package com.nsw.mard.p20.rest;

import com.nsw.security.UserCustom;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class SecurityUtil {

    public static UserCustom getLoginUser() {
       Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
       if (principal instanceof UserDetails) {
           if (principal != null)
             return (UserCustom)principal;
       }
        return null;
    }

    public static String getTaxCode() {
       UserCustom userCustom = getLoginUser();
       if (userCustom != null) return userCustom.getUsername();
       return "";
    }

    public static String getTaxName() {
       UserCustom userCustom = getLoginUser();
       if (userCustom != null) return userCustom.getCompanyName();
        return "";
    }
}
