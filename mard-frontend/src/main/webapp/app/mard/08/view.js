function Mard08ViewVM () {
    var viewVMSelf = this;
    viewVMSelf.kdnkVM = ko.observable(null);
    viewVMSelf.ktclVM = ko.observable(null);
    viewVMSelf.errorMsg = ko.observable('');
    viewVMSelf.fiHSType = ko.observable(null);
    viewVMSelf.isEditable = ko.observable(false);

    viewVMSelf.clearForm = function() {
        viewVMSelf.errorMsg('');
    };

    viewVMSelf.applyState = function (options) {
        viewVMSelf.fiHSType(options.fiHSType);
        if (options.fiHSType < 4) {
            viewVMSelf.kdnkVM(new HangHoaNhapKhauVM(options));
        } else if (options.fiHSType >= 4) {
            viewVMSelf.ktclVM(new KiemTraChatLuongVM(options));
        }
    };

    viewVMSelf.btnBack = function () {
        History.go(-1);
    }
}

function init(options) {
    var mard08ViewVM = new Mard08ViewVM();
    ko.applyBindings(mard08ViewVM, document.getElementById('mard08ViewHS'));
    mard08ViewVM.applyState(options);
}

function getThongTinHoSo (callback) {
    $.ajax({
        async: true,
        type: 'GET',
        cache: false,
        crossDomain: true,
        url: app.appContext + '/mard/08/hoso/find' + "?idHoSo=" + idHoSo,
        beforeSend: function (xhr) {
            xhr.setRequestHeader(CSRF_TOKEN_NAME, CSRF_TOKEN_VALUE);
        },
        success: function (res) {
            callback(res);
        },
        error: function (x, t, m) {
        },
    })
}

$(document).ready(function () {
    $('.date-picker').datetimepicker({
        format: 'dd/mm/yyyy'
    });

    var options = {};
    $('#loading10').show();
    getThongTinHoSo(function (data) {
        options = data.data;
        $.when(
            // Get list country
            app.sendGetRequest("/mard/08/danhmuc/quocgia", function (res) {
                options['lstCountry'] = res.data;
            }),
            // Get list province
            app.sendGetRequest("/mard/08/danhmuc/tinhthanh", function (res) {
                options['lstProvince'] = res.data;
            }),
            // Get list port
            app.sendGetRequest("/mard/08/danhmuc/cuakhau?countryCode=VN", function (res) {
                options['lstPort'] = res.data;
            }),
            // Get UOMs
            app.sendGetRequest("/mard/08/danhmuc/unit?unitTypeId=4&systemId=8", function (res) {
                options['lstUOMs'] = res.data;
            }),
            // Get profile status
            app.sendGetRequest("/mard/08/danhmuc/statusHoso?systemId=8", function (res) {
                options['lstProfileStatus'] = res.data;
            }),
            // Get attach types
            app.sendGetRequest("/mard/08/danhmuc/dinhkem?systemId=8&type=20", function (res) {
                options['lstAtchType20'] = res.data;
            }),
            app.sendGetRequest("/mard/08/danhmuc/dinhkem?systemId=8&type=20A", function (res) {
                options['lstAtchType20A'] = res.data;
            }),
            // Get document types
            app.sendGetRequest("/mard/08/hoso/doctype", function (res) {
                options['lstDocType'] = res.data;
            })
        ).done(function (data) {
            $('#loading10').hide();
            init(options);
        })
    })
});