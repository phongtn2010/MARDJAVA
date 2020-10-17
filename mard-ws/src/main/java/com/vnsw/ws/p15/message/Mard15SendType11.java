package com.vnsw.ws.p15.message;

import com.vnsw.ws.p15.envelop.Content;
import com.vnsw.ws.p15.envelop.Envelope;

import java.util.Date;


/***
 *
 *
 * @Mard015BuildMessageSendType115
 * @class Mard015SendType115
 * Created by Nguyen Van Quang
 * 06/12/2018 15:156:15
 *
 */
public class Mard15SendType11 {

    public static Envelope send(Envelope envelope) {

       DNYeuCauRutHS dnYeuCauRutHS = new DNYeuCauRutHS();
       dnYeuCauRutHS.setFiRequestDate(new Date());
       Content content = new Content();
       content.setFiDNYeuCauRutHS(dnYeuCauRutHS);
       envelope.getBody().setContent(content);

        return envelope;
    }


}