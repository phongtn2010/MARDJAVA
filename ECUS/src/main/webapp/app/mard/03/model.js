/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* global app, RAW_HS_STATUS */

var TAO_MOI = 0;
var CHO_TIEP_NHAN = 1;
var DA_TIEP_NHAN = 2;
var YC_BOSUNG_HS = 3;
var DA_BOSUNG_HS = 4;
var RUT_HS = 5;
var TUCHOI_HS = 6;
var XACNHAN_DON_DK = 7;
var XINRUT_HS = 8;
var DONG_Y_XINRUT_HS = 9;
var TC_XIN_RUT = 10;
var XINSUA_HS = 11;
var DONGY_CHINHSUA_HS = 12;
var TC_YC_SUA_HS = 13;
var TB_APPHI = 14;
var XACNHAN_PHI = 15;
var LO_HANG_CANXL = 16;
var GIAY_CN_KDDV_NK = 17;
var GIAY_CN_KD_SP_DV_NK = 18;
var SUA_GIAY_CN_KDDV_NK = 19;
var SUA_GIAY_CN_KD_SP_DV_NK = 20;
var DN_XIN_SUA_GCN = 21;
var DONGY_XINSUA_GCN_KDDV = 22;
var TC_XIN_SUA_GCN = 23;
var XACNHAN_HANG_QUA_CK = 24;
var DN_XIN_HUY_GCN = 25;
var DONGY_XIN_HUY_GCN = 26;
var TC_XIN_HUY_GCN = 27;
var DN_XIN_CHUYEN_CK = 28;
var CAP_CV_CHUYEN_CK = 29;
var TC_YC_CAP_CV = 30;
var CAP_CHINHSUA_CV_CHUYEN_CK = 31;
var XIN_RUT_CV_CHUYENKHAU = 32;
var DONGY_XINRUT_CV_CHUYEN_CK = 33;
var TC_YC_XINRUT_CV_CHUYEN_CK = 34;
var THUHOI_CV_CHUYEN_CK = 35;
var DONGY_XINSUA_GCN_SPDV = 36;
var XACNHAN_HANG_QUA_CK_16B = 37;
var GUI_SUA_CHUYEN_CK = 38;

function ConfirmMessageVM(fiMsg, nswfileCode) {
    var self = this;
    self.fiMsg = ko.observable(fiMsg);
    self.nswfileCode = ko.observable(nswfileCode);
}

ko.observableArray.fn.firstIndexOf = function (predicate, predicateOwner) {
    for (var i = 0, j = this().length; i < j; i++) {
        if (predicate.call(predicateOwner, this()[i])) {
            return i;
        }
    }
    return -1;
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


var mapTbdhoso03 = function (d, p) {
    return ko.utils.arrayMap(d, function (item, index) {
        return new Tbdhoso03((index + 1) + p, item);
    });
};
function Tbdhoso03(STT, item) {
    var self = this;
    if (item) {
        ko.mapping.fromJS(item, {}, self);
    }
    self.STT = ko.observable(STT);
    self.bXemLichSu = ko.dependentObservable(function () {
        return true;
    }, self);
    self.bSuaHoSo = ko.dependentObservable(function () {
        return [TAO_MOI, CHO_TIEP_NHAN, YC_BOSUNG_HS, DA_BOSUNG_HS].indexOf(self.fiTrangThaiMa()) >= 0;
    }, self);
    self.bXinSuaHoSo = ko.dependentObservable(function () {
        //return true;
        return [DA_TIEP_NHAN, DONGY_CHINHSUA_HS, TC_YC_SUA_HS, XACNHAN_DON_DK].indexOf(self.fiTrangThaiMa()) >= 0;
    }, self);
    self.bXinRutHoSo = ko.dependentObservable(function () {
        return [CHO_TIEP_NHAN, DA_TIEP_NHAN, YC_BOSUNG_HS, DA_BOSUNG_HS, DONGY_CHINHSUA_HS, TC_YC_SUA_HS, TC_XIN_RUT, XACNHAN_DON_DK].indexOf(self.fiTrangThaiMa()) >= 0;
    }, self);
    self.bXoaHoSo = ko.dependentObservable(function () {
        return [TAO_MOI].indexOf(self.fiTrangThaiMa()) >= 0;
    }, self);

    self.bDonkhaibao = ko.dependentObservable(function () {
        return [XACNHAN_DON_DK].indexOf(self.fiTrangThaiMa()) >= 0;
    }, self);

    self.bGiayCnhan = ko.dependentObservable(function () {
        return [GIAY_CN_KDDV_NK, GIAY_CN_KD_SP_DV_NK, SUA_GIAY_CN_KDDV_NK, SUA_GIAY_CN_KD_SP_DV_NK, DONGY_XINSUA_GCN_KDDV, DONGY_XINSUA_GCN_SPDV, XACNHAN_HANG_QUA_CK, XACNHAN_HANG_QUA_CK_16B, TC_XIN_SUA_GCN].indexOf(self.fiTrangThaiMa()) >= 0;
    }, self);

    self.bChuyenCkhau = ko.dependentObservable(function () {
        if (self.fiMaNoiDK() == 2 && [TAO_MOI, CHO_TIEP_NHAN, YC_BOSUNG_HS, DA_BOSUNG_HS, RUT_HS, TUCHOI_HS, DONGY_XINRUT_CV_CHUYEN_CK, THUHOI_CV_CHUYEN_CK].indexOf(self.fiTrangThaiMa()) < 0) {
            return true;
        }
    }, self);

    self.bCvChuyenCk = ko.dependentObservable(function () {
        return [CAP_CV_CHUYEN_CK, TC_YC_XINRUT_CV_CHUYEN_CK, CAP_CHINHSUA_CV_CHUYEN_CK].indexOf(self.fiTrangThaiMa()) >= 0;
    }, self);

    self.sendDateText = ko.observable(item.fiNgayTao ? new Date(item.fiNgayTao).toDayFirstWithTime() : null);
//    self.fiNgaycapGpText = ko.observable(item.fiNgaycapGp ? new Date(item.fiNgaycapGp).toDayFirstWithTime() : null);
//    if ([CAP_GP, DA_SUA_GP].indexOf(self.codeStatus()) < 0) {
//        self.fiNgaycapGpText(null);
//    }

}

var mapTbdlichsu03 = function (dataFromServer, p) {
    return ko.utils.arrayMap(dataFromServer, function (item, index) {
        return new Tbdlichsu03(index + 1 + p, item);
    });
};
var Tbdlichsu03 = function (STT, item) {
    var self = this;
    this.STT = ko.observable(STT);
    if (item != null) {
        ko.mapping.fromJS(item, {}, self);
    }

    self.fiNgaytao = ko.observable(item.fiNgaytao ? new Date(item.fiNgaytao).toDayFirstWithTime() : null);
};

var MapHangHoa03 = function (d) {
    return ko.utils.arrayMap(d, function (item, index) {
        item.fiStt = index + 1;
        return new HangHoa03(item, index + 1);
    });
};

function HangHoa03(data) {
    var self = this;
    self.fiStt = ko.observable(data ? data.fiStt : null);
    self.productSort = ko.observable(data ? data.productSort : null);
    self.productId = ko.observable(data ? data.productId : null);
    self.fiHsCode = ko.observable(data ? data.fiHsCode : null);
    self.productName = ko.observable(data ? data.productName : null);
    self.productFrom = ko.observable(data ? data.productFrom : null);
    self.quantity = ko.observable(data ? data.quantity : null);
    self.quantityUnitCode = ko.observable(data ? data.quantityUnitCode : null);
    self.quantityUnitName = ko.observable(data ? data.quantityUnitName : null);

    //type = 1
    self.animalBreed = ko.observable(data ? data.animalBreed : null);
    self.animalMale = ko.observable(data ? data.animalMale : null);
    self.animalMaleName = ko.observable(data ? data.animalMaleName : null);
    self.animalAge = ko.observable(data ? data.animalAge : null);

    // type = 2
    self.netWeight = ko.observable(data ? data.netWeight : null);
    self.netWeightUnitCode = ko.observable(data ? data.netWeightUnitCode : null);
    self.netWeightUnitName = ko.observable(data ? data.netWeightUnitName : null);
    self.grossWeight = ko.observable(data ? data.grossWeight : null);
    self.grossWeightUnitCode = ko.observable(data ? data.grossWeightUnitCode : null);
    self.grossWeightUnitName = ko.observable(data ? data.grossWeightUnitName : null);
    self.packings = ko.observable(data ? data.packings : null);

    self.ptVanchuyen = ko.observable(data ? data.ptVanchuyen : null);
    self.fiCuakhauXuat = ko.observable(data ? data.fiCuakhauXuat : null);
    self.donviXl = ko.observable(data ? data.donviXl : null);
    self.soNiemphong = ko.observable(data ? data.soNiemphong : null);
    self.ptVchuyenMoi = ko.observable(data ? data.ptVchuyenMoi : null);
}

var mapHanghoaSpdv03 = function (d) {
    return ko.utils.arrayMap(d, function (item, index) {
        item.fiStt = index + 1;
        return new HangHoaSpdv03(item, index + 1);
    });
};

function HangHoaSpdv03(data) {
    var self = this;
    self.fiStt = ko.observable(data ? data.fiStt : null);
    self.productSort = ko.observable(data ? data.fiStt : null);
    self.productId = ko.observable(data ? data.fiIdHanghoa : null);
    self.fiHsCode = ko.observable(data ? data.fiSohieu : null);//
    self.productName = ko.observable(data ? data.fiTenhang : null);
    self.productFrom = ko.observable(null);
    self.quantity = ko.observable(data ? data.fiSoluong : null);
    self.quantityUnitCode = ko.observable(null);
    self.quantityUnitName = ko.observable(null);

    //type = 1
    self.animalBreed = ko.observable(data ? data.fiGiongloai : null);
    self.animalMale = ko.observable(data ? data.fiMaGioitinh : null);
    self.animalMaleName = ko.observable(data ? data.fiGioitinh : null);
    self.animalAge = ko.observable(data ? data.fiTuoi : null);

    // type = 2
    self.netWeight = ko.observable(data ? data.fiKhoiluong : null);
    self.netWeightUnitCode = ko.observable(null);
    self.netWeightUnitName = ko.observable(null);
    self.grossWeight = ko.observable(null);
    self.grossWeightUnitCode = ko.observable(null);
    self.grossWeightUnitName = ko.observable(null);
    self.packings = ko.observable(data ? data.fiDonggoi : null);

}
