/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnsw.ws.p01.controller;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
/**
 * Gửi các bản tin đi của thủ tục 01 NHNN
 */
import javax.xml.soap.*;

import java.io.FileInputStream;
import java.io.StringReader;
import java.net.URI;
import java.net.URISyntaxException;

import java.nio.charset.Charset;

import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.apache.commons.lang3.StringEscapeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.vnsw.ws.p01.constant.ThuTuc01BackendUriConstant;

import com.vnsw.ws.p01.common.Constants01;
import com.vnsw.ws.p01.entity.db.*;

import com.vnsw.ws.p01.envelop.Body;
import com.vnsw.ws.p01.envelop.Content;
import com.vnsw.ws.p01.envelop.Envelope;
import com.vnsw.ws.common.envelop.Error;
import com.vnsw.ws.common.envelop.Header;
import com.vnsw.ws.p01.message.receive.HSCongTy;
import com.vnsw.ws.p01.message.receive.HoSoTienTe;
import com.vnsw.ws.p01.message.send.HoSoNgoaiTe;
import com.vnsw.ws.p01.message.send.SendMessage;
import com.vnsw.ws.p01.message.send.TepDinhKemHoSo;
import com.vnsw.ws.p01.message.send.ThongTinCuaKhau;
import com.vnsw.ws.p01.message.send.YeuCauRut;
import com.vnsw.ws.p01.service.EnvelopeService;
import com.vnsw.ws.p01.service.ReceiveService1;
import com.vnsw.ws.p01.util.Constants;
import com.vnsw.ws.p01.util.FileServiceHelper;
import com.vnsw.ws.p01.util.SBV01HoSoNgoaiTe1BackendUtil;
import com.vnsw.ws.p01.util.SBV01TepDinhKemHoSo1BackendUtil;
import com.vnsw.ws.p01.util.SBV01TienTe1BackendUtil;
import com.vnsw.ws.p01.util.ThucTuc01Constant;
import com.vnsw.ws.p01.util.TrangThaiHoSo;

import com.vnsw.ws.common.service.EnvelopXmlService;
import com.vnsw.ws.common.entity.json.ResponseDownload;
import com.vnsw.ws.common.entity.json.ResponseJson;
import com.vnsw.ws.common.service.EncryptService;
import com.vnsw.ws.common.service.RabbitMQService;
import com.vnsw.ws.helper.RabbitMQErrorHelper;
import com.vnsw.ws.helper.SoapHelper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Phong84NV
 */
@RestController
@RequestMapping("/send/01")
public class Send1Controller {

	public static final Logger logger = LoggerFactory.getLogger(Send1Controller.class);

	private static final String CLASS_NAME = "Send1Controller";

	@Autowired
	private Environment environment;

	@Autowired
	private EnvelopXmlService convertXmlService;

	@Autowired
	private EnvelopeService envelopeService;

	@Autowired
	private EncryptService encryptService;

	@Autowired
	ReceiveService1 receiveEndpoint01;

	@Autowired
	RabbitMQService rabbitMQService;

	@RequestMapping(value = "/sendAll/", method = RequestMethod.POST)
	public ResponseEntity<ResponseJson> sendAll(@RequestBody SendMessage sendMessage) {

		HttpStatus httpStatus = null;
		String errorMessage = "";
		boolean isSuccess = false;
		httpStatus = HttpStatus.OK;
		Envelope envelopeSend = new Envelope();
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
                logger.info("Send message {}", sendMessage);
		try {
			
			// Neu co ky so
			if (sendMessage.getSignedXml() == null) {
				if ("true".equals(sendMessage.getGetXmlNotSend()))

					return getXMLContent(sendMessage);

				else {

					// Lay ho so ngoai te
					HoSoNgoaiTe1 hsNgoaiTe1 = SBV01HoSoNgoaiTe1BackendUtil.getHoSoNgoaiTe1(
							getURL(ThuTuc01BackendUriConstant.HOSONGOAITE1URI_GET), sendMessage.getFiIdHoso());

					envelopeSend = createEnvelopeSend(hsNgoaiTe1, sendMessage);

					String xml = convertXmlService.ObjectToXml(envelopeSend);

					logger.info("XML NOT SIGN: {}", xml);
				}
			}

			// Gui

			isSuccess = send(envelopeSend, sendMessage.getSignedXml(), sendMessage.getType(), Constants.SBV1_PRO);

			logger.info("ISSUCCESS sau khi gui: {}", isSuccess);

			// Gui loi
			if (sendMessage.getGetXmlNotSend() != null && "true".equals(sendMessage.getGetXmlNotSend())) {

				String xml = convertXmlService.ObjectToXml(envelopeSend);

				logger.info("ISSUCCESS khong gui: {}", isSuccess);

				return createResponse(xml, isSuccess, errorMessage, httpStatus, null);
			}

			// Neu gui thanh cong thi update trang thai ho so
			if (isSuccess)
				updateStatusHS(sendMessage);

		} catch (Exception ex) {

			logger.error(ex.getMessage(), ex);
		}

		return createResponse(null, isSuccess, errorMessage, httpStatus, null);

	}

	private ResponseEntity<ResponseJson> getXMLContent(SendMessage sendMessage) {
		String errorMessage = "";
		try {
			long fiIdHoso = sendMessage.getFiIdHoso(); // setFiIdHoso

			HoSoNgoaiTe1 hsNgoaiTe1 = SBV01HoSoNgoaiTe1BackendUtil
					.getHoSoNgoaiTe1(getURL(ThuTuc01BackendUriConstant.HOSONGOAITE1URI_GET), fiIdHoso);

			// Tao message send
			Envelope envelopeSend = createEnvelopeSend(hsNgoaiTe1, sendMessage);

			if (envelopeSend != null) {
				Body getBody = envelopeSend.getBody();
				envelopeSend.setBody(new Body());
				logger.info("LAY BAN TIN BODY GUI DI: {}", getBody.toXml());
				logger.info("LAY BAN TIN ENVELOP DI: {}", envelopeSend.toXml());
				return createResponse(envelopeSend.toXml(), true, getBody.toXml(), HttpStatus.OK, null);

			}

		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
		}
		return createResponse(null, true, errorMessage, HttpStatus.OK, null);
	}

	private String getURL(String uriKey) {
		return environment.getRequiredProperty("URI_BACKEND_ADDRESS") + uriKey;
	}

	private Envelope createEnvelopeSend(HoSoNgoaiTe1 hsNgoaiTe1, SendMessage sendMessage) {

		Envelope envelopeSend = new Envelope();
		try {

			// Gan cac gia tri cho Header
			Header header = setHeader(hsNgoaiTe1, sendMessage);

			// Ktra MessageType de gan Content
			Content content = createContent(hsNgoaiTe1, sendMessage);

			// Gan Content vao Body
			Body body = envelopeService.createBody(content);

			// Gan header, body vao Envelope
			envelopeSend = envelopeService.createResponse(header, body);

		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			return null;
		}

		return envelopeSend;
	}

	private Header setHeader(HoSoNgoaiTe1 hsNgoaiTe1, SendMessage sendMessage) {

		Header header = envelopeService.createSendHeader(hsNgoaiTe1.getMaHoSo(), Constants.SBV1_PRO,
				sendMessage.getType(), sendMessage.getFunction());

		header.getFrom().setIdentity(hsNgoaiTe1.getMaSoThue());

		header.getSubject().setDocumentType(Constants.SBV1_PRO);

		header.getSubject().setPreReference(hsNgoaiTe1.getMaHoSo());

		header.getSubject().setReference(hsNgoaiTe1.getMaHoSo());

		header.getSubject().setPreDocumentYear(header.getSubject().getDocumentYear());

		setFunctionToHeader(header, sendMessage, hsNgoaiTe1);

		return header;
	}

	private void updateStatusHS(SendMessage sendMessage) {
		try {
			// Lay ho so ngoai te
			HoSoNgoaiTe1 hsNgoaiTe1 = SBV01HoSoNgoaiTe1BackendUtil
					.getHoSoNgoaiTe1(getURL(ThuTuc01BackendUriConstant.HOSONGOAITE1URI_GET), sendMessage.getFiIdHoso());

			String type = sendMessage.getType();

			String function = sendMessage.getFunction();

			if (type.equals(Constants01.SBV01_TYPE_11) && (function.equals(Constants01.SBV01_FUNCTION_01)
					|| function.equals(Constants01.SBV01_FUNCTION_02)))
				hsNgoaiTe1.setTrangThai(TrangThaiHoSo.CHO_TIEP_NHAN_1);

			else if (type.equals(Constants01.SBV01_TYPE_11) && function.equals(Constants01.SBV01_FUNCTION_03))
				hsNgoaiTe1.setTrangThai(TrangThaiHoSo.DA_SUA_DOI_BO_SUNG_3);

			else if (type.equals(Constants01.SBV01_TYPE_12) && (function.equals(Constants01.SBV01_FUNCTION_01)))
				hsNgoaiTe1.setTrangThai(TrangThaiHoSo.HUY_BO_2);

			else if (type.equals(Constants01.SBV01_TYPE_12) && (function.equals(Constants01.SBV01_FUNCTION_02)))
				hsNgoaiTe1.setTrangThai(TrangThaiHoSo.YEU_CAU_HUY_6);

			String url = getURL(ThuTuc01BackendUriConstant.HOSONGOAITE1URI_UPDATE);

			SBV01HoSoNgoaiTe1BackendUtil.updateHoSoNgoaiTe1(url, sendMessage.getFiIdHoso(), hsNgoaiTe1);

		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
		}
	}

	private Content createContent(HoSoNgoaiTe1 hsNgoaiTe1, SendMessage sendMessage) {
		String type = sendMessage.getType();
		Content content = new Content();
		if (type.equals(Constants01.SBV01_TYPE_11)) {
			HoSoNgoaiTe hsGui = convertHoSoNgoaiTe(hsNgoaiTe1);
			content.setHsNgoaiTe(hsGui);
		} else if (type.equals(Constants01.SBV01_TYPE_12)) {
			YeuCauRut yeuCauRut = new YeuCauRut();
			yeuCauRut.setNgayRut(new Date());
			yeuCauRut.setNoiDung(sendMessage.getLyDo());
			content.setYeuCauRut(yeuCauRut);
		}
		return content;
	}

	private void setFunctionToHeader(Header header, SendMessage sendMessage, HoSoNgoaiTe1 hsGui) {
		String type = sendMessage.getType();
		if (sendMessage.getFunction() == null || "".equals(sendMessage.getFunction())) {

			if (type.equals(Constants01.SBV01_TYPE_11)) {
				if (hsGui.getTrangThai() == TrangThaiHoSo.TAO_MOI_0)
					header.getSubject().setFunction(Constants01.SBV01_FUNCTION_01);
				else if (hsGui.getTrangThai() == TrangThaiHoSo.CHO_TIEP_NHAN_1)
					header.getSubject().setFunction(Constants01.SBV01_FUNCTION_02);
				else if (hsGui.getTrangThai() == TrangThaiHoSo.YEU_CAU_SUA_DOI_BO_SUNG_5)
					header.getSubject().setFunction(Constants01.SBV01_FUNCTION_03);
			} else if (type.equals(Constants01.SBV01_TYPE_12)) {
				if (hsGui.getTrangThai() == TrangThaiHoSo.CHO_TIEP_NHAN_1)
					header.getSubject().setFunction(Constants01.SBV01_FUNCTION_01);
				else
					header.getSubject().setFunction(Constants01.SBV01_FUNCTION_02);
			}

		} else
			header.getSubject().setFunction(sendMessage.getFunction());
	}

	/**
	 * Gửi di va nhan ket qua tra ve
	 *
	 * @param envelopeSend
	 * @return
	 * @throws Exception
	 */
	private boolean send(Envelope envelopeSend, String signedXml, String msgType, String documentType) {
		Boolean isSuccess = false;
		String xml = "";
		if (signedXml == null || (signedXml != null && "".equals(signedXml))) {
			xml = convertXmlService.ObjectToXml(envelopeSend);
		} else {
			xml = signedXml;
		}

		String isEncrypt = environment.getProperty("ENCRYPT");
		if ("true".equals(isEncrypt)) {
			String key = environment.getProperty("KEY_AES");
			xml = encryptService.encrypt(key, xml);
		}

		String responseStr = "";

		Envelope envl;
		Error error;

		String officeCode = Constants.SBV;
		logger.info("----------------BAT DAU GUI HO SO-------------------");
		String url = environment.getProperty("GATEWAY_LINK");
		logger.info("----------------CALL WEBSERVICE URL: {}-------------------", url);
		try {
			SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
			SOAPConnection soapConnection = soapConnectionFactory.createConnection();

			String nameSpace = environment.getProperty("GATEWAY_NAMESPACE");
			String nameSpaceKey = environment.getProperty("GATEWAY_NAMESPACE_KEY");
			String methodTag = environment.getProperty("GATEWAY_MOTHOD_TAG");
			String requestOfficeCode = environment.getProperty("GATEWAY_PAYLOAD_TAG_OFFICECODE");
			String requestDocumentType = environment.getProperty("GATEWAY_PAYLOAD_TAG_DOCUMENTTYPE");
			String requestPayload = environment.getProperty("GATEWAY_PAYLOAD_TAG_DATA");

			SOAPMessage soapMessage = SoapHelper.createSOAPRequest(xml, officeCode, documentType, nameSpace,
					nameSpaceKey, methodTag, requestOfficeCode, requestDocumentType, requestPayload);

			SOAPMessage soapResponse = soapConnection.call(soapMessage, url);

			responseStr = SoapHelper.getSOAPResponse(soapResponse);
			soapConnection.close();

		} catch (Exception ex) {
			String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
					+ Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
					+ Constants.MESSAGE_SEPARATOR + ex.toString();
			RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());

			error = envelopeService.createError(Constants.ERR01_CODE, Constants.ERR01);
			envl = envelopeService.createEnvelopeError(envelopeSend.getHeader().getSubject().getReference(),
					documentType, msgType, error);
			responseStr = envl.toString();
			logger.error(ex.getMessage(), ex);
		}

		logger.info("ISSUCCESS send sau khi gui gateway: {}", isSuccess);
		if ("true".equals(isEncrypt)) {
			String key = environment.getProperty("KEY_AES");
			xml = encryptService.decrypt(key, responseStr);
		} else {
			xml = responseStr;
		}
//		if (checkFunction99(xml))
//			return true;

		logger.info(" XML Gateway tra ve: {}", xml);

		Envelope envelopeReturn = convertXmlService.xmlToEnvelope(xml, Envelope.class);

		if (envelopeReturn == null)
			return isSuccess;
		isSuccess = checkTypeReturn(envelopeReturn);
		if (!isSuccess) {
                    if (envelopeReturn != null && envelopeReturn.getBody() != null && envelopeReturn.getBody().getContent() != null) {
                        List<Error> errors = envelopeReturn.getBody().getContent().getErrorList();
			envelopeSend.getBody().getContent().setErrorList(errors);
                    }			
		}
		logger.info("ISSUCCESS cuoi cung cua send: {}", isSuccess);
		return isSuccess;
	}

	/**
	 * Kiểm tra bản tin trả về
	 *
	 * @param envelopeReturn
	 * @return
	 */
	private boolean checkTypeReturn(Envelope envelopeReturn) {
		return envelopeReturn != null && envelopeReturn.getHeader() != null
				&& envelopeReturn.getHeader().getSubject() != null
				&& Constants01.SBV01_FUNCTION_99.equals(envelopeReturn.getHeader().getSubject().getFunction());
	}

	public ResponseEntity<ResponseJson> createResponse(List lstResult, boolean isSuccess, String content,
			HttpStatus httpStatus, Long total) {
		ResponseJson objResponse = new ResponseJson();
		objResponse.setData(lstResult);
		if (total == null) {
			total = lstResult != null ? Long.valueOf(lstResult.size()) : 0L;
		}
		objResponse.setTotal(total);
		objResponse.setSuccess(isSuccess);
		objResponse.setMessage(content);
		return new ResponseEntity<>(objResponse, httpStatus);
	}

	public ResponseEntity<ResponseJson> createResponse(Object obj, boolean isSuccess, String content,
			HttpStatus httpStatus, Long total) {
		ResponseJson objResponse = new ResponseJson();
		objResponse.setData(obj);
		objResponse.setTotal(total);
		objResponse.setSuccess(isSuccess);
		objResponse.setMessage(content);
		return new ResponseEntity<>(objResponse, httpStatus);
	}

	/**
	 * Lay du lieu tu Backend
	 *
	 * @throws Exception
	 *
	 * @throws URISyntaxException
	 */
	@SuppressWarnings("rawtypes")
	public ResponseJson getData(String url) {
		ResponseJson responJson = null;
		try {
			logger.info("getData: {}", url);
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

	public boolean validString(String temp) {
		return (temp == null || "".equals(temp.trim()));
	}

	private List<HoSoTienTe> convertTienTe(List<TienTe1> listTienTe) {
		List<HoSoTienTe> listHSTienTe = new ArrayList<>();

		if (listTienTe != null && !listTienTe.isEmpty()) {
			for (int i = 0; i < listTienTe.size(); i++) {
				HoSoTienTe hsTienTe = new HoSoTienTe();
				hsTienTe.setIdHoSo(listTienTe.get(i).getIdHoSo());
				hsTienTe.setIdTienTe(listTienTe.get(i).getIdTienTe());
				hsTienTe.setMaLoaiTienTe(listTienTe.get(i).getMaLoaiTienTe());
				hsTienTe.setSoLuongNgoaiTeBangChu(listTienTe.get(i).getSoLuongNgoaiTeBangChu());
				hsTienTe.setSoLuongNgoaiTeBangSo(listTienTe.get(i).getSoLuongNgoaiTeBangSo());
				listHSTienTe.add(hsTienTe);
			}
		}

		return listHSTienTe;
	}

	private List<TepDinhKemHoSo> convertTepDinhKem(List<TepDinhKemHoSo1> listTepDinhKem1) {
		List<TepDinhKemHoSo> listTDK = new ArrayList<>();
		FileServiceHelper fileServiceHelper = new FileServiceHelper();
		try {
			String url = environment.getRequiredProperty(Constants.URL_FILE_SERVICE) + '/' + (Constants.URL_DOWNLOAD);
			logger.info("URLDOWNLOAD: {}", url);
			for (int i = 0; i < listTepDinhKem1.size(); i++) {
				// Get byte[] file
				logger.info("GUID + PATH + FILENAME: {} , {}, {}", listTepDinhKem1.get(i).getGuID(),
						listTepDinhKem1.get(i).getDuongDanFile(), listTepDinhKem1.get(i).getTenTepDinhKem());

				String fileCode = listTepDinhKem1.get(i).getGuID() + "." + listTepDinhKem1.get(i).getLoaiTep();

				ResponseDownload response = fileServiceHelper.downloadFile(url,
						listTepDinhKem1.get(i).getDuongDanFile(), fileCode);
				logger.info("RESPONSE DOWNLOAD FILE LENGTH: {}", response.getContent().length);
				byte[] bytes = org.apache.commons.codec.binary.Base64.encodeBase64(response.getContent());

				TepDinhKemHoSo tdk = new TepDinhKemHoSo();
				tdk.setIdHoSo(listTepDinhKem1.get(i).getIdHoSo());
				tdk.setIdTepDK(listTepDinhKem1.get(i).getIdTepDK());
				tdk.setMaLoaiTepDinhKem(listTepDinhKem1.get(i).getMaLoaiTepDinhKem());
				tdk.setNoiDungFile(new String(bytes));
				tdk.setTenLoaiTepDinhKem(listTepDinhKem1.get(i).getTenLoaiTepDinhKem());
				tdk.setTenTepDinhKem(listTepDinhKem1.get(i).getTenTepDinhKem());
				listTDK.add(tdk);
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
		}
		return listTDK;
	}

	private HoSoNgoaiTe convertHoSoNgoaiTe(HoSoNgoaiTe1 hsNgoaiTe1) {
		HoSoNgoaiTe hsNgoaiTe = new HoSoNgoaiTe();
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);

		try {
			hsNgoaiTe.setMaChiNhanh(hsNgoaiTe1.getMaChiNhanh());
			hsNgoaiTe.setTenChiNhanh(hsNgoaiTe1.getTenChiNhanh());
			hsNgoaiTe.setHinhThucXNK(hsNgoaiTe1.getHinhThucXNK());
			hsNgoaiTe.setXuatNhapKhauTuNgay(hsNgoaiTe1.getXuatNhapKhauTuNgay());
			hsNgoaiTe.setXuatNhapKhauDenNgay(hsNgoaiTe1.getXuatNhapKhauDenNgay());
			hsNgoaiTe.setCapGiayPhepLanDau(hsNgoaiTe1.isCapGiayPhepLanDau() ? 1 : 0);
			hsNgoaiTe.setSoGiayPhepDaCap(hsNgoaiTe1.getSoGiayPhepDaCap());
			hsNgoaiTe.setDoiTacXuatNhapKhau(hsNgoaiTe1.getDoiTacXuatNhapKhau());
			if (StringUtils.hasText(hsNgoaiTe1.getGhiChu()))
				hsNgoaiTe.setGhiChu(hsNgoaiTe1.getGhiChu());

			// CurrencyList
			String url = getURL(ThuTuc01BackendUriConstant.TIENTE1URI_GETBYTIENTES);
			List<TienTe1> currencyList = SBV01TienTe1BackendUtil.getByTienTes(url, hsNgoaiTe1.getIdHoSo());

			hsNgoaiTe.setCurrencyList(convertTienTe(currencyList));

			// AttachmentList
			url = getURL(ThuTuc01BackendUriConstant.ATTACHMENT1URI_GETBYTEPDINHKEM);
			List<TepDinhKemHoSo1> attachmentList = SBV01TepDinhKemHoSo1BackendUtil.getByTepDinhKems(url,
					hsNgoaiTe1.getIdHoSo());
			hsNgoaiTe.setAttachmentList(convertTepDinhKem(attachmentList));

			// Company
			HSCongTy hsCongTy = new HSCongTy();
			hsCongTy.setMaSoThue(hsNgoaiTe1.getMaSoThue());
			hsCongTy.setTenNganHang(hsNgoaiTe1.getTenNganHang());
			hsCongTy.setDiaChi(hsNgoaiTe1.getDiaChi());
			hsCongTy.setDienThoai(hsNgoaiTe1.getDienThoai());
			hsCongTy.setFax(hsNgoaiTe1.getFax());
			hsNgoaiTe.setHsCongty(hsCongTy);

			// Gate
			ThongTinCuaKhau gate = new ThongTinCuaKhau();
			gate.setMaCuaKhau(hsNgoaiTe1.getMaCuaKhau());
			gate.setTenCuaKhau(hsNgoaiTe1.getTenCuaKhau());
			hsNgoaiTe.setGate(gate);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return new HoSoNgoaiTe();
		}
		return hsNgoaiTe;
	}

	public Object saveModel(Object model, String uri) {

		ResponseJson responseJson = new ResponseJson();
		try {
			logger.info(uri);
			responseJson = createRestTemplate(uri, model, HttpMethod.POST, null);
			logger.info("SaveModel => ResponseJson: {}", responseJson);
		} catch (Exception ex) {
			String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
					+ Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
					+ Constants.MESSAGE_SEPARATOR + ex.toString();
			logger.error(errorInfo);
			RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
			logger.error(ex.getMessage(), ex);
			return responseJson;
		}
		return responseJson;
	}

	private ResponseJson createRestTemplate(String uri, Object body, HttpMethod httpMethod,
			Map<String, Object> params) {

		String host = environment.getRequiredProperty(ThucTuc01Constant.URI_BACKEND_ADDRESS);

		uri = host + uri;

		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(uri);

		if (params != null) {

			for (Map.Entry<String, Object> entry : params.entrySet()) {
				String key = entry.getKey();
				Object value = entry.getValue();
				builder.queryParam(key, String.valueOf(value));
			}

		}

		uri = builder.build().encode().toString();

		List<HttpMessageConverter<?>> converters = new ArrayList<>();

		converters.add(new MappingJackson2HttpMessageConverter());

		RestTemplate restTemplate = new RestTemplate();

		restTemplate.setMessageConverters(converters);

		HttpHeaders headers = new HttpHeaders();

		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity<Object> entity = new HttpEntity<>(body, headers);

		ResponseEntity<ResponseJson> response = restTemplate.exchange(uri, httpMethod, entity, ResponseJson.class);

		return response.getBody();

	}

	private boolean checkFunction99(String xml) {
		try {
			xml = StringEscapeUtils.unescapeXml(xml);
			xml = StringEscapeUtils.unescapeHtml4(xml);
			final String START_TAG = "<ReceiveResult>";
			final String END_TAG = "</ReceiveResult>";
			if (xml.contains(START_TAG) && xml.contains(END_TAG)) {
				xml = xml.substring(xml.indexOf(START_TAG) + START_TAG.length(), xml.lastIndexOf(END_TAG));
			}
			XMLInputFactory factory = XMLInputFactory.newInstance();
			factory.setProperty(XMLInputFactory.IS_SUPPORTING_EXTERNAL_ENTITIES, Boolean.FALSE);
			factory.setProperty(XMLInputFactory.SUPPORT_DTD, Boolean.FALSE);
			XMLStreamReader xmlStreamReader = factory.createXMLStreamReader(new StringReader(xml));
                        XPath xPath = XPathFactory.newInstance().newXPath();
                        String expression = "/Envelope/Header/Subject/function";
                        String function = (String) xPath.compile(expression).evaluate(xmlStreamReader, XPathConstants.STRING);
                        xmlStreamReader.close();
                        return "99".equals(function.trim());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return false;
	}

}