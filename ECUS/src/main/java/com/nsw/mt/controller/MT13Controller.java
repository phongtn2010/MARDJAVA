package com.nsw.mt.controller;

import com.nsw.constant.AppConstant;
import com.nsw.controller.BaseController;
import com.nsw.mt.constant.MT13Constant;
import com.nsw.security.UserCustom;
import com.nsw.service.RabbitMQService;
import com.nsw.util.GsonUtils;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.env.Environment;
import org.springframework.security.core.context.SecurityContextHolder;
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
 * @author AnPhucNguyen
 */
@Controller
@RequestMapping(MT13Constant.Routes.ROOT)
public class MT13Controller extends BaseController {

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
    @RequestMapping(value = {MT13Constant.View.HOME, MT13Constant.View.INDEX}, method = RequestMethod.GET)
    public String indexPage(@PathVariable String code, ModelMap model) {
//        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        if (principal instanceof UserDetails) {
//            UserCustom user = (UserCustom) principal;
//            initData(model, user);
//        } else {
//            return AppConstant.redirectPage(AppConstant.Pages.LOGOUT);
//        }
        initData(model, null);
        String page = getPage(code, MT13Constant.ViewType.HOME);
        return page;
    }

    /**
     * Create or Update document page
     *
     * @param code
     * @param model
     * @return
     */
    @RequestMapping(value = {MT13Constant.View.EDIT}, method = RequestMethod.GET)
    public String create(@PathVariable String code, ModelMap model) {
//        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        if (principal instanceof UserDetails) {
//            UserCustom user = (UserCustom) principal;
//            initData(model, user);
//        } else {
//            return AppConstant.redirectPage(AppConstant.Pages.LOGOUT);
//        }
        initData(model, null);
        String page = getPage(code, MT13Constant.ViewType.EDIT);
        return page;
    }

    /**
     * View document page
     *
     * @param code
     * @param model
     * @return
     */
    @RequestMapping(value = {MT13Constant.View.VIEW}, method = RequestMethod.GET)
    public String view(@PathVariable String code, ModelMap model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        if (principal instanceof UserDetails) {
//            UserCustom user = (UserCustom) principal;
//            initData(model, user);
//        } else {
//            return AppConstant.redirectPage(AppConstant.Pages.LOGOUT);
//        }
        initData(model, null);
        String page = getPage(code, MT13Constant.ViewType.VIEW);
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
        //model.addAttribute(AppConstant.DanhMuc.Menu, AppHelper.GetMenusForUser(user.getTabs(), environment.getRequiredProperty("nsw.fontend.url")));
        model.addAttribute(AppConstant.DanhMuc.Applet, environment.getRequiredProperty(AppConstant.Common.APPLET));
        model.addAttribute(AppConstant.DanhMuc.Sign, environment.getRequiredProperty(MT13Constant.EnableSign));
        model.addAttribute(AppConstant.DanhMuc.Version, AppConstant.getVersion());
        //model.addAttribute(AppConstant.DanhMuc.UserName, user.getUsername());
        HashMap customUser = new HashMap();
//        customUser.put("username", user.getUsername());
//        customUser.put("companyName", user.getCompanyName());
//        customUser.put("companyAddress", user.getCompanyAddress());
//        customUser.put("companyPhoneNumber", user.getCompanyPhoneNumber());
//        customUser.put("companyFax", user.getCompanyFax());
//        customUser.put("companyEmail", user.getCompanyEmail());
        model.addAttribute(AppConstant.DanhMuc.User, GsonUtils.getInstance().serializer(customUser));
    }

    private String getPage(String code, String viewType) {
        if (null == code || null == viewType) {
            return null;
        }

        switch (viewType) {
            case MT13Constant.ViewType.HOME:
                return String.format(MT13Constant.Pages.HOME_PATTERN, code);
            case MT13Constant.ViewType.EDIT:
                return String.format(MT13Constant.Pages.EDIT_PATTERN, code);
            default:
                return String.format(MT13Constant.Pages.VIEW_PATTERN, code);
        }
    }
}
