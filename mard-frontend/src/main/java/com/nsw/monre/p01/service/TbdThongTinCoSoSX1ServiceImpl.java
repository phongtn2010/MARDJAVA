package com.nsw.monre.p01.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import com.nsw.monre.p01.constant.ThuTuc01Constant;
import com.nsw.monre.p01.constant.ThuTuc01BackendUriConstant;
import com.nsw.monre.p01.searchitem.TbdThongTinCoSoSX1SearchItem;
import com.nsw.monre.p01.model.TbdThongTinCoSoSX1;
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
public class TbdThongTinCoSoSX1ServiceImpl implements TbdThongTinCoSoSX1Service {

	private static final Logger LOGGER = LoggerFactory.getLogger(TbdThongTinCoSoSX1ServiceImpl.class);

	@Autowired
	private Environment mEnvironment;

	@Override
	public List<TbdThongTinCoSoSX1> getTbdThongTinCoSoSX1s(int pageIndex, int pageSize, String sort)  {

		try {

			Map<String, Object> params = new HashMap<>();

			 params.put("pageIndex", pageIndex);

			 params.put("pageSize", pageSize);

			 params.put("sort", sort);

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc01Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc01BackendUriConstant.TbdThongTinCoSoSX1Uri.GET_SLICE_TBD_THONG_TIN_CO_SO_S_X_1), null, HttpMethod.GET, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), new TypeReference<List<TbdThongTinCoSoSX1>>(){});

		} catch (Exception e) {


			LOGGER.error(e.getMessage(), e);
			return Collections.emptyList();

		}

	}

	@Override
	public List<TbdThongTinCoSoSX1> getTbdThongTinCoSoSX1s()  {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc01Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc01BackendUriConstant.TbdThongTinCoSoSX1Uri.GET_ALL_TBD_THONG_TIN_CO_SO_S_X_1), null, HttpMethod.GET, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), new TypeReference<List<TbdThongTinCoSoSX1>>(){});

		} catch (Exception e) {


			LOGGER.error(e.getMessage(), e);
			return Collections.emptyList();

		}

	}

	@Override
	public List<TbdThongTinCoSoSX1> searchTbdThongTinCoSoSX1s(TbdThongTinCoSoSX1SearchItem item)  {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc01Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc01BackendUriConstant.TbdThongTinCoSoSX1Uri.SEARCH_TBD_THONG_TIN_CO_SO_S_X_1), item, HttpMethod.POST, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), new TypeReference<List<TbdThongTinCoSoSX1>>(){});

		} catch (Exception e) {


			LOGGER.error(e.getMessage(), e);
			return Collections.emptyList();

		}

	}

	@Override
	public long countSearchTbdThongTinCoSoSX1(TbdThongTinCoSoSX1SearchItem item)  {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc01Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc01BackendUriConstant.TbdThongTinCoSoSX1Uri.COUNT_SEARCH_TBD_THONG_TIN_CO_SO_S_X_1), item, HttpMethod.POST, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), Long.class);

		} catch (Exception e) {


			LOGGER.error(e.getMessage(), e);
			return 0;
		}

	}

	@Override
	public boolean deleteBySearchItemTbdThongTinCoSoSX1s(TbdThongTinCoSoSX1SearchItem item)  {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc01Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc01BackendUriConstant.TbdThongTinCoSoSX1Uri.DELETE_BY_SEARCH_ITEM_TBD_THONG_TIN_CO_SO_S_X_1), item, HttpMethod.POST, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), Boolean.class);

		} catch (Exception e) {


			LOGGER.error(e.getMessage(), e);
			return false;

		}

	}

	@Override
	public List<TbdThongTinCoSoSX1> callStoreMappingToModel(Object[] paramInputs)  {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc01Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc01BackendUriConstant.TbdThongTinCoSoSX1Uri.CALL_STORE_MAPPING_TO_TBD_THONG_TIN_CO_SO_S_X_1), paramInputs, HttpMethod.POST, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), new TypeReference<List<TbdThongTinCoSoSX1>>(){});

		} catch (Exception e) {


			LOGGER.error(e.getMessage(), e);
			return Collections.emptyList();

		}

	}

	@Override
	public Object callStoreNoMappingToModel(Object[] paramInputs)  {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc01Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc01BackendUriConstant.TbdThongTinCoSoSX1Uri.CALL_STORE_NO_MAPPING_TO_TBD_THONG_TIN_CO_SO_S_X_1), paramInputs, HttpMethod.POST, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return responseJson.getData();

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return null;

		}

	}

	@Override
	public TbdThongTinCoSoSX1 saveTbdThongTinCoSoSX1(TbdThongTinCoSoSX1 pTbdThongTinCoSoSX1)  {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc01Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc01BackendUriConstant.TbdThongTinCoSoSX1Uri.CREATE_TBD_THONG_TIN_CO_SO_S_X_1), pTbdThongTinCoSoSX1, HttpMethod.POST, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), TbdThongTinCoSoSX1.class);

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return null;

		}

	}

	@Override
	public TbdThongTinCoSoSX1 updateTbdThongTinCoSoSX1(Long pTbdThongTinCoSoSX1Id, TbdThongTinCoSoSX1 pTbdThongTinCoSoSX1)  {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc01Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc01BackendUriConstant.TbdThongTinCoSoSX1Uri.UPDATE_TBD_THONG_TIN_CO_SO_S_X_1) +"/" + pTbdThongTinCoSoSX1Id , pTbdThongTinCoSoSX1, HttpMethod.POST, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), TbdThongTinCoSoSX1.class);

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return null;

		}

	}

	@Override
	public TbdThongTinCoSoSX1 getTbdThongTinCoSoSX1(Long pTbdThongTinCoSoSX1Id)  {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc01Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc01BackendUriConstant.TbdThongTinCoSoSX1Uri.GET_ONE_TBD_THONG_TIN_CO_SO_S_X_1) +"/" + pTbdThongTinCoSoSX1Id, null, HttpMethod.GET, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), TbdThongTinCoSoSX1.class);

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return null;

		}

	}

	@Override
	public boolean deleteTbdThongTinCoSoSX1ById(Long pTbdThongTinCoSoSX1Id)  {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc01Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc01BackendUriConstant.TbdThongTinCoSoSX1Uri.DELETE_TBD_THONG_TIN_CO_SO_S_X_1)  + "/" + pTbdThongTinCoSoSX1Id, null, HttpMethod.GET, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), Boolean.class);

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return false;

		}

	}

	@Override
	public long countAllTbdThongTinCoSoSX1()  {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc01Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc01BackendUriConstant.TbdThongTinCoSoSX1Uri.COUNT_ALL_TBD_THONG_TIN_CO_SO_S_X_1), null, HttpMethod.GET, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), Long.class);

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return 0;

		}

	}

	@Override
	public List<TbdThongTinCoSoSX1> findByIdHS(long idHS)  {

		try {

			Map<String, Object> params = new HashMap<>();

			params.put("idHS", idHS);

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc01Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc01BackendUriConstant.TbdThongTinCoSoSX1Uri.FIND_BY_ID_H_S), null, HttpMethod.GET, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), new TypeReference<List<TbdThongTinCoSoSX1>>(){});

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return Collections.emptyList();

		}

	}

	@Override
	public List<TbdThongTinCoSoSX1> findByIdHSOrderByTbdThongTinCoSoSXIdAsc(long idHS)  {

		try {

			Map<String, Object> params = new HashMap<>();

			params.put("idHS", idHS);

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc01Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc01BackendUriConstant.TbdThongTinCoSoSX1Uri.FIND_BY_ID_H_S_ORDER_BY_TBD_THONG_TIN_CO_SO_S_X_ID_ASC), null, HttpMethod.GET, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), new TypeReference<List<TbdThongTinCoSoSX1>>(){});

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return Collections.emptyList();

		}

	}

	@Override
	public List<TbdThongTinCoSoSX1> findByIdCS(long idCS)  {

		try {

			Map<String, Object> params = new HashMap<>();

			params.put("idCS", idCS);

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc01Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc01BackendUriConstant.TbdThongTinCoSoSX1Uri.FIND_BY_ID_C_S), null, HttpMethod.GET, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), new TypeReference<List<TbdThongTinCoSoSX1>>(){});

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return Collections.emptyList();

		}

	}

	@Override
	public TbdThongTinCoSoSX1 findByIdHSAndIdCS(long idHS, long idCS)  {

		try {

			Map<String, Object> params = new HashMap<>();

			params.put("idHS", idHS);

			params.put("idCS", idCS);

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc01Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc01BackendUriConstant.TbdThongTinCoSoSX1Uri.FIND_BY_ID_H_S_AND_ID_C_S), null, HttpMethod.GET, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), TbdThongTinCoSoSX1.class);

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return null;

		}

	}

}

