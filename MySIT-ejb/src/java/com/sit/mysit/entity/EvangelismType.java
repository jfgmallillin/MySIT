/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sit.mysit.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "evangelism_type", catalog = "mysit", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EvangelismType.findAll", query = "SELECT e FROM EvangelismType e"),
    @NamedQuery(name = "EvangelismType.findById", query = "SELECT e FROM EvangelismType e WHERE e.id = :id"),
    @NamedQuery(name = "EvangelismType.findByName", query = "SELECT e FROM EvangelismType e WHERE e.name = :name")})
public class EvangelismType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(nullable = false, length = 30)
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "evangelismType")
    private List<EvangelismTbl> evangelismTblList;

    public EvangelismType() {
    }

    public EvangelismType(Integer id) {
        this.id = id;
    }

    public EvangelismType(Integer id, String name) {
        this.id = id;
        this.name = name;
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

    @XmlTransient
    @JsonIgnore
    public List<EvangelismTbl> getEvangelismTblList() {
        return evangelismTblList;
    }

    public void setEvangelismTblList(List<EvangelismTbl> evangelismTblList) {
        this.evangelismTblList = evangelismTblList;
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
        if (!(object instanceof EvangelismType)) {
            return false;
        }
        EvangelismType other = (EvangelismType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sit.mysit.entity.EvangelismType[ id=" + id + " ]";
    }
    
}
