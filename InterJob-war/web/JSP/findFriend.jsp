<%-- 
    Document   : findFriend
    Created on : Apr 24, 2017, 9:00:15 AM
    Author     : Francisco Ruiz <pacorf>
--%>

<%@page import="interJob.entity.User"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        // Variables for showing errors in the alerts section of the webpage
        String error = (String)request.getAttribute("error");
        String info = (String)request.getAttribute("info");
        List<User> userList = (List<User>)request.getAttribute("userlist");
        List<User> friendList = (List<User>)request.getAttribute("friendlist");
        String username = (String)request.getParameter("username");
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
            
            table {
                margin-top: 15px;
            }
        </style>
        <!-- BOOTSTRAP END -->
        <title>Find Friend</title>
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
                        <li><a href="<%=application.getContextPath()%>/ProfileServlet">My Profile</a></li>
                        <li class="active"><a href="<%=application.getContextPath()%>/FriendsServlet">Friends</a></li>
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
            <h1>User search</h1>
            <form class="form-find-friend" name="find-friend" action="FindFriendServlet">
                <label for="username">Input friend username</label>
                <table>
                    <td><input type="text" name="username" class="form-control" autofocus></td>
                    <td><button class="btn btn-default" type="submit">Search</button></td>
                </table>
            </form>
            <br>
        </div>
        <div class="container">
            <% if (userList != null && !userList.isEmpty() && username.length() > 0) { %>
            Results for '<%=username%>':
            <table class="table">
                <tr>
                    <th>Username</th>
                    <th>Name</th>
                    <th>Last Name</th>
                    <th></th>
                </tr>
                <% for(User u: userList) { %>
                <tr>
                    <td><a href="ProfileServlet?id=<%=u.getId()%>"><%=u.getUsername()%></a></td>
                    <td><%=u.getName()%></td>
                    <td><%=u.getLastName()%></td>
                    <td><% if (!friendList.contains(u)) { %>
                        <a href="#" title="Send Friend Request">
                            <span class="glyphicon glyphicon-plus"></span>
                        </a>
                        <% } %>
                    </td>
                            
                </tr>
                <% } %>
            </table>
            <% } else if (username != null) { %>
            No results for '<%=username%>'
            <% } %>
        </div>
    </body>
</html>
