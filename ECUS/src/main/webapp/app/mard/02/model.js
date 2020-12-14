/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* global app, RAW_HS_STATUS */

var TAO_MOI = 0;
var CHO_TIEP_NHAN = 1;
var YC_BOSUNG = 2;
var DA_BOSUNG = 3;
var TC_HOSO = 4;
var HUY_HOSO = 5;
var DA_TIEP_NHAN = 6;
var XINSUA_HOSO = 7;
var DONGY_SUA_HOSO = 8;
var TC_SUA_HOSO = 9;
var XIN_HUY_HOSO = 10;
var DONGY_HUY_HOSO = 11;
var TC_HUY_HOSO = 12;
var CONGVAN_KIEMDICH = 13;
var XINSUA_CONGVAN = 14;
var DONGY_SUA_CONGVAN = 15;
var TC_SUA_CONGVAN = 16;
var CONGVAN_KIEMDICH_DA_SUADOI = 17;

function ConfirmMessageVM(fiMsg, nswfileCode) {
    var self = this;
    self.fiMsg = ko.observable(fiMsg);
    self.nswfileCode = ko.observable(nswfileCode);
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
    self.nameStatusFee = ko.observable(null);

    self.STT = ko.observable(STT);
    self.bXemLichSu = ko.dependentObservable(function () {
        return true;
    }, self);
    self.bSuaHoSo = ko.dependentObservable(function () {
        //return true;
        return [TC_HOSO, TAO_MOI, CHO_TIEP_NHAN, YC_BOSUNG].indexOf(self.codeStatus()) >= 0;
    }, self);
    
    self.bXinSuaHoSo = ko.dependentObservable(function () {
        //return true;
        return [DA_TIEP_NHAN, DONGY_SUA_HOSO, TC_SUA_HOSO].indexOf(self.codeStatus()) >= 0;
    }, self);
    
    self.bXinRutHoSo = ko.dependentObservable(function () {
        //return true;
        return [CHO_TIEP_NHAN, DA_TIEP_NHAN, YC_BOSUNG, DA_BOSUNG, DONGY_SUA_HOSO, TC_SUA_HOSO, TC_HUY_HOSO].indexOf(self.codeStatus()) >= 0;

    }, self);
    self.bXoaHoSo = ko.dependentObservable(function () {
        //return true;
        return [TAO_MOI].indexOf(self.codeStatus()) >= 0;
    }, self);
    self.bXemCongVan = ko.dependentObservable(function () {
        //return true;
        return [CONGVAN_KIEMDICH, TC_SUA_CONGVAN, DONGY_SUA_CONGVAN, CONGVAN_KIEMDICH_DA_SUADOI].indexOf(self.codeStatus()) >= 0;
    }, self);
    self.createDateText = ko.observable(item.createDate ? new Date(item.createDate).toDayFirstWithTime() : null);
//    self.fiNgaycapGpText = ko.observable(item.fiNgaycapGp ? new Date(item.fiNgaycapGp).toDayFirstWithTime() : null);
//    if ([CAP_GP, DA_SUA_GP].indexOf(self.codeStatus()) < 0) {
//        self.fiNgaycapGpText(null);
//    }

}
var MapBanKhai17 = function (d) {
    return ko.utils.arrayMap(d, function (item, index) {
        item.fiStt = index + 1;
        return new BanKhai17(item, index + 1);
    });
};

function BanKhai17(data, i) {
    var self = this;
    self.regisGood17Id = ko.observable(data ? data.regisGood17Id() : null);
    self.nswFilecode = ko.observable(data ? data.nswFilecode() : null);
    self.testMethod = ko.observable(data ? data.testMethod() : null);
    self.registrationId = ko.observable(data ? data.registrationId() : null);
    self.totalQuantity = ko.observable(data ? data.totalQuantity() : null);
    self.importGate = ko.observable(data ? data.importGate() : null);
    self.exportGate = ko.observable(data ? data.exportGate() : null);
    self.executionTime = ko.observable(data ? data.executionTime() : null);
    self.stayTime = ko.observable(data ? data.stayTime() : null);
    self.route = ko.observable(data ? data.route() : null);
    self.attachedDoc = ko.observable(data ? data.attachedDoc() : null);
//    self.ctyTu17 = ko.observable(new CtyTu17Form(options));
//    self.ctyDen17 = ko.observable(new CtyDen17Form(options));
//    self.lstHangHoa17 = ko.observableArray(MapHangHoa17(bankhai17 ? bankhai17.lstHangHoa17() : null));
    self.ctyTu17 = ko.observable(data ? data.CtyTu17 : []);
    self.ctyDen17 = ko.observable(data ? data.CtyDen17 : []);
    self.lstHangHoa17 = ko.observableArray(data ? data.lstHangHoa17 : []);




}



var MapBanKhai18 = function (dataFromServer, d) {
    return ko.utils.arrayMap(dataFromServer, function (item, index) {
        return new BanKhai18(item, index + 1 + d);
    });
}

function BanKhai18(data, i) {
    var self = this;
    self.fiStt = ko.observable(i);

}

var mapTbdLichsu02 = function (dataFromServer, p) {
    return ko.utils.arrayMap(dataFromServer, function (item, index) {
        return new TbdLichsu02(index + 1 + p, item);
    });
};
var TbdLichsu02 = function (STT, item) {
    console.log(item);
    debugger;
    var self = this;
    this.STT = ko.observable(STT);
    if (item != null) {
        ko.mapping.fromJS(item, {}, self);
    }

    self.fiNgaytao = ko.observable(item.fiNgaytao ? new Date(item.fiNgaytao).toDayFirstWithTime() : null);
};

var MapHangHoa17 = function (d) {
    return ko.utils.arrayMap(d, function (item, index) {
        item.fiStt = index + 1;
        return new hanghoa17(item, index + 1);
    });
};
function hanghoa17(data, i) {
    var self = this;
    // self.fiStt = ko.observable(data ? data.fiStt : i);
    self.goodId = ko.observable(data ? data.goodId : null);
    self.goodSort = ko.observable(data ? data.goodSort : i);
    self.goodName = ko.observable(data ? data.goodName : null);
    self.quantily = ko.observable(data ? data.quantily : null);
    self.quantityUnitCode = ko.observable(data ? data.quantityUnitCode : null);
    self.quantityUnitName = ko.observable(data ? data.quantityUnitName : null);
    self.exporterState = ko.observable(data ? data.exporterState : null);
    self.regisGood17Id = ko.observable(data ? data.regisGood17Id : null);
    self.regisGood18Id = ko.observable(data ? data.regisGood18Id : null);
}
var MapCtyDen17 = function (d) {
    return ko.utils.arrayMap(d, function (item, index) {
        item.fiStt = index + 1;
        return new ctyDen17(item, index + 1);
    });
};
function ctyDen17(data, i) {
    var self = this;
    self.fiStt = ko.observable(data ? data.fiStt : i);
    self.toCompanyId = ko.observable(data ? data.toCompanyId : null);
    self.toCompanyName = ko.observable(data ? data.toCompanyName : null);
    self.toCompanyAddress = ko.observable(data ? data.toCompanyAddress : null);
    self.regisGood17Id = ko.observable(data ? data.regisGood17Id : null);
    self.regisGood18Id = ko.observable(data ? data.regisGood18Id : null);

}
var MapCtyTu17 = function (d) {
    return ko.utils.arrayMap(d, function (item, index) {
        item.fiStt = index + 1;
        return new ctyTu17(item, index + 1);
    });
};
function ctyTu17(data, i) {
    var self = this;
    self.fiStt = ko.observable(data ? data.fiStt : i);
    self.fromCompanyId = ko.observable(data ? data.fromCompanyId : null);
    self.fromCompanyName = ko.observable(data ? data.fromCompanyName : null);
    self.fromCompanyAddress = ko.observable(data ? data.fromCompanyAddress : null);
    self.regisGood17Id = ko.observable(data ? data.regisGood17Id : null);
    self.regisGood18Id = ko.observable(data ? data.regisGood18Id : null);

}

//==================18=======================
var MapCtyDen18 = function (d) {
    return ko.utils.arrayMap(d, function (item, index) {
        item.fiStt = index + 1;
        return new ctyDen18(item, index + 1);
    });
};
function ctyDen18(data, i) {
    debugger;
    var self = this;
    self.fiStt = ko.observable(data ? data.fiStt : i);
    self.toCompanyId = ko.observable(data ? data.toCompanyId : null);
    self.toCompanyName = ko.observable(data ? data.toCompanyName : null);
    self.toCompanyAddress = ko.observable(data ? data.toCompanyAddress : null);
    self.regisGood17Id = ko.observable(data ? data.regisGood17Id : null);
    self.regisGood18Id = ko.observable(data ? data.regisGood18Id : null);

}
var MapCtyTu18 = function (d) {
    return ko.utils.arrayMap(d, function (item, index) {
        item.fiStt = index + 1;
        return new ctyTu18(item, index + 1);
    });
};
function ctyTu18(data, i) {
    debugger;
    var self = this;
    self.fiStt = ko.observable(data ? data.fiStt : i);
    self.fromCompanyId = ko.observable(data ? data.fromCompanyId : null);
    self.fromCompanyName = ko.observable(data ? data.fromCompanyName : null);
    self.fromCompanyAddress = ko.observable(data ? data.fromCompanyAddress : null);
    self.regisGood17Id = ko.observable(data ? data.regisGood17Id : null);
    self.regisGood18Id = ko.observable(data ? data.regisGood18Id : null);

}

var MapHangHoa18 = function (d) {
    return ko.utils.arrayMap(d, function (item, index) {
        item.fiStt = index + 1;
        return new hanghoa18(item, index + 1);
    });
};
function hanghoa18(data, i) {
    var self = this;
    self.fiStt = ko.observable(data ? data.fiStt : i);
    self.goodId = ko.observable(data ? data.goodId : null);
    self.goodSort = ko.observable(data ? data.goodSort : null);
    self.goodName = ko.observable(data ? data.goodName : null);
    self.quantily = ko.observable(data ? data.quantily : null);
    self.quantityUnitCode = ko.observable(data ? data.quantityUnitCode : null);
    self.quantityUnitName = ko.observable(data ? data.quantityUnitName : null);
    self.exporterState = ko.observable(data ? data.exporterState : null);
    self.regisGood17Id = ko.observable(data ? data.regisGood17Id : null);
    self.regisGood18Id = ko.observable(data ? data.regisGood18Id : null);

}
;
var MapKhoNgoai18 = function (d) {
    return ko.utils.arrayMap(d, function (item, index) {
        item.fiStt = index + 1;
        return new khoNgoai18(item, index + 1);
    });
};
function khoNgoai18(data, i) {
    var self = this;
    self.fiStt = ko.observable(data ? data.fiStt : i);
    self.bondedListId = ko.observable(data ? data.bondedListId : null);
    self.bondedName = ko.observable(data ? data.bondedName : null);
    self.certificateNo = ko.observable(data ? data.certificateNo : null);
    self.certificateDate = ko.observable(data ? new Date(data.certificateDate) : null);
    self.certificateDateValid = ko.observable(data ? new Date(data.certificateDateValid) : null);
    self.contractNo = ko.observable(data ? data.contractNo : null);
    self.contractDate = ko.observable(data ? new Date(data.contractDate) : null);
    self.contractDateValid = ko.observable(data ? new Date(data.contractDateValid) : null);
    self.regisGood18Id = ko.observable(data ? data.regisGood18Id : null);

};