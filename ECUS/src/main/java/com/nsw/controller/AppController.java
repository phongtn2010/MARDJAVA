package com.nsw.controller;

import com.nsw.constant.AppConstant;
import com.nsw.helper.AppHelper;
import com.nsw.common.model.json.Tab;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.nsw.service.UserProfileService;
import com.nsw.service.UserService;
import com.nsw.security.UserCustom;
import com.nsw.util.Constants;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.core.env.Environment;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;

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
            if (user != null) {
                if (httpSession.getAttribute(Constants.MENU_SESSION) != null) {
                    Tabs = (List<Tab>) httpSession.getAttribute(Constants.MENU_SESSION);
                } else {
                    Tabs = AppHelper.GetMenusForUser(user.getTabs(), environment.getRequiredProperty("nsw.fontend.url"));
                    httpSession.setAttribute(Constants.MENU_SESSION, Tabs);
                }
            }
        }
        return Tabs;
    }

    @RequestMapping(value = {AppConstant.ControllerURI.ROOT,
        AppConstant.ControllerURI.HOME,
        AppConstant.ControllerURI.INDEX}, method = RequestMethod.GET)
    public String indexPage(ModelMap model, final HttpServletRequest request) throws URISyntaxException {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        if (principal instanceof UserDetails) {
//            UserCustom user = (UserCustom) principal;
//            if (user != null) {
//                initData(model);
//            }
//        } else {
//            return AppConstant.Pages.ACCESSDINED;
//        }
        String requestUrl = request.getHeader("referer");
        if (requestUrl == null) {
            return AppConstant.Pages.HOME;
        }
        MultiValueMap<String, String> params = UriComponentsBuilder.fromUri(new URI(requestUrl)).build().getQueryParams();
        List<String> redirectUrl = params.get("url");
        if (redirectUrl != null && redirectUrl.get(0) != null) {
            String url = redirectUrl.get(0);
            //url = url.substring(1, url.length());
            return AppConstant.redirectPage(environment.getRequiredProperty("nsw.root.url") + url);
        } else {
            return AppConstant.Pages.ACCESSDINED;
        }        
    }

    @RequestMapping(value = AppConstant.ControllerURI.LOGIN, method = RequestMethod.GET, params = "url")
    public String loginPage(@RequestParam(value = "url", required = false) String url) {        
        if (isCurrentAuthenticationAnonymous()) {
            return AppConstant.Pages.LOGIN;
        } else {
            return AppConstant.redirectPage(environment.getRequiredProperty("nsw.root.url") + url);
        }
    }

    @RequestMapping(value = AppConstant.ControllerURI.LOGOUT, method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) throws URISyntaxException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            persistentTokenBasedRememberMeServices.logout(request, response, auth);
            SecurityContextHolder.getContext().setAuthentication(null);
        }
        return AppConstant.Pages.ACCESSDINED;
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
        String userName = null;
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
            UserCustom user = (UserCustom) principal;
            if (user != null) {
                model.addAttribute(AppConstant.DanhMuc.Menu, getMenuData());
                model.addAttribute(AppConstant.DanhMuc.UserName, getPrincipal());
                model.addAttribute(AppConstant.DanhMuc.Version, AppConstant.getVersion());
            }
            model.addAttribute(AppConstant.DanhMuc.Applet, environment.getRequiredProperty(AppConstant.Common.APPLET));
            model.addAttribute(AppConstant.DanhMuc.Sign, environment.getRequiredProperty(AppConstant.Common.ISSIGN));
        }
    }
}
