/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnsw.ws.util;

import org.apache.log4j.Logger;


public class LogUtil {

    private static final Logger logger = Logger.getLogger(LogUtil.class);

    public static void addLogInfo(String description) {
        LogInfo log = new LogInfo();
        log.className = Thread.currentThread().getStackTrace()[2].getClassName();
        log.lineOfCode = Thread.currentThread().getStackTrace()[2].getLineNumber();
        log.methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        log.description = description;
        logger.info("className:" + log.className + " lineOfCode:" + log.lineOfCode
                + " methodName: " + log.methodName + " description:" + log.description);
    }

    public static void addLog(Exception en) {
        LogInfo log = new LogInfo();
        log.className = Thread.currentThread().getStackTrace()[2].getClassName();
        log.lineOfCode = Thread.currentThread().getStackTrace()[2].getLineNumber();
        log.methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        logger.error(log, en);
        logger.error("className:" + log.className + " lineOfCode:" + log.lineOfCode
                + " methodName: " + log.methodName + " description:" + log.description);
    }
}
