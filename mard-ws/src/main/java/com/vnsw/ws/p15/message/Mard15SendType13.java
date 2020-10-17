package com.vnsw.ws.p15.message;

import com.vnsw.ws.common.entity.json.ResponseDownload;
import com.vnsw.ws.p15.component.Mard15DownloadFile;
import com.vnsw.ws.p15.envelop.Content;
import com.vnsw.ws.p15.envelop.Envelope;
import com.vnsw.ws.p15.model.TbdDinhKem15;
import com.vnsw.ws.p15.model.TbdHoSo15;
import com.vnsw.ws.p15.model.TbdKetQuaXuLy15;
import com.vnsw.ws.p15.model.TbdThuoc15;
import org.springframework.beans.BeanUtils;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class Mard15SendType13 {

    public static Envelope send(Envelope envelope, TbdHoSo15 tbdHoSo15, List<TbdThuoc15> tbdThuoc15s, List<TbdDinhKem15> tbdDinhKem15s, TbdKetQuaXuLy15 tbdKetQuaXuLy15, Mard15DownloadFile mard015DownloadFile) {

        Content content = new Content();
        DNYeuCauSuaHS dNYeuCauSuaHS = new DNYeuCauSuaHS();
        Application application = new Application();
        if (!ObjectUtils.isEmpty(tbdHoSo15)) {
            BeanUtils.copyProperties(tbdHoSo15, application);
            dNYeuCauSuaHS.setFiReason(tbdKetQuaXuLy15.getFiContent());
            dNYeuCauSuaHS.setFiRequestDate(tbdKetQuaXuLy15.getFiProcessDate());
        }

        if (!ObjectUtils.isEmpty(tbdThuoc15s)) {
            List<Goods> goodss = new ArrayList();
            for (TbdThuoc15 tbdThuoc15 : tbdThuoc15s) {
                Goods goods = new Goods();
                BeanUtils.copyProperties(tbdThuoc15, goods);
                goodss.add(goods);
            }
            application.setFiGoods(goodss);
        }

        if (!ObjectUtils.isEmpty(tbdDinhKem15s)) {
            List<Attachment> attachments = new ArrayList();
            for (TbdDinhKem15 tbdDinhKem15 : tbdDinhKem15s) {
                Attachment attachment = new Attachment();
                attachment.setFiFileCode(tbdDinhKem15.getFiFileTypeCode());
                attachment.setFiFileName(tbdDinhKem15.getFiFileName());
                ResponseDownload responseDownload = mard015DownloadFile.fileDownload(tbdDinhKem15.getFiPath(), tbdDinhKem15.getFiFileCode());
                if (!ObjectUtils.isEmpty(responseDownload)) {
                    if (!ObjectUtils.isEmpty(responseDownload.getContent())) {
                        attachment.setFiFileByte(Base64.getEncoder().encodeToString(responseDownload.getContent()));
                    }
                }
                attachments.add(attachment);
            }
            dNYeuCauSuaHS.setFiAttachment(attachments);
        }
        dNYeuCauSuaHS.setFiApplication(application);
        content.setFiDNYeuCauSuaHS(dNYeuCauSuaHS);
        envelope.getBody().setContent(content);

        return envelope;
    }


}
