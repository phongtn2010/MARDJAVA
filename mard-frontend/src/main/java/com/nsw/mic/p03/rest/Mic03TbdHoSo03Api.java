package com.nsw.mic.p03.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.common.model.json.ResponseJson;
import com.nsw.mic.p03.dto.HoSo03DTO;
import com.nsw.mic.p03.dto.HoSo03SearchDTO;
import com.nsw.mic.p03.dto.TbdHoSo03DTO;
import com.nsw.mic.p03.model.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/***
*
*
* @RestController
* @class Mic03TbdHoSo03Resource
* Created by Nguyen Van Quang
* 11/12/2048 10:0303:50
*
*/
@RestController
@RequestMapping("/mic/03/tbdHoSo03")
public class Mic03TbdHoSo03Api extends Mic03CallBack {

	/**
	* @param tbdHoSo03 - Type: TbdHoSo03
	* @return may can null
	*/
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<TbdHoSo03DTO> createTbdHoSo03(@RequestBody @Valid TbdHoSo03DTO tbdHoSo03) {
		tbdHoSo03 = createRestTemplate(getURL("/mic/03/tbdHoSo03/create"), tbdHoSo03, HttpMethod.POST, null, TbdHoSo03DTO.class);
		return ResponseEntity.ok().body(tbdHoSo03);
	}

	/**
	* @param fiIdHoSo - Type: Long
	* @param tbdHoSo03 - Type: TbdHoSo03
	* @return may can null
	*/
	@RequestMapping(value = "/update/{fiIdHoSo}", method = RequestMethod.POST)
	public ResponseEntity<TbdHoSo03DTO> updateTbdHoSo03(@PathVariable("fiIdHoSo") Long fiIdHoSo, @RequestBody @Valid TbdHoSo03DTO tbdHoSo03) {
		tbdHoSo03 = createRestTemplate(getURL("/mic/03/tbdHoSo03/update/") + fiIdHoSo, tbdHoSo03, HttpMethod.POST, null, TbdHoSo03DTO.class);
		return ResponseEntity.ok().body(tbdHoSo03);
	}

	/**
	* @param fiIdHoSo - Type: Long
	* @return may can throw new Execption
	*/
	@RequestMapping(value = "/delete/{fiIdHoSo}", method = RequestMethod.POST)
	public ResponseEntity<TbdHoSo03DTO> deleteTbdHoSo03(@PathVariable("fiIdHoSo") Long fiIdHoSo) {
		TbdHoSo03DTO tbdHoSo03 = getTbdHoSo03(fiIdHoSo).getBody();
		if (ObjectUtils.isEmpty(tbdHoSo03)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		tbdHoSo03.setFiActive(0);
		tbdHoSo03 = updateTbdHoSo03(fiIdHoSo, tbdHoSo03).getBody();
		return ResponseEntity.ok().body(tbdHoSo03);
	}

	/**
	* @param fiIdHoSo - Type: Long
	* @return may can null
	*/
	@RequestMapping(value = "/get/{fiIdHoSo}", method = RequestMethod.GET)
	public ResponseEntity<TbdHoSo03DTO> getTbdHoSo03(@PathVariable("fiIdHoSo") Long fiIdHoSo) {
		TbdHoSo03DTO tbdHoSo03 = createRestTemplate(getURL("/mic/03/tbdHoSo03/get/") + fiIdHoSo, null, HttpMethod.GET, null, TbdHoSo03DTO.class);
		return ResponseEntity.ok().body(tbdHoSo03);
	}


	/**
	* @return can return null or throw exception
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/page", method = RequestMethod.POST)
	public ResponseEntity<ResponseJson> page(@RequestBody HoSo03SearchDTO hoSo03SearchDTO) {

		Map<String, Object> params = new HashMap<>();
		if (isFcap()) {
			params.put("isFcap", String.valueOf(isFcap()));
		}

		String currentUser = SecurityUtil.getTaxCode();
		if (StringUtils.hasText(currentUser)) {
			hoSo03SearchDTO.setFiTaxCode(currentUser);
		}
		hoSo03SearchDTO.setFiActive(1);
		hoSo03SearchDTO.setFiDocumentType(Mic03Constant.DOCUMENT_TYPE);
		System.out.println(hoSo03SearchDTO.toString());

		Page<HoSo03DTO> page = createRestTemplate(getURL("/mic/03/tbdHoSo03/page"), hoSo03SearchDTO, HttpMethod.POST, params, Page.class);
		ObjectMapper mapper = new ObjectMapper();
		List<HoSo03DTO> hoSo03DTOList = mapper.convertValue(page.getContent(), new TypeReference<List<HoSo03DTO>>() {});
		page.setContent(hoSo03DTOList);

		ResponseJson responseJson = new ResponseJson();
		responseJson.setData(page);
		responseJson.setSuccess(true);
		return ResponseEntity.ok().body(responseJson);
	}


}