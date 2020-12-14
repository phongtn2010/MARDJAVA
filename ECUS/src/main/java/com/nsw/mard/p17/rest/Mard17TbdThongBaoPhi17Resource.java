package com.nsw.mard.p17.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.mard.p17.model.PageableDTO;
import com.nsw.mard.p17.model.TbdThongBaoPhi17;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.nsw.mard.p17.model.TbdThongBaoPhi17DTO;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/***
*
*
* @RestController
* @class Mard17TbdThongBaoPhi17Resource
* Created by Nguyen Van Quang
* 11/12/2018 10:07:40
*
*/
@RestController
@RequestMapping("/mard/17/tbdThongBaoPhi17")
public class Mard17TbdThongBaoPhi17Resource extends Mard17CallBack {

	/**
	* @param tbdThongBaoPhi17 - Type: TbdThongBaoPhi17
	* @return may can null
	*/
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<TbdThongBaoPhi17> createTbdThongBaoPhi17(@RequestBody @Valid TbdThongBaoPhi17 tbdThongBaoPhi17) {
		tbdThongBaoPhi17 = createRestTemplate(getURL("/mard/17/tbdThongBaoPhi17/create"), tbdThongBaoPhi17, HttpMethod.POST, null, TbdThongBaoPhi17.class);
		return ResponseEntity.ok().body(tbdThongBaoPhi17);
	}

	/**
	* @param fiId - Type: Long
	* @param tbdThongBaoPhi17 - Type: TbdThongBaoPhi17
	* @return may can null
	*/
	@RequestMapping(value = "/update/{fiId}", method = RequestMethod.POST)
	public ResponseEntity<TbdThongBaoPhi17> updateTbdThongBaoPhi17(@PathVariable("fiId") Long fiId, @RequestBody @Valid TbdThongBaoPhi17 tbdThongBaoPhi17) {
		tbdThongBaoPhi17 = createRestTemplate(getURL("/mard/17/tbdThongBaoPhi17/update/") + fiId, tbdThongBaoPhi17, HttpMethod.POST, null, TbdThongBaoPhi17.class);
		return ResponseEntity.ok().body(tbdThongBaoPhi17);
	}

	/**
	* @param fiId - Type: Long
	* @return may can throw new Execption
	*/
	@RequestMapping(value = "/delete/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbdThongBaoPhi17> deleteTbdThongBaoPhi17(@PathVariable("fiId") Long fiId) {
		TbdThongBaoPhi17 tbdThongBaoPhi17 = createRestTemplate(getURL("/mard/17/tbdThongBaoPhi17/delete/") + fiId, null, HttpMethod.GET, null, TbdThongBaoPhi17.class);
		return ResponseEntity.ok().body(tbdThongBaoPhi17);
	}

	/**
	* @param fiId - Type: Long
	* @return may can null
	*/
	@RequestMapping(value = "/get/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbdThongBaoPhi17> getTbdThongBaoPhi17(@PathVariable("fiId") Long fiId) {
		TbdThongBaoPhi17 tbdThongBaoPhi17 = createRestTemplate(getURL("/mard/17/tbdThongBaoPhi17/get/") + fiId, null, HttpMethod.GET, null, TbdThongBaoPhi17.class);
		return ResponseEntity.ok().body(tbdThongBaoPhi17);
	}

	/**
	* @param pageableDTO - Type: PageableDTO
	* @return may can null
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findAll", method = RequestMethod.POST)
	public ResponseEntity<List<TbdThongBaoPhi17>> findAllTbdThongBaoPhi17(@RequestBody @Valid PageableDTO pageableDTO) {

		List<TbdThongBaoPhi17> tbdThongBaoPhi17List = createRestTemplate(getURL("/mard/17/tbdThongBaoPhi17/findAll"), pageableDTO, HttpMethod.POST, null, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdThongBaoPhi17List = mapper.convertValue(tbdThongBaoPhi17List, new TypeReference<List<TbdThongBaoPhi17>>() {});

		return ResponseEntity.ok().body(tbdThongBaoPhi17List);
	}

	/**
	 * @param fiIdHoSo - Type: Long
	 * @return can return null or throw exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findByFiIdHoSo", method = RequestMethod.GET)
	public ResponseEntity<List<TbdThongBaoPhi17DTO>> findByFiIdHoSo(@RequestParam(name = "fiIdHoSo", required = false) Long fiIdHoSo) {

		Map<String, Object> params = new HashMap<>();
		params.put("fiIdHoSo", fiIdHoSo);
		List<TbdThongBaoPhi17DTO> tbdThongBaoPhi17List = createRestTemplate(getURL("/mard/17/tbdThongBaoPhi17/findByFiIdHoSo"), null, HttpMethod.GET, params, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdThongBaoPhi17List = mapper.convertValue(tbdThongBaoPhi17List, new TypeReference<List<TbdThongBaoPhi17DTO>>() {});

		return ResponseEntity.ok().body(tbdThongBaoPhi17List);
	}

}
