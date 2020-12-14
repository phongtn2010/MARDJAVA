package com.nsw.mard.p17.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.mard.p17.model.PageableDTO;
import com.nsw.mard.p17.model.TbsTepDinhKem17;

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
* @class Mard17TbsTepDinhKem17Resource
* Created by Nguyen Van Quang
* 11/12/2018 10:08:172
*
*/
@RestController
@RequestMapping("/mard/17/tbsTepDinhKem17")
public class Mard17TbsTepDinhKem17Resource extends Mard17CallBack {

	/**
	* @param tbsTepDinhKem17 - Type: TbsTepDinhKem17
	* @return may can null
	*/
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<TbsTepDinhKem17> createTbsTepDinhKem17(@RequestBody @Valid TbsTepDinhKem17 tbsTepDinhKem17) {
		tbsTepDinhKem17 = createRestTemplate(getURL("/mard/17/tbsTepDinhKem17/create"), tbsTepDinhKem17, HttpMethod.POST, null, TbsTepDinhKem17.class);
		return ResponseEntity.ok().body(tbsTepDinhKem17);
	}

	/**
	* @param tepDinhKemId - Type: Long
	* @param tbsTepDinhKem17 - Type: TbsTepDinhKem17
	* @return may can null
	*/
	@RequestMapping(value = "/update/{tepDinhKemId}", method = RequestMethod.POST)
	public ResponseEntity<TbsTepDinhKem17> updateTbsTepDinhKem17(@PathVariable("tepDinhKemId") Long tepDinhKemId, @RequestBody @Valid TbsTepDinhKem17 tbsTepDinhKem17) {
		tbsTepDinhKem17 = createRestTemplate(getURL("/mard/17/tbsTepDinhKem17/update/") + tepDinhKemId, tbsTepDinhKem17, HttpMethod.POST, null, TbsTepDinhKem17.class);
		return ResponseEntity.ok().body(tbsTepDinhKem17);
	}

	/**
	* @param tepDinhKemId - Type: Long
	* @return may can throw new Execption
	*/
	@RequestMapping(value = "/delete/{tepDinhKemId}", method = RequestMethod.GET)
	public ResponseEntity<TbsTepDinhKem17> deleteTbsTepDinhKem17(@PathVariable("tepDinhKemId") Long tepDinhKemId) {
		TbsTepDinhKem17 tbsTepDinhKem17 = createRestTemplate(getURL("/mard/17/tbsTepDinhKem17/delete/") + tepDinhKemId, null, HttpMethod.GET, null, TbsTepDinhKem17.class);
		return ResponseEntity.ok().body(tbsTepDinhKem17);
	}

	/**
	* @param tepDinhKemId - Type: Long
	* @return may can null
	*/
	@RequestMapping(value = "/get/{tepDinhKemId}", method = RequestMethod.GET)
	public ResponseEntity<TbsTepDinhKem17> getTbsTepDinhKem17(@PathVariable("tepDinhKemId") Long tepDinhKemId) {
		TbsTepDinhKem17 tbsTepDinhKem17 = createRestTemplate(getURL("/mard/17/tbsTepDinhKem17/get/") + tepDinhKemId, null, HttpMethod.GET, null, TbsTepDinhKem17.class);
		return ResponseEntity.ok().body(tbsTepDinhKem17);
	}

	/**
	* @param pageableDTO - Type: PageableDTO
	* @return may can null
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findAll", method = RequestMethod.POST)
	public ResponseEntity<List<TbsTepDinhKem17>> findAllTbsTepDinhKem17(@RequestBody @Valid PageableDTO pageableDTO) {

		List<TbsTepDinhKem17> tbsTepDinhKem17List = createRestTemplate(getURL("/mard/17/tbsTepDinhKem17/findAll"), pageableDTO, HttpMethod.POST, null, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbsTepDinhKem17List = mapper.convertValue(tbsTepDinhKem17List, new TypeReference<List<TbsTepDinhKem17>>() {});

		return ResponseEntity.ok().body(tbsTepDinhKem17List);
	}

	/**
	* @param loaiThuTuc - Type: String
	* @return can return null or throw exception
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findByLoaiThuTuc", method = RequestMethod.GET)
	public ResponseEntity<List<TbsTepDinhKem17>> findByLoaiThuTucOrderByFiSortAsc(@RequestParam(name = "loaiThuTuc", required = false) String loaiThuTuc) {

		Map<String, Object> params = new HashMap<>();
		params.put("loaiThuTuc", loaiThuTuc);
		List<TbsTepDinhKem17> tbsTepDinhKem17List = createRestTemplate(getURL("/mard/17/tbsTepDinhKem17/findByLoaiThuTuc"), null, HttpMethod.GET, params, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbsTepDinhKem17List = mapper.convertValue(tbsTepDinhKem17List, new TypeReference<List<TbsTepDinhKem17>>() {});

		return ResponseEntity.ok().body(tbsTepDinhKem17List);
	}


}
