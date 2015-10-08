/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sit.mysit.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jack
 */
@Entity
@Table(name = "org_member_hierarchy", catalog = "mysit", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrgMemberHierarchy.findAll", query = "SELECT o FROM OrgMemberHierarchy o"),
    @NamedQuery(name = "OrgMemberHierarchy.findByProfileId", query = "SELECT o FROM OrgMemberHierarchy o WHERE o.profileId = :profileId"),
    @NamedQuery(name = "OrgMemberHierarchy.findByLft", query = "SELECT o FROM OrgMemberHierarchy o WHERE o.lft = :lft"),
    @NamedQuery(name = "OrgMemberHierarchy.findByRgt", query = "SELECT o FROM OrgMemberHierarchy o WHERE o.rgt = :rgt")})
public class OrgMemberHierarchy implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PROFILE_ID", nullable = false)
    private Integer profileId;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int lft;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int rgt;
    @JoinColumn(name = "PROFILE_ID", referencedColumnName = "PROFILE_ID", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    private MemberProfile memberProfile;

    public OrgMemberHierarchy() {
    }

    public OrgMemberHierarchy(Integer profileId) {
        this.profileId = profileId;
    }

    public OrgMemberHierarchy(Integer profileId, int lft, int rgt) {
        this.profileId = profileId;
        this.lft = lft;
        this.rgt = rgt;
    }

    public Integer getProfileId() {
        return profileId;
    }

    public void setProfileId(Integer profileId) {
        this.profileId = profileId;
    }

    public int getLft() {
        return lft;
    }

    public void setLft(int lft) {
        this.lft = lft;
    }

    public int getRgt() {
        return rgt;
    }

    public void setRgt(int rgt) {
        this.rgt = rgt;
    }

    public MemberProfile getMemberProfile() {
        return memberProfile;
    }

    public void setMemberProfile(MemberProfile memberProfile) {
        this.memberProfile = memberProfile;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (profileId != null ? profileId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrgMemberHierarchy)) {
            return false;
        }
        OrgMemberHierarchy other = (OrgMemberHierarchy) object;
        if ((this.profileId == null && other.profileId != null) || (this.profileId != null && !this.profileId.equals(other.profileId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sit.mysit.entity.OrgMemberHierarchy[ profileId=" + profileId + " ]";
    }
    
}
