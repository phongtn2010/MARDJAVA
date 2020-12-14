/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* global app, RAW_HS_STATUS */

var TAO_MOI = 0;
var CHO_THONG_BAO_PHI = 1;
var DA_XAC_NHAN_PHI = 2;
var YC_BO_SUNG = 3;
var DA_RUT_HOSO = 4;
var DA_BO_SUNG_HOSO = 5;
var TU_CHOI_CAP_PHEP = 7;
var DUOC_CAP_GIAYPHEP = 8;
var YC_NOP_LAI_PHI = 9;
var THANH_TOAN_PHI_BOSUNG = 10;
var THONG_BAO_AP_PHI = 11;
var CHO_XAC_NHAN_PHI = 12;
var DA_GUI_BAO_CAO_XU_LY = 13;

function UrlItem(d){
    var self = this;
    self.fiTenTep = ko.observable(d.fiTenTep);
    self.fiDuongDan = ko.observable(d.fiDuongDan);
    self.fiMaTep = ko.observable(d.fiMaTep);
}

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

var mapTbdlichsu9 = function (dataFromServer) {
    return ko.utils.arrayMap(dataFromServer, function (item, index) {
        return new Tbdlichsu9(index + 1, item);
    });
};
var Tbdlichsu9 = function (STT, item) {
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

var mapTbdhoso9 = function (d, p) {
    return ko.utils.arrayMap(d, function (item, index) {
        return new Tbdhoso9((index + p) + 1, item);
    });
};
function Tbdhoso9(STT, item) {
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

    if ([DUOC_CAP_GIAYPHEP].indexOf(self.fiTrangthai()) < 0) {
        self.fiNgaycapGcn(null);
    }

    self.STT = ko.observable(STT);
    self.bXemLichSu = ko.dependentObservable(function () {
        return true;
    }, self);

    self.bSuaHoSo = ko.dependentObservable(function () {
        return [TAO_MOI, YC_BO_SUNG, CHO_THONG_BAO_PHI, YC_NOP_LAI_PHI, THONG_BAO_AP_PHI, CHO_XAC_NHAN_PHI].indexOf(self.fiTrangthai()) >= 0;
    }, self);

    self.bGuiHoSo = ko.dependentObservable(function () {
        return [TAO_MOI, YC_BO_SUNG, CHO_THONG_BAO_PHI, YC_NOP_LAI_PHI, THONG_BAO_AP_PHI, CHO_XAC_NHAN_PHI].indexOf(self.fiTrangthai()) >= 0;
    }, self);
    
    self.bXinRutHoSo = ko.dependentObservable(function () {
        return [CHO_THONG_BAO_PHI, YC_NOP_LAI_PHI, THONG_BAO_AP_PHI, CHO_XAC_NHAN_PHI, THANH_TOAN_PHI_BOSUNG].indexOf(self.fiTrangthai()) >= 0;
    }, self);

    self.bXoaHoSo = ko.dependentObservable(function () {
        return [TAO_MOI].indexOf(self.fiTrangthai()) >= 0;
    }, self);

    self.bXemThongBaoPhi = ko.dependentObservable(function () {
        return [THONG_BAO_AP_PHI, YC_NOP_LAI_PHI].indexOf(self.fiTrangthai()) >= 0;
    }, self);

    self.bXemKetQua = ko.dependentObservable(function () {
        return [DUOC_CAP_GIAYPHEP, DA_GUI_BAO_CAO_XU_LY].indexOf(self.fiTrangthai()) >= 0;
    }, self);

    self.bGuiBaoCao = ko.dependentObservable(function () {
        return (null != self.fiCoHhKoDat() && self.fiCoHhKoDat() == 1 && self.fiTrangthai() != DA_GUI_BAO_CAO_XU_LY);
    }, self);

    self.fiNgaynopText = ko.observable(item.fiNgaynop ? new Date(item.fiNgaynop).toDayFirstWithTime() : null);
}

function TbdhsHanghoa9(data) {
    var self = this;

    self.fiStt = ko.observable(data ? data.fiStt : null);
    self.fiIdHanghoa = ko.observable(data ? data.fiIdHanghoa : null);
    self.fiIdHoso = ko.observable(data ? data.fiIdHoso : null);
    self.fiTenHh = ko.observable(data ? data.fiTenHh : null);
    self.fiMaNhomHh = ko.observable(data ? data.fiMaNhomHh : null);
    self.fiTenNhomHh = ko.observable(data ? data.fiTenNhomHh : null);
    self.fiTenNsx = ko.observable(data ? data.fiTenNsx : null);
    self.fiDiachiNsx = ko.observable(data ? data.fiDiachiNsx : null);
    self.fiPtkt = ko.observable(data ? data.fiPtkt : null);
    self.fiSoVbxnPtkt = ko.observable(data ? data.fiSoVbxnPtkt : null);
    self.fiSoCongbo = ko.observable(data ? data.fiSoCongbo : null);

    self.dinhKem = new Tbddinhkem9(data ? data.dinhKem : null);
}

var mapTbdhsHanghoa9 = function (d) {
    return ko.utils.arrayMap(d, function (item, index) {
        item.fiStt = index + 1;
        return new TbdhsHanghoa9(item);
    });
};