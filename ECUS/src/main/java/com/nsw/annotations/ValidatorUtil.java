/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.annotations;

import com.nsw.moh.constant.ThuTuc06Constant;
import com.nsw.util.Constants;
import com.nsw.util.DateTimeUtils;
import com.nsw.util.Utility;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.util.StringUtils;

/**
 *
 * @author PhongNguyen
 */
public final class ValidatorUtil {

    private ValidatorUtil() {
    }

    public static void validateEntity(AbstractEntity myEntity) throws Exception {
        myEntity.addErrors(validateAnnotatedFields(myEntity));
    }

    private static List<ErrorEntity> validateAnnotatedFields(AbstractEntity myEntity) throws Exception {
        List<ErrorEntity> errors = new ArrayList<ErrorEntity>();
        boolean isDecimalErrorLength = false;
        for (Field field : myEntity.getClass().getDeclaredFields()) {

            final FieldName fieldName = field.getAnnotation(FieldName.class);
            final ExcelColRow excelInfo = field.getAnnotation(ExcelColRow.class);
            final Object fieldValue = PropertyUtils.getProperty(myEntity, field.getName());

            // Mandatory 
            final Mandatory mandatory = field.getAnnotation(Mandatory.class);
            if (mandatory != null) {
                if (fieldValue == null) {
                    if (excelInfo != null) {
                        errors.add(new ErrorEntity(excelInfo.row(), excelInfo.col(),
                                fieldName.name(), Constants.ErrorCode.KHONGCOGIATRI, excelInfo.sheetName()));
                    } else {
                        errors.add(new ErrorEntity(0, 0, fieldName.name(), Constants.ErrorCode.KHONGCOGIATRI, ""));
                    }
                }
            }
            
            if(errors.size() > 0) return errors;

            if (fieldValue != null) {
                // MaxLength
                final Maxlength maxLength = field.getAnnotation(Maxlength.class);
                if (maxLength != null) {
                    if (fieldValue instanceof String) {
                        //Hummm: unicode charactor
                        byte[] bytes = ((String) fieldValue).getBytes(Charset.forName("UTF-8"));
                        if (maxLength.maxLength() < bytes.length) {
                            isDecimalErrorLength = true;
                            if (excelInfo != null) {
                                errors.add(new ErrorEntity(excelInfo.row(), excelInfo.col(),
                                        fieldName.name(), Constants.ErrorCode.VUOTQUACHIEUDAI, excelInfo.sheetName()));
                            } else {
                                errors.add(new ErrorEntity(0, 0, fieldName.name(), Constants.ErrorCode.VUOTQUACHIEUDAI, ""));
                            }
                        }
                    }
                }

                // Email
                final Email email = field.getAnnotation(Email.class);
                if (email != null) {
                    if (!Utility.IsEmail((String) fieldValue)) {
                        if (excelInfo != null) {
                            errors.add(new ErrorEntity(excelInfo.row(), excelInfo.col(),
                                    fieldName.name(), Constants.ErrorCode.KHONGDUNGDINHDANG, excelInfo.sheetName()));
                        } else {
                            errors.add(new ErrorEntity(0, 0, fieldName.name(), Constants.ErrorCode.KHONGDUNGDINHDANG, ""));
                        }
                    }
                }

                // Decimal number
                final DecimalNumber decimalN = field.getAnnotation(DecimalNumber.class);
                if (decimalN != null) { 
                    
                    if(isDecimalErrorLength) return errors;
                    
                    String val = fieldValue.toString();
                    int count = StringUtils.countOccurrencesOf(val, ".");
                    if (count > 1) {
                        errors.add(new ErrorEntity(excelInfo.row(), excelInfo.col(),
                                fieldName.name(), Constants.ErrorCode.KHONGDUNGDINHDANG, excelInfo.sheetName()));
                    } else {
                        if(count == 1) {                            
                            String[] str = val.trim().split("\\.");
                            String precision = str[0];
                            String scale = str[1];
                            if (!Utility.IsDecimal(val, precision, scale)
                                || ThuTuc06Constant.DefaultValue.VALUE_1S.equals(fieldValue)) {
                                if (excelInfo != null) {
                                    errors.add(new ErrorEntity(excelInfo.row(), excelInfo.col(),
                                            fieldName.name(), Constants.ErrorCode.KHONGDUNGDINHDANG, excelInfo.sheetName()));
                                } else {
                                    errors.add(new ErrorEntity(0, 0, fieldName.name(), Constants.ErrorCode.KHONGDUNGDINHDANG, ""));
                                }
                            }
                        }
                    }
                }

                // DateTime
                final DateAttribute date = field.getAnnotation(DateAttribute.class);
                if (date != null) {
                    Date dt = (Date) fieldValue;
                    String dts = DateTimeUtils.convertDateToString(dt);
                    if (!Utility.IsDate(dts)) {
                        if (excelInfo != null) {
                            errors.add(new ErrorEntity(excelInfo.row(), excelInfo.col(),
                                    fieldName.name(), Constants.ErrorCode.KHONGDUNGDINHDANG, excelInfo.sheetName()));
                        } else {
                            errors.add(new ErrorEntity(0, 0, fieldName.name(), Constants.ErrorCode.KHONGDUNGDINHDANG, ""));
                        }
                    } else if (DateTimeUtils.compare2Date(dt, DateTimeUtils.MAX_DATE) == 0) {
                        if (excelInfo != null) {
                            errors.add(new ErrorEntity(excelInfo.row(), excelInfo.col(),
                                    fieldName.name(), Constants.ErrorCode.KHONGNHOHON_NGAYHIENTAI, excelInfo.sheetName()));
                        } else {
                            errors.add(new ErrorEntity(0, 0, fieldName.name(), Constants.ErrorCode.KHONGNHOHON_NGAYHIENTAI, ""));
                        }
                    } else if (DateTimeUtils.compare2Date(dt, DateTimeUtils.MIN_DATE) == 0) {
                        if (excelInfo != null) {
                            errors.add(new ErrorEntity(excelInfo.row(), excelInfo.col(),
                                    fieldName.name(), Constants.ErrorCode.KHONGDUNGDINHDANG, excelInfo.sheetName()));
                        } else {
                            errors.add(new ErrorEntity(0, 0, fieldName.name(), Constants.ErrorCode.KHONGDUNGDINHDANG, ""));
                        }
                    }
                }
            }
        }

        return errors;
    }
}
