package com.nsw.monre.p05.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import com.nsw.monre.p05.constant.ThuTuc05Constant;
import com.nsw.monre.p05.constant.ThuTuc05BackendUriConstant;
import com.nsw.monre.p05.searchitem.TbdCapGiayXacNhan5SearchItem;
import com.nsw.monre.p05.model.TbdCapGiayXacNhan5;
import org.springframework.http.HttpMethod;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import com.nsw.monre.p05.model.ResponseJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@PropertySource("classpath:monre_api.properties")
public class TbdCapGiayXacNhan5ServiceImpl implements TbdCapGiayXacNhan5Service {

	private static final Logger LOGGER = LoggerFactory.getLogger(TbdCapGiayXacNhan5ServiceImpl.class);

	@Autowired
	private Environment mEnvironment;

	@Override
	public List<TbdCapGiayXacNhan5> getTbdCapGiayXacNhan5s(int pageIndex, int pageSize, String sort) {

		try {

			Map<String, Object> params = new HashMap<>();

			 params.put("pageIndex", pageIndex);

			 params.put("pageSize", pageSize);

			 params.put("sort", sort);

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc05Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc05BackendUriConstant.TbdCapGiayXacNhan5Uri.GET_SLICE_TBD_CAP_GIAY_XAC_NHAN_5), null, HttpMethod.GET, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), new TypeReference<List<TbdCapGiayXacNhan5>>(){});

		} catch (Exception e) {

				LOGGER.error(e.getMessage(), e);
				return Collections.emptyList();
		}

	}

	@Override
	public List<TbdCapGiayXacNhan5> getTbdCapGiayXacNhan5s() {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc05Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc05BackendUriConstant.TbdCapGiayXacNhan5Uri.GET_ALL_TBD_CAP_GIAY_XAC_NHAN_5), null, HttpMethod.GET, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), new TypeReference<List<TbdCapGiayXacNhan5>>(){});

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return Collections.emptyList();
		}

	}

	@Override
	public List<TbdCapGiayXacNhan5> searchTbdCapGiayXacNhan5s(TbdCapGiayXacNhan5SearchItem item) {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc05Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc05BackendUriConstant.TbdCapGiayXacNhan5Uri.SEARCH_TBD_CAP_GIAY_XAC_NHAN_5), item, HttpMethod.POST, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), new TypeReference<List<TbdCapGiayXacNhan5>>(){});

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return Collections.emptyList();
		}

	}

	@Override
	public long countSearchTbdCapGiayXacNhan5(TbdCapGiayXacNhan5SearchItem item) {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc05Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc05BackendUriConstant.TbdCapGiayXacNhan5Uri.COUNT_SEARCH_TBD_CAP_GIAY_XAC_NHAN_5), item, HttpMethod.POST, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), Long.class);

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return 0;

		}

	}

	@Override
	public boolean deleteBySearchItemTbdCapGiayXacNhan5s(TbdCapGiayXacNhan5SearchItem item) {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc05Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc05BackendUriConstant.TbdCapGiayXacNhan5Uri.DELETE_BY_SEARCH_ITEM_TBD_CAP_GIAY_XAC_NHAN_5), item, HttpMethod.POST, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), Boolean.class);

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return false;

		}

	}

	@Override
	public List<TbdCapGiayXacNhan5> callStoreMappingToModel(Object[] paramInputs) {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc05Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc05BackendUriConstant.TbdCapGiayXacNhan5Uri.CALL_STORE_MAPPING_TO_TBD_CAP_GIAY_XAC_NHAN_5), paramInputs, HttpMethod.POST, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), new TypeReference<List<TbdCapGiayXacNhan5>>(){});

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return Collections.emptyList();

		}

	}

	@Override
	public Object callStoreNoMappingToModel(Object[] paramInputs) {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc05Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc05BackendUriConstant.TbdCapGiayXacNhan5Uri.CALL_STORE_NO_MAPPING_TO_TBD_CAP_GIAY_XAC_NHAN_5), paramInputs, HttpMethod.POST, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return responseJson.getData();

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return null;

		}

	}

	@Override
	public TbdCapGiayXacNhan5 saveTbdCapGiayXacNhan5(TbdCapGiayXacNhan5 pTbdCapGiayXacNhan5) {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc05Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc05BackendUriConstant.TbdCapGiayXacNhan5Uri.CREATE_TBD_CAP_GIAY_XAC_NHAN_5), pTbdCapGiayXacNhan5, HttpMethod.POST, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), TbdCapGiayXacNhan5.class);

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return null;

		}

	}

	@Override
	public TbdCapGiayXacNhan5 updateTbdCapGiayXacNhan5(Long pTbdCapGiayXacNhan5Id, TbdCapGiayXacNhan5 pTbdCapGiayXacNhan5) {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc05Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc05BackendUriConstant.TbdCapGiayXacNhan5Uri.UPDATE_TBD_CAP_GIAY_XAC_NHAN_5) +"/" + pTbdCapGiayXacNhan5Id , pTbdCapGiayXacNhan5, HttpMethod.POST, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), TbdCapGiayXacNhan5.class);

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return null;

		}

	}

	@Override
	public TbdCapGiayXacNhan5 getTbdCapGiayXacNhan5(Long pTbdCapGiayXacNhan5Id) {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc05Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc05BackendUriConstant.TbdCapGiayXacNhan5Uri.GET_ONE_TBD_CAP_GIAY_XAC_NHAN_5) +"/" + pTbdCapGiayXacNhan5Id, null, HttpMethod.GET, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), TbdCapGiayXacNhan5.class);

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return null;

		}

	}

	@Override
	public boolean deleteTbdCapGiayXacNhan5ById(Long pTbdCapGiayXacNhan5Id) {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc05Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc05BackendUriConstant.TbdCapGiayXacNhan5Uri.DELETE_TBD_CAP_GIAY_XAC_NHAN_5)  + "/" + pTbdCapGiayXacNhan5Id, null, HttpMethod.GET, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), Boolean.class);

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return false;

		}

	}

	@Override
	public long countAllTbdCapGiayXacNhan5() {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc05Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc05BackendUriConstant.TbdCapGiayXacNhan5Uri.COUNT_ALL_TBD_CAP_GIAY_XAC_NHAN_5), null, HttpMethod.GET, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), Long.class);

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return 0;

		}

	}

	@Override
	public List<TbdCapGiayXacNhan5> findByIdHSOrderByIdGxnDesc(long idHS) {

		try {

			Map<String, Object> params = new HashMap<>();

			params.put("idHS", idHS);

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc05Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc05BackendUriConstant.TbdCapGiayXacNhan5Uri.FIND_BY_ID_H_S_ORDER_BY_ID_GXN_DESC), null, HttpMethod.GET, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), new TypeReference<List<TbdCapGiayXacNhan5>>(){});

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return Collections.emptyList();

		}

	}

	@Override
	public List<TbdCapGiayXacNhan5> findByIdHS(long idHS) {

		try {

			Map<String, Object> params = new HashMap<>();

			params.put("idHS", idHS);

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc05Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc05BackendUriConstant.TbdCapGiayXacNhan5Uri.FIND_BY_ID_H_S), null, HttpMethod.GET, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), new TypeReference<List<TbdCapGiayXacNhan5>>(){});

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return Collections.emptyList();

		}

	}
	
	private static final String SOGIAYXN_KEY = "soGiayXN";

	@Override
	public List<TbdCapGiayXacNhan5> findBySoGiayXNAndMaSoThueOrderByIdGxnDesc(String soGiayXN, String maSoThue) {

		try {

			Map<String, Object> params = new HashMap<>();

			params.put(SOGIAYXN_KEY, soGiayXN);

			params.put("maSoThue", maSoThue);

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc05Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc05BackendUriConstant.TbdCapGiayXacNhan5Uri.FIND_BY_SO_GIAY_X_N_AND_MA_SO_THUE_ORDER_BY_ID_GXN_DESC), null, HttpMethod.GET, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), new TypeReference<List<TbdCapGiayXacNhan5>>(){});

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return Collections.emptyList();

		}

	}

	@Override
	public List<TbdCapGiayXacNhan5> findBySoGiayXNOrderByIdGxnDesc(String soGiayXN) {

		try {

			Map<String, Object> params = new HashMap<>();

			params.put(SOGIAYXN_KEY, soGiayXN);

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc05Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc05BackendUriConstant.TbdCapGiayXacNhan5Uri.FIND_BY_SO_GIAY_X_N_ORDER_BY_ID_GXN_DESC), null, HttpMethod.GET, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), new TypeReference<List<TbdCapGiayXacNhan5>>(){});

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return Collections.emptyList();

		}

	}

	@Override
	public List<TbdCapGiayXacNhan5> findBySoGiayXNAndHinhThucAndMaSoThueOrderByIdGxnDesc(String soGiayXN, long hinhThuc, String maSoThue) {

		try {

			Map<String, Object> params = new HashMap<>();

			params.put(SOGIAYXN_KEY, soGiayXN);

			params.put("hinhThuc", hinhThuc);

			params.put("maSoThue", maSoThue);

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc05Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc05BackendUriConstant.TbdCapGiayXacNhan5Uri.FIND_BY_SO_GIAY_X_N_AND_HINH_THUC_AND_MA_SO_THUE_ORDER_BY_ID_GXN_DESC), null, HttpMethod.GET, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), new TypeReference<List<TbdCapGiayXacNhan5>>(){});

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return Collections.emptyList();

		}

	}

}

