/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.api;

import com.nsw.common.model.TokenInfo;
import com.nsw.common.model.json.ResponseJson;
import com.nsw.helper.BackendRequestHelper;
import com.nsw.helper.RabbitMQInfo;
import com.nsw.security.UserCustom;
import com.nsw.service.RabbitMQService;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author phongnv
 */
@RestController
public class BaseApi {

    static final Logger logger = LoggerFactory.getLogger(BaseApi.class);
    private static final String TAG = "BaseApi";
    public static final String BACKEND_COMMON = "nsw.common.url";
    public static final String CHECK_SIGNATURE = "/ca/checkCA/";
    
    @Autowired
    protected Environment environment;
    @Autowired
    protected RabbitMQService rabbitMQService;

    /**
     * L?y category t? cache
     *
     * @param backend
     * @param key
     * @param id
     * @return
     */
    @RequestMapping(value = {"/cache/category"}, method = RequestMethod.GET, params = {})
    public ResponseJson getCategoryFromCache(@RequestParam("backend") String backend, @RequestParam("key") String key, @RequestParam(name = "id", required = false) String id) {
        try {
            String apiURI = environment.getRequiredProperty(backend) + environment.getRequiredProperty(key);
            if (id != null && !id.isEmpty()) {
                apiURI += id;
            }
            ResponseJson cate = BackendRequestHelper.getInstance().getFromCache(apiURI);
            return cate;
        } catch (Exception ex) {
            logger.error(TAG + "::getCategoryFromCache::", ex);
        }
        return null;
    }    
    
    public ResponseJson verifySignature(@RequestBody TokenInfo token) {
        String backendCommonUrl = environment.getRequiredProperty(BACKEND_COMMON);
        ResponseJson json = BackendRequestHelper
                .getInstance()
                .doPostRequest(backendCommonUrl + CHECK_SIGNATURE, token);
        return json;
    }

    /**
     *
     * @param property
     * @param restUri
     * @return
     */
    protected String getFullUri(String property, String restUri) {
        return environment.getRequiredProperty(property) + restUri;
    }

    /**
     * tao chuoi md5 cho uploadfile
     *
     * @param generateStr
     * @return
     */
    protected String generateMD5(String generateStr) {
        String key = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] msByte = generateStr.getBytes(Charset.forName("UTF-8"));
            byte byteData[] = md.digest(msByte);
            BigInteger number = new BigInteger(1, byteData);
            String hashtext = number.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            key = hashtext;
        } catch (NoSuchAlgorithmException ex) {
            logger.error(TAG + "::generateMD5", ex);
        }
        return key;
    }

    protected String getMimeType(String fileExtension) {
        if (null != fileExtension) {
            switch (fileExtension.toLowerCase()) {
                case "jpg":
                case "jpeg":
                    return "image/jpg";
                case "png":
                    return "image/png";
                case "pdf":
                    return "application/pdf";
                case "doc":
                    return "application/msword";
                case "docx":
                    return "application/vnd.openxmlformats-officedocument.wordprocessingml.document";
                case "xls":
                    return "application/vnd.ms-excel";
                case "xlsx":
                    return "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
                default:
                    return "application/octet-stream";
            }
        }
        return "application/octet-stream";
    }

    protected UserCustom getUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserCustom user = (UserCustom) principal;
        return user;
    }

    protected String getUsername() {
//        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        UserCustom user = (UserCustom) principal;
//        return user.getUsername();
        return null;
    }

    protected RabbitMQInfo getRabbitMQ() {
        return rabbitMQService.getRabbitMQInfo();
    }

    protected String encodeFileToBase64Binary(File file) throws IOException {
        byte[] bytes = loadFile(file);
        byte[] encoded = Base64.encodeBase64(bytes);
        String encodedString = new String(encoded);
        return encodedString;
    }

    protected String encodeFileToBase64Binary(String fileName) throws IOException {
        File file = new File(fileName);
        return encodeFileToBase64Binary(file);
    }

    protected static byte[] loadFile(File file) throws IOException {
        byte[] bytes;
        try (InputStream is = new FileInputStream(file)) {
            long length = file.length();
            if (length > Integer.MAX_VALUE) {
                // File is too large
            }
            bytes = new byte[(int) length];
            int offset = 0;
            int numRead = 0;
            while (offset < bytes.length
                    && (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
                offset += numRead;
            }
            if (offset < bytes.length) {
                throw new IOException("Could not completely read file " + file.getName());
            }
        }
        return bytes;
    }
    
    protected String decodeXmlMessage(String xmlEncode) throws IOException {
        Base64 base64 = new Base64();
        String decodedString = new String(base64.decode(xmlEncode.getBytes()), "UTF8");
        return decodedString;
    }

    protected String encodeXmlMessage(String xmlOriginal) throws IOException {
        Base64 base64 = new Base64();
        String encodeString = new String(base64.encode(xmlOriginal.getBytes("UTF8")), "UTF8");
        return encodeString;
    }
}
