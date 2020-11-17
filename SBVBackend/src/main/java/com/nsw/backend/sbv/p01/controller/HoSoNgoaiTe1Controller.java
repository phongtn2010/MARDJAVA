package com.nsw.backend.sbv.p01.controller;

import com.nsw.backend.sbv.p01.model.HoSoNgoaiTe1;
import com.nsw.backend.sbv.p01.model.HoSoNgoaiTe1SearchItem;
import com.nsw.backend.sbv.p01.model.HoSoNgoaiTeModel;
import com.nsw.backend.sbv.p01.repositories.HoSoNgoaiTe1Repository;
import com.nsw.backend.sbv.p01.service.HoSoNgoaiTe1Service;
import com.nsw.backend.util.ResponseJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

@RestController
@RequestMapping(value ="/sbv/01/hoSoGPXNKNgoaiTe")
public class HoSoNgoaiTe1Controller extends BaseController {

	private static final Logger LOGGER = LoggerFactory.getLogger(HoSoNgoaiTe1Controller.class);

	private static final String CLASS_NAME = HoSoNgoaiTe1Controller.class.getSimpleName();

	@Autowired
	private HoSoNgoaiTe1Service mHoSoNgoaiTe1Service;
	
	@Autowired
	private HoSoNgoaiTe1Repository mHoSoNgoaiTe1Repository;

	@ResponseBody
	@RequestMapping(value ="/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResponseJson> createHoSoNgoaiTe1(@RequestBody HoSoNgoaiTe1 pHoSoNgoaiTe1) {

		String errorMessage = "";
		boolean isSuccess = false;
		Object data = null;

		try {
			pHoSoNgoaiTe1.setIdHoSo(getId());
			pHoSoNgoaiTe1.setMaHoSo(MakeUUID.makePK(pHoSoNgoaiTe1.getIdHoSo()));
			pHoSoNgoaiTe1 = mHoSoNgoaiTe1Service.createHoSoNgoaiTe1(pHoSoNgoaiTe1);
			data = pHoSoNgoaiTe1;
			isSuccess = true;
		} catch (Exception e) {
			LOGGER.error("[createHoSoNgoaiTe1 | "+ e.getMessage() +"]", e);
			pushLog(e, CLASS_NAME);
			errorMessage =  e.getMessage() +" | "+ getStackTrace(e.getCause()) +"]";
		}

		return createResponse(data, isSuccess, errorMessage);
	}

	@ResponseBody
	@RequestMapping(value ="/update/{primaryKey}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResponseJson> updateHoSoNgoaiTe1(@PathVariable(name = "primaryKey") long primaryKey, @RequestBody HoSoNgoaiTe1 pHoSoNgoaiTe1) {

		String errorMessage = "";
		boolean isSuccess = false;
		Object data = null;

		try {
			HoSoNgoaiTe1 findById = mHoSoNgoaiTe1Service.getHoSoNgoaiTe1(primaryKey);
			if (findById != null) {
				data = mHoSoNgoaiTe1Service.updateHoSoNgoaiTe1(primaryKey, pHoSoNgoaiTe1);
				isSuccess = true;
			}
		} catch (Exception e) {
			LOGGER.error("[updateHoSoNgoaiTe1 | "+ e.getMessage() +"]", e);
			pushLog(e, CLASS_NAME);
			errorMessage =  e.getMessage() +" | "+ getStackTrace(e.getCause()) +"]";
		}

		return createResponse(data, isSuccess, errorMessage);
	}

	@ResponseBody
	@RequestMapping(value ="/delete/{primaryKey}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResponseJson> deleteHoSoNgoaiTe1(@PathVariable(name = "primaryKey") long primaryKey) {

		String errorMessage = "";
		boolean isSuccess = false;
		Object data = null;

		try {
			HoSoNgoaiTe1 findById = mHoSoNgoaiTe1Service.getHoSoNgoaiTe1(primaryKey);
			if (findById != null) {
				data = mHoSoNgoaiTe1Service.deleteHoSoNgoaiTe1(findById);
				isSuccess = true;
			}
		} catch (Exception e) {
			LOGGER.error("[deleteHoSoNgoaiTe1 | "+ e.getMessage() +"]", e);
			pushLog(e, CLASS_NAME);
			errorMessage = e.getMessage() +" | "+ getStackTrace(e.getCause()) +"]";
		}

		return createResponse(data, isSuccess, errorMessage);
	}

	@ResponseBody
	@RequestMapping(value ="/get/{primaryKey}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResponseJson> getHoSoNgoaiTe1(@PathVariable(name = "primaryKey") long primaryKey) {

		String errorMessage = "";
		boolean isSuccess = false;
		Object data = null;

		try {
			HoSoNgoaiTe1 findById = mHoSoNgoaiTe1Service.getHoSoNgoaiTe1(primaryKey);
			if (findById != null) {
				data = findById;
				isSuccess = true;
			}
		} catch (Exception e) {
			LOGGER.error("[getHoSoNgoaiTe1 | "+ e.getMessage() +"]", e);
			pushLog(e, CLASS_NAME);
			errorMessage =  e.getMessage() +" | "+ getStackTrace(e.getCause()) +"]";
		}

		return createResponse(data, isSuccess, errorMessage);
	}

	@ResponseBody
	@RequestMapping(value ="/findByMaHoSo", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResponseJson> findByMaHoSo(@RequestParam(required = true, name="maHoSo", defaultValue = "null")String maHoSo) {

		String errorMessage = "";
		boolean isSuccess = false;
		Object data = null;

		try {
			data = mHoSoNgoaiTe1Service.findByMaHoSo(maHoSo);
			isSuccess = true;
		} catch (Exception e) {
			LOGGER.error("[findByMaHoSo | "+ e.getMessage() +"]", e);
			pushLog(e, CLASS_NAME);
			errorMessage =  e.getMessage() +" | "+ getStackTrace(e.getCause()) +"]";
		}

		return createResponse(data, isSuccess, errorMessage);
	}
	

	@ResponseBody
	@RequestMapping(value ="/searchHoSos", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResponseJson> searchHoSos(@RequestBody HoSoNgoaiTe1SearchItem searchItem) {

		ResponseJson responseJson = new ResponseJson();

		try {
			Pageable pageable = new PageRequest(searchItem.getPageIndex(), searchItem.getPageSize(), new Sort(Sort.Direction.DESC, "ngayTao"));
			Page<HoSoNgoaiTeModel> page = mHoSoNgoaiTe1Repository.search(pageable, searchItem.getMaSoThue(), searchItem.getMaHoSo(), searchItem.getTrangThai(), searchItem.getHinhThucXNK(), searchItem.getMaCuaKhau(), searchItem.getFromNgayTao(), searchItem.getToNgayTao(), searchItem.isXoaHoSo(), searchItem.getFromNgayPhep(), searchItem.getToNgayPhep(), searchItem.getSoGiayPhep());
			responseJson.setData( page.getContent());
			responseJson.setTotal(page.getTotalElements());
			responseJson.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("[searchHoSos | "+ e.getMessage() +"]", e);
			pushLog(e, CLASS_NAME);
			String errorMessage =  e.getMessage() +" | "+ getStackTrace(e.getCause()) +"]";
			responseJson.setMessage(errorMessage);
		}

		return new ResponseEntity<>(responseJson, HttpStatus.OK);
	}

	@ResponseBody
	@RequestMapping(value ="/countHoSos", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResponseJson> countHoSos(@RequestBody HoSoNgoaiTe1SearchItem item) {

		String errorMessage = "";
		boolean isSuccess = false;
		Object data = null;

		try {
			data = mHoSoNgoaiTe1Service.countHoSos(item);
			isSuccess = true;
		} catch (Exception e) {
			LOGGER.error("[countHoSos | "+ e.getMessage() +"]", e);
			pushLog(e, CLASS_NAME);
			errorMessage =  e.getMessage() +" | "+ getStackTrace(e.getCause()) +"]";
		}

		return createResponse(data, isSuccess, errorMessage);
	}

	private static String getStackTrace(Throwable e) {

		return e.getLocalizedMessage();
	}

	@Autowired
	private EntityManager entityManager;

	private long getId() {
		String sql = "select SBV.TBDHOSONGOAITE1_SEQ.NEXTVAL from dual";
		BigDecimal bigDecimal = (BigDecimal)entityManager.createNativeQuery(sql).getSingleResult();
		return bigDecimal.longValue();
	}

}