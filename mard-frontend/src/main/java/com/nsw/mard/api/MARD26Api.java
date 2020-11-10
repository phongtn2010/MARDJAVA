/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.mard.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.nsw.api.BaseApi;
import com.nsw.common.model.json.ResponseJson;
import com.nsw.constant.AppConstant;
import com.nsw.helper.BackendRequestHelper;
import com.nsw.helper.FileServiceHelper;
import com.nsw.helper.RabbitMQErrorHelper;
import com.nsw.helper.RabbitMQInfo;
import com.nsw.mard.constant.MARD26Constant;
import com.nsw.mard.constant.Mard25Constant;
import com.nsw.mard.p26.model.*;
import com.nsw.util.GsonUtils;
import com.nsw.util.LogUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;

@RestController
@RequestMapping("/mard/26")
public class MARD26Api extends BaseApi {

    static final String TAG = "MARD26Api";
    private static final int BUFFER_SIZE = 4096;
    FileServiceHelper fileHelper = new FileServiceHelper();

    @Autowired
    Environment environment;

    @RequestMapping(value = "/hanghoa/getlist", method = RequestMethod.GET)
    public @ResponseBody
    ResponseJson getHoSoByStatus(
            @RequestParam(name = "taxCode") String taxCode) {
        ResponseJson json = new ResponseJson();
        try {
            json = BackendRequestHelper.getInstance().doGetRequest(Mard25Constant.getInstance().getApiUrl(environment, MARD26Constant.API.SEARCH_PRODUCT_FROM_TACN) + "?taxCode="+taxCode );
            return json;
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
            json.setData(null);
            json.setSuccess(false);
            json.setMessage(ex.getMessage());
            return json;
        }
    }
}
