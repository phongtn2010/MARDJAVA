package com.nsw.mard.p14.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.mard.p14.model.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.nsw.mard.p14.model.KetQuaXuLy14DTO;
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
* @class Mard14TbdKetQuaXuLy14Resource
* Created by Nguyen Van Quang
* 11/12/2018 10:07:11
*
*/
@RestController
@RequestMapping("/mard/14/tbdKetQuaXuLy14")
public class Mard14TbdKetQuaXuLy14Resource extends Mard14CallBack {

	/**
	* @param tbdKetQuaXuLy14 - Type: TbdKetQuaXuLy14
	* @return may can null
	*/
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<TbdKetQuaXuLy14> createTbdKetQuaXuLy14(@RequestBody @Valid TbdKetQuaXuLy14 tbdKetQuaXuLy14) {
		tbdKetQuaXuLy14 = createRestTemplate(getURL("/mard/14/tbdKetQuaXuLy14/create"), tbdKetQuaXuLy14, HttpMethod.POST, null, TbdKetQuaXuLy14.class);
		return ResponseEntity.ok().body(tbdKetQuaXuLy14);
	}

	/**
	* @param fiId - Type: Long
	* @param tbdKetQuaXuLy14 - Type: TbdKetQuaXuLy14
	* @return may can null
	*/
	@RequestMapping(value = "/update/{fiId}", method = RequestMethod.POST)
	public ResponseEntity<TbdKetQuaXuLy14> updateTbdKetQuaXuLy14(@PathVariable("fiId") Long fiId, @RequestBody @Valid TbdKetQuaXuLy14 tbdKetQuaXuLy14) {
		tbdKetQuaXuLy14 = createRestTemplate(getURL("/mard/14/tbdKetQuaXuLy14/update/") + fiId, tbdKetQuaXuLy14, HttpMethod.POST, null, TbdKetQuaXuLy14.class);
		return ResponseEntity.ok().body(tbdKetQuaXuLy14);
	}

	/**
	* @param fiId - Type: Long
	* @return may can throw new Execption
	*/
	@RequestMapping(value = "/delete/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbdKetQuaXuLy14> deleteTbdKetQuaXuLy14(@PathVariable("fiId") Long fiId) {
		TbdKetQuaXuLy14 tbdKetQuaXuLy14 = createRestTemplate(getURL("/mard/14/tbdKetQuaXuLy14/delete/") + fiId, null, HttpMethod.GET, null, TbdKetQuaXuLy14.class);
		return ResponseEntity.ok().body(tbdKetQuaXuLy14);
	}

	/**
	* @param fiId - Type: Long
	* @return may can null
	*/
	@RequestMapping(value = "/get/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbdKetQuaXuLy14> getTbdKetQuaXuLy14(@PathVariable("fiId") Long fiId) {
		TbdKetQuaXuLy14 tbdKetQuaXuLy14 = createRestTemplate(getURL("/mard/14/tbdKetQuaXuLy14/get/") + fiId, null, HttpMethod.GET, null, TbdKetQuaXuLy14.class);
		return ResponseEntity.ok().body(tbdKetQuaXuLy14);
	}

	/**
	* @param pageableDTO - Type: PageableDTO
	* @return may can null
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findAll", method = RequestMethod.POST)
	public ResponseEntity<List<TbdKetQuaXuLy14>> findAllTbdKetQuaXuLy14(@RequestBody @Valid PageableDTO pageableDTO) {

		List<TbdKetQuaXuLy14> tbdKetQuaXuLy14List = createRestTemplate(getURL("/mard/14/tbdKetQuaXuLy14/findAll"), pageableDTO, HttpMethod.POST, null, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdKetQuaXuLy14List = mapper.convertValue(tbdKetQuaXuLy14List, new TypeReference<List<TbdKetQuaXuLy14>>() {});

		return ResponseEntity.ok().body(tbdKetQuaXuLy14List);
	}

	/**
	* @param fiIdHoSo - Type: Long
	* @return can return null or throw exception
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/page", method = RequestMethod.POST)
	public ResponseEntity<Page<KetQuaXuLy14DTO>> page(@RequestBody @Valid PageableDTO pageableDTO, @RequestParam(name = "fiIdHoSo", required = false) Long fiIdHoSo) {
		Map<String, Object> params = new HashMap<>();
		params.put("fiIdHoSo", fiIdHoSo);
		com.nsw.mard.p14.model.Page<KetQuaXuLy14DTO> page = createRestTemplate(getURL("/mard/14/tbdKetQuaXuLy14/page"), pageableDTO, HttpMethod.POST, params, com.nsw.mard.p14.model.Page.class);
		ObjectMapper mapper = new ObjectMapper();
		List<KetQuaXuLy14DTO> ketQuaXuLy14DTOList = mapper.convertValue(page.getContent(), new TypeReference<List<KetQuaXuLy14DTO>>() {});
		page.setContent(ketQuaXuLy14DTOList);
		return ResponseEntity.ok().body(page);

	}
	


}