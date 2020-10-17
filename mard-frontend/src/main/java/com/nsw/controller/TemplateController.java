/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.controller;

import com.nsw.constant.AppConstant;
import com.nsw.helper.RabbitMQErrorHelper;
import com.nsw.helper.RabbitMQInfo;
import com.nsw.service.RabbitMQService;
import com.nsw.util.LogUtil;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author PhongNguyen
 */
@Controller
@RequestMapping("/templates")
public class TemplateController {

    @Autowired
    Environment environment;

    @Autowired
    RabbitMQService rabbitMQService;

    private static final String CLASS_NAME = "TemplateController";

    @RequestMapping("/{code}/{fileName:.+}")
    public void downloadResource(HttpServletRequest request,
            HttpServletResponse response,
            @PathVariable("code") String code,
            @PathVariable("fileName") String fileName,
            @RequestHeader String referer) {

        try {
            String dataDirectory = request.getServletContext().getRealPath("/WEB-INF/downloads/" + code + "/");
            Path file = Paths.get(dataDirectory, fileName);
            if (Files.exists(file)) {
                String mimeType = URLConnection.guessContentTypeFromName(fileName);

                if (mimeType == null) {
                    mimeType = "application/octet-stream";
                }

                response.setContentType(mimeType);
                response.addHeader("Content-Disposition", "attachment; filename=" + fileName);

                Files.copy(file, response.getOutputStream());
                response.getOutputStream().flush();

            }
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + CLASS_NAME
                    + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQInfo mqInfo = getRabbitMQ();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, mqInfo);
        }
    }

    private RabbitMQInfo getRabbitMQ() {
        return rabbitMQService.getRabbitMQInfo();
    }

}
