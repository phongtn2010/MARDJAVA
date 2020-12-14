package com.nsw.mard.p25.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Date;


@Data
public class TbdattachHd25 implements Serializable {

    private static final long serialVersionUID = 1L;


    private Long fiId;

    private Long fiIdHs;

    private String fiSoHd;

    private Date fiNgayHd;

    private Long fiIdFile;

    private String fiFileName;

    private String fiFileLink;

}
