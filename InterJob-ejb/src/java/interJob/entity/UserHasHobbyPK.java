/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interJob.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Francisco Ruiz <pacorf>
 */
@Embeddable
public class UserHasHobbyPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "USER_ID")
    private int userId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HOBBY_ID")
    private int hobbyId;

    public UserHasHobbyPK() {
    }

    public UserHasHobbyPK(int userId, int hobbyId) {
        this.userId = userId;
        this.hobbyId = hobbyId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getHobbyId() {
        return hobbyId;
    }

    public void setHobbyId(int hobbyId) {
        this.hobbyId = hobbyId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) userId;
        hash += (int) hobbyId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserHasHobbyPK)) {
            return false;
        }
        UserHasHobbyPK other = (UserHasHobbyPK) object;
        if (this.userId != other.userId) {
            return false;
        }
        if (this.hobbyId != other.hobbyId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "interJob.entity.UserHasHobbyPK[ userId=" + userId + ", hobbyId=" + hobbyId + " ]";
    }
    
}
