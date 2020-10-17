package com.vnsw.ws.p11.envelop;

import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class From11 {

    public From11() {

    }

    public From11(String name, String identity, String countryCode,
            String ministryCode, String organizationCode, String unitCode) {
        this.identity = identity;
        this.name = name;
        this.countryCode = countryCode;
        this.ministryCode = ministryCode;
        this.organizationCode = organizationCode;
        this.unitCode = unitCode;

    }
    
    public From11(String name, String identity) {
        this.identity = identity;
        this.name = name;

    }

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
    
   

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getIdentity() {
        return identity;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getMinistryCode() {
        return ministryCode;
    }

    public void setMinistryCode(String ministryCode) {
        this.ministryCode = ministryCode;
    }

    public String getOrganizationCode() {
        return organizationCode;
    }

    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode;
    }

    public String getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }

}
