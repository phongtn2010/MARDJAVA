function Mard25ViewVM() {
    var viewHSVMSelf = this;
    viewHSVMSelf.kdnkVM = ko.observable(null);
    viewHSVMSelf.isEditable = ko.observable(false);

    viewHSVMSelf.applyState = function (options) {
        viewHSVMSelf.kdnkVM(new HangHoaNhapKhauVM(options))
    }

    viewHSVMSelf.btnBack = function () {
        History.go(-1);
    }
    viewHSVMSelf.goIndexPage = function () {
        window.location.href = app.appContext + "/mard/25/";
    }
}

function getThongTinHoSo(callback) {
    $('#loading08').show();
    $.ajax({
        async: true,
        type: 'GET',
        cache: false,
        crossDomain: true,
        url: app.appContext + '/mard/25/hoso/find' + "?idHoSo=" + idHoSo,
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
    var mard25ViewVM = new Mard25ViewVM();
    ko.applyBindings(mard25ViewVM, document.getElementById('mard25ViewHSModal'));
    mard25ViewVM.applyState(options);
}

$(document).ready(function () {
    var options = {};
    getThongTinHoSo(function (data) {
        options = data.data;
        $('#loading10').show();
        $.when(
            // Get list country
            app.sendGetRequest("/mard/25/danhmuc/quocgia", function (res) {
                options['lstCountry'] = res.data;
            }),
            // Get list province
            app.sendGetRequest("/mard/25/danhmuc/tinhthanh", function (res) {
                options['lstProvince'] = res.data;
            }),
            // Get list port
            app.sendGetRequest("/mard/25/danhmuc/cuakhau?countryCode=VN", function (res) {
                options['lstPort'] = res.data;
            }),
            // Get UOMs
            app.sendGetRequest("/mard/25/danhmuc/unit?unitTypeId=4&systemId=6", function (res) {
                options['lstUOMAnimal'] = res.data;
            }),
            // Get profile status
            app.sendGetRequest("/mard/25/danhmuc/getby-catno/1", function (res) {
                options['lstNhom'] = res.data;
                options['lstPhanNhom'] = res.data;
                options['lstPhanLoai'] = res.data;
                options['lstLoai'] = res.data;
            })
            ,
            app.sendGetRequest("/mard/25/danhmuc/getby-catno/11", function (res) {
                options['lstAtchType'] = res.data;
            })
            ,
            app.sendGetRequest("/mard/25/danhmuc/getby-catno/12", function (res) {
                options['lstLoaiHoSoDangKy'] = res.data;
            }),
            app.sendGetRequest("/mard/25/danhmuc/getby-catno/25", function (res) {
                options['lstProfileStatus'] = res.data;
            }),
            app.sendGetRequest("/mard/25/danhmuc/getby-catno/2", function (res) {
                options['lstHoSoType'] = res.data;
            }),
            // Get danh muc tien te
            app.sendGetRequest("/mard/25/danhmuc/getby-catno/26", function (res) {
                options['lstLoaiTienTe'] = res.data;
            }),//danh muc loai file dinh kem khac
            app.sendGetRequest("/mard/25/danhmuc/getby-catno/12", function (res) {
                options['lstLoaiFileDinhKemKhac'] = res.data;
            }),
            // Get danh muc dvt
            app.sendGetRequest("/mard/25/danhmuc/getby-catno/10", function (res) {
                options['lstDMDVT'] = res.data;
            }),
            // Get danh muc dvt
            app.sendGetRequest("/mard/25/danhmuc/getby-catno/3", function (res) {
                options['lstChiTieuAT'] = res.data;
            })
        ).done(function (data) {
            $('#loading10').hide();
            init(options);
        })
    })
})