package com.nsw.mard.controller;

import com.nsw.constant.AppConstant;
import com.nsw.controller.BaseController;
import com.nsw.helper.AppHelper;
import com.nsw.mard.constant.Mard09Constant;
import com.nsw.most.constant.ThuTuc01Constant;
import com.nsw.security.UserCustom;
import com.nsw.service.RabbitMQService;
import com.nsw.util.GsonUtils;
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
@RequestMapping("/mard/09")
public class Mard09Controller extends BaseController {
    private static final String ID_HOSO = "idHoSo";

    @Autowired
    Environment environment;

    @Autowired
    RabbitMQService rabbitMQService;

    /**
     * index page
     *
     * @param model
     * @return
     */
    @RequestMapping(value = {"/", "/home", "/index"}, method = RequestMethod.GET)
    public String indexPage(ModelMap model) {
        initData(model, null);
        return Mard09Constant.Page.HOME;
    }


    @RequestMapping(value = {"/xem/{idHoSo}"}, method = RequestMethod.GET)
    public String xemHoso(ModelMap model, @PathVariable("idHoSo") Long idHoSo) {
        initData(model, null);
        model.addAttribute(ID_HOSO, idHoSo);
        return Mard09Constant.Page.VIEW;
    }

    /**
     * Khởi tạo dữ liệu
     *
     * @param model
     * @param user
     */
    private void initData(ModelMap model, UserCustom user) {
        model.addAttribute(AppConstant.DanhMuc.Sign, environment.getRequiredProperty(ThuTuc01Constant.EnableSign));
        model.addAttribute(AppConstant.DanhMuc.Version, AppConstant.getVersion());
    }
}
