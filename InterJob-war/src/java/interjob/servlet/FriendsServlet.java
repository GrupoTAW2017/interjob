/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interjob.servlet;

import interJob.ejb.UserFacade;
import javax.ejb.EJB;
import interJob.entity.User;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author fuynfactory
 */
@WebServlet(name = "FriendsServlet", urlPatterns = {"/FriendsServlet"})
public class FriendsServlet extends HttpServlet {

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
        
        RequestDispatcher rd;
        
        User user;
        Integer UserID = 1;
        if(!request.getParameterMap().containsKey("id")) {
            HttpSession session = request.getSession();
            user = (User) session.getAttribute("user");
            
            if (user == null) { // If not logged in, go to login
                String error = "Login first!";
                request.setAttribute("error", error);
                rd = this.getServletContext().getRequestDispatcher("/LoginServlet");
                rd.forward(request, response);
            }
            else {
                UserID = user.getId();
                request.setAttribute("ownPage", true);
                request.setAttribute("username", user.getUsername());
            }
        }
        else {
            try {
                UserID = Integer.parseInt(request.getParameter("id"));
            } catch(NumberFormatException e) {
                String error = "The User-ID: \"" + request.getParameter("id") + "\" isn't a correct input!";
                request.setAttribute("error", error);
                
                rd = this.getServletContext().getRequestDispatcher("/home.jsp");
                rd.forward(request, response);
            }
        
            // check if the UserID is a correct input
            if(UserID < 1) {
                String error = "The User-ID: \"" + UserID + "\" isn't a correct input!";
                request.setAttribute("error", error);
                
                rd = this.getServletContext().getRequestDispatcher("/home.jsp");
                rd.forward(request, response);
            }
            
            // fetch username from the database
            user = userFacade.findUserById(UserID);
            if(user != null) {
                request.setAttribute("ownPage", false);
                request.setAttribute("username", user.getUsername());
            }
            else {
                String error = "A user with the id: \"" + UserID + "\" doesn't exist!";
                request.setAttribute("error", error);
            }
        }

        // fetch friends from the database
        List<User> friends = userFacade.getFriends(UserID);
        request.setAttribute("friends", friends);
        
        rd = this.getServletContext().getRequestDispatcher("/friends.jsp");
        rd.forward(request, response);
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
        processRequest(request, response);
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
