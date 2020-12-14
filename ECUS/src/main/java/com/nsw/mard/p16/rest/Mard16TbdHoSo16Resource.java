package com.nsw.mard.p16.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.mard.p14.rest.SecurityUtil;
import com.nsw.mard.p16.model.HoSo16DTO;
import com.nsw.mard.p16.model.Page;
import com.nsw.mard.p16.model.PageableDTO;
import com.nsw.mard.p16.model.TbdHoSo16;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/***
*
*
* @RestController
* @class Mard16TbdHoSo16Resource
* Created by Nguyen Van Quang
* 11/12/2018 10:1616:50
*
*/
@RestController
@RequestMapping("/mard/16/tbdHoSo16")
public class Mard16TbdHoSo16Resource extends Mard16CallBack {

	/**
	* @param tbdHoSo16 - Type: TbdHoSo16
	* @return may can null
	*/
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<TbdHoSo16> createTbdHoSo16(@RequestBody @Valid TbdHoSo16 tbdHoSo16) {
		tbdHoSo16 = createRestTemplate(getURL("/mard/16/tbdHoSo16/create"), tbdHoSo16, HttpMethod.POST, null, TbdHoSo16.class);
		return ResponseEntity.ok().body(tbdHoSo16);
	}

	/**
	* @param fiIdHoSo - Type: Long
	* @param tbdHoSo16 - Type: TbdHoSo16
	* @return may can null
	*/
	@RequestMapping(value = "/update/{fiIdHoSo}", method = RequestMethod.POST)
	public ResponseEntity<TbdHoSo16> updateTbdHoSo16(@PathVariable("fiIdHoSo") Long fiIdHoSo, @RequestBody @Valid TbdHoSo16 tbdHoSo16) {
		tbdHoSo16 = createRestTemplate(getURL("/mard/16/tbdHoSo16/update/") + fiIdHoSo, tbdHoSo16, HttpMethod.POST, null, TbdHoSo16.class);
		return ResponseEntity.ok().body(tbdHoSo16);
	}

	/**
	* @param fiIdHoSo - Type: Long
	* @return may can throw new Execption
	*/
	@RequestMapping(value = "/delete/{fiIdHoSo}", method = RequestMethod.POST)
	public ResponseEntity<TbdHoSo16> deleteTbdHoSo16(@PathVariable("fiIdHoSo") Long fiIdHoSo) {
		TbdHoSo16 tbdHoSo16 = getTbdHoSo16(fiIdHoSo).getBody();
		if (ObjectUtils.isEmpty(tbdHoSo16)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		tbdHoSo16.setFiActive(0);
		tbdHoSo16 = updateTbdHoSo16(fiIdHoSo, tbdHoSo16).getBody();
		return ResponseEntity.ok().body(tbdHoSo16);
	}

	/**
	* @param fiIdHoSo - Type: Long
	* @return may can null
	*/
	@RequestMapping(value = "/get/{fiIdHoSo}", method = RequestMethod.GET)
	public ResponseEntity<TbdHoSo16> getTbdHoSo16(@PathVariable("fiIdHoSo") Long fiIdHoSo) {
		TbdHoSo16 tbdHoSo16 = createRestTemplate(getURL("/mard/16/tbdHoSo16/get/") + fiIdHoSo, null, HttpMethod.GET, null, TbdHoSo16.class);
		return ResponseEntity.ok().body(tbdHoSo16);
	}

	/**
	* @param pageableDTO - Type: PageableDTO
	* @return may can null
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findAll", method = RequestMethod.POST)
	public ResponseEntity<List<TbdHoSo16>> findAllTbdHoSo16(@RequestBody @Valid PageableDTO pageableDTO) {

		List<TbdHoSo16> tbdHoSo16List = createRestTemplate(getURL("/mard/16/tbdHoSo16/findAll"), pageableDTO, HttpMethod.POST, null, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdHoSo16List = mapper.convertValue(tbdHoSo16List, new TypeReference<List<TbdHoSo16>>() {});

		return ResponseEntity.ok().body(tbdHoSo16List);
	}

	/**
	* @param fiDocumentType - Type: String
	* @param fiDocumentName - Type: String
	* @param fiTaxCode - Type: String
	* @param fiActive - Type: Integer
	* @param fiStatus - Type: Integer
	* @param fromFiSendDate - Type: Date
	* @param toFiSendDate - Type: Date
	* @return can return null or throw exception
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/page", method = RequestMethod.POST)
	public ResponseEntity<Page<HoSo16DTO>> page(@RequestBody PageableDTO pageableDTO, @RequestParam(name = "fiDocumentType", required = false) String fiDocumentType, @RequestParam(name = "fiDocumentName", required = false) String fiDocumentName, @RequestParam(name = "fiTaxCode", required = false) String fiTaxCode, @RequestParam(name = "fiActive", required = false) Integer fiActive, @RequestParam(name = "fiStatus", required = false) Integer fiStatus, @DateTimeFormat(pattern = "dd/MM/yyyy") @RequestParam(name = "fromFiSendDate", required = false) Date fromFiSendDate, @DateTimeFormat(pattern = "dd/MM/yyyy") @RequestParam(name = "toFiSendDate", required = false) Date toFiSendDate, @RequestParam(name = "fiDispatchNo", required = false) String fiDispatchNo, @DateTimeFormat(pattern = "dd/MM/yyyy") @RequestParam(name = "fromFiSignConfirmDate", required = false) Date fromFiSignConfirmDate, @DateTimeFormat(pattern = "dd/MM/yyyy") @RequestParam(name = "toFiSignConfirmDate", required = false) Date toFiSignConfirmDate) {

		Map<String, Object> params = new HashMap<>();
		params.put("fiDocumentType", fiDocumentType);
		params.put("fiDocumentName", fiDocumentName);
		if (isFcap()) {
			params.put("isFcap", String.valueOf(isFcap()));
		}
		String currentUser = SecurityUtil.getTaxCode();
		if (StringUtils.hasText(currentUser)) {
			fiTaxCode = currentUser;
		}
		params.put("fiTaxCode", fiTaxCode);
		params.put("fiActive", 1);
		params.put("fiStatus", fiStatus);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		if (!ObjectUtils.isEmpty(fromFiSendDate)) {
			params.put("fromFiSendDate",  dateFormat.format(fromFiSendDate));
		}
		if (!ObjectUtils.isEmpty(toFiSendDate)) {
			params.put("toFiSendDate",  dateFormat.format(toFiSendDate));
		}
		params.put("fiDispatchNo", fiDispatchNo);
		if (!ObjectUtils.isEmpty(fromFiSignConfirmDate)) {
			params.put("fromFiSignConfirmDate",  dateFormat.format(fromFiSignConfirmDate));
		}
		if (!ObjectUtils.isEmpty(toFiSignConfirmDate)) {
			params.put("toFiSignConfirmDate",  dateFormat.format(toFiSignConfirmDate));
		}
		Page<HoSo16DTO> page = createRestTemplate(getURL("/mard/16/tbdHoSo16/page"), pageableDTO, HttpMethod.POST, params, Page.class);
		ObjectMapper mapper = new ObjectMapper();
		List<HoSo16DTO> hoSo16DTOList = mapper.convertValue(page.getContent(), new TypeReference<List<HoSo16DTO>>() {});
		page.setContent(hoSo16DTOList);

		return ResponseEntity.ok().body(page);
	}

	/**
	* @param fiDocumentName - Type: String
	* @return can return null or throw exception
	*/
	@RequestMapping(value = "/findByDocumentName", method = RequestMethod.GET)
	public ResponseEntity<List<TbdHoSo16>> findByFiDocumentName(@RequestParam(name = "fiDocumentName", required = false) String fiDocumentName) {

		Map<String, Object> params = new HashMap<>();
		params.put("fiDocumentName", fiDocumentName);
		List<TbdHoSo16> tbdHoSo16 = createRestTemplate(getURL("/mard/16/tbdHoSo16/findByDocumentName"), null, HttpMethod.GET, params, List.class);
		ObjectMapper mapper = new ObjectMapper();
		List<TbdHoSo16> hoSo16DTOList = mapper.convertValue(tbdHoSo16, new TypeReference<List<TbdHoSo16>>() {});
		return ResponseEntity.ok().body(hoSo16DTOList);
	}

	/**
	* @param fiDocumentType - Type: String
	* @param fiDocumentName - Type: String
	* @param fiTaxCode - Type: String
	* @return can return null or throw exception
	*/
	@RequestMapping(value = "/findByDocumentTypeAndDocumentNameAndFiTaxCode", method = RequestMethod.GET)
	public ResponseEntity<TbdHoSo16> findByFiDocumentTypeAndFiDocumentNameAndFiTaxCode(@RequestParam(name = "fiDocumentType", required = false) String fiDocumentType, @RequestParam(name = "fiDocumentName", required = false) String fiDocumentName, @RequestParam(name = "fiTaxCode", required = false) String fiTaxCode) {

		Map<String, Object> params = new HashMap<>();
		params.put("fiDocumentType", fiDocumentType);
		params.put("fiDocumentName", fiDocumentName);
		params.put("fiTaxCode", fiTaxCode);
		TbdHoSo16 tbdHoSo16 = createRestTemplate(getURL("/mard/16/tbdHoSo16/findByDocumentTypeAndDocumentNameAndFiTaxCode"), null, HttpMethod.GET, params, TbdHoSo16.class);

		return ResponseEntity.ok().body(tbdHoSo16);
	}


}