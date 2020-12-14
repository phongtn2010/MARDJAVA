package com.nsw.mard.p17.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.mard.p17.model.PageableDTO;
import com.nsw.mard.p17.model.TbdDinhKem17;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import com.nsw.mard.p18.model.TbdDinhKem18;
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
* @class Mard17TbdDinhKem17Resource
* Created by Nguyen Van Quang
* 11/12/2018 10:05:02
*
*/
@RestController
@RequestMapping("/mard/17/tbdDinhKem17")
public class Mard17TbdDinhKem17Resource extends Mard17CallBack {

	@Autowired
	private Mard17TbdKetQuaXuLy17Resource fldMard17TbdKetQuaXuLy17Resource;

	@Autowired
	private Mard17TbdHoSo17Resource fldMard17TbdHoSo17Resource;

	/**
	* @param tbdDinhKem17 - Type: TbdDinhKem17
	* @return may can null
	*/
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<TbdDinhKem17> createTbdDinhKem17(@RequestBody @Valid TbdDinhKem17 tbdDinhKem17) {
		tbdDinhKem17 = createRestTemplate(getURL("/mard/17/tbdDinhKem17/create"), tbdDinhKem17, HttpMethod.POST, null, TbdDinhKem17.class);
		createHistory(fldMard17TbdKetQuaXuLy17Resource, fldMard17TbdHoSo17Resource, "Tạo mới tệp đính kèm: " + tbdDinhKem17.getFiFileName(), tbdDinhKem17.getFiIdHoSo());
		return ResponseEntity.ok().body(tbdDinhKem17);
	}

	/**
	* @param fiId - Type: Long
	* @param tbdDinhKem17 - Type: TbdDinhKem17
	* @return may can null
	*/
	@RequestMapping(value = "/update/{fiId}", method = RequestMethod.POST)
	public ResponseEntity<TbdDinhKem17> updateTbdDinhKem17(@PathVariable("fiId") Long fiId, @RequestBody @Valid TbdDinhKem17 tbdDinhKem17) {
		tbdDinhKem17 = createRestTemplate(getURL("/mard/17/tbdDinhKem17/update/") + fiId, tbdDinhKem17, HttpMethod.POST, null, TbdDinhKem17.class);
		return ResponseEntity.ok().body(tbdDinhKem17);
	}

	/**
	* @param fiId - Type: Long
	* @return may can throw new Execption
	*/
	@RequestMapping(value = "/delete/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbdDinhKem17> deleteTbdDinhKem17(@PathVariable("fiId") Long fiId) {
		TbdDinhKem17 tbdDinhKem17 = createRestTemplate(getURL("/mard/17/tbdDinhKem17/delete/") + fiId, null, HttpMethod.DELETE, null, TbdDinhKem17.class);
		createHistory(fldMard17TbdKetQuaXuLy17Resource, fldMard17TbdHoSo17Resource, "Xóa tệp đính kèm: " + tbdDinhKem17.getFiFileName(), tbdDinhKem17.getFiIdHoSo());
		return ResponseEntity.ok().body(tbdDinhKem17);
	}

	/**
	* @param fiId - Type: Long
	* @return may can null
	*/
	@RequestMapping(value = "/get/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbdDinhKem17> getTbdDinhKem17(@PathVariable("fiId") Long fiId) {
		TbdDinhKem17 tbdDinhKem17 = createRestTemplate(getURL("/mard/17/tbdDinhKem17/get/") + fiId, null, HttpMethod.GET, null, TbdDinhKem17.class);
		return ResponseEntity.ok().body(tbdDinhKem17);
	}
	@RequestMapping(value = "/findByFiProductId/{fiProductId}", method = RequestMethod.GET)
	public ResponseEntity<List<TbdDinhKem17>> findByFiProductId(@PathVariable("fiProductId") Long fiProductId) {

		Map<String, Object> params = new HashMap<>();
		params.put("fiProductId", fiProductId);
		List<TbdDinhKem17> tbdDinhKem17List = createRestTemplate(getURL("/mard/17/tbdDinhKem17/findByFiProductId/") +  fiProductId, null, HttpMethod.GET, params, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdDinhKem17List = mapper.convertValue(tbdDinhKem17List, new TypeReference<List<TbdDinhKem17>>() {});

		return ResponseEntity.ok().body(tbdDinhKem17List);
	}

	/**
	* @param pageableDTO - Type: PageableDTO
	* @return may can null
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findAll", method = RequestMethod.POST)
	public ResponseEntity<List<TbdDinhKem17>> findAllTbdDinhKem17(@RequestBody @Valid PageableDTO pageableDTO) {

		List<TbdDinhKem17> tbdDinhKem17List = createRestTemplate(getURL("/mard/17/tbdDinhKem17/findAll"), pageableDTO, HttpMethod.POST, null, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdDinhKem17List = mapper.convertValue(tbdDinhKem17List, new TypeReference<List<TbdDinhKem17>>() {});

		return ResponseEntity.ok().body(tbdDinhKem17List);
	}

	/**
	* @param fiIdHoSo - Type: Long
	* @return can return null or throw exception
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findByFiIdHoSo", method = RequestMethod.GET)
	public ResponseEntity<List<TbdDinhKem17>> findByFiIdHoSo(@RequestParam(name = "fiIdHoSo", required = false) Long fiIdHoSo) {

		Map<String, Object> params = new HashMap<>();
		params.put("fiIdHoSo", fiIdHoSo);
		List<TbdDinhKem17> tbdDinhKem17List = createRestTemplate(getURL("/mard/17/tbdDinhKem17/findByFiIdHoSo"), null, HttpMethod.GET, params, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdDinhKem17List = mapper.convertValue(tbdDinhKem17List, new TypeReference<List<TbdDinhKem17>>() {});

		return ResponseEntity.ok().body(tbdDinhKem17List);
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
		Optional<Long> tbdDinhKem17 = createRestTemplate(getURL("/mard/17/tbdDinhKem17/sizeOfFiles"), null, HttpMethod.GET, params, Optional.class);

		return ResponseEntity.ok().body(tbdDinhKem17);
	}


}
