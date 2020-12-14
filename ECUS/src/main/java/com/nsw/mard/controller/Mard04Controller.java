package com.nsw.mard.controller;

import com.nsw.constant.AppConstant;
import com.nsw.controller.BaseController;
import com.nsw.mard.constant.Mard04Constant;
import com.nsw.security.UserCustom;
import com.nsw.service.RabbitMQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author HuongMK
 */
@Controller
@RequestMapping({Mard04Constant.Routes.ROOT_HOME})
public class Mard04Controller extends BaseController {
    @Autowired
    Environment environment;
    @Autowired
    MessageSource messageSource;
    @Autowired
    RabbitMQService rabbitMQService;

    @RequestMapping(value = {Mard04Constant.View.HOME, Mard04Constant.View.INDEX}, method = {RequestMethod.GET})
    public String index(ModelMap model) {
        initData(model, null);
        return Mard04Constant.Pages.HOME;
    }

    @RequestMapping(value = {Mard04Constant.View.VIEW}, method = {RequestMethod.GET})
    public String viewData(ModelMap model) {
        initData(model, null);
        return Mard04Constant.Pages.VIEW;
    }

    @RequestMapping(value = {Mard04Constant.View.XAC_NHAN_DON}, method = {RequestMethod.GET})
    public String viewXacNhanDonATTP(ModelMap model) {
        initData(model, null);
        return Mard04Constant.Pages.XAC_NHAN_DON;
    }

    @RequestMapping(value = {Mard04Constant.View.MAU_GIAY_GIULAI}, method = {RequestMethod.GET})
    public String mauGiayGiuLaiVaXuLy(ModelMap model) {
        initData(model, null);
        return Mard04Constant.Pages.MAU_GIAY_GIULAI;
    }

    @RequestMapping(value = {Mard04Constant.View.MAU_GIAY_CNKD}, method = {RequestMethod.GET})
    public String mauGiayCNKD(ModelMap model) {
        initData(model, null);
        return Mard04Constant.Pages.MAU_GIAY_CNKD;
    }

    @RequestMapping(value = {Mard04Constant.View.MAU_GIAY_XNCL}, method = {RequestMethod.GET})
    public String mauGiayXNCL(ModelMap model) {
        initData(model, null);
        return Mard04Constant.Pages.MAU_GIAY_XNCL;
    }

    @RequestMapping(value = {Mard04Constant.View.MAU_GIAY_CNTP}, method = {RequestMethod.GET})
    public String mauGiayATTP(ModelMap model) {
        initData(model, null);
        return Mard04Constant.Pages.MAU_GIAY_CNTP;
    }

    @RequestMapping(value = {Mard04Constant.View.MAU_GIAY_ATTP}, method = {RequestMethod.GET})
    public String mauGiayCNTP(ModelMap model) {
        initData(model, null);
        return Mard04Constant.Pages.MAU_GIAY_ATTP;
    }

    @RequestMapping(value = {Mard04Constant.View.MAU_GIAY_TAMCAP}, method = {RequestMethod.GET})
    public String mauGiayTamCap(ModelMap model) {
        initData(model, null);
        return Mard04Constant.Pages.MAU_GIAY_TAMCAP;
    }

    @RequestMapping(value = {Mard04Constant.View.CHARGE}, method = {RequestMethod.GET})
    public String viewCharge(ModelMap model) {
        initData(model, null);
        return Mard04Constant.Pages.CHARGE;
    }

    @RequestMapping(value = {Mard04Constant.View.CHARGEBS}, method = {RequestMethod.GET})
    public String viewChargeBS(ModelMap model) {
        initData(model, null);
        return Mard04Constant.Pages.CHARGEBS;
    }

    @RequestMapping(value = {Mard04Constant.View.XAC_NHAN_PHI}, method = {RequestMethod.GET})
    public String viewXacNhanPhi(ModelMap model) {
        initData(model, null);
        return Mard04Constant.Pages.XAC_NHAN_PHI;
    }

    private void initData(ModelMap model, UserCustom user) {
        model.addAttribute(AppConstant.DanhMuc.Sign, environment.getRequiredProperty(Mard04Constant.EnableSign));
        model.addAttribute(AppConstant.DanhMuc.Version, AppConstant.getVersion());
    }
}