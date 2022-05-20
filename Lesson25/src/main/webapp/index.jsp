<%@ page import="utils.DbUtils" %>
<%@ page import="model.User" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    User auth = (User) request.getSession().getAttribute("username");
    if (auth != null) {
        request.setAttribute("username", auth);
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Index Page</title>
</head>
<body>
<jsp:forward page="/login"/>
<%out.print(DbUtils.getConnection()); %>
<%@include file="resources/footer.jsp" %>
</body>
</html>