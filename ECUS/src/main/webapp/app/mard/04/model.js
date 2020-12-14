/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* global app, RAW_HS_STATUS */

var TAO_MOI = 0;
var CHO_TIEP_NHAN = 1;
var TUCHOI_HS = 2;
var RUT_HS = 3;
var YC_BOSUNG_HS = 4;
var DA_BOSUNG_HS = 5;
var DA_TIEP_NHAN = 6;
var XINRUT_HS = 7;
var DONG_Y_XINRUT_HS = 8;
var TC_XIN_RUT = 9;
var XINSUA_HS = 10;
var DONG_Y_XINSUA_HS = 11;
var TUCHOI_XINSUA_HS = 12;
var XACNHAN_DON = 13;
var THONGBAO_APPHI = 14;
var YCBS_PHI = 15;
var XACNHAN_PHI = 16;
var DACAP_LENH = 17;
var CAPGIAY_TAMCAP = 18;
var CAPGIAY_CNKD = 19;
var DACAP_XNCL = 20;
var DACAP_XNCL_LAN2 = 21;
var DACAP_ATTP = 22;
var DACAP_GIULAI = 23;
var CAPTAM_CNKD = 24;
var CAP_CNKD_CHINHSUA = 25;
var DACAP_XNCL_CHINHSUA = 26;
var DACAP_XNCL_CHINHSUA_LAN2 = 27;
var DACAP_ATTP_CHINHSUA = 28;
var DACAP_CNTP = 29;
var DACAP_CNTP_CHINHSUA = 30;
var XIN_GIAHAN = 31;
var NOP_GCN_TUCONGBO = 32;
var DONGY_YC_GIAHAN = 33;
var TUCHOI_YC_GIAHAN = 34;
var XN_HOANTHANH_HS = 35;
var HS_CHUA_HOANTHIEN = 36;

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


var mapTbdhoso04 = function (d, p) {
    return ko.utils.arrayMap(d, function (item, index) {
        return new Tbdhoso04((index + 1) + p, item);
    });
};

function Tbdhoso04(STT, item) {
    var self = this;
    if (item) {
        ko.mapping.fromJS(item, {}, self);
    }
    // self.nameStatusFee = ko.observable(null);
    self.STT = ko.observable(STT);
    self.bXemLichSu = ko.dependentObservable(function () {
        return true;
    }, self);
    self.bSuaHoSo = ko.dependentObservable(function () {
        //return true;
        return ([TAO_MOI, CHO_TIEP_NHAN, YC_BOSUNG_HS, DA_BOSUNG_HS, DA_TIEP_NHAN,
            TUCHOI_XINSUA_HS].indexOf(self.fiMaTrangthai()) >= 0) || (self.fiMaTrangthai() == TC_XIN_RUT && self.fiCheckXnd() !== 1);
    }, self);
    self.bXinRutHoSo = ko.dependentObservable(function () {
        //return true;
        return [CHO_TIEP_NHAN, DA_BOSUNG_HS, YC_BOSUNG_HS, DA_TIEP_NHAN, DONG_Y_XINSUA_HS, TUCHOI_XINSUA_HS, TC_XIN_RUT, XACNHAN_DON].indexOf(self.fiMaTrangthai()) >= 0;
    }, self);
    self.bXoaHoSo = ko.dependentObservable(function () {
        //return true;
        return [TAO_MOI].indexOf(self.fiMaTrangthai()) >= 0;
    }, self);
    self.bDonDangKy = ko.dependentObservable(function () {
        if (self.fiCheckXnd() == 1) {
            return true;
        }
        // return [XACNHAN_DON].indexOf(self.fiMaTrangthai()) >= 0;
    }, self);
    // self.bXinSuaHoSo = ko.dependentObservable(function () {
    //     return [DA_TIEP_NHAN, DONG_Y_XINSUA_HS, TUCHOI_XINSUA_HS, TC_XIN_RUT].indexOf(self.fiMaTrangthai()) >= 0;
    // });
    self.bXemkqKiemDich = ko.dependentObservable(function () {
        // return true;
        return [DACAP_LENH, CAPGIAY_TAMCAP, CAPGIAY_CNKD, DACAP_XNCL, DACAP_XNCL_LAN2, DACAP_ATTP, DACAP_GIULAI, CAPTAM_CNKD, CAP_CNKD_CHINHSUA,
            DACAP_XNCL_CHINHSUA, DACAP_XNCL_CHINHSUA_LAN2, DACAP_ATTP_CHINHSUA, DACAP_CNTP, DACAP_CNTP_CHINHSUA].indexOf(self.fiMaTrangthai()) >= 0;
    }, self);

    self.bThongBaoPhi = ko.dependentObservable(function () {
        //return true;
        return [THONGBAO_APPHI, YCBS_PHI, XACNHAN_PHI].indexOf(self.fiMaTrangthaiphi()) >= 0;
    }, self);

    self.fiNgayguiText = ko.observable(item.fiNgaygui ? new Date(item.fiNgaygui).toDayFirstWithTime() : null);
    self.fiNgayCapText = ko.observable(item.fiNgayCapphep ? new Date(item.fiNgayCapphep).toDayFirstWithTime() : null);

}


var mapTbdHanghoa04 = function (d) {
    return ko.utils.arrayMap(d, function (item, index) {
        item.fiStt = index + 1;
        return new TbdHanghoa04(item, index + 1);
    });
};

function TbdHanghoa04(data) {
    var self = this;
    self.fiStt = ko.observable(data ? data.fiStt : null);
    self.fiIdHh = ko.observable(data ? data.fiIdHh : null);
    self.fiIdHoso = ko.observable(data ? data.fiIdHoso : null);
    self.fiMaHoso = ko.observable(data ? data.fiMaHoso : null);

    self.fiMaHang = ko.observable(data ? data.fiMaHang : null);
    self.fiTenHang = ko.observable(data ? data.fiTenHang : null);
    self.fiTenhangKhac = ko.observable(data ? data.fiTenhangKhac : null);
    self.fiTenchitietHanghoa = ko.observable(data ? data.fiTenchitietHanghoa : null);
    self.fiMaNhomHh = ko.observable(data ? data.fiMaNhomHh : null);
    self.fiTenNhomHh = ko.observable(data ? data.fiTenNhomHh : null);
    self.fiTenNhomHhKhac = ko.observable(data ? data.fiTenNhomHhKhac : null);
    self.fiTenKhoahoc = ko.observable(data ? data.fiTenKhoahoc : null);
    self.fiSoluong = ko.observable(data ? data.fiSoluong : null);
    self.fiMaBaobi = ko.observable(data ? data.fiMaBaobi : null);
    self.fiTenBaobi = ko.observable(data ? data.fiTenBaobi : null);
    self.fiKhoiluongTinh = ko.observable(data ? data.fiKhoiluongTinh : null);
    self.fiMaDvKlTinh = ko.observable(data ? data.fiMaDvKlTinh : null);
    self.fiTenDvKlTinh = ko.observable(data ? data.fiTenDvKlTinh : null);
    self.fiKlTinhTheoTan = ko.observable(data ? data.fiKlTinhTheoTan : null);
    self.fiKhoiluongBaoBi = ko.observable(data ? data.fiKhoiluongBaoBi : null);
    self.fiMaDvKlBaobi = ko.observable(data ? data.fiMaDvKlBaobi : null);
    self.fiTenDvKlBaobi = ko.observable(data ? data.fiTenDvKlBaobi : null);
    self.fiKlCabiTheoTan = ko.observable(data ? data.fiKlCabiTheoTan : null);
    self.fiTenCosoSx = ko.observable(data ? data.fiTenCosoSx : null);
    self.fiMasoNhasanxuat = ko.observable(data ? data.fiMasoNhasanxuat : null);
    self.fiDiachiCosoSx = ko.observable(data ? data.fiDiachiCosoSx : null);
    self.fiMaHs = ko.observable(data ? data.fiMaHs : null);
    self.fiMaBophanSd = ko.observable(data ? data.fiMaBophanSd : null);
    self.fiTenBophanSd = ko.observable(data ? data.fiTenBophanSd : null);
    self.fiTenBophanSdKhac = ko.observable(data ? data.fiTenBophanSdKhac : null);
    self.fiMasoThucan = ko.observable(data ? data.fiMasoThucan : null);
    self.fiMaNuocXx = ko.observable(data ? data.fiMaNuocXx : null);
    self.fiNuocXuatxu = ko.observable(data ? data.fiNuocXuatxu : null);
    self.fiGiatriHh = ko.observable(data ? data.fiGiatriHh : null);
    self.fiMaDvTiente = ko.observable(data ? data.fiMaDvTiente : '01');
    self.fiTenDvTiente = ko.observable(data ? data.fiTenDvTiente : 'USD');
    self.fiMaNhomSp = ko.observable(data ? data.fiMaNhomSp : null);
    self.fiNhomSp = ko.observable(data ? data.fiNhomSp : null);
    self.fiNhomSpKhac = ko.observable(data ? data.fiNhomSpKhac : null);
    self.fiMaPhuongthucKt = ko.observable(data ? data.fiMaPhuongthucKt : null);
    self.fiPhuongthucKt = ko.observable(data ? data.fiPhuongthucKt : null);
    self.fiSoVbPhuongthuc = ko.observable(data ? data.fiSoVbPhuongthuc : null);
    self.fiHoatdong = ko.observable(data ? data.fiHoatdong : null);

    // show ten hang hoa khac ra ngoai grid
    self.tenHangHtml = ko.observable(self.fiTenhangKhac() != null ? self.fiTenhangKhac() : self.fiTenHang());
    // show ten nhom hang hoa khac ra ngoai grid
    self.nhomHangHtml = ko.observable(self.fiTenNhomHhKhac() != null ? self.fiTenNhomHhKhac() : self.fiTenNhomHh());
}

function TbdHopdong04(data, i) {
    var self = this;
    self.fiStt = ko.observable(data ? data.fiStt : null);
    self.fiIdHd = ko.observable(data ? data.fiIdHd : null);
    self.fiIdHoso = ko.observable(data ? data.fiIdHoso : null);
    self.fiMaHoso = ko.observable(data ? data.fiMaHoso : null);
    self.fiMaLoaigiayto = ko.observable(data ? data.fiMaLoaigiayto : null);
    self.fiLoaigiayto = ko.observable(data ? data.fiLoaigiayto : null);
    self.fiSoHopdong = ko.observable(data ? data.fiSoHopdong : null);
    self.fiNgaycapGiayto = ko.observable(data ? new Date(data.fiNgaycapGiayto) : null);
    self.fiHoatdong = ko.observable(data ? data.fiHoatdong : null);

}

var mapTbdHopdong04 = function (d) {
    return ko.utils.arrayMap(d, function (item, index) {
        item.fiStt = index + 1;
        return new TbdHopdong04(item, index + 1);
    });
};


var mapTbdlichsu04 = function (dataFromServer, p) {
    return ko.utils.arrayMap(dataFromServer, function (item, index) {
        return new Tbdlichsu04(index + 1 + p, item);
    });
};
var Tbdlichsu04 = function (STT, item) {
    var self = this;
    this.STT = ko.observable(STT);
    if (item != null) {
        ko.mapping.fromJS(item, {}, self);
    }
    self.fiThoigianText = ko.observable(item.fiThoigian ? new Date(item.fiThoigian).toDayFirstWithTime() : null);
};
