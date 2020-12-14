package com.nsw.mard.p17.rest;



public class NumberToWord {
	static String unitsArray[] = { "không", "một", "hai", "ba", "bốn", "năm", "sáu", "bảy", "tám", "chín" };
	private static String dochangchuc(Integer so, boolean daydu) {
	    String chuoi = "";
	    Integer chuc = (int) Math.floor(so / 10);
        int donvi =  (int)(so % 10);
    
	    if (chuc > 1) {
	        chuoi = " " + unitsArray[chuc] + " mươi";
	        if (donvi == 1) {
	            chuoi += " mốt";
	        }
	    } else if (chuc == 1) {
	        chuoi = " mười";
	        if (donvi == 1) {
	            chuoi += " một";
	        }
	    } else if (daydu && donvi > 0) {
	        chuoi = " lẻ";
	    }
	    if (donvi == 5 && chuc > 1) {
	        chuoi += " lăm";
	    } else if (donvi > 1 || (donvi == 1 && chuc == 0)) {
	        chuoi += " " + unitsArray[donvi];
	    }
	    return chuoi;
	}
	private static String docblock(Integer so,boolean daydu) {
        String chuoi = "";
        Integer tram = (int)Math.floor(so / 100);
        so = so % 100;
        if (daydu || tram > 0) {
            chuoi = " " + unitsArray[tram] + " trăm";
            chuoi += dochangchuc(so, true);
        } else {
            chuoi = dochangchuc(so, false);
        }
        return chuoi;
    }
	private static String dochangtrieu(Integer so,boolean daydu) {
	    String chuoi = "";
	    Integer trieu = (int)Math.floor(so / 1000000);
	    so = so % 1000000;
	    if (trieu > 0) {
	        chuoi = docblock((int)trieu, daydu) + " triệu";
	        daydu = true;
	    }
	    Integer nghin = (int)Math.floor(so / 1000);
	    so = so % 1000;
	    if (nghin > 0) {
	        chuoi += docblock((int)nghin, daydu) + " nghìn";
	        daydu = true;
	    }
	    if (so > 0) {
	        chuoi += docblock(so, daydu);
	    }
	    return chuoi;
	}
	public static String docso(Integer so) {
        if (so == 0) return unitsArray[0];
        String chuoi = "", hauto = "";
        do {
			Integer ty = so % 1000000000;
            so = (int)Math.floor(so / 1000000000);
            if (so > 0) {
                chuoi = dochangtrieu(ty, true) + hauto + chuoi;
            } else {
                chuoi = dochangtrieu(ty, false) + hauto + chuoi;
            }
            hauto = " tỷ";
        } while (so > 0);

        return chuoi;
    }
}