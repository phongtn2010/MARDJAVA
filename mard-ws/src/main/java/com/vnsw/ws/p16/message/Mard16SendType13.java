package com.vnsw.ws.p16.message;

import com.vnsw.ws.common.entity.json.ResponseDownload;
import com.vnsw.ws.p16.component.Mard16DownloadFile;
import com.vnsw.ws.p16.envelop.Content;
import com.vnsw.ws.p16.envelop.Envelope;
import com.vnsw.ws.p16.message.Attachment;
import com.vnsw.ws.p16.message.DNYeuCauSuaHS;
import com.vnsw.ws.p16.message.Goods;
import com.vnsw.ws.p16.model.*;
import org.springframework.beans.BeanUtils;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;

public class Mard16SendType13 {

    public static Envelope send13(Envelope envelope, TbdHoSo16 tbdHoSo16, List<TbdThuoc16> tbdThuoc16s, List<TbdDinhKem16> tbdDinhKem16s, TbdKetQuaXuLy16 tbdKetQuaXuLy16, Mard16DownloadFile mard016DownloadFile,  List<TbdToKhaiKyThuat16> toKhaiKyThuat16s) {

        Content content = new Content();
        DNYeuCauSuaHS dNYeuCauSuaHS = new DNYeuCauSuaHS();

        dNYeuCauSuaHS.setFiReason(tbdKetQuaXuLy16.getFiContent());
        dNYeuCauSuaHS.setFiRequestDate(new Date());

        Application application = new Application();

        if (!ObjectUtils.isEmpty(tbdHoSo16)) {

            BeanUtils.copyProperties(tbdHoSo16, application);

            Purposes purposes = new Purposes();
            purposes.setFiPurposes(tbdHoSo16.getFiPurposes());
            purposes.setFiOtherPurposesValue(tbdHoSo16.getFiOtherPurposesValue());
            application.setFiPurposes(purposes);

            Others others = new Others();
            others.setFiScale(tbdHoSo16.getFiScale());
            others.setFiLocation(tbdHoSo16.getFiLocation());
            application.setFiOthers(others);

            RelatedDocuments relatedDocuments = new RelatedDocuments();
            relatedDocuments.setFiDocument(tbdHoSo16.getFiDocument());
            relatedDocuments.setFiOtherPaperValue(tbdHoSo16.getFiOtherPaperValue());
            application.setFiRelatedDocuments(relatedDocuments);

            Sign sign = new Sign();
            BeanUtils.copyProperties(tbdHoSo16, sign);
            application.setFiSign(sign);

            if (!ObjectUtils.isEmpty(tbdThuoc16s)) {
                List<Goods> goodss = new ArrayList();
                for (TbdThuoc16 tbdThuoc16 : tbdThuoc16s) {
                    Goods goods = new Goods();
                    BeanUtils.copyProperties(tbdThuoc16, goods);
                    goodss.add(goods);
                }
                application.setFiGoods(goodss);
            }

            if (!ObjectUtils.isEmpty(tbdDinhKem16s)) {
                List<Attachment> attachments = new ArrayList();
                for (TbdDinhKem16 tbdDinhKem16 : tbdDinhKem16s) {
                    Attachment attachment = new Attachment();
                    attachment.setFiFileCode(tbdDinhKem16.getFiFileTypeCode());
                    attachment.setFiFileName(tbdDinhKem16.getFiFileName());
                    ResponseDownload responseDownload = mard016DownloadFile.fileDownload(tbdDinhKem16.getFiPath(), tbdDinhKem16.getFiFileCode());
                    if (!ObjectUtils.isEmpty(responseDownload)) {
                        if (!ObjectUtils.isEmpty(responseDownload.getContent())) {
                            attachment.setFiFileByte(Base64.getEncoder().encodeToString(responseDownload.getContent()));
                        }
                    }

                    attachments.add(attachment);
                }
                application.setFiAttachment(attachments);
            }

            if (!ObjectUtils.isEmpty(toKhaiKyThuat16s)) {

                List<TechnicalDeclaration> technicalDeclarationList = new ArrayList();
                for (TbdToKhaiKyThuat16 tbdToKhaiKyThuat16 : toKhaiKyThuat16s) {
                    TechnicalDeclaration technicalDeclaration = new TechnicalDeclaration();
                    BeanUtils.copyProperties(tbdToKhaiKyThuat16, technicalDeclaration);
                    technicalDeclarationList.add(technicalDeclaration);
                }
                dNYeuCauSuaHS.setFiTechnicalDeclarations(technicalDeclarationList);
            }
        }

        dNYeuCauSuaHS.setFiApplication(application);
        content.setFiDNYeuCauSuaHS(dNYeuCauSuaHS);
        envelope.getBody().setContent(content);

        return envelope;
    }


}
