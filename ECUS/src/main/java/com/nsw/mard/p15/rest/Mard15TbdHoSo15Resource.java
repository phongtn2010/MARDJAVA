package com.nsw.mard.p15.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.mard.p14.rest.SecurityUtil;
import com.nsw.mard.p15.model.HoSo15DTO;
import com.nsw.mard.p15.model.Page;
import com.nsw.mard.p15.model.PageableDTO;
import com.nsw.mard.p15.model.TbdHoSo15;

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
* @class Mard15TbdHoSo15Resource
* Created by Nguyen Van Quang
* 11/12/2018 10:1515:50
*
*/
@RestController
@RequestMapping("/mard/15/tbdHoSo15")
public class Mard15TbdHoSo15Resource extends Mard15CallBack {

	/**
	* @param tbdHoSo15 - Type: TbdHoSo15
	* @return may can null
	*/
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<TbdHoSo15> createTbdHoSo15(@RequestBody @Valid TbdHoSo15 tbdHoSo15) {
		tbdHoSo15 = createRestTemplate(getURL("/mard/15/tbdHoSo15/create"), tbdHoSo15, HttpMethod.POST, null, TbdHoSo15.class);
		return ResponseEntity.ok().body(tbdHoSo15);
	}

	/**
	* @param fiIdHoSo - Type: Long
	* @param tbdHoSo15 - Type: TbdHoSo15
	* @return may can null
	*/
	@RequestMapping(value = "/update/{fiIdHoSo}", method = RequestMethod.POST)
	public ResponseEntity<TbdHoSo15> updateTbdHoSo15(@PathVariable("fiIdHoSo") Long fiIdHoSo, @RequestBody @Valid TbdHoSo15 tbdHoSo15) {
		tbdHoSo15 = createRestTemplate(getURL("/mard/15/tbdHoSo15/update/") + fiIdHoSo, tbdHoSo15, HttpMethod.POST, null, TbdHoSo15.class);
		return ResponseEntity.ok().body(tbdHoSo15);
	}

	/**
	* @param fiIdHoSo - Type: Long
	* @return may can throw new Execption
	*/
	@RequestMapping(value = "/delete/{fiIdHoSo}", method = RequestMethod.POST)
	public ResponseEntity<TbdHoSo15> deleteTbdHoSo15(@PathVariable("fiIdHoSo") Long fiIdHoSo) {
		TbdHoSo15 tbdHoSo15 = getTbdHoSo15(fiIdHoSo).getBody();
		if (ObjectUtils.isEmpty(tbdHoSo15)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		tbdHoSo15.setFiActive(0);
		tbdHoSo15 = updateTbdHoSo15(fiIdHoSo, tbdHoSo15).getBody();
		return ResponseEntity.ok().body(tbdHoSo15);
	}

	/**
	* @param fiIdHoSo - Type: Long
	* @return may can null
	*/
	@RequestMapping(value = "/get/{fiIdHoSo}", method = RequestMethod.GET)
	public ResponseEntity<TbdHoSo15> getTbdHoSo15(@PathVariable("fiIdHoSo") Long fiIdHoSo) {
		TbdHoSo15 tbdHoSo15 = createRestTemplate(getURL("/mard/15/tbdHoSo15/get/") + fiIdHoSo, null, HttpMethod.GET, null, TbdHoSo15.class);
		return ResponseEntity.ok().body(tbdHoSo15);
	}

	/**
	* @param pageableDTO - Type: PageableDTO
	* @return may can null
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findAll", method = RequestMethod.POST)
	public ResponseEntity<List<TbdHoSo15>> findAllTbdHoSo15(@RequestBody @Valid PageableDTO pageableDTO) {

		List<TbdHoSo15> tbdHoSo15List = createRestTemplate(getURL("/mard/15/tbdHoSo15/findAll"), pageableDTO, HttpMethod.POST, null, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdHoSo15List = mapper.convertValue(tbdHoSo15List, new TypeReference<List<TbdHoSo15>>() {});

		return ResponseEntity.ok().body(tbdHoSo15List);
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
	public ResponseEntity<Page<HoSo15DTO>> page(@RequestBody PageableDTO pageableDTO, @RequestParam(name = "fiDocumentType", required = false) String fiDocumentType, @RequestParam(name = "fiDocumentName", required = false) String fiDocumentName, @RequestParam(name = "fiTaxCode", required = false) String fiTaxCode, @RequestParam(name = "fiActive", required = false) Integer fiActive, @RequestParam(name = "fiStatus", required = false) Integer fiStatus, @DateTimeFormat(pattern = "dd/MM/yyyy") @RequestParam(name = "fromFiSendDate", required = false) Date fromFiSendDate, @DateTimeFormat(pattern = "dd/MM/yyyy") @RequestParam(name = "toFiSendDate", required = false) Date toFiSendDate, @RequestParam(name = "fiDispatchNo", required = false) String fiDispatchNo, @DateTimeFormat(pattern = "dd/MM/yyyy") @RequestParam(name = "fromFiSignConfirmDate", required = false) Date fromFiSignConfirmDate, @DateTimeFormat(pattern = "dd/MM/yyyy") @RequestParam(name = "toFiSignConfirmDate", required = false) Date toFiSignConfirmDate) {

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
		Page<HoSo15DTO> page = createRestTemplate(getURL("/mard/15/tbdHoSo15/page"), pageableDTO, HttpMethod.POST, params, Page.class);
		ObjectMapper mapper = new ObjectMapper();
		List<HoSo15DTO> hoSo15DTOList = mapper.convertValue(page.getContent(), new TypeReference<List<HoSo15DTO>>() {});
		page.setContent(hoSo15DTOList);

		return ResponseEntity.ok().body(page);
	}

	/**
	* @param fiDocumentName - Type: String
	* @return can return null or throw exception
	*/
	@RequestMapping(value = "/findByDocumentName", method = RequestMethod.GET)
	public ResponseEntity<List<TbdHoSo15>> findByFiDocumentName(@RequestParam(name = "fiDocumentName", required = false) String fiDocumentName) {

		Map<String, Object> params = new HashMap<>();
		params.put("fiDocumentName", fiDocumentName);
		List<TbdHoSo15> tbdHoSo15 = createRestTemplate(getURL("/mard/15/tbdHoSo15/findByDocumentName"), null, HttpMethod.GET, params, List.class);
		ObjectMapper mapper = new ObjectMapper();
		List<TbdHoSo15> hoSo15DTOList = mapper.convertValue(tbdHoSo15, new TypeReference<List<TbdHoSo15>>() {});
		return ResponseEntity.ok().body(hoSo15DTOList);
	}

	/**
	* @param fiDocumentType - Type: String
	* @param fiDocumentName - Type: String
	* @param fiTaxCode - Type: String
	* @return can return null or throw exception
	*/
	@RequestMapping(value = "/findByDocumentTypeAndDocumentNameAndFiTaxCode", method = RequestMethod.GET)
	public ResponseEntity<TbdHoSo15> findByFiDocumentTypeAndFiDocumentNameAndFiTaxCode(@RequestParam(name = "fiDocumentType", required = false) String fiDocumentType, @RequestParam(name = "fiDocumentName", required = false) String fiDocumentName, @RequestParam(name = "fiTaxCode", required = false) String fiTaxCode) {

		Map<String, Object> params = new HashMap<>();
		params.put("fiDocumentType", fiDocumentType);
		params.put("fiDocumentName", fiDocumentName);
		params.put("fiTaxCode", fiTaxCode);
		TbdHoSo15 tbdHoSo15 = createRestTemplate(getURL("/mard/15/tbdHoSo15/findByDocumentTypeAndDocumentNameAndFiTaxCode"), null, HttpMethod.GET, params, TbdHoSo15.class);

		return ResponseEntity.ok().body(tbdHoSo15);
	}


}