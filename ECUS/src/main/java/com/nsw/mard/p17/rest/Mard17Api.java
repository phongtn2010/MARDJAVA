package com.nsw.mard.p17.rest;


import com.nsw.mard.p14.rest.SecurityUtil;
import com.nsw.mard.p17.model.*;
import com.nsw.security.UserCustom;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
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
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/mard/api/17")
public class Mard17Api extends Mard17CallBack  {

	public static final String DOCUMENT_TYPE = "BNNPTNT0600008";
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Mard17Api.class);
	
	@Autowired
	private Mard17TbdHoSo17Resource fldMard17TbdHoSo17Resource;

	@Autowired
	private Mard17TbsTepDinhKem17Resource fldMard17TbsTepDinhKem17Resource;

	@Autowired
	private Mard17TbdDinhKem17Resource fldMard17TbdDinhKem17Resource;

	@Autowired
	private Mard17TbsTrangThai17Resource fldMard17TbsTrangThai17Resource;

	@Autowired
	private Mard17TbdThuoc17Resource fldMard17TbdThuoc17Resource;

	@Autowired
	private Mard17TbsLoaiThuoc17Resource fldMard17TbsLoaiThuoc17Resource;

	@Autowired
	private Mard17TbsMucDich17Resource fldMard17TbsMucDich17Resource;

	@Autowired
	private Mard17TbsLoaiCN17Resource fldMard17TbsLoaiCN17Resoure;

	@Autowired
	private Mard17TbdGiayPhep17Resource fldMard17TbdGiayPhep17Resource;

	@Autowired
	private Mard17TbdGPThuoc17Resource fldMard17TbdGPThuoc17Resource;

	@Autowired
	private Mard17TbdKetQuaXuLy17Resource fldMard17TbdKetQuaXuLy17Resource;

	@Autowired
	private  Mard17TbsLoaiThuoc17Resource mard17TbsLoaiThuoc17Resource;

	private MessageSource fldMessageSource;

	@Autowired
	public Mard17Api(MessageSource messageSource) {
		this.fldMessageSource = messageSource;
	}

	@RequestMapping(value = "/edit/{idHoSo}", method = RequestMethod.POST)
	public ResponseEntity<Form17DTO> edit(@PathVariable("idHoSo") Long idHoSo) {

		Form17DTO form = new Form17DTO();
		form.setDanhMucTepDinhKems(fldMard17TbsTepDinhKem17Resource.findByLoaiThuTucOrderByFiSortAsc(DOCUMENT_TYPE).getBody());
		form.setDanhMucThuocs(fldMard17TbsLoaiThuoc17Resource.findAllTbsLoaiThuoc17(new PageableDTO(100, 0)).getBody());
		form.setDanhMucMucDichs(fldMard17TbsMucDich17Resource.findByFiDocumentType(DOCUMENT_TYPE).getBody());
		form.setDanhMucLoaiCN(fldMard17TbsLoaiCN17Resoure.findByFiDocumentType(DOCUMENT_TYPE).getBody());
		String code = "0";
		TbdHoSo17DTO hoSo17DTO = new TbdHoSo17DTO();
		hoSo17DTO.setFiModifiedDate(new Date());
		form.setHoSo(hoSo17DTO);
		if (idHoSo > 0) {
			BeanUtils.copyProperties(fldMard17TbdHoSo17Resource.getTbdHoSo17(idHoSo).getBody(), hoSo17DTO);
			form.setHoSo(hoSo17DTO);
			form.setTepDinhKems(fldMard17TbdDinhKem17Resource.findByFiIdHoSo(idHoSo).getBody());
			LOGGER.info("TepDinhKems theo idHoSo: {}", fldMard17TbdDinhKem17Resource.findByFiIdHoSo(idHoSo).getBody().toString());
			form.setThuocs(fldMard17TbdThuoc17Resource.findByFiIdHoSo(idHoSo).getBody());
			code = String.valueOf(form.getHoSo().getFiStatus());
		} else {
			UserCustom userCustom = SecurityUtil.getLoginUser();
			if (!ObjectUtils.isEmpty(userCustom)) {
				hoSo17DTO.setFiNameOfRegistration(userCustom.getCompanyName());
				hoSo17DTO.setFiAddressOfRegistration(userCustom.getCompanyAddress());
				hoSo17DTO.setFiFax(userCustom.getCompanyFax());
				hoSo17DTO.setFiEmail(userCustom.getCompanyEmail());
				hoSo17DTO.setFiPhone(userCustom.getCompanyPhoneNumber());
				hoSo17DTO.setFiTaxCode(userCustom.getUsername());
				hoSo17DTO.setFiCreateDate(new Date());
				hoSo17DTO.setFiActive(1);
				hoSo17DTO.setFiIdHoSo(0L);
				hoSo17DTO.setFiStatus(0);
				hoSo17DTO.setFiDocumentType(DOCUMENT_TYPE);
				hoSo17DTO.setFiDocumentName(DOCUMENT_TYPE);
			}
		}
		final String fiCode = code;
		List<TbsTrangThai17> tbsTrangThai17s = fldMard17TbsTrangThai17Resource.findAllTbsTrangThai17(new PageableDTO(100, 0)).getBody();
		if (!ObjectUtils.isEmpty(tbsTrangThai17s)) {
			Optional<TbsTrangThai17> find = tbsTrangThai17s.stream().filter(p-> fiCode.equals(p.getFiCode())).findFirst();
			if (find.isPresent()) form.getHoSo().setFiStatusName(find.get().getFiStatusName());
		}
		return ResponseEntity.ok().body(form);
	}
	
	@RequestMapping(value = "/send", method = RequestMethod.POST)
	public ResponseEntity<ResponseJson17> send(@RequestBody @Valid SendMessage17 sendMessage17) {
		
		LOGGER.info("send: {}", sendMessage17);
		ResponseJson17 responseJson17 = new ResponseJson17();
		sendMessage17.setFiTaxCode(SecurityUtil.getTaxCode());
		sendMessage17.setFiUserName(SecurityUtil.getTaxName());
		try {
			responseJson17 = createRestTemplate(getURL("/mard/17/sendAll/"), sendMessage17, HttpMethod.POST, null, ResponseJson17.class);
			if (responseJson17.isSuccess()) {
				/*if(sendMessage17.getFiAction() == 5){
					TbdHoSo17 tbdHoSo17 = fldMard17TbdHoSo17Resource.getTbdHoSo17(sendMessage17.getFiIdHoSo()).getBody();
					//tbdHoSo17.setFiOldStatus(tbdHoSo17.getFiStatus());
					tbdHoSo17.setFiStatus(22);
					fldMard17TbdHoSo17Resource.updateTbdHoSo17(sendMessage17.getFiIdHoSo(), tbdHoSo17);
				}*/
				responseJson17.setMessage(fldMessageSource.getMessage("mard.17.send.ok", null, LocaleContextHolder.getLocale()));
			} else {
				if (responseJson17.getStatus() == HttpStatus.GATEWAY_TIMEOUT.value()) {
					responseJson17.setMessage(fldMessageSource.getMessage("mard.17.send.timeout", null, LocaleContextHolder.getLocale()));
				} else if (responseJson17.getStatus() == HttpStatus.BAD_GATEWAY.value()) {
					responseJson17.setMessage(fldMessageSource.getMessage("mard.17.send.notOk", null, LocaleContextHolder.getLocale()));
				} else  {
					responseJson17.setMessage(fldMessageSource.getMessage("mard.17.send.exception", null, LocaleContextHolder.getLocale()));
				}
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			responseJson17.setException(fldMessageSource.getMessage("mard.17.send.exception", null, LocaleContextHolder.getLocale()));
		}
		
		return ResponseEntity.ok().body(responseJson17);
	}
	@RequestMapping(value = "/save/{idHoSo}", method = RequestMethod.POST)
	public ResponseEntity<Form17DTO> save(@PathVariable("idHoSo") Long idHoSo, @RequestBody @Valid Form17DTO form17DTO) {

		if (!isValid(form17DTO.getHoSo())) {
			return ResponseEntity.badRequest().body(form17DTO);
		}
		if (!ObjectUtils.isEmpty(form17DTO.getThuocs())) {
			for (TbdThuoc17 item : form17DTO.getThuocs()) {
				if (!isValid(item)) {
					return ResponseEntity.badRequest().body(form17DTO);
				}
			}
		}
		if (!ObjectUtils.isEmpty(form17DTO.getTepDinhKems())) {
			for (TbdDinhKem17 item : form17DTO.getTepDinhKems()) {
				if (!isValid(item)) {
					return ResponseEntity.badRequest().body(form17DTO);
				}
			}
		}

		TbdHoSo17 tbdHoSo17 = new TbdHoSo17();

		BeanUtils.copyProperties(form17DTO.getHoSo(), tbdHoSo17);
		showLog(form17DTO);
		if (idHoSo > 0) {
			fldMard17TbdHoSo17Resource.updateTbdHoSo17(idHoSo, tbdHoSo17);
			LOGGER.info("fldMard17TbdHoSo17Resource.updateTbdHoSo17(idHoSo, tbdHoSo17): {}", fldMard17TbdHoSo17Resource.updateTbdHoSo17(idHoSo, tbdHoSo17).toString());
			LOGGER.info("form17DTO.getHoSo(): {}", form17DTO.getTepDinhKems());

			TbdHoSo17 finalTbdHoSo1 = tbdHoSo17;
			form17DTO.getTepDinhKems().stream().forEach(p-> {
						p.setFiIdHoSo(finalTbdHoSo1.getFiIdHoSo());
						if(p.getFiId() == null){
							createRestTemplate(getURL("/mard/17/tbdDinhKem17/create"), p, HttpMethod.POST, null, TbdDinhKem17.class);
						}
					});
			createHistory( fldMard17TbdKetQuaXuLy17Resource, fldMard17TbdHoSo17Resource, "Cập nhật hồ sơ", tbdHoSo17.getFiIdHoSo());
		} else {
			tbdHoSo17.setFiDocumentName("-1");
			tbdHoSo17 = fldMard17TbdHoSo17Resource.createTbdHoSo17(tbdHoSo17).getBody();
            final TbdHoSo17 tbdHoSo171Final = tbdHoSo17;
            if (!ObjectUtils.isEmpty(tbdHoSo17)) {
                form17DTO.getTepDinhKems().stream().forEach(p->{
                    p.setFiIdHoSo(tbdHoSo171Final.getFiIdHoSo());
					p = createRestTemplate(getURL("/mard/17/tbdDinhKem17/create"), p, HttpMethod.POST, null, TbdDinhKem17.class);
                    showLog(p);
                    //--------------------------
					LOGGER.info("p: {}" + p.toString());
                });
            }
			createHistory(fldMard17TbdKetQuaXuLy17Resource, fldMard17TbdHoSo17Resource, "Tạo mới hồ sơ", tbdHoSo17.getFiIdHoSo());
		}
        final TbdHoSo17 tbdHoSo171Final = tbdHoSo17;
        if (!ObjectUtils.isEmpty(tbdHoSo17)) {

            form17DTO.getThuocs().stream().forEach(p->{
            	TbdThuoc17 p2 = null;

                p.setFiIdHoSo(tbdHoSo171Final.getFiIdHoSo());
                if (Objects.equals(p.getFiId(), 0L)) {
                    p2 = createRestTemplate(getURL("/mard/17/tbdThuoc17/create"), p, HttpMethod.POST, null, TbdThuoc17.class);
                } else {
                    p2 = createRestTemplate(getURL("/mard/17/tbdThuoc17/update/") + p.getFiId(), p, HttpMethod.POST, null, TbdThuoc17.class);
                }
				if (!ObjectUtils.isEmpty(p.getFiTepDinhKemThuocs())) {
					TbdThuoc17 finalP = p2;
					p.getFiTepDinhKemThuocs().stream().forEach(pDinhKem -> {
						LOGGER.info("p(Thuoc): {}", finalP.toString());
						pDinhKem.setFiIdHoSo(tbdHoSo171Final.getFiIdHoSo());
						pDinhKem.setFiProductId(finalP.getFiId());
						pDinhKem = createRestTemplate(getURL("/mard/17/tbdDinhKem17/create"), pDinhKem, HttpMethod.POST, null, TbdDinhKem17.class);
						showLog(pDinhKem);
						LOGGER.info("dinhkemThuoc: {}", pDinhKem.toString());
					});
				}

				showLog(p);
            });

        }
        form17DTO.getHoSo().setFiDocumentName(tbdHoSo17.getFiDocumentName());
		form17DTO.getHoSo().setFiIdHoSo(tbdHoSo17.getFiIdHoSo());
        System.out.println(tbdHoSo17.getFiPurposes());

		return ResponseEntity.ok().body(form17DTO);
	}
	

	@RequestMapping(value = "/findGP/{idHoSo}", method = RequestMethod.POST)
	public ResponseEntity<FormGPDTO> findGP(@PathVariable("idHoSo") Long idHoSo) {
		FormGPDTO form = new FormGPDTO();
		TbdGiayPhep17DTO hoSo17DTO = new TbdGiayPhep17DTO();
		form.setHoSo(hoSo17DTO);
		if (idHoSo > 0) {
			BeanUtils.copyProperties(fldMard17TbdGiayPhep17Resource.findByFiIdHoSo(idHoSo).getBody().get(0), hoSo17DTO);
			form.setHoSo(hoSo17DTO);
			form.setThuocs(fldMard17TbdGPThuoc17Resource.findByFiIdHoSo(idHoSo).getBody());
			form.setDmLoaiThuoc(mard17TbsLoaiThuoc17Resource.findAllTbsLoaiThuoc17(new PageableDTO(100, 0)).getBody());
			form.setDanhMucMucDichs(fldMard17TbsMucDich17Resource.findByFiDocumentType(DOCUMENT_TYPE).getBody());
		}
		
		return ResponseEntity.ok().body(form);
	}
	@RequestMapping(value = "/saveThanhToanAndSend", method = RequestMethod.POST)
	public ResponseEntity<ResponseJson17> saveThanhToanAndSend(@RequestBody @Valid TbdThanhToan17DTO tbdThanhToan17DTO) {
		TbdThanhToan17 tbdThanhToan17 = new TbdThanhToan17();
		BeanUtils.copyProperties(tbdThanhToan17DTO, tbdThanhToan17);
		tbdThanhToan17.setFiCreateDate(new Date());
		tbdThanhToan17 = createRestTemplate(getURL("/mard/17/tbdThanhToan17/create"), tbdThanhToan17, HttpMethod.POST, null, TbdThanhToan17.class);
		createHistory(fldMard17TbdKetQuaXuLy17Resource, fldMard17TbdHoSo17Resource, "Thanh toán phí", tbdThanhToan17.getFiIdHoSo());
		tbdThanhToan17DTO.setFiId(tbdThanhToan17.getFiId());
		SendMessage17 sendMessage17 = new SendMessage17();
		sendMessage17.setFiAction(4);
		sendMessage17.setFiIdHoSo(tbdThanhToan17.getFiIdHoSo());
		ResponseJson17 responseJson17 = new ResponseJson17();
		sendMessage17.setFiTaxCode(SecurityUtil.getTaxCode());
		sendMessage17.setFiUserName(SecurityUtil.getTaxName());
		try {
			responseJson17 = createRestTemplate(getURL("/mard/17/sendAll/"), sendMessage17, HttpMethod.POST, null, ResponseJson17.class);
			if (responseJson17.isSuccess()) {
				responseJson17.setMessage(fldMessageSource.getMessage("mard.17.send.ok", null, LocaleContextHolder.getLocale()));
			} else {
				if (responseJson17.getStatus() == HttpStatus.GATEWAY_TIMEOUT.value()) {
					responseJson17.setMessage(fldMessageSource.getMessage("mard.17.send.timeout", null, LocaleContextHolder.getLocale()));
				} else if (responseJson17.getStatus() == HttpStatus.BAD_GATEWAY.value()) {
					responseJson17.setMessage(fldMessageSource.getMessage("mard.17.send.notOk", null, LocaleContextHolder.getLocale()));
				} else  {
					responseJson17.setMessage(fldMessageSource.getMessage("mard.17.send.exception", null, LocaleContextHolder.getLocale()));
				}
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			responseJson17.setException(fldMessageSource.getMessage("mard.17.send.exception", null, LocaleContextHolder.getLocale()));
		}
		return ResponseEntity.ok().body(responseJson17);
	}
	//start xuatGP ---------------------------------------------------------------------------------
	/*@RequestMapping(value = "/xuatGiayPhep/{idHoSo}", method = RequestMethod.GET)
	public void xuatGiayPhep(HttpServletResponse response, @PathVariable("idHoSo") Long idHoSo) {
		try {
			String mimeType = "application/octet-stream";
			response.setHeader("Content-Disposition",String.format("filename=\"giayPhep.docx\""));
			response.setContentType(mimeType);
			//getAllContent();
			FileCopyUtils.copy(getAllContent(idHoSo).toByteArray(), response.getOutputStream());
		}
		catch (Exception ex) {
			LOGGER.error(ex.getMessage());
			ex.printStackTrace();
		}

			//FileCopyUtils.copy(getAllContent().toByteArray(), response.getOutputStream());
	}*/
	/*public ByteArrayOutputStream getAllContent(Long idHoSo) throws IOException {
		XWPFDocument document = new XWPFDocument();
		XWPFParagraph title = document.createParagraph();

		title.setAlignment(ParagraphAlignment.CENTER);
		XWPFRun titleRun = title.createRun();
		TbdGiayPhep17DTO tbdGiayPhep17 = new TbdGiayPhep17DTO();
		//BeanUtils.copyProperties(fldMard17TbdGiayPhep17Resource.findByFiIdHoSo(idHoSo).getBody().get(0), tbdGiayPhep17);
		titleRun.setText("TEST XUAT GIAY PHEP" + idHoSo);
		titleRun.setBold(true);
		titleRun.setFontFamily("Arial");

		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		//FileOutputStream byteArrayOutputStream  = new FileOutputStream("Giay-Phep.docx");
		document.write(byteArrayOutputStream);

		//byteArrayOutputStream.close();


		return byteArrayOutputStream;

	}*/
	@RequestMapping(value = "/xuatGiayPhep/{idHoSo}", method = RequestMethod.GET)
	public void downloadTemplate(HttpServletRequest request, HttpServletResponse response, @PathVariable("idHoSo")Long idHoSo) throws IOException{
		TbdGiayPhep17DTO tbdGiayPhep17 = new TbdGiayPhep17DTO();
		List<TbsMucDich17> tbsMucDich17List = fldMard17TbsMucDich17Resource.findByFiDocumentType("BNNPTNT0600008").getBody();
		BeanUtils.copyProperties(fldMard17TbdGiayPhep17Resource.findByFiIdHoSo(idHoSo).getBody().get(0), tbdGiayPhep17);
		String mucDich = tbdGiayPhep17.getFiPurposes().substring(0, 1);
		String mucDichInWord = "";
		List<TbdGPThuoc17> tbdGPThuoc17s = fldMard17TbdGPThuoc17Resource.findByFiIdHoSo(idHoSo).getBody();
		String fiCoKhangSinh = "";
		String fiEndB = "./.";


		for(TbsMucDich17 tbsMucDich17 : tbsMucDich17List){
			if(Integer.parseInt(mucDich) == tbsMucDich17.getFiId()) mucDichInWord = tbsMucDich17.getFiName();

		}
		Double totalMoneyUSD = 0.0;
		Double totalMoneyEUR = 0.0;

		for (TbdGPThuoc17 tbdGPThuoc17 : tbdGPThuoc17s )
		{
			if(tbdGPThuoc17.getFiMoneyUnitCode().equals("USD")) {
				totalMoneyUSD += tbdGPThuoc17.getFiTotal();
			}
			else if(tbdGPThuoc17.getFiMoneyUnitCode().equals("EUR")){
				totalMoneyEUR += tbdGPThuoc17.getFiTotal();
			}
			if(tbdGPThuoc17.getFiProductType() == 8) {
				fiCoKhangSinh = "c) Báo cáo việc " + mucDichInWord + " nguyên liệu kháng sinh của lô nguyên liệu kháng sinh nhập khẩu lần trước, khi nộp hồ sơ đăng ký nhập khẩu nguyên liệu kháng sinh lô hàng tiếp theo về Cục Thú y./.";
				fiEndB = ".";
			}

		}
		String totalMoneyUSDInDouble = String.valueOf(totalMoneyUSD);
		String totalMoneyEURInDouble = String.valueOf(totalMoneyEUR);
		String totalMoneyInWordUSD = "";
		String totalMoneyInWordEUR = "";
		if(!totalMoneyUSDInDouble.split("\\.")[1].startsWith("0")) {
			totalMoneyInWordUSD = NumberToWord.docso(Integer.parseInt(totalMoneyUSDInDouble.split("\\.")[0])) + NumberToWord.docso(Integer.parseInt(totalMoneyUSDInDouble.split("\\.")[1]));
		}
		else if(totalMoneyUSDInDouble.split("\\.")[1].startsWith("0"))
		{
			totalMoneyInWordUSD = NumberToWord.docso(Integer.parseInt(totalMoneyUSDInDouble.split("\\.")[0]));
		}
		if(!totalMoneyEURInDouble.split("\\.")[1].startsWith("0")) {
			totalMoneyInWordEUR = NumberToWord.docso(Integer.parseInt(totalMoneyEURInDouble.split("\\.")[0])) + NumberToWord.docso(Integer.parseInt(totalMoneyEURInDouble.split("\\.")[1]));
		}
		else if(totalMoneyEURInDouble.split("\\.")[1].startsWith("0"))
		{
			totalMoneyInWordEUR = NumberToWord.docso(Integer.parseInt(totalMoneyEURInDouble.split("\\.")[0]));
		}
		Integer licenseType = tbdGiayPhep17.getFiLicenseType();
		String mucDichKhac = tbdGiayPhep17.getFiPurposeOtherNote();
		String lyDoTuChoi = tbdGiayPhep17.getFiDeniedReason();
		Integer templateDicision = WordUtil.handlerTemplate(mucDich, licenseType, lyDoTuChoi, mucDichKhac);
		String fileName = "";
		//Integer template = 0;
		//duoc pham (ko dung cho muc dich sd, kd)
		if (templateDicision == 4 ){
			fileName = "GP-KpSd.docx";
		}
		else if(templateDicision == 3 ){
			fileName = "GP-KpSd-TC.docx";
		}
		//vac xin
		else if(templateDicision == 6){
			fileName = "GP-VacXin-Sd.docx";
		}
		else if(templateDicision == 5){
			fileName = "GP-VacXin-Sd-TC.docx";
		}
		//Nguyen lieu
		else if(templateDicision == 10){
			fileName = "GP-NguyenLieu-Sd.docx";
		}
		else if(templateDicision == 9){
			fileName = "GP-NguyenLieu-Sd-TC.docx";
		}
		else if(templateDicision == 14){
			fileName = "GP-TongHop.docx";
		}
		else if(templateDicision == 13){
			fileName = "GP-TongHop-TC.docx";
		}

		//String fileName = "GPNhapKhau_5_TC.docx";
		//FileInputStream fileInputStream = null;
		//OutputStream responseOutputStream = null;
		try
		{
			//SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
			String ngayGui = WordUtil.formatDate(tbdGiayPhep17.getFiSignDate());
			String ngayKy = WordUtil.formatDate(tbdGiayPhep17.getFiSignConfirmDate());
			String fiNgayKy  = "ngày " + ngayKy.split("/")[0] + " tháng " + ngayKy.split("/")[1] + " năm " + ngayKy.split("/")[2];
			String fiSignConfirmDate = "Hà Nội, " + fiNgayKy;


			//BeanUtils.copyProperties(fldMard17TbdGiayPhep17Resource.findByFiIdHoSo(idHoSo).getBody().get(0), tbdGiayPhep17);
			String filePath = request.getServletContext().getRealPath("/WEB-INF/downloads/mard/17/")+ fileName;
			File file = new File(filePath);
			XWPFDocument document = new XWPFDocument(OPCPackage.open(file));
			WordUtil.createRow(document, tbdGPThuoc17s.size(), tbdGPThuoc17s, totalMoneyUSD, totalMoneyEUR , totalMoneyInWordUSD, totalMoneyInWordEUR );
			WordUtil.replace(document, "fiSignDate", ngayGui);
			WordUtil.replace(document, "fiDeniedReason", tbdGiayPhep17.getFiDeniedReason());
			WordUtil.replace(document, "fiSignConfirmDate", fiSignConfirmDate);
			WordUtil.replace(document, "fiPurpose", mucDichInWord);
			WordUtil.replace(document, "fiMucDichKhac", tbdGiayPhep17.getFiPurposeOtherNote());
			WordUtil.replace(document, "fiDispatchNo", tbdGiayPhep17.getFiDispatchNo());
			WordUtil.replace(document, "fiMultiproductLicense", tbdGiayPhep17.getFiMultiproductLicense());
			WordUtil.replace(document, "fiRegistrationName", tbdGiayPhep17.getFiOrganization());
			WordUtil.replace(document, "fiCoKhangSinh", fiCoKhangSinh);
			WordUtil.replace(document, "fiNgayKy", fiNgayKy);
			WordUtil.replace(document, "fiEndB", fiEndB);
			WordUtil.replace(document, "fiApplicationNo", tbdGiayPhep17.getFiApplicationNo());
			WordUtil.replace(document, "fiNumberOfProduct", String.valueOf(tbdGPThuoc17s.size()));
			WordUtil.replace(document, "fiDinhKemDanhMuc", tbdGiayPhep17.getFiMultiproductLicense().toUpperCase());
			WordUtil.replace(document, "fiInWordNumberOfProduct", NumberToWord.docso(tbdGPThuoc17s.size()).trim());
			WordUtil.replace(document, "fiSignConfirmName", tbdGiayPhep17.getFiSignConfirmName());
			WordUtil.replace(document, "fiLicenseContent", tbdGiayPhep17.getFiLicenseContent());
			//document.getTableArray(3).createRow().addNewTableCell().setText();

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
			LOGGER.error("ex: {}", ex.getMessage());
			LOGGER.error(ex.getMessage(), ex);
		}
		/*finally
		{
			fileInputStream.close();
			responseOutputStream.close();
		}*/
	}


}
