package com.vnsw.ws.p16.message;

import com.vnsw.ws.common.entity.json.ResponseDownload;
import com.vnsw.ws.p16.component.Mard16DownloadFile;
import com.vnsw.ws.p16.envelop.Content;
import com.vnsw.ws.p16.envelop.Envelope;
import com.vnsw.ws.p16.model.TbdDinhKem16;
import com.vnsw.ws.p16.model.TbdHoSo16;
import com.vnsw.ws.p16.model.TbdThuoc16;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import com.vnsw.ws.p16.model.TbdToKhaiKyThuat16;
import org.springframework.beans.BeanUtils;
import org.springframework.util.ObjectUtils;


/***
*
*
* @Mard016BuildMessageSendType10
* @class Mard016SendType10
* Created by Nguyen Van Quang
* 06/12/2018 16:166:16
*
*/
public class Mard16SendType10 {

	public static Envelope sendType10(Envelope envelope, TbdHoSo16 tbdHoSo16, List<TbdThuoc16> tbdThuoc16s, List<TbdDinhKem16> tbdDinhKem16s, Mard16DownloadFile mard016DownloadFile, List<TbdToKhaiKyThuat16> toKhaiKyThuat16s) {

		Content content = new Content();
		DNDangKyHoSo dNDangKyHoSo = new DNDangKyHoSo();
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
				dNDangKyHoSo.setFiTechnicalDeclarations(technicalDeclarationList);
			}
		}

		dNDangKyHoSo.setFiApplication(application);
		content.setFiDNDangKyHoSo(dNDangKyHoSo);
		envelope.getBody().setContent(content);

		return envelope;
	}


}