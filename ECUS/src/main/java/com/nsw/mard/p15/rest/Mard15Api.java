package com.nsw.mard.p15.rest;


import javax.validation.*;

import com.nsw.mard.p14.rest.Mard14TbsMucDich14Resource;
import com.nsw.mard.p14.rest.Mard14TbsTepDinhKem14Resource;
import com.nsw.mard.p14.rest.SecurityUtil;
import com.nsw.mard.p15.model.*;
import com.nsw.security.UserCustom;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import java.util.*;

@RestController
@RequestMapping("/mard/api/15")
public class Mard15Api extends Mard15CallBack  {

	public static final String DOCUMENT_TYPE = "BNN0500004";
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Mard15Api.class);
	
	@Autowired
	private Mard15TbdHoSo15Resource fldMard15TbdHoSo15Resource;

	@Autowired
	private Mard14TbsTepDinhKem14Resource fldMard14TbsTepDinhKem14Resource;

	@Autowired
	private Mard15TbdDinhKem15Resource fldMard15TbdDinhKem15Resource;

	@Autowired
	private Mard15TbdThuoc15Resource fldMard15TbdThuoc15Resource;

	@Autowired
	private Mard14TbsMucDich14Resource fldMard14TbsMucDich14Resource;
	@Autowired
	private Mard15TbdGiayPhep15Resource fldMard15TbdGiayPhep15Resource;

	@Autowired
	private Mard15TbdGPThuoc15Resource fldMard15TbdGPThuoc15Resource;

	@Autowired
	private Mard15TbdKetQuaXuLy15Resource fldMard15TbdKetQuaXuLy15Resource;

	@Autowired
	private Mard15TbsTrangThai15Resource fldMard15TbsTrangThai15Resource;

	private MessageSource fldMessageSource;

	@Autowired
	public Mard15Api(MessageSource messageSource) {
		this.fldMessageSource = messageSource;
	}

	@RequestMapping(value = "/edit/{idHoSo}", method = RequestMethod.POST)
	public ResponseEntity<Form15DTO> edit(@PathVariable("idHoSo") Long idHoSo) {
		Form15DTO form = new Form15DTO();
		form.setDanhMucTepDinhKems(fldMard14TbsTepDinhKem14Resource.findByLoaiThuTucOrderByFiSortAsc(DOCUMENT_TYPE).getBody());
		form.setDanhMucMucDichs(fldMard14TbsMucDich14Resource.findByFiDocumentType(DOCUMENT_TYPE).getBody());
		String code = "0";
		TbdHoSo15DTO hoSo15DTO = new TbdHoSo15DTO();
		form.setHoSo(hoSo15DTO);
		if (idHoSo > 0) {
			BeanUtils.copyProperties(fldMard15TbdHoSo15Resource.getTbdHoSo15(idHoSo).getBody(), hoSo15DTO);
			form.setHoSo(hoSo15DTO);
			form.setTepDinhKems(fldMard15TbdDinhKem15Resource.findByFiIdHoSo(idHoSo).getBody());
			form.setThuocs(fldMard15TbdThuoc15Resource.findByFiIdHoSo(idHoSo).getBody());
			code = String.valueOf(form.getHoSo().getFiStatus());
		} else {
			UserCustom userCustom = SecurityUtil.getLoginUser();
			if (!ObjectUtils.isEmpty(userCustom)) {
				hoSo15DTO.setFiNameOfRegistration(userCustom.getCompanyName());
				hoSo15DTO.setFiAddressOfRegistration(userCustom.getCompanyAddress());
				hoSo15DTO.setFiFax(userCustom.getCompanyFax());
				hoSo15DTO.setFiEmail(userCustom.getCompanyEmail());
				hoSo15DTO.setFiPhone(userCustom.getCompanyPhoneNumber());
				hoSo15DTO.setFiTaxCode(userCustom.getUsername());
				hoSo15DTO.setFiCreateDate(new Date());
				hoSo15DTO.setFiModifiedDate(new Date());
				hoSo15DTO.setFiActive(1);
				hoSo15DTO.setFiIdHoSo(0L);
				hoSo15DTO.setFiStatus(0);
				hoSo15DTO.setFiDocumentType(DOCUMENT_TYPE);
				hoSo15DTO.setFiDocumentName(DOCUMENT_TYPE);
			}

		}
		final String fiCode = code;
		List<TbsTrangThai15> tbsTrangThai15s = fldMard15TbsTrangThai15Resource.findAllTbsTrangThai15(new PageableDTO(100, 0)).getBody();
		if (!ObjectUtils.isEmpty(tbsTrangThai15s)) {
			Optional<TbsTrangThai15> find = tbsTrangThai15s.stream().filter(p-> fiCode.equals(p.getFiCode())).findFirst();
			if (find.isPresent()) form.getHoSo().setFiStatusName(find.get().getFiStatusName());
		}
		return ResponseEntity.ok().body(form);
	}
	
	@RequestMapping(value = "/send", method = RequestMethod.POST)
	public ResponseEntity<ResponseJson15> send(@RequestBody @Valid SendMessage15 sendMessage15) {
		
		LOGGER.info("send: {}", sendMessage15);
		ResponseJson15 responseJson15 = new ResponseJson15();
		sendMessage15.setFiTaxCode(SecurityUtil.getTaxCode());
		sendMessage15.setFiUserName(SecurityUtil.getTaxName());
		try {
			responseJson15  = createRestTemplate(getURL("/mard/15/sendAll/"), sendMessage15, HttpMethod.POST, null, ResponseJson15.class);
			if (responseJson15.isSuccess()) {
				responseJson15.setMessage(fldMessageSource.getMessage("mard.15.send.ok", null, LocaleContextHolder.getLocale()));
			} else {
				if (responseJson15.getStatus() == HttpStatus.GATEWAY_TIMEOUT.value()) {
					responseJson15.setMessage(fldMessageSource.getMessage("mard.15.send.timeout", null, LocaleContextHolder.getLocale()));
				} else if (responseJson15.getStatus() == HttpStatus.BAD_GATEWAY.value()) {
					responseJson15.setMessage(fldMessageSource.getMessage("mard.15.send.notOk", null, LocaleContextHolder.getLocale()));
				} else  {
					responseJson15.setMessage(fldMessageSource.getMessage("mard.15.send.exception", null, LocaleContextHolder.getLocale()));
				}

			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			responseJson15.setException(fldMessageSource.getMessage("mard.15.send.exception", null, LocaleContextHolder.getLocale()));
		}
		
		return ResponseEntity.ok().body(responseJson15);
	}

	@RequestMapping(value = "/save/{idHoSo}", method = RequestMethod.POST)
	public ResponseEntity<Form15DTO> save(@PathVariable("idHoSo") Long idHoSo, @RequestBody @Valid Form15DTO form15DTO) {

		if (!isValid(form15DTO.getHoSo())) {
			return ResponseEntity.badRequest().body(form15DTO);
		}
		if (!ObjectUtils.isEmpty(form15DTO.getThuocs())) {
		    for (TbdThuoc15 item : form15DTO.getThuocs()) {
                if (!isValid(item)) {
                    return ResponseEntity.badRequest().body(form15DTO);
                }
            }
        }
        if (!ObjectUtils.isEmpty(form15DTO.getTepDinhKems())) {
            for (TbdDinhKem15 item : form15DTO.getTepDinhKems()) {
                if (!isValid(item)) {
                    return ResponseEntity.badRequest().body(form15DTO);
                }
            }
        }
		TbdHoSo15 tbdHoSo15 = new TbdHoSo15();
		BeanUtils.copyProperties(form15DTO.getHoSo(), tbdHoSo15);
		showLog(form15DTO);
		if (idHoSo > 0) {
			fldMard15TbdHoSo15Resource.updateTbdHoSo15(idHoSo, tbdHoSo15);
			createHistory( fldMard15TbdKetQuaXuLy15Resource, fldMard15TbdHoSo15Resource, "Cập nhật hồ sơ", tbdHoSo15.getFiIdHoSo());
		} else {
			tbdHoSo15 = fldMard15TbdHoSo15Resource.createTbdHoSo15(tbdHoSo15).getBody();
            final TbdHoSo15 tbdHoSo151Final = tbdHoSo15;
            if (!ObjectUtils.isEmpty(tbdHoSo15)) {
                form15DTO.getTepDinhKems().stream().forEach(p->{
                    p.setFiIdHoSo(tbdHoSo151Final.getFiIdHoSo());
                    p = createRestTemplate(getURL("/mard/15/tbdDinhKem15/create"), p, HttpMethod.POST, null, TbdDinhKem15.class);
                    showLog(p);
                });
            }
			createHistory(fldMard15TbdKetQuaXuLy15Resource, fldMard15TbdHoSo15Resource, "Tạo mới hồ sơ", tbdHoSo15.getFiIdHoSo());
		}
        final TbdHoSo15 tbdHoSo151Final = tbdHoSo15;
        if (!ObjectUtils.isEmpty(tbdHoSo15)) {
            form15DTO.getThuocs().stream().forEach(p->{
                p.setFiIdHoSo(tbdHoSo151Final.getFiIdHoSo());
                if (Objects.equals(p.getFiId(), 0L)) {
                    p = createRestTemplate(getURL("/mard/15/tbdThuoc15/create"), p, HttpMethod.POST, null, TbdThuoc15.class);
                } else {
                    p = createRestTemplate(getURL("/mard/15/tbdThuoc15/update/") + p.getFiId(), p, HttpMethod.POST, null, TbdThuoc15.class);
                }
                showLog(p);
            });

        }
		form15DTO.getHoSo().setFiDocumentName(tbdHoSo15.getFiDocumentName());
		form15DTO.getHoSo().setFiIdHoSo(tbdHoSo15.getFiIdHoSo());

		return ResponseEntity.ok().body(form15DTO);
	}
	

	@RequestMapping(value = "/findGP/{idHoSo}", method = RequestMethod.POST)
	public ResponseEntity<FormGPDTO> findGP(@PathVariable("idHoSo") Long idHoSo) {
		FormGPDTO form = new FormGPDTO();
		TbdGiayPhep15DTO hoSo15DTO = new TbdGiayPhep15DTO();
		form.setHoSo(hoSo15DTO);
		if (idHoSo > 0) {
			BeanUtils.copyProperties(fldMard15TbdGiayPhep15Resource.findByFiIdHoSo(idHoSo).getBody().get(0), hoSo15DTO);
			form.setHoSo(hoSo15DTO);
			form.setThuocs(fldMard15TbdGPThuoc15Resource.findByFiIdHoSo(idHoSo).getBody());
		}
		
		return ResponseEntity.ok().body(form);
	}


}
