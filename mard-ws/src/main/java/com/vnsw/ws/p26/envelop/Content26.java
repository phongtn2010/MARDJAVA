package com.vnsw.ws.p26.envelop;

import com.vnsw.ws.p26.message.receive.*;
import com.vnsw.ws.p26.message.send.*;
import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Content")
@Data
public class Content26 {

    @XmlElementWrapper(name = "ErrorList")
    @XmlElement(name = "Error")
    protected List<Error26> ErrorList;

    @XmlElement(name = "ReceiveDate")
    protected String receiveDate;

    // Ho so moi
    @XmlElement(name = "Application")
    protected Hoso26 hoso26;

}
