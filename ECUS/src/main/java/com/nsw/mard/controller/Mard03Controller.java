/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.mard.controller;

import com.nsw.constant.AppConstant;
import com.nsw.controller.BaseController;
import com.nsw.helper.AppHelper;
import com.nsw.mard.constant.Mard03Constant;
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
 * @author TamDT
 */
@Controller
@RequestMapping(Mard03Constant.Routes.ROOT_HOME)
public class Mard03Controller extends BaseController {

    @Autowired
    Environment environment;
    @Autowired
    MessageSource messageSource;
    @Autowired
    RabbitMQService rabbitMQService;

    @RequestMapping(value = {Mard03Constant.View.HOME, Mard03Constant.View.INDEX}, method = RequestMethod.GET)
    public String index(ModelMap model) {
        initData(model, null);
        return Mard03Constant.Pages.HOME;
    }

    @RequestMapping(value = {Mard03Constant.View.EDIT}, method = RequestMethod.GET)
    public String addNew(ModelMap model) {
        initData(model, null);
        return Mard03Constant.Pages.EDIT;
    }

    @RequestMapping(value = {Mard03Constant.View.VIEW}, method = RequestMethod.GET)
    public String viewData(ModelMap model) {
        initData(model, null);
        return Mard03Constant.Pages.VIEW;
    }

    @RequestMapping(value = {Mard03Constant.View.VIEW_GP}, method = RequestMethod.GET)
    public String viewGP(ModelMap model) {
        initData(model, null);
        return Mard03Constant.Pages.VIEW_GP;
    }

    @RequestMapping(value = {Mard03Constant.View.CHARGE}, method = RequestMethod.GET)
    public String viewCharge(ModelMap model) {
        initData(model, null);
        return Mard03Constant.Pages.CHARGE;
    }

    @RequestMapping(value = {Mard03Constant.View.MAU_GIAY_CNHAN}, method = RequestMethod.GET)
    public String mauGiayCna(ModelMap model) {
        initData(model, null);
        return Mard03Constant.Pages.MAU_GIAY_CNHAN;
    }

    @RequestMapping(value = {Mard03Constant.View.MAU_GIAY_CNHANB}, method = RequestMethod.GET)
    public String mauGiayCnb(ModelMap model) {
        initData(model, null);
        return Mard03Constant.Pages.MAU_GIAY_CNHANB;
    }

    @RequestMapping(value = {Mard03Constant.View.MAU_DON_KIEMDICH}, method = RequestMethod.GET)
    public String mauDonkiemdich(ModelMap model) {
        initData(model, null);
        return Mard03Constant.Pages.MAU_DON_KIEMDICH;
    }

    @RequestMapping(value = {Mard03Constant.View.DON_XIN_CK}, method = RequestMethod.GET)
    public String donXinCk(ModelMap model) {
        initData(model, null);
        return Mard03Constant.Pages.DON_XIN_CK;
    }

    @RequestMapping(value = {Mard03Constant.View.CVAN_CK}, method = RequestMethod.GET)
    public String congVanChuyenCK(ModelMap model) {
        initData(model, null);
        return Mard03Constant.Pages.CVAN_CK;
    }

    //todo
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
