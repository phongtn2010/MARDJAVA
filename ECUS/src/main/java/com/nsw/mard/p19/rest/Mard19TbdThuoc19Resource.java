package com.nsw.mard.p19.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.mard.p19.model.PageableDTO;
import com.nsw.mard.p19.model.TbdThuoc19;

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
* @class Mard19TbdThuoc19Resource
* Created by Nguyen Van Quang
* 11/12/2019 10:06:196
*
*/
@RestController
@RequestMapping("/mard/19/tbdThuoc19")
public class Mard19TbdThuoc19Resource extends Mard19CallBack {



	@Autowired
	private Mard19TbdKetQuaXuLy19Resource fldMard19TbdKetQuaXuLy19Resource;

	@Autowired
	private Mard19TbdHoSo19Resource fldMard19TbdHoSo19Resource;

	/**
	* @param tbdThuoc19 - Type: TbdThuoc19
	* @return may can null
	*/
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<TbdThuoc19> createTbdThuoc19(@RequestBody @Valid TbdThuoc19 tbdThuoc19) {
		if (!isValid(tbdThuoc19)) {
			return ResponseEntity.badRequest().body(tbdThuoc19);
		}

		tbdThuoc19 = createRestTemplate(getURL("/mard/18/tbdThuoc18/create"), tbdThuoc19, HttpMethod.POST, null, TbdThuoc19.class);
		createHistory(fldMard19TbdKetQuaXuLy19Resource, fldMard19TbdHoSo19Resource, "Tạo mới thông tin thuốc: " + tbdThuoc19.getFiNameOfGoods(), tbdThuoc19.getFiIdHoSo());
		return ResponseEntity.ok().body(tbdThuoc19);
	}

	/**
	* @param fiId - Type: Long
	* @param tbdThuoc19 - Type: TbdThuoc19
	* @return may can null
	*/
	@RequestMapping(value = "/update/{fiId}", method = RequestMethod.POST)
	public ResponseEntity<TbdThuoc19> updateTbdThuoc19(@PathVariable("fiId") Long fiId, @RequestBody @Valid TbdThuoc19 tbdThuoc19) {
		if (!isValid(tbdThuoc19)) {
			return ResponseEntity.badRequest().body(tbdThuoc19);
		}

		tbdThuoc19 = createRestTemplate(getURL("/mard/18/tbdThuoc18/update/") + fiId, tbdThuoc19, HttpMethod.POST, null, TbdThuoc19.class);
		createHistory(fldMard19TbdKetQuaXuLy19Resource, fldMard19TbdHoSo19Resource,"Cập nhật thông tin thuốc: " + tbdThuoc19.getFiNameOfGoods(), tbdThuoc19.getFiIdHoSo());
		return ResponseEntity.ok().body(tbdThuoc19);
	}

	/**
	* @param fiId - Type: Long
	* @return may can throw new Execption
	*/
	@RequestMapping(value = "/delete/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbdThuoc19> deleteTbdThuoc19(@PathVariable("fiId") Long fiId) {
		TbdThuoc19 tbdThuoc19 = createRestTemplate(getURL("/mard/18/tbdThuoc18/delete/") + fiId, null, HttpMethod.DELETE, null, TbdThuoc19.class);
		createHistory(fldMard19TbdKetQuaXuLy19Resource, fldMard19TbdHoSo19Resource,"Xóa thông tin thuốc: " + tbdThuoc19.getFiNameOfGoods(), tbdThuoc19.getFiIdHoSo());
		return ResponseEntity.ok().body(tbdThuoc19);
	}

	/**
	* @param fiId - Type: Long
	* @return may can null
	*/
	@RequestMapping(value = "/get/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbdThuoc19> getTbdThuoc19(@PathVariable("fiId") Long fiId) {
		TbdThuoc19 tbdThuoc19 = createRestTemplate(getURL("/mard/18/tbdThuoc18/get/") + fiId, null, HttpMethod.GET, null, TbdThuoc19.class);
		return ResponseEntity.ok().body(tbdThuoc19);
	}

	/**
	* @param pageableDTO - Type: PageableDTO
	* @return may can null
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findAll", method = RequestMethod.POST)
	public ResponseEntity<List<TbdThuoc19>> findAllTbdThuoc19(@RequestBody @Valid PageableDTO pageableDTO) {

		List<TbdThuoc19> tbdThuoc19List = createRestTemplate(getURL("/mard/18/tbdThuoc18/findAll"), pageableDTO, HttpMethod.POST, null, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdThuoc19List = mapper.convertValue(tbdThuoc19List, new TypeReference<List<TbdThuoc19>>() {});

		return ResponseEntity.ok().body(tbdThuoc19List);
	}

	/**
	* @param fiIdHoSo - Type: Long
	* @return can return null or throw exception
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findByFiIdHoSo", method = RequestMethod.GET)
	public ResponseEntity<List<TbdThuoc19>> findByFiIdHoSo(@RequestParam(name = "fiIdHoSo", required = false) Long fiIdHoSo) {

		Map<String, Object> params = new HashMap<>();
		params.put("fiIdHoSo", fiIdHoSo);
		List<TbdThuoc19> tbdThuoc19List = createRestTemplate(getURL("/mard/18/tbdThuoc18/findByFiIdHoSo"), null, HttpMethod.GET, params, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdThuoc19List = mapper.convertValue(tbdThuoc19List, new TypeReference<List<TbdThuoc19>>() {});

		return ResponseEntity.ok().body(tbdThuoc19List);
	}


}
