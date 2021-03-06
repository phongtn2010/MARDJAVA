/*
 * Created on 15 Apr 2019 ( Time 11:40:27 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 

package com.nsw.moh.p09.model;

import java.io.Serializable;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;

import java.util.Date;

import javax.persistence.*;

/**
 * Persistent class for entity stored in table "TBSTCKT9"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="TBSTCKT9", schema="MOH" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="Tbstckt9.countAll", query="SELECT COUNT(x) FROM Tbstckt9 x" )
} )
public class Tbstckt9 implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @Column(name="FI_ID", nullable=false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TBSTCKT9_SEQ")
    @SequenceGenerator(sequenceName = "TBSTCKT9_SEQ", schema = "MOH", initialValue = 1, allocationSize = 1, name = "TBSTCKT9_SEQ")
    private Long fiId         ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="FI_MA_TCKT", length=12)
    private String     fiMaTckt     ;

    @Column(name="FI_TEN_TCKT", length=255)
    private String     fiTenTckt    ;

    @Column(name="FI_TEN_VIETTAT", length=12)
    private String     fiTenViettat ;

    @Column(name="FI_HOATDONG")
    private Long fiHoatdong   ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="FI_NGAYTAO")
    private Date       fiNgaytao    ;



    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public Tbstckt9() {
		super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setFiId( Long fiId ) {
        this.fiId = fiId ;
    }
    public Long getFiId() {
        return this.fiId;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : FI_MA_TCKT ( VARCHAR2 ) 
    public void setFiMaTckt( String fiMaTckt ) {
        this.fiMaTckt = fiMaTckt;
    }
    public String getFiMaTckt() {
        return this.fiMaTckt;
    }

    //--- DATABASE MAPPING : FI_TEN_TCKT ( VARCHAR2 ) 
    public void setFiTenTckt( String fiTenTckt ) {
        this.fiTenTckt = fiTenTckt;
    }
    public String getFiTenTckt() {
        return this.fiTenTckt;
    }

    //--- DATABASE MAPPING : FI_TEN_VIETTAT ( VARCHAR2 ) 
    public void setFiTenViettat( String fiTenViettat ) {
        this.fiTenViettat = fiTenViettat;
    }
    public String getFiTenViettat() {
        return this.fiTenViettat;
    }

    //--- DATABASE MAPPING : FI_HOATDONG ( NUMBER ) 
    public void setFiHoatdong( Long fiHoatdong ) {
        this.fiHoatdong = fiHoatdong;
    }
    public Long getFiHoatdong() {
        return this.fiHoatdong;
    }

    //--- DATABASE MAPPING : FI_NGAYTAO ( TIMESTAMP(6) ) 
    public void setFiNgaytao( Date fiNgaytao ) {
        this.fiNgaytao = fiNgaytao;
    }
    public Date getFiNgaytao() {
        return this.fiNgaytao;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(fiId);
        sb.append("]:"); 
        sb.append(fiMaTckt);
        sb.append("|");
        sb.append(fiTenTckt);
        sb.append("|");
        sb.append(fiTenViettat);
        sb.append("|");
        sb.append(fiHoatdong);
        sb.append("|");
        sb.append(fiNgaytao);
        return sb.toString(); 
    } 

}
