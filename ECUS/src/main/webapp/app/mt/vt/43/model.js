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
var YC_SUA_VANBAN = 6;
var DONG_Y_YC_SUA_VB = 7;
var TU_CHOI_CAP_VANBAN = 8;
var DUOC_CAP_VANBAN = 9;
var DA_CAP_LAI_VANBAN = 10;
var DA_THU_HOI = 11;
var TU_CHOI_YC_SUA_VB = 12;
var YC_TRA_LAI_KQ = 13;

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

var mapTbdlichsu43 = function (dataFromServer,p) {
    return ko.utils.arrayMap(dataFromServer, function (item, index) {
        return new Tbdlichsu43(index + 1+p, item);
    });
};
var Tbdlichsu43 = function (STT, item) {
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

var mapTbdhoso43 = function (d,p) {
    return ko.utils.arrayMap(d, function (item, index) {
        return new Tbdhoso43((index + 1) + p, item);
    });
};
function Tbdhoso43(STT, item) {
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

    if ([DUOC_CAP_VANBAN, DA_CAP_LAI_VANBAN, TU_CHOI_YC_SUA_VB, DONG_Y_YC_SUA_VB].indexOf(self.fiTrangthai()) < 0) {
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
    self.bXinRutHoSo = ko.dependentObservable(function () {
        //return true;
        return [CHO_TIEP_NHAN, DA_TIEP_NHAN, YC_BO_SUNG, DA_BO_SUNG_HOSO].indexOf(self.fiTrangthai()) >= 0;

    }, self);
    self.bXoaHoSo = ko.dependentObservable(function () {
        //return true;
        return [TAO_MOI].indexOf(self.fiTrangthai()) >= 0;
    }, self);
    self.bXemThongBao = ko.dependentObservable(function () {
        //return true;
         return [DUOC_CAP_VANBAN, DA_CAP_LAI_VANBAN, TU_CHOI_YC_SUA_VB, YC_SUA_VANBAN, DONG_Y_YC_SUA_VB, TU_CHOI_CAP_VANBAN, DA_THU_HOI, YC_TRA_LAI_KQ].indexOf(self.fiTrangthai()) >= 0;
    }, self);

    self.fiNgayguiText = ko.observable(item.fiNgaygui ? new Date(item.fiNgaygui).toDayFirstWithTime() : null);
}

function TbdhsXe43(data) {
    var self = this;
    self.fiIdXe = ko.observable(data ? data.fiIdXe : null);
    self.fiIdHoso = ko.observable(data ? data.fiIdHoso : null);
    self.fiStt = ko.observable(data ? data.fiStt : null);
    self.fiBksXe = ko.observable(data ? data.fiBksXe : null);
    self.fiSoGhe = ko.observable(data ? data.fiSoGhe : null);
    self.fiNamSx = ko.observable(data ? data.fiNamSx : null);
    self.fiMaNhanhieu = ko.observable(data ? data.fiMaNhanhieu : null);
    self.fiTenHieu = ko.observable(data ? data.fiTenHieu : null);
    self.fiSoKhung = ko.observable(data ? data.fiSoKhung : null);
    self.fiSoMay = ko.observable(data ? data.fiSoMay : null);
    self.fiMauSon = ko.observable(data ? data.fiMauSon : null);
    self.fiLoaihang = ko.observable(data ? data.fiLoaihang : null);
    self.fiDncpTuNg = ko.observable(data ? new Date(data.fiDncpTuNg) : null);
    self.fiDncpDenNg = ko.observable(data ? new Date(data.fiDncpDenNg) : null);
    self.fiMaTuyen = ko.observable(data ? data.fiMaTuyen : null);
    self.fiTenTuyen = ko.observable(data ? data.fiTenTuyen : null);
    self.fiHanhtrinh = ko.observable(data ? data.fiHanhtrinh : null);
    self.fiDiemDung = ko.observable(data ? data.fiDiemDung : null);
    self.fiDkKhoihanh = ko.observable(data ? new Date(data.fiDkKhoihanh) : null);
    self.fiHoatdong = ko.observable(data ? data.fiHoatdong : null);
    self.fiNguoitao = ko.observable(data ? data.fiNguoitao : null);
    self.fiNgaytao = ko.observable(data ? new Date(data.fiNgaytao) : null);
    self.fiNgCapnhat = ko.observable(data ? data.fiNgCapnhat : null);
}
var mapTbdhsXe43 = function (d) {
    return ko.utils.arrayMap(d, function (item, index) {
        item.fiStt = index + 1;
        return new TbdhsXe43(item);
    });
};

var mapTbdgiayphep43 = function (d) {
    return ko.utils.arrayMap(d, function (item, index) {
        return new Tbdgiayphep43(index + 1, item);
    });
};
var Tbdgiayphep43 = function (STT, item) {
    var self = this;
    this.STT = ko.observable(STT);
    if (item) {
        ko.mapping.fromJS(item, {}, self);
    }

    self.fiGpTuNgayText = ko.observable(item.fiGpTuNgay ? new Date(item.fiGpTuNgay).toDayFirstWithTime() : null);
    self.isChecked = ko.observable(false);
};

var mapTbdgpLichsu43 = function (dataFromServer) {
    return ko.utils.arrayMap(dataFromServer, function (item, index) {
        return new Tbdgplichsu43(index + 1, item);
    });
};
var Tbdgplichsu43 = function (STT, item) {
    var self = this;
    this.STT = ko.observable(STT);
    if (item != null) {
        ko.mapping.fromJS(item, {}, self);
    }

    self.fiNgaytao = ko.observable(item.fiNgaytao ? new Date(item.fiNgaytao).toDayFirstWithTime() : null);
};