package com.vnsw.ws.annotations;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class DateSerialization extends XmlAdapter<String, Date> {
	private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public String marshal(Date v) throws Exception {
        synchronized (dateFormat) {
            return dateFormat.format(v);
        }
    }

    @Override
    public Date unmarshal(String v) throws Exception {
        if (v.length() == 0) {
            return null;
        } else {
            synchronized (dateFormat) {
                return dateFormat.parse(v);
            }
        }
    }

}
