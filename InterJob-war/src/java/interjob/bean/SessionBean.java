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
    

    public User getUser() {
        FacesContext context = FacesContext.getCurrentInstance();
        return (User) context.getExternalContext().getSessionMap().get("user");
    }

    public void setUser(User user) {
        // Put user into session map
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getSessionMap().put("user", user);
        // And into SessionBean
    }
    /**
     * Creates a new instance of SessionBean
     */
    public SessionBean() {
    }
}
