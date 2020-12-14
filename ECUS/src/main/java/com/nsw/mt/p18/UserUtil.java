package com.nsw.mt.p18;

import java.util.Collections;

import com.nsw.security.UserCustom;

public class UserUtil {

	public static UserCustom getUserDefault() {
		return new UserCustom("1", "", false, false, false, false, Collections.emptyList());
	}
}
