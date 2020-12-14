package com.nsw.common.model;


import java.util.Date;

public class Unit{
    
    private Long unitid;

    private Long categoryid;

    private String name;

    private String unitcode;

    private Date modifieddate;

    private String isdelete;

    private Long role;

    private String stdcode;

    private Long epsilon;

    public Unit() {
        super();
    }

    public void setUnitid(Long unitid) {
        this.unitid = unitid;
    }

    public Long getUnitid() {
        return this.unitid;
    }

    //--- DATABASE MAPPING : CATEGORYID ( NUMBER ) 
    public void setCategoryid(Long categoryid) {
        this.categoryid = categoryid;
    }

    public Long getCategoryid() {
        return this.categoryid;
    }

    //--- DATABASE MAPPING : NAME ( NVARCHAR2 ) 
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    //--- DATABASE MAPPING : UNITCODE ( NVARCHAR2 ) 
    public void setUnitcode(String unitcode) {
        this.unitcode = unitcode;
    }

    public String getUnitcode() {
        return this.unitcode;
    }

    //--- DATABASE MAPPING : MODIFIEDDATE ( DATE ) 
    public void setModifieddate(Date modifieddate) {
        this.modifieddate = modifieddate;
    }

    public Date getModifieddate() {
        return this.modifieddate;
    }

    //--- DATABASE MAPPING : ISDELETE ( CHAR ) 
    public void setIsdelete(String isdelete) {
        this.isdelete = isdelete;
    }

    public String getIsdelete() {
        return this.isdelete;
    }

    //--- DATABASE MAPPING : ROLE ( NUMBER ) 
    public void setRole(Long role) {
        this.role = role;
    }

    public Long getRole() {
        return this.role;
    }

    //--- DATABASE MAPPING : STDCODE ( CHAR ) 
    public void setStdcode(String stdcode) {
        this.stdcode = stdcode;
    }

    public String getStdcode() {
        return this.stdcode;
    }

    //--- DATABASE MAPPING : EPSILON ( NUMBER ) 
    public void setEpsilon(Long epsilon) {
        this.epsilon = epsilon;
    }

    public Long getEpsilon() {
        return this.epsilon;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        sb.append("]:");
        sb.append(unitid);
        sb.append("|");
        sb.append(categoryid);
        sb.append("|");
        sb.append(name);
        sb.append("|");
        sb.append(unitcode);
        sb.append("|");
        sb.append(modifieddate);
        sb.append("|");
        sb.append(isdelete);
        sb.append("|");
        sb.append(role);
        sb.append("|");
        sb.append(stdcode);
        sb.append("|");
        sb.append(epsilon);
        return sb.toString();
    }

}
