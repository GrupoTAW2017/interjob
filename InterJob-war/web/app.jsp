<%-- 
    Document   : app
    Created on : 15.04.2017, 21:14:05
    Author     : bluman91
--%>

<%@ page import="interJob.entity.User"%>
<%@ page session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>interJob - Home</title>
        <style type="text/css">
            table {
                border-collapse: collapse;
                margin-bottom: 20px;
            }
            
            th, td {
                padding: 5px;
                text-align: left;
            }
        </style>
    </head>
    <% 
        User user = (User)request.getSession().getAttribute("user");
    %>
    <body>
        <% if (user != null) { %>
            <h2>Hello <%=user.getUsername()%>!</h2>
            <table>
                <tr>
                    <td><b>Name:</b></td>
                    <td><%=user.getName()%></td>
                </tr>
                <tr>
                    <td><b>Last Name:</b></td>
                    <td><%=user.getLastName()%></td>
                </tr>
                <tr>
                    <td><b>Twitter:</b></td>
                    <td><%=user.getTwitter()%></td>
                </tr>
                <tr>
                    <td><b>Instagram:</b></td>
                    <td><%=user.getInstagram()%></td>
                </tr>
                <tr>
                    <td><b>Webpage:</b></td>
                    <td><%=user.getWebpage()%></td>
                </tr>
                <tr>
                    <td><b>Foto:</b></td>
                    <td><%=user.getFoto()%></td>
                </tr>
            </table>
        <% } %>
        <a href="FriendsServlet?id=<%= user.getId() %>">Show Friends</a>
        <br>
        <a href="LogoutServlet">Logout</a>
    </body>
</html>
