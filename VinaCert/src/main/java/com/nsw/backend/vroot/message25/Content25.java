package com.nsw.backend.vroot.message25;

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

}
