/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* global app, CSRF_TOKEN_NAME, CSRF_TOKEN_VALUE, RAW_HS_STATUS, History */

var triggerTab = function (tab) {
    var $tab = $('#' + tab);
    if ($tab.length > 0) {// ?
        $tab.trigger('click');
    }
};
function HosoVM(options) {
    var self = this;
    ko.mapping.fromJS(options.hoso, {}, self);
    self.fiTrangthaiText = ko.dependentObservable(function () {
        if (RAW_HS_STATUS) {
            for (var i = 0; i < RAW_HS_STATUS.length; i++) {
                if (RAW_HS_STATUS[i].id == self.fiTrangthai()) {
                    return RAW_HS_STATUS[i].name;
                }
            }
            return "Tạo mới";
        }
    }, self);
}
;

function FileVM(options) {
    var self = this;
    self.lstDinhkem11 = ko.observableArray([]);
    if (options.hoso.lstDinhkem11 && options.hoso.lstDinhkem11.length > 0) {
        self.lstDinhkem11(mapTbddinhkem11(options.hoso.lstDinhkem11));
    }
}
;

function Lichsu11VM(options) {
    var self = this;
    if (options && options.hoso.lstLichsu11) {
        self.lstLichsu11 = ko.observableArray(mapTbdLichsu11(options.hoso.lstLichsu11));
    } else {
        self.lstLichsu11 = ko.observableArray([]);
    }
    self.updateData = function (data) {
        if (data && data.hoso.lstLichsu11) {
            self.lstLichsu11(mapTbdLichsu11(data.hoso.lstLichsu11));
        }
    };
}
;

function Gcn(options) {
    var self = this;    
    var gcn11 = options.hoso.gcn11;
    gcn11.fiBangoc = gcn11. fiBangoc == 1 ? "X" : "";
    gcn11.fiBansao = gcn11. fiBansao == 1 ? "X" : "";
    gcn11.fiDadonggoi = gcn11. fiDadonggoi == 1 ? "X" : "";
    gcn11.fiDagoilai = gcn11. fiDagoilai == 1 ? "X" : "";
    gcn11.fiGiunguyengoc = gcn11. fiGiunguyengoc == 1 ? "X" : "";
    gcn11.fiBaobimoi = gcn11. fiBaobimoi == 1 ? "X" : "";
    gcn11.fiTrencsGoc = gcn11. fiTrencsGoc == 1 ? "X" : "";
    gcn11.fiKtBosung = gcn11. fiKtBosung == 1 ? "X" : "";
    gcn11.hh = [];
    gcn11.tkh = "";
    if(gcn11.tbdhhgcn11 && gcn11.tbdhhgcn11.length > 0){
        var t = gcn11.tbdhhgcn11.length > 3 ? 3 : gcn11.tbdhhgcn11.length;
        for(i = 0; i < t; i++){
            gcn11.tkh += (gcn11.tbdhhgcn11[i]["fiTenKh"] || "" + "; ");
            gcn11.hh.push(gcn11.tbdhhgcn11[i]);
        }
    }
    ko.mapping.fromJS(gcn11, {}, self);
    if(gcn11 && gcn11.tbdhhgcn11){
        // Mac dinh bo 3 phan thu dau di
        gcn11.tbdhhgcn11.shift();
        gcn11.tbdhhgcn11.shift();
        gcn11.tbdhhgcn11.shift();
    }
    self.tbdhhgcn11 = ko.observableArray(gcn11 && gcn11.tbdhhgcn11 ? mapTbdhhgcn11(gcn11.tbdhhgcn11) : null);
    self.hh = ko.observableArray(mapTbdhhgcn11(gcn11.hh));
    if (options.tab == "mau") {
        triggerTab('a-tab_mard11_3');
    }
}

function Mard11ViewVM(options) {
    var self = this;
    self.btnTroLaiClick = function () {
        History.go(-1);
    };

    self.exportHref = ko.observable(app.appContext + "/mard/11/hoso/bieumau/" + options.fiIdHoso);
    self.exportMauHref = ko.observable(app.appContext + "/mard/11/hoso/mau-gcn/" + options.fiIdHoso);
    self.exportMauVisible = ko.observable(options.hoso.gcn11 && options.hoso.gcn11.fiIdGcn > 0);
    self.lichsu11VM = ko.observable(new Lichsu11VM(options));
    self.hosoVM = ko.observable(new HosoVM(options));
    self.fileVM = ko.observable(new FileVM(options));
    self.gcn = ko.observable(options.hoso.gcn11 && options.hoso.gcn11.fiIdGcn ? new Gcn(options) : null);
};

$(document).ready(function () {
    var mard11ViewVM;
    if (!RAW_HS_STATUS || RAW_HS_STATUS.length <= 0) {
        getCategory("HS_STATUS", null, function (res) {
            if (res.success) {
                RAW_HS_STATUS = res.data;
            }
            init();
        });
    } else {
        init();
    }
    var init = function () {
        var options = app.parseQuerystring();
        $.ajax({
            async: true,
            type: 'POST',
            cache: false,
            crossDomain: true,
            url: app.appContext + '/mard/11/hoso/t/' + options.fiIdHoso,
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            beforeSend: function (xhr) {
                xhr.setRequestHeader(CSRF_TOKEN_NAME, CSRF_TOKEN_VALUE);
                $('#loading10').show();
            },
            success: function (res) {
                if (res.success) {
                    options.hoso = res.data;
                    mard11ViewVM = new Mard11ViewVM(options);
                    ko.applyBindings(mard11ViewVM, document.getElementById('mard11View'));
                }
            },
            error: function (x, t, m) {
                alert('Lỗi khi thực hiện yêu cầu');
            },
            complete: function (jqXHR, textStatus) {
                $('#loading10').hide();
            }
        });
    };
});


