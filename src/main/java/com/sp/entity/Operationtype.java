/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sp.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Oguzhan
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Operationtype.findAll", query = "SELECT o FROM Operationtype o")
    , @NamedQuery(name = "Operationtype.findByOperationTypeid", query = "SELECT o FROM Operationtype o WHERE o.operationTypeid = :operationTypeid")
    , @NamedQuery(name = "Operationtype.findByOperationTypeName", query = "SELECT o FROM Operationtype o WHERE o.operationTypeName = :operationTypeName")})
public class Operationtype implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "operationTypeid")
    private Integer operationTypeid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "operationTypeName")
    private String operationTypeName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "operationTypeid")
    private Collection<User> userCollection;

    public Operationtype() {
    }

    public Operationtype(Integer operationTypeid) {
        this.operationTypeid = operationTypeid;
    }

    public Operationtype(Integer operationTypeid, String operationTypeName) {
        this.operationTypeid = operationTypeid;
        this.operationTypeName = operationTypeName;
    }

    public Integer getOperationTypeid() {
        return operationTypeid;
    }

    public void setOperationTypeid(Integer operationTypeid) {
        this.operationTypeid = operationTypeid;
    }

    public String getOperationTypeName() {
        return operationTypeName;
    }

    public void setOperationTypeName(String operationTypeName) {
        this.operationTypeName = operationTypeName;
    }

    @XmlTransient
    public Collection<User> getUserCollection() {
        return userCollection;
    }

    public void setUserCollection(Collection<User> userCollection) {
        this.userCollection = userCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (operationTypeid != null ? operationTypeid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Operationtype)) {
            return false;
        }
        Operationtype other = (Operationtype) object;
        if ((this.operationTypeid == null && other.operationTypeid != null) || (this.operationTypeid != null && !this.operationTypeid.equals(other.operationTypeid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sp.entity.Operationtype[ operationTypeid=" + operationTypeid + " ]";
    }
    
}
