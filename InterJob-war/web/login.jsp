<%-- 
    Document   : login
    Created on : 02-abr-2017, 18:39:44
    Author     : fuynfactory
--%>

<%@page import="interjob.webForm.LoginForm"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>interJob</title>
    </head>  
         <% 
           LoginForm login =(LoginForm)request.getAttribute("login");
        %>  

    <body>
        <form name="crear" action="LoginServlet" method="post">
            <table border="1">                 
                <tr>                
                    <% if (login.isWritelogin()){%>
                        <td><b>you must write your name loggin</b></td>
                    <%}%>
                    <td><b>Login</b></td>
                    <td><input type="text" name="Login" value="<%=login.getLogin()%>"/></td>
                </tr>
                <tr>
                    <% if (login.isWritepassword()){%>
                        <td><b>you must write your password</b></td>
                    <%}%>
                    <td><b>Password</b></td>
                    <td><input type="password" name="Pasword" value=""/></td>
                    
                </tr> 
                <tr>
                    <td colspan="2"><input type="submit" name="btnSave" value="Go"/></td>                    
                    
                </tr>
                <% if (login.isAccessDenied()){%>
                <tr>
                        <td><b>Access Denied</b></td>
                </tr>
                <%}%>         
                
                <tr>
                <a href="..."> New User</a>
                </tr>
            </table>
        </form>
    </body>
</html>