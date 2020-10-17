package com.nsw.monre.p05.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import com.nsw.monre.p05.constant.ThuTuc05Constant;
import com.nsw.monre.p05.constant.ThuTuc05BackendUriConstant;
import com.nsw.monre.p05.searchitem.TbdTepTin5SearchItem;
import com.nsw.monre.p05.model.TbdTepTin5;
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
public class TbdTepTin5ServiceImpl implements TbdTepTin5Service {

	private static final Logger LOGGER = LoggerFactory.getLogger(TbdTepTin5ServiceImpl.class);

	@Autowired
	private Environment mEnvironment;

	@Override
	public List<TbdTepTin5> getTbdTepTin5s(int pageIndex, int pageSize, String sort) {

		try {

			Map<String, Object> params = new HashMap<>();

			 params.put("pageIndex", pageIndex);

			 params.put("pageSize", pageSize);

			 params.put("sort", sort);

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc05Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc05BackendUriConstant.TbdTepTin5Uri.GET_SLICE_TBD_TEP_TIN_5), null, HttpMethod.GET, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), new TypeReference<List<TbdTepTin5>>(){});

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return Collections.emptyList();


		}

	}

	@Override
	public List<TbdTepTin5> getTbdTepTin5s() {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc05Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc05BackendUriConstant.TbdTepTin5Uri.GET_ALL_TBD_TEP_TIN_5), null, HttpMethod.GET, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), new TypeReference<List<TbdTepTin5>>(){});

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return Collections.emptyList();


		}

	}

	@Override
	public List<TbdTepTin5> searchTbdTepTin5s(TbdTepTin5SearchItem item) {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc05Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc05BackendUriConstant.TbdTepTin5Uri.SEARCH_TBD_TEP_TIN_5), item, HttpMethod.POST, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), new TypeReference<List<TbdTepTin5>>(){});

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return Collections.emptyList();


		}

	}

	@Override
	public long countSearchTbdTepTin5(TbdTepTin5SearchItem item) {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc05Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc05BackendUriConstant.TbdTepTin5Uri.COUNT_SEARCH_TBD_TEP_TIN_5), item, HttpMethod.POST, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), Long.class);

		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return 0;


		}

	}

	@Override
	public boolean deleteBySearchItemTbdTepTin5s(TbdTepTin5SearchItem item) {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc05Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc05BackendUriConstant.TbdTepTin5Uri.DELETE_BY_SEARCH_ITEM_TBD_TEP_TIN_5), item, HttpMethod.POST, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), Boolean.class);

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return false;


		}

	}

	@Override
	public List<TbdTepTin5> callStoreMappingToModel(Object[] paramInputs) {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc05Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc05BackendUriConstant.TbdTepTin5Uri.CALL_STORE_MAPPING_TO_TBD_TEP_TIN_5), paramInputs, HttpMethod.POST, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), new TypeReference<List<TbdTepTin5>>(){});

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return Collections.emptyList();

		}

	}

	@Override
	public Object callStoreNoMappingToModel(Object[] paramInputs) {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc05Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc05BackendUriConstant.TbdTepTin5Uri.CALL_STORE_NO_MAPPING_TO_TBD_TEP_TIN_5), paramInputs, HttpMethod.POST, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return responseJson.getData();

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return null;


		}

	}

	@Override
	public TbdTepTin5 saveTbdTepTin5(TbdTepTin5 pTbdTepTin5) {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc05Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc05BackendUriConstant.TbdTepTin5Uri.CREATE_TBD_TEP_TIN_5), pTbdTepTin5, HttpMethod.POST, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), TbdTepTin5.class);

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return null;
		}

	}

	@Override
	public TbdTepTin5 updateTbdTepTin5(Long pTbdTepTin5Id, TbdTepTin5 pTbdTepTin5) {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc05Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc05BackendUriConstant.TbdTepTin5Uri.UPDATE_TBD_TEP_TIN_5) +"/" + pTbdTepTin5Id , pTbdTepTin5, HttpMethod.POST, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), TbdTepTin5.class);

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return null;

		}

	}

	@Override
	public TbdTepTin5 getTbdTepTin5(Long pTbdTepTin5Id) {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc05Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc05BackendUriConstant.TbdTepTin5Uri.GET_ONE_TBD_TEP_TIN_5) +"/" + pTbdTepTin5Id, null, HttpMethod.GET, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), TbdTepTin5.class);

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return null;

		}

	}

	@Override
	public boolean deleteTbdTepTin5ById(Long pTbdTepTin5Id) {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc05Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc05BackendUriConstant.TbdTepTin5Uri.DELETE_TBD_TEP_TIN_5)  + "/" + pTbdTepTin5Id, null, HttpMethod.GET, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), Boolean.class);

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return false;

		}

	}

	@Override
	public long countAllTbdTepTin5() {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc05Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc05BackendUriConstant.TbdTepTin5Uri.COUNT_ALL_TBD_TEP_TIN_5), null, HttpMethod.GET, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), Long.class);

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return 0;

		}

	}

	@Override
	public List<TbdTepTin5> findByIdHSOrderByLoaiTepTinAsc(long idHS) {

		try {

			Map<String, Object> params = new HashMap<>();

			params.put("idHS", idHS);

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc05Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc05BackendUriConstant.TbdTepTin5Uri.FIND_BY_ID_H_S_ORDER_BY_LOAI_TEP_TIN_ASC), null, HttpMethod.GET, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), new TypeReference<List<TbdTepTin5>>(){});

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return Collections.emptyList();


		}

	}

}

