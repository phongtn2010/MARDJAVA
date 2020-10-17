package com.vnsw.ws.p14.service;

import com.vnsw.ws.common.envelop.Error;
import com.vnsw.ws.common.envelop.From;
import com.vnsw.ws.common.service.EnvelopXmlService;
import com.vnsw.ws.p14.component.Mard14CallBack;
import com.vnsw.ws.p14.constant.Mard14Constant;
import com.vnsw.ws.p14.envelop.Content;
import com.vnsw.ws.p14.envelop.Envelope;
import com.vnsw.ws.p14.message.*;
import com.vnsw.ws.p14.model.*;
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
import java.util.*;

@Service
public class ReceiveService14Impl implements ReceiveService14 {

    public static final Logger LOGGER = LoggerFactory.getLogger(ReceiveService14Impl.class);

    @Autowired
    private Mard14CallBack mard014CallBack;

    @Autowired
    private EnvelopXmlService convertXmlService;

    @Override
    public Envelope receive(String xml) {

        LOGGER.info("ReceiveService14Impl: documentType: {},  {}", Mard14Constant.MARD1_PRO, xml);

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
            List<TbdHoSo14> tbdHoSo142 = mard014CallBack.findByFiDocumentName(maHoso).getBody();
            TbdHoSo14 tbdHoSo14 = null;
            if (!ObjectUtils.isEmpty(tbdHoSo142)) {
                tbdHoSo14 = tbdHoSo142.stream().filter(p-> p.getFiActive().intValue() == 1).findFirst().orElseThrow(() -> new NullPointerException("KHONG TIM THAY HO SO: " + maHoso));
            }
            Assert.notNull(tbdHoSo14, "KHONG TIM THAY HO SO: " + maHoso);
            switch (type) {
                case "12":
                    checkDocumentType(documentType, type, xml);
                    receiveType12(envelope, tbdHoSo14);
                    break;
                case "14":
                    checkDocumentType(documentType, type, xml);
                    receiveType14(envelope, tbdHoSo14);
                    break;
                case "16":
                    checkDocumentType(documentType, type, xml);
                    receiveType16(envelope, tbdHoSo14);
                    break;
                case "17":
                    checkDocumentType(documentType, type, xml);
                    receiveType17(envelope, tbdHoSo14);
                    break;
                case "19":
                    checkDocumentType(documentType, type, xml);
                    receiveType19(envelope, tbdHoSo14);
                    break;
                case "20":
                    checkDocumentType(documentType, type, xml);
                    receiveType20(envelope, tbdHoSo14);
                    break;
                case "24":
                    checkDocumentType(documentType, type, xml);
                    receiveType24(envelope, tbdHoSo14);
                    break;
                    default:
                        throw new CustomRuntimeException("KHONG TIM THAY TYPE = " + type);
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            Error error = new Error();
            error.setErrorCode(Mard14Constant.ERR02_CODE);
            String errorXSD = "";
            if (e instanceof IOException || e instanceof SAXParseException) {
                errorXSD += " BAN TIN SAI CAU TRUC XSD: ";
            }
            error.setErrorName(Mard14Constant.ERR02 + " : " + errorXSD + e.getMessage());
            return createReturnEnvelope(envelope, "00", error);
        }
        return createReturnEnvelope(envelope, "99", null);
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

    private void receiveType24(Envelope envelope, TbdHoSo14 tbdHoSo14) {
        BNNGuiChinhSuaGP content = envelope.getBody().getContent().getFiBNNGuiChinhSuaGP();
        if (content == null) return;
        tbdHoSo14.setFiOldStatus(tbdHoSo14.getFiStatus());
        String function = envelope.getHeader().getSubject().getFunction();
        switch (function) {
            case "23":
                tbdHoSo14.setFiStatus(19);
                break;
            default:
                throw new CustomRuntimeException("Function not found: " + function);
        }

        if (!checkFiPurposes(content.getFiPurposes())) {
            throw new CustomRuntimeException("SAI MUC DICH QUY DINH! getFiPurposes = " + content.getFiPurposes());
        }

        List<TbdGiayPhep14> findTbdGiayPhep14s = mard014CallBack.findTbdGiayPhep14ByFiIdHoSo(tbdHoSo14.getFiIdHoSo()).getBody();
        if (!ObjectUtils.isEmpty(findTbdGiayPhep14s)) {
            findTbdGiayPhep14s.stream().forEach(p->{
                mard014CallBack.deleteTbdGiayPhep14(p.getFiId());
            });
        }
        List<TbdGPThuoc14> findTbdGPThuoc14s = mard014CallBack.findTbdGPThuoc14ByFiIdHoSo(tbdHoSo14.getFiIdHoSo()).getBody();
        if (!ObjectUtils.isEmpty(findTbdGPThuoc14s)) {
            findTbdGPThuoc14s.stream().forEach(p->{
                mard014CallBack.deleteTbdGPThuoc14(p.getFiId());
            });
        }

        TbdGiayPhep14 tbdGiayPhep14 = new TbdGiayPhep14();
        BeanUtils.copyProperties(content, tbdGiayPhep14);
        tbdGiayPhep14.setFiIdHoSo(tbdHoSo14.getFiIdHoSo());

        final Long idHoSo = tbdHoSo14.getFiIdHoSo();
        content.getFiGoods().stream().forEach(p -> {
            TbdGPThuoc14 tbdGPThuoc14 = new TbdGPThuoc14();
            BeanUtils.copyProperties(p, tbdGPThuoc14);
            tbdGPThuoc14.setFiIdHoSo(idHoSo);
            mard014CallBack.createTbdGPThuoc14(tbdGPThuoc14);
        });
        mard014CallBack.createTbdGiayPhep14(tbdGiayPhep14);
        mard014CallBack.updateTbdHoSo14(tbdHoSo14.getFiIdHoSo(), tbdHoSo14);
        createHistory(content.getFiSignConfirmName(), content.getFiSignConfirmName(), "Thông báo chỉnh sửa giấy phép: " + content.getFiReason(), new Date(), tbdHoSo14.getFiIdHoSo(), tbdHoSo14.getFiStatus());
    }

    private void receiveType20(Envelope envelope, TbdHoSo14 tbdHoSo14) {
        CapGiayPhepNhapKhau content = envelope.getBody().getContent().getFiCapGiayPhepNhapKhau();
        if (content == null) return;
        tbdHoSo14.setFiOldStatus(tbdHoSo14.getFiStatus());
        String function = envelope.getHeader().getSubject().getFunction();
        switch (function) {
            case "18":
                tbdHoSo14.setFiStatus(18);
                break;
            default:
                throw new CustomRuntimeException("Function not found: " + function);
        }
        if (!checkFiPurposes(content.getFiPurposes())) {
            throw new CustomRuntimeException("SAI MUC DICH QUY DINH! getFiPurposes = " + content.getFiPurposes());
        }
        List<TbdGiayPhep14> find = mard014CallBack.findTbdGiayPhep14ByFiIdHoSo(tbdHoSo14.getFiIdHoSo()).getBody();
        if (find != null && !find.isEmpty()) throw new CustomRuntimeException("HO SO NAY DA TON TAI SO GIAY PHEP: DispatchNo = "+ content.getFiDispatchNo() + " exists!");
        TbdGiayPhep14 tbdGiayPhep14 = new TbdGiayPhep14();
        BeanUtils.copyProperties(content, tbdGiayPhep14);
        tbdGiayPhep14.setFiIdHoSo(tbdHoSo14.getFiIdHoSo());

        final Long idHoSo = tbdHoSo14.getFiIdHoSo();
        content.getFiGoods().stream().forEach(p -> {
            TbdGPThuoc14 tbdGPThuoc14 = new TbdGPThuoc14();
            BeanUtils.copyProperties(p, tbdGPThuoc14);
            tbdGPThuoc14.setFiIdHoSo(idHoSo);
            mard014CallBack.createTbdGPThuoc14(tbdGPThuoc14);
        });
        mard014CallBack.createTbdGiayPhep14(tbdGiayPhep14);
        mard014CallBack.updateTbdHoSo14(tbdHoSo14.getFiIdHoSo(), tbdHoSo14);
        createHistory(content.getFiSignConfirmName(), content.getFiSignConfirmName(), "Thông báo cấp giấy phép", new Date(), tbdHoSo14.getFiIdHoSo(), tbdHoSo14.getFiStatus());
    }

    private boolean checkFiPurposes(String fiPurposes) {
        List<TbsMucDich14> findAll = mard014CallBack.findTbsMucDichByFiDocumentType(Mard14Constant.MARD1_PRO).getBody();

        final List<String> mucDichs = new ArrayList<>();
        if (StringUtils.hasText(fiPurposes)) {
            mucDichs.addAll(Arrays.asList(fiPurposes.split(";")));
        }
        Optional<TbsMucDich14> find = findAll.stream().filter(p-> mucDichs.contains(p.getFiCode())).findFirst();
        return find.isPresent();
    }

    private void receiveType19(Envelope envelope, TbdHoSo14 tbdHoSo14) {
        BNNDeNghiTTBoSung content = envelope.getBody().getContent().getFiBnnDeNghiTTBoSung();
        if (content == null) return;
        tbdHoSo14.setFiOldStatus(tbdHoSo14.getFiStatus());
        String function = envelope.getHeader().getSubject().getFunction();
        switch (function) {
            case "16":
                tbdHoSo14.setFiStatus(20);
                break;
            default:
                throw new CustomRuntimeException("Function not found: " + function);
        }

        mard014CallBack.updateTbdHoSo14(tbdHoSo14.getFiIdHoSo(), tbdHoSo14);
        createHistory(content.getFiCreaterName(), content.getFiDepartment(), content.getFiNote(), new Date(), tbdHoSo14.getFiIdHoSo(), tbdHoSo14.getFiStatus());
    }


    private void receiveType17(Envelope envelope, TbdHoSo14 tbdHoSo14) {
        ThongTinApPhi content = envelope.getBody().getContent().getFiThongTinApPhi();
        if (content == null) return;
        tbdHoSo14.setFiOldStatus(tbdHoSo14.getFiStatus());
        String function = envelope.getHeader().getSubject().getFunction();
        switch (function) {
            case "14":
                tbdHoSo14.setFiStatus(15);
                break;
            default:
                throw new CustomRuntimeException("Function not found: " + function);
        }

        TbdThongBaoPhi14 tbdThongBaoPhi14 = new TbdThongBaoPhi14();
        BeanUtils.copyProperties(content, tbdThongBaoPhi14);
        tbdThongBaoPhi14.setFiCreateDate(new Date());
        tbdThongBaoPhi14.setFiIdHoSo(tbdHoSo14.getFiIdHoSo());
        mard014CallBack.createTbdThongBaoPhi14(tbdThongBaoPhi14);
        mard014CallBack.updateTbdHoSo14(tbdHoSo14.getFiIdHoSo(), tbdHoSo14);
        createHistory(content.getFiAccountNo(), content.getFiAccountName(), content.getFiNote(), new Date(), tbdHoSo14.getFiIdHoSo(), tbdHoSo14.getFiStatus());
    }

    private void receiveType16(Envelope envelope, TbdHoSo14 tbdHoSo14) {
        BNNPhanHoiYeuRutSuaHS content = envelope.getBody().getContent().getFiBNNPhanHoiYeuRutSuaHS();
        if (content == null) return;
        String function = envelope.getHeader().getSubject().getFunction();
        switch (function) {
            case "12":
                tbdHoSo14.setFiOldStatus(tbdHoSo14.getFiStatus());
                tbdHoSo14.setFiStatus(13);
                break;
            case "13":
                int old = tbdHoSo14.getFiStatus();
                tbdHoSo14.setFiStatus(tbdHoSo14.getFiOldStatus());
                tbdHoSo14.setFiOldStatus(old);
                break;
            default:
                throw new CustomRuntimeException("Function not found: " + function);
        }
        tbdHoSo14 = mard014CallBack.updateTbdHoSo14(tbdHoSo14.getFiIdHoSo(), tbdHoSo14).getBody();
        System.out.println(tbdHoSo14.toString());
        createHistory(content.getFiCreaterName(), content.getFiDepartment(), content.getFiReason(), content.getFiSignConfirmDate(), tbdHoSo14.getFiIdHoSo(), tbdHoSo14.getFiStatus());
    }

    private void receiveType14(Envelope envelope, TbdHoSo14 tbdHoSo14) {

        BNNPhanHoiYeuCauSuaHS content = envelope.getBody().getContent().getFiBNNPhanHoiYeuCauSuaHS();
        if (content == null) return;
        tbdHoSo14.setFiOldStatus(tbdHoSo14.getFiStatus());
        String function = envelope.getHeader().getSubject().getFunction();
        switch (function) {
            case "09":
                tbdHoSo14.setFiStatus(10);
                mard014CallBack.updateTbdHoSo14(tbdHoSo14.getFiIdHoSo(), tbdHoSo14);
                break;
            case "10":
                tbdHoSo14.setFiStatus(11);
                tbdHoSo14.setFiActive(0);
                mard014CallBack.updateTbdHoSo14(tbdHoSo14.getFiIdHoSo(), tbdHoSo14);
                TbdHoSo14 oldTbdHoSo141 = mard014CallBack.getTbdHoSo14(tbdHoSo14.getFiVersion().longValue()).getBody();
                oldTbdHoSo141.setFiActive(1);
                oldTbdHoSo141.setFiStatus(11);
                mard014CallBack.updateTbdHoSo14(oldTbdHoSo141.getFiIdHoSo(), oldTbdHoSo141);
                break;
            default:
                throw new CustomRuntimeException("Function not found: " + function);
        }


        createHistory(content.getFiCreaterName(), content.getFiDepartment(), content.getFiReason(), content.getFiSignConfirmDate(), tbdHoSo14.getFiIdHoSo(), tbdHoSo14.getFiStatus());
    }

    private void receiveType12(Envelope envelope, TbdHoSo14 tbdHoSo14) {

        KetQuaThamDinh content = envelope.getBody().getContent().getFiKetQuaThamDinh();
        if (content == null) return;
        tbdHoSo14.setFiOldStatus(tbdHoSo14.getFiStatus());
        String function = envelope.getHeader().getSubject().getFunction();
        switch (function) {
            case "05":
                tbdHoSo14.setFiStatus(3);
                break;
            case "06":
                tbdHoSo14.setFiStatus(4);
                break;
            case "07":
                tbdHoSo14.setFiStatus(5);
                break;
            case "20":
                tbdHoSo14.setFiStatus(7);
                break;
            default:
                throw new CustomRuntimeException("Function not found: " + function);
        }

        mard014CallBack.updateTbdHoSo14(tbdHoSo14.getFiIdHoSo(), tbdHoSo14).getBody();
        createHistory(content.getFiCreaterName(), content.getFiDepartment(), content.getFiContent(), content.getFiResultDate(), tbdHoSo14.getFiIdHoSo(), tbdHoSo14.getFiStatus());
    }

    private void createHistory(String createName, String department, String content, Date processDate, Long idHoSo, Integer status) {
        TbdKetQuaXuLy14 tbdKetQuaXuLy14 = new TbdKetQuaXuLy14();
        tbdKetQuaXuLy14.setFiIdHoSo(idHoSo);
        tbdKetQuaXuLy14.setFiStatus(status);
        tbdKetQuaXuLy14.setFiCreateDate(new Date());
        tbdKetQuaXuLy14.setFiContent(content);
        tbdKetQuaXuLy14.setFiProcessor(createName);
        tbdKetQuaXuLy14.setFiProcessDate(processDate);
        tbdKetQuaXuLy14.setFiNameOfRegistration(department);
        if (!StringUtils.hasText(tbdKetQuaXuLy14.getFiContent())) {
            tbdKetQuaXuLy14.setFiContent("Bộ  Nông Nghiệp xử lý kết quả");
        }
        if (tbdKetQuaXuLy14.getFiProcessDate() == null) {
            tbdKetQuaXuLy14.setFiProcessDate(new Date());
        }
        if (!StringUtils.hasText(tbdKetQuaXuLy14.getFiNameOfRegistration())) tbdKetQuaXuLy14.setFiNameOfRegistration("Bộ  Nông Nghiệp");
        if (!StringUtils.hasText(tbdKetQuaXuLy14.getFiProcessor())) tbdKetQuaXuLy14.setFiProcessor("Bộ  Nông Nghiệp");
        TbdHoSo14 tbdHoSo14 = mard014CallBack.getTbdHoSo14(idHoSo).getBody();
        tbdKetQuaXuLy14.setFiDocumentType(tbdHoSo14.getFiDocumentType());
        tbdKetQuaXuLy14.setFiDocumentName(tbdHoSo14.getFiDocumentName());
        mard014CallBack.createTbdKetQuaXuLy14(tbdKetQuaXuLy14);
    }

    private void checkDocumentType(String documentType, String type, String xml) throws SAXException, IOException {
        String fileXSD = "";
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            switch (documentType) {
                case Mard14Constant.MARD1_PRO:
                    fileXSD = classLoader.getResource("p14/mard_" + type + ".xsd").toString();
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
