package com.nsw.mard.p20.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.mard.p20.model.PageableDTO;
import com.nsw.mard.p20.model.TbdThuoc20;

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
* @class Mard20TbdThuoc20Resource
* Created by Nguyen Van Quang
* 11/12/2020 10:06:206
*
*/
@RestController
@RequestMapping("/mard/20/tbdThuoc20")
public class Mard20TbdThuoc20Resource extends Mard20CallBack {



	@Autowired
	private Mard20TbdKetQuaXuLy20Resource fldMard20TbdKetQuaXuLy20Resource;

	@Autowired
	private Mard20TbdHoSo20Resource fldMard20TbdHoSo20Resource;

	/**
	* @param tbdThuoc20 - Type: TbdThuoc20
	* @return may can null
	*/
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<TbdThuoc20> createTbdThuoc20(@RequestBody @Valid TbdThuoc20 tbdThuoc20) {
		if (!isValid(tbdThuoc20)) {
			return ResponseEntity.badRequest().body(tbdThuoc20);
		}

		tbdThuoc20 = createRestTemplate(getURL("/mard/18/tbdThuoc18/create"), tbdThuoc20, HttpMethod.POST, null, TbdThuoc20.class);
		createHistory(fldMard20TbdKetQuaXuLy20Resource, fldMard20TbdHoSo20Resource, "Tạo mới thông tin thuốc: " + tbdThuoc20.getFiNameOfGoods(), tbdThuoc20.getFiIdHoSo());
		return ResponseEntity.ok().body(tbdThuoc20);
	}

	/**
	* @param fiId - Type: Long
	* @param tbdThuoc20 - Type: TbdThuoc20
	* @return may can null
	*/
	@RequestMapping(value = "/update/{fiId}", method = RequestMethod.POST)
	public ResponseEntity<TbdThuoc20> updateTbdThuoc20(@PathVariable("fiId") Long fiId, @RequestBody @Valid TbdThuoc20 tbdThuoc20) {
		if (!isValid(tbdThuoc20)) {
			return ResponseEntity.badRequest().body(tbdThuoc20);
		}

		tbdThuoc20 = createRestTemplate(getURL("/mard/18/tbdThuoc18/update/") + fiId, tbdThuoc20, HttpMethod.POST, null, TbdThuoc20.class);
		createHistory(fldMard20TbdKetQuaXuLy20Resource, fldMard20TbdHoSo20Resource,"Cập nhật thông tin thuốc: " + tbdThuoc20.getFiNameOfGoods(), tbdThuoc20.getFiIdHoSo());
		return ResponseEntity.ok().body(tbdThuoc20);
	}

	/**
	* @param fiId - Type: Long
	* @return may can throw new Execption
	*/
	@RequestMapping(value = "/delete/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbdThuoc20> deleteTbdThuoc20(@PathVariable("fiId") Long fiId) {
		TbdThuoc20 tbdThuoc20 = createRestTemplate(getURL("/mard/18/tbdThuoc18/delete/") + fiId, null, HttpMethod.DELETE, null, TbdThuoc20.class);
		createHistory(fldMard20TbdKetQuaXuLy20Resource, fldMard20TbdHoSo20Resource,"Xóa thông tin thuốc: " + tbdThuoc20.getFiNameOfGoods(), tbdThuoc20.getFiIdHoSo());
		return ResponseEntity.ok().body(tbdThuoc20);
	}

	/**
	* @param fiId - Type: Long
	* @return may can null
	*/
	@RequestMapping(value = "/get/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbdThuoc20> getTbdThuoc20(@PathVariable("fiId") Long fiId) {
		TbdThuoc20 tbdThuoc20 = createRestTemplate(getURL("/mard/18/tbdThuoc18/get/") + fiId, null, HttpMethod.GET, null, TbdThuoc20.class);
		return ResponseEntity.ok().body(tbdThuoc20);
	}

	/**
	* @param pageableDTO - Type: PageableDTO
	* @return may can null
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findAll", method = RequestMethod.POST)
	public ResponseEntity<List<TbdThuoc20>> findAllTbdThuoc20(@RequestBody @Valid PageableDTO pageableDTO) {

		List<TbdThuoc20> tbdThuoc20List = createRestTemplate(getURL("/mard/18/tbdThuoc18/findAll"), pageableDTO, HttpMethod.POST, null, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdThuoc20List = mapper.convertValue(tbdThuoc20List, new TypeReference<List<TbdThuoc20>>() {});

		return ResponseEntity.ok().body(tbdThuoc20List);
	}

	/**
	* @param fiIdHoSo - Type: Long
	* @return can return null or throw exception
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findByFiIdHoSo", method = RequestMethod.GET)
	public ResponseEntity<List<TbdThuoc20>> findByFiIdHoSo(@RequestParam(name = "fiIdHoSo", required = false) Long fiIdHoSo) {

		Map<String, Object> params = new HashMap<>();
		params.put("fiIdHoSo", fiIdHoSo);
		List<TbdThuoc20> tbdThuoc20List = createRestTemplate(getURL("/mard/18/tbdThuoc18/findByFiIdHoSo"), null, HttpMethod.GET, params, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdThuoc20List = mapper.convertValue(tbdThuoc20List, new TypeReference<List<TbdThuoc20>>() {});

		return ResponseEntity.ok().body(tbdThuoc20List);
	}


}
