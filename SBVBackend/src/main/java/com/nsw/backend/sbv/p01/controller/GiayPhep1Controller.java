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
@RequestMapping(value ="/sbv/01/thongTinCGPHS1")
public class GiayPhep1Controller extends BaseController {

	private static final Logger LOGGER = LoggerFactory.getLogger(GiayPhep1Controller.class);

	private static final String CLASS_NAME = GiayPhep1Controller.class.getSimpleName();

	@Autowired
	private GiayPhep1Service mGiayPhep1Service;

	@ResponseBody
	@RequestMapping(value ="/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResponseJson> createGiayPhep1(@RequestBody GiayPhep1 pGiayPhep1) {

		String errorMessage = "";
		boolean isSuccess = false;
		Object data = null;

		try {
			data = mGiayPhep1Service.createGiayPhep1(pGiayPhep1);
			isSuccess = true;
		} catch (Exception e) {
			LOGGER.error("[createGiayPhep1 | "+ e.getMessage() +"]", e);
			pushLog(e, CLASS_NAME);
			errorMessage =  e.getMessage() +" | "+ getStackTrace(e.getCause()) +"]";
		}

		return createResponse(data, isSuccess, errorMessage);
	}

	@ResponseBody
	@RequestMapping(value ="/update/{primaryKey}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResponseJson> updateGiayPhep1(@PathVariable(name = "primaryKey") long primaryKey, @RequestBody GiayPhep1 pGiayPhep1) {

		String errorMessage = "";
		boolean isSuccess = false;
		Object data = null;

		try {
			GiayPhep1 findById = mGiayPhep1Service.getGiayPhep1(primaryKey);
			if (findById != null) {
				data = mGiayPhep1Service.updateGiayPhep1(primaryKey, pGiayPhep1);
				isSuccess = true;
			}
		} catch (Exception e) {
			LOGGER.error("[updateGiayPhep1 | "+ e.getMessage() +"]", e);
			pushLog(e, CLASS_NAME);
			errorMessage =  e.getMessage() +" | "+ getStackTrace(e.getCause()) +"]";
		}

		return createResponse(data, isSuccess, errorMessage);
	}

	@ResponseBody
	@RequestMapping(value ="/delete/{primaryKey}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResponseJson> deleteGiayPhep1(@PathVariable(name = "primaryKey") long primaryKey) {

		String errorMessage = "";
		boolean isSuccess = false;
		Object data = null;

		try {
			GiayPhep1 findById = mGiayPhep1Service.getGiayPhep1(primaryKey);
			if (findById != null) {
				data = mGiayPhep1Service.deleteGiayPhep1(findById);
				isSuccess = true;
			}
		} catch (Exception e) {
			LOGGER.error("[deleteGiayPhep1 | "+ e.getMessage() +"]", e);
			pushLog(e, CLASS_NAME);
			errorMessage = e.getMessage() +" | "+ getStackTrace(e.getCause()) +"]";
		}

		return createResponse(data, isSuccess, errorMessage);
	}

	@ResponseBody
	@RequestMapping(value ="/get/{primaryKey}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResponseJson> getGiayPhep1(@PathVariable(name = "primaryKey") long primaryKey) {

		String errorMessage = "";
		boolean isSuccess = false;
		Object data = null;

		try {
			GiayPhep1 findById = mGiayPhep1Service.getGiayPhep1(primaryKey);
			if (findById != null) {
				data = findById;
				isSuccess = true;
			}
		} catch (Exception e) {
			LOGGER.error("[getGiayPhep1 | "+ e.getMessage() +"]", e);
			pushLog(e, CLASS_NAME);
			errorMessage =  e.getMessage() +" | "+ getStackTrace(e.getCause()) +"]";
		}

		return createResponse(data, isSuccess, errorMessage);
	}

	@ResponseBody
	@RequestMapping(value ="/findBySoGiayPhep", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResponseJson> findBySoGiayPhep(@RequestParam(required = true, name="soGiayPhep", defaultValue = "null")String soGiayPhep) {

		String errorMessage = "";
		boolean isSuccess = false;
		Object data = null;

		try {
			data = mGiayPhep1Service.findBySoGiayPhep(soGiayPhep);
			isSuccess = true;
		} catch (Exception e) {
			LOGGER.error("[findBySoGiayPhep | "+ e.getMessage() +"]", e);
			pushLog(e, CLASS_NAME);
			errorMessage =  e.getMessage() +" | "+ getStackTrace(e.getCause()) +"]";
		}

		return createResponse(data, isSuccess, errorMessage);
	}

	@ResponseBody
	@RequestMapping(value ="/getByIdHoSo", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResponseJson> getByIdHoSo(@RequestParam(required = true, name="idHoSo", defaultValue = "0")long idHoSo) {

		String errorMessage = "";
		boolean isSuccess = false;
		Object data = null;

		try {
			data = mGiayPhep1Service.getByIdHoSo(idHoSo);
			isSuccess = true;
		} catch (Exception e) {
			LOGGER.error("[getByIdHoSo | "+ e.getMessage() +"]", e);
			pushLog(e, CLASS_NAME);
			errorMessage =  e.getMessage() +" | "+ getStackTrace(e.getCause()) +"]";
		}

		return createResponse(data, isSuccess, errorMessage);
	}

	private static String getStackTrace(Throwable e) {

		return e.getLocalizedMessage();
	}

}