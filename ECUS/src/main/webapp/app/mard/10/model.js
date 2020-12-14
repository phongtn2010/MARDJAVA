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

var mapTbdLichsu10  = function (dataFromServer) {
    return ko.utils.arrayMap(dataFromServer, function (item, index) {
        return new Tbdlichsu10(index + 1, item);
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
var mapTbddinhkem10 = function (dataFromServer) {
    return ko.utils.arrayMap(dataFromServer, function (item, index) {
        return new Tbddinhkem10(index + 1, item);
    });
};

var mapTbdhoso10 = function (dataFromServer) {
    return ko.utils.arrayMap(dataFromServer, function (item, index) {
        return new Tbdhoso10(index + 1, item);
    });
};

var Tbdlichsu10 = function (STT, item) {
    var self = this;
    this.STT = ko.observable(STT);
    if (item != null) {
        ko.mapping.fromJS(item, {}, self);
    }
    
    self.fiTenTrangthai = ko.computed(function() {
        if(!RAW_HS_STATUS || RAW_HS_STATUS.length <= 0){
            return self.fiTrangthai();
        }
        else{
            for(var i = 0; i < RAW_HS_STATUS.length;i++){
                if(RAW_HS_STATUS[i]["id"] == self.fiTrangthai()){
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

var mapTbdhanghoa10 = function(dataFromServer){
    return ko.utils.arrayMap(dataFromServer, function (item, index) {
        return new Tbdhanghoa10(item);
    });
};
function Tbdhanghoa10(item) {
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

function Tbdhanghoa(fiStt, fiIdHh, fiTenHh, fiNoiSx, fiSoluong, fiMdvSl, fiTendvSl, fiTlTinh, fiMaTlTinh, fiTentlTinh, fiTlBi, fiMaTlBi, fiTenTlBi, fiLoaiBb, fiSoHd) {
    this.fiIdHh = ko.observable(fiIdHh);
    this.fiStt = ko.observable(fiStt);
    this.fiTenHh = ko.observable(fiTenHh);
    this.fiNoiSx = ko.observable(fiNoiSx);
    this.fiSoluong = ko.observable(fiSoluong);
    this.fiMdvSl = ko.observable(fiMdvSl);
    this.fiTendvSl = ko.observable(fiTendvSl);
    this.fiTlTinh = ko.observable(fiTlTinh);
    this.fiMaTlTinh = ko.observable(fiMaTlTinh);
    this.fiTentlTinh = ko.observable(fiTentlTinh);
    this.fiTlBi = ko.observable(fiTlBi);
    this.fiMaTlBi = ko.observable(fiMaTlBi);
    this.fiTenTlBi = ko.observable(fiTenTlBi);
    this.fiLoaiBb = ko.observable(fiLoaiBb);
    this.fiSoHd = ko.observable(fiSoHd);
    this.fiIdHoso= ko.observable();
    this.fiMaHoso= ko.observable();

    this.bSua = ko.dependentObservable(function () {
        return true;
    }, this);

    this.bXoa = ko.dependentObservable(function () {
        return true;
    }, this);
};

function Tbddinhkem10(STT, item) {
    var self = this;
    this.STT = ko.observable(STT);
    if (item != null) {
        ko.mapping.fromJS(item, {}, self);
    }

    this.viewUrl = ko.computed(function () {
        return app.appContext + "/mard/10/download/" + self.fiIdDinhkem() + "?mode=view";
    });
    this.downloadUrl = ko.computed(function () {
        return app.appContext + "/mard/10/download/" + self.fiIdDinhkem() + "?mode=";
    });


    this.bXoa = ko.dependentObservable(function () {
        return true;
    }, this);
}
;

function Tbdhoso10(STT, item) {
    var self = this;
    
    if (item) {
        ko.mapping.fromJS(item, {}, self);
    }
    self.fiTenTrangthai = ko.computed(function() {
        if(!RAW_HS_STATUS || RAW_HS_STATUS.length <= 0){
            return self.fiTrangthai();
        }
        else{
            for(var i = 0; i < RAW_HS_STATUS.length;i++){
                if(RAW_HS_STATUS[i]["id"] == self.fiTrangthai()){
                    return RAW_HS_STATUS[i]["name"] ? RAW_HS_STATUS[i]["name"] : self.fiTrangthai();
                }
            }
        }
    }, self);
    
    self.STT = ko.observable(STT);
    self.bXem = ko.dependentObservable(function(){
        return true;
    }, self);
    self.bSua = ko.dependentObservable(function () {
        return [YEU_CAU_BO_SUNG,TAO_MOI,CHO_TIEP_NHAN,CHO_TIEP_NHAN_BO_SUNG].indexOf(self.fiTrangthai()) >= 0;
    }, self);
    self.bXinSua = ko.dependentObservable(function () {
        return [THONG_BAO_XU_LY_LO_HANG,QUYET_DINH_XU_LY_VSTY,DONG_Y_YCCS, DA_TIEP_NHAN,DA_XAC_NHAN_DON_KHAI_BAO_KD,DA_GUI_THONG_BAO_AP_PHI,DA_NOP_PHI_CK,DA_YC_NOP_BS_PHI].indexOf(self.fiTrangthai()) >= 0;
    }, self);
    self.bHuy = ko.dependentObservable(function () {
        return [YEU_CAU_BO_SUNG,TAO_MOI,CHO_TIEP_NHAN,CHO_TIEP_NHAN_BO_SUNG].indexOf(self.fiTrangthai()) >= 0;
    }, self);
    self.bXinHuy = ko.dependentObservable(function () {
        return [THONG_BAO_XU_LY_LO_HANG,QUYET_DINH_XU_LY_VSTY, DONG_Y_YCCS, CHO_TIEP_NHAN_YCCS,DA_TIEP_NHAN,DA_XAC_NHAN_DON_KHAI_BAO_KD,DA_GUI_THONG_BAO_AP_PHI,DA_NOP_PHI_CK,DA_YC_NOP_BS_PHI].indexOf(self.fiTrangthai()) >= 0 ;
    }, self);
    self.bThongBaoCK = ko.dependentObservable(function () {
        return [DA_GUI_THONG_BAO_AP_PHI,DA_YC_NOP_BS_PHI].indexOf(self.fiTrangthai()) >= 0;
    }, self);
    self.bXinSuaGCN = ko.dependentObservable(function () {
        return [GCN_14A,GCN_14B,GCN_15A,GCN_15B,GCN_15C].indexOf(self.fiTrangthai()) >= 0;
    }, self);
}

var  TAO_MOI = 0;
var  CHO_TIEP_NHAN = 1;
var  CHO_TIEP_NHAN_BO_SUNG = 2;
var  DA_HUY = 3;
var  BI_TU_CHOI = 4;
var  YEU_CAU_BO_SUNG = 5;
var  DA_TIEP_NHAN = 6;
var  DA_XAC_NHAN_DON_KHAI_BAO_KD = 7;
var  DA_GUI_THONG_BAO_AP_PHI = 8;
var  DA_NOP_PHI_CK = 9;
var  DA_YC_NOP_BS_PHI = 10;
var  THONG_BAO_XU_LY_LO_HANG = 11;
var  QUYET_DINH_XU_LY_VSTY = 12;
var  GCN_14A = 13;
var  GCN_14B = 14;
var  GCN_15A = 15;
var  GCN_15B = 16;
var  GCN_15C = 17;
var  CHO_TIEP_NHAN_YCCS = 18;
var  DONG_Y_YCCS = 19;
var  TU_CHOI_YCCS = 20;
var  CHO_TIEP_NHAN_YC_XIN_RUT = 21;
var  DONG_Y_YC_XIN_RUT = 22;
var  TU_CHOI_YC_XIN_RUT = 23;
var  CHO_TIEP_NHAN_YC_CS_GCN = 24;
var  DA_CHINH_SUA_GCN_THEO_YC = 25;
var  TU_CHOI_YC_CS_GCN = 26;
var  DA_SUA_GCN_KIEM_DICH = 27;
var  DA_SUADOI_BS = 28;