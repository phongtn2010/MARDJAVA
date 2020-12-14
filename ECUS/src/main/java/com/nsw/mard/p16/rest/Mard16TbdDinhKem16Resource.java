package com.nsw.mard.p16.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.mard.p16.model.PageableDTO;
import com.nsw.mard.p16.model.TbdDinhKem16;

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
* @class Mard16TbdDinhKem16Resource
* Created by Nguyen Van Quang
* 11/12/2018 10:05:02
*
*/
@RestController
@RequestMapping("/mard/16/tbdDinhKem16")
public class Mard16TbdDinhKem16Resource extends Mard16CallBack {

	@Autowired
	private Mard16TbdKetQuaXuLy16Resource fldMard16TbdKetQuaXuLy16Resource;

	@Autowired
	private Mard16TbdHoSo16Resource fldMard16TbdHoSo16Resource;
	
	/**
	* @param tbdDinhKem16 - Type: TbdDinhKem16
	* @return may can null
	*/
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<TbdDinhKem16> createTbdDinhKem16(@RequestBody @Valid TbdDinhKem16 tbdDinhKem16) {
		tbdDinhKem16 = createRestTemplate(getURL("/mard/16/tbdDinhKem16/create"), tbdDinhKem16, HttpMethod.POST, null, TbdDinhKem16.class);
		createHistory(fldMard16TbdKetQuaXuLy16Resource, fldMard16TbdHoSo16Resource, "Tạo mới tệp đính kèm: " + tbdDinhKem16.getFiFileName(), tbdDinhKem16.getFiIdHoSo());
		return ResponseEntity.ok().body(tbdDinhKem16);
	}

	/**
	* @param fiId - Type: Long
	* @param tbdDinhKem16 - Type: TbdDinhKem16
	* @return may can null
	*/
	@RequestMapping(value = "/update/{fiId}", method = RequestMethod.POST)
	public ResponseEntity<TbdDinhKem16> updateTbdDinhKem16(@PathVariable("fiId") Long fiId, @RequestBody @Valid TbdDinhKem16 tbdDinhKem16) {
		tbdDinhKem16 = createRestTemplate(getURL("/mard/16/tbdDinhKem16/update/") + fiId, tbdDinhKem16, HttpMethod.POST, null, TbdDinhKem16.class);
		return ResponseEntity.ok().body(tbdDinhKem16);
	}

	/**
	* @param fiId - Type: Long
	* @return may can throw new Execption
	*/
	@RequestMapping(value = "/delete/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbdDinhKem16> deleteTbdDinhKem16(@PathVariable("fiId") Long fiId) {
		TbdDinhKem16 tbdDinhKem16 = createRestTemplate(getURL("/mard/16/tbdDinhKem16/delete/") + fiId, null, HttpMethod.DELETE, null, TbdDinhKem16.class);
		createHistory(fldMard16TbdKetQuaXuLy16Resource, fldMard16TbdHoSo16Resource, "Xóa tệp đính kèm: " + tbdDinhKem16.getFiFileName(), tbdDinhKem16.getFiIdHoSo());
		return ResponseEntity.ok().body(tbdDinhKem16);
	}

	/**
	* @param fiId - Type: Long
	* @return may can null
	*/
	@RequestMapping(value = "/get/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbdDinhKem16> getTbdDinhKem16(@PathVariable("fiId") Long fiId) {
		TbdDinhKem16 tbdDinhKem16 = createRestTemplate(getURL("/mard/16/tbdDinhKem16/get/") + fiId, null, HttpMethod.GET, null, TbdDinhKem16.class);
		return ResponseEntity.ok().body(tbdDinhKem16);
	}

	/**
	* @param pageableDTO - Type: PageableDTO
	* @return may can null
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findAll", method = RequestMethod.POST)
	public ResponseEntity<List<TbdDinhKem16>> findAllTbdDinhKem16(@RequestBody @Valid PageableDTO pageableDTO) {

		List<TbdDinhKem16> tbdDinhKem16List = createRestTemplate(getURL("/mard/16/tbdDinhKem16/findAll"), pageableDTO, HttpMethod.POST, null, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdDinhKem16List = mapper.convertValue(tbdDinhKem16List, new TypeReference<List<TbdDinhKem16>>() {});

		return ResponseEntity.ok().body(tbdDinhKem16List);
	}

	/**
	* @param fiIdHoSo - Type: Long
	* @return can return null or throw exception
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findByFiIdHoSo", method = RequestMethod.GET)
	public ResponseEntity<List<TbdDinhKem16>> findByFiIdHoSo(@RequestParam(name = "fiIdHoSo", required = false) Long fiIdHoSo) {

		Map<String, Object> params = new HashMap<>();
		params.put("fiIdHoSo", fiIdHoSo);
		List<TbdDinhKem16> tbdDinhKem16List = createRestTemplate(getURL("/mard/16/tbdDinhKem16/findByFiIdHoSo"), null, HttpMethod.GET, params, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdDinhKem16List = mapper.convertValue(tbdDinhKem16List, new TypeReference<List<TbdDinhKem16>>() {});

		return ResponseEntity.ok().body(tbdDinhKem16List);
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
		Optional<Long> tbdDinhKem16 = createRestTemplate(getURL("/mard/16/tbdDinhKem16/sizeOfFiles"), null, HttpMethod.GET, params, Optional.class);

		return ResponseEntity.ok().body(tbdDinhKem16);
	}


}