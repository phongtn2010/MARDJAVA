package com.vnsw.ws.p14.message;

import com.vnsw.ws.common.entity.json.ResponseDownload;
import com.vnsw.ws.p14.component.Mard14DownloadFile;
import com.vnsw.ws.p14.envelop.Content;
import com.vnsw.ws.p14.envelop.Envelope;
import com.vnsw.ws.p14.model.TbdThanhToan14;
import org.springframework.beans.BeanUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.Base64;

public class Mard14SendType18 {

    public static Envelope send(Envelope envelope, TbdThanhToan14 tbdThanhToan14, Mard14DownloadFile mard014DownloadFile) {

        ThongBaoChuyenKhoan thongBaoChuyenKhoan = new ThongBaoChuyenKhoan();
        BeanUtils.copyProperties(tbdThanhToan14, thongBaoChuyenKhoan);
        if (StringUtils.hasText(tbdThanhToan14.getFiPath()) && StringUtils.hasText(tbdThanhToan14.getFiFileName()) && StringUtils.hasText(tbdThanhToan14.getFiFileCode())) {
            ResponseDownload responseDownload = mard014DownloadFile.fileDownload(tbdThanhToan14.getFiPath(), tbdThanhToan14.getFiFileCode());
            if (!ObjectUtils.isEmpty(responseDownload)) {
                if (!ObjectUtils.isEmpty(responseDownload.getContent())) {
                    Attach attach = new Attach();
                    attach.setFiFileName(tbdThanhToan14.getFiFileName());
                    attach.setFiFileByte(Base64.getEncoder().encodeToString(responseDownload.getContent()));
                    thongBaoChuyenKhoan.setFiAttach(attach);
                }
            }
        }
        Content content = new Content();
        content.setFiThongBaoChuyenKhoan(thongBaoChuyenKhoan);
        envelope.getBody().setContent(content);

        return envelope;
    }
}
