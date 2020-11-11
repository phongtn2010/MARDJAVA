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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping(value ="/sbv/01/trangThai1")
public class TrangThai1Controller extends BaseController {

	private static final Logger LOGGER = LoggerFactory.getLogger(TrangThai1Controller.class);

	private static final String CLASS_NAME = TrangThai1Controller.class.getSimpleName();

	@Autowired
	private TrangThai1Service mTrangThai1Service;

	@ResponseBody
	@RequestMapping(value ="/get/{primaryKey}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResponseJson> getTrangThai1(@PathVariable(name = "primaryKey") long primaryKey) {

		String errorMessage = "";
		boolean isSuccess = false;
		Object data = null;

		try {
			TrangThai1 findById = mTrangThai1Service.getTrangThai1(primaryKey);
			if (findById != null) {
				data = findById;
				isSuccess = true;
			}
		} catch (Exception e) {
			LOGGER.error("[getTrangThai1 | "+ e.getMessage() +"]", e);
			pushLog(e, CLASS_NAME);
			errorMessage =  e.getMessage() +" | "+ getStackTrace(e.getCause()) +"]";
		}

		return createResponse(data, isSuccess, errorMessage);
	}

	@ResponseBody
	@RequestMapping(value ="/findByGiaTri", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResponseJson> findByGiaTri(@RequestParam(required = true, name="giaTri", defaultValue = "0")int giaTri) {

		String errorMessage = "";
		boolean isSuccess = false;
		Object data = null;

		try {
			data = mTrangThai1Service.findByGiaTri(giaTri);
			isSuccess = true;
		} catch (Exception e) {
			LOGGER.error("[findByGiaTri | "+ e.getMessage() +"]", e);
			pushLog(e, CLASS_NAME);
			errorMessage =  e.getMessage() +" | "+ getStackTrace(e.getCause()) +"]";
		}

		return createResponse(data, isSuccess, errorMessage);
	}

	@ResponseBody
	@RequestMapping(value ="/getAllTrangThai1s", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResponseJson> getAllTrangThai1s() {

		String errorMessage = "";
		boolean isSuccess = false;
		Object data = null;

		try {
			data = mTrangThai1Service.getAllTrangThai1s();
			isSuccess = true;
		} catch (Exception e) {
			LOGGER.error("[getAllTrangThai1s | "+ e.getMessage() +"]", e);
			pushLog(e, CLASS_NAME);
			errorMessage =  e.getMessage() +" | "+ getStackTrace(e.getCause()) +"]";
		}

		return createResponse(data, isSuccess, errorMessage);
	}

	private static String getStackTrace(Throwable e) {

		return e.getLocalizedMessage();
	}

}