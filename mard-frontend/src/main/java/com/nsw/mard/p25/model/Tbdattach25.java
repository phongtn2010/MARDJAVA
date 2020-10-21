package com.nsw.mard.p25.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Data
public class Tbdattach25 implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long fiId;

    private Long fiIdHs;

    private Long fiLoaifile;

    private String fiTenloai;

    private Long fiFileId;

    private String fiFileName;

    private String fiFileLink;

}
