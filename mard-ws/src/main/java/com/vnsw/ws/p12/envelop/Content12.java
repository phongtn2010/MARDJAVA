package com.vnsw.ws.p12.envelop;

import com.vnsw.ws.p12.message.receive.KetQuaXuLy;
import com.vnsw.ws.p12.message.receive.Tbdcongvan12;
import com.vnsw.ws.p12.message.send.Tbdhoso12;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Content")
public class Content12 {

    @XmlElementWrapper(name = "ErrorList")
    @XmlElement(name = "Error")
    protected List<Error12> ErrorList;
    
    @XmlElementWrapper(name = "InspectionResultList")
    @XmlElement(name = "InspectionResult")
    protected List<Tbdcongvan12> lstTbdcongvan12s;
    
    @XmlElement(name = "Result")
    protected KetQuaXuLy ketQuaXuLy;
    
    @XmlElement(name = "ReductionFreeInspection")
    protected Tbdhoso12 tbdhoso12;
    
    @XmlElement(name = "ReceiveDate")
    protected String receiveDate;
    
    public Content12() {
    }


    public List<Error12> getErrorList() {
        return ErrorList;
    }

    public void setErrorList(List<Error12> ErrorList) {
        this.ErrorList = ErrorList;
    }

    public String getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(String receiveDate) {
        this.receiveDate = receiveDate;
    }

    public List<Tbdcongvan12> getLstTbdcongvan12s() {
        return lstTbdcongvan12s;
    }

    public void setLstTbdcongvan12s(List<Tbdcongvan12> lstTbdcongvan12s) {
        this.lstTbdcongvan12s = lstTbdcongvan12s;
    }

    public KetQuaXuLy getKetQuaXuLy() {
        return ketQuaXuLy;
    }

    public void setKetQuaXuLy(KetQuaXuLy ketQuaXuLy) {
        this.ketQuaXuLy = ketQuaXuLy;
    }

    public Tbdhoso12 getTbdhoso12() {
        return tbdhoso12;
    }

    public void setTbdhoso12(Tbdhoso12 tbdhoso12) {
        this.tbdhoso12 = tbdhoso12;
    }

}
