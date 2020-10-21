package com.vnsw.ws.p25.envelop;


import lombok.Data;

import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class From25 {

    @XmlElement(name = "name")
    @Size(max = 255)
    private String name;
    @XmlElement(name = "identity")
    @Size(max = 13)
    private String identity;

    @XmlElement(name = "countryCode")
    @Size(max = 2)
    private String countryCode;

    @XmlElement(name = "ministryCode")
    @Size(max = 20)
    private String ministryCode;

    @XmlElement(name = "organizationCode")
    @Size(max = 20)
    private String organizationCode;

    @XmlElement(name = "unitCode")
    @Size(max = 20)
    private String unitCode;

    public From25(String name, String identity, String countryCode, String ministryCode, String organizationCode, String unitCode) {
        this.name = name;
        this.identity = identity;
        this.countryCode = countryCode;
        this.ministryCode = ministryCode;
        this.organizationCode = organizationCode;
        this.unitCode = unitCode;
    }

    public From25() {
    }
}
