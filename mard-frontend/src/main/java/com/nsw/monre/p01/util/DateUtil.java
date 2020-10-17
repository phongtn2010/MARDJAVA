package com.nsw.monre.p01.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class DateUtil {

	public static final String DD_MM_YYYY = "dd/MM/yyyy";

	public static final String DD_MM_YYYY_INPUT = "dd/MM/yyyy";

	public static final String MMM_DD_YYYY = "MMM/dd/yyyy";

	public static final String DDMMYYYY = "dd/MM/yyyy";

	public static final String DD_MM_YYYY_HH_MM_SS = "dd/MM/yyyy HH:mm:ss";
	
	public static final String DD_MM_YYYY_HH_MM = "dd/MM/yyyy HH:mm";

	private static final Logger LOGGER = LoggerFactory.getLogger(DateUtil.class);
	
	private DateUtil() {
	}

	public static String getFormatDate(String pattern, Date date) {
		if (date == null)
			return "";
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
			dateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));

			return dateFormat.format(date);

		} catch (Exception e) {
			
                    LOGGER.error(e.getMessage(), e);
			return "";
		}
	}

	public static String getFormatDate(String patternInput, String patternOutput, String dateString) {
		if (dateString == null)
			return "";
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat(patternInput);

			dateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
			Date date = dateFormat.parse(dateString);

			SimpleDateFormat dateFormat2 = new SimpleDateFormat(patternOutput);
			return dateFormat2.format(date);

		} catch (Exception e) {
			
                    LOGGER.error(e.getMessage(), e);
			return "";
		}
	}

	public static Date getDate(String pattern, String date) {

		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);

		if (date == null || date.isEmpty())
			return null;

		try {
			return dateFormat.parse(date);
		} catch (ParseException e) {
			return null;
		}
		
	}

	public static String getCurrentDate() {

		return getFormatDate(DD_MM_YYYY, new Date());
	}

	public static Date getNowDate() {
		
		return new Date();
	}
	

	public static String getDaySuffix(int day) {

		switch (day) {

		case 1:
		case 21:
		case 31:
			return "st";

		case 2:
		case 22:
			return "nd";

		case 3:
		case 23:
			return "rd";

		default:
			return "th";
		}
	}

	public static String getEUDate(Date date) {

		String result = "";

		String dateString = getFormatDate(MMM_DD_YYYY, date);

		String[] dateArray = dateString.split("/");

		int day = NumberUtil.toInt(dateArray[1]);

		String daySuffix = getDaySuffix(day);

		result += dateArray[0] + " " + dateArray[1] + "<sup>" + daySuffix + "</sup>" + "," + dateArray[2];

		return result;
	}

}
