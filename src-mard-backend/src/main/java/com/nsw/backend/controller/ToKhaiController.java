package com.nsw.backend.controller;

import com.nsw.backend.helper.RabbitMQErrorHelper;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.nsw.backend.service.RabbitMQService;
import com.nsw.backend.tokhai.model.*;
import com.nsw.backend.util.Constants;
import com.nsw.backend.util.ResponseJson;
import javax.xml.XMLConstants;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

@RestController
@RequestMapping("/tokhai")
public class ToKhaiController {

    private static final String CLASS_NAME = "ToKhaiController";
    public static final Logger logger = LoggerFactory.getLogger(ToKhaiController.class);

    @Autowired
    RabbitMQService rabbitMQService;
    @Autowired
    private Environment environment;

    @RequestMapping(value = "/data/", method = RequestMethod.POST)
    public ResponseEntity<ResponseJson> data(@RequestBody TokhaiRequest tokhaiRequest) {
        HttpStatus httpStatus = null;
        String errorMessage = "";
        boolean isSuccess = false;
        httpStatus = HttpStatus.OK;
        TokhaiResponse obj = null;
        try {
            logger.info("/data/, method = POST");
            obj = getTokhai(tokhaiRequest);
            isSuccess = true;
        } catch (Exception ex) {
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + ex.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
        }
        return createResponse(obj, isSuccess, errorMessage, httpStatus, null);

    }

    private TokhaiResponse getTokhai(TokhaiRequest tokhaiRequest) {

        TokhaiResponse obj = new TokhaiResponse();
        try {
            String xmlInput = createSoapMessage(tokhaiRequest);
            String soapAction = "http://tempuri.org/IServiceTCTKHQ/TOKHAIHQ_Search";
            String xmlOuput = sendSoapMessage(xmlInput, environment.getRequiredProperty("URI_ADDRESS_TOKHAI_SERVER"),
                    soapAction);
            Document document = parseXmlFile(xmlOuput);
            obj = taoTokhaiResponse(document);

            // Lay thong tin hang hoa
            xmlInput = createSoapMessageHh(obj.getTkid(), tokhaiRequest.getMahq(), tokhaiRequest.getNamdk());
            soapAction = "http://tempuri.org/IServiceTCTKHQ/HANGHOAHQ_Search";
            xmlOuput = sendSoapMessage(xmlInput, environment.getRequiredProperty("URI_ADDRESS_TOKHAI_SERVER"),
                    soapAction);
            document = parseXmlFile(xmlOuput);
            List<HanghoaResponse> lstHanghoa = taodsHanghoaResponse(document);
            obj.setLstHanghoa(lstHanghoa);

            // Lay thong tin don vi
            xmlInput = createSoapMessageSDonVi(obj.getMalh());
            soapAction = "http://tempuri.org/IServiceTCTKHQ/NSW_SDonVi_SelectItem";
            xmlOuput = sendSoapMessage(xmlInput, environment.getRequiredProperty("URI_ADDRESS_TOKHAI_SERVER"),
                    soapAction);
            document = parseXmlFile(xmlOuput);
            if (true) {
            }

        } catch (Exception e) {
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + e.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
        }
        return obj;
    }

    /**
     * Tao danh sach hang hoa tu danh sach tra ve cua ws
     *
     * @param document
     * @return
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    private List<HanghoaResponse> taodsHanghoaResponse(Document document) {
        List<HanghoaResponse> lst = new ArrayList();
        HanghoaResponse obj = null;
        NodeList sttHangLst = document.getElementsByTagName("STT_Hang");
        NodeList maHangLst = document.getElementsByTagName("Ma_Hang");
        NodeList tenHangLst = document.getElementsByTagName("Ten_Hang");
        NodeList maQlLst = document.getElementsByTagName("Ma_QL");
        NodeList luongLst = document.getElementsByTagName("Luong");
        NodeList maDvtLst = document.getElementsByTagName("Ma_DVT");
        NodeList triGiaLst = document.getElementsByTagName("Tri_Gia_TT");
        NodeList nuocXxLst = document.getElementsByTagName("Nuoc_XX");
        if (sttHangLst != null && sttHangLst.getLength() > 0) {
            for (int i = 0; i < sttHangLst.getLength(); i++) {
                obj = new HanghoaResponse();
                obj.setSttHang(sttHangLst.item(i).getTextContent().trim());
                obj.setMaHang(maHangLst.item(i).getTextContent().trim());
                obj.setTenHang(tenHangLst.item(i).getTextContent().trim());
                obj.setMaQl(maQlLst.item(i).getTextContent().trim());
                obj.setLuong(luongLst.item(i).getTextContent().trim());
                obj.setMaDvt(maDvtLst.item(i).getTextContent().trim());
                obj.setTriGia(triGiaLst.item(i).getTextContent().trim());
                obj.setNuocXx(nuocXxLst.item(i).getTextContent().trim());
                lst.add(obj);
            }
        }
        return lst;
    }

    /**
     * Send Soap Message
     *
     * @param xmlInput
     * @return
     */
    private String sendSoapMessage(String xmlInput, String link, String soapAction) {
        InputStreamReader isr = null;
        BufferedReader in = null;
        OutputStream out = null;
        String outputString = "";
        URL url;
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        String proxyEnable = environment.getRequiredProperty("PROXY_ENABLE");
        String proxyAddress = environment.getRequiredProperty("PROXY_ADDRESS");
        String proxyPort = environment.getRequiredProperty("PROXY_PORT");
        try {
            URLConnection connection = null;
            url = new URL(link);
            if ("1".equals(proxyEnable)) {
                Proxy proxy = new Proxy(Proxy.Type.HTTP,
                        new InetSocketAddress(proxyAddress, Integer.valueOf(proxyPort)));
                connection = url.openConnection(proxy);
            } else {
                connection = url.openConnection();
            }

            HttpURLConnection httpConn = (HttpURLConnection) connection;
            byte[] buffer = new byte[xmlInput.length()];
            buffer = xmlInput.getBytes();
            bout.write(buffer);
            byte[] b = bout.toByteArray();

            httpConn.setRequestProperty("Content-Length", String.valueOf(b.length));
            httpConn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
            httpConn.setRequestProperty("SOAPAction", soapAction);
            httpConn.setRequestMethod("POST");
            httpConn.setDoOutput(true);
            httpConn.setDoInput(true);
            out = httpConn.getOutputStream();

            out.write(b);

            isr = new InputStreamReader(httpConn.getInputStream());
            in = new BufferedReader(isr);

            String bufferStr = "";
            // Write the SOAP message response to a String.
            while ((bufferStr = in.readLine()) != null) {
                outputString = outputString + bufferStr;
            }
        } catch (Exception e) {
            String errorInfo = Constants.APP_NAME + Constants.MESSAGE_SEPARATOR + CLASS_NAME
                    + Constants.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + Constants.MESSAGE_SEPARATOR + e.toString();
            RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, rabbitMQService.getRabbitMQInfo());
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    logger.error(e.getMessage());
                }
            }
            if (isr != null) {
                try {
                    isr.close();
                } catch (IOException e) {
                    logger.error(e.getMessage());
                }
            }
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    logger.error(e.getMessage());
                }
            }
        }
        return outputString;

    }

    /**
     * Tạo bản tin SOAP
     *
     * @param tokhaiRequest
     * @return
     */
    private String createSoapMessage(TokhaiRequest tokhaiRequest) {
        String xmlInput = " <soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\n"
                + "<soapenv:Header/>\n" + " <soapenv:Body>\n" + " <tem:TOKHAIHQ_Search>\n" + " <!--Optional:-->\n"
                + " <tem:so_TK_VNACCS>" + tokhaiRequest.getSotk() + "</tem:so_TK_VNACCS>\n" + " <!--Optional:-->"
                + "  <tem:MaHQ>" + tokhaiRequest.getMahq() + "</tem:MaHQ>\n" + "  <!--Optional:-->" + " <tem:NameDK>"
                + tokhaiRequest.getNamdk() + "</tem:NameDK>\n" + "  <!--Optional:-->" + "  <tem:MST>"
                + tokhaiRequest.getMst() + "</tem:MST>\n" + " </tem:TOKHAIHQ_Search>\n" + " </soapenv:Body>\n"
                + "</soapenv:Envelope>\n";
        return xmlInput;
    }

    /**
     * Tạo bản tin SOAP hàng hóa
     *
     * @param tokhaiRequest
     * @return
     */
    private String createSoapMessageHh(String tkId, String maHq, String namDk) {
        String xmlInput = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\n"
                + " <soapenv:Header/>\n" + " <soapenv:Body>\n" + " <tem:HANGHOAHQ_Search>\n" + " <tem:TK_ID>" + tkId
                + " </tem:TK_ID>" + " <tem:MaHQ>" + maHq + " </tem:MaHQ>" + " <tem:NameDK>" + namDk
                + "  </tem:NameDK>\n" + "  </tem:HANGHOAHQ_Search>\n" + "  </soapenv:Body>\n"
                + "  </soapenv:Envelope>\n";
        return xmlInput;
    }

    /**
     * Tạo bản tin SOAP don vi
     *
     * @param
     * @return
     */
    private String createSoapMessageSDonVi(String MaDV) {
        String xmlInput = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\n"
                + " <soapenv:Header/>\n" + " <soapenv:Body>\n" + " <tem:NSW_SDonVi_SelectItem>\n" + " <tem:MaDV>" + MaDV
                + " </tem:MaDV>\n" + "  </tem:NSW_SDonVi_SelectItem>\n" + "  </soapenv:Body>\n"
                + "  </soapenv:Envelope>\n";
        return xmlInput;
    }

    /**
     * Tạo tờ khai Phản hồi
     *
     * @param document
     * @return
     */
    TokhaiResponse taoTokhaiResponse(Document document) {
        TokhaiResponse obj = new TokhaiResponse();
        NodeList nodeLst = document.getElementsByTagName("MaPL_KT");
        if (nodeLst != null && nodeLst.item(0) != null) {
            obj.setMapl(nodeLst.item(0).getTextContent());
        }
        nodeLst = document.getElementsByTagName("SO_TK");
        if (nodeLst != null && nodeLst.item(0) != null) {
            obj.setSotk(nodeLst.item(0).getTextContent());
        }
        nodeLst = document.getElementsByTagName("Ma_LH");
        if (nodeLst != null && nodeLst.item(0) != null) {
            obj.setMalh(nodeLst.item(0).getTextContent());
        }
        nodeLst = document.getElementsByTagName("Ma_HQ");
        if (nodeLst != null && nodeLst.item(0) != null) {
            obj.setMalh(nodeLst.item(0).getTextContent());
        }
        nodeLst = document.getElementsByTagName("Nam_DK");
        if (nodeLst != null && nodeLst.item(0) != null) {
            obj.setMalh(nodeLst.item(0).getTextContent());
        }
        nodeLst = document.getElementsByTagName("Ngay_DK");
        if (nodeLst != null && nodeLst.item(0) != null) {
            obj.setNgaydk(nodeLst.item(0).getTextContent());
        }
        // DON VI NHAP KHAU
        nodeLst = document.getElementsByTagName("Ma_DV_NK");
        if (nodeLst != null && nodeLst.item(0) != null) {
            obj.setMaDvNK(nodeLst.item(0).getTextContent());
        }
        nodeLst = document.getElementsByTagName("Ten_DV_NK");
        if (nodeLst != null && nodeLst.item(0) != null) {
            obj.setTenDvNK(nodeLst.item(0).getTextContent());
        }
        nodeLst = document.getElementsByTagName("Diachi_DV_NK");
        if (nodeLst != null && nodeLst.item(0) != null) {
            obj.setDiachiDvNK(nodeLst.item(0).getTextContent());
        }

        // DON VI XUAT KHAU
        nodeLst = document.getElementsByTagName("Ma_DV_XK");
        if (nodeLst != null && nodeLst.item(0) != null) {
            obj.setMaDvXK(nodeLst.item(0).getTextContent());
        }
        nodeLst = document.getElementsByTagName("Ten_DV_XK");
        if (nodeLst != null && nodeLst.item(0) != null) {
            obj.setTenDvXK(nodeLst.item(0).getTextContent());
        }
        nodeLst = document.getElementsByTagName("Diachi_DV_XK");
        if (nodeLst != null && nodeLst.item(0) != null) {
            obj.setDiachiDvXK(nodeLst.item(0).getTextContent());
        }
        nodeLst = document.getElementsByTagName("SDT_DV_XK");
        if (nodeLst != null && nodeLst.item(0) != null) {
            obj.setDienthoaiDvXK(nodeLst.item(0).getTextContent());
        }
        //
        nodeLst = document.getElementsByTagName("So_Luong_Kien");
        if (nodeLst != null && nodeLst.item(0) != null) {
            obj.setSoluongkien(nodeLst.item(0).getTextContent());
        }
        nodeLst = document.getElementsByTagName("Tong_Trong_Luong");
        if (nodeLst != null && nodeLst.item(0) != null) {
            obj.setTongtrongluong(nodeLst.item(0).getTextContent());
        }
        nodeLst = document.getElementsByTagName("Dia_Diem_Xep_Hang");
        if (nodeLst != null && nodeLst.item(0) != null) {
            obj.setDiadiemxephang(nodeLst.item(0).getTextContent());
        }
        nodeLst = document.getElementsByTagName("Dia_Diem_Nhap_Hang");
        if (nodeLst != null && nodeLst.item(0) != null) {
            obj.setDiadiemnhaphang(nodeLst.item(0).getTextContent());
        }
        nodeLst = document.getElementsByTagName("Phuong_Tien_VC");
        if (nodeLst != null && nodeLst.item(0) != null) {
            obj.setPhuongtienvc(nodeLst.item(0).getTextContent());
        }
        nodeLst = document.getElementsByTagName("Ngay_Hang_Di");
        if (nodeLst != null && nodeLst.item(0) != null) {
            obj.setNgayhangdi(nodeLst.item(0).getTextContent());
        }
        nodeLst = document.getElementsByTagName("So_HD");
        if (nodeLst != null && nodeLst.item(0) != null) {
            obj.setSohd(nodeLst.item(0).getTextContent());
        }
        nodeLst = document.getElementsByTagName("Ngay_Phat_Hanh_HD");
        if (nodeLst != null && nodeLst.item(0) != null) {
            obj.setNgayphathanhhd(nodeLst.item(0).getTextContent());
        }
        nodeLst = document.getElementsByTagName("Phuong_Thuc_TT");
        if (nodeLst != null && nodeLst.item(0) != null) {
            obj.setPhuongthuctt(nodeLst.item(0).getTextContent());
        }
        nodeLst = document.getElementsByTagName("Tong_Gia_Tri_HD");
        if (nodeLst != null && nodeLst.item(0) != null) {
            obj.setTonggiatrihd(nodeLst.item(0).getTextContent());
        }
        nodeLst = document.getElementsByTagName("Dieu_Kien_HD");
        if (nodeLst != null && nodeLst.item(0) != null) {
            obj.setDieukienhd(nodeLst.item(0).getTextContent());
        }
        nodeLst = document.getElementsByTagName("Ty_Gia");
        if (nodeLst != null && nodeLst.item(0) != null) {
            obj.setTygia(nodeLst.item(0).getTextContent());
        }
        nodeLst = document.getElementsByTagName("Ngay_Hoan_Thanh");
        if (nodeLst != null && nodeLst.item(0) != null) {
            obj.setNgayhoanthanh(nodeLst.item(0).getTextContent());
        }
        nodeLst = document.getElementsByTagName("Ngay_Cap_Phep");
        if (nodeLst != null && nodeLst.item(0) != null) {
            obj.setNgaycapphep(nodeLst.item(0).getTextContent());
        }
        nodeLst = document.getElementsByTagName("TK_ID");
        if (nodeLst != null && nodeLst.item(0) != null) {
            obj.setTkid(nodeLst.item(0).getTextContent());
        }
        return obj;
    }

    /**
     * Phân tích chuỗi xml thành đối tượng Document
     *
     * @param in
     * @return
     */
    private static Document parseXmlFile(String in) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            DocumentBuilder db = dbf.newDocumentBuilder();
            InputSource is = new InputSource(new StringReader(in));
            return db.parse(is);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * linhdx Tao Response Create Response
     *
     * @param lstResult
     * @param isSuccess
     * @param errorMessage
     * @param httpStatus
     * @param total
     * @return
     */
    public ResponseEntity<ResponseJson> createResponse(TokhaiResponse obj, boolean isSuccess, String errorMessage,
            HttpStatus httpStatus, Long total) {
        ResponseJson objResponse = new ResponseJson();
        objResponse.setData(obj);
        if (obj != null) {
            total = 1L;
        }
        objResponse.setTotal(total);
        objResponse.setSuccess(isSuccess);
        objResponse.setMessage(errorMessage);
        if(obj != null){
            logger.info("response = " + obj.getSotk());
        }
        return new ResponseEntity<>(objResponse, httpStatus);
    }
}
