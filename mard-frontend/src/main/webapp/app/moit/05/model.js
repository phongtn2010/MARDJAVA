/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* global app, RAW_HS_STATUS */

var TAO_MOI = 0;
var CHO_TIEP_NHAN = 1;
var DA_TIEP_NHAN = 2;
var TU_CHOI_HOSO = 3;
var YC_BO_SUNG = 4;
var DA_RUT_HOSO = 5;
var DA_BO_SUNG_HOSO = 6;
var YC_RUT_HOSO = 7;
var DONG_Y_YC_RUT = 8;
var YC_SUA_HOSO = 9;
var DONG_Y_YC_SUA = 10;
var TU_CHOI_YC_SUA = 11;
var DUOC_CAP_VANBAN = 12;
var DIEU_CHINH_VANBAN = 13;
var DA_THU_HOI = 14;
var TU_CHOI_YC_RUT = 15;

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

var mapTbdlichsu5 = function (dataFromServer, p) {
    return ko.utils.arrayMap(dataFromServer, function (item, index) {
        return new Tbdlichsu5(index + 1 + p, item);
    });
};
var Tbdlichsu5 = function (STT, item) {
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
    var self = this;
    self.id = id;
    self.name = name;
};

var mapTbdhoso5 = function (d, p) {
    return ko.utils.arrayMap(d, function (item, index) {
        return new Tbdhoso5((index + 1) + p, item);
    });
};
function Tbdhoso5(STT, item) {
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

    if ([DUOC_CAP_VANBAN, DIEU_CHINH_VANBAN, DIEU_CHINH_VANBAN].indexOf(self.fiTrangthai()) < 0) {
        self.fiNgaycapVb(null);
    }

    self.STT = ko.observable(STT);
    self.bXemLichSu = ko.dependentObservable(function () {
        return true;
    }, self);
    self.bSuaHoSo = ko.dependentObservable(function () {
        //return true;
        return [TAO_MOI, CHO_TIEP_NHAN, YC_BO_SUNG, DA_BO_SUNG_HOSO].indexOf(self.fiTrangthai()) >= 0;
    }, self);
    self.bXinSuaHoSo = ko.dependentObservable(function () {
        //return true;
        return [DA_TIEP_NHAN, DONG_Y_YC_SUA, TU_CHOI_YC_SUA].indexOf(self.fiTrangthai()) >= 0;
    }, self);
    self.bXinRutHoSo = ko.dependentObservable(function () {
        //return true;
        return [CHO_TIEP_NHAN, DA_TIEP_NHAN, YC_BO_SUNG, DA_BO_SUNG_HOSO,
            DONG_Y_YC_SUA, TU_CHOI_YC_SUA, DUOC_CAP_VANBAN, DIEU_CHINH_VANBAN, TU_CHOI_YC_RUT].indexOf(self.fiTrangthai()) >= 0;

    }, self);
    self.bXoaHoSo = ko.dependentObservable(function () {
        //return true;
        return [TAO_MOI].indexOf(self.fiTrangthai()) >= 0;
    }, self);
    self.bXemThongBao = ko.dependentObservable(function () {
        //return true;
        return [DUOC_CAP_VANBAN, DIEU_CHINH_VANBAN].indexOf(self.fiTrangthai()) >= 0;
    }, self);

    self.fiNgayguiText = ko.observable(item.fiNgaygui ? new Date(item.fiNgaygui).toDayFirstWithTime() : null);
}

function TbdhsHanghoa5(data, i) {
    var self = this;
    self.fiIdHh = ko.observable(data ? data.fiIdHh : null);
    self.fiStt = ko.observable(data ? data.fiStt : i);
    self.fiLoaiNguyenlieu = ko.observable(data ? data.fiLoaiNguyenlieu : null).extend({
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiMaNguyenlieu = ko.observable(data ? data.fiMaNguyenlieu : null).extend({
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiTenNguyenlieu = ko.observable(data ? data.fiTenNguyenlieu : null).extend({
        maxLength: {message: 'Tối đa 2000 ký tự', params: 2000}
    });
    self.fiDangkyNhapkhauNamx1 = ko.observable(data ? data.fiDangkyNhapkhauNamx1 : null).extend({
        maxLength: {message: 'Tối đa 12 ký tự và phải nhập số hoặc số thập phân sau dấu phẩy 3 chữ số', params: 12},
        pattern: {
            message: 'Bạn phải nhập số hoặc số thập phân sau dấu phẩy 3 chữ số ví dụ: 1.234',
            params: /^[0-9]{0,9}(?:\.[0-9]{0,3})?$/
        }
    });

    self.fiSoluongCapX1 = ko.observable(data ? data.fiSoluongCapX1 : null).extend({
        maxLength: {message: 'Tối đa 12 ký tự và phải nhập số hoặc số thập phân sau dấu phẩy 3 chữ số', params: 12},
        pattern: {
            message: 'Bạn phải nhập số hoặc số thập phân sau dấu phẩy 3 chữ số ví dụ: 1.234',
            params: /^[0-9]{0,9}(?:\.[0-9]{0,3})?$/
        }
    });
    self.fiUocThuchienX1 = ko.observable(data ? data.fiUocThuchienX1 : null).extend({
        maxLength: {message: 'Tối đa 12 ký tự và phải nhập số hoặc số thập phân sau dấu phẩy 3 chữ số', params: 12},
        pattern: {
            message: 'Bạn phải nhập số hoặc số thập phân sau dấu phẩy 3 chữ số ví dụ: 1.234',
            params: /^[0-9]{0,9}(?:\.[0-9]{0,3})?$/
        }
    });
    self.fiDangkyNhapkhauNamx = ko.observable(data ? data.fiDangkyNhapkhauNamx : null).extend({
        maxLength: {message: 'Tối đa 12 ký tự và phải nhập số hoặc số thập phân sau dấu phẩy 3 chữ số', params: 12},
        pattern: {
            message: 'Bạn phải nhập số hoặc số thập phân sau dấu phẩy 3 chữ số ví dụ: 1.234',
            params: /^[0-9]{0,12}(?:\.[0-9]{0,3})?$/
        }
    });

    self.fiHoatdong = ko.observable(data ? data.fiHoatdong : null);
    self.fiNguoitao = ko.observable(data ? data.fiNguoitao : null);
    self.fiNgaytao = ko.observable(data ? data.fiNgaytao : null);
    self.fiNgCapnhat = ko.observable(data ? data.fiNgCapnhat : null);
    self.fiIdHoso = ko.observable(data ? data.fiIdHoso : null);
    
    
    var hhVG = [self.fiDangkyNhapkhauNamx,self.fiUocThuchienX1,self.fiSoluongCapX1,self.fiDangkyNhapkhauNamx1];

    self.hhErrors = ko.validation.group(hhVG, {deep: true, live: true, observable: true});
}
var mapTbdhsHanghoa5 = function (d) {
    return ko.utils.arrayMap(d, function (item, index) {
        item.fiStt = index + 1;
        return new TbdhsHanghoa5(item, index + 1);
    });
};