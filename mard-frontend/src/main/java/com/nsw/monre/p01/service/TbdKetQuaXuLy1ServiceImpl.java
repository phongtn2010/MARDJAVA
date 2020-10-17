package com.nsw.monre.p01.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import com.nsw.monre.p01.constant.ThuTuc01Constant;
import com.nsw.monre.p01.constant.ThuTuc01BackendUriConstant;
import com.nsw.monre.p01.searchitem.TbdKetQuaXuLy1SearchItem;
import com.nsw.monre.p01.model.TbdKetQuaXuLy1;
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
public class TbdKetQuaXuLy1ServiceImpl implements TbdKetQuaXuLy1Service {

	private static final Logger LOGGER = LoggerFactory.getLogger(TbdKetQuaXuLy1ServiceImpl.class);

	@Autowired
	private Environment mEnvironment;

	@Override
	public List<TbdKetQuaXuLy1> getTbdKetQuaXuLy1s(int pageIndex, int pageSize, String sort)  {

		try {

			Map<String, Object> params = new HashMap<>();

			 params.put("pageIndex", pageIndex);

			 params.put("pageSize", pageSize);

			 params.put("sort", sort);

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc01Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc01BackendUriConstant.TbdKetQuaXuLy1Uri.GET_SLICE_TBD_KET_QUA_XU_LY_1), null, HttpMethod.GET, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), new TypeReference<List<TbdKetQuaXuLy1>>(){});

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return Collections.emptyList();

		}

	}

	@Override
	public List<TbdKetQuaXuLy1> getTbdKetQuaXuLy1s()  {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc01Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc01BackendUriConstant.TbdKetQuaXuLy1Uri.GET_ALL_TBD_KET_QUA_XU_LY_1), null, HttpMethod.GET, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), new TypeReference<List<TbdKetQuaXuLy1>>(){});

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return Collections.emptyList();

		}

	}

	@Override
	public List<TbdKetQuaXuLy1> searchTbdKetQuaXuLy1s(TbdKetQuaXuLy1SearchItem item)  {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc01Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc01BackendUriConstant.TbdKetQuaXuLy1Uri.SEARCH_TBD_KET_QUA_XU_LY_1), item, HttpMethod.POST, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), new TypeReference<List<TbdKetQuaXuLy1>>(){});

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return Collections.emptyList();

		}

	}

	@Override
	public long countSearchTbdKetQuaXuLy1(TbdKetQuaXuLy1SearchItem item)  {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc01Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc01BackendUriConstant.TbdKetQuaXuLy1Uri.COUNT_SEARCH_TBD_KET_QUA_XU_LY_1), item, HttpMethod.POST, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), Long.class);

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return 0;

		}

	}

	@Override
	public boolean deleteBySearchItemTbdKetQuaXuLy1s(TbdKetQuaXuLy1SearchItem item)  {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc01Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc01BackendUriConstant.TbdKetQuaXuLy1Uri.DELETE_BY_SEARCH_ITEM_TBD_KET_QUA_XU_LY_1), item, HttpMethod.POST, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), Boolean.class);

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return false;

		}

	}

	@Override
	public List<TbdKetQuaXuLy1> callStoreMappingToModel(Object[] paramInputs)  {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc01Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc01BackendUriConstant.TbdKetQuaXuLy1Uri.CALL_STORE_MAPPING_TO_TBD_KET_QUA_XU_LY_1), paramInputs, HttpMethod.POST, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), new TypeReference<List<TbdKetQuaXuLy1>>(){});

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return Collections.emptyList();

		}

	}

	@Override
	public Object callStoreNoMappingToModel(Object[] paramInputs)  {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc01Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc01BackendUriConstant.TbdKetQuaXuLy1Uri.CALL_STORE_NO_MAPPING_TO_TBD_KET_QUA_XU_LY_1), paramInputs, HttpMethod.POST, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return responseJson.getData();

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return null;

		}

	}

	@Override
	public TbdKetQuaXuLy1 saveTbdKetQuaXuLy1(TbdKetQuaXuLy1 pTbdKetQuaXuLy1)  {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc01Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc01BackendUriConstant.TbdKetQuaXuLy1Uri.CREATE_TBD_KET_QUA_XU_LY_1), pTbdKetQuaXuLy1, HttpMethod.POST, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), TbdKetQuaXuLy1.class);

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return null;

		}

	}

	@Override
	public TbdKetQuaXuLy1 updateTbdKetQuaXuLy1(Long pTbdKetQuaXuLy1Id, TbdKetQuaXuLy1 pTbdKetQuaXuLy1)  {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc01Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc01BackendUriConstant.TbdKetQuaXuLy1Uri.UPDATE_TBD_KET_QUA_XU_LY_1) +"/" + pTbdKetQuaXuLy1Id , pTbdKetQuaXuLy1, HttpMethod.POST, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), TbdKetQuaXuLy1.class);

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return null;

		}

	}

	@Override
	public TbdKetQuaXuLy1 getTbdKetQuaXuLy1(Long pTbdKetQuaXuLy1Id)  {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc01Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc01BackendUriConstant.TbdKetQuaXuLy1Uri.GET_ONE_TBD_KET_QUA_XU_LY_1) +"/" + pTbdKetQuaXuLy1Id, null, HttpMethod.GET, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), TbdKetQuaXuLy1.class);

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return null;

		}

	}

	@Override
	public boolean deleteTbdKetQuaXuLy1ById(Long pTbdKetQuaXuLy1Id)  {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc01Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc01BackendUriConstant.TbdKetQuaXuLy1Uri.DELETE_TBD_KET_QUA_XU_LY_1)  + "/" + pTbdKetQuaXuLy1Id, null, HttpMethod.GET, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), Boolean.class);

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return false;

		}

	}

	@Override
	public long countAllTbdKetQuaXuLy1()  {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc01Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc01BackendUriConstant.TbdKetQuaXuLy1Uri.COUNT_ALL_TBD_KET_QUA_XU_LY_1), null, HttpMethod.GET, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), Long.class);

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return 0;

		}

	}

	@Override
	public TbdKetQuaXuLy1 findByIdHSAndIdKQ(long idHS, long idKQ)  {

		try {

			Map<String, Object> params = new HashMap<>();

			params.put("idHS", idHS);

			params.put("idKQ", idKQ);

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc01Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc01BackendUriConstant.TbdKetQuaXuLy1Uri.FIND_BY_ID_H_S_AND_ID_K_Q), null, HttpMethod.GET, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), TbdKetQuaXuLy1.class);

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return null;

		}

	}

	@Override
	public List<TbdKetQuaXuLy1> findByIdHS(long idHS)  {

		try {

			Map<String, Object> params = new HashMap<>();

			params.put("idHS", idHS);

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc01Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc01BackendUriConstant.TbdKetQuaXuLy1Uri.FIND_BY_ID_H_S), null, HttpMethod.GET, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), new TypeReference<List<TbdKetQuaXuLy1>>(){});

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return Collections.emptyList();

		}

	}

}

