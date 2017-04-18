<%-- 
    Document   : friends.jsp
    Created on : 18.04.2017, 14:44:22
    Author     : bluman91
--%>

<%@ page import="java.util.List;" %>
<%@ page import="interJob.entity.User" %>
<%@ page session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>interJob - Friends</title>
        <style type="text/css">
            table {
                border-collapse: collapse;
                margin-bottom: 20px;
            }
            
            th, td {
                padding: 5px;
                text-align: left;
                border: 1px solid #000;
            }
            
            div.info, div.success, div.warning, div.error {
                margin: 10px 0px;
                padding:12px;
            }
            div.info {
                color: #00529B;
                background-color: #BDE5F8;
            }
            div.success {
                color: #4F8A10;
                background-color: #DFF2BF;
            }
            div.warning {
                color: #9F6000;
                background-color: #FEEFB3;
            }
            div.error {
                color: #D8000C;
                background-color: #FFBABA;
            }
        </style>
    </head>
    <% 
        User user = (User)request.getSession().getAttribute("user");
        
        List<User> friends = (List<User>)request.getAttribute("friends");
        String warning = (String)request.getAttribute("warning");
    %>
    <body>
        <% if (friends == null) { %>
        <div class="warning">
            <%= warning %>
        </div>
        <% } else { %>
            <h2>Friends of <%=user.getUsername()%>:</h2>
            <table>
                <tr>
                    <th>Username</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Twitter</th>
                    <th>Instagram</th>
                    <th>Webpage</th>
                </tr>
                <% for(User friend : friends) { %>
                <tr>
                    <td><%= friend.getUsername() %></td>
                    <td><%= friend.getName() %></td>
                    <td><%= friend.getLastName() %></td>
                    <td><%= friend.getTwitter() %></td>
                    <td><%= friend.getInstagram() %></td>
                    <td><%= friend.getWebpage() %></td>
                </tr>
                <% } %>
            </table>
        <% } %>
        <a href="LoginServlet">Back</a>
    </body>
</html>

