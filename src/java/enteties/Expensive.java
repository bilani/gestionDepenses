/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enteties;

import java.io.Serializable;
import java.util.Collection;
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

/**
 *
 * @author Mohamad Bilani
 */
@Entity
@Table(name = "expensive")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Expensive.findAll", query = "SELECT e FROM Expensive e"),
    @NamedQuery(name = "Expensive.findByExpID", query = "SELECT e FROM Expensive e WHERE e.expID = :expID"),
    @NamedQuery(name = "Expensive.findByExpDesc", query = "SELECT e FROM Expensive e WHERE e.expDesc = :expDesc")})
public class Expensive implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Exp_ID")
    private Integer expID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Exp_Desc")
    private String expDesc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iDExpens")
    private Collection<Transaction> transactionCollection;

    public Expensive() {
    }

    public Expensive(Integer expID) {
        this.expID = expID;
    }

    public Expensive(Integer expID, String expDesc) {
        this.expID = expID;
        this.expDesc = expDesc;
    }

    public Integer getExpID() {
        return expID;
    }

    public void setExpID(Integer expID) {
        this.expID = expID;
    }

    public String getExpDesc() {
        return expDesc;
    }

    public void setExpDesc(String expDesc) {
        this.expDesc = expDesc;
    }

    @XmlTransient
    public Collection<Transaction> getTransactionCollection() {
        return transactionCollection;
    }

    public void setTransactionCollection(Collection<Transaction> transactionCollection) {
        this.transactionCollection = transactionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (expID != null ? expID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Expensive)) {
            return false;
        }
        Expensive other = (Expensive) object;
        if ((this.expID == null && other.expID != null) || (this.expID != null && !this.expID.equals(other.expID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "enteties.Expensive[ expID=" + expID + " ]";
    }
    
}
