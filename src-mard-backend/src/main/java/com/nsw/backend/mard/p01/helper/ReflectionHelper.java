package com.nsw.backend.mard.p01.helper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.Id;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ReflectionHelper {
    private static final Logger log = LoggerFactory.getLogger(ReflectionHelper.class);

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
                    log.error("IllegalAcessException", e);
                }
                field.setAccessible(accessible);
            }
        }
    }

    public static <T> void cleanIdAndFields(List<T> list) {
        list.forEach(ReflectionHelper::cleanIdAndFields);
    }

    public static <T> void initListIfNull(T a) {
        Class<?> objectClass = a.getClass();
        for (Field field : objectClass.getDeclaredFields()) {
            Type type = field.getGenericType();
            if (type instanceof ParameterizedType) {
                ParameterizedType pType = (ParameterizedType) type;
                if (pType.getRawType().getTypeName().contains("List")) {
                    boolean accessible = field.isAccessible();
                    field.setAccessible(true);
                    try {
                        if (field.get(a) == null) {
                            field.set(a, new ArrayList<>());
                        }
                    } catch (IllegalAccessException e) {
                        log.error("IllegalAcessException", e);
                    }
                    field.setAccessible(accessible);
                }
            }
        }
    }
}
