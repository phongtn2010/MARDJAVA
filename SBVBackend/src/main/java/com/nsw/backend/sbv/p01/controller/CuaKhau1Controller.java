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
@RequestMapping(value ="/sbv/01/cuaKhau1")
public class CuaKhau1Controller extends BaseController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CuaKhau1Controller.class);

	private static final String CLASS_NAME = CuaKhau1Controller.class.getSimpleName();

	@Autowired
	private CuaKhau1Service mCuaKhau1Service;

	@ResponseBody
	@RequestMapping(value ="/get/{primaryKey}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResponseJson> getCuaKhau1(@PathVariable(name = "primaryKey") long primaryKey) {

		String errorMessage = "";
		boolean isSuccess = false;
		Object data = null;

		try {
			CuaKhau1 findById = mCuaKhau1Service.getCuaKhau1(primaryKey);
			if (findById != null) {
				data = findById;
				isSuccess = true;
			}
		} catch (Exception e) {
			LOGGER.error("[getCuaKhau1 | "+ e.getMessage() +"]", e);
			pushLog(e, CLASS_NAME);
			errorMessage =  e.getMessage() +" | "+ getStackTrace(e.getCause()) +"]";
		}

		return createResponse(data, isSuccess, errorMessage);
	}

	@ResponseBody
	@RequestMapping(value ="/findByMaCuaKhau", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResponseJson> findByMaCuaKhau(@RequestParam(required = true, name="maCuaKhau", defaultValue = "null")String maCuaKhau) {

		String errorMessage = "";
		boolean isSuccess = false;
		Object data = null;

		try {
			data = mCuaKhau1Service.findByMaCuaKhau(maCuaKhau);
			isSuccess = true;
		} catch (Exception e) {
			LOGGER.error("[findByMaCuaKhau | "+ e.getMessage() +"]", e);
			pushLog(e, CLASS_NAME);
			errorMessage =  e.getMessage() +" | "+ getStackTrace(e.getCause()) +"]";
		}

		return createResponse(data, isSuccess, errorMessage);
	}

	@ResponseBody
	@RequestMapping(value ="/getByMaChiNhanhs", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResponseJson> getByMaChiNhanhs(@RequestParam(required = true, name="maChiNhanh", defaultValue = "null")String maChiNhanh) {

		String errorMessage = "";
		boolean isSuccess = false;
		Object data = null;

		try {
			data = mCuaKhau1Service.getByMaChiNhanhs(maChiNhanh);
			isSuccess = true;
		} catch (Exception e) {
			LOGGER.error("[getByMaChiNhanhs | "+ e.getMessage() +"]", e);
			pushLog(e, CLASS_NAME);
			errorMessage =  e.getMessage() +" | "+ getStackTrace(e.getCause()) +"]";
		}

		return createResponse(data, isSuccess, errorMessage);
	}

	@ResponseBody
	@RequestMapping(value ="/getAllCuaKhaus", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResponseJson> getAllCuaKhaus() {

		String errorMessage = "";
		boolean isSuccess = false;
		Object data = null;

		try {
			data = mCuaKhau1Service.getAllCuaKhaus();
			isSuccess = true;
		} catch (Exception e) {
			LOGGER.error("[getAllCuaKhaus | "+ e.getMessage() +"]", e);
			pushLog(e, CLASS_NAME);
			errorMessage =  e.getMessage() +" | "+ getStackTrace(e.getCause()) +"]";
		}

		return createResponse(data, isSuccess, errorMessage);
	}

	private static String getStackTrace(Throwable e) {

		return e.getLocalizedMessage();
	}

}