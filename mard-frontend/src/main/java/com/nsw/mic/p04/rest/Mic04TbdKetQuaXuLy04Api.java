package com.nsw.mic.p04.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.common.model.json.ResponseJson;
import com.nsw.mic.p04.dto.PageableDTO;
import com.nsw.mic.p04.model.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.nsw.mic.p04.dto.KetQuaXuLy04DTO;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
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
* @class Mic04TbdKetQuaXuLy04Resource
* Created by Nguyen Van Quang
* 11/12/2048 10:07:11
*
*/
@RestController
@RequestMapping("/mic/04/tbdKetQuaXuLy04")
public class Mic04TbdKetQuaXuLy04Api extends Mic04CallBack {

	/**
	* @param tbdKetQuaXuLy04 - Type: TbdKetQuaXuLy04
	* @return may can null
	*/
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<TbdKetQuaXuLy04> createTbdKetQuaXuLy04(@RequestBody @Valid TbdKetQuaXuLy04 tbdKetQuaXuLy04) {
		tbdKetQuaXuLy04.setFiUuid("NULL");
		tbdKetQuaXuLy04 = createRestTemplate(getURL("/mic/04/tbdKetQuaXuLy04/create"), tbdKetQuaXuLy04, HttpMethod.POST, null, TbdKetQuaXuLy04.class);
		return ResponseEntity.ok().body(tbdKetQuaXuLy04);
	}

	/**
	* @param fiId - Type: Long
	* @param tbdKetQuaXuLy04 - Type: TbdKetQuaXuLy04
	* @return may can null
	*/
	@RequestMapping(value = "/update/{fiId}", method = RequestMethod.POST)
	public ResponseEntity<TbdKetQuaXuLy04> updateTbdKetQuaXuLy04(@PathVariable("fiId") Long fiId, @RequestBody @Valid TbdKetQuaXuLy04 tbdKetQuaXuLy04) {
		tbdKetQuaXuLy04 = createRestTemplate(getURL("/mic/04/tbdKetQuaXuLy04/update/") + fiId, tbdKetQuaXuLy04, HttpMethod.POST, null, TbdKetQuaXuLy04.class);
		return ResponseEntity.ok().body(tbdKetQuaXuLy04);
	}

	/**
	* @param fiId - Type: Long
	* @return may can throw new Execption
	*/
	@RequestMapping(value = "/delete/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbdKetQuaXuLy04> deleteTbdKetQuaXuLy04(@PathVariable("fiId") Long fiId) {
		TbdKetQuaXuLy04 tbdKetQuaXuLy04 = createRestTemplate(getURL("/mic/04/tbdKetQuaXuLy04/delete/") + fiId, null, HttpMethod.GET, null, TbdKetQuaXuLy04.class);
		return ResponseEntity.ok().body(tbdKetQuaXuLy04);
	}

	/**
	* @param fiId - Type: Long
	* @return may can null
	*/
	@RequestMapping(value = "/get/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbdKetQuaXuLy04> getTbdKetQuaXuLy04(@PathVariable("fiId") Long fiId) {
		TbdKetQuaXuLy04 tbdKetQuaXuLy04 = createRestTemplate(getURL("/mic/04/tbdKetQuaXuLy04/get/") + fiId, null, HttpMethod.GET, null, TbdKetQuaXuLy04.class);
		return ResponseEntity.ok().body(tbdKetQuaXuLy04);
	}

	/**
	* @param pageableDTO - Type: PageableDTO
	* @return may can null
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findAll", method = RequestMethod.POST)
	public ResponseEntity<List<TbdKetQuaXuLy04>> findAllTbdKetQuaXuLy04(@RequestBody @Valid PageableDTO pageableDTO) {

		List<TbdKetQuaXuLy04> tbdKetQuaXuLy04List = createRestTemplate(getURL("/mic/04/tbdKetQuaXuLy04/findAll"), pageableDTO, HttpMethod.POST, null, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdKetQuaXuLy04List = mapper.convertValue(tbdKetQuaXuLy04List, new TypeReference<List<TbdKetQuaXuLy04>>() {});

		return ResponseEntity.ok().body(tbdKetQuaXuLy04List);
	}

	/**
	* @param fiIdHoSo - Type: Long
	* @return can return null or throw exception
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/page", method = RequestMethod.POST)
	public ResponseEntity<ResponseJson> page(@RequestBody @Valid PageableDTO pageableDTO, @RequestParam(name = "fiIdHoSo", required = false) Long fiIdHoSo) {
		Map<String, Object> params = new HashMap<>();
		params.put("fiIdHoSo", fiIdHoSo);
		com.nsw.mic.p04.model.Page<KetQuaXuLy04DTO> page = createRestTemplate(getURL("/mic/04/tbdKetQuaXuLy04/page"), pageableDTO, HttpMethod.POST, params, com.nsw.mic.p04.model.Page.class);
		ObjectMapper mapper = new ObjectMapper();
		ResponseJson responseJson = new ResponseJson();
		responseJson.setSuccess(true);
		responseJson.setData(page);
		return ResponseEntity.ok().body(responseJson);

	}
	


}
