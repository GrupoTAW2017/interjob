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
        <style type="text/css">
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
           String error = (String)request.getAttribute("error");
           String info = (String)request.getAttribute("info");
         %>  

    <body>
        <% if (error != null) { %>
        <div class="error">
            <b>Error:</b> <%= error %>!  
        </div>
        <% } else if (info != null) { %>
        <div class="success">
            <%= info %>!
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