ko.validation.rules.pattern.message = 'Invalid.';
ko.validation.init({
    registerExtenders: true,
    messagesOnModified: true,
    insertMessages: true,
    parseInputAttributes: true,
    messageTemplate: null
}, true);

function Mard07ViewVM () {
    var viewVMSelf = this;
    viewVMSelf.isEditable = ko.observable(false);

    viewVMSelf.kdnkVM = ko.observable(null);

    viewVMSelf.applyState = function (options) {
        viewVMSelf.kdnkVM(new HangHoaNhapKhauVM(options));
        viewVMSelf.kdnkVM().applyState(options);
    }

    viewVMSelf.goIndexPage = function () {
        window.location.href = app.appContext + "/mard/07/";
    }
}

function init(options) {
    var mard07ViewVM = new Mard07ViewVM();
    ko.applyBindings(mard07ViewVM, document.getElementById('mard07View'));
    mard07ViewVM.applyState(options);
}

function getThongTinHoSo (callback) {
    $.ajax({
        async: true,
        type: 'GET',
        cache: false,
        crossDomain: true,
        url: app.appContext + '/mard/07/hoso/find' + "?idHoSo=" + idHoSo,
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
    $('#loading08').show();
    var options = {};
    getThongTinHoSo(function (data) {
        options = data.data;
        options['lstPurpose'] = [
            {
                id: 1,
                name: "Kinh doanh thực phẩm"
            },
            {
                id: 2,
                name: "Làm giống nuôi thương phẩm"},
            {
                id: 3,
                name: "Làm giống bố mẹ"},
            {
                id: 4,
                name: "Làm thủ công mĩ nghệ"},
            {
                id: 5,
                name: "Làm cảnh"},
            {
                id: 6,
                name: "Chế biến thực phẩm"},
            {
                id: 7,
                name: "Làm nguyên liệu gia công, chế biến thực phẩm xuất khẩu"
            },
            {
                id: 8,
                name: "Hàng làm mẫu thử"
            },
            {
                id: 9,
                name: "Khác"
            },
            {
                id: 10,
                name: "Sản phẩm động vật thủy sản xuất khẩu bị triệu hồi hoặc bị trả về"
            }
        ];
        $.when(
            // Get list country
            app.sendGetRequest("/mard/07/danhmuc/quocgia", function (res) {
                options['lstCountry'] = res.data;
            }),
            // Get list province
            app.sendGetRequest("/mard/07/danhmuc/tinhthanh", function (res) {
                options['lstProvince'] = res.data;
            }),
            // Get list port
            app.sendGetRequest("/mard/07/danhmuc/cuakhau?countryCode=VN", function (res) {
                options['lstPort'] = res.data;
            }),
            // Get profile status
            app.sendGetRequest("/mard/07/danhmuc/trangthai?systemId=7", function (res) {
                options['lstProfileStatus'] = res.data;
            }),
            // Get list department
            app.sendGetRequest("/mard/09/dvxl", function (res) {
                var lstTramThuY = [];

                var lstChildPU = res.data[0].lstChildPU;

                lstChildPU.forEach(function (itemChicuc) {
                    lstTramThuY.push({
                        id: itemChicuc.fiPUCode,
                        name: itemChicuc.fiPUDesc
                    });
                    itemChicuc.lstChildPU.forEach(function (itemTram) {
                        lstTramThuY.push({
                            id: itemTram.fiPUCode,
                            name: "-- " + itemTram.fiPUDesc
                        });
                    })
                });
                options['lstDepartment'] = lstTramThuY;
            }),
            // Get attach types
            app.sendGetRequest("/mard/07/danhmuc/dinhkem?systemId=7&type=N", function (res) {
                options['lstAtchType'] = res.data;
            }),
            // Get attach types gccb
            app.sendGetRequest("/mard/07/danhmuc/dinhkem?systemId=7&type=GCCB", function (res) {
                options['lstAtchTypeGCCB'] = res.data;
            }),
            // Get attach types htc
            app.sendGetRequest("/mard/07/danhmuc/dinhkem?systemId=7&type=HTC", function (res) {
                options['lstAtchTypeHTC'] = res.data;
            }),
            // Get phan loai hang hoa
            app.sendGetRequest("/mard/07/danhmuc/hanghoa?type=PHAN_LOAI", function (res) {
                options['lstClassification'] = res.data;
            }),
            // Get danh muc hang hoa
            app.sendGetRequest("/mard/07/danhmuc/hanghoa?type=DANH_MUC_HANG_HOA", function (res) {
                options['lstCategory'] = res.data;
            }),
            // Get phuong thuc bao quan
            app.sendGetRequest("/mard/07/danhmuc/hanghoa?type=LOAI", function (res) {
                options['lstSpecies'] = res.data;
            }),
            // Get UOMs
            app.sendGetRequest("/mard/07/danhmuc/unit?unitTypeId=4&systemId=6", function (res) {
                options['lstUOM'] = res.data;
            }),
            // Get list giay phep
            app.sendGetRequest("/mard/07/danhmuc/giayphep06", function (res) {
                options['lstCongVan'] = res.data;
            })
        ).done(function (data) {
            $('#loading08').hide();
            init(options);
        })
    });
})
