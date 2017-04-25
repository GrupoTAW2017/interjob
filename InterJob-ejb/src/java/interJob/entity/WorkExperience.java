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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rassillon
 */
@Entity
@Table(name = "WORK_EXPERIENCE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WorkExperience.findAll", query = "SELECT w FROM WorkExperience w")
    , @NamedQuery(name = "WorkExperience.findById", query = "SELECT w FROM WorkExperience w WHERE w.id = :id")
    , @NamedQuery(name = "WorkExperience.findByStartDate", query = "SELECT w FROM WorkExperience w WHERE w.startDate = :startDate")
    , @NamedQuery(name = "WorkExperience.findByEndDate", query = "SELECT w FROM WorkExperience w WHERE w.endDate = :endDate")
    , @NamedQuery(name = "WorkExperience.findByBusiness", query = "SELECT w FROM WorkExperience w WHERE w.business = :business")
    , @NamedQuery(name = "WorkExperience.findByJob", query = "SELECT w FROM WorkExperience w WHERE w.job = :job")
    , @NamedQuery(name = "WorkExperience.findByWebpage", query = "SELECT w FROM WorkExperience w WHERE w.webpage = :webpage")})
public class WorkExperience implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "START_DATE")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Column(name = "END_DATE")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @Size(max = 100)
    @Column(name = "BUSINESS")
    private String business;
    @Size(max = 100)
    @Column(name = "JOB")
    private String job;
    @Size(max = 100)
    @Column(name = "WEBPAGE")
    private String webpage;
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private User userId;

    public WorkExperience() {
    }

    public WorkExperience(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getWebpage() {
        return webpage;
    }

    public void setWebpage(String webpage) {
        this.webpage = webpage;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
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
        if (!(object instanceof WorkExperience)) {
            return false;
        }
        WorkExperience other = (WorkExperience) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ea.entity.WorkExperience[ id=" + id + " ]";
    }
    
}
