package com.nsw.monre.p01.util;



import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.nsw.monre.p01.model.UserInfo;
import com.nsw.security.UserCustom;

public class LoginUtil {

	
	private LoginUtil() {
	}

	public static UserInfo getUserInfo() {
		
		 Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		 if (principal instanceof UserDetails) {
	            UserCustom user = (UserCustom) principal;
	               
	            	UserInfo userInfo = new UserInfo();
	            	
	            	userInfo.setTenDN(user.getCompanyName());
	            	
	            	userInfo.setTruSoChinh(user.getCompanyAddress());
	            	
	            	userInfo.setEmailNguoiDaiDien(user.getRepresenterEmail());
	            	
	            	userInfo.setFaxNguoiDaiDien(user.getCompanyFax());
	            	
	            	userInfo.setSoDTNguoiDaiDien(user.getRepresenterPhone() != null ? user.getRepresenterPhone() : user.getCompanyPhoneNumber());
	            	
	            	userInfo.setNguoiDaiDien(user.getRepresenterName());
	            	
	            	userInfo.setMaSoThue(user.getUsername());
	            	
	            	userInfo.setMaCoQuan(user.getCompanyType());
	            	
	            	userInfo.setsoGCNDKKD(user.getUsername());
	            	
	            	return userInfo;
	        }
		 
		return new UserInfo();
	}
	
	
}
