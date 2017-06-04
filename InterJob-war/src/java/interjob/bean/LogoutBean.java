/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interjob.bean;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/*
    @document   : FriendsBean.java
    @created on : 04-jun-2017, 16:50:00
    @author     : Andreas Blume <bluman91>
*/
@Named(value = "logoutBean")
@RequestScoped
public class LogoutBean {

    public LogoutBean() {
    }
    
    public String doLogout() {
        ExternalContext ec = FacesContext.getCurrentInstance()
                                         .getExternalContext();
        
        // invalidate session
        ec.invalidateSession();
        
        String info = "Logged out successfully!";
        ec.getRequestMap()
          .put("info", info);
        
        // Go to login page
        return "login";
    }
    
}
