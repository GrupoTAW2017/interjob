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
                margin-top: 25px;
            }
            td > a {
                text-decoration: none;
            }
        </style>
        <!-- BOOTSTRAP END -->
        <% if(ownPage) { %>
        <title>My friends</title>
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
            <% } %>
            <!-- ALERT SYSTEM END -->
    
        <div class="container">
            <% if (friends != null) { %>
            <% if(ownPage) { %>
            <h2>My friends</h2>
            <% } else { %>
            <h2>Friends of <%= username %></h2>
            <% } %>
            <table class="table table-striped table-responsive">
                <thead>
                    <tr>
                        <th>Username</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Twitter</th>
                        <th>Instagram</th>
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
                        <td><%= friend.getLastName() %></td>
                        <td><%= friend.getTwitter() %></td>
                        <td><%= friend.getInstagram() %></td>
                        <td><%= friend.getWebpage() %></td>
                        <td>
                            <a href="<%= application.getContextPath() %>/ProfileServlet?id=<%= friend.getId() %>" title="Show profile">
                                <span class="glyphicon glyphicon-info-sign"></span> 
                            </a>
                        </td>
                        <td>
                            <a href="#" title="Send message">
                                <span class="glyphicon glyphicon-envelope"></span> 
                            </a>
                        </td>
                        <% if(ownPage) { %>
                        <td>
                            <a href="#" title="Delete Friendship">
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
            <h2>The user <%= username %>  has no friends. :( %></h2>
            <% } %>
         </div>
    </body>
</html>

