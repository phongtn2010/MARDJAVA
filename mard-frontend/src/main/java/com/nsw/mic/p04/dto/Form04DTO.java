package com.nsw.mic.p04.dto;

import com.nsw.mic.p03.model.TbsTepDinhKem03;
import com.nsw.mic.p03.model.TbsTinhThanhPho03;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
public class Form04DTO implements Serializable {

	private TbdHoSo04DTO hoSo;
	private List<TbsTepDinhKem03> danhMucTepDinhKems = Collections.emptyList();
	private List<TbsTinhThanhPho03> danhMucTinhTPs = Collections.emptyList();
	private int action;

}
