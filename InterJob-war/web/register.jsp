<%-- 
    Document   : register
    Created on : 20-abr-2017, 23:59:32
    Author     : Francisco Ruiz <pacorf>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        String error = (String)request.getAttribute("error");
    %>
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
                background-color: #eee;
            }
            .alert-system {
                position: absolute;
                margin-left: auto;
                margin-right: auto;
                left: 0;
                right: 0;
            }
            .form-register {
                max-width: 350px;
                padding: 15px;
                margin: 0 auto;
            }
            .form-register h2 {
                padding-top: 50px;
                text-align: center;
            }
        </style>
        <!-- BOOTSTRAP END -->
        <title>Register</title>
    </head>
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
            <% } %>
                
            <!-- ALERT SYSTEM END -->
            
        <div class="container">
            <form class="form-register" action="RegisterServlet" method="post">
                <h2 class="form-register">Join InterJob</h2>
                <label for="username">Username *</label>
                <input type="text" name="username" class="form-control" placeholder="Username" required autofocus>
                <label for="name">Name *</label>
                <input type="text" name="name" class="form-control" placeholder="Name" required>
                <label for="last-name">Last Name *</label>
                <input type="text" name="last-name" class="form-control" placeholder="Last Name" required>
                <label for="password">Password *</label>
                <input type="password" name="password" class="form-control" placeholder="Password" required>
                <br>
                <button class="btn btn-lg btn-primary btn-block" type="submit">Register</button>
            </form>
        </div>
    </body>
</html>
