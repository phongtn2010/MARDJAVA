/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.moh.controller;

import com.nsw.constant.AppConstant;
import com.nsw.controller.BaseController;
import com.nsw.helper.AppHelper;
import com.nsw.moh.constant.Moh03Constant;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;

/**
 * @author HuongMK
 */
@Controller
@RequestMapping(Moh03Constant.Routes.ROOT_HOME)
public class Moh03Controller extends BaseController {

    @Autowired
    Environment environment;
    @Autowired
    MessageSource messageSource;
    @Autowired
    RabbitMQService rabbitMQService;

    @RequestMapping(value = {Moh03Constant.View.HOME, Moh03Constant.View.INDEX}, method = RequestMethod.GET)
    public String index(ModelMap model) {
        initData(model, null);
        return Moh03Constant.Pages.HOME;
    }

    @RequestMapping(value = {Moh03Constant.View.EDIT}, method = RequestMethod.GET)
    public String addNew(ModelMap model) {
        initData(model, null);
        return Moh03Constant.Pages.EDIT;
    }

    @RequestMapping(value = {Moh03Constant.View.VIEW}, method = RequestMethod.GET)
    public String viewData(ModelMap model) {
        initData(model, null);
        return Moh03Constant.Pages.VIEW;
    }

    @RequestMapping(value = {Moh03Constant.View.VIEW_GP}, method = RequestMethod.GET)
    public String viewGP(ModelMap model) {
        initData(model, null);
        return Moh03Constant.Pages.VIEW_GP;
    }

    private void initData(ModelMap model, UserCustom user) {
//        model.addAttribute(AppConstant.DanhMuc.Menu, AppHelper.GetMenusForUser(user.getTabs(), environment.getRequiredProperty("nsw.fontend.url")));
//        model.addAttribute(AppConstant.DanhMuc.Applet, environment.getRequiredProperty(AppConstant.Common.APPLET));
        model.addAttribute(AppConstant.DanhMuc.Sign, environment.getRequiredProperty(Moh03Constant.EnableSign));
        model.addAttribute(AppConstant.DanhMuc.Version, AppConstant.getVersion());
//        model.addAttribute(AppConstant.DanhMuc.UserName, user.getUsername());
//        HashMap customUser = new HashMap();
//        customUser.put("username", user.getUsername());
//        customUser.put("companyName", user.getCompanyName());
//        customUser.put("companyAddress", user.getCompanyAddress());
//        customUser.put("companyPhoneNumber", user.getCompanyPhoneNumber());
//        customUser.put("companyFax", user.getCompanyFax());
//        customUser.put("companyEmail", user.getCompanyEmail());
//        model.addAttribute(AppConstant.DanhMuc.User, GsonUtils.getInstance().serializer(customUser));
    }

}
