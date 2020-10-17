package com.nsw.monre.p01.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import com.nsw.monre.p01.constant.ThuTuc01Constant;
import com.nsw.monre.p01.constant.ThuTuc01BackendUriConstant;
import com.nsw.monre.p01.searchitem.TbdGXNThongTinPheLieu1SearchItem;
import com.nsw.monre.p01.model.TbdGXNThongTinPheLieu1;
import org.springframework.http.HttpMethod;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import com.nsw.monre.p01.model.ResponseJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@PropertySource("classpath:monre_api.properties")
public class TbdGXNThongTinPheLieu1ServiceImpl implements TbdGXNThongTinPheLieu1Service {

	private static final Logger LOGGER = LoggerFactory.getLogger(TbdGXNThongTinPheLieu1ServiceImpl.class);

	@Autowired
	private Environment mEnvironment;

	@Override
	public List<TbdGXNThongTinPheLieu1> getTbdGXNThongTinPheLieu1s(int pageIndex, int pageSize, String sort) {

		try {

			Map<String, Object> params = new HashMap<>();

			 params.put("pageIndex", pageIndex);

			 params.put("pageSize", pageSize);

			 params.put("sort", sort);

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc01Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc01BackendUriConstant.TbdGXNThongTinPheLieu1Uri.GET_SLICE_TBD_G_X_N_THONG_TIN_PHE_LIEU_1), null, HttpMethod.GET, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), new TypeReference<List<TbdGXNThongTinPheLieu1>>(){});

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return Collections.emptyList();
		}

	}

	@Override
	public List<TbdGXNThongTinPheLieu1> getTbdGXNThongTinPheLieu1s() {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc01Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc01BackendUriConstant.TbdGXNThongTinPheLieu1Uri.GET_ALL_TBD_G_X_N_THONG_TIN_PHE_LIEU_1), null, HttpMethod.GET, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), new TypeReference<List<TbdGXNThongTinPheLieu1>>(){});

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return Collections.emptyList();

		}

	}

	@Override
	public List<TbdGXNThongTinPheLieu1> searchTbdGXNThongTinPheLieu1s(TbdGXNThongTinPheLieu1SearchItem item) {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc01Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc01BackendUriConstant.TbdGXNThongTinPheLieu1Uri.SEARCH_TBD_G_X_N_THONG_TIN_PHE_LIEU_1), item, HttpMethod.POST, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), new TypeReference<List<TbdGXNThongTinPheLieu1>>(){});

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return Collections.emptyList();

		}

	}

	@Override
	public long countSearchTbdGXNThongTinPheLieu1(TbdGXNThongTinPheLieu1SearchItem item) {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc01Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc01BackendUriConstant.TbdGXNThongTinPheLieu1Uri.COUNT_SEARCH_TBD_G_X_N_THONG_TIN_PHE_LIEU_1), item, HttpMethod.POST, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), Long.class);

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return 0;

		}

	}

	@Override
	public boolean deleteBySearchItemTbdGXNThongTinPheLieu1s(TbdGXNThongTinPheLieu1SearchItem item) {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc01Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc01BackendUriConstant.TbdGXNThongTinPheLieu1Uri.DELETE_BY_SEARCH_ITEM_TBD_G_X_N_THONG_TIN_PHE_LIEU_1), item, HttpMethod.POST, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), Boolean.class);

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return false;

		}

	}

	@Override
	public List<TbdGXNThongTinPheLieu1> callStoreMappingToModel(Object[] paramInputs) {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc01Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc01BackendUriConstant.TbdGXNThongTinPheLieu1Uri.CALL_STORE_MAPPING_TO_TBD_G_X_N_THONG_TIN_PHE_LIEU_1), paramInputs, HttpMethod.POST, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), new TypeReference<List<TbdGXNThongTinPheLieu1>>(){});

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return Collections.emptyList();

		}

	}

	@Override
	public Object callStoreNoMappingToModel(Object[] paramInputs) {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc01Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc01BackendUriConstant.TbdGXNThongTinPheLieu1Uri.CALL_STORE_NO_MAPPING_TO_TBD_G_X_N_THONG_TIN_PHE_LIEU_1), paramInputs, HttpMethod.POST, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return responseJson.getData();

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return null;

		}

	}

	@Override
	public TbdGXNThongTinPheLieu1 saveTbdGXNThongTinPheLieu1(TbdGXNThongTinPheLieu1 pTbdGXNThongTinPheLieu1) {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc01Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc01BackendUriConstant.TbdGXNThongTinPheLieu1Uri.CREATE_TBD_G_X_N_THONG_TIN_PHE_LIEU_1), pTbdGXNThongTinPheLieu1, HttpMethod.POST, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), TbdGXNThongTinPheLieu1.class);

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return null;

		}

	}

	@Override
	public TbdGXNThongTinPheLieu1 updateTbdGXNThongTinPheLieu1(Long pTbdGXNThongTinPheLieu1Id, TbdGXNThongTinPheLieu1 pTbdGXNThongTinPheLieu1) {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc01Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc01BackendUriConstant.TbdGXNThongTinPheLieu1Uri.UPDATE_TBD_G_X_N_THONG_TIN_PHE_LIEU_1) +"/" + pTbdGXNThongTinPheLieu1Id , pTbdGXNThongTinPheLieu1, HttpMethod.POST, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), TbdGXNThongTinPheLieu1.class);

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return null;

		}

	}

	@Override
	public TbdGXNThongTinPheLieu1 getTbdGXNThongTinPheLieu1(Long pTbdGXNThongTinPheLieu1Id) {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc01Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc01BackendUriConstant.TbdGXNThongTinPheLieu1Uri.GET_ONE_TBD_G_X_N_THONG_TIN_PHE_LIEU_1) +"/" + pTbdGXNThongTinPheLieu1Id, null, HttpMethod.GET, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), TbdGXNThongTinPheLieu1.class);

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return null;

		}

	}

	@Override
	public boolean deleteTbdGXNThongTinPheLieu1ById(Long pTbdGXNThongTinPheLieu1Id) {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc01Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc01BackendUriConstant.TbdGXNThongTinPheLieu1Uri.DELETE_TBD_G_X_N_THONG_TIN_PHE_LIEU_1)  + "/" + pTbdGXNThongTinPheLieu1Id, null, HttpMethod.GET, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), Boolean.class);

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return false;

		}

	}

	@Override
	public long countAllTbdGXNThongTinPheLieu1() {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc01Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc01BackendUriConstant.TbdGXNThongTinPheLieu1Uri.COUNT_ALL_TBD_G_X_N_THONG_TIN_PHE_LIEU_1), null, HttpMethod.GET, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), Long.class);

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return 0;

		}

	}

	@Override
	public List<TbdGXNThongTinPheLieu1> findByIdGXN(long idGXN) {

		try {

			Map<String, Object> params = new HashMap<>();

			params.put("idGXN", idGXN);

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc01Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc01BackendUriConstant.TbdGXNThongTinPheLieu1Uri.FIND_BY_ID_G_X_N), null, HttpMethod.GET, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), new TypeReference<List<TbdGXNThongTinPheLieu1>>(){});

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return Collections.emptyList();

		}

	}

}

