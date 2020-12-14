package com.nsw.monre.p01.util;

import java.text.DecimalFormat;
import java.util.Calendar;


public class UIDUtil {

	
	private UIDUtil() {
	}

	public static String makePK(long pk) {
		
		String code = "TN";
		
		Calendar  calendar = Calendar.getInstance();
		
		DecimalFormat decimalFormat = new DecimalFormat("000000000");
		
		code += decimalFormat.format(pk);
		
		code += calendar.get(Calendar.YEAR);
		
		return code;
		
	}
	
	
	
}
