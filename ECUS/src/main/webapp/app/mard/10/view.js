/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* global app, CSRF_TOKEN_NAME, CSRF_TOKEN_VALUE, RAW_HS_STATUS, History */

var triggerTab = function (tab) {
    var $tab = $('#' + tab);
    if ($tab) {// ?
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
    self.lstDinhkem10 = ko.observableArray([]);
    if (options.hoso.lstDinhkem10 && options.hoso.lstDinhkem10.length > 0) {
        self.lstDinhkem10(mapTbddinhkem10(options.hoso.lstDinhkem10));
    }
}
;

function Mau14aVM(options) {
    var self = this;
    if (options && options.hoso.tbdmau14a) {
        ko.mapping.fromJS(options.hoso.tbdmau14a, {}, self);
        if (options.tab == "mau") {
            triggerTab('a-tab_mard10_3');
        }
    }
}
;

function Mau14bVM(options) {
    var self = this;
    if (options && options.hoso.tbdmau14b) {
        ko.mapping.fromJS(options.hoso.tbdmau14b, {}, self);
        if (options.tab == "mau") {
            triggerTab('a-tab_mard10_4');
        }
    }
}
;

function Mau15aVM(options) {
    var self = this;
    if (options && options.hoso.tbdmau15a) {
        ko.mapping.fromJS(options.hoso.tbdmau15a, {}, self);

        if (options.tab == "mau") {
            triggerTab('a-tab_mard10_5');
        }
    }
}
;

function Mau15bVM(options) {
    var self = this;
    if (options && options.hoso.tbdmau15b) {
        ko.mapping.fromJS(options.hoso.tbdmau15b, {}, self);
        if (options.tab == "mau") {
            triggerTab('a-tab_mard10_6');
        }
    }
}
;

function Mau15cVM(options) {
    var self = this;
    if (options && options.hoso.tbdmau15c) {
        ko.mapping.fromJS(options.hoso.tbdmau15c, {}, self);
        if (options.tab == "mau") {
            triggerTab('a-tab_mard10_7');
        }
    }
}
;

function Mau9aVM(options) {
    var self = this;
    if (options && options.hoso.tbdmau9a) {
        ko.mapping.fromJS(options.hoso.tbdmau9a, {}, self);
        if (options.tab == "mau") {
            triggerTab('a-tab_mard10_8');
        }
    }
}
;

function Lichsu02VM(options) {
    var self = this;
    if (options && options.hoso.lstLichsu10) {
        self.lstLichsu10 = ko.observableArray(mapTbdLichsu10(options.hoso.lstLichsu10));
    } else {
        self.lstLichsu10 = ko.observableArray([]);
    }
    self.updateData = function (data) {
        if (data && data.hoso.lstLichsu10) {
            self.lstLichsu10(mapTbdLichsu10(data.hoso.lstLichsu10));
        }
    };
}
;

function Mau15bv2VM(options) {
    var self = this;
    if (options && options.hoso.tbdmau15b) {
        ko.mapping.fromJS(options.hoso.tbdmau15b, {}, self);
        if (options.tab == "mau") {
            triggerTab('a-tab_mard10_15bv2');
        }
    }
}
;


function Mard10ViewVM(options, checkDate) {
    var self = this;
    self.btnTroLaiClick = function () {
        History.go(-1);
    };

    self.exportHref = ko.observable(app.appContext + "/mard/10/hoso/bieumau/" + options.fiIdHoso);

    self.mau14aVM = ko.observable(options.hoso.tbdmau14a ? new Mau14aVM(options) : null);
    self.mau14bVM = ko.observable(options.hoso.tbdmau14b ? new Mau14bVM(options) : null);
    self.mau15aVM = ko.observable(options.hoso.tbdmau15a ? new Mau15aVM(options) : null);

    //Neu qua ngay 10/02/2019 thi bieu mau 2019
    self.mau15bv2VM =ko.observable(null);
    self.mau15bVM =ko.observable(null);
    if (checkDate === 1) {
        self.mau15bv2VM = ko.observable(options.hoso.tbdmau15b ? new Mau15bv2VM(options) : null);
    } else {
        self.mau15bVM = ko.observable(options.hoso.tbdmau15b ? new Mau15bVM(options) : null);
    }
    self.mau15cVM = ko.observable(options.hoso.tbdmau15c ? new Mau15cVM(options) : null);
    self.mau9aVM = ko.observable(options.hoso.tbdmau9a ? new Mau9aVM(options) : null);
    self.lichsu02VM = ko.observable(new Lichsu02VM(options));
    self.hosoVM = ko.observable(new HosoVM(options));
    self.fileVM = ko.observable(new FileVM(options));
}
;

$(document).ready(function () {
    var mard10ViewVM;
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
            url: app.appContext + '/mard/10/hoso/t/' + options.fiIdHoso,
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            beforeSend: function (xhr) {
                xhr.setRequestHeader(CSRF_TOKEN_NAME, CSRF_TOKEN_VALUE);
                $('#loading10').show();
            },
            success: function (res) {
                if (res.success) {
                    options.hoso = res.data;
                    //Kiem tra xem neu sau ngay 10/02/2019 thi la bieu mau khac
                    var mocCu = new Date(2019,1,10).getTime();
                    var tbdmau15b = res.data["tbdmau15b"];
                    var ngayCapMillis;
                    if(tbdmau15b!=null){
                        ngayCapMillis=tbdmau15b["fiNgaytao"];
                    }
                    var checkDate;
                    if (ngayCapMillis > mocCu) {
                        checkDate = 1;
                    }else{
                        checkDate=0;
                    }
                    
                    
                    mard10ViewVM = new Mard10ViewVM(options, checkDate);
                    ko.applyBindings(mard10ViewVM, document.getElementById('mard10View'));
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


