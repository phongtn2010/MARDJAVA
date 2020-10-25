package com.nsw.backend.mard.p25.dto;


import com.nsw.backend.mard.p25.constant.Constant25;
import com.nsw.backend.mard.p25.model.TbdHanghoa25;
import com.nsw.backend.mard.p25.model.TbdHoso25;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Data
public class Hoso25 {

    String fiNSWFileCode;


    String fiNSWFileCodeOld;

    String fiGDK;

    String fiGDKId;

    String fiGDKName;

    String fiGDKLink;

    String DepartmentCode;

    String DepartmentName;

    String fiSellName;

    String fiSellCountryName;

    String fiSellCountryCode;

    String fiSellAddress;

    String fiSellTel;

    String fiSellFax;

    String fiSellExport;

    String fiPurchName;

    String fiPurchAddress;

    String fiPurchTel;

    String fiPurchFax;

    String fiPurchReci;

    Date fiPurchFromDate;

    Date fiPurchToDate;

    Date fiHSCreatedDate;

    String fiSignAddress;

    String fiSignName;

    String fiTaxCode;

    String fiHSType;


    Integer fiProductType;

    List<TbdHanghoa25> fiProductList;

    private String fiAddressGath;

    private Date fiRegSamFromDate;

    private Date fiRegSamToDate;

    private String fiAddressRegSample;

    private String fiContactName;

    private String fiContactAddress;

    private String fiContactTel;

    private String fiContactEmail;



    private List<TbdattachHoadon25> fiListAttchHoaDon;

    private List<TbdattachHd25> fiListAttchHD;

    private List<TbdattachDg25> fiListAttchPhieu;
    private List<Tbdattach25> fiAttach;
    public static Hoso25 parseToWSEntity(TbdHoso25 hoso25){
        Hoso25 profile= new Hoso25();
        profile.setFiListAttchHD(new ArrayList<TbdattachHd25>());
        profile.setFiListAttchHoaDon(new ArrayList<TbdattachHoadon25>());
        profile.setFiListAttchPhieu(new ArrayList<TbdattachDg25>());
        profile.setFiAttach(new ArrayList<Tbdattach25>());
        BeanUtils.copyProperties(hoso25, profile);
        //Hop dong
        hoso25.getFiAttachmentList().forEach(atch -> {

            if(atch.getFiFileTypeID()== Constant25.FILE_DINHKEM_TYPE.HOP_DONG){
                TbdattachHd25 hopDong = new TbdattachHd25();
                hopDong.setFiSoHd(atch.getFiFileHD());
                hopDong.setFiNgayHd(atch.getFiFileHDDate());
                hopDong.setFiIdFile(atch.getFiGuidBNN());
                hopDong.setFiFileName(atch.getFiFileName());
                hopDong.setFiFileLink(atch.getFiLinkBNN());
                profile.getFiListAttchHD().add(hopDong);
            }




            else if(atch.getFiFileTypeID()== Constant25.FILE_DINHKEM_TYPE.HOA_DON){
                //hoad don
                TbdattachHoadon25 hoadon=new TbdattachHoadon25();
                hoadon.setFiSoHoadon(atch.getFiFileHD());
                hoadon.setFiNgayHoadon(atch.getFiFileHDDate());
                hoadon.setFiFileId(atch.getFiGuidBNN());
                hoadon.setFiFileName(atch.getFiFileName());
                hoadon.setFiFileLink(atch.getFiLinkBNN());
                profile.getFiListAttchHoaDon().add(hoadon);
            }



            else if(atch.getFiFileTypeID()== Constant25.FILE_DINHKEM_TYPE.PHIEU_DG){
                //phieu
                TbdattachDg25 phieu=new TbdattachDg25();
                phieu.setFiSoPhieu(atch.getFiFileHD());
                phieu.setFiNgayPhieu(atch.getFiFileHDDate());
                phieu.setFiFileId(atch.getFiGuidBNN());
                phieu.setFiFileName(atch.getFiFileName());
                phieu.setFiFileLink(atch.getFiLinkBNN());
                profile.getFiListAttchPhieu().add(phieu);
            }else{
                //con lai
                Tbdattach25 tbdattach25= new Tbdattach25();
                tbdattach25.setFiLoaifile(atch.getFiFileTypeID().toString());
                tbdattach25.setFiFileId(atch.getFiGuidBNN());
                tbdattach25.setFiFileName(atch.getFiFileName());
                tbdattach25.setFiFileLink(atch.getFiLinkBNN());
                profile.getFiAttach().add(tbdattach25);
            }



        });

        return profile;
    }
}
