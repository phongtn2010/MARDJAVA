package com.vnsw.ws.p16.service;

import com.vnsw.ws.common.envelop.Error;
import com.vnsw.ws.common.envelop.From;
import com.vnsw.ws.common.service.EnvelopXmlService;
import com.vnsw.ws.p14.model.CustomRuntimeException;
import com.vnsw.ws.p14.model.TbdHoSo14;
import com.vnsw.ws.p16.component.Mard16CallBack;
import com.vnsw.ws.p16.constant.Mard16Constant;
import com.vnsw.ws.p16.envelop.Content;
import com.vnsw.ws.p16.envelop.Envelope;
import com.vnsw.ws.p16.message.*;
import com.vnsw.ws.p16.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.*;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class ReceiveService16Impl implements ReceiveService16 {

    public static final Logger LOGGER = LoggerFactory.getLogger(ReceiveService16Impl.class);

    @Autowired
    private Mard16CallBack mard016CallBack;

    @Autowired
    private EnvelopXmlService convertXmlService;

    String xsd18 = "mard_16_";

    @Override
    public Envelope receive(String xml) {

        LOGGER.info("ReceiveService16Impl: documentType: {},  {}", Mard16Constant.MARD1_PRO, xml);

        Envelope envelope = convertXmlService.xmlToEnvelope(xml, Envelope.class);

        try {

            String documentType = envelope.getHeader().getSubject().getDocumentType();
            String type = envelope.getHeader().getSubject().getType();
            String function = envelope.getHeader().getSubject().getFunction();
            String maHoso = envelope.getHeader().getSubject().getReference();

            LOGGER.info("[ Load param ] documentType: {}, type: {}, function: {}, maHoso: {}", documentType, type, function, maHoso);

            Objects.requireNonNull(envelope, "BAN TIN KHONG HOP LE");
            Objects.requireNonNull(envelope.getHeader(), "BAN TIN KHONG HOP LE");
            Objects.requireNonNull(envelope.getBody(), "BAN TIN KHONG HOP LE");
            Objects.requireNonNull(envelope.getBody().getContent(), "BAN TIN KHONG HOP LE");
            TbdHoSo16 tbdHoSo16 = null;
            List<TbdHoSo16> tbdHoSo16s = mard016CallBack.findByFiDocumentName(maHoso).getBody();
            if (!ObjectUtils.isEmpty(tbdHoSo16s)) {
                tbdHoSo16 = tbdHoSo16s.stream().filter(p-> p.getFiActive().intValue() == 1).findFirst().orElseThrow(() -> new NullPointerException("KHONG TIM THAY HO SO: " + maHoso));
            }
            Assert.notNull(tbdHoSo16, "KHONG TIM THAY HO SO: " + maHoso);
            switch (type) {
                case "12":
                    checkDocumentType(documentType, type, xml);
                    receiveType12(envelope, tbdHoSo16);
                    break;
                case "14":
                    checkDocumentType(documentType, type, xml);
                    receiveType14(envelope, tbdHoSo16);
                    break;
                case "16":
                    checkDocumentType(documentType, type, xml);
                    receiveType16(envelope, tbdHoSo16);
                    break;
                case "17":
                    checkDocumentType(documentType, type, xml);
                    receiveType17(envelope, tbdHoSo16);
                    break;
                case "19":
                    checkDocumentType(documentType, type, xml);
                    receiveType19(envelope, tbdHoSo16);
                    break;
                case "20":
                    checkDocumentType(documentType, type, xml);
                    receiveType20(envelope, tbdHoSo16);
                    break;
                default:
                    throw new CustomRuntimeException("KHONG TIM THAY TYPE = " + type);
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            Error error = new Error();
            error.setErrorCode(Mard16Constant.ERR02_CODE);
            String errorXSD = "";
            if (e instanceof IOException || e instanceof SAXParseException) {
                errorXSD += " BAN TIN SAI CAU TRUC XSD: ";
            }
            error.setErrorName(Mard16Constant.ERR02 + " : " + errorXSD + e.getMessage());
            return createReturnEnvelope(envelope, "00", error);
        }

        return createReturnEnvelope(envelope, "99",  null);
    }

    private Envelope createReturnEnvelope(Envelope envelope, String function, Error error) {
        From from = envelope.getHeader().getFrom();
        envelope.getHeader().setFrom(envelope.getHeader().getTo());
        envelope.getHeader().setTo(from);
        envelope.getHeader().getSubject().setFunction(function);
        envelope.getBody().setContent(new Content());
        if ("99".equals(function)) envelope.getBody().getContent().setReceiveDate(new Date());
        if (error != null) envelope.getBody().getContent().setErrorList(Arrays.asList(error));

        return envelope;
    }

    private void receiveType20(Envelope envelope, TbdHoSo16 tbdHoSo16) {
        BNNGuiChinhSuaGP content = envelope.getBody().getContent().getFiBNNGuiChinhSuaGP();
        if (content == null) return;
        tbdHoSo16.setFiOldStatus(tbdHoSo16.getFiStatus());
        String function = envelope.getHeader().getSubject().getFunction();
        switch (function) {
            case "17":
                tbdHoSo16.setFiStatus(17);
                break;
            case "18":
                tbdHoSo16.setFiStatus(14);
                break;
            default:
                throw new CustomRuntimeException("Function not found: " + function);
        }

        List<TbdGiayPhep16> find = mard016CallBack.findByFiIdHoSo(tbdHoSo16.getFiIdHoSo()).getBody();
        if (!ObjectUtils.isEmpty(find)) {
            find.stream().forEach(p-> {
                mard016CallBack.deleteTbdGiayPhep16(p.getFiId());
            });
        }
        List<TbdGPThuoc16> findTbdGPThuoc16s = mard016CallBack.findByFiIdHoSoTbdGPThuoc16(tbdHoSo16.getFiIdHoSo()).getBody();
        if (!ObjectUtils.isEmpty(find)) {
            findTbdGPThuoc16s.stream().forEach(p-> {
                mard016CallBack.deleteTbdGPThuoc16(p.getFiId());
            });
        }
        TbdGiayPhep16 tbdGiayPhep16 = new TbdGiayPhep16();
        BeanUtils.copyProperties(content.getFiVarietyLicense(), tbdGiayPhep16);
        tbdGiayPhep16.setFiIdHoSo(tbdHoSo16.getFiIdHoSo());

        if (!ObjectUtils.isEmpty(content.getFiVarietyLicense().getFiGoods())) {
            for (Goods goods : content.getFiVarietyLicense().getFiGoods()) {
                TbdGPThuoc16 tbdGPThuoc16 = new TbdGPThuoc16();
                BeanUtils.copyProperties(goods, tbdGPThuoc16);
                tbdGPThuoc16.setFiIdHoSo(tbdHoSo16.getFiIdHoSo());
                tbdGPThuoc16 = mard016CallBack.createTbdGPThuoc16(tbdGPThuoc16).getBody();
                System.out.println(tbdGPThuoc16.toString());
            }
        }

        tbdGiayPhep16 = mard016CallBack.createTbdGiayPhep16(tbdGiayPhep16).getBody();
        System.out.println(tbdGiayPhep16.toString());
        mard016CallBack.updateTbdHoSo16(tbdHoSo16.getFiIdHoSo(), tbdHoSo16);
        createHistory(content.getFiVarietyLicense().getFiSignConfirmName(), content.getFiVarietyLicense().getFiSignConfirmName(), "Đồng ý yêu cầu xin chỉnh sửa thông tin GP: " + content.getFiReason(), new Date(), tbdHoSo16.getFiIdHoSo(), tbdHoSo16.getFiStatus());
    }

    private void receiveType19(Envelope envelope, TbdHoSo16 tbdHoSo16) {
        BNNTuChoiYeuCauSuaGP content = envelope.getBody().getContent().getFiBnnTuChoiYeuCauSuaGP();
        if (content == null) return;
        String function = envelope.getHeader().getSubject().getFunction();
        switch (function) {
            case "16":
                tbdHoSo16.setFiOldStatus(tbdHoSo16.getFiStatus());
                tbdHoSo16.setFiStatus(16);
                break;
            default:
                throw new CustomRuntimeException("Function not found: " + function);
        }
        tbdHoSo16 = mard016CallBack.updateTbdHoSo16(tbdHoSo16.getFiIdHoSo(), tbdHoSo16).getBody();
        createHistory(content.getFiCreaterName(), content.getFiDepartment(), content.getFiReason(), content.getFiSignConfirmDate(), tbdHoSo16.getFiIdHoSo(), tbdHoSo16.getFiStatus());
    }

    private void receiveType17(Envelope envelope, TbdHoSo16 tbdHoSo16) {
        CapGiayPhepNhapKhau content = envelope.getBody().getContent().getFiCapGiayPhepNhapKhau();
        if (content == null) return;
        tbdHoSo16.setFiOldStatus(tbdHoSo16.getFiStatus());
        String function = envelope.getHeader().getSubject().getFunction();
        switch (function) {
            case "14":
                tbdHoSo16.setFiStatus(13);
                break;
            default:
                throw new CustomRuntimeException("Function not found: " + function);
        }
        List<TbdGiayPhep16> find = mard016CallBack.findByFiIdHoSo(tbdHoSo16.getFiIdHoSo()).getBody();
        if (find != null && !find.isEmpty()) throw new CustomRuntimeException("DispatchNo = "+ content.getFiDispatchNo() + " exists!");
        TbdGiayPhep16 tbdGiayPhep16 = new TbdGiayPhep16();
        BeanUtils.copyProperties(content, tbdGiayPhep16);
        tbdGiayPhep16.setFiIdHoSo(tbdHoSo16.getFiIdHoSo());

        if (!ObjectUtils.isEmpty(content.getFiGoods())) {
            for (Goods goods : content.getFiGoods()) {
                TbdGPThuoc16 tbdGPThuoc16 = new TbdGPThuoc16();
                BeanUtils.copyProperties(goods, tbdGPThuoc16);
                tbdGPThuoc16.setFiIdHoSo(tbdHoSo16.getFiIdHoSo());
                tbdGPThuoc16 = mard016CallBack.createTbdGPThuoc16(tbdGPThuoc16).getBody();
                System.out.println(tbdGPThuoc16.toString());
            }
        }

        tbdGiayPhep16 = mard016CallBack.createTbdGiayPhep16(tbdGiayPhep16).getBody();
        System.out.println(tbdGiayPhep16.toString());
        mard016CallBack.updateTbdHoSo16(tbdHoSo16.getFiIdHoSo(), tbdHoSo16).getBody();
        createHistory("BNN", "BNN", "Thông báo cấp giấy phép", new Date(), tbdHoSo16.getFiIdHoSo(), tbdHoSo16.getFiStatus());
    }

    private void receiveType16(Envelope envelope, TbdHoSo16 tbdHoSo16) {
        BNNPhanHoiYeuRutSuaHS content = envelope.getBody().getContent().getFiBNNPhanHoiYeuRutSuaHS();
        if (content == null) return;
        String function = envelope.getHeader().getSubject().getFunction();
        switch (function) {
            case "12":
                tbdHoSo16.setFiOldStatus(tbdHoSo16.getFiStatus());
                tbdHoSo16.setFiStatus(11);
                break;
            case "13":
                int old = tbdHoSo16.getFiStatus();
                tbdHoSo16.setFiStatus(tbdHoSo16.getFiOldStatus());
                tbdHoSo16.setFiOldStatus(old);
                break;
            default:
                throw new CustomRuntimeException("Function not found: " + function);
        }
        tbdHoSo16 = mard016CallBack.updateTbdHoSo16(tbdHoSo16.getFiIdHoSo(), tbdHoSo16).getBody();
        System.out.println(tbdHoSo16.toString());
        createHistory(content.getFiCreaterName(), content.getFiDepartment(), content.getFiReason(), content.getFiSignConfirmDate(), tbdHoSo16.getFiIdHoSo(), tbdHoSo16.getFiStatus());
    }

    private void receiveType14(Envelope envelope, TbdHoSo16 tbdHoSo16) {

        BNNPhanHoiYeuCauSuaHS content = envelope.getBody().getContent().getFiBNNPhanHoiYeuCauSuaHS();
        if (content == null) return;
        tbdHoSo16.setFiOldStatus(tbdHoSo16.getFiStatus());
        String function = envelope.getHeader().getSubject().getFunction();
        switch (function) {
            case "09":
                tbdHoSo16.setFiStatus(8);
                break;
            case "10":
                tbdHoSo16.setFiStatus(9);
                tbdHoSo16.setFiActive(0);
                mard016CallBack.updateTbdHoSo16(tbdHoSo16.getFiIdHoSo(), tbdHoSo16);
                TbdHoSo16 oldTbdHoSo161 = mard016CallBack.getTbdHoSo16(tbdHoSo16.getFiVersion().longValue()).getBody();
                oldTbdHoSo161.setFiActive(1);
                oldTbdHoSo161.setFiStatus(9);
                mard016CallBack.updateTbdHoSo16(oldTbdHoSo161.getFiIdHoSo(), oldTbdHoSo161);
                break;
            default:
                throw new CustomRuntimeException("Function not found: " + function);
        }
        mard016CallBack.updateTbdHoSo16(tbdHoSo16.getFiIdHoSo(), tbdHoSo16);
        createHistory(content.getFiCreaterName(), content.getFiDepartment(), content.getFiReason(), content.getFiSignConfirmDate(), tbdHoSo16.getFiIdHoSo(), tbdHoSo16.getFiStatus());
    }

    private void receiveType12(Envelope envelope, TbdHoSo16 tbdHoSo16) {

        KetQuaThamDinh content = envelope.getBody().getContent().getFiKetQuaThamDinh();
        if (content == null) return;
        tbdHoSo16.setFiOldStatus(tbdHoSo16.getFiStatus());
        String function = envelope.getHeader().getSubject().getFunction();
        switch (function) {
            case "05":
                tbdHoSo16.setFiStatus(3);
                break;
            case "06":
                tbdHoSo16.setFiStatus(4);
                break;
            case "07":
                tbdHoSo16.setFiStatus(5);
                break;
            default:
                throw new CustomRuntimeException("Function not found: " + function);
        }

        mard016CallBack.updateTbdHoSo16(tbdHoSo16.getFiIdHoSo(), tbdHoSo16).getBody();
        createHistory(content.getFiCreaterName(), content.getFiDepartment(), content.getFiContent(), content.getFiResultDate(), tbdHoSo16.getFiIdHoSo(), tbdHoSo16.getFiStatus());
    }

    private void createHistory(String createName, String department, String content, Date processDate, Long idHoSo, Integer status) {
        TbdKetQuaXuLy16 tbdKetQuaXuLy16 = new TbdKetQuaXuLy16();
        tbdKetQuaXuLy16.setFiIdHoSo(idHoSo);
        tbdKetQuaXuLy16.setFiStatus(status);
        tbdKetQuaXuLy16.setFiCreateDate(new Date());
        tbdKetQuaXuLy16.setFiContent(content);
        tbdKetQuaXuLy16.setFiProcessor(createName);
        tbdKetQuaXuLy16.setFiProcessDate(processDate);
        tbdKetQuaXuLy16.setFiNameOfRegistration(department);
        if (!StringUtils.hasText(tbdKetQuaXuLy16.getFiContent())) {
            tbdKetQuaXuLy16.setFiContent("Bộ  Nông Nghiệp xử lý kết quả");
        }
        if (tbdKetQuaXuLy16.getFiProcessDate() == null) {
            tbdKetQuaXuLy16.setFiProcessDate(new Date());
        }
        if (!StringUtils.hasText(tbdKetQuaXuLy16.getFiNameOfRegistration())) tbdKetQuaXuLy16.setFiNameOfRegistration(" Bộ  Nông Nghiệp");
        if (!StringUtils.hasText(tbdKetQuaXuLy16.getFiProcessor())) tbdKetQuaXuLy16.setFiProcessor("Bộ  Nông Nghiệp");
        TbdHoSo16 tbdHoSo16 = mard016CallBack.getTbdHoSo16(idHoSo).getBody();
        tbdKetQuaXuLy16.setFiDocumentType(tbdHoSo16.getFiDocumentType());
        tbdKetQuaXuLy16.setFiDocumentName(tbdHoSo16.getFiDocumentName());
        mard016CallBack.createTbdKetQuaXuLy16(tbdKetQuaXuLy16);
    }
    private void checkDocumentType(String documentType, String type, String xml) throws SAXException, IOException {
        String fileXSD = "";
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            switch (documentType) {
                case Mard16Constant.MARD1_PRO:
                    fileXSD = classLoader.getResource("p16/mard_" + type + ".xsd").toString();
                    break;
            }

        } catch (Exception e) {
            LOGGER.error("KHONG TIM THAY FILE XSD: {}", e);
        }
        if (StringUtils.hasText(fileXSD)) {
            Path p = Paths.get(URI.create(fileXSD));
            File file = p.toFile();
            if (file != null) {
                validateWithStringXML(xml, file);
            }
        }
    }

    public void validateWithStringXML(String xml, File scFile) throws SAXException, IOException {
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = schemaFactory.newSchema(scFile);
        Validator validator = schema.newValidator();
        Source source = new StreamSource(new StringReader(xml));
        validator.validate(source);

    }


}
