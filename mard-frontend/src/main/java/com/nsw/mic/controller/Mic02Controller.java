/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.mic.controller;

import com.nsw.constant.AppConstant;
import com.nsw.controller.BaseController;
import com.nsw.helper.AppHelper;
import com.nsw.mic.constant.Mic02Constant;
import com.nsw.moit.constant.MOIT01Constant;
import com.nsw.security.UserCustom;
import com.nsw.service.RabbitMQService;
import com.nsw.util.GsonUtils;
import java.util.HashMap;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.env.Environment;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLConnection;
import java.nio.charset.Charset;
import org.springframework.util.FileCopyUtils;

/**
 *
 * @author TamDT
 */

@Controller
@RequestMapping(Mic02Constant.Routes.ROOT_HOME)
public class Mic02Controller extends BaseController{
    
    @Autowired
    Environment environment;
    @Autowired
    MessageSource messageSource;
    @Autowired
    RabbitMQService rabbitMQService;
    
    
    @RequestMapping(value = {Mic02Constant.View.HOME, Mic02Constant.View.INDEX}, method = RequestMethod.GET)
    public String index(ModelMap model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        
        if (principal instanceof UserDetails) {
            UserCustom user = (UserCustom) principal;
            initData(model, user);
        } else {
            return AppConstant.redirectPage(AppConstant.Pages.LOGOUT);
        }
        return Mic02Constant.Pages.HOME;
    }
    
    @RequestMapping(value = {Mic02Constant.View.EDIT}, method = RequestMethod.GET)
    public String addNew(ModelMap model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            UserCustom user = (UserCustom) principal;
            initData(model, user);
        } else {
            return AppConstant.redirectPage(AppConstant.Pages.LOGOUT);
        }
        return Mic02Constant.Pages.EDIT;
    }

    @RequestMapping(value = {Mic02Constant.View.VIEW}, method = RequestMethod.GET)
    public String viewData(ModelMap model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            UserCustom user = (UserCustom) principal;
            initData(model, user);
        } else {
            return AppConstant.redirectPage(AppConstant.Pages.LOGOUT);
        }
        return Mic02Constant.Pages.VIEW;
    }
     @RequestMapping(value = {Mic02Constant.View.VIEW_GP}, method = RequestMethod.GET)
    public String viewGP(ModelMap model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            UserCustom user = (UserCustom) principal;
            initData(model, user);
        } else {
            return AppConstant.redirectPage(AppConstant.Pages.LOGOUT);
        }
        return Mic02Constant.Pages.VIEW_GP;
    }
    //download file
    @RequestMapping(value="/download", method = RequestMethod.GET)
    public void downloadFile(HttpServletResponse response) throws IOException {
     
        File file = null;
         
        //internal
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        file = new File(classloader.getResource("BIEU_MAU_TB_NK.xlsx").getFile());
         
        if(!file.exists()){
            String errorMessage = "Sorry. The file you are looking for does not exist";
            System.out.println(errorMessage);
            OutputStream outputStream = response.getOutputStream();
            outputStream.write(errorMessage.getBytes(Charset.forName("UTF-8")));
            outputStream.close();
            return;
        }
         
        String mimeType= URLConnection.guessContentTypeFromName(file.getName());
        if(mimeType==null){
            System.out.println("mimetype is not detectable, will take default");
            mimeType = "application/octet-stream";
        }
         
        System.out.println("mimetype : "+mimeType);
        response.setContentType(mimeType);
        response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() +"\""));
        response.setContentLength((int)file.length());
        InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
        FileCopyUtils.copy(inputStream, response.getOutputStream());
    }
    
    private void initData(ModelMap model, UserCustom user) {
        model.addAttribute(AppConstant.DanhMuc.Menu, AppHelper.GetMenusForUser(user.getTabs(), environment.getRequiredProperty("nsw.fontend.url")));
        model.addAttribute(AppConstant.DanhMuc.Applet, environment.getRequiredProperty(AppConstant.Common.APPLET));
        model.addAttribute(AppConstant.DanhMuc.Sign, environment.getRequiredProperty(MOIT01Constant.EnableSign));
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
