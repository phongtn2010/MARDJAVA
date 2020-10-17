package com.nsw.mard.p16.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.mard.p16.model.PageableDTO;
import com.nsw.mard.p16.model.TbdThuoc16;

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
* @class Mard16TbdThuoc16Resource
* Created by Nguyen Van Quang
* 11/12/2018 10:06:166
*
*/
@RestController
@RequestMapping("/mard/16/tbdThuoc16")
public class Mard16TbdThuoc16Resource extends Mard16CallBack {

	private static final Logger LOGGER = LoggerFactory.getLogger(Mard16TbdThuoc16Resource.class);

	@Autowired
	private Mard16TbdKetQuaXuLy16Resource fldMard16TbdKetQuaXuLy16Resource;

	@Autowired
	private Mard16TbdHoSo16Resource fldMard16TbdHoSo16Resource;

	/**
	* @param tbdThuoc16 - Type: TbdThuoc16
	* @return may can null
	*/
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<TbdThuoc16> createTbdThuoc16(@RequestBody @Valid TbdThuoc16 tbdThuoc16) {
		if (!isValid(tbdThuoc16)) {
			return ResponseEntity.badRequest().body(tbdThuoc16);
		}
		tbdThuoc16 = createRestTemplate(getURL("/mard/16/tbdThuoc16/create"), tbdThuoc16, HttpMethod.POST, null, TbdThuoc16.class);
		createHistory(fldMard16TbdKetQuaXuLy16Resource, fldMard16TbdHoSo16Resource, "Tạo mới thông tin thuốc: " + tbdThuoc16.getFiNameOfGoods(), tbdThuoc16.getFiIdHoSo());
		return ResponseEntity.ok().body(tbdThuoc16);
	}

	/**
	* @param fiId - Type: Long
	* @param tbdThuoc16 - Type: TbdThuoc16
	* @return may can null
	*/
	@RequestMapping(value = "/update/{fiId}", method = RequestMethod.POST)
	public ResponseEntity<TbdThuoc16> updateTbdThuoc16(@PathVariable("fiId") Long fiId, @RequestBody @Valid TbdThuoc16 tbdThuoc16) {
		if (!isValid(tbdThuoc16)) {
			return ResponseEntity.badRequest().body(tbdThuoc16);
		}
		tbdThuoc16 = createRestTemplate(getURL("/mard/16/tbdThuoc16/update/") + fiId, tbdThuoc16, HttpMethod.POST, null, TbdThuoc16.class);
		createHistory(fldMard16TbdKetQuaXuLy16Resource, fldMard16TbdHoSo16Resource,"Cập nhật thông tin thuốc: " + tbdThuoc16.getFiNameOfGoods(), tbdThuoc16.getFiIdHoSo());
		return ResponseEntity.ok().body(tbdThuoc16);
	}

	/**
	* @param fiId - Type: Long
	* @return may can throw new Execption
	*/
	@RequestMapping(value = "/delete/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbdThuoc16> deleteTbdThuoc16(@PathVariable("fiId") Long fiId) {
		TbdThuoc16 tbdThuoc16 = createRestTemplate(getURL("/mard/16/tbdThuoc16/delete/") + fiId, null, HttpMethod.DELETE, null, TbdThuoc16.class);
		createHistory(fldMard16TbdKetQuaXuLy16Resource, fldMard16TbdHoSo16Resource,"Xóa thông tin thuốc: " + tbdThuoc16.getFiNameOfGoods(), tbdThuoc16.getFiIdHoSo());
		return ResponseEntity.ok().body(tbdThuoc16);
	}

	/**
	* @param fiId - Type: Long
	* @return may can null
	*/
	@RequestMapping(value = "/get/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbdThuoc16> getTbdThuoc16(@PathVariable("fiId") Long fiId) {
		TbdThuoc16 tbdThuoc16 = createRestTemplate(getURL("/mard/16/tbdThuoc16/get/") + fiId, null, HttpMethod.GET, null, TbdThuoc16.class);
		return ResponseEntity.ok().body(tbdThuoc16);
	}

	/**
	* @param pageableDTO - Type: PageableDTO
	* @return may can null
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findAll", method = RequestMethod.POST)
	public ResponseEntity<List<TbdThuoc16>> findAllTbdThuoc16(@RequestBody @Valid PageableDTO pageableDTO) {

		List<TbdThuoc16> tbdThuoc16List = createRestTemplate(getURL("/mard/16/tbdThuoc16/findAll"), pageableDTO, HttpMethod.POST, null, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdThuoc16List = mapper.convertValue(tbdThuoc16List, new TypeReference<List<TbdThuoc16>>() {});

		return ResponseEntity.ok().body(tbdThuoc16List);
	}

	/**
	* @param fiIdHoSo - Type: Long
	* @return can return null or throw exception
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findByFiIdHoSo", method = RequestMethod.GET)
	public ResponseEntity<List<TbdThuoc16>> findByFiIdHoSo(@RequestParam(name = "fiIdHoSo", required = false) Long fiIdHoSo) {

		Map<String, Object> params = new HashMap<>();
		params.put("fiIdHoSo", fiIdHoSo);
		List<TbdThuoc16> tbdThuoc16List = createRestTemplate(getURL("/mard/16/tbdThuoc16/findByFiIdHoSo"), null, HttpMethod.GET, params, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdThuoc16List = mapper.convertValue(tbdThuoc16List, new TypeReference<List<TbdThuoc16>>() {});

		return ResponseEntity.ok().body(tbdThuoc16List);
	}


}