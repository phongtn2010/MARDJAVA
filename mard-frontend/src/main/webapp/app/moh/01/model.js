/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* global app, RAW_HS_STATUS */

var TAO_MOI = 0;
var CHO_XAC_NHAN_PHI = 1;
var DA_XAC_NHAN_PHI = 2;
var YC_BO_SUNG = 3;
var DA_TIEP_NHAN = 4;
var DA_BO_SUNG_HOSO = 5;
var TU_CHOI_HOSO = 6;
var TU_CHOI_CAP_PHEP = 7;
var DUOC_CAP_GIAYPHEP = 8;
var YC_THANH_TOAN_PHI = 9;
var THANH_TOAN_PHI_BOSUNG = 10;

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

var mapTbdlichsu1 = function (dataFromServer) {
    return ko.utils.arrayMap(dataFromServer, function (item, index) {
        return new Tbdlichsu1(index + 1, item);
    });
};
var Tbdlichsu1 = function (STT, item) {
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

var mapTbdhoso1 = function (d, p) {
    return ko.utils.arrayMap(d, function (item, index) {
        return new Tbdhoso1((index + p) + 1, item);
    });
};
function Tbdhoso1(STT, item) {
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
        self.fiNgaycapGp(null);
    }

    self.STT = ko.observable(STT);
    self.bXemLichSu = ko.dependentObservable(function () {
        return true;
    }, self);
    self.bSuaHoSo = ko.dependentObservable(function () {
        //return true;
        return [TAO_MOI, YC_THANH_TOAN_PHI, YC_BO_SUNG, TU_CHOI_HOSO].indexOf(self.fiTrangthai()) >= 0;
    }, self);
    self.bGuiHoSo = ko.dependentObservable(function () {
        //return true;
        return [TAO_MOI, YC_THANH_TOAN_PHI, YC_BO_SUNG, TU_CHOI_HOSO].indexOf(self.fiTrangthai()) >= 0;

    }, self);
    self.bXinRutHoSo = ko.dependentObservable(function () {
        //return true;
        return [DA_TIEP_NHAN, YC_BO_SUNG, DA_BO_SUNG_HOSO].indexOf(self.fiTrangthai()) >= 0;

    }, self);
    self.bXoaHoSo = ko.dependentObservable(function () {
        //return true;
        return [TAO_MOI].indexOf(self.fiTrangthai()) >= 0;
    }, self);
    self.bXemThongBao = ko.dependentObservable(function () {
        //return true;
        return [DUOC_CAP_GIAYPHEP].indexOf(self.fiTrangthai()) >= 0;
    }, self);

    self.fiNgaytaoText = ko.observable(item.fiNgaytao ? new Date(item.fiNgaytao).toDayFirstWithTime() : null);
}

function TbdhsHanghoa1(data) {
    var self = this;
    
    self.fiStt = ko.observable(data ? data.fiStt : null);
    self.fiIdHanghoa = ko.observable(data ? data.fiIdHanghoa : null);
    self.fiIdHoso = ko.observable(data ? data.fiIdHoso : null);
    self.fiTenCp = ko.observable(data ? data.fiTenCp : null);
    self.fiHamLuong = ko.observable(data ? data.fiHamLuong : null);
    self.fiTacDungCp = ko.observable(data ? data.fiTacDungCp : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 500 ký tự', params: 500}
    });
    self.fiDviTinh = ko.observable(data ? data.fiDviTinh : null);
    self.fiSoLuong = ko.observable(data ? data.fiSoLuong : null).extend({
        number: {message: 'Phải nhập số', params: true},
        pattern: {
            message: 'Phải nhập giá trị với tối đa 2 số ở phần thập phân ví dụ: 1.23',
            params: '^[0-9]{0,15}(?:\.[0-9]{0,2})?$'
        }
    });
    self.fiTenNsx = ko.observable(data ? data.fiTenNsx : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 500 ký tự', params: 500}
    });
}

var mapTbdhsHanghoa1 = function (d) {
    return ko.utils.arrayMap(d, function (item, index) {
        item.fiStt = index + 1;
        return new TbdhsHanghoa1(item);
    });
};

