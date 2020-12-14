package com.nsw.mard.p18.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.mard.p18.model.HoSo18DTO;
import com.nsw.mard.p18.model.Page;
import com.nsw.mard.p18.model.PageableDTO;
import com.nsw.mard.p18.model.TbdHoSo18;

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
* @class Mard24TbdHoSo24Resource
* Created by Nguyen Van Quang
* 11/12/2018 10:2424:50
*
*/
@RestController
@RequestMapping("/mard/18/tbdHoSo18")
public class Mard18TbdHoSo18Resource extends Mard18CallBack {

	/**
	* @param tbdHoSo18 - Type: TbdHoSo18
	* @return may can null
	*/
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<TbdHoSo18> createTbdHoSo18(@RequestBody @Valid TbdHoSo18 tbdHoSo18) {
		tbdHoSo18 = createRestTemplate(getURL("/mard/18/tbdHoSo18/create"), tbdHoSo18, HttpMethod.POST, null, TbdHoSo18.class);
		return ResponseEntity.ok().body(tbdHoSo18);
	}

	/**
	* @param fiIdHoSo - Type: Long
	* @param tbdHoSo18 - Type: TbdHoSo18
	* @return may can null
	*/
	@RequestMapping(value = "/update/{fiIdHoSo}", method = RequestMethod.POST)
	public ResponseEntity<TbdHoSo18> 	updateTbdHoSo18(@PathVariable("fiIdHoSo") Long fiIdHoSo, @RequestBody @Valid TbdHoSo18 tbdHoSo18) {
		tbdHoSo18 = createRestTemplate(getURL("/mard/18/tbdHoSo18/update/") + fiIdHoSo, tbdHoSo18, HttpMethod.POST, null, TbdHoSo18.class);
		return ResponseEntity.ok().body(tbdHoSo18);
	}

	/**
	* @param fiIdHoSo - Type: Long
	* @return may can throw new Execption
	*/
	@RequestMapping(value = "/delete/{fiIdHoSo}", method = RequestMethod.POST)
	public ResponseEntity<TbdHoSo18> deleteTbdHoSo18(@PathVariable("fiIdHoSo") Long fiIdHoSo) {
		TbdHoSo18 tbdHoSo18 = getTbdHoSo18(fiIdHoSo).getBody();
		if (ObjectUtils.isEmpty(tbdHoSo18)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		tbdHoSo18.setFiActive(0);
		tbdHoSo18 = updateTbdHoSo18(fiIdHoSo, tbdHoSo18).getBody();
		return ResponseEntity.ok().body(tbdHoSo18);
	}

	/**
	* @param fiIdHoSo - Type: Long
	* @return may can null
	*/
	@RequestMapping(value = "/get/{fiIdHoSo}", method = RequestMethod.GET)
	public ResponseEntity<TbdHoSo18> getTbdHoSo18(@PathVariable("fiIdHoSo") Long fiIdHoSo) {
		TbdHoSo18 tbdHoSo18 = createRestTemplate(getURL("/mard/18/tbdHoSo18/get/") + fiIdHoSo, null, HttpMethod.GET, null, TbdHoSo18.class);
		return ResponseEntity.ok().body(tbdHoSo18);
	}

	/**
	* @param pageableDTO - Type: PageableDTO
	* @return may can null
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findAll", method = RequestMethod.POST)
	public ResponseEntity<List<TbdHoSo18>> findAllTbdHoSo18(@RequestBody @Valid PageableDTO pageableDTO) {

		List<TbdHoSo18> tbdHoSo18List = createRestTemplate(getURL("/mard/18/tbdHoSo18/findAll"), pageableDTO, HttpMethod.POST, null, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdHoSo18List = mapper.convertValue(tbdHoSo18List, new TypeReference<List<TbdHoSo18>>() {});

		return ResponseEntity.ok().body(tbdHoSo18List);
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
	public ResponseEntity<Page<HoSo18DTO>> page(@RequestBody PageableDTO pageableDTO,
												@RequestParam(name = "fiDocumentType", required = false) String fiDocumentType,
												@RequestParam(name = "fiDocumentName", required = false) String fiDocumentName,
												@RequestParam(name = "fiTaxCode", required = false) String fiTaxCode,
												@RequestParam(name = "fiActive", required = false) Integer fiActive,
												@RequestParam(name = "fiStatus", required = false) Integer fiStatus,
												@DateTimeFormat(pattern = "dd/MM/yyyy")
													@RequestParam(name = "fromFiSendDate", required = false) Date fromFiSendDate,
												@DateTimeFormat(pattern = "dd/MM/yyyy")
													@RequestParam(name = "toFiSendDate", required = false) Date toFiSendDate,
												@RequestParam(name = "fiDispatchNo", required = false) String fiDispatchNo,
												@DateTimeFormat(pattern = "dd/MM/yyyy")
													@RequestParam(name = "fromFiSignConfirmDate", required = false) Date fromFiSignConfirmDate,
												@DateTimeFormat(pattern = "dd/MM/yyyy")
													@RequestParam(name = "toFiSignConfirmDate", required = false) Date toFiSignConfirmDate) {

		Map<String, Object> params = new HashMap<>();
		params.put("fiDocumentType", Mard18Api.DOCUMENT_TYPE);
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
		Page<HoSo18DTO> page = createRestTemplate(getURL("/mard/18/tbdHoSo18/page"), pageableDTO, HttpMethod.POST, params, Page.class);
		ObjectMapper mapper = new ObjectMapper();
		List<HoSo18DTO> hoSo18DTOList = mapper.convertValue(page.getContent(), new TypeReference<List<HoSo18DTO>>() {});
		page.setContent(hoSo18DTOList);

		return ResponseEntity.ok().body(page);
	}

	/**
	* @param fiDocumentName - Type: String
	* @return can return null or throw exception
	*/
	@RequestMapping(value = "/findByDocumentName", method = RequestMethod.GET)
	public ResponseEntity<List<TbdHoSo18>> findByFiDocumentName(@RequestParam(name = "fiDocumentName", required = false) String fiDocumentName) {

		Map<String, Object> params = new HashMap<>();
		params.put("fiDocumentName", fiDocumentName);
		List<TbdHoSo18> tbdHoSo18 = createRestTemplate(getURL("/mard/18/tbdHoSo18/findByDocumentName"), null, HttpMethod.GET, params, List.class);
		ObjectMapper mapper = new ObjectMapper();
		List<TbdHoSo18> hoSo18DTOList = mapper.convertValue(tbdHoSo18, new TypeReference<List<TbdHoSo18>>() {});
		return ResponseEntity.ok().body(hoSo18DTOList);
	}

	/**
	* @param fiDocumentType - Type: String
	* @param fiDocumentName - Type: String
	* @param fiTaxCode - Type: String
	* @return can return null or throw exception
	*/
	@RequestMapping(value = "/findByDocumentTypeAndDocumentNameAndFiTaxCode", method = RequestMethod.GET)
	public ResponseEntity<TbdHoSo18> findByFiDocumentTypeAndFiDocumentNameAndFiTaxCode(@RequestParam(name = "fiDocumentType", required = false) String fiDocumentType, @RequestParam(name = "fiDocumentName", required = false) String fiDocumentName, @RequestParam(name = "fiTaxCode", required = false) String fiTaxCode) {

		Map<String, Object> params = new HashMap<>();
		params.put("fiDocumentType", fiDocumentType);
		params.put("fiDocumentName", fiDocumentName);
		params.put("fiTaxCode", fiTaxCode);
		TbdHoSo18 tbdHoSo18 = createRestTemplate(getURL("/mard/18/tbdHoSo18/findByDocumentTypeAndDocumentNameAndFiTaxCode"), null, HttpMethod.GET, params, TbdHoSo18.class);

		return ResponseEntity.ok().body(tbdHoSo18);
	}


}
