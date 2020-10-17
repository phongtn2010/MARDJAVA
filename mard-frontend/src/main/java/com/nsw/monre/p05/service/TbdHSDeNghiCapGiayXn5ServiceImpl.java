package com.nsw.monre.p05.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import com.nsw.monre.p05.constant.ThuTuc05Constant;
import com.nsw.monre.p01.constant.ThuTuc01Constant;
import com.nsw.monre.p05.constant.ThuTuc05BackendUriConstant;
import com.nsw.monre.p05.searchitem.TbdHSDeNghiCapGiayXn5SearchItem;
import com.nsw.monre.p05.model.TbdHSDeNghiCapGiayXn5;
import org.springframework.http.HttpMethod;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.nsw.monre.p05.model.HoSo5;
import com.nsw.monre.p05.model.ResponseJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@PropertySource("classpath:monre_api.properties")
public class TbdHSDeNghiCapGiayXn5ServiceImpl implements TbdHSDeNghiCapGiayXn5Service {

	private static final Logger LOGGER = LoggerFactory.getLogger(TbdHSDeNghiCapGiayXn5ServiceImpl.class);

	@Autowired
	private Environment mEnvironment;

	@Override
	public List<TbdHSDeNghiCapGiayXn5> getTbdHSDeNghiCapGiayXn5s(int pageIndex, int pageSize, String sort) {

		try {

			Map<String, Object> params = new HashMap<>();

			 params.put("pageIndex", pageIndex);

			 params.put("pageSize", pageSize);

			 params.put("sort", sort);

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc05Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc05BackendUriConstant.TbdHSDeNghiCapGiayXn5Uri.GET_SLICE_TBD_H_S_DE_NGHI_CAP_GIAY_XN_5), null, HttpMethod.GET, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), new TypeReference<List<TbdHSDeNghiCapGiayXn5>>(){});

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return Collections.emptyList();


		}

	}

	@Override
	public List<TbdHSDeNghiCapGiayXn5> getTbdHSDeNghiCapGiayXn5s() {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc05Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc05BackendUriConstant.TbdHSDeNghiCapGiayXn5Uri.GET_ALL_TBD_H_S_DE_NGHI_CAP_GIAY_XN_5), null, HttpMethod.GET, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), new TypeReference<List<TbdHSDeNghiCapGiayXn5>>(){});

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return Collections.emptyList();


		}

	}

	@Override
	public List<TbdHSDeNghiCapGiayXn5> searchTbdHSDeNghiCapGiayXn5s(TbdHSDeNghiCapGiayXn5SearchItem item) {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc05Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc05BackendUriConstant.TbdHSDeNghiCapGiayXn5Uri.SEARCH_TBD_H_S_DE_NGHI_CAP_GIAY_XN_5), item, HttpMethod.POST, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), new TypeReference<List<TbdHSDeNghiCapGiayXn5>>(){});

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return Collections.emptyList();


		}

	}

	@Override
	public long countSearchTbdHSDeNghiCapGiayXn5(TbdHSDeNghiCapGiayXn5SearchItem item) {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc05Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc05BackendUriConstant.TbdHSDeNghiCapGiayXn5Uri.COUNT_SEARCH_TBD_H_S_DE_NGHI_CAP_GIAY_XN_5), item, HttpMethod.POST, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), Long.class);

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return 0;


		}

	}

	@Override
	public boolean deleteBySearchItemTbdHSDeNghiCapGiayXn5s(TbdHSDeNghiCapGiayXn5SearchItem item) {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc05Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc05BackendUriConstant.TbdHSDeNghiCapGiayXn5Uri.DELETE_BY_SEARCH_ITEM_TBD_H_S_DE_NGHI_CAP_GIAY_XN_5), item, HttpMethod.POST, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), Boolean.class);

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return false;


		}

	}

	@Override
	public List<TbdHSDeNghiCapGiayXn5> callStoreMappingToModel(Object[] paramInputs) {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc05Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc05BackendUriConstant.TbdHSDeNghiCapGiayXn5Uri.CALL_STORE_MAPPING_TO_TBD_H_S_DE_NGHI_CAP_GIAY_XN_5), paramInputs, HttpMethod.POST, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), new TypeReference<List<TbdHSDeNghiCapGiayXn5>>(){});

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return Collections.emptyList();


		}

	}

	@Override
	public Object callStoreNoMappingToModel(Object[] paramInputs) {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc05Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc05BackendUriConstant.TbdHSDeNghiCapGiayXn5Uri.CALL_STORE_NO_MAPPING_TO_TBD_H_S_DE_NGHI_CAP_GIAY_XN_5), paramInputs, HttpMethod.POST, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return responseJson.getData();

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return null;


		}

	}

	@Override
	public TbdHSDeNghiCapGiayXn5 saveTbdHSDeNghiCapGiayXn5(TbdHSDeNghiCapGiayXn5 pTbdHSDeNghiCapGiayXn5) {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc05Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc05BackendUriConstant.TbdHSDeNghiCapGiayXn5Uri.CREATE_TBD_H_S_DE_NGHI_CAP_GIAY_XN_5), pTbdHSDeNghiCapGiayXn5, HttpMethod.POST, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), TbdHSDeNghiCapGiayXn5.class);

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return null;

		}

	}

	@Override
	public TbdHSDeNghiCapGiayXn5 updateTbdHSDeNghiCapGiayXn5(Long pTbdHSDeNghiCapGiayXn5Id, TbdHSDeNghiCapGiayXn5 pTbdHSDeNghiCapGiayXn5) {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc05Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc05BackendUriConstant.TbdHSDeNghiCapGiayXn5Uri.UPDATE_TBD_H_S_DE_NGHI_CAP_GIAY_XN_5) +"/" + pTbdHSDeNghiCapGiayXn5Id , pTbdHSDeNghiCapGiayXn5, HttpMethod.POST, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), TbdHSDeNghiCapGiayXn5.class);

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return null;

		}

	}

	@Override
	public TbdHSDeNghiCapGiayXn5 getTbdHSDeNghiCapGiayXn5(Long pTbdHSDeNghiCapGiayXn5Id) {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc05Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc05BackendUriConstant.TbdHSDeNghiCapGiayXn5Uri.GET_ONE_TBD_H_S_DE_NGHI_CAP_GIAY_XN_5) +"/" + pTbdHSDeNghiCapGiayXn5Id, null, HttpMethod.GET, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), TbdHSDeNghiCapGiayXn5.class);

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return null;

		}

	}

	@Override
	public boolean deleteTbdHSDeNghiCapGiayXn5ById(Long pTbdHSDeNghiCapGiayXn5Id) {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc05Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc05BackendUriConstant.TbdHSDeNghiCapGiayXn5Uri.DELETE_TBD_H_S_DE_NGHI_CAP_GIAY_XN_5)  + "/" + pTbdHSDeNghiCapGiayXn5Id, null, HttpMethod.GET, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), Boolean.class);

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return false;

		}

	}

	@Override
	public long countAllTbdHSDeNghiCapGiayXn5() {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc05Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc05BackendUriConstant.TbdHSDeNghiCapGiayXn5Uri.COUNT_ALL_TBD_H_S_DE_NGHI_CAP_GIAY_XN_5), null, HttpMethod.GET, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), Long.class);

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return 0;

		}

	}

	@Override
	public TbdHSDeNghiCapGiayXn5 findByIdHSAndLoaiThuTucAndXoaAndMaSoThue(long idHS, String loaiThuTuc, int xoa, String maSoThue) {

		try {

			Map<String, Object> params = new HashMap<>();

			params.put("idHS", idHS);

			params.put("loaiThuTuc", loaiThuTuc);

			params.put("xoa", xoa);

			params.put("maSoThue", maSoThue);

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc05Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc05BackendUriConstant.TbdHSDeNghiCapGiayXn5Uri.FIND_BY_ID_H_S_AND_LOAI_THU_TUC_AND_XOA_AND_MA_SO_THUE), null, HttpMethod.GET, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), TbdHSDeNghiCapGiayXn5.class);

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return null;

		}

	}

	@Override
	public TbdHSDeNghiCapGiayXn5 findByMaHoSo(String maHoSo) {

		try {

			Map<String, Object> params = new HashMap<>();

			params.put("maHoSo", maHoSo);

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc05Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc05BackendUriConstant.TbdHSDeNghiCapGiayXn5Uri.FIND_BY_MA_HO_SO), null, HttpMethod.GET, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), TbdHSDeNghiCapGiayXn5.class);

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return null;

		}

	}

	@Override
	public TbdHSDeNghiCapGiayXn5 findByIdHSAndMaHoSoAndLoaiThuTucAndXoaAndMaSoThue(long idHS, String maHoSo, String loaiThuTuc, int xoa, String maSoThue) {

		try {

			Map<String, Object> params = new HashMap<>();

			params.put("idHS", idHS);

			params.put("maHoSo", maHoSo);

			params.put("loaiThuTuc", loaiThuTuc);

			params.put("xoa", xoa);

			params.put("maSoThue", maSoThue);

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc05Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc05BackendUriConstant.TbdHSDeNghiCapGiayXn5Uri.FIND_BY_ID_H_S_AND_MA_HO_SO_AND_LOAI_THU_TUC_AND_XOA_AND_MA_SO_THUE), null, HttpMethod.GET, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), TbdHSDeNghiCapGiayXn5.class);

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return null;

		}

	}
	
	@Override
	public List<HoSo5> search(TbdHSDeNghiCapGiayXn5SearchItem item) {
		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc01Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc05BackendUriConstant.TbdHSDeNghiCapGiayXn5Uri.SEARCH), item, HttpMethod.POST, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), new TypeReference<List<HoSo5>>(){});

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return Collections.emptyList();


		}
	}
	
	@Override
	public long count(TbdHSDeNghiCapGiayXn5SearchItem item) {
		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc01Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc05BackendUriConstant.TbdHSDeNghiCapGiayXn5Uri.COUNT), item, HttpMethod.POST, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), Long.class);

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return 0;


		}
	}

}

