/*
 * Created on 25 Jul 2017 ( Time 08:16:29 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 
package com.nsw.backend.dic.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Persistent class for entity stored in table "CMON_PAYMENTTYPE"
 *
 * @author Telosys Tools Generator
 *
 */
@Entity
@Table(name = "\"Cmon_PaymentType\"", schema = "MARD")
// Define named queries here
@NamedQueries({
    @NamedQuery(name = "CmonPaymenttype.countAll", query = "SELECT COUNT(x) FROM CmonPaymenttype x")
})
public class CmonPaymenttype implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "\"PaymentTypeID\"")
    private Long paymenttypeid;

    @Column(name = "\"PaymentTypeName\"")
    private String paymenttypename;

    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public CmonPaymenttype() {
        super();
    }

    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : PaymentTypeID ( NUMBER ) 
    public void setPaymenttypeid(Long paymenttypeid) {
        this.paymenttypeid = paymenttypeid;
    }

    public Long getPaymenttypeid() {
        return this.paymenttypeid;
    }

    //--- DATABASE MAPPING : PaymentTypeName ( NVARCHAR2 ) 
    public void setPaymenttypename(String paymenttypename) {
        this.paymenttypename = paymenttypename;
    }

    public String getPaymenttypename() {
        return this.paymenttypename;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append("]:");
        sb.append(paymenttypeid);
        sb.append("|");
        sb.append(paymenttypename);
        return sb.toString();
    }

}
