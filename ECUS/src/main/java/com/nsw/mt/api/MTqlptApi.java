/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.mt.api;

import com.nsw.api.BaseApi;
import com.nsw.common.model.json.ResponseJson;
import com.nsw.constant.AppConstant;
import com.nsw.helper.BackendRequestHelper;
import com.nsw.helper.RabbitMQErrorHelper;

import com.nsw.mt.constant.MTqlptConstant;
import com.nsw.mt.qlpt.model.FilterForm;
import com.nsw.mt.qlpt.model.TbdqlPhuongtien;
import com.nsw.util.LogUtil;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mt/qlpt")
public class MTqlptApi extends BaseApi {

    static final String TAG = "MTqlptApi";

    @Autowired
    Environment environment;

    /**
     * Ham lay danh muc
     *
     * @param key
     * @param id
     * @return
     */
    @RequestMapping(value = "/danhmuc", method = RequestMethod.POST)
    public @ResponseBody
    ResponseJson getCategory(
            @RequestParam("key") String key,
            @RequestParam(name = "id", required = false) String id
    ) {
        ResponseJson json = null;
        try {
            switch (key) {
                case MTqlptConstant.DANHMUC.PT_LOAIHINH:
                    json = BackendRequestHelper.getInstance().doGetRequest(MTqlptConstant.getInstance().getApiUrl(environment, MTqlptConstant.API.DANHMUC_LAOIHINH));
                    break;
                case MTqlptConstant.DANHMUC.PT_MAUSON:
                    json = BackendRequestHelper.getInstance().doGetRequest(MTqlptConstant.getInstance().getApiUrl(environment, MTqlptConstant.API.DANHMUC_MAUSON));
                    break;
                case MTqlptConstant.DANHMUC.PT_NHANHIEU:
                    json = BackendRequestHelper.getInstance().doGetRequest(MTqlptConstant.getInstance().getApiUrl(environment, MTqlptConstant.API.DANHMUC_NHANHIEU));
                    break;
                case MTqlptConstant.DANHMUC.PT_QUOCGIA:
                    json = BackendRequestHelper.getInstance().doGetRequest(MTqlptConstant.getInstance().getApiUrl(environment, MTqlptConstant.API.DANHMUC_QUOCGIA));
                    break;

                default:
                    break;
            }
            return json;
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
        return null;
    }

    /**
     * Ham tim kiem theo dieu kien dau vao tu nguoi dung
     *
     * @param filter
     * @return
     */
    @RequestMapping(value = "/phuongtien/search", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson searchPhuongtien(
            @RequestBody FilterForm filter
    ) {
        try {
            //filter.setNguoiTao(getUsername());
            ResponseJson json = BackendRequestHelper.getInstance().doPostRequest(MTqlptConstant.getInstance().getApiUrl(environment, MTqlptConstant.API.PHUONGTIEN_SEARCH), filter);
            return json;
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }

        return null;
    }

    /**
     * *
     * Ham kiem tra phan quyen du lieu
     *
     * @param fipPhuongtien
     * @return
     */
    private boolean isOwner(Object fipPhuongtien) {
        ResponseJson json = BackendRequestHelper.getInstance().doGetRequest(MTqlptConstant.getInstance().getApiUrl(environment, MTqlptConstant.API.PHUONGTIEN_OWNER) + fipPhuongtien + "/" + getUsername());
        return json != null && Boolean.parseBoolean(json.getData().toString());
    }

    /**
     * Xoa phuong tien
     *
     * @param fiIdPhuongtien
     * @return
     */
    @RequestMapping(value = "/phuongtien/xoa/{fiIdPhuongtien}", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson deletepPhuongtien(
            @PathVariable Long fiIdPhuongtien
    ) {
        if (fiIdPhuongtien == null || !isOwner(fiIdPhuongtien)) {
            return null;
        }
        HashMap map = new HashMap();
        ResponseJson json = BackendRequestHelper.getInstance().doPostRequest(MTqlptConstant.getInstance().getApiUrl(environment, MTqlptConstant.API.PHUONGTIEN_DELETE) + "/" + fiIdPhuongtien, map);
        return json;
    }

    /**
     * Lay chi tiet phuong tien
     *
     * @param fiIdPhuongtien
     * @return
     */
    @RequestMapping(value = "/phuongtien/t/{fiIdPhuongtien}", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson getpPhuongtien(
            @PathVariable Long fiIdPhuongtien
    ) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        try {
            String url = MTqlptConstant.getInstance().getApiUrl(environment, MTqlptConstant.API.PHUONGTIEN_GET_BYIDPHUONGTIEN);
            json = BackendRequestHelper.getInstance().doGetRequest(url + fiIdPhuongtien);
//            if (json != null && (LinkedHashMap) json.getData() != null) {
//                if (!getUsername().equals(((LinkedHashMap) json.getData()).get("fiNguoitao"))) {
//                    return null;
//                }
//            }
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
        return json;
    }

    /**
     * Tao moi phuong tien
     *
     * @param tbdqlPhuongtien
     * @return
     */
    @RequestMapping(value = "/phuongtien/taomoi", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson createHoso(
            @RequestBody TbdqlPhuongtien tbdpPhuongtien
    ) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        try {
            // Bắt đầu gọi backend để thêm mới
            if (tbdpPhuongtien != null) {
                tbdpPhuongtien.setFiNguoitao(getUsername());
                tbdpPhuongtien.setFiNgaytao(new Date());
            }
            json = BackendRequestHelper.getInstance().doPostRequest(MTqlptConstant.getInstance().getApiUrl(environment, MTqlptConstant.API.PHUONGTIEN_INSERT), tbdpPhuongtien);

        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
        return json;
    }

    /**
     * Cap nhat phuong tien
     *
     * @param tbdqlPhuongtien
     * @return
     */
    @RequestMapping(value = "/phuongtien/capnhap", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public @ResponseBody
    ResponseJson updatepPhuongtien(
            @RequestBody TbdqlPhuongtien tbdpPhuongtien
    ) {
        ResponseJson json = new ResponseJson();
        json.setSuccess(false);
        try {

            if (tbdpPhuongtien == null || !isOwner(tbdpPhuongtien.getFiIdXe())) {
                return json;
            }else{
                tbdpPhuongtien.setFiNgCapnhat(new Date());
            }
            

            json = BackendRequestHelper.getInstance().doCustomRequest(MTqlptConstant.getInstance().getApiUrl(environment, MTqlptConstant.API.PHUONGTIEN_UPDATE), HttpMethod.PUT, tbdpPhuongtien, new HashMap<>());
        } catch (Exception ex) {
            LogUtil.addLog(ex);
            String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + TAG + AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName() + AppConstant.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, getRabbitMQ());
        }
        return json;
    }

}
