
package interjob.bean;

import interJob.ejb.FriendshipFacade;
import interJob.ejb.UserFacade;
import interJob.entity.User;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/*
    @document   : FriendsBean.java
    @created on : 31-may-2017, 23:00:00
    @author     : Andreas Blume <bluman91>
*/
@Named(value = "friendsBean")
@RequestScoped
public class FriendsBean implements Serializable {
    
    @EJB    private FriendshipFacade friendshipFacade;
    @EJB    private UserFacade userFacade;
    
    private User user = null;
    private List<User> friends = null;
    
    private boolean filter = false;
    private String filterText = "Username";
    
    @Inject
    private SessionBean sessionBean;
    
    public FriendsBean() {

    }
    
    @PostConstruct
    public void init() {
        ExternalContext ec = FacesContext.getCurrentInstance()
                                         .getExternalContext();
        
        // check GET-Parameter "id"
        Integer profileId;
        Map<String, String> paramMap = ec.getRequestParameterMap();
        if(paramMap.containsKey("id")) {
            try {
                profileId = Integer.parseInt(paramMap.get("id"));
            } catch (NumberFormatException e) {
                String error = "The get-Parameter 'id' has a wrong format!";
                ec.getRequestMap().put("error", error);
            
                if(sessionBean.getUser() != null) { // check if an user is logged in
                    profileId = sessionBean.getUser().getId();
                }
                else {  // If no parameter, choose no user
                    this.user = null;
                    return;
                }
            }
        }
        else {
            if(sessionBean.getUser() != null) { // check if an user is logged in
                profileId = sessionBean.getUser().getId();
            }
            else {
                this.user = null;
                return;
            }
        }

        // get user
        this.user = userFacade.findUserById(profileId);
        
        // find friends
        if (this.user != null) {
            // find friends
            this.friends = this.userFacade.getFriends(this.user.getId());
        }
    }
    
    public void deleteFriend(Integer delFriendId) {
        ExternalContext ec = FacesContext.getCurrentInstance()
                                         .getExternalContext();
        
        // check if the UserID is a correct input
        if(delFriendId < 1) {
            String error = "The User-ID: \"" + delFriendId + "\" isn't a correct input!";
            ec.getRequestMap().put("error", error);
            return;
        }
        // check if it the same id as your own UserID
        if(sessionBean.getUser().getId().equals(delFriendId)) {
            String info = "You can't break off the friendship with yourself. :D";
            ec.getRequestMap().put("info", info);
            return;
        }
        
        // check if an user with this id exist
        User friend = this.userFacade.findUserById(delFriendId);
        if(friend == null) {
            String error = "An user with the User-ID: \"" + delFriendId + "\" doesn't exist!";
            ec.getRequestMap().put("error", error);
            return;
        }
        
        // check if you are a friend of the user with the UserID "friendsID"
        List<User> friendList = userFacade.getFriends(sessionBean.getUser().getId());
        if(friendList != null) {
            if(!friendList.contains(friend)) {
                String error = "You are not a (confirmed) friend of the user \"" + friend.getUsername() + "\"!";
                ec.getRequestMap().put("error", error);
            }
            else {
                int count = friendshipFacade.deleteFriend(sessionBean.getUser(), friend);
          
                if(count == 1) {
                    String info = "You successfully broke off the friendship with the user \"" + friend.getUsername() + "\"!";
                    ec.getRequestMap().put("info", info);
                } else {
                    String error = "An error occured while breaking off the friendship with the user \"" + friend.getUsername() + "\"! Please try again later.";
                    ec.getRequestMap().put("error", error);
                }
            }
        }
        
        // update friend list
        this.friends = this.userFacade.getFriends(sessionBean.getUser().getId());
    }
    
    public void setFilterText(String username) {
        this.filter = true;
        this.filterText = username;
        this.friends.clear();

        username = username.toLowerCase();
        List<User> friendList = this.userFacade.getFriends(this.user.getId());
        for(User friend : friendList) {
            if(friend.getUsername().toLowerCase().contains(username))
                this.friends.add(friend);
        }
    }
    public String getFilterText() {
        return this.filterText;
    }
    public Integer getUserId() {
        return this.user.getId();
    }
    public void setUserId(Integer UserId) {
        this.user = userFacade.findUserById(UserId);
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

    public boolean getFilter() {
        return filter;
    }
}
