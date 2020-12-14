/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.mard.p02.model;

import java.util.List;

/**
 * @author Fujitsu
 */
public class TbdRegistrationGood1802 {

    private Long regisGood18Id;
    private Long testMethod;
    private String nswFilecode;
    private Long registrationId;
    private String importGate;
    private String purpose;
    private String executionTime;
    private String stayTime;
    private String attachedDoc;
    private String exportGate;
    private Long isActive;
    private String totalQuantity;
    private String route;
    private List<TbdFromCompanyList02> ctyTu18;
    private List<TbdToCompanyList02> ctyDen18;
    private List<TbdGoods02> lstHangHoa18;
    private List<TbdBondedList02> lstNgoaiQuan18;

    public Long getRegisGood18Id() {
        return regisGood18Id;
    }

    public void setRegisGood18Id(Long regisGood18Id) {
        this.regisGood18Id = regisGood18Id;
    }

    public Long getTestMethod() {
        return testMethod;
    }

    public void setTestMethod(Long testMethod) {
        this.testMethod = testMethod;
    }

    public String getNswFilecode() {
        return nswFilecode;
    }

    public void setNswFilecode(String nswFilecode) {
        this.nswFilecode = nswFilecode;
    }

    public Long getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(Long registrationId) {
        this.registrationId = registrationId;
    }

    public String getImportGate() {
        return importGate;
    }

    public void setImportGate(String importGate) {
        this.importGate = importGate;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(String executionTime) {
        this.executionTime = executionTime;
    }

    public String getStayTime() {
        return stayTime;
    }

    public void setStayTime(String stayTime) {
        this.stayTime = stayTime;
    }

    public String getAttachedDoc() {
        return attachedDoc;
    }

    public void setAttachedDoc(String attachedDoc) {
        this.attachedDoc = attachedDoc;
    }

    public String getExportGate() {
        return exportGate;
    }

    public void setExportGate(String exportGate) {
        this.exportGate = exportGate;
    }

    public Long getIsActive() {
        return isActive;
    }

    public void setIsActive(Long isActive) {
        this.isActive = isActive;
    }

    public String getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(String totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public List<TbdFromCompanyList02> getCtyTu18() {
        return ctyTu18;
    }

    public void setCtyTu18(List<TbdFromCompanyList02> ctyTu18) {
        this.ctyTu18 = ctyTu18;
    }

    public List<TbdToCompanyList02> getCtyDen18() {
        return ctyDen18;
    }

    public void setCtyDen18(List<TbdToCompanyList02> ctyDen18) {
        this.ctyDen18 = ctyDen18;
    }

    public List<TbdGoods02> getLstHangHoa18() {
        return lstHangHoa18;
    }

    public void setLstHangHoa18(List<TbdGoods02> lstHangHoa18) {
        this.lstHangHoa18 = lstHangHoa18;
    }

    public List<TbdBondedList02> getLstNgoaiQuan18() {
        return lstNgoaiQuan18;
    }

    public void setLstNgoaiQuan18(List<TbdBondedList02> lstNgoaiQuan18) {
        this.lstNgoaiQuan18 = lstNgoaiQuan18;
    }
}
