package com.nsw.mard.p20.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.mard.p20.model.PageableDTO;
import com.nsw.mard.p20.model.TbdThongBaoKetQua20;

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
* @class Mard20TbdGiayPhep20Resource
* Created by Nguyen Van Quang
* 11/12/2020 10:06:22
*
*/
@RestController
@RequestMapping("/mard/20/tbdGiayPhep20")
public class Mard20TbdThongBaoKetQua20Resource extends Mard20CallBack {

	/**
	* @param tbdThongBaoKetQua20 - Type: TbdGiayPhep20
	* @return may can null
	*/
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<TbdThongBaoKetQua20> createTbdGiayPhep20(@RequestBody @Valid TbdThongBaoKetQua20 tbdThongBaoKetQua20) {
		tbdThongBaoKetQua20 = createRestTemplate(getURL("/mard/18/tbdGiayPhep18/create"), tbdThongBaoKetQua20, HttpMethod.POST, null, TbdThongBaoKetQua20.class);
		return ResponseEntity.ok().body(tbdThongBaoKetQua20);
	}

	/**
	* @param fiId - Type: Long
	* @param tbdThongBaoKetQua20 - Type: TbdGiayPhep20
	* @return may can null
	*/
	@RequestMapping(value = "/update/{fiId}", method = RequestMethod.POST)
	public ResponseEntity<TbdThongBaoKetQua20> updateTbdGiayPhep20(@PathVariable("fiId") Long fiId, @RequestBody @Valid TbdThongBaoKetQua20 tbdThongBaoKetQua20) {
		tbdThongBaoKetQua20 = createRestTemplate(getURL("/mard/18/tbdGiayPhep18/update/") + fiId, tbdThongBaoKetQua20, HttpMethod.POST, null, TbdThongBaoKetQua20.class);
		return ResponseEntity.ok().body(tbdThongBaoKetQua20);
	}

	/**
	* @param fiId - Type: Long
	* @return may can throw new Execption
	*/
	@RequestMapping(value = "/delete/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbdThongBaoKetQua20> deleteTbdGiayPhep20(@PathVariable("fiId") Long fiId) {
		TbdThongBaoKetQua20 tbdThongBaoKetQua20 = createRestTemplate(getURL("/mard/18/tbdGiayPhep18/delete/") + fiId, null, HttpMethod.GET, null, TbdThongBaoKetQua20.class);
		return ResponseEntity.ok().body(tbdThongBaoKetQua20);
	}

	/**
	* @param fiId - Type: Long
	* @return may can null
	*/
	@RequestMapping(value = "/get/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbdThongBaoKetQua20> getTbdGiayPhep20(@PathVariable("fiId") Long fiId) {
		TbdThongBaoKetQua20 tbdThongBaoKetQua20 = createRestTemplate(getURL("/mard/18/tbdGiayPhep18/get/") + fiId, null, HttpMethod.GET, null, TbdThongBaoKetQua20.class);
		return ResponseEntity.ok().body(tbdThongBaoKetQua20);
	}

	/**
	* @param pageableDTO - Type: PageableDTO
	* @return may can null
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findAll", method = RequestMethod.POST)
	public ResponseEntity<List<TbdThongBaoKetQua20>> findAllTbdGiayPhep20(@RequestBody @Valid PageableDTO pageableDTO) {

		List<TbdThongBaoKetQua20> tbdThongBaoKetQua20List = createRestTemplate(getURL("/mard/18/tbdGiayPhep18/findAll"), pageableDTO, HttpMethod.POST, null, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdThongBaoKetQua20List = mapper.convertValue(tbdThongBaoKetQua20List, new TypeReference<List<TbdThongBaoKetQua20>>() {});

		return ResponseEntity.ok().body(tbdThongBaoKetQua20List);
	}

	/**
	* @param fiIdHoSo - Type: Long
	* @return can return null or throw exception
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findByFiIdHoSo", method = RequestMethod.GET)
	public ResponseEntity<List<TbdThongBaoKetQua20>> findByFiIdHoSo(@RequestParam(name = "fiIdHoSo", required = false) Long fiIdHoSo) {

		Map<String, Object> params = new HashMap<>();
		params.put("fiIdHoSo", fiIdHoSo);
		List<TbdThongBaoKetQua20> tbdThongBaoKetQua20List = createRestTemplate(getURL("/mard/18/tbdGiayPhep18/findByFiIdHoSo"), null, HttpMethod.GET, params, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdThongBaoKetQua20List = mapper.convertValue(tbdThongBaoKetQua20List, new TypeReference<List<TbdThongBaoKetQua20>>() {});

		return ResponseEntity.ok().body(tbdThongBaoKetQua20List);
	}

	/**
	* @param fiDispatchNo - Type: String
	* @return can return null or throw exception
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findByFiDispatchNo", method = RequestMethod.GET)
	public ResponseEntity<List<TbdThongBaoKetQua20>> findByFiDispatchNo(@RequestParam(name = "fiDispatchNo", required = false) String fiDispatchNo) {

		Map<String, Object> params = new HashMap<>();
		params.put("fiDispatchNo", fiDispatchNo);
		List<TbdThongBaoKetQua20> tbdThongBaoKetQua20List = createRestTemplate(getURL("/mard/18/tbdGiayPhep18/findByFiDispatchNo"), null, HttpMethod.GET, params, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdThongBaoKetQua20List = mapper.convertValue(tbdThongBaoKetQua20List, new TypeReference<List<TbdThongBaoKetQua20>>() {});

		return ResponseEntity.ok().body(tbdThongBaoKetQua20List);
	}


}
