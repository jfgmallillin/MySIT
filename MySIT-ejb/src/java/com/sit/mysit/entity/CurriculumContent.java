/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sit.mysit.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jack
 */
@Entity
@Table(name = "curriculum_content", catalog = "mysit", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CurriculumContent.findAll", query = "SELECT c FROM CurriculumContent c"),
    @NamedQuery(name = "CurriculumContent.findByCurriculumId", query = "SELECT c FROM CurriculumContent c WHERE c.curriculumContentPK.curriculumId = :curriculumId"),
    @NamedQuery(name = "CurriculumContent.findBySubjectId", query = "SELECT c FROM CurriculumContent c WHERE c.curriculumContentPK.subjectId = :subjectId"),
    @NamedQuery(name = "CurriculumContent.findBySeqNo", query = "SELECT c FROM CurriculumContent c WHERE c.seqNo = :seqNo")})
public class CurriculumContent implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CurriculumContentPK curriculumContentPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SEQ_NO", nullable = false)
    private int seqNo;
    @JoinColumn(name = "SUBJECT_ID", referencedColumnName = "ID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SubjectTbl subjectTbl;
    @JoinColumn(name = "CURRICULUM_ID", referencedColumnName = "ID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private CurriculumTbl curriculumTbl;

    public CurriculumContent() {
    }

    public CurriculumContent(CurriculumContentPK curriculumContentPK) {
        this.curriculumContentPK = curriculumContentPK;
    }

    public CurriculumContent(CurriculumContentPK curriculumContentPK, int seqNo) {
        this.curriculumContentPK = curriculumContentPK;
        this.seqNo = seqNo;
    }

    public CurriculumContent(int curriculumId, int subjectId) {
        this.curriculumContentPK = new CurriculumContentPK(curriculumId, subjectId);
    }

    public CurriculumContentPK getCurriculumContentPK() {
        return curriculumContentPK;
    }

    public void setCurriculumContentPK(CurriculumContentPK curriculumContentPK) {
        this.curriculumContentPK = curriculumContentPK;
    }

    public int getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(int seqNo) {
        this.seqNo = seqNo;
    }

    public SubjectTbl getSubjectTbl() {
        return subjectTbl;
    }

    public void setSubjectTbl(SubjectTbl subjectTbl) {
        this.subjectTbl = subjectTbl;
    }

    public CurriculumTbl getCurriculumTbl() {
        return curriculumTbl;
    }

    public void setCurriculumTbl(CurriculumTbl curriculumTbl) {
        this.curriculumTbl = curriculumTbl;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (curriculumContentPK != null ? curriculumContentPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CurriculumContent)) {
            return false;
        }
        CurriculumContent other = (CurriculumContent) object;
        if ((this.curriculumContentPK == null && other.curriculumContentPK != null) || (this.curriculumContentPK != null && !this.curriculumContentPK.equals(other.curriculumContentPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sit.mysit.entity.CurriculumContent[ curriculumContentPK=" + curriculumContentPK + " ]";
    }
    
}
