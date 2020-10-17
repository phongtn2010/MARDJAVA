package com.vnsw.ws.p15.message;

import com.vnsw.ws.p15.envelop.Content;
import com.vnsw.ws.p15.envelop.Envelope;
import com.vnsw.ws.p15.model.TbdKetQuaXuLy15;


/***
 *
 *
 * @Mard015BuildMessageSendType115
 * @class Mard015SendType115
 * Created by Nguyen Van Quang
 * 06/12/2018 15:156:15
 *
 */
public class Mard15SendType15 {

    public static Envelope send(Envelope envelope, TbdKetQuaXuLy15 tbdKetQuaXuLy15) {

        DNYeuCauRutHSSauTiepNhan dnYeuCauRutHS = new DNYeuCauRutHSSauTiepNhan();
        dnYeuCauRutHS.setFiRequestDate(tbdKetQuaXuLy15.getFiProcessDate());
        dnYeuCauRutHS.setFiReason(tbdKetQuaXuLy15.getFiContent());
        Content content = new Content();
        content.setFiDnYeuCauRutHSSauTiepNhan(dnYeuCauRutHS);
        envelope.getBody().setContent(content);

        return envelope;
    }


}