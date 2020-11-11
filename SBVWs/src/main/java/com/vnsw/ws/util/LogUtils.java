package com.vnsw.ws.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogUtils {

    public static final Logger LOGGER = LoggerFactory.getLogger(LogUtils.class);

    /**
     * Lưu log
     *
     * @param ex
     */
    public static void addLog(Exception ex) {
        try {
            LogStruct log = new LogStruct();
            log.className = Thread.currentThread().getStackTrace()[2]
                    .getClassName();
            log.lineOfCode = Thread.currentThread().getStackTrace()[2]
                    .getLineNumber();
            log.methodName = Thread.currentThread().getStackTrace()[2]
                    .getMethodName();
            LOGGER.error(log.className + " line:" + log.lineOfCode
                    + " method: " + log.methodName + " des:" + log.description);
        } catch (Exception ex2) {
            LOGGER.error("Lỗi khi lưu log: ", ex2);
        }

        try {
            LogStruct log = new LogStruct();
            log.className = Thread.currentThread().getStackTrace()[3]
                    .getClassName();
            log.lineOfCode = Thread.currentThread().getStackTrace()[3]
                    .getLineNumber();
            log.methodName = Thread.currentThread().getStackTrace()[3]
                    .getMethodName();
            LOGGER.error(log.className + " line:" + log.lineOfCode
                    + " method: " + log.methodName + " des:" + log.description);
        } catch (Exception ex2) {
            LOGGER.error("Lỗi khi lưu log: ", ex2);
        }
        try {
            LogStruct log = new LogStruct();
            log.className = Thread.currentThread().getStackTrace()[4]
                    .getClassName();
            log.lineOfCode = Thread.currentThread().getStackTrace()[4]
                    .getLineNumber();
            log.methodName = Thread.currentThread().getStackTrace()[4]
                    .getMethodName();
            LOGGER.error(log.className + " line:" + log.lineOfCode
                    + " method: " + log.methodName + " des:" + log.description);
        } catch (Exception ex2) {
            LOGGER.error("Lỗi khi lưu log: ", ex2);
        }

    }
}

class LogStruct {

    String className;
    int lineOfCode;
    String methodName;
    String description;
}
