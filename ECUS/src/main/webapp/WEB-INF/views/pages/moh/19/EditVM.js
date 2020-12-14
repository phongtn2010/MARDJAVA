/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
ko.validation.rules.pattern.message = 'Invalid.';
ko.validation.init({registerExtenders: true, messagesOnModified: true, insertMessages: true, parseInputAttributes: true, messageTemplate: null}, true);

//(function() {
//    var init = ko.bindingHandlers['datePicker'].init;
//    ko.bindingHandlers['datePicker'].init = function (element, valueAccessor, allBindingsAccessor, viewModel, bindingContext) {
//        init(element, valueAccessor, allBindingsAccessor);
//        return ko.bindingHandlers['validationCore'].init(element, valueAccessor, allBindingsAccessor, viewModel, bindingContext);
//    };
//}());


function EditVM(options) {
    self = this;
    self.formVM = ko.validatedObservable(new FormVM(options));
    self.formVM().hosoErrors.showAllMessages(false);
    self.btnLuu = ko.observable(false);
    self.btnGui = ko.observable(false);

    var proceduceId = function () {
        var pName = document.location.pathname;
        var items = pName.split('/');
        return items[items.length - 2];
    };

    self.title = ko.observable(NSWLang["moh_" + proceduceId() + "_tenthutuc"]);
    
    if (self.formVM().fiIdHoso() > 0) {
        if (self.formVM().fiTrangthai() == TAO_MOI) {
            self.btnLuu(true);
        }
    } else {
        self.btnLuu(true);
    }

    if (self.formVM().fiIdHoso() > 0) {
        if (self.formVM().fiTrangthai() == TAO_MOI
                || self.formVM().fiTrangthai() == CHO_TIEP_NHAN
                || self.formVM().fiTrangthai() == TU_CHOI_HOSO
                || self.formVM().fiTrangthai() == YC_BO_SUNG) {
            self.btnGui(true);
        }
    } else {
        self.btnGui(true);
    }

    /**
     * Luu ho so
     * @returns {undefined}
     */
    self.btnLuuClick = function () {
        var cb = function (d) {
            self.formVM().fiIdHoso(d.data.fiIdHoso);
            self.formVM().fiMaHoso(d.data.fiMaHoso);
            self.formVM().fiNguoitao(d.data.fiNguoitao);
            self.formVM().fiTrangthai(d.data.fiTrangthai);
            self.formVM().fiTenTt(d.data.fiTenTt);
        };
        
        var resultForm = self.formVM().isValidForm();
        if (!resultForm.success) {
            if(null != resultForm.message) {
                app.Alert('Phải nhập đầy đủ các thông tin còn thiếu. ' + resultForm.message);
            } else {
                app.Alert('Phải nhập đúng và đủ thông tin các trường dữ liệu yêu cầu (đánh dấu màu đỏ).');
            }
            return;
        }

        var fiIdHoso = self.formVM().fiIdHoso();
        var data = self.formVM().toJSON();

        delete data['__ko_mapping__'];

        var url = !fiIdHoso || fiIdHoso <= 0 ? '/moh/19/hoso/taomoi' : '/moh/19/hoso/capnhap';

        app.makePost({
            url: url,
            data: JSON.stringify(ko.toJS(data)),
            success: function (d) {
                if (d && d.success) {
                    app.Alert('Lưu dữ liệu thành công');
                    cb(d);
                } else {
                    app.Alert('Lưu dữ liệu không thành công');
                }
            },
            error: function (e) {
                app.Alert('Lưu dữ liệu không thành công');
            }
        });
    };
    /**
     * Gui ho so
     * @returns {undefined}
     */
    self.btnGuiClick = function () {
        var cb = function (d) {
            self.formVM().fiIdHoso(d.data.fiIdHoso);
            self.formVM().fiMaHoso(d.data.fiMaHoso);
            self.formVM().fiNguoitao(d.data.fiNguoitao);
            self.formVM().fiTrangthai(d.data.fiTrangthai);
            self.formVM().fiTenTt(d.data.fiTenTt);
            self.btnLuu(false);
        };
        var resultForm = self.formVM().isValidForm();
        if (!resultForm.success) {
            if(null != resultForm.message) {
                app.Alert(resultForm.message);
            } else {
                app.Alert('Phải nhập đúng và đủ thông tin các trường dữ liệu yêu cầu (đánh dấu màu đỏ).');
            }
            return;
        }

        var fiIdHoso = self.formVM().fiIdHoso();
        var data = self.formVM().toJSON();

        //console.log(data);

        self.pop = app.popup({
            title: 'Thông báo',
            html: '<b>Bạn chắc chắn muốn gửi hồ sơ?</b>',
            width: 450,
            buttons: [
                {
                    name: NSWLang["common_button_toi_chac_chan"],
                    class: 'btn',
                    icon: 'fa-save',
                    action: function () {
                        app.popupRemove(self.pop.selector);
                        app.makePost({
                            url: '/moh/19/hoso/send',
                            data: JSON.stringify(data),
                            success: function (d) {
                                if (d && d.success) {
                                    app.Alert('Gửi hồ sơ thành công');
                                    cb(d);
                                } else {
                                    app.Alert('Không gửi được hồ sơ');
                                }
                            },
                            error: function (e) {
                                app.Alert('Không gửi được hồ sơ');
                            }
                        });
                    }
                },
                {
                    name: 'Huỷ',
                    class: 'btn',
                    icon: 'fa-close',
                    action: function () {
                        app.popupRemove(self.pop.selector);
                    }
                }
            ]
        });
    };
    /**
     * Tro lai man hinh danh sach
     * @returns {undefined}
     */
    self.btnTroLaiClick = function () {
        History.go(-1);
    };
}

var DINHKEMDATA = null;
$(document).ready(function () {

    var options = app.parseQuerystring();
    $('#loading10').show();

    var documentType = '/1';

    $.when(
            app.getCategory('/moh/19/danhmuc', 'DANHMUC_DONVITINH', null, function (res) {
                if (res.success) {
                    options.lstDonViTinh = res.data;
                } else {
                    options.lstDonViTinh = [];
                }
            }),
            app.getCategory('/moh/19/danhmuc', 'DANHMUC_TINHTHANH', null, function (res) {
                if (res.success) {
                    options.lstTinhThanh = res.data;
                } else {
                    options.lstTinhThanh = [];
                }
            }),
            app.getCategory('/moh/19/danhmuc', 'DANHMUC_CUAKHAU_NHAPKHAU', null, function (res) {
                if (res.success) {
                    options.lstCuaKhauNhap = res.data;
                } else {
                    options.lstCuaKhauNhap = [];
                }
            }),
            app.getCategory('/moh/19/danhmuc', 'DANHMUC_NUOCSANXUAT', null, function (res) {
                if (res.success) {
                    options.ltsNuocSanXuat = res.data;
                } else {
                    options.ltsNuocSanXuat = [];
                }
            }),
            app.getCategory('/moh/19/danhmuc', 'DANHMUC_LOAIDONHANG', options.maThuTuc + documentType, function (res) {
                if (res.success) {
                    options.lstLoaiDonHang = res.data;
                } else {
                    options.lstLoaiDonHang = [];
                }
            }),
            app.getCategory('/moh/19/danhmuc', 'DANHMUC_LOAIFILE', options.maThuTuc, function (res) {
                if (res.success) {
                    DINHKEMDATA = res.data;
                } else {
                    DINHKEMDATA = [];
                }
            }),
            app.getCategory('/moh/19/danhmuc', 'DANHMUC_NGUYENLIEU', null, function (res) {
                if (res.success) {
                    options.lstNguyenLieu = res.data;
                } else {
                    options.lstNguyenLieu = [];
                }
            }),
            app.getCategory('/moh/19/danhmuc', 'DANHMUC_XUATXUHANGHOA', null, function (res) {
                if (res.success) {
                    options.lstXuatXuHangHoa = res.data;
                } else {
                    options.lstXuatXuHangHoa = [];
                }
            }),
            app.getCategory('/moh/19/danhmuc', 'DANHMUC_COSODENGHI', null, function (res) {
                if (res.success) {
                    options.lstCoSoDeNghiCap = res.data;
                } else {
                    options.lstCoSoDeNghiCap = [];
                }
            })
            ).done(function (data) {
        init();
        $('#loading10').hide();
    });

    var init = function () {
        if (options && options.fiIdHoso > 0) {
            var url = '/moh/19/hoso/t/' + options.fiIdHoso;
            app.makePost({
                url: url,
                data: JSON.stringify({}),
                success: function (d) {
                    if (d.success) {
                        options.hoso = d.data;
                        var editVM = new EditVM(options);
                        ko.applyBindings(editVM, document.getElementById('EditVM'));
                        $("#fiMaTinh").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
                        $("#fiMaCuaKhau").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
                        $("#fiXuatXu").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
                        $("#fiMaDvtinh").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
                        $("#fiMaQgSx").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
                        $("#fiMaQgNk").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
                        $("#fiLoaiDon").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
                        $("#fiMaHang").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
                        $("#fiCosoCppFsc").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
                        $(".fiMaNglieu").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
                    }
                },
                error: function (e) {
                    app.Alert('Không lấy được dữ liệu hồ sơ');
                }
            });
        } else {
            options.lstDinhKems = DINHKEMDATA;
            var editVM = new EditVM(options);
            ko.applyBindings(editVM, document.getElementById('EditVM'));
            $("#fiMaTinh").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
            $("#fiMaCuaKhau").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
            $("#fiXuatXu").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
            $("#fiMaDvtinh").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
            $("#fiMaQgSx").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
            $("#fiMaQgNk").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
            $("#fiLoaiDon").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
            $("#fiMaHang").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
            $("#fiCosoCppFsc").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
        }
    };
});

