package com.nsw.mard.p25.util;

import com.nsw.mard.constant.Mard25Constant;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Mard25Hepler {

    public static String toVNStringDate(Date date){
        if (date==null){
            return "";
        }else{
            StringBuffer stringBuffer = new StringBuffer("ngày ");
            stringBuffer.append(date.getDate()+ " tháng ");
            stringBuffer.append((date.getMonth()+1)+ " năm ");
            stringBuffer.append(date.getYear()+1900);
            return stringBuffer.toString();
        }
    }
    public static String toShortStringDate(Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        if (date==null){
            return "";
        }else{
            return simpleDateFormat.format(date);
        }
    }

    public static String getHinhThucCB(Integer ht){
        if(null==ht){
            return "";
        }else{
            if(ht==Mard25Constant.HinhThucCB.NONE.getId()){
                return Mard25Constant.HinhThucCB.NONE.getName();
            }else if(ht==Mard25Constant.HinhThucCB.IS_LESS_THAN.getId()){
                return Mard25Constant.HinhThucCB.IS_LESS_THAN.getName();
            }else if(ht==Mard25Constant.HinhThucCB.IS_GREATER_THAN.getId()){
                return Mard25Constant.HinhThucCB.IS_GREATER_THAN.getName();
            }else if(ht==Mard25Constant.HinhThucCB.IS_LESS_THAN_OR_EQUAL_TO.getId()){
                return Mard25Constant.HinhThucCB.IS_LESS_THAN_OR_EQUAL_TO.getName();
            }else if(ht==Mard25Constant.HinhThucCB.IS_GREATER_THAN_OR_EQUAL_TO.getId()){
                return Mard25Constant.HinhThucCB.IS_GREATER_THAN_OR_EQUAL_TO.getName();
            }else{
                return Mard25Constant.HinhThucCB.MIN_MAX.getName();
            }
        }
    }

    public static String getLoaiHoSo(String loai){
        if (null==loai||loai.equals("")){
            return "";
        }
        switch (loai){
            case "1":
                return Mard25Constant.LoaiHS._2A.getName();
            case "2":
                return Mard25Constant.LoaiHS._2B.getName();
            case "3":
                return Mard25Constant.LoaiHS._2C.getName();
            case "4":
                return Mard25Constant.LoaiHS._2D.getName();
            default:
                return "";
        }
    }
}
