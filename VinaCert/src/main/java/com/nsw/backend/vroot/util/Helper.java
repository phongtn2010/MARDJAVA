package com.nsw.backend.vroot.util;

public class Helper {
    public static String switchCategoryTypeByCatNo(Long fiCatNo){
        String catTypeName="";
        switch (fiCatNo.intValue()){
            case 3:
                catTypeName="Danh mục đơn vị CT AT- CL";
                break;
            case 4:
                catTypeName="Danh mục Phân nhóm TACN";
                break;
            case 5:
                catTypeName="Danh mục loại TACN";
                break;
            case 6:
                catTypeName="Danh mục phân loại TACN";
                break;
            case 7:
                catTypeName="Danh mục chỉ tiêu số lượng";
                break;
            case 10:
                catTypeName="Danh mục chỉ tiêu khối lượng";
                break;
            case 26:
                catTypeName="Danh mục tiền tệ";
                break;
            default:
                break;
        }
        return catTypeName;
    }
}
