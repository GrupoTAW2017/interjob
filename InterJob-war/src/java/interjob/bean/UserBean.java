
/*
    Document   : UserBean.java
    Created on : 28-may-2017, 22:40:00
    Author     : Andreas Blume <bluman91>
*/

package interjob.bean;

import interJob.ejb.FriendshipFacade;
import interJob.ejb.HobbyFacade;
import interJob.ejb.StudiesFacade;
import interJob.ejb.UserFacade;
import interJob.ejb.WorkExperienceFacade;
import interJob.entity.Hobby;
import interJob.entity.Studies;
import interJob.entity.User;
import interJob.entity.WorkExperience;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.faces.context.FacesContext;


/**
 *
 * @author Andreas Blume <bluman91>
 */
@Named
@RequestScoped
public class UserBean implements Serializable {
    
    @EJB    FriendshipFacade friendshipFacade;
    @EJB    HobbyFacade hobbyFacade;
    @EJB    StudiesFacade studiesFacade;
    @EJB    UserFacade userFacade;
    @EJB    WorkExperienceFacade workExperienceFacade;
    
    
    private User profileUser = null;
    private List<Studies> studies = null;
    private List<WorkExperience> workExperiences = null;
    private  List<Hobby> hobbies = null;
    
    
    public UserBean() {
        
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
            this.profileUser = null;
            return;
        }

        this.profileUser = userFacade.findUserById(profileId);
        if (this.profileUser != null) {
            // find studies
            this.studies = this.studiesFacade.findStudiesByUser(profileUser);
            // find work experiences
            this.workExperiences = this.workExperienceFacade.findWorkExperiencesByUser(profileUser);
            // find hobbies
            this.hobbies = this.hobbyFacade.findHobbiesByUser(profileUser);
        }
    }

    public User getProfileUser() {
        return profileUser;
    }

    public void setProfileUser(User profileUser) {
        this.profileUser = profileUser;
    }

    public List<Studies> getStudies() {
        return studies;
    }

    public void setStudies(List<Studies> studies) {
        this.studies = studies;
    }

    public List<WorkExperience> getWorkExperiences() {
        return workExperiences;
    }

    public void setWorkExperiences(List<WorkExperience> workExperiences) {
        this.workExperiences = workExperiences;
    }

    public List<Hobby> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<Hobby> hobbies) {
        this.hobbies = hobbies;
    }
}
