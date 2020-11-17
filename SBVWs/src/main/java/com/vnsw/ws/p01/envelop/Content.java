package com.vnsw.ws.p01.envelop;

import com.vnsw.ws.p01.message.receive.GiayPhep;
import com.vnsw.ws.p01.message.receive.KetQuaXuLyHoSo;
import com.vnsw.ws.p01.message.send.HoSoNgoaiTe;
import com.vnsw.ws.p01.message.send.YeuCauRut;
import com.vnsw.ws.annotations.DateSerialization;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vnsw.ws.common.envelop.Error;
/**
 *
 * @author PhongNV9
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Content")
public class Content {

	@Override
	public String toString() {
		return "Content [errorList=" + errorList + ", receiveDate=" + receiveDate + ", hsNgoaiTe=" + hsNgoaiTe
				+ ", yeuCauRut=" + yeuCauRut + ", ketQuaXuLyHoSo=" + ketQuaXuLyHoSo + ", giayPhepHoSo=" + giayPhepHoSo
				+ "]";
	}

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

	//11 Gui Ho so ngoi te
  	@XmlElement(name = "HSDK_GP_XNKngoaite")
  	private HoSoNgoaiTe hsNgoaiTe;
  	
  	public HoSoNgoaiTe getHsNgoaiTe() {
		return hsNgoaiTe;
	}

	public void setHsNgoaiTe(HoSoNgoaiTe hsNgoaiTe) {
		this.hsNgoaiTe = hsNgoaiTe;
	}

	public YeuCauRut getYeuCauRut() {
		return yeuCauRut;
	}

	public void setYeuCauRut(YeuCauRut yeuCauRut) {
		this.yeuCauRut = yeuCauRut;
	}

	public KetQuaXuLyHoSo getKetQuaXuLyHoSo() {
		return ketQuaXuLyHoSo;
	}

	public void setKetQuaXuLyHoSo(KetQuaXuLyHoSo ketQuaXuLyHoSo) {
		this.ketQuaXuLyHoSo = ketQuaXuLyHoSo;
	}

	public GiayPhep getGiayXacNhanHoSo() {
		return giayPhepHoSo;
	}

	public void setGiayXacNhanHoSo(GiayPhep giayPhepHoSo) {
		this.giayPhepHoSo = giayPhepHoSo;
	}

	//12 Gui yeu cau xin huy ho so
  	@XmlElement(name = "RequestCancel")
  	private YeuCauRut yeuCauRut;
  	
  	//32,33 Ket qua nhan ho so
  	@XmlElement(name = "Result")
  	private KetQuaXuLyHoSo ketQuaXuLyHoSo;
  	
  	//31 Nhan giay phep
  	@XmlElement(name = "GP_XNKngoaite")
  	private GiayPhep giayPhepHoSo;
  	
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
