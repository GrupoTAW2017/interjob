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
        <!-- BOOTSTRAP REQUIRED STYLESHEETS AND JS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
        <style>
            body {
                padding-top: 50px;
            }
            .alert-system {
                position: absolute;
                margin-left: auto;
                margin-right: auto;
                left: 0;
                right: 0;
            }
            .form-login {
                max-width: 350px;
                padding: 15px;
                margin: 0 auto;
            }
            .form-login h2 {
                padding-top: 50px;
                text-align: center;
            }
            a.btn {
                width: 100px;
            }
        </style>
        <!-- BOOTSTRAP END -->
        <title>Login</title>
    </head>  
    <%
        String error = (String)request.getAttribute("error");
        String info = (String)request.getAttribute("info");
    %>  

    <body>
        <nav class="navbar navbar-inverse navbar-fixed-top"> <!-- THIS NAV IS THE TOP NAVBAR -->
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="<%=application.getContextPath()%>">InterJob</a> <!-- NAVBAR TITLE AND LINK TO MAIN -->
                </div>
                <div id="navbar" class="collapse navbar-collapse">
                    <ul class="nav navbar-nav"> <!-- ELEMENTS IN NAVIGATION BAR -->
                        <li class="active"><a href="<%=application.getContextPath()%>/HomeServlet">Home</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="<%=application.getContextPath()%>/LoginServlet">Login</a></li>
                    </ul>
                </div>
            </div>
        </nav><!-- NAVBAR END -->

        <!-- ALERT SYSTEM -->
        <%
            if (error != null) {
        %>
        <div class="alert alert-danger alert-dismissable fade in container alert-system">
            <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
            <strong>Error:</strong> <%=error%>
        </div>
        <% } else if (info != null) {%>
        <div class="alert alert-success alert-dismissable fade in container alert-system">
            <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
            <%=info%>
        </div>

        <% }%>
        <!-- ALERT SYSTEM END -->


        <div class="container">
            <form class="form-login" name="login" action="LoginServlet" method="post">
                <h2 class="form-login">Login</h2>
                <label for="username">Username</label>
                <input type="text" name="username" class="form-control" autofocus>
                <label for="password">Password</label>
                <input type="password" name="password" class="form-control">
                <br>
                <button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
            </form>
            <a href="RegisterServlet"  class="btn btn-default alert-system">Register</a>
        </div>
    </body>
</html>