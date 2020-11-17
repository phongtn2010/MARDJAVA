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
@RequestMapping(value ="/sbv/01/yeuCauHuyHS1")
public class YeuCauHuyHoSo1Controller extends BaseController {

	private static final Logger LOGGER = LoggerFactory.getLogger(YeuCauHuyHoSo1Controller.class);

	private static final String CLASS_NAME = YeuCauHuyHoSo1Controller.class.getSimpleName();

	@Autowired
	private YeuCauHuyHoSo1Service mYeuCauHuyHoSo1Service;

	@ResponseBody
	@RequestMapping(value ="/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResponseJson> createYeuCauHuyHoSo1(@RequestBody YeuCauHuyHoSo1 pYeuCauHuyHoSo1) {

		String errorMessage = "";
		boolean isSuccess = false;
		Object data = null;

		try {
			data = mYeuCauHuyHoSo1Service.createYeuCauHuyHoSo1(pYeuCauHuyHoSo1);
			isSuccess = true;
		} catch (Exception e) {
			LOGGER.error("[createYeuCauHuyHoSo1 | "+ e.getMessage() +"]", e);
			pushLog(e, CLASS_NAME);
			errorMessage =  e.getMessage() +" | "+ getStackTrace(e.getCause()) +"]";
		}

		return createResponse(data, isSuccess, errorMessage);
	}

	@ResponseBody
	@RequestMapping(value ="/update/{primaryKey}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResponseJson> updateYeuCauHuyHoSo1(@PathVariable(name = "primaryKey") long primaryKey, @RequestBody YeuCauHuyHoSo1 pYeuCauHuyHoSo1) {

		String errorMessage = "";
		boolean isSuccess = false;
		Object data = null;

		try {
			YeuCauHuyHoSo1 findById = mYeuCauHuyHoSo1Service.getYeuCauHuyHoSo1(primaryKey);
			if (findById != null) {
				data = mYeuCauHuyHoSo1Service.updateYeuCauHuyHoSo1(primaryKey, pYeuCauHuyHoSo1);
				isSuccess = true;
			}
		} catch (Exception e) {
			LOGGER.error("[updateYeuCauHuyHoSo1 | "+ e.getMessage() +"]", e);
			pushLog(e, CLASS_NAME);
			errorMessage =  e.getMessage() +" | "+ getStackTrace(e.getCause()) +"]";
		}

		return createResponse(data, isSuccess, errorMessage);
	}

	@ResponseBody
	@RequestMapping(value ="/delete/{primaryKey}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResponseJson> deleteYeuCauHuyHoSo1(@PathVariable(name = "primaryKey") long primaryKey) {

		String errorMessage = "";
		boolean isSuccess = false;
		Object data = null;

		try {
			YeuCauHuyHoSo1 findById = mYeuCauHuyHoSo1Service.getYeuCauHuyHoSo1(primaryKey);
			if (findById != null) {
				data = mYeuCauHuyHoSo1Service.deleteYeuCauHuyHoSo1(findById);
				isSuccess = true;
			}
		} catch (Exception e) {
			LOGGER.error("[deleteYeuCauHuyHoSo1 | "+ e.getMessage() +"]", e);
			pushLog(e, CLASS_NAME);
			errorMessage = e.getMessage() +" | "+ getStackTrace(e.getCause()) +"]";
		}

		return createResponse(data, isSuccess, errorMessage);
	}

	@ResponseBody
	@RequestMapping(value ="/get/{primaryKey}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResponseJson> getYeuCauHuyHoSo1(@PathVariable(name = "primaryKey") long primaryKey) {

		String errorMessage = "";
		boolean isSuccess = false;
		Object data = null;

		try {
			YeuCauHuyHoSo1 findById = mYeuCauHuyHoSo1Service.getYeuCauHuyHoSo1(primaryKey);
			if (findById != null) {
				data = findById;
				isSuccess = true;
			}
		} catch (Exception e) {
			LOGGER.error("[getYeuCauHuyHoSo1 | "+ e.getMessage() +"]", e);
			pushLog(e, CLASS_NAME);
			errorMessage =  e.getMessage() +" | "+ getStackTrace(e.getCause()) +"]";
		}

		return createResponse(data, isSuccess, errorMessage);
	}

	@ResponseBody
	@RequestMapping(value ="/getYeuCauHuyHoSo1s", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResponseJson> getYeuCauHuyHoSo1s(@RequestParam(required = true, name="idHoSo", defaultValue = "0")long idHoSo) {

		String errorMessage = "";
		boolean isSuccess = false;
		Object data = null;

		try {
			data = mYeuCauHuyHoSo1Service.getYeuCauHuyHoSo1s(idHoSo);
			isSuccess = true;
		} catch (Exception e) {
			LOGGER.error("[getYeuCauHuyHoSo1s | "+ e.getMessage() +"]", e);
			pushLog(e, CLASS_NAME);
			errorMessage =  e.getMessage() +" | "+ getStackTrace(e.getCause()) +"]";
		}

		return createResponse(data, isSuccess, errorMessage);
	}

	private static String getStackTrace(Throwable e) {

		return e.getLocalizedMessage();
	}

}