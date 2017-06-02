/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interjob.bean;

import interJob.ejb.UserFacade;
import interJob.entity.User;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Francisco Ruiz <pacorf>
 */
@Named(value = "registerBean")
@RequestScoped
public class RegisterBean {

    @EJB
    UserFacade userFacade;
    
    private String username;
    private String name;
    private String lastName;
    private String password;

    /**
     * Creates a new instance of RegisterBean
     */
    public RegisterBean() {
    }

    public String doRegister() {
        
        FacesContext context = FacesContext.getCurrentInstance();
        
        // Check if username is already taken
        if (userFacade.findByUsername(username) != null) {
            String error = "Username already exists!";
            context.getExternalContext().getRequestMap().put("error", error);
            return "register";
        }
        
        // Create new User object
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setName(name);
        newUser.setLastName(lastName);
        newUser.setPassword(password);
        
        // Persist new user
        userFacade.create(newUser);
        
        // Report client
        String info = "Account successfully created!";
        context.getExternalContext().getRequestMap().put("info", info);
        
        return "login";
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
