package com.nsw.mard.p19.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.mard.p18.model.TbdDinhKem18;
import com.nsw.mard.p19.model.PageableDTO;
import com.nsw.mard.p19.model.TbdDinhKem19;

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
* @class Mard19TbdDinhKem19Resource
* Created by Nguyen Van Quang
* 11/12/2019 10:05:02
*
*/
@RestController
@RequestMapping("/mard/19/tbdDinhKem19")
public class Mard19TbdDinhKem19Resource extends Mard19CallBack {

	@Autowired
	private Mard19TbdKetQuaXuLy19Resource fldMard19TbdKetQuaXuLy19Resource;

	@Autowired
	private Mard19TbdHoSo19Resource fldMard19TbdHoSo19Resource;

	/**
	* @param tbdDinhKem19 - Type: TbdDinhKem19
	* @return may can null
	*/
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<TbdDinhKem19> createTbdDinhKem19(@RequestBody @Valid TbdDinhKem19 tbdDinhKem19) {
		tbdDinhKem19 = createRestTemplate(getURL("/mard/18/tbdDinhKem18/create"), tbdDinhKem19, HttpMethod.POST, null, TbdDinhKem19.class);
		createHistory(fldMard19TbdKetQuaXuLy19Resource, fldMard19TbdHoSo19Resource, "Tạo mới tệp đính kèm: " + tbdDinhKem19.getFiFileName(), tbdDinhKem19.getFiIdHoSo());
		return ResponseEntity.ok().body(tbdDinhKem19);
	}

	/**
	* @param fiId - Type: Long
	* @param tbdDinhKem19 - Type: TbdDinhKem19
	* @return may can null
	*/
	@RequestMapping(value = "/update/{fiId}", method = RequestMethod.POST)
	public ResponseEntity<TbdDinhKem19> updateTbdDinhKem19(@PathVariable("fiId") Long fiId, @RequestBody @Valid TbdDinhKem19 tbdDinhKem19) {
		tbdDinhKem19 = createRestTemplate(getURL("/mard/18/tbdDinhKem18/update/") + fiId, tbdDinhKem19, HttpMethod.POST, null, TbdDinhKem19.class);
		return ResponseEntity.ok().body(tbdDinhKem19);
	}
	@RequestMapping(value = "/findByFiProductId/{fiProductId}", method = RequestMethod.GET)
	public ResponseEntity<List<TbdDinhKem19>> findByFiProductId(@PathVariable("fiProductId") Long fiProductId) {

		Map<String, Object> params = new HashMap<>();
		params.put("fiProductId", fiProductId);
		List<TbdDinhKem19> tbdDinhKem19List = createRestTemplate(getURL("/mard/18/tbdDinhKem18/findByFiProductId/") +  fiProductId, null, HttpMethod.GET, params, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdDinhKem19List = mapper.convertValue(tbdDinhKem19List, new TypeReference<List<TbdDinhKem19>>() {});

		return ResponseEntity.ok().body(tbdDinhKem19List);
	}

	/**
	* @param fiId - Type: Long
	* @return may can throw new Execption
	*/
	@RequestMapping(value = "/delete/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbdDinhKem19> deleteTbdDinhKem19(@PathVariable("fiId") Long fiId) {
		TbdDinhKem19 tbdDinhKem19 = createRestTemplate(getURL("/mard/18/tbdDinhKem18/delete/") + fiId, null, HttpMethod.DELETE, null, TbdDinhKem19.class);
		createHistory(fldMard19TbdKetQuaXuLy19Resource, fldMard19TbdHoSo19Resource, "Xóa tệp đính kèm: " + tbdDinhKem19.getFiFileName(), tbdDinhKem19.getFiIdHoSo());
		return ResponseEntity.ok().body(tbdDinhKem19);
	}

	/**
	* @param fiId - Type: Long
	* @return may can null
	*/
	@RequestMapping(value = "/get/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbdDinhKem19> getTbdDinhKem19(@PathVariable("fiId") Long fiId) {
		TbdDinhKem19 tbdDinhKem19 = createRestTemplate(getURL("/mard/18/tbdDinhKem18/get/") + fiId, null, HttpMethod.GET, null, TbdDinhKem19.class);
		return ResponseEntity.ok().body(tbdDinhKem19);
	}

	/**
	* @param pageableDTO - Type: PageableDTO
	* @return may can null
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findAll", method = RequestMethod.POST)
	public ResponseEntity<List<TbdDinhKem19>> findAllTbdDinhKem19(@RequestBody @Valid PageableDTO pageableDTO) {

		List<TbdDinhKem19> tbdDinhKem19List = createRestTemplate(getURL("/mard/18/tbdDinhKem18/findAll"), pageableDTO, HttpMethod.POST, null, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdDinhKem19List = mapper.convertValue(tbdDinhKem19List, new TypeReference<List<TbdDinhKem19>>() {});

		return ResponseEntity.ok().body(tbdDinhKem19List);
	}

	/**
	* @param fiIdHoSo - Type: Long
	* @return can return null or throw exception
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findByFiIdHoSo", method = RequestMethod.GET)
	public ResponseEntity<List<TbdDinhKem19>> findByFiIdHoSo(@RequestParam(name = "fiIdHoSo", required = false) Long fiIdHoSo) {

		Map<String, Object> params = new HashMap<>();
		params.put("fiIdHoSo", fiIdHoSo);
		List<TbdDinhKem19> tbdDinhKem19List = createRestTemplate(getURL("/mard/18/tbdDinhKem18/findByFiIdHoSo"), null, HttpMethod.GET, params, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdDinhKem19List = mapper.convertValue(tbdDinhKem19List, new TypeReference<List<TbdDinhKem19>>() {});

		return ResponseEntity.ok().body(tbdDinhKem19List);
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
		Optional<Long> tbdDinhKem19 = createRestTemplate(getURL("/mard/18/tbdDinhKem18/sizeOfFiles"), null, HttpMethod.GET, params, Optional.class);

		return ResponseEntity.ok().body(tbdDinhKem19);
	}


}
