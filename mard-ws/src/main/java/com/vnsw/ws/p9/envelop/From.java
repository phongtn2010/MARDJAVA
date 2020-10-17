package com.vnsw.ws.p9.envelop;


import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class From {

    public From() {

    }

    public From(String name, String identity, String countryCode,
                String ministryCode, String organizationCode, String unitCode) {
        this.identity = identity;
        this.name = name;
        this.countryCode = countryCode;
        this.ministryCode = ministryCode;
        this.organizationCode = organizationCode;
        this.unitCode = unitCode;

    }
    
    public From(String name, String identity, String countryCode,
                String ministryCode, String organizationCode, String unitCode1, String unitCode2) {
        this.identity = identity;
        this.name = name;
        this.countryCode = countryCode;
        this.ministryCode = ministryCode;
        this.organizationCode = organizationCode;
        this.unitCode1 = unitCode1;
        this.unitCode2 = unitCode2;

    }
    
    public From(String name, String identity) {
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
    
    // Ma don vi kiem dich
    @XmlElement(name = "unitCode1")
    @Size(max = 20)
    private String unitCode1;
    
    // Ma don vi giam sat
    @XmlElement(name = "unitCode2")
    @Size(max = 20)
    private String unitCode2;

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

    public String getUnitCode1() {
        return unitCode1;
    }

    public void setUnitCode1(String unitCode1) {
        this.unitCode1 = unitCode1;
    }

    public String getUnitCode2() {
        return unitCode2;
    }

    public void setUnitCode2(String unitCode2) {
        this.unitCode2 = unitCode2;
    }

}
