package com.vnsw.ws.p16.message;

import com.vnsw.ws.p16.envelop.Content;
import com.vnsw.ws.p16.envelop.Envelope;
import com.vnsw.ws.p16.message.DNYeuCauChinhSuaGP;
import com.vnsw.ws.p16.model.TbdKetQuaXuLy16;

public class Mard16SendType18 {

    public static Envelope send(Envelope envelope, TbdKetQuaXuLy16 tbdKetQuaXuLy16) {

        DNYeuCauChinhSuaGP dnYeuCauChinhSuaGP = new DNYeuCauChinhSuaGP();
        dnYeuCauChinhSuaGP.setFiRequestDate(tbdKetQuaXuLy16.getFiProcessDate());
        dnYeuCauChinhSuaGP.setFiReason(tbdKetQuaXuLy16.getFiContent());
        Content content = new Content();
        content.setFiDnYeuCauChinhSuaGP(dnYeuCauChinhSuaGP);
        envelope.getBody().setContent(content);

        return envelope;
    }
}
