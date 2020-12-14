/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
ko.validation.rules.pattern.message = 'Invalid.';
ko.validation.init({registerExtenders: true, messagesOnModified: true, insertMessages: true, parseInputAttributes: true, messageTemplate: null}, true);

function ViewVM(options) {
    self = this;
    self.formVM = ko.observable(new FormVM(options));
    self.resultVM = ko.observable(new ResultVM(options));
    self.showCert = ko.observable(false);
    
    if (options.tab) {
        self.showCert(true);
    }
    
    /**
     * Tro lai man hinh danh sach
     * @returns {undefined}
     */
    self.btnTroLaiClick = function () {
        History.go(-1);
    };
    
    self.formVM().hosoErrors.showAllMessages(false);
}
var DINHKEMDATA = null;
$(document).ready(function () {

    var options = app.parseQuerystring();
    $('#loading10').show();
    var pName = document.location.pathname;
    var items = pName.split('/');
    var _documentType = items[items.length - 2];
    
    var documentType = '';
    if (parseInt(_documentType) === 12) {
        documentType = '/1';
    } else if (parseInt(_documentType) === 34) {
        documentType = '/2';
    } else {
        documentType = '/0';
    }
    
    $.when(
            app.getCategory('/moh/39/danhmuc', 'DANHMUC_DONVITINH', null, function (res) {
                if (res.success) {
                    options.lstDonViTinh = res.data;
                } else {
                    options.lstDonViTinh = [];
                }
            }),
            app.getCategory('/moh/39/danhmuc', 'DANHMUC_TINHTHANH', null, function (res) {
                if (res.success) {
                    options.lstTinhThanh = res.data;
                } else {
                    options.lstTinhThanh = [];
                }
            }),
            app.getCategory('/moh/39/danhmuc', 'DANHMUC_CUAKHAU_NHAPKHAU', null, function (res) {
                if (res.success) {
                    options.lstCuaKhauNhap = res.data;
                } else {
                    options.lstCuaKhauNhap = [];
                }
            }),
            app.getCategory('/moh/39/danhmuc', 'DANHMUC_NUOCSANXUAT', null, function (res) {
                if (res.success) {
                    options.ltsNuocSanXuat = res.data;
                } else {
                    options.ltsNuocSanXuat = [];
                }
            }),
            app.getCategory('/moh/39/danhmuc', 'DANHMUC_LOAIDONHANG', options.maThuTuc + documentType, function (res) {
                if (res.success) {
                    options.lstLoaiDonHang = res.data;
                } else {
                    options.lstLoaiDonHang = [];
                }
            }),
            app.getCategory('/moh/39/danhmuc', 'DANHMUC_LOAIFILE', options.maThuTuc, function (res) {
                if (res.success) {
                    DINHKEMDATA = res.data;
                } else {
                    DINHKEMDATA = [];
                }
            }),
            app.getCategory('/moh/39/danhmuc', 'DANHMUC_NGUYENLIEU', null, function (res) {
                if (res.success) {
                    options.lstNguyenLieu = res.data;
                } else {
                    options.lstNguyenLieu = [];
                }
            }),
            app.getCategory('/moh/39/danhmuc', 'DANHMUC_MUCDICHNHAPKHAU', options.maThuTuc + '/0', function (res) {
                if (res.success) {
                    options.lstMucDichNhapKhau = res.data;
                } else {
                    options.lstMucDichNhapKhau = [];
                }
            })
    ).done(function (data) {
        
        init();
        $('#loading10').hide();
    });
    
    var cb = function () {
        var view = new ViewVM(options);
        ko.applyBindings(view, document.getElementById('ViewVM'));
        $("#fiMaTinh").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
        $("#fiMaCuaKhau").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
        $(".fiMaCuaKhau").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
        $("#fiMucDichNk").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
        $("#fiMaDvtinh").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
        $("#fiMaQgSx").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
        $("#fiLoaiDon").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
        $("#fiMaHang").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
    };

    var init = function () {
        
        if (options && options.fiIdHoso > 0) {
            var url = '/moh/39/hoso/t/' + options.fiIdHoso;
            var url_result = '/moh/39/hoso/vanban';
            app.makePost({
                url: url,
                data: JSON.stringify({}),
                success: function (d) {
                    if (d.success) {
                        options.hoso = d.data;
                        if (options.tab) {
                            app.makePost({
                                url: url_result,
                                data: JSON.stringify({
                                    fiIdHoso: options.fiIdHoso,
                                    fiMaHoso: options.fiMaHoso
                                }),
                                success: function (obj) {
                                    if (obj.success) {
                                        if (obj.data != null) {
                                            options.vanban = obj.data;
                                            cb();
                                        }
                                    }
                                },
                                error: function (e) {
                                    app.Alert('Không lấy được dữ liệu công văn.');
                                    cb();
                                }
                            });
                        } else {
                            cb();
                        }
                    }
                },
                error: function (e) {
                    app.Alert('Không lấy được dữ liệu hồ sơ');
                }
            });
        }
    };
});

