package com.vnsw.ws.p04.envelop;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

import com.vnsw.ws.common.envelop.Error;
import com.vnsw.ws.p04.entity.TbdAnanyticalCheckedList04;
import com.vnsw.ws.p04.entity.TbdFeeResponse04;
import com.vnsw.ws.p04.entity.TbdKqxl04;
import com.vnsw.ws.p04.entity.TbdPhytosanitaryDetain04;
import com.vnsw.ws.p04.entity.TbdPhytosanitaryFee04;
import com.vnsw.ws.p04.entity.TbdPhytosanitaryResult04;
import com.vnsw.ws.p04.entity.TbdQualityResult04;
import com.vnsw.ws.p04.entity.TbdRegistrationComfirm04;
import com.vnsw.ws.p04.entity.TbdRequestEdit;
import com.vnsw.ws.p04.entity.TbdRequestEditCer04;
import com.vnsw.ws.p04.entity.TbdTemporaryPhytosanitary04;
import com.vnsw.ws.p04.entity.TbdYcRut04;
import com.vnsw.ws.p04.message.send.DNYeucauRut;
import com.vnsw.ws.p04.message.send.DNYeucauSua;
import com.vnsw.ws.p04.message.send.DNYeucauSuaXNCL;
import com.vnsw.ws.p04.message.send.TbdRegistrationProfile04;
import com.vnsw.ws.p04.message.send.TbdThongbaoThanhtoan;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Content")
public class Content {

    @XmlElementWrapper(name = "DS_Loi")
    @XmlElement(name = "Thongtin_Loi")
    protected List<Error> ErrorList;
    
    @XmlElement(name = "RegistrationProfile")
    protected TbdRegistrationProfile04 tbdRegistrationProfile04;
    
    @XmlElement(name = "ngaythongbao")
    protected String receiveDate;
    
    @XmlElement(name = "RequestCancel")
    protected DNYeucauRut dNYeucauRut;
    
    @XmlElement(name = "Result")
    protected TbdKqxl04 tbdKqxl04;
    
    @XmlElement(name = "RegistrationComfirm")
    protected TbdRegistrationComfirm04 tbdRegistrationComfirm04;
    
    @XmlElement(name = "RequestEdit")
    protected DNYeucauSua DNYeucauSua;
    
    @XmlElement(name = "ResponseEdit")
    protected TbdRequestEdit tbdRequestEdit;
    
    @XmlElement(name = "ResponseCancel")
    protected TbdYcRut04 tbdYcRut04;
    
    @XmlElement(name = "PhytosanitaryDetain")
    protected TbdPhytosanitaryDetain04 tbdPhytosanitaryDetain04;
    
    @XmlElement(name = "TemporaryPhytosanitary")
    protected TbdTemporaryPhytosanitary04 tbdTemporaryPhytosanitary04;
    
    @XmlElement(name = "PhytosanitaryResult")
    protected TbdPhytosanitaryResult04 tbdPhytosanitaryResult04;
    
    @XmlElement(name = "QualityResult")
    protected TbdQualityResult04 tbdQualityResult04;
    
    @XmlElement(name = "PhytosanitaryFee")
    protected TbdPhytosanitaryFee04 tbdPhytosanitaryFee04;
    
    @XmlElement(name = "RequestEditCer")
    protected DNYeucauSuaXNCL dNYeucauSuaXNCL;
    
    @XmlElement(name = "ResponseEditCer")
    protected TbdRequestEditCer04 tbdRequestEditCer04;
    
    @XmlElement(name = "AnanyticalCheckedList")
    protected TbdAnanyticalCheckedList04 tbdAnanyticalCheckedList04;
    
    @XmlElement(name = "PhytosanitaryFee")
    protected TbdThongbaoThanhtoan tbdThongbaoThanhtoan;
    
    @XmlElement(name = "FeeResponse")
    protected TbdFeeResponse04 tbdFeeResponse04;

    public Content() {
    }

    public List<Error> getErrorList() {
        return ErrorList;
    }

    public void setErrorList(List<Error> ErrorList) {
        this.ErrorList = ErrorList;
    }

    public String getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(String receiveDate) {
        this.receiveDate = receiveDate;
    }

    public TbdRegistrationProfile04 getTbdRegistrationProfile04() {
        return tbdRegistrationProfile04;
    }

    public void setTbdRegistrationProfile04(TbdRegistrationProfile04 tbdRegistrationProfile04) {
        this.tbdRegistrationProfile04 = tbdRegistrationProfile04;
    }

    public DNYeucauRut getdNYeucauRut() {
        return dNYeucauRut;
    }

    public void setdNYeucauRut(DNYeucauRut dNYeucauRut) {
        this.dNYeucauRut = dNYeucauRut;
    }

    public TbdKqxl04 getTbdKqxl04() {
        return tbdKqxl04;
    }

    public void setTbdKqxl04(TbdKqxl04 tbdKqxl04) {
        this.tbdKqxl04 = tbdKqxl04;
    }

    public TbdRegistrationComfirm04 getTbdRegistrationComfirm04() {
        return tbdRegistrationComfirm04;
    }

    public void setTbdRegistrationComfirm04(TbdRegistrationComfirm04 tbdRegistrationComfirm04) {
        this.tbdRegistrationComfirm04 = tbdRegistrationComfirm04;
    }

    public DNYeucauSua getDNYeucauSua() {
        return DNYeucauSua;
    }

    public void setDNYeucauSua(DNYeucauSua DNYeucauSua) {
        this.DNYeucauSua = DNYeucauSua;
    }

    public TbdRequestEdit getTbdRequestEdit() {
        return tbdRequestEdit;
    }

    public void setTbdRequestEdit(TbdRequestEdit tbdRequestEdit) {
        this.tbdRequestEdit = tbdRequestEdit;
    }

    public TbdYcRut04 getTbdYcRut04() {
        return tbdYcRut04;
    }

    public void setTbdYcRut04(TbdYcRut04 tbdYcRut04) {
        this.tbdYcRut04 = tbdYcRut04;
    }

    public TbdPhytosanitaryDetain04 getTbdPhytosanitaryDetain04() {
        return tbdPhytosanitaryDetain04;
    }

    public void setTbdPhytosanitaryDetain04(TbdPhytosanitaryDetain04 tbdPhytosanitaryDetain04) {
        this.tbdPhytosanitaryDetain04 = tbdPhytosanitaryDetain04;
    }

    public TbdTemporaryPhytosanitary04 getTbdTemporaryPhytosanitary04() {
        return tbdTemporaryPhytosanitary04;
    }

    public void setTbdTemporaryPhytosanitary04(TbdTemporaryPhytosanitary04 tbdTemporaryPhytosanitary04) {
        this.tbdTemporaryPhytosanitary04 = tbdTemporaryPhytosanitary04;
    }

    public TbdPhytosanitaryResult04 getTbdPhytosanitaryResult04() {
        return tbdPhytosanitaryResult04;
    }

    public void setTbdPhytosanitaryResult04(TbdPhytosanitaryResult04 tbdPhytosanitaryResult04) {
        this.tbdPhytosanitaryResult04 = tbdPhytosanitaryResult04;
    }

    public TbdQualityResult04 getTbdQualityResult04() {
        return tbdQualityResult04;
    }

    public void setTbdQualityResult04(TbdQualityResult04 tbdQualityResult04) {
        this.tbdQualityResult04 = tbdQualityResult04;
    }

    public TbdPhytosanitaryFee04 getTbdPhytosanitaryFee04() {
        return tbdPhytosanitaryFee04;
    }

    public void setTbdPhytosanitaryFee04(TbdPhytosanitaryFee04 tbdPhytosanitaryFee04) {
        this.tbdPhytosanitaryFee04 = tbdPhytosanitaryFee04;
    }

    public DNYeucauSuaXNCL getdNYeucauSuaXNCL() {
        return dNYeucauSuaXNCL;
    }

    public void setdNYeucauSuaXNCL(DNYeucauSuaXNCL dNYeucauSuaXNCL) {
        this.dNYeucauSuaXNCL = dNYeucauSuaXNCL;
    }

    public TbdRequestEditCer04 getTbdRequestEditCer04() {
        return tbdRequestEditCer04;
    }

    public void setTbdRequestEditCer04(TbdRequestEditCer04 tbdRequestEditCer04) {
        this.tbdRequestEditCer04 = tbdRequestEditCer04;
    }

    public TbdAnanyticalCheckedList04 getTbdAnanyticalCheckedList04() {
        return tbdAnanyticalCheckedList04;
    }

    public void setTbdAnanyticalCheckedList04(TbdAnanyticalCheckedList04 tbdAnanyticalCheckedList04) {
        this.tbdAnanyticalCheckedList04 = tbdAnanyticalCheckedList04;
    }

    public TbdThongbaoThanhtoan getTbdThongbaoThanhtoan() {
        return tbdThongbaoThanhtoan;
    }

    public void setTbdThongbaoThanhtoan(TbdThongbaoThanhtoan tbdThongbaoThanhtoan) {
        this.tbdThongbaoThanhtoan = tbdThongbaoThanhtoan;
    }

    public TbdFeeResponse04 getTbdFeeResponse04() {
        return tbdFeeResponse04;
    }

    public void setTbdFeeResponse04(TbdFeeResponse04 tbdFeeResponse04) {
        this.tbdFeeResponse04 = tbdFeeResponse04;
    }

}
