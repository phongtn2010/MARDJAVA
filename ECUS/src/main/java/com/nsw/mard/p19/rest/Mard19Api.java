package com.nsw.mard.p19.rest;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.*;

import com.nsw.mard.p14.rest.SecurityUtil;
import com.nsw.mard.p19.rest.WordUtil;
import com.nsw.mard.p18.model.*;
import com.nsw.mard.p19.model.FormGPDTO;
import com.nsw.mard.p19.model.PageableDTO;
import com.nsw.mard.p19.model.TbdDinhKem19;
import com.nsw.mard.p19.model.TbdThuoc19;
import com.nsw.mard.p18.rest.Mard18Api;
import com.nsw.mard.p18.rest.Mard18TbsTepDinhKem18Resource;
import com.nsw.mard.p19.model.*;
import com.nsw.security.UserCustom;

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
import org.springframework.util.FileCopyUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/mard/api/19")
public class Mard19Api extends Mard19CallBack  {

	public static final String DOCUMENT_TYPE = "BNNPTNT06000073";
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Mard19Api.class);
	
	@Autowired
	private Mard19TbdHoSo19Resource fldMard19TbdHoSo19Resource;

	@Autowired
	private Mard19TbsTepDinhKem19Resource fldMard19TbsTepDinhKem19Resource;

	@Autowired
	private Mard19TbdDinhKem19Resource fldMard19TbdDinhKem19Resource;

	@Autowired
	private Mard19TbsTrangThai19Resource fldMard19TbsTrangThai19Resource;

	@Autowired
	private Mard19TbdThuoc19Resource fldMard19TbdThuoc19Resource;

	@Autowired
	private Mard19TbsLoaiThuoc19Resource fldMard19TbsLoaiThuoc19Resource;

	//@Autowired
	//private Mard19TbsMucDich19Resource fldMard19TbsMucDich19Resource;

	@Autowired
	private Mard18TbsTepDinhKem18Resource fldMard18TbsTepDinhKem18Resource;

	@Autowired
	private Mard19TbsLoaiCN19Resource fldMard19TbsLoaiCN19Resoure;

	@Autowired
	private Mard19TbdThongBaoKetQua19Resource fldMard19TbdThongBaoKetQua19Resource;

	@Autowired
	private Mard19TbdTBKetQuaThuoc19Resource fldMard19TbdTBKetQuaThuoc19Resource;

	@Autowired
	private Mard19TbdKetQuaXuLy19Resource fldMard19TbdKetQuaXuLy19Resource;

	@Autowired
	private  Mard19TbsLoaiThuoc19Resource mard19TbsLoaiThuoc19Resource;

	private MessageSource fldMessageSource;

	@Autowired
	public Mard19Api(MessageSource messageSource) {
		this.fldMessageSource = messageSource;
	}

	@RequestMapping(value = "/edit/{idHoSo}", method = RequestMethod.POST)
	public ResponseEntity<Form19DTO> edit(@PathVariable("idHoSo") Long idHoSo) {

		Form19DTO form = new Form19DTO();
		//can sua
		form.setDanhMucTepDinhKems(fldMard19TbsTepDinhKem19Resource.findByLoaiThuTucOrderByFiSortAsc(Mard18Api.DOCUMENT_TYPE).getBody());
		form.setDanhMucThuocs(fldMard19TbsLoaiThuoc19Resource.findAllTbsLoaiThuoc19(new PageableDTO(100, 0)).getBody());
		//form.setDanhMucMucDichs(fldMard19TbsMucDich19Resource.findByFiDocumentType(DOCUMENT_TYPE).getBody());
		//form.setDanhMucLoaiCN(fldMard19TbsLoaiCN19Resoure.findByFiDocumentType(DOCUMENT_TYPE).getBody());
		//Dung chung bang tbs loai cn 18

		form.setDanhMucLoaiCN(fldMard19TbsLoaiCN19Resoure.findByFiDocumentType("BNNPTNT06000071").getBody());
		String code = "0";
		TbdHoSo19DTO hoSo19DTO = new TbdHoSo19DTO();
		hoSo19DTO.setFiModifiedDate(new Date());
		form.setHoSo(hoSo19DTO);
		if (idHoSo > 0) {
			BeanUtils.copyProperties(fldMard19TbdHoSo19Resource.getTbdHoSo19(idHoSo).getBody(), hoSo19DTO);
			form.setHoSo(hoSo19DTO);
			form.setTepDinhKems(fldMard19TbdDinhKem19Resource.findByFiIdHoSo(idHoSo).getBody());
			form.setThuocs(fldMard19TbdThuoc19Resource.findByFiIdHoSo(idHoSo).getBody());

			code = String.valueOf(form.getHoSo().getFiStatus());
		} else {
			UserCustom userCustom = SecurityUtil.getLoginUser();
			if (!ObjectUtils.isEmpty(userCustom)) {
				hoSo19DTO.setFiNameOfRegistration(userCustom.getCompanyName());
				hoSo19DTO.setFiAddressOfRegistration(userCustom.getCompanyAddress());
				hoSo19DTO.setFiFax(userCustom.getCompanyFax());
				hoSo19DTO.setFiEmail(userCustom.getCompanyEmail());
				hoSo19DTO.setFiPhone(userCustom.getCompanyPhoneNumber());
				hoSo19DTO.setFiTaxCode(userCustom.getUsername());
				hoSo19DTO.setFiCreateDate(new Date());
				hoSo19DTO.setFiActive(1);
				hoSo19DTO.setFiIdHoSo(0L);
				hoSo19DTO.setFiStatus(0);
				hoSo19DTO.setFiDocumentType(DOCUMENT_TYPE);
				hoSo19DTO.setFiDocumentName(DOCUMENT_TYPE);
			}
		}
		final String fiCode = code;
		List<TbsTrangThai19> tbsTrangThai19s = fldMard19TbsTrangThai19Resource.findAllTbsTrangThai19(new PageableDTO(100, 0)).getBody();
		if (!ObjectUtils.isEmpty(tbsTrangThai19s)) {
			Optional<TbsTrangThai19> find = tbsTrangThai19s.stream().filter(p-> fiCode.equals(p.getFiCode())).findFirst();
			if (find.isPresent()) form.getHoSo().setFiStatusName(find.get().getFiStatusName());
		}
		return ResponseEntity.ok().body(form);
	}
	
	@RequestMapping(value = "/send", method = RequestMethod.POST)
	public ResponseEntity<ResponseJson19> send(@RequestBody @Valid SendMessage19 sendMessage19) {
		
		LOGGER.info("send: {}", sendMessage19);
		ResponseJson19 responseJson19 = new ResponseJson19();
		sendMessage19.setFiTaxCode(SecurityUtil.getTaxCode());
		sendMessage19.setFiUserName(SecurityUtil.getTaxName());
		try {
			responseJson19 = createRestTemplate(getURL("/mard/18/sendAll/"), sendMessage19, HttpMethod.POST, null, ResponseJson19.class);
			if (responseJson19.isSuccess()) {
				responseJson19.setMessage(fldMessageSource.getMessage("mard.19.send.ok", null, LocaleContextHolder.getLocale()));
			} else {
				if (responseJson19.getStatus() == HttpStatus.GATEWAY_TIMEOUT.value()) {
					responseJson19.setMessage(fldMessageSource.getMessage("mard.19.send.timeout", null, LocaleContextHolder.getLocale()));
				} else if (responseJson19.getStatus() == HttpStatus.BAD_GATEWAY.value()) {
					responseJson19.setMessage(fldMessageSource.getMessage("mard.19.send.notOk", null, LocaleContextHolder.getLocale()));
				} else  {
					responseJson19.setMessage(fldMessageSource.getMessage("mard.19.send.exception", null, LocaleContextHolder.getLocale()));
				}
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			responseJson19.setException(fldMessageSource.getMessage("mard.19.send.exception", null, LocaleContextHolder.getLocale()));
		}
		
		return ResponseEntity.ok().body(responseJson19);
	}

	@RequestMapping(value = "/save/{idHoSo}", method = RequestMethod.POST)
	public ResponseEntity<Form19DTO> save(@PathVariable("idHoSo") Long idHoSo, @RequestBody @Valid Form19DTO form19DTO) {

		if (!isValid(form19DTO.getHoSo())) {
			return ResponseEntity.badRequest().body(form19DTO);
		}
		if (!ObjectUtils.isEmpty(form19DTO.getThuocs())) {
			for (TbdThuoc19 item : form19DTO.getThuocs()) {
				if (!isValid(item)) {
					return ResponseEntity.badRequest().body(form19DTO);
				}
			}
		}
		if (!ObjectUtils.isEmpty(form19DTO.getTepDinhKems())) {
			for (TbdDinhKem19 item : form19DTO.getTepDinhKems()) {
				if (!isValid(item)) {
					return ResponseEntity.badRequest().body(form19DTO);
				}
			}
		}

		TbdHoSo19 tbdHoSo19 = new TbdHoSo19();
		BeanUtils.copyProperties(form19DTO.getHoSo(), tbdHoSo19);
		showLog(form19DTO);
		if (idHoSo > 0) {
			fldMard19TbdHoSo19Resource.updateTbdHoSo19(idHoSo, tbdHoSo19);
			TbdHoSo19 finalTbdHoSo1 = tbdHoSo19;
			form19DTO.getTepDinhKems().stream().forEach(p-> {
				p.setFiIdHoSo(finalTbdHoSo1.getFiIdHoSo());
				if(p.getFiId() == null){
					createRestTemplate(getURL("/mard/18/tbdDinhKem18/create"), p, HttpMethod.POST, null, TbdDinhKem19.class);
				}
			});
			createHistory( fldMard19TbdKetQuaXuLy19Resource, fldMard19TbdHoSo19Resource, "Cập nhật hồ sơ", tbdHoSo19.getFiIdHoSo());
		} else {
			tbdHoSo19.setFiDocumentName("-1");
			tbdHoSo19 = fldMard19TbdHoSo19Resource.createTbdHoSo19(tbdHoSo19).getBody();
            final TbdHoSo19 tbdHoSo191Final = tbdHoSo19;
            if (!ObjectUtils.isEmpty(tbdHoSo19)) {
                form19DTO.getTepDinhKems().stream().forEach(p->{
                    p.setFiIdHoSo(tbdHoSo191Final.getFiIdHoSo());
					p = createRestTemplate(getURL("/mard/18/tbdDinhKem18/create"), p, HttpMethod.POST, null, TbdDinhKem19.class);
                    showLog(p);
                });
            }
			createHistory(fldMard19TbdKetQuaXuLy19Resource, fldMard19TbdHoSo19Resource, "Tạo mới hồ sơ", tbdHoSo19.getFiIdHoSo());
		}
        final TbdHoSo19 tbdHoSo191Final = tbdHoSo19;
        if (!ObjectUtils.isEmpty(tbdHoSo19)) {
            form19DTO.getThuocs().stream().forEach(p->{
				TbdThuoc19 p2 = null;
                p.setFiIdHoSo(tbdHoSo191Final.getFiIdHoSo());
                if (Objects.equals(p.getFiId(), 0L)) {
					p2 = createRestTemplate(getURL("/mard/18/tbdThuoc18/create"), p, HttpMethod.POST, null, TbdThuoc19.class);
                } else {
					p2 = createRestTemplate(getURL("/mard/18/tbdThuoc18/update/") + p.getFiId(), p, HttpMethod.POST, null, TbdThuoc19.class);
                }
				if (!ObjectUtils.isEmpty(p.getFiTepDinhKemThuocs())) {
					TbdThuoc19 finalP = p2;
					p.getFiTepDinhKemThuocs().stream().forEach(pDinhKem -> {
						LOGGER.info("p(Thuoc): {}", finalP.toString());
						pDinhKem.setFiIdHoSo(tbdHoSo191Final.getFiIdHoSo());
						pDinhKem.setFiProductId(finalP.getFiId());
						pDinhKem = createRestTemplate(getURL("/mard/18/tbdDinhKem18/create"), pDinhKem, HttpMethod.POST, null, TbdDinhKem19.class);
						showLog(pDinhKem);
						LOGGER.info("dinhkemThuoc: {}", pDinhKem.toString());
					});
				}
                showLog(p);
            });

        }
        form19DTO.getHoSo().setFiDocumentName(tbdHoSo19.getFiDocumentName());
		form19DTO.getHoSo().setFiIdHoSo(tbdHoSo19.getFiIdHoSo());


		return ResponseEntity.ok().body(form19DTO);
	}
	

	@RequestMapping(value = "/findGP/{idHoSo}", method = RequestMethod.POST)
	public ResponseEntity<FormGPDTO> findGP(@PathVariable("idHoSo") Long idHoSo) {
		FormGPDTO form = new FormGPDTO();
		TbdThongBaoKetQua19DTO hoSo19DTO = new TbdThongBaoKetQua19DTO();
		form.setHoSo(hoSo19DTO);
		if (idHoSo > 0) {
			BeanUtils.copyProperties(fldMard19TbdThongBaoKetQua19Resource.findByFiIdHoSo(idHoSo).getBody().get(0), hoSo19DTO);
			form.setHoSo(hoSo19DTO);
			form.setThuocs(fldMard19TbdTBKetQuaThuoc19Resource.findByFiIdHoSo(idHoSo).getBody());
			form.setDmLoaiThuoc(mard19TbsLoaiThuoc19Resource.findAllTbsLoaiThuoc19(new PageableDTO(100, 0)).getBody());

		}
		
		return ResponseEntity.ok().body(form);
	}

	//xuat gp
	@RequestMapping(value = "/xuatGiayPhep/{idHoSo}", method = RequestMethod.GET)
	public void downloadTemplate(HttpServletRequest request, HttpServletResponse response, @PathVariable("idHoSo")Long idHoSo) throws IOException {

		String fileName = "hoso-tt4-19.docx";
		//FileInputStream fileInputStream = null;
		//OutputStream responseOutputStream = null;
		try
		{
			TbdHoSo19 tbdHoSo19 = new TbdHoSo19();
			BeanUtils.copyProperties(fldMard19TbdHoSo19Resource.getTbdHoSo19(idHoSo).getBody(), tbdHoSo19);
			TbdThongBaoKetQua19DTO tbdThongBaoKetQua19 = new TbdThongBaoKetQua19DTO();
			//List<TbdTBKetQuaThuoc19> tbdGPThuoc19s = null;
			List<TbdThuoc19> tbdThuoc19s = null;
			tbdThuoc19s = fldMard19TbdThuoc19Resource.findByFiIdHoSo(idHoSo).getBody();
			BeanUtils.copyProperties(fldMard19TbdThongBaoKetQua19Resource.findByFiIdHoSo(idHoSo).getBody().get(0), tbdThongBaoKetQua19);
			//SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
			String fiSendDate = WordUtil.formatDate(tbdHoSo19.getFiSendDate());
			String ngayGuiKemHS = " ngày " + fiSendDate.split("/")[0] + " tháng " + fiSendDate.split("/")[1] + " năm " + fiSendDate.split("/")[2];
			String ngayGui = "Hà Nội," + ngayGuiKemHS;
			String ngayKy = WordUtil.formatDate(tbdThongBaoKetQua19.getFiSignConfirmDate());
			String fiCQDate = WordUtil.formatDate(tbdHoSo19.getFiCQDate());
			String fiCMSDate = WordUtil.formatDate(tbdHoSo19.getFiCMSDate());
			String fiSignConfirmDate = "Hà Nội, ngày " + ngayKy.split("/")[0] + " tháng " + ngayKy.split("/")[1] + " năm " + ngayKy.split("/")[2];
			String ngayNop = WordUtil.formatDate(tbdThongBaoKetQua19.getFiSignDate());
			//String fiCQDate =  WordUtil.formatDate(tbdThongBaoKetQua19.getFiCQDate());
			//BeanUtils.copyProperties(fldMard17TbdGiayPhep17Resource.findByFiIdHoSo(idHoSo).getBody().get(0), tbdGiayPhep17);
			String filePath = request.getServletContext().getRealPath("/WEB-INF/downloads/mard/19/")+ fileName;
			File file = new File(filePath);
			XWPFDocument document = new XWPFDocument(OPCPackage.open(file));
			WordUtil.createRowHoSo(document, tbdThuoc19s.size(), tbdThuoc19s);
			WordUtil.replace(document,"fiNameOfRegistration", tbdHoSo19.getFiNameOfRegistration());
			WordUtil.replace(document,"fiAddressOfRegistration", tbdHoSo19.getFiAddressOfRegistration());
			WordUtil.replace(document,"fiPhoneNumber", tbdHoSo19.getFiPhone());
			WordUtil.replace(document,"fiFax", tbdHoSo19.getFiFax());
			WordUtil.replace(document,"fiEmail", tbdHoSo19.getFiEmail());
			WordUtil.replace(document,"fiGates", tbdThongBaoKetQua19.getFiGates());
			WordUtil.replace(document,"fiContractNo", tbdThongBaoKetQua19.getFiContractNo());
			WordUtil.replace(document,"fiGoodListNo", tbdThongBaoKetQua19.getFiGoodListNo());
			WordUtil.replace(document, "fiCQNo", tbdThongBaoKetQua19.getFiCQNo());
			WordUtil.replace(document, "fiCQOrganization", tbdThongBaoKetQua19.getFiCQOrganization());
			WordUtil.replace(document, "fiCQDate", fiCQDate);
			WordUtil.replace(document, "fiCQIssueBy", tbdThongBaoKetQua19.getFiCQIssueBy());
			WordUtil.replace(document, "fiCMSNo", tbdThongBaoKetQua19.getFiCMSNo());
			WordUtil.replace(document, "fiCMSOrganization", tbdThongBaoKetQua19.getFiCMSOrganization());
			WordUtil.replace(document, "fiCMSDate", fiCMSDate);
			WordUtil.replace(document, "fiCMSIssueBy", tbdThongBaoKetQua19.getFiCMSIssueBy());
			WordUtil.replace(document, "fiInvoiceNo", tbdThongBaoKetQua19.getFiInvoiceNo());
			WordUtil.replace(document, "fiBillNo", tbdThongBaoKetQua19.getFiBillNo());
			WordUtil.replace(document, "fiDeclarationNo", tbdThongBaoKetQua19.getFiDeclarationNo());
			WordUtil.replace(document, "fiCONo", tbdThongBaoKetQua19.getFiCONo());
			WordUtil.replace(document, "fiCFSNo", tbdThongBaoKetQua19.getFiCFSNo());
			WordUtil.replace(document, "fiTechRegul", tbdThongBaoKetQua19.getFiTechRegul());
			WordUtil.replace(document, "fiApplyRegul", tbdThongBaoKetQua19.getFiApplyRegul());
			WordUtil.replace(document, "fiRegistrationNumber", tbdThongBaoKetQua19.getFiDispatchNo());
			WordUtil.replace(document, "fiRegistrationDate", fiSignConfirmDate);
			WordUtil.replace(document, "fiSendDate", ngayGui);
			WordUtil.replace(document, "fiNgayGuiKem", ngayGuiKemHS);
			WordUtil.replace(document, "fiSoDonDangKy", tbdHoSo19.getFiApplicationNo());


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
	//xuat ho so
	@RequestMapping(value = "/xuatFileHoSo/{idHoSo}", method = RequestMethod.GET)
	public void downloadTemplateHoSo(HttpServletRequest request, HttpServletResponse response, @PathVariable("idHoSo")Long fiIdHoSo) {
		String fileName = "hoso-tt4-19.docx";
		try
		{
			String filePath = request.getServletContext().getRealPath("/WEB-INF/downloads/mard/19/")+ fileName;
			File file = new File(filePath);
			XWPFDocument document = new XWPFDocument(OPCPackage.open(file));
			/*List<TbdHoSo18> tbdHoSo18List = fldMard18TbdHoSo18Resource.findByFiDocumentName(fiDocumentName).getBody();
			TbdHoSo18 tbdHoSo18 = tbdHoSo18List.stream()
					.filter(p ->
							1 == p.getFiActive())
					.findAny()
					.orElse(tbdHoSo18List.get(0));*/
			TbdHoSo19 tbdHoSo19 = new TbdHoSo19();
			BeanUtils.copyProperties(fldMard19TbdHoSo19Resource.getTbdHoSo19(fiIdHoSo).getBody(), tbdHoSo19);
			List<TbdThuoc19> tbdThuoc19s = fldMard19TbdThuoc19Resource.findByFiIdHoSo(tbdHoSo19.getFiIdHoSo()).getBody();
			String fiCQDate = WordUtil.formatDate(tbdHoSo19.getFiCQDate());
			String fiCMSDate = WordUtil.formatDate(tbdHoSo19.getFiCMSDate());
			String fiRegistrationDate = WordUtil.formatDate(tbdHoSo19.getFiRegistrationDate());
			String fiSendDate = WordUtil.formatDate(tbdHoSo19.getFiSendDate());
			String ngayGui = "Hà Nội, ngày " + fiSendDate.split("/")[0] + " tháng " + fiSendDate.split("/")[1] + " năm " + fiSendDate.split("/")[2];
			String ngayGuiKemHS = " ngày " + fiSendDate.split("/")[0] + " tháng " + fiSendDate.split("/")[1] + " năm " + fiSendDate.split("/")[2];
			String ngayVaoSo = ".............";
			if(fiRegistrationDate.contains("/")) {
				ngayVaoSo = "Hà Nội, ngày " + fiRegistrationDate.split("/")[0] + " tháng " + fiRegistrationDate.split("/")[1] + " năm " + fiRegistrationDate.split("/")[2];
			}
			WordUtil.createRowHoSo(document, tbdThuoc19s.size(), tbdThuoc19s);
			WordUtil.replace(document,"fiNameOfRegistration", tbdHoSo19.getFiNameOfRegistration());
			WordUtil.replace(document,"fiAddressOfRegistration", tbdHoSo19.getFiAddressOfRegistration());
			WordUtil.replace(document,"fiPhoneNumber", tbdHoSo19.getFiPhone());
			WordUtil.replace(document,"fiFax", tbdHoSo19.getFiFax());
			WordUtil.replace(document,"fiEmail", tbdHoSo19.getFiEmail());
			WordUtil.replace(document,"fiGates", tbdHoSo19.getFiGates());
			WordUtil.replace(document,"fiContractNo", tbdHoSo19.getFiContractNo());
			WordUtil.replace(document,"fiGoodListNo", tbdHoSo19.getFiGoodListNo());
			WordUtil.replace(document, "fiCQNo", tbdHoSo19.getFiCQNo());
			WordUtil.replace(document, "fiCQOrganization", tbdHoSo19.getFiCQOrganization());
			WordUtil.replace(document, "fiCQDate", fiCQDate);
			WordUtil.replace(document, "fiCQIssueBy", tbdHoSo19.getFiCQIssueBy());
			WordUtil.replace(document, "fiCMSNo", tbdHoSo19.getFiCMSNo());
			WordUtil.replace(document, "fiCMSOrganization", tbdHoSo19.getFiCMSOrganization());
			WordUtil.replace(document, "fiCMSDate", fiCMSDate);
			WordUtil.replace(document, "fiCMSIssueBy", tbdHoSo19.getFiCMSIssueBy());
			WordUtil.replace(document, "fiInvoiceNo", tbdHoSo19.getFiInvoiceNo());
			WordUtil.replace(document, "fiBillNo", tbdHoSo19.getFiBillNo());
			WordUtil.replace(document, "fiDeclarationNo", tbdHoSo19.getFiDeclarationNo());
			WordUtil.replace(document, "fiCONo", tbdHoSo19.getFiCONo());
			WordUtil.replace(document, "fiCFSNo", tbdHoSo19.getFiCFSNo());
			WordUtil.replace(document, "fiTechRegul", tbdHoSo19.getFiTechRegul());
			WordUtil.replace(document, "fiApplyRegul", tbdHoSo19.getFiApplyRegul());
			WordUtil.replace(document, "fiRegistrationNumber", tbdHoSo19.getFiRegistrationNumber());
			WordUtil.replace(document, "fiRegistrationDate", ngayVaoSo);
			WordUtil.replace(document, "fiSendDate", ngayGui);
			WordUtil.replace(document, "fiNgayGuiKem", ngayGuiKemHS);
			WordUtil.replace(document, "fiSoDonDangKy", tbdHoSo19.getFiApplicationNo());
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
		catch (Exception ex)
		{
			ex.printStackTrace();
			LOGGER.error(ex.getMessage(), ex);
			LOGGER.error("ERROR WITH WORD EXPORT: {}", ex.getMessage());
		}


	}

}
