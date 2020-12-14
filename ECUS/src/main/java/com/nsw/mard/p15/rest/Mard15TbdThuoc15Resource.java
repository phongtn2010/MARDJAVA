package com.nsw.mard.p15.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.mard.p15.model.PageableDTO;
import com.nsw.mard.p15.model.TbdThuoc15;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.*;

import org.apache.poi.ss.formula.functions.T;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
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
* @class Mard15TbdThuoc15Resource
* Created by Nguyen Van Quang
* 11/12/2018 10:06:156
*
*/
@RestController
@RequestMapping("/mard/15/tbdThuoc15")
public class Mard15TbdThuoc15Resource extends Mard15CallBack {

	private static final Logger LOGGER = LoggerFactory.getLogger(Mard15TbdThuoc15Resource.class);

	@Autowired
	private Mard15TbdKetQuaXuLy15Resource fldMard15TbdKetQuaXuLy15Resource;

	@Autowired
	private Mard15TbdHoSo15Resource fldMard15TbdHoSo15Resource;

	/**
	* @param tbdThuoc15 - Type: TbdThuoc15
	* @return may can null
	*/
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<TbdThuoc15> createTbdThuoc15(@RequestBody @Valid TbdThuoc15 tbdThuoc15) {
		if (!isValid(tbdThuoc15)) {
			return ResponseEntity.badRequest().body(tbdThuoc15);
		}
		tbdThuoc15 = createRestTemplate(getURL("/mard/15/tbdThuoc15/create"), tbdThuoc15, HttpMethod.POST, null, TbdThuoc15.class);
		createHistory(fldMard15TbdKetQuaXuLy15Resource, fldMard15TbdHoSo15Resource, "Tạo mới thông tin thuốc: " + tbdThuoc15.getFiNameOfGoods(), tbdThuoc15.getFiIdHoSo());
		return ResponseEntity.ok().body(tbdThuoc15);
	}

	/**
	* @param fiId - Type: Long
	* @param tbdThuoc15 - Type: TbdThuoc15
	* @return may can null
	*/
	@RequestMapping(value = "/update/{fiId}", method = RequestMethod.POST)
	public ResponseEntity<TbdThuoc15> updateTbdThuoc15(@PathVariable("fiId") Long fiId, @RequestBody @Valid TbdThuoc15 tbdThuoc15) {
		if (!isValid(tbdThuoc15)) {
			return ResponseEntity.badRequest().body(tbdThuoc15);
		}
		tbdThuoc15 = createRestTemplate(getURL("/mard/15/tbdThuoc15/update/") + fiId, tbdThuoc15, HttpMethod.POST, null, TbdThuoc15.class);
		createHistory(fldMard15TbdKetQuaXuLy15Resource, fldMard15TbdHoSo15Resource,"Cập nhật thông tin thuốc: " + tbdThuoc15.getFiNameOfGoods(), tbdThuoc15.getFiIdHoSo());
		return ResponseEntity.ok().body(tbdThuoc15);
	}

	/**
	* @param fiId - Type: Long
	* @return may can throw new Execption
	*/
	@RequestMapping(value = "/delete/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbdThuoc15> deleteTbdThuoc15(@PathVariable("fiId") Long fiId) {
		TbdThuoc15 tbdThuoc15 = createRestTemplate(getURL("/mard/15/tbdThuoc15/delete/") + fiId, null, HttpMethod.DELETE, null, TbdThuoc15.class);
		createHistory(fldMard15TbdKetQuaXuLy15Resource, fldMard15TbdHoSo15Resource,"Xóa thông tin thuốc: " + tbdThuoc15.getFiNameOfGoods(), tbdThuoc15.getFiIdHoSo());
		return ResponseEntity.ok().body(tbdThuoc15);
	}

	/**
	* @param fiId - Type: Long
	* @return may can null
	*/
	@RequestMapping(value = "/get/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbdThuoc15> getTbdThuoc15(@PathVariable("fiId") Long fiId) {
		TbdThuoc15 tbdThuoc15 = createRestTemplate(getURL("/mard/15/tbdThuoc15/get/") + fiId, null, HttpMethod.GET, null, TbdThuoc15.class);
		return ResponseEntity.ok().body(tbdThuoc15);
	}

	/**
	* @param pageableDTO - Type: PageableDTO
	* @return may can null
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findAll", method = RequestMethod.POST)
	public ResponseEntity<List<TbdThuoc15>> findAllTbdThuoc15(@RequestBody @Valid PageableDTO pageableDTO) {

		List<TbdThuoc15> tbdThuoc15List = createRestTemplate(getURL("/mard/15/tbdThuoc15/findAll"), pageableDTO, HttpMethod.POST, null, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdThuoc15List = mapper.convertValue(tbdThuoc15List, new TypeReference<List<TbdThuoc15>>() {});

		return ResponseEntity.ok().body(tbdThuoc15List);
	}

	/**
	* @param fiIdHoSo - Type: Long
	* @return can return null or throw exception
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findByFiIdHoSo", method = RequestMethod.GET)
	public ResponseEntity<List<TbdThuoc15>> findByFiIdHoSo(@RequestParam(name = "fiIdHoSo", required = false) Long fiIdHoSo) {

		Map<String, Object> params = new HashMap<>();
		params.put("fiIdHoSo", fiIdHoSo);
		List<TbdThuoc15> tbdThuoc15List = createRestTemplate(getURL("/mard/15/tbdThuoc15/findByFiIdHoSo"), null, HttpMethod.GET, params, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdThuoc15List = mapper.convertValue(tbdThuoc15List, new TypeReference<List<TbdThuoc15>>() {});

		return ResponseEntity.ok().body(tbdThuoc15List);
	}


}