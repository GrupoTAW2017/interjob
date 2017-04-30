/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interjob.servlet;

import interJob.ejb.FriendshipFacade;
import interJob.ejb.HobbyFacade;
import interJob.ejb.StudiesFacade;
import interJob.ejb.UserFacade;
import interJob.ejb.WorkExperienceFacade;
import interJob.entity.Hobby;
import interJob.entity.Studies;
import interJob.entity.User;
import interJob.entity.WorkExperience;

import java.io.IOException;
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
 * @author Francisco Ruiz <pacorf>
 */
@WebServlet(name = "ProfileServlet", urlPatterns = {"/ProfileServlet"})
public class ProfileServlet extends HttpServlet {
    
    @EJB
    FriendshipFacade friendshipFacade;
    
    @EJB
    HobbyFacade hobbyFacade;
    
    @EJB
    StudiesFacade studiesFacade;
    
    @EJB
    UserFacade userFacade;
    
    @EJB
    WorkExperienceFacade workExperienceFacade;

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
        User user = (User) session.getAttribute("user"); // get current user from session
        List<User> friendList;
        RequestDispatcher rd;

        if (user == null) { // If not logged in, go to login
            String error = "Login first!";
            request.setAttribute("error", error);
            rd = this.getServletContext().getRequestDispatcher("/LoginServlet");
            rd.forward(request, response);
        } else {
            // Check friend status
            friendList = userFacade.getFriends(user.getId());
            if (friendList != null) {
                
            }
            request.setAttribute("friendstatus", "NO");
        }

        try {
            Integer profileId = Integer.parseInt(request.getParameter("id")); // user id used for showing profile info.
            User profileUser = userFacade.findUserById(profileId);
            if (profileUser != null) {
                request.setAttribute("profileuser", profileUser);
                // find studies
                List<Studies> studies = studiesFacade.findStudiesByUser(profileUser);
                request.setAttribute("studies", studies);
                // find work experiences
                List<WorkExperience> workExperiences = workExperienceFacade.findWorkExperiencesByUser(profileUser);
                request.setAttribute("workExperiences", workExperiences);
                // find hobbies
                List<Hobby> hobbies = hobbyFacade.findHobbiesByUser(profileUser);
                request.setAttribute("hobbies", hobbies);
            }
        } catch (NumberFormatException e) { // If no parameter, choose logged in user.
            request.setAttribute("profileuser", user);
            // find studies
            List<Studies> studies = studiesFacade.findStudiesByUser(user);
            request.setAttribute("studies", studies);
            // find work experiences
            List<WorkExperience> workExperiences = workExperienceFacade.findWorkExperiencesByUser(user);
            request.setAttribute("workExperiences", workExperiences);
            // find hobbies
            List<Hobby> hobbies = hobbyFacade.findHobbiesByUser(user);
            request.setAttribute("hobbies", hobbies);
        }
        
        rd = this.getServletContext().getRequestDispatcher("/profile.jsp");
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
