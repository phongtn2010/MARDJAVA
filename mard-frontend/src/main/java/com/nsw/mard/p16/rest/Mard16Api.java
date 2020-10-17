package com.nsw.mard.p16.rest;


import javax.validation.*;

import com.nsw.mard.p14.rest.Mard14TbsMucDich14Resource;
import com.nsw.mard.p14.rest.Mard14TbsTepDinhKem14Resource;
import com.nsw.mard.p14.rest.SecurityUtil;
import com.nsw.mard.p15.model.TbsTrangThai15;
import com.nsw.mard.p15.rest.Mard15TbsTrangThai15Resource;
import com.nsw.mard.p16.model.*;
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


import java.util.*;

@RestController
@RequestMapping("/mard/api/16")
public class Mard16Api extends Mard16CallBack  {

	public static final String DOCUMENT_TYPE = "BNN0500003";
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Mard16Api.class);
	
	@Autowired
	private Mard16TbdHoSo16Resource fldMard16TbdHoSo16Resource;

	@Autowired
	private Mard14TbsTepDinhKem14Resource fldMard14TbsTepDinhKem14Resource;

	@Autowired
	private Mard16TbdDinhKem16Resource fldMard16TbdDinhKem16Resource;

	@Autowired
	private Mard16TbdThuoc16Resource fldMard16TbdThuoc16Resource;

	@Autowired
	private Mard14TbsMucDich14Resource fldMard14TbsMucDich14Resource;
	@Autowired
	private Mard16TbdGiayPhep16Resource fldMard16TbdGiayPhep16Resource;

	@Autowired
	private Mard16TbdGPThuoc16Resource fldMard16TbdGPThuoc16Resource;

	@Autowired
	private Mard16TbdKetQuaXuLy16Resource fldMard16TbdKetQuaXuLy16Resource;

	@Autowired
	private Mard15TbsTrangThai15Resource fldMard15TbsTrangThai15Resource;

	@Autowired
	private Mard16TbdToKhaiKyThuat16Reource fldMard16TbdToKhaiKyThuat16Reource;

	@Autowired
	private Mard16TbsLoaiGiayTo16Resource fldMard16TbsLoaiGiayTo16Resource;

	@Autowired
	private Mard16TbsBoPhan16Resource fldMard16TbsBoPhan16Resource;

	@Autowired
	private Mard16TbsGiaTriSuDung16Resource fldMard16TbsGiaTriSuDung16Resource;


	private MessageSource fldMessageSource;

	@Autowired
	public Mard16Api(MessageSource messageSource) {
		this.fldMessageSource = messageSource;
	}

	@RequestMapping(value = "/edit/{idHoSo}", method = RequestMethod.POST)
	public ResponseEntity<Form16DTO> edit(@PathVariable("idHoSo") Long idHoSo) {
		Form16DTO form = new Form16DTO();
		form.setDanhMucTepDinhKems(fldMard14TbsTepDinhKem14Resource.findByLoaiThuTucOrderByFiSortAsc(DOCUMENT_TYPE).getBody());
		form.setDanhMucMucDichs(fldMard14TbsMucDich14Resource.findByFiDocumentType(DOCUMENT_TYPE).getBody());
		form.setTbsLoaiGiayTo16s(fldMard16TbsLoaiGiayTo16Resource.findAll(new PageableDTO(1, 0, "fiCode", "asc")).getBody());
		form.setTbsBoPhan16s(fldMard16TbsBoPhan16Resource.findAll(new PageableDTO(1, 0, "fiCode", "asc")).getBody());
		form.setTbsGiaTriSuDung16s(fldMard16TbsGiaTriSuDung16Resource.findAll(new PageableDTO(1, 0, "fiCode", "asc")).getBody());
		String code = "0";
		TbdHoSo16DTO hoSo16DTO = new TbdHoSo16DTO();
		form.setHoSo(hoSo16DTO);
		if (idHoSo > 0) {
			BeanUtils.copyProperties(fldMard16TbdHoSo16Resource.getTbdHoSo16(idHoSo).getBody(), hoSo16DTO);
			form.setHoSo(hoSo16DTO);
			form.setTepDinhKems(fldMard16TbdDinhKem16Resource.findByFiIdHoSo(idHoSo).getBody());
			form.setThuocs(fldMard16TbdThuoc16Resource.findByFiIdHoSo(idHoSo).getBody());
			form.setToKhaiKyThuats(fldMard16TbdToKhaiKyThuat16Reource.findByFiIdHoSo(idHoSo).getBody());
			code = String.valueOf(form.getHoSo().getFiStatus());
		} else {
			UserCustom userCustom = SecurityUtil.getLoginUser();
			if (!ObjectUtils.isEmpty(userCustom)) {
				hoSo16DTO.setFiNameOfRegistration(userCustom.getCompanyName());
				hoSo16DTO.setFiAddressOfRegistration(userCustom.getCompanyAddress());
				hoSo16DTO.setFiFax(userCustom.getCompanyFax());
				hoSo16DTO.setFiEmail(userCustom.getCompanyEmail());
				hoSo16DTO.setFiPhone(userCustom.getCompanyPhoneNumber());
				hoSo16DTO.setFiTaxCode(userCustom.getUsername());
				hoSo16DTO.setFiCreateDate(new Date());
				hoSo16DTO.setFiModifiedDate(new Date());
				hoSo16DTO.setFiActive(1);
				hoSo16DTO.setFiIdHoSo(0L);
				hoSo16DTO.setFiStatus(0);
				hoSo16DTO.setFiDocumentType(DOCUMENT_TYPE);
				hoSo16DTO.setFiDocumentName(DOCUMENT_TYPE);
			}

		}
		final String fiCode = code;
		List<TbsTrangThai15> TbsTrangThai15s = fldMard15TbsTrangThai15Resource.findAllTbsTrangThai15(new com.nsw.mard.p15.model.PageableDTO(100, 0)).getBody();
		if (!ObjectUtils.isEmpty(TbsTrangThai15s)) {
			Optional<TbsTrangThai15> find = TbsTrangThai15s.stream().filter(p-> fiCode.equals(p.getFiCode())).findFirst();
			if (find.isPresent()) form.getHoSo().setFiStatusName(find.get().getFiStatusName());
		}
		return ResponseEntity.ok().body(form);
	}
	
	@RequestMapping(value = "/send", method = RequestMethod.POST)
	public ResponseEntity<ResponseJson16> send(@RequestBody @Valid SendMessage16 sendMessage16) {
		
		LOGGER.info("send: {}", sendMessage16);
		ResponseJson16 responseJson16 = new ResponseJson16();
		sendMessage16.setFiTaxCode(SecurityUtil.getTaxCode());
		sendMessage16.setFiUserName(SecurityUtil.getTaxName());
		try {
			responseJson16  = createRestTemplate(getURL("/mard/16/sendAll/"), sendMessage16, HttpMethod.POST, null, ResponseJson16.class);
			if (responseJson16.isSuccess()) {
				responseJson16.setMessage(fldMessageSource.getMessage("mard.16.send.ok", null, LocaleContextHolder.getLocale()));
			} else {
				if (responseJson16.getStatus() == HttpStatus.GATEWAY_TIMEOUT.value()) {
					responseJson16.setMessage(fldMessageSource.getMessage("mard.16.send.timeout", null, LocaleContextHolder.getLocale()));
				} else if (responseJson16.getStatus() == HttpStatus.BAD_GATEWAY.value()) {
					responseJson16.setMessage(fldMessageSource.getMessage("mard.16.send.notOk", null, LocaleContextHolder.getLocale()));
				} else  {
					responseJson16.setMessage(fldMessageSource.getMessage("mard.16.send.exception", null, LocaleContextHolder.getLocale()));
				}

			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			responseJson16.setException(fldMessageSource.getMessage("mard.16.send.exception", null, LocaleContextHolder.getLocale()));
		}
		
		return ResponseEntity.ok().body(responseJson16);
	}

	@RequestMapping(value = "/save/{idHoSo}", method = RequestMethod.POST)
	public ResponseEntity<Form16DTO> save(@PathVariable("idHoSo") Long idHoSo, @RequestBody @Valid Form16DTO form16DTO) {

		if (!isValid(form16DTO.getHoSo())) {
			return ResponseEntity.badRequest().body(form16DTO);
		}
		if (!ObjectUtils.isEmpty(form16DTO.getThuocs())) {
		    for (TbdThuoc16 item : form16DTO.getThuocs()) {
                if (!isValid(item)) {
                    return ResponseEntity.badRequest().body(form16DTO);
                }
            }
        }
        if (!ObjectUtils.isEmpty(form16DTO.getTepDinhKems())) {
            for (TbdDinhKem16 item : form16DTO.getTepDinhKems()) {
                if (!isValid(item)) {
                    return ResponseEntity.badRequest().body(form16DTO);
                }
            }
        }
		if (!ObjectUtils.isEmpty(form16DTO.getToKhaiKyThuats())) {
			for (TbdToKhaiKyThuat16 item : form16DTO.getToKhaiKyThuats()) {
				if (!isValid(item)) {
					return ResponseEntity.badRequest().body(form16DTO);
				}
			}
		}
		TbdHoSo16 tbdHoSo16 = new TbdHoSo16();
		BeanUtils.copyProperties(form16DTO.getHoSo(), tbdHoSo16);
		showLog(form16DTO);
		if (idHoSo > 0) {
			fldMard16TbdHoSo16Resource.updateTbdHoSo16(idHoSo, tbdHoSo16);
			createHistory( fldMard16TbdKetQuaXuLy16Resource, fldMard16TbdHoSo16Resource, "Cập nhật hồ sơ", tbdHoSo16.getFiIdHoSo());
		} else {
			tbdHoSo16 = fldMard16TbdHoSo16Resource.createTbdHoSo16(tbdHoSo16).getBody();
            final TbdHoSo16 tbdHoSo161Final = tbdHoSo16;
            if (!ObjectUtils.isEmpty(tbdHoSo16)) {
                form16DTO.getTepDinhKems().stream().forEach(p->{
                    p.setFiIdHoSo(tbdHoSo161Final.getFiIdHoSo());
                    p = createRestTemplate(getURL("/mard/16/tbdDinhKem16/create"), p, HttpMethod.POST, null, TbdDinhKem16.class);
                    showLog(p);
                });
            }
			createHistory(fldMard16TbdKetQuaXuLy16Resource, fldMard16TbdHoSo16Resource, "Tạo mới hồ sơ", tbdHoSo16.getFiIdHoSo());
		}
        final TbdHoSo16 tbdHoSo161Final = tbdHoSo16;
        if (!ObjectUtils.isEmpty(tbdHoSo16)) {
            form16DTO.getThuocs().stream().forEach(p->{
                p.setFiIdHoSo(tbdHoSo161Final.getFiIdHoSo());
                if (Objects.equals(p.getFiId(), 0L)) {
                    p = createRestTemplate(getURL("/mard/16/tbdThuoc16/create"), p, HttpMethod.POST, null, TbdThuoc16.class);
                } else {
                    p = createRestTemplate(getURL("/mard/16/tbdThuoc16/update/") + p.getFiId(), p, HttpMethod.POST, null, TbdThuoc16.class);
                }
                showLog(p);
            });

        }
		if (!ObjectUtils.isEmpty(form16DTO.getToKhaiKyThuats())) {
			form16DTO.getToKhaiKyThuats().stream().forEach(p->{
				p.setFiIdHoSo(tbdHoSo161Final.getFiIdHoSo());
				if (Objects.equals(p.getFiId(), 0L)) {
					p = createRestTemplate(getURL("/mard/16/tbdToKhaiKyThuat16/create"), p, HttpMethod.POST, null, TbdToKhaiKyThuat16.class);
				} else {
					p = createRestTemplate(getURL("/mard/16/tbdToKhaiKyThuat16/update/") + p.getFiId(), p, HttpMethod.POST, null, TbdToKhaiKyThuat16.class);
				}
				showLog(p);
			});

		}
		form16DTO.getHoSo().setFiDocumentName(tbdHoSo16.getFiDocumentName());
		form16DTO.getHoSo().setFiIdHoSo(tbdHoSo16.getFiIdHoSo());


		return ResponseEntity.ok().body(form16DTO);
	}
	

	@RequestMapping(value = "/findGP/{idHoSo}", method = RequestMethod.POST)
	public ResponseEntity<FormGPDTO> findGP(@PathVariable("idHoSo") Long idHoSo) {
		FormGPDTO form = new FormGPDTO();
		TbdGiayPhep16DTO hoSo16DTO = new TbdGiayPhep16DTO();
		form.setHoSo(hoSo16DTO);
		if (idHoSo > 0) {
			BeanUtils.copyProperties(fldMard16TbdGiayPhep16Resource.findByFiIdHoSo(idHoSo).getBody().get(0), hoSo16DTO);
			form.setHoSo(hoSo16DTO);
			form.setThuocs(fldMard16TbdGPThuoc16Resource.findByFiIdHoSo(idHoSo).getBody());
		}
		
		return ResponseEntity.ok().body(form);
	}


}
