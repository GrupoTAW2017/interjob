/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interjob.bean;

import interJob.ejb.UserFacade;
import interJob.entity.User;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author Francisco Ruiz <pacorf>
 */
@Named(value = "profileBean")
@RequestScoped
public class ProfileBean {

    @EJB
    private UserFacade userFacade;

    @Inject
    SessionBean sessionBean;

    // User used in profile edition page
    private User profileUser;

    // Variables for Password Editor
    private String oldPassword = "";
    private String newPassword = "";
    private String newPasswordRepeat = "";

    @PostConstruct
    public void init() {
        //TODO: Load form
    }
    
    /**
     * Creates a new instance of ProfileBean
     */
    public ProfileBean() {
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getNewPasswordRepeat() {
        return newPasswordRepeat;
    }

    public void setNewPasswordRepeat(String newPasswordRepeat) {
        this.newPasswordRepeat = newPasswordRepeat;
    }

    public User getProfileUser() {
        return profileUser;
    }

    public void setProfileUser(User profileUser) {
        this.profileUser = profileUser;
    }

    /**
     * Invoked by Profile Editor (profileedit.xhtml)
     *
     * @return Response URL
     */
    public String doUpdateProfile() {
        //TODO: Finish doUpdateProfile()

        return null;
    }

    /**
     * Invoked by PasswordEditor (passwordedit.xhtml)
     * Updates logged in user's password with the new one.
     * @return Response URL
     */
    public String doUpdatePassword() {
        
        // Variable used for storing the session's user
        User sessionUser;
        
        if (!isUserLoggedOn()) return "login";
        sessionUser = sessionBean.getUser();
        
        if (this.oldPassword==null || this.newPassword==null || this.newPasswordRepeat==null) {
            String error = "Fields cannot be empty! " + this.oldPassword + this.newPassword + this.newPasswordRepeat;
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("error", error);
            return null;
        }
        
        
        if (sessionUser.getPassword().equals(oldPassword)) { // check old password
                if (newPassword.equals(newPasswordRepeat)) { // check new password
                    if (!sessionUser.getPassword().equals(newPassword)) { // check if old and new password do not match
                        // SUCCESS
                        sessionUser.setPassword(newPassword);
                        userFacade.edit(sessionUser);
                        String info = "Password changed sucessfully!";
                        FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("info", info);
                        return "profile";
                    } else {
                        String error = "New password must be different from the old one.";
                        FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("error", error);
                    }
                } else {
                    String error = "New passwords typed do not match.";
                    FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("error", error);
                }
            } else {
                String error = "Old password do not match.";
                FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("error", error);
            }
        return "passwordedit";
    }
    
    /**
     * Checks if user is logged in.
     */
    private boolean isUserLoggedOn () {
        if (sessionBean.getUser() != null) {
            return true;
        }
        return false;
    }

}
