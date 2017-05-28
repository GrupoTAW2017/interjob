<%-- 
    Document   : profileEditor
    Created on : 18-abr-2017, 19:56:14
    Author     : Francisco Ruiz <pacorf>
--%>

<%@page import="interJob.entity.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        User user = (User) request.getSession().getAttribute("user"); // Logged in User
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
        </style>
        <!-- BOOTSTRAP END -->
        <title>Edit Profile</title>
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
                        <li><a href="<%=application.getContextPath()%>/home.jsp">Home</a></li>
                        <li class="active"><a href="<%=application.getContextPath()%>/ProfileServlet">My Profile</a></li>
                        <li><a href="<%=application.getContextPath()%>/FriendsServlet">Friends</a></li>
                        <li><a href="#">EXAMPLE</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="<%=application.getContextPath()%>/LogoutServlet">Logout</a></li>
                    </ul>
                </div>
            </div>
        </nav><!-- NAVBAR END -->

        <div class="container">
            <h1>Edit Profile</h1>
            <form action="ProfileEditorServlet" method="post">
                <div class="form-group">
                    <label for="username">Username</label>
                    <input type="text" class="form-control" name="username" placeholder="Please insert a username" value="<%=user.getUsername()%>">
                </div>
                <div class="form-group">
                    <label for="name">Name</label>
                    <input type="text" class="form-control" name="name" placeholder="Please insert a name" value="<%=user.getName()%>">
                </div>
                <div class="form-group">
                    <label for="last_name">Last Name</label>
                    <input type="text" class="form-control" name="last_name" placeholder="Please insert your last name" value="<%=user.getLastName()%>">
                </div>
                <div class="form-group">
                    <label for="twitter">Twitter</label>
                    <input type="text" class="form-control" name="twitter" placeholder="Please insert a Twitter account" value="<%=user.getTwitter()%>">
                </div>
                <div class="form-group">
                    <label for="instagram">Instagram</label>
                    <input type="text" class="form-control" name="instagram" placeholder="Please insert an Instagram account" value="<%=user.getInstagram()%>">
                </div>
                <div class="form-group">
                    <label for="webpage">Webpage</label>
                    <input type="text" class="form-control" name="webpage" placeholder="Please URL" value="<%=user.getWebpage()%>">
                </div>
                <div class="form-group">
                    <label for="foto">Photo URL</label>
                    <input type="text" class="form-control" name="foto" placeholder="Please insert photo URL" value="<%=user.getFoto()%>">
                </div>
                <button type="submit" class="btn btn-default">Save</button>
            </form>
        </div>

    </body>
</html>
