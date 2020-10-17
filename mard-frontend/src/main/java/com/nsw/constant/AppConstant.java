/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.constant;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author PhongNguyen
 */
public class AppConstant {

    public static final String URL_UPLOAD = "/file/upload";
    public static final String URL_DOWNLOAD = "/file/download";

    public interface RABBITMQ_LOG {

        public final static String RABBIT_HOST = "localhost";
        public static final String EXCHANGE_NAME = "logExchange";
        public static final String QUEUE_LOG_ERROR_NAME = "Log_Error_Queue";
        public static final String ROUTING_KEY_ERROR = "error";
    }

    public static final String APP_NAME = "NSWFrontend";
    public static final String MESSAGE_SEPARATOR = "\\{}";

    public interface Common {

        public static final String APPLET = "nsw.applet.path";
        public static final String ISSIGN = "nsw.sign";
        public static final String COMMONURL = "nsw.common.url";
        public static final String BREADCRUMB = "breadcrumbs";
        public static final String FILESERVICES = "nsw.file.services.url";
    }

    public interface Breadcrumb {

        public static final String HOME = "nsw.breadcrumb.home";
        public static final String LIST = "nsw.breadcrumb.list";
        public static final String DETAIL = "nsw.breadcrumb.detail";
    }

    public interface DateTime {

        public static final String yyyyMMddhhmmss = "yyyyMMddhhmmss";
    }

    public interface API {

        public static final String NSW_API_TOKHAI = "nsw.api.tokhai";
        public static final String NSW_API_DSHQ = "nsw.api.danhsachhq";
    }

    public interface Pages {

        public static final String HOME = "nsw.page.home";
        public static final String LOGIN = "nsw.page.login";
        public static final String LOGOUT = "login?logout";
        public static final String ERROR = "nsw.page.error";
        public static final String ACCESSDINED = "nsw.page.accessdenied";
        public static final String NOTFOUND = "nsw.page.notfound";
        public static final String TESTCA = "nsw.page.testca";
    }

    public interface ControllerURI {
        public static final String ROOT = "/";
        public static final String HOME = "/home";
        public static final String INDEX = "/index";
        public static final String LOGIN = "/login";
        public static final String LOGOUT = "/logout";
        public static final String NOACCESS = "/noaccess";
        public static final String ERROR = "/error";
        public static final String NOTFOUND = "/notfound";

        public static final String CATEST = "/ca";
    }

    public interface Folder {
        public static final String TemSaveFolder = "nsw.fontend.tempfolder";
    }

    public interface Download {
        public static final String TemSaveFolder = "nsw.fontend.tempfolder";
    }

    public interface DanhMuc {
        public static final String QuyChuanVietNam = "qcvn";
        public static final String DonViTinh = "dvt";
        public static final String QuocGia = "quocgia";
        public static final String Menu = "tabs";

        public static final String UserName = "loggedinuser";
        public static final String Version = "version";
        public static final String Applet = "applet";
        public static final String Sign = "sign";
        public static final String User = "user";
        public static final String UPLOAD_URL = "upload";
    }

    public interface Display {

        public static final String Hide = "none";
        public static final String Show = " ";
        public static final String HideImportName = "hideImport";
        public static final String IsView = "IsView";
    }

    public static String redirectPage(String pageName) {
        return "redirect:/" + pageName;
    }

    public static String getVersion() {
        SimpleDateFormat formatter = new SimpleDateFormat(AppConstant.DateTime.yyyyMMddhhmmss);
        Date today = Calendar.getInstance().getTime();
        return formatter.format(today);
    }
}
