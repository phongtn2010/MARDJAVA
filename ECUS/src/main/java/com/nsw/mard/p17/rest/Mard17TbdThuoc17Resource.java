package com.nsw.mard.p17.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.mard.p17.model.PageableDTO;
import com.nsw.mard.p17.model.TbdThuoc17;

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
* @class Mard17TbdThuoc17Resource
* Created by Nguyen Van Quang
* 11/12/2018 10:06:176
*
*/
@RestController
@RequestMapping("/mard/17/tbdThuoc17")
public class Mard17TbdThuoc17Resource extends Mard17CallBack {



	@Autowired
	private Mard17TbdKetQuaXuLy17Resource fldMard17TbdKetQuaXuLy17Resource;

	@Autowired
	private Mard17TbdHoSo17Resource fldMard17TbdHoSo17Resource;

	/**
	* @param tbdThuoc17 - Type: TbdThuoc17
	* @return may can null
	*/
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<TbdThuoc17> createTbdThuoc17(@RequestBody @Valid TbdThuoc17 tbdThuoc17) {
		if (!isValid(tbdThuoc17)) {
			return ResponseEntity.badRequest().body(tbdThuoc17);
		}

		tbdThuoc17 = createRestTemplate(getURL("/mard/17/tbdThuoc17/create"), tbdThuoc17, HttpMethod.POST, null, TbdThuoc17.class);
		createHistory(fldMard17TbdKetQuaXuLy17Resource, fldMard17TbdHoSo17Resource, "Tạo mới thông tin thuốc: " + tbdThuoc17.getFiNameOfProduct(), tbdThuoc17.getFiIdHoSo());
		return ResponseEntity.ok().body(tbdThuoc17);
	}

	/**
	* @param fiId - Type: Long
	* @param tbdThuoc17 - Type: TbdThuoc17
	* @return may can null
	*/
	@RequestMapping(value = "/update/{fiId}", method = RequestMethod.POST)
	public ResponseEntity<TbdThuoc17> updateTbdThuoc17(@PathVariable("fiId") Long fiId, @RequestBody @Valid TbdThuoc17 tbdThuoc17) {
		if (!isValid(tbdThuoc17)) {
			return ResponseEntity.badRequest().body(tbdThuoc17);
		}

		tbdThuoc17 = createRestTemplate(getURL("/mard/17/tbdThuoc17/update/") + fiId, tbdThuoc17, HttpMethod.POST, null, TbdThuoc17.class);
		createHistory(fldMard17TbdKetQuaXuLy17Resource, fldMard17TbdHoSo17Resource,"Cập nhật thông tin thuốc: " + tbdThuoc17.getFiNameOfProduct(), tbdThuoc17.getFiIdHoSo());
		return ResponseEntity.ok().body(tbdThuoc17);
	}

	/**
	* @param fiId - Type: Long
	* @return may can throw new Execption
	*/
	@RequestMapping(value = "/delete/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbdThuoc17> deleteTbdThuoc17(@PathVariable("fiId") Long fiId) {
		TbdThuoc17 tbdThuoc17 = createRestTemplate(getURL("/mard/17/tbdThuoc17/delete/") + fiId, null, HttpMethod.DELETE, null, TbdThuoc17.class);
		createHistory(fldMard17TbdKetQuaXuLy17Resource, fldMard17TbdHoSo17Resource,"Xóa thông tin thuốc: " + tbdThuoc17.getFiNameOfProduct(), tbdThuoc17.getFiIdHoSo());
		return ResponseEntity.ok().body(tbdThuoc17);
	}

	/**
	* @param fiId - Type: Long
	* @return may can null
	*/
	@RequestMapping(value = "/get/{fiId}", method = RequestMethod.GET)
	public ResponseEntity<TbdThuoc17> getTbdThuoc17(@PathVariable("fiId") Long fiId) {
		TbdThuoc17 tbdThuoc17 = createRestTemplate(getURL("/mard/17/tbdThuoc17/get/") + fiId, null, HttpMethod.GET, null, TbdThuoc17.class);
		return ResponseEntity.ok().body(tbdThuoc17);
	}

	/**
	* @param pageableDTO - Type: PageableDTO
	* @return may can null
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findAll", method = RequestMethod.POST)
	public ResponseEntity<List<TbdThuoc17>> findAllTbdThuoc17(@RequestBody @Valid PageableDTO pageableDTO) {

		List<TbdThuoc17> tbdThuoc17List = createRestTemplate(getURL("/mard/17/tbdThuoc17/findAll"), pageableDTO, HttpMethod.POST, null, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdThuoc17List = mapper.convertValue(tbdThuoc17List, new TypeReference<List<TbdThuoc17>>() {});

		return ResponseEntity.ok().body(tbdThuoc17List);
	}

	/**
	* @param fiIdHoSo - Type: Long
	* @return can return null or throw exception
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findByFiIdHoSo", method = RequestMethod.GET)
	public ResponseEntity<List<TbdThuoc17>> findByFiIdHoSo(@RequestParam(name = "fiIdHoSo", required = false) Long fiIdHoSo) {
		Map<String, Object> params = new HashMap<>();
		params.put("fiIdHoSo", fiIdHoSo);
		List<TbdThuoc17> tbdThuoc17List = createRestTemplate(getURL("/mard/17/tbdThuoc17/findByFiIdHoSo"), null, HttpMethod.GET, params, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbdThuoc17List = mapper.convertValue(tbdThuoc17List, new TypeReference<List<TbdThuoc17>>() {});
		return ResponseEntity.ok().body(tbdThuoc17List);
	}


}
