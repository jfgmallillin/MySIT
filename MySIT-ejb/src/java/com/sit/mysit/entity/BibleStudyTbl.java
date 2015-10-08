/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sit.mysit.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jack
 */
@Entity
@Table(name = "bible_study_tbl", catalog = "mysit", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BibleStudyTbl.findAll", query = "SELECT b FROM BibleStudyTbl b"),
    @NamedQuery(name = "BibleStudyTbl.findById", query = "SELECT b FROM BibleStudyTbl b WHERE b.id = :id"),
    @NamedQuery(name = "BibleStudyTbl.findByDate", query = "SELECT b FROM BibleStudyTbl b WHERE b.date = :date")})
public class BibleStudyTbl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date date;
    @JoinColumn(name = "ACTIVITY_ID", referencedColumnName = "ACTIVITY_ID", nullable = false)
    @ManyToOne(optional = false)
    private OrgActivitiesTbl activityId;
    @JoinColumn(name = "DISCIPLE_ID", referencedColumnName = "PROFILE_ID", nullable = false)
    @ManyToOne(optional = false)
    private MemberProfile discipleId;
    @JoinColumn(name = "DISCIPLER_ID", referencedColumnName = "PROFILE_ID", nullable = false)
    @ManyToOne(optional = false)
    private MemberProfile disciplerId;
    @JoinColumn(name = "SUBJECT_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private SubjectTbl subjectId;

    public BibleStudyTbl() {
    }

    public BibleStudyTbl(Integer id) {
        this.id = id;
    }

    public BibleStudyTbl(Integer id, Date date) {
        this.id = id;
        this.date = date;
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

    public OrgActivitiesTbl getActivityId() {
        return activityId;
    }

    public void setActivityId(OrgActivitiesTbl activityId) {
        this.activityId = activityId;
    }

    public MemberProfile getDiscipleId() {
        return discipleId;
    }

    public void setDiscipleId(MemberProfile discipleId) {
        this.discipleId = discipleId;
    }

    public MemberProfile getDisciplerId() {
        return disciplerId;
    }

    public void setDisciplerId(MemberProfile disciplerId) {
        this.disciplerId = disciplerId;
    }

    public SubjectTbl getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(SubjectTbl subjectId) {
        this.subjectId = subjectId;
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
        if (!(object instanceof BibleStudyTbl)) {
            return false;
        }
        BibleStudyTbl other = (BibleStudyTbl) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sit.mysit.entity.BibleStudyTbl[ id=" + id + " ]";
    }
    
}
