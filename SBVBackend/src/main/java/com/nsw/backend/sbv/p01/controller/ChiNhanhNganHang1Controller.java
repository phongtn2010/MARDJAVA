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
@RequestMapping(value ="/sbv/01/cnNganHang1")
public class ChiNhanhNganHang1Controller extends BaseController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ChiNhanhNganHang1Controller.class);

	private static final String CLASS_NAME = ChiNhanhNganHang1Controller.class.getSimpleName();

	@Autowired
	private ChiNhanhNganHang1Service mChiNhanhNganHang1Service;

	@ResponseBody
	@RequestMapping(value ="/get/{primaryKey}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResponseJson> getChiNhanhNganHang1(@PathVariable(name = "primaryKey") long primaryKey) {

		String errorMessage = "";
		boolean isSuccess = false;
		Object data = null;

		try {
			ChiNhanhNganHang1 findById = mChiNhanhNganHang1Service.getChiNhanhNganHang1(primaryKey);
			if (findById != null) {
				data = findById;
				isSuccess = true;
			}
		} catch (Exception e) {
			LOGGER.error("[getChiNhanhNganHang1 | "+ e.getMessage() +"]", e);
			pushLog(e, CLASS_NAME);
			errorMessage =  e.getMessage() +" | "+ getStackTrace(e.getCause()) +"]";
		}

		return createResponse(data, isSuccess, errorMessage);
	}

	@ResponseBody
	@RequestMapping(value ="/findByMaChiNhanh", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResponseJson> findByMaChiNhanh(@RequestParam(required = true, name="maChiNhanh", defaultValue = "null")String maChiNhanh) {

		String errorMessage = "";
		boolean isSuccess = false;
		Object data = null;

		try {
			data = mChiNhanhNganHang1Service.findByMaChiNhanh(maChiNhanh);
			isSuccess = true;
		} catch (Exception e) {
			LOGGER.error("[findByMaChiNhanh | "+ e.getMessage() +"]", e);
			pushLog(e, CLASS_NAME);
			errorMessage =  e.getMessage() +" | "+ getStackTrace(e.getCause()) +"]";
		}

		return createResponse(data, isSuccess, errorMessage);
	}

	@ResponseBody
	@RequestMapping(value ="/getAllChiNhanhNganHang1s", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResponseJson> getAllChiNhanhNganHang1s() {

		String errorMessage = "";
		boolean isSuccess = false;
		Object data = null;

		try {
			data = mChiNhanhNganHang1Service.getAllChiNhanhNganHang1s();
			isSuccess = true;
		} catch (Exception e) {
			LOGGER.error("[getAllChiNhanhNganHang1s | "+ e.getMessage() +"]", e);
			pushLog(e, CLASS_NAME);
			errorMessage =  e.getMessage() +" | "+ getStackTrace(e.getCause()) +"]";
		}

		return createResponse(data, isSuccess, errorMessage);
	}

	private static String getStackTrace(Throwable e) {

		return e.getLocalizedMessage();
	}

}