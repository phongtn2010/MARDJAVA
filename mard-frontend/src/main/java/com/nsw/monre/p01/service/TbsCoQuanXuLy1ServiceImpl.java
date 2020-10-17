package com.nsw.monre.p01.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import com.nsw.monre.p01.constant.ThuTuc01Constant;
import com.nsw.monre.p01.constant.ThuTuc01BackendUriConstant;
import com.nsw.monre.p01.searchitem.TbsCoQuanXuLy1SearchItem;
import com.nsw.monre.p01.model.TbsCoQuanXuLy1;
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
public class TbsCoQuanXuLy1ServiceImpl implements TbsCoQuanXuLy1Service {

	private static final Logger LOGGER = LoggerFactory.getLogger(TbsCoQuanXuLy1ServiceImpl.class);

	@Autowired
	private Environment mEnvironment;

	@Override
	public List<TbsCoQuanXuLy1> getTbsCoQuanXuLy1s(int pageIndex, int pageSize, String sort)  {

		try {

			Map<String, Object> params = new HashMap<>();

			 params.put("pageIndex", pageIndex);

			 params.put("pageSize", pageSize);

			 params.put("sort", sort);

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc01Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc01BackendUriConstant.TbsCoQuanXuLy1Uri.GET_SLICE_TBS_CO_QUAN_XU_LY_1), null, HttpMethod.GET, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), new TypeReference<List<TbsCoQuanXuLy1>>(){});

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return Collections.emptyList();

		}

	}

	@Override
	public List<TbsCoQuanXuLy1> getTbsCoQuanXuLy1s()  {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc01Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc01BackendUriConstant.TbsCoQuanXuLy1Uri.GET_ALL_TBS_CO_QUAN_XU_LY_1), null, HttpMethod.GET, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), new TypeReference<List<TbsCoQuanXuLy1>>(){});

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return Collections.emptyList();

		}

	}

	@Override
	public List<TbsCoQuanXuLy1> searchTbsCoQuanXuLy1s(TbsCoQuanXuLy1SearchItem item)  {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc01Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc01BackendUriConstant.TbsCoQuanXuLy1Uri.SEARCH_TBS_CO_QUAN_XU_LY_1), item, HttpMethod.POST, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), new TypeReference<List<TbsCoQuanXuLy1>>(){});

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return Collections.emptyList();

		}

	}

	@Override
	public long countSearchTbsCoQuanXuLy1(TbsCoQuanXuLy1SearchItem item)  {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc01Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc01BackendUriConstant.TbsCoQuanXuLy1Uri.COUNT_SEARCH_TBS_CO_QUAN_XU_LY_1), item, HttpMethod.POST, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), Long.class);

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return 0;

		}

	}

	@Override
	public boolean deleteBySearchItemTbsCoQuanXuLy1s(TbsCoQuanXuLy1SearchItem item)  {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc01Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc01BackendUriConstant.TbsCoQuanXuLy1Uri.DELETE_BY_SEARCH_ITEM_TBS_CO_QUAN_XU_LY_1), item, HttpMethod.POST, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), Boolean.class);

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return false;

		}

	}

	@Override
	public List<TbsCoQuanXuLy1> callStoreMappingToModel(Object[] paramInputs)  {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc01Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc01BackendUriConstant.TbsCoQuanXuLy1Uri.CALL_STORE_MAPPING_TO_TBS_CO_QUAN_XU_LY_1), paramInputs, HttpMethod.POST, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), new TypeReference<List<TbsCoQuanXuLy1>>(){});

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return Collections.emptyList();

		}

	}

	@Override
	public Object callStoreNoMappingToModel(Object[] paramInputs)  {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc01Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc01BackendUriConstant.TbsCoQuanXuLy1Uri.CALL_STORE_NO_MAPPING_TO_TBS_CO_QUAN_XU_LY_1), paramInputs, HttpMethod.POST, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return responseJson.getData();

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return null;

		}

	}

	@Override
	public TbsCoQuanXuLy1 saveTbsCoQuanXuLy1(TbsCoQuanXuLy1 pTbsCoQuanXuLy1)  {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc01Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc01BackendUriConstant.TbsCoQuanXuLy1Uri.CREATE_TBS_CO_QUAN_XU_LY_1), pTbsCoQuanXuLy1, HttpMethod.POST, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), TbsCoQuanXuLy1.class);

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return null;

		}

	}

	@Override
	public TbsCoQuanXuLy1 updateTbsCoQuanXuLy1(String pTbsCoQuanXuLy1Id, TbsCoQuanXuLy1 pTbsCoQuanXuLy1)  {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc01Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc01BackendUriConstant.TbsCoQuanXuLy1Uri.UPDATE_TBS_CO_QUAN_XU_LY_1) +"/" + pTbsCoQuanXuLy1Id , pTbsCoQuanXuLy1, HttpMethod.POST, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), TbsCoQuanXuLy1.class);

		} catch (Exception e) {


			LOGGER.error(e.getMessage(), e);
			return null;

		}

	}

	@Override
	public TbsCoQuanXuLy1 getTbsCoQuanXuLy1(String pTbsCoQuanXuLy1Id)  {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc01Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc01BackendUriConstant.TbsCoQuanXuLy1Uri.GET_ONE_TBS_CO_QUAN_XU_LY_1) +"/" + pTbsCoQuanXuLy1Id, null, HttpMethod.GET, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), TbsCoQuanXuLy1.class);

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return null;
		}

	}

	@Override
	public boolean deleteTbsCoQuanXuLy1ById(String pTbsCoQuanXuLy1Id)  {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc01Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc01BackendUriConstant.TbsCoQuanXuLy1Uri.DELETE_TBS_CO_QUAN_XU_LY_1)  + "/" + pTbsCoQuanXuLy1Id, null, HttpMethod.GET, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), Boolean.class);

		} catch (Exception e) {


			LOGGER.error(e.getMessage(), e);
			return false;

		}

	}

	@Override
	public long countAllTbsCoQuanXuLy1()  {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc01Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc01BackendUriConstant.TbsCoQuanXuLy1Uri.COUNT_ALL_TBS_CO_QUAN_XU_LY_1), null, HttpMethod.GET, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), Long.class);

		} catch (Exception e) {


			LOGGER.error(e.getMessage(), e);
			return 0;

		}

	}

}

