package com.vnsw.ws.p25.message.send;

import com.vnsw.ws.annotations.DateSerialization;
import lombok.Data;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;
import java.util.List;

@XmlType(name = "Report")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class Report {
    @XmlElement(name = "NSWFileCode")
    String fiNSWFileCode;
    @XmlElementWrapper(name = "AttachmentReportList")
    @XmlElement(name = "AttachmentReport")
    private List<Tbdattach25> fiListAttch;
}
