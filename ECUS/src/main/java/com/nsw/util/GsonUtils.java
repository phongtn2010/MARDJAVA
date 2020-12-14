/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author phongnv
 */
public class GsonUtils {
    public class JsonDateDeserializer implements JsonDeserializer<Date> {
       @Override
       public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
          String s = json.getAsJsonPrimitive().getAsString();
          //long l = Long.parseLong(s.substring(6, s.length() - 2));
          Date d = new Date(Long.parseLong(s));

        //Calendar calendar = Calendar.getInstance();
        //calendar.setTimeInMillis(Long.parseLong(s));
          return d; 
       } 
    }
    private static Gson gson;
    private static GsonUtils instance;

    public GsonUtils() {
        gson = new GsonBuilder().registerTypeAdapter(Date.class, new JsonDateDeserializer()).create();
    }

    public static GsonUtils getInstance() {
        synchronized (GsonUtils.class) {
            if (instance == null) {
                instance = new GsonUtils();
            }
            return instance;
        }
    }
    
    public <T> T deserializer(String json, Class<T> type){
        return gson.fromJson(json, type);
    }
    public <T> String serializer(T json){
        return gson.toJson(json);
    }
    public <T> T transform(Object obj, Class<T> type){
        return deserializer(serializer(obj), type);
    }
}
