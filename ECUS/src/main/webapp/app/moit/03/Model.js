/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var STATUS_TAO_MOI = 0;
var STATUS_CHO_TIEP_NHAN = 1;
var STATUS_DA_TIEP_NHAN = 2;
var STATUS_DA_RUT_HOSO = 3;
var STATUS_YEUCAU_BOSUNG_HOSO = 4;
var STATUS_DA_BOSUNG_HOSO = 5;
var STATUS_DA_SUA_HOSO = 6;
var STATUS_NHAN_QUYET_DINH = 7;
var STATUS_NHAN_QUYET_DINH_HUY = 8;
var STATUS_NHAN_QUYET_DINH_DINH_CHI = 9;
var STATUS_YC_HUY_QUYET_DINH = 10;
var STATUS_YC_DINH_CHI_QUYET_DINH = 11;
var STATUS_YC_GIA_HAN_QUYET_DINH = 12;
var STATUS_NHAN_QUYET_DINH_GIA_HAN = 13;
var STATUS_TC_GIA_HAN_QUYET_DINH = 14;
var STATUS_DA_GUI_TT_KHAC_PHUC = 15;
var STATUS_DONG_Y_TT_KHAC_PHUC = 16;
var STATUS_TC_TT_KHAC_PHUC = 17;

function ConfirmMessageVM(fiMsg, fiMaHoso) {
    var self = this;
    self.fiMsg = ko.observable(fiMsg);
    self.fiMaHoso = ko.observable(fiMaHoso);
}

function RutHoSoVM(fiMsg, fiMaHoso, fiTrangthai) {
    var self = this;
    self.fiMsg = ko.observable(fiMsg);
    self.fiTrangthai = ko.observable(fiTrangthai);
    
    self.fiContent = ko.observable(self.fiTrangthai() <= STATUS_CHO_TIEP_NHAN ? 'ly do': null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 500 ký tự', params: 500}
    });
    self.fiMaHoso = ko.observable(fiMaHoso);

    var lstVG = [self.fiContent];
    self.lstErrors = ko.validation.group(lstVG, {deep: true, live: true, observable: true});

    self.isValidForm = function () {
        if (self.fiTrangthai() > 1) {
            if (self.lstErrors().length > 0) {
                self.lstErrors.showAllMessages();
                return false;
            }
        }
        return true;
    };
}

function TbdHosoViewModel(STT, item) {
    var self = this;
    self.STT = ko.observable(STT);
    if (item) {
        ko.mapping.fromJS(item, {}, self);
    }

    self.fiNgaytao = ko.observable(item.fiNgaytao ? new Date(item.fiNgaytao).toDayFirstWithTime() : null);
    self.bXemHoSo = ko.dependentObservable(function () {
        return true;
    }, self);
    self.bSuaHoSo = ko.dependentObservable(function () {
        return [STATUS_TAO_MOI, STATUS_CHO_TIEP_NHAN, STATUS_DA_TIEP_NHAN, STATUS_YEUCAU_BOSUNG_HOSO, STATUS_DA_BOSUNG_HOSO, STATUS_DA_SUA_HOSO].indexOf(self.fiTrangthai()) >= 0;
    }, self);
    self.bXoaHoSo = ko.dependentObservable(function () {
        return [STATUS_TAO_MOI].indexOf(self.fiTrangthai()) >= 0;
    }, self);
    self.bRutHoSo = ko.dependentObservable(function () {
        return [STATUS_CHO_TIEP_NHAN, STATUS_DA_TIEP_NHAN, STATUS_YEUCAU_BOSUNG_HOSO, STATUS_DA_BOSUNG_HOSO, STATUS_DA_SUA_HOSO].indexOf(self.fiTrangthai()) >= 0;
    }, self);
    self.bXinGiaHanBoSung = ko.dependentObservable(function () {
        return [STATUS_YEUCAU_BOSUNG_HOSO].indexOf(self.fiTrangthai()) >= 0;
    }, self);
    self.bXemQuyetDinh = ko.dependentObservable(function () {
        return [STATUS_NHAN_QUYET_DINH].indexOf(self.fiTrangthai()) >= 0;
    }, self);
}

function ListTbdHosoModel(data, pageSize, pageNo) {
    return ko.utils.arrayMap(data, function (item, index) {
        return new TbdHosoViewModel(pageSize*(pageNo-1)+index + 1, item);
    });
}
//Danh cho mapping thong tin tu to khai
function TbdHangHoaModel(id, index, item) {
    this.fiIdHh = ko.observable(id);
    this.fiSotk = ko.observable(null);
    this.fiIdHoso = ko.observable(null);
    this.fiMaHs = ko.observable(item.fiMaHs());
    this.fiMaHh = ko.observable(null);
    this.fiTenHh = ko.observable(item.fiTenHh());
    this.fiTenNsx = ko.observable(null);
    this.fiMaQg = ko.observable(null);
    this.fiTenQg = ko.observable(null);
    this.fiKyhieu = ko.observable(null);
    this.fiKieu = ko.observable(null);
    this.fiPhamvido = ko.observable(null);
    this.fiCapCx = ko.observable(null);    
    this.fiDactinhKt = ko.observable(null);
    this.fiGhiChu = ko.observable(null);
    this.fiNgaytao = ko.observable(null);
    this.fiHoatdong = ko.observable(null);
    this.fiNguoitao = ko.observable(null);
    this.fiMaql = ko.observable(item.fiMaQl());
    this.isChecked = ko.observable(item.isChecked());
    this.stt = ko.observable(index);
}

function TbdhanghoaViewModel(item, index) {
    var self = this;
    if (item) {
        ko.mapping.fromJS(item, {}, self);
    }

    if (item.fiIdHh === null || item.fiIdHh === 0) {
        self.fiIdHh(-1 * new Date().getTime());
    }

    self.stt = ko.observable(index);
    this.bSua = ko.dependentObservable(function () {
        return true;
    }, this);
    this.bXoa = ko.dependentObservable(function () {
        return true;
    }, this);
}

function ListTbdhanghoaModel(data) {
    return ko.utils.arrayMap(data, function (item, index) {
        return new TbdhanghoaViewModel(item, index + 1);
    });
}

function TbdHaiQuanViewModel(item, index) {
    var self = this;
    if (item) {
        ko.mapping.fromJS(item, {}, self);
    }
    if (item.fiIdTk === null) {
        self.fiIdTk(-1 * new Date().getTime());
    }
    self.fiNgayDKVN = ko.observable(item.fiNgayDk ? new Date(item.fiNgayDk).toDayFirstString() : new Date().toDayFirstString());
    self.fiNgayCapHoaDon = ko.observable(item.fiNgayCapHd ? new Date(item.fiNgayCapHd).toDayFirstString() : new Date().toDayFirstString());
    self.stt = ko.observable(index);
}

function ListTbdHaiQuanModel(data) {
    return ko.utils.arrayMap(data, function (item, index) {
        return new TbdHaiQuanViewModel(item, index + 1);
    });
}

function TokhaiHangHoaResponseViewModel(item) {
    var self = this;
    if (item) {
        ko.mapping.fromJS(item, {}, self);
    }

    self.isChecked = ko.observable(false);

    self.onChecked = function () {
        return !self.isChecked();
    };
}

function ListTokhaiHangHoaResponseModel(data) {
    return ko.utils.arrayMap(data, function (item, index) {
        return new TokhaiHangHoaResponseViewModel(item);
    });
}

function Tbdtokhaihq3ViewModel(index, item) {
    this.stt = ko.observable(index);
    this.fiIdTk = ko.observable(-1 * new Date().getTime());
    this.fiSoTk = ko.observable(item.fiSoTk());
    this.fiNgayDk = ko.observable(item.fiNgayDk());
    this.fiMaHq = ko.observable(item.fiMaHq());

    this.fiTenDvNk = ko.observable(item.fiNguoiNk());
    this.fiDiachiDvNk = ko.observable(item.fiDiachiNnk());

    this.fiTenDvXk = ko.observable(item.fiNguoiXk());
    this.fiDiachiDvXk = ko.observable(item.fiDiachiNxk());
    this.fiNuocXk = ko.observable(item.fiNuocXk());

    this.fiSoHoadon = ko.observable(item.fiSoHoadon());
    this.fiNgayCapHd = ko.observable(item.fiNgayCapHd());
    this.fiSoluong = ko.observable(item.fiSoluong());
    this.fiTong = ko.observable(item.fiTong());

    this.fiIdHoso = ko.observable(null);
    this.fiGhichu = ko.observable(null);
    this.fiNgaytao = ko.observable(null);
    this.fiHoatdong = ko.observable(1);
    this.fiNguoitao = ko.observable(null);
    this.fiMaHoso = ko.observable(null);

    this.fiNgayDKVN = ko.observable(new Date(item.fiNgayDk()).toDayFirstString());

    this.toKhaiHQDs = ListTbdtokhaihqd3Model(item.lstHanghoa());
}

function Tbdtokhaihqd3ViewModel(item) {
    this.fiIdSp = ko.observable(null);
    this.fiMaHs = ko.observable(item.fiMaHs());
    this.fiTenHh = ko.observable(item.fiTenHh());
    this.fiKlSl = ko.observable(item.fiKlSl());
    this.fiTenDv = ko.observable(item.fiTenDv());

    this.fiIdTk = ko.observable(item.fiIdTk());
    this.fiGhichu = ko.observable(null);

    this.fiNgaytao = ko.observable(null);
    this.fiHoatdong = ko.observable(1);
    this.fiNguoitao = ko.observable(null);

    this.fiMaql = ko.observable(item.fiMaQl());
    this.stt = ko.observable(item.fiStt());
}

function ListTbdtokhaihqd3Model(data) {
    return ko.utils.arrayMap(data, function (item, index) {
        return new Tbdtokhaihqd3ViewModel(item);
    });
}

function Tbddinhkem3(STT, item) {
    var self = this;
    self.stt = ko.observable(STT);
    if (item) {
        ko.mapping.fromJS(item, {}, self);
    }
    self.downloadUrl = ko.computed(function () {
        return app.appContext + "/file/download/" + self.fiMostId();
    });
    self.bXoa = ko.dependentObservable(function () {
        return true;
    }, this);
}

function ListTbddinhkem3Model(d) {
    return ko.utils.arrayMap(d, function (item, index) {
        return new Tbddinhkem3(index + 1, item);
    });
}

function Tbdlichsu3Model(STT, item) {
    var self = this;
    self.STT = ko.observable(STT);
    if (item) {
        ko.mapping.fromJS(item, {}, self);
    }
    self.downloadUrl = ko.computed(function () {
        return app.appContext + "/most/03/dinhkem/" + self.fiIdLichsu()+"/"+self.fiIdHoso();
    });
    self.fiNgaytao = ko.observable(item.fiNgaytao ? new Date(item.fiNgaytao).toDayFirstWithTime() : null);
    self.fiThoihan = ko.observable(item.fiThoihan ? new Date(item.fiThoihan).toDayFirstWithTime() : null);
}

function ListTbdlichsu3Model(data) {
    return ko.utils.arrayMap(data, function (item, index) {
        return new Tbdlichsu3Model(index + 1, item);
    });
}


function Tbddinhkem3QD(STT, item) {
    var self = this;
    self.stt = ko.observable(STT);
    if (item) {
        ko.mapping.fromJS(item, {}, self);
    }
    self.downloadUrl = ko.computed(function () {
        return app.appContext + "/most/03/quyetDinhFile/" + self.fiMaHoso()+"/"+item.fiMaLoai;
    });
}

function ListTbddinhkem3QDModel(d) {
    return ko.utils.arrayMap(d, function (item, index) {
        return new Tbddinhkem3QD(index + 1, item);
    });
}

$(document).ready(function(){
    $('.date-picker').datepicker({rtl: false, orientation: "left", autoclose: true, todayHighlight: true});
})