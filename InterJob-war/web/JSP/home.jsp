<%-- 
    Document   : home
    Created on : 18-abr-2017, 18:00:17
    Author     : Francisco Ruiz <pacorf>
--%>

<%@page import="interJob.entity.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        User user = (User)request.getSession().getAttribute("user"); // Logged in User
        // Variables for showing errors in the alerts section of the webpage
        String error = (String)request.getAttribute("error");
        String info = (String)request.getAttribute("info");
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
            }
            .alert-system {
                position: absolute;
                margin-left: auto;
                margin-right: auto;
                left: 0;
                right: 0;
            }
        </style>
        <!-- BOOTSTRAP END -->
        <title>Main Page</title>
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
                        <li><a href="<%=application.getContextPath()%>/ProfileServlet">My Profile</a></li>
                        <li><a href="<%=application.getContextPath()%>/FriendsServlet">Friends</a></li>
                        <li><a href="#">EXAMPLE</a></li>
                    </ul>
                        <ul class="nav navbar-nav navbar-right">
                            <li><a href="<%=application.getContextPath()%>/LogoutServlet">Logout</a></li>
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
                <div class="alert alert-info alert-dismissable fade in container alert-system">
                    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                    <strong>Info:</strong> <%=info%>
                </div>
            
            <% }%>
            <!-- ALERT SYSTEM END -->

            <div class="container">
            <h1>Welcome <%=user.getName()%>!</h1>
        </div>
    </body>
</html>