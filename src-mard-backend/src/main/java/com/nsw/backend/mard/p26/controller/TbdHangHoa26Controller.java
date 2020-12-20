package com.nsw.backend.mard.p26.controller;

import com.nsw.backend.controller.BaseController;
import com.nsw.backend.mard.p25.constant.Constant25;
import com.nsw.backend.mard.p25.dto.FilterFormHangHoa26;
import com.nsw.backend.mard.p25.dto.FilterFormHangHoaMK25;
import com.nsw.backend.mard.p25.dto.FilterResultHangHoaMK25;
import com.nsw.backend.mard.p25.model.TbdHanghoa25;
import com.nsw.backend.mard.p25.model.TbdHoso25;
import com.nsw.backend.mard.p25.service.TbdHangHoa25Service;
import com.nsw.backend.mard.p25.service.TbdHanghoaMK25Service;
import com.nsw.backend.mard.p25.service.TbdHoso25Service;
import com.nsw.backend.mard.p26.constant.Constant26;
import com.nsw.backend.mard.p26.model.FilterResultHH;
import com.nsw.backend.mard.p26.model.TbdHanghoa26;
import com.nsw.backend.util.ResponseJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/mard/26/hanghoa")
public class TbdHangHoa26Controller extends BaseController {
    private static final Logger LOG = LoggerFactory.getLogger(TbdHangHoa26Controller.class);
    private static final String TAG = "TbdHangHoa26Controller";
    private final TbdHangHoa25Service tbdHangHoa25Service;
    private final TbdHanghoaMK25Service tbdHanghoaMK25Service;
    private final TbdHoso25Service tbdHoso25Service;

    public TbdHangHoa26Controller(TbdHangHoa25Service tbdHangHoa25Service, TbdHoso25Service tbdHoso25Service, TbdHanghoaMK25Service tbdHanghoaMK25Service) {
        this.tbdHangHoa25Service = tbdHangHoa25Service;
        this.tbdHoso25Service = tbdHoso25Service;
        this.tbdHanghoaMK25Service = tbdHanghoaMK25Service;
    }

    @RequestMapping(value = "/getlist", method = RequestMethod.POST)
    public ResponseEntity<ResponseJson> getListByFilter(@RequestBody FilterFormHangHoaMK25 filter) {
        try {
//            List<TbdHanghoa26> tbdHanghoa26List = getListHangHoaMienKiem(filterFormHangHoa26.getTaxCode());
//            FilterResultHH filterResultHH = new FilterResultHH();
//            filterResultHH.setPage(filterFormHangHoa26.getPage() == 0 ? 0 : filterFormHangHoa26.getPage() - 1);
//            filterResultHH.setSize(filterFormHangHoa26.getSize());
//            if (!tbdHanghoa26List.isEmpty()&&null!=tbdHanghoa26List){
//                Integer from=filterResultHH.getPage() * filterResultHH.getSize();
//                Integer to=filterResultHH.getPage() * filterResultHH.getSize()+filterResultHH.getSize();
//                filterResultHH.setData(
//                        tbdHanghoa26List.subList(from,to));
//            }else {
//                filterResultHH.setData(new ArrayList<>());
//            }
//            filterResultHH.setTotal(tbdHanghoa26List.size());
            FilterResultHangHoaMK25 result = tbdHanghoaMK25Service.searchHanghoaMK25(filter);
            return createSuccessResponse(result,HttpStatus.OK);
        }catch (Exception e){
            LOG.error(e.getMessage());
            return createErrorResponse(e.getMessage(),HttpStatus.OK);
        }
    }

    private List<TbdHanghoa26> getListHangHoaMienKiem(String taxCode) {
        List<TbdHanghoa26> lstHangHoaMienKiem = new ArrayList<>();
//        List<TbdHanghoa25> lstHangHoaTACN = tbdHangHoa25Service.findByFiTaxCodeAndFiTrangThaiHangHoa(taxCode,44);
//        if(!lstHangHoaTACN.isEmpty()&&null!=lstHangHoaTACN){
//            lstHangHoaTACN.forEach(tbdHanghoa25->{
//                TbdHanghoa26 tbdHanghoa26 = new TbdHanghoa26();
//                BeanUtils.copyProperties(tbdHanghoa25,tbdHanghoa26);
//                lstHangHoaMienKiem.add(tbdHanghoa26);
//            });
//        }
//        lstHangHoaMienKiem.forEach(tbdHanghoa26->{
//            TbdHoso25 result = tbdHoso25Service.findById(tbdHanghoa26.getFiIdHS());
//            if(result!=null){
//                tbdHanghoa26.setFiNSWFileCode(result.getFiNSWFileCode());
//            }
//        });
        //Loai 2a
        List<TbdHoso25> listHoso2A = tbdHoso25Service.findByFiTaxCodeAndFiActiveAndFiHSStatusAndFiHSType(taxCode, Constant26._ACTIVE, Constant25.HosoStatus.DA_XAC_NHAN_GDK.getId(), Constant25.HosoType._2A.getId());
        List<TbdHoso25> listHoso2B = tbdHoso25Service.findByFiTaxCodeAndFiActiveAndFiHSStatusAndFiHSType(taxCode, Constant26._ACTIVE, Constant25.HosoStatus.DA_XAC_NHAN_GDK.getId(), Constant25.HosoType._2B.getId());
        List<TbdHoso25> listHoso2C = tbdHoso25Service.findByFiTaxCodeAndFiActiveAndFiHSStatusAndFiHSType(taxCode, Constant26._ACTIVE, Constant25.HosoStatus.DA_XAC_NHAN_GDK.getId(), Constant25.HosoType._2C.getId());
        //2A,2B thi xu ly chung
        listHoso2A.addAll(listHoso2B);
        List<TbdHoso25> listHoso2AB = listHoso2A;
        if (!listHoso2AB.isEmpty() || null != listHoso2AB) {
            listHoso2AB.forEach(tbdHoso25 -> {
                List<TbdHanghoa25> listHangHoa25 = tbdHoso25.getFiProductList();
                listHangHoa25.forEach(hanghoa25 -> {
                    if (hanghoa25.getFiTrangThaiHangHoa() != null && hanghoa25.getFiTrangThaiHangHoa() == Constant25.HosoStatus.DA_TIEP_NHAN_KQ_DANH_GIA_SPH.getId()) {
                        TbdHanghoa26 tbdHanghoa26 = new TbdHanghoa26();
                        BeanUtils.copyProperties(hanghoa25, tbdHanghoa26);
                        tbdHanghoa26.setFiNSWFileCode(tbdHoso25.getFiNSWFileCode());
                        lstHangHoaMienKiem.add(tbdHanghoa26);
                    }
                });
            });
        }
        //2C
        if (!listHoso2C.isEmpty() || null != listHoso2C) {
            listHoso2C.forEach(tbdHoso25 -> {
                List<TbdHanghoa25> listHangHoa25 = tbdHoso25.getFiProductList();
                listHangHoa25.forEach(hanghoa25 -> {
                    if (hanghoa25.getFiTrangThaiHangHoa() != null && hanghoa25.getFiTrangThaiHangHoa() == Constant25.HosoStatus.DA_CAP_THONG_BAO_KQKT.getId()) {
                        TbdHanghoa26 tbdHanghoa26 = new TbdHanghoa26();
                        BeanUtils.copyProperties(hanghoa25, tbdHanghoa26);
                        tbdHanghoa26.setFiNSWFileCode(tbdHoso25.getFiNSWFileCode());
                        lstHangHoaMienKiem.add(tbdHanghoa26);
                    }
                });
            });
        }
        return lstHangHoaMienKiem;
    }
}
