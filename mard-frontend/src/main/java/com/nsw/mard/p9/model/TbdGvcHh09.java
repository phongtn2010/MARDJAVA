package com.nsw.mard.p9.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
public class TbdGvcHh09 extends CmonHh09 implements Serializable {
    private Long fiIdHh;

    private Long fiIdCV;

    public TbdGvcHh09() {
        super();
    }
}
