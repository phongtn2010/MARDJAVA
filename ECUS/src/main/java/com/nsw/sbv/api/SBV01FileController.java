package com.nsw.sbv.api;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.nsw.common.model.ResponseUpload;
import com.nsw.common.model.json.ResponseJson;
import com.nsw.constant.AppConstant;
import com.nsw.helper.RabbitMQErrorHelper;
import com.nsw.helper.RabbitMQInfo;
import com.nsw.sbv.p01.model.HoSoNgoaiTe1;
import com.nsw.sbv.p01.model.KetQuaXuLyHoSo1;
import com.nsw.sbv.p01.model.TepDinhKemHoSo1;
import com.nsw.sbv.p01.util.FileServiceHelper;
import com.nsw.sbv.p01.util.SBV01Constants;
import com.nsw.sbv.p01.util.SBV01HoSoNgoaiTe1BackendUtil;
import com.nsw.sbv.p01.util.SBV01KetQuaXuLyHoSo1BackendUtil;
import com.nsw.sbv.p01.util.SBV01TepDinhKemHoSo1BackendUtil;

@Controller
@RequestMapping(value = SBV01Constants.ApiUrls.ROOT)
public class SBV01FileController extends SBV01BaseController {

	static final Logger LOGGER = LoggerFactory.getLogger(SBV01FileController.class);
	private static final String CLASS_NAME = "FileUploadController";
	private static final int BUFFER_SIZE = 4096;
	FileServiceHelper fileHelper = new FileServiceHelper();

	private static final String BACKEND_URL_UPLOAD_KEY = "com.nsw.sbv.p01.upload";
	private static final String BACKEND_URL_DOWNLOAD_KEY = "com.nsw.sbv.p01.download";
	private static final String BACKEND_URL_KEY = "sbv.01.backend";
	private static final String UNDEFINED_INPUT = "undefined,";

	@RequestMapping(value = "/upload/{idHoSo}/{maLoaiTepTin}", method = RequestMethod.POST)
	public @ResponseBody ResponseJson uploadFile(@RequestParam("file") MultipartFile file,
			@RequestParam("mcode") String mcode, @RequestParam("pcode") String pcode, HttpServletRequest request,
			@PathVariable("idHoSo") long idHoSo, @PathVariable("maLoaiTepTin") int maLoaiTepTin) {
		if (StringUtils.hasText(mcode) && mcode.startsWith(UNDEFINED_INPUT)) {
			mcode = mcode.replace(UNDEFINED_INPUT, "");
		}
		if (StringUtils.hasText(pcode) && pcode.startsWith(UNDEFINED_INPUT)) {
			pcode = pcode.replace(UNDEFINED_INPUT, "");
		}
		ResponseJson json = new ResponseJson();
		json.setSuccess(false);
		json.setMessage(getMessage(SBV01Constants.MessageKeys.ACTION_ERROR, null, request.getLocale()));
		RabbitMQInfo mqInfo = getRabbitMQ();
		try {
			if (file.isEmpty() || !StringUtils.hasText(mcode) || !StringUtils.hasText(pcode)) {
				return json;
			}

			String tempFolder = environment.getProperty(AppConstant.Download.TemSaveFolder);
			String uri = getFullUri(environment.getRequiredProperty(BACKEND_URL_UPLOAD_KEY));
			ResponseJson responseJson = fileHelper.uploadFile(uri, file, tempFolder, mcode, pcode, mqInfo);
			if (!isUploadSuccess(responseJson))
				return json;
			json = responseJson;
			ResponseUpload responseUpload = readObject(json, ResponseUpload.class);
			if (responseUpload != null) {
				String uuId = FilenameUtils.getBaseName(responseUpload.getFileCode());

				TepDinhKemHoSo1 tepDinhKemHoSo1 = new TepDinhKemHoSo1();
				tepDinhKemHoSo1.setIdTepDK(0);
				tepDinhKemHoSo1.setGuID(uuId);
				tepDinhKemHoSo1.setDuongDanFile(responseUpload.getFilePath());
				tepDinhKemHoSo1.setIdHoSo(idHoSo);
				tepDinhKemHoSo1.setTenTepDinhKem(responseUpload.getFileName());
				tepDinhKemHoSo1.setMaLoaiTepDinhKem(String.valueOf(maLoaiTepTin));
				tepDinhKemHoSo1.setTenLoaiTepDinhKem(getTenLoaiTepTin(request, maLoaiTepTin));
				tepDinhKemHoSo1.setLoaiTep(FilenameUtils.getExtension(responseUpload.getFileCode()));
				if (idHoSo > 0) {
					tepDinhKemHoSo1 = SBV01TepDinhKemHoSo1BackendUtil.createTepDinhKemHoSo1(
							getFullUri(environment.getRequiredProperty(CREATE_TEP_DINH_KEM)),
							tepDinhKemHoSo1);
					if (tepDinhKemHoSo1 != null) {
						HoSoNgoaiTe1 hoSoNgoaiTe1 = SBV01HoSoNgoaiTe1BackendUtil.getHoSoNgoaiTe1(getURL(GET_HO_SO), idHoSo);
						String tep = "[ ";
						tep += tepDinhKemHoSo1.getTenLoaiTepDinhKem();
						tep += " | " + tepDinhKemHoSo1.getTenTepDinhKem();
						tep += " ]";
						saveLichSuHoSo(request, idHoSo, hoSoNgoaiTe1.getTrangThai(), LICH_SU_SUA_HO_SO_THEM_TEP_TIN, tep, hoSoNgoaiTe1.getMaHoSo());
					}
				}

				json.setData(tepDinhKemHoSo1);
				json.setMessage(getMessage(SBV01Constants.MessageKeys.ACTION_SUCCESS, null, request.getLocale()));
				json.setSuccess(true);

			}

		} catch (Exception ex) {
			String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + CLASS_NAME
					+ AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
					+ AppConstant.MESSAGE_SEPARATOR + ex.toString();

			LOGGER.error(ex.getMessage(), ex);
			RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, mqInfo);
		}

		return json;
	}

	private boolean isUploadSuccess(ResponseJson responseJson) {
		boolean isTrue = true;
		if (responseJson == null || !responseJson.isSuccess() || responseJson.getData() == null)
			return false;

		return isTrue;
	}

	private String getTenLoaiTepTin(HttpServletRequest request, int maLoaiTepTin) {
		if (maLoaiTepTin == SBV01Constants.TepDinhKems.TEP_LOAI_2) {
			return getMessage("sbv.01.form.teptin.03", null, request.getLocale());
		}
		if (maLoaiTepTin == SBV01Constants.TepDinhKems.TEP_LOAI_3) {
			return getMessage("sbv.01.form.teptin.04", null, request.getLocale());
		}
		return getMessage("sbv.01.form.teptin.02", null, request.getLocale());
	}

	@RequestMapping(value = "/download/{idTepDinhKem}", method = RequestMethod.GET)
	public void downloadFile(HttpServletResponse response, @PathVariable("idTepDinhKem") long idTepDinhKem) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			try {

				TepDinhKemHoSo1 tepDinhKemHoSo1 = SBV01TepDinhKemHoSo1BackendUtil.getTepDinhKemHoSo1(
						getFullUri(environment.getRequiredProperty(GET_TEP_DINH_KEM)),
						idTepDinhKem);

				if (tepDinhKemHoSo1 != null) {
					String loaiTep = tepDinhKemHoSo1.getLoaiTep();
					if (!StringUtils.hasText(loaiTep)) loaiTep = FilenameUtils.getExtension(tepDinhKemHoSo1.getTenTepDinhKem());
					String fileCode = tepDinhKemHoSo1.getGuID() + "." + loaiTep;
					downloadFile(response, fileCode, tepDinhKemHoSo1.getTenTepDinhKem(), fileCode,
							tepDinhKemHoSo1.getDuongDanFile());
				}
			} catch (Exception ex) {
				LOGGER.error(ex.getMessage(), ex);
			}
		}
	}
	
	@RequestMapping(value = "/downloadKQXL/{idKetQuaXL}", method = RequestMethod.GET)
	public void downloadFileKetQuaXuLy(HttpServletResponse response, @PathVariable("idKetQuaXL") long idKetQuaXL) {
		RabbitMQInfo mqInfo = getRabbitMQ();
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			try {

				KetQuaXuLyHoSo1 tepDinhKemHoSo1 = SBV01KetQuaXuLyHoSo1BackendUtil.getKetQuaXuLyHoSo1(getFullUri(environment.getRequiredProperty(GET_KET_QUA_XU_LY)),  idKetQuaXL);
				if (tepDinhKemHoSo1 != null) {
					String fileCode = tepDinhKemHoSo1.getGuID() + "." + FilenameUtils.getExtension(tepDinhKemHoSo1.getTenTepDinhKem());
					downloadFile(response, fileCode, tepDinhKemHoSo1.getTenTepDinhKem(), fileCode,
							tepDinhKemHoSo1.getDuongDanFile());
				}
			} catch (Exception ex) {
				String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + CLASS_NAME
						+ AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
						+ AppConstant.MESSAGE_SEPARATOR + ex.toString();

				LOGGER.error(ex.getMessage(), ex);
				RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, mqInfo);
			}
		}
	}

	@RequestMapping(value = "/getfile/{mcode}/{pcode}/{code}", method = RequestMethod.GET)
	public void downloadNewFile(HttpServletResponse response, @PathVariable("code") String code,
			@PathVariable("mcode") String mCode, @PathVariable("pcode") String pCode) {
		RabbitMQInfo mqInfo = getRabbitMQ();
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			try {
				if (code != null) {
					Date date = new Date();
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
					String spack = "/";
					String filePath = mCode + spack + pCode + spack + dateFormat.format(date);
					downloadFile2(response, code, code, filePath);
				}
			} catch (Exception ex) {

				LOGGER.error(ex.getMessage(), ex);
				String errorInfo = AppConstant.APP_NAME + AppConstant.MESSAGE_SEPARATOR + CLASS_NAME
						+ AppConstant.MESSAGE_SEPARATOR + Thread.currentThread().getStackTrace()[1].getMethodName()
						+ AppConstant.MESSAGE_SEPARATOR + ex.toString();

				RabbitMQErrorHelper.pushLogToRabbitMQ(errorInfo, mqInfo);
			}
		}
	}

	private void downloadFile(HttpServletResponse response, String fileCode, String fileName, String fileCodeDb,
			String filePathDb) throws IOException {
		String name = fileName;
		String path = filePathDb;
		String mimeType = "";
		RabbitMQInfo mqInfo = getRabbitMQ();
		if (name == null) {
			name = fileCode;
		}

		if (fileCodeDb.equals(fileCode)) {
			String uri = getFullUri(environment.getProperty(BACKEND_URL_DOWNLOAD_KEY));
			byte[] fileByte = fileHelper.downloadFile(uri, path, fileCode, mqInfo);

			LOGGER.info("SIZE = {}, {}, {}", fileCode, fileName, fileCodeDb);
			Path savePath = Paths.get(environment.getProperty(AppConstant.Download.TemSaveFolder) + name);
			Files.write(savePath, fileByte);

			File downloadFile = savePath.toFile();

			mimeType = URLConnection.guessContentTypeFromName(name);
			if (mimeType == null) {
				mimeType = "application/octet-stream";
			}

			response.setContentType(mimeType);
			response.setHeader("Content-Disposition", String.format("attachment; filename=\"%s\"", name));
			response.setContentLength((int) downloadFile.length());

			try (OutputStream outStream = response.getOutputStream();
					FileInputStream inputStream = new FileInputStream(downloadFile)) {

				byte[] buffer = new byte[BUFFER_SIZE];
				int bytesRead = -1;

				while ((bytesRead = inputStream.read(buffer)) != -1) {
					outStream.write(buffer, 0, bytesRead);
				}
			}
			Files.delete(savePath);
		}
	}

	private void downloadFile2(HttpServletResponse response, String fileCode, String fileName, String filePathDb)
			throws IOException {
		String name = fileName;
		String path = filePathDb;
		String mimeType = "";
		RabbitMQInfo mqInfo = getRabbitMQ();
		if (name == null) {
			name = fileCode;
		}

		String uri = getFullUri(environment.getProperty(BACKEND_URL_DOWNLOAD_KEY));
		byte[] fileByte = fileHelper.downloadFile(uri, path, fileCode, mqInfo);

		Path savePath = Paths.get(environment.getProperty(AppConstant.Download.TemSaveFolder) + name);
		Files.write(savePath, fileByte);

		File downloadFile = savePath.toFile();

		mimeType = URLConnection.guessContentTypeFromName(name);
		if (mimeType == null) {
			mimeType = "application/octet-stream";
		}

		response.setContentType(mimeType);
		response.setHeader("Content-Disposition", String.format("attachment; filename=\"%s\"", name));
		response.setContentLength((int) downloadFile.length());

		try (OutputStream outStream = response.getOutputStream();
				FileInputStream inputStream = new FileInputStream(downloadFile)) {

			byte[] buffer = new byte[BUFFER_SIZE];
			int bytesRead = -1;

			while ((bytesRead = inputStream.read(buffer)) != -1) {
				outStream.write(buffer, 0, bytesRead);
			}
		}
		Files.delete(savePath);
	}

	String getFullUri(String restUri) {
		return environment.getRequiredProperty(BACKEND_URL_KEY) + restUri;
	}

	private RabbitMQInfo getRabbitMQ() {
		return rabbitMQService.getRabbitMQInfo();
	}


}
