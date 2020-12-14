package com.nsw.mard.p15.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.mard.p15.model.PageableDTO;
import com.nsw.mard.p15.model.TbdDinhKem15;

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
* @class Mard15TbdDinhKem15Resource
* Created by Nguyen Van Quang
* 11/12/2018 10:05:02
*
*/
@RestController
@RequestMapping("/mard/15/tbdDinhKem15")
public class Mard15TbdDinhKem15Resource extends Mard15CallBack {

	@Autowired
	private Mard15TbdKetQuaXuLy15Resource fldMard15TbdKetQuaXuLy15Resource;

	@Autowired
	private Mard15TbdHoSo15Resource fldMard15TbdHoSo15Resource;
	
	/**
	* @param tbdDinhKem15 - Type: TbdDinhKem15
	* @return may can null
	*/
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<TbdDinhKem15> createTbdDinhKem15(@RequestBody @Valid TbdDinhKem15 tbdDinhKem15) {
		tbdDinhKem15 = createRestTemplate(getURL("/mard/15/tbdDinhKem15/create"), tbdDinhKem15, HttpMethod.POST, null, TbdDinhKem15.class);
		createHistory(fldMard15TbdKetQuaXuLy15Resource, fldMard15TbdHoSo15Resource, "Tạo mới tệp đính kèm: " + tbdDinhKem15.getFiFileName(), tbdDinhKem15.getFiIdHoSo());
		return ResponseEntity.ok().body(tbdDinhKem15);
	}

	/**
	* @param fiId - Type: Long
	* @param tbdDinhKem15 - Type: TbdDinhKem15
	* @return may can null
	*/
	@RequestMapping(value = "/update/{fiId}", method = RequestMethod.POST)
	public ResponseEntity<TbdDinhKem15> updateTbdDinhKem15(@PathVariable("fiId") Long fiId, @RequestBody @Valid TbdDinhKem15 tbdDinhKem15) {
		tbdDinhKem15 = createRestTemplate(getURL("/mard/15/tbdDinhKem15/update/") + fiId, tbdDinhKem15, HttpMethod.POST, null, TbdDinhKem15.class);
		return ResponseEntity.ok().body(tbdDinhKem15);
	}

	/**
	* @param fiId - Type: Long
	* @return may can throw new Execption
	*/
	@RequestMapping(value = "/delete/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbdDinhKem15> deleteTbdDinhKem15(@PathVariable("fiId") Long fiId) {
		TbdDinhKem15 tbdDinhKem15 = createRestTemplate(getURL("/mard/15/tbdDinhKem15/delete/") + fiId, null, HttpMethod.DELETE, null, TbdDinhKem15.class);
		createHistory(fldMard15TbdKetQuaXuLy15Resource, fldMard15TbdHoSo15Resource, "Xóa tệp đính kèm: " + tbdDinhKem15.getFiFileName(), tbdDinhKem15.getFiIdHoSo());
		return ResponseEntity.ok().body(tbdDinhKem15);
	}

	/**
	* @param fiId - Type: Long
	* @return may can null
	*/
	@RequestMapping(value = "/get/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbdDinhKem15> getTbdDinhKem15(@PathVariable("fiId") Long fiId) {
		TbdDinhKem15 tbdDinhKem15 = createRestTemplate(getURL("/mard/15/tbdDinhKem15/get/") + fiId, null, HttpMethod.GET, null, TbdDinhKem15.class);
		return ResponseEntity.ok().body(tbdDinhKem15);
	}

	/**
	* @param pageableDTO - Type: PageableDTO
	* @return may can null
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findAll", method = RequestMethod.POST)
	public ResponseEntity<List<TbdDinhKem15>> findAllTbdDinhKem15(@RequestBody @Valid PageableDTO pageableDTO) {

		List<TbdDinhKem15> tbdDinhKem15List = createRestTemplate(getURL("/mard/15/tbdDinhKem15/findAll"), pageableDTO, HttpMethod.POST, null, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdDinhKem15List = mapper.convertValue(tbdDinhKem15List, new TypeReference<List<TbdDinhKem15>>() {});

		return ResponseEntity.ok().body(tbdDinhKem15List);
	}

	/**
	* @param fiIdHoSo - Type: Long
	* @return can return null or throw exception
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findByFiIdHoSo", method = RequestMethod.GET)
	public ResponseEntity<List<TbdDinhKem15>> findByFiIdHoSo(@RequestParam(name = "fiIdHoSo", required = false) Long fiIdHoSo) {

		Map<String, Object> params = new HashMap<>();
		params.put("fiIdHoSo", fiIdHoSo);
		List<TbdDinhKem15> tbdDinhKem15List = createRestTemplate(getURL("/mard/15/tbdDinhKem15/findByFiIdHoSo"), null, HttpMethod.GET, params, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdDinhKem15List = mapper.convertValue(tbdDinhKem15List, new TypeReference<List<TbdDinhKem15>>() {});

		return ResponseEntity.ok().body(tbdDinhKem15List);
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
		Optional<Long> tbdDinhKem15 = createRestTemplate(getURL("/mard/15/tbdDinhKem15/sizeOfFiles"), null, HttpMethod.GET, params, Optional.class);

		return ResponseEntity.ok().body(tbdDinhKem15);
	}


}