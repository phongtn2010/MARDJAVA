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
var YC_RUT_HOSO = 6;
var DONG_Y_YC_RUT = 7;
var TU_CHOI_CAP_VB = 8;
var THONG_BAO_CAP_VB = 9;
var THONG_BAO_CAP_LAI_VB = 10;
var THONG_BAO_THU_HOI_VB = 11;
var TU_CHOI_YC_RUT = 12;

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

var mapTbdLichsu09 = function (dataFromServer) {
    return ko.utils.arrayMap(dataFromServer, function (item, index) {
        return new Tbdlichsu09(index + 1, item);
    });
};
var Tbdlichsu09 = function (STT, item) {
    var self = this;
    console.log(item);
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

var mapTbdhoso09 = function (dataFromServer,i) {
    return ko.utils.arrayMap(dataFromServer, function (item, index) {
        return new Tbdhoso09(index+i + 1, item);
    });
};


function Tbdhoso09(STT, item) {
    var self = this;

    if (item) {
        ko.mapping.fromJS(item, {}, self);
    }
    self.fiTenTrangthai = ko.computed(function () {
        if (!RAW_HS_STATUS || RAW_HS_STATUS.length <= 0) {
            return self.fiTrangthai();
        } else {
            for (var i = 0; i < RAW_HS_STATUS.length; i++) {
                if (RAW_HS_STATUS[i]["id"] == self.fiTrangthai) {
                    return RAW_HS_STATUS[i]["name"] ? RAW_HS_STATUS[i]["name"] : self.fiTrangthai();
                }
            }
        }
    }, self);

    self.STT = ko.observable(STT);
    self.bXemLichSu = ko.dependentObservable(function () {
        return true;
    }, self);
    self.bSuaHoSo = ko.dependentObservable(function () {
//        return true;
        return [TAO_MOI, CHO_TIEP_NHAN, YC_BO_SUNG].indexOf(self.fiTrangthai()) >= 0;
    }, self);
    self.bXinRutHoSo = ko.dependentObservable(function () {
//        return true;
        return [CHO_TIEP_NHAN, YC_BO_SUNG, DA_TIEP_NHAN, TU_CHOI_YC_RUT,DA_BO_SUNG_HOSO].indexOf(self.fiTrangthai()) >= 0;
    }, self);
    self.bXoaHoSo = ko.dependentObservable(function () {
        //return true;
        return [TAO_MOI].indexOf(self.fiTrangthai()) >= 0;
    }, self);
    self.bXemThongBao = ko.dependentObservable(function () {
        //return true;
        return [THONG_BAO_CAP_VB, THONG_BAO_CAP_LAI_VB].indexOf(self.fiTrangthai()) >= 0;
    }, self);
    
    self.fiNgayguiText = ko.observable(item.fiNgaygui ? new Date(item.fiNgaygui).toDayFirstWithTime() : null);
}
var mapTbdnguongen9 = function (data) {
    return ko.utils.arrayMap(data, function (item, index) {
         item.Stt = index + 1;
        return new Tbdnguongen9(item);
    });
};
function Tbdnguongen9(data,i) {
    var self = this;
    self.stt = ko.observable(i);
    self.fiIdNguongen = ko.observable(data ? data.fiIdNguongen : null);
    self.fiIdHoso = ko.observable(data ? data.fiIdHoso : null);
    self.fiMaNguongen = ko.observable(data ? data.fiMaNguongen : null);
    self.fiTenThongThuong = ko.observable(data ? data.fiTenThongThuong : null);
    self.fiTenKhoaHoc = ko.observable(data ? data.fiTenKhoaHoc : null);
    self.fiTenKhac = ko.observable(data ? data.fiTenKhac : null);
    self.fiThongTinNguonGen = ko.observable(data ? data.fiThongTinNguonGen : null);
    self.fiMoTaNguonGen = ko.observable(data ? data.fiMoTaNguonGen : null);
    self.fiNgaycapnhat = ko.observable(data ? data.fiNgaycapnhat : null);
    self.fiNgaytao = ko.observable(data ? data.fiNgaytao : null);
    self.fiHoatdong = ko.observable(data ? data.fiHoatdong : null);
    self.isShowDel = ko.observable(data ? data.isShowDel : true);
}


function TbdMauGen9(data,index) {
    debugger;
    var self = this;
    self.stt = ko.observable(index);
    self.fiIdMaugen = ko.observable(data ? data.fiIdMaugen : null);
    self.fiIdHoso = ko.observable(data ? data.fiIdHoso : null);
    self.fiTenNguonGen = ko.observable(data ? data.fiTenNguonGen : null);
    self.fiTenMau = ko.observable(data ? data.fiTenMau : null);
    self.fiTenMauKhoaHoc = ko.observable(data ? data.fiTenMauKhoaHoc : null);
    self.fiSoLuong = ko.observable(data ? data.fiSoLuong : null);
    self.fiDonViTinh = ko.observable(data ? data.fiDonViTinh : null);
    self.fiDiaDiem = ko.observable(data ? data.fiDiaDiem : null);
    self.fiCachThucThuThapMau = ko.observable(data ? data.fiCachThucThuThapMau : null);
    self.fiNgaycap = ko.observable(data ? data.fiNgaycap : null);
    self.fiNgaytao = ko.observable(data ? data.fiNgaytao : null);
    self.fiHoatdong = ko.observable(data ? data.fiHoatdong : null);
    self.fiIdNguonGen = ko.observable(data ? data.fiIdNguonGen : null);
}
var mapTbdMauGen9 = function (data) {
    return ko.utils.arrayMap(data, function (item, index) {
        return new TbdMauGen9(item,index + 1);
    });
};






