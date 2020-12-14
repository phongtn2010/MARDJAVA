package com.nsw.mard.p18.rest;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.*;

import com.nsw.mard.p14.rest.SecurityUtil;

import com.nsw.mard.p17.model.TbdGPThuoc17;
import com.nsw.mard.p17.model.TbdGiayPhep17DTO;
import com.nsw.mard.p17.rest.NumberToWord;
import com.nsw.mard.p18.rest.WordUtil;
import com.nsw.mard.p18.model.TbdDinhKem18;
import com.nsw.mard.p18.model.TbdHoSo18;
import com.nsw.mard.p18.model.*;
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
import org.springframework.web.bind.annotation.*;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/mard/api/18")
public class Mard18Api extends Mard18CallBack  {
    //can sua de phan biet loai ho so
	public static final String DOCUMENT_TYPE = "BNNPTNT06000071";

	private static final Logger LOGGER = LoggerFactory.getLogger(Mard18Api.class);
	
	@Autowired
	private Mard18TbdHoSo18Resource fldMard18TbdHoSo18Resource;

	@Autowired
	private Mard18TbsTepDinhKem18Resource fldMard18TbsTepDinhKem18Resource;

	@Autowired
	private Mard18TbdDinhKem18Resource fldMard18TbdDinhKem18Resource;

	@Autowired
	private Mard18TbsTrangThai18Resource fldMard18TbsTrangThai18Resource;

	@Autowired
	private Mard18TbdThuoc18Resource fldMard18TbdThuoc18Resource;

	@Autowired
	private Mard18TbsLoaiThuoc18Resource fldMard18TbsLoaiThuoc18Resource;

	//@Autowired
	//private Mard18TbsMucDich18Resource fldMard18TbsMucDich18Resource;

	@Autowired
	private Mard18TbsLoaiCN18Resource fldMard18TbsLoaiCN18Resoure;

	@Autowired
	private Mard18TbdThongBaoKetQua18Resource fldMard18TbdThongBaoKetQua18Resource;

	@Autowired
	private Mard18TbdTBKetQuaThuoc18Resource fldMard18TbdTBKetQuaThuoc18Resource;

	@Autowired
	private Mard18TbdKetQuaXuLy18Resource fldMard18TbdKetQuaXuLy18Resource;

	@Autowired
	private  Mard18TbsLoaiThuoc18Resource mard18TbsLoaiThuoc18Resource;

	private MessageSource fldMessageSource;

	@Autowired
	public Mard18Api(MessageSource messageSource) {
		this.fldMessageSource = messageSource;
	}

	@RequestMapping(value = "/edit/{idHoSo}", method = RequestMethod.POST)
	public ResponseEntity<Form18DTO> edit(@PathVariable("idHoSo") Long idHoSo) {

		Form18DTO form = new Form18DTO();
		form.setDanhMucTepDinhKems(fldMard18TbsTepDinhKem18Resource.findByLoaiThuTucOrderByFiSortAsc(DOCUMENT_TYPE).getBody());
		form.setDanhMucThuocs(fldMard18TbsLoaiThuoc18Resource.findAllTbsLoaiThuoc18(new PageableDTO(100, 0)).getBody());
		form.setDanhMucLoaiCN(fldMard18TbsLoaiCN18Resoure.findByFiDocumentType(DOCUMENT_TYPE).getBody());
		String code = "0";
		TbdHoSo18DTO hoSo18DTO = new TbdHoSo18DTO();
		hoSo18DTO.setFiModifiedDate(new Date());
		form.setHoSo(hoSo18DTO);
		if (idHoSo > 0) {
			LOGGER.info(String.valueOf(form.getDanhMucTepDinhKems()));
			LOGGER.info("DOCUMENT_TYPE: {}", DOCUMENT_TYPE);
			BeanUtils.copyProperties(fldMard18TbdHoSo18Resource.getTbdHoSo18(idHoSo).getBody(), hoSo18DTO);
			form.setHoSo(hoSo18DTO);
			form.setTepDinhKems(fldMard18TbdDinhKem18Resource.findByFiIdHoSo(idHoSo).getBody());
			LOGGER.info(String.valueOf(form.getDanhMucTepDinhKems()));
			form.setThuocs(fldMard18TbdThuoc18Resource.findByFiIdHoSo(idHoSo).getBody());
			code = String.valueOf(form.getHoSo().getFiStatus());
		} else {
			UserCustom userCustom = SecurityUtil.getLoginUser();
			if (!ObjectUtils.isEmpty(userCustom)) {
				hoSo18DTO.setFiNameOfRegistration(userCustom.getCompanyName());
				hoSo18DTO.setFiAddressOfRegistration(userCustom.getCompanyAddress());
				hoSo18DTO.setFiFax(userCustom.getCompanyFax());
				hoSo18DTO.setFiEmail(userCustom.getCompanyEmail());
				hoSo18DTO.setFiPhone(userCustom.getCompanyPhoneNumber());
				hoSo18DTO.setFiTaxCode(userCustom.getUsername());
				hoSo18DTO.setFiCreateDate(new Date());
				hoSo18DTO.setFiActive(1);
				hoSo18DTO.setFiIdHoSo(0L);
				hoSo18DTO.setFiStatus(0);
				hoSo18DTO.setFiDocumentType(DOCUMENT_TYPE);
				hoSo18DTO.setFiDocumentName(DOCUMENT_TYPE);
			}
		}
		final String fiCode = code;
		List<TbsTrangThai18> tbsTrangThai18s = fldMard18TbsTrangThai18Resource.findAllTbsTrangThai18(new PageableDTO(100, 0)).getBody();
		if (!ObjectUtils.isEmpty(tbsTrangThai18s)) {
			Optional<TbsTrangThai18> find = tbsTrangThai18s.stream().filter(p-> fiCode.equals(p.getFiCode())).findFirst();
			if (find.isPresent()) form.getHoSo().setFiStatusName(find.get().getFiStatusName());
		}
		return ResponseEntity.ok().body(form);
	}
	
	@RequestMapping(value = "/send", method = RequestMethod.POST)
	public ResponseEntity<ResponseJson18> send(@RequestBody @Valid SendMessage18 sendMessage18) {
		
		LOGGER.info("send: {}", sendMessage18);
		ResponseJson18 responseJson18 = new ResponseJson18();
		sendMessage18.setFiTaxCode(SecurityUtil.getTaxCode());
		sendMessage18.setFiUserName(SecurityUtil.getTaxName());

		try {
			responseJson18 = createRestTemplate(getURL("/mard/18/sendAll/"), sendMessage18, HttpMethod.POST, null, ResponseJson18.class);
			if (responseJson18.isSuccess()) {
				responseJson18.setMessage(fldMessageSource.getMessage("mard.18.send.ok", null, LocaleContextHolder.getLocale()));
			} else {
				if (responseJson18.getStatus() == HttpStatus.GATEWAY_TIMEOUT.value()) {
					responseJson18.setMessage(fldMessageSource.getMessage("mard.18.send.timeout", null, LocaleContextHolder.getLocale()));
				} else if (responseJson18.getStatus() == HttpStatus.BAD_GATEWAY.value()) {
					responseJson18.setMessage(fldMessageSource.getMessage("mard.18.send.notOk", null, LocaleContextHolder.getLocale()));
				} else  {
					responseJson18.setMessage(fldMessageSource.getMessage("mard.18.send.exception", null, LocaleContextHolder.getLocale()));
				}
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			responseJson18.setException(fldMessageSource.getMessage("mard.18.send.exception", null, LocaleContextHolder.getLocale()));
		}
		
		return ResponseEntity.ok().body(responseJson18);
	}

	@RequestMapping(value = "/save/{idHoSo}", method = RequestMethod.POST)
	public ResponseEntity<Form18DTO> save(@PathVariable("idHoSo") Long idHoSo, @RequestBody @Valid Form18DTO form18DTO) {

		if (!isValid(form18DTO.getHoSo())) {
			return ResponseEntity.badRequest().body(form18DTO);
		}
		if (!ObjectUtils.isEmpty(form18DTO.getThuocs())) {
			for (TbdThuoc18 item : form18DTO.getThuocs()) {
				if (!isValid(item)) {
					return ResponseEntity.badRequest().body(form18DTO);
				}
			}
		}
		if (!ObjectUtils.isEmpty(form18DTO.getTepDinhKems())) {
			for (TbdDinhKem18 item : form18DTO.getTepDinhKems()) {
				if (!isValid(item)) {
					return ResponseEntity.badRequest().body(form18DTO);
				}
			}
		}
		TbdHoSo18 tbdHoSo18 = new TbdHoSo18();
		BeanUtils.copyProperties(form18DTO.getHoSo(), tbdHoSo18);
		showLog(form18DTO);
		if (idHoSo > 0) {
			fldMard18TbdHoSo18Resource.updateTbdHoSo18(idHoSo, tbdHoSo18);
			TbdHoSo18 finalTbdHoSo1 = tbdHoSo18;
			form18DTO.getTepDinhKems().stream().forEach(p-> {
				p.setFiIdHoSo(finalTbdHoSo1.getFiIdHoSo());
				if(p.getFiId() == null){
					createRestTemplate(getURL("/mard/18/tbdDinhKem18/create"), p, HttpMethod.POST, null, TbdDinhKem18.class);
				}
			});
			createHistory( fldMard18TbdKetQuaXuLy18Resource, fldMard18TbdHoSo18Resource, "Cập nhật hồ sơ", tbdHoSo18.getFiIdHoSo());
		} else {
			tbdHoSo18.setFiDocumentName("-1");
			tbdHoSo18 = fldMard18TbdHoSo18Resource.createTbdHoSo18(tbdHoSo18).getBody();
            final TbdHoSo18 tbdHoSo181Final = tbdHoSo18;
            if (!ObjectUtils.isEmpty(tbdHoSo18)) {
                form18DTO.getTepDinhKems().stream().forEach(p->{
                    p.setFiIdHoSo(tbdHoSo181Final.getFiIdHoSo());
					p = createRestTemplate(getURL("/mard/18/tbdDinhKem18/create"), p, HttpMethod.POST, null, TbdDinhKem18.class);
                    showLog(p);
                });
            }
			createHistory(fldMard18TbdKetQuaXuLy18Resource, fldMard18TbdHoSo18Resource, "Tạo mới hồ sơ", tbdHoSo18.getFiIdHoSo());
		}
        final TbdHoSo18 tbdHoSo181Final = tbdHoSo18;
        if (!ObjectUtils.isEmpty(tbdHoSo18)) {
            form18DTO.getThuocs().stream().forEach(p->{
				TbdThuoc18 p2 = null;
                p.setFiIdHoSo(tbdHoSo181Final.getFiIdHoSo());
                if (Objects.equals(p.getFiId(), 0L)) {
                   p2 = createRestTemplate(getURL("/mard/18/tbdThuoc18/create"), p, HttpMethod.POST, null, TbdThuoc18.class);
                }
				else {
				  p2 = createRestTemplate(getURL("/mard/18/tbdThuoc18/update/") + p.getFiId(), p, HttpMethod.POST, null, TbdThuoc18.class);
				}
				if (!ObjectUtils.isEmpty(p.getFiTepDinhKemThuocs())) {
					TbdThuoc18 finalP = p2;
					p.getFiTepDinhKemThuocs().stream().forEach(pDinhKem -> {
						LOGGER.info("p(Thuoc): {}", finalP.toString());
						pDinhKem.setFiIdHoSo(tbdHoSo181Final.getFiIdHoSo());
						pDinhKem.setFiProductId(finalP.getFiId());
						pDinhKem = createRestTemplate(getURL("/mard/18/tbdDinhKem18/create"), pDinhKem, HttpMethod.POST, null, TbdDinhKem18.class);
						showLog(pDinhKem);
						LOGGER.info("dinhkemThuoc: {}", pDinhKem.toString());
					});
				}



                showLog(p);
            });

        }
        form18DTO.getHoSo().setFiDocumentName(tbdHoSo18.getFiDocumentName());
		form18DTO.getHoSo().setFiIdHoSo(tbdHoSo18.getFiIdHoSo());
		return ResponseEntity.ok().body(form18DTO);
	}
	

	@RequestMapping(value = "/findGP/{idHoSo}", method = RequestMethod.POST)
	public ResponseEntity<FormGPDTO> findGP(@PathVariable("idHoSo") Long idHoSo) {
		FormGPDTO form = new FormGPDTO();
		TbdThongBaoKetQua18DTO hoSo18DTO = new TbdThongBaoKetQua18DTO();
		form.setHoSo(hoSo18DTO);
		LOGGER.info("form: {}", form.toString());
		LOGGER.info("TbdThongBaoKetQua18DTO: {}", hoSo18DTO.toString());
		LOGGER.info("fiIdHoSo : {}", idHoSo);
		if (idHoSo > 0) {
			BeanUtils.copyProperties(fldMard18TbdThongBaoKetQua18Resource.findByFiIdHoSo(idHoSo).getBody().get(0), hoSo18DTO);
			form.setHoSo(hoSo18DTO);
			LOGGER.info("hoSo18DTO: {}", hoSo18DTO );
			form.setThuocs(fldMard18TbdTBKetQuaThuoc18Resource.findByFiIdHoSo(idHoSo).getBody());
			//LOGGER.info("thuocs: {}" , form.getThuocs().toString());
			form.setDmLoaiThuoc(mard18TbsLoaiThuoc18Resource.findAllTbsLoaiThuoc18(new PageableDTO(100, 0)).getBody());
			//form.setDanhMucMucDichs(fldMard18TbsMucDich18Resource.findByFiDocumentType(DOCUMENT_TYPE).getBody());
		}
		
		return ResponseEntity.ok().body(form);
	}
	//Bổ sung số tờ khai và số vận đơn
	@RequestMapping(value = "/saveSoToKhaiAndSoVanDonAndSend/{idHoSo}", method = RequestMethod.POST)
	public ResponseEntity<ResponseJson18> saveSoToKhaiAndSend(@PathVariable("idHoSo")Long fiIdHoSo, @RequestBody TbdHoSo18DTO tbdHoSo18DTO){
		TbdHoSo18 tbdHoSo18 = new TbdHoSo18();
		BeanUtils.copyProperties(fldMard18TbdHoSo18Resource.getTbdHoSo18(fiIdHoSo).getBody(), tbdHoSo18);
		if(tbdHoSo18DTO.getFiBillNo() != null && !(tbdHoSo18DTO.getFiBillNo().isEmpty())) {
			tbdHoSo18.setFiBillNo(tbdHoSo18DTO.getFiBillNo());
		}
		LOGGER.info("tbdHoso18DTO : {}", tbdHoSo18DTO.toString());
		if(tbdHoSo18DTO.getFiDeclarationNo() != null && !(tbdHoSo18DTO.getFiDeclarationNo().isEmpty())) {
			tbdHoSo18.setFiDeclarationNo(tbdHoSo18DTO.getFiDeclarationNo());
		}
		fldMard18TbdHoSo18Resource.updateTbdHoSo18(fiIdHoSo, tbdHoSo18);
		SendMessage18 sendMessage18 = new SendMessage18();
		ResponseJson18 responseJson18 = new ResponseJson18();
		sendMessage18.setFiTaxCode(SecurityUtil.getTaxCode());
		sendMessage18.setFiUserName(SecurityUtil.getTaxName());
		sendMessage18.setFiAction(6);
		sendMessage18.setFiIdHoSo(fiIdHoSo);

		try {
			responseJson18 = createRestTemplate(getURL("/mard/18/sendAll/"), sendMessage18, HttpMethod.POST, null, ResponseJson18.class);
			if (responseJson18.isSuccess()) {
				responseJson18.setMessage(fldMessageSource.getMessage("mard.18.send.ok", null, LocaleContextHolder.getLocale()));
				createHistory(fldMard18TbdKetQuaXuLy18Resource, fldMard18TbdHoSo18Resource, "Bổ sung số tờ khai", tbdHoSo18.getFiIdHoSo());
			} else {
				if (responseJson18.getStatus() == HttpStatus.GATEWAY_TIMEOUT.value()) {
					responseJson18.setMessage(fldMessageSource.getMessage("mard.18.send.timeout", null, LocaleContextHolder.getLocale()));
				} else if (responseJson18.getStatus() == HttpStatus.BAD_GATEWAY.value()) {
					responseJson18.setMessage(fldMessageSource.getMessage("mard.18.send.notOk", null, LocaleContextHolder.getLocale()));
				} else  {
					responseJson18.setMessage(fldMessageSource.getMessage("mard.18.send.exception", null, LocaleContextHolder.getLocale()));
				}
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			responseJson18.setException(fldMessageSource.getMessage("mard.18.send.exception", null, LocaleContextHolder.getLocale()));
		}

		return ResponseEntity.ok().body(responseJson18);

	}
	//xuat gp
	@RequestMapping(value = "/xuatGiayPhep/{idHoSo}", method = RequestMethod.GET)
	public void downloadTemplate(HttpServletRequest request, HttpServletResponse response, @PathVariable("idHoSo")Long idHoSo) throws IOException {

		String fileName = "template-tt4-dk.docx";
		//FileInputStream fileInputStream = null;
		//OutputStream responseOutputStream = null;
		try
		{
			TbdThongBaoKetQua18DTO tbdGiayPhep18 = new TbdThongBaoKetQua18DTO();
			//lấy cửa nhập khẩu và thời gian nhập khẩu
			List<TbdThuoc18> tbdThuoc18List = new ArrayList<>();
			tbdThuoc18List = fldMard18TbdThuoc18Resource.findByFiIdHoSo(idHoSo).getBody();
			String cuaNhapKhau = tbdThuoc18List.get(0).getFiGate();
			String thoiGianNk = WordUtil.formatDate(tbdThuoc18List.get(0).getFiImportTimeFrom()) + " - " + WordUtil.formatDate(tbdThuoc18List.get(0).getFiImportTimeTo());
			List<TbdTBKetQuaThuoc18> tbdGPThuoc18s = null;
			tbdGPThuoc18s = fldMard18TbdTBKetQuaThuoc18Resource.findByFiIdHoSo(idHoSo).getBody();
			BeanUtils.copyProperties(fldMard18TbdThongBaoKetQua18Resource.findByFiIdHoSo(idHoSo).getBody().get(0), tbdGiayPhep18);
			//SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
			String ngayGui = WordUtil.formatDate(tbdGiayPhep18.getFiSignConfirmDate());
			String fiSignConfirmDate = "Hà Nội, ngày " + ngayGui.split("/")[0] + " tháng " + ngayGui.split("/")[1] + " năm " + ngayGui.split("/")[2];
			String ngayNop = WordUtil.formatDate(tbdGiayPhep18.getFiSignDate());
			String fiCQDate =  WordUtil.formatDate(tbdGiayPhep18.getFiCQDate());
			//BeanUtils.copyProperties(fldMard17TbdGiayPhep17Resource.findByFiIdHoSo(idHoSo).getBody().get(0), tbdGiayPhep17);
			String filePath = request.getServletContext().getRealPath("/WEB-INF/downloads/mard/18/")+ fileName;
			File file = new File(filePath);
			XWPFDocument document = new XWPFDocument(OPCPackage.open(file));
			WordUtil.createRow(document, tbdGPThuoc18s.size(), tbdGPThuoc18s);
			WordUtil.replace(document, "fiDispatchNo", tbdGiayPhep18.getFiDispatchNo());
			WordUtil.replace(document, "fiSignConfirmDate", fiSignConfirmDate);
			WordUtil.replace(document, "fiImportTime", thoiGianNk);
			WordUtil.replace(document, "fiGates", cuaNhapKhau);
			WordUtil.replace(document, "fiContractNo", tbdGiayPhep18.getFiContractNo());
			WordUtil.replace(document, "fiGoodListNo", tbdGiayPhep18.getFiGoodListNo());
			WordUtil.replace(document, "fiInvoiceNo", tbdGiayPhep18.getFiInvoiceNo());
			WordUtil.replace(document, "fiBillNo", tbdGiayPhep18.getFiBillNo());
			WordUtil.replace(document, "fiDeclarationNo", tbdGiayPhep18.getFiDeclarationNo());
			WordUtil.replace(document, "fiCONo", tbdGiayPhep18.getFiCONo());
			WordUtil.replace(document, "fiCFSNo", tbdGiayPhep18.getFiCFSNo());
			WordUtil.replace(document, "fiOrganization", tbdGiayPhep18.getFiOrganization());
			WordUtil.replace(document, "fiApplicationNo", tbdGiayPhep18.getFiApplicationNo());
			WordUtil.replace(document, "fiSignDate", ngayNop);
			WordUtil.replace(document, "fiApplyRegul", tbdGiayPhep18.getFiApplyRegul());
			WordUtil.replace(document, "fiTechRegul", tbdGiayPhep18.getFiTechRegul());
			WordUtil.replace(document, "fiCQNo", tbdGiayPhep18.getFiCQNo());
			WordUtil.replace(document, "fiCQOrganization", tbdGiayPhep18.getFiCQOrganization());
			WordUtil.replace(document, "fiCQDate", fiCQDate);
			WordUtil.replace(document, "fiCQIssueBy", tbdGiayPhep18.getFiCQIssueBy());
			WordUtil.replace(document, "fiResult", tbdGiayPhep18.getFiResult());
			WordUtil.replace(document, "fiSignConfirmName", tbdGiayPhep18.getFiSignConfirmName());


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
			LOGGER.info("ERROR: {}", ex.getMessage());
			LOGGER.error(ex.getMessage(), ex);
		}
		finally {

			response.getOutputStream().close();
		}
	}
	//xuat ho so
	@RequestMapping(value = "/xuatFileHoSo/{idHoSo}", method = RequestMethod.GET)
	public void downloadTemplateHoSo(HttpServletRequest request, HttpServletResponse response, @PathVariable("idHoSo")Long fiIdHoSo) {
		String fileName = "hoso-tt4.docx";
		try
		{
			String hasVacXin = "";
			final Integer[] VAC_XIN_ARRAY = {16, 17, 18};
			List<Integer> vacXinLst = Arrays.asList(VAC_XIN_ARRAY);
			String filePath = request.getServletContext().getRealPath("/WEB-INF/downloads/mard/18/")+ fileName;
			File file = new File(filePath);
			XWPFDocument document = new XWPFDocument(OPCPackage.open(file));
			/*List<TbdHoSo18> tbdHoSo18List = fldMard18TbdHoSo18Resource.findByFiDocumentName(fiDocumentName).getBody();
			TbdHoSo18 tbdHoSo18 = tbdHoSo18List.stream()
					.filter(p ->
							1 == p.getFiActive())
					.findAny()
					.orElse(tbdHoSo18List.get(0));*/
			TbdHoSo18 tbdHoSo18 = new TbdHoSo18();
			BeanUtils.copyProperties(fldMard18TbdHoSo18Resource.getTbdHoSo18(fiIdHoSo).getBody(), tbdHoSo18);

			List<TbdThuoc18> tbdThuoc18s = fldMard18TbdThuoc18Resource.findByFiIdHoSo(tbdHoSo18.getFiIdHoSo()).getBody();
			for(TbdThuoc18 tbdThuoc18 : tbdThuoc18s){
				if (vacXinLst.contains(tbdThuoc18.getFiProductType())) {
					hasVacXin = "Đây là lô hàng kiểm tra chất lượng vắc xin thú y nên thời gian kiểm tra là 60 ngày. Kính đề nghị cơ quan hải quan tạo điều kiện cho " + tbdHoSo18.getFiNameOfRegistration() + " được gia hạn thời gian bổ sung kết quả kiểm tra chất lượng lô hàng vắc xin thú y nhập khẩu để hoàn tất thủ tục thông quan theo quy định";
					break;
				}
			}
			String fiCQDate = WordUtil.formatDate(tbdHoSo18.getFiCQDate());
			String fiCMSDate = WordUtil.formatDate(tbdHoSo18.getFiCMSDate());
			String fiRegistrationDate = WordUtil.formatDate(tbdHoSo18.getFiRegistrationDate());
			String fiSendDate = WordUtil.formatDate(tbdHoSo18.getFiSendDate());
			String ngayGui = "Hà Nội, ngày " + fiSendDate.split("/")[0] + " tháng " + fiSendDate.split("/")[1] + " năm " + fiSendDate.split("/")[2];
			String ngayGuiKemHS = " ngày " + fiSendDate.split("/")[0] + " tháng " + fiSendDate.split("/")[1] + " năm " + fiSendDate.split("/")[2];
			String ngayVaoSo = ".............";
			if(fiRegistrationDate.contains("/")) {
				ngayVaoSo = "Hà Nội, ngày " + fiRegistrationDate.split("/")[0] + " tháng " + fiRegistrationDate.split("/")[1] + " năm " + fiRegistrationDate.split("/")[2];
			}
			WordUtil.createRowHoSo(document, tbdThuoc18s.size(), tbdThuoc18s);
			WordUtil.replace(document,"fiNameOfRegistration", tbdHoSo18.getFiNameOfRegistration());
			WordUtil.replace(document,"fiAddressOfRegistration", tbdHoSo18.getFiAddressOfRegistration());
			WordUtil.replace(document,"fiPhoneNumber", tbdHoSo18.getFiPhone());
			WordUtil.replace(document,"fiFax", tbdHoSo18.getFiFax());
			WordUtil.replace(document,"fiEmail", tbdHoSo18.getFiEmail());
			WordUtil.replace(document,"fiGates", tbdHoSo18.getFiGates());
			WordUtil.replace(document,"fiContractNo", tbdHoSo18.getFiContractNo());
			WordUtil.replace(document,"fiGoodListNo", tbdHoSo18.getFiGoodListNo());
			WordUtil.replace(document, "fiCQNo", tbdHoSo18.getFiCQNo());
			WordUtil.replace(document, "fiCQOrganization", tbdHoSo18.getFiCQOrganization());
			WordUtil.replace(document, "fiCQDate", fiCQDate);
			WordUtil.replace(document, "fiCQIssueBy", tbdHoSo18.getFiCQIssueBy());
			WordUtil.replace(document, "fiCMSNo", tbdHoSo18.getFiCMSNo());
			WordUtil.replace(document, "fiCMSOrganization", tbdHoSo18.getFiCMSOrganization());
			WordUtil.replace(document, "fiCMSDate", fiCMSDate);
			WordUtil.replace(document, "fiCMSIssueBy", tbdHoSo18.getFiCMSIssueBy());
			WordUtil.replace(document, "fiInvoiceNo", tbdHoSo18.getFiInvoiceNo());
			WordUtil.replace(document, "fiBillNo", tbdHoSo18.getFiBillNo());
			WordUtil.replace(document, "fiDeclarationNo", tbdHoSo18.getFiDeclarationNo());
			WordUtil.replace(document, "fiCONo", tbdHoSo18.getFiCONo());
			WordUtil.replace(document, "fiCFSNo", tbdHoSo18.getFiCFSNo());
			WordUtil.replace(document, "fiTechRegul", tbdHoSo18.getFiTechRegul());
			WordUtil.replace(document, "fiApplyRegul", tbdHoSo18.getFiApplyRegul());
			WordUtil.replace(document, "fiRegistrationNumber", tbdHoSo18.getFiRegistrationNumber());
			WordUtil.replace(document, "fiRegistrationDate", ngayVaoSo);
			WordUtil.replace(document, "fiSendDate", ngayGui);
			WordUtil.replace(document, "fiNgayGuiKem", ngayGuiKemHS);
			WordUtil.replace(document, "fiSoDonDangKy", tbdHoSo18.getFiApplicationNo());
			WordUtil.replace(document, "fiHasVacXin", hasVacXin);
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
			LOGGER.error("ERROR WITH WORD EXPORT: {}", ex.getMessage());
			LOGGER.error(ex.getMessage(), ex);

		}


	}

}
