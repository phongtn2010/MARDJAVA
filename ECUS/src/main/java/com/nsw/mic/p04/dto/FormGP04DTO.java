package com.nsw.mic.p04.dto;


import com.nsw.mic.p03.model.TbsTepDinhKem03;
import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.List;

@Getter
@Setter
public class FormGP04DTO {

    private TbdGiayPhep04DTO tbdGiayPhep04DTO;
    private List<TbsTepDinhKem03> danhMucTepDinhKems = Collections.emptyList();


}
