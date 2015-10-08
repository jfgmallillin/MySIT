/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sit.mysit.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author jack
 */
@Embeddable
public class CurriculumContentPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "CURRICULUM_ID", nullable = false)
    private int curriculumId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SUBJECT_ID", nullable = false)
    private int subjectId;

    public CurriculumContentPK() {
    }

    public CurriculumContentPK(int curriculumId, int subjectId) {
        this.curriculumId = curriculumId;
        this.subjectId = subjectId;
    }

    public int getCurriculumId() {
        return curriculumId;
    }

    public void setCurriculumId(int curriculumId) {
        this.curriculumId = curriculumId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) curriculumId;
        hash += (int) subjectId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CurriculumContentPK)) {
            return false;
        }
        CurriculumContentPK other = (CurriculumContentPK) object;
        if (this.curriculumId != other.curriculumId) {
            return false;
        }
        if (this.subjectId != other.subjectId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sit.mysit.entity.CurriculumContentPK[ curriculumId=" + curriculumId + ", subjectId=" + subjectId + " ]";
    }
    
}
