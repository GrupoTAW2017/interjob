<%-- 
    Document   : friends.jsp
    Created on : 18.04.2017, 14:44:22
    Author     : bluman91
--%>

<%@ page import="java.util.List;" %>
<%@ page import="interJob.entity.User" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <%         
        User user = (User)session.getAttribute("user");
        
        Boolean ownPage = (Boolean)request.getAttribute("ownPage");
        String username = (String)request.getAttribute("username");         // username of the user
        List<User> friends = (List<User>)request.getAttribute("friends");   // a list with the friends of the user
        
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
        <!-- Social Icons -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
                margin-top: 25px;
            }
            th, td {
                text-align: center;
            }
            td > a {
                text-decoration: none;
            }
            div#noFriends {
                margin-top: 20px;
            }
            a.socialIcon {
                font-size: 24px;
                text-decoration: none;
            }
            a.fa-twitter {
                color: #00aced;
            }
            a.fa-instagram {
                color: #bc2a8d;
            }
        </style>
        <!-- BOOTSTRAP END -->
        <% if(ownPage) { %>
        <title>My Friends</title>
        <% } else { %>
        <title>Friends of <%= username %></title>
        <% } %>
    </head
    
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
                        <% if(ownPage) { %>
                        <li class="active"><a href="<%=application.getContextPath()%>/FriendsServlet">Friends</a></li>
                        <% } else { %>
                        <li><a href="<%=application.getContextPath()%>/FriendsServlet">Friends</a></li>
                        <% } %>
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
        <div class="alert alert-success alert-dismissable fade in container alert-system">
            <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
            <%=info%>
        </div>
        <% }%>
        <!-- ALERT SYSTEM END -->
    
        <div class="container">
            <% if(ownPage) { %>
            <h2>My Friends</h2>
            <% } else { %>
            <h2>Friends of <%= username %></h2>
            <% } %>
            <a href="FindFriendServlet" class="btn btn-default">Search Friend</a><br>
            <% if (friends != null) { %>
            <table class="table table-striped table-responsive">
                <thead>
                    <tr>
                        <th>Username</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Social Media</th>
                        <th>Webpage</th>
                        <th></th>
                        <th></th>
                        <% if(ownPage) { %>
                        <th></th>
                        <% } %>
                    </tr>
                </thead>
                <tbody>
                <% for(User friend : friends) { %>
                    <tr>
                        <td><%= friend.getUsername() %></td>
                        <td><%= friend.getName() %></td>
                        <td><%= friend.getLastName()%></td>
                        <td>
                            <% if(!friend.getTwitter().equals("")) { %>
                            <a href="https://twitter.com/<%= friend.getTwitter() %>" class="fa fa-twitter socialIcon" title="Twitter"></a>
                            <% } %>
                            <% if(!friend.getInstagram().equals("")) { %>
                            <a href="https://instagram.com/<%= friend.getInstagram()%>" class="fa fa-instagram socialIcon" title="Instagram"></a>
                            <% } %>
                        </td>
                        <td>
                            <% if(!friend.getWebpage().equals("")) { %>
                            <a href="https://<%=friend.getWebpage()%>"><%=friend.getWebpage()%></a>
                            <% } %>
                        </td>
                        <td>
                            <a href="<%= application.getContextPath() %>/ProfileServlet?id=<%= friend.getId() %>" title="Show profile">
                                <span class="glyphicon glyphicon-info-sign"></span> 
                            </a>
                        </td>
                        <td>
                            <a href="#" title="Send message" style="font-size:16px;">
                                <span class="glyphicon glyphicon-envelope"></span> 
                            </a>
                        </td>
                        <% if(ownPage) { %>
                        <td>
                            <a href="<%= application.getContextPath() %>/DeleteFriendServlet?friend=<%= friend.getId() %>" title="Break off the friendship">
                                <span class="glyphicon glyphicon-trash"></span> 
                            </a>
                        </td>
                        <% } %>
                        </td>
                    </tr>
                <% } %>
                </tbody>
            </table>
            <% } else { %>
                <% if(ownPage) { %>
                <div id="noFriends">
                Your friend list is empty. :(
                </div>
                <% } else { %>
                <div id="noFriends">
                The friend list of the user <%= username %>  is empty. :(
                </div>
                <% } %>
            <% } %>
         </div>
    </body>
</html>

