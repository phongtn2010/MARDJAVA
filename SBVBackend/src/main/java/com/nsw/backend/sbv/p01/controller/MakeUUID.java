package com.nsw.backend.sbv.p01.controller;

import java.text.DecimalFormat;
import java.util.Calendar;

public class MakeUUID {

	
	private MakeUUID() {
	}

	public static String makePK(long pk) {

		String code = "CUR";
		Calendar calendar = Calendar.getInstance();
		code += calendar.get(Calendar.YEAR);

		DecimalFormat decimalFormat = new DecimalFormat("000000");
		code += decimalFormat.format(pk);

		return code;
	}
}
