package com.nsw.moit.p06.util;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.nsw.moit.p06.model.TbsTepDinhKem6;

import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;


/***
*
*
* @BackendUtil
* @class TbsTepDinhKem6BackendUtil
* Created by Nguyen Van Quang
* 22/08/2018 13:00:37
*
*/
@Component
public class Moit06TbsTepDinhKem6BackendUtil {

	@Autowired
	private MOIT06CallBackUtil callBackUtil;

	/**
	* @param tepDinhKemId - Type: Long
	* @return may can null
	*/
	public TbsTepDinhKem6 getTbsTepDinhKem6(Long tepDinhKemId) {

		Object body = callBackUtil.createRestTemplate(callBackUtil.getURL("path.moit.06.tbsTepDinhKem6.get") + "/" + tepDinhKemId, null, HttpMethod.GET, null);
		return callBackUtil.readJsonStringToObject(body.toString(), TbsTepDinhKem6.class);
	}

	/**
	* @param loaiThuTuc - Type: String
	* @return can return null or throw exception
	 * @throws IOException 
	 * @throws JsonProcessingException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	*/
	
	public List<TbsTepDinhKem6> findByLoaiThuTuc(String loaiThuTuc) throws JsonParseException, JsonMappingException, JsonProcessingException, IOException {

		Map<String, Object> params = new HashMap<>();
		params.put("loaiThuTuc", loaiThuTuc);
		Object responseJson = callBackUtil.createRestTemplate(callBackUtil.getURL("path.moit.06.tbsTepDinhKem6.findByLoaiThuTuc"), null, HttpMethod.GET, params);
		List<TbsTepDinhKem6> tbsTepDinhKem6s = callBackUtil.readJsonStringToList(responseJson, TbsTepDinhKem6.class);
		tbsTepDinhKem6s.sort(Comparator.comparing(TbsTepDinhKem6::getOrder));
		return tbsTepDinhKem6s;
	}


}