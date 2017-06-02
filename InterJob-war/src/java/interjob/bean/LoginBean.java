/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interjob.bean;

import interJob.ejb.UserFacade;
import interJob.entity.User;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Francisco Ruiz <pacorf>
 */
@Named
@RequestScoped
public class LoginBean implements Serializable {

    @EJB
    UserFacade userFacade;

    @Inject
    SessionBean sessionBean;

    private String username;
    private String password;

    /**
     * Creates a new instance of LoginBean
     */
    public LoginBean() {
    }

    public String doLogin() {

        FacesContext context = FacesContext.getCurrentInstance();

        if (username.equals("") || password.equals("")) { // If fields empty
            String error = "You have to fill out username and password";
            context.getExternalContext().getRequestMap().put("error", error);
            return "login";
        }

        // Check if credentials are correct
        User user = userFacade.loginUser(username, password);
        if (user == null) {
            String error = "Username or password wrong!";
            context.getExternalContext().getRequestMap().put("error", error);
            return "login";
        }
        
        // Insert user into session
        sessionBean.setUser(user);
        
        String info = "Logged in successfully!";
        context.getExternalContext().getRequestMap().put("info", info);
        return "home";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
