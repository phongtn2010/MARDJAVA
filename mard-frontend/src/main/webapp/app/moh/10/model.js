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
var THU_HOI_GIAYPHEP = 9;

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

var mapTbdlichsu10 = function (dataFromServer) {
    return ko.utils.arrayMap(dataFromServer, function (item, index) {
        return new Tbdlichsu10(index + 1, item);
    });
};
var Tbdlichsu10 = function (STT, item) {
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

var mapTbdhoso10 = function (d, p) {
    return ko.utils.arrayMap(d, function (item, index) {
        return new Tbdhoso10((index + p) + 1, item);
    });
};
function Tbdhoso10(STT, item) {
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
        //return true;
        return [TAO_MOI, YC_BO_SUNG, TU_CHOI_HOSO].indexOf(self.fiTrangthai()) >= 0;
    }, self);
    self.bGuiHoSo = ko.dependentObservable(function () {
        //return true;
        return [TAO_MOI, YC_BO_SUNG, TU_CHOI_HOSO].indexOf(self.fiTrangthai()) >= 0;

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

function TbdhsHanghoa10(data) {
    var self = this;
    
    self.fiStt = ko.observable(data ? data.fiStt : null);
    self.fiIdHanghoa = ko.observable(data ? data.fiIdHanghoa : null);
    self.fiIdHoso = ko.observable(data ? data.fiIdHoso : null);
    self.fiTenTtb = ko.observable(data ? data.fiTenTtb : null);
    self.fiLoaiTtb = ko.observable(data ? data.fiLoaiTtb : null);
    self.fiTenCsh = ko.observable(data ? data.fiTenCsh : null);
    self.fiDiachiCsh = ko.observable(data ? data.fiDiachiCsh : null);
    self.fiTenQgCsh = ko.observable(data ? data.fiTenQgCsh : null);
    self.fiMaQaCsh = ko.observable(data ? data.fiMaQaCsh : null);
    self.fiPhannhom = ko.observable(data ? data.fiPhannhom : null);
    self.fiNhomTtb = ko.observable(data ? data.fiNhomTtb : null);
    self.fiNhieuCssx = ko.observable(data ? data.fiNhieuCssx : null);
    self.fiDongGoi = ko.observable(data ? data.fiDongGoi : null);
    self.fiSoluongNk = ko.observable(data ? data.fiSoluongNk : null);
    
    self.lstLoaiHangHoas = ko.observableArray(mapTbdhsHhLoai7(data ? data.lstLoaiHangHoas : []));
}

var mapTbdhsHanghoa10 = function (d) {
    return ko.utils.arrayMap(d, function (item, index) {
        item.fiStt = index + 1;
        return new TbdhsHanghoa10(item);
    });
};

function TbdhsHhCssx10(data) {
    var self = this;
    self.fiStt = ko.observable(data ? data.fiStt : null);
    self.fiIdHhCssx = ko.observable(data ? data.fiIdHhCssx : null);
    self.fiIdHhLoai = ko.observable(data ? data.fiIdHhLoai : null);
    self.fiTenCssx = ko.observable(data ? data.fiTenCssx : null);
    self.fiDiachiCssx = ko.observable(data ? data.fiDiachiCssx : null);
    self.fiTenQgSx = ko.observable(data ? data.fiTenQgSx : null);
    self.fiMaQgSx = ko.observable(data ? data.fiMaQgSx : null);
}

var mapTbdhsHhCssx10 = function (d) {
    return ko.utils.arrayMap(d, function (item, index) {
        item.fiStt = index + 1;
        return new TbdhsHhCssx10(item);
    });
};

function TbdhsHhLoai10(data) {
    var self = this;
    self.fiStt = ko.observable(data ? data.fiStt : null);
    self.fiIdHhLoai = ko.observable(data ? data.fiIdHhLoai : null);
    self.fiIdHanghoa = ko.observable(data ? data.fiIdHanghoa : null);
    self.fiMaSpCl = ko.observable(data ? data.fiMaSpCl : null);
    self.fiDongGoiCl = ko.observable(data ? data.fiDongGoiCl : null);
    self.lstCssxHangHoas = ko.observableArray(mapTbdhsHhCssx10(data ? data.lstCssxHangHoas : []));
}

var mapTbdhsHhLoai10 = function (d) {
    return ko.utils.arrayMap(d, function (item, index) {
        item.fiStt = index + 1;
        return new TbdhsHhLoai10(item);
    });
};

function Tbddinhkem10(data) {
    var self = this;
    self.fiStt = ko.observable(data ? data.fiStt : null);
    self.fiIdDt = ko.observable(data ? data.fiIdDt : null);
    self.fiLoaiDt = ko.observable(data ? data.fiLoaiDt : null);
    self.fiMaTep = ko.observable(data ? data.fiMaTep : null);
    self.fiLoaiTep = ko.observable(data ? data.fiLoaiTep : null);
    self.fiTenTep = ko.observable(data ? data.fiTenTep : null);
    self.fiTenLoaiTep = ko.observable(data ? data.fiTenLoaiTep : null);
    self.fiDuongDan = ko.observable(data ? data.fiDuongDan : null);
}

var mapTbddinhkem10 = function (d) {
    return ko.utils.arrayMap(d, function (item, index) {
        item.fiStt = index + 1;
        return new Tbddinhkem10(item);
    });
};

