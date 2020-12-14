package com.nsw.mard.p9.model;

import com.google.common.base.Objects;
import lombok.Data;

import java.io.Serializable;

/**
 * Persistent class for entity stored in table "TBDDINHKEM09"
 *
 * @author Telosys Tools Generator
 *
 */
@Data
public class Tbddinhkem09 implements Serializable {

    private Long fiIdDinhkem;

    private Long fiMaLoai;

    private String fiTenLoai;

    private String fiTenTep;

    private String fiNoiDung;

    private Long fiHoatdong;

    private String fiDuongDan;

    private String fiGuid;

    private Long fiIdHS;

    private Long fiIdQualityRejectCer;

    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public Tbddinhkem09() {
        super();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tbddinhkem09 that = (Tbddinhkem09) o;
        return Objects.equal(fiIdDinhkem, that.fiIdDinhkem);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(fiIdDinhkem);
    }
}
