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
@Table(name = "curriculum_tbl", catalog = "mysit", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CurriculumTbl.findAll", query = "SELECT c FROM CurriculumTbl c"),
    @NamedQuery(name = "CurriculumTbl.findById", query = "SELECT c FROM CurriculumTbl c WHERE c.id = :id"),
    @NamedQuery(name = "CurriculumTbl.findByName", query = "SELECT c FROM CurriculumTbl c WHERE c.name = :name"),
    @NamedQuery(name = "CurriculumTbl.findByDescription", query = "SELECT c FROM CurriculumTbl c WHERE c.description = :description"),
    @NamedQuery(name = "CurriculumTbl.findByKeyword", query = "SELECT c FROM CurriculumTbl c WHERE c.keyword = :keyword")})
public class CurriculumTbl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(nullable = false, length = 50)
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(nullable = false, length = 250)
    private String description;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(nullable = false, length = 20)
    private String keyword;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "curriculumTbl")
    private List<CurriculumContent> curriculumContentList;

    public CurriculumTbl() {
    }

    public CurriculumTbl(Integer id) {
        this.id = id;
    }

    public CurriculumTbl(Integer id, String name, String description, String keyword) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.keyword = keyword;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    @XmlTransient
    @JsonIgnore
    public List<CurriculumContent> getCurriculumContentList() {
        return curriculumContentList;
    }

    public void setCurriculumContentList(List<CurriculumContent> curriculumContentList) {
        this.curriculumContentList = curriculumContentList;
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
        if (!(object instanceof CurriculumTbl)) {
            return false;
        }
        CurriculumTbl other = (CurriculumTbl) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sit.mysit.entity.CurriculumTbl[ id=" + id + " ]";
    }
    
}
