package com.vnsw.ws.p26.message.send;

import com.vnsw.ws.p26.entity.receive.AttachmentReport;
import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Report")
@Data
public class UploadBaoCao {
    @XmlElement(name = "NSWFileCode")
    String fiNSWFileCode;
    @XmlElementWrapper(name = "AttachmentReportList")
    @XmlElement(name = "AttachmentReport")
    private List<AttachmentReport> fiAttachReport;
}
