package com.nsw.mic.p03.dto;


import com.nsw.mic.p03.model.TbsTepDinhKem03;
import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.List;

@Getter
@Setter
public class FormGP03DTO {

    private TbdGiayPhep03DTO tbdGiayPhep03DTO;
    private List<TbsTepDinhKem03> danhMucTepDinhKems = Collections.emptyList();

}
