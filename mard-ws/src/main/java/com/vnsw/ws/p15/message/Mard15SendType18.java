package com.vnsw.ws.p15.message;

import com.vnsw.ws.p15.envelop.Content;
import com.vnsw.ws.p15.envelop.Envelope;
import com.vnsw.ws.p15.model.TbdKetQuaXuLy15;

public class Mard15SendType18 {

    public static Envelope send(Envelope envelope, TbdKetQuaXuLy15 tbdKetQuaXuLy15) {

        DNYeuCauChinhSuaGP dnYeuCauChinhSuaGP = new DNYeuCauChinhSuaGP();
        dnYeuCauChinhSuaGP.setFiRequestDate(tbdKetQuaXuLy15.getFiProcessDate());
        dnYeuCauChinhSuaGP.setFiReason(tbdKetQuaXuLy15.getFiContent());
        Content content = new Content();
        content.setFiDnYeuCauChinhSuaGP(dnYeuCauChinhSuaGP);
        envelope.getBody().setContent(content);

        return envelope;
    }
}
