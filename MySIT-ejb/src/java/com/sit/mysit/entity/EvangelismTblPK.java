/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sit.mysit.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author jack
 */
@Embeddable
public class EvangelismTblPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACTIVITY_ID", nullable = false)
    private int activityId;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int type;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATE_START", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateStart;

    public EvangelismTblPK() {
    }

    public EvangelismTblPK(int activityId, int type, Date dateStart) {
        this.activityId = activityId;
        this.type = type;
        this.dateStart = dateStart;
    }

    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) activityId;
        hash += (int) type;
        hash += (dateStart != null ? dateStart.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EvangelismTblPK)) {
            return false;
        }
        EvangelismTblPK other = (EvangelismTblPK) object;
        if (this.activityId != other.activityId) {
            return false;
        }
        if (this.type != other.type) {
            return false;
        }
        if ((this.dateStart == null && other.dateStart != null) || (this.dateStart != null && !this.dateStart.equals(other.dateStart))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sit.mysit.entity.EvangelismTblPK[ activityId=" + activityId + ", type=" + type + ", dateStart=" + dateStart + " ]";
    }
    
}
