package com.nsw.mard.controller;

import com.nsw.constant.AppConstant;
import com.nsw.controller.BaseController;
import com.nsw.helper.AppHelper;
import com.nsw.mard.constant.MARD26Constant;
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Revo
 */
@Controller
@RequestMapping("/mard/26")
public class MARD26Controller extends BaseController {

    @Autowired
    Environment environment;
    @Autowired
    MessageSource messageSource;
    @Autowired
    RabbitMQService rabbitMQService;

    /**
     * Home page
     *
     * @param model
     * @return
     */
    @RequestMapping(value = {"/", "/home", "/index"}, method = RequestMethod.GET)
    public String indexPage(ModelMap model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            UserCustom user = (UserCustom) principal;
            initData(model, user);
        } else {
            return AppConstant.redirectPage(AppConstant.Pages.LOGOUT);
        }

        return MARD26Constant.ViewType.HOME;
    }

    /**
     * Create or Update document page
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(ModelMap model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            UserCustom user = (UserCustom) principal;
            initData(model, user);
            model.addAttribute("idHS",0);
        } else {
            return AppConstant.redirectPage(AppConstant.Pages.LOGOUT);
        }
        return MARD26Constant.ViewType.EDIT;
    }
    @RequestMapping(value = "/edit/{idHS}", method = RequestMethod.GET)
    public String edit(ModelMap model,@PathVariable Integer idHS) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            UserCustom user = (UserCustom) principal;
            initData(model, user);
            model.addAttribute("idHS",idHS);
        } else {
            return AppConstant.redirectPage(AppConstant.Pages.LOGOUT);
        }
        return MARD26Constant.ViewType.EDIT;
    }
    /**
     * View document page
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String view(ModelMap model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            UserCustom user = (UserCustom) principal;
            initData(model, user);
        } else {
            return AppConstant.redirectPage(AppConstant.Pages.LOGOUT);
        }
        return MARD26Constant.ViewType.VIEW;
    }

    /**
     * Khởi tạo dữ liệu
     *
     * @param model
     * @param user
     */
    private void initData(ModelMap model, UserCustom user) {
        model.addAttribute(AppConstant.DanhMuc.Menu, AppHelper.GetMenusForUser(user.getTabs(), environment.getRequiredProperty("nsw.fontend.url")));
        model.addAttribute(AppConstant.DanhMuc.Applet, environment.getRequiredProperty(AppConstant.Common.APPLET));
        model.addAttribute(AppConstant.DanhMuc.Sign, environment.getRequiredProperty(MARD26Constant.EnableSign));
        model.addAttribute(AppConstant.DanhMuc.Version, AppConstant.getVersion());
        model.addAttribute(AppConstant.DanhMuc.UserName, user.getUsername());
        HashMap customUser = new HashMap();
        customUser.put("username", user.getUsername());
        customUser.put("companyName", user.getCompanyName());
        customUser.put("companyAddress", user.getCompanyAddress());
        customUser.put("companyPhoneNumber", user.getCompanyPhoneNumber());
        customUser.put("companyFax", user.getCompanyFax());
        customUser.put("companyEmail", user.getCompanyEmail());
        model.addAttribute(AppConstant.DanhMuc.User, GsonUtils.getInstance().serializer(customUser));
    }
    
    private String getPage(String code, String viewType) {
        if (null == code || null == viewType) {
            return null;
        }

        switch (viewType) {
            case MARD26Constant.ViewType.HOME:
                return String.format(MARD26Constant.Pages.HOME_PATTERN, code);
            case MARD26Constant.ViewType.EDIT:
                return String.format(MARD26Constant.Pages.EDIT_PATTERN, code);
            default:
                return String.format(MARD26Constant.Pages.VIEW_PATTERN, code);
        }
    }
}
