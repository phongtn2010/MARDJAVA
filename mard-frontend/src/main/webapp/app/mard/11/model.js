/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* global app, RAW_HS_STATUS */

ko.observableArray.fn.firstIndexOf = function (predicate, predicateOwner) {
    for (var i = 0, j = this().length; i < j; i++) {
        if (predicate.call(predicateOwner, this()[i])) {
            return i;
        }
    }
    return -1;
};

var mapTbdhhgcn11 = function (dataFromServer) {
    return ko.utils.arrayMap(dataFromServer, function (item, index) {
        return new TbdhhGcn11FromItem(index + 1, item);
    });
};

var mapTbdLichsu11 = function (dataFromServer) {
    return ko.utils.arrayMap(dataFromServer, function (item, index) {
        return new Tbdlichsu11(index + 1, item);
    });
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
var mapTbddinhkem11 = function (dataFromServer) {
    return ko.utils.arrayMap(dataFromServer, function (item, index) {
        return new Tbddinhkem11(index + 1, item);
    });
};

var mapTbdhoso11 = function (dataFromServer) {
    return ko.utils.arrayMap(dataFromServer, function (item, index) {
        return new Tbdhoso11(index + 1, item);
    });
};

var Tbdlichsu11 = function (STT, item) {
    var self = this;
    this.STT = ko.observable(STT);
    if (item != null) {
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
};

var Category = function (id, name) {
    this.id = id;
    this.name = name;
};

var mapTbdhanghoa11 = function (dataFromServer) {
    return ko.utils.arrayMap(dataFromServer, function (item, index) {
        return new Tbdhanghoa11(item);
    });
};
function Tbdhanghoa11(item) {
    var self = this;
    if (item != null) {
        ko.mapping.fromJS(item, {}, self);
    }

    this.bSua = ko.dependentObservable(function () {
        return true;
    }, this);

    this.bXoa = ko.dependentObservable(function () {
        return true;
    }, this);
}

function Tbdhanghoa(fiStt, fiIdHanghoa, fiTenHh, fiTenKh, fiCososx, fiMaCososx, 
fiDiachiCssx, fiSoluong, fiMdvSl, fiTendvSl, fiKlTinh, fiMadvKlt, fiTendvKlt, 
fiKlBi, fiMadvBi, fiTendvBi, fiMahs, fiSohd, fiIdHoso, fiMaHoso, fiMasp) {
    this.fiIdHanghoa = ko.observable(fiIdHanghoa);
    this.fiStt = ko.observable(fiStt);
    this.fiTenHh = ko.observable(fiTenHh);
    this.fiTenKh = ko.observable(fiTenKh);
    this.fiCososx = ko.observable(fiCososx);
    this.fiMaCososx = ko.observable(fiMaCososx);
    this.fiDiachiCssx = ko.observable(fiDiachiCssx);
    this.fiMadvSl = ko.observable(fiMdvSl);
    this.fiTendvSl = ko.observable(fiTendvSl);
    this.fiSoluong = ko.observable(fiSoluong);
    this.fiMadvKlt = ko.observable(fiMadvKlt);
    this.fiTendvKlt = ko.observable(fiTendvKlt);
    this.fiKlTinh = ko.observable(fiKlTinh);
    this.fiMadvBi = ko.observable(fiMadvBi);
    this.fiTendvBi = ko.observable(fiTendvBi);
    this.fiKlBi = ko.observable(fiKlBi);
    this.fiMahs = ko.observable(fiMahs);
    this.fiMasp = ko.observable(fiMasp);
    this.fiSohd = ko.observable(fiSohd);
    this.fiIdHoso = ko.observable(fiIdHoso);
    this.fiMaHoso = ko.observable(fiMaHoso);

    this.bSua = ko.dependentObservable(function () {
        return true;
    }, this);

    this.bXoa = ko.dependentObservable(function () {
        return true;
    }, this);
}
;

function Tbddinhkem11(STT, item) {
    var self = this;
    this.STT = ko.observable(STT);
    if (item != null) {
        ko.mapping.fromJS(item, {}, self);
    }

    this.viewUrl = ko.computed(function () {
        return app.appContext + "/mard/11/download/" + self.fiIdDinhkem() + "?mode=view";
    });
    this.downloadUrl = ko.computed(function () {
        return app.appContext + "/mard/11/download/" + self.fiIdDinhkem() + "?mode=";
    });


    this.bXoa = ko.dependentObservable(function () {
        return true;
    }, this);
}
;

function Tbdhoso11(STT, item) {
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
    self.bXem = ko.dependentObservable(function () {
        return true;
    }, self);
    self.bSua = ko.dependentObservable(function () {
        return [TAO_MOI, CHO_TIEP_NHAN, YEU_CAU_BO_SUNG].indexOf(self.fiTrangthai()) >= 0;//,
    }, self);
    self.bXinSua = ko.dependentObservable(function () {
        return [TU_CHOI_YCCS, TU_CHOI_YC_XIN_RUT, CHO_TIEP_NHAN_BO_SUNG, DA_XAC_NHAN_GIAY_KHAI_BAO_KD, DA_GUI_THONG_BAO_AP_PHI, DA_YC_NOP_BS_PHI, DA_NOP_PHI_CK, THONG_BAO_XU_LY_LO_HANG, DE_NGHI_CUNG_CAP_TT_GIAY_CHUNG_NHAN, CUNG_CAP_TT_GIAY_CHUNG_NHAN, DONG_Y_YCCS].indexOf(self.fiTrangthai()) >= 0;
    }, self);
    self.bHuy = ko.dependentObservable(function () {
        return [TAO_MOI].indexOf(self.fiTrangthai()) >= 0;
    }, self);
    self.bXinHuy = ko.dependentObservable(function () {
        return [TU_CHOI_YCCS, TU_CHOI_YC_XIN_RUT, CHO_TIEP_NHAN, CHO_TIEP_NHAN_BO_SUNG, YEU_CAU_BO_SUNG, CHO_TIEP_NHAN_YCCS, DA_XAC_NHAN_GIAY_KHAI_BAO_KD, DA_GUI_THONG_BAO_AP_PHI, DA_YC_NOP_BS_PHI, DA_NOP_PHI_CK, THONG_BAO_XU_LY_LO_HANG, DE_NGHI_CUNG_CAP_TT_GIAY_CHUNG_NHAN, CUNG_CAP_TT_GIAY_CHUNG_NHAN, DONG_Y_YCCS].indexOf(self.fiTrangthai()) >= 0;
    }, self);
    self.bThongBaoCK = ko.dependentObservable(function () {
        return [DA_GUI_THONG_BAO_AP_PHI, DA_YC_NOP_BS_PHI].indexOf(self.fiTrangthai()) >= 0;
    }, self);
    self.bXinSuaGCN = ko.dependentObservable(function () {
        return [DA_PHE_DUYET_GCN_KIEM_DICH, BNN_CHINH_SUA_GCN, DONG_Y_XIN_SUA_GCN, TU_CHOI_XIN_SUA_GCN].indexOf(self.fiTrangthai()) >= 0;
    }, self);
    self.bGuiTTGCN = ko.dependentObservable(function () {
        return [DE_NGHI_CUNG_CAP_TT_GIAY_CHUNG_NHAN].indexOf(self.fiTrangthai()) >= 0;
    }, self);
}

function TbdhhGcn11FromItem(index, item) {
    var self = this;
    if (item != null) {
        ko.mapping.fromJS(item, {}, self);
    }

    this.bSua = ko.dependentObservable(function () {
        return true;
    }, this);

    this.bXoa = ko.dependentObservable(function () {
        return true;
    }, this);
}

function TbdhhGcn11(fiStt, fiIdHh, fiTenHh, fiTenKh, fiMadvSl, fiTendvSl, fiSoluong, fiMadvKl, fiTendvKl, fiKhoiluong, fiMadvBi, fiTendvBi, fiKlbi, fiMadvTt, fiTendvTt, fiThetich, fiMadvTtbi, fiTendvTtbi, fiThetichbi, fiIdHoso, fiMaHoso) {
    this.fiIdHh = ko.observable(fiIdHh);
    this.fiStt = ko.observable(fiStt);
    this.fiTenHh = ko.observable(fiTenHh);
    this.fiTenKh = ko.observable(fiTenKh);

    this.fiMadvSl = ko.observable(fiMadvSl);
    this.fiTendvSl = ko.observable(fiTendvSl);
    this.fiSoluong = ko.observable(fiSoluong);

    this.fiMadvKl = ko.observable(fiMadvKl);
    this.fiTendvKl = ko.observable(fiTendvKl);
    this.fiKhoiluong = ko.observable(fiKhoiluong);

    this.fiMadvBi = ko.observable(fiMadvBi);
    this.fiTendvBi = ko.observable(fiTendvBi);
    this.fiKlbi = ko.observable(fiKlbi);

    this.fiMadvTt = ko.observable(fiMadvTt);
    this.fiTendvTt = ko.observable(fiTendvTt);
    this.fiThetich = ko.observable(fiThetich);

    this.fiMadvTtbi = ko.observable(fiMadvTtbi);
    this.fiTendvTtbi = ko.observable(fiTendvTtbi);
    this.fiThetichbi = ko.observable(fiThetichbi);

    this.fiIdHoso = ko.observable(fiIdHoso);
    this.fiMaHoso = ko.observable(fiMaHoso);

    this.bSua = ko.dependentObservable(function () {
        return true;
    }, this);

    this.bXoa = ko.dependentObservable(function () {
        return true;
    }, this);
}


var TAO_MOI = 0;
var CHO_TIEP_NHAN = 1;
var CHO_TIEP_NHAN_BO_SUNG = 2;
var DA_HUY = 3;
var BI_TU_CHOI = 4;
var YEU_CAU_BO_SUNG = 5;
//var DA_TIEP_NHAN_HOSO = 26;
var DA_XAC_NHAN_GIAY_KHAI_BAO_KD = 6;
var DA_GUI_THONG_BAO_AP_PHI = 7;
var DA_NOP_PHI_CK = 8;
var DA_YC_NOP_BS_PHI = 9;
var DA_NOP_BS_PHI = 10;
var THONG_BAO_XU_LY_LO_HANG = 11;
var DE_NGHI_CUNG_CAP_TT_GIAY_CHUNG_NHAN = 12;
var CUNG_CAP_TT_GIAY_CHUNG_NHAN = 13;
var DA_PHE_DUYET_GCN_KIEM_DICH = 14;
var CHO_TIEP_NHAN_YCCS = 15;
var DONG_Y_YCCS = 16;
var TU_CHOI_YCCS = 17;
var CHO_TIEP_NHAN_YC_XIN_RUT = 18;
var DONG_Y_YC_XIN_RUT = 19;
var TU_CHOI_YC_XIN_RUT = 20;
var CHO_TIEP_NHAN_YC_CS_GCN = 21;
var DONG_Y_XIN_SUA_GCN = 22;
var TU_CHOI_XIN_SUA_GCN = 23;
var BNN_CHINH_SUA_GCN = 24;
//var DA_SUA_DOI_BS_HOSO = 25;
//var THONG_BAO_GCN_KDTV = 28;
//var DA_XAC_NHAN_DON = 27;

var aseanVNProvince = [
    {'provinceCode': '01', 'provinceName': 'Thành Phố Hà Nội'},
    {'provinceCode': '02', 'provinceName': 'Thành Phố Hồ Chí Minh'},
    {'provinceCode': '03', 'provinceName': 'Thành Phố Hải Phòng'},
    {'provinceCode': '04', 'provinceName': 'Thành Phố Cần Thơ'},
    {'provinceCode': '05', 'provinceName': 'Thành Phố Đà Nẵng'},
    {'provinceCode': '06', 'provinceName': 'Tỉnh Hà Giang'},
    {'provinceCode': '07', 'provinceName': 'Tỉnh Cao Bằng'},
    {'provinceCode': '08', 'provinceName': 'Tỉnh Lai Châu'},
    {'provinceCode': '09', 'provinceName': 'Tỉnh Lào Cai'},
    {'provinceCode': '10', 'provinceName': 'Tỉnh Tuyên Quang'},
    {'provinceCode': '11', 'provinceName': 'Tỉnh Lạng Sơn'},
    {'provinceCode': '12', 'provinceName': 'Tỉnh Bắc Kạn'},
    {'provinceCode': '13', 'provinceName': 'Tỉnh Thái Nguyên'},
    {'provinceCode': '14', 'provinceName': 'Tỉnh Yên Bái'},
    {'provinceCode': '15', 'provinceName': 'Tỉnh Sơn La'},
    {'provinceCode': '16', 'provinceName': 'Tỉnh Phú Thọ'},
    {'provinceCode': '17', 'provinceName': 'Tỉnh Vĩnh Phúc'},
    {'provinceCode': '18', 'provinceName': 'Tỉnh Quảng Ninh'},
    {'provinceCode': '19', 'provinceName': 'Tỉnh Bắc Giang'},
    {'provinceCode': '20', 'provinceName': 'Tỉnh Bắc Ninh'},
    {'provinceCode': '21', 'provinceName': 'Tỉnh Hải Dương'},
    {'provinceCode': '22', 'provinceName': 'Tỉnh Hưng Yên'},
    {'provinceCode': '23', 'provinceName': 'Tỉnh Hòa Bình'},
    {'provinceCode': '24', 'provinceName': 'Tỉnh Hà Nam'},
    {'provinceCode': '25', 'provinceName': 'Tỉnh Nam Định'},
    {'provinceCode': '26', 'provinceName': 'Tỉnh Thái Bình'},
    {'provinceCode': '27', 'provinceName': 'Tỉnh Ninh Bình'},
    {'provinceCode': '28', 'provinceName': 'Tỉnh Thanh Hóa'},
    {'provinceCode': '29', 'provinceName': 'Tỉnh Nghệ An'},
    {'provinceCode': '30', 'provinceName': 'Tỉnh Hà Tĩnh'},
    {'provinceCode': '31', 'provinceName': ''},
    {'provinceCode': '32', 'provinceName': ''},
    {'provinceCode': '33', 'provinceName': ''},
    {'provinceCode': '34', 'provinceName': ''},
    {'provinceCode': '35', 'provinceName': ''},
    {'provinceCode': '36', 'provinceName': ''},
    {'provinceCode': '37', 'provinceName': ''},
    {'provinceCode': '38', 'provinceName': ''},
    {'provinceCode': '39', 'provinceName': ''},
    {'provinceCode': '40', 'provinceName': ''},
    {'provinceCode': '41', 'provinceName': ''},
    {'provinceCode': '42', 'provinceName': ''},
    {'provinceCode': '43', 'provinceName': ''},
    {'provinceCode': '44', 'provinceName': ''},
    {'provinceCode': '45', 'provinceName': ''},
    {'provinceCode': '46', 'provinceName': ''},
    {'provinceCode': '47', 'provinceName': ''},
    {'provinceCode': '48', 'provinceName': ''},
    {'provinceCode': '49', 'provinceName': ''},
    {'provinceCode': '50', 'provinceName': ''},
    {'provinceCode': '51', 'provinceName': ''},
    {'provinceCode': '52', 'provinceName': ''},
    {'provinceCode': '53', 'provinceName': ''},
    {'provinceCode': '54', 'provinceName': ''},
    {'provinceCode': '55', 'provinceName': ''},
    {'provinceCode': '56', 'provinceName': ''},
    {'provinceCode': '57', 'provinceName': ''},
    {'provinceCode': '58', 'provinceName': ''}
];