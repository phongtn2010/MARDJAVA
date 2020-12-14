package com.nsw.mard.p18.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.mard.p18.model.PageableDTO;
import com.nsw.mard.p18.model.TbdTBKetQuaThuoc18;

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
* @class Mard18TbdGPThuoc18Resource
* Created by Nguyen Van Quang
* 11/12/2018 10:06:57
*
*/
@RestController
@RequestMapping("/mard/18/tbdTBKetQuaThuoc")
public class Mard18TbdTBKetQuaThuoc18Resource extends Mard18CallBack {

	/**
	* @param tbdTBKetQuaThuoc18 - Type: TbdGPThuoc18
	* @return may can null
	*/
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<TbdTBKetQuaThuoc18> createTbdGPThuoc18(@RequestBody @Valid TbdTBKetQuaThuoc18 tbdTBKetQuaThuoc18) {
		tbdTBKetQuaThuoc18 = createRestTemplate(getURL("/mard/18/tbdTBKetQuaThuoc/create"), tbdTBKetQuaThuoc18, HttpMethod.POST, null, TbdTBKetQuaThuoc18.class);
		return ResponseEntity.ok().body(tbdTBKetQuaThuoc18);
	}

	/**
	* @param fiId - Type: Long
	* @param tbdTBKetQuaThuoc18 - Type: TbdGPThuoc18
	* @return may can null
	*/
	@RequestMapping(value = "/update/{fiId}", method = RequestMethod.POST)
	public ResponseEntity<TbdTBKetQuaThuoc18> updateTbdGPThuoc18(@PathVariable("fiId") Long fiId, @RequestBody @Valid TbdTBKetQuaThuoc18 tbdTBKetQuaThuoc18) {
		tbdTBKetQuaThuoc18 = createRestTemplate(getURL("/mard/18/tbdTBKetQuaThuoc/update/") + fiId, tbdTBKetQuaThuoc18, HttpMethod.POST, null, TbdTBKetQuaThuoc18.class);
		return ResponseEntity.ok().body(tbdTBKetQuaThuoc18);
	}

	/**
	* @param fiId - Type: Long
	* @return may can throw new Execption
	*/
	@RequestMapping(value = "/delete/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbdTBKetQuaThuoc18> deleteTbdGPThuoc18(@PathVariable("fiId") Long fiId) {
		TbdTBKetQuaThuoc18 tbdTBKetQuaThuoc18 = createRestTemplate(getURL("/mard/18/tbdTBKetQuaThuoc/delete/") + fiId, null, HttpMethod.GET, null, TbdTBKetQuaThuoc18.class);
		return ResponseEntity.ok().body(tbdTBKetQuaThuoc18);
	}

	/**
	* @param fiId - Type: Long
	* @return may can null
	*/
	@RequestMapping(value = "/get/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbdTBKetQuaThuoc18> getTbdGPThuoc18(@PathVariable("fiId") Long fiId) {
		TbdTBKetQuaThuoc18 tbdTBKetQuaThuoc18 = createRestTemplate(getURL("/mard/18/tbdTBKetQuaThuoc/get/") + fiId, null, HttpMethod.GET, null, TbdTBKetQuaThuoc18.class);
		return ResponseEntity.ok().body(tbdTBKetQuaThuoc18);
	}

	/**
	* @param pageableDTO - Type: PageableDTO
	* @return may can null
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findAll", method = RequestMethod.POST)
	public ResponseEntity<List<TbdTBKetQuaThuoc18>> findAllTbdGPThuoc18(@RequestBody @Valid PageableDTO pageableDTO) {

		List<TbdTBKetQuaThuoc18> tbdTBKetQuaThuoc18List = createRestTemplate(getURL("/mard/18/tbdTBKetQuaThuoc/findAll"), pageableDTO, HttpMethod.POST, null, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdTBKetQuaThuoc18List = mapper.convertValue(tbdTBKetQuaThuoc18List, new TypeReference<List<TbdTBKetQuaThuoc18>>() {});

		return ResponseEntity.ok().body(tbdTBKetQuaThuoc18List);
	}

	/**
	* @param fiIdHoSo - Type: Long
	* @return can return null or throw exception
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findByFiIdHoSo", method = RequestMethod.GET)
	public ResponseEntity<List<TbdTBKetQuaThuoc18>> findByFiIdHoSo(@RequestParam(name = "fiIdHoSo", required = false) Long fiIdHoSo) {

		Map<String, Object> params = new HashMap<>();
		params.put("fiIdHoSo", fiIdHoSo);
		List<TbdTBKetQuaThuoc18> tbdTBKetQuaThuoc18List = createRestTemplate(getURL("/mard/18/tbdTBKetQuaThuoc/findByFiIdHoSo"), null, HttpMethod.GET, params, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdTBKetQuaThuoc18List = mapper.convertValue(tbdTBKetQuaThuoc18List, new TypeReference<List<TbdTBKetQuaThuoc18>>() {});

		return ResponseEntity.ok().body(tbdTBKetQuaThuoc18List);
	}


}
