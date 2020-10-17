package com.vnsw.ws.p1.evelop;

import com.vnsw.ws.p1.message.receive.*;
import com.vnsw.ws.p1.message.send.*;
import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Content")
@Data
public class Content01 {

    @XmlElementWrapper(name = "ErrorList")
    @XmlElement(name = "Error")
    protected List<Error01> ErrorList;

    @XmlElement(name = "ReceiveDate")
    protected String receiveDate;

    /**
     * Tạo mới hồ sơ
     */
    @XmlElement(name = "RegistrationProfile")
    protected Hoso01 hoso01;

    /**
     * CNKD động vật 13A
     */
    @XmlElement(name = "CertificateForAnimal")
    protected CNKD13A cnkd13A;

    /**
     * CNKD sản phẩm động vật 13B
     */
    @XmlElement(name = "CertificateProductAnimal")
    protected CNKD13B cnkd13B;

    /**
     * CNKD sản phẩm động vật China
     */
    @XmlElement(name = "CertificateChina")
    protected CNKDChina cnkdChina;

    /**
     * CNKD sản phẩm động vật Hong Kong gà
     */
    @XmlElement(name = "CertificateHongKongChicken")
    protected CNKDHongKongChicken cnkdHongKongChicken;

    /**
     * CNKD sản phẩm động vật Hong Kong Lợn
     */
    @XmlElement(name = "CertificateHongKongPig")
    protected CNKDHongKongPig cnkdHongKongPig;

    /**
     * CNKD sản phẩm động vật Malaysia
     */
    @XmlElement(name = "CertificateMalaysia")
    protected CNKDMalaysia cnkdMalaysia;

    /**
     * Công văn kết quả yêu cầu xuất khẩu
     */
    @XmlElement(name = "NotificationFailed")
    protected CVKQYCXuatKhau01 cvkqycXuatKhau01;

    /**
     * Kết quả thẩm định hồ sơ 01
     */
    @XmlElement(name = "Result")
    protected KQTDhoso01 kqtDhoso01;

    /**
     * Kết quả yêu cầu rút hồ sơ 01
     */
    @XmlElement(name = "ResponseCancel")
    protected KQYCRutHoSo01 kqycRutHoSo01;

    /**
     * Kết quả yêu cầu sửa hồ sơ 01
     */
    @XmlElement(name = "ProResponseEdit")
    protected KQYCSuaHoSo01 kqycSuaHoSo01;

    /**
     * Thông báo áp phí
     */
    @XmlElement(name = "PhytosanitaryFee")
    protected TBApPhi01 tbApPhi01;

    /**
     * Thông báo đồng ý hơ sơ 01
     */
    @XmlElement(name = "ResultConfirm")
    protected TBDYhoso01 tbdYhoso01;

    /**
     * Thông báo kết quả yêu cầu hủy CNKD
     */
    @XmlElement(name = "ResponseCancelCer")
    protected TBKQYCHuyCNKD tbkqycHuyCNKD;

    /**
     * Thông báo kết quả yêu cầu sửa CNKD
     */
    @XmlElement(name = "ResponseEditCer")
    protected TBKQYCSuaCNKD tbkqycSuaCNKD;

    /**
     * Thông báo xác nhận phí 01
     */
    @XmlElement(name = "FeeRequest")
    protected TBXacNhanPhi01 tbXacNhanPhi01;

    /**
     * Doanh nghiệp xin hủy CNKD
     */
    @XmlElement(name = "RequestCancelCer")
    protected DNXinHuyCNKD dnXinHuyCNKD;

    /**
     * Doanh nghiệp xin sửa CNKD
     */
    @XmlElement(name = "RequestEditCer")
    protected DNXinSuaCNKD dnXinSuaCNKD;

    /**
     * Doanh nghiệp xin hủy hồ sơ trước khi khi tiếp nhận
     */
    @XmlElement(name = "RequestProCancel")
    protected XinHuyHoSo01ChuaTiepNhan xinHuyHoSo01ChuaTiepNhan;

    /**
     * Doanh nghiệp xin hủy hồ sơ sau khi tiếp nhận
     */
    @XmlElement(name = "RequestCancel")
    protected XinHuyHoSo01 xinHuyHoSo01;

    /**
     * Doanh nghiệp xin sửa hồ sơ khi chưa chấp CNKD
     */
    @XmlElement(name = "RequestProEdit")
    protected XinSuaHoSo01ChuaCNKD xinSuaHoSo01ChuaCNKD;


}
