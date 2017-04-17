/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interJob.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Francisco Ruiz <pacorf>
 */
@Entity
@Table(name = "STUDIES", catalog = "dbinterjob", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Studies.findAll", query = "SELECT s FROM Studies s")
    , @NamedQuery(name = "Studies.findByStartDate", query = "SELECT s FROM Studies s WHERE s.startDate = :startDate")
    , @NamedQuery(name = "Studies.findByEndDate", query = "SELECT s FROM Studies s WHERE s.endDate = :endDate")
    , @NamedQuery(name = "Studies.findByLocation", query = "SELECT s FROM Studies s WHERE s.location = :location")
    , @NamedQuery(name = "Studies.findById", query = "SELECT s FROM Studies s WHERE s.id = :id")
    , @NamedQuery(name = "Studies.findByUserId", query = "SELECT s FROM Studies s WHERE s.userId = :userId")})
public class Studies implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "START_DATE")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Column(name = "END_DATE")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @Lob
    @Size(max = 65535)
    @Column(name = "DESCRIPTION")
    private String description;
    @Size(max = 100)
    @Column(name = "LOCATION")
    private String location;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "USER_ID")
    private int userId;

    public Studies() {
    }

    public Studies(Integer id) {
        this.id = id;
    }

    public Studies(Integer id, int userId) {
        this.id = id;
        this.userId = userId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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
        if (!(object instanceof Studies)) {
            return false;
        }
        Studies other = (Studies) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "interJob.entity.Studies[ id=" + id + " ]";
    }
    
}
