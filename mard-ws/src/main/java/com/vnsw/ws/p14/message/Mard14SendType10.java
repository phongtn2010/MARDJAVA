package com.vnsw.ws.p14.message;

import com.vnsw.ws.common.entity.json.ResponseDownload;
import com.vnsw.ws.p14.component.Mard14DownloadFile;
import com.vnsw.ws.p14.envelop.Content;
import com.vnsw.ws.p14.envelop.Envelope;
import com.vnsw.ws.p14.model.TbdDinhKem14;
import com.vnsw.ws.p14.model.TbdHoSo14;
import com.vnsw.ws.p14.model.TbdThuoc14;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.util.ObjectUtils;


/***
*
*
* @Mard014BuildMessageSendType10
* @class Mard014SendType10
* Created by Nguyen Van Quang
* 06/12/2018 15:146:15
*
*/
public class Mard14SendType10 {

	public static Envelope send(Envelope envelope, TbdHoSo14 tbdHoSo14, List<TbdThuoc14> tbdThuoc14s, List<TbdDinhKem14> tbdDinhKem14s, Mard14DownloadFile mard014DownloadFile) {

		Content content = new Content();
		DNDangKyHoSo dNDangKyHoSo = new DNDangKyHoSo();
		if (!ObjectUtils.isEmpty(tbdHoSo14)) {
			BeanUtils.copyProperties(tbdHoSo14, dNDangKyHoSo);
		}

		if (!ObjectUtils.isEmpty(tbdThuoc14s)) {
			List<Goods> goodss = new ArrayList();
			for (TbdThuoc14 tbdThuoc14 : tbdThuoc14s) {
				Goods goods = new Goods();
				BeanUtils.copyProperties(tbdThuoc14, goods);
				goodss.add(goods);
			}
			dNDangKyHoSo.setFiGoods(goodss);
		}

		if (!ObjectUtils.isEmpty(tbdDinhKem14s)) {
			List<Attachment> attachments = new ArrayList();
			for (TbdDinhKem14 tbdDinhKem14 : tbdDinhKem14s) {
				Attachment attachment = new Attachment();
				attachment.setFiFileCode(tbdDinhKem14.getFiFileTypeCode());
				attachment.setFiFileName(tbdDinhKem14.getFiFileName());
				ResponseDownload responseDownload = mard014DownloadFile.fileDownload(tbdDinhKem14.getFiPath(), tbdDinhKem14.getFiFileCode());
				if (!ObjectUtils.isEmpty(responseDownload)) {
					if (!ObjectUtils.isEmpty(responseDownload.getContent())) {
						attachment.setFiFileByte(Base64.getEncoder().encodeToString(responseDownload.getContent()));
					}
				}

				attachments.add(attachment);
			}
			dNDangKyHoSo.setFiAttachment(attachments);
		}
		content.setFiDNDangKyHoSo(dNDangKyHoSo);
		envelope.getBody().setContent(content);

		return envelope;
	}


}