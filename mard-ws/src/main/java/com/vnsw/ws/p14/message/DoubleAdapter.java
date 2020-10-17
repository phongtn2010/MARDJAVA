package com.vnsw.ws.p14.message;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.math.BigDecimal;

public class DoubleAdapter extends XmlAdapter<BigDecimal, Double> {

    @Override
    public Double unmarshal(BigDecimal v)  throws Exception {
        if (v != null) {
            return v.doubleValue();
        }
       return null;
    }

    @Override
    public BigDecimal marshal(Double v) throws Exception {
        if (v != null) {
            BigDecimal bigDecimal = new BigDecimal(v);
            return bigDecimal;
        }
        return null;
    }
}
