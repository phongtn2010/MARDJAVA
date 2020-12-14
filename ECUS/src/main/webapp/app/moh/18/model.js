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
var TU_CHOI_HOSO = 6;
var TU_CHOI_CAP_PHEP = 7;
var DUOC_CAP_GIAYPHEP = 8;

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

var mapTbdlichsu18 = function (dataFromServer) {
    return ko.utils.arrayMap(dataFromServer, function (item, index) {
        return new Tbdlichsu18(index + 1, item);
    });
};
var Tbdlichsu18 = function (STT, item) {
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

var mapTbdhoso18 = function (d, p) {
    return ko.utils.arrayMap(d, function (item, index) {
        return new Tbdhoso18((index + p) + 1, item);
    });
};
function Tbdhoso18(STT, item) {
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
        self.fiNgaycapCv(null);
    }

    self.STT = ko.observable(STT);
    self.bXemLichSu = ko.dependentObservable(function () {
        return true;
    }, self);
    self.bSuaHoSo = ko.dependentObservable(function () {
        //return true;
        return [TAO_MOI, CHO_TIEP_NHAN, YC_BO_SUNG, TU_CHOI_HOSO].indexOf(self.fiTrangthai()) >= 0;
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
        return [DUOC_CAP_GIAYPHEP].indexOf(self.fiTrangthai()) >= 0;
    }, self);

    self.fiNgayguiText = ko.observable(item.fiNgaynop ? new Date(item.fiNgaynop).toDayFirstWithTime() : null);
}

function TbdhsNglieu18(data) {
    var self = this;
    self.fiStt = ko.observable(data ? data.fiStt : null);
    self.fiIdNglieu = ko.observable(data ? data.fiIdNglieu : null);
    self.fiIdDonhang = ko.observable(data ? data.fiIdDonhang : null);
    self.fiMaHoso = ko.observable(data ? data.fiMaHoso : null);
    self.fiMaNglieu = ko.observable(data ? data.fiMaNglieu : null);
    self.fiTenNglieu = ko.observable(data ? data.fiTenNglieu : null);
    self.fiTenNglieuNsx = ko.observable(data ? data.fiTenNglieuNsx : null);
    self.fiLoaiNglieu = ko.observable(data ? data.fiLoaiNglieu : null);
    self.fiTongKl = ko.observable(data ? data.fiTongKl : null).extend({
        number: {message: 'Phải nhập giá trị là số', params: true},
        pattern: {
            message: 'Phải nhập giá trị với tối đa 2 số ở phần thập phân ví dụ: 1.23',
            params: '^[1-9]{0,15}(?:\.[0-9]{0,2})?$'
        }
    });
    self.fiHoatdong = ko.observable(data ? data.fiHoatdong : null);
    self.fiNguoitao = ko.observable(data ? data.fiNguoitao : null);
    self.fiNgaytao = ko.observable(data ? data.fiNgaytao : null);
    self.fiNgCapnhat = ko.observable(data ? data.fiNgCapnhat : null);
}
var mapTbdhsNglieu18 = function (d) {
    return ko.utils.arrayMap(d, function (item, index) {
        item.fiStt = index + 1;
        return new TbdhsNglieu18(item);
    });
};

var mapTbdhsCuaKhau = function (d) {
    return ko.utils.arrayMap(d, function (item, index) {        
        return item.fiMaCkhau;
    });
};

function hangHoaItem(data) {
    var self = this;
    self.fiTenHang = ko.observable(data ? data.fiTenHang : null);
    self.fiBaoChe = ko.observable(data ? data.fiBaoChe : null);
    self.fiDongGoi = ko.observable(data ? data.fiDongGoi : null);
    self.fiHoatChat = ko.observable(data ? data.fiHoatChat : null);
    self.fiSoDkLh = ko.observable(data ? data.fiSoDkLh : null);
    self.fiTenDvtinh = ko.observable(data ? data.fiTenDvtinh : null);
    self.fiSoLuong = ko.observable(data ? data.fiSoLuong : null);    
    self.fiTccl = ko.observable(data ? data.fiTccl : null);    
    self.fiTenCoSoSx = ko.observable(data ? data.fiTenCoSoSx : null);
    self.fiDiachiCssx = ko.observable(data ? data.fiDiachiCssx : null);
    self.fiTenQgSx = ko.observable(data ? data.fiTenQgSx : null);
    self.fiTenCoSoNk = ko.observable(data ? data.fiTenCoSoNk : null);
    self.fiDiachiCsNk = ko.observable(data ? data.fiDiachiCsNk : null);
    self.fiTenQgNk = ko.observable(data ? data.fiTenQgNk : null);
    self.fiTenNglieu = ko.observable(data ? data.fiTenNglieu : null);
    self.fiTongKl = ko.observable(data ? data.fiTongKl : null);
}

