/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interjob.servlet;


import interJob.ejb.UserFacade;
import interJob.entity.User;
import interjob.webForm.LoginForm;
import java.io.IOException;
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
    //private UserFacade userFacade;

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
        
        LoginForm login; 
        login = (LoginForm)session.getAttribute("login");
        RequestDispatcher rd;
        if (login==null){
            login = new LoginForm();
            //request.setAttribute("login", login);
            //rd = this.getServletContext().getRequestDispatcher("/login.jsp");
      
        } //else {
        /*    login.setAccessDenied(false);
            login.setWritelogin(false);
            login.setWritepassword(false);
            if (login.getLogin().equals("")) login.setWritelogin(true);
            if (login.getPassword().equals("")) login.setWritepassword(true);
            if ((!login.isWritelogin()) && 
               (!login.isWritepassword())) {
               User user = new User();
               user.setUsername(login.getLogin());
               user.setPassword(login.getPassword());
               User userLogeado = this.userFacade.loginUser(user);
               if (userLogeado==null) {
                   
                   login.setAccessDenied(true);
                   request.setAttribute("login", login);
                   rd = this.getServletContext().getRequestDispatcher("/login.jsp");
               } else {
                   request.setAttribute("user", user);
                   rd = this.getServletContext().getRequestDispatcher("app"); ///// TODO: APP redirect                   
                   
               }
               
               
            //} else {*/
                
            //}
            request.setAttribute("login", login);
            rd = getServletContext().getRequestDispatcher("/login.jsp");
       // }    
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
