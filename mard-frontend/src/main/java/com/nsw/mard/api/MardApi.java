package com.nsw.mard.api;

import com.nsw.common.model.json.ResponseJson;
import com.nsw.constant.AppConstant;
import com.nsw.helper.BackendRequestHelper;
import com.nsw.helper.RabbitMQErrorHelper;
import com.nsw.mard.constant.Mard06Constant;
import com.nsw.util.LogUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mard")
public class MardApi {
    @Autowired
    Environment environment;
    @RequestMapping(value = "/cssx/find/", method = RequestMethod.GET)
    public @ResponseBody
    ResponseJson getCountry(

    ) {
        ResponseJson json = new ResponseJson();
        try {
            json = BackendRequestHelper.getInstance().doGetRequest(environment.getRequiredProperty(Mard06Constant.API.BACKEND)+"/mard/cssx/find/");
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
