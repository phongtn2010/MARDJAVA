package com.nsw.mard.p20.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.mard.p20.model.TbdDinhKem20;
import com.nsw.mard.p20.model.PageableDTO;
import com.nsw.mard.p20.model.TbdDinhKem20;

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
* @class Mard20TbdDinhKem20Resource
* Created by Nguyen Van Quang
* 11/12/2020 10:05:02
*
*/
@RestController
@RequestMapping("/mard/20/tbdDinhKem20")
public class Mard20TbdDinhKem20Resource extends Mard20CallBack {

	@Autowired
	private Mard20TbdKetQuaXuLy20Resource fldMard20TbdKetQuaXuLy20Resource;

	@Autowired
	private Mard20TbdHoSo20Resource fldMard20TbdHoSo20Resource;

	/**
	* @param tbdDinhKem20 - Type: TbdDinhKem20
	* @return may can null
	*/
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<TbdDinhKem20> createTbdDinhKem20(@RequestBody @Valid TbdDinhKem20 tbdDinhKem20) {
		tbdDinhKem20 = createRestTemplate(getURL("/mard/18/tbdDinhKem18/create"), tbdDinhKem20, HttpMethod.POST, null, TbdDinhKem20.class);
		createHistory(fldMard20TbdKetQuaXuLy20Resource, fldMard20TbdHoSo20Resource, "Tạo mới tệp đính kèm: " + tbdDinhKem20.getFiFileName(), tbdDinhKem20.getFiIdHoSo());
		return ResponseEntity.ok().body(tbdDinhKem20);
	}

	/**
	* @param fiId - Type: Long
	* @param tbdDinhKem20 - Type: TbdDinhKem20
	* @return may can null
	*/
	@RequestMapping(value = "/update/{fiId}", method = RequestMethod.POST)
	public ResponseEntity<TbdDinhKem20> updateTbdDinhKem20(@PathVariable("fiId") Long fiId, @RequestBody @Valid TbdDinhKem20 tbdDinhKem20) {
		tbdDinhKem20 = createRestTemplate(getURL("/mard/18/tbdDinhKem18/update/") + fiId, tbdDinhKem20, HttpMethod.POST, null, TbdDinhKem20.class);
		return ResponseEntity.ok().body(tbdDinhKem20);
	}

	/**
	* @param fiId - Type: Long
	* @return may can throw new Execption
	*/
	@RequestMapping(value = "/delete/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbdDinhKem20> deleteTbdDinhKem20(@PathVariable("fiId") Long fiId) {
		TbdDinhKem20 tbdDinhKem20 = createRestTemplate(getURL("/mard/18/tbdDinhKem18/delete/") + fiId, null, HttpMethod.DELETE, null, TbdDinhKem20.class);
		createHistory(fldMard20TbdKetQuaXuLy20Resource, fldMard20TbdHoSo20Resource, "Xóa tệp đính kèm: " + tbdDinhKem20.getFiFileName(), tbdDinhKem20.getFiIdHoSo());
		return ResponseEntity.ok().body(tbdDinhKem20);
	}
	@RequestMapping(value = "/findByFiProductId/{fiProductId}", method = RequestMethod.GET)
	public ResponseEntity<List<TbdDinhKem20>> findByFiProductId(@PathVariable("fiProductId") Long fiProductId) {

		Map<String, Object> params = new HashMap<>();
		params.put("fiProductId", fiProductId);
		List<TbdDinhKem20> tbdDinhKem20List = createRestTemplate(getURL("/mard/18/tbdDinhKem18/findByFiProductId/") +  fiProductId, null, HttpMethod.GET, params, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdDinhKem20List = mapper.convertValue(tbdDinhKem20List, new TypeReference<List<TbdDinhKem20>>() {});

		return ResponseEntity.ok().body(tbdDinhKem20List);
	}

	/**
	* @param fiId - Type: Long
	* @return may can null
	*/
	@RequestMapping(value = "/get/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbdDinhKem20> getTbdDinhKem20(@PathVariable("fiId") Long fiId) {
		TbdDinhKem20 tbdDinhKem20 = createRestTemplate(getURL("/mard/18/tbdDinhKem18/get/") + fiId, null, HttpMethod.GET, null, TbdDinhKem20.class);
		return ResponseEntity.ok().body(tbdDinhKem20);
	}

	/**
	* @param pageableDTO - Type: PageableDTO
	* @return may can null
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findAll", method = RequestMethod.POST)
	public ResponseEntity<List<TbdDinhKem20>> findAllTbdDinhKem20(@RequestBody @Valid PageableDTO pageableDTO) {

		List<TbdDinhKem20> tbdDinhKem20List = createRestTemplate(getURL("/mard/18/tbdDinhKem18/findAll"), pageableDTO, HttpMethod.POST, null, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdDinhKem20List = mapper.convertValue(tbdDinhKem20List, new TypeReference<List<TbdDinhKem20>>() {});

		return ResponseEntity.ok().body(tbdDinhKem20List);
	}

	/**
	* @param fiIdHoSo - Type: Long
	* @return can return null or throw exception
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findByFiIdHoSo", method = RequestMethod.GET)
	public ResponseEntity<List<TbdDinhKem20>> findByFiIdHoSo(@RequestParam(name = "fiIdHoSo", required = false) Long fiIdHoSo) {

		Map<String, Object> params = new HashMap<>();
		params.put("fiIdHoSo", fiIdHoSo);
		List<TbdDinhKem20> tbdDinhKem20List = createRestTemplate(getURL("/mard/18/tbdDinhKem18/findByFiIdHoSo"), null, HttpMethod.GET, params, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdDinhKem20List = mapper.convertValue(tbdDinhKem20List, new TypeReference<List<TbdDinhKem20>>() {});

		return ResponseEntity.ok().body(tbdDinhKem20List);
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
		Optional<Long> tbdDinhKem20 = createRestTemplate(getURL("/mard/18/tbdDinhKem18/sizeOfFiles"), null, HttpMethod.GET, params, Optional.class);

		return ResponseEntity.ok().body(tbdDinhKem20);
	}


}
