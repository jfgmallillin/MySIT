/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sit.mysit.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
@Table(name = "member_profile", catalog = "mysit", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MemberProfile.findAll", query = "SELECT m FROM MemberProfile m"),
    @NamedQuery(name = "MemberProfile.findByProfileId", query = "SELECT m FROM MemberProfile m WHERE m.profileId = :profileId"),
    @NamedQuery(name = "MemberProfile.findByFirstname", query = "SELECT m FROM MemberProfile m WHERE m.firstname = :firstname"),
    @NamedQuery(name = "MemberProfile.findByLastname", query = "SELECT m FROM MemberProfile m WHERE m.lastname = :lastname"),
    @NamedQuery(name = "MemberProfile.findByMiddlename", query = "SELECT m FROM MemberProfile m WHERE m.middlename = :middlename"),
    @NamedQuery(name = "MemberProfile.findByGender", query = "SELECT m FROM MemberProfile m WHERE m.gender = :gender"),
    @NamedQuery(name = "MemberProfile.findByBBirthday", query = "SELECT m FROM MemberProfile m WHERE m.bBirthday = :bBirthday"),
    @NamedQuery(name = "MemberProfile.findBySBirthday", query = "SELECT m FROM MemberProfile m WHERE m.sBirthday = :sBirthday"),
    @NamedQuery(name = "MemberProfile.findByStatus", query = "SELECT m FROM MemberProfile m WHERE m.status = :status")})
public class MemberProfile implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PROFILE_ID", nullable = false)
    private Integer profileId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(nullable = false, length = 50)
    private String firstname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(nullable = false, length = 50)
    private String lastname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(nullable = false, length = 25)
    private String middlename;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private char gender;
    @Basic(optional = false)
    @NotNull
    @Column(name = "B_BIRTHDAY", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date bBirthday;
    @Basic(optional = false)
    @NotNull
    @Column(name = "S_BIRTHDAY", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date sBirthday;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private short status;
    @ManyToMany(mappedBy = "memberProfileList")
    private List<OrgGroup> orgGroupList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "memberProfile")
    private OrgMemberHierarchy orgMemberHierarchy;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "discipleId")
    private List<BibleStudyTbl> bibleStudyTblList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "disciplerId")
    private List<BibleStudyTbl> bibleStudyTblList1;
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private Userlogin userId;

    public MemberProfile() {
    }

    public MemberProfile(Integer profileId) {
        this.profileId = profileId;
    }

    public MemberProfile(Integer profileId, String firstname, String lastname, String middlename, char gender, Date bBirthday, Date sBirthday, short status) {
        this.profileId = profileId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.middlename = middlename;
        this.gender = gender;
        this.bBirthday = bBirthday;
        this.sBirthday = sBirthday;
        this.status = status;
    }

    public Integer getProfileId() {
        return profileId;
    }

    public void setProfileId(Integer profileId) {
        this.profileId = profileId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public Date getBBirthday() {
        return bBirthday;
    }

    public void setBBirthday(Date bBirthday) {
        this.bBirthday = bBirthday;
    }

    public Date getSBirthday() {
        return sBirthday;
    }

    public void setSBirthday(Date sBirthday) {
        this.sBirthday = sBirthday;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    @XmlTransient
    @JsonIgnore
    public List<OrgGroup> getOrgGroupList() {
        return orgGroupList;
    }

    public void setOrgGroupList(List<OrgGroup> orgGroupList) {
        this.orgGroupList = orgGroupList;
    }

    public OrgMemberHierarchy getOrgMemberHierarchy() {
        return orgMemberHierarchy;
    }

    public void setOrgMemberHierarchy(OrgMemberHierarchy orgMemberHierarchy) {
        this.orgMemberHierarchy = orgMemberHierarchy;
    }

    @XmlTransient
    @JsonIgnore
    public List<BibleStudyTbl> getBibleStudyTblList() {
        return bibleStudyTblList;
    }

    public void setBibleStudyTblList(List<BibleStudyTbl> bibleStudyTblList) {
        this.bibleStudyTblList = bibleStudyTblList;
    }

    @XmlTransient
    @JsonIgnore
    public List<BibleStudyTbl> getBibleStudyTblList1() {
        return bibleStudyTblList1;
    }

    public void setBibleStudyTblList1(List<BibleStudyTbl> bibleStudyTblList1) {
        this.bibleStudyTblList1 = bibleStudyTblList1;
    }

    public Userlogin getUserId() {
        return userId;
    }

    public void setUserId(Userlogin userId) {
        this.userId = userId;
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
        if (!(object instanceof MemberProfile)) {
            return false;
        }
        MemberProfile other = (MemberProfile) object;
        if ((this.profileId == null && other.profileId != null) || (this.profileId != null && !this.profileId.equals(other.profileId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sit.mysit.entity.MemberProfile[ profileId=" + profileId + " ]";
    }
    
}
