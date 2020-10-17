package com.vnsw.ws.p14.message;

import com.vnsw.ws.p14.envelop.Content;
import com.vnsw.ws.p14.envelop.Envelope;

import java.util.Date;


/***
 *
 *
 * @Mard014BuildMessageSendType114
 * @class Mard014SendType114
 * Created by Nguyen Van Quang
 * 06/12/2018 15:146:15
 *
 */
public class Mard14SendType11 {

    public static Envelope send(Envelope envelope) {

       DNYeuCauRutHS dnYeuCauRutHS = new DNYeuCauRutHS();
       dnYeuCauRutHS.setFiRequestDate(new Date());
       Content content = new Content();
       content.setFiDNYeuCauRutHS(dnYeuCauRutHS);
       envelope.getBody().setContent(content);

        return envelope;
    }


}