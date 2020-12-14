package com.nsw.mic.p04.rest;


import javax.validation.Valid;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsw.common.model.json.ResponseJson;
import com.nsw.mic.p04.dto.*;
import com.nsw.mic.p04.model.*;
import com.nsw.mic.p03.rest.Mic03CommonApi;
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
@RequestMapping(Mic04Constant.ROOT_API)
public class Mic04Api extends Mic04CallBack  {

	private static final Logger LOGGER = LoggerFactory.getLogger(Mic04Api.class);
	
	@Autowired
	private Mic04TbdHoSo04Api fldMic04TbdHoSo04Api;

	@Autowired
	private Mic03CommonApi mic03CommonApi;

	@Autowired
	private Mic04GiayPhepApi fldMic04GiayPhepApi;

	@Autowired
	private Mic04TbdKetQuaXuLy04Api fldMic04TbdKetQuaXuLy04Api;

	@RequestMapping(value = "/edit/{idHoSo}", method = RequestMethod.POST)
	public ResponseEntity<ResponseJson> edit(@PathVariable("idHoSo") Long idHoSo) {

		Form04DTO form = new Form04DTO();
		form.setDanhMucTepDinhKems(mic03CommonApi.findByLoaiThuTucOrderByFiSortAsc(Mic04Constant.DOCUMENT_TYPE));
		form.setDanhMucTinhTPs(mic03CommonApi.getTbsTinhThanhPho03s());
		TbdHoSo04DTO hoSo04DTO = new TbdHoSo04DTO();
		hoSo04DTO.setFiModifiedDate(new Date());
		form.setHoSo(hoSo04DTO);
		if (idHoSo > 0) {
			hoSo04DTO = fldMic04TbdHoSo04Api.getTbdHoSo04(idHoSo).getBody();
			form.setHoSo(hoSo04DTO);
		} else {
			UserCustom userCustom = SecurityUtil.getLoginUser();
			if (!ObjectUtils.isEmpty(userCustom)) {
				hoSo04DTO.setFiTenTCCaNhan(userCustom.getCompanyName());
				hoSo04DTO.setFiDiaChi(userCustom.getCompanyAddress());
				hoSo04DTO.setFiSoDienThoai(userCustom.getCompanyPhoneNumber());
				hoSo04DTO.setFiTaxCode(userCustom.getUsername());
				hoSo04DTO.setFiCreateDate(new Date());
				hoSo04DTO.setFiActive(1);
				hoSo04DTO.setFiIdHoSo(0L);
				hoSo04DTO.setFiStatus(0);
				hoSo04DTO.setFiDocumentType(Mic04Constant.DOCUMENT_TYPE);
			}
		}
		ResponseJson responseJson = new ResponseJson();
		responseJson.setSuccess(true);
		responseJson.setData(form);
		return ResponseEntity.ok().body(responseJson);
	}
	
	@RequestMapping(value = "/save/{idHoSo}", method = RequestMethod.POST)
	public ResponseEntity<ResponseJson> save(@PathVariable("idHoSo") Long idHoSo, @RequestBody @Valid Form04DTO form04DTO) {

		ResponseJson responseJson = new ResponseJson();
		responseJson.setData(form04DTO);
		System.out.println(form04DTO.toString());
		if (idHoSo > 0) {
			form04DTO.getHoSo().setFiModifiedDate(new Date());
			form04DTO.setHoSo(fldMic04TbdHoSo04Api.updateTbdHoSo04(idHoSo, form04DTO.getHoSo()).getBody());
			createHistory(fldMic04TbdKetQuaXuLy04Api, fldMic04TbdHoSo04Api, "Cập nhật hồ sơ", form04DTO.getHoSo().getFiIdHoSo());
		} else {
			form04DTO.getHoSo().setFiCreateDate(new Date());
			form04DTO.getHoSo().setFiModifiedDate(new Date());
			form04DTO.setHoSo(fldMic04TbdHoSo04Api.createTbdHoSo04(form04DTO.getHoSo()).getBody());
			createHistory(fldMic04TbdKetQuaXuLy04Api, fldMic04TbdHoSo04Api, "Tạo mới hồ sơ", form04DTO.getHoSo().getFiIdHoSo());
		}
		responseJson.setSuccess(true);
		return ResponseEntity.ok().body(responseJson);
	}

	@RequestMapping(value = "/send", method = RequestMethod.POST)
	public ResponseEntity<ResponseJson04> send(@RequestBody @Valid SendMessage04 sendMessage04) {

		LOGGER.info("send: {}", sendMessage04);
		ResponseJson04 responseJson04 = new ResponseJson04();
		sendMessage04.setFiTaxCode(SecurityUtil.getTaxCode());
		sendMessage04.setFiUserName(SecurityUtil.getTaxName());
		try {
			responseJson04  = createRestTemplate(getURL("/mic/04/sendAll/"), sendMessage04, HttpMethod.POST, null, ResponseJson04.class);
			responseJson04.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			responseJson04.setException(e.getLocalizedMessage());
		}

		return ResponseEntity.ok().body(responseJson04);
	}

	@RequestMapping(value = "/xoaHoSo/{fiIdHoSo}", method = RequestMethod.POST)
	public ResponseEntity<ResponseJson04> xoaHoSo(@PathVariable("fiIdHoSo") Long fiIdHoSo) {

		ResponseJson04 responseJson04 = new ResponseJson04();
		try {
			TbdHoSo04DTO tbdHoSo04DTO = fldMic04TbdHoSo04Api.getTbdHoSo04(fiIdHoSo).getBody();
			tbdHoSo04DTO.setFiActive(0);
			fldMic04TbdHoSo04Api.updateTbdHoSo04(fiIdHoSo, tbdHoSo04DTO);
			responseJson04.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			responseJson04.setException(e.getLocalizedMessage());
		}

		return ResponseEntity.ok().body(responseJson04);
	}

	/**
	 * @return may can null
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findAllStatus", method = RequestMethod.POST)
	public ResponseEntity<ResponseJson> findAllTbsTrangThai04() {

		List<TbsTrangThai04> tbsTrangThai04List = createRestTemplate(getURL("/mic/04/tbsTrangThai04/findByDocumentType/" + Mic04Constant.DOCUMENT_TYPE), null, HttpMethod.GET, null, List.class);
		ObjectMapper mapper = new ObjectMapper();
		tbsTrangThai04List = mapper.convertValue(tbsTrangThai04List, new TypeReference<List<TbsTrangThai04>>() {});

		ResponseJson responseJson = new ResponseJson();
		responseJson.setSuccess(true);
		responseJson.setData(tbsTrangThai04List);
		return ResponseEntity.ok().body(responseJson);
	}

}
