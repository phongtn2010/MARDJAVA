/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var STATUS_TAO_MOI = 0;
var STATUS_CHO_TIEP_NHAN = 1;
var STATUS_DA_TIEP_NHAN = 2;
var STATUS_THONG_BAO_KIEM_TRA = 3;
var STATUS_DA_RUT = 4;
var STATUS_YC_BO_SUNG = 5;
var STATUS_DA_BO_SUNG = 6;
var STATUS_YC_XIN_RUT_HOSO = 7;
var STATUS_DONG_Y_YC_RUT = 8;
var STATUS_XIN_SUA_HOSO = 9;
var STATUS_DONG_Y_YC_XIN_SUA = 10;
var STATUS_TU_CHOI_YC_XIN_SUA = 11;
var STATUS_YC_BO_SUNG_TAI_LIEU = 12;
var STATUS_DA_GUI_TAI_LIEU = 13;
var STATUS_DA_CAP_GIAY_CFS = 14;
var STATUS_TU_CHOI_CAP_GIAY_CFS = 15;
var STATUS_DA_THU_HOI_GIAY_CFS = 16;

function ConfirmMessageVM(fiMsg, fiMaHoso) {
    var self = this;
    self.fiMsg = ko.observable(fiMsg);
    self.fiMaHoso = ko.observable(fiMaHoso);
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
        return [STATUS_TAO_MOI, STATUS_CHO_TIEP_NHAN, STATUS_DA_TIEP_NHAN, STATUS_YC_BO_SUNG, STATUS_DA_BO_SUNG, STATUS_DONG_Y_YC_XIN_SUA, STATUS_TU_CHOI_YC_XIN_SUA].indexOf(self.fiTrangthai()) >= 0;
    }, self);
    self.bXoaHoSo = ko.dependentObservable(function () {
        return [STATUS_TAO_MOI].indexOf(self.fiTrangthai()) >= 0;
    }, self);
    self.bRutHoSo = ko.dependentObservable(function () {
        return [STATUS_CHO_TIEP_NHAN, STATUS_DA_TIEP_NHAN, STATUS_YC_BO_SUNG, STATUS_DA_BO_SUNG, 
            STATUS_DONG_Y_YC_XIN_SUA, STATUS_TU_CHOI_YC_XIN_SUA, STATUS_YC_BO_SUNG_TAI_LIEU, STATUS_DA_GUI_TAI_LIEU].indexOf(self.fiTrangthai()) >= 0;
    }, self);
    self.bBoSungTaiLieu = ko.dependentObservable(function () {
        return [STATUS_YC_BO_SUNG_TAI_LIEU].indexOf(self.fiTrangthai()) >= 0;
    }, self);
    self.bXemGiayChungNhan = ko.dependentObservable(function () {
        return [STATUS_DA_CAP_GIAY_CFS].indexOf(self.fiTrangthai()) >= 0;
    }, self);
}

function ListTbdHosoModel(data, pageSize, pageNo) {
    return ko.utils.arrayMap(data, function (item, index) {
        return new TbdHosoViewModel(pageSize*(pageNo-1)+index + 1, item);
    });
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

function Tbddinhkem4(STT, item) {
    var self = this;
    self.stt = ko.observable(STT);
    if (item) {
        ko.mapping.fromJS(item, {}, self);
    }
    self.downloadUrl = ko.computed(function () {
        return app.appContext + "/file/download/" + self.fiKhcnId();
    });
    self.bXoa = ko.dependentObservable(function () {
        return true;
    }, this);
}

function ListTbddinhkem4Model(d) {
    return ko.utils.arrayMap(d, function (item, index) {
        return new Tbddinhkem4(index + 1, item);
    });
}

function Tbdlichsu4Model(STT, item) {
    var self = this;
    self.STT = ko.observable(STT);
    self.downloadUrl = ko.computed(function () {
        return app.appContext + "/most/04/dinhkemls/" + item.fiIdLichsu;
    });
    if (item) {
        ko.mapping.fromJS(item, {}, self);
    }
    self.fiNgaytao = ko.observable(item.fiNgaytao ? new Date(item.fiNgaytao).toDayFirstWithTime() : null);
    self.fiThoihan = ko.observable(item.fiThoihan ? new Date(item.fiThoihan).toDayFirstWithTime() : null);
}

function ListTbdlichsu4Model(data) {
    return ko.utils.arrayMap(data, function (item, index) {
        return new Tbdlichsu4Model(index + 1, item);
    });
}

function Tbddinhkem3QD(STT, item) {
    var self = this;
    self.stt = ko.observable(STT);
    if (item) {
        ko.mapping.fromJS(item, {}, self);
    }
    self.downloadUrl = ko.computed(function () {
        return app.appContext + "/getfile/most/03/" + self.fiGuiId();
    });
}

function ListTbddinhkem3QDModel(d) {
    return ko.utils.arrayMap(d, function (item, index) {
        return new Tbddinhkem3QD(index + 1, item);
    });
}
