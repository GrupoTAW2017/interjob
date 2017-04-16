<%-- 
    Document   : login
    Created on : 02-abr-2017, 18:39:44
    Author     : fuynfactory
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>interJob</title>
    </head>  
         <% 
           String error = (String)request.getAttribute("error");
           String message = (String)request.getAttribute("message");
         %>  

    <body>
        <% if (error != null) { %>
        <div style="color: #ff0000; margin-bottom: 5px;">
            <b>Error:</b> <%=error%>!  
        </div>
        <% } else if (message != null) { %>
        <div style="color: #008000 ; margin-bottom: 5px;">
            <%=message%>!
        </div>
        <% } %>
        <form name="login" action="LoginServlet" method="post">
            <table border="1">                 
                <tr>                
                    <td><b>Username</b></td>
                    <td><input type="text" name="username" value=""/></td>
                </tr>
                <tr>
                    <td><b>Password</b></td>
                    <td><input type="password" name="password" value=""/></td>
                    
                </tr> 
                <tr>
                    <td colspan="2"><input type="submit" name="btnSave" value="Login"/></td>                    
                </tr>
            </table>
        </form>
        <a href="#">Register</a>
    </body>
</html>