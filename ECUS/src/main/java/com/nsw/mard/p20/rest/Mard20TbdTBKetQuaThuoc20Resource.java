package com.nsw.mard.p20.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.mard.p20.model.PageableDTO;
import com.nsw.mard.p20.model.TbdTBKetQuaThuoc20;

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
* @class Mard20TbdGPThuoc20Resource
* Created by Nguyen Van Quang
* 11/12/2020 10:06:57
*
*/
@RestController
@RequestMapping("/mard/20/tbdGPThuoc20")
public class Mard20TbdTBKetQuaThuoc20Resource extends Mard20CallBack {

	/**
	* @param tbdTBKetQuaThuoc20 - Type: TbdGPThuoc20
	* @return may can null
	*/
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<TbdTBKetQuaThuoc20> createTbdGPThuoc20(@RequestBody @Valid TbdTBKetQuaThuoc20 tbdTBKetQuaThuoc20) {
		tbdTBKetQuaThuoc20 = createRestTemplate(getURL("/mard/18/tbdTBKetQuaThuoc/create"), tbdTBKetQuaThuoc20, HttpMethod.POST, null, TbdTBKetQuaThuoc20.class);
		return ResponseEntity.ok().body(tbdTBKetQuaThuoc20);
	}

	/**
	* @param fiId - Type: Long
	* @param tbdTBKetQuaThuoc20 - Type: TbdGPThuoc20
	* @return may can null
	*/
	@RequestMapping(value = "/update/{fiId}", method = RequestMethod.POST)
	public ResponseEntity<TbdTBKetQuaThuoc20> updateTbdGPThuoc20(@PathVariable("fiId") Long fiId, @RequestBody @Valid TbdTBKetQuaThuoc20 tbdTBKetQuaThuoc20) {
		tbdTBKetQuaThuoc20 = createRestTemplate(getURL("/mard/18/tbdTBKetQuaThuoc/update/") + fiId, tbdTBKetQuaThuoc20, HttpMethod.POST, null, TbdTBKetQuaThuoc20.class);
		return ResponseEntity.ok().body(tbdTBKetQuaThuoc20);
	}

	/**
	* @param fiId - Type: Long
	* @return may can throw new Execption
	*/
	@RequestMapping(value = "/delete/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbdTBKetQuaThuoc20> deleteTbdGPThuoc20(@PathVariable("fiId") Long fiId) {
		TbdTBKetQuaThuoc20 tbdTBKetQuaThuoc20 = createRestTemplate(getURL("/mard/18/tbdTBKetQuaThuoc/delete/") + fiId, null, HttpMethod.GET, null, TbdTBKetQuaThuoc20.class);
		return ResponseEntity.ok().body(tbdTBKetQuaThuoc20);
	}

	/**
	* @param fiId - Type: Long
	* @return may can null
	*/
	@RequestMapping(value = "/get/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbdTBKetQuaThuoc20> getTbdGPThuoc20(@PathVariable("fiId") Long fiId) {
		TbdTBKetQuaThuoc20 tbdTBKetQuaThuoc20 = createRestTemplate(getURL("/mard/18/tbdTBKetQuaThuoc/get/") + fiId, null, HttpMethod.GET, null, TbdTBKetQuaThuoc20.class);
		return ResponseEntity.ok().body(tbdTBKetQuaThuoc20);
	}

	/**
	* @param pageableDTO - Type: PageableDTO
	* @return may can null
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findAll", method = RequestMethod.POST)
	public ResponseEntity<List<TbdTBKetQuaThuoc20>> findAllTbdGPThuoc20(@RequestBody @Valid PageableDTO pageableDTO) {

		List<TbdTBKetQuaThuoc20> tbdTBKetQuaThuoc20List = createRestTemplate(getURL("/mard/18/tbdTBKetQuaThuoc/findAll"), pageableDTO, HttpMethod.POST, null, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdTBKetQuaThuoc20List = mapper.convertValue(tbdTBKetQuaThuoc20List, new TypeReference<List<TbdTBKetQuaThuoc20>>() {});

		return ResponseEntity.ok().body(tbdTBKetQuaThuoc20List);
	}

	/**
	* @param fiIdHoSo - Type: Long
	* @return can return null or throw exception
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findByFiIdHoSo", method = RequestMethod.GET)
	public ResponseEntity<List<TbdTBKetQuaThuoc20>> findByFiIdHoSo(@RequestParam(name = "fiIdHoSo", required = false) Long fiIdHoSo) {

		Map<String, Object> params = new HashMap<>();
		params.put("fiIdHoSo", fiIdHoSo);
		List<TbdTBKetQuaThuoc20> tbdTBKetQuaThuoc20List = createRestTemplate(getURL("/mard/18/tbdTBKetQuaThuoc/findByFiIdHoSo"), null, HttpMethod.GET, params, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdTBKetQuaThuoc20List = mapper.convertValue(tbdTBKetQuaThuoc20List, new TypeReference<List<TbdTBKetQuaThuoc20>>() {});

		return ResponseEntity.ok().body(tbdTBKetQuaThuoc20List);
	}


}
