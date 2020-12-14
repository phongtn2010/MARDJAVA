/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.ws.util;

import java.text.SimpleDateFormat;

/**
 *
 * @author QUANGNV18
 */
public class Constants {
    public static final int BUFFER_SIZE = 4096;
    
    public interface GOV {
        public static final String BKHCN = "BKHCN";
    }
    
    public interface LOCAL_WEBSERVICE {
        public static final String PREFIX_NAMESPACE_KEY = "_NAMESPACE_KEY";
        public static final String PREFIX_URI = "_LINK";
        public static final String PREFIX_NAMESPACE = "_NAMESPACE";
        public static final String PREFIX_METHOD_TAG = "_METHOD_TAG";
        public static final String PREFIX_PAYLOAD_TAG = "_PAYLOAD_TAG";
        public static final String NAMESPACE_URI = "http://com/vnsw/send/gateway/generated";
        public static final String COMMON_METHOD_TAG = "receiveRequest";
        public static final String PREFIX_NAMESPACE_KEY_METHOD_TAG = "_NAMESPACE_KEY_METHOD_TAG";
        public static final String PREFIX_NAMESPACE_KEY_PAYLOAD_TAG = "_NAMESPACE_KEY_PAYLOAD_TAG";
        public static final String PREFIX_SOAP_ACTION = "_ACTION";
    }
    
    public interface FUNCTION {
        public static final String FUNC_SUCCESS = "99";
        public static final String FUNC_ERROR = "00";
    }
    public interface VERSION {

        public static final String SEND_VERSION = "1.0";
        public static final String RECEIVE_VERSION = "1.0";
    }
    public static final SimpleDateFormat formatterYear = new SimpleDateFormat("yyyy");
    public static final SimpleDateFormat formatterDateTime = new SimpleDateFormat(
            "yyyy-MM-dd HH:mm:ss");

    public static final String APP_NAME = "FRONTEND";
    public static final String MESSAGE_SEPARATOR = "\\{}";
}
