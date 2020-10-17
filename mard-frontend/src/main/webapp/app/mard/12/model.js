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

var mapTbdhoso12 = function (d, p) {
    return ko.utils.arrayMap(d, function (item, index) {
        return new Tbdhoso12((index + p) + 1, item);
    });
};
function Tbdhoso12(STT, item) {
    var self = this;

    if (item) {
        ko.mapping.fromJS(item, {}, self);
    }
    self.fiTenTt = ko.computed(function () {
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
    
    self.fiNgaycapCvText = ko.observable(null);
    if ([DUOC_CAP_GIAYPHEP].indexOf(self.fiTrangthai()) < 0) {
        self.fiNgaycapCv(null);
    } else {
        
        self.fiNgaycapCvText(item.fiNgaycapCv ? new Date(item.fiNgaycapCv).toDayFirstWithTime() : null);
        //console.log(self.fiNgaycapCvText());
    }

    self.STT = ko.observable(STT);
    self.bXemLichSu = ko.dependentObservable(function () {
        return true;
    }, self);
    self.bSuaHoSo = ko.dependentObservable(function () {
        //return true;
        return [TAO_MOI].indexOf(self.fiTrangthai()) >= 0;
    }, self);
    self.bXoaHoSo = ko.dependentObservable(function () {
        //return true;
        return [TAO_MOI].indexOf(self.fiTrangthai()) >= 0;
    }, self);
    self.bXemThongBao = ko.dependentObservable(function () {
        //return true;
        return [DUOC_CAP_GIAYPHEP].indexOf(self.fiTrangthai()) >= 0;
    }, self);

    self.fiNgayguiText = ko.observable(item.fiNgaygui ? new Date(item.fiNgaygui).toDayFirstWithTime() : null);
}

function TbdhsHanghoa12(data) {
    var self = this;
    self.fiIdHh = ko.observable(data ? data.fiIdHh : null);
    self.fiStt = ko.observable(data ? data.fiStt : null);
    self.fiIdHoso = ko.observable(data ? data.fiIdHoso : null);
    self.fiMaHoso = ko.observable(data ? data.fiMaHoso : null);
    self.fiMahosoXncl = ko.observable(data ? data.fiMahosoXncl : null);
    self.fiTenHh = ko.observable(data ? data.fiTenHh : null);
    self.fiMsChungnhan = ko.observable(data ? data.fiMsChungnhan : null);
    self.fiMucChatluong = ko.observable(data ? data.fiMucChatluong : null);
    self.fiHangSx = ko.observable(data ? data.fiHangSx : null);
    self.fiNuocSx = ko.observable(data ? data.fiNuocSx : null);
    self.fiSodkXncl = ko.observable(data ? data.fiSodkXncl : null);
    self.fiSogiayXncl = ko.observable(data ? data.fiSogiayXncl : null);
    self.fiNgaycapXncl = ko.observable(data ? data.fiNgaycapXncl : null).extend({ vnDate: true });
    self.fiHoatdong = ko.observable(data ? data.fiHoatdong : null);
    self.fiNguoitao = ko.observable(data ? data.fiNguoitao : null);
    self.fiNgaytao = ko.observable(data ? data.fiNgaytao : null);
    self.fiNgCapnhat = ko.observable(data ? data.fiNgCapnhat : null);
    self.rowSpan = ko.observable(data ? data.rowSpan : null);
    self.group = ko.observable(data ? data.group : null);
    self.fiNgaycapXnclText = ko.observable(data.fiNgaycapXncl ? new Date(data.fiNgaycapXncl).toDayFirstWithTime() : null);
}
var mapTbdhsHanghoa12 = function (d) {
    d = calcRowSpanByGroup(setGroup(d));
    return ko.utils.arrayMap(d, function (item, index) {
        item.fiStt = index + 1;
        return new TbdhsHanghoa12(item);
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