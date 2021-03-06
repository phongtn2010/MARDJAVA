/*
 * Created on 25 Jul 2017 ( Time 08:15:33 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 
package com.nsw.backend.dic.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Persistent class for entity stored in table "CMON_ATTACHTYPE"
 *
 * @author Telosys Tools Generator
 *
 */
@Entity
@Table(name = "\"Cmon_AttachType\"", schema = "MARD")
// Define named queries here
@NamedQueries({
    @NamedQuery(name = "CmonAttachtype.countAll", query = "SELECT COUNT(x) FROM CmonAttachtype x")
})
public class CmonAttachtype implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "\"ID\"")
    private Long id;
    
    @Column(name = "\"AttachTypeId\"")
    private Long attachtypeid;

    @Column(name = "\"AttachTypeCode\"", length = 20)
    private String attachtypecode;

    @Column(name = "\"AttachTypeName\"")
    private String attachtypename;

    @Column(name = "\"LfdkType\"")
    private Long lfdktype;

    @Column(name = "\"SystemID\"")
    private Long systemid;

    public CmonAttachtype() {
        super();
    }

    public void setAttachtypeid(Long attachtypeid) {
        this.attachtypeid = attachtypeid;
    }

    public Long getAttachtypeid() {
        return this.attachtypeid;
    }

    //--- DATABASE MAPPING : AttachTypeCode ( VARCHAR2 ) 
    public void setAttachtypecode(String attachtypecode) {
        this.attachtypecode = attachtypecode;
    }

    public String getAttachtypecode() {
        return this.attachtypecode;
    }

    //--- DATABASE MAPPING : AttachTypeName ( NVARCHAR2 ) 
    public void setAttachtypename(String attachtypename) {
        this.attachtypename = attachtypename;
    }

    public String getAttachtypename() {
        return this.attachtypename;
    }

    //--- DATABASE MAPPING : LfdkType ( NUMBER ) 
    public void setLfdktype(Long lfdktype) {
        this.lfdktype = lfdktype;
    }

    public Long getLfdktype() {
        return this.lfdktype;
    }

    //--- DATABASE MAPPING : SystemID ( NUMBER ) 
    public void setSystemid(Long systemid) {
        this.systemid = systemid;
    }

    public Long getSystemid() {
        return this.systemid;
    }

    //--- DATABASE MAPPING : ID ( NUMBER ) 
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
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
        sb.append(attachtypeid);
        sb.append("|");
        sb.append(attachtypecode);
        sb.append("|");
        sb.append(attachtypename);
        sb.append("|");
        sb.append(lfdktype);
        sb.append("|");
        sb.append(systemid);
        sb.append("|");
        sb.append(id);
        return sb.toString();
    }

}
