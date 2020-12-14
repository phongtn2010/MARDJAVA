package com.nsw.moit.controller;

import com.nsw.constant.AppConstant;
import com.nsw.controller.BaseController;
import com.nsw.moit.constant.MOIT05Constant;
import com.nsw.security.UserCustom;
import com.nsw.service.RabbitMQService;
import com.nsw.util.GsonUtils;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.env.Environment;
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
@RequestMapping(MOIT05Constant.Routes.ROOT_HOME)
public class MOIT05Controller extends BaseController {

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
    @RequestMapping(value = {MOIT05Constant.View.HOME, MOIT05Constant.View.INDEX}, method = RequestMethod.GET)
    public String indexPage(ModelMap model) {
//        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        if (principal instanceof UserDetails) {
//            UserCustom user = (UserCustom) principal;
//            initData(model, user);
//        } else {
//            return AppConstant.redirectPage(AppConstant.Pages.LOGOUT);
//        }
        initData(model, null);
        return MOIT05Constant.Pages.HOME;
    }

    /**
     * View document page
     *
     * @param code
     * @param model
     * @return
     */
    @RequestMapping(value = {MOIT05Constant.View.VIEW}, method = RequestMethod.GET)
    public String view(ModelMap model) {
//        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        if (principal instanceof UserDetails) {
//            UserCustom user = (UserCustom) principal;
//            initData(model, user);
//        } else {
//            return AppConstant.redirectPage(AppConstant.Pages.LOGOUT);
//        }
        initData(model, null);
        return MOIT05Constant.Pages.VIEW;
    }

    /**
     * Khởi tạo dữ liệu
     *
     * @param model
     * @param helper
     * @param user
     */
    private void initData(ModelMap model, UserCustom user) {
//        model.addAttribute(AppConstant.DanhMuc.Menu, AppHelper.GetMenusForUser(user.getTabs(), environment.getRequiredProperty("nsw.fontend.url")));
        model.addAttribute(AppConstant.DanhMuc.Applet, environment.getRequiredProperty(AppConstant.Common.APPLET));
        model.addAttribute(AppConstant.DanhMuc.Sign, environment.getRequiredProperty(MOIT05Constant.EnableSign));
        model.addAttribute(AppConstant.DanhMuc.Version, AppConstant.getVersion());
//        model.addAttribute(AppConstant.DanhMuc.UserName, user.getUsername());
        HashMap customUser = new HashMap();
//        customUser.put("username", user.getUsername());
//        customUser.put("companyName", user.getCompanyName());
//        customUser.put("companyAddress", user.getCompanyAddress());
//        customUser.put("companyPhoneNumber", user.getCompanyPhoneNumber());
//        customUser.put("companyFax", user.getCompanyFax());
//        customUser.put("companyEmail", user.getCompanyEmail());
        model.addAttribute(AppConstant.DanhMuc.User, GsonUtils.getInstance().serializer(customUser));
    }
}
