package com.vnsw.ws.p10.envelop;

import com.vnsw.ws.p10.entity.db.Tbdhoso10;
import com.vnsw.ws.p10.message.receive.AnimalIsolationList;
import com.vnsw.ws.p10.message.receive.AnimalProcessed;
import com.vnsw.ws.p10.message.receive.AnimalProductsIsolationList;
import com.vnsw.ws.p10.message.receive.AnimalQuarantineList;
import com.vnsw.ws.p10.message.receive.FoodAnimalQuarantineList;
import com.vnsw.ws.p10.message.receive.ProcessVSTYList;
import com.vnsw.ws.p10.message.receive.ProductAnimalQuarantineList;
import com.vnsw.ws.p10.message.receive.QuarantineCancelResponse;
import com.vnsw.ws.p10.message.receive.QuarantineCerEditResponse;
import com.vnsw.ws.p10.message.receive.QuarantineCerEditResponseList;
import com.vnsw.ws.p10.message.receive.QuarantineEditResponse;
import com.vnsw.ws.p10.message.receive.QuarantineFee;
import com.vnsw.ws.p10.message.receive.QuarantineFeeResponse;
import com.vnsw.ws.p10.message.receive.QuarantineResult;
import com.vnsw.ws.p10.message.receive.RegistrationList;
import com.vnsw.ws.p10.message.send.QuarantineCancel;
import com.vnsw.ws.p10.message.send.QuarantineFeeRequest;
import com.vnsw.ws.p10.message.send.RegistrationCerEdit;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Content")
public class Content10 {

    @XmlElementWrapper(name = "ErrorList")
    @XmlElement(name = "Error")
    protected List<Error10> ErrorList;
    
    @XmlElement(name = "ReceiveDate")
    protected String receiveDate;
    
    // Ho so moi
    @XmlElement(name = "Registration") 
    protected Tbdhoso10  tbdhoso10 ;

    @XmlElement(name = "QuarantineResult")
    protected QuarantineResult  quarantineResult ;
    
    @XmlElement(name = "RegistrationList")
    protected RegistrationList  registrationList ;
    
    @XmlElement(name = "QuarantineFee")
    protected QuarantineFee  quarantineFee ;
    
    @XmlElement(name = "QuarantineFeeRequest")
    protected QuarantineFeeRequest  quarantineFeeRequest ;
    
    @XmlElement(name = "QuarantineFeeResponse")
    protected QuarantineFeeResponse  quarantineFeeResponse ;
    
    @XmlElement(name = "AnimalProcessed")
    protected AnimalProcessed  animalProcessed;
    
    @XmlElement(name = "QuarantineCancel")
    protected QuarantineCancel  quarantineCancel;
    
    @XmlElement(name = "QuarantineCancelResponse")
    protected QuarantineCancelResponse  quarantineCancelResponse;
    
    @XmlElement(name = "QuarantineEditResponse")
    protected QuarantineEditResponse  quarantineEditResponse;
    
    @XmlElement(name = "ProcessVSTYList")
    protected ProcessVSTYList  processVSTYList;
    
    @XmlElement(name = "AnimalIsolationList")
    protected AnimalIsolationList  animalIsolationList;
    
    @XmlElement(name = "AnimalProductsIsolationList")
    protected AnimalProductsIsolationList  animalProductsIsolationList;

    @XmlElement(name = "AnimalQuarantineList")
    protected AnimalQuarantineList  animalQuarantineList;    
    
    @XmlElement(name = "ProductAnimalQuarantineList")
    protected ProductAnimalQuarantineList  productAnimalQuarantineList;   
    
    @XmlElement(name = "FoodAnimalQuarantineList")
    protected FoodAnimalQuarantineList  foodAnimalQuarantineList; 
    
    @XmlElement(name = "RegistrationCerEdit")
    protected RegistrationCerEdit  registrationCerEdit; 
    
    @XmlElement(name = "QuarantineCerEditResponseList")
    protected QuarantineCerEditResponseList  quarantineCerEditResponseList; 

    public Content10() {
    }

    public Content10(List<Error10> ErrorList, String receiveDate, Tbdhoso10  tbdhoso10, QuarantineResult quarantineResult, RegistrationList registrationList, QuarantineFee quarantineFee, QuarantineFeeRequest quarantineFeeRequest, QuarantineFeeResponse quarantineFeeResponse, AnimalProcessed animalProcessed, QuarantineCancel quarantineCancel, QuarantineCancelResponse quarantineCancelResponse, QuarantineEditResponse quarantineEditResponse, ProcessVSTYList processVSTYList, AnimalIsolationList animalIsolationList, AnimalProductsIsolationList animalProductsIsolationList, AnimalQuarantineList animalQuarantineList, ProductAnimalQuarantineList productAnimalQuarantineList, FoodAnimalQuarantineList foodAnimalQuarantineList, RegistrationCerEdit registrationCerEdit, QuarantineCerEditResponseList quarantineCerEditResponseList) {
        this.ErrorList = ErrorList;
        this.receiveDate = receiveDate;
        this.tbdhoso10 = tbdhoso10;
        this.quarantineResult = quarantineResult;
        this.registrationList = registrationList;
        this.quarantineFee = quarantineFee;
        this.quarantineFeeRequest = quarantineFeeRequest;
        this.quarantineFeeResponse = quarantineFeeResponse;
        this.animalProcessed = animalProcessed;
        this.quarantineCancel = quarantineCancel;
        this.quarantineCancelResponse = quarantineCancelResponse;
        this.quarantineEditResponse = quarantineEditResponse;
        this.processVSTYList = processVSTYList;
        this.animalIsolationList = animalIsolationList;
        this.animalProductsIsolationList = animalProductsIsolationList;
        this.animalQuarantineList = animalQuarantineList;
        this.productAnimalQuarantineList = productAnimalQuarantineList;
        this.foodAnimalQuarantineList = foodAnimalQuarantineList;
        this.registrationCerEdit = registrationCerEdit;
        this.quarantineCerEditResponseList = quarantineCerEditResponseList;
    }

    public List<Error10> getErrorList() {
        return ErrorList;
    }

    public void setErrorList(List<Error10> ErrorList) {
        this.ErrorList = ErrorList;
    }

    public String getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(String receiveDate) {
        this.receiveDate = receiveDate;
    }

    public Tbdhoso10 getTbdhoso10() {
        return tbdhoso10;
    }

    public void setTbdhoso10(Tbdhoso10 tbdhoso10) {
        this.tbdhoso10 = tbdhoso10;
    }

    public QuarantineResult getQuarantineResult() {
        return quarantineResult;
    }

    public void setQuarantineResult(QuarantineResult quarantineResult) {
        this.quarantineResult = quarantineResult;
    }

    public RegistrationList getRegistrationList() {
        return registrationList;
    }

    public void setRegistrationList(RegistrationList registrationList) {
        this.registrationList = registrationList;
    }

    public QuarantineFee getQuarantineFee() {
        return quarantineFee;
    }

    public void setQuarantineFee(QuarantineFee quarantineFee) {
        this.quarantineFee = quarantineFee;
    }

    public QuarantineFeeRequest getQuarantineFeeRequest() {
        return quarantineFeeRequest;
    }

    public void setQuarantineFeeRequest(QuarantineFeeRequest quarantineFeeRequest) {
        this.quarantineFeeRequest = quarantineFeeRequest;
    }

    public QuarantineFeeResponse getQuarantineFeeResponse() {
        return quarantineFeeResponse;
    }

    public void setQuarantineFeeResponse(QuarantineFeeResponse quarantineFeeResponse) {
        this.quarantineFeeResponse = quarantineFeeResponse;
    }

    public AnimalProcessed getAnimalProcessed() {
        return animalProcessed;
    }

    public void setAnimalProcessed(AnimalProcessed animalProcessed) {
        this.animalProcessed = animalProcessed;
    }

    public QuarantineCancel getQuarantineCancel() {
        return quarantineCancel;
    }

    public void setQuarantineCancel(QuarantineCancel quarantineCancel) {
        this.quarantineCancel = quarantineCancel;
    }

    public QuarantineCancelResponse getQuarantineCancelResponse() {
        return quarantineCancelResponse;
    }

    public void setQuarantineCancelResponse(QuarantineCancelResponse quarantineCancelResponse) {
        this.quarantineCancelResponse = quarantineCancelResponse;
    }

    public QuarantineEditResponse getQuarantineEditResponse() {
        return quarantineEditResponse;
    }

    public void setQuarantineEditResponse(QuarantineEditResponse quarantineEditResponse) {
        this.quarantineEditResponse = quarantineEditResponse;
    }

    public ProcessVSTYList getProcessVSTYList() {
        return processVSTYList;
    }

    public void setProcessVSTYList(ProcessVSTYList processVSTYList) {
        this.processVSTYList = processVSTYList;
    }

    public AnimalIsolationList getAnimalIsolationList() {
        return animalIsolationList;
    }

    public void setAnimalIsolationList(AnimalIsolationList animalIsolationList) {
        this.animalIsolationList = animalIsolationList;
    }

    public AnimalProductsIsolationList getAnimalProductsIsolationList() {
        return animalProductsIsolationList;
    }

    public void setAnimalProductsIsolationList(AnimalProductsIsolationList animalProductsIsolationList) {
        this.animalProductsIsolationList = animalProductsIsolationList;
    }

    public AnimalQuarantineList getAnimalQuarantineList() {
        return animalQuarantineList;
    }

    public void setAnimalQuarantineList(AnimalQuarantineList animalQuarantineList) {
        this.animalQuarantineList = animalQuarantineList;
    }

    public ProductAnimalQuarantineList getProductAnimalQuarantineList() {
        return productAnimalQuarantineList;
    }

    public void setProductAnimalQuarantineList(ProductAnimalQuarantineList productAnimalQuarantineList) {
        this.productAnimalQuarantineList = productAnimalQuarantineList;
    }

    public FoodAnimalQuarantineList getFoodAnimalQuarantineList() {
        return foodAnimalQuarantineList;
    }

    public void setFoodAnimalQuarantineList(FoodAnimalQuarantineList foodAnimalQuarantineList) {
        this.foodAnimalQuarantineList = foodAnimalQuarantineList;
    }

    public RegistrationCerEdit getRegistrationCerEdit() {
        return registrationCerEdit;
    }

    public void setRegistrationCerEdit(RegistrationCerEdit registrationCerEdit) {
        this.registrationCerEdit = registrationCerEdit;
    }

    public QuarantineCerEditResponseList getQuarantineCerEditResponseList() {
        return quarantineCerEditResponseList;
    }

    public void setQuarantineCerEditResponseList(QuarantineCerEditResponseList quarantineCerEditResponseList) {
        this.quarantineCerEditResponseList = quarantineCerEditResponseList;
    }
}
