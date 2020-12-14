package com.nsw.mard.p19.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.mard.p19.model.PageableDTO;
import com.nsw.mard.p19.model.TbdThongBaoKetQua19;

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
* @class Mard19TbdGiayPhep19Resource
* Created by Nguyen Van Quang
* 11/12/2019 10:06:22
*
*/
@RestController
@RequestMapping("/mard/19/tbdGiayPhep19")
public class Mard19TbdThongBaoKetQua19Resource extends Mard19CallBack {

	/**
	* @param tbdThongBaoKetQua19 - Type: TbdGiayPhep19
	* @return may can null
	*/
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<TbdThongBaoKetQua19> createTbdGiayPhep19(@RequestBody @Valid TbdThongBaoKetQua19 tbdThongBaoKetQua19) {
		tbdThongBaoKetQua19 = createRestTemplate(getURL("/mard/18/tbdGiayPhep18/create"), tbdThongBaoKetQua19, HttpMethod.POST, null, TbdThongBaoKetQua19.class);
		return ResponseEntity.ok().body(tbdThongBaoKetQua19);
	}

	/**
	* @param fiId - Type: Long
	* @param tbdThongBaoKetQua19 - Type: TbdGiayPhep19
	* @return may can null
	*/
	@RequestMapping(value = "/update/{fiId}", method = RequestMethod.POST)
	public ResponseEntity<TbdThongBaoKetQua19> updateTbdGiayPhep19(@PathVariable("fiId") Long fiId, @RequestBody @Valid TbdThongBaoKetQua19 tbdThongBaoKetQua19) {
		tbdThongBaoKetQua19 = createRestTemplate(getURL("/mard/18/tbdGiayPhep18/update/") + fiId, tbdThongBaoKetQua19, HttpMethod.POST, null, TbdThongBaoKetQua19.class);
		return ResponseEntity.ok().body(tbdThongBaoKetQua19);
	}

	/**
	* @param fiId - Type: Long
	* @return may can throw new Execption
	*/
	@RequestMapping(value = "/delete/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbdThongBaoKetQua19> deleteTbdGiayPhep19(@PathVariable("fiId") Long fiId) {
		TbdThongBaoKetQua19 tbdThongBaoKetQua19 = createRestTemplate(getURL("/mard/18/tbdGiayPhep18/delete/") + fiId, null, HttpMethod.GET, null, TbdThongBaoKetQua19.class);
		return ResponseEntity.ok().body(tbdThongBaoKetQua19);
	}

	/**
	* @param fiId - Type: Long
	* @return may can null
	*/
	@RequestMapping(value = "/get/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbdThongBaoKetQua19> getTbdGiayPhep19(@PathVariable("fiId") Long fiId) {
		TbdThongBaoKetQua19 tbdThongBaoKetQua19 = createRestTemplate(getURL("/mard/18/tbdGiayPhep18/get/") + fiId, null, HttpMethod.GET, null, TbdThongBaoKetQua19.class);
		return ResponseEntity.ok().body(tbdThongBaoKetQua19);
	}

	/**
	* @param pageableDTO - Type: PageableDTO
	* @return may can null
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findAll", method = RequestMethod.POST)
	public ResponseEntity<List<TbdThongBaoKetQua19>> findAllTbdGiayPhep19(@RequestBody @Valid PageableDTO pageableDTO) {

		List<TbdThongBaoKetQua19> tbdThongBaoKetQua19List = createRestTemplate(getURL("/mard/18/tbdGiayPhep18/findAll"), pageableDTO, HttpMethod.POST, null, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdThongBaoKetQua19List = mapper.convertValue(tbdThongBaoKetQua19List, new TypeReference<List<TbdThongBaoKetQua19>>() {});

		return ResponseEntity.ok().body(tbdThongBaoKetQua19List);
	}

	/**
	* @param fiIdHoSo - Type: Long
	* @return can return null or throw exception
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findByFiIdHoSo", method = RequestMethod.GET)
	public ResponseEntity<List<TbdThongBaoKetQua19>> findByFiIdHoSo(@RequestParam(name = "fiIdHoSo", required = false) Long fiIdHoSo) {

		Map<String, Object> params = new HashMap<>();
		params.put("fiIdHoSo", fiIdHoSo);
		List<TbdThongBaoKetQua19> tbdThongBaoKetQua19List = createRestTemplate(getURL("/mard/18/tbdGiayPhep18/findByFiIdHoSo"), null, HttpMethod.GET, params, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdThongBaoKetQua19List = mapper.convertValue(tbdThongBaoKetQua19List, new TypeReference<List<TbdThongBaoKetQua19>>() {});

		return ResponseEntity.ok().body(tbdThongBaoKetQua19List);
	}

	/**
	* @param fiDispatchNo - Type: String
	* @return can return null or throw exception
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findByFiDispatchNo", method = RequestMethod.GET)
	public ResponseEntity<List<TbdThongBaoKetQua19>> findByFiDispatchNo(@RequestParam(name = "fiDispatchNo", required = false) String fiDispatchNo) {

		Map<String, Object> params = new HashMap<>();
		params.put("fiDispatchNo", fiDispatchNo);
		List<TbdThongBaoKetQua19> tbdThongBaoKetQua19List = createRestTemplate(getURL("/mard/18/tbdGiayPhep18/findByFiDispatchNo"), null, HttpMethod.GET, params, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdThongBaoKetQua19List = mapper.convertValue(tbdThongBaoKetQua19List, new TypeReference<List<TbdThongBaoKetQua19>>() {});

		return ResponseEntity.ok().body(tbdThongBaoKetQua19List);
	}


}
