package com.nsw.backend.helper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.docx4j.Docx4J;
import org.docx4j.convert.out.FOSettings;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class CommonDocProcess {
	public static final Logger logger = LoggerFactory.getLogger(CommonDocProcess.class);
	/**
	 * Xua file sang pdf
	 * @param wmp
	 * @param folder
	 * @param fileName
	 * @return
	 */
	public FileOutputStream exportPdf(WordprocessingMLPackage wmp, String folder, String fileName){
		FileOutputStream fo = null;
		try {
			File file = new File(folder + fileName);
			fo = new FileOutputStream(file);
			FOSettings foSettings = Docx4J.createFOSettings();
			foSettings.setWmlPackage(wmp);
			Docx4J.toFO(foSettings, fo, Docx4J.FLAG_NONE);
			System.out.println("Convert Pdf Done");
		} catch (FileNotFoundException | Docx4JException e) {
			logger.error(e.getMessage());
		}
		return fo;
    }
	/**
	 * Ngat dong de cho hien thi trong bang khong bi tran
	 * @param str
	 * @param lengthOne
	 * @return
	 */
	public String wrapText(String str, int lengthOne) {
		String result = "";
		if (str != null && !"".equals(str)) {
			String[] lst = str.split(" ");
			for (String objStr : lst) {
				objStr = wrapOneText(objStr, lengthOne);
				result += objStr;
				result += " ";
			}
		}
		return result;

	}
	/**
	 * Ngat xau, 1 xau lien khong dau cach
	 * @param str
	 * @param lengthOne
	 * @return
	 */
	public String wrapOneText(String str, int lengthOne) {
		String returnStr = "";
		int numberBreak = str.length() / lengthOne;
		int maxleng = 0;
		int value = numberBreak + 1;
		for (int a = 0; a < value; a++) {
			if (str.length() < lengthOne * (a + 1)) {
				maxleng = str.length();
			} else {
				maxleng = lengthOne * (a + 1);
			}
			returnStr = returnStr + str.substring(lengthOne * a, maxleng) + " ";
		}
		return returnStr;

	}
	
}
