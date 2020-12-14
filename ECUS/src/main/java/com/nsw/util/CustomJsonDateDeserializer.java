/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.core.JsonParser;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 *
 * @author Phong84NV
 */
public class CustomJsonDateDeserializer extends JsonDeserializer<Date> {

    @Override
    public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {        
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String date = jsonParser.getText();
        
        if(date == null || date.equals(""))
            return null;
        
        try {            
            return format.parse(date);
        } catch (Exception e) {
            try {
                Long date2 = jsonParser.getLongValue();
                Date dt = new Date(date2);
                return dt; 
            } catch (Exception ex) {
                return null;
            }
        }
    }
}
