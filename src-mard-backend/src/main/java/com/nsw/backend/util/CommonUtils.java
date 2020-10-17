/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.backend.util;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommonUtils {

    private static final Logger LOG = LoggerFactory.getLogger(CommonUtils.class);
    private static CommonUtils instance = null;

    protected CommonUtils() {
        LOG.info("CommonUtils start instance");
    }

    public static CommonUtils getInstance() {

        synchronized (CommonUtils.class) {
            if (instance == null) {
                LOG.info("getInstance(): First time getInstance was invoked!");
                instance = new CommonUtils();
            }
        }
        return instance;
    }

}
