/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.mard.controller;

import com.nsw.constant.AppConstant;
import com.nsw.controller.BaseController;
import com.nsw.helper.AppHelper;
import com.nsw.mard.constant.Mard02Constant;
import com.nsw.moit.constant.MOIT01Constant;
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
 *
 * @author Trinhnd
 */
@Controller
@RequestMapping(Mard02Constant.Routes.ROOT_HOME)
public class Mard02Controller extends BaseController {

    @Autowired
    Environment environment;
    @Autowired
    MessageSource messageSource;
    @Autowired
    RabbitMQService rabbitMQService;

    @RequestMapping(value = {Mard02Constant.View.HOME, Mard02Constant.View.INDEX}, method = RequestMethod.GET)
    public String index(ModelMap model) {
        initData(model, null);
        return Mard02Constant.Pages.HOME;
    }

    @RequestMapping(value = {Mard02Constant.View.EDIT}, method = RequestMethod.GET)
    public String addNew(ModelMap model) {
        initData(model, null);
        return Mard02Constant.Pages.EDIT;
    }

    @RequestMapping(value = {Mard02Constant.View.VIEW}, method = RequestMethod.GET)
    public String viewData(ModelMap model) {
        initData(model, null);
        return Mard02Constant.Pages.VIEW;
    }

    @RequestMapping(value = {Mard02Constant.View.VIEW_GP}, method = RequestMethod.GET)
    public String viewGP(ModelMap model) {
        initData(model, null);
        return Mard02Constant.Pages.VIEW_GP;
    }

    @RequestMapping(value = {Mard02Constant.View.CHARGE}, method = RequestMethod.GET)
    public String viewCharge(ModelMap model) {
        initData(model, null);
        return Mard02Constant.Pages.CHARGE;
    }
    
    @RequestMapping(value = {Mard02Constant.View.MAU_GIAY_DK}, method = RequestMethod.GET)
    public String mauGiayDangKy(ModelMap model) {
        initData(model, null);
        return Mard02Constant.Pages.MAU_GIAY_DK;
    }
    @RequestMapping(value = {Mard02Constant.View.MAU_GIAY_XNCL}, method = RequestMethod.GET)
    public String mauGiayXNCL(ModelMap model) {
        initData(model, null);
        return Mard02Constant.Pages.MAU_GIAY_XNCL;
    }
    @RequestMapping(value = {Mard02Constant.View.MAU_GIAY_CNKD}, method = RequestMethod.GET)
    public String mauGiayCNKD(ModelMap model) {
        initData(model, null);
        return Mard02Constant.Pages.MAU_GIAY_CNKD;
    }
    @RequestMapping(value = {Mard02Constant.View.MAU_GIAY_TAMCAP}, method = RequestMethod.GET)
    public String mauGiayTamCap(ModelMap model) {
        initData(model, null);
        return Mard02Constant.Pages.MAU_GIAY_TAMCAP;
    }
    @RequestMapping(value = {Mard02Constant.View.MAU_GIAY_GIULAI}, method = RequestMethod.GET)
    public String mauGiayGiuLaiVaXuLy(ModelMap model) {
        initData(model, null);
        return Mard02Constant.Pages.MAU_GIAY_GIULAI;
    }

    private void initData(ModelMap model, UserCustom user) {
//        model.addAttribute(AppConstant.DanhMuc.Menu, AppHelper.GetMenusForUser(user.getTabs(), environment.getRequiredProperty("nsw.fontend.url")));
//        model.addAttribute(AppConstant.DanhMuc.Applet, environment.getRequiredProperty(AppConstant.Common.APPLET));
        model.addAttribute(AppConstant.DanhMuc.Sign, environment.getRequiredProperty(MOIT01Constant.EnableSign));
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
