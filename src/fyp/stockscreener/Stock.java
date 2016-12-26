/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fyp.stockscreener;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Lim
 */
@Entity
@Table(name = "stock", catalog = "fyp", schema = "")
@NamedQueries({
    @NamedQuery(name = "Stock.findAll", query = "SELECT s FROM Stock s"),
    @NamedQuery(name = "Stock.findByStockSymbol", query = "SELECT s FROM Stock s WHERE s.stockSymbol = :stockSymbol"),
    @NamedQuery(name = "Stock.findByStockBGF", query = "SELECT s FROM Stock s WHERE s.stockBGF = :stockBGF"),
    @NamedQuery(name = "Stock.findByStockCode", query = "SELECT s FROM Stock s WHERE s.stockCode = :stockCode"),
    @NamedQuery(name = "Stock.findByStockDCF", query = "SELECT s FROM Stock s WHERE s.stockDCF = :stockDCF"),
    @NamedQuery(name = "Stock.findByStockDEM", query = "SELECT s FROM Stock s WHERE s.stockDEM = :stockDEM"),
    @NamedQuery(name = "Stock.findByStockGGM", query = "SELECT s FROM Stock s WHERE s.stockGGM = :stockGGM"),
    @NamedQuery(name = "Stock.findByStockGrowth", query = "SELECT s FROM Stock s WHERE s.stockGrowth = :stockGrowth"),
    @NamedQuery(name = "Stock.findByStockHigh", query = "SELECT s FROM Stock s WHERE s.stockHigh = :stockHigh"),
    @NamedQuery(name = "Stock.findByStockLast", query = "SELECT s FROM Stock s WHERE s.stockLast = :stockLast"),
    @NamedQuery(name = "Stock.findByStockLow", query = "SELECT s FROM Stock s WHERE s.stockLow = :stockLow"),
    @NamedQuery(name = "Stock.findByStockName", query = "SELECT s FROM Stock s WHERE s.stockName = :stockName"),
    @NamedQuery(name = "Stock.findByStockPrev", query = "SELECT s FROM Stock s WHERE s.stockPrev = :stockPrev")})
public class Stock implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Stock_Symbol")
    private String stockSymbol;
    @Column(name = "Stock_BGF")
    private BigInteger stockBGF;
    @Column(name = "Stock_Code")
    private String stockCode;
    @Column(name = "Stock_DCF")
    private BigInteger stockDCF;
    @Column(name = "Stock_DEM")
    private BigInteger stockDEM;
    @Column(name = "Stock_GGM")
    private BigInteger stockGGM;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Stock_Growth")
    private Float stockGrowth;
    @Column(name = "Stock_High")
    private Float stockHigh;
    @Column(name = "Stock_Last")
    private Float stockLast;
    @Column(name = "Stock_Low")
    private Float stockLow;
    @Column(name = "Stock_Name")
    private String stockName;
    @Column(name = "Stock_Prev")
    private Float stockPrev;

    public Stock() {
    }

    public Stock(String stockSymbol) {
        this.stockSymbol = stockSymbol;
    }

    public String getStockSymbol() {
        return stockSymbol;
    }

    public void setStockSymbol(String stockSymbol) {
        String oldStockSymbol = this.stockSymbol;
        this.stockSymbol = stockSymbol;
        changeSupport.firePropertyChange("stockSymbol", oldStockSymbol, stockSymbol);
    }

    public BigInteger getStockBGF() {
        return stockBGF;
    }

    public void setStockBGF(BigInteger stockBGF) {
        BigInteger oldStockBGF = this.stockBGF;
        this.stockBGF = stockBGF;
        changeSupport.firePropertyChange("stockBGF", oldStockBGF, stockBGF);
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        String oldStockCode = this.stockCode;
        this.stockCode = stockCode;
        changeSupport.firePropertyChange("stockCode", oldStockCode, stockCode);
    }

    public BigInteger getStockDCF() {
        return stockDCF;
    }

    public void setStockDCF(BigInteger stockDCF) {
        BigInteger oldStockDCF = this.stockDCF;
        this.stockDCF = stockDCF;
        changeSupport.firePropertyChange("stockDCF", oldStockDCF, stockDCF);
    }

    public BigInteger getStockDEM() {
        return stockDEM;
    }

    public void setStockDEM(BigInteger stockDEM) {
        BigInteger oldStockDEM = this.stockDEM;
        this.stockDEM = stockDEM;
        changeSupport.firePropertyChange("stockDEM", oldStockDEM, stockDEM);
    }

    public BigInteger getStockGGM() {
        return stockGGM;
    }

    public void setStockGGM(BigInteger stockGGM) {
        BigInteger oldStockGGM = this.stockGGM;
        this.stockGGM = stockGGM;
        changeSupport.firePropertyChange("stockGGM", oldStockGGM, stockGGM);
    }

    public Float getStockGrowth() {
        return stockGrowth;
    }

    public void setStockGrowth(Float stockGrowth) {
        Float oldStockGrowth = this.stockGrowth;
        this.stockGrowth = stockGrowth;
        changeSupport.firePropertyChange("stockGrowth", oldStockGrowth, stockGrowth);
    }

    public Float getStockHigh() {
        return stockHigh;
    }

    public void setStockHigh(Float stockHigh) {
        Float oldStockHigh = this.stockHigh;
        this.stockHigh = stockHigh;
        changeSupport.firePropertyChange("stockHigh", oldStockHigh, stockHigh);
    }

    public Float getStockLast() {
        return stockLast;
    }

    public void setStockLast(Float stockLast) {
        Float oldStockLast = this.stockLast;
        this.stockLast = stockLast;
        changeSupport.firePropertyChange("stockLast", oldStockLast, stockLast);
    }

    public Float getStockLow() {
        return stockLow;
    }

    public void setStockLow(Float stockLow) {
        Float oldStockLow = this.stockLow;
        this.stockLow = stockLow;
        changeSupport.firePropertyChange("stockLow", oldStockLow, stockLow);
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        String oldStockName = this.stockName;
        this.stockName = stockName;
        changeSupport.firePropertyChange("stockName", oldStockName, stockName);
    }

    public Float getStockPrev() {
        return stockPrev;
    }

    public void setStockPrev(Float stockPrev) {
        Float oldStockPrev = this.stockPrev;
        this.stockPrev = stockPrev;
        changeSupport.firePropertyChange("stockPrev", oldStockPrev, stockPrev);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stockSymbol != null ? stockSymbol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stock)) {
            return false;
        }
        Stock other = (Stock) object;
        if ((this.stockSymbol == null && other.stockSymbol != null) || (this.stockSymbol != null && !this.stockSymbol.equals(other.stockSymbol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fyp.stockscreener.Stock[ stockSymbol=" + stockSymbol + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
