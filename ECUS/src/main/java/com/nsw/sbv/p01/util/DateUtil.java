package com.nsw.sbv.p01.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateUtil {

	private DateUtil() {
	}

	
	public static String getDateTimeFormat(Date date) {
		if (date == null) return "";
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		dateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
		return dateFormat.format(date);
	}
	
	
}
