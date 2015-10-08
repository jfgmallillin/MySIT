/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sit.mysit.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author jack
 */
@Entity
@Table(catalog = "mysit", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Userlogin.findAll", query = "SELECT u FROM Userlogin u"),
    @NamedQuery(name = "Userlogin.findMaxId", query = "SELECT MAX(u.id) + 1 FROM Userlogin u"),
    @NamedQuery(name = "Userlogin.findById", query = "SELECT u FROM Userlogin u WHERE u.id = :id"),
    @NamedQuery(name = "Userlogin.findByUsername", query = "SELECT u FROM Userlogin u WHERE u.username = :username"),
    @NamedQuery(name = "Userlogin.findByPassword", query = "SELECT u FROM Userlogin u WHERE u.password = :password"),
    @NamedQuery(name = "Userlogin.findByMobileNo", query = "SELECT u FROM Userlogin u WHERE u.mobileNo = :mobileNo"),
    @NamedQuery(name = "Userlogin.findByStatus", query = "SELECT u FROM Userlogin u WHERE u.status = :status")})
public class Userlogin implements Serializable {
    public static final int STATUS_ACTIVE = 1;
    public static final int STATUS_LOCKED = 2;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(nullable = false, length = 30)
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(nullable = false, length = 64)
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "MOBILE_NO", nullable = false, length = 11)
    private String mobileNo;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int status;
    @JoinTable(name = "userroles", joinColumns = {
        @JoinColumn(name = "USER_ID", referencedColumnName = "ID", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "ROLE_ID", referencedColumnName = "ID", nullable = false)})
    @ManyToMany
    private List<Role> roleList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private List<MemberProfile> memberProfileList;

    public Userlogin() {
    }

    public Userlogin(Integer id) {
        this.id = id;
    }

    public Userlogin(Integer id, String username, String password, String mobileNo, int status) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.mobileNo = mobileNo;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @XmlTransient
    @JsonIgnore
    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    @XmlTransient
    @JsonIgnore
    public List<MemberProfile> getMemberProfileList() {
        return memberProfileList;
    }

    public void setMemberProfileList(List<MemberProfile> memberProfileList) {
        this.memberProfileList = memberProfileList;
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
        if (!(object instanceof Userlogin)) {
            return false;
        }
        Userlogin other = (Userlogin) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sit.mysit.entity.Userlogin[ id=" + id + " ]";
    }
    
}
