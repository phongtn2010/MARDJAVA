package com.nsw.common.model;

import java.util.Date;

public class State {
    private Long stateid;
    private String statecode;
    private String name;
    private Date modifieddate;
    private String isdelete;
    private Long role;
    private String description;
    private String namevi;
    
    public State() {
        super();
    }
    
    public void setStateid(Long stateid) {
        this.stateid = stateid;
    }

    public Long getStateid() {
        return this.stateid;
    }
    
    public void setStatecode(String statecode) {
        this.statecode = statecode;
    }

    public String getStatecode() {
        return this.statecode;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    
    public void setModifieddate(Date modifieddate) {
        this.modifieddate = modifieddate;
    }

    public Date getModifieddate() {
        return this.modifieddate;
    }
    
    public void setIsdelete(String isdelete) {
        this.isdelete = isdelete;
    }

    public String getIsdelete() {
        return this.isdelete;
    }
     
    public void setRole(Long role) {
        this.role = role;
    }

    public Long getRole() {
        return this.role;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
    
    public void setNamevi(String namevi) {
        this.namevi = namevi;
    }

    public String getNamevi() {
        return this.namevi;
    }
    
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        sb.append("]:");
        sb.append(stateid);
        sb.append("|");
        sb.append(statecode);
        sb.append("|");
        sb.append(name);
        sb.append("|");
        sb.append(modifieddate);
        sb.append("|");
        sb.append(isdelete);
        sb.append("|");
        sb.append(role);
        sb.append("|");
        sb.append(description);
        sb.append("|");
        sb.append(namevi);
        return sb.toString();
    }
}
