package com.nsw.mard.p7.model;

import com.google.common.base.Objects;
import lombok.Data;

import java.io.Serializable;

@Data
public class TbdDinhkem07 implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String SEQUENCE_NAME = "TBDDINHKEM07_SEQ";

    private Integer fiIdDinhkem;

    private Integer fiFileTypeCode;

    private String fiFileTypeName;

    private String fiFileName;

    private Integer fiActive;

    private String fiPath;

    private String fiGuid;

    private Integer fiIdHS;

    public TbdDinhkem07() {
        super();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TbdDinhkem07 that = (TbdDinhkem07) o;
        return Objects.equal(fiIdDinhkem, that.fiIdDinhkem);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(fiIdDinhkem);
    }

}
