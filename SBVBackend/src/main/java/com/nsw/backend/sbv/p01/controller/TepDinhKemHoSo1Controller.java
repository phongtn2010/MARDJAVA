package com.nsw.backend.sbv.p01.controller;

import com.nsw.backend.sbv.p01.model.*;
import com.nsw.backend.sbv.p01.service.*;
import com.nsw.backend.util.ResponseJson;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
@RequestMapping(value ="/sbv/01/tepDinhKem1")
public class TepDinhKemHoSo1Controller extends BaseController {

	private static final Logger LOGGER = LoggerFactory.getLogger(TepDinhKemHoSo1Controller.class);

	private static final String CLASS_NAME = TepDinhKemHoSo1Controller.class.getSimpleName();

	@Autowired
	private TepDinhKemHoSo1Service mTepDinhKemHoSo1Service;

	@ResponseBody
	@RequestMapping(value ="/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResponseJson> createTepDinhKemHoSo1(@RequestBody TepDinhKemHoSo1 pTepDinhKemHoSo1) {

		String errorMessage = "";
		boolean isSuccess = false;
		Object data = null;

		try {
			data = mTepDinhKemHoSo1Service.createTepDinhKemHoSo1(pTepDinhKemHoSo1);
			isSuccess = true;
		} catch (Exception e) {
			LOGGER.error("[createTepDinhKemHoSo1 | "+ e.getMessage() +"]", e);
			pushLog(e, CLASS_NAME);
			errorMessage =  e.getMessage() +" | "+ getStackTrace(e.getCause()) +"]";
		}

		return createResponse(data, isSuccess, errorMessage);
	}

	@ResponseBody
	@RequestMapping(value ="/update/{primaryKey}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResponseJson> updateTepDinhKemHoSo1(@PathVariable(name = "primaryKey") long primaryKey, @RequestBody TepDinhKemHoSo1 pTepDinhKemHoSo1) {

		String errorMessage = "";
		boolean isSuccess = false;
		Object data = null;

		try {
			TepDinhKemHoSo1 findById = mTepDinhKemHoSo1Service.getTepDinhKemHoSo1(primaryKey);
			if (findById != null) {
				data = mTepDinhKemHoSo1Service.updateTepDinhKemHoSo1(primaryKey, pTepDinhKemHoSo1);
				isSuccess = true;
			}
		} catch (Exception e) {
			LOGGER.error("[updateTepDinhKemHoSo1 | "+ e.getMessage() +"]", e);
			pushLog(e, CLASS_NAME);
			errorMessage =  e.getMessage() +" | "+ getStackTrace(e.getCause()) +"]";
		}

		return createResponse(data, isSuccess, errorMessage);
	}

	@ResponseBody
	@RequestMapping(value ="/delete/{primaryKey}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResponseJson> deleteTepDinhKemHoSo1(@PathVariable(name = "primaryKey") long primaryKey) {

		String errorMessage = "";
		boolean isSuccess = false;
		Object data = null;

		try {
			TepDinhKemHoSo1 findById = mTepDinhKemHoSo1Service.getTepDinhKemHoSo1(primaryKey);
			if (findById != null) {
				data = mTepDinhKemHoSo1Service.deleteTepDinhKemHoSo1(findById);
				isSuccess = true;
			}
		} catch (Exception e) {
			LOGGER.error("[deleteTepDinhKemHoSo1 | "+ e.getMessage() +"]", e);
			pushLog(e, CLASS_NAME);
			errorMessage = e.getMessage() +" | "+ getStackTrace(e.getCause()) +"]";
		}

		return createResponse(data, isSuccess, errorMessage);
	}

	@ResponseBody
	@RequestMapping(value ="/get/{primaryKey}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResponseJson> getTepDinhKemHoSo1(@PathVariable(name = "primaryKey") long primaryKey) {

		String errorMessage = "";
		boolean isSuccess = false;
		Object data = null;

		try {
			TepDinhKemHoSo1 findById = mTepDinhKemHoSo1Service.getTepDinhKemHoSo1(primaryKey);
			if (findById != null) {
				data = findById;
				isSuccess = true;
			}
		} catch (Exception e) {
			LOGGER.error("[getTepDinhKemHoSo1 | "+ e.getMessage() +"]", e);
			pushLog(e, CLASS_NAME);
			errorMessage =  e.getMessage() +" | "+ getStackTrace(e.getCause()) +"]";
		}

		return createResponse(data, isSuccess, errorMessage);
	}

	@ResponseBody
	@RequestMapping(value ="/getByTepDinhKems", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResponseJson> getByTepDinhKems(@RequestParam(required = true, name="idHoSo", defaultValue = "0")long idHoSo) {

		String errorMessage = "";
		boolean isSuccess = false;
		Object data = null;

		try {
			data = mTepDinhKemHoSo1Service.getByTepDinhKems(idHoSo);
			isSuccess = true;
		} catch (Exception e) {
			LOGGER.error("[getByTepDinhKems | "+ e.getMessage() +"]", e);
			pushLog(e, CLASS_NAME);
			errorMessage =  e.getMessage() +" | "+ getStackTrace(e.getCause()) +"]";
		}

		return createResponse(data, isSuccess, errorMessage);
	}
	
	@ResponseBody
	@RequestMapping(value ="/sizeOfFiles", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResponseJson> sizeOfFiles(@RequestParam(required = true, name="idHoSo", defaultValue = "0")long idHoSo) {

		ResponseJson responseJson = new ResponseJson();

		try {
			long size = mTepDinhKemHoSo1Service.sizeOfFiles(idHoSo);
			responseJson.setSuccess(true);
			responseJson.setTotal(size);
		} catch (Exception e) {
			LOGGER.error("[getByTepDinhKems | "+ e.getMessage() +"]", e);
			pushLog(e, CLASS_NAME);
			String errorMessage =  e.getMessage() +" | "+ getStackTrace(e.getCause()) +"]";
			responseJson.setMessage(errorMessage);
		}

		return new ResponseEntity<>(responseJson, HttpStatus.OK);
	}

	private static String getStackTrace(Throwable e) {

		return e.getLocalizedMessage();
	}

}