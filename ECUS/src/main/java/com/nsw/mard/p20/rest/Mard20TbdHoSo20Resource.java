package com.nsw.mard.p20.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.mard.p20.model.HoSo20DTO;
import com.nsw.mard.p20.model.Page;
import com.nsw.mard.p20.model.PageableDTO;
import com.nsw.mard.p20.model.TbdHoSo20;

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
* 11/12/2020 10:2424:50
*
*/
@RestController
@RequestMapping("/mard/20/tbdHoSo20")
public class Mard20TbdHoSo20Resource extends Mard20CallBack {

	/**
	* @param tbdHoSo20 - Type: TbdHoSo20
	* @return may can null
	*/
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<TbdHoSo20> createTbdHoSo20(@RequestBody @Valid TbdHoSo20 tbdHoSo20) {
		tbdHoSo20 = createRestTemplate(getURL("/mard/18/tbdHoSo18/create"), tbdHoSo20, HttpMethod.POST, null, TbdHoSo20.class);
		return ResponseEntity.ok().body(tbdHoSo20);
	}

	/**
	* @param fiIdHoSo - Type: Long
	* @param tbdHoSo20 - Type: TbdHoSo20
	* @return may can null
	*/
	@RequestMapping(value = "/update/{fiIdHoSo}", method = RequestMethod.POST)
	public ResponseEntity<TbdHoSo20> 	updateTbdHoSo20(@PathVariable("fiIdHoSo") Long fiIdHoSo, @RequestBody @Valid TbdHoSo20 tbdHoSo20) {
		tbdHoSo20 = createRestTemplate(getURL("/mard/18/tbdHoSo18/update/") + fiIdHoSo, tbdHoSo20, HttpMethod.POST, null, TbdHoSo20.class);
		return ResponseEntity.ok().body(tbdHoSo20);
	}

	/**
	* @param fiIdHoSo - Type: Long
	* @return may can throw new Execption
	*/
	@RequestMapping(value = "/delete/{fiIdHoSo}", method = RequestMethod.POST)
	public ResponseEntity<TbdHoSo20> deleteTbdHoSo20(@PathVariable("fiIdHoSo") Long fiIdHoSo) {
		TbdHoSo20 tbdHoSo20 = getTbdHoSo20(fiIdHoSo).getBody();
		if (ObjectUtils.isEmpty(tbdHoSo20)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		tbdHoSo20.setFiActive(0);
		tbdHoSo20 = updateTbdHoSo20(fiIdHoSo, tbdHoSo20).getBody();
		return ResponseEntity.ok().body(tbdHoSo20);
	}

	/**
	* @param fiIdHoSo - Type: Long
	* @return may can null
	*/
	@RequestMapping(value = "/get/{fiIdHoSo}", method = RequestMethod.GET)
	public ResponseEntity<TbdHoSo20> getTbdHoSo20(@PathVariable("fiIdHoSo") Long fiIdHoSo) {
		TbdHoSo20 tbdHoSo20 = createRestTemplate(getURL("/mard/18/tbdHoSo18/get/") + fiIdHoSo, null, HttpMethod.GET, null, TbdHoSo20.class);
		return ResponseEntity.ok().body(tbdHoSo20);
	}

	/**
	* @param pageableDTO - Type: PageableDTO
	* @return may can null
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findAll", method = RequestMethod.POST)
	public ResponseEntity<List<TbdHoSo20>> findAllTbdHoSo20(@RequestBody @Valid PageableDTO pageableDTO) {

		List<TbdHoSo20> tbdHoSo20List = createRestTemplate(getURL("/mard/18/tbdHoSo18/findAll"), pageableDTO, HttpMethod.POST, null, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdHoSo20List = mapper.convertValue(tbdHoSo20List, new TypeReference<List<TbdHoSo20>>() {});

		return ResponseEntity.ok().body(tbdHoSo20List);
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
	public ResponseEntity<Page<HoSo20DTO>> page(@RequestBody PageableDTO pageableDTO,
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
		params.put("fiDocumentType", Mard20Api.DOCUMENT_TYPE);
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
		Page<HoSo20DTO> page = createRestTemplate(getURL("/mard/18/tbdHoSo18/page"), pageableDTO, HttpMethod.POST, params, Page.class);
		ObjectMapper mapper = new ObjectMapper();
		List<HoSo20DTO> hoSo20DTOList = mapper.convertValue(page.getContent(), new TypeReference<List<HoSo20DTO>>() {});
		page.setContent(hoSo20DTOList);

		return ResponseEntity.ok().body(page);
	}

	/**
	* @param fiDocumentName - Type: String
	* @return can return null or throw exception
	*/
	@RequestMapping(value = "/findByDocumentName", method = RequestMethod.GET)
	public ResponseEntity<List<TbdHoSo20>> findByFiDocumentName(@RequestParam(name = "fiDocumentName", required = false) String fiDocumentName) {

		Map<String, Object> params = new HashMap<>();
		params.put("fiDocumentName", fiDocumentName);
		List<TbdHoSo20> tbdHoSo20 = createRestTemplate(getURL("/mard/18/tbdHoSo18/findByDocumentName"), null, HttpMethod.GET, params, List.class);
		ObjectMapper mapper = new ObjectMapper();
		List<TbdHoSo20> hoSo20DTOList = mapper.convertValue(tbdHoSo20, new TypeReference<List<TbdHoSo20>>() {});
		return ResponseEntity.ok().body(hoSo20DTOList);
	}

	/**
	* @param fiDocumentType - Type: String
	* @param fiDocumentName - Type: String
	* @param fiTaxCode - Type: String
	* @return can return null or throw exception
	*/
	@RequestMapping(value = "/findByDocumentTypeAndDocumentNameAndFiTaxCode", method = RequestMethod.GET)
	public ResponseEntity<TbdHoSo20> findByFiDocumentTypeAndFiDocumentNameAndFiTaxCode(@RequestParam(name = "fiDocumentType", required = false) String fiDocumentType, @RequestParam(name = "fiDocumentName", required = false) String fiDocumentName, @RequestParam(name = "fiTaxCode", required = false) String fiTaxCode) {

		Map<String, Object> params = new HashMap<>();
		params.put("fiDocumentType", fiDocumentType);
		params.put("fiDocumentName", fiDocumentName);
		params.put("fiTaxCode", fiTaxCode);
		TbdHoSo20 tbdHoSo20 = createRestTemplate(getURL("/mard/18/tbdHoSo18/findByDocumentTypeAndDocumentNameAndFiTaxCode"), null, HttpMethod.GET, params, TbdHoSo20.class);

		return ResponseEntity.ok().body(tbdHoSo20);
	}


}
