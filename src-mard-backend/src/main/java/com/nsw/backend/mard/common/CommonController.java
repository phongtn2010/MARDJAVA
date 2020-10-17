package com.nsw.backend.mard.common;

import java.text.DecimalFormat;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.nsw.backend.util.ResponseJson;
import com.nsw.backend.ws.client.ResponseDownload;
import com.nsw.backend.ws.client.ResponseUpload;

/**
 * Các hàm dùng chung
 *
 * @author linhdx
 */
public class CommonController {

	public static final Logger logger = LoggerFactory.getLogger(CommonController.class);

	/**
	 * linhdx log ban tin loi
	 *
	 * @param ex
	 * @return
	 */
	public String logMessage(Exception ex) {
		String errorMessage = ex.getMessage();
		return logMessage(errorMessage);
	}

	/**
	 * linhdx log ban tin
	 *
	 * @param errorMessage
	 * @return
	 */
	public String logMessage(String errorMessage) {
		logger.error(errorMessage);
		return errorMessage;
	}

	/**
	 * Lấy dữ liệu từ cell
	 *
	 * @param cell
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public String getDataCell(XSSFCell cell) {
		String value = "";
		try {
			DataFormatter df = new DataFormatter();

			if (cell.getCellType() == Cell.CELL_TYPE_FORMULA) {
				value = cell.getStringCellValue().trim();
			} else {
				value = df.formatCellValue(cell);
			}

			if (value != null && !"".equals(value)) {
				if (value.contains("E")) {
					try {
						value = convertScientificToDecimalFormat(value);
					} catch (Exception e) {
						logger.error(e.getMessage());
					}
				}
			}
		} catch (Exception ex) {

		}
		return value;

	}

	/**
	 * Xử lý các trường hợp số khoa học bé quá
	 *
	 * @param input
	 * @return
	 */
	private String convertScientificToDecimalFormat(String input) {
		if (input == null) {
			return "";
		}
		String rslt = input;
		String pattern = "###############.#######################";
		DecimalFormat myFormatter = new DecimalFormat(pattern);
		if (input.contains("E-")) {
			String[] arr = input.split("E-");
			Integer tmp2 = Integer.valueOf(arr[1]);
			rslt = shift(arr[0], tmp2);
		} else if (input.contains("E")) {
			String[] arr = input.split("E");
			Double tmp1 = Double.valueOf(arr[0]);
			Long tmp2 = Long.valueOf(arr[1]);
			Double rsltD = tmp1 * Math.pow(10, tmp2);
			rslt = myFormatter.format(rsltD);
		}
		return rslt;

	}

	/**
	 * Dịch chuyển số về sau dấu . trong số thập phân Ví dụ value 5, shif4 thì
	 * sẽ thành 0.00005
	 *
	 * @param value
	 * @param numberShift
	 * @return
	 */
	String shift(String value, int numberShift) {
		String result = "0.";
		value = value.replace(".", "");
		for (int i = 1; i < numberShift; i++) {
			result += "0";
		}
		result += value;
		return result;
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
	@SuppressWarnings("rawtypes")
	public ResponseEntity<ResponseJson> createResponse(List lstResult, boolean isSuccess, String errorMessage,
			HttpStatus httpStatus, Long total) {
		ResponseJson objResponse = new ResponseJson();
		objResponse.setData(lstResult);
		if (total == null) {
			total = lstResult != null ? Long.valueOf(lstResult.size()) : 0L;
		}
		objResponse.setTotal(total);
		objResponse.setSuccess(isSuccess);
		objResponse.setMessage(errorMessage);
		logger.info("response = " + objResponse.toString());
		return new ResponseEntity<>(objResponse, httpStatus);
	}

	/**
	 * linhdx Tao Response Create Response
	 *
	 * @param hoso1
	 * @param isSuccess
	 * @param errorMessage
	 * @param httpStatus
	 * @return
	 */
	public ResponseEntity<ResponseJson> createResponse(Object obj, boolean isSuccess, String errorMessage,
			HttpStatus httpStatus) {
		ResponseJson objResponse = new ResponseJson();
		objResponse.setData(obj);
		objResponse.setSuccess(isSuccess);
		objResponse.setMessage(errorMessage);
		logger.info("response = " + objResponse.toString());
		return new ResponseEntity<>(objResponse, httpStatus);
	}

	/**
	 * Tao respose
	 *
	 * @param res
	 * @param isSuccess
	 * @param errorMessage
	 * @param httpStatus
	 * @return
	 */
	public ResponseEntity<ResponseJson> createResponse(ResponseUpload res, boolean isSuccess, String errorMessage,
			HttpStatus httpStatus) {
		ResponseJson objResponse = new ResponseJson();
		objResponse.setData(res);
		objResponse.setSuccess(isSuccess);
		objResponse.setMessage(errorMessage);
		logger.info("response = " + objResponse.toString());
		return new ResponseEntity<>(objResponse, httpStatus);
	}

	/**
	 * Tao respose
	 *
	 * @param res
	 * @param isSuccess
	 * @param errorMessage
	 * @param httpStatus
	 * @return
	 */
	public ResponseEntity<ResponseJson> createResponse(ResponseDownload res, boolean isSuccess, String errorMessage,
			HttpStatus httpStatus) {
		ResponseJson objResponse = new ResponseJson();
		objResponse.setData(res);
		objResponse.setSuccess(isSuccess);
		objResponse.setMessage(errorMessage);
		logger.info("response = " + objResponse.toString());
		return new ResponseEntity<>(objResponse, httpStatus);
	}
}
