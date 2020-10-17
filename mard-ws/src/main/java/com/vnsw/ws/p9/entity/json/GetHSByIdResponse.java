package com.vnsw.ws.p9.entity.json;

import com.vnsw.ws.p9.message.send.HoSo09;
import lombok.Data;

@Data
public class GetHSByIdResponse {
    private HoSo09 data;
}
