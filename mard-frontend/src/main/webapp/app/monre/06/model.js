/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* global app, RAW_HS_STATUS */

var TAO_MOI = 0;
var CHO_TIEP_NHAN = 1;
var DANG_XU_LY = 2;
var YC_BO_SUNG = 3;
var DA_RUT_HOSO = 4;
var DA_BO_SUNG_HOSO = 5;
var YC_RUT_HOSO = 6;
var DONG_Y_YC_RUT = 7;
var TU_CHOI_CAP_TBNK = 8;
var DUOC_CAP_TBNK = 9;
var DA_CAP_LAI_TBNK = 10;
var DA_THU_HOI = 11;
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

var mapTbdLichsu06 = function (dataFromServer) {
    return ko.utils.arrayMap(dataFromServer, function (item, index) {
        return new Tbdlichsu06(index + 1, item);
    });
};
var Tbdlichsu06 = function (STT, item) {
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

var mapTbdhoso06 = function (dataFromServer) {
    return ko.utils.arrayMap(dataFromServer, function (item, index) {
        return new Tbdhoso06(index + 1, item);
    });
};
function Tbdhoso06(STT, item) {
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

    self.STT = ko.observable(STT);
    self.bXemLichSu = ko.dependentObservable(function () {
        return true;
    }, self);
    self.bSuaHoSo = ko.dependentObservable(function () {
        //return true;
        return [TAO_MOI, CHO_TIEP_NHAN, YC_BO_SUNG].indexOf(self.fiTrangthai()) >= 0;
    }, self);
    self.bXinRutHoSo = ko.dependentObservable(function () {
        //return true;
        return [CHO_TIEP_NHAN, YC_BO_SUNG, DANG_XU_LY, TU_CHOI_YC_RUT].indexOf(self.fiTrangthai()) >= 0;
    }, self);
    self.bXoaHoSo = ko.dependentObservable(function () {
        //return true;
        return [TAO_MOI].indexOf(self.fiTrangthai()) >= 0;
    }, self);
    self.bXemThongBao = ko.dependentObservable(function () {
        //return true;
        return [DUOC_CAP_TBNK, DA_CAP_LAI_TBNK].indexOf(self.fiTrangthai()) >= 0;
    }, self);
    
    self.fiNgayguiText = ko.observable(item.fiNgaygui ? new Date(item.fiNgaygui).toDayFirstWithTime() : null);
}

function Tbdlohangpl6(data) {
    var self = this;    
    self.fiIdLohang = ko.observable(data ? data.fiIdLohang : null);
    self.fiLhTen = ko.observable(data ? data.fiLhTen : null);
    self.fiLhTgian = ko.observable(data ? data.fiLhTgian : null);
    self.fiLhMaCuakhau = ko.observable(data ? data.fiLhMaCuakhau : null);
    self.fiLhTenCuakhau = ko.observable(data ? data.fiLhTenCuakhau : null);
    self.fiLhKluong = ko.observable(data ? data.fiLhKluong : null);
    self.fiHoatdong = ko.observable(data ? data.fiHoatdong : null);
    self.fiNguoitao = ko.observable(data ? data.fiNguoitao : null);
    self.fiNgaytao = ko.observable(data ? data.fiNgaytao : null);
    self.fiNgCapnhat = ko.observable(data ? data.fiNgCapnhat : null);
    self.fiIdHoso = ko.observable(data ? data.fiIdHoso : null);
    self.fiIdLoaiPl = ko.observable(data ? data.fiIdLoaiPl : null);
}

function Tbdloaipl6(data) {
    var self = this;
    
    self.fiIdLoaiPl = ko.observable(data ? data.fiIdLoaiPl : null);  
    self.fiIdpl = ko.observable(data ? data.fiIdpl : null);
    self.fiTenloaiPl = ko.observable(data ? data.fiTenloaiPl : null);
    self.fiMaHs = ko.observable(data ? data.fiMaHs : null);
    self.fiHoatdong = ko.observable(data ? data.fiHoatdong : null);
    self.fiNguoitao = ko.observable(data ? data.fiNguoitao : null);
    self.fiNgaytao = ko.observable(data ? data.fiNgaytao : null);
    self.fiNgCapnhat = ko.observable(data ? data.fiNgCapnhat : null);
    self.fiIdHoso = ko.observable(data ? data.fiIdHoso : null);
    
    self.lstLohangPheLieu = ko.observableArray([]);
}

function TbdlohangVM(index, data) {
    var self = this;
    
    self.fiStt = ko.observable(index);
    self.fiIdHoso = ko.observable(data ? data.fiIdHoso : null);
    self.fiIdLohang = ko.observable(data ? data.fiIdLohang : null);//Id tu sinh ngau nhien
    self.fiIdpl = ko.observable(data ? data.fiIdpl : null);//Id cua ban ghi ben thu tuc 01
    self.fiTenloaiPl = ko.observable(data ? data.fiTenloaiPl : null);
    self.fiMaHs = ko.observable(data ? data.fiMaHs : null);
    self.fiLhTen = ko.observable(data ? data.fiLhTen : null);
    self.fiLhKluong = ko.observable(data ? data.fiLhKluong : null);
    self.fiLhTgian = ko.observable(data ? data.fiLhTgian : null);    
    self.fiLhMaCuakhau = ko.observable(data ? data.fiLhMaCuakhau : null);
    self.fiLhTenCuakhau = ko.observable(data ? data.fiLhTenCuakhau : null);
    self.fiKhoiLuongDuocPhep = ko.observable(data ? data.fiKhoiLuongDuocPhep : null);    
    self.fiKhoiLuongConLai = ko.observable(data ? data.fiKhoiLuongConLai : null);    
}
