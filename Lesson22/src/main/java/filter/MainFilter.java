package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/*"},
        initParams = {@WebInitParam(name = "encoding", value = "UTF-8", description = "Encoding param")})
public class MainFilter implements Filter {
    private String code;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        code = filterConfig.getInitParameter("encoding");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String codeRequest = servletRequest.getCharacterEncoding();
        if (code != null && !code.equalsIgnoreCase(codeRequest)) {
            servletRequest.setCharacterEncoding(code);
            servletResponse.setContentType("text/html");
            servletResponse.setCharacterEncoding(code);
        }

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(false);
        String loginURI = request.getContextPath() + "/";

        boolean loginRequest = request.getRequestURI().equals(loginURI);
        if (session != null || loginRequest) {
            filterChain.doFilter(request, response);
        } else {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/login.html");
//            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/accessDenied.html");
            requestDispatcher.forward(request, response);
        }
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        code = null;
    }
}