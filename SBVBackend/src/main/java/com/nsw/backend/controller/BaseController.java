package com.nsw.backend.controller;


import com.nsw.backend.util.Constants;
import com.nsw.backend.util.ResponseJson;
import com.nsw.backend.ws.client.ResponseDownload;
import com.nsw.backend.ws.client.ResponseUpload;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class BaseController {

    private static final Logger LOG = LoggerFactory.getLogger(BaseController.class);

    /**
     * linhdx log ban tin loi
     *
     * @param ex
     * @return
     */
    public String logMessage(Exception ex) {
        String errorMessage = ex.getMessage();
        return logMessage(errorMessage);
    }

    /**
     * linhdx log ban tin
     *
     * @param errorMessage
     * @return
     */
    public String logMessage(String errorMessage) {
        LOG.error(errorMessage);
        return errorMessage;
    }

    public ResponseEntity<ResponseJson> createResponse(Object obj, boolean isSuccess,
                                                       String errorMessage, HttpStatus httpStatus) {
        ResponseJson objResponse = new ResponseJson();
        objResponse.setData(obj);
        objResponse.setSuccess(isSuccess);
        objResponse.setMessage(errorMessage);
        //LOG.info("response = " + objResponse.toString());

        return new ResponseEntity<>(objResponse, httpStatus);
    }

    /**
     * linhdx Tao Response Create Response
     *
     * @param lstResult
     * @param isSuccess
     * @param errorMessage
     * @param httpStatus
     * @param total
     * @return
     */
    @SuppressWarnings("rawtypes")
    public ResponseEntity<ResponseJson> createResponse(List lstResult, boolean isSuccess, String errorMessage,
                                                       HttpStatus httpStatus, Long total) {
        ResponseJson objResponse = new ResponseJson();
        objResponse.setData(lstResult);
        if (total == null) {
            total = lstResult != null ? Long.valueOf(lstResult.size()) : 0L;
        }
        objResponse.setTotal(total);
        objResponse.setSuccess(isSuccess);
        objResponse.setMessage(errorMessage);
//		logger.info("response = " + objResponse.toString());
        return new ResponseEntity<>(objResponse, httpStatus);
    }

    public ResponseEntity<ResponseJson> createSuccessResponse(Object obj, HttpStatus httpStatus) {
        return createResponse(obj, true, "", httpStatus);
    }

    public ResponseEntity<ResponseJson> createErrorResponse(Object obj, String errorMessage, HttpStatus httpStatus) {
        return createResponse(obj, false, errorMessage, httpStatus);
    }

    public ResponseEntity<ResponseJson> createErrorResponse(String errorMessage, HttpStatus httpStatus) {
        return createResponse(null, false, errorMessage, httpStatus);
    }

    protected ResponseEntity<ResponseJson> createResponseUpload(ResponseUpload res, HttpStatus httpStatus) {
        ResponseJson objResponse = new ResponseJson();
        objResponse.setData(res);
        objResponse.setSuccess(true);
        objResponse.setMessage("");
        //LOG.info("upload response = " + objResponse.toString());

        return new ResponseEntity<>(objResponse, httpStatus);
    }

    protected ResponseEntity<ResponseJson> createResponseDownload(ResponseDownload res, HttpStatus httpStatus) {
        ResponseJson objResponse = new ResponseJson();
        objResponse.setData(res);
        objResponse.setSuccess(true);
        objResponse.setMessage("");
        //LOG.info("download response = " + objResponse.toString());

        return new ResponseEntity<>(objResponse, httpStatus);
    }

    protected ResponseEntity<ResponseJson> createResponseDownload(byte[] res, String fileName, HttpStatus httpStatus) {
        ResponseJson objResponse = new ResponseJson();
        objResponse.setData(Base64.encodeBase64String(res));//new String()
        objResponse.setSuccess(true);
        objResponse.setMessage(fileName);
        //OG.info("download response = " + objResponse.toString());

        return new ResponseEntity<>(objResponse, httpStatus);
    }

    protected String getErrorInfo(String tag, Exception error) {
        return Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + tag
                + Constants.MESSAGE_SEPARATOR + error.getStackTrace()[1].getMethodName()
                + Constants.MESSAGE_SEPARATOR + error.toString();
    }

    protected File base64ToFile(String base64FileData, File file) {
        byte data[] = Base64.decodeBase64(base64FileData);
        FileOutputStream fos = null;
        try {
            //File file = new File(filePath);
            fos = new FileOutputStream(file);
            fos.write(data);
            return file;
        } catch (Exception e) {
            LOG.error("BaseController::base64ToFile", e);
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException ex) {
                    LOG.error("BaseController::base64ToFile::close", ex);
                }
            }
        }
        return null;
    }

    protected File base64ToFile(String base64FileData, String filePath) {
        return base64ToFile(base64FileData, new File(filePath));
    }
}
