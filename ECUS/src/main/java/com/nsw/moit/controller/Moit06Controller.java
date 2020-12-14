package com.nsw.moit.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nsw.common.model.Breadcrumb;
import com.nsw.common.model.json.Tab;
import com.nsw.constant.AppConstant;
import com.nsw.helper.AppHelper;
import com.nsw.helper.RabbitMQErrorHelper;
import com.nsw.moit.p06.model.HoSo6EditForm;
import com.nsw.moit.p06.model.TbdHoSo6;
import com.nsw.moit.p06.util.Moit06BackendConstants;
import com.nsw.moit.p06.util.Moit06Constants;
import com.nsw.moit.p06.util.Moit06TbdHoSo6BackendUtil;
import com.nsw.most.constant.ThuTuc01Constant;
import com.nsw.security.UserCustom;
import com.nsw.service.RabbitMQService;
import com.nsw.util.Constants;

@Controller
@RequestMapping("/moit/06")
public class Moit06Controller {

    public static final Logger LOGGER = LoggerFactory.getLogger(Moit06Controller.class);

    @Autowired
    protected RabbitMQService rabbitMQService;

    @Autowired
    private Environment environment;

    @Autowired
    private HttpSession httpSession;

    @Autowired
    protected MessageSource messageSource;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String index(HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes,
            Locale locale, ModelMap model) {

        try {

            setBreadcrumb(false, model);
            model.addAttribute(AppConstant.DanhMuc.Menu, getMenuData());
            model.addAttribute(AppConstant.DanhMuc.UserName, "");
            model.addAttribute(AppConstant.DanhMuc.Version, AppConstant.getVersion());
            model.addAttribute(AppConstant.DanhMuc.Applet,
                    environment.getRequiredProperty(AppConstant.Common.APPLET));
            model.addAttribute(AppConstant.DanhMuc.Sign,
                    environment.getRequiredProperty(ThuTuc01Constant.EnableSign));

        } catch (Exception e) {

            LOGGER.error(e.getMessage(), e);

            pushLog(e);

        }

        return Moit06Constants.PAGE.INDEX;
    }

    @RequestMapping(value = {"/view/{id}"}, method = RequestMethod.GET)
    public String view(ModelMap model, HttpServletRequest request, @PathVariable("id") long id) {

        setBreadcrumb(false, model);
        model.addAttribute(AppConstant.DanhMuc.Menu, getMenuData());
        model.addAttribute(AppConstant.DanhMuc.UserName, "");
        model.addAttribute(AppConstant.DanhMuc.Version, AppConstant.getVersion());
        model.addAttribute(AppConstant.DanhMuc.Applet, environment.getRequiredProperty(AppConstant.Common.APPLET));
        model.addAttribute(AppConstant.DanhMuc.Sign, environment.getRequiredProperty(ThuTuc01Constant.EnableSign));

        TbdHoSo6 tbdHoSo6 = Moit06TbdHoSo6BackendUtil.getTbdHoSo6(getURL(Moit06BackendConstants.TbdHoSo6Constants.GET_ONE), id);
        HoSo6EditForm form = new HoSo6EditForm();
        BeanUtils.copyProperties(tbdHoSo6, form);
        form.setXemHoSo(true);
        model.addAttribute("form", form);
        return Moit06Constants.PAGE.EDIT;

    }

    private String getURL(String uriKey) {
        return environment.getRequiredProperty(Moit06Constants.PROPERTIES.BACKEND) + environment.getRequiredProperty(uriKey);
    }

    @SuppressWarnings("unchecked")
    public List<Tab> getMenuData() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Tab> mTabs = null;
        if (principal instanceof UserDetails) {
            UserCustom user = (UserCustom) principal;
            if (httpSession.getAttribute(Constants.MENU_SESSION) != null) {
                mTabs = (List<Tab>) httpSession.getAttribute(Constants.MENU_SESSION);
            } else {
                mTabs = AppHelper.GetMenusForUser(user.getTabs(),
                        environment.getRequiredProperty("nsw.fontend.url"));
                httpSession.setAttribute(Constants.MENU_SESSION, mTabs);
            }
        }
        return mTabs;
    }

    private void setBreadcrumb(boolean isDetail, ModelMap model) {
        List<Breadcrumb> breadcrumbs = new ArrayList<>();
        Breadcrumb nav = new Breadcrumb("/moit/06/home", environment.getRequiredProperty(AppConstant.Breadcrumb.LIST));
        breadcrumbs.add(nav);
        if (isDetail) {
            nav = new Breadcrumb("#", environment.getRequiredProperty(AppConstant.Breadcrumb.DETAIL));
            breadcrumbs.add(nav);
        }
        model.addAttribute(AppConstant.Common.BREADCRUMB, breadcrumbs);
    }

    /**
     * Ghi log nen server
     *
     * @param ex
     */
    public void pushLog(Exception ex) {

        try {

            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + getClass().getSimpleName()
                    + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + AppConstant.MESSAGE_SEPARATOR + ex.toString();

            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo,
                    rabbitMQService.getRabbitMQInfo());

        } catch (Exception e) {

            LOGGER.error(e.getMessage(), e);
        }
    }

    private String redirect(String url) {
        if (!url.startsWith("/")) {
            url = "/" + url;
        }
        return "redirect:/moit/06" + url;
    }

}
