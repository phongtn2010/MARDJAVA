package com.nsw.mard.p18.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.mard.p18.model.PageableDTO;
import com.nsw.mard.p18.model.TbdDinhKem18;

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
* @class Mard18TbdDinhKem18Resource
* Created by Nguyen Van Quang
* 11/12/2018 10:05:02
*
*/
@RestController
@RequestMapping("/mard/18/tbdDinhKem18")
public class Mard18TbdDinhKem18Resource extends Mard18CallBack {

	@Autowired
	private Mard18TbdKetQuaXuLy18Resource fldMard18TbdKetQuaXuLy18Resource;

	@Autowired
	private Mard18TbdHoSo18Resource fldMard18TbdHoSo18Resource;

	/**
	* @param tbdDinhKem18 - Type: TbdDinhKem18
	* @return may can null
	*/
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<TbdDinhKem18> createTbdDinhKem18(@RequestBody @Valid TbdDinhKem18 tbdDinhKem18) {
		tbdDinhKem18 = createRestTemplate(getURL("/mard/18/tbdDinhKem18/create"), tbdDinhKem18, HttpMethod.POST, null, TbdDinhKem18.class);
		createHistory(fldMard18TbdKetQuaXuLy18Resource, fldMard18TbdHoSo18Resource, "Tạo mới tệp đính kèm: " + tbdDinhKem18.getFiFileName(), tbdDinhKem18.getFiIdHoSo());
		return ResponseEntity.ok().body(tbdDinhKem18);
	}

	/**
	* @param fiId - Type: Long
	* @param tbdDinhKem18 - Type: TbdDinhKem18
	* @return may can null
	*/
	@RequestMapping(value = "/update/{fiId}", method = RequestMethod.POST)
	public ResponseEntity<TbdDinhKem18> updateTbdDinhKem18(@PathVariable("fiId") Long fiId, @RequestBody @Valid TbdDinhKem18 tbdDinhKem18) {
		tbdDinhKem18 = createRestTemplate(getURL("/mard/18/tbdDinhKem18/update/") + fiId, tbdDinhKem18, HttpMethod.POST, null, TbdDinhKem18.class);
		return ResponseEntity.ok().body(tbdDinhKem18);
	}

	/**
	* @param fiId - Type: Long
	* @return may can throw new Execption
	*/
	@RequestMapping(value = "/delete/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbdDinhKem18> deleteTbdDinhKem18(@PathVariable("fiId") Long fiId) {
		TbdDinhKem18 tbdDinhKem18 = createRestTemplate(getURL("/mard/18/tbdDinhKem18/delete/") + fiId, null, HttpMethod.DELETE, null, TbdDinhKem18.class);
		createHistory(fldMard18TbdKetQuaXuLy18Resource, fldMard18TbdHoSo18Resource, "Xóa tệp đính kèm: " + tbdDinhKem18.getFiFileName(), tbdDinhKem18.getFiIdHoSo());
		return ResponseEntity.ok().body(tbdDinhKem18);
	}

	/**
	* @param fiId - Type: Long
	* @return may can null
	*/
	@RequestMapping(value = "/get/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbdDinhKem18> getTbdDinhKem18(@PathVariable("fiId") Long fiId) {
		TbdDinhKem18 tbdDinhKem18 = createRestTemplate(getURL("/mard/18/tbdDinhKem18/get/") + fiId, null, HttpMethod.GET, null, TbdDinhKem18.class);
		return ResponseEntity.ok().body(tbdDinhKem18);
	}

	/**
	* @param pageableDTO - Type: PageableDTO
	* @return may can null
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findAll", method = RequestMethod.POST)
	public ResponseEntity<List<TbdDinhKem18>> findAllTbdDinhKem18(@RequestBody @Valid PageableDTO pageableDTO) {

		List<TbdDinhKem18> tbdDinhKem18List = createRestTemplate(getURL("/mard/18/tbdDinhKem18/findAll"), pageableDTO, HttpMethod.POST, null, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdDinhKem18List = mapper.convertValue(tbdDinhKem18List, new TypeReference<List<TbdDinhKem18>>() {});

		return ResponseEntity.ok().body(tbdDinhKem18List);
	}

	/**
	* @param fiIdHoSo - Type: Long
	* @return can return null or throw exception
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findByFiIdHoSo", method = RequestMethod.GET)
	public ResponseEntity<List<TbdDinhKem18>> findByFiIdHoSo(@RequestParam(name = "fiIdHoSo", required = false) Long fiIdHoSo) {

		Map<String, Object> params = new HashMap<>();
		params.put("fiIdHoSo", fiIdHoSo);
		List<TbdDinhKem18> tbdDinhKem18List = createRestTemplate(getURL("/mard/18/tbdDinhKem18/findByFiIdHoSo"), null, HttpMethod.GET, params, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdDinhKem18List = mapper.convertValue(tbdDinhKem18List, new TypeReference<List<TbdDinhKem18>>() {});

		return ResponseEntity.ok().body(tbdDinhKem18List);
	}
	@RequestMapping(value = "/findByFiProductId/{fiProductId}", method = RequestMethod.GET)
	public ResponseEntity<List<TbdDinhKem18>> findByFiProductId(@PathVariable("fiProductId") Long fiProductId) {

		Map<String, Object> params = new HashMap<>();
		params.put("fiProductId", fiProductId);
		List<TbdDinhKem18> tbdDinhKem18List = createRestTemplate(getURL("/mard/18/tbdDinhKem18/findByFiProductId/") +  fiProductId, null, HttpMethod.GET, params, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdDinhKem18List = mapper.convertValue(tbdDinhKem18List, new TypeReference<List<TbdDinhKem18>>() {});

		return ResponseEntity.ok().body(tbdDinhKem18List);
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
		Optional<Long> tbdDinhKem18 = createRestTemplate(getURL("/mard/18/tbdDinhKem18/sizeOfFiles"), null, HttpMethod.GET, params, Optional.class);

		return ResponseEntity.ok().body(tbdDinhKem18);
	}


}
