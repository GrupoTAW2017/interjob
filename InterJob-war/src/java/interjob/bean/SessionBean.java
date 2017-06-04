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

/**
 *
 * @author Francisco Ruiz <pacorf>  and  Andreas Blume <bluman91>
 */
@Named(value = "sessionBean")
@SessionScoped
public class SessionBean implements Serializable {

    @EJB UserFacade userFacade;
    
    User user = null;
    

    public SessionBean() {
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
