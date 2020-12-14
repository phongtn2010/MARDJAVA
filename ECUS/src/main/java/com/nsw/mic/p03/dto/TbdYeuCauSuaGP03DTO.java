package com.nsw.mic.p03.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class TbdYeuCauSuaGP03DTO {

    private Long fiId;

    @NotNull
    private String fiNoiDung;

    @NotNull
    private Date fiNgayYeuCau;

    @NotNull
    private Long fiIdGiayPhep;

    private List<TbdDinhKemYCSGP03DTO> tbdDinhKemYCSGP03DTOS = new ArrayList<>();

    public Long getFiId() {
        return fiId;
    }
}
