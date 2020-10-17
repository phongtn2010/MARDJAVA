package com.nsw.mt.utility.qlgp;

import com.google.gson.Gson;
import com.nsw.common.model.Breadcrumb;
import com.nsw.common.model.json.ResponseJson;
import com.nsw.common.model.json.Tab;
import com.nsw.constant.AppConstant;
import com.nsw.controller.BaseController;
import com.nsw.helper.AppHelper;
import com.nsw.most.constant.ThuTuc01Constant;
import com.nsw.mt.MTConstants;
import com.nsw.mt.p01.MT01Controller;
import com.nsw.security.UserCustom;
import com.nsw.service.RabbitMQService;
import com.nsw.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping(value = "/mt/qlgp")
@PropertySource("classpath:mt_api.properties")
public class QuanlyGiayphepController extends BaseController {
    public static final Logger LOGGER = LoggerFactory.getLogger(MT01Controller.class);

    @Autowired
    protected RabbitMQService rabbitMQService;

    @Autowired
    private Environment environment;

    @Autowired
    private HttpSession httpSession;

    @Autowired
    protected MessageSource messageSource;

    Gson gson = new Gson();

    @InitBinder
    public void bindData(WebDataBinder binder) {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }

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
        Breadcrumb nav = new Breadcrumb("/", environment.getRequiredProperty(AppConstant.Breadcrumb.LIST));
        breadcrumbs.add(nav);
        if (isDetail) {
            nav = new Breadcrumb("#", environment.getRequiredProperty(AppConstant.Breadcrumb.DETAIL));
            breadcrumbs.add(nav);
        }
        model.addAttribute(AppConstant.Common.BREADCRUMB, breadcrumbs);
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String index(HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes,
                        Locale locale, ModelMap model) {
        try {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (principal instanceof UserDetails) {
                UserCustom user = (UserCustom) principal;
                setBreadcrumb(false, model);
                model.addAttribute(AppConstant.DanhMuc.Menu, getMenuData());
                model.addAttribute(AppConstant.DanhMuc.UserName, user.getUsername());
                model.addAttribute(AppConstant.DanhMuc.Version, AppConstant.getVersion());
                model.addAttribute(AppConstant.DanhMuc.Applet,
                        environment.getRequiredProperty(AppConstant.Common.APPLET));
                model.addAttribute(AppConstant.DanhMuc.Sign,
                        environment.getRequiredProperty(ThuTuc01Constant.EnableSign));
                model.addAttribute("userCustom", gson.toJson(user));
            } else {
                return AppConstant.redirectPage(AppConstant.Pages.LOGOUT);
            }

        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }

        return "nsw.mt.page.utility.qlgp";
    }

    @ResponseBody
    @RequestMapping(value = "/call_service", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Object> callBackendService(HttpServletRequest request, @RequestBody Map<String, Object> form) {

        try {
            Long total = 0L;
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (!(principal instanceof UserDetails)) {

                return createResponseEntity(null, 0L, getMessage(MTConstants.MessageKeys.ACTION_ERROR, null, request.getLocale()), false, HttpStatus.OK);
            }
            String urlBackEnd = form.get("URL_BACKEND").toString();
            String method = form.get("METHOD").toString();
            HttpMethod httpMethod = "POST".equals(method) ? HttpMethod.POST
                    : "GET".equals(method) ? HttpMethod.GET : HttpMethod.OPTIONS;
            Object requestObject = form.get("REQUEST");
            Map<String, Object> params = new HashMap<>();
            System.out.println("URL:" + environment.getProperty("mt.backend") + urlBackEnd);
            System.out.println("Request: " + gson.toJson(form));
            ResponseJson responseJson = callRestTemplate(environment.getProperty("mt.backend") + urlBackEnd, requestObject, httpMethod, params);
            if (form.containsKey("URL_GET_TOTAL")) {
                String urlGetTotal = form.get("URL_GET_TOTAL").toString();
                ResponseJson response = callRestTemplate(environment.getProperty("mt.backend") + urlGetTotal, requestObject, httpMethod, params);
                total = ((Integer) response.getData()).longValue();
            }
            return createResponseEntity(responseJson.getData(), total, "", true, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("CALL_SERVICE_ERROR", e);
        }
        return createResponseEntity(null, 0L, getMessage(MTConstants.MessageKeys.ACTION_ERROR, null, request.getLocale()), false, HttpStatus.OK);
    }

}
