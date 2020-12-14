/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
ko.validation.rules.pattern.message = 'Invalid.';
ko.validation.init({
    registerExtenders: true,
    messagesOnModified: true,
    insertMessages: true,
    parseInputAttributes: true,
    messageTemplate: null
}, true);

function EditVM(options) {
    self = this;
    self.formVM = ko.observable(new FormVM(options));

    if (options.copy) {
        self.formVM().fiIdHoso(null);
        self.formVM().fiMaHoso(null);
        self.formVM().fiMaTrangthai(null);
        self.formVM().fiTenTrangthai(null);
        self.formVM().fiNgaygui(null);
        self.formVM().fiNgayCapphep(null);
        self.formVM().fiNgaytao(null);
        self.formVM().fiNguoitao(null);
        self.formVM().fiHoatdong(null);
        self.formVM().fiCheckXnd(null);
        self.formVM().fiMaTrangthaiphi(null);
        self.formVM().fiTenTrangthaiphi(null);
    }

    /**
     * Button quay lai
     *
     */
    self.btnTroLaiClick = function () {
        History.go(-1);
    };

}

var DINHKEMDATA = null;
var RAW_HS_STATUS = null;
$(document).ready(function () {
    var options = app.parseQuerystring();
    $('#loading10').show();
    $.when(
        app.getCategory('/mard/p04/danhmuc', 'DM_TEPTIN', null, function (res) {
            if (res.success) {
                DINHKEMDATA = res.data;
            } else {
                DINHKEMDATA = [];
            }
        }),
        app.getCategory('/mard/p04/danhmuc', 'DM_BAOBI', null, function (res) {
            if (res.success) {
                options.lstBaobi = res.data;
            } else {
                options.lstBaobi = [];
            }
        }),
        app.getCategory('/mard/p04/danhmuc', 'DM_BOPHANDUNG', null, function (res) {
            if (res.success) {
                options.lstBophandung = res.data;
            } else {
                options.lstBophandung = [];
            }
        }),
        app.getCategory('/mard/p04/danhmuc', 'DM_CQXL', null, function (res) {
            if (res.success) {
                options.lstCqxl = res.data;
            } else {
                options.lstCqxl = [];
            }
        }),
        app.getCategory('/mard/p04/danhmuc', 'DM_CUAKHAU', null, function (res) {
            if (res.success) {
                options.lstCuakhauXuat = res.data;
            } else {
                options.lstCuakhauXuat = [];
            }
        }),
        app.getCategory('/mard/p04/danhmuc', 'DM_CUAKHAU', null, function (res) {
            if (res.success) {
                options.lstCangnhan = res.data;
            } else {
                options.lstCangnhan = [];
            }
        }),
        app.getCategory('/mard/p04/danhmuc', 'DM_CUAKHAU', null, function (res) {
            if (res.success) {
                options.lstCuakhauNhap = res.data;
            } else {
                options.lstCuakhauNhap = [];
            }
        }),
        app.getCategory('/mard/p04/danhmuc', 'DM_DONVI_TINH', null, function (res) {
            if (res.success) {
                options.lstDvTinhKlt = res.data;
            } else {
                options.lstDvTinhKlt = [];
            }
        }),
        app.getCategory('/mard/p04/danhmuc', 'DM_DONVI_TINH', null, function (res) {
            if (res.success) {
                options.lstDvTinhKlbb = res.data;
            } else {
                options.lstDvTinhKlbb = [];
            }
        }),
        app.getCategory('/mard/p04/danhmuc', 'DM_HANGHOA', null, function (res) {
            if (res.success) {
                options.lstHanghoa = res.data;
            } else {
                options.lstHanghoa = [];
            }
        }),
        app.getCategory('/mard/p04/danhmuc', 'DM_LOAI_GIAYTO', null, function (res) {
            if (res.success) {
                options.lstLoaiGiayto = res.data;
            } else {
                options.lstLoaiGiayto = [];
            }
        }),
        app.getCategory('/mard/p04/danhmuc', 'DM_LOAIHANG', null, function (res) {
            if (res.success) {
                options.lstLoaihang = res.data;
            } else {
                options.lstLoaihang = [];
            }
        }),
        app.getCategory('/mard/p04/danhmuc', 'DM_LOAI_THUCAN', null, function (res) {
            if (res.success) {
                options.lstLoaiThucan = res.data;
            } else {
                options.lstLoaiThucan = [];
            }
        }),
        app.getCategory('/mard/p04/danhmuc', 'DM_PHUONGTIEN', null, function (res) {
            if (res.success) {
                options.lstPhuongtien = res.data;
            } else {
                options.lstPhuongtien = [];
            }
        }),
        app.getCategory('/mard/p04/danhmuc', 'DM_QUOCGIA', null, function (res) {
            if (res.success) {
                options.lstNuocXuatkhau = res.data;
            } else {
                options.lstNuocXuatkhau = [];
            }
        }),
        app.getCategory('/mard/p04/danhmuc', 'DM_QUOCGIA', null, function (res) {
            if (res.success) {
                options.lstNuocXuatxu = res.data;
            } else {
                options.lstNuocXuatxu = [];
            }
        }),
        app.getCategory('/mard/p04/danhmuc', 'DM_DV_TIENTE', null, function (res) {
            if (res.success) {
                options.lstDvTiente = res.data;
            } else {
                options.lstDvTiente = [];
            }
        }),
        app.getCategory('/mard/p04/danhmuc', 'DM_LOAIDON', null, function (res) {

            if (res.success) {
                options.lstLoaidon = res.data;
            } else {
                options.lstLoaidon = [];
            }
        }),
        app.getCategory('/mard/p04/danhmuc', 'DM_LOAI_KIEMTRA', null, function (res) {
            if (res.success) {
                options.lstLoaiKiemtra = res.data;
            } else {
                options.lstLoaiKiemtra = [];
            }
        }),
        app.getCategory('/mard/p04/danhmuc', 'DM_PHUONGTHUC_KT', null, function (res) {
            if (res.success) {
                options.lstPhuongthucKt = res.data;
            } else {
                options.lstPhuongthucKt = [];
            }
        })
    ).done(function (data) {
        init();
        $('#loading10').hide();
    });
    var init = function () {
        if (options && options.fiIdHoso > 0) {
            var url = '/mard/p04/hoso/t/' + options.fiIdHoso;
            app.makePost({
                url: url,
                data: JSON.stringify({}),
                success: function (d) {
                    if (d.success) {
                        options.hoso = d.data;
                        var editVM = new EditVM(options);
                        options.lstDinhkem04 = DINHKEMDATA;
                        ko.applyBindings(editVM, document.getElementById('EditVM'));
                        $("#fiMaLoaidon").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
                        $("#fiMaCqxl").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
                        $("#fiMaCuakhauXuat").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
                        $("#fiMaCuakhauNhap").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
                        $("#fiManuocXk").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
                        $("#fiMaPhuongtien").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
                        $("#fiMaLoaiThucan").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
                        $("#fiMaLoaiKiemtra").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
                        $("#fiMacangNoinhan").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
                        var hd = options.hoso.lstHopdong04;
                        if (hd != null && hd.length > 0) {
                            for (var i = 0; i < hd.length; i++) {
                                $("#fiMaLoaigiayto-" + hd[i].fiIdHd).select2({
                                    placeholder: '-- Chọn --',
                                    width: '100%',
                                    allowClear: true
                                });
                            }
                        }
                    }
                },
                error: function (e) {
                    app.Alert('Không lấy được dữ liệu hồ sơ');
                }
            });
        } else {
            options.lstDinhkem04 = DINHKEMDATA;
            var editVM = new EditVM(options);
            ko.applyBindings(editVM, document.getElementById('EditVM'));
            $("#fiMaLoaidon").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
            $("#fiMaCqxl").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
            $("#fiMaCuakhauXuat").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
            $("#fiMaCuakhauNhap").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
            $("#fiManuocXk").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
            $("#fiMaPhuongtien").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
            $("#fiMaLoaiThucan").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
            $("#fiMaLoaiKiemtra").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
            $("#fiMacangNoinhan").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
        }
    };
});