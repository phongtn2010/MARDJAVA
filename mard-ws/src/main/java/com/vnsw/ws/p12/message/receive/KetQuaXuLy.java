/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnsw.ws.p12.message.receive;

import com.vnsw.ws.annotations.DateSerialization;
import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Result")
public class KetQuaXuLy {

    @XmlElement(name = "NSWFileCode")
    private String NSWFileCode;

    @XmlElement(name = "Reason")
    private String Reason;

    @XmlElement(name = "ResultDate")
    @XmlJavaTypeAdapter(DateSerialization.class)
    private Date ResultDate;

    @XmlElement(name = "ReturnDate")
    @XmlJavaTypeAdapter(DateSerialization.class)
    private Date ReturnDate;

    @XmlElement(name = "Department")
    private String Department;

    @XmlElement(name = "CreaterName")
    private String CreaterName;

    @XmlElement(name = "FileName")
    private String FileName;

    @XmlElement(name = "FileByte")
    private String FileByte;

    public KetQuaXuLy() {
    }

    public KetQuaXuLy(String NSWFileCode, String Reason, Date ResultDate, Date ReturnDate, String Department, String CreaterName, String FileName, String FileByte) {
        this.NSWFileCode = NSWFileCode;
        this.Reason = Reason;
        this.ResultDate = ResultDate;
        this.ReturnDate = ReturnDate;
        this.Department = Department;
        this.CreaterName = CreaterName;
        this.FileName = FileName;
        this.FileByte = FileByte;
    }

    public String getReason() {
        return Reason;
    }

    public void setReason(String Reason) {
        this.Reason = Reason;
    }

    public Date getResultDate() {
        return ResultDate;
    }

    public void setResultDate(Date ResultDate) {
        this.ResultDate = ResultDate;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String Department) {
        this.Department = Department;
    }

    public String getCreaterName() {
        return CreaterName;
    }

    public void setCreaterName(String CreaterName) {
        this.CreaterName = CreaterName;
    }

    public String getFileName() {
        return FileName;
    }

    public void setFileName(String FileName) {
        this.FileName = FileName;
    }

    public String getFileByte() {
        return FileByte;
    }

    public void setFileByte(String FileByte) {
        this.FileByte = FileByte;
    }

    public Date getReturnDate() {
        return ReturnDate;
    }

    public void setReturnDate(Date ReturnDate) {
        this.ReturnDate = ReturnDate;
    }

    public String getNSWFileCode() {
        return NSWFileCode;
    }

    public void setNSWFileCode(String NSWFileCode) {
        this.NSWFileCode = NSWFileCode;
    }

}
