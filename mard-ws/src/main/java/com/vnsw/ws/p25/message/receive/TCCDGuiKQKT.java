package com.vnsw.ws.p25.message.receive;

import com.vnsw.ws.annotations.DateSerialization;
import com.vnsw.ws.p25.entity.receive.AttachmentResult;
import lombok.Data;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;
import java.util.List;

@XmlType(name = "ResultTestInformation")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class TCCDGuiKQKT {
    @XmlElement(name = "NSWFileCode")
    String fiNSWFileCode;

    @XmlElement(name = "AssignID")
    String fiAssignID;
    @XmlElement(name = "AssignName")
    String fiAssignName;
    @XmlElement(name = "GoodsId")
    String fiMaHangHoa;
    @XmlElement(name = "NameOfGoods")
    String fiTenHangHoa;
    @XmlElement(name = "ResultTest")
    Integer fiKetQuaDanhGia;

    @XmlElement(name = "TestConfirmNumber")
    String fiSoGCN;
    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "TestConfirmDate")
    Date fiNgayCap;
    @XmlElement(name = "TestConfirmAttachmentId")
    String fiMaFileGCN;
    @XmlElement(name = "TestConfirmFileLink")
    String fiLinkFileGCN;

    @XmlElementWrapper(name = "AttachmentResultList")
    @XmlElement(name = "AttachmentResult")
    List<AttachmentResult> fiDanhSachDinhKem;

}
