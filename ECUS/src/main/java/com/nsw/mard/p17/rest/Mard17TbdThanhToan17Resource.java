package com.nsw.mard.p17.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.mard.p17.model.PageableDTO;
import com.nsw.mard.p17.model.TbdThanhToan17;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.nsw.mard.p17.model.TbdThanhToan17DTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/***
*
*
* @RestController
* @class Mard17TbdThanhToan17Resource
* Created by Nguyen Van Quang
* 11/12/2018 10:07:17
*
*/
@RestController
@RequestMapping("/mard/17/tbdThanhToan17")
public class Mard17TbdThanhToan17Resource extends Mard17CallBack {

	@Autowired
	private Mard17TbdKetQuaXuLy17Resource fldMard17TbdKetQuaXuLy17Resource;

	@Autowired
	private Mard17TbdHoSo17Resource fldMard17TbdHoSo17Resource;

	/**
	* @param tbdThanhToan17DTO - Type: TbdThanhToan17
	* @return may can null
	*/
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<TbdThanhToan17DTO> createTbdThanhToan17(@RequestBody @Valid TbdThanhToan17DTO tbdThanhToan17DTO) {
		if (!isValid(tbdThanhToan17DTO)) {
			return ResponseEntity.badRequest().body(tbdThanhToan17DTO);
		}
		TbdThanhToan17 tbdThanhToan17 = new TbdThanhToan17();
		BeanUtils.copyProperties(tbdThanhToan17DTO, tbdThanhToan17);
		tbdThanhToan17.setFiCreateDate(new Date());
		tbdThanhToan17 = createRestTemplate(getURL("/mard/17/tbdThanhToan17/create"), tbdThanhToan17, HttpMethod.POST, null, TbdThanhToan17.class);
		createHistory(fldMard17TbdKetQuaXuLy17Resource, fldMard17TbdHoSo17Resource, "Thanh  toán phí", tbdThanhToan17.getFiIdHoSo());
		tbdThanhToan17DTO.setFiId(tbdThanhToan17.getFiId());
		return ResponseEntity.ok().body(tbdThanhToan17DTO);
	}

	/**
	* @param fiId - Type: Long
	* @param tbdThanhToan17DTO - Type: TbdThanhToan17
	* @return may can null
	*/
	@RequestMapping(value = "/update/{fiId}", method = RequestMethod.POST)
	public ResponseEntity<TbdThanhToan17DTO> updateTbdThanhToan17(@PathVariable("fiId") Long fiId, @RequestBody @Valid TbdThanhToan17DTO tbdThanhToan17DTO) {
		if (!isValid(tbdThanhToan17DTO)) {
			return ResponseEntity.badRequest().body(tbdThanhToan17DTO);
		}
		TbdThanhToan17 tbdThanhToan17 = new TbdThanhToan17();
		BeanUtils.copyProperties(tbdThanhToan17DTO, tbdThanhToan17);
		createRestTemplate(getURL("/mard/17/tbdThanhToan17/update/") + fiId, tbdThanhToan17, HttpMethod.POST, null, TbdThanhToan17.class);
		return ResponseEntity.ok().body(tbdThanhToan17DTO);
	}

	/**
	* @param fiId - Type: Long
	* @return may can throw new Execption
	*/
	@RequestMapping(value = "/delete/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbdThanhToan17> deleteTbdThanhToan17(@PathVariable("fiId") Long fiId) {
		TbdThanhToan17 tbdThanhToan17 = createRestTemplate(getURL("/mard/17/tbdThanhToan17/delete/") + fiId, null, HttpMethod.DELETE, null, TbdThanhToan17.class);
		return ResponseEntity.ok().body(tbdThanhToan17);
	}

	/**
	* @param fiId - Type: Long
	* @return may can null
	*/
	@RequestMapping(value = "/get/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbdThanhToan17> getTbdThanhToan17(@PathVariable("fiId") Long fiId) {
		TbdThanhToan17 tbdThanhToan17 = createRestTemplate(getURL("/mard/17/tbdThanhToan17/get/") + fiId, null, HttpMethod.GET, null, TbdThanhToan17.class);
		return ResponseEntity.ok().body(tbdThanhToan17);
	}

	/**
	* @param pageableDTO - Type: PageableDTO
	* @return may can null
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findAll", method = RequestMethod.POST)
	public ResponseEntity<List<TbdThanhToan17>> findAllTbdThanhToan17(@RequestBody @Valid PageableDTO pageableDTO) {

		List<TbdThanhToan17> tbdThanhToan17List = createRestTemplate(getURL("/mard/17/tbdThanhToan17/findAll"), pageableDTO, HttpMethod.POST, null, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdThanhToan17List = mapper.convertValue(tbdThanhToan17List, new TypeReference<List<TbdThanhToan17>>() {});

		return ResponseEntity.ok().body(tbdThanhToan17List);
	}

	/**
	 * @param fiIdHoSo - Type: Long
	 * @return can return null or throw exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findByFiIdHoSo", method = RequestMethod.GET)
	public ResponseEntity<List<TbdThanhToan17DTO>> findByFiIdHoSo(@RequestParam(name = "fiIdHoSo", required = false) Long fiIdHoSo) {

		Map<String, Object> params = new HashMap<>();
		params.put("fiIdHoSo", fiIdHoSo);
		List<TbdThanhToan17DTO> tbdThanhToan17List = createRestTemplate(getURL("/mard/17/tbdThanhToan17/findByFiIdHoSo"), null, HttpMethod.GET, params, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdThanhToan17List = mapper.convertValue(tbdThanhToan17List, new TypeReference<List<TbdThanhToan17DTO>>() {});

		return ResponseEntity.ok().body(tbdThanhToan17List);
	}

}
