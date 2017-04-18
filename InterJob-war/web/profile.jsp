<%-- 
    Document   : profile
    Created on : 17-abr-2017, 19:55:31
    Author     : Francisco Ruiz <pacorf>
--%>

<%@page import="interJob.entity.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        User user = (User)request.getSession().getAttribute("user"); // Logged in User
        User profileUser = (User)request.getSession().getAttribute("profileuser"); // WARNING: user can be the logged in one or a requested one by id
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
    <% if (profileUser == null) { %>
        <title>Profile not found!</title>
    <% } else { %>
        <title><%=profileUser.getUsername()%>'s Profile</title>
    <% } %>
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
                    <li><a href="<%=application.getContextPath()%>/HomeServlet">Home</a></li>
                    <li class="active"><a href="<%=application.getContextPath()%>/ProfileServlet">My Profile</a></li>
                    <li><a href="#">EXAMPLE</a></li>
                  </ul>
                </div>
          </div>
        </nav><!-- NAVBAR END -->
        
        <div class="container">
        <% if (profileUser == null) { %>
            <h2>Profile not found!</h2>
        <% } else { %>
            <h2><%=profileUser.getUsername()%>'s profile</h2>
            
            <table><tr>
            <td>
                <% if (profileUser.getFoto() != null) { %>
                    <img src="<%=profileUser.getFoto()%>">
                <% } %>
            </td>
            <td>
                <table class="table">
                    <tr>
                        <td><b>Username:</b></td>
                        <td><%=profileUser.getUsername()%></td>
                    </tr>
                    <tr>
                        <td><b>Name:</b></td>
                        <td><%=profileUser.getName()%></td>
                    </tr>
                    <tr>
                        <td><b>Last Name:</b></td>
                        <td><%=profileUser.getLastName()%></td>
                    </tr>
                    <tr>
                        <td><b>Twitter:</b></td>
                        <td><a href="http://twitter.com/<%=profileUser.getTwitter()%>"><%=profileUser.getTwitter()%></a></td>
                    </tr>
                    <tr>
                        <td><b>Instagram:</b></td>
                        <td><a href="https://instagram.com/<%=profileUser.getInstagram()%>"><%=profileUser.getInstagram()%></a></td>
                    </tr>
                    <tr>
                        <td><b>Webpage:</b></td>
                        <td><a href="https://<%=profileUser.getWebpage()%>"><%=profileUser.getWebpage()%></a></td>
                    </tr>
                </table>
                <%
                    // Check if profileuser is logged in user
                    if (profileUser.equals(user)) {
                %>
                <a href="#" class="btn btn-default" role="button">Edit Profile</a>

                <%
                    }
                %>
            </td>
            </tr></table>
        <% } %>
    </div>
    </body>
</html>
