package com.nsw.mard.controller;


import com.nsw.constant.AppConstant;
import com.nsw.controller.BaseController;
import com.nsw.helper.AppHelper;
import com.nsw.mard.constant.Mard07Constant;
import com.nsw.mard.constant.Mard08Constant;
import com.nsw.most.constant.ThuTuc01Constant;
import com.nsw.security.UserCustom;
import com.nsw.service.RabbitMQService;
import com.nsw.util.GsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

@Controller
@RequestMapping("/mard/08")
public class Mard08Controller extends BaseController{
    private static final String ID_FIELD = "idHoSo";

    @Autowired
    Environment environment;

    @Autowired
    RabbitMQService rabbitMQService;

    @RequestMapping(value = {"/", "/home", "/index"}, method = RequestMethod.GET)
    public String indexPage(ModelMap model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            UserCustom user = (UserCustom) principal;
            initData(model, user);
        } else {
            return AppConstant.redirectPage(AppConstant.Pages.LOGOUT);
        }
        return Mard08Constant.Page.HOME;
    }

    @RequestMapping(value = {"/create"}, method = RequestMethod.GET)
    public String create(ModelMap model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            UserCustom user = (UserCustom) principal;
            initData(model, user);
        } else {
            return AppConstant.redirectPage(AppConstant.Pages.LOGOUT);
        }
        return Mard08Constant.Page.CREATE;
    }

    @RequestMapping(value = {"/edit/{idHoSo}"}, method = RequestMethod.GET)
    public String editHoso(ModelMap model, @PathVariable("idHoSo") Long idHoSo) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            UserCustom user = (UserCustom) principal;
            initData(model, user);
            model.addAttribute(ID_FIELD, idHoSo);
        } else {
            return AppConstant.redirectPage(AppConstant.Pages.LOGOUT);
        }
        return Mard08Constant.Page.EDIT;
    }

    @RequestMapping(value = {"/ycs/{idHoSo}"}, method = RequestMethod.GET)
    public String requestEditHoso(ModelMap model, @PathVariable("idHoSo") Long idHoSo) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            UserCustom user = (UserCustom) principal;
            initData(model, user);
            model.addAttribute(ID_FIELD, idHoSo);
        } else {
            return AppConstant.redirectPage(AppConstant.Pages.LOGOUT);
        }
        return Mard08Constant.Page.YCS;
    }

    @RequestMapping(value = {"/view/{idHoSo}"}, method = RequestMethod.GET)
    public String viewHoso(ModelMap model, @PathVariable("idHoSo") Long idHoSo) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            UserCustom user = (UserCustom) principal;
            initData(model, user);
            model.addAttribute(ID_FIELD, idHoSo);
        } else {
            return AppConstant.redirectPage(AppConstant.Pages.LOGOUT);
        }
        return Mard08Constant.Page.VIEW;
    }


    @RequestMapping(value = {"/cert"}, method = RequestMethod.GET)
    public String thongtinGCN(ModelMap model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            UserCustom user = (UserCustom) principal;
            initData(model, user);
        } else {
            return AppConstant.redirectPage(AppConstant.Pages.LOGOUT);
        }
        return Mard08Constant.Page.CERT;
    }


    private void initData(ModelMap model, UserCustom user) {
        model.addAttribute(AppConstant.DanhMuc.Menu, AppHelper.GetMenusForUser(user.getTabs(), environment.getRequiredProperty("nsw.fontend.url")));
        model.addAttribute(AppConstant.DanhMuc.Applet, environment.getRequiredProperty(AppConstant.Common.APPLET));
        model.addAttribute(AppConstant.DanhMuc.Sign, environment.getRequiredProperty(Mard07Constant.EnableSign));
        model.addAttribute(AppConstant.DanhMuc.Version, AppConstant.getVersion());
        model.addAttribute(AppConstant.DanhMuc.UserName, user.getUsername());
        HashMap customUser = new HashMap();
        customUser.put("username", user.getUsername());
        customUser.put("companyName",user.getCompanyName());
        customUser.put("companyAddress", user.getCompanyAddress());
        customUser.put("companyPhoneNumber", user.getCompanyPhoneNumber());
        customUser.put("companyFax", user.getCompanyFax());
        customUser.put("companyEmail", user.getCompanyEmail());
        model.addAttribute(AppConstant.DanhMuc.User, GsonUtils.getInstance().serializer(customUser));
    }
}
