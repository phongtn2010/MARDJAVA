package com.nsw.mard.p9.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class TbdCnkdHh09 extends CmonHh09 implements Serializable {
    private Long fiIdHh;

    private Long fiIdCV;

    public TbdCnkdHh09() {
        super();
    }
}
