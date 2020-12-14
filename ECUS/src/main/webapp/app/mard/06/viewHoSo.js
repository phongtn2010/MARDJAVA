function Mard06ViewVM() {
    var viewHSVMSelf = this;
    viewHSVMSelf.kdnkVM = ko.observable(null);
    viewHSVMSelf.isEditable = ko.observable(false);

    viewHSVMSelf.applyState = function (options) {
        viewHSVMSelf.kdnkVM(new KiemDichNhapKhauVM(options))
    }

    viewHSVMSelf.btnBack = function () {
        History.go(-1);
    }
    viewHSVMSelf.goIndexPage = function () {
        window.location.href = app.appContext + "/mard/06/";
    }
}

function getThongTinHoSo(callback) {
    $('#loading08').show();
    $.ajax({
        async: true,
        type: 'GET',
        cache: false,
        crossDomain: true,
        url: app.appContext + '/mard/06/hoso/find' + "?idHoSo=" + idHoSo,
        beforeSend: function (xhr) {
            xhr.setRequestHeader(CSRF_TOKEN_NAME, CSRF_TOKEN_VALUE);
        },
        success: function (res) {
            callback(res);
            $('#loading08').hide();
        },
        error: function (x, t, m) {
            $('#loading08').hide();
        },
    })
}

function init(options) {
    var mard06ViewVM = new Mard06ViewVM();
    ko.applyBindings(mard06ViewVM, document.getElementById('mard06View'));
    mard06ViewVM.applyState(options);
}

$(document).ready(function () {
    var options = {};
    getThongTinHoSo(function (data) {
        options = data.data;
        $('#loading10').show();
        $.when(
            // Get list country
            app.sendGetRequest("/mard/06/danhmuc/quocgia", function (res) {
                options['lstCountry'] = res.data;
            }),
            // Get list province
            app.sendGetRequest("/mard/06/danhmuc/tinhthanh", function (res) {
                options['lstProvince'] = res.data;
            }),
            // Get list port
            app.sendGetRequest("/mard/06/danhmuc/cuakhau?countryCode=VN", function (res) {
                options['lstPort'] = res.data;
            }),
            // Get UOMs
            app.sendGetRequest("/mard/06/danhmuc/unit?unitTypeId=4&systemId=6", function (res) {
                options['lstUOMAnimal'] = res.data;
            }),
            // Get profile status
            app.sendGetRequest("/mard/06/danhmuc/statusHoso?systemId=6", function (res) {
                options['lstProfileStatus'] = res.data;
            }),
            // Get attach types
            app.sendGetRequest("/mard/06/danhmuc/dinhkem?systemId=6", function (res) {
                options['lstAtchType'] = res.data;
            })
        ).done(function (data) {
            $('#loading10').hide();
            init(options);
        })
    })
})