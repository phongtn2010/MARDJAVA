/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* global app, RAW_HS_STATUS */

var TAO_MOI = 0;
var CHO_TIEP_NHAN = 1;
var YC_BOSUNG_THANHPHAN_HS = 2;
var DA_BOSUNG_THANHPHAN_HS = 3;
var DA_TIEP_NHAN = 4;
var YC_BOSUNG_HS = 5;
var DA_BOSUNG_HOSO = 6;
var DA_RUT_HS = 7;
var TC_CAP_GP = 8;
var YC_XINRUT_HS = 9;
var DONG_Y_XINRUT_HS = 10;
var CAP_GP = 11;
var XIN_SUA_GP = 12;
var DONGY_SUA_GP = 13;
var TC_SUA_GP = 14;
var THU_HOI_GIAY_PHEP = 15;
var TU_CHOI_YC_RUT = 16;
var TU_CHOI_TIEPNHAN_HS = 17;
var DA_SUA_GP = 19;




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
    self.fiTenTrangThai = ko.computed(function () {
        if (!RAW_HS_STATUS || RAW_HS_STATUS.length <= 0) {
            return self.fiMaTrangThai();
        } else {
            for (var i = 0; i < RAW_HS_STATUS.length; i++) {
                if (RAW_HS_STATUS[i]["id"] == self.fiMaTrangThai()) {
                    return RAW_HS_STATUS[i]["name"] ? RAW_HS_STATUS[i]["name"] : self.fiMaTrangThai();
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
        return [TAO_MOI, CHO_TIEP_NHAN, YC_BOSUNG_HS, TU_CHOI_TIEPNHAN_HS, YC_BOSUNG_THANHPHAN_HS].indexOf(self.fiMaTrangThai()) >= 0;
    }, self);
    self.bGuiHoSo = ko.dependentObservable(function () {
        //return true;
        return [TAO_MOI].indexOf(self.fiMaTrangThai()) >= 0;
    }, self);
    self.bXinRutHoSo = ko.dependentObservable(function () {
        //return true;
        return [CHO_TIEP_NHAN, TU_CHOI_TIEPNHAN_HS, DA_TIEP_NHAN, YC_BOSUNG_THANHPHAN_HS, YC_BOSUNG_HS, DA_BOSUNG_HOSO, DA_BOSUNG_THANHPHAN_HS].indexOf(self.fiMaTrangThai()) >= 0;

    }, self);
    self.bXoaHoSo = ko.dependentObservable(function () {
        //return true;
        return [TAO_MOI].indexOf(self.fiMaTrangThai()) >= 0;
    }, self);
    self.bXemThongBao = ko.dependentObservable(function () {
        //return true;
        return [CAP_GP, DA_SUA_GP].indexOf(self.fiMaTrangThai()) >= 0;
    }, self);
    self.fiNgayguiText = ko.observable(item.fiNgayGui ? new Date(item.fiNgayGui).toDayFirstWithTime() : null);
    self.fiNgaycapGpText = ko.observable(item.fiNgaycapGp ? new Date(item.fiNgaycapGp).toDayFirstWithTime() : null);
    if ([CAP_GP, DA_SUA_GP].indexOf(self.fiMaTrangThai()) < 0) {
        self.fiNgaycapGpText(null);
    }

}
var MapTbdThietBiNk02 = function (d) {
    return ko.utils.arrayMap(d, function (item, index) {
        item.fiStt = index + 1;
        return new TbdThietBiNk02(item, index + 1);
    });
};

function TbdThietBiNk02(data) {
    var self = this;

    self.fiStt = ko.observable(data ? data.fiStt : null);
    self.fiIdThietBi = ko.observable(data ? data.fiIdThietBi : null);
    self.fiTenMay = ko.observable(data ? data.fiTenMay : null);
    self.fiKieuIn = ko.observable(data ? data.fiKieuIn : null);
    self.fiSoMauIn = ko.observable(data ? data.fiSoMauIn : null);
    self.fiModelMay = ko.observable(data ? data.fiModelMay : null);
    self.fiSoDinhDanhMay = ko.observable(data ? data.fiSoDinhDanhMay : null);
    self.fiNuocSx = ko.observable(data ? data.fiNuocSx : null);
    self.fiNamSx = ko.observable(data ? data.fiNamSx : null);
    self.fiSoLuong = ko.observable(data ? data.fiSoLuong : null);
    self.fiChatLuong = ko.observable(data ? data.fiChatLuong : null);
    self.fiKhuanKhoBanIn = ko.observable(data ? data.fiKhuanKhoBanIn : null);
    self.fiDonViTinhKhuonKho = ko.observable(data ? data.fiDonViTinhKhuonKho : null);
    self.fiTocDoIn = ko.observable(data ? data.fiTocDoIn : null);
    self.fiDonViTocDoIn = ko.observable(data ? data.fiDonViTocDoIn : null);
    self.fiGiaThietBi = ko.observable(data ? data.fiGiaThietBi : null);
    self.fiTenHangSx = ko.observable(data ? data.fiTenHangSx : null);
    self.fiMaTv = ko.observable(data ? data.fiMaTv : null);
    self.fiMaKieuIn = ko.observable(data ? data.fiMaKieuIn : null);
    self.fiMaChatLuong = ko.observable(data ? data.fiMaChatLuong : null);
    self.fiMaTocdo = ko.observable(data ? data.fiMaTocdo : null);
    self.fiMaKichThuoc = ko.observable(data ? data.fiMaKichThuoc : null);
    self.fiGiaThietBiStr = ko.observable(null);
    if (data) {
        var gt = data.fiGiaThietBi * 1;
        self.fiGiaThietBiStr(gt.toLocaleString());
    }

    self.fiIdHoso = ko.observable(null);
    self.fiMaHoso = ko.observable(null);


}
var mapTbdlichsu02 = function (dataFromServer, p) {
    return ko.utils.arrayMap(dataFromServer, function (item, index) {
        return new Tbdlichsu02(index + 1 + p, item);
    });
};
var Tbdlichsu02 = function (STT, item) {
    var self = this;
    this.STT = ko.observable(STT);
    if (item != null) {
        ko.mapping.fromJS(item, {}, self);
    }
    self.fiTenTrangthai = ko.computed(function () {
        if (!RAW_HS_STATUS || RAW_HS_STATUS.length <= 0) {
            return self.fiMaTrangthai();
        } else {
            for (var i = 0; i < RAW_HS_STATUS.length; i++) {
                if (RAW_HS_STATUS[i]["id"] == self.fiMaTrangthai()) {
                    return RAW_HS_STATUS[i]["name"] ? RAW_HS_STATUS[i]["name"] : self.fiMaTrangthai();
                }
            }
        }
    }, self);
    self.fiNgaytao = ko.observable(item.fiNgaytao ? new Date(item.fiNgaytao).toDayFirstWithTime() : null);
//    self.fiNgaytao = ko.observable(item.fiNgaytao ? new Date(item.fiNgaytao).toDayFirstWithTime() : null);
};
