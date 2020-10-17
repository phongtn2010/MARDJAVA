package com.vnsw.ws.p11.envelop;

import com.vnsw.ws.p11.entity.db.Tbdhoso11;
import com.vnsw.ws.p11.message.receive.PhytosanitaryCer;
import com.vnsw.ws.p11.message.receive.PhytosanitaryCerInfoRequest;
import com.vnsw.ws.p11.message.receive.PhytosanitaryFee;
import com.vnsw.ws.p11.message.receive.PhytosanitaryFeeResponse;
import com.vnsw.ws.p11.message.receive.PhytosanitaryProcess;
import com.vnsw.ws.p11.message.receive.PhytosanitaryResponseCancel;
import com.vnsw.ws.p11.message.receive.PhytosanitaryResponseEdit;
import com.vnsw.ws.p11.message.receive.PhytosanitaryResponseEditCer;
import com.vnsw.ws.p11.message.receive.PhytosanitaryResult;
import com.vnsw.ws.p11.message.send.PhytosanitaryCerInfo;
import com.vnsw.ws.p11.message.send.PhytosanitaryFeeRequest;
import com.vnsw.ws.p11.message.send.PhytosanitaryRequestCancel;
import com.vnsw.ws.p11.message.send.PhytosanitaryRequestEditCer;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Content")
public class Content11 {

    @XmlElementWrapper(name = "ErrorList")
    @XmlElement(name = "Error")
    protected List<Error11> ErrorList;
    
    @XmlElement(name = "ReceiveDate")
    protected String receiveDate;
    
    // Ho so moi
    @XmlElement(name = "Phytosanitary") 
    protected Tbdhoso11  tbdhoso11 ;

    @XmlElement(name = "PhytosanitaryRequestCancel")
    protected PhytosanitaryRequestCancel  phytosanitaryRequestCancel ;
   
    @XmlElement(name = "PhytosanitaryFee")
    protected PhytosanitaryFee  phytosanitaryFee;
    
    @XmlElement(name = "PhytosanitaryFeeRequest")
    protected PhytosanitaryFeeRequest  phytosanitaryFeeRequest;
    
    @XmlElement(name = "PhytosanitaryCerInfo")
    protected PhytosanitaryCerInfo phytosanitaryCerInfo;
    
    @XmlElement(name = "PhytosanitaryRequestEditCer")
    protected PhytosanitaryRequestEditCer phytosanitaryRequestEditCer;
    
    @XmlElement(name = "PhytosanitaryResult")
    protected PhytosanitaryResult phytosanitaryResult;
    
    @XmlElement(name = "PhytosanitaryResponseEdit")
    protected PhytosanitaryResponseEdit phytosanitaryResponseEdit;

    @XmlElement(name = "PhytosanitaryResponseCancel")
    protected PhytosanitaryResponseCancel phytosanitaryResponseCancel;
    
    @XmlElement(name = "PhytosanitaryFeeResponse")
    protected PhytosanitaryFeeResponse phytosanitaryFeeResponse;
    
    @XmlElement(name = "PhytosanitaryCer")
    protected PhytosanitaryCer phytosanitaryCer;
    
    @XmlElement(name = "PhytosanitaryCerInfoRequest")
    protected PhytosanitaryCerInfoRequest phytosanitaryCerInfoRequest;
    
    @XmlElement(name = "PhytosanitaryResponseEditCer")
    protected PhytosanitaryResponseEditCer phytosanitaryResponseEditCer;
    
    @XmlElement(name = "PhytosanitaryProcess")
    protected PhytosanitaryProcess phytosanitaryProcess;
    
    public Content11() {
    }

    public Content11(List<Error11> ErrorList, String receiveDate, Tbdhoso11 tbdhoso11, PhytosanitaryRequestCancel phytosanitaryRequestCancel, PhytosanitaryFee phytosanitaryFee, PhytosanitaryCerInfo phytosanitaryCerInfo, PhytosanitaryRequestEditCer phytosanitaryRequestEditCer) {
        this.ErrorList = ErrorList;
        this.receiveDate = receiveDate;
        this.tbdhoso11 = tbdhoso11;
        this.phytosanitaryRequestCancel = phytosanitaryRequestCancel;
        this.phytosanitaryFee = phytosanitaryFee;
        this.phytosanitaryCerInfo = phytosanitaryCerInfo;
        this.phytosanitaryRequestEditCer = phytosanitaryRequestEditCer;
    }

    public List<Error11> getErrorList() {
        return ErrorList;
    }

    public void setErrorList(List<Error11> ErrorList) {
        this.ErrorList = ErrorList;
    }

    public String getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(String receiveDate) {
        this.receiveDate = receiveDate;
    }

    public Tbdhoso11 getTbdhoso11() {
        return tbdhoso11;
    }

    public void setTbdhoso11(Tbdhoso11 tbdhoso11) {
        this.tbdhoso11 = tbdhoso11;
    }

    public PhytosanitaryRequestCancel getPhytosanitaryRequestCancel() {
        return phytosanitaryRequestCancel;
    }

    public void setPhytosanitaryRequestCancel(PhytosanitaryRequestCancel phytosanitaryRequestCancel) {
        this.phytosanitaryRequestCancel = phytosanitaryRequestCancel;
    }

    public PhytosanitaryFee getPhytosanitaryFee() {
        return phytosanitaryFee;
    }

    public void setPhytosanitaryFee(PhytosanitaryFee phytosanitaryFee) {
        this.phytosanitaryFee = phytosanitaryFee;
    }

    public PhytosanitaryCerInfo getPhytosanitaryCerInfo() {
        return phytosanitaryCerInfo;
    }

    public void setPhytosanitaryCerInfo(PhytosanitaryCerInfo phytosanitaryCerInfo) {
        this.phytosanitaryCerInfo = phytosanitaryCerInfo;
    }

    public PhytosanitaryRequestEditCer getPhytosanitaryRequestEditCer() {
        return phytosanitaryRequestEditCer;
    }

    public void setPhytosanitaryRequestEditCer(PhytosanitaryRequestEditCer phytosanitaryRequestEditCer) {
        this.phytosanitaryRequestEditCer = phytosanitaryRequestEditCer;
    }

    public PhytosanitaryResult getPhytosanitaryResult() {
        return phytosanitaryResult;
    }

    public void setPhytosanitaryResult(PhytosanitaryResult phytosanitaryResult) {
        this.phytosanitaryResult = phytosanitaryResult;
    }

    public PhytosanitaryResponseEdit getPhytosanitaryResponseEdit() {
        return phytosanitaryResponseEdit;
    }

    public void setPhytosanitaryResponseEdit(PhytosanitaryResponseEdit phytosanitaryResponseEdit) {
        this.phytosanitaryResponseEdit = phytosanitaryResponseEdit;
    }

    public PhytosanitaryResponseCancel getPhytosanitaryResponseCancel() {
        return phytosanitaryResponseCancel;
    }

    public void setPhytosanitaryResponseCancel(PhytosanitaryResponseCancel phytosanitaryResponseCancel) {
        this.phytosanitaryResponseCancel = phytosanitaryResponseCancel;
    }

    public PhytosanitaryFeeResponse getPhytosanitaryFeeResponse() {
        return phytosanitaryFeeResponse;
    }

    public void setPhytosanitaryFeeResponse(PhytosanitaryFeeResponse phytosanitaryFeeResponse) {
        this.phytosanitaryFeeResponse = phytosanitaryFeeResponse;
    }

    public PhytosanitaryCer getPhytosanitaryCer() {
        return phytosanitaryCer;
    }

    public void setPhytosanitaryCer(PhytosanitaryCer phytosanitaryCer) {
        this.phytosanitaryCer = phytosanitaryCer;
    }

    public PhytosanitaryCerInfoRequest getPhytosanitaryCerInfoRequest() {
        return phytosanitaryCerInfoRequest;
    }

    public void setPhytosanitaryCerInfoRequest(PhytosanitaryCerInfoRequest phytosanitaryCerInfoRequest) {
        this.phytosanitaryCerInfoRequest = phytosanitaryCerInfoRequest;
    }

    public PhytosanitaryResponseEditCer getPhytosanitaryResponseEditCer() {
        return phytosanitaryResponseEditCer;
    }

    public void setPhytosanitaryResponseEditCer(PhytosanitaryResponseEditCer phytosanitaryResponseEditCer) {
        this.phytosanitaryResponseEditCer = phytosanitaryResponseEditCer;
    }

    public PhytosanitaryProcess getPhytosanitaryProcess() {
        return phytosanitaryProcess;
    }

    public void setPhytosanitaryProcess(PhytosanitaryProcess phytosanitaryProcess) {
        this.phytosanitaryProcess = phytosanitaryProcess;
    }

    public PhytosanitaryFeeRequest getPhytosanitaryFeeRequest() {
        return phytosanitaryFeeRequest;
    }

    public void setPhytosanitaryFeeRequest(PhytosanitaryFeeRequest phytosanitaryFeeRequest) {
        this.phytosanitaryFeeRequest = phytosanitaryFeeRequest;
    }
}
