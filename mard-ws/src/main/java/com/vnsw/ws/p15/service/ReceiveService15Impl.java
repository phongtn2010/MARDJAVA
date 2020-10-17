package com.vnsw.ws.p15.service;

import com.vnsw.ws.common.envelop.Error;
import com.vnsw.ws.common.envelop.From;
import com.vnsw.ws.common.service.EnvelopXmlService;
import com.vnsw.ws.p14.model.CustomRuntimeException;
import com.vnsw.ws.p15.component.Mard15CallBack;
import com.vnsw.ws.p15.constant.Mard15Constant;
import com.vnsw.ws.p15.envelop.Content;
import com.vnsw.ws.p15.envelop.Envelope;
import com.vnsw.ws.p15.message.*;
import com.vnsw.ws.p15.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
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
public class ReceiveService15Impl implements ReceiveService15 {

    public static final Logger LOGGER = LoggerFactory.getLogger(ReceiveService15Impl.class);

    @Autowired
    private Environment environment;

    @Autowired
    private Mard15CallBack mard015CallBack;

    @Autowired
    private EnvelopXmlService convertXmlService;

    String xsd18 = "mard_15_";

    @Override
    public Envelope receive(String xml) {

        LOGGER.info("ReceiveService15Impl: documentType: {},  {}", Mard15Constant.MARD1_PRO, xml);

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
            TbdHoSo15 tbdHoSo15 = null;
            List<TbdHoSo15> tbdHoSo15List =  mard015CallBack.findByFiDocumentName(maHoso).getBody();
            if (Objects.nonNull(tbdHoSo15List)) {
                tbdHoSo15 = tbdHoSo15List.stream().filter(p-> p.getFiActive().intValue() == 1).findFirst().orElseThrow(() -> new NullPointerException("KHONG TIM THAY HO SO: " + maHoso));
            }
            Assert.notNull(tbdHoSo15, "KHONG TIM THAY HO SO: " + maHoso);
            switch (type) {
                case "12":
                    checkDocumentType(documentType, type, xml);
                    receiveType12(envelope, tbdHoSo15);
                    break;
                case "14":
                    checkDocumentType(documentType, type, xml);
                    receiveType14(envelope, tbdHoSo15);
                    break;
                case "16":
                    checkDocumentType(documentType, type, xml);
                    receiveType16(envelope, tbdHoSo15);
                    break;
                case "17":
                    checkDocumentType(documentType, type, xml);
                    receiveType17(envelope, tbdHoSo15);
                    break;
                case "19":
                    checkDocumentType(documentType, type, xml);
                    receiveType19(envelope, tbdHoSo15);
                    break;
                case "20":
                    checkDocumentType(documentType, type, xml);
                    receiveType20(envelope, tbdHoSo15);
                    break;
                    default:
                        throw new CustomRuntimeException("KHONG TIM THAY TYPE = " + type);
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            Error error = new Error();
            error.setErrorCode(Mard15Constant.ERR02_CODE);
            String errorXSD = "";
            if (e instanceof IOException || e instanceof SAXParseException) {
                errorXSD += " BAN TIN SAI CAU TRUC XSD: ";
            }
            error.setErrorName(Mard15Constant.ERR02 + " : " + errorXSD + e.getMessage());

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

    private void receiveType20(Envelope envelope, TbdHoSo15 tbdHoSo15) {
        BNNGuiChinhSuaGP content = envelope.getBody().getContent().getFiBNNGuiChinhSuaGP();
        if (content == null) return;
        tbdHoSo15.setFiOldStatus(tbdHoSo15.getFiStatus());
        String function = envelope.getHeader().getSubject().getFunction();
        switch (function) {
            case "17":
                tbdHoSo15.setFiStatus(17);
                break;
            case "18":
                tbdHoSo15.setFiStatus(14);
                break;
            default:
                throw new CustomRuntimeException("Function not found: " + function);
        }

        List<TbdGiayPhep15> find = mard015CallBack.findByFiIdHoSo(tbdHoSo15.getFiIdHoSo()).getBody();
        if (!ObjectUtils.isEmpty(find)) {
            find.stream().forEach(p-> {
                mard015CallBack.deleteTbdGiayPhep15(p.getFiId());
            });
        }
        List<TbdGPThuoc15> findTbdGPThuoc15s = mard015CallBack.findByFiIdHoSoTbdGPThuoc15(tbdHoSo15.getFiIdHoSo()).getBody();
        if (!ObjectUtils.isEmpty(findTbdGPThuoc15s)) {
            findTbdGPThuoc15s.stream().forEach(p-> {
                mard015CallBack.deleteTbdGPThuoc15(p.getFiId());
            });
        }
        TbdGiayPhep15 tbdGiayPhep15 = new TbdGiayPhep15();
        BeanUtils.copyProperties(content.getFiGeneticLicense(), tbdGiayPhep15);
        tbdGiayPhep15.setFiIdHoSo(tbdHoSo15.getFiIdHoSo());

        if (!ObjectUtils.isEmpty(content.getFiGeneticLicense().getFiGoods())) {
            for (Goods goods : content.getFiGeneticLicense().getFiGoods()) {
                TbdGPThuoc15 tbdGPThuoc15 = new TbdGPThuoc15();
                BeanUtils.copyProperties(goods, tbdGPThuoc15);
                tbdGPThuoc15.setFiIdHoSo(tbdHoSo15.getFiIdHoSo());
                mard015CallBack.createTbdGPThuoc15(tbdGPThuoc15).getBody();
            }
        }

        mard015CallBack.createTbdGiayPhep15(tbdGiayPhep15).getBody();
        mard015CallBack.updateTbdHoSo15(tbdHoSo15.getFiIdHoSo(), tbdHoSo15);
        createHistory(content.getFiGeneticLicense().getFiSignConfirmName(), content.getFiGeneticLicense().getFiSignConfirmName(), "Đồng ý yêu cầu xin chỉnh sửa thông tin GP: " + content.getFiReason(), new Date(), tbdHoSo15.getFiIdHoSo(), tbdHoSo15.getFiStatus());
    }

    private void receiveType19(Envelope envelope, TbdHoSo15 tbdHoSo15) {
        BNNTuChoiYeuCauSuaGP content = envelope.getBody().getContent().getFiBnnTuChoiYeuCauSuaGP();
        if (content == null) return;
        String function = envelope.getHeader().getSubject().getFunction();
        switch (function) {
            case "16":
                tbdHoSo15.setFiOldStatus(tbdHoSo15.getFiStatus());
                tbdHoSo15.setFiStatus(16);
                break;
            default:
                throw new CustomRuntimeException("Function not found: " + function);
        }
        tbdHoSo15 = mard015CallBack.updateTbdHoSo15(tbdHoSo15.getFiIdHoSo(), tbdHoSo15).getBody();
        createHistory(content.getFiCreaterName(), content.getFiDepartment(), content.getFiReason(), content.getFiSignConfirmDate(), tbdHoSo15.getFiIdHoSo(), tbdHoSo15.getFiStatus());
    }

    private void receiveType17(Envelope envelope, TbdHoSo15 tbdHoSo15) {
        CapGiayPhepNhapKhau content = envelope.getBody().getContent().getFiCapGiayPhepNhapKhau();
        if (content == null) return;
        tbdHoSo15.setFiOldStatus(tbdHoSo15.getFiStatus());
        String function = envelope.getHeader().getSubject().getFunction();
        switch (function) {
            case "14":
                tbdHoSo15.setFiStatus(13);
                break;
            default:
                throw new CustomRuntimeException("Function not found: " + function);
        }
        List<TbdGiayPhep15> find = mard015CallBack.findByFiIdHoSo(tbdHoSo15.getFiIdHoSo()).getBody();
        if (find != null && !find.isEmpty()) throw new CustomRuntimeException("DispatchNo = "+ content.getFiDispatchNo() + " exists!");
        TbdGiayPhep15 tbdGiayPhep15 = new TbdGiayPhep15();
        BeanUtils.copyProperties(content, tbdGiayPhep15);
        tbdGiayPhep15.setFiIdHoSo(tbdHoSo15.getFiIdHoSo());
        if (!ObjectUtils.isEmpty(content.getFiGoods())) {
            for (Goods goods : content.getFiGoods()) {
                TbdGPThuoc15 tbdGPThuoc15 = new TbdGPThuoc15();
                BeanUtils.copyProperties(goods, tbdGPThuoc15);
                tbdGPThuoc15.setFiIdHoSo(tbdHoSo15.getFiIdHoSo());
                mard015CallBack.createTbdGPThuoc15(tbdGPThuoc15).getBody();
            }
        }
        mard015CallBack.createTbdGiayPhep15(tbdGiayPhep15).getBody();
        mard015CallBack.updateTbdHoSo15(tbdHoSo15.getFiIdHoSo(), tbdHoSo15).getBody();
        createHistory("BNN", "BNN", "Thông báo cấp giấy phép", new Date(), tbdHoSo15.getFiIdHoSo(), tbdHoSo15.getFiStatus());
    }

    private void receiveType16(Envelope envelope, TbdHoSo15 tbdHoSo15) {
        BNNPhanHoiYeuRutSuaHS content = envelope.getBody().getContent().getFiBNNPhanHoiYeuRutSuaHS();
        if (content == null) return;
        String function = envelope.getHeader().getSubject().getFunction();
        switch (function) {
            case "12":
                tbdHoSo15.setFiOldStatus(tbdHoSo15.getFiStatus());
                tbdHoSo15.setFiStatus(11);
                break;
            case "13":
                int old = tbdHoSo15.getFiStatus();
                tbdHoSo15.setFiStatus(tbdHoSo15.getFiOldStatus());
                tbdHoSo15.setFiOldStatus(old);
                break;
            default:
                throw new CustomRuntimeException("Function not found: " + function);
        }
        tbdHoSo15 = mard015CallBack.updateTbdHoSo15(tbdHoSo15.getFiIdHoSo(), tbdHoSo15).getBody();
        System.out.println(tbdHoSo15.toString());
        createHistory(content.getFiCreaterName(), content.getFiDepartment(), content.getFiReason(), content.getFiSignConfirmDate(), tbdHoSo15.getFiIdHoSo(), tbdHoSo15.getFiStatus());
    }

    private void receiveType14(Envelope envelope, TbdHoSo15 tbdHoSo15) {

        BNNPhanHoiYeuCauSuaHS content = envelope.getBody().getContent().getFiBNNPhanHoiYeuCauSuaHS();
        if (content == null) return;
        tbdHoSo15.setFiOldStatus(tbdHoSo15.getFiStatus());
        String function = envelope.getHeader().getSubject().getFunction();
        switch (function) {
            case "09":
                tbdHoSo15.setFiStatus(8);
                mard015CallBack.updateTbdHoSo15(tbdHoSo15.getFiIdHoSo(), tbdHoSo15);
                break;
            case "10":
                tbdHoSo15.setFiStatus(9);
                tbdHoSo15.setFiActive(0);
                mard015CallBack.updateTbdHoSo15(tbdHoSo15.getFiIdHoSo(), tbdHoSo15);
                TbdHoSo15 oldTbdHoSo151 = mard015CallBack.getTbdHoSo15(tbdHoSo15.getFiVersion().longValue()).getBody();
                oldTbdHoSo151.setFiActive(1);
                oldTbdHoSo151.setFiStatus(9);
                mard015CallBack.updateTbdHoSo15(oldTbdHoSo151.getFiIdHoSo(), oldTbdHoSo151);
                break;
            default:
                throw new CustomRuntimeException("Function not found: " + function);
        }

        createHistory(content.getFiCreaterName(), content.getFiDepartment(), content.getFiReason(), content.getFiSignConfirmDate(), tbdHoSo15.getFiIdHoSo(), tbdHoSo15.getFiStatus());
    }

    private void receiveType12(Envelope envelope, TbdHoSo15 tbdHoSo15) {

        KetQuaThamDinh content = envelope.getBody().getContent().getFiKetQuaThamDinh();
        if (content == null) return;
        tbdHoSo15.setFiOldStatus(tbdHoSo15.getFiStatus());
        String function = envelope.getHeader().getSubject().getFunction();
        switch (function) {
            case "05":
                tbdHoSo15.setFiStatus(3);
                break;
            case "06":
                tbdHoSo15.setFiStatus(4);
                break;
            case "07":
                tbdHoSo15.setFiStatus(5);
                break;
            default:
                throw new CustomRuntimeException("Function not found: " + function);
        }

        mard015CallBack.updateTbdHoSo15(tbdHoSo15.getFiIdHoSo(), tbdHoSo15).getBody();
        createHistory(content.getFiCreaterName(), content.getFiDepartment(), content.getFiContent(), content.getFiResultDate(), tbdHoSo15.getFiIdHoSo(), tbdHoSo15.getFiStatus());
    }

    private void createHistory(String createName, String department, String content, Date processDate, Long idHoSo, Integer status) {
        TbdKetQuaXuLy15 tbdKetQuaXuLy15 = new TbdKetQuaXuLy15();
        tbdKetQuaXuLy15.setFiIdHoSo(idHoSo);
        tbdKetQuaXuLy15.setFiStatus(status);
        tbdKetQuaXuLy15.setFiCreateDate(new Date());
        tbdKetQuaXuLy15.setFiContent(content);
        tbdKetQuaXuLy15.setFiProcessor(createName);
        tbdKetQuaXuLy15.setFiProcessDate(processDate);
        tbdKetQuaXuLy15.setFiNameOfRegistration(department);
        if (!StringUtils.hasText(tbdKetQuaXuLy15.getFiContent())) {
            tbdKetQuaXuLy15.setFiContent("Bộ  Nông Nghiệp xử lý kết quả");
        }
        if (tbdKetQuaXuLy15.getFiProcessDate() == null) {
            tbdKetQuaXuLy15.setFiProcessDate(new Date());
        }
        if (!StringUtils.hasText(tbdKetQuaXuLy15.getFiNameOfRegistration())) tbdKetQuaXuLy15.setFiNameOfRegistration(" Bộ  Nông Nghiệp");
        if (!StringUtils.hasText(tbdKetQuaXuLy15.getFiProcessor())) tbdKetQuaXuLy15.setFiProcessor("Bộ  Nông Nghiệp");
        TbdHoSo15 tbdHoSo15 = mard015CallBack.getTbdHoSo15(idHoSo).getBody();
        tbdKetQuaXuLy15.setFiDocumentType(tbdHoSo15.getFiDocumentType());
        tbdKetQuaXuLy15.setFiDocumentName(tbdHoSo15.getFiDocumentName());
        mard015CallBack.createTbdKetQuaXuLy15(tbdKetQuaXuLy15);
    }
    private void checkDocumentType(String documentType, String type, String xml) throws SAXException, IOException {
        String fileXSD = "";
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            switch (documentType) {
                case Mard15Constant.MARD1_PRO:
                    fileXSD = classLoader.getResource("p15/mard_" + type + ".xsd").toString();
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
