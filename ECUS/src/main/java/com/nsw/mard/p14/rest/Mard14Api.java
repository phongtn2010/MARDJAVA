package com.nsw.mard.p14.rest;


import javax.validation.Valid;

import com.nsw.mard.p14.model.*;
import com.nsw.security.UserCustom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/mard/api/14")
public class Mard14Api extends Mard14CallBack  {

	public static final String DOCUMENT_TYPE = "BNN0300003";
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Mard14Api.class);
	
	@Autowired
	private Mard14TbdHoSo14Resource fldMard14TbdHoSo14Resource;

	@Autowired
	private Mard14TbsTepDinhKem14Resource fldMard14TbsTepDinhKem14Resource;

	@Autowired
	private Mard14TbdDinhKem14Resource fldMard14TbdDinhKem14Resource;

	@Autowired
	private Mard14TbsTrangThai14Resource fldMard14TbsTrangThai14Resource;

	@Autowired
	private Mard14TbdThuoc14Resource fldMard14TbdThuoc14Resource;

	@Autowired
	private Mard14TbsLoaiThuoc14Resource fldMard14TbsLoaiThuoc14Resource;

	@Autowired
	private Mard14TbsMucDich14Resource fldMard14TbsMucDich14Resource;

	@Autowired
	private Mard14TbdGiayPhep14Resource fldMard14TbdGiayPhep14Resource;

	@Autowired
	private Mard14TbdGPThuoc14Resource fldMard14TbdGPThuoc14Resource;

	@Autowired
	private Mard14TbdKetQuaXuLy14Resource fldMard14TbdKetQuaXuLy14Resource;

	@Autowired
	private  Mard14TbsLoaiThuoc14Resource mard14TbsLoaiThuoc14Resource;

	private MessageSource fldMessageSource;

	@Autowired
	public Mard14Api(MessageSource messageSource) {
		this.fldMessageSource = messageSource;
	}

	@RequestMapping(value = "/edit/{idHoSo}", method = RequestMethod.POST)
	public ResponseEntity<Form14DTO> edit(@PathVariable("idHoSo") Long idHoSo) {

		Form14DTO form = new Form14DTO();
		form.setDanhMucTepDinhKems(fldMard14TbsTepDinhKem14Resource.findByLoaiThuTucOrderByFiSortAsc(DOCUMENT_TYPE).getBody());
		form.setDanhMucThuocs(fldMard14TbsLoaiThuoc14Resource.findAllTbsLoaiThuoc14(new PageableDTO(100, 0)).getBody());
		form.setDanhMucMucDichs(fldMard14TbsMucDich14Resource.findByFiDocumentType(DOCUMENT_TYPE).getBody());
		String code = "0";
		TbdHoSo14DTO hoSo14DTO = new TbdHoSo14DTO();
		hoSo14DTO.setFiModifiedDate(new Date());
		form.setHoSo(hoSo14DTO);
		if (idHoSo > 0) {
			BeanUtils.copyProperties(fldMard14TbdHoSo14Resource.getTbdHoSo14(idHoSo).getBody(), hoSo14DTO);
			form.setHoSo(hoSo14DTO);
			form.setTepDinhKems(fldMard14TbdDinhKem14Resource.findByFiIdHoSo(idHoSo).getBody());
			form.setThuocs(fldMard14TbdThuoc14Resource.findByFiIdHoSo(idHoSo).getBody());
			code = String.valueOf(form.getHoSo().getFiStatus());
		} else {
			UserCustom userCustom = SecurityUtil.getLoginUser();
			if (!ObjectUtils.isEmpty(userCustom)) {
				hoSo14DTO.setFiNameOfRegistration(userCustom.getCompanyName());
				hoSo14DTO.setFiAddressOfRegistration(userCustom.getCompanyAddress());
				hoSo14DTO.setFiFax(userCustom.getCompanyFax());
				hoSo14DTO.setFiEmail(userCustom.getCompanyEmail());
				hoSo14DTO.setFiPhone(userCustom.getCompanyPhoneNumber());
				hoSo14DTO.setFiTaxCode(userCustom.getUsername());
				hoSo14DTO.setFiCreateDate(new Date());
				hoSo14DTO.setFiActive(1);
				hoSo14DTO.setFiIdHoSo(0L);
				hoSo14DTO.setFiStatus(0);
				hoSo14DTO.setFiDocumentType(DOCUMENT_TYPE);
				hoSo14DTO.setFiDocumentName(DOCUMENT_TYPE);
			}
		}
		final String fiCode = code;
		List<TbsTrangThai14> tbsTrangThai14s = fldMard14TbsTrangThai14Resource.findAllTbsTrangThai14(new PageableDTO(100, 0)).getBody();
		if (!ObjectUtils.isEmpty(tbsTrangThai14s)) {
			Optional<TbsTrangThai14> find = tbsTrangThai14s.stream().filter(p-> fiCode.equals(p.getFiCode())).findFirst();
			if (find.isPresent()) form.getHoSo().setFiStatusName(find.get().getFiStatusName());
		}
		return ResponseEntity.ok().body(form);
	}
	
	@RequestMapping(value = "/send", method = RequestMethod.POST)
	public ResponseEntity<ResponseJson14> send(@RequestBody @Valid SendMessage14 sendMessage14) {
		
		LOGGER.info("send: {}", sendMessage14);
		ResponseJson14 responseJson14 = new ResponseJson14();
		sendMessage14.setFiTaxCode(SecurityUtil.getTaxCode());
		sendMessage14.setFiUserName(SecurityUtil.getTaxName());
		try {
			responseJson14  = createRestTemplate(getURL("/mard/14/sendAll/"), sendMessage14, HttpMethod.POST, null, ResponseJson14.class);
			if (responseJson14.isSuccess()) {
				responseJson14.setMessage(fldMessageSource.getMessage("mard.14.send.ok", null, LocaleContextHolder.getLocale()));
			} else {
				if (responseJson14.getStatus() == HttpStatus.GATEWAY_TIMEOUT.value()) {
					responseJson14.setMessage(fldMessageSource.getMessage("mard.14.send.timeout", null, LocaleContextHolder.getLocale()));
				} else if (responseJson14.getStatus() == HttpStatus.BAD_GATEWAY.value()) {
					responseJson14.setMessage(fldMessageSource.getMessage("mard.14.send.notOk", null, LocaleContextHolder.getLocale()));
				} else  {
					responseJson14.setMessage(fldMessageSource.getMessage("mard.14.send.exception", null, LocaleContextHolder.getLocale()));
				}
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			responseJson14.setException(fldMessageSource.getMessage("mard.14.send.exception", null, LocaleContextHolder.getLocale()));
		}
		
		return ResponseEntity.ok().body(responseJson14);
	}

	@RequestMapping(value = "/save/{idHoSo}", method = RequestMethod.POST)
	public ResponseEntity<Form14DTO> save(@PathVariable("idHoSo") Long idHoSo, @RequestBody @Valid Form14DTO form14DTO) {

		if (!isValid(form14DTO.getHoSo())) {
			return ResponseEntity.badRequest().body(form14DTO);
		}
		if (!ObjectUtils.isEmpty(form14DTO.getThuocs())) {
			for (TbdThuoc14 item : form14DTO.getThuocs()) {
				if (!isValid(item)) {
					return ResponseEntity.badRequest().body(form14DTO);
				}
			}
		}
		if (!ObjectUtils.isEmpty(form14DTO.getTepDinhKems())) {
			for (TbdDinhKem14 item : form14DTO.getTepDinhKems()) {
				if (!isValid(item)) {
					return ResponseEntity.badRequest().body(form14DTO);
				}
			}
		}

		TbdHoSo14 tbdHoSo14 = new TbdHoSo14();
		BeanUtils.copyProperties(form14DTO.getHoSo(), tbdHoSo14);
		showLog(form14DTO);
		if (idHoSo > 0) {
			fldMard14TbdHoSo14Resource.updateTbdHoSo14(idHoSo, tbdHoSo14);
			createHistory( fldMard14TbdKetQuaXuLy14Resource, fldMard14TbdHoSo14Resource, "Cập nhật hồ sơ", tbdHoSo14.getFiIdHoSo());
		} else {
			tbdHoSo14.setFiDocumentName("-1");
			tbdHoSo14 = fldMard14TbdHoSo14Resource.createTbdHoSo14(tbdHoSo14).getBody();
            final TbdHoSo14 tbdHoSo141Final = tbdHoSo14;
            if (!ObjectUtils.isEmpty(tbdHoSo14)) {
                form14DTO.getTepDinhKems().stream().forEach(p->{
                    p.setFiIdHoSo(tbdHoSo141Final.getFiIdHoSo());
					p = createRestTemplate(getURL("/mard/14/tbdDinhKem14/create"), p, HttpMethod.POST, null, TbdDinhKem14.class);
                    showLog(p);
                });
            }
			createHistory(fldMard14TbdKetQuaXuLy14Resource, fldMard14TbdHoSo14Resource, "Tạo mới hồ sơ", tbdHoSo14.getFiIdHoSo());
		}
        final TbdHoSo14 tbdHoSo141Final = tbdHoSo14;
        if (!ObjectUtils.isEmpty(tbdHoSo14)) {
            form14DTO.getThuocs().stream().forEach(p->{
                p.setFiIdHoSo(tbdHoSo141Final.getFiIdHoSo());
                if (Objects.equals(p.getFiId(), 0L)) {
                    p = createRestTemplate(getURL("/mard/14/tbdThuoc14/create"), p, HttpMethod.POST, null, TbdThuoc14.class);
                } else {
                    p = createRestTemplate(getURL("/mard/14/tbdThuoc14/update/") + p.getFiId(), p, HttpMethod.POST, null, TbdThuoc14.class);
                }
                showLog(p);
            });

        }
        form14DTO.getHoSo().setFiDocumentName(tbdHoSo14.getFiDocumentName());
		form14DTO.getHoSo().setFiIdHoSo(tbdHoSo14.getFiIdHoSo());

		return ResponseEntity.ok().body(form14DTO);
	}
	

	@RequestMapping(value = "/findGP/{idHoSo}", method = RequestMethod.POST)
	public ResponseEntity<FormGPDTO> findGP(@PathVariable("idHoSo") Long idHoSo) {
		FormGPDTO form = new FormGPDTO();
		TbdGiayPhep14DTO hoSo14DTO = new TbdGiayPhep14DTO();
		form.setHoSo(hoSo14DTO);
		if (idHoSo > 0) {
			BeanUtils.copyProperties(fldMard14TbdGiayPhep14Resource.findByFiIdHoSo(idHoSo).getBody().get(0), hoSo14DTO);
			form.setHoSo(hoSo14DTO);
			form.setThuocs(fldMard14TbdGPThuoc14Resource.findByFiIdHoSo(idHoSo).getBody());
			form.setDmLoaiThuoc(mard14TbsLoaiThuoc14Resource.findAllTbsLoaiThuoc14(new PageableDTO(100, 0)).getBody());
			form.setDanhMucMucDichs(fldMard14TbsMucDich14Resource.findByFiDocumentType(DOCUMENT_TYPE).getBody());
		}
		
		return ResponseEntity.ok().body(form);
	}
	
}
