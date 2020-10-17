package com.nsw.monre.p01.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import com.nsw.monre.p01.constant.ThuTuc01Constant;
import com.nsw.monre.p01.constant.ThuTuc01BackendUriConstant;
import com.nsw.monre.p01.searchitem.TbsThongTinCoSoSX1SearchItem;
import com.nsw.monre.p01.model.TbsThongTinCoSoSX1;
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
public class TbsThongTinCoSoSX1ServiceImpl implements TbsThongTinCoSoSX1Service {

	private static final Logger LOGGER = LoggerFactory.getLogger(TbsThongTinCoSoSX1ServiceImpl.class);

	@Autowired
	private Environment mEnvironment;

	@Override
	public List<TbsThongTinCoSoSX1> getTbsThongTinCoSoSX1s(int pageIndex, int pageSize, String sort)  {

		try {

			Map<String, Object> params = new HashMap<>();

			 params.put("pageIndex", pageIndex);

			 params.put("pageSize", pageSize);

			 params.put("sort", sort);

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc01Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc01BackendUriConstant.TbsThongTinCoSoSX1Uri.GET_SLICE_TBS_THONG_TIN_CO_SO_S_X_1), null, HttpMethod.GET, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), new TypeReference<List<TbsThongTinCoSoSX1>>(){});

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return Collections.emptyList();

		}

	}

	@Override
	public List<TbsThongTinCoSoSX1> getTbsThongTinCoSoSX1s()  {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc01Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc01BackendUriConstant.TbsThongTinCoSoSX1Uri.GET_ALL_TBS_THONG_TIN_CO_SO_S_X_1), null, HttpMethod.GET, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), new TypeReference<List<TbsThongTinCoSoSX1>>(){});

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return Collections.emptyList();

		}

	}

	@Override
	public List<TbsThongTinCoSoSX1> searchTbsThongTinCoSoSX1s(TbsThongTinCoSoSX1SearchItem item)  {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc01Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc01BackendUriConstant.TbsThongTinCoSoSX1Uri.SEARCH_TBS_THONG_TIN_CO_SO_S_X_1), item, HttpMethod.POST, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), new TypeReference<List<TbsThongTinCoSoSX1>>(){});

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return Collections.emptyList();

		}

	}

	@Override
	public long countSearchTbsThongTinCoSoSX1(TbsThongTinCoSoSX1SearchItem item)  {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc01Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc01BackendUriConstant.TbsThongTinCoSoSX1Uri.COUNT_SEARCH_TBS_THONG_TIN_CO_SO_S_X_1), item, HttpMethod.POST, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), Long.class);

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return 0;
		}

	}

	@Override
	public boolean deleteBySearchItemTbsThongTinCoSoSX1s(TbsThongTinCoSoSX1SearchItem item)  {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc01Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc01BackendUriConstant.TbsThongTinCoSoSX1Uri.DELETE_BY_SEARCH_ITEM_TBS_THONG_TIN_CO_SO_S_X_1), item, HttpMethod.POST, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), Boolean.class);

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return false;

		}

	}

	@Override
	public List<TbsThongTinCoSoSX1> callStoreMappingToModel(Object[] paramInputs)  {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc01Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc01BackendUriConstant.TbsThongTinCoSoSX1Uri.CALL_STORE_MAPPING_TO_TBS_THONG_TIN_CO_SO_S_X_1), paramInputs, HttpMethod.POST, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), new TypeReference<List<TbsThongTinCoSoSX1>>(){});

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return Collections.emptyList();
		}

	}

	@Override
	public Object callStoreNoMappingToModel(Object[] paramInputs)  {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc01Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc01BackendUriConstant.TbsThongTinCoSoSX1Uri.CALL_STORE_NO_MAPPING_TO_TBS_THONG_TIN_CO_SO_S_X_1), paramInputs, HttpMethod.POST, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return responseJson.getData();

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return null;


		}

	}

	@Override
	public TbsThongTinCoSoSX1 saveTbsThongTinCoSoSX1(TbsThongTinCoSoSX1 pTbsThongTinCoSoSX1)  {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc01Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc01BackendUriConstant.TbsThongTinCoSoSX1Uri.CREATE_TBS_THONG_TIN_CO_SO_S_X_1), pTbsThongTinCoSoSX1, HttpMethod.POST, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), TbsThongTinCoSoSX1.class);

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return null;


		}

	}

	@Override
	public TbsThongTinCoSoSX1 updateTbsThongTinCoSoSX1(Long pTbsThongTinCoSoSX1Id, TbsThongTinCoSoSX1 pTbsThongTinCoSoSX1)  {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc01Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc01BackendUriConstant.TbsThongTinCoSoSX1Uri.UPDATE_TBS_THONG_TIN_CO_SO_S_X_1) +"/" + pTbsThongTinCoSoSX1Id , pTbsThongTinCoSoSX1, HttpMethod.POST, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), TbsThongTinCoSoSX1.class);

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return null;


		}

	}

	@Override
	public TbsThongTinCoSoSX1 getTbsThongTinCoSoSX1(Long pTbsThongTinCoSoSX1Id)  {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc01Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc01BackendUriConstant.TbsThongTinCoSoSX1Uri.GET_ONE_TBS_THONG_TIN_CO_SO_S_X_1) +"/" + pTbsThongTinCoSoSX1Id, null, HttpMethod.GET, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), TbsThongTinCoSoSX1.class);

		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return null;

		}

	}

	@Override
	public boolean deleteTbsThongTinCoSoSX1ById(Long pTbsThongTinCoSoSX1Id)  {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc01Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc01BackendUriConstant.TbsThongTinCoSoSX1Uri.DELETE_TBS_THONG_TIN_CO_SO_S_X_1)  + "/" + pTbsThongTinCoSoSX1Id, null, HttpMethod.GET, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), Boolean.class);

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return false;

		}

	}

	@Override
	public long countAllTbsThongTinCoSoSX1()  {

		try {

			Map<String, Object> params = new HashMap<>();

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc01Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc01BackendUriConstant.TbsThongTinCoSoSX1Uri.COUNT_ALL_TBS_THONG_TIN_CO_SO_S_X_1), null, HttpMethod.GET, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), Long.class);

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return 0;

		}

	}

	@Override
	public List<TbsThongTinCoSoSX1> findByMaNguoiTaoOrderByIdCSAsc(String maNguoiTao)  {

		try {

			Map<String, Object> params = new HashMap<>();

			params.put("maNguoiTao", maNguoiTao);

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc01Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc01BackendUriConstant.TbsThongTinCoSoSX1Uri.FIND_BY_MA_NGUOI_TAO_ORDER_BY_ID_C_S_ASC), null, HttpMethod.GET, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), new TypeReference<List<TbsThongTinCoSoSX1>>(){});

		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return Collections.emptyList();

		}

	}

	@Override
	public List<TbsThongTinCoSoSX1> findByMaNguoiTaoOrderByIdCSDesc(String maNguoiTao)  {

		try {

			Map<String, Object> params = new HashMap<>();

			params.put("maNguoiTao", maNguoiTao);

			ResponseJson responseJson = RestTemplateClient.createRestTemplate(mEnvironment.getRequiredProperty(ThuTuc01Constant.HOST_NAME), mEnvironment.getRequiredProperty(ThuTuc01BackendUriConstant.TbsThongTinCoSoSX1Uri.FIND_BY_MA_NGUOI_TAO_ORDER_BY_ID_C_S_DESC), null, HttpMethod.GET, params);

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

			return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), new TypeReference<List<TbsThongTinCoSoSX1>>(){});

		} catch (Exception e) {

			LOGGER.error(e.getMessage(), e);
			return Collections.emptyList();

		}

	}

}

