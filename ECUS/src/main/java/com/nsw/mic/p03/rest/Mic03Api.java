package com.nsw.mic.p03.rest;


import javax.validation.Valid;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.common.model.json.ResponseJson;
import com.nsw.mic.p03.dto.*;
import com.nsw.mic.p03.model.*;
import com.nsw.security.UserCustom;

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
import org.springframework.web.bind.annotation.RestController;


import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(Mic03Constant.ROOT_API)
public class Mic03Api extends Mic03CallBack  {

	private static final Logger LOGGER = LoggerFactory.getLogger(Mic03Api.class);
	
	@Autowired
	private Mic03TbdHoSo03Api fldMic03TbdHoSo03Api;

	@Autowired
	private Mic03CommonApi mic03CommonApi;

	@Autowired
	private Mic03GiayPhepApi fldMic03GiayPhepApi;

	@Autowired
	private Mic03TbdKetQuaXuLy03Api fldMic03TbdKetQuaXuLy03Api;


	@RequestMapping(value = "/edit/{idHoSo}", method = RequestMethod.POST)
	public ResponseEntity<ResponseJson> edit(@PathVariable("idHoSo") Long idHoSo) {

		Form03DTO form = new Form03DTO();
		form.setDanhMucTepDinhKems(mic03CommonApi.findByLoaiThuTucOrderByFiSortAsc(Mic03Constant.DOCUMENT_TYPE));
		form.setDanhMucTinhTPs(mic03CommonApi.getTbsTinhThanhPho03s());
		TbdHoSo03DTO hoSo03DTO = new TbdHoSo03DTO();
		hoSo03DTO.setFiModifiedDate(new Date());
		form.setHoSo(hoSo03DTO);
		if (idHoSo > 0) {
			hoSo03DTO = fldMic03TbdHoSo03Api.getTbdHoSo03(idHoSo).getBody();
			form.setHoSo(hoSo03DTO);
		} else {
			UserCustom userCustom = SecurityUtil.getLoginUser();
			if (!ObjectUtils.isEmpty(userCustom)) {
				hoSo03DTO.setFiTenTCCaNhan(userCustom.getCompanyName());
				hoSo03DTO.setFiDiaChi(userCustom.getCompanyAddress());
				hoSo03DTO.setFiSoDienThoai(userCustom.getCompanyPhoneNumber());
				hoSo03DTO.setFiTaxCode(userCustom.getUsername());
				hoSo03DTO.setFiCreateDate(new Date());
				hoSo03DTO.setFiActive(1);
				hoSo03DTO.setFiIdHoSo(0L);
				hoSo03DTO.setFiStatus(0);
				hoSo03DTO.setFiDocumentType(Mic03Constant.DOCUMENT_TYPE);
			}
		}
		ResponseJson responseJson = new ResponseJson();
		responseJson.setSuccess(true);
		responseJson.setData(form);
		return ResponseEntity.ok().body(responseJson);
	}
	
	@RequestMapping(value = "/save/{idHoSo}", method = RequestMethod.POST)
	public ResponseEntity<ResponseJson> save(@PathVariable("idHoSo") Long idHoSo, @RequestBody @Valid Form03DTO form03DTO) {

		ResponseJson responseJson = new ResponseJson();
		responseJson.setData(form03DTO);
		System.out.println(form03DTO.toString());
		if (idHoSo > 0) {
			form03DTO.getHoSo().setFiModifiedDate(new Date());
			form03DTO.setHoSo(fldMic03TbdHoSo03Api.updateTbdHoSo03(idHoSo, form03DTO.getHoSo()).getBody());
			createHistory(fldMic03TbdKetQuaXuLy03Api, fldMic03TbdHoSo03Api, "Cập nhật hồ sơ", form03DTO.getHoSo().getFiIdHoSo());
		} else {
			form03DTO.getHoSo().setFiCreateDate(new Date());
			form03DTO.getHoSo().setFiModifiedDate(new Date());
			form03DTO.setHoSo(fldMic03TbdHoSo03Api.createTbdHoSo03(form03DTO.getHoSo()).getBody());
			createHistory(fldMic03TbdKetQuaXuLy03Api, fldMic03TbdHoSo03Api, "Tạo mới hồ sơ", form03DTO.getHoSo().getFiIdHoSo());
		}
		responseJson.setSuccess(true);
		return ResponseEntity.ok().body(responseJson);
	}

	@RequestMapping(value = "/send", method = RequestMethod.POST)
	public ResponseEntity<ResponseJson03> send(@RequestBody @Valid SendMessage03 sendMessage03) {

		LOGGER.info("send: {}", sendMessage03);
		ResponseJson03 responseJson03 = new ResponseJson03();
		sendMessage03.setFiTaxCode(SecurityUtil.getTaxCode());
		sendMessage03.setFiUserName(SecurityUtil.getTaxName());
		try {
			responseJson03  = createRestTemplate(getURL("/mic/03/sendAll/"), sendMessage03, HttpMethod.POST, null, ResponseJson03.class);
			responseJson03.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			responseJson03.setException(e.getLocalizedMessage());
		}

		return ResponseEntity.ok().body(responseJson03);
	}

	@RequestMapping(value = "/xoaHoSo/{fiIdHoSo}", method = RequestMethod.POST)
	public ResponseEntity<ResponseJson03> xoaHoSo(@PathVariable("fiIdHoSo") Long fiIdHoSo) {

		ResponseJson03 responseJson03 = new ResponseJson03();
		try {
			TbdHoSo03DTO tbdHoSo03DTO = fldMic03TbdHoSo03Api.getTbdHoSo03(fiIdHoSo).getBody();
			tbdHoSo03DTO.setFiActive(0);
			fldMic03TbdHoSo03Api.updateTbdHoSo03(fiIdHoSo, tbdHoSo03DTO);
			responseJson03.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			responseJson03.setException(e.getLocalizedMessage());
		}

		return ResponseEntity.ok().body(responseJson03);
	}

	/**
	 * @return may can null
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findAllStatus", method = RequestMethod.POST)
	public ResponseEntity<ResponseJson> findAllTbsTrangThai03() {

		List<TbsTrangThai03> tbsTrangThai03List = createRestTemplate(getURL("/mic/03/tbsTrangThai03/findByDocumentType/" + Mic03Constant.DOCUMENT_TYPE), null, HttpMethod.GET, null, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbsTrangThai03List = mapper.convertValue(tbsTrangThai03List, new TypeReference<List<TbsTrangThai03>>() {});

		ResponseJson responseJson = new ResponseJson();
		responseJson.setSuccess(true);
		responseJson.setData(tbsTrangThai03List);
		return ResponseEntity.ok().body(responseJson);
	}

}
