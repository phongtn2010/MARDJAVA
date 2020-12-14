package com.nsw.mic.p04.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.common.model.json.ResponseJson;
import com.nsw.mic.p04.dto.HoSo04DTO;
import com.nsw.mic.p04.dto.HoSo04SearchDTO;
import com.nsw.mic.p04.dto.TbdHoSo04DTO;
import com.nsw.mic.p04.model.*;

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
* @class Mic04TbdHoSo04Resource
* Created by Nguyen Van Quang
* 11/12/2048 10:0404:50
*
*/
@RestController
@RequestMapping("/mic/04/tbdHoSo04")
public class Mic04TbdHoSo04Api extends Mic04CallBack {

	/**
	* @param tbdHoSo04 - Type: TbdHoSo04
	* @return may can null
	*/
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<TbdHoSo04DTO> createTbdHoSo04(@RequestBody @Valid TbdHoSo04DTO tbdHoSo04) {
		tbdHoSo04 = createRestTemplate(getURL("/mic/04/tbdHoSo04/create"), tbdHoSo04, HttpMethod.POST, null, TbdHoSo04DTO.class);
		return ResponseEntity.ok().body(tbdHoSo04);
	}

	/**
	* @param fiIdHoSo - Type: Long
	* @param tbdHoSo04 - Type: TbdHoSo04
	* @return may can null
	*/
	@RequestMapping(value = "/update/{fiIdHoSo}", method = RequestMethod.POST)
	public ResponseEntity<TbdHoSo04DTO> updateTbdHoSo04(@PathVariable("fiIdHoSo") Long fiIdHoSo, @RequestBody @Valid TbdHoSo04DTO tbdHoSo04) {
		tbdHoSo04 = createRestTemplate(getURL("/mic/04/tbdHoSo04/update/") + fiIdHoSo, tbdHoSo04, HttpMethod.POST, null, TbdHoSo04DTO.class);
		return ResponseEntity.ok().body(tbdHoSo04);
	}

	/**
	* @param fiIdHoSo - Type: Long
	* @return may can throw new Execption
	*/
	@RequestMapping(value = "/delete/{fiIdHoSo}", method = RequestMethod.POST)
	public ResponseEntity<TbdHoSo04DTO> deleteTbdHoSo04(@PathVariable("fiIdHoSo") Long fiIdHoSo) {
		TbdHoSo04DTO tbdHoSo04 = getTbdHoSo04(fiIdHoSo).getBody();
		if (ObjectUtils.isEmpty(tbdHoSo04)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		tbdHoSo04.setFiActive(0);
		tbdHoSo04 = updateTbdHoSo04(fiIdHoSo, tbdHoSo04).getBody();
		return ResponseEntity.ok().body(tbdHoSo04);
	}

	/**
	* @param fiIdHoSo - Type: Long
	* @return may can null
	*/
	@RequestMapping(value = "/get/{fiIdHoSo}", method = RequestMethod.GET)
	public ResponseEntity<TbdHoSo04DTO> getTbdHoSo04(@PathVariable("fiIdHoSo") Long fiIdHoSo) {
		TbdHoSo04DTO tbdHoSo04 = createRestTemplate(getURL("/mic/04/tbdHoSo04/get/") + fiIdHoSo, null, HttpMethod.GET, null, TbdHoSo04DTO.class);
		return ResponseEntity.ok().body(tbdHoSo04);
	}


	/**
	* @return can return null or throw exception
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/page", method = RequestMethod.POST)
	public ResponseEntity<ResponseJson> page(@RequestBody HoSo04SearchDTO hoSo04SearchDTO) {

		Map<String, Object> params = new HashMap<>();
		if (isFcap()) {
			params.put("isFcap", String.valueOf(isFcap()));
		}

		String currentUser = SecurityUtil.getTaxCode();
		if (StringUtils.hasText(currentUser)) {
			hoSo04SearchDTO.setFiTaxCode(currentUser);
		}
		hoSo04SearchDTO.setFiActive(1);
		hoSo04SearchDTO.setFiDocumentType(Mic04Constant.DOCUMENT_TYPE);
		System.out.println(hoSo04SearchDTO.toString());

		Page<HoSo04DTO> page = createRestTemplate(getURL("/mic/04/tbdHoSo04/page"), hoSo04SearchDTO, HttpMethod.POST, params, Page.class);
		ObjectMapper mapper = new ObjectMapper();
		List<HoSo04DTO> hoSo04DTOList = mapper.convertValue(page.getContent(), new TypeReference<List<HoSo04DTO>>() {});
		page.setContent(hoSo04DTOList);

		ResponseJson responseJson = new ResponseJson();
		responseJson.setData(page);
		responseJson.setSuccess(true);
		return ResponseEntity.ok().body(responseJson);
	}


}