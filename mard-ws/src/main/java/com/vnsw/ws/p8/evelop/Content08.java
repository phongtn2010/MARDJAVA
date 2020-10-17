package com.vnsw.ws.p8.evelop;

import com.vnsw.ws.p8.message.receive.*;
import com.vnsw.ws.p8.message.send.DNHuyHS;
import com.vnsw.ws.p8.message.send.DNYeuCauRutHS;
import com.vnsw.ws.p8.message.send.DNYeuCauSuaHS;
import com.vnsw.ws.p8.message.send.Hoso08;
import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Content")
@Data
public class Content08 {

    @XmlElementWrapper(name = "ErrorList")
    @XmlElement(name = "Error")
    protected List<Error08> ErrorList;

    @XmlElement(name = "ReceiveDate")
    protected String receiveDate;

    // Ho so moi
    @XmlElement(name = "Registration")
    protected Hoso08 hoso08 ;

    @XmlElement(name = "Quarantine")
    protected CongVanKDNK congVanKDNK;

    @XmlElement(name = "QuarantineResult")
    protected KetQuaThamDinh ketQuaThamDinh;

    @XmlElement(name = "RequestEdit")
    protected DNYeuCauSuaHS dnYeuCauSuaHS;

    @XmlElement(name = "ResponseEdit")
    protected PhanHoiYeuCauSuaHS phanHoiYeuCauSuaHS;

    @XmlElement(name = "QuarantineCancel")
    protected DNHuyHS dnHuyHS;

    @XmlElement(name = "QuarantineCancelRequest")
    protected DNYeuCauRutHS dnYeuCauRutHS;

    @XmlElement(name = "QuarantineCancelResponse")
    protected BNNPhanHoiYeuCauRutHS bnnPhanHoiYeuCauRutHS;

    @XmlElement(name = "VeterinaryHygiene")
    protected CongVanVSTY congVanVSTY;

    @XmlElement(name = "VeterinaryHygieneResult")
    protected KetQuaVSTYKhongDat ketQuaVSTYKhongDat;

}
