package com.nsw.mard.p18.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.mard.p18.model.PageableDTO;
import com.nsw.mard.p18.model.TbdThongBaoKetQua18;

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
* @class Mard18TbdGiayPhep18Resource
* Created by Nguyen Van Quang
* 11/12/2018 10:06:22
*
*/
@RestController
@RequestMapping("/mard/18/tbdGiayPhep18")
public class Mard18TbdThongBaoKetQua18Resource extends Mard18CallBack {

	/**
	* @param tbdThongBaoKetQua18 - Type: TbdGiayPhep18
	* @return may can null
	*/
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<TbdThongBaoKetQua18> createTbdGiayPhep18(@RequestBody @Valid TbdThongBaoKetQua18 tbdThongBaoKetQua18) {
		tbdThongBaoKetQua18 = createRestTemplate(getURL("/mard/18/tbdGiayPhep18/create"), tbdThongBaoKetQua18, HttpMethod.POST, null, TbdThongBaoKetQua18.class);
		return ResponseEntity.ok().body(tbdThongBaoKetQua18);
	}

	/**
	* @param fiId - Type: Long
	* @param tbdThongBaoKetQua18 - Type: TbdGiayPhep18
	* @return may can null
	*/
	@RequestMapping(value = "/update/{fiId}", method = RequestMethod.POST)
	public ResponseEntity<TbdThongBaoKetQua18> updateTbdGiayPhep18(@PathVariable("fiId") Long fiId, @RequestBody @Valid TbdThongBaoKetQua18 tbdThongBaoKetQua18) {
		tbdThongBaoKetQua18 = createRestTemplate(getURL("/mard/18/tbdGiayPhep18/update/") + fiId, tbdThongBaoKetQua18, HttpMethod.POST, null, TbdThongBaoKetQua18.class);
		return ResponseEntity.ok().body(tbdThongBaoKetQua18);
	}

	/**
	* @param fiId - Type: Long
	* @return may can throw new Execption
	*/
	@RequestMapping(value = "/delete/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbdThongBaoKetQua18> deleteTbdGiayPhep18(@PathVariable("fiId") Long fiId) {
		TbdThongBaoKetQua18 tbdThongBaoKetQua18 = createRestTemplate(getURL("/mard/18/tbdGiayPhep18/delete/") + fiId, null, HttpMethod.GET, null, TbdThongBaoKetQua18.class);
		return ResponseEntity.ok().body(tbdThongBaoKetQua18);
	}

	/**
	* @param fiId - Type: Long
	* @return may can null
	*/
	@RequestMapping(value = "/get/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbdThongBaoKetQua18> getTbdGiayPhep18(@PathVariable("fiId") Long fiId) {
		TbdThongBaoKetQua18 tbdThongBaoKetQua18 = createRestTemplate(getURL("/mard/18/tbdGiayPhep18/get/") + fiId, null, HttpMethod.GET, null, TbdThongBaoKetQua18.class);
		return ResponseEntity.ok().body(tbdThongBaoKetQua18);
	}

	/**
	* @param pageableDTO - Type: PageableDTO
	* @return may can null
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findAll", method = RequestMethod.POST)
	public ResponseEntity<List<TbdThongBaoKetQua18>> findAllTbdGiayPhep18(@RequestBody @Valid PageableDTO pageableDTO) {

		List<TbdThongBaoKetQua18> tbdThongBaoKetQua18List = createRestTemplate(getURL("/mard/18/tbdGiayPhep18/findAll"), pageableDTO, HttpMethod.POST, null, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdThongBaoKetQua18List = mapper.convertValue(tbdThongBaoKetQua18List, new TypeReference<List<TbdThongBaoKetQua18>>() {});

		return ResponseEntity.ok().body(tbdThongBaoKetQua18List);
	}

	/**
	* @param fiIdHoSo - Type: Long
	* @return can return null or throw exception
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findByFiIdHoSo", method = RequestMethod.GET)
	public ResponseEntity<List<TbdThongBaoKetQua18>> findByFiIdHoSo(@RequestParam(name = "fiIdHoSo", required = false) Long fiIdHoSo) {

		Map<String, Object> params = new HashMap<>();
		params.put("fiIdHoSo", fiIdHoSo);
		List<TbdThongBaoKetQua18> tbdThongBaoKetQua18List = createRestTemplate(getURL("/mard/18/tbdGiayPhep18/findByFiIdHoSo"), null, HttpMethod.GET, params, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdThongBaoKetQua18List = mapper.convertValue(tbdThongBaoKetQua18List, new TypeReference<List<TbdThongBaoKetQua18>>() {});

		return ResponseEntity.ok().body(tbdThongBaoKetQua18List);
	}

	/**
	* @param fiDispatchNo - Type: String
	* @return can return null or throw exception
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findByFiDispatchNo", method = RequestMethod.GET)
	public ResponseEntity<List<TbdThongBaoKetQua18>> findByFiDispatchNo(@RequestParam(name = "fiDispatchNo", required = false) String fiDispatchNo) {

		Map<String, Object> params = new HashMap<>();
		params.put("fiDispatchNo", fiDispatchNo);
		List<TbdThongBaoKetQua18> tbdThongBaoKetQua18List = createRestTemplate(getURL("/mard/18/tbdGiayPhep18/findByFiDispatchNo"), null, HttpMethod.GET, params, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdThongBaoKetQua18List = mapper.convertValue(tbdThongBaoKetQua18List, new TypeReference<List<TbdThongBaoKetQua18>>() {});

		return ResponseEntity.ok().body(tbdThongBaoKetQua18List);
	}
	@RequestMapping(value = "/findSoCongVanByMaThuTuc/{fiTaxCode}", method = RequestMethod.GET)
	public ResponseEntity<List<String>> findSoCongVanByMaThuTuc(@PathVariable("fiTaxCode")String fiTaxCode) {
		List<String> ListCongVan = createRestTemplate(getURL("/mard/18/tbdGiayPhep18/findSoCongVanByMaThuTuc/") + fiTaxCode, null, HttpMethod.GET, null, List.class);
		return ResponseEntity.ok().body(ListCongVan);
	}
}
