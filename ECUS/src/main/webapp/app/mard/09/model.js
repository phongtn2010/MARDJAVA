/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* global app, RAW_HS_STATUS */

var TAO_MOI = 0;
var CHO_TIEP_NHAN = 1;
var DA_TIEP_NHAN = 2;
var DUOC_CAP_GIAYPHEP = 3;
var DA_THU_HOI = 4;

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


var Exporter20 = function (index, item) {
    var self = this;
    self.STT = ko.observable(index);

    if (item.fiSellerAddress) item.fiExporterAddress = item.fiSellerAddress;
    if (item.fiSellerName) item.fiExporterName = item.fiSellerName;

    self.fiExporterCountry = ko.observable(item ? mapQuocgia[item.fiSellerStateCode] : null);
    self.fiSellerStateCode = ko.observable(item ? item.fiSellerStateCode : null);
    self.fiExporterName = ko.observable(item ? item.fiExporterName : null);
    self.fiExporterPhone = ko.observable(item ? item.fiSellerPhone : null);
    self.fiExporterFax = ko.observable(item ? item.fiSellerFax : null);
    self.fiExporterAddress = ko.observable(item ? item.fiExporterAddress : null);
    self.fiPortOfDepartureName = ko.observable(item ? item.fiPortOfDepartureName : null);
};

var Goods03 = function (index, item) {
    var self = this;

    self.STT = ko.observable(index);

    self.fiProductCode = ko.observable(item ? item.fiProductCode : null);
    self.fiProductName = ko.observable(item ? item.fiProductName : null);
    self.fiProductScienceName = ko.observable(item ? item.fiProductScienceName : null);
    self.fiQtyFemale = ko.observable(item ? item.fiQuantityFemale ? item.fiQuantityFemale : item.fiQtyFemale : 0);
    self.fiQtyMale = ko.observable(item ? item.fiQuantityMale ? item.fiQuantityMale : item.fiQtyMale : null);
    self.fiAge = ko.observable(item ? item.fiAge : null);
    self.fiPackingType = ko.observable(item ? item.fiPackingType ? item.fiPackingType : item.fiPackingWay : null);
    self.fiNumber = ko.observable(item ? item.fiNumber : null);
    self.fiUnitCode = ko.observable(item ? item.fiUnitCode : null);
    self.fiUnitName = ko.observable(item ? item.fiUnitName : null);
    self.fiNetWeight = ko.observable(item ? item.fiNetWeight : null);
    self.fiNWUnitCode = ko.observable(item ? item.fiNWUnitCode : null);
    self.fiNWUnitName = ko.observable(item ? item.fiNWUnitName : null);
    self.fiGrossWeight = ko.observable(item ? item.fiGrossWeight : null);
    self.fiGWUnitName = ko.observable(item ? item.fiNWUnitName : null);
    self.fiGWUnitCode = ko.observable(item ? item.fiNWUnitCode : null);
    self.fiPurpose = ko.observable(item ? item.fiPurpose : null);
    self.fiCountryOrigin = ko.observable(item ? item.fiCountryOrigin : null);
    self.fiPortCode = ko.observable(item ? item.fiPortCode : null);
    self.fiCountryOriginName = ko.observable(item ? item.fiCountryOriginName : null);
    self.fiPortName = ko.observable(item && item.fiPortName ? item.fiPortName : item && item.fiImportPortOfDestName ? item.fiImportPortOfDestName : null);
    self.fiCirculateNo = ko.observable(item ? item.fiCirculateNo : null);
};

var mapTbdGoods03 = function (data) {
    return ko.utils.arrayMap(data, function (item, index) {
        return new Goods03(index + 1, item);
    });
};

var Company03 = function (index, item) {
    var self = this;
    self.STT = ko.observable(index);
    self.fiIdExporter = ko.observable(item ? item.fiIdExporter : null);
    self.fiCompanyName = ko.observable(item ? item.fiExporterName : null);
    self.fiCompanyAddress = ko.observable(item ? item.fiExporterAddress : null);
};

var mapTdbCompany03 = function (data) {
    return ko.utils.arrayMap(data, function (item, index) {
        return new Company03(index + 1, item);
    });
};

var Mfs03 = function (index, item) {
    var self = this;
    self.STT = ko.observable(index);

    if (item.fiCompanyName) item.fiFactoryName = item.fiCompanyName;
    if (item.fiCompanyAddress) item.fiFactoryAddress = item.fiCompanyAddress;
    self.fiManufactureName = ko.observable(item ? item.fiFactoryName : null);
    self.fiIdFactory = ko.observable(item ? item.fiIdFactory : null);
    self.fiManufactureAddress = ko.observable(item ? item.fiFactoryAddress : null);
};

var mapTdbMfs03 = function (data) {
    return ko.utils.arrayMap(data, function (item, index) {
        return new Mfs03(index + 1, item);
    });
};

var IsoLoc03 = function (index, item) {
    var self = this;
    self.STT = ko.observable(index);
    self.fiQuarantineName = ko.observable(item ? item.fiIsoLocName : null);
    self.fiIdQuarLoc = ko.observable(item ? item.fiIdQuarLoc : null);
    self.fiQuarantineAddress = ko.observable(item ? item.fiIsoLocAddress : null);
};

var mapTdbIsoLoc03 = function (data) {
    return ko.utils.arrayMap(data, function (item, index) {
        return new IsoLoc03(index + 1, item);
    });
};

var mapTbdlichsu12 = function (dataFromServer) {
    return ko.utils.arrayMap(dataFromServer, function (item, index) {
        return new Tbdlichsu12(index + 1, item);
    });
};
var Tbdlichsu12 = function (STT, item) {
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

var RegistrationConfirm = function (data, hoso) {

    var checkType = {
        "1": "Miễn kiểm tra chất lượng thức ăn chăn nuôi, thủy sản nhập khẩu",
        "2": "Miễn kiểm tra chất lượng có thời hạn",
        "3": "Kiểm tra giảm có thời hạn",
        "4": "Kiểm tra thông thường",
        "5": "Kiểm tra chặt"
    };

    var self = this;

    var fiInspectionTypeStr = checkType[data ? data.fiInspectionType.toString() : null];

    if (hoso != null && hoso.fiProductType() > 3) {
        self.type = ko.observable("20a");
    } else {
        self.type = ko.observable("03");
    }

    self.fiLinkFile = ko.observable(hoso ? hoso.fiLinkFile(): null);
    self.fiNSWFileCode = ko.observable(data ? data.fiNSWFileCode: null);
    self.fiRegistrationComfirmNo = ko.observable(data ? data.fiRegistrationComfirmNo : null);
    self.fiAnanyticalRequiredList = ko.observableArray(data ? data.fiAnanyticalRequiredList : []);
    self.fiInspectionTypeStr = ko.observable(fiInspectionTypeStr);
    self.fiNoticeOfExemptionFromInspectionNo = ko.observable(data ? data.fiNoticeOfExemptionFromInspectionNo : null);
    self.fiDateOfTestingFrom = ko.observable(data ? new Date(data.fiDateOfTestingFrom) : null);
    self.fiDateOfTestingTo = ko.observable(data ? new Date(data.fiDateOfTestingTo) : null);
    self.fiUnitOfTesting = ko.observable(data ? data.fiUnitOfTesting : null);
    self.fiAssignCode = ko.observable(data ? data.fiAssignCode : null);
    self.fiAssignName = ko.observable(data ? data.fiAssignName : null);
    self.fiLocationOfSamplingConfirm = ko.observable(data ? data.fiLocationOfSamplingConfirm : null);
    self.fiTimeOfSamplingConfirm = ko.observable(data ? data.fiTimeOfSamplingConfirm: null);
    self.fiDateOfSamplingConfirm = ko.observable(data ? data.fiDateOfSamplingConfirm : null);
    self.fiSignConfirmDate = ko.observable(data ? new Date(data.fiSignConfirmDate) : null);
    self.fiSignConfirmName = ko.observable(data ? data.fiSignConfirmName : null);
    self.fiSignConfirmAddress = ko.observable(data ? data.fiSignConfirmAddress : null);
    self.fiRejectionReason = ko.observable(data ? data.fiRejectionReason : null);
    self.fiSignConfirmDateOfCustoms = ko.observable(data ? new Date(data.fiSignConfirmDateOfCustoms) : null);
    self.fiSignConfirmNameOfCustoms = ko.observable(data ? data.fiSignConfirmNameOfCustoms : null);
    self.fiSignConfirmAddressOfCustoms = ko.observable(data ? data.fiSignConfirmAddressOfCustoms : null);

    self.isCTYAccept = ko.observable(data ? !isTextEmpty(data.fiLocationOfSamplingConfirm) : false);
    self.isHQAccept = ko.observable(data ? !isTextEmpty(data.fiRejectionReason) : false);

    self.fiQuarantineLocationName = ko.observable(data ? data.fiQuarantineLocationName : null);
    self.fiMonitoringLocationTimeFrom = ko.observable(data ? new Date(data.fiMonitoringLocationTimeFrom) : null);
    self.fiMonitoringLocationTimeTo = ko.observable(data ? new Date(data.fiMonitoringLocationTimeTo) : null);

};

function isTextEmpty(str) {
    return (!str || 0  === str.length);
}

var mapTbdhoso09 = function (d, p) {
    return ko.utils.arrayMap(d, function (item, index) {
        return new Tbdhoso09((index + p) + 1, item);
    });
};
function Tbdhoso09(STT, item) {
    var self = this;


    if (item) {
        ko.mapping.fromJS(item, {}, self);
    }

    self.STT = ko.observable(STT);

    // self.fiTenTt = ko.computed(function () {
    //     if (!RAW_HS_STATUS || RAW_HS_STATUS.length <= 0) {
    //         return self.fiTrangthai();
    //     } else {
    //         for (var i = 0; i < RAW_HS_STATUS.length; i++) {
    //             if (RAW_HS_STATUS[i]["id"] == self.fiTrangthai()) {
    //                 return RAW_HS_STATUS[i]["name"] ? RAW_HS_STATUS[i]["name"] : self.fiTrangthai();
    //             }
    //         }
    //     }
    // }, self);
    
    // self.fiNgaycapCvText = ko.observable(null);
    // if ([DUOC_CAP_GIAYPHEP].indexOf(self.fiTrangthai()) < 0) {
    //     self.fiNgaycapCv(null);
    // } else {
    //
    //     self.fiNgaycapCvText(item.fiNgaycapCv ? new Date(item.fiNgaycapCv).toDayFirstWithTime() : null);
    //     //console.log(self.fiNgaycapCvText());
    // }
    //
    // self.bXemLichSu = ko.dependentObservable(function () {
    //     return true;
    // }, self);
    // self.bSuaHoSo = ko.dependentObservable(function () {
    //     //return true;
    //     return [TAO_MOI].indexOf(self.fiTrangthai()) >= 0;
    // }, self);
    // self.bXoaHoSo = ko.dependentObservable(function () {
    //     //return true;
    //     return [TAO_MOI].indexOf(self.fiTrangthai()) >= 0;
    // }, self);
    // self.bXemThongBao = ko.dependentObservable(function () {
    //     //return true;
    //     return [DUOC_CAP_GIAYPHEP].indexOf(self.fiTrangthai()) >= 0;
    // }, self);

    // self.fiNgayguiText = ko.observable(item.fiNgaygui ? new Date(item.fiNgaygui).toDayFirstWithTime() : null);
}

function TbdhsHanghoa09(data) {
    var self = this;
    self.fiStt = ko.observable(data ? data.fiStt : null);
    self.fiMaHanghoa = ko.observable(data ? data.fiIdProduct : null);
    self.fiTenHh = ko.observable(data ? data.fiProductName : null);
    self.fiTenKhoahoc = ko.observable(null);
    self.fiSoluongKhoiluong = ko.observable(data ? data.fiNumber : null);
    self.fiMaLoaiBaobi = ko.observable(null);
    self.fiTenLoaiBaobi = ko.observable(null);
    self.fiTrongluongTinh = ko.observable(null);
    self.fiTrongluongCabi = ko.observable(null);
}
var mapTbdhsHanghoa09 = function (d) {
    d = calcRowSpanByGroup(setGroup(d));
    return ko.utils.arrayMap(d, function (item, index) {
        item.fiStt = index + 1;
        return new TbdhsHanghoa09(item);
    });
};

function TbdhsHanghoa12Ext(data) {
    var self = this;
    self.fiIdHh = ko.observable(data.fiIdHh ? data.fiIdHh : null);
    self.fiStt = ko.observable(data.fiStt ? data.fiStt : null);
    self.fiIdHoso = ko.observable(data.fiIdHoso ? data.fiIdHoso : null);
    self.fiMaHoso = ko.observable(data.fiMaHoso ? data.fiMaHoso : null);
    self.fiMahosoXncl = ko.observable(data.fiMahosoXncl ? data.fiMahosoXncl : null);
    self.fiTenHh = ko.observable(data.fiTenHh ? data.fiTenHh : null);
    self.fiMsChungnhan = ko.observable(data.fiMsChungnhan ? data.fiMsChungnhan : null);
    self.fiMucChatluong = ko.observable(data.fiMucChatluong ? data.fiMucChatluong : null);
    self.fiHangSx = ko.observable(data.fiHangSx ? data.fiHangSx : null);
    self.fiNuocSx = ko.observable(data.fiNuocSx ? data.fiNuocSx : null);
    self.fiSodkXncl = ko.observable(data.fiSodkXncl ? data.fiSodkXncl : null);
    self.fiSogiayXncl = ko.observable(data.fiSogiayXncl ? data.fiSogiayXncl : null);
    self.fiNgaycapXncl = ko.observable(data.fiNgaycapXncl ? data.fiNgaycapXncl : null);
    self.fiHoatdong = ko.observable(data.fiHoatdong ? data.fiHoatdong : null);
    self.fiNguoitao = ko.observable(data.fiNguoitao ? data.fiNguoitao : null);
    self.fiNgaytao = ko.observable(data.fiNgaytao ? data.fiNgaytao : null);
    self.isSelected = ko.observable(false);
    self.lable = ko.observable('Chọn');
    self.rowSpan = ko.observable(data.rowSpan ? data.rowSpan : null);
    self.group = ko.observable(data.group ? data.group : null);
    self.fiNgaycapXnclText = ko.observable(data.fiNgaycapXncl ? new Date(data.fiNgaycapXncl).toDayFirstWithTime() : null);
}

var mapTbdhsHanghoa12Ext = function (d) {
    d = calcRowSpanByGroup(d);
    return ko.utils.arrayMap(d, function (item, index) {
        item.fiStt = index + 1;
        return new TbdhsHanghoa12Ext(item);
    });
};

var calcRowSpanByGroup = function(d){

    if(!d){
        return;
    }
    
    var group = null;
    var rowSpan = 0;
    var first = null;
    for(var i = 0; i < d.length; i++){
        if(!group){
            group = d[i].group;
            rowSpan = 1;
            first = d[i];
        }
        else{
            if(group  !== d[i].group  || i === d.length - 1){
                first.rowSpan = rowSpan;
                group = d[i].group;
                rowSpan = 1;
                first = d[i];
            }
            else{
                d[i].rowSpan = 0;
                rowSpan ++;
            }
        }
    }
    return d;
};

var setGroup = function(d){

    if(!d){
        return;
    }
    var arr = [d[0].fiTenHh, d[0].fiMsChungnhan, d[0].fiMucChatluong , d[0].fiHangSx , d[0].fiNuocSx];
    var group = arr.join(";");
    for(var i = 0; i < d.length; i++){
        if([d[i].fiTenHh, d[i].fiMsChungnhan, d[i].fiMucChatluong , d[i].fiHangSx , d[i].fiNuocSx].join(";") != group ){
            group = [d[i].fiTenHh, d[i].fiMsChungnhan, d[i].fiMucChatluong , d[i].fiHangSx , d[i].fiNuocSx].join(";");
        }
        d[i].group = group;
    }
    
    return d;
};

// Lọc các hàng hóa trùng nhau
var uniqueTbdhsHanghoa12 = function(d){
    var result = [];
    var groups = [];
    for(var i = 0; i < d.length; i++){
        var group = [d[i].fiTenHh, d[i].fiMsChungnhan, d[i].fiMucChatluong , d[i].fiHangSx , d[i].fiNuocSx].join(";");
        // nếu chưa có trong danh sách thì thêm vào
        if(groups.indexOf(group) < 0){
            groups.push(group);
            result.push(d[i]);
        }
    }
    return result;
};

function replaceNull(someObj, replaceValue) {
    var replacer = function(key, value) {
        String(value) === "null" || String(value) === "undefined" ? replaceValue : value;
    };

    return JSON.parse( JSON.stringify(someObj, replacer));
}