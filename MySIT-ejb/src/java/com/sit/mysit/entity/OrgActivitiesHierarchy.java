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
@Table(name = "org_activities_hierarchy", catalog = "mysit", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrgActivitiesHierarchy.findAll", query = "SELECT o FROM OrgActivitiesHierarchy o"),
    @NamedQuery(name = "OrgActivitiesHierarchy.findByActivityId", query = "SELECT o FROM OrgActivitiesHierarchy o WHERE o.activityId = :activityId"),
    @NamedQuery(name = "OrgActivitiesHierarchy.findByLft", query = "SELECT o FROM OrgActivitiesHierarchy o WHERE o.lft = :lft"),
    @NamedQuery(name = "OrgActivitiesHierarchy.findByRgt", query = "SELECT o FROM OrgActivitiesHierarchy o WHERE o.rgt = :rgt")})
public class OrgActivitiesHierarchy implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACTIVITY_ID", nullable = false)
    private Integer activityId;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int lft;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int rgt;
    @JoinColumn(name = "ACTIVITY_ID", referencedColumnName = "ACTIVITY_ID", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    private OrgActivitiesTbl orgActivitiesTbl;

    public OrgActivitiesHierarchy() {
    }

    public OrgActivitiesHierarchy(Integer activityId) {
        this.activityId = activityId;
    }

    public OrgActivitiesHierarchy(Integer activityId, int lft, int rgt) {
        this.activityId = activityId;
        this.lft = lft;
        this.rgt = rgt;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
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

    public OrgActivitiesTbl getOrgActivitiesTbl() {
        return orgActivitiesTbl;
    }

    public void setOrgActivitiesTbl(OrgActivitiesTbl orgActivitiesTbl) {
        this.orgActivitiesTbl = orgActivitiesTbl;
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
        if (!(object instanceof OrgActivitiesHierarchy)) {
            return false;
        }
        OrgActivitiesHierarchy other = (OrgActivitiesHierarchy) object;
        if ((this.activityId == null && other.activityId != null) || (this.activityId != null && !this.activityId.equals(other.activityId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sit.mysit.entity.OrgActivitiesHierarchy[ activityId=" + activityId + " ]";
    }
    
}
