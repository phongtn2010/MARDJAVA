/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* global app, RAW_HS_STATUS */

var TAO_MOI = 0;
var CHO_TIEP_NHAN = 1;
var YC_BOSUNG = 2;
var DA_BOSUNG = 3;
var RUT_HS = 4;
var DA_TIEP_NHAN = 5;
var TC_CAP_GP = 6;
var CAP_GP = 7;
var TU_CHOI_HS = 8;

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
    self.bXemGiayPhep = ko.dependentObservable(function () {
        //return true;
        return [CAP_GP].indexOf(self.fiTrangthai()) >= 0;
    }, self);
    self.bXinRutHoSo = ko.dependentObservable(function () {
        //return true;
        return [CHO_TIEP_NHAN, YC_BOSUNG, DA_BOSUNG, TU_CHOI_HS].indexOf(self.fiTrangthai()) >= 0;

    }, self);
    self.bSuaHoSo = ko.dependentObservable(function () {
        //return true;
        return [TAO_MOI, CHO_TIEP_NHAN, YC_BOSUNG, TU_CHOI_HS].indexOf(self.fiTrangthai()) >= 0;
    }, self);
    self.bXoaHoSo = ko.dependentObservable(function () {
        //return true;
        return [TAO_MOI].indexOf(self.fiTrangthai()) == 0;
    }, self);
    self.fiTenDn = ko.observable(item.doanhnghiep03 ? item.doanhnghiep03.fiTenDn : null);
    self.fiNgayguiText = ko.observable(item.fiNgaynop ? new Date(item.fiNgaynop).toDayFirstWithTime() : null);
    self.fiNgaycapGpText = ko.observable(item.fiNgaycap ? new Date(item.fiNgaycap).toDayFirstWithTime() : null);
}


var mapHanghoa03 = function (d) {
    return ko.utils.arrayMap(d, function (item, index) {
        return new HangHoa03(item);
    });
};

function HangHoa03(data) {
    var self = this;
    self.fiIdDonhang = ko.observable(data ? data.fiIdDonhang : null);
    self.fiIdHoso = ko.observable(data ? data.fiIdHoso : null);
    self.fiMaDuoclieu = ko.observable(data ? data.fiMaDuoclieu : null);
    self.fiTenDuoclieu = ko.observable(data ? data.fiTenDuoclieu : null);
    self.fiMaHs = ko.observable(data ? data.fiMaHs : null);
    self.fiBophanDung = ko.observable(data ? data.fiBophanDung : null);
    self.fiTenKh = ko.observable(data ? data.fiTenKh : null);
    self.fiMaDvTinh = ko.observable(data ? data.fiMaDvTinh : null);
    self.fiTenDvTinh = ko.observable(data ? data.fiTenDvTinh : null);
    self.fiSoluong = ko.observable(data ? data.fiSoluong : null);
    self.fiMaTccl = ko.observable(data ? data.fiMaTccl : null);
    self.fiTccl = ko.observable(data ? data.fiTccl : null);
    self.fiMaQgSx = ko.observable(data ? data.fiMaQgSx : null);
    self.fiTenQgSx = ko.observable(data ? data.fiTenQgSx : null);
    self.fiCosoSx = ko.observable(data ? data.fiCosoSx : null);
    self.fiMaQgCc = ko.observable(data ? data.fiMaQgCc : null);
    self.fiTenQgCc = ko.observable(data ? data.fiTenQgCc : null);
    self.fiCosoCc = ko.observable(data ? data.fiCosoCc : null);
    self.fiGhichu = ko.observable(data ? data.fiGhichu : null);
    self.fiHoatdong = ko.observable(data ? data.fiHoatdong : null);
    self.fiNguoitao = ko.observable(data ? data.fiNguoitao : null);
    self.fiNgaytao = ko.observable(data ? new Date(data.fiNgaytao) : null);
    self.fiTenKhac = ko.observable(data ? data.fiTenKhac : null);
    self.fiTcclKhac = ko.observable(data ? data.fiTcclKhac : null);

    // lay ten duoc lieu hien thi ra bảng
    self.fiTendl = ko.observable(data && self.fiTenKhac() ? self.fiTenKhac() : self.fiTenDuoclieu());
    self.fiTextTenDl = ko.observable(data && self.fiTendl() ? self.fiTendl() : null);

    // lay ten tieu chuan chat luong khac hien thi ra bang
    self.fiTentccl = ko.observable(data && self.fiTcclKhac() ? self.fiTcclKhac() : self.fiTccl());
    self.fiTextTccl = ko.observable(data && self.fiTentccl() ? self.fiTentccl() : null);

    //dung cho list giay phep
    self.fiTenKhoahoc = ko.observable(data ? data.fiTenKhoahoc : null);
};

var mapCuakhau03 = function (d) {
    return ko.utils.arrayMap(d, function (item, index) {
        item.fiStt = index + 1;
        return new Cuakhau03(item, index + 1);
    });
};

function Cuakhau03(data, i) {
    var self = this;
    self.fiStt = ko.observable(data ? data.fiStt : i);
    self.fiIdCuakhau = ko.observable(data ? data.fiIdCuakhau : null);
    self.fiIdHoso = ko.observable(data ? data.fiIdHoso : i);
    self.fiMaCuakhau = ko.observable(data ? data.fiMaCuakhau : null);
    self.fiTenCuakhau = ko.observable(data ? data.fiTenCuakhau : null);
    self.fiHoatdong = ko.observable(data ? data.fiHoatdong : null);
    self.fiNguoitao = ko.observable(data ? data.fiNguoitao : null);
    self.fiNgaytao = ko.observable(data ? new Date(data.fiNgaytao) : null);
};

var mapTbdLichsu03 = function (dataFromServer, p) {
    return ko.utils.arrayMap(dataFromServer, function (item, index) {
        return new TbdLichsu03(index + 1 + p, item);
    });
};
var TbdLichsu03 = function (STT, item) {
    var self = this;
    this.STT = ko.observable(STT);
    if (item != null) {
        ko.mapping.fromJS(item, {}, self);
    }
    self.fiNgaytao = ko.observable(item.fiNgaytao ? new Date(item.fiNgaytao).toDayFirstWithTime() : null);
};
