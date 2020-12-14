package com.nsw.mard.p14.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.mard.p14.model.HoSo14DTO;
import com.nsw.mard.p14.model.Page;
import com.nsw.mard.p14.model.PageableDTO;
import com.nsw.mard.p14.model.TbdHoSo14;

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
* @class Mard14TbdHoSo14Resource
* Created by Nguyen Van Quang
* 11/12/2018 10:1414:50
*
*/
@RestController
@RequestMapping("/mard/14/tbdHoSo14")
public class Mard14TbdHoSo14Resource extends Mard14CallBack {

	/**
	* @param tbdHoSo14 - Type: TbdHoSo14
	* @return may can null
	*/
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<TbdHoSo14> createTbdHoSo14(@RequestBody @Valid TbdHoSo14 tbdHoSo14) {
		tbdHoSo14 = createRestTemplate(getURL("/mard/14/tbdHoSo14/create"), tbdHoSo14, HttpMethod.POST, null, TbdHoSo14.class);
		return ResponseEntity.ok().body(tbdHoSo14);
	}

	/**
	* @param fiIdHoSo - Type: Long
	* @param tbdHoSo14 - Type: TbdHoSo14
	* @return may can null
	*/
	@RequestMapping(value = "/update/{fiIdHoSo}", method = RequestMethod.POST)
	public ResponseEntity<TbdHoSo14> updateTbdHoSo14(@PathVariable("fiIdHoSo") Long fiIdHoSo, @RequestBody @Valid TbdHoSo14 tbdHoSo14) {
		tbdHoSo14 = createRestTemplate(getURL("/mard/14/tbdHoSo14/update/") + fiIdHoSo, tbdHoSo14, HttpMethod.POST, null, TbdHoSo14.class);
		return ResponseEntity.ok().body(tbdHoSo14);
	}

	/**
	* @param fiIdHoSo - Type: Long
	* @return may can throw new Execption
	*/
	@RequestMapping(value = "/delete/{fiIdHoSo}", method = RequestMethod.POST)
	public ResponseEntity<TbdHoSo14> deleteTbdHoSo14(@PathVariable("fiIdHoSo") Long fiIdHoSo) {
		TbdHoSo14 tbdHoSo14 = getTbdHoSo14(fiIdHoSo).getBody();
		if (ObjectUtils.isEmpty(tbdHoSo14)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		tbdHoSo14.setFiActive(0);
		tbdHoSo14 = updateTbdHoSo14(fiIdHoSo, tbdHoSo14).getBody();
		return ResponseEntity.ok().body(tbdHoSo14);
	}

	/**
	* @param fiIdHoSo - Type: Long
	* @return may can null
	*/
	@RequestMapping(value = "/get/{fiIdHoSo}", method = RequestMethod.GET)
	public ResponseEntity<TbdHoSo14> getTbdHoSo14(@PathVariable("fiIdHoSo") Long fiIdHoSo) {
		TbdHoSo14 tbdHoSo14 = createRestTemplate(getURL("/mard/14/tbdHoSo14/get/") + fiIdHoSo, null, HttpMethod.GET, null, TbdHoSo14.class);
		return ResponseEntity.ok().body(tbdHoSo14);
	}

	/**
	* @param pageableDTO - Type: PageableDTO
	* @return may can null
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findAll", method = RequestMethod.POST)
	public ResponseEntity<List<TbdHoSo14>> findAllTbdHoSo14(@RequestBody @Valid PageableDTO pageableDTO) {

		List<TbdHoSo14> tbdHoSo14List = createRestTemplate(getURL("/mard/14/tbdHoSo14/findAll"), pageableDTO, HttpMethod.POST, null, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdHoSo14List = mapper.convertValue(tbdHoSo14List, new TypeReference<List<TbdHoSo14>>() {});

		return ResponseEntity.ok().body(tbdHoSo14List);
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
	public ResponseEntity<Page<HoSo14DTO>> page(@RequestBody PageableDTO pageableDTO, @RequestParam(name = "fiDocumentType", required = false) String fiDocumentType, @RequestParam(name = "fiDocumentName", required = false) String fiDocumentName, @RequestParam(name = "fiTaxCode", required = false) String fiTaxCode, @RequestParam(name = "fiActive", required = false) Integer fiActive, @RequestParam(name = "fiStatus", required = false) Integer fiStatus, @DateTimeFormat(pattern = "dd/MM/yyyy") @RequestParam(name = "fromFiSendDate", required = false) Date fromFiSendDate, @DateTimeFormat(pattern = "dd/MM/yyyy") @RequestParam(name = "toFiSendDate", required = false) Date toFiSendDate, @RequestParam(name = "fiDispatchNo", required = false) String fiDispatchNo, @DateTimeFormat(pattern = "dd/MM/yyyy") @RequestParam(name = "fromFiSignConfirmDate", required = false) Date fromFiSignConfirmDate, @DateTimeFormat(pattern = "dd/MM/yyyy") @RequestParam(name = "toFiSignConfirmDate", required = false) Date toFiSignConfirmDate) {

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
		Page<HoSo14DTO> page = createRestTemplate(getURL("/mard/14/tbdHoSo14/page"), pageableDTO, HttpMethod.POST, params, Page.class);
		ObjectMapper mapper = new ObjectMapper();
		List<HoSo14DTO> hoSo14DTOList = mapper.convertValue(page.getContent(), new TypeReference<List<HoSo14DTO>>() {});
		page.setContent(hoSo14DTOList);

		return ResponseEntity.ok().body(page);
	}

	/**
	* @param fiDocumentName - Type: String
	* @return can return null or throw exception
	*/
	@RequestMapping(value = "/findByDocumentName", method = RequestMethod.GET)
	public ResponseEntity<List<TbdHoSo14>> findByFiDocumentName(@RequestParam(name = "fiDocumentName", required = false) String fiDocumentName) {

		Map<String, Object> params = new HashMap<>();
		params.put("fiDocumentName", fiDocumentName);
		List<TbdHoSo14> tbdHoSo14 = createRestTemplate(getURL("/mard/14/tbdHoSo14/findByDocumentName"), null, HttpMethod.GET, params, List.class);
		ObjectMapper mapper = new ObjectMapper();
		List<TbdHoSo14> hoSo14DTOList = mapper.convertValue(tbdHoSo14, new TypeReference<List<TbdHoSo14>>() {});
		return ResponseEntity.ok().body(hoSo14DTOList);
	}

	/**
	* @param fiDocumentType - Type: String
	* @param fiDocumentName - Type: String
	* @param fiTaxCode - Type: String
	* @return can return null or throw exception
	*/
	@RequestMapping(value = "/findByDocumentTypeAndDocumentNameAndFiTaxCode", method = RequestMethod.GET)
	public ResponseEntity<TbdHoSo14> findByFiDocumentTypeAndFiDocumentNameAndFiTaxCode(@RequestParam(name = "fiDocumentType", required = false) String fiDocumentType, @RequestParam(name = "fiDocumentName", required = false) String fiDocumentName, @RequestParam(name = "fiTaxCode", required = false) String fiTaxCode) {

		Map<String, Object> params = new HashMap<>();
		params.put("fiDocumentType", fiDocumentType);
		params.put("fiDocumentName", fiDocumentName);
		params.put("fiTaxCode", fiTaxCode);
		TbdHoSo14 tbdHoSo14 = createRestTemplate(getURL("/mard/14/tbdHoSo14/findByDocumentTypeAndDocumentNameAndFiTaxCode"), null, HttpMethod.GET, params, TbdHoSo14.class);

		return ResponseEntity.ok().body(tbdHoSo14);
	}


}