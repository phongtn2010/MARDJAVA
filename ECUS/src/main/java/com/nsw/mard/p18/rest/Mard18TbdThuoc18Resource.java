package com.nsw.mard.p18.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.mard.p18.model.PageableDTO;
import com.nsw.mard.p18.model.TbdThuoc18;

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
* @class Mard18TbdThuoc18Resource
* Created by Nguyen Van Quang
* 11/12/2018 10:06:186
*
*/
@RestController
@RequestMapping("/mard/18/tbdThuoc18")
public class Mard18TbdThuoc18Resource extends Mard18CallBack {

	@Autowired
	private Mard18TbdKetQuaXuLy18Resource fldMard18TbdKetQuaXuLy18Resource;

	@Autowired
	private Mard18TbdHoSo18Resource fldMard18TbdHoSo18Resource;

	/**
	* @param tbdThuoc18 - Type: TbdThuoc18
	* @return may can null
	*/
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<TbdThuoc18> createTbdThuoc18(@RequestBody @Valid TbdThuoc18 tbdThuoc18) {
		if (!isValid(tbdThuoc18)) {
			return ResponseEntity.badRequest().body(tbdThuoc18);
		}

		tbdThuoc18 = createRestTemplate(getURL("/mard/18/tbdThuoc18/create"), tbdThuoc18, HttpMethod.POST, null, TbdThuoc18.class);
		createHistory(fldMard18TbdKetQuaXuLy18Resource, fldMard18TbdHoSo18Resource, "Tạo mới thông tin thuốc: " + tbdThuoc18.getFiNameOfGoods(), tbdThuoc18.getFiIdHoSo());
		return ResponseEntity.ok().body(tbdThuoc18);
	}

	/**
	* @param fiId - Type: Long
	* @param tbdThuoc18 - Type: TbdThuoc18
	* @return may can null
	*/
	@RequestMapping(value = "/update/{fiId}", method = RequestMethod.POST)
	public ResponseEntity<TbdThuoc18> updateTbdThuoc18(@PathVariable("fiId") Long fiId, @RequestBody @Valid TbdThuoc18 tbdThuoc18) {
		if (!isValid(tbdThuoc18)) {
			return ResponseEntity.badRequest().body(tbdThuoc18);
		}

		tbdThuoc18 = createRestTemplate(getURL("/mard/18/tbdThuoc18/update/") + fiId, tbdThuoc18, HttpMethod.POST, null, TbdThuoc18.class);
		createHistory(fldMard18TbdKetQuaXuLy18Resource, fldMard18TbdHoSo18Resource,"Cập nhật thông tin thuốc: " + tbdThuoc18.getFiNameOfGoods(), tbdThuoc18.getFiIdHoSo());
		return ResponseEntity.ok().body(tbdThuoc18);
	}

	/**
	* @param fiId - Type: Long
	* @return may can throw new Execption
	*/
	@RequestMapping(value = "/delete/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbdThuoc18> deleteTbdThuoc18(@PathVariable("fiId") Long fiId) {
		TbdThuoc18 tbdThuoc18 = createRestTemplate(getURL("/mard/18/tbdThuoc18/delete/") + fiId, null, HttpMethod.DELETE, null, TbdThuoc18.class);
		createHistory(fldMard18TbdKetQuaXuLy18Resource, fldMard18TbdHoSo18Resource,"Xóa thông tin thuốc: " + tbdThuoc18.getFiNameOfGoods(), tbdThuoc18.getFiIdHoSo());
		return ResponseEntity.ok().body(tbdThuoc18);
	}

	/**
	* @param fiId - Type: Long
	* @return may can null
	*/
	@RequestMapping(value = "/get/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbdThuoc18> getTbdThuoc18(@PathVariable("fiId") Long fiId) {
		TbdThuoc18 tbdThuoc18 = createRestTemplate(getURL("/mard/18/tbdThuoc18/get/") + fiId, null, HttpMethod.GET, null, TbdThuoc18.class);
		return ResponseEntity.ok().body(tbdThuoc18);
	}

	/**
	* @param pageableDTO - Type: PageableDTO
	* @return may can null
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findAll", method = RequestMethod.POST)
	public ResponseEntity<List<TbdThuoc18>> findAllTbdThuoc18(@RequestBody @Valid PageableDTO pageableDTO) {

		List<TbdThuoc18> tbdThuoc18List = createRestTemplate(getURL("/mard/18/tbdThuoc18/findAll"), pageableDTO, HttpMethod.POST, null, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdThuoc18List = mapper.convertValue(tbdThuoc18List, new TypeReference<List<TbdThuoc18>>() {});

		return ResponseEntity.ok().body(tbdThuoc18List);
	}

	/**
	* @param fiIdHoSo - Type: Long
	* @return can return null or throw exception
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findByFiIdHoSo", method = RequestMethod.GET)
	public ResponseEntity<List<TbdThuoc18>> findByFiIdHoSo(@RequestParam(name = "fiIdHoSo", required = false) Long fiIdHoSo) {

		Map<String, Object> params = new HashMap<>();
		params.put("fiIdHoSo", fiIdHoSo);
		List<TbdThuoc18> tbdThuoc18List = createRestTemplate(getURL("/mard/18/tbdThuoc18/findByFiIdHoSo"), null, HttpMethod.GET, params, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdThuoc18List = mapper.convertValue(tbdThuoc18List, new TypeReference<List<TbdThuoc18>>() {});

		return ResponseEntity.ok().body(tbdThuoc18List);
	}


}
