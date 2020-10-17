package com.nsw.controller;

import com.nsw.common.model.json.Tab;
import com.nsw.constant.AppConstant;
import com.nsw.helper.AppHelper;
import com.nsw.security.UserCustom;
import com.nsw.service.UserProfileService;
import com.nsw.service.UserService;
import com.nsw.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(AppConstant.ControllerURI.ROOT)
public class AppController {

    @Autowired
    UserService userService;

    @Autowired
    UserProfileService userProfileService;

    @Autowired
    MessageSource messageSource;

    @Autowired
    PersistentTokenBasedRememberMeServices persistentTokenBasedRememberMeServices;

    @Autowired
    AuthenticationTrustResolver authenticationTrustResolver;

    @Autowired
    Environment environment;

    @Autowired
    private HttpSession httpSession;

    public List<Tab> getMenuData() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Tab> Tabs = null;
        if (principal instanceof UserDetails) {
            UserCustom user = (UserCustom) principal;

            if (httpSession.getAttribute(Constants.MENU_SESSION) != null) {
                Tabs = (List<Tab>) httpSession.getAttribute(Constants.MENU_SESSION);
            } else {
                Tabs = AppHelper.GetMenusForUser(user.getTabs(), environment.getRequiredProperty("nsw.fontend.url"));
                httpSession.setAttribute(Constants.MENU_SESSION, Tabs);
            }
        }
        return Tabs;
    }
    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public String viewEdit(@PathVariable("name") final String name, Model model) {
        return AppConstant.Pages.ERROR;
    }
    @RequestMapping(value = {AppConstant.ControllerURI.ROOT,
        AppConstant.ControllerURI.HOME,
        AppConstant.ControllerURI.INDEX}, method = RequestMethod.GET)
    public String indexPage(ModelMap model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            initData(model);
        } else {
            return AppConstant.Pages.ERROR;
        }

        return AppConstant.Pages.HOME;
    }

    @RequestMapping(value = AppConstant.ControllerURI.LOGIN, method = RequestMethod.GET)
    public String loginPage() {
        if (isCurrentAuthenticationAnonymous()) {
            return AppConstant.Pages.LOGIN;
        } else {
            return AppConstant.redirectPage(AppConstant.Pages.HOME);
        }
    }

    @RequestMapping(value = AppConstant.ControllerURI.LOGOUT, method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            persistentTokenBasedRememberMeServices.logout(request, response, auth);
            SecurityContextHolder.getContext().setAuthentication(null);
        }
        return AppConstant.redirectPage(AppConstant.Pages.LOGOUT);
    }

    @RequestMapping(value = AppConstant.ControllerURI.NOACCESS, method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model) {
        initData(model);
        return AppConstant.Pages.ACCESSDINED;
    }

    @RequestMapping(value = AppConstant.ControllerURI.NOTFOUND, method = RequestMethod.GET)
    public String notfoundPage(ModelMap model) {
        initData(model);
        return AppConstant.Pages.NOTFOUND;
    }

    @RequestMapping(value = AppConstant.ControllerURI.ERROR, method = RequestMethod.GET)
    public String errorPage(ModelMap model) {
        initData(model);
        return AppConstant.Pages.ERROR;
    }

    @RequestMapping(value = AppConstant.ControllerURI.CATEST, method = RequestMethod.GET)
    public String caTestPage(ModelMap model) {
        initData(model);
        return AppConstant.Pages.TESTCA;
    }

    private String getPrincipal() {
        String userName;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }

    private boolean isCurrentAuthenticationAnonymous() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authenticationTrustResolver.isAnonymous(authentication);
    }

    private void initData(ModelMap model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            model.addAttribute(AppConstant.DanhMuc.Menu, getMenuData());
            model.addAttribute(AppConstant.DanhMuc.UserName, getPrincipal());
            model.addAttribute(AppConstant.DanhMuc.Version, AppConstant.getVersion());
            model.addAttribute(AppConstant.DanhMuc.Applet, environment.getRequiredProperty(AppConstant.Common.APPLET));
            model.addAttribute(AppConstant.DanhMuc.Sign, environment.getRequiredProperty(AppConstant.Common.ISSIGN));
        }
    }
}
