package com.nsw.backend.sbv.p01.controller;

import com.nsw.backend.sbv.p01.model.*;
import com.nsw.backend.sbv.p01.service.*;
import com.nsw.backend.util.ResponseJson;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping(value ="/sbv/01/gpTienTe1")
public class GPTienTe1Controller extends BaseController {

	private static final Logger LOGGER = LoggerFactory.getLogger(GPTienTe1Controller.class);

	private static final String CLASS_NAME = GPTienTe1Controller.class.getSimpleName();

	@Autowired
	private GPTienTe1Service mGPTienTe1Service;

	@ResponseBody
	@RequestMapping(value ="/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResponseJson> createGPTienTe1(@RequestBody GPTienTe1 pGPTienTe1) {

		String errorMessage = "";
		boolean isSuccess = false;
		Object data = null;

		try {
			data = mGPTienTe1Service.createGPTienTe1(pGPTienTe1);
			isSuccess = true;
		} catch (Exception e) {
			LOGGER.error("[createGPTienTe1 | "+ e.getMessage() +"]", e);
			pushLog(e, CLASS_NAME);
			errorMessage =  e.getMessage() +" | "+ getStackTrace(e.getCause()) +"]";
		}

		return createResponse(data, isSuccess, errorMessage);
	}

	@ResponseBody
	@RequestMapping(value ="/update/{primaryKey}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResponseJson> updateGPTienTe1(@PathVariable(name = "primaryKey") long primaryKey, @RequestBody GPTienTe1 pGPTienTe1) {

		String errorMessage = "";
		boolean isSuccess = false;
		Object data = null;

		try {
			GPTienTe1 findById = mGPTienTe1Service.getGPTienTe1(primaryKey);
			if (findById != null) {
				data = mGPTienTe1Service.updateGPTienTe1(primaryKey, pGPTienTe1);
				isSuccess = true;
			}
		} catch (Exception e) {
			LOGGER.error("[updateGPTienTe1 | "+ e.getMessage() +"]", e);
			pushLog(e, CLASS_NAME);
			errorMessage =  e.getMessage() +" | "+ getStackTrace(e.getCause()) +"]";
		}

		return createResponse(data, isSuccess, errorMessage);
	}

	@ResponseBody
	@RequestMapping(value ="/delete/{primaryKey}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResponseJson> deleteGPTienTe1(@PathVariable(name = "primaryKey") long primaryKey) {

		String errorMessage = "";
		boolean isSuccess = false;
		Object data = null;

		try {
			GPTienTe1 findById = mGPTienTe1Service.getGPTienTe1(primaryKey);
			if (findById != null) {
				data = mGPTienTe1Service.deleteGPTienTe1(findById);
				isSuccess = true;
			}
		} catch (Exception e) {
			LOGGER.error("[deleteGPTienTe1 | "+ e.getMessage() +"]", e);
			pushLog(e, CLASS_NAME);
			errorMessage = e.getMessage() +" | "+ getStackTrace(e.getCause()) +"]";
		}

		return createResponse(data, isSuccess, errorMessage);
	}

	@ResponseBody
	@RequestMapping(value ="/get/{primaryKey}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResponseJson> getGPTienTe1(@PathVariable(name = "primaryKey") long primaryKey) {

		String errorMessage = "";
		boolean isSuccess = false;
		Object data = null;

		try {
			GPTienTe1 findById = mGPTienTe1Service.getGPTienTe1(primaryKey);
			if (findById != null) {
				data = findById;
				isSuccess = true;
			}
		} catch (Exception e) {
			LOGGER.error("[getGPTienTe1 | "+ e.getMessage() +"]", e);
			pushLog(e, CLASS_NAME);
			errorMessage =  e.getMessage() +" | "+ getStackTrace(e.getCause()) +"]";
		}

		return createResponse(data, isSuccess, errorMessage);
	}

	@ResponseBody
	@RequestMapping(value ="/getByIdCapGXNHoSo", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResponseJson> getByIdCapGXNHoSo() {

		String errorMessage = "";
		boolean isSuccess = false;
		Object data = null;

		try {
			data = mGPTienTe1Service.getByIdCapGXNHoSo();
			isSuccess = true;
		} catch (Exception e) {
			LOGGER.error("[getByIdCapGXNHoSo | "+ e.getMessage() +"]", e);
			pushLog(e, CLASS_NAME);
			errorMessage =  e.getMessage() +" | "+ getStackTrace(e.getCause()) +"]";
		}

		return createResponse(data, isSuccess, errorMessage);
	}

	private static String getStackTrace(Throwable e) {

		return e.getLocalizedMessage();
	}

}