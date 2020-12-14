package com.nsw.mard.p19.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.mard.p19.model.PageableDTO;
import com.nsw.mard.p19.model.TbdTBKetQuaThuoc19;

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
* @class Mard19TbdGPThuoc19Resource
* Created by Nguyen Van Quang
* 11/12/2019 10:06:57
*
*/
@RestController
@RequestMapping("/mard/19/tbdGPThuoc19")
public class Mard19TbdTBKetQuaThuoc19Resource extends Mard19CallBack {

	/**
	* @param tbdTBKetQuaThuoc19 - Type: TbdGPThuoc19
	* @return may can null
	*/
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<TbdTBKetQuaThuoc19> createTbdGPThuoc19(@RequestBody @Valid TbdTBKetQuaThuoc19 tbdTBKetQuaThuoc19) {
		tbdTBKetQuaThuoc19 = createRestTemplate(getURL("/mard/18/tbdGPThuoc18/create"), tbdTBKetQuaThuoc19, HttpMethod.POST, null, TbdTBKetQuaThuoc19.class);
		return ResponseEntity.ok().body(tbdTBKetQuaThuoc19);
	}

	/**
	* @param fiId - Type: Long
	* @param tbdTBKetQuaThuoc19 - Type: TbdGPThuoc19
	* @return may can null
	*/
	@RequestMapping(value = "/update/{fiId}", method = RequestMethod.POST)
	public ResponseEntity<TbdTBKetQuaThuoc19> updateTbdGPThuoc19(@PathVariable("fiId") Long fiId, @RequestBody @Valid TbdTBKetQuaThuoc19 tbdTBKetQuaThuoc19) {
		tbdTBKetQuaThuoc19 = createRestTemplate(getURL("/mard/18/tbdGPThuoc18/update/") + fiId, tbdTBKetQuaThuoc19, HttpMethod.POST, null, TbdTBKetQuaThuoc19.class);
		return ResponseEntity.ok().body(tbdTBKetQuaThuoc19);
	}

	/**
	* @param fiId - Type: Long
	* @return may can throw new Execption
	*/
	@RequestMapping(value = "/delete/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbdTBKetQuaThuoc19> deleteTbdGPThuoc19(@PathVariable("fiId") Long fiId) {
		TbdTBKetQuaThuoc19 tbdTBKetQuaThuoc19 = createRestTemplate(getURL("/mard/18/tbdGPThuoc18/delete/") + fiId, null, HttpMethod.GET, null, TbdTBKetQuaThuoc19.class);
		return ResponseEntity.ok().body(tbdTBKetQuaThuoc19);
	}

	/**
	* @param fiId - Type: Long
	* @return may can null
	*/
	@RequestMapping(value = "/get/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbdTBKetQuaThuoc19> getTbdGPThuoc19(@PathVariable("fiId") Long fiId) {
		TbdTBKetQuaThuoc19 tbdTBKetQuaThuoc19 = createRestTemplate(getURL("/mard/18/tbdGPThuoc18/get/") + fiId, null, HttpMethod.GET, null, TbdTBKetQuaThuoc19.class);
		return ResponseEntity.ok().body(tbdTBKetQuaThuoc19);
	}

	/**
	* @param pageableDTO - Type: PageableDTO
	* @return may can null
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findAll", method = RequestMethod.POST)
	public ResponseEntity<List<TbdTBKetQuaThuoc19>> findAllTbdGPThuoc19(@RequestBody @Valid PageableDTO pageableDTO) {

		List<TbdTBKetQuaThuoc19> tbdTBKetQuaThuoc19List = createRestTemplate(getURL("/mard/18/tbdGPThuoc18/findAll"), pageableDTO, HttpMethod.POST, null, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdTBKetQuaThuoc19List = mapper.convertValue(tbdTBKetQuaThuoc19List, new TypeReference<List<TbdTBKetQuaThuoc19>>() {});

		return ResponseEntity.ok().body(tbdTBKetQuaThuoc19List);
	}

	/**
	* @param fiIdHoSo - Type: Long
	* @return can return null or throw exception
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findByFiIdHoSo", method = RequestMethod.GET)
	public ResponseEntity<List<TbdTBKetQuaThuoc19>> findByFiIdHoSo(@RequestParam(name = "fiIdHoSo", required = false) Long fiIdHoSo) {

		Map<String, Object> params = new HashMap<>();
		params.put("fiIdHoSo", fiIdHoSo);
		List<TbdTBKetQuaThuoc19> tbdTBKetQuaThuoc19List = createRestTemplate(getURL("/mard/18/tbdTBKetQuaThuoc/findByFiIdHoSo"), null, HttpMethod.GET, params, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdTBKetQuaThuoc19List = mapper.convertValue(tbdTBKetQuaThuoc19List, new TypeReference<List<TbdTBKetQuaThuoc19>>() {});

		return ResponseEntity.ok().body(tbdTBKetQuaThuoc19List);
	}


}
