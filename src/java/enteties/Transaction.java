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
 * @author Mohamad Bilani
 */
@Entity
@Table(name = "transaction")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transaction.findAll", query = "SELECT t FROM Transaction t"),
    @NamedQuery(name = "Transaction.findByIDTrans", query = "SELECT t FROM Transaction t WHERE t.iDTrans = :iDTrans"),
    @NamedQuery(name = "Transaction.findByAmount", query = "SELECT t FROM Transaction t WHERE t.amount = :amount"),
    @NamedQuery(name = "Transaction.findByDate", query = "SELECT t FROM Transaction t WHERE t.date = :date")})
public class Transaction implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
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
    @JoinColumn(name = "ID_user", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private User iDuser;
    @JoinColumn(name = "ID_Expens", referencedColumnName = "Exp_ID")
    @ManyToOne(optional = false)
    private Expensive iDExpens;

    public Transaction() {
    }

    public Transaction(Integer iDTrans) {
        this.iDTrans = iDTrans;
    }

    public Transaction(Integer iDTrans, int amount, Date date) {
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

    public User getIDuser() {
        return iDuser;
    }

    public void setIDuser(User iDuser) {
        this.iDuser = iDuser;
    }

    public Expensive getIDExpens() {
        return iDExpens;
    }

    public void setIDExpens(Expensive iDExpens) {
        this.iDExpens = iDExpens;
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
        if (!(object instanceof Transaction)) {
            return false;
        }
        Transaction other = (Transaction) object;
        if ((this.iDTrans == null && other.iDTrans != null) || (this.iDTrans != null && !this.iDTrans.equals(other.iDTrans))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "enteties.Transaction[ iDTrans=" + iDTrans + " ]";
    }
    
}
