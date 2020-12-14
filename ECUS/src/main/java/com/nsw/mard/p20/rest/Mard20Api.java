package com.nsw.mard.p20.rest;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.*;

import com.nsw.common.model.TokenInfo;
import com.nsw.common.model.json.ResponseJson;
import com.nsw.mard.p14.rest.SecurityUtil;

import com.nsw.mard.p20.model.TbdDinhKem20;
import com.nsw.mard.p20.model.TbdHoSo20;

import com.nsw.mard.p20.model.*;
import com.nsw.security.UserCustom;

import com.nsw.util.Utility;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/mard/api/20")
public class Mard20Api extends Mard20CallBack {

	public static final String DOCUMENT_TYPE = "BNNPTNT06000072";
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Mard20Api.class);
	
	@Autowired
	private Mard20TbdHoSo20Resource fldMard20TbdHoSo20Resource;

	@Autowired
	private Mard20TbsTepDinhKem20Resource fldMard20TbsTepDinhKem20Resource;

	@Autowired
	private Mard20TbdDinhKem20Resource fldMard20TbdDinhKem20Resource;

	@Autowired
	private Mard20TbsTrangThai20Resource fldMard20TbsTrangThai20Resource;

	@Autowired
	private Mard20TbdThuoc20Resource fldMard20TbdThuoc20Resource;

	@Autowired
	private Mard20TbsLoaiThuoc20Resource fldMard20TbsLoaiThuoc20Resource;

	//@Autowired
	//private Mard20TbsMucDich20Resource fldMard20TbsMucDich20Resource;

	@Autowired
	private Mard20TbsLoaiCN20Resource fldMard20TbsLoaiCN20Resoure;

	@Autowired
	private Mard20TbdThongBaoKetQua20Resource fldMard20TbdThongBaoKetQua20Resource;

	@Autowired
	private Mard20TbdTBKetQuaThuoc20Resource fldMard20TbdTBKetQuaThuoc20Resource;

	@Autowired
	private Mard20TbdKetQuaXuLy20Resource fldMard20TbdKetQuaXuLy20Resource;

	@Autowired
	private  Mard20TbsLoaiThuoc20Resource mard20TbsLoaiThuoc20Resource;



	private MessageSource fldMessageSource;

	@Autowired
	public Mard20Api(MessageSource messageSource) {
		this.fldMessageSource = messageSource;
	}

	@RequestMapping(value = "/edit/{idHoSo}", method = RequestMethod.POST)
	public ResponseEntity<Form20DTO> edit(@PathVariable("idHoSo") Long idHoSo) {

		Form20DTO form = new Form20DTO();
		form.setDanhMucTepDinhKems(fldMard20TbsTepDinhKem20Resource.findByLoaiThuTucOrderByFiSortAsc("BNNPTNT06000071").getBody());
		form.setDanhMucThuocs(fldMard20TbsLoaiThuoc20Resource.findAllTbsLoaiThuoc20(new PageableDTO(100, 0)).getBody());
		//form.setDanhMucMucDichs(fldMard20TbsMucDich20Resource.findByFiDocumentType(DOCUMENT_TYPE).getBody());
		//form.setDanhMucLoaiCN(fldMard20TbsLoaiCN20Resoure.findByFiDocumentType(DOCUMENT_TYPE).getBody());
		form.setDanhMucLoaiCN(fldMard20TbsLoaiCN20Resoure.findByFiDocumentType("BNNPTNT06000071").getBody());
		String code = "0";
		TbdHoSo20DTO hoSo20DTO = new TbdHoSo20DTO();
		hoSo20DTO.setFiModifiedDate(new Date());
		form.setHoSo(hoSo20DTO);
		if (idHoSo > 0) {
			BeanUtils.copyProperties(fldMard20TbdHoSo20Resource.getTbdHoSo20(idHoSo).getBody(), hoSo20DTO);
			form.setHoSo(hoSo20DTO);
			form.setTepDinhKems(fldMard20TbdDinhKem20Resource.findByFiIdHoSo(idHoSo).getBody());
			form.setThuocs(fldMard20TbdThuoc20Resource.findByFiIdHoSo(idHoSo).getBody());

			code = String.valueOf(form.getHoSo().getFiStatus());
		} else {
			UserCustom userCustom = SecurityUtil.getLoginUser();
			if (!ObjectUtils.isEmpty(userCustom)) {
				hoSo20DTO.setFiNameOfRegistration(userCustom.getCompanyName());
				hoSo20DTO.setFiAddressOfRegistration(userCustom.getCompanyAddress());
				hoSo20DTO.setFiFax(userCustom.getCompanyFax());
				hoSo20DTO.setFiEmail(userCustom.getCompanyEmail());
				hoSo20DTO.setFiPhone(userCustom.getCompanyPhoneNumber());
				hoSo20DTO.setFiTaxCode(userCustom.getUsername());
				hoSo20DTO.setFiCreateDate(new Date());
				hoSo20DTO.setFiActive(1);
				hoSo20DTO.setFiIdHoSo(0L);
				hoSo20DTO.setFiStatus(0);
				hoSo20DTO.setFiDocumentType(DOCUMENT_TYPE);
				hoSo20DTO.setFiDocumentName(DOCUMENT_TYPE);
			}
		}
		final String fiCode = code;
		List<TbsTrangThai20> tbsTrangThai20s = fldMard20TbsTrangThai20Resource.findAllTbsTrangThai20(new PageableDTO(100, 0)).getBody();
		if (!ObjectUtils.isEmpty(tbsTrangThai20s)) {
			Optional<TbsTrangThai20> find = tbsTrangThai20s.stream().filter(p-> fiCode.equals(p.getFiCode())).findFirst();
			if (find.isPresent()) form.getHoSo().setFiStatusName(find.get().getFiStatusName());
		}
		return ResponseEntity.ok().body(form);
	}
	
	@RequestMapping(value = "/send", method = RequestMethod.POST)
	public ResponseEntity<ResponseJson20> send(@RequestBody @Valid SendMessage20 sendMessage20) {
		
		LOGGER.info("send: {}", sendMessage20);
		ResponseJson20 responseJson20 = new ResponseJson20();
		sendMessage20.setFiTaxCode(SecurityUtil.getTaxCode());
		sendMessage20.setFiUserName(SecurityUtil.getTaxName());
		try {
			responseJson20 = createRestTemplate(getURL("/mard/18/sendAll/"), sendMessage20, HttpMethod.POST, null, ResponseJson20.class);
			if (responseJson20.isSuccess()) {

				////them cau hinh ky so...............
				/*SignData signData = new SignData();
				//signData.setFiDocumentCode(((LinkedHashMap) json.getData()).get("fiMaHoso").toString());//mahoso
				//signData.setFiDocType(((LinkedHashMap) json.getData()).get("fiMaThutuc").toString());//mathutuc
				//signData.setFiFunc(message.getFunction());//function
				//signData.setFiMsgType(message.getType());//type
				String xml = responseJson20.getData().toString();
				//String body = getMessageBody(xml);
				String hashVal = Utility.GetHashData(xml);
				signData.setFiXml(xml);
				signData.setFiXmlEncode(encodeXmlMessage(xml));
				signData.setFiHash(hashVal);
				signData.setFiHashEncode(encodeXmlMessage("<DS>" + hashVal + "</DS>"));
				json.setSign(signData);*/
				responseJson20.setMessage(fldMessageSource.getMessage("mard.20.send.ok", null, LocaleContextHolder.getLocale()));
			} else {
				if (responseJson20.getStatus() == HttpStatus.GATEWAY_TIMEOUT.value()) {
					responseJson20.setMessage(fldMessageSource.getMessage("mard.20.send.timeout", null, LocaleContextHolder.getLocale()));
				} else if (responseJson20.getStatus() == HttpStatus.BAD_GATEWAY.value()) {
					responseJson20.setMessage(fldMessageSource.getMessage("mard.20.send.notOk", null, LocaleContextHolder.getLocale()));
				} else  {
					responseJson20.setMessage(fldMessageSource.getMessage("mard.20.send.exception", null, LocaleContextHolder.getLocale()));
				}
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			responseJson20.setException(fldMessageSource.getMessage("mard.20.send.exception", null, LocaleContextHolder.getLocale()));
		}
		
		return ResponseEntity.ok().body(responseJson20);
	}

	@RequestMapping(value = "/save/{idHoSo}", method = RequestMethod.POST)
	public ResponseEntity<Form20DTO> save(@PathVariable("idHoSo") Long idHoSo, @RequestBody @Valid Form20DTO form20DTO) {

		if (!isValid(form20DTO.getHoSo())) {
			return ResponseEntity.badRequest().body(form20DTO);
		}
		if (!ObjectUtils.isEmpty(form20DTO.getThuocs())) {
			for (TbdThuoc20 item : form20DTO.getThuocs()) {
				if (!isValid(item)) {
					return ResponseEntity.badRequest().body(form20DTO);
				}
			}
		}
		if (!ObjectUtils.isEmpty(form20DTO.getTepDinhKems())) {
			for (TbdDinhKem20 item : form20DTO.getTepDinhKems()) {
				if (!isValid(item)) {
					return ResponseEntity.badRequest().body(form20DTO);
				}
			}
		}

		TbdHoSo20 tbdHoSo20 = new TbdHoSo20();
		BeanUtils.copyProperties(form20DTO.getHoSo(), tbdHoSo20);
		showLog(form20DTO);
		if (idHoSo > 0) {
			fldMard20TbdHoSo20Resource.updateTbdHoSo20(idHoSo, tbdHoSo20);
			TbdHoSo20 finalTbdHoSo1 = tbdHoSo20;
			form20DTO.getTepDinhKems().stream().forEach(p-> {
				p.setFiIdHoSo(finalTbdHoSo1.getFiIdHoSo());
				if(p.getFiId() == null){
					createRestTemplate(getURL("/mard/18/tbdDinhKem18/create"), p, HttpMethod.POST, null, TbdDinhKem20.class);
				}
			});
			createHistory( fldMard20TbdKetQuaXuLy20Resource, fldMard20TbdHoSo20Resource, "Cập nhật hồ sơ", tbdHoSo20.getFiIdHoSo());
		} else {
			tbdHoSo20.setFiDocumentName("-1");
			tbdHoSo20 = fldMard20TbdHoSo20Resource.createTbdHoSo20(tbdHoSo20).getBody();
            final TbdHoSo20 tbdHoSo201Final = tbdHoSo20;
            if (!ObjectUtils.isEmpty(tbdHoSo20)) {
                form20DTO.getTepDinhKems().stream().forEach(p->{
                    p.setFiIdHoSo(tbdHoSo201Final.getFiIdHoSo());
					p = createRestTemplate(getURL("/mard/18/tbdDinhKem18/create"), p, HttpMethod.POST, null, TbdDinhKem20.class);
                    showLog(p);
                });
            }
			createHistory(fldMard20TbdKetQuaXuLy20Resource, fldMard20TbdHoSo20Resource, "Tạo mới hồ sơ", tbdHoSo20.getFiIdHoSo());
		}
        final TbdHoSo20 tbdHoSo201Final = tbdHoSo20;
        if (!ObjectUtils.isEmpty(tbdHoSo20)) {
            form20DTO.getThuocs().stream().forEach(p->{
            	TbdThuoc20 p2 = null;
                p.setFiIdHoSo(tbdHoSo201Final.getFiIdHoSo());
                if (Objects.equals(p.getFiId(), 0L)) {
                    p2 = createRestTemplate(getURL("/mard/18/tbdThuoc18/create"), p, HttpMethod.POST, null, TbdThuoc20.class);
                } else {
                	p2 = createRestTemplate(getURL("/mard/18/tbdThuoc18/update/") + p.getFiId(), p, HttpMethod.POST, null, TbdThuoc20.class);
                }
				if (!ObjectUtils.isEmpty(p.getFiTepDinhKemThuocs())) {
					TbdThuoc20 finalP = p2;
					p.getFiTepDinhKemThuocs().stream().forEach(pDinhKem -> {
						LOGGER.info("p(Thuoc): {}", finalP.toString());
						pDinhKem.setFiIdHoSo(tbdHoSo201Final.getFiIdHoSo());
						pDinhKem.setFiProductId(finalP.getFiId());
						pDinhKem = createRestTemplate(getURL("/mard/18/tbdDinhKem18/create"), pDinhKem, HttpMethod.POST, null, TbdDinhKem20.class);
						showLog(pDinhKem);
						LOGGER.info("dinhkemThuoc: {}", pDinhKem.toString());
					});
				}
                showLog(p);
            });

        }
        form20DTO.getHoSo().setFiDocumentName(tbdHoSo20.getFiDocumentName());
		form20DTO.getHoSo().setFiIdHoSo(tbdHoSo20.getFiIdHoSo());


		return ResponseEntity.ok().body(form20DTO);
	}
	

	@RequestMapping(value = "/findGP/{idHoSo}", method = RequestMethod.POST)
	public ResponseEntity<FormGPDTO> findGP(@PathVariable("idHoSo") Long idHoSo) {
		FormGPDTO form = new FormGPDTO();
		TbdThongBaoKetQua20DTO hoSo20DTO = new TbdThongBaoKetQua20DTO();
		form.setHoSo(hoSo20DTO);
		if (idHoSo > 0) {
			BeanUtils.copyProperties(fldMard20TbdThongBaoKetQua20Resource.findByFiIdHoSo(idHoSo).getBody().get(0), hoSo20DTO);
			form.setHoSo(hoSo20DTO);
			form.setThuocs(fldMard20TbdTBKetQuaThuoc20Resource.findByFiIdHoSo(idHoSo).getBody());
			form.setDmLoaiThuoc(mard20TbsLoaiThuoc20Resource.findAllTbsLoaiThuoc20(new PageableDTO(100, 0)).getBody());
			//form.setDanhMucMucDichs(fldMard20TbsMucDich20Resource.findByFiDocumentType(DOCUMENT_TYPE).getBody());
		}
		
		return ResponseEntity.ok().body(form);
	}
	@RequestMapping(value = {"/verify"}, method = RequestMethod.POST)
	public @ResponseBody
	ResponseJson verify(@RequestBody TokenInfo token) {
		token.setUser(this.getUsername());
		token.setMinistryCode("MARD");
		return this.verifySignature(token);
	}
	//xuat gp
	@RequestMapping(value = "/xuatGiayPhep/{idHoSo}", method = RequestMethod.GET)
	public void downloadTemplate(HttpServletRequest request, HttpServletResponse response, @PathVariable("idHoSo")Long idHoSo) throws IOException {

		String fileName = "thong-bao-mien-kiem.docx";
		//FileInputStream fileInputStream = null;
		//OutputStream responseOutputStream = null;
		try
		{
			TbdThongBaoKetQua20DTO tbdThongBaoKetQua20DTO = new TbdThongBaoKetQua20DTO();
			//List<TbdTBKetQuaThuoc19> tbdGPThuoc19s = null;
			List<TbdTBKetQuaThuoc20> tbdTBKetQuaThuoc20s = null;
			tbdTBKetQuaThuoc20s = fldMard20TbdTBKetQuaThuoc20Resource.findByFiIdHoSo(idHoSo).getBody();
			BeanUtils.copyProperties(fldMard20TbdThongBaoKetQua20Resource.findByFiIdHoSo(idHoSo).getBody().get(0), tbdThongBaoKetQua20DTO);
			//SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
			//String fiSendDate = com.nsw.mard.p19.rest.WordUtil.formatDate(tbdThongBaoKetQua20DTO.getFiSignDate());
			//String ngayGuiKemHS = " ngày " + fiSendDate.split("/")[0] + " tháng " + fiSendDate.split("/")[1] + " năm " + fiSendDate.split("/")[2];
			//String ngayGui = WordUtil.formatDate(tbdThongBaoKetQua20DTO.getFiSignConfirmDate());
			String hieuLuc = WordUtil.formatDate(tbdThongBaoKetQua20DTO.getFiSignConfirmDate());
			String fiSignConfirmFrom = "từ ngày " + hieuLuc.split("/")[0] + " tháng " + hieuLuc.split("/")[1] + " năm " + hieuLuc.split("/")[2];
			String fiSignConfirmTo = "đến ngày " + hieuLuc.split("/")[0] + " tháng " + hieuLuc.split("/")[1] + " năm " + (Integer.parseInt(hieuLuc.split("/")[2]) + 2);
			//String fiCQDate = com.nsw.mard.p19.rest.WordUtil.formatDate(tbdHoSo19.getFiCQDate());
			//String fiCMSDate = com.nsw.mard.p19.rest.WordUtil.formatDate(tbdHoSo19.getFiCMSDate());
			String fiSignConfirmDate = "Hà Nội, ngày " + hieuLuc.split("/")[0] + " tháng " + hieuLuc.split("/")[1] + " năm " + hieuLuc.split("/")[2];
			//String ngayNop = com.nsw.mard.p19.rest.WordUtil.formatDate(tbdThongBaoKetQua19.getFiSignDate());
			//String fiCQDate =  WordUtil.formatDate(tbdThongBaoKetQua19.getFiCQDate());
			//BeanUtils.copyProperties(fldMard17TbdGiayPhep17Resource.findByFiIdHoSo(idHoSo).getBody().get(0), tbdGiayPhep17);
			String filePath = request.getServletContext().getRealPath("/WEB-INF/downloads/mard/20/")+ fileName;
			File file = new File(filePath);
			XWPFDocument document = new XWPFDocument(OPCPackage.open(file));
			WordUtil.createRow(document, tbdTBKetQuaThuoc20s.size(), tbdTBKetQuaThuoc20s);
			WordUtil.replace(document, "fiDispatchNo", tbdThongBaoKetQua20DTO.getFiDispatchNo());
			WordUtil.replace(document, "fiSignConfirmDate", fiSignConfirmDate);
			WordUtil.replace(document, "fiSignConfirmFrom", fiSignConfirmFrom);
			WordUtil.replace(document, "fiSignConfirmTo", fiSignConfirmTo);
			WordUtil.replace(document, "fiSignConfirmName", tbdThongBaoKetQua20DTO.getFiSignConfirmName());
			WordUtil.replace(document, "fiOrganizationUppercase", tbdThongBaoKetQua20DTO.getFiOrganization().toUpperCase());
			WordUtil.replace(document, "fiOrganizationLowercase", tbdThongBaoKetQua20DTO.getFiOrganization());



			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			document.write(byteArrayOutputStream);

			String mimeType = request.getServletContext().getMimeType(filePath);
			if (mimeType == null) {
				mimeType = "application/octet-stream";
			}
			response.setContentType(mimeType);
			response.addHeader("Content-Disposition", "attachment; filename=" + fileName);
			//response.setContentLength((int) document());

			//fileInputStream = new FileInputStream(file);
			FileCopyUtils.copy(byteArrayOutputStream.toByteArray(), response.getOutputStream());
			//responseOutputStream = response.getOutputStream();
			/*int bytes;
			while ((bytes = fileInputStream.read()) != -1) {
				responseOutputStream.write(bytes);
			}*/
			byteArrayOutputStream.close();

		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			LOGGER.error("ERROR WITH WORD EXPORT: {}", ex.getMessage());
			LOGGER.error(ex.getMessage(), ex);
		}
		finally {

			response.getOutputStream().close();
		}
	}
}