package com.vnsw.ws.p15.message;

import com.vnsw.ws.annotations.DateSerialization;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;



/***
 *
 *
 * @Model
 * @class DNYeuCauRutHS
 * Created by Nguyen Van Quang
 * 05/12/2018 17:50:50
 *
 */
@XmlRootElement(name = "GeneticRequestCancel")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "fiRequestDate", "fiReason"})
public class DNYeuCauRutHSSauTiepNhan {

    public DNYeuCauRutHSSauTiepNhan() {}

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "RequestDate", required = true)
    private Date fiRequestDate;

    @XmlElement(name = "Reason", required = true)
    private String fiReason;

    public Date getFiRequestDate() {
        return fiRequestDate;
    }

    public void setFiRequestDate(Date fiRequestDate) {
        this.fiRequestDate = fiRequestDate;
    }

    public String getFiReason() {
        return fiReason;
    }

    public void setFiReason(String fiReason) {
        this.fiReason = fiReason;
    }

    @Override
    public String toString() {
        return "DNYeuCauRutHSSauTiepNhan{" +
                "fiRequestDate=" + fiRequestDate +
                ", fiReason='" + fiReason + '\'' +
                '}';
    }
}
