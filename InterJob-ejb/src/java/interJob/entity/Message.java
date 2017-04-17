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
@Table(name = "MESSAGE", catalog = "dbinterjob", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Message.findAll", query = "SELECT m FROM Message m")
    , @NamedQuery(name = "Message.findById", query = "SELECT m FROM Message m WHERE m.id = :id")
    , @NamedQuery(name = "Message.findByDate", query = "SELECT m FROM Message m WHERE m.date = :date")
    , @NamedQuery(name = "Message.findByRead", query = "SELECT m FROM Message m WHERE m.read = :read")
    , @NamedQuery(name = "Message.findByUserFrom", query = "SELECT m FROM Message m WHERE m.userFrom = :userFrom")
    , @NamedQuery(name = "Message.findByUserTo", query = "SELECT m FROM Message m WHERE m.userTo = :userTo")})
public class Message implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Lob
    @Size(max = 65535)
    @Column(name = "CONTENT")
    private String content;
    @Basic(optional = false)
    @NotNull
    @Column(name = "READ")
    private short read;
    @Basic(optional = false)
    @NotNull
    @Column(name = "USER_FROM")
    private int userFrom;
    @Basic(optional = false)
    @NotNull
    @Column(name = "USER_TO")
    private int userTo;

    public Message() {
    }

    public Message(Integer id) {
        this.id = id;
    }

    public Message(Integer id, short read, int userFrom, int userTo) {
        this.id = id;
        this.read = read;
        this.userFrom = userFrom;
        this.userTo = userTo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public short getRead() {
        return read;
    }

    public void setRead(short read) {
        this.read = read;
    }

    public int getUserFrom() {
        return userFrom;
    }

    public void setUserFrom(int userFrom) {
        this.userFrom = userFrom;
    }

    public int getUserTo() {
        return userTo;
    }

    public void setUserTo(int userTo) {
        this.userTo = userTo;
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
        if (!(object instanceof Message)) {
            return false;
        }
        Message other = (Message) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "interJob.entity.Message[ id=" + id + " ]";
    }
    
}
