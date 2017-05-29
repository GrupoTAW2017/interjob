/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interjob.bean;

import interJob.ejb.UserFacade;
import interJob.entity.User;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;

/**
 *
 * @author Francisco Ruiz <pacorf>
 */
@Named(value = "sessionBean")
@SessionScoped
public class SessionBean implements Serializable {

    @EJB UserFacade userFacade;
    
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    /**
     * Creates a new instance of SessionBean
     */
    public SessionBean() {
    }
    
    @PostConstruct
    public void init() {
        FacesContext context = FacesContext.getCurrentInstance();
        
        
        
        User u = userFacade.findUserById(1);
        context.getExternalContext().getSessionMap().put("user", u);
        
        
        user = (User)context.getExternalContext().getSessionMap().get("user");
        
        System.out.println(user.getName());
        
    }
    
}
