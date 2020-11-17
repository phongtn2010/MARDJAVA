/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnsw.ws.helper;

import com.vnsw.ws.common.entity.json.ResponseJson;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class JsonHelper {

    /**
     * Tao Response Create Response
     *
     * @param lstResult
     * @param isSuccess
     * @param errorMessage
     * @param httpStatus
     * @param total
     * @return
     */
    @SuppressWarnings("rawtypes")
    public static ResponseEntity<ResponseJson> createResponse(List lstResult, boolean isSuccess, String errorMessage,
            HttpStatus httpStatus, Long total) {
        ResponseJson objResponse = new ResponseJson();
        objResponse.setData(lstResult);
        if (total == null) {
            total = lstResult != null ? Long.valueOf(lstResult.size()) : 0L;
        }
        objResponse.setTotal(total);
        objResponse.setSuccess(isSuccess);
        objResponse.setMessage(errorMessage);
        return new ResponseEntity<>(objResponse, httpStatus);
    }

    /**
     * Tao Response Create Response
     *
     * @param lstResult
     * @param isSuccess
     * @param errorMessage
     * @param httpStatus
     * @param total
     * @return
     */
    public static ResponseEntity<ResponseJson> createResponse(Object obj, boolean isSuccess, String errorMessage,
            HttpStatus httpStatus, Long total) {
        ResponseJson objResponse = new ResponseJson();
        objResponse.setData(obj);
        objResponse.setTotal(total);
        objResponse.setSuccess(isSuccess);
        objResponse.setMessage(errorMessage);
        return new ResponseEntity<>(objResponse, httpStatus);
    }
}
