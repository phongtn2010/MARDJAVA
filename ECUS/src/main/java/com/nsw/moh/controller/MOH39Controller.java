package com.nsw.moh.controller;

import com.nsw.constant.AppConstant;
import com.nsw.controller.BaseController;
import com.nsw.helper.AppHelper;
import com.nsw.moh.constant.MOH39Constant;
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
 * @author AnPhucNguyen
 */
@Controller
@RequestMapping(MOH39Constant.Routes.ROOT)
public class MOH39Controller extends BaseController {

    @Autowired
    Environment environment;
    @Autowired
    RabbitMQService rabbitMQService;

    /**
     * Home page
     *
     * @param code
     * @param model
     * @return
     */
    @RequestMapping(value = {MOH39Constant.View.HOME, MOH39Constant.View.INDEX}, method = RequestMethod.GET)
    public String indexPage(@PathVariable String code, ModelMap model) {
        
        initData(model, null);
        
        String page = getPage(code, MOH39Constant.ViewType.HOME);
        return page;
    }

    /**
     * Create or Update document page
     *
     * @param code
     * @param model
     * @return
     */
    @RequestMapping(value = {MOH39Constant.View.EDIT}, method = RequestMethod.GET)
    public String create(@PathVariable String code, ModelMap model) {
        initData(model, null);
        String page = getPage(code, MOH39Constant.ViewType.EDIT);
        return page;
    }
    
    @RequestMapping(value = {MOH39Constant.View.EDIT_TYPE}, method = RequestMethod.GET)
    public String create(@PathVariable String code, @PathVariable String type, ModelMap model) {
        initData(model, null);
        String page = getPageByType(code, type, MOH39Constant.ViewType.EDIT);
        return page;
    }

    /**
     * View document page
     *
     * @param code
     * @param model
     * @return
     */
    @RequestMapping(value = {MOH39Constant.View.VIEW}, method = RequestMethod.GET)
    public String view(@PathVariable String code, ModelMap model) {
        initData(model, null);
        String page = getPage(code, MOH39Constant.ViewType.VIEW);
        return page;
    }
    
    @RequestMapping(value = {MOH39Constant.View.VIEW_TYPE}, method = RequestMethod.GET)
    public String viewByType(@PathVariable String code, @PathVariable String type, ModelMap model) {
        initData(model, null);
        String page = getPageByType(code, type, MOH39Constant.ViewType.VIEW);
        return page;
    }
	
	@RequestMapping(value = {MOH39Constant.View.RESULT}, method = RequestMethod.GET)
    public String result(@PathVariable String code, ModelMap model) {
        initData(model, null);
        String page = getPage(code, MOH39Constant.ViewType.RESULT);
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
        //model.addAttribute(AppConstant.DanhMuc.Applet, environment.getRequiredProperty(AppConstant.Common.APPLET));
        model.addAttribute(AppConstant.DanhMuc.Sign, environment.getRequiredProperty(MOH39Constant.EnableSign));
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
            return "moh.home";
        }

        if ("00".equals(code)) {
            return "moh.home";
        }

        switch (viewType) {
            case MOH39Constant.ViewType.HOME:
                return String.format(MOH39Constant.Pages.HOME_PATTERN, code);
            case MOH39Constant.ViewType.EDIT:
                return String.format(MOH39Constant.Pages.EDIT_PATTERN, code);
            case MOH39Constant.ViewType.RESULT:
                return String.format(MOH39Constant.Pages.RESULT_PATTERN, code);
            default:
                return String.format(MOH39Constant.Pages.VIEW_PATTERN, code);
        }
    }
    
    private String getPageByType(String code, String type, String viewType) {
        if (null == code || null == viewType) {
            return "moh.home";
        }

        if ("00".equals(code)) {
            return "moh.home";
        }

        switch (viewType) {
            case MOH39Constant.ViewType.VIEW:
                return String.format(MOH39Constant.Pages.VIEW_PATTERN_TYPE, code, type);
            case MOH39Constant.ViewType.EDIT:
                return String.format(MOH39Constant.Pages.EDIT_PATTERN_TYPE, code, type);
            case MOH39Constant.ViewType.RESULT:
                return String.format(MOH39Constant.Pages.RESULT_PATTERN_TYPE, code, type);
            default:
                return String.format(MOH39Constant.Pages.HOME_PATTERN, code);
        }
    }
}
