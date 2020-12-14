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
var TU_CHOI_CAP_GIAY_PHEP = 6;
var THU_HOI_GIAY_PHEP = 7;
var LE_PHI_THAM_DINH = 9;
var XAC_NHAN_THANH_TOANS = 8;
var TU_CHOI_TIEP_NHAN_HS = 10;
var RUT_HO_SO = 11;
var CAP_GIAY_PHEP = 12;


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
var mapTbdlichsu05 = function (dataFromServer, p) {
    return ko.utils.arrayMap(dataFromServer, function (item, index) {
        return new Tbdlichsu05(index + 1 + p, item);
    });
};
var Tbdlichsu05 = function (STT, item) {
    var self = this;
    this.STT = ko.observable(STT);
    if (item != null) {
        ko.mapping.fromJS(item, {}, self);
    }
    self.fiTenTrangthai = ko.computed(function () {
        if (!RAW_HS_STATUS || RAW_HS_STATUS.length <= 0) {
            return self.fiTrangthaihoso();
        } else {
            for (var i = 0; i < RAW_HS_STATUS.length; i++) {
                if (RAW_HS_STATUS[i]["id"] == self.fiTrangthaihoso()) {
                    return RAW_HS_STATUS[i]["name"] ? RAW_HS_STATUS[i]["name"] : self.fiTrangthaihoso();
                }
            }
        }
    }, self);
    self.fiThoigian = ko.observable(item.fiThoigian ? new Date(item.fiThoigian).toDayFirstWithTime() : null);
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


var mapTbdhoso05 = function (d, p) {
    return ko.utils.arrayMap(d, function (item, index) {
        return new Tbdhoso05((index + 1) + p, item);
    });
};
function Tbdhoso05(STT, item) {
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
    if ([CAP_GIAY_PHEP].indexOf(self.fiTrangthai()) < 0) {
        self.fiNgayCap(null);
    }
    self.STT = ko.observable(STT);
    self.bXemLichSu = ko.dependentObservable(function () {
        return true;
    }, self);
    self.bSuaHoSo = ko.dependentObservable(function () {
        //return true;
        return [TAO_MOI, CHO_TIEP_NHAN, YC_BO_SUNG, TU_CHOI_TIEP_NHAN_HS].indexOf(self.fiTrangthai()) >= 0;
    }, self);
    self.bXinRutHoSo = ko.dependentObservable(function () {
        //return true;
        return [CHO_TIEP_NHAN, TU_CHOI_TIEP_NHAN_HS].indexOf(self.fiTrangthai()) >= 0;

    }, self);
    self.bXoaHoSo = ko.dependentObservable(function () {
        //return true;
        return [TAO_MOI].indexOf(self.fiTrangthai()) >= 0;
    }, self);
    self.bXemThongBao = ko.dependentObservable(function () {
        //return true;
        return [CAP_GIAY_PHEP].indexOf(self.fiTrangthai()) >= 0;
    }, self);
    self.fiNgayguiText = ko.observable(item.fiNgaygui ? new Date(item.fiNgaygui).toDayFirstWithTime() : null);
}

var mapTbdhsNkpxTtpnpxk05 = function (d) {
    return ko.utils.arrayMap(d, function (item, index) {
        item.fiStt = index + 1;
        return new TbdhsNkpxTtpnpxk05(item, index + 1);
    });
};

function TbdhsNkpxTtpnpxk05(data, i) {
    
    var self = this;
    self.fiStt = ko.observable(i);
    self.fiIdHoso = ko.observable(data ? data.fiIdHoso : null);
    self.fiMaHoso = ko.observable(data ? data.fiMaHoso : null);
    self.fiIdTtpnpxk = ko.observable(data ? data.fiIdTtpnpxk : null);
    self.fiMaDongViPhongXa = ko.observable(data ? data.fiMaDongViPhongXa : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 50 ký tự', params: 50}
    });
    self.fiTenDongViPhongXa = ko.observable(data ? data.fiTenDongViPhongXa : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiMaHieu = ko.observable(data ? data.fiMaHieu : null);

    self.fiSoSeri = ko.observable(data ? data.fiSoSeri : null);
    self.fiHangSanXuat = ko.observable(data ? data.fiHangSanXuat : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 500 ký tự', params: 500}
    });
    self.fiHoatDo = ko.observable(data ? data.fiHoatDo : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 15.3 ký tự', params: 15.3}
    });
    self.fiHoatDoDonVi = ko.observable(data ? data.fiHoatDoDonVi : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 1 ký tự', params: 1}
    });
    self.fiTenHoatDoDonVi = ko.observable(data ? data.fiTenHoatDoDonVi : null);
    self.fiNgayXacDinhHoatDo = ko.observable(data ? data.fiNgayXacDinhHoatDo : null);
    self.fiNgayXacDinhHoatDoText = ko.observable(data.fiNgayXacDinhHoatDo ? new Date(data.fiNgayXacDinhHoatDo).toDayFirstWithTime() : null);

    self.fiMaMucDichSuDung = ko.observable(data ? data.fiMaMucDichSuDung : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiCamKetTraNguon = ko.observable(data ? data.fiCamKetTraNguon : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 1 ký tự', params: 1}
    });
    self.fiMucDichSuDungKhac = ko.observable(data ? data.fiMucDichSuDungKhac : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 500 ký tự', params: 500}
    });
    self.fiTbMaHieu = ko.observable(data ? data.fiTbMaHieu : null);
    self.fiTbNoiDat = ko.observable(data ? data.fiTbNoiDat : null);
    self.fiTbSoSeri = ko.observable(data ? data.fiTbSoSeri : null);
    self.fiTbHangNuocSanXuat = ko.observable(data ? data.fiTbHangNuocSanXuat : null);
    self.fiTbNamSanXuat = ko.observable(data ? data.fiTbNamSanXuat : null);
    self.fiTbDiDongCoDinh = ko.observable(data ? data.fiTbDiDongCoDinh : null);
    self.fiTbKhoiLuongUrani = ko.observable(data ? data.fiTbKhoiLuongUrani : null);
    self.fiHoatdong = ko.observable(data ? data.fiHoatdong : null);
    self.fiMaHoso = ko.observable(data ? data.fiMaHoso : null);
    self.fiNguoitao = ko.observable(data ? data.fiNguoitao : null);
    self.fiNgaytao = ko.observable(data ? data.fiNgaytao : null);
    self.fiNgaycapnhap = ko.observable(data ? data.fiNgaycapnhap : null);

    var pxkVG = [self.fiMaDongViPhongXa, self.fiTenDongViPhongXa, self.fiHangSanXuat, self.fiHoatDo, self.fiHoatDoDonVi,
        self.fiMaMucDichSuDung, self.fiCamKetTraNguon];
    self.pxkErrors = ko.validation.group(pxkVG, {deep: true, live: true, observable: true});

}


var mapTbdhsTtpPxh05 = function (d) {
    return ko.utils.arrayMap(d, function (item, index) {
        item.fiStt = index + 1;
        return new TbdhsTtpPxh05(item, index + 1);
    });
}
function TbdhsTtpPxh05(data, i) {
    var self = this;
    self.fiStt = ko.observable(data ? data.fiStt : i);
    self.fiIdHoso = ko.observable(data ? data.fiIdHoso : null);
    self.fiMaHoso = ko.observable(data ? data.fiMaHoso : null);
    self.fiIdTtpPxh = ko.observable(data ? data.fiIdTtpPxh : null);
    self.fiMaDongViPhongXa = ko.observable(data ? data.fiMaDongViPhongXa : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 50 ký tự', params: 50}
    });
    self.fiTenDongViPhongXa = ko.observable(data ? data.fiTenDongViPhongXa : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiHangSanXuat = ko.observable(data ? data.fiHangSanXuat : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiCongThucHoaHoc = ko.observable(data ? data.fiCongThucHoaHoc : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 2000 ký tự', params: 2000}
    });
    self.fiTrangThaiVatLy = ko.observable(data ? data.fiTrangThaiVatLy : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiTongHoatDoTrongNam = ko.observable(data ? data.fiTongHoatDoTrongNam : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 15.3 ký tự', params: 15.3}
    });
    self.fiHoatDoDonVi = ko.observable(data ? data.fiHoatDoDonVi : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 1 ký tự', params: 1}
    });
    self.fiMaMucDichSuDung = ko.observable(data ? data.fiMaMucDichSuDung : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiMucDichSuDungKhac = ko.observable(data ? data.fiMucDichSuDungKhac : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 500 ký tự', params: 500}
    });
    self.fiTrangthai = ko.observable(data ? data.fiTrangthai : null);
    self.fiNguoitao = ko.observable(data ? data.fiNguoitao : null);
    self.fiHoatdong = ko.observable(data ? data.fiHoatdong : null);
    self.fiNgaytao = ko.observable(data ? data.fiNgaytao : null);
    self.fiNgCapnhat = ko.observable(data ? data.fiNgCapnhat : null);
    
    self.fiTenHoatDoDonVi = ko.observable(data ? data.fiTenHoatDoDonVi : null);
    
    
    var pxHoVG = [self.fiMaDongViPhongXa, self.fiTenDongViPhongXa, self.fiHangSanXuat
                , self.fiCongThucHoaHoc, self.fiTrangThaiVatLy, self.fiTongHoatDoTrongNam, self.fiHoatDoDonVi
                , self.fiMaMucDichSuDung]
    self.pxhError = ko.validation.group(pxHoVG, {deep: true, live: true, observable: true});
}

//
//var mapTeptin05 = function (d, p) {
//    return ko.utils.arrayMap(d, function (item, index) {
//        item.fiStt = index + 1;
//        return new TbdTeptin05((index + 1) + p, item);
//    });
//};
//
//function TbdTeptin05(data, i) {
//    var self = this;
//    self.STT = ko.observable(i);
//    self.fiIdHoso = ko.observable(data ? data.fiIdHoso : null);
//    self.fiMaHoso = ko.observable(data ? data.fiMaHoso : null);
//    self.fiIdTeptin = ko.observable(data ? data.fiIdTeptin : null);
//    self.fiTrangthai = ko.observable(data ? data.fiTrangthai : null);
//    self.fiNguoitao = ko.observable(data ? data.fiNguoitao : null);
//    self.fiHoatdong = ko.observable(data ? data.fiHoatdong : null);
//    self.fiNgaytao = ko.observable(data ? data.fiNgaytao : null);
//    self.fiNgCapnhat = ko.observable(data ? data.fiNgCapnhat : null);
//    self.fiLoaiTepTin = ko.observable(data ? data.fiMucDichSuDungKhac : null).extend({
//        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
//        maxLength: {message: 'Tối đa 5 ký tự', params: 5}
//    });
//    self.fiTenLoaiTep = ko.observable(data ? data.fiTenLoaiTep : null).extend({
//        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
//        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
//    });
//    self.fiTenTepTin = ko.observable(data ? data.fiTenTepTin : null).extend({
//        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
//        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
//    });
//    self.fiTepTinId = ko.observable(data ? data.fiTepTinId : null).extend({
//        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
//        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
//    });
//}


var mapTbdgiayphep05 = function (d) {
    return ko.utils.arrayMap(d, function (item, index) {
        return new Tbdgiayphep05(index + 1, item);
    });
};
var Tbdgiayphep05 = function (STT, item) {
    var self = this;
    this.STT = ko.observable(STT);
    if (item) {
        (item);
        ko.mapping.fromJS(item, {}, self);
    }

    self.fiTrangthai = ko.observable(item.fiTrangthai);
    self.fiNgayCPText = ko.observable(item.fiNgayky ? new Date(item.fiNgayky).toDayFirstWithTime() : null);
    self.isChecked = ko.observable(false);
    self.isDisable = ko.dependentObservable(function () {
        // return True
        return [YC_SUA_GIAYPHEP].indexOf(self.fiTrangthai()) >= 0;

    }, self)

};