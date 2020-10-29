package com.nsw.backend.mard.p25.client;
import com.nsw.backend.mard.p25.dto.Ananytical;
import lombok.Data;


import java.util.List;

@Data
public class Goods {

    private String fiGoodsId;

    private String fiNameOfGoods;

    private String fiGoodTypeId;

    private String fiGoodTypeName;

    private String fiNature;
    private List<Ananytical> fiAnanyticalRequiredList;
}
