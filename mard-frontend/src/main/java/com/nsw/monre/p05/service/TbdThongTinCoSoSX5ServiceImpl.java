package com.nsw.monre.p05.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import com.nsw.monre.p05.constant.ThuTuc05Constant;
import com.nsw.monre.p05.constant.ThuTuc05BackendUriConstant;
import com.nsw.monre.p05.searchitem.TbdThongTinCoSoSX5SearchItem;
import com.nsw.monre.p05.model.TbdThongTinCoSoSX5;
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
public class TbdThongTinCoSoSX5ServiceImpl implements TbdThongTinCoSoSX5Service {

	private static final Logger LOGGER = LoggerFactory.getLogger(TbdThongTinCoSoSX5ServiceImpl.class);

	@Autowired
	private Environment mEnvironment;

	@Override
	public List<TbdThongTinCoSoSX5> getTbdThongTinCoSoSX5s(int pageIndex, int pageSize, String sort) {

		try {

			Map<String, Object> params = new HashMap<>();

			 params.put("pageIndex", pageIndex);

			 params.put("pageSize", pageSize);

			 params.put("sort", sort);

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc05Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc05BackendUriConstant.TbdThongTinCoSoSX5Uri.GET_SLICE_TBD_THONG_TIN_CO_SO_S_X_5), null, HttpMethod.GET, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), new TypeReference<List<TbdThongTinCoSoSX5>>(){});

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return Collections.emptyList();


		}

	}

	@Override
	public List<TbdThongTinCoSoSX5> getTbdThongTinCoSoSX5s() {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc05Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc05BackendUriConstant.TbdThongTinCoSoSX5Uri.GET_ALL_TBD_THONG_TIN_CO_SO_S_X_5), null, HttpMethod.GET, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), new TypeReference<List<TbdThongTinCoSoSX5>>(){});

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return Collections.emptyList();


		}

	}

	@Override
	public List<TbdThongTinCoSoSX5> searchTbdThongTinCoSoSX5s(TbdThongTinCoSoSX5SearchItem item) {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc05Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc05BackendUriConstant.TbdThongTinCoSoSX5Uri.SEARCH_TBD_THONG_TIN_CO_SO_S_X_5), item, HttpMethod.POST, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), new TypeReference<List<TbdThongTinCoSoSX5>>(){});

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return Collections.emptyList();


		}

	}

	@Override
	public long countSearchTbdThongTinCoSoSX5(TbdThongTinCoSoSX5SearchItem item) {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc05Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc05BackendUriConstant.TbdThongTinCoSoSX5Uri.COUNT_SEARCH_TBD_THONG_TIN_CO_SO_S_X_5), item, HttpMethod.POST, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), Long.class);

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return 0;


		}

	}

	@Override
	public boolean deleteBySearchItemTbdThongTinCoSoSX5s(TbdThongTinCoSoSX5SearchItem item) {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc05Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc05BackendUriConstant.TbdThongTinCoSoSX5Uri.DELETE_BY_SEARCH_ITEM_TBD_THONG_TIN_CO_SO_S_X_5), item, HttpMethod.POST, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), Boolean.class);

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return false;


		}

	}

	@Override
	public List<TbdThongTinCoSoSX5> callStoreMappingToModel(Object[] paramInputs) {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc05Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc05BackendUriConstant.TbdThongTinCoSoSX5Uri.CALL_STORE_MAPPING_TO_TBD_THONG_TIN_CO_SO_S_X_5), paramInputs, HttpMethod.POST, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), new TypeReference<List<TbdThongTinCoSoSX5>>(){});

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return Collections.emptyList();


		}

	}

	@Override
	public Object callStoreNoMappingToModel(Object[] paramInputs) {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc05Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc05BackendUriConstant.TbdThongTinCoSoSX5Uri.CALL_STORE_NO_MAPPING_TO_TBD_THONG_TIN_CO_SO_S_X_5), paramInputs, HttpMethod.POST, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return responseJson.getData();

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return null;

		}

	}

	@Override
	public TbdThongTinCoSoSX5 saveTbdThongTinCoSoSX5(TbdThongTinCoSoSX5 pTbdThongTinCoSoSX5) {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc05Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc05BackendUriConstant.TbdThongTinCoSoSX5Uri.CREATE_TBD_THONG_TIN_CO_SO_S_X_5), pTbdThongTinCoSoSX5, HttpMethod.POST, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), TbdThongTinCoSoSX5.class);

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return null;


		}

	}

	@Override
	public TbdThongTinCoSoSX5 updateTbdThongTinCoSoSX5(Long pTbdThongTinCoSoSX5Id, TbdThongTinCoSoSX5 pTbdThongTinCoSoSX5) {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc05Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc05BackendUriConstant.TbdThongTinCoSoSX5Uri.UPDATE_TBD_THONG_TIN_CO_SO_S_X_5) +"/" + pTbdThongTinCoSoSX5Id , pTbdThongTinCoSoSX5, HttpMethod.POST, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), TbdThongTinCoSoSX5.class);

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return null;


		}

	}

	@Override
	public TbdThongTinCoSoSX5 getTbdThongTinCoSoSX5(Long pTbdThongTinCoSoSX5Id) {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc05Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc05BackendUriConstant.TbdThongTinCoSoSX5Uri.GET_ONE_TBD_THONG_TIN_CO_SO_S_X_5) +"/" + pTbdThongTinCoSoSX5Id, null, HttpMethod.GET, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), TbdThongTinCoSoSX5.class);

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return null;


		}

	}

	@Override
	public boolean deleteTbdThongTinCoSoSX5ById(Long pTbdThongTinCoSoSX5Id) {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc05Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc05BackendUriConstant.TbdThongTinCoSoSX5Uri.DELETE_TBD_THONG_TIN_CO_SO_S_X_5)  + "/" + pTbdThongTinCoSoSX5Id, null, HttpMethod.GET, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), Boolean.class);

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return false;


		}

	}

	@Override
	public long countAllTbdThongTinCoSoSX5() {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc05Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc05BackendUriConstant.TbdThongTinCoSoSX5Uri.COUNT_ALL_TBD_THONG_TIN_CO_SO_S_X_5), null, HttpMethod.GET, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), Long.class);

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return 0;


		}

	}

	@Override
	public List<TbdThongTinCoSoSX5> findByIdHS(long idHS) {

		try {

			Map<String, Object> params = new HashMap<>();

			params.put("idHS", idHS);

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc05Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc05BackendUriConstant.TbdThongTinCoSoSX5Uri.FIND_BY_ID_H_S), null, HttpMethod.GET, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), new TypeReference<List<TbdThongTinCoSoSX5>>(){});

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return Collections.emptyList();


		}

	}

	@Override
	public List<TbdThongTinCoSoSX5> findByIdHSOrderByTbdThongTinCoSoSXIdAsc(long idHS) {

		try {

			Map<String, Object> params = new HashMap<>();

			params.put("idHS", idHS);

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc05Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc05BackendUriConstant.TbdThongTinCoSoSX5Uri.FIND_BY_ID_H_S_ORDER_BY_TBD_THONG_TIN_CO_SO_S_X_ID_ASC), null, HttpMethod.GET, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), new TypeReference<List<TbdThongTinCoSoSX5>>(){});

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return Collections.emptyList();


		}

	}

	@Override
	public List<TbdThongTinCoSoSX5> findByIdCS(long idCS) {

		try {

			Map<String, Object> params = new HashMap<>();

			params.put("idCS", idCS);

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc05Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc05BackendUriConstant.TbdThongTinCoSoSX5Uri.FIND_BY_ID_C_S), null, HttpMethod.GET, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), new TypeReference<List<TbdThongTinCoSoSX5>>(){});

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return Collections.emptyList();


		}

	}

	@Override
	public TbdThongTinCoSoSX5 findByIdHSAndIdCS(long idHS, long idCS) {

		try {

			Map<String, Object> params = new HashMap<>();

			params.put("idHS", idHS);

			params.put("idCS", idCS);

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc05Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc05BackendUriConstant.TbdThongTinCoSoSX5Uri.FIND_BY_ID_H_S_AND_ID_C_S), null, HttpMethod.GET, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), TbdThongTinCoSoSX5.class);

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return null;


		}

	}

}

