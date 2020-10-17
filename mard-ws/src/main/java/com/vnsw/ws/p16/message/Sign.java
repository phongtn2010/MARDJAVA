package com.vnsw.ws.p16.message;

import com.vnsw.ws.annotations.DateSerialization;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

@XmlRootElement(name = "Sign")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "fiSignAddress", "fiSignDate", "fiSignName", "fiSignerPosition"})
public class Sign {

    @XmlElement(name = "SignAddress", required = true)
    private String fiSignAddress;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "SignDate", required = true)
    private Date fiSignDate;

    @XmlElement(name = "SignName", required = true)
    private String fiSignName;

    @XmlElement(name = "Position", required = true)
    private String fiSignerPosition;

    public String getFiSignAddress() {
        return fiSignAddress;
    }

    public void setFiSignAddress(String fiSignAddress) {
        this.fiSignAddress = fiSignAddress;
    }

    public Date getFiSignDate() {
        return fiSignDate;
    }

    public void setFiSignDate(Date fiSignDate) {
        this.fiSignDate = fiSignDate;
    }

    public String getFiSignName() {
        return fiSignName;
    }

    public void setFiSignName(String fiSignName) {
        this.fiSignName = fiSignName;
    }

    public String getFiSignerPosition() {
        return fiSignerPosition;
    }

    public void setFiSignerPosition(String fiSignerPosition) {
        this.fiSignerPosition = fiSignerPosition;
    }
}
