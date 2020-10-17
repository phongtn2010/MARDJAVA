package com.nsw.backend.mard.p25.helper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.Id;
import java.lang.reflect.Field;
import java.util.List;

public class ReflectionHelper {
    private static final Logger LOG = LoggerFactory.getLogger(ReflectionHelper.class);
    private static final String TAG = "ReflectionHelper";

    private ReflectionHelper() {
    }

    private static <T> void cleanIdAndFields(T a) {
        Class<?> objectClass = a.getClass();
        for (Field field : objectClass.getDeclaredFields()) {
            if (field.getName().equals("fiIdHS") || field.isAnnotationPresent(Id.class)) {
                boolean accessible = field.isAccessible();
                field.setAccessible(true);
                try {
                    field.set(a, null);
                } catch (IllegalAccessException e) {
                    LOG.error(TAG + e.getMessage(), e);
                }
                field.setAccessible(accessible);
            }
        }
    }

    public static <T> void cleanIdAndFields(List<T> list) {
        list.forEach(ReflectionHelper::cleanIdAndFields);
    }
}
