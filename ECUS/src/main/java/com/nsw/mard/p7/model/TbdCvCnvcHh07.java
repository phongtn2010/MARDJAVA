/*
 * Created on 18 Jul 2017 ( Time 08:39:33 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite)
package com.nsw.mard.p7.model;

import lombok.Data;

import java.io.Serializable;

/**
 * Persistent class for entity stored in table "TBDCVHANGHOA07" - Thông tin hàng hóa cho công văn
 *
 * @author Telosys Tools Generator
 */
@Data
public class TbdCvCnvcHh07 extends CmonHangHoa07 implements Serializable {

    private Integer fiIdProduct;

    private Integer fiIdCV;
}
