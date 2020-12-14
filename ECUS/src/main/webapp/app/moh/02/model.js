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
    self.fiTenDn = ko.observable(item.tbdDoanhnghiep02 ? item.tbdDoanhnghiep02.fiTenDoanhnghiep : null);
    self.fiNgayguiText = ko.observable(item.fiNgaygui ? new Date(item.fiNgaygui).toDayFirstWithTime() : null);
    self.fiNgaycapGpText = ko.observable(item.fiNgaynopHoso ? new Date(item.fiNgaynopHoso).toDayFirstWithTime() : null);
}


var mapHanghoa02 = function (d) {
    return ko.utils.arrayMap(d, function (item, index) {
        item.fiStt = index + 1;
        return new HangHoa02(item);
    });
};

function HangHoa02(data) {
    var self = this;
    self.fiIdDonhang = ko.observable(data ? data.fiIdDonhang : null);
    self.fiIdHoso = ko.observable(data ? data.fiIdHoso : null);
    self.fiLoaimau = ko.observable(data ? data.fiLoaimau : null);
    self.fiNguongoc = ko.observable(data ? data.fiNguongoc : null);
    self.fiSoluong = ko.observable(data ? data.fiSoluong : null);
    self.fiDonviTinh = ko.observable(data ? data.fiDonviTinh : null);
    self.fiHinhthuc = ko.observable(data ? data.fiHinhthuc : null);
    self.fiNoigui = ko.observable(data ? data.fiNoigui : null);
    self.fiNoiNhan = ko.observable(data ? data.fiNoiNhan : null);
    self.fiDuongVanchuyen = ko.observable(data ? data.fiDuongVanchuyen : null);
    self.fiHoatdong = ko.observable(data ? data.fiHoatdong : null);
    self.fiNguoitao = ko.observable(data ? data.fiNguoitao : null);
    self.fiNgaytao = ko.observable(data ? new Date(data.fiNgaytao) : null);
    self.fiNgCapnhat = ko.observable(data ? new Date(data.fiNgCapnhat) : null);

    self.fiHinhthucKhac = ko.observable(data ? data.fiHinhthucKhac : null);

    self.fiMaDvTinh = ko.observable(data ? data.fiMaDvTinh : null);
    self.fiTenDvTinh = ko.observable(data ? data.fiTenDvTinh : null);
    self.fiMaHinhthuc = ko.observable(data ? data.fiMaHinhthuc : null);
    self.fiTenHinhthuc = ko.observable(data ? data.fiTenHinhthuc : null);
    self.fiMaVanchuyen = ko.observable(data ? data.fiMaVanchuyen : null);
    self.fiTenVanchuyen = ko.observable(data ? data.fiTenVanchuyen : null);
    self.fiMaQuocgia = ko.observable(data ? data.fiMaQuocgia : null);
    self.fiTenQuocgia = ko.observable(data ? data.fiTenQuocgia : null);
    self.strQG = ko.observable(null);

    // hien thi ten khac khi duoc lua chon ra table hang hoa
    self.fiHinhthucDonggoi = ko.observable(data && self.fiHinhthucKhac() ? self.fiHinhthucKhac() : self.fiTenHinhthuc());
    self.fiTextHinhthuc = ko.observable(data && self.fiHinhthucDonggoi() ? self.fiHinhthucDonggoi() : null);

    var fiHT = "<span>" + self.fiNoigui() + "</span>-<span>" + self.fiTenQuocgia() + "</span>";

    self.strQG(fiHT);
};

var mapDoanhNghiep02 = function (d) {
    return ko.utils.arrayMap(d, function (item, index) {
        item.fiStt = index + 1;
        return new DoanhNghiep02(item, index + 1);
    });
};

function DoanhNghiep02(data, i) {
    var self = this;
    self.fiIdDoanhnghiep = ko.observable(data ? data.fiIdDoanhnghiep : null);
    self.fiIdHoso = ko.observable(data ? data.fiIdHoso : null);
    self.fiMaSothue = ko.observable(data ? data.fiMaSothue : null);
    self.fiTenDoanhnghiep = ko.observable(data ? data.fiTenDoanhnghiep : null);
    self.fiSoCongvan = ko.observable(data ? data.fiSoCongvan : null);
    self.fiNoidungCongvan = ko.observable(data ? data.fiNoidungCongvan : null);
    self.fiDiachi = ko.observable(data ? data.fiDiachi : null);
    self.fiNguoiDaidien = ko.observable(data ? data.fiNguoiDaidien : null);
    self.fiChucvu = ko.observable(data ? data.fiChucvu : null);
    self.fiHoatdong = ko.observable(data ? data.fiHoatdong : null);
    self.fiNgaytao = ko.observable(data ? new Date(data.fiNgaytao) : null);
    self.fiNgCapnhat = ko.observable(data ? new Date(data.fiNgCapnhat) : null);
    self.fiNguoitao = ko.observable(data ? data.fiNguoitao : null);
    self.fiMaHoso = ko.observable(data ? data.fiMaHoso : null);
    self.fiTrangthai = ko.observable(data ? data.fiTrangthai : null);
    self.fiTenTt = ko.observable(data ? data.fiTenTt : null);
}

var mapTbdLichsu02 = function (dataFromServer, p) {
    return ko.utils.arrayMap(dataFromServer, function (item, index) {
        return new TbdLichsu02(index + 1 + p, item);
    });
};
var TbdLichsu02 = function (STT, item) {
    var self = this;
    this.STT = ko.observable(STT);
    if (item != null) {
        ko.mapping.fromJS(item, {}, self);
    }
    self.fiNgaytao = ko.observable(item.fiNgaytao ? new Date(item.fiNgaytao).toDayFirstWithTime() : null);
};
