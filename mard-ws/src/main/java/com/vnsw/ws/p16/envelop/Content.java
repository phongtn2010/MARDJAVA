package com.vnsw.ws.p16.envelop;

import com.vnsw.ws.annotations.DateSerialization;
import com.vnsw.ws.common.envelop.Error;
import com.vnsw.ws.p14.message.ThongBaoChuyenKhoan;
import com.vnsw.ws.p14.message.ThongTinApPhi;
import com.vnsw.ws.p16.message.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

/**
 *
 * @author PhongNV9
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Content")
public class Content {



	//00 Error 
    @XmlElementWrapper(name = "ErrorList")
    @XmlElement(name = "Error")
    private List<Error> errorList;
    public List<Error> getErrorList() {
        return errorList;
    }

    public void setErrorList(List<Error> errorList) {
        this.errorList = errorList;
    }

    //99-Success 
	@XmlJavaTypeAdapter(DateSerialization.class)
	@XmlElement(name = "ReceiveDate")
    private Date receiveDate;
  
  	public Date getReceiveDate() {
		return receiveDate;
	}

	public void setReceiveDate(Date receiveDate) {
		this.receiveDate = receiveDate;
	}

	@XmlElement(name = "VarietyLicenseEdit")
	private BNNGuiChinhSuaGP fiBNNGuiChinhSuaGP;

	@XmlElement(name = "VarietyResponseEdit")
	private BNNPhanHoiYeuCauSuaHS fiBNNPhanHoiYeuCauSuaHS;

	@XmlElement(name = "VarietyResponseCancel")
	private BNNPhanHoiYeuRutSuaHS fiBNNPhanHoiYeuRutSuaHS;

	@XmlElement(name = "VarietyLicense")
	private CapGiayPhepNhapKhau fiCapGiayPhepNhapKhau;

	@XmlElement(name = "Variety")
	private DNDangKyHoSo fiDNDangKyHoSo;

	@XmlElement(name = "VarietyCancel")
	private DNYeuCauRutHS fiDNYeuCauRutHS;

	@XmlElement(name = "VarietyRequestCancel")
	private DNYeuCauRutHSSauTiepNhan fiDnYeuCauRutHSSauTiepNhan;

	@XmlElement(name = "VarietyRequestEdit")
	private DNYeuCauSuaHS fiDNYeuCauSuaHS;

	@XmlElement(name = "VarietyResult")
	private KetQuaThamDinh fiKetQuaThamDinh;

	@XmlElement(name = "VarietyRequestEditLicense")
	private DNYeuCauChinhSuaGP fiDnYeuCauChinhSuaGP;

	@XmlElement(name = "VarietyResponseEditLicense")
	private BNNTuChoiYeuCauSuaGP fiBnnTuChoiYeuCauSuaGP;

	public BNNGuiChinhSuaGP getFiBNNGuiChinhSuaGP() {
		return this.fiBNNGuiChinhSuaGP;
	}

	public void setFiBNNGuiChinhSuaGP(BNNGuiChinhSuaGP fiBNNGuiChinhSuaGP) {
		this.fiBNNGuiChinhSuaGP = fiBNNGuiChinhSuaGP;
	}

	public BNNPhanHoiYeuCauSuaHS getFiBNNPhanHoiYeuCauSuaHS() {
		return this.fiBNNPhanHoiYeuCauSuaHS;
	}

	public void setFiBNNPhanHoiYeuCauSuaHS(BNNPhanHoiYeuCauSuaHS fiBNNPhanHoiYeuCauSuaHS) {
		this.fiBNNPhanHoiYeuCauSuaHS = fiBNNPhanHoiYeuCauSuaHS;
	}

	public BNNPhanHoiYeuRutSuaHS getFiBNNPhanHoiYeuRutSuaHS() {
		return this.fiBNNPhanHoiYeuRutSuaHS;
	}

	public void setFiBNNPhanHoiYeuRutSuaHS(BNNPhanHoiYeuRutSuaHS fiBNNPhanHoiYeuRutSuaHS) {
		this.fiBNNPhanHoiYeuRutSuaHS = fiBNNPhanHoiYeuRutSuaHS;
	}

	public CapGiayPhepNhapKhau getFiCapGiayPhepNhapKhau() {
		return this.fiCapGiayPhepNhapKhau;
	}

	public void setFiCapGiayPhepNhapKhau(CapGiayPhepNhapKhau fiCapGiayPhepNhapKhau) {
		this.fiCapGiayPhepNhapKhau = fiCapGiayPhepNhapKhau;
	}

	public DNDangKyHoSo getFiDNDangKyHoSo() {
		return this.fiDNDangKyHoSo;
	}

	public void setFiDNDangKyHoSo(DNDangKyHoSo fiDNDangKyHoSo) {
		this.fiDNDangKyHoSo = fiDNDangKyHoSo;
	}

	public DNYeuCauRutHS getFiDNYeuCauRutHS() {
		return this.fiDNYeuCauRutHS;
	}

	public void setFiDNYeuCauRutHS(DNYeuCauRutHS fiDNYeuCauRutHS) {
		this.fiDNYeuCauRutHS = fiDNYeuCauRutHS;
	}

	public DNYeuCauSuaHS getFiDNYeuCauSuaHS() {
		return this.fiDNYeuCauSuaHS;
	}

	public void setFiDNYeuCauSuaHS(DNYeuCauSuaHS fiDNYeuCauSuaHS) {
		this.fiDNYeuCauSuaHS = fiDNYeuCauSuaHS;
	}

	public KetQuaThamDinh getFiKetQuaThamDinh() {
		return this.fiKetQuaThamDinh;
	}

	public void setFiKetQuaThamDinh(KetQuaThamDinh fiKetQuaThamDinh) {
		this.fiKetQuaThamDinh = fiKetQuaThamDinh;
	}


	public DNYeuCauRutHSSauTiepNhan getFiDnYeuCauRutHSSauTiepNhan() {
		return fiDnYeuCauRutHSSauTiepNhan;
	}

	public void setFiDnYeuCauRutHSSauTiepNhan(DNYeuCauRutHSSauTiepNhan fiDnYeuCauRutHSSauTiepNhan) {
		this.fiDnYeuCauRutHSSauTiepNhan = fiDnYeuCauRutHSSauTiepNhan;
	}

	public DNYeuCauChinhSuaGP getFiDnYeuCauChinhSuaGP() {
		return fiDnYeuCauChinhSuaGP;
	}

	public void setFiDnYeuCauChinhSuaGP(DNYeuCauChinhSuaGP fiDnYeuCauChinhSuaGP) {
		this.fiDnYeuCauChinhSuaGP = fiDnYeuCauChinhSuaGP;
	}

	public BNNTuChoiYeuCauSuaGP getFiBnnTuChoiYeuCauSuaGP() {
		return fiBnnTuChoiYeuCauSuaGP;
	}

	public void setFiBnnTuChoiYeuCauSuaGP(BNNTuChoiYeuCauSuaGP fiBnnTuChoiYeuCauSuaGP) {
		this.fiBnnTuChoiYeuCauSuaGP = fiBnnTuChoiYeuCauSuaGP;
	}

	public static final Logger logger = LoggerFactory.getLogger(Content.class);
  	
  	public String toXml() throws JAXBException {
		try {
			JAXBContext context = JAXBContext.newInstance(Content.class);
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			OutputStream output = new OutputStream() {
				private StringBuilder string = new StringBuilder();

				@Override
				public void write(int b) throws IOException {
					this.string.append((char) b);
				}

				public String toString() {
					return this.string.toString();
				}
			};
			m.marshal(this, output);
			return output.toString();
		} catch (Exception e) {
			logger.error("ERROR WHILE PARSE TO XML: {}", e);
			return null;
		}
	}

}
