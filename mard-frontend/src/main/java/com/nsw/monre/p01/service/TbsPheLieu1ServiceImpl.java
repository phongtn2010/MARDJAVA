package com.nsw.monre.p01.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import com.nsw.monre.p01.constant.ThuTuc01Constant;
import com.nsw.monre.p01.constant.ThuTuc01BackendUriConstant;
import com.nsw.monre.p01.searchitem.TbsPheLieu1SearchItem;
import com.nsw.monre.p01.model.TbsPheLieu1;
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
public class TbsPheLieu1ServiceImpl implements TbsPheLieu1Service {

	private static final Logger LOGGER = LoggerFactory.getLogger(TbsPheLieu1ServiceImpl.class);

	@Autowired
	private Environment mEnvironment;

	@Override
	public List<TbsPheLieu1> getTbsPheLieu1s(int pageIndex, int pageSize, String sort)  {

		try {

			Map<String, Object> params = new HashMap<>();

			 params.put("pageIndex", pageIndex);

			 params.put("pageSize", pageSize);

			 params.put("sort", sort);

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc01Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc01BackendUriConstant.TbsPheLieu1Uri.GET_SLICE_TBS_PHE_LIEU_1), null, HttpMethod.GET, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), new TypeReference<List<TbsPheLieu1>>(){});

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return Collections.emptyList();

		}

	}

	@Override
	public List<TbsPheLieu1> getTbsPheLieu1s()  {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc01Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc01BackendUriConstant.TbsPheLieu1Uri.GET_ALL_TBS_PHE_LIEU_1), null, HttpMethod.GET, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), new TypeReference<List<TbsPheLieu1>>(){});

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return Collections.emptyList();
		}

	}

	@Override
	public List<TbsPheLieu1> searchTbsPheLieu1s(TbsPheLieu1SearchItem item)  {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc01Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc01BackendUriConstant.TbsPheLieu1Uri.SEARCH_TBS_PHE_LIEU_1), item, HttpMethod.POST, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), new TypeReference<List<TbsPheLieu1>>(){});

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return Collections.emptyList();

		}

	}

	@Override
	public long countSearchTbsPheLieu1(TbsPheLieu1SearchItem item)  {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc01Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc01BackendUriConstant.TbsPheLieu1Uri.COUNT_SEARCH_TBS_PHE_LIEU_1), item, HttpMethod.POST, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), Long.class);

		} catch (Exception e) {


			LOGGER.error(e.getMessage(), e);
			return 0;

		}

	}

	@Override
	public boolean deleteBySearchItemTbsPheLieu1s(TbsPheLieu1SearchItem item)  {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc01Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc01BackendUriConstant.TbsPheLieu1Uri.DELETE_BY_SEARCH_ITEM_TBS_PHE_LIEU_1), item, HttpMethod.POST, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), Boolean.class);

		} catch (Exception e) {


			LOGGER.error(e.getMessage(), e);
			return false;

		}

	}

	@Override
	public List<TbsPheLieu1> callStoreMappingToModel(Object[] paramInputs)  {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc01Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc01BackendUriConstant.TbsPheLieu1Uri.CALL_STORE_MAPPING_TO_TBS_PHE_LIEU_1), paramInputs, HttpMethod.POST, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), new TypeReference<List<TbsPheLieu1>>(){});

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return Collections.emptyList();

		}

	}

	@Override
	public Object callStoreNoMappingToModel(Object[] paramInputs)  {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc01Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc01BackendUriConstant.TbsPheLieu1Uri.CALL_STORE_NO_MAPPING_TO_TBS_PHE_LIEU_1), paramInputs, HttpMethod.POST, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return responseJson.getData();

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return null;

		}

	}

	@Override
	public TbsPheLieu1 saveTbsPheLieu1(TbsPheLieu1 pTbsPheLieu1)  {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc01Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc01BackendUriConstant.TbsPheLieu1Uri.CREATE_TBS_PHE_LIEU_1), pTbsPheLieu1, HttpMethod.POST, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), TbsPheLieu1.class);

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return null;

		}

	}

	@Override
	public TbsPheLieu1 updateTbsPheLieu1(String pTbsPheLieu1Id, TbsPheLieu1 pTbsPheLieu1)  {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc01Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc01BackendUriConstant.TbsPheLieu1Uri.UPDATE_TBS_PHE_LIEU_1) +"/" + pTbsPheLieu1Id , pTbsPheLieu1, HttpMethod.POST, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), TbsPheLieu1.class);

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return null;

		}

	}

	@Override
	public TbsPheLieu1 getTbsPheLieu1(String pTbsPheLieu1Id)  {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc01Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc01BackendUriConstant.TbsPheLieu1Uri.GET_ONE_TBS_PHE_LIEU_1) +"/" + pTbsPheLieu1Id, null, HttpMethod.GET, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), TbsPheLieu1.class);

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return null;

		}

	}

	@Override
	public boolean deleteTbsPheLieu1ById(String pTbsPheLieu1Id)  {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc01Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc01BackendUriConstant.TbsPheLieu1Uri.DELETE_TBS_PHE_LIEU_1)  + "/" + pTbsPheLieu1Id, null, HttpMethod.GET, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), Boolean.class);

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return false;

		}

	}

	@Override
	public long countAllTbsPheLieu1()  {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc01Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc01BackendUriConstant.TbsPheLieu1Uri.COUNT_ALL_TBS_PHE_LIEU_1), null, HttpMethod.GET, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), Long.class);

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return 0;

		}

	}

}

