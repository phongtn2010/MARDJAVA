package com.nsw.mard.p16.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.mard.p16.model.KetQuaXuLy16DTO;
import com.nsw.mard.p16.model.Page;
import com.nsw.mard.p16.model.PageableDTO;
import com.nsw.mard.p16.model.ResponseJson16;
import com.nsw.mard.p16.model.TbdKetQuaXuLy16;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

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
* @class Mard16TbdKetQuaXuLy16Resource
* Created by Nguyen Van Quang
* 11/12/2018 10:07:11
*
*/
@RestController
@RequestMapping("/mard/16/tbdKetQuaXuLy16")
public class Mard16TbdKetQuaXuLy16Resource extends Mard16CallBack {

	/**
	* @param tbdKetQuaXuLy16 - Type: TbdKetQuaXuLy16
	* @return may can null
	*/
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<TbdKetQuaXuLy16> createTbdKetQuaXuLy16(@RequestBody @Valid TbdKetQuaXuLy16 tbdKetQuaXuLy16) {
		tbdKetQuaXuLy16 = createRestTemplate(getURL("/mard/16/tbdKetQuaXuLy16/create"), tbdKetQuaXuLy16, HttpMethod.POST, null, TbdKetQuaXuLy16.class);
		return ResponseEntity.ok().body(tbdKetQuaXuLy16);
	}

	/**
	* @param fiId - Type: Long
	* @param tbdKetQuaXuLy16 - Type: TbdKetQuaXuLy16
	* @return may can null
	*/
	@RequestMapping(value = "/update/{fiId}", method = RequestMethod.POST)
	public ResponseEntity<TbdKetQuaXuLy16> updateTbdKetQuaXuLy16(@PathVariable("fiId") Long fiId, @RequestBody @Valid TbdKetQuaXuLy16 tbdKetQuaXuLy16) {
		tbdKetQuaXuLy16 = createRestTemplate(getURL("/mard/16/tbdKetQuaXuLy16/update/") + fiId, tbdKetQuaXuLy16, HttpMethod.POST, null, TbdKetQuaXuLy16.class);
		return ResponseEntity.ok().body(tbdKetQuaXuLy16);
	}

	/**
	* @param fiId - Type: Long
	* @return may can throw new Execption
	*/
	@RequestMapping(value = "/delete/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbdKetQuaXuLy16> deleteTbdKetQuaXuLy16(@PathVariable("fiId") Long fiId) {
		TbdKetQuaXuLy16 tbdKetQuaXuLy16 = createRestTemplate(getURL("/mard/16/tbdKetQuaXuLy16/delete/") + fiId, null, HttpMethod.GET, null, TbdKetQuaXuLy16.class);
		return ResponseEntity.ok().body(tbdKetQuaXuLy16);
	}

	/**
	* @param fiId - Type: Long
	* @return may can null
	*/
	@RequestMapping(value = "/get/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbdKetQuaXuLy16> getTbdKetQuaXuLy16(@PathVariable("fiId") Long fiId) {
		TbdKetQuaXuLy16 tbdKetQuaXuLy16 = createRestTemplate(getURL("/mard/16/tbdKetQuaXuLy16/get/") + fiId, null, HttpMethod.GET, null, TbdKetQuaXuLy16.class);
		return ResponseEntity.ok().body(tbdKetQuaXuLy16);
	}

	/**
	* @param pageableDTO - Type: PageableDTO
	* @return may can null
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findAll", method = RequestMethod.POST)
	public ResponseEntity<List<TbdKetQuaXuLy16>> findAllTbdKetQuaXuLy16(@RequestBody @Valid PageableDTO pageableDTO) {

		List<TbdKetQuaXuLy16> tbdKetQuaXuLy16List = createRestTemplate(getURL("/mard/16/tbdKetQuaXuLy16/findAll"), pageableDTO, HttpMethod.POST, null, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdKetQuaXuLy16List = mapper.convertValue(tbdKetQuaXuLy16List, new TypeReference<List<TbdKetQuaXuLy16>>() {});

		return ResponseEntity.ok().body(tbdKetQuaXuLy16List);
	}

	/**
	* @param fiIdHoSo - Type: Long
	* @return can return null or throw exception
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/page", method = RequestMethod.POST)
	public ResponseEntity<Page<KetQuaXuLy16DTO>> page(@RequestBody PageableDTO pageableDTO, @RequestParam(name = "fiIdHoSo", required = false) Long fiIdHoSo) {
		Map<String, Object> params = new HashMap<>();
		params.put("fiIdHoSo", fiIdHoSo);
		Page<KetQuaXuLy16DTO> page = createRestTemplate(getURL("/mard/16/tbdKetQuaXuLy16/page"), pageableDTO, HttpMethod.POST, params, Page.class);
		ObjectMapper mapper = new ObjectMapper();
		List<KetQuaXuLy16DTO> ketQuaXuLy16DTOList = mapper.convertValue(page.getContent(), new TypeReference<List<KetQuaXuLy16DTO>>() {});
		page.setContent(ketQuaXuLy16DTOList);
		return ResponseEntity.ok().body(page);
		
	}
	


}