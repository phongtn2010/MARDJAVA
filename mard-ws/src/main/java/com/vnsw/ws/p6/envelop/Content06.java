package com.vnsw.ws.p6.envelop;

import com.vnsw.ws.p6.message.receive.*;
import com.vnsw.ws.p6.message.send.DNYeucauHuyHoso;
import com.vnsw.ws.p6.message.send.DNYeucauSuaHoso;
import com.vnsw.ws.p6.message.send.Hoso06;
import com.vnsw.ws.p8.message.send.DNHuyHS;
import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Content")
@Data
public class Content06 {

    @XmlElementWrapper(name = "ErrorList")
    @XmlElement(name = "Error")
    protected List<Error06> ErrorList;

    @XmlElement(name = "ReceiveDate")
    protected String receiveDate;

    // Ho so moi
    @XmlElement(name = "RegistrationProfile")
    protected Hoso06 hoso06;

    @XmlElement(name = "VeterinaryHygiene")
    protected CongVanVSTY congVanVSTY;

    @XmlElement(name = "QuarantineDispatch")
    protected CongVanKDNK congVanKDNK;

    @XmlElement(name = "EvaluationResult")
    protected KetQuaThamDinh ketQuaThamDinh;

    @XmlElement(name = "QuarantineCancel")
    protected DNHuyHS dnHuyHS;

    @XmlElement(name = "RequestCancel")
    protected DNYeucauHuyHoso dnYeucauHuyHoso;

    @XmlElement(name = "ResponseCancel")
    protected PhanhoiYeucauHuyHoso phanhoiYeucauHuyHoso;

    @XmlElement(name = "RequestEdit")
    protected DNYeucauSuaHoso dnYeucauSuaHoso;

    @XmlElement(name = "ResponseEdit")
    protected PhanhoiYeucauSuaHoso phanhoiYeucauSuaHoso;

    @XmlElement(name = "VeterinaryHygieneFail")
    protected KetquaVSTY ketquaVSTY;

}
