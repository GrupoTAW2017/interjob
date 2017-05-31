
package interjob.bean;

import interJob.ejb.UserFacade;
import interJob.entity.User;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/*
    Document   : FriendsBean.java
    Created on : 31-may-2017, 23:00:00
    Author     : Andreas Blume <bluman91>
*/
@Named
@RequestScoped
public class FriendsBean implements Serializable {
    
    @EJB    UserFacade userFacade;
    
    private User user = null;
    private List<User> friends = null;
    
    @Inject
    private SessionBean sessionBean;
    
    public FriendsBean() {

    }
    
    @PostConstruct
    public void init() {
        // check GET-Parameter
        FacesContext context = FacesContext.getCurrentInstance();
        Map<String, String> paramMap = context.getExternalContext().getRequestParameterMap();
        Integer profileId;
        try {
            profileId = Integer.parseInt(paramMap.get("id"));
        } catch (NumberFormatException e) { // If no parameter, choose no user
            if(sessionBean != null) {
                profileId = sessionBean.getUser().getId();
            }
            else {
                this.user = null;
                return;
            }
        }

        this.user = userFacade.findUserById(profileId);
        if (this.user != null) {
            // find friends
            this.friends = this.userFacade.getFriends(this.user.getId());
        }
    }
    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getFriends() {
        return friends;
    }

    public void setFriends(List<User> friends) {
        this.friends = friends;
    }
}
