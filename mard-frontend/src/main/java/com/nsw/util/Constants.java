/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.util;

/**
 *
 * @author Phong84NV
 */
public final class Constants {
    public static final String APP_NAME = "FRONTEND";
    
    public interface SIGN {
    	public static final String ON = "true";
    	public static final String OFF = "false";
    }
    
    /**
     * Status 0: delete;1: active
     */
    public interface Status {

        public static final Long ACTIVE = 1l;
        public static final Long INACTIVE = 0l;
        public static final Long DELETE = -1L;
    }

    public interface ErrorCode {
        public static final String SHEETINVAILD = "CODE"; 
        public static final String LOINGHIEPVU = "CODE0";        
        public static final String KHONGDUNGDINHDANG = "CODE1";
        public static final String KHONGCOGIATRI = "CODE2";
        public static final String VUOTQUACHIEUDAI = "CODE3";
        public static final String KHONGNHOHON_NGAYHIENTAI = "CODE4";
        public static final String V1_KHONGNHOHON_V2 = "CODE5";
    }
    
    public static final String MENU_SESSION = "MENU";

    public static final int PAGE_SIZE = 15;
    
    public interface CDATA {

        public static final String START_TAG = "<![CDATA[";
        public static final String END_TAG = "]]>";
    }
    
    public interface RESPONSETYPE {

        public static final String FUNCTION_01 = "01";
        public static final String TYPE_SUCCESS = "99";
        public static final String ERROR = "00";
    }
            
    public interface ENVELOP_TAG_ENCODE {

        public static final String OPEN_TAG = "&lt;Envelope&gt;";
        public static final String CLOSE_TAG = "&lt;/Envelope&gt;";
    }
    
    public interface TAG_ENCODE {

        public final static String OPEN_TAG = "&lt;";
        public static final String CLOSE_TAG = "&gt;";
        public static final String UNKNOW_TAG = "";
        public static final String AND_TAG = "&amp;";
    }
    
    public interface TAG_NO_ENCODE {

        public final static String OPEN_TAG = "<";
        public static final String CLOSE_TAG = ">";
        public static final String AND_TAG = "&";
    }
    public static final String MESSAGE_SEPARATOR_WITHOUT_FLASH = "{}";
    public static final String MESSAGE_SEPARATOR = "\\{}";
    public static final String MESSAGE_SEPARATOR_WITH_SLASH = "\\{}";
    
     public interface RES_METHOD {
        public static final String POST = "POST";
        public static final String PUT = "PUT";
        public static final String DELETE = "DELETE";
    }
}
