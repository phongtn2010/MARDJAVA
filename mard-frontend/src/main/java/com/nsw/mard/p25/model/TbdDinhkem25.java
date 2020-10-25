package com.nsw.mard.p25.model;

import com.google.common.base.Objects;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class TbdDinhkem25 implements Serializable {

    private Long fiIdDinhkem;

    private Long fiFileTypeID;

    private String fiFileTypeName;

    private String fiFileMaHoSo;

    private String fiFileName;

    private String fiFileHD;

    private Date fiFileHDDate;

    private Long fiActive;

    private String fiLinkBNN;

    private String fiGuidBNN;

    private Long fiIdHS;

    private Long fiIdProduct;

    public TbdDinhkem25() {
        super();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TbdDinhkem25 that = (TbdDinhkem25) o;
        return Objects.equal(fiIdDinhkem, that.fiIdDinhkem);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(fiIdDinhkem);
    }
}
