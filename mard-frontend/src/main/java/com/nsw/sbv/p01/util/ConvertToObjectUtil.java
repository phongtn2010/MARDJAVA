package com.nsw.sbv.p01.util;

import java.lang.reflect.Field;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConvertToObjectUtil {

	public static final Logger LOGGER = LoggerFactory.getLogger(ConvertToObjectUtil.class);
	
	
	private ConvertToObjectUtil() {
	}

	public static <T> T convertTo(Object fromObject, T toObject) {

		if (fromObject == null || toObject == null)
			return null;

		Field[] fields = fromObject.getClass().getDeclaredFields();

		if (fields == null)
			return null;

		setField(fromObject, fields, toObject, toObject.getClass().getDeclaredFields());

		fields = fromObject.getClass().getSuperclass().getDeclaredFields();

		setField(fromObject, fields, toObject, toObject.getClass().getSuperclass().getDeclaredFields());

		return toObject;

	}

	private static void setField(Object fromObject, Field[] fromFields, Object toObject, Field[] toFields) {

		for (Field item : fromFields) {

			String name = item.getName();

			for (Field j : toFields) {

				if (j.getName().equals(name)) {

					item.setAccessible(true);

					j.setAccessible(true);

					if (item.getType().equals(j.getType())) {

						try {
							j.set(toObject, item.get(fromObject));
						} catch (Exception e) {
							LOGGER.error(e.getMessage(), e);
						}

					}

				}
			}
		}

	}

}
