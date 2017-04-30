/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interjob.servlet;

import interJob.ejb.FriendshipFacade;
import interJob.ejb.UserFacade;
import interJob.entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author User
 */
@WebServlet(name = "DeleteFriendServlet", urlPatterns = {"/DeleteFriendServlet"})
public class DeleteFriendServlet extends HttpServlet {
    
    @EJB
    private FriendshipFacade friendshipFacade;
    
    @EJB
    private UserFacade userFacade;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");

        RequestDispatcher rd;

        if (user == null) { // If not logged in, go to login
            String error = "Login first!";
            request.setAttribute("error", error);
            rd = this.getServletContext().getRequestDispatcher("/LoginServlet");
            rd.forward(request, response);
        } else {
            rd = this.getServletContext().getRequestDispatcher("/FriendsServlet.jsp");
            rd.forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);

        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        RequestDispatcher rd;

        if (user == null) { // If not logged in, go to login
            String error = "Login first!";
            request.setAttribute("error", error);
            rd = this.getServletContext().getRequestDispatcher("/LoginServlet");
            rd.forward(request, response);
        } else {
            int friendsID = 0;
            try {
                friendsID = Integer.parseInt(request.getParameter("friend"));
            } catch(NumberFormatException e) {
                String error = "The User-ID: \"" + request.getParameter("friend") + "\" isn't a correct input!";
                request.setAttribute("error", error);
                
                rd = this.getServletContext().getRequestDispatcher("/home.jsp");
                rd.forward(request, response);
            }
            
            // check if the UserID is a correct input
            if(friendsID < 1) {
                String error = "The User-ID: \"" + friendsID + "\" isn't a correct input!";
                request.setAttribute("error", error);
                
                rd = this.getServletContext().getRequestDispatcher("/home.jsp");
                rd.forward(request, response);
            }
            
            // check if it the same id as your own UserID
            if(friendsID == user.getId()) {
                String info = "You can't break off the friendship with yourself. :D";
                request.setAttribute("info", info);
                
                rd = this.getServletContext().getRequestDispatcher("/home.jsp");
                rd.forward(request, response);
            }
            
            // check if an user with this id exist
            User friend = userFacade.findUserById(friendsID);
            if(friend == null) {
                String error = "An user with the User-ID: \"" + friendsID + "\" doesn't exist!";
                request.setAttribute("error", error);
                
                rd = this.getServletContext().getRequestDispatcher("/home.jsp");
                rd.forward(request, response);
            }
            
            // check if you are a friend of the user with the UserID "friendsID"
            List<User> friends = userFacade.getFriends(user.getId());
            if(!friends.contains(friend)) {
                String error = "You are not a (confirmed) friend of the user \"" + friend.getUsername() + "\"!";
                request.setAttribute("error", error);
                
                rd = this.getServletContext().getRequestDispatcher("/home.jsp");
                rd.forward(request, response);
            } else {
                int count = friendshipFacade.deleteFriend(user, friend);
            
                if(count == 1) {
                    String info = "You have successfully break off the friendship with the user \"" + friend.getUsername() + "\"!";
                    request.setAttribute("info", info);
                } else {
                    String error = "An error occured while breaking off the friendship with the user \"" + friend.getUsername() + "\"! Please try again later.";
                    request.setAttribute("error", error);
                }
                
                rd = this.getServletContext().getRequestDispatcher("/FriendsServlet");
                rd.forward(request, response);
            }
        }
        
        rd = this.getServletContext().getRequestDispatcher("/home.jsp");
        rd.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
