package com.nsw.mard.p14.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.mard.p14.model.PageableDTO;
import com.nsw.mard.p14.model.TbdThanhToan14;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.nsw.mard.p14.model.TbdThanhToan14DTO;
import com.nsw.mard.p14.model.TbdThuoc14;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/***
*
*
* @RestController
* @class Mard14TbdThanhToan14Resource
* Created by Nguyen Van Quang
* 11/12/2018 10:07:24
*
*/
@RestController
@RequestMapping("/mard/14/tbdThanhToan14")
public class Mard14TbdThanhToan14Resource extends Mard14CallBack {

	@Autowired
	private Mard14TbdKetQuaXuLy14Resource fldMard14TbdKetQuaXuLy14Resource;

	@Autowired
	private Mard14TbdHoSo14Resource fldMard14TbdHoSo14Resource;

	/**
	* @param tbdThanhToan14DTO - Type: TbdThanhToan14
	* @return may can null
	*/
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<TbdThanhToan14DTO> createTbdThanhToan14(@RequestBody @Valid TbdThanhToan14DTO tbdThanhToan14DTO) {
		if (!isValid(tbdThanhToan14DTO)) {
			return ResponseEntity.badRequest().body(tbdThanhToan14DTO);
		}
		TbdThanhToan14 tbdThanhToan14 = new TbdThanhToan14();
		BeanUtils.copyProperties(tbdThanhToan14DTO, tbdThanhToan14);
		tbdThanhToan14.setFiCreateDate(new Date());
		tbdThanhToan14 = createRestTemplate(getURL("/mard/14/tbdThanhToan14/create"), tbdThanhToan14, HttpMethod.POST, null, TbdThanhToan14.class);
		createHistory(fldMard14TbdKetQuaXuLy14Resource, fldMard14TbdHoSo14Resource, "Thanh  toán phí", tbdThanhToan14.getFiIdHoSo());
		tbdThanhToan14DTO.setFiId(tbdThanhToan14.getFiId());
		return ResponseEntity.ok().body(tbdThanhToan14DTO);
	}

	/**
	* @param fiId - Type: Long
	* @param tbdThanhToan14DTO - Type: TbdThanhToan14
	* @return may can null
	*/
	@RequestMapping(value = "/update/{fiId}", method = RequestMethod.POST)
	public ResponseEntity<TbdThanhToan14DTO> updateTbdThanhToan14(@PathVariable("fiId") Long fiId, @RequestBody @Valid TbdThanhToan14DTO tbdThanhToan14DTO) {
		if (!isValid(tbdThanhToan14DTO)) {
			return ResponseEntity.badRequest().body(tbdThanhToan14DTO);
		}
		TbdThanhToan14 tbdThanhToan14 = new TbdThanhToan14();
		BeanUtils.copyProperties(tbdThanhToan14DTO, tbdThanhToan14);
		createRestTemplate(getURL("/mard/14/tbdThanhToan14/update/") + fiId, tbdThanhToan14, HttpMethod.POST, null, TbdThanhToan14.class);
		return ResponseEntity.ok().body(tbdThanhToan14DTO);
	}

	/**
	* @param fiId - Type: Long
	* @return may can throw new Execption
	*/
	@RequestMapping(value = "/delete/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbdThanhToan14> deleteTbdThanhToan14(@PathVariable("fiId") Long fiId) {
		TbdThanhToan14 tbdThanhToan14 = createRestTemplate(getURL("/mard/14/tbdThanhToan14/delete/") + fiId, null, HttpMethod.DELETE, null, TbdThanhToan14.class);
		return ResponseEntity.ok().body(tbdThanhToan14);
	}

	/**
	* @param fiId - Type: Long
	* @return may can null
	*/
	@RequestMapping(value = "/get/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbdThanhToan14> getTbdThanhToan14(@PathVariable("fiId") Long fiId) {
		TbdThanhToan14 tbdThanhToan14 = createRestTemplate(getURL("/mard/14/tbdThanhToan14/get/") + fiId, null, HttpMethod.GET, null, TbdThanhToan14.class);
		return ResponseEntity.ok().body(tbdThanhToan14);
	}

	/**
	* @param pageableDTO - Type: PageableDTO
	* @return may can null
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findAll", method = RequestMethod.POST)
	public ResponseEntity<List<TbdThanhToan14>> findAllTbdThanhToan14(@RequestBody @Valid PageableDTO pageableDTO) {

		List<TbdThanhToan14> tbdThanhToan14List = createRestTemplate(getURL("/mard/14/tbdThanhToan14/findAll"), pageableDTO, HttpMethod.POST, null, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdThanhToan14List = mapper.convertValue(tbdThanhToan14List, new TypeReference<List<TbdThanhToan14>>() {});

		return ResponseEntity.ok().body(tbdThanhToan14List);
	}

	/**
	 * @param fiIdHoSo - Type: Long
	 * @return can return null or throw exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findByFiIdHoSo", method = RequestMethod.GET)
	public ResponseEntity<List<TbdThanhToan14DTO>> findByFiIdHoSo(@RequestParam(name = "fiIdHoSo", required = false) Long fiIdHoSo) {

		Map<String, Object> params = new HashMap<>();
		params.put("fiIdHoSo", fiIdHoSo);
		List<TbdThanhToan14DTO> tbdThanhToan14List = createRestTemplate(getURL("/mard/14/tbdThanhToan14/findByFiIdHoSo"), null, HttpMethod.GET, params, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdThanhToan14List = mapper.convertValue(tbdThanhToan14List, new TypeReference<List<TbdThanhToan14DTO>>() {});

		return ResponseEntity.ok().body(tbdThanhToan14List);
	}

}