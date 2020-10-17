package com.nsw.backend.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.core.JsonParser;
import java.text.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomJsonDateDeserializer extends JsonDeserializer<Date> {
    
    public static final Logger logger = LoggerFactory.getLogger(CustomJsonDateDeserializer.class);
    
    @Override
    public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        //SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String date = jsonParser.getText();
        try {
            return format.parse(date);
        } catch (ParseException e) {
            logger.error(e.getMessage(), e);
            return null;
        }
    }
}
