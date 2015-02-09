/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enteties;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @author Mohamad Bilani
 */
@Entity
@Table(name = "income_trans")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IncomeTrans.findAll", query = "SELECT i FROM IncomeTrans i"),
    @NamedQuery(name = "IncomeTrans.findByIDTrans", query = "SELECT i FROM IncomeTrans i WHERE i.iDTrans = :iDTrans"),
    @NamedQuery(name = "IncomeTrans.findByAmount", query = "SELECT i FROM IncomeTrans i WHERE i.amount = :amount"),
    @NamedQuery(name = "IncomeTrans.findByDate", query = "SELECT i FROM IncomeTrans i WHERE i.date = :date")})
public class IncomeTrans implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_Trans")
    private Integer iDTrans;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Amount")
    private int amount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @JoinColumn(name = "ID_User", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private User iDUser;
    @JoinColumn(name = "ID_Income_Type", referencedColumnName = "ID_Income")
    @ManyToOne(optional = false)
    private IncomeType iDIncomeType;

    public IncomeTrans() {
    }

    public IncomeTrans(Integer iDTrans) {
        this.iDTrans = iDTrans;
    }

    public IncomeTrans(Integer iDTrans, int amount, Date date) {
        this.iDTrans = iDTrans;
        this.amount = amount;
        this.date = date;
    }

    public Integer getIDTrans() {
        return iDTrans;
    }

    public void setIDTrans(Integer iDTrans) {
        this.iDTrans = iDTrans;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getIDUser() {
        return iDUser;
    }

    public void setIDUser(User iDUser) {
        this.iDUser = iDUser;
    }

    public IncomeType getIDIncomeType() {
        return iDIncomeType;
    }

    public void setIDIncomeType(IncomeType iDIncomeType) {
        this.iDIncomeType = iDIncomeType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDTrans != null ? iDTrans.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IncomeTrans)) {
            return false;
        }
        IncomeTrans other = (IncomeTrans) object;
        if ((this.iDTrans == null && other.iDTrans != null) || (this.iDTrans != null && !this.iDTrans.equals(other.iDTrans))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "enteties.IncomeTrans[ iDTrans=" + iDTrans + " ]";
    }
    
}
