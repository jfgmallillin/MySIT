/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sit.mysit.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jack
 */
@Entity
@Table(name = "evangelism_tbl", catalog = "mysit", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EvangelismTbl.findAll", query = "SELECT e FROM EvangelismTbl e"),
    @NamedQuery(name = "EvangelismTbl.findByActivityId", query = "SELECT e FROM EvangelismTbl e WHERE e.evangelismTblPK.activityId = :activityId"),
    @NamedQuery(name = "EvangelismTbl.findByType", query = "SELECT e FROM EvangelismTbl e WHERE e.evangelismTblPK.type = :type"),
    @NamedQuery(name = "EvangelismTbl.findByDateStart", query = "SELECT e FROM EvangelismTbl e WHERE e.evangelismTblPK.dateStart = :dateStart"),
    @NamedQuery(name = "EvangelismTbl.findByDateEnd", query = "SELECT e FROM EvangelismTbl e WHERE e.dateEnd = :dateEnd"),
    @NamedQuery(name = "EvangelismTbl.findByPrc", query = "SELECT e FROM EvangelismTbl e WHERE e.prc = :prc"),
    @NamedQuery(name = "EvangelismTbl.findByAc", query = "SELECT e FROM EvangelismTbl e WHERE e.ac = :ac"),
    @NamedQuery(name = "EvangelismTbl.findByNi", query = "SELECT e FROM EvangelismTbl e WHERE e.ni = :ni"),
    @NamedQuery(name = "EvangelismTbl.findByTotal", query = "SELECT e FROM EvangelismTbl e WHERE e.total = :total"),
    @NamedQuery(name = "EvangelismTbl.findByKeyword", query = "SELECT e FROM EvangelismTbl e WHERE e.keyword = :keyword")})
public class EvangelismTbl implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EvangelismTblPK evangelismTblPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATE_END", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateEnd;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int prc;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int ac;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int ni;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int total;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(nullable = false)
    private byte[] data;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(nullable = false, length = 20)
    private String keyword;
    @JoinColumn(name = "TYPE", referencedColumnName = "ID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private EvangelismType evangelismType;
    @JoinColumn(name = "ACTIVITY_ID", referencedColumnName = "ACTIVITY_ID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private OrgActivitiesTbl orgActivitiesTbl;

    public EvangelismTbl() {
    }

    public EvangelismTbl(EvangelismTblPK evangelismTblPK) {
        this.evangelismTblPK = evangelismTblPK;
    }

    public EvangelismTbl(EvangelismTblPK evangelismTblPK, Date dateEnd, int prc, int ac, int ni, int total, byte[] data, String keyword) {
        this.evangelismTblPK = evangelismTblPK;
        this.dateEnd = dateEnd;
        this.prc = prc;
        this.ac = ac;
        this.ni = ni;
        this.total = total;
        this.data = data;
        this.keyword = keyword;
    }

    public EvangelismTbl(int activityId, int type, Date dateStart) {
        this.evangelismTblPK = new EvangelismTblPK(activityId, type, dateStart);
    }

    public EvangelismTblPK getEvangelismTblPK() {
        return evangelismTblPK;
    }

    public void setEvangelismTblPK(EvangelismTblPK evangelismTblPK) {
        this.evangelismTblPK = evangelismTblPK;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public int getPrc() {
        return prc;
    }

    public void setPrc(int prc) {
        this.prc = prc;
    }

    public int getAc() {
        return ac;
    }

    public void setAc(int ac) {
        this.ac = ac;
    }

    public int getNi() {
        return ni;
    }

    public void setNi(int ni) {
        this.ni = ni;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public EvangelismType getEvangelismType() {
        return evangelismType;
    }

    public void setEvangelismType(EvangelismType evangelismType) {
        this.evangelismType = evangelismType;
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
        hash += (evangelismTblPK != null ? evangelismTblPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EvangelismTbl)) {
            return false;
        }
        EvangelismTbl other = (EvangelismTbl) object;
        if ((this.evangelismTblPK == null && other.evangelismTblPK != null) || (this.evangelismTblPK != null && !this.evangelismTblPK.equals(other.evangelismTblPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sit.mysit.entity.EvangelismTbl[ evangelismTblPK=" + evangelismTblPK + " ]";
    }
    
}
