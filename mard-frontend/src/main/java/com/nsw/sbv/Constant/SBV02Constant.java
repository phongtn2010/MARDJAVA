package com.nsw.sbv.Constant;
import com.nsw.mard.constant.Mard06Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

public class SBV02Constant {
    static SBV02Constant instance;
    public static final String EnableSign = "nsw.sbv.02.sign";
    public static SBV02Constant getInstance() {
        synchronized (SBV02Constant.class) {
            if (instance == null) {
                instance = new SBV02Constant();
            }
            return instance;
        }
    }
    @Autowired
    Environment environment;

    public static class Page {
        private Page(){

        }
        public static final String HOME = "sbv.02.home";
        public static final String CREATE = "sbv.02.create";
        public static final String EDIT = "mard.06.edit";
        public static final String VIEW = "mard.06.view";
    }
    public static class API {

        private API(){

        }
        public static final String VANG = "sbv.02.danhmuc.vang";
        public static final String BACKEND = "sbv.api.backend.dev";
        public static final String CUAKHAU = "sbv.02.danhmuc.cuakhau";
        public static final String HOSO_CREATE = "sbv.02.tbdhosovang2.create";
        public static final String DVT = "sbv.02.danhmuc.dvt";
        public static final String TIENTE = "sbv.02.danhmuc.tiente";



    }
    public String getApiUrl(Environment environment, String key) {
        return environment.getRequiredProperty(SBV02Constant.API.BACKEND) + environment.getRequiredProperty(key);
    }
}
