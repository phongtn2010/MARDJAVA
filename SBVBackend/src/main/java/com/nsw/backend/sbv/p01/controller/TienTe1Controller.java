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
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping(value ="/sbv/01/tienTe1")
public class TienTe1Controller extends BaseController {

	private static final Logger LOGGER = LoggerFactory.getLogger(TienTe1Controller.class);

	private static final String CLASS_NAME = TienTe1Controller.class.getSimpleName();

	@Autowired
	private TienTe1Service mTienTe1Service;

	@ResponseBody
	@RequestMapping(value ="/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResponseJson> createTienTe1(@RequestBody TienTe1 pTienTe1) {

		String errorMessage = "";
		boolean isSuccess = false;
		Object data = null;

		try {
			data = mTienTe1Service.createTienTe1(pTienTe1);
			isSuccess = true;
		} catch (Exception e) {
			LOGGER.error("[createTienTe1 | "+ e.getMessage() +"]", e);
			pushLog(e, CLASS_NAME);
			errorMessage =  e.getMessage() +" | "+ getStackTrace(e.getCause()) +"]";
		}

		return createResponse(data, isSuccess, errorMessage);
	}

	@ResponseBody
	@RequestMapping(value ="/update/{primaryKey}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResponseJson> updateTienTe1(@PathVariable(name = "primaryKey") long primaryKey, @RequestBody TienTe1 pTienTe1) {

		String errorMessage = "";
		boolean isSuccess = false;
		Object data = null;

		try {
			TienTe1 findById = mTienTe1Service.getTienTe1(primaryKey);
			if (findById != null) {
				data = mTienTe1Service.updateTienTe1(primaryKey, pTienTe1);
				isSuccess = true;
			}
		} catch (Exception e) {
			LOGGER.error("[updateTienTe1 | "+ e.getMessage() +"]", e);
			pushLog(e, CLASS_NAME);
			errorMessage =  e.getMessage() +" | "+ getStackTrace(e.getCause()) +"]";
		}

		return createResponse(data, isSuccess, errorMessage);
	}

	@ResponseBody
	@RequestMapping(value ="/delete/{primaryKey}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResponseJson> deleteTienTe1(@PathVariable(name = "primaryKey") long primaryKey) {

		String errorMessage = "";
		boolean isSuccess = false;
		Object data = null;

		try {
			TienTe1 findById = mTienTe1Service.getTienTe1(primaryKey);
			if (findById != null) {
				data = mTienTe1Service.deleteTienTe1(findById);
				isSuccess = true;
			}
		} catch (Exception e) {
			LOGGER.error("[deleteTienTe1 | "+ e.getMessage() +"]", e);
			pushLog(e, CLASS_NAME);
			errorMessage = e.getMessage() +" | "+ getStackTrace(e.getCause()) +"]";
		}

		return createResponse(data, isSuccess, errorMessage);
	}

	@ResponseBody
	@RequestMapping(value ="/get/{primaryKey}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResponseJson> getTienTe1(@PathVariable(name = "primaryKey") long primaryKey) {

		String errorMessage = "";
		boolean isSuccess = false;
		Object data = null;

		try {
			TienTe1 findById = mTienTe1Service.getTienTe1(primaryKey);
			if (findById != null) {
				data = findById;
				isSuccess = true;
			}
		} catch (Exception e) {
			LOGGER.error("[getTienTe1 | "+ e.getMessage() +"]", e);
			pushLog(e, CLASS_NAME);
			errorMessage =  e.getMessage() +" | "+ getStackTrace(e.getCause()) +"]";
		}

		return createResponse(data, isSuccess, errorMessage);
	}

	@ResponseBody
	@RequestMapping(value ="/getByTienTes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResponseJson> getByTienTes(@RequestParam(required = true, name="idHoSo", defaultValue = "0")long idHoSo) {

		String errorMessage = "";
		boolean isSuccess = false;
		Object data = null;

		try {
			data = mTienTe1Service.getByTienTes(idHoSo);
			isSuccess = true;
		} catch (Exception e) {
			LOGGER.error("[getByTienTes | "+ e.getMessage() +"]", e);
			pushLog(e, CLASS_NAME);
			errorMessage =  e.getMessage() +" | "+ getStackTrace(e.getCause()) +"]";
		}

		return createResponse(data, isSuccess, errorMessage);
	}

	private static String getStackTrace(Throwable e) {

		return e.getLocalizedMessage();
	}

}