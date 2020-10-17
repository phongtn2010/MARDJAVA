package com.nsw.mard.p6.model;
import com.google.common.base.Objects;
import lombok.Data;


import java.io.Serializable;

@Data
public class TbdDinhkem06 implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String SEQUENCE_NAME = "TBDDINHKEM06_SEQ";

    private Long fiIdDinhkem;

    private Long fiFileTypeCode;

    private String fiFileTypeName;

    private String fiFileName;

    private Long fiActive;

    private String fiPath;

    private String fiGuid;

    private Long fiIdHS;

    public TbdDinhkem06() {
        super();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TbdDinhkem06 that = (TbdDinhkem06) o;
        return Objects.equal(fiIdDinhkem, that.fiIdDinhkem);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(fiIdDinhkem);
    }
}

