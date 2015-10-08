/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sit.mysit.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "org_group", catalog = "mysit", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrgGroup.findAll", query = "SELECT o FROM OrgGroup o"),
    @NamedQuery(name = "OrgGroup.findById", query = "SELECT o FROM OrgGroup o WHERE o.id = :id"),
    @NamedQuery(name = "OrgGroup.findByName", query = "SELECT o FROM OrgGroup o WHERE o.name = :name"),
    @NamedQuery(name = "OrgGroup.findByDescription", query = "SELECT o FROM OrgGroup o WHERE o.description = :description")})
public class OrgGroup implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(nullable = false, length = 25)
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(nullable = false, length = 200)
    private String description;
    @JoinTable(name = "org_member_group", joinColumns = {
        @JoinColumn(name = "ORG_GROUP_ID", referencedColumnName = "ID", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "MEMBER_PROFILE_ID", referencedColumnName = "PROFILE_ID", nullable = false)})
    @ManyToMany
    private List<MemberProfile> memberProfileList;

    public OrgGroup() {
    }

    public OrgGroup(Integer id) {
        this.id = id;
    }

    public OrgGroup(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        if (!(object instanceof OrgGroup)) {
            return false;
        }
        OrgGroup other = (OrgGroup) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sit.mysit.entity.OrgGroup[ id=" + id + " ]";
    }
    
}
