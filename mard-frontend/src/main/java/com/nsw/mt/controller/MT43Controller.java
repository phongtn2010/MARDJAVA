package com.nsw.mt.controller;

import com.nsw.constant.AppConstant;
import com.nsw.controller.BaseController;
import com.nsw.helper.AppHelper;
import com.nsw.mt.constant.MT43Constant;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author AnPhucNguyen
 */
@Controller
@RequestMapping(MT43Constant.Routes.ROOT)
public class MT43Controller extends BaseController {

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
    @RequestMapping(value = {MT43Constant.View.HOME, MT43Constant.View.INDEX}, method = RequestMethod.GET)
    public String indexPage(ModelMap model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            UserCustom user = (UserCustom) principal;
            initData(model, user);
        } else {
            return AppConstant.redirectPage(AppConstant.Pages.LOGOUT);
        }
        return MT43Constant.Pages.HOME;
    }

    /**
     * Create or Update document page
     *
     * @param code
     * @param model
     * @return
     */
    @RequestMapping(value = {MT43Constant.View.EDIT}, method = RequestMethod.GET)
    public String create(ModelMap model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            UserCustom user = (UserCustom) principal;
            initData(model, user);
        } else {
            return AppConstant.redirectPage(AppConstant.Pages.LOGOUT);
        }
        return MT43Constant.Pages.EDIT;
    }

    /**
     * View document page
     *
     * @param code
     * @param model
     * @return
     */
    @RequestMapping(value = {MT43Constant.View.VIEW}, method = RequestMethod.GET)
    public String view(ModelMap model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            UserCustom user = (UserCustom) principal;
            initData(model, user);
        } else {
            return AppConstant.redirectPage(AppConstant.Pages.LOGOUT);
        }
        return MT43Constant.Pages.VIEW;
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
        model.addAttribute(AppConstant.DanhMuc.Sign, environment.getRequiredProperty(MT43Constant.EnableSign));
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
}
