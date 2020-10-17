package com.vnsw.ws.annotations;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DoubleSerialization extends XmlAdapter<String, Double> {
    @Override
    public String marshal(Double v) {
        return String.format("%.3f", v);
    }

    @Override
    public Double unmarshal(String v) {
        return Double.parseDouble(v);
    }

}
