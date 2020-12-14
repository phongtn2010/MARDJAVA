package com.nsw.mic.p04.rest;

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
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
@RequestMapping(Mic04Constant.ROOT_API)
public class FileExcelTemplateDownload04Api {

    public static final Logger LOGGER = LoggerFactory.getLogger(FileExcelTemplateDownload04Api.class);

    @Autowired
    private Mic04TbdHoSo04Api mic04TbdHoSo04Api;

    @RequestMapping(value = "/downloadTemplate/excel", method = RequestMethod.GET)
    public void downloadTemplate(HttpServletResponse response) {
        try {
            String mimeType = "application/octet-stream";
            response.setContentType(mimeType);
            response.setHeader("Content-Disposition", String.format("filename=\"Danh sách nhân viên thẩm định nội dung sách nhập khẩu.xls\""));
            ClassLoader classLoader = getClass().getClassLoader();
            FileCopyUtils.copy(Files.readAllBytes(Paths.get(classLoader.getResource("mic/03/Template_04.xls").toURI())), response.getOutputStream());
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage(), ex);
        }
    }

}
