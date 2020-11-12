package com.nsw.backend.dic.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "\"TBSDANHMUCCUAKHAU2\"", schema = "SBV")
// Define named queries here
@NamedQueries({
        @NamedQuery(name = "CmonPort.countAll", query = "SELECT COUNT(x) FROM CmonPort x")
})
public class CmonPort implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "\"FI_ID_CUA_KHAU\"", length = 20)
    private String fiIdCuaKhau;

    @Column(name = "\"FI_TEN_CUA_KHAU\"", length = 255)
    private String fiTenCuaKhau;

    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public CmonPort() {
        super();
    }

    public CmonPort(String portcode, String portname) {
        this.fiIdCuaKhau = portcode;
        this.fiTenCuaKhau = portname;
    }

    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : PortID ( NUMBER )
    public void setFiIdCuaKhau(String fiIdCuaKhau) {
        this.fiIdCuaKhau = fiIdCuaKhau;
    }

    public String getFiIdCuaKhau() {
        return this.fiIdCuaKhau;
    }

    //--- DATABASE MAPPING : PortCode ( VARCHAR2 )
    public void setFiTenCuaKhau(String fiTenCuaKhau) {
        this.fiTenCuaKhau = fiTenCuaKhau;
    }

    public String getFiTenCuaKhau() {
        return this.fiTenCuaKhau;
    }



}
