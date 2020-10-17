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

var mapTbdLichsu07 = function (dataFromServer) {
    return ko.utils.arrayMap(dataFromServer, function (item, index) {
        return new Tbdlichsu07(index + 1, item);
    });
};
var Tbdlichsu07 = function (STT, item) {
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

var mapTbdhoso07 = function (dataFromServer) {
    return ko.utils.arrayMap(dataFromServer, function (item, index) {
        return new Tbdhoso07(index + 1, item);
    });
};
function Tbdhoso07(STT, item) {
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
        return [CHO_TIEP_NHAN, YC_BO_SUNG, DA_TIEP_NHAN, TU_CHOI_YC_RUT].indexOf(self.fiTrangthai()) >= 0;
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

function Tbdphelieu7(index, data) {
    var self = this;
    self.stt = ko.observable(index);
    self.fiIdPl = ko.observable(data ? data.fiIdPl : null);
    self.fiTenPl = ko.observable(data ? data.fiTenPl : null);
    self.fiMaHs = ko.observable(data ? data.fiMaHs : null);
    self.fiKhoiluong = ko.observable(data ? data.fiKhoiluong : null);
    self.fiHoatdong = ko.observable(data ? data.fiHoatdong : null);
    self.fiNguoitao = ko.observable(data ? data.fiNguoitao : null);
    self.fiNgaytao = ko.observable(data ? data.fiNgaytao : null);
    self.fiNgCapnhat = ko.observable(data ? data.fiNgCapnhat : null);
    self.fiIdHoso = ko.observable(data ? data.fiIdHoso : null);
}
var mapTbdphelieu7 = function (data) {
    return ko.utils.arrayMap(data, function (item, index) {
        return new Tbdphelieu7(index + 1, item);
    });
};

function Tbdcososx7(index, data) {
    var self = this;
    self.stt = ko.observable(index);
    self.fiIdCssx = ko.observable(data ? data.fiIdCssx : null);
    self.fiTenCssx = ko.observable(data ? data.fiTenCssx : null);
    self.fiDiachiCssx = ko.observable(data ? data.fiDiachiCssx : null);
    self.fiSdtCssx = ko.observable(data ? data.fiSdtCssx : null);
    self.fiFaxCssx = ko.observable(data ? data.fiFaxCssx : null);
    self.fiEmailCssx = ko.observable(data ? data.fiEmailCssx : null);
    self.fiMaTinh = ko.observable(data ? data.fiMaTinh : null);
    self.fiTenTinh = ko.observable(data ? data.fiTenTinh : null);
    self.fiMaHuyen = ko.observable(data ? data.fiMaHuyen : null);
    self.fiTenHuyen = ko.observable(data ? data.fiTenHuyen : null);
    self.fiMaXaphuong = ko.observable(data ? data.fiMaXaphuong : null);
    self.fiTenXaphuong = ko.observable(data ? data.fiTenXaphuong : null);
    self.fiHoatdong = ko.observable(data ? data.fiHoatdong : null);
    self.fiNguoitao = ko.observable(data ? data.fiNguoitao : null);
    self.fiNgCapnhat = ko.observable(data ? data.fiNgCapnhat : null);
    //Custom prop
    self.fiIsSelected = ko.observable(data ? data.fiIsSelected : false);
}
var mapTbdcososx7 = function (data) {
    return ko.utils.arrayMap(data, function (item, index) {
        return new Tbdcososx7(index + 1, item);
    });
};

function Tbsprovince1(d) {
    var self = this;
    self.fiMa = ko.observable(d ? d.fiProvinceid : null);
    self.fiTen = ko.observable(d ? d.fiProvincename : null);
}
var mapTbsprovince1 = function (data) {
    return ko.utils.arrayMap(data, function (item, index) {
        return new Tbsprovince1(item);
    });
};

function Tbsward1(d) {
    var self = this;
    self.fiMa = ko.observable(d ? d.fiWardid : null);
    self.fiTen = ko.observable(d ? d.fiWardname : null);
}
var mapTbsward1 = function (data) {
    return ko.utils.arrayMap(data, function (item, index) {
        return new Tbsward1(item);
    });
};

function Tbsdistrict1(d) {
    var self = this;
    self.fiMa = ko.observable(d ? d.fiDistrictid : null);
    self.fiTen = ko.observable(d ? d.fiDistrictname : null);
}
var mapTbsdistrict1 = function (data) {
    return ko.utils.arrayMap(data, function (item, index) {
        return new Tbsdistrict1(item);
    });
};