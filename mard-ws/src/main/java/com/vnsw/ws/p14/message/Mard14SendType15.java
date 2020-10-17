package com.vnsw.ws.p14.message;

import com.vnsw.ws.p14.envelop.Content;
import com.vnsw.ws.p14.envelop.Envelope;
import com.vnsw.ws.p14.model.TbdKetQuaXuLy14;


/***
 *
 *
 * @Mard014BuildMessageSendType114
 * @class Mard014SendType114
 * Created by Nguyen Van Quang
 * 06/12/2018 15:146:15
 *
 */
public class Mard14SendType15 {

    public static Envelope send(Envelope envelope, TbdKetQuaXuLy14 tbdKetQuaXuLy14) {

        DNYeuCauRutHSSauTiepNhan dnYeuCauRutHS = new DNYeuCauRutHSSauTiepNhan();
        dnYeuCauRutHS.setFiRequestDate(tbdKetQuaXuLy14.getFiProcessDate());
        dnYeuCauRutHS.setFiReason(tbdKetQuaXuLy14.getFiContent());
        Content content = new Content();
        content.setFiDnYeuCauRutHSSauTiepNhan(dnYeuCauRutHS);
        envelope.getBody().setContent(content);

        return envelope;
    }


}