package com.vnsw.ws.p01.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.apache.commons.io.FilenameUtils;
import org.assertj.core.util.Files;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.xml.validation.XmlValidator;
import org.xml.sax.SAXException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vnsw.ws.common.entity.json.ResponseJson;

import com.vnsw.ws.common.service.RabbitMQService;
import com.vnsw.ws.p01.entity.db.*;
import com.vnsw.ws.p01.envelop.Body;
import com.vnsw.ws.p01.envelop.Content;
import com.vnsw.ws.p01.envelop.Envelope;
import com.vnsw.ws.p01.message.receive.GPTienTe;
import com.vnsw.ws.p01.message.receive.GiayPhep;
import com.vnsw.ws.p01.message.receive.KetQuaXuLyHoSo;
import com.vnsw.ws.common.envelop.Error;
import com.vnsw.ws.common.envelop.Header;
import com.vnsw.ws.common.envelop.Subject;
import com.vnsw.ws.p01.util.Constants;
import com.vnsw.ws.p01.util.ResponseUpload;
import com.vnsw.ws.p01.util.SBV01GPTienTe1BackendUtil;
import com.vnsw.ws.p01.util.SBV01GiayPhep1BackendUtil;
import com.vnsw.ws.p01.util.SBV01HoSoNgoaiTe1BackendUtil;
import com.vnsw.ws.p01.util.SBV01KetQuaXuLyHoSo1BackendUtil;
import com.vnsw.ws.p01.util.ThucTuc01Constant;
import com.vnsw.ws.p01.util.TrangThaiHoSo;
import com.vnsw.ws.p01.common.Constants01;
import com.vnsw.ws.p01.constant.ThuTuc01BackendUriConstant;
import com.vnsw.ws.helper.RabbitMQErrorHelper;
import com.vnsw.ws.helper.ValidateXSDHelper;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

/**
 * Xử lý bản tin của thủ tục 01 Bộ NTMT
 */
@Service("helperSBV01Service")
public class ReceiveService1Impl implements ReceiveService1 {

	public static final Logger logger = LoggerFactory.getLogger(ReceiveService1Impl.class);

	private static final String CLASS_NAME = "ReceiveEndpoint01Impl";

	@Autowired
	private Environment environment;
	@Autowired
	private EnvelopeService envelopeService;
	@Autowired
	RabbitMQService rabbitMQService;

	

	String url;
	String messageErrorUpdateHS = "UPDATE STATUS HOSOXNK";
	String messageErrorUpload = "ATTACHMENT UPLOAD FAILED";

		
	public Envelope receive(String xml) {
		
		Envelope envelope = new Envelope();
		Header header = null;
		Content ct = null;
		String documentType;
		String type;
		String function;
		String maHoso;
		
		documentType = envelopeService.getDocumentType(xml);
		type = envelopeService.getValueFromXml(xml, "/Envelope/Header/Subject/type");
		function = envelopeService.getValueFromXml(xml, "/Envelope/Header/Subject/function");
		maHoso = envelopeService.getValueFromXml(xml, "/Envelope/Header/Subject/reference");	
		
		logger.info("[ Load param ] documentType: {}, type: {}, function: {}, maHoso: {}", documentType, type, function,
				maHoso);
		
		try {
			logger.info("[XML RECEIVE:] {}", xml);
	
			ValidateXSDHelper validator = new ValidateXSDHelper();
			 // Validate xml
	        String errorMsg = validator.validateWithStringXML(xml, Constants01.SBV_01_VALIDATE_FILE + type + function + ".xsd");
	        if (errorMsg != null) {
				Error error = new Error();
	            error.setErrorCode(Constants.ERR02_CODE);
	            error.setErrorName(errorMsg);
	            return envelopeService.createEnvelopeError(maHoso, documentType, type, error);
			}
		
			if (envelope.fromXml(xml)) {
				header = envelope.getHeader();
				ct = envelope.getBody().getContent();
			}
			else {
				Error error = new Error();
	            error.setErrorCode(Constants.ERR02_CODE);
	            error.setErrorName(Constants.ERR02);
	            return envelopeService.createEnvelopeError(maHoso, documentType, type, error);
			}
			
			Envelope envelopeReturn = execute(header, ct, documentType, maHoso, type, function);

			return envelopeReturn == null ? createEnvelopReturn(header) : envelopeReturn;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return logException(Constants.ERR02_CODE, e.getLocalizedMessage(), type, maHoso);
		}
	}

	private Envelope execute(Header header, Content ct, String documentType, String maHoso, String type, String function) {
		Envelope envelopeReturn = null;
		
		// Tim ho so ngoai te voi ma Reference
		HoSoNgoaiTe1 hoso1 = getHoSoNgoaiTe1(maHoso);

		if (hoso1 == null || hoso1.getIdHoSo() <= 0) {
			return logException(Constants01.SBV11_CODE, Constants01.SBV11, type, maHoso);
		}

		switch (type) {
		// 31 Hoan thanh cap phep
		case Constants01.SBV01_TYPE_31:
			envelopeReturn = receiveMessaget31(header, ct, maHoso, documentType, type, hoso1);
			if (envelopeReturn != null)
				return envelopeReturn;
			break;

		// 32 Ket qua xu ly ho so
		case Constants01.SBV01_TYPE_32:
			envelopeReturn = receiveMessage32(ct, maHoso, documentType, type, Integer.parseInt(function), hoso1);
			if (envelopeReturn != null)
				return envelopeReturn;
			break;

		// 33 Ket qua xu ly ho so
		case Constants01.SBV01_TYPE_33:
			envelopeReturn = receiveMessage33(ct, maHoso, documentType, type, Integer.parseInt(function), hoso1);
			if (envelopeReturn != null)
				return envelopeReturn;
			break;
		default:
			return logException(Constants.ERR04_CODE, Constants.ERR04, type, maHoso);
		}
		return envelopeReturn;
	}

	private HoSoNgoaiTe1 getHoSoNgoaiTe1(String maHoso) {
		HoSoNgoaiTe1 hoso1 = null;
		try {
			url = getURL(ThuTuc01BackendUriConstant.HOSONGOAITE1URI_FINDBYMAHOSO);
			hoso1 = SBV01HoSoNgoaiTe1BackendUtil.findByMaHoSo(url, maHoso);

			logger.info("[ HOSO ]: {}", hoso1);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			return hoso1;
		}
		return hoso1;
	}

	public String validateWithStringXML(String xml, String schemaFile) {
		SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		String errorMsg = null;
		try {
			Schema schema = schemaFactory
					.newSchema(new StreamSource(XmlValidator.class.getResourceAsStream(schemaFile)));

			Validator validator = schema.newValidator();
			Source source = new StreamSource(new StringReader(xml));
			validator.validate(source);
			errorMsg = null;
		} catch (SAXException | IOException e) {
			errorMsg = e.toString();
			logger.error(e.getMessage(), e);
			return errorMsg;
		}
		return errorMsg;

	}

	private Envelope logException(String errorCode, String errorName, String type, String maHoso) {
		Error error = new Error();
		error.setErrorCode(errorCode);
		error.setErrorName(errorName);
		return envelopeService.createEnvelopeError(maHoso, Constants.SBV1_PRO, type, error);
	}

	/**
	 * Goi ham POST, PUT de Them moi, cap nhat du lieu
	 *
	 * @param url
	 * @param object
	 * @param method
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes" })
	@Override
	public ResponseJson callResforEntity(String url, Object object, String method) {
		try {
			url = environment.getRequiredProperty(ThucTuc01Constant.URI_BACKEND_ADDRESS) + url;
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<Object> entity = new HttpEntity<>(object, headers);
			ResponseEntity responseEntity = null;
			if ("POST".equals(method)) {
				responseEntity = restTemplate.postForEntity(url, entity, ResponseJson.class);
			} else if ("PUT".equals(method)) {
				restTemplate.put(url, object);
			} else if ("DELETE".equals(method)) {
				restTemplate.delete(url);
			}
			if (responseEntity != null) {
				return (ResponseJson) responseEntity.getBody();
			}
		} catch (Exception ex) {
			String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
					+ Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
					+ Constants.MESSAGE_SEPARATOR + ex.toString();
			logger.error(ex.getMessage(), ex);
			RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
		}
		return null;
	}

	/**
	 * Tạo Envelope
	 *
	 * @param xml
	 * @param header
	 * @param json
	 * @return
	 */
	private Envelope createEnvelopReturn(Header header) {
		Envelope envelop = new Envelope();
		Content content = new Content();
		Body body = new Body();
		Subject subject = header.getSubject();
		content.setReceiveDate(new Date());
		body.setContent(content);
		subject.setFunction(Constants.FUNC_SUCCESS);
		header.setSubject(subject);
		envelop.setHeader(header);
		envelop.setBody(body);
		return envelop;
	}
	
	

	private ResponseUpload uploadFile(String base64File, String fileName) {
		URI uploadUrl;
		ResponseUpload uploadInfo = null;
		try {
			url = environment.getRequiredProperty("URI_ADDRESS_FILE_SERVER") + Constants.URL_UPLOAD;
			uploadUrl = new URI(url);

			RestTemplate restTemplate = new RestTemplate();
			FormHttpMessageConverter formConverter = new FormHttpMessageConverter();
			formConverter.setCharset(Charset.forName("UTF8"));
			restTemplate.getMessageConverters().add(formConverter);
			restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
			MultiValueMap<String, Object> parts = new LinkedMultiValueMap<>();

			String folederUpload = environment.getRequiredProperty("FOLDER_TEMP_FILE_SERVICE");
			UUID uuid = UUID.randomUUID();
			String fileNameOnServer = uuid.toString() + "_" + fileName;

			logger.info("uploadFile: {} {} fileNameOnServer: ", url, fileNameOnServer);

			byte[] decodedBytes = org.apache.commons.codec.binary.Base64.decodeBase64(base64File);
			File file = new File(folederUpload + fileNameOnServer);
			writeFile(file, decodedBytes);

			parts.add("file", new FileSystemResource(file));
			parts.add("fileName", fileName);
			parts.add("ministry", "SBV");
			parts.add("procedure", "01");

			uploadInfo = restTemplate.postForObject(uploadUrl, parts, ResponseUpload.class);

			logger.info("UPLOAD URL: {}", uploadUrl);

			Files.delete(file);
			return uploadInfo;
		} catch (URISyntaxException ex) {
			String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
					+ Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
					+ Constants.MESSAGE_SEPARATOR + ex.toString();
			logger.error(ex.getMessage(), ex);
			RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
		}
		return null;
	}

	private void writeFile(File file, byte[] decodedBytes) {
		try (BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(file))) {
			writer.write(decodedBytes);
		} catch (IOException ex) {
			logger.error(ex.getMessage(), ex);
		}

	}

	@SuppressWarnings("rawtypes")
	public ResponseJson getData(String url) {
		ResponseJson responJson = null;
		try {
			String logString = "getData: " + url;
			logger.info(logString);
			URI upLoadUrl = new URI(url);
			RestTemplate restTemplate = new RestTemplate();
			FormHttpMessageConverter formConverter = new FormHttpMessageConverter();
			formConverter.setCharset(Charset.forName("UTF8"));
			restTemplate.getMessageConverters().add(formConverter);
			restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
			ResponseEntity responseEntity = restTemplate.getForEntity(upLoadUrl, ResponseJson.class);
			responJson = (ResponseJson) responseEntity.getBody();
		} catch (Exception ex) {
			String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
					+ Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
					+ Constants.MESSAGE_SEPARATOR + ex.toString();
			RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
			logger.error(ex.getMessage(), ex);
		}

		return responJson;
	}

	private Envelope createErrorSaveDBReturn(String errorMess, String maHS, String documentType, String type) {
		errorMess = "[ Loi trong qua trinh luu : " + errorMess + " ]";
		Error error = new Error();
		error.setErrorCode(Constants.SBV09_CODE);
		error.setErrorName(errorMess);
		Envelope envelopeReturn = envelopeService.createEnvelopeError(maHS, documentType, type, error);
		String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME + Constants.MESSAGE_SEPARATOR
				+ Thread.currentThread().getStackTrace()[1].getMethodName() + Constants.MESSAGE_SEPARATOR + errorMess;
		logger.error(errorInfo);
		RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
		return envelopeReturn;
	}

	private GiayPhep1 convertGiayXacNhanHSXNK1(GiayPhep giayXacNhan, long idHoSo) {
		GiayPhep1 giayXacNhan1 = new GiayPhep1();
		try {
			giayXacNhan1.setIdHoSo(idHoSo);
			giayXacNhan1.setSoGiayPhep(giayXacNhan.getSoGiayPhep());
			giayXacNhan1.setNgayHetHan(giayXacNhan.getNgayHetHan());
			giayXacNhan1.setNgayCap(giayXacNhan.getNgayCap());
			giayXacNhan1.setNguoiKy(giayXacNhan.getNguoiKy());
			giayXacNhan1.setNgayXuatNhapKhauTu(giayXacNhan.getThoiGianXNKTu());
			giayXacNhan1.setNgayXuatNhapKhauDen(giayXacNhan.getThoiGianXNKDen());
			giayXacNhan1.setMaSoThue(giayXacNhan.getHsCongty().getMaSoThue());
			giayXacNhan1.setTenNganHang(giayXacNhan.getHsCongty().getTenNganHang());
			giayXacNhan1.setDiaChi(giayXacNhan.getHsCongty().getDiaChi());
			giayXacNhan1.setDienThoai(giayXacNhan.getHsCongty().getDienThoai());
			giayXacNhan1.setFax(giayXacNhan.getHsCongty().getFax());
			giayXacNhan1.setMaCuaKhau(giayXacNhan.getGate().getMaCuaKhau());
			giayXacNhan1.setTenCuaKhau(giayXacNhan.getGate().getTenCuaKhau());
			if (Objects.nonNull(giayXacNhan.getAttachment())) {
				giayXacNhan1.setMaLoaiTepDinhKem(giayXacNhan.getAttachment().getMaLoaiTepDinhKem());
				giayXacNhan1.setTenLoaiTepDinhKem(giayXacNhan.getAttachment().getTenLoaiTepDinhKem());
				giayXacNhan1.setTenTepDinhKem(giayXacNhan.getAttachment().getTenTepDinhKem());
			}
			
			giayXacNhan1.setMaCoQuan(giayXacNhan.getMaCoQuanCapGiay());
			giayXacNhan1.setTenCoQuan(giayXacNhan.getTenCoQuanCapGiay());
			giayXacNhan1.setGhiChu(giayXacNhan.getGhiChu());
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			new GiayPhep1();
		}
		return giayXacNhan1;
	}

	private KetQuaXuLyHoSo1 convertKetQuaXyLyHS(KetQuaXuLyHoSo ketQuaXuLyHoSo, long idHoSo) {
		KetQuaXuLyHoSo1 ketQuaXuLyHoSo1 = new KetQuaXuLyHoSo1();
		try {
			ketQuaXuLyHoSo1.setChuyenVienXuLy(ketQuaXuLyHoSo.getChuyenVienXuLy());
			ketQuaXuLyHoSo1.setDonViXuLy(ketQuaXuLyHoSo.getDonViXuLy());
			ketQuaXuLyHoSo1.setIdHoSo(idHoSo);
			ketQuaXuLyHoSo1.setNgayXuLy(ketQuaXuLyHoSo.getNgayXuLy());
			ketQuaXuLyHoSo1.setNoiDungXuLy(ketQuaXuLyHoSo.getNoiDungXuLy());
			if (ketQuaXuLyHoSo.getAttachment() != null) {
				ketQuaXuLyHoSo1.setMaLoaiTepDinhKem(ketQuaXuLyHoSo.getAttachment().getMaLoaiTepDinhKem());
				ketQuaXuLyHoSo1.setTenLoaiTepDinhKem(ketQuaXuLyHoSo.getAttachment().getTenLoaiTepDinhKem());
				ketQuaXuLyHoSo1.setTenTepDinhKem(ketQuaXuLyHoSo.getAttachment().getTenTepDinhKem());
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return ketQuaXuLyHoSo1;
		}
		return ketQuaXuLyHoSo1;
	}

	private GPTienTe1 convertGiayPhepTienTe(GPTienTe gpTienTe, long idGPHoSo, long idCapGXNTienTe) {
		GPTienTe1 gpTienTe1 = new GPTienTe1();
		try {
			gpTienTe1.setIdCapGXNHoSo(idGPHoSo);
			gpTienTe1.setIdCapGXNTienTe(idCapGXNTienTe);
			gpTienTe1.setMaLoaiTienTe(gpTienTe.getMaLoaiTienTe());
			gpTienTe1.setSoLuongNgoaiTeBangChu(gpTienTe.getSoLuongNgoaiTeBangChu());
			gpTienTe1.setSoLuongNgoaiTeBangSo(gpTienTe.getSoLuongNgoaiTeBangSo());
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			return new GPTienTe1();
		}
		return gpTienTe1;
	}

	private KetQuaXuLyHoSo1 createHistory(String info, String user, GiayPhep1 giayPhep1, int trangThai) {
		KetQuaXuLyHoSo1 ketquaXLHS = new KetQuaXuLyHoSo1();
		try {
			ketquaXLHS.setNoiDungXuLy(info);
			ketquaXLHS.setNgayXuLy(new Date());
			ketquaXLHS.setChuyenVienXuLy(user);
			ketquaXLHS.setDonViXuLy(Constants.SBV);
			ketquaXLHS.setGuID(giayPhep1.getGuID());
			ketquaXLHS.setDuongDanFile(giayPhep1.getDuongDanFile());
			ketquaXLHS.setIdHoSo(giayPhep1.getIdHoSo());
			ketquaXLHS.setTenTepDinhKem(giayPhep1.getTenTepDinhKem());
			ketquaXLHS.setTenLoaiTepDinhKem(giayPhep1.getTenLoaiTepDinhKem());
			ketquaXLHS.setTrangThai(trangThai);
			url = getURL(ThuTuc01BackendUriConstant.KETQUAXULY1URI_CREATE);
			return SBV01KetQuaXuLyHoSo1BackendUtil.createKetQuaXuLyHoSo1(url, ketquaXLHS);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			ketquaXLHS = null;
		}
		return ketquaXLHS;
	}

	private String getURL(String uriKey) {
		return environment.getRequiredProperty(ThucTuc01Constant.URI_BACKEND_ADDRESS) + uriKey;
	}

	private Envelope receiveMessage33(Content ct, String maHoso, String documentType, String type, int ifunc,
			HoSoNgoaiTe1 hoso1) {
		Envelope envelope = null;
		try {

			KetQuaXuLyHoSo ketQuaXuLyHoSo = ct.getKetQuaXuLyHoSo();

			KetQuaXuLyHoSo1 ketquaXLHS1 = convertKetQuaXyLyHS(ketQuaXuLyHoSo, hoso1.getIdHoSo());

			if (ketQuaXuLyHoSo.getAttachment() != null) {
				// Upload attachment file
				url = getURL(Constants.URL_UPLOAD);
				
				ResponseUpload uploadInfo = uploadFile(ketQuaXuLyHoSo.getAttachment().getNoiDungFile(), ketQuaXuLyHoSo.getAttachment().getTenTepDinhKem());
				
				// Neu upload thanh cong
				
				if (uploadInfo != null) {
					
					String guid = FilenameUtils.getBaseName(uploadInfo.getFileName());
					ketquaXLHS1.setGuID(guid);
					ketquaXLHS1.setDuongDanFile(uploadInfo.getFilePath());

				} else {
					return createErrorSaveDBReturn(messageErrorUpload, maHoso, documentType, type);
				}
			}

			// Update status HSDK_GP_XNKngoaite
			if (ifunc == Integer.parseInt(Constants01.SBV01_FUNCTION_01))
				hoso1.setTrangThai(TrangThaiHoSo.HUY_BO_2);
			else if (ifunc == Integer.parseInt(Constants01.SBV01_FUNCTION_02))
				hoso1.setTrangThai(TrangThaiHoSo.TU_CHOI_YEU_CAU_HUY_7);
			ketquaXLHS1.setTrangThai(hoso1.getTrangThai());

			// Result + Attachment
			url = getURL(ThuTuc01BackendUriConstant.KETQUAXULY1URI_CREATE);
			if (SBV01KetQuaXuLyHoSo1BackendUtil.createKetQuaXuLyHoSo1(url, ketquaXLHS1) == null)
				return createErrorSaveDBReturn("CREATE KETQUAXULY", maHoso, documentType, type);

			// Update status HSDK_GP_XNKngoaite
			url = getURL(ThuTuc01BackendUriConstant.HOSONGOAITE1URI_UPDATE);
			if (SBV01HoSoNgoaiTe1BackendUtil.updateHoSoNgoaiTe1(url, hoso1.getIdHoSo(), hoso1) == null)
				return createErrorSaveDBReturn(messageErrorUpdateHS, maHoso, documentType, type);
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return createErrorSaveDBReturn(e.getMessage(), maHoso, documentType, type);
		}
		return envelope;
	}

	private Envelope receiveMessage32(Content ct, String maHoso, String documentType, String type, int ifunc,
			HoSoNgoaiTe1 hoso1) {
		Envelope envelope = null;
		try {
			KetQuaXuLyHoSo ketQuaXuLyHoSo = ct.getKetQuaXuLyHoSo();

			KetQuaXuLyHoSo1 ketquaXLHS1 = convertKetQuaXyLyHS(ketQuaXuLyHoSo, hoso1.getIdHoSo());
			
			logger.info("KETQUAXULY: {}",ketquaXLHS1);

			if (ketQuaXuLyHoSo.getAttachment() != null) {
				// Upload attachment file
		
				ResponseUpload uploadInfo = uploadFile(ketQuaXuLyHoSo.getAttachment().getNoiDungFile(), ketQuaXuLyHoSo.getAttachment().getTenTepDinhKem());

				// Neu upload thanh cong
				if ( uploadInfo != null) {
					String guid = FilenameUtils.getBaseName(uploadInfo.getFileName());
					ketquaXLHS1.setGuID(guid);
					ketquaXLHS1.setDuongDanFile(uploadInfo.getFilePath());

				} else {
					return createErrorSaveDBReturn(messageErrorUpload, maHoso, documentType, type);
				}
			}
			// Update status HSDK_GP_XNKngoaite
			
			if (ifunc == Integer.parseInt(Constants01.SBV01_FUNCTION_01))
				hoso1.setTrangThai(TrangThaiHoSo.DA_TIEP_NHAN_4);
			else if (ifunc == Integer.parseInt(Constants01.SBV01_FUNCTION_02))
				hoso1.setTrangThai(TrangThaiHoSo.YEU_CAU_SUA_DOI_BO_SUNG_5);
			else if (ifunc == Integer.parseInt(Constants01.SBV01_FUNCTION_03))
				hoso1.setTrangThai(TrangThaiHoSo.TU_CHOI_CAP_PHEP_9);
			ketquaXLHS1.setTrangThai(hoso1.getTrangThai());

			// Ket qua xu ly
			url = getURL(ThuTuc01BackendUriConstant.KETQUAXULY1URI_CREATE);
			if (SBV01KetQuaXuLyHoSo1BackendUtil.createKetQuaXuLyHoSo1(url, ketquaXLHS1) == null)
				return createErrorSaveDBReturn("CREATE KETQUAXULY", maHoso, documentType, type);
			
			url = getURL(ThuTuc01BackendUriConstant.HOSONGOAITE1URI_UPDATE);
			if (SBV01HoSoNgoaiTe1BackendUtil.updateHoSoNgoaiTe1(url, hoso1.getIdHoSo(), hoso1) == null)
				return createErrorSaveDBReturn(messageErrorUpdateHS, maHoso, documentType, type);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return createErrorSaveDBReturn(e.getMessage(), maHoso, documentType, type);
		}
		return envelope;
	}

	private Envelope receiveMessaget31(Header header, Content ct, String maHoso, String documentType, String type,
			HoSoNgoaiTe1 hoso1) {
		Envelope envelope = null;
		try {
			GiayPhep giayPhep = ct.getGiayXacNhanHoSo();
			
			// Tim xem co ton tai giay phep voi MaHS
			url = getURL(ThuTuc01BackendUriConstant.GIAYCAPPHEP1URI_GETBYMAHOSO);
			GiayPhep1 giayPhep1 = SBV01GiayPhep1BackendUtil.getByIdHoSo(url, hoso1.getIdHoSo());
			if (giayPhep1 != null) {
				return createErrorSaveDBReturn("GIAYXACNHANHOSO DA TON TAI TREN HE THONG", maHoso, documentType, type);
			}
			//Check so giay phep co ton tai hay ko
			url = getURL(ThuTuc01BackendUriConstant.GIAYCAPPHEP1URI_FINDBYSOGIAYPHEP);
			giayPhep1 = SBV01GiayPhep1BackendUtil.findBySoGiayPhep(url, giayPhep.getSoGiayPhep());
			
			if (giayPhep1 != null) {
				return createErrorSaveDBReturn("SOGIAYPHEP DA TON TAI TREN HE THONG", maHoso, documentType, type);
			}
			
			// Upload attachment file
			
			
			
			
			// Neu upload thanh cong
			//if (Objects.nonNull(giayPhep)) {
				
				giayPhep1 = convertGiayXacNhanHSXNK1(giayPhep, hoso1.getIdHoSo());
				
				if (Objects.nonNull(ct.getGiayXacNhanHoSo().getAttachment())) {
					url = getURL(Constants.URL_UPLOAD);
					ResponseUpload uploadInfo = uploadFile(ct.getGiayXacNhanHoSo().getAttachment().getNoiDungFile(), ct.getGiayXacNhanHoSo().getAttachment().getTenTepDinhKem());
					if (Objects.nonNull(uploadInfo)) {
						String guid = FilenameUtils.getBaseName(uploadInfo.getFileName());
					giayPhep1.setGuID(guid);
					giayPhep1.setDuongDanFile(uploadInfo.getFilePath());
					}
					
				}
				
				url = getURL(ThuTuc01BackendUriConstant.GIAYCAPPHEP1URI_CREATE);
				if (SBV01GiayPhep1BackendUtil.createGiayPhep1(url, giayPhep1) == null) {
					return createErrorSaveDBReturn("GIAYPHEP", maHoso, documentType, type);
				}
				// CurrencyList
				// Lay thong tin giay phep vua save
				url = getURL(ThuTuc01BackendUriConstant.GIAYPHEPTIENTE1URI_CREATE);
				List<GPTienTe> currencyList = giayPhep.getCurrencyList();
				for (int i = 0; i < currencyList.size(); i++) {
					GPTienTe1 gpTienTe1 = convertGiayPhepTienTe(currencyList.get(i), hoso1.getIdHoSo(),
							giayPhep1.getIdCapGXNHoSo());
					if (SBV01GPTienTe1BackendUtil.createGPTienTe1(url, gpTienTe1) == null)
						return createErrorSaveDBReturn("GIAYPHEPTIENTE", maHoso, documentType, type);
				}
			//} else {
			//	return createErrorSaveDBReturn(messageErrorUpload, maHoso, documentType, type);
			//}

			// Update status HSDK_GP_XNKngoaite
			url = getURL(ThuTuc01BackendUriConstant.HOSONGOAITE1URI_UPDATE);
			hoso1.setTrangThai(TrangThaiHoSo.HOAN_THANH_CAP_PHEP_8);

			if (SBV01HoSoNgoaiTe1BackendUtil.updateHoSoNgoaiTe1(url, hoso1.getIdHoSo(), hoso1) == null)
				return createErrorSaveDBReturn("UPDATE STATUS HOSOXNK", maHoso, documentType, type);

			if (createHistory("Tiếp nhận giấy phép có mã hồ sơ: " + maHoso, header.getFrom().getName(), giayPhep1,
					hoso1.getTrangThai()) != null) {
				logger.info("{}", "[ Luu lich su ]");
			} else {
				logger.info("{}", "[ Luu lich su khong thanh cong ]");
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return createErrorSaveDBReturn(e.getMessage(), maHoso, documentType, type);
		}
		return envelope;
	}

	public static <T> T readObject(ResponseJson responseJson, Class<T> clz) {

		try {
			ObjectMapper mapper = new ObjectMapper();
			if (responseJson.getData() != null) {
				return mapper.readValue(mapper.writeValueAsString(responseJson.getData()), clz);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}
}
