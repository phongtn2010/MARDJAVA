package com.vnsw.ws.p16.message;

import com.vnsw.ws.p16.envelop.Content;
import com.vnsw.ws.p16.envelop.Envelope;
import com.vnsw.ws.p16.message.DNYeuCauRutHS;

import java.util.Date;


/***
 *
 *
 * @Mard016BuildMessageSendType116
 * @class Mard016SendType116
 * Created by Nguyen Van Quang
 * 06/12/2018 16:166:16
 *
 */
public class Mard16SendType11 {

    public static Envelope send(Envelope envelope) {

       DNYeuCauRutHS dnYeuCauRutHS = new DNYeuCauRutHS();
       dnYeuCauRutHS.setFiRequestDate(new Date());
       Content content = new Content();
       content.setFiDNYeuCauRutHS(dnYeuCauRutHS);
       envelope.getBody().setContent(content);

        return envelope;
    }


}