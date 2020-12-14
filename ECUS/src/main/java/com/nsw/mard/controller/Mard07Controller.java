package com.nsw.mard.controller;

import com.nsw.constant.AppConstant;
import com.nsw.helper.AppHelper;
import com.nsw.mard.constant.Mard07Constant;
import com.nsw.most.constant.ThuTuc01Constant;
import com.nsw.security.UserCustom;
import com.nsw.service.RabbitMQService;
import com.nsw.util.GsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.env.Environment;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;

@Controller
@RequestMapping("/mard/07")
public class Mard07Controller {
    private static final String ID_FILED = "idHoSo";

    @Autowired
    Environment environment;
    @Autowired
    MessageSource messageSource;
    @Autowired
    RabbitMQService rabbitMQService;

    @RequestMapping(value = {"/", "/home", "/index"}, method = RequestMethod.GET)
    public String indexPage(ModelMap model) {
        initData(model, null);
        return Mard07Constant.Page.HOME;
    }

    @RequestMapping(value = {"/view/{idHoSo}"}, method = RequestMethod.GET)
    public String viewHoso(ModelMap model, @PathVariable("idHoSo") Long idHoSo) {
        initData(model, null);
        return Mard07Constant.Page.VIEW;
    }

    private void initData(ModelMap model, UserCustom user) {
        model.addAttribute(AppConstant.DanhMuc.Sign, environment.getRequiredProperty(ThuTuc01Constant.EnableSign));
        model.addAttribute(AppConstant.DanhMuc.Version, AppConstant.getVersion());
    }
}
