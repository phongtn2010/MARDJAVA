package com.nsw.mard.controller;

import com.nsw.constant.AppConstant;
import com.nsw.controller.BaseController;
import com.nsw.helper.AppHelper;
import com.nsw.mard.constant.MARD12Constant;
import com.nsw.security.UserCustom;
import com.nsw.service.RabbitMQService;
import com.nsw.util.GsonUtils;
import java.util.HashMap;
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
@RequestMapping(MARD12Constant.Routes.ROOT)
public class MARD12Controller extends BaseController {

    @Autowired
    Environment environment;
    @Autowired
    MessageSource messageSource;
    @Autowired
    RabbitMQService rabbitMQService;

    /**
     * Home page
     *
     * @param code
     * @param model
     * @return
     */
    @RequestMapping(value = {MARD12Constant.View.HOME, MARD12Constant.View.INDEX}, method = RequestMethod.GET)
    public String indexPage(@PathVariable String code, ModelMap model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            UserCustom user = (UserCustom) principal;
            initData(model, user);
        } else {
            return AppConstant.redirectPage(AppConstant.Pages.LOGOUT);
        }
        String page = getPage(code, MARD12Constant.ViewType.HOME);
        return page;
    }

    /**
     * Create or Update document page
     *
     * @param code
     * @param model
     * @return
     */
    @RequestMapping(value = {MARD12Constant.View.EDIT}, method = RequestMethod.GET)
    public String create(@PathVariable String code, ModelMap model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            UserCustom user = (UserCustom) principal;
            initData(model, user);
        } else {
            return AppConstant.redirectPage(AppConstant.Pages.LOGOUT);
        }
        String page = getPage(code, MARD12Constant.ViewType.EDIT);
        return page;
    }

    /**
     * View document page
     *
     * @param code
     * @param model
     * @return
     */
    @RequestMapping(value = {MARD12Constant.View.VIEW}, method = RequestMethod.GET)
    public String view(@PathVariable String code, ModelMap model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            UserCustom user = (UserCustom) principal;
            initData(model, user);
        } else {
            return AppConstant.redirectPage(AppConstant.Pages.LOGOUT);
        }
        String page = getPage(code, MARD12Constant.ViewType.VIEW);
        return page;
    }

    /**
     * Khởi tạo dữ liệu
     *
     * @param model
     * @param helper
     * @param user
     */
    private void initData(ModelMap model, UserCustom user) {
        model.addAttribute(AppConstant.DanhMuc.Menu, AppHelper.GetMenusForUser(user.getTabs(), environment.getRequiredProperty("nsw.fontend.url")));
        model.addAttribute(AppConstant.DanhMuc.Applet, environment.getRequiredProperty(AppConstant.Common.APPLET));
        model.addAttribute(AppConstant.DanhMuc.Sign, environment.getRequiredProperty(MARD12Constant.EnableSign));
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
            case MARD12Constant.ViewType.HOME:
                return String.format(MARD12Constant.Pages.HOME_PATTERN, code);
            case MARD12Constant.ViewType.EDIT:
                return String.format(MARD12Constant.Pages.EDIT_PATTERN, code);
            default:
                return String.format(MARD12Constant.Pages.VIEW_PATTERN, code);
        }
    }
}
