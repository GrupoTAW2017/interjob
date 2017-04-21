/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interjob.servlet;

import interJob.ejb.UserFacade;
import interJob.entity.User;
import java.io.IOException;
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
 * @author fuynfactory
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

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
        if (user == null) {
            rd = this.getServletContext().getRequestDispatcher("/login.jsp");
            rd.forward(request, response);
        }
        else {
            rd = this.getServletContext().getRequestDispatcher("/HomeServlet");
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
        
        // get post-parameter
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        // check if username or/and password is empty
        if(username.equals("") || password.equals("")) {
            String error = "You have to fill out <b>username</b> and <b>password</b>";
            request.setAttribute("error", error);
            
            RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/login.jsp");
            rd.forward(request, response);
        }
        
        // check if username and password is correct
        User user = userFacade.loginUser(username, password);
        if(user == null) {
            String error = "<b>username</b> or <b>password</b> is wrong";
            request.setAttribute("error", error);
        
            RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/login.jsp");
            rd.forward(request, response);
        }

        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        
        // Let user know that login was successful
        String info = "Logged in successfully!";
        request.setAttribute("info", info);
        
        RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/HomeServlet");
        rd.forward(request, response);
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
