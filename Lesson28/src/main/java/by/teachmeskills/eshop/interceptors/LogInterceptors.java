package by.teachmeskills.eshop.interceptors;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogInterceptors implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        long startTime = System.currentTimeMillis();
        System.out.println("\n------ LogInterception.preHandle ---");
        System.out.println("Request URL: " + request.getRequestURL());
        System.out.println("Start time : " + System.currentTimeMillis());
        request.setAttribute("startTime", startTime);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("\n----- LogInterception.postHandle ----");
        System.out.println("Request URL : " + request.getRequestURL());
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("\n----- LogInterception.afterCompletion ----");
        long startTime = (long) request.getAttribute("start");
        long endTime = System.currentTimeMillis();
        System.out.println("Request URl : " + request.getRequestURL());
        System.out.println("End time : " + endTime);
        System.out.println("Time taken : " + (endTime - startTime));
    }
}