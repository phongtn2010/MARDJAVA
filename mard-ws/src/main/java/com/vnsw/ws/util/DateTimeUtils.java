package com.vnsw.ws.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTimeUtils {
	@SuppressWarnings("static-access")
	public static Date addOneDay(Date date) {
		Calendar c = Calendar.getInstance();
		if (date != null) {
			c.setTime(date);
			c.add(c.DAY_OF_MONTH, 1);
		}
		return c.getTime();
	}

	@SuppressWarnings("static-access")
	public static Date addOneHour(Date date) {
		Calendar c = Calendar.getInstance();
		if (date != null) {
			c.setTime(date);
			c.add(c.HOUR_OF_DAY, 1);
		}
		return c.getTime();
	}

	@SuppressWarnings("static-access")
	public static Date addDay(Date date, int days) {
		Calendar c = Calendar.getInstance();
		if (date != null) {
			c.setTime(date);
			c.add(c.DAY_OF_MONTH, days);
		}
		return c.getTime();
	}

	public static Date getAddDate(Date date, int months, int days) {

		Calendar cl = Calendar.getInstance();
		cl.setTime(date);

		cl.add(Calendar.MONTH, months);
		cl.add(Calendar.DATE, days);

		return cl.getTime();
	}

	@SuppressWarnings("deprecation")
	public static int compare2Date(Date date1, Date date2) {
		int iReturn = 0;
		if (date1.getYear() > date2.getYear()) {
			iReturn = 1;
		} else if (date1.getYear() < date2.getYear()) {
			iReturn = -1;
		} else if (date1.getMonth() > date2.getMonth()) {
			iReturn = 1;
		} else if (date1.getMonth() < date2.getMonth()) {
			iReturn = -1;
		} else if (date1.getDate() > date2.getDate()) {
			iReturn = 1;
		} else if (date1.getDate() < date2.getDate()) {
			iReturn = -1;
		}
		return iReturn;
	}

	public static Date convertStringToDate(String date, String pattern) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		return dateFormat.parse(date);
	}

	public static Date convertStringToDate(String date) throws ParseException {
		if ((date == null) || ("".equals(date))) {
			return null;
		}
		String pattern = "dd/MM/yyyy";
		return convertStringToDate(date, pattern);
	}

	public static String convertDateToString(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		if (date == null) {
			throw new IllegalArgumentException("Method argument must be not null");
		}
		return dateFormat.format(date);
	}

	public static String convertDateTimeToString(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm dd/MM/yyyy");
		if (date == null) {
			throw new IllegalArgumentException("Method argument must be not null");
		}
		return dateFormat.format(date);
	}

	public static Date getDate() {
		Calendar calendar = Calendar.getInstance();
		return calendar.getTime();
	}

	public static java.sql.Date convertToSqlDate(Date utilDate) {
		return new java.sql.Date(utilDate.getTime());
	}

	public static Date convertToUtilDate(java.sql.Date sqlDate) {
		return new Date(sqlDate.getTime());
	}

	public static Date getWeekStart(Date curr) {
		if (curr == null) {
			curr = new Date();
		}
		Calendar c = Calendar.getInstance();
		c.setTime(curr);
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK) - c.getFirstDayOfWeek();
		c.add(Calendar.DAY_OF_MONTH, -dayOfWeek);

		Date weekStart = c.getTime();

		return weekStart;
	}

	public static Date getWeekEnd(Date curr) {
		if (curr == null) {
			curr = new Date();
		}
		Calendar c = Calendar.getInstance();
		c.setTime(getWeekStart(curr));
		c.add(Calendar.DAY_OF_MONTH, 6);
		Date weekEnd = c.getTime();
		return weekEnd;
	}

	public static int getNumberOfWorkingDay(Date startDate, Date endDate) {
		Calendar startCal = Calendar.getInstance();
		startCal.setTime(startDate);
		int startDay = startCal.get(Calendar.DAY_OF_WEEK);
		Calendar endCal = Calendar.getInstance();
		endCal.setTime(endDate);
		endCal.set(Calendar.HOUR_OF_DAY, 23);
		endCal.set(Calendar.MINUTE, 59);
		endCal.set(Calendar.SECOND, 59);
		endCal.set(Calendar.MILLISECOND, 0);

		double daysBetween = Math.ceil(((double) (endCal.getTimeInMillis() - startCal.getTimeInMillis()))
				/ (24 * 60 * 60 * 1000));
		int weeks = (int) Math.floor(daysBetween / 7) * 5;
		int remainDays = (int) Math.ceil(daysBetween % 7);
		int numberOfWorkingDays = weeks + remainDays;

		while ((Calendar.SUNDAY == startDay || Calendar.SATURDAY == startDay) && remainDays > 0) {
			if (Calendar.SATURDAY == startDay) {
				startDay = Calendar.SUNDAY;
				remainDays--;
				numberOfWorkingDays--;
				continue;
			}
			if (Calendar.SUNDAY == startDay) {
				startDay = Calendar.MONDAY;
				remainDays--;
				numberOfWorkingDays--;
			}
		}
		
		int offset = startDay + remainDays - 1 - Calendar.SATURDAY;
		if (offset == 0) {
			numberOfWorkingDays -= 1;
		} else if (offset >= 1) {
			numberOfWorkingDays -= 2;
		}
		return numberOfWorkingDays;
	}

	public static Date getEndWorkingDate(Date startDate, int numberOfWorkingDays) {
		int numberOfWorkingDayToAdd = numberOfWorkingDays;
		Calendar startCal = Calendar.getInstance();
		startCal.setTime(startDate);
		int startDay = startCal.get(Calendar.DAY_OF_WEEK);

		while (Calendar.SATURDAY == startDay || Calendar.SUNDAY == startDay) {
			startCal.add(Calendar.DAY_OF_YEAR, 1);
			startDay = startCal.get(Calendar.DAY_OF_WEEK);
		}
		
		numberOfWorkingDayToAdd--;
		int numberOfWeekToAdd = numberOfWorkingDayToAdd / 5;
		int remainDays = numberOfWorkingDayToAdd % 5;

		while (remainDays > 0) {
			startCal.add(Calendar.DAY_OF_YEAR, 1);
			startDay = startCal.get(Calendar.DAY_OF_WEEK);
			while (Calendar.SATURDAY == startDay || Calendar.SUNDAY == startDay) {
				startCal.add(Calendar.DAY_OF_YEAR, 1);
				startDay = startCal.get(Calendar.DAY_OF_WEEK);
			}
			remainDays--;
		}

		if (numberOfWeekToAdd > 0) {
			startCal.add(Calendar.DAY_OF_YEAR, numberOfWeekToAdd * 7);
		}
		int endDay = startCal.get(Calendar.DAY_OF_WEEK);
		
		while (Calendar.SUNDAY == endDay || Calendar.SATURDAY == endDay) {
			startCal.add(Calendar.DAY_OF_YEAR, -1);
			endDay = startCal.get(Calendar.DAY_OF_WEEK);
		}
		return startCal.getTime();
	}

	public static Date removeTime(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	public static Date setStartTimeOfDate(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		return cal.getTime();
	}

	public static Date setEndTimeOfDate(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		return cal.getTime();
	}

	public static Date getAfterDay(Date date) {
		if (date == null) {
			return null;
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, 1);
		return cal.getTime();
	}
}
