package com.nsw.backend.sbv.p01.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.nsw.backend.util.ResponseJson;


public class BaseController {


	public void pushLog(Exception ex, String className) {


	}

	public ResponseEntity<ResponseJson> createResponse(Object obj, boolean isSuccess, String errorMessage) {

		ResponseJson objResponse = new ResponseJson();
		objResponse.setData(obj);
		objResponse.setSuccess(isSuccess);
		objResponse.setMessage(errorMessage);

		return new ResponseEntity<>(objResponse, HttpStatus.OK);
	}

}