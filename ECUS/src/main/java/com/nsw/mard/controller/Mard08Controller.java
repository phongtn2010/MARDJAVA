package com.nsw.mard.controller;


import com.nsw.constant.AppConstant;
import com.nsw.controller.BaseController;
import com.nsw.mard.constant.Mard08Constant;
import com.nsw.most.constant.ThuTuc01Constant;
import com.nsw.security.UserCustom;
import com.nsw.service.RabbitMQService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

@Controller
@RequestMapping("/mard/08")
public class Mard08Controller extends BaseController {
    private static final Logger LOG = LoggerFactory.getLogger(Mard08Controller.class);
    private static final String TAG = "mard08Controller";

    @Autowired
    Environment environment;
    @Autowired
    MessageSource messageSource;
    @Autowired
    RabbitMQService rabbitMQService;

    @RequestMapping(value = {"/", "/home", "/index"}, method = RequestMethod.GET)
    public String indexPage(ModelMap model) {
        initData(model, null);
        return Mard08Constant.Page.HOME;
    }

    @RequestMapping(value = {"/view/{idHoSo}"}, method = RequestMethod.GET)
    public String viewHoso(ModelMap model, @PathVariable("idHoSo") Long idHoSo) {
        initData(model, null);
        return Mard08Constant.Page.VIEW;
    }


    @RequestMapping(value = {"/cert"}, method = RequestMethod.GET)
    public String thongtinGCN(ModelMap model) {
        initData(model, null);
        return Mard08Constant.Page.CERT;
    }


    private void initData(ModelMap model, UserCustom user) {
        model.addAttribute(AppConstant.DanhMuc.Sign, environment.getRequiredProperty(ThuTuc01Constant.EnableSign));
        model.addAttribute(AppConstant.DanhMuc.Version, AppConstant.getVersion());
//        model.addAttribute(AppConstant.DanhMuc.Menu, AppHelper.GetMenusForUser(user.getTabs(), environment.getRequiredProperty("nsw.fontend.url")));
//        model.addAttribute(AppConstant.DanhMuc.Applet, environment.getRequiredProperty(AppConstant.Common.APPLET));
//        model.addAttribute(AppConstant.DanhMuc.Sign, environment.getRequiredProperty(ThuTuc01Constant.EnableSign));
//        model.addAttribute(AppConstant.DanhMuc.Version, AppConstant.getVersion());
//        model.addAttribute(AppConstant.DanhMuc.UserName, user.getUsername());
//        HashMap customUser = new HashMap();
//        customUser.put("username", user.getUsername());
//        customUser.put("companyName",user.getCompanyName());
//        customUser.put("companyAddress", user.getCompanyAddress());
//        customUser.put("companyPhoneNumber", user.getCompanyPhoneNumber());
//        customUser.put("companyFax", user.getCompanyFax());
//        customUser.put("companyEmail", user.getCompanyEmail());
//        model.addAttribute(AppConstant.DanhMuc.User, GsonUtils.getInstance().serializer(customUser));
    }
}
