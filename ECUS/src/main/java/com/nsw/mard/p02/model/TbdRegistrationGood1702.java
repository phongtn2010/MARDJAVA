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
public class TbdRegistrationGood1702 {

    private Long regisGood17Id;
    private Long testMethod;
    private String nswFilecode;
    private Long registrationId;
    private String totalQuantity;
    private String importGate;
    private String exportGate;
    private String executionTime;
    private String stayTime;
    private String route;
    private String attachedDoc;
    private List<TbdFromCompanyList02> ctyTu17;
    private List<TbdToCompanyList02> ctyDen17;
    private List<TbdGoods02> lstHangHoa17;

    public Long getRegisGood17Id() {
        return regisGood17Id;
    }

    public void setRegisGood17Id(Long regisGood17Id) {
        this.regisGood17Id = regisGood17Id;
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

    public String getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(String totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public String getImportGate() {
        return importGate;
    }

    public void setImportGate(String importGate) {
        this.importGate = importGate;
    }

    public String getExportGate() {
        return exportGate;
    }

    public void setExportGate(String exportGate) {
        this.exportGate = exportGate;
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

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getAttachedDoc() {
        return attachedDoc;
    }

    public void setAttachedDoc(String attachedDoc) {
        this.attachedDoc = attachedDoc;
    }

    public List<TbdFromCompanyList02> getCtyTu17() {
        return ctyTu17;
    }

    public void setCtyTu17(List<TbdFromCompanyList02> ctyTu17) {
        this.ctyTu17 = ctyTu17;
    }

    public List<TbdToCompanyList02> getCtyDen17() {
        return ctyDen17;
    }

    public void setCtyDen17(List<TbdToCompanyList02> ctyDen17) {
        this.ctyDen17 = ctyDen17;
    }

    public List<TbdGoods02> getLstHangHoa17() {
        return lstHangHoa17;
    }

    public void setLstHangHoa17(List<TbdGoods02> lstHangHoa17) {
        this.lstHangHoa17 = lstHangHoa17;
    }
}
