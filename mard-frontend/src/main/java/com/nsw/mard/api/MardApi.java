package com.nsw.mard.api;

import com.nsw.common.model.json.ResponseJson;
import com.nsw.constant.AppConstant;
import com.nsw.helper.BackendRequestHelper;
import com.nsw.helper.RabbitMQErrorHelper;
import com.nsw.mard.comon.CmonSeafoodprocessors;
import com.nsw.mard.comon.FilterFormCmonSF;
import com.nsw.mard.constant.Mard06Constant;
import com.nsw.util.LogUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mard")
public class MardApi {
    @Autowired
    Environment environment;

    @RequestMapping(value = "/danhmuc/cssx", method = RequestMethod.POST)
    public @ResponseBody
    ResponseJson getCSSX(@RequestBody FilterFormCmonSF filterFormCmonSF) {
        ResponseJson json = new ResponseJson();
        try {
            json = BackendRequestHelper.getInstance().doPostRequest(environment.getRequiredProperty(Mard06Constant.API.BACKEND)+"/mard/danhmuc/cssx",filterFormCmonSF);
            return json;
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            json.setData(null);
            json.setSuccess(false);
            json.setMessage(ex.getMessage());
            return json;
        }
    }

    @RequestMapping(value = "/cssx/update", method = RequestMethod.POST)
    public @ResponseBody
    ResponseJson updateCSSX(@RequestBody CmonSeafoodprocessors cmonSeafoodprocessors) {
        ResponseJson json = new ResponseJson();
        try {
            json = BackendRequestHelper.getInstance().doPostRequest(environment.getRequiredProperty(Mard06Constant.API.BACKEND)+"/mard/danhmuc/cssx/update",cmonSeafoodprocessors);
            return json;
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            json.setData(null);
            json.setSuccess(false);
            json.setMessage(ex.getMessage());
            return json;
        }
    }

    @RequestMapping(value = "/cssx/delete", method = RequestMethod.POST)
    public @ResponseBody
    ResponseJson deleteCSSX(@RequestBody CmonSeafoodprocessors cmonSeafoodprocessors) {
        ResponseJson json = new ResponseJson();
        try {
            json = BackendRequestHelper.getInstance().doPostRequest(environment.getRequiredProperty(Mard06Constant.API.BACKEND)+"/mard/danhmuc/cssx/delete",cmonSeafoodprocessors);
            return json;
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            json.setData(null);
            json.setSuccess(false);
            json.setMessage(ex.getMessage());
            return json;
        }
    }
}
