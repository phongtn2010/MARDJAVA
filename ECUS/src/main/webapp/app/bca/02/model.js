/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* global app, RAW_HS_STATUS */

var TAO_MOI = 0;
var CHO_TIEP_NHAN = 1;
var DA_TIEP_NHAN = 2;
var YC_BO_SUNG = 3;
var DA_RUT_HOSO = 4;
var DA_BO_SUNG_HOSO = 5;
var YC_SUA_GIAYPHEP = 6;
var DONG_Y_YC_SUA_GP = 7;
var TU_CHOI_CAP_GIAYPHEP = 8;
var DUOC_CAP_GIAYPHEP = 9;
var DA_CAP_LAI_GIAYPHEP = 10;
var DA_THU_HOI = 11;
var TU_CHOI_YC_SUA_GP = 12;
var YC_RUT_HOSO = 13;
var DONG_Y_YC_RUT = 14;
var TU_CHOI_YC_RUT = 15;
var YC_SUA_HOSO = 16;
var DONG_Y_YC_SUA = 17;
var TU_CHOI_YC_SUA = 18;
var DA_DUYET = 19;
var THONG_BAO_PHI = 20;
var DA_THANH_TOAN = 21;
var YC_BS_PHI = 22;
var XACNHAN_THANHTOAN_PHI = 23;

function ConfirmMessageVM(fiMsg, fiMaHoso) {
    var self = this;
    self.fiMsg = ko.observable(fiMsg);
    self.fiMaHoso = ko.observable(fiMaHoso);
}

ko.observableArray.fn.firstIndexOf = function (predicate, predicateOwner) {
    for (var i = 0, j = this().length; i < j; i++) {
        if (predicate.call(predicateOwner, this()[i])) {
            return i;
        }
    }
    return -1;
};

var mapTbdlichsu02 = function (dataFromServer, p) {
    return ko.utils.arrayMap(dataFromServer, function (item, index) {
        return new Tbdlichsu02(index + 1 + p, item);
    });
};
var Tbdlichsu02 = function (STT, item) {
    var self = this;
    this.STT = ko.observable(STT);
    if (item != null) {
        ko.mapping.fromJS(item, {}, self);
    }

    self.fiNgaytao = ko.observable(item.fiNgaytao ? new Date(item.fiNgaytao).toDayFirstWithTime() : null);
};

var mapCategory = function (dataFromServer, idName, textName) {
    if (idName && textName) {
        return ko.utils.arrayMap(dataFromServer, function (item) {
            return new Category(item[idName], item[textName]);
        });
    } else {
        return ko.utils.arrayMap(dataFromServer, function (item) {
            return new Category(item.id, item.name);
        });
    }
};
var Category = function (id, name) {
    this.id = id;
    this.name = name;
};

var mapTbdhoso02 = function (d, p) {
    return ko.utils.arrayMap(d, function (item, index) {
        return new Tbdhoso02((index + 1) + p, item);
    });
};
function Tbdhoso02(STT, item) {
    var self = this;

    if (item) {
        ko.mapping.fromJS(item, {}, self);
    }
    self.fiTenTrangthai = ko.computed(function () {
        if (!RAW_HS_STATUS || RAW_HS_STATUS.length <= 0) {
            return self.fiTrangthai();
        } else {
            for (var i = 0; i < RAW_HS_STATUS.length; i++) {
                if (RAW_HS_STATUS[i]["id"] == self.fiTrangthai()) {
                    return RAW_HS_STATUS[i]["name"] ? RAW_HS_STATUS[i]["name"] : self.fiTrangthai();
                }
            }
        }
    }, self);

    if ([DUOC_CAP_GIAYPHEP, DA_CAP_LAI_GIAYPHEP, YC_SUA_GIAYPHEP, DONG_Y_YC_SUA_GP, TU_CHOI_CAP_GIAYPHEP].indexOf(self.fiTrangthai()) < 0) {
        self.fiNgaycapGp(null);
    }

    self.STT = ko.observable(STT);
    self.bXemLichSu = ko.dependentObservable(function () {
        return true;
    }, self);
    self.bSuaHoSo = ko.dependentObservable(function () {
        //return true;
        return [TAO_MOI, CHO_TIEP_NHAN, YC_BO_SUNG].indexOf(self.fiTrangthai()) >= 0;
    }, self);
    self.bXinSuaHoSo = ko.dependentObservable(function () {
        //return true;
        return [DA_TIEP_NHAN, DONG_Y_YC_SUA, TU_CHOI_YC_SUA, DA_BO_SUNG_HOSO, DA_DUYET].indexOf(self.fiTrangthai()) >= 0;
    }, self);
    self.bXinRutHoSo = ko.dependentObservable(function () {
        //return true;
        return [DONG_Y_YC_SUA_GP, TU_CHOI_CAP_GIAYPHEP, DUOC_CAP_GIAYPHEP
                    , DA_CAP_LAI_GIAYPHEP, TU_CHOI_YC_SUA_GP, DONG_Y_YC_RUT, DA_RUT_HOSO
                    , YC_RUT_HOSO, YC_SUA_HOSO, TAO_MOI, DA_THU_HOI, YC_SUA_GIAYPHEP].indexOf(self.fiTrangthai()) <= 0;

    }, self);
    self.bThongTinPhi = ko.dependentObservable(function () {
        return [THONG_BAO_PHI, YC_BS_PHI].indexOf(self.fiTrangthai()) >= 0;
    }, self);
    self.bXoaHoSo = ko.dependentObservable(function () {
        //return true;
        return [TAO_MOI].indexOf(self.fiTrangthai()) >= 0;
    }, self);
    self.bXemThongBao = ko.dependentObservable(function () {
        //return true;
        return [DUOC_CAP_GIAYPHEP, DA_CAP_LAI_GIAYPHEP, TU_CHOI_YC_SUA_GP, YC_SUA_GIAYPHEP].indexOf(self.fiTrangthai()) >= 0;
    }, self);


    self.fiNgayguiText = ko.observable(item.fiNgaygui ? new Date(item.fiNgaygui).toDayFirstWithTime() : null);
}

function TbdhsNguoidk02(data, i) {
    
    var self = this;
    self.STT = ko.observable(i);
    self.fiId = ko.observable(data ? data.fiId : null);
    self.fiIdHoso = ko.observable(data.fiIdHoso ? data.fiIdHoso : null);
    self.flagValid1 = ko.observable(data.flagValid ? data.flagValid : true);
    self.flagValid2 = ko.observable(data.flagValid ? data.flagValid : true);
    self.flagValid3 = ko.observable(data.flagValid ? data.flagValid : true);
    
    self.fiGhichu = ko.observable(data.fiGhichu ? data.fiGhichu : null);
    self.fiTenDv = ko.observable(data.fiTenDv ? data.fiTenDv : null);
    self.fiLoai = ko.observable(data.fiLoai ? data.fiLoai : null);
    
    self.fiTenNguoidk = ko.observable(data.fiTenNguoidk ? data.fiTenNguoidk : null).extend({
        maxLength: {message: 'Tối đa 100 ký tự', params: 100}
    });
    self.fiSocmndNguoidk = ko.observable(data.fiSocmndNguoidk ? data.fiSocmndNguoidk : null).extend({
        maxLength: {message: 'Tối đa 50 ký tự', params: 50}
    });
    self.fiBksPhuongtien = ko.observable(data.fiBksPhuongtien ? data.fiBksPhuongtien : null).extend({
        maxLength: {message: 'Tối đa 50 ký tự', params: 50}
    });

    self.fiKhoiluongVc = ko.observable(data.fiKhoiluongVc ? data.fiKhoiluongVc : null).extend({
        maxLength: {message: 'Tối đa 2000 ký tự', params: 2000},
        pattern: {
            message: 'Bạn phải nhập số hoặc số thập phân sau dấu phẩy 3 chữ số. Ví dụ: 15.234',
            params: /^[0-9]{0,15}(?:\.[0-9]{0,3})?$/
        }
    });
    

    self.fiTenDv = ko.observable(data ? data.fiTenDv : null);
    self.fiGhichu = ko.observable(data ? data.fiGhichu : null).extend({
        maxLength: {message: 'Tối đa 500 ký tự', params: 500}
    });


    var nguoiDkVG = [self.fiLoai, self.fiTenNguoidk, self.fiSocmndNguoidk, self.fiBksPhuongtien, self.fiTenDv, self.fiKhoiluongVc, self.fiGhichu];
    var nguoiApTaiVG = [self.fiLoai, self.fiTenNguoidk, self.fiSocmndNguoidk, self.fiBksPhuongtien];
    self.nguoiDkError = ko.validation.group(nguoiDkVG, {deep: true, live: true, observable: true});
    self.nguoiApTaiError = ko.validation.group(nguoiApTaiVG, {deep: true, live: true, observable: true});
    
    
    self.changeValidData = function () {
        if(self.fiLoai() === undefined) $("#fiLoai_lbl_"+self.STT()).show();
        else {
            $("#fiLoai_lbl_"+self.STT()).hide();
            validType();
        }

        if(self.fiTenNguoidk()===null) $("#fiTenNguoidk_lbl_"+self.STT()).show();
        else $("#fiTenNguoidk_lbl_"+self.STT()).hide(); 

        if(self.fiSocmndNguoidk()===null) $("#fiSocmndNguoidk_lbl_"+self.STT()).show();
        else $("#fiSocmndNguoidk_lbl_"+self.STT()).hide();

        if(self.fiBksPhuongtien()===null) $("#fiBksPhuongtien_lbl_"+self.STT()).show();
        else $("#fiBksPhuongtien_lbl_"+self.STT()).hide();
        
        
    }
    
    function validType(){
        if(self.fiLoai()===1){
            if(self.fiTenDv()===undefined) {
                self.flagValid1(false);
                $("#fiTenDv_lbl_"+self.STT()).show();
            }else {
                self.flagValid1(true);
                $("#fiTenDv_lbl_"+self.STT()).hide();
            }
                
            if(self.fiKhoiluongVc()===null) {
                self.flagValid2(false);
                $("#fiKhoiluongVc_lbl_"+self.STT()).show();
            }else {
                self.flagValid2(true);
                $("#fiKhoiluongVc_lbl_"+self.STT()).hide();
            }
                
            if(self.fiGhichu()===null){
                self.flagValid3(false);
                $("#fiGhichu_lbl_"+self.STT()).show();
            }else {
                self.flagValid3(true);
                $("#fiGhichu_lbl_"+self.STT()).hide();
            }
        }else{
           self.flagValid1(true);
           self.flagValid2(true);
           self.flagValid3(true);
           $("#fiTenDv_lbl_"+self.STT()).hide(); 
           $("#fiKhoiluongVc_lbl_"+self.STT()).hide();
           $("#fiGhichu_lbl_"+self.STT()).hide();
        }
    }
}

var mapTbdhsNguoidk02 = function (d) {
    return ko.utils.arrayMap(d, function (item, index) {
        item.STT = index + 1;
        return new TbdhsNguoidk02(item, index + 1);
    });
}

