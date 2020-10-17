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
var TT_LE_PHI_THAM_DINH = 0;
var TT_XAC_NHAN_THANH_TOAN = 1;



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
var mapTbdhsPhieuKbNguonPxk06 = function (d) {
    return ko.utils.arrayMap(d, function (item, index) {
        item.fiStt = index + 1;
        return new TbdhsPhieuKbNguonPxk06(item);
    });
};

function TbdhsPhieuKbNguonPxk06(data, i) {
    var self = this;
    self.STT = ko.observable(data ? data.STT : i);

    self.fiIdPhieuKb = ko.observable(data ? data.fiIdPhieuKb : null);
    self.fiMaDongViPhongXa = ko.observable(data ? data.fiMaDongViPhongXa : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 100 ký tự', params: 100}
    });
    self.fiTenDongViPhongXa = ko.observable(data ? data.fiTenDongViPhongXa : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 200 ký tự', params: 200}
    });
    self.fiMaHieu = ko.observable(data ? data.fiMaHieu : null);
    self.fiSoSeri = ko.observable(data ? data.fiSoSeri : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 100 ký tự', params: 100}
    });
    self.fiHangSanXuat = ko.observable(data ? data.fiHangSanXuat : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 500 ký tự', params: 500}
    });
    self.fiHoatDo = ko.observable(data ? data.fiHoatDo : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 15.3 ký tự', params: 15.3},
        pattern: {
            message: 'Bạn chỉ được nhập số hoặc số thập phân sau dấu chấm 3 chữ số ',
            params: /^[0-9]{1,12}(?:\.[0-9]{1,3})?$/
        }
    });
    self.fiHoatDoDonVi = ko.observable(data ? data.fiHoatDoDonVi : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 1 ký tự', params: 1}
    });
    self.fiTenHoatDoDonVi = ko.observable(data ? data.fiTenHoatDoDonVi : null);
    self.fiNgayXacDinhHoatDo = ko.observable(data ? data.fiNgayXacDinhHoatDo : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiMaMucDichSuDung = ko.observable(data ? data.fiMaMucDichSuDung : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiMucDichSuDungKhac = ko.observable(data ? data.fiMucDichSuDungKhac : null);
    self.fiXuatXuNguon = ko.observable(data ? data.fiXuatXuNguon : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiXuatXuNguonNgaycap = ko.observable(data ? data.fiXuatXuNguonNgaycap : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiXuatXuNguonSgp = ko.observable(data ? data.fiXuatXuNguonSgp : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 100 ký tự', params: 100}
    });
    self.fiCamKetTraLaiNguon = ko.observable(data ? data.fiCamKetTraLaiNguon : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiTenHoatDoDV = ko.computed(function () {
        if (!RAW_HS_STATUS || RAW_HS_STATUS.length <= 0) {
            return self.fiHoatDoDonVi();
        } else {
            for (var i = 0; i < RAW_HS_STATUS.length; i++) {
                if (RAW_HS_STATUS[i]["id"] == self.fiHoatDoDonVi()) {
                    return RAW_HS_STATUS[i]["name"] ? RAW_HS_STATUS[i]["name"] : self.fiHoatDoDonVi();
                }
            }
        }
    }, self);
    self.fiTbMaHieu = ko.observable(data ? data.fiTbMaHieu : null);
    self.fiTbSoSeri = ko.observable(data ? data.fiTbSoSeri : null);
    self.fiTbHangNuocSanXuat = ko.observable(data ? data.fiTbHangNuocSanXuat : null);
    self.fiTbNamSanXuat = ko.observable(data ? data.fiTbNamSanXuat : null);
    self.fiTbDiDongCoDinh = ko.observable(data ? data.fiTbDiDongCoDinh : null);
    self.fiTbNoiDat = ko.observable(data ? data.fiTbNoiDat : null);
    self.fiTbKhoiLuongUrani = ko.observable(data ? data.fiTbKhoiLuongUrani : null);
    self.fiHsCapgiayphepPxkId = ko.observable(data ? data.fiHsCapgiayphepPxkId : null);
    self.fiIdHoso = ko.observable(data ? data.fiIdHoso : null);
    self.fiMaHoso = ko.observable(data ? data.fiMaHoso : null);
    self.fiHoatdong = ko.observable(data ? data.fiHoatdong : null);
    self.fiNguoitao = ko.observable(data ? data.fiNguoitao : null);
    self.fiNgaytao = ko.observable(data ? new Date(data.fiNgaytao) : null);
    self.fiNgCapnhat = ko.observable(data ? data.fiNgCapnhat : null);
    self.fiNgayXacDinhHoatDoText = ko.observable(data ? new Date(data.fiNgayXacDinhHoatDo).toDayFirstWithTime() : null);

    var nguoiDkVG = [self.fiMaDongViPhongXa, self.fiTenDongViPhongXa, self.fiHoatDoDonVi, self.fiNgayXacDinhHoatDo, self.fiMaMucDichSuDung, self.fiXuatXuNguon, self.fiXuatXuNguonNgaycap, self.fiXuatXuNguonSgp, self.fiCamKetTraLaiNguon];
    self.nguoiDkError = ko.validation.group(nguoiDkVG, {deep: true, live: true, observable: true});

}

var mapTbdhoso06 = function (d, p) {
    return ko.utils.arrayMap(d, function (item, index) {
        return new Tbdhoso06((index + 1) + p, item);
    });
};
function Tbdhoso06(STT, item) {
    var self = this;
    if (item) {
        ko.mapping.fromJS(item, {}, self);
    }
    self.fiTenTrangthai = ko.computed(function () {
        if (!RAW_HS_STATUS || RAW_HS_STATUS.length <= 0) {
            return self.fiTrangThai();
        } else {
            for (var i = 0; i < RAW_HS_STATUS.length; i++) {
                if (RAW_HS_STATUS[i]["id"] == self.fiTrangThai()) {
                    return RAW_HS_STATUS[i]["name"] ? RAW_HS_STATUS[i]["name"] : self.fiTrangThai();
                }
            }
        }
    }, self);
     self.fiTenTTLePhi = ko.computed(function () {
        if(self.fiTrangThaiLePhi()!==null){
            if(self.fiTrangThaiLePhi()===0 ){
                return "Lệ phí thẩm định";
            }else{
                return "Xác nhận thanh toán";
            }
        }
    },self);
    
    if ([CAP_GIAY_PHEP].indexOf(self.fiTrangThai()) < 0) {
        self.fiNgayCap(null);

    }

    self.STT = ko.observable(STT);
    self.bXemLichSu = ko.dependentObservable(function () {
        return true;
    }, self);
    self.bXemLichSu = ko.dependentObservable(function () {
        return true;
    }, self);
    self.bSuaHoSo = ko.dependentObservable(function () {
        //return true;
        return [TAO_MOI, CHO_TIEP_NHAN, YC_BO_SUNG, TU_CHOI_TIEP_NHAN_HS].indexOf(self.fiTrangThai()) >= 0;
    }, self);
    self.bXinRutHoSo = ko.dependentObservable(function () {
        //return true;
        return [CHO_TIEP_NHAN, TU_CHOI_TIEP_NHAN_HS].indexOf(self.fiTrangThai()) >= 0;
    }, self);
    self.bXoaHoSo = ko.dependentObservable(function () {
        //return true;
        return [TAO_MOI].indexOf(self.fiTrangThai()) >= 0;
    }, self);
    self.bXemThongBao = ko.dependentObservable(function () {
        //return true;
        return [CAP_GIAY_PHEP].indexOf(self.fiTrangThai()) >= 0;
    }, self);
    self.fiNgayguiText = ko.observable(item.fiNgaygui ? new Date(item.fiNgaygui).toDayFirstWithTime() : null);
}
var mapTbdhsPhieuNguonPxkQsd06 = function (d) {
    return ko.utils.arrayMap(d, function (item, index) {
        item.fiStt = index + 1;
        return new TbdhsPhieuNguonPxkQsd06(item);
    });
};
function TbdhsPhieuNguonPxkQsd06(data, i) {
    var self = this;
    self.STT = ko.observable(data ? data.STT : i);

    self.fiIdNguonPxkPsd = ko.observable(data ? data.fiIdNguonPxkPsd : null);
    self.fiMaDongViPhongXa = ko.observable(data ? data.fiMaDongViPhongXa : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 100 ký tự', params: 100}
    });
    self.fiTenDongViPhongXa = ko.observable(data ? data.fiTenDongViPhongXa : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiMaHieu = ko.observable(data ? data.fiMaHieu : null);
    self.fiSoSeri = ko.observable(data ? data.fiSoSeri : null);
    self.fiHangSanXuat = ko.observable(data ? data.fiHangSanXuat : null);
    self.fiHoatDo = ko.observable(data ? data.fiHoatDo : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 15.3 ký tự', params: 15.3},
        pattern: {
            message: 'Bạn chỉ được nhập số hoặc số thập phân sau dấu chấm 3 chữ số ',
            params: /^[0-9]{1,12}(?:\.[0-9]{1,3})?$/
        }
    });
    self.fiHoatDoDonVi = ko.observable(data ? data.fiHoatDoDonVi : null);
    self.fiNgayXacDinhHoatDo = ko.observable(data ? data.fiNgayXacDinhHoatDo : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiMaMucDichSuDung = ko.observable(data ? data.fiMaMucDichSuDung : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiMucDichSuDungKhac = ko.observable(data ? data.fiMucDichSuDungKhac : null);
    self.fiTbMaHieu = ko.observable(data ? data.fiTbMaHieu : null);
    self.fiTbSoSeri = ko.observable(data ? data.fiTbSoSeri : null);
    self.fiTbHangSanXuat = ko.observable(data ? data.fiTbHangSanXuat : null);
    self.fiTbMoTaHienTrang = ko.observable(data ? data.fiTbMoTaHienTrang : null);
    self.fiXlBienPhapXuLy = ko.observable(data ? data.fiXlBienPhapXuLy : null);
    self.fiXlDiaDiemLuuGiu = ko.observable(data ? data.fiXlDiaDiemLuuGiu : null);
    self.fiHsCapgiayphepPxkId = ko.observable(data ? data.fiHsCapgiayphepPxkId : null);
    self.fiIdHoso = ko.observable(data ? data.fiIdHoso : null);
    self.fiMaHoso = ko.observable(data ? data.fiMaHoso : null);
    self.fiHoatdong = ko.observable(data ? data.fiHoatdong : null);
    self.fiNguoitao = ko.observable(data ? data.fiNguoitao : null);
    self.fiNgaytao = ko.observable(data ? data.fiNgaytao : null);
    self.fiNgCapnhat = ko.observable(data ? data.fiNgCapnhat : null);
    self.fiNgayXacDinhHoatDoText = ko.observable(data ? new Date(data.fiNgayXacDinhHoatDo).toDayFirstWithTime() : null);
    self.fiTenHoatDoDonVi = ko.observable(data ? data.fiTenHoatDoDonVi : null);
    var nguoiDkVG = [self.fiMaDongViPhongXa, self.fiTenDongViPhongXa, self.fiNgayXacDinhHoatDo, self.fiMaMucDichSuDung];
//    var nguoiApTaiVG = [self.fiTenNguoidk, self.fiSocmndNguoidk, self.fiBksPhuongtien]
    self.nguoiDkError = ko.validation.group(nguoiDkVG, {deep: true, live: true, observable: true});
//    self.nguoiApTaiError = ko.validation.group(nguoiApTaiVG, {deep: true, live: true, observable: true});
    self.fiTbNamSanXuat = ko.observable(data ? data.fiTbNamSanXuat : null);
}
var mapTbdhsPhieuKbNguonPxh06 = function (d) {
    return ko.utils.arrayMap(d, function (item, index) {
        item.fiStt = index + 1;
        return new TbdhsPhieuKbNguonPxh06(item);
    });
};

function TbdhsPhieuKbNguonPxh06(data, i) {
    var self = this;
    self.STT = ko.observable(data ? data.STT : i);

    self.fiIdKbNguonPxh = ko.observable(data ? data.fiIdKbNguonPxh : null);
    self.fiMaDongViPhongXa = ko.observable(data ? data.fiMaDongViPhongXa : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 100 ký tự', params: 100}
    });
    self.fiTenDongViPhongXa = ko.observable(data ? data.fiTenDongViPhongXa : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiMaHieu = ko.observable(data ? data.fiMaHieu : null);
    self.fiHangNuocSanXuat = ko.observable(data ? data.fiHangNuocSanXuat : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
     self.fiHoatDo = ko.observable(data ? data.fiHoatDo : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 15.3 ký tự', params: 15.3},
        pattern: {
            message: 'Bạn chỉ được nhập số hoặc số thập phân sau dấu chấm 3 chữ số ',
            params: /^[0-9]{1,12}(?:\.[0-9]{1,3})?$/
        }
    });
    self.fiHoatDoDonVi = ko.observable(data ? data.fiHoatDoDonVi : null);
    self.fiMaMucDichSuDung = ko.observable(data ? data.fiMaMucDichSuDung : null);
    self.fiMucDichSuDungKhac = ko.observable(data ? data.fiMucDichSuDungKhac : null);
    self.fiHsCapgiayphepPxkId = ko.observable(data ? data.fiHsCapgiayphepPxkId : null);
    self.fiIdHoso = ko.observable(data ? data.fiIdHoso : null);
    self.fiMaHoso = ko.observable(data ? data.fiMaHoso : null);
    self.fiHoatdong = ko.observable(data ? data.fiHoatdong : null);
    self.fiNguoitao = ko.observable(data ? data.fiNguoitao : null);
    self.fiNgaytao = ko.observable(data ? new Date(data.fiNgaytao) : null);
    self.fiNgaycapnhat = ko.observable(data ? new Date(data.fiNgaycapnhat) : null);
    self.fiTrangThaiVatLy = ko.observable(data ? data.fiTrangThaiVatLy : null);
    self.fiCongThucHoaHoc = ko.observable(data ? data.fiCongThucHoaHoc : null);


    var nguoiDkVG = [self.fiMaDongViPhongXa, self.fiTenDongViPhongXa, self.fiHangNuocSanXuat, self.fiHoatDo];
    var nguoiApTaiVG = [self.fiTenNguoidk, self.fiSocmndNguoidk, self.fiBksPhuongtien]
    self.nguoiDkError = ko.validation.group(nguoiDkVG, {deep: true, live: true, observable: true});
    self.nguoiApTaiError = ko.validation.group(nguoiApTaiVG, {deep: true, live: true, observable: true});
    self.fiTenHoatDoDonVi = ko.observable(data ? data.fiTenHoatDoDonVi : null);
}
var mapTbdlichsu06 = function (dataFromServer, p) {
    return ko.utils.arrayMap(dataFromServer, function (item, index) {
        return new Tbdlichsu06(index + 1 + p, item);
    });
};
var Tbdlichsu06 = function (STT, item) {
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
    self.fiNgaytao = ko.observable(item.fiNgaytao ? new Date(item.fiNgaytao).toDayFirstWithTime() : null);
    self.fiThoigian = ko.observable(item.fiThoigian ? new Date(item.fiThoigian).toDayFirstWithTime() : null);
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


