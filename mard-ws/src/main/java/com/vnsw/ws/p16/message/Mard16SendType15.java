package com.vnsw.ws.p16.message;

import com.vnsw.ws.p16.envelop.Content;
import com.vnsw.ws.p16.envelop.Envelope;
import com.vnsw.ws.p16.message.DNYeuCauRutHSSauTiepNhan;
import com.vnsw.ws.p16.model.TbdKetQuaXuLy16;


/***
 *
 *
 * @Mard016BuildMessageSendType116
 * @class Mard016SendType116
 * Created by Nguyen Van Quang
 * 06/12/2018 16:166:16
 *
 */
public class Mard16SendType15 {

    public static Envelope send(Envelope envelope, TbdKetQuaXuLy16 tbdKetQuaXuLy16) {

        DNYeuCauRutHSSauTiepNhan dnYeuCauRutHS = new DNYeuCauRutHSSauTiepNhan();
        dnYeuCauRutHS.setFiRequestDate(tbdKetQuaXuLy16.getFiProcessDate());
        dnYeuCauRutHS.setFiReason(tbdKetQuaXuLy16.getFiContent());
        Content content = new Content();
        content.setFiDnYeuCauRutHSSauTiepNhan(dnYeuCauRutHS);
        envelope.getBody().setContent(content);

        return envelope;
    }


}