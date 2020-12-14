package com.nsw.mard.p14.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.mard.p14.model.PageableDTO;
import com.nsw.mard.p14.model.TbdThuoc14;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
* @class Mard14TbdThuoc14Resource
* Created by Nguyen Van Quang
* 11/12/2018 10:06:146
*
*/
@RestController
@RequestMapping("/mard/14/tbdThuoc14")
public class Mard14TbdThuoc14Resource extends Mard14CallBack {

	@Autowired
	private Mard14TbdKetQuaXuLy14Resource fldMard14TbdKetQuaXuLy14Resource;

	@Autowired
	private Mard14TbdHoSo14Resource fldMard14TbdHoSo14Resource;

	/**
	* @param tbdThuoc14 - Type: TbdThuoc14
	* @return may can null
	*/
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<TbdThuoc14> createTbdThuoc14(@RequestBody @Valid TbdThuoc14 tbdThuoc14) {
		if (!isValid(tbdThuoc14)) {
			return ResponseEntity.badRequest().body(tbdThuoc14);
		}
		tbdThuoc14 = createRestTemplate(getURL("/mard/14/tbdThuoc14/create"), tbdThuoc14, HttpMethod.POST, null, TbdThuoc14.class);
		createHistory(fldMard14TbdKetQuaXuLy14Resource, fldMard14TbdHoSo14Resource, "Tạo mới thông tin thuốc: " + tbdThuoc14.getFiNameOfGoods(), tbdThuoc14.getFiIdHoSo());
		return ResponseEntity.ok().body(tbdThuoc14);
	}

	/**
	* @param fiId - Type: Long
	* @param tbdThuoc14 - Type: TbdThuoc14
	* @return may can null
	*/
	@RequestMapping(value = "/update/{fiId}", method = RequestMethod.POST)
	public ResponseEntity<TbdThuoc14> updateTbdThuoc14(@PathVariable("fiId") Long fiId, @RequestBody @Valid TbdThuoc14 tbdThuoc14) {
		if (!isValid(tbdThuoc14)) {
			return ResponseEntity.badRequest().body(tbdThuoc14);
		}
		tbdThuoc14 = createRestTemplate(getURL("/mard/14/tbdThuoc14/update/") + fiId, tbdThuoc14, HttpMethod.POST, null, TbdThuoc14.class);
		createHistory(fldMard14TbdKetQuaXuLy14Resource, fldMard14TbdHoSo14Resource,"Cập nhật thông tin thuốc: " + tbdThuoc14.getFiNameOfGoods(), tbdThuoc14.getFiIdHoSo());
		return ResponseEntity.ok().body(tbdThuoc14);
	}

	/**
	* @param fiId - Type: Long
	* @return may can throw new Execption
	*/
	@RequestMapping(value = "/delete/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbdThuoc14> deleteTbdThuoc14(@PathVariable("fiId") Long fiId) {
		TbdThuoc14 tbdThuoc14 = createRestTemplate(getURL("/mard/14/tbdThuoc14/delete/") + fiId, null, HttpMethod.DELETE, null, TbdThuoc14.class);
		createHistory(fldMard14TbdKetQuaXuLy14Resource, fldMard14TbdHoSo14Resource,"Xóa thông tin thuốc: " + tbdThuoc14.getFiNameOfGoods(), tbdThuoc14.getFiIdHoSo());
		return ResponseEntity.ok().body(tbdThuoc14);
	}

	/**
	* @param fiId - Type: Long
	* @return may can null
	*/
	@RequestMapping(value = "/get/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbdThuoc14> getTbdThuoc14(@PathVariable("fiId") Long fiId) {
		TbdThuoc14 tbdThuoc14 = createRestTemplate(getURL("/mard/14/tbdThuoc14/get/") + fiId, null, HttpMethod.GET, null, TbdThuoc14.class);
		return ResponseEntity.ok().body(tbdThuoc14);
	}

	/**
	* @param pageableDTO - Type: PageableDTO
	* @return may can null
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findAll", method = RequestMethod.POST)
	public ResponseEntity<List<TbdThuoc14>> findAllTbdThuoc14(@RequestBody @Valid PageableDTO pageableDTO) {

		List<TbdThuoc14> tbdThuoc14List = createRestTemplate(getURL("/mard/14/tbdThuoc14/findAll"), pageableDTO, HttpMethod.POST, null, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdThuoc14List = mapper.convertValue(tbdThuoc14List, new TypeReference<List<TbdThuoc14>>() {});

		return ResponseEntity.ok().body(tbdThuoc14List);
	}

	/**
	* @param fiIdHoSo - Type: Long
	* @return can return null or throw exception
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findByFiIdHoSo", method = RequestMethod.GET)
	public ResponseEntity<List<TbdThuoc14>> findByFiIdHoSo(@RequestParam(name = "fiIdHoSo", required = false) Long fiIdHoSo) {

		Map<String, Object> params = new HashMap<>();
		params.put("fiIdHoSo", fiIdHoSo);
		List<TbdThuoc14> tbdThuoc14List = createRestTemplate(getURL("/mard/14/tbdThuoc14/findByFiIdHoSo"), null, HttpMethod.GET, params, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdThuoc14List = mapper.convertValue(tbdThuoc14List, new TypeReference<List<TbdThuoc14>>() {});

		return ResponseEntity.ok().body(tbdThuoc14List);
	}


}