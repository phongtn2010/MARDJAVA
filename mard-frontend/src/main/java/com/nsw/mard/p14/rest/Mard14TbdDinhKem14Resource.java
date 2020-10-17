package com.nsw.mard.p14.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.mard.p14.model.PageableDTO;
import com.nsw.mard.p14.model.TbdDinhKem14;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
* @class Mard14TbdDinhKem14Resource
* Created by Nguyen Van Quang
* 11/12/2018 10:05:02
*
*/
@RestController
@RequestMapping("/mard/14/tbdDinhKem14")
public class Mard14TbdDinhKem14Resource extends Mard14CallBack {

	@Autowired
	private Mard14TbdKetQuaXuLy14Resource fldMard14TbdKetQuaXuLy14Resource;

	@Autowired
	private Mard14TbdHoSo14Resource fldMard14TbdHoSo14Resource;

	/**
	* @param tbdDinhKem14 - Type: TbdDinhKem14
	* @return may can null
	*/
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<TbdDinhKem14> createTbdDinhKem14(@RequestBody @Valid TbdDinhKem14 tbdDinhKem14) {
		tbdDinhKem14 = createRestTemplate(getURL("/mard/14/tbdDinhKem14/create"), tbdDinhKem14, HttpMethod.POST, null, TbdDinhKem14.class);
		createHistory(fldMard14TbdKetQuaXuLy14Resource, fldMard14TbdHoSo14Resource, "Tạo mới tệp đính kèm: " + tbdDinhKem14.getFiFileName(), tbdDinhKem14.getFiIdHoSo());
		return ResponseEntity.ok().body(tbdDinhKem14);
	}

	/**
	* @param fiId - Type: Long
	* @param tbdDinhKem14 - Type: TbdDinhKem14
	* @return may can null
	*/
	@RequestMapping(value = "/update/{fiId}", method = RequestMethod.POST)
	public ResponseEntity<TbdDinhKem14> updateTbdDinhKem14(@PathVariable("fiId") Long fiId, @RequestBody @Valid TbdDinhKem14 tbdDinhKem14) {
		tbdDinhKem14 = createRestTemplate(getURL("/mard/14/tbdDinhKem14/update/") + fiId, tbdDinhKem14, HttpMethod.POST, null, TbdDinhKem14.class);
		return ResponseEntity.ok().body(tbdDinhKem14);
	}

	/**
	* @param fiId - Type: Long
	* @return may can throw new Execption
	*/
	@RequestMapping(value = "/delete/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbdDinhKem14> deleteTbdDinhKem14(@PathVariable("fiId") Long fiId) {
		TbdDinhKem14 tbdDinhKem14 = createRestTemplate(getURL("/mard/14/tbdDinhKem14/delete/") + fiId, null, HttpMethod.DELETE, null, TbdDinhKem14.class);
		createHistory(fldMard14TbdKetQuaXuLy14Resource, fldMard14TbdHoSo14Resource, "Xóa tệp đính kèm: " + tbdDinhKem14.getFiFileName(), tbdDinhKem14.getFiIdHoSo());
		return ResponseEntity.ok().body(tbdDinhKem14);
	}

	/**
	* @param fiId - Type: Long
	* @return may can null
	*/
	@RequestMapping(value = "/get/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbdDinhKem14> getTbdDinhKem14(@PathVariable("fiId") Long fiId) {
		TbdDinhKem14 tbdDinhKem14 = createRestTemplate(getURL("/mard/14/tbdDinhKem14/get/") + fiId, null, HttpMethod.GET, null, TbdDinhKem14.class);
		return ResponseEntity.ok().body(tbdDinhKem14);
	}

	/**
	* @param pageableDTO - Type: PageableDTO
	* @return may can null
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findAll", method = RequestMethod.POST)
	public ResponseEntity<List<TbdDinhKem14>> findAllTbdDinhKem14(@RequestBody @Valid PageableDTO pageableDTO) {

		List<TbdDinhKem14> tbdDinhKem14List = createRestTemplate(getURL("/mard/14/tbdDinhKem14/findAll"), pageableDTO, HttpMethod.POST, null, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdDinhKem14List = mapper.convertValue(tbdDinhKem14List, new TypeReference<List<TbdDinhKem14>>() {});

		return ResponseEntity.ok().body(tbdDinhKem14List);
	}

	/**
	* @param fiIdHoSo - Type: Long
	* @return can return null or throw exception
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findByFiIdHoSo", method = RequestMethod.GET)
	public ResponseEntity<List<TbdDinhKem14>> findByFiIdHoSo(@RequestParam(name = "fiIdHoSo", required = false) Long fiIdHoSo) {

		Map<String, Object> params = new HashMap<>();
		params.put("fiIdHoSo", fiIdHoSo);
		List<TbdDinhKem14> tbdDinhKem14List = createRestTemplate(getURL("/mard/14/tbdDinhKem14/findByFiIdHoSo"), null, HttpMethod.GET, params, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdDinhKem14List = mapper.convertValue(tbdDinhKem14List, new TypeReference<List<TbdDinhKem14>>() {});

		return ResponseEntity.ok().body(tbdDinhKem14List);
	}

	/**
	* @param fiIdHoSo - Type: Long
	* @return can return null or throw exception
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/sizeOfFiles", method = RequestMethod.GET)
	public ResponseEntity<Optional<Long>> sizeOfFiles(@RequestParam(name = "fiIdHoSo") Long fiIdHoSo) {

		Map<String, Object> params = new HashMap<>();
		params.put("fiIdHoSo", fiIdHoSo);
		Optional<Long> tbdDinhKem14 = createRestTemplate(getURL("/mard/14/tbdDinhKem14/sizeOfFiles"), null, HttpMethod.GET, params, Optional.class);

		return ResponseEntity.ok().body(tbdDinhKem14);
	}


}