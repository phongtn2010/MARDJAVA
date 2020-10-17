package com.nsw.mard.p14.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.mard.p14.model.PageableDTO;
import com.nsw.mard.p14.model.TbdThanhToan14;
import com.nsw.mard.p14.model.TbdThongBaoPhi14;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.nsw.mard.p14.model.TbdThongBaoPhi14DTO;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/***
*
*
* @RestController
* @class Mard14TbdThongBaoPhi14Resource
* Created by Nguyen Van Quang
* 11/12/2018 10:07:40
*
*/
@RestController
@RequestMapping("/mard/14/tbdThongBaoPhi14")
public class Mard14TbdThongBaoPhi14Resource extends Mard14CallBack {

	/**
	* @param tbdThongBaoPhi14 - Type: TbdThongBaoPhi14
	* @return may can null
	*/
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<TbdThongBaoPhi14> createTbdThongBaoPhi14(@RequestBody @Valid TbdThongBaoPhi14 tbdThongBaoPhi14) {
		tbdThongBaoPhi14 = createRestTemplate(getURL("/mard/14/tbdThongBaoPhi14/create"), tbdThongBaoPhi14, HttpMethod.POST, null, TbdThongBaoPhi14.class);
		return ResponseEntity.ok().body(tbdThongBaoPhi14);
	}

	/**
	* @param fiId - Type: Long
	* @param tbdThongBaoPhi14 - Type: TbdThongBaoPhi14
	* @return may can null
	*/
	@RequestMapping(value = "/update/{fiId}", method = RequestMethod.POST)
	public ResponseEntity<TbdThongBaoPhi14> updateTbdThongBaoPhi14(@PathVariable("fiId") Long fiId, @RequestBody @Valid TbdThongBaoPhi14 tbdThongBaoPhi14) {
		tbdThongBaoPhi14 = createRestTemplate(getURL("/mard/14/tbdThongBaoPhi14/update/") + fiId, tbdThongBaoPhi14, HttpMethod.POST, null, TbdThongBaoPhi14.class);
		return ResponseEntity.ok().body(tbdThongBaoPhi14);
	}

	/**
	* @param fiId - Type: Long
	* @return may can throw new Execption
	*/
	@RequestMapping(value = "/delete/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbdThongBaoPhi14> deleteTbdThongBaoPhi14(@PathVariable("fiId") Long fiId) {
		TbdThongBaoPhi14 tbdThongBaoPhi14 = createRestTemplate(getURL("/mard/14/tbdThongBaoPhi14/delete/") + fiId, null, HttpMethod.GET, null, TbdThongBaoPhi14.class);
		return ResponseEntity.ok().body(tbdThongBaoPhi14);
	}

	/**
	* @param fiId - Type: Long
	* @return may can null
	*/
	@RequestMapping(value = "/get/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbdThongBaoPhi14> getTbdThongBaoPhi14(@PathVariable("fiId") Long fiId) {
		TbdThongBaoPhi14 tbdThongBaoPhi14 = createRestTemplate(getURL("/mard/14/tbdThongBaoPhi14/get/") + fiId, null, HttpMethod.GET, null, TbdThongBaoPhi14.class);
		return ResponseEntity.ok().body(tbdThongBaoPhi14);
	}

	/**
	* @param pageableDTO - Type: PageableDTO
	* @return may can null
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findAll", method = RequestMethod.POST)
	public ResponseEntity<List<TbdThongBaoPhi14>> findAllTbdThongBaoPhi14(@RequestBody @Valid PageableDTO pageableDTO) {

		List<TbdThongBaoPhi14> tbdThongBaoPhi14List = createRestTemplate(getURL("/mard/14/tbdThongBaoPhi14/findAll"), pageableDTO, HttpMethod.POST, null, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdThongBaoPhi14List = mapper.convertValue(tbdThongBaoPhi14List, new TypeReference<List<TbdThongBaoPhi14>>() {});

		return ResponseEntity.ok().body(tbdThongBaoPhi14List);
	}

	/**
	 * @param fiIdHoSo - Type: Long
	 * @return can return null or throw exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findByFiIdHoSo", method = RequestMethod.GET)
	public ResponseEntity<List<TbdThongBaoPhi14DTO>> findByFiIdHoSo(@RequestParam(name = "fiIdHoSo", required = false) Long fiIdHoSo) {

		Map<String, Object> params = new HashMap<>();
		params.put("fiIdHoSo", fiIdHoSo);
		List<TbdThongBaoPhi14DTO> tbdThongBaoPhi14List = createRestTemplate(getURL("/mard/14/tbdThongBaoPhi14/findByFiIdHoSo"), null, HttpMethod.GET, params, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdThongBaoPhi14List = mapper.convertValue(tbdThongBaoPhi14List, new TypeReference<List<TbdThongBaoPhi14DTO>>() {});

		return ResponseEntity.ok().body(tbdThongBaoPhi14List);
	}

}