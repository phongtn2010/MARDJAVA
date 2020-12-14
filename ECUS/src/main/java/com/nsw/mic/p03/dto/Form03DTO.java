package com.nsw.mic.p03.dto;

import com.nsw.mic.p03.model.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
public class Form03DTO implements Serializable {

	private TbdHoSo03DTO hoSo;
	private List<TbsTepDinhKem03> danhMucTepDinhKems = Collections.emptyList();
	private List<TbsTinhThanhPho03> danhMucTinhTPs = Collections.emptyList();
	private int action;

}
