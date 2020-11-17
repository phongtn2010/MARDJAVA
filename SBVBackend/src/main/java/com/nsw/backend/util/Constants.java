package com.nsw.backend.util;

public final class Constants {

    /**
     * Status 0: delete; 1: active
     */
    public interface Status {

        public static final Long PREACTIVE = 2L;
        public static final Long ACTIVE = 1L;
        public static final Long INACTIVE = 0L;
        public static final Long DELETE = -1L;
    }

    public interface Roles { // Role to get Dictionaries

        public static final Long MONRE = 6L;
    }
    
    public interface MATHUTUC {
        public static final String BTNMT6 = "BTNMT0600006";
    }

    public interface PROCEDURE {
    	
        public static final String THUTUC6 = "PL";//Thu tuc 06 - to be define
        public static final String THUTUC7 = "CT";//Thu tuc 07 - to be define
    }

    public interface EXTEND {

        public static final String EXCEL = "xlsx";
        public static final String PDF = "pdf";
        public static final String DOC = "doc";
        public static final String DOCX = "docx";
    }

    public interface UPLOAD {
        public static final String PATH_UPLOAD = "PATH_UPLOAD";
    }

    public interface DOWNLOAD {
    	public static final String URL_DOWNLOAD = "URL_DOWNLOAD";
    }

    public interface ERR {

        public static final String ERR_01_CODE = "01";
        public static final String ERR_01_NAME = "Lỗi khi đọc file";
    }

    public interface DONVI {

        public static final String NSW = "NSW";
        public static final String TNMT = "TNMT";
    }
    
    public static final String APP_NAME = "MONREBackend";
    public static final String MESSAGE_SEPARATOR = "\\{}";

}
