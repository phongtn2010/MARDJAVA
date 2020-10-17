package com.nsw.util;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.lang.reflect.*;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
/**
 *
 * @author phongnv
 */
public final class GenericUtils {
    
    public static Object convert(String value, String type){
        try {
            if(value == null){
                return value;
            }
            switch(type){
                default:
                case "String":
                    return value;
                case "Date":      
                    if(value.isEmpty()){
                        return null;
                    }
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    return sdf.parse(value);
                case "Long":
                    if(value.isEmpty()){
                        return null;
                    }
                    return Long.parseLong(value);
                case "BigDecimal":
                    if(value.isEmpty()){
                        return null;
                    }
                    DecimalFormatSymbols symbols = new DecimalFormatSymbols();
                    symbols.setGroupingSeparator(',');
                    symbols.setDecimalSeparator('.');
                    String pattern = "#,##0.0#";
                    DecimalFormat decimalFormat = new DecimalFormat(pattern, symbols);
                    decimalFormat.setParseBigDecimal(true);
                    BigDecimal bigDecimal = (BigDecimal) decimalFormat.parse(value);
                    return bigDecimal;
            }
        } catch (ParseException | NumberFormatException ex) {
            LogUtil.addLog(ex);
            return null;
        }
    }

    public static boolean set(Object object, String fieldName, Object fieldValue) {
        if(fieldValue == null){
            return true;
        }
        Class<?> clazz = object.getClass();
        while (clazz != null) {
            try {
                Field field = clazz.getDeclaredField(fieldName);
                field.setAccessible(true);
                field.set(object, fieldValue);
                return true;
            } catch (NoSuchFieldException e) {
                LogUtil.addLog(e);
                clazz = clazz.getSuperclass();
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    public static <V> V get(Object object, String fieldName) {
        Class<?> clazz = object.getClass();
        while (clazz != null) {
            try {
                Field field = clazz.getDeclaredField(fieldName);
                field.setAccessible(true);
                return (V) field.get(object);
            } catch (NoSuchFieldException e) {
                LogUtil.addLog(e);
                clazz = clazz.getSuperclass();
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
        }
        return null;
    }
    
//    public static void main(String[] args){
//        try {
//            Class<?> clazz = Class.forName("com.viettel.util.clzz");
//            Object instance = clazz.newInstance();
//            set(instance, "d", new Date());
//            set(instance, "s", "clzz");
//            set(instance, "l", 1l);
//            Date d = get(instance, "d");
//            System.err.println(d);
//            String s = get(instance, "s");
//            System.err.println(s);
//            Long l = get(instance, "l");
//            System.err.println(l);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }
}
