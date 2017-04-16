<%-- 
    Document   : app
    Created on : 15.04.2017, 21:14:05
    Author     : bluman91
--%>

<%@ page import="interjob.user.User"%>
<%@ page session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>interJob - Home</title>
    </head>
    <% 
        User user = (User)request.getSession().getAttribute("user");
        String username = user.getUsername();
    %>
    <body>
        <% if (user.isLoggedIn()) { %>
            <h1>Login successfull! Hello <%=username%>!</h1>
        <% } %>
    </body>
    <a href="LogoutServlet">Logout</a>
</html>
