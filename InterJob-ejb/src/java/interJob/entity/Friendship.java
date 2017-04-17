/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interJob.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Francisco Ruiz <pacorf>
 */
@Entity
@Table(name = "FRIENDSHIP", catalog = "dbinterjob", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Friendship.findAll", query = "SELECT f FROM Friendship f")
    , @NamedQuery(name = "Friendship.findByConfirmed", query = "SELECT f FROM Friendship f WHERE f.confirmed = :confirmed")
    , @NamedQuery(name = "Friendship.findByUserId", query = "SELECT f FROM Friendship f WHERE f.userId = :userId")
    , @NamedQuery(name = "Friendship.findByUserId1", query = "SELECT f FROM Friendship f WHERE f.userId1 = :userId1")
    , @NamedQuery(name = "Friendship.findById", query = "SELECT f FROM Friendship f WHERE f.id = :id")})
public class Friendship implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "CONFIRMED")
    private Short confirmed;
    @Basic(optional = false)
    @NotNull
    @Column(name = "USER_ID")
    private int userId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "USER_ID1")
    private int userId1;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;

    public Friendship() {
    }

    public Friendship(Integer id) {
        this.id = id;
    }

    public Friendship(Integer id, int userId, int userId1) {
        this.id = id;
        this.userId = userId;
        this.userId1 = userId1;
    }

    public Short getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Short confirmed) {
        this.confirmed = confirmed;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserId1() {
        return userId1;
    }

    public void setUserId1(int userId1) {
        this.userId1 = userId1;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Friendship)) {
            return false;
        }
        Friendship other = (Friendship) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "interJob.entity.Friendship[ id=" + id + " ]";
    }
    
}
