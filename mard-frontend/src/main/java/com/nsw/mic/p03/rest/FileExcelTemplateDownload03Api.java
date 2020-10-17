package com.nsw.mic.p03.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
@RequestMapping(Mic03Constant.ROOT_API)
public class FileExcelTemplateDownload03Api {

    public static final Logger LOGGER = LoggerFactory.getLogger(FileExcelTemplateDownload03Api.class);

    @Autowired
    private Mic03TbdHoSo03Api mic03TbdHoSo03Api;

    @RequestMapping(value = "/downloadTemplate/excel", method = RequestMethod.GET)
    public void downloadTemplate(HttpServletResponse response) {
        try {
            String mimeType = "application/octet-stream";
            response.setContentType(mimeType);
            response.setHeader("Content-Disposition", String.format("filename=\"Danh sách xuất bản phẩm nhập khẩu không kinh doanh.xls\""));
            ClassLoader classLoader = getClass().getClassLoader();
            FileCopyUtils.copy(Files.readAllBytes(Paths.get(classLoader.getResource("mic/03/Template_03.xls").toURI())), response.getOutputStream());
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage(), ex);
        }
    }

}
