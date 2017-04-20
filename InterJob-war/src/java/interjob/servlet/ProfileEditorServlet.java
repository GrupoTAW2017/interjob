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
 * @author Francisco Ruiz <pacorf>
 */
@WebServlet(name = "ProfileEditorServlet", urlPatterns = {"/ProfileEditorServlet"})
public class ProfileEditorServlet extends HttpServlet {

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
            rd = this.getServletContext().getRequestDispatcher("/profileEditor.jsp");
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
            // Get all form parameters
            String username = request.getParameter("username");
            String name = request.getParameter("name");
            String lastName = request.getParameter("last_name");
            String twitter = request.getParameter("twitter");
            String instagram = request.getParameter("instagram");
            String webpage = request.getParameter("webpage");
            String foto = request.getParameter("foto");

            user.setUsername(username);
            user.setName(name);
            user.setLastName(lastName);
            user.setTwitter(twitter);
            user.setInstagram(instagram);
            user.setWebpage(webpage);
            user.setFoto(foto);
            
            boolean anyError = false;

            String error = "";
            
            if (username.isEmpty()) {
                anyError = true;
                error += "<br>Username cannot be empty!";
            }
            if (name.isEmpty()) {
                anyError = true;
                error += "<br>Name cannot be empty!";
            }
            if (lastName.isEmpty()) {
                anyError = true;
                error += "<br>Last Name cannot be empty!";
            }

            if (anyError) {
                request.setAttribute("error", error);
            } else { // SUCCESS
                userFacade.edit(user); // UPDATE PROFILE INFORMATION
                String info = "Profile saved successfully!";
                request.setAttribute("info", info);
            }

        }

        rd = this.getServletContext().getRequestDispatcher("/ProfileServlet");
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
