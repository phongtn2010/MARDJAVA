package com.nsw.mard.p14.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.mard.p14.model.PageableDTO;
import com.nsw.mard.p14.model.TbsTepDinhKem14;

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
* @class Mard14TbsTepDinhKem14Resource
* Created by Nguyen Van Quang
* 11/12/2018 10:08:142
*
*/
@RestController
@RequestMapping("/mard/14/tbsTepDinhKem14")
public class Mard14TbsTepDinhKem14Resource extends Mard14CallBack {

	/**
	* @param tbsTepDinhKem14 - Type: TbsTepDinhKem14
	* @return may can null
	*/
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<TbsTepDinhKem14> createTbsTepDinhKem14(@RequestBody @Valid TbsTepDinhKem14 tbsTepDinhKem14) {
		tbsTepDinhKem14 = createRestTemplate(getURL("/mard/14/tbsTepDinhKem14/create"), tbsTepDinhKem14, HttpMethod.POST, null, TbsTepDinhKem14.class);
		return ResponseEntity.ok().body(tbsTepDinhKem14);
	}

	/**
	* @param tepDinhKemId - Type: Long
	* @param tbsTepDinhKem14 - Type: TbsTepDinhKem14
	* @return may can null
	*/
	@RequestMapping(value = "/update/{tepDinhKemId}", method = RequestMethod.POST)
	public ResponseEntity<TbsTepDinhKem14> updateTbsTepDinhKem14(@PathVariable("tepDinhKemId") Long tepDinhKemId, @RequestBody @Valid TbsTepDinhKem14 tbsTepDinhKem14) {
		tbsTepDinhKem14 = createRestTemplate(getURL("/mard/14/tbsTepDinhKem14/update/") + tepDinhKemId, tbsTepDinhKem14, HttpMethod.POST, null, TbsTepDinhKem14.class);
		return ResponseEntity.ok().body(tbsTepDinhKem14);
	}

	/**
	* @param tepDinhKemId - Type: Long
	* @return may can throw new Execption
	*/
	@RequestMapping(value = "/delete/{tepDinhKemId}", method = RequestMethod.GET)
	public ResponseEntity<TbsTepDinhKem14> deleteTbsTepDinhKem14(@PathVariable("tepDinhKemId") Long tepDinhKemId) {
		TbsTepDinhKem14 tbsTepDinhKem14 = createRestTemplate(getURL("/mard/14/tbsTepDinhKem14/delete/") + tepDinhKemId, null, HttpMethod.GET, null, TbsTepDinhKem14.class);
		return ResponseEntity.ok().body(tbsTepDinhKem14);
	}

	/**
	* @param tepDinhKemId - Type: Long
	* @return may can null
	*/
	@RequestMapping(value = "/get/{tepDinhKemId}", method = RequestMethod.GET)
	public ResponseEntity<TbsTepDinhKem14> getTbsTepDinhKem14(@PathVariable("tepDinhKemId") Long tepDinhKemId) {
		TbsTepDinhKem14 tbsTepDinhKem14 = createRestTemplate(getURL("/mard/14/tbsTepDinhKem14/get/") + tepDinhKemId, null, HttpMethod.GET, null, TbsTepDinhKem14.class);
		return ResponseEntity.ok().body(tbsTepDinhKem14);
	}

	/**
	* @param pageableDTO - Type: PageableDTO
	* @return may can null
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findAll", method = RequestMethod.POST)
	public ResponseEntity<List<TbsTepDinhKem14>> findAllTbsTepDinhKem14(@RequestBody @Valid PageableDTO pageableDTO) {

		List<TbsTepDinhKem14> tbsTepDinhKem14List = createRestTemplate(getURL("/mard/14/tbsTepDinhKem14/findAll"), pageableDTO, HttpMethod.POST, null, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbsTepDinhKem14List = mapper.convertValue(tbsTepDinhKem14List, new TypeReference<List<TbsTepDinhKem14>>() {});

		return ResponseEntity.ok().body(tbsTepDinhKem14List);
	}

	/**
	* @param loaiThuTuc - Type: String
	* @return can return null or throw exception
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findByLoaiThuTuc", method = RequestMethod.GET)
	public ResponseEntity<List<TbsTepDinhKem14>> findByLoaiThuTucOrderByFiSortAsc(@RequestParam(name = "loaiThuTuc", required = false) String loaiThuTuc) {

		Map<String, Object> params = new HashMap<>();
		params.put("loaiThuTuc", loaiThuTuc);
		List<TbsTepDinhKem14> tbsTepDinhKem14List = createRestTemplate(getURL("/mard/14/tbsTepDinhKem14/findByLoaiThuTuc"), null, HttpMethod.GET, params, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbsTepDinhKem14List = mapper.convertValue(tbsTepDinhKem14List, new TypeReference<List<TbsTepDinhKem14>>() {});

		return ResponseEntity.ok().body(tbsTepDinhKem14List);
	}


}