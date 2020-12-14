package com.nsw.mard.p19.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.mard.p19.model.HoSo19DTO;
import com.nsw.mard.p19.model.Page;
import com.nsw.mard.p19.model.PageableDTO;
import com.nsw.mard.p19.model.TbdHoSo19;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
* 11/12/2019 10:2424:50
*
*/
@RestController
@RequestMapping("/mard/19/tbdHoSo19")
public class Mard19TbdHoSo19Resource extends Mard19CallBack {
	public static final Logger LOGGER = LoggerFactory.getLogger(Mard19TbdHoSo19Resource.class);

	/**
	* @param tbdHoSo19 - Type: TbdHoSo19
	* @return may can null
	*/
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<TbdHoSo19> createTbdHoSo19(@RequestBody @Valid TbdHoSo19 tbdHoSo19) {
		tbdHoSo19 = createRestTemplate(getURL("/mard/18/tbdHoSo18/create"), tbdHoSo19, HttpMethod.POST, null, TbdHoSo19.class);
		return ResponseEntity.ok().body(tbdHoSo19);
	}

	/**
	* @param fiIdHoSo - Type: Long
	* @param tbdHoSo19 - Type: TbdHoSo19
	* @return may can null
	*/
	@RequestMapping(value = "/update/{fiIdHoSo}", method = RequestMethod.POST)
	public ResponseEntity<TbdHoSo19> 	updateTbdHoSo19(@PathVariable("fiIdHoSo") Long fiIdHoSo, @RequestBody @Valid TbdHoSo19 tbdHoSo19) {
		tbdHoSo19 = createRestTemplate(getURL("/mard/18/tbdHoSo18/update/") + fiIdHoSo, tbdHoSo19, HttpMethod.POST, null, TbdHoSo19.class);
		return ResponseEntity.ok().body(tbdHoSo19);
	}

	/**
	* @param fiIdHoSo - Type: Long
	* @return may can throw new Execption
	*/
	@RequestMapping(value = "/delete/{fiIdHoSo}", method = RequestMethod.POST)
	public ResponseEntity<TbdHoSo19> deleteTbdHoSo19(@PathVariable("fiIdHoSo") Long fiIdHoSo) {
		TbdHoSo19 tbdHoSo19 = getTbdHoSo19(fiIdHoSo).getBody();
		if (ObjectUtils.isEmpty(tbdHoSo19)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		tbdHoSo19.setFiActive(0);
		tbdHoSo19 = updateTbdHoSo19(fiIdHoSo, tbdHoSo19).getBody();
		return ResponseEntity.ok().body(tbdHoSo19);
	}

	/**
	* @param fiIdHoSo - Type: Long
	* @return may can null
	*/
	@RequestMapping(value = "/get/{fiIdHoSo}", method = RequestMethod.GET)
	public ResponseEntity<TbdHoSo19> getTbdHoSo19(@PathVariable("fiIdHoSo") Long fiIdHoSo) {
		TbdHoSo19 tbdHoSo19 = createRestTemplate(getURL("/mard/18/tbdHoSo18/get/") + fiIdHoSo, null, HttpMethod.GET, null, TbdHoSo19.class);
		return ResponseEntity.ok().body(tbdHoSo19);
	}

	/**
	* @param pageableDTO - Type: PageableDTO
	* @return may can null
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findAll", method = RequestMethod.POST)
	public ResponseEntity<List<TbdHoSo19>> findAllTbdHoSo19(@RequestBody @Valid PageableDTO pageableDTO) {

		List<TbdHoSo19> tbdHoSo19List = createRestTemplate(getURL("/mard/18/tbdHoSo18/findAll"), pageableDTO, HttpMethod.POST, null, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdHoSo19List = mapper.convertValue(tbdHoSo19List, new TypeReference<List<TbdHoSo19>>() {});

		return ResponseEntity.ok().body(tbdHoSo19List);
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
	public ResponseEntity<Page<HoSo19DTO>> page(@RequestBody PageableDTO pageableDTO,
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
		params.put("fiDocumentType", Mard19Api.DOCUMENT_TYPE);
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
		Page<HoSo19DTO> page = createRestTemplate(getURL("/mard/18/tbdHoSo18/page"), pageableDTO, HttpMethod.POST, params, Page.class);
		ObjectMapper mapper = new ObjectMapper();
		List<HoSo19DTO> hoSo19DTOList = mapper.convertValue(page.getContent(), new TypeReference<List<HoSo19DTO>>() {});
		page.setContent(hoSo19DTOList);
		LOGGER.info("hoSo19DTOList: {}", hoSo19DTOList.get(0).toString());
		LOGGER.info("hoSo19DTODocumentType: {}", hoSo19DTOList.get(0).getFiDocumentType().toString());
        LOGGER.info("page: {}", ResponseEntity.ok().body(page));
		return ResponseEntity.ok().body(page);
	}

	/**
	* @param fiDocumentName - Type: String
	* @return can return null or throw exception
	*/
	@RequestMapping(value = "/findByDocumentName", method = RequestMethod.GET)
	public ResponseEntity<List<TbdHoSo19>> findByFiDocumentName(@RequestParam(name = "fiDocumentName", required = false) String fiDocumentName) {

		Map<String, Object> params = new HashMap<>();
		params.put("fiDocumentName", fiDocumentName);
		List<TbdHoSo19> tbdHoSo19 = createRestTemplate(getURL("/mard/18/tbdHoSo18/findByDocumentName"), null, HttpMethod.GET, params, List.class);
		ObjectMapper mapper = new ObjectMapper();
		List<TbdHoSo19> hoSo19DTOList = mapper.convertValue(tbdHoSo19, new TypeReference<List<TbdHoSo19>>() {});
		return ResponseEntity.ok().body(hoSo19DTOList);
	}
	/*@RequestMapping(value = "/findByDocumentType", method = RequestMethod.GET)
	public ResponseEntity<List<TbdHoSo19>> findByFiDocumentType(@RequestParam(name = "fiDocumentType", required = false) String fiDocumentType) {

		Map<String, Object> params = new HashMap<>();
		params.put("fiDocumentType", fiDocumentType);
		List<TbdHoSo19> tbdHoSo19 = createRestTemplate(getURL("/mard/18/tbdHoSo18/findByDocumentType"), null, HttpMethod.GET, params, List.class);
		ObjectMapper mapper = new ObjectMapper();
		List<TbdHoSo19> hoSo19DTOList = mapper.convertValue(tbdHoSo19, new TypeReference<List<TbdHoSo19>>() {});
		return ResponseEntity.ok().body(hoSo19DTOList);
	}*/


	/**
	* @param fiDocumentType - Type: String
	* @param fiDocumentName - Type: String
	* @param fiTaxCode - Type: String
	* @return can return null or throw exception
	*/
	@RequestMapping(value = "/findByDocumentTypeAndDocumentNameAndFiTaxCode", method = RequestMethod.GET)
	public ResponseEntity<TbdHoSo19> findByFiDocumentTypeAndFiDocumentNameAndFiTaxCode(@RequestParam(name = "fiDocumentType", required = false) String fiDocumentType, @RequestParam(name = "fiDocumentName", required = false) String fiDocumentName, @RequestParam(name = "fiTaxCode", required = false) String fiTaxCode) {

		Map<String, Object> params = new HashMap<>();
		params.put("fiDocumentType", fiDocumentType);
		params.put("fiDocumentName", fiDocumentName);
		params.put("fiTaxCode", fiTaxCode);
		TbdHoSo19 tbdHoSo19 = createRestTemplate(getURL("/mard/18/tbdHoSo18/findByDocumentTypeAndDocumentNameAndFiTaxCode"), null, HttpMethod.GET, params, TbdHoSo19.class);

		return ResponseEntity.ok().body(tbdHoSo19);
	}


}
