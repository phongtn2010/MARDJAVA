package com.vnsw.ws.p7.evelope;

import com.vnsw.ws.p7.message.receive.*;
import com.vnsw.ws.p7.message.send.*;
import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Content")
@Data
public class Content07 {

    @XmlElementWrapper(name = "ErrorList")
    @XmlElement(name = "Error")
    protected List<Error07> ErrorList;

    @XmlElement(name = "ReceiveDate")
    protected String receiveDate;

    @XmlElement(name = "RegistrationProfile")
    RegistrationProfile registrationProfile;

    @XmlElement(name = "RequestEdit")
    DnYeucauSuaHoso dnYeucauSuaHoso;

    @XmlElement(name = "QuarantineCertificate")
    ChungNhanKiemDich chungNhanKiemDich;

    @XmlElement(name = "TransportCertificate")
    ChungNhanVanChuyen chungNhanVanChuyen;

    @XmlElement(name = "Result")
    KetQuaThamDinh ketQuaThamDinh;

    @XmlElement(name = "RegistrationComfirm")
    XacNhanDonDangKy xacNhanDonDangKy;

    @XmlElement(name = "ResponseEdit")
    PhanhoiYeucauSuaHoso phanhoiYeucauSuaHoso;

    @XmlElement(name = "RequestCancel")
    DNYeucauRutHoso dnYeucauRutHoso;

    @XmlElement(name = "CancelRegistrationProfile")
    DNRutHosoTruocTiepnhan dnRutHosoTruocTiepnhan;

    @XmlElement(name = "ResponseCancel")
    PhanhoiYeucauRutHoso phanhoiYeucauRutHoso;

    @XmlElement(name = "PhytosanitaryFee")
    ThongbaoApphi thongbaoApphi;

    @XmlElement(name = "FeeRequest")
    XacnhanThanhtoan xacNhanPhi;

    @XmlElement(name = "QualityFail")
    ThongbaoLohangKhongdat thongbaoLohangKhongdat;

    @XmlElement(name = "RequestEditCert")
    YeucauSuaGCN yeucauSuaGCN;

    @XmlElement(name = "ResponseEditCer")
    TuchoiSuaGCN tuchoiSuaGCN;

}
