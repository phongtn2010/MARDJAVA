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

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping(value ="/sbv/01/ketQuaXuLyHS1")
public class KetQuaXuLyHoSo1Controller extends BaseController {

	private static final Logger LOGGER = LoggerFactory.getLogger(KetQuaXuLyHoSo1Controller.class);

	private static final String CLASS_NAME = KetQuaXuLyHoSo1Controller.class.getSimpleName();

	@Autowired
	private KetQuaXuLyHoSo1Service mKetQuaXuLyHoSo1Service;

	@ResponseBody
	@RequestMapping(value ="/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResponseJson> createKetQuaXuLyHoSo1(@RequestBody KetQuaXuLyHoSo1 pKetQuaXuLyHoSo1) {

		String errorMessage = "";
		boolean isSuccess = false;
		Object data = null;

		try {
			pKetQuaXuLyHoSo1.setNgayTao(new Date());
			data = mKetQuaXuLyHoSo1Service.createKetQuaXuLyHoSo1(pKetQuaXuLyHoSo1);
			isSuccess = true;
		} catch (Exception e) {
			LOGGER.error("[createKetQuaXuLyHoSo1 | "+ e.getMessage() +"]", e);
			pushLog(e, CLASS_NAME);
			errorMessage =  e.getMessage() +" | "+ getStackTrace(e.getCause()) +"]";
		}

		return createResponse(data, isSuccess, errorMessage);
	}

	@ResponseBody
	@RequestMapping(value ="/update/{primaryKey}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResponseJson> updateKetQuaXuLyHoSo1(@PathVariable(name = "primaryKey") long primaryKey, @RequestBody KetQuaXuLyHoSo1 pKetQuaXuLyHoSo1) {

		String errorMessage = "";
		boolean isSuccess = false;
		Object data = null;

		try {
			KetQuaXuLyHoSo1 findById = mKetQuaXuLyHoSo1Service.getKetQuaXuLyHoSo1(primaryKey);
			if (findById != null) {
				data = mKetQuaXuLyHoSo1Service.updateKetQuaXuLyHoSo1(primaryKey, pKetQuaXuLyHoSo1);
				isSuccess = true;
			}
		} catch (Exception e) {
			LOGGER.error("[updateKetQuaXuLyHoSo1 | "+ e.getMessage() +"]", e);
			pushLog(e, CLASS_NAME);
			errorMessage =  e.getMessage() +" | "+ getStackTrace(e.getCause()) +"]";
		}

		return createResponse(data, isSuccess, errorMessage);
	}

	@ResponseBody
	@RequestMapping(value ="/delete/{primaryKey}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResponseJson> deleteKetQuaXuLyHoSo1(@PathVariable(name = "primaryKey") long primaryKey) {

		String errorMessage = "";
		boolean isSuccess = false;
		Object data = null;

		try {
			KetQuaXuLyHoSo1 findById = mKetQuaXuLyHoSo1Service.getKetQuaXuLyHoSo1(primaryKey);
			if (findById != null) {
				data = mKetQuaXuLyHoSo1Service.deleteKetQuaXuLyHoSo1(findById);
				isSuccess = true;
			}
		} catch (Exception e) {
			LOGGER.error("[deleteKetQuaXuLyHoSo1 | "+ e.getMessage() +"]", e);
			pushLog(e, CLASS_NAME);
			errorMessage = e.getMessage() +" | "+ getStackTrace(e.getCause()) +"]";
		}

		return createResponse(data, isSuccess, errorMessage);
	}

	@ResponseBody
	@RequestMapping(value ="/get/{primaryKey}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResponseJson> getKetQuaXuLyHoSo1(@PathVariable(name = "primaryKey") long primaryKey) {

		String errorMessage = "";
		boolean isSuccess = false;
		Object data = null;

		try {
			KetQuaXuLyHoSo1 findById = mKetQuaXuLyHoSo1Service.getKetQuaXuLyHoSo1(primaryKey);
			if (findById != null) {
				data = findById;
				isSuccess = true;
			}
		} catch (Exception e) {
			LOGGER.error("[getKetQuaXuLyHoSo1 | "+ e.getMessage() +"]", e);
			pushLog(e, CLASS_NAME);
			errorMessage =  e.getMessage() +" | "+ getStackTrace(e.getCause()) +"]";
		}

		return createResponse(data, isSuccess, errorMessage);
	}

	@ResponseBody
	@RequestMapping(value ="/searchKetQuaXuLys", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResponseJson> searchKetQuaXuLys(@RequestParam(required = true, name="idHoSo", defaultValue = "0")long idHoSo, @RequestParam(required = false, name="pageIndex", defaultValue = "1")int pageIndex, @RequestParam(required = false, name="pageSize", defaultValue = "10")int pageSize) {

		String errorMessage = "";
		boolean isSuccess = false;
		Object data = null;

		try {
			data = mKetQuaXuLyHoSo1Service.searchKetQuaXuLys(idHoSo, pageIndex, pageSize);
			isSuccess = true;
		} catch (Exception e) {
			LOGGER.error("[searchKetQuaXuLys | "+ e.getMessage() +"]", e);
			pushLog(e, CLASS_NAME);
			errorMessage =  e.getMessage() +" | "+ getStackTrace(e.getCause()) +"]";
		}

		return createResponse(data, isSuccess, errorMessage);
	}

	@ResponseBody
	@RequestMapping(value ="/countHoSos", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResponseJson> countKetQuaXuLys(@RequestParam(required = true, name="idHoSo", defaultValue = "0")long idHoSo) {

		String errorMessage = "";
		boolean isSuccess = false;
		Object data = null;

		try {
			data = mKetQuaXuLyHoSo1Service.countKetQuaXuLys(idHoSo);
			isSuccess = true;
		} catch (Exception e) {
			LOGGER.error("[countKetQuaXuLys | "+ e.getMessage() +"]", e);
			pushLog(e, CLASS_NAME);
			errorMessage =  e.getMessage() +" | "+ getStackTrace(e.getCause()) +"]";
		}

		return createResponse(data, isSuccess, errorMessage);
	}

	private static String getStackTrace(Throwable e) {

		return e.getLocalizedMessage();
	}

}