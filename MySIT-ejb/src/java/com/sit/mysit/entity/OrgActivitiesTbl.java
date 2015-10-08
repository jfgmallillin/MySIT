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
@Table(name = "org_activities_tbl", catalog = "mysit", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrgActivitiesTbl.findAll", query = "SELECT o FROM OrgActivitiesTbl o"),
    @NamedQuery(name = "OrgActivitiesTbl.findByActivityId", query = "SELECT o FROM OrgActivitiesTbl o WHERE o.activityId = :activityId"),
    @NamedQuery(name = "OrgActivitiesTbl.findByName", query = "SELECT o FROM OrgActivitiesTbl o WHERE o.name = :name"),
    @NamedQuery(name = "OrgActivitiesTbl.findByDescription", query = "SELECT o FROM OrgActivitiesTbl o WHERE o.description = :description"),
    @NamedQuery(name = "OrgActivitiesTbl.findByDateStart", query = "SELECT o FROM OrgActivitiesTbl o WHERE o.dateStart = :dateStart"),
    @NamedQuery(name = "OrgActivitiesTbl.findByDateEnd", query = "SELECT o FROM OrgActivitiesTbl o WHERE o.dateEnd = :dateEnd"),
    @NamedQuery(name = "OrgActivitiesTbl.findByKeyword", query = "SELECT o FROM OrgActivitiesTbl o WHERE o.keyword = :keyword")})
public class OrgActivitiesTbl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACTIVITY_ID", nullable = false)
    private Integer activityId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(nullable = false, length = 50)
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(nullable = false, length = 500)
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATE_START", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateStart;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATE_END", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateEnd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(nullable = false, length = 20)
    private String keyword;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orgActivitiesTbl")
    private List<EvangelismTbl> evangelismTblList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "orgActivitiesTbl")
    private OrgActivitiesHierarchy orgActivitiesHierarchy;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "activityId")
    private List<BibleStudyTbl> bibleStudyTblList;

    public OrgActivitiesTbl() {
    }

    public OrgActivitiesTbl(Integer activityId) {
        this.activityId = activityId;
    }

    public OrgActivitiesTbl(Integer activityId, String name, String description, Date dateStart, Date dateEnd, String keyword) {
        this.activityId = activityId;
        this.name = name;
        this.description = description;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.keyword = keyword;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
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

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    @XmlTransient
    @JsonIgnore
    public List<EvangelismTbl> getEvangelismTblList() {
        return evangelismTblList;
    }

    public void setEvangelismTblList(List<EvangelismTbl> evangelismTblList) {
        this.evangelismTblList = evangelismTblList;
    }

    public OrgActivitiesHierarchy getOrgActivitiesHierarchy() {
        return orgActivitiesHierarchy;
    }

    public void setOrgActivitiesHierarchy(OrgActivitiesHierarchy orgActivitiesHierarchy) {
        this.orgActivitiesHierarchy = orgActivitiesHierarchy;
    }

    @XmlTransient
    @JsonIgnore
    public List<BibleStudyTbl> getBibleStudyTblList() {
        return bibleStudyTblList;
    }

    public void setBibleStudyTblList(List<BibleStudyTbl> bibleStudyTblList) {
        this.bibleStudyTblList = bibleStudyTblList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (activityId != null ? activityId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrgActivitiesTbl)) {
            return false;
        }
        OrgActivitiesTbl other = (OrgActivitiesTbl) object;
        if ((this.activityId == null && other.activityId != null) || (this.activityId != null && !this.activityId.equals(other.activityId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sit.mysit.entity.OrgActivitiesTbl[ activityId=" + activityId + " ]";
    }
    
}
