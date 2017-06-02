<%-- 
    Document   : profile
    Created on : 17-abr-2017, 19:55:31
    Author     : Francisco Ruiz <pacorf> and Andreas Blume <bluman91>
--%>

<%@ page import="interJob.entity.Hobby" %>
<%@ page import="interJob.entity.Studies" %>
<%@ page import="interJob.entity.User" %>
<%@ page import="interJob.entity.WorkExperience" %>
<%@ page import="java.util.List;" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <%
        User user = (User)request.getSession().getAttribute("user"); // Logged in User
        User profileUser = (User)request.getAttribute("profileuser"); // WARNING: user can be the logged in one or a requested one by id
        List<Hobby> hobbies = (List<Hobby>) request.getAttribute("hobbies");
        List<Studies> studies = (List<Studies>) request.getAttribute("studies");
        List<WorkExperience> workExperiences = (List<WorkExperience>) request.getAttribute("workExperiences");
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/yyyy");
        
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
                margin-top: 10px;
            }
            
            ul.infoList {
                padding-left: 10px;
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
                        <%
                            // Check if profileuser is logged in user
                            if (profileUser.equals(user)) {
                        %>
                        <li class="active"><a href="<%=application.getContextPath()%>/ProfileServlet">My Profile</a></li>
                        <%
                            } else {
                        %>
                        <li><a href="<%=application.getContextPath()%>/ProfileServlet">My Profile</a></li>
                        <%
                            }
                        %>
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

        <div class="container" style="margin-bottom: 30px;">
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
                                <td><b>Name:</b></td>
                                <td><%=profileUser.getName()%></td>
                            </tr>
                            <tr>
                                <td><b>Last Name:</b></td>
                                <td><%=profileUser.getLastName()%></td>
                            </tr>
                            <tr>
                                <td><b>Studies:</b></td>
                                <td>
                                <% if(studies.size() == 0) { %>
                                    <i>no studies</i>
                                <% } else { %>
                                    <ul class="infoList">
                                    <% for(Studies s : studies) { %>
                                        <% if(s.getEndDate() == null) { %>
                                        <li><%= dateFormat.format(s.getStartDate()) %> - today: <%= s.getDescription() %> (<%= s.getLocation() %>)</li>
                                        <% } else { %>
                                        <li><%= dateFormat.format(s.getStartDate()) %> - <%= dateFormat.format(s.getEndDate()) %>: <%= s.getDescription() %> (<%= s.getLocation() %>)</li>
                                        <% } %>
                                    <% } %>
                                    </ul>
                                <% } %>
                                </td>
                            </tr>
                            <tr>
                                <td><b>Work Experiences:</b></td>
                                <td>
                                <% if(workExperiences.size() == 0) { %>
                                    <i>no work experiences</i>
                                <% } else { %>
                                    <ul class="infoList">
                                    <% for(WorkExperience w : workExperiences) { %>
                                        <% if(w.getEndDate() == null) { %>
                                        <li><%= dateFormat.format(w.getStartDate()) %> - today: <%= w.getJob() %> (<a href="http://<%= w.getWebpage() %>"><%= w.getBusiness() %></a>)</li>
                                        <% } else { %>
                                        <li><%= dateFormat.format(w.getStartDate()) %> - <%= dateFormat.format(w.getEndDate()) %>: <%= w.getJob() %> (<a href="http://<%= w.getWebpage() %>"><%= w.getBusiness() %></a>)</li>
                                        <% } %>
                                    <% } %>
                                    </ul>
                                <% } %>
                                </td>
                            </tr>
                            <tr>
                                <td><b>Hobbies:</b></td>
                                <td>
                                <% if(hobbies.size() == 0) { %>
                                    <i>no hobbies</i>
                                <% } else { %>
                                    <ul class="infoList">
                                    <% for(Hobby h : hobbies) { %>
                                        <li><%= h.getName() %></li>
                                    <% } %>
                                    </ul>
                                <% } %>
                                </td>
                            </tr>
                            <% if(!profileUser.getWebpage().equals("")) { %>
                            <tr>
                                <td><b>Webpage:</b></td>
                                <td><a href="https://<%=profileUser.getWebpage()%>"><%=profileUser.getWebpage()%></a></td>
                            </tr>
                            <% } %>
                            <% if(!profileUser.getTwitter().equals("") || !profileUser.getInstagram().equals("")) { %>
                            <tr>
                                <td><b>Social Media:</b></td>
                                <td>
                                    <% if(!profileUser.getTwitter().equals("")) { %>
                                    <a href="https://twitter.com/<%= profileUser.getTwitter() %>" class="fa fa-twitter socialIcon" title="Twitter"></a>
                                    <% } %>
                                    <% if(!profileUser.getInstagram().equals("")) { %>
                                    <a href="https://instagram.com/<%= profileUser.getInstagram()%>" class="fa fa-instagram socialIcon" title="Instagram"></a>
                                    <% } %>
                                </td>
                            </tr>
                            <% } %>
                        </table>
                        <%
                            // Check if profileuser is logged in user
                            if (profileUser.equals(user)) {
                        %>
                        <a href="<%=application.getContextPath()%>/ProfileEditorServlet" class="btn btn-default" role="button">Edit Profile</a>
                        <a href="<%=application.getContextPath()%>/PasswordEditorServlet" class="btn btn-default" role="button">Change Password</a>
                        <%
                            } else {
                        %>
                        <a href="<%=application.getContextPath()%>/FriendsServlet?id=<%= profileUser.getId() %>" class="btn btn-default" role="button">Show his/her Friends</a>
                        <%
                            }
                        %>
                    </td>
                </tr></table>
                <% } %>
        </div>
    </body>
</html>