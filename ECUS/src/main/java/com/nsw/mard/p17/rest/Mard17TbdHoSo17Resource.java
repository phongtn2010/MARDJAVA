package com.nsw.mard.p17.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.mard.p17.model.HoSo17DTO;
import com.nsw.mard.p17.model.Page;
import com.nsw.mard.p17.model.PageableDTO;
import com.nsw.mard.p17.model.TbdHoSo17;

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
@RequestMapping("/mard/17/tbdHoSo17")
public class Mard17TbdHoSo17Resource extends Mard17CallBack {

	/**
	* @param tbdHoSo17 - Type: TbdHoSo17
	* @return may can null
	*/
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<TbdHoSo17> createTbdHoSo17(@RequestBody @Valid TbdHoSo17 tbdHoSo17) {
		tbdHoSo17 = createRestTemplate(getURL("/mard/17/tbdHoSo17/create"), tbdHoSo17, HttpMethod.POST, null, TbdHoSo17.class);
		return ResponseEntity.ok().body(tbdHoSo17);
	}

	/**
	* @param fiIdHoSo - Type: Long
	* @param tbdHoSo17 - Type: TbdHoSo17
	* @return may can null
	*/
	@RequestMapping(value = "/update/{fiIdHoSo}", method = RequestMethod.POST)
	public ResponseEntity<TbdHoSo17> 	updateTbdHoSo17(@PathVariable("fiIdHoSo") Long fiIdHoSo, @RequestBody @Valid TbdHoSo17 tbdHoSo17) {
		tbdHoSo17 = createRestTemplate(getURL("/mard/17/tbdHoSo17/update/") + fiIdHoSo, tbdHoSo17, HttpMethod.POST, null, TbdHoSo17.class);
		return ResponseEntity.ok().body(tbdHoSo17);
	}

	/**
	* @param fiIdHoSo - Type: Long
	* @return may can throw new Execption
	*/
	@RequestMapping(value = "/delete/{fiIdHoSo}", method = RequestMethod.POST)
	public ResponseEntity<TbdHoSo17> deleteTbdHoSo17(@PathVariable("fiIdHoSo") Long fiIdHoSo) {
		TbdHoSo17 tbdHoSo17 = getTbdHoSo17(fiIdHoSo).getBody();
		if (ObjectUtils.isEmpty(tbdHoSo17)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		tbdHoSo17.setFiActive(0);
		tbdHoSo17 = updateTbdHoSo17(fiIdHoSo, tbdHoSo17).getBody();
		return ResponseEntity.ok().body(tbdHoSo17);
	}

	/**
	* @param fiIdHoSo - Type: Long
	* @return may can null
	*/
	@RequestMapping(value = "/get/{fiIdHoSo}", method = RequestMethod.GET)
	public ResponseEntity<TbdHoSo17> getTbdHoSo17(@PathVariable("fiIdHoSo") Long fiIdHoSo) {
		TbdHoSo17 tbdHoSo17 = createRestTemplate(getURL("/mard/17/tbdHoSo17/get/") + fiIdHoSo, null, HttpMethod.GET, null, TbdHoSo17.class);
		return ResponseEntity.ok().body(tbdHoSo17);
	}

	/**
	* @param pageableDTO - Type: PageableDTO
	* @return may can null
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findAll", method = RequestMethod.POST)
	public ResponseEntity<List<TbdHoSo17>> findAllTbdHoSo17(@RequestBody @Valid PageableDTO pageableDTO) {

		List<TbdHoSo17> tbdHoSo17List = createRestTemplate(getURL("/mard/17/tbdHoSo17/findAll"), pageableDTO, HttpMethod.POST, null, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdHoSo17List = mapper.convertValue(tbdHoSo17List, new TypeReference<List<TbdHoSo17>>() {});

		return ResponseEntity.ok().body(tbdHoSo17List);
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
	public ResponseEntity<Page<HoSo17DTO>> page(@RequestBody PageableDTO pageableDTO,
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
		Page<HoSo17DTO> page = createRestTemplate(getURL("/mard/17/tbdHoSo17/page"), pageableDTO, HttpMethod.POST, params, Page.class);
		ObjectMapper mapper = new ObjectMapper();
		List<HoSo17DTO> hoSo17DTOList = mapper.convertValue(page.getContent(), new TypeReference<List<HoSo17DTO>>() {});
		page.setContent(hoSo17DTOList);

		return ResponseEntity.ok().body(page);
	}

	/**
	* @param fiDocumentName - Type: String
	* @return can return null or throw exception
	*/
	@RequestMapping(value = "/findByDocumentName", method = RequestMethod.GET)
	public ResponseEntity<List<TbdHoSo17>> findByFiDocumentName(@RequestParam(name = "fiDocumentName", required = false) String fiDocumentName) {

		Map<String, Object> params = new HashMap<>();
		params.put("fiDocumentName", fiDocumentName);
		List<TbdHoSo17> tbdHoSo17 = createRestTemplate(getURL("/mard/17/tbdHoSo17/findByDocumentName"), null, HttpMethod.GET, params, List.class);
		ObjectMapper mapper = new ObjectMapper();
		List<TbdHoSo17> hoSo17DTOList = mapper.convertValue(tbdHoSo17, new TypeReference<List<TbdHoSo17>>() {});
		return ResponseEntity.ok().body(hoSo17DTOList);
	}

	/**
	* @param fiDocumentType - Type: String
	* @param fiDocumentName - Type: String
	* @param fiTaxCode - Type: String
	* @return can return null or throw exception
	*/
	@RequestMapping(value = "/findByDocumentTypeAndDocumentNameAndFiTaxCode", method = RequestMethod.GET)
	public ResponseEntity<TbdHoSo17> findByFiDocumentTypeAndFiDocumentNameAndFiTaxCode(@RequestParam(name = "fiDocumentType", required = false) String fiDocumentType, @RequestParam(name = "fiDocumentName", required = false) String fiDocumentName, @RequestParam(name = "fiTaxCode", required = false) String fiTaxCode) {

		Map<String, Object> params = new HashMap<>();
		params.put("fiDocumentType", fiDocumentType);
		params.put("fiDocumentName", fiDocumentName);
		params.put("fiTaxCode", fiTaxCode);
		TbdHoSo17 tbdHoSo17 = createRestTemplate(getURL("/mard/17/tbdHoSo17/findByDocumentTypeAndDocumentNameAndFiTaxCode"), null, HttpMethod.GET, params, TbdHoSo17.class);

		return ResponseEntity.ok().body(tbdHoSo17);
	}


}
