package com.nsw.monre.p05.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import com.nsw.monre.p05.constant.ThuTuc05Constant;
import com.nsw.monre.p05.constant.ThuTuc05BackendUriConstant;
import com.nsw.monre.p05.searchitem.TbdGXNThongTinCoSoSX5SearchItem;
import com.nsw.monre.p05.model.TbdGXNThongTinCoSoSX5;
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
public class TbdGXNThongTinCoSoSX5ServiceImpl implements TbdGXNThongTinCoSoSX5Service {

	private static final Logger LOGGER = LoggerFactory.getLogger(TbdGXNThongTinCoSoSX5ServiceImpl.class);

	@Autowired
	private Environment mEnvironment;

	@Override
	public List<TbdGXNThongTinCoSoSX5> getTbdGXNThongTinCoSoSX5s(int pageIndex, int pageSize, String sort) {

		try {

			Map<String, Object> params = new HashMap<>();

			 params.put("pageIndex", pageIndex);

			 params.put("pageSize", pageSize);

			 params.put("sort", sort);

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc05Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc05BackendUriConstant.TbdGXNThongTinCoSoSX5Uri.GET_SLICE_TBD_G_X_N_THONG_TIN_CO_SO_S_X_5), null, HttpMethod.GET, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), new TypeReference<List<TbdGXNThongTinCoSoSX5>>(){});

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return Collections.emptyList();


		}

	}

	@Override
	public List<TbdGXNThongTinCoSoSX5> getTbdGXNThongTinCoSoSX5s() {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc05Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc05BackendUriConstant.TbdGXNThongTinCoSoSX5Uri.GET_ALL_TBD_G_X_N_THONG_TIN_CO_SO_S_X_5), null, HttpMethod.GET, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), new TypeReference<List<TbdGXNThongTinCoSoSX5>>(){});

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return Collections.emptyList();


		}

	}

	@Override
	public List<TbdGXNThongTinCoSoSX5> searchTbdGXNThongTinCoSoSX5s(TbdGXNThongTinCoSoSX5SearchItem item) {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc05Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc05BackendUriConstant.TbdGXNThongTinCoSoSX5Uri.SEARCH_TBD_G_X_N_THONG_TIN_CO_SO_S_X_5), item, HttpMethod.POST, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), new TypeReference<List<TbdGXNThongTinCoSoSX5>>(){});

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return Collections.emptyList();


		}

	}

	@Override
	public long countSearchTbdGXNThongTinCoSoSX5(TbdGXNThongTinCoSoSX5SearchItem item) {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc05Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc05BackendUriConstant.TbdGXNThongTinCoSoSX5Uri.COUNT_SEARCH_TBD_G_X_N_THONG_TIN_CO_SO_S_X_5), item, HttpMethod.POST, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), Long.class);

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return 0;


		}

	}

	@Override
	public boolean deleteBySearchItemTbdGXNThongTinCoSoSX5s(TbdGXNThongTinCoSoSX5SearchItem item) {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc05Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc05BackendUriConstant.TbdGXNThongTinCoSoSX5Uri.DELETE_BY_SEARCH_ITEM_TBD_G_X_N_THONG_TIN_CO_SO_S_X_5), item, HttpMethod.POST, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), Boolean.class);

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return false;


		}

	}

	@Override
	public List<TbdGXNThongTinCoSoSX5> callStoreMappingToModel(Object[] paramInputs) {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc05Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc05BackendUriConstant.TbdGXNThongTinCoSoSX5Uri.CALL_STORE_MAPPING_TO_TBD_G_X_N_THONG_TIN_CO_SO_S_X_5), paramInputs, HttpMethod.POST, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), new TypeReference<List<TbdGXNThongTinCoSoSX5>>(){});

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return Collections.emptyList();


		}

	}

	@Override
	public Object callStoreNoMappingToModel(Object[] paramInputs) {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc05Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc05BackendUriConstant.TbdGXNThongTinCoSoSX5Uri.CALL_STORE_NO_MAPPING_TO_TBD_G_X_N_THONG_TIN_CO_SO_S_X_5), paramInputs, HttpMethod.POST, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return responseJson.getData();

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return null;


		}

	}

	@Override
	public TbdGXNThongTinCoSoSX5 saveTbdGXNThongTinCoSoSX5(TbdGXNThongTinCoSoSX5 pTbdGXNThongTinCoSoSX5) {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc05Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc05BackendUriConstant.TbdGXNThongTinCoSoSX5Uri.CREATE_TBD_G_X_N_THONG_TIN_CO_SO_S_X_5), pTbdGXNThongTinCoSoSX5, HttpMethod.POST, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), TbdGXNThongTinCoSoSX5.class);

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return null;


		}

	}

	@Override
	public TbdGXNThongTinCoSoSX5 updateTbdGXNThongTinCoSoSX5(Long pTbdGXNThongTinCoSoSX5Id, TbdGXNThongTinCoSoSX5 pTbdGXNThongTinCoSoSX5) {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc05Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc05BackendUriConstant.TbdGXNThongTinCoSoSX5Uri.UPDATE_TBD_G_X_N_THONG_TIN_CO_SO_S_X_5) +"/" + pTbdGXNThongTinCoSoSX5Id , pTbdGXNThongTinCoSoSX5, HttpMethod.POST, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), TbdGXNThongTinCoSoSX5.class);

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return null;


		}

	}

	@Override
	public TbdGXNThongTinCoSoSX5 getTbdGXNThongTinCoSoSX5(Long pTbdGXNThongTinCoSoSX5Id) {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc05Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc05BackendUriConstant.TbdGXNThongTinCoSoSX5Uri.GET_ONE_TBD_G_X_N_THONG_TIN_CO_SO_S_X_5) +"/" + pTbdGXNThongTinCoSoSX5Id, null, HttpMethod.GET, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), TbdGXNThongTinCoSoSX5.class);

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return null;


		}

	}

	@Override
	public boolean deleteTbdGXNThongTinCoSoSX5ById(Long pTbdGXNThongTinCoSoSX5Id) {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc05Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc05BackendUriConstant.TbdGXNThongTinCoSoSX5Uri.DELETE_TBD_G_X_N_THONG_TIN_CO_SO_S_X_5)  + "/" + pTbdGXNThongTinCoSoSX5Id, null, HttpMethod.GET, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), Boolean.class);

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return false;


		}

	}

	@Override
	public long countAllTbdGXNThongTinCoSoSX5() {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc05Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc05BackendUriConstant.TbdGXNThongTinCoSoSX5Uri.COUNT_ALL_TBD_G_X_N_THONG_TIN_CO_SO_S_X_5), null, HttpMethod.GET, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), Long.class);

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return 0;


		}

	}

	@Override
	public List<TbdGXNThongTinCoSoSX5> findByIdGXN(long idGXN) {

		try {

			Map<String, Object> params = new HashMap<>();

			params.put("idGXN", idGXN);

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc05Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc05BackendUriConstant.TbdGXNThongTinCoSoSX5Uri.FIND_BY_ID_G_X_N), null, HttpMethod.GET, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), new TypeReference<List<TbdGXNThongTinCoSoSX5>>(){});

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return Collections.emptyList();


		}

	}

}

