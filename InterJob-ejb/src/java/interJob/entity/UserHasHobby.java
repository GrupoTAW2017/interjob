/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interJob.entity;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Francisco Ruiz <pacorf>
 */
@Entity
@Table(name = "USER_HAS_HOBBY", catalog = "dbinterjob", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserHasHobby.findAll", query = "SELECT u FROM UserHasHobby u")
    , @NamedQuery(name = "UserHasHobby.findByUserId", query = "SELECT u FROM UserHasHobby u WHERE u.userHasHobbyPK.userId = :userId")
    , @NamedQuery(name = "UserHasHobby.findByHobbyId", query = "SELECT u FROM UserHasHobby u WHERE u.userHasHobbyPK.hobbyId = :hobbyId")})
public class UserHasHobby implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UserHasHobbyPK userHasHobbyPK;

    public UserHasHobby() {
    }

    public UserHasHobby(UserHasHobbyPK userHasHobbyPK) {
        this.userHasHobbyPK = userHasHobbyPK;
    }

    public UserHasHobby(int userId, int hobbyId) {
        this.userHasHobbyPK = new UserHasHobbyPK(userId, hobbyId);
    }

    public UserHasHobbyPK getUserHasHobbyPK() {
        return userHasHobbyPK;
    }

    public void setUserHasHobbyPK(UserHasHobbyPK userHasHobbyPK) {
        this.userHasHobbyPK = userHasHobbyPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userHasHobbyPK != null ? userHasHobbyPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserHasHobby)) {
            return false;
        }
        UserHasHobby other = (UserHasHobby) object;
        if ((this.userHasHobbyPK == null && other.userHasHobbyPK != null) || (this.userHasHobbyPK != null && !this.userHasHobbyPK.equals(other.userHasHobbyPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "interJob.entity.UserHasHobby[ userHasHobbyPK=" + userHasHobbyPK + " ]";
    }
    
}
