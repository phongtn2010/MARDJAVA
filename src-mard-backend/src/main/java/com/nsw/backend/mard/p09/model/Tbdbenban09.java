package com.nsw.backend.mard.p09.model;

import com.nsw.backend.dic.model.CmonBaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "TBDBENBAN09", schema = "MARD")
@NamedQueries({
        @NamedQuery(name = "Tbdbenban09.countAll", query = "SELECT COUNT(x) FROM Tbdbenban09 x")
})
public class Tbdbenban09 extends CmonBaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @Column(name = "FI_ID_SELLER")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TBDBENBAN09_SEQ")
    @SequenceGenerator(sequenceName = "TBDBENBAN09_SEQ", schema = "MARD", initialValue = 10000, allocationSize = 1, name = "TBDBENBAN09_SEQ")
    private Long fiIdSeller;

    @Column(name = "FI_HS_ID")
    private Long fiIdHS;

    @Column(name = "FI_SELLER_STATE_CODE", length = 250)
    private String fiSellerStateCode;

    @Column(name = "FI_SELLER_STATE_NAME", length = 250)
    private String fiSellerStateName;

    @Column(name = "FI_SELLER_ADDRESS", length = 250)
    private String fiSellerAddress;

    @Column(name = "FI_SELLER_NAME", length = 250)
    private String fiSellerName;

    @Column(name = "FI_SELLER_PHONE", length = 50)
    private String fiSellerPhone;

    @Column(name = "FI_SELLER_FAX", length = 50)
    private String fiSellerFax;

    @Column(name = "FI_PORT_DPT_NAME", length = 250)
    private String fiPortOfDepartureName;

}
