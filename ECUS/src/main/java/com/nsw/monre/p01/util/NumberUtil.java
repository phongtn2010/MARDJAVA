package com.nsw.monre.p01.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NumberUtil {

	public static final int DEFAULT_INTEGER_NUMBER = 0;
	
	public static final long DEFAULT_LONG_NUMBER = 0;
	
	public static final float DEFAULT_FLOAT_NUMBER = 0;
	
	public static final double DEFAULT_DOUBLE_NUMBER = 0;
	
	public static final short DEFAULT_SHORT_NUMBER = 0;
	
	public static final boolean DEFAULT_BOOLEAN = false;
	
	public static final String DEFAULT_STRING = "";
	
	public static final Logger LOGGER = LoggerFactory.getLogger(NumberUtil.class);
	
	
	private NumberUtil() {
	}

	
	
	
	public static int toInt(String object, int defaultValue) {
		
		try {
			
			return Integer.parseInt(object);
			
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return defaultValue;
		}
		
	}
	
	public static int toInt(String object) {
		
		try {
			
			return Integer.parseInt(object);
			
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return DEFAULT_INTEGER_NUMBER;
		}
		
	}
	
	public static float toFloat(String object, float defaultValue) {
		
		try {
			
			return Float.parseFloat(object);
			
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return defaultValue;
		}
		
	}
	
	public static float toFloat(String object) {
		
		try {
			
			return Float.parseFloat(object);
			
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return DEFAULT_FLOAT_NUMBER;
		}
		
	}
	
	public static long toLong(String object, long defaultValue) {
		
		try {
			
			return Long.parseLong(object);
			
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return defaultValue;
		}
		
	}
	
	public static long toLong(String object) {
		
		try {
			
			return Long.parseLong(object);
			
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return DEFAULT_LONG_NUMBER;
		}
		
	}
	
	public static double toDouble(String object, double defaultValue) {
		
		try {
			
			return Double.parseDouble(object);
			
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return defaultValue;
		}
		
	}
	
	public static double toDouble(String object) {
		
		try {
			
			return Double.parseDouble(object);
			
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return DEFAULT_DOUBLE_NUMBER;
		}
		
	}
	
	
	public static short toShort(String object, short defaultValue) {
		
		try {
			
			return Short.parseShort(object);
			
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return defaultValue;
		}
		
	}
	
	public static short toShort(String object) {
		
		try {
			
			return Short.parseShort(object);
			
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return DEFAULT_SHORT_NUMBER;
		}
		
	}
	
}

