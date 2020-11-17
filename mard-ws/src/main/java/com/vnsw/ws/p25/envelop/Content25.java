package com.vnsw.ws.p25.envelop;

import com.vnsw.ws.p25.message.receive.*;
import com.vnsw.ws.p25.message.send.*;
import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Content")
@Data
public class Content25 {

    @XmlElementWrapper(name = "ErrorList")
    @XmlElement(name = "Error")
    protected List<Error25> ErrorList;

    @XmlElement(name = "ReceiveDate")
    protected String receiveDate;

    // Ho so moi
    @XmlElement(name = "AniFeed")
    protected Hoso25 hoso25;
    @XmlElement(name = "Report")
    protected UploadBaoCao uploadBaoCao;
    //NSW
    @XmlElement(name = "RequestCancel")
    protected DNYeucauHuyHoso dNYeucauHuyHoso;
    //BNN
    @XmlElement(name = "Result")
    protected KetQuaXuLy ketQuaXuLy;
    //BNN
    @XmlElement(name = "ResultConfirm")
    protected XacNhanDon xacNhanDon;
    //BNN
    @XmlElement(name = "ResultConfirmCancel")
    protected BNNThongBaoThuHoiGDK thongBaoThuHoiGDK;
    //NSW
    @XmlElement(name = "TestInformation")
    protected GuiHSTCCD guiHSTCCD;
    //BNN
    @XmlElement(name = "ResultTestInformation")
    protected TCCDGuiKQKT tccdGuiKQKT;
    //NSW
    @XmlElement(name = "SendResultTest")
    protected DNNopKetQua nopKetQua;
    //BNN
    @XmlElement(name = "ResultResponse")
    protected BNNXuLyKQ xuLyKQ;
    //BNN
    @XmlElement(name = "ResultCheck")
    protected GiayXNCL giayXNCL;
    //BNN
    @XmlElement(name = "AniFeedResultCertificateCancel")
    protected BNNThuHoiGiayXNCL thuHoiGiayXNCL;
    //BNN
    @XmlElement(name = "ResultReception2d")
    protected BNNTiepNhanHD2D tiepNhanHD2D;
}
