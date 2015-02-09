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
@Table(name = "income_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IncomeType.findAll", query = "SELECT i FROM IncomeType i"),
    @NamedQuery(name = "IncomeType.findByIDIncome", query = "SELECT i FROM IncomeType i WHERE i.iDIncome = :iDIncome"),
    @NamedQuery(name = "IncomeType.findByIncomeDesc", query = "SELECT i FROM IncomeType i WHERE i.incomeDesc = :incomeDesc")})
public class IncomeType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_Income")
    private Integer iDIncome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Income_Desc")
    private String incomeDesc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iDIncomeType")
    private Collection<IncomeTrans> incomeTransCollection;

    public IncomeType() {
    }

    public IncomeType(Integer iDIncome) {
        this.iDIncome = iDIncome;
    }

    public IncomeType(Integer iDIncome, String incomeDesc) {
        this.iDIncome = iDIncome;
        this.incomeDesc = incomeDesc;
    }

    public Integer getIDIncome() {
        return iDIncome;
    }

    public void setIDIncome(Integer iDIncome) {
        this.iDIncome = iDIncome;
    }

    public String getIncomeDesc() {
        return incomeDesc;
    }

    public void setIncomeDesc(String incomeDesc) {
        this.incomeDesc = incomeDesc;
    }

    @XmlTransient
    public Collection<IncomeTrans> getIncomeTransCollection() {
        return incomeTransCollection;
    }

    public void setIncomeTransCollection(Collection<IncomeTrans> incomeTransCollection) {
        this.incomeTransCollection = incomeTransCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDIncome != null ? iDIncome.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IncomeType)) {
            return false;
        }
        IncomeType other = (IncomeType) object;
        if ((this.iDIncome == null && other.iDIncome != null) || (this.iDIncome != null && !this.iDIncome.equals(other.iDIncome))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "enteties.IncomeType[ iDIncome=" + iDIncome + " ]";
    }
    
}
