package com.nsw.backend.util;

public final class Constants {

    /**
     * Status 0: delete; 1: active
     */
    public interface Status {

        public static final Long ACTIVE = 1L;
        public static final Long INACTIVE = 0L;
        public static final Long DELETE = -1L;
        public static final Long COMPLETED = 1L;
        public static final Long INCOMPLETE = 0L;
    }

    public interface Roles { // Role to get Dictionaries

        public static final Long MOST = 8L;
    }

    public interface PROCEDURE {

        public static final String THUTUC1 = "QG";//Thu tuc 01
        public static final String THUTUC2 = "QQ";//Thu tuc 02 - to be define
    }

    public interface EXTEND {

        public static final String EXCEL = "xlsx";
        public static final String PDF = "pdf";
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
        public static final String KHCN = "KHCN";
    }

    public static final String APP_NAME = "MARDBackend";
    public static final String MESSAGE_SEPARATOR = "\\{}";

}
