package com.nsw.mard.p15.rest;

import com.nsw.common.model.ResponseUpload;
import com.nsw.common.model.json.ResponseJson;
import com.nsw.constant.AppConstant;
import com.nsw.helper.FileServiceHelper;
import com.nsw.helper.RabbitMQErrorHelper;
import com.nsw.helper.RabbitMQInfo;
import com.nsw.mard.p15.model.TbdDinhKem15;
import com.nsw.mard.p15.model.TbdHoSo15;
import com.nsw.mard.p15.model.TbdKetQuaXuLy15;
import com.nsw.service.RabbitMQService;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.env.Environment;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/mard/api/15")
public class Mard15FileApi extends Mard15CallBack {

    private static final Logger LOGGER = LoggerFactory.getLogger(Mard15FileApi.class);

    private static final String UNDEFINED_INPUT = "undefined,";

    @Autowired
    protected Environment environment;

    @Autowired
    protected MessageSource messageSource;

    @Autowired
    protected RabbitMQService rabbitMQService;

    @Autowired
    private Mard15TbdDinhKem15Resource fldMard15TbdDinhKem15Resource;

    @Autowired
    private Mard15TbdKetQuaXuLy15Resource fldMard15TbdKetQuaXuLy15Resource;

    @Autowired
    private Mard15TbdHoSo15Resource fldMard15TbdHoSo15Resource;


    @RequestMapping(value = "/upload/{idHoSo}/{maLoaiTepTin}", method = RequestMethod.POST)
    public @ResponseBody
    ResponseJson uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("mcode") String mcode, @RequestParam("pcode") String pcode, HttpServletRequest request, @PathVariable("idHoSo") long idHoSo, @PathVariable("maLoaiTepTin") int maLoaiTepTin) {
        if (StringUtils.hasText(mcode) && mcode.startsWith(UNDEFINED_INPUT)) {
            mcode = mcode.replace(UNDEFINED_INPUT, "");
        }
        if (StringUtils.hasText(pcode) && pcode.startsWith(UNDEFINED_INPUT)) {
            pcode = pcode.replace(UNDEFINED_INPUT, "");
        }
        FileServiceHelper fileHelper = new FileServiceHelper();

        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        try {
            if (file.isEmpty() || !StringUtils.hasText(mcode) || !StringUtils.hasText(pcode)) {
                return json;
            }

            String tempFolder = environment.getProperty(AppConstant.Download.TemSaveFolder);
            String uri = getURL("/mard/15/file/upload/");
            ResponseJson responseJson = fileHelper.uploadFile(uri, file, tempFolder, mcode, pcode, rabbitMQService.getRabbitMQInfo());
            if (!isUploadSuccess(responseJson)) return null;
            LOGGER.info("Upload file success: {}, size: {}", file.getOriginalFilename(), file.getSize());
            json = responseJson;
            ResponseUpload responseUpload = readObject(json, ResponseUpload.class);
            if (responseUpload != null) {
                String uuId = FilenameUtils.getBaseName(responseUpload.getFileCode());

                TbdDinhKem15 dinhKem15 = new TbdDinhKem15();
                dinhKem15.setFiUuid(uuId);
                dinhKem15.setFiPath(responseUpload.getFilePath());
                dinhKem15.setFiIdHoSo(idHoSo);
                dinhKem15.setFiFileName(file.getOriginalFilename());
                dinhKem15.setFiFileCode(responseUpload.getFileCode());
                dinhKem15.setFiSize(file.getSize());
                dinhKem15.setFiFileTypeCode(String.valueOf(maLoaiTepTin));
                dinhKem15.setFiFileGroup(Mard15Api.DOCUMENT_TYPE);

                if (idHoSo > 0) {
                    LOGGER.info("Create tep dinh kem: {}", dinhKem15);
                    dinhKem15 = fldMard15TbdDinhKem15Resource.createTbdDinhKem15(dinhKem15).getBody();
                    createHistory(fldMard15TbdKetQuaXuLy15Resource, fldMard15TbdHoSo15Resource, "Thêm tệp đính kèm: " + dinhKem15.getFiFileName(), idHoSo);
                }

                json.setData(dinhKem15);
                json.setSuccess(true);
                return json;
            }

        } catch (Exception ex) {
            LOGGER.error(ex.getMessage(), ex);
        }

        return null;
    }

    @RequestMapping(value = "/download/{idTepDinhKem}", method = RequestMethod.GET)
    public void downloadFile(HttpServletResponse response, @PathVariable("idTepDinhKem") long idTepDinhKem) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {

            TbdDinhKem15 dinhKem15 = fldMard15TbdDinhKem15Resource.getTbdDinhKem15(idTepDinhKem).getBody();

            if (dinhKem15 != null) {
                String fileCode = dinhKem15.getFiFileCode();
                try {
                    downloadFile(response, fileCode, fileCode, fileCode, dinhKem15.getFiPath());
                } catch (IOException e) {
                    LOGGER.error(e.getMessage(), e);
                }
            }

        }
    }

    @RequestMapping(value = "/getfile/{mcode}/{pcode}/{code}", method = RequestMethod.GET)
    public void downloadNewFile(HttpServletResponse response, @PathVariable("code") String code, @PathVariable("mcode") String mCode, @PathVariable("pcode") String pCode) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            try {
                if (code != null) {
                    Date date = new Date();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                    String spack = "/";
                    String filePath = mCode + spack + pCode + spack + dateFormat.format(date);
                    downloadFile2(response, code, code, filePath);
                }
            } catch (Exception ex) {

                LOGGER.error(ex.getMessage(), ex);
            }
        }
    }


    private void downloadFile(HttpServletResponse response, String fileCode, String fileName, String fileCodeDb, String filePathDb) throws IOException {
        String name = fileName;
        String path = filePathDb;
        String mimeType = "";
        if (name == null) {
            name = fileCode;
        }

        if (fileCodeDb.equals(fileCode)) {
            FileServiceHelper fileHelper = new FileServiceHelper();
            String uri = getURL("/mard/15/file/download/");
            byte[] fileByte = fileHelper.downloadFile(uri, path, fileCode, rabbitMQService.getRabbitMQInfo());

            if (!ObjectUtils.isEmpty(fileByte)) {
                LOGGER.info("SIZE = {}, {}, {}", fileCode, fileName, fileCodeDb);
                Path savePath = Paths.get(environment.getProperty(AppConstant.Download.TemSaveFolder) + name);
                Files.write(savePath, fileByte);

                File downloadFile = savePath.toFile();

                mimeType = URLConnection.guessContentTypeFromName(name);
                if (mimeType == null) {
                    mimeType = "application/octet-stream";
                }

                response.setContentType(mimeType);
                response.setHeader("Content-Disposition", String.format("attachment; filename=\"%s\"", name));
                response.setContentLength((int) downloadFile.length());

                try (OutputStream outStream = response.getOutputStream(); FileInputStream inputStream = new FileInputStream(downloadFile)) {

                    byte[] buffer = new byte[4096];
                    int bytesRead = -1;

                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        outStream.write(buffer, 0, bytesRead);
                    }
                }
                Files.delete(savePath);
            }
        }
    }

    private void downloadFile2(HttpServletResponse response, String fileCode, String fileName, String filePathDb) throws IOException {
        String name = fileName;
        String path = filePathDb;
        String mimeType = "";
        RabbitMQInfo mqInfo = rabbitMQService.getRabbitMQInfo();
        if (name == null) {
            name = fileCode;
        }

        String uri = getURL("/mard/15/file/download/");
        FileServiceHelper fileHelper = new FileServiceHelper();
        byte[] fileByte = fileHelper.downloadFile(uri, path, fileCode, mqInfo);

        Path savePath = Paths.get(environment.getProperty(AppConstant.Download.TemSaveFolder) + name);
        Files.write(savePath, fileByte);

        File downloadFile = savePath.toFile();

        mimeType = URLConnection.guessContentTypeFromName(name);
        if (mimeType == null) {
            mimeType = "application/octet-stream";
        }

        response.setContentType(mimeType);
        response.setHeader("Content-Disposition", String.format("attachment; filename=\"%s\"", name));
        response.setContentLength((int) downloadFile.length());

        try (OutputStream outStream = response.getOutputStream(); FileInputStream inputStream = new FileInputStream(downloadFile)) {

            byte[] buffer = new byte[4096];
            int bytesRead = -1;

            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outStream.write(buffer, 0, bytesRead);
            }
        }
        Files.delete(savePath);
    }

    private boolean isUploadSuccess(ResponseJson responseJson) {
        boolean isTrue = true;
        if (responseJson == null || !responseJson.isSuccess() || responseJson.getData() == null) return false;

        return isTrue;
    }

}
