/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
ko.validation.rules.pattern.message = 'Invalid.';
ko.validation.init({registerExtenders: true, messagesOnModified: true, insertMessages: true, parseInputAttributes: true, messageTemplate: null}, true);

function EditVM(options) {
    self = this;
    self.formVM = ko.observable(new FormVM(options));
    self.formVM().hosoErrors.showAllMessages(false);
    self.btnLuu = ko.observable(false);
    self.btnGui = ko.observable(false);

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
            if (!fiIdHoso || fiIdHoso <= 0) {
                self.formVM().fiIdHoso(d.data.fiIdHoso);
                self.formVM().fiNgaytao(new Date(d.data.fiNgaytao));
            } else {
                self.formVM().fiIdHoso(d.data.fiIdHoso);
            }            
            self.formVM().fiMaHoso(d.data.fiMaHoso);
            self.formVM().fiNguoitao(d.data.fiNguoitao);            
            self.formVM().fiTrangthai(d.data.fiTrangthai);
            self.formVM().fiTenTt(d.data.fiTenTt);
        };

        if (!self.formVM().isValidForm()) {
            app.Alert('Phải nhập đúng và đủ thông tin các trường dữ liệu yêu cầu (đánh dấu màu đỏ).');
            return;
        }

        var fiIdHoso = self.formVM().fiIdHoso();
        var data = self.formVM().toJSON();

        var url = !fiIdHoso || fiIdHoso <= 0 ? '/mt/43/hoso/taomoi' : '/mt/43/hoso/capnhap';

        app.makePost({
            url: url,
            data: JSON.stringify(data),
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
            if (!fiIdHoso || fiIdHoso <= 0) {
                self.formVM().fiIdHoso(d.data.fiIdHoso);
                self.formVM().fiNgaytao(new Date(d.data.fiNgaytao));
            } else {
                self.formVM().fiIdHoso(d.data.fiIdHoso);
            }            
            self.formVM().fiMaHoso(d.data.fiMaHoso);
            self.formVM().fiNguoitao(d.data.fiNguoitao);            
            self.formVM().fiTrangthai(d.data.fiTrangthai);
            self.formVM().fiTenTt(d.data.fiTenTt);
			self.btnLuu = ko.observable(false);
        };

        if (!self.formVM().isValidForm()) {
            app.Alert('Phải nhập đúng và đủ thông tin các trường dữ liệu yêu cầu (đánh dấu màu đỏ).');
            return;
        }

        var fiIdHoso = self.formVM().fiIdHoso();
        var data = self.formVM().toJSON();

        app.makePost({
            url: '/mt/43/hoso/send',
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
    $('#loading10').show();
    var options = app.parseQuerystring();
    $.when(
            app.getCategory('/mt/43/danhmuc', 'HS_DONVIXULY', options.maThuTuc, function (res) {
                if (res.success) {
                    options.lstDonViXuLy = res.data;
                } else {
                    options.lstDonViXuLy = [];
                }
            }),
            app.getCategory('/mt/43/danhmuc', 'HS_TUYENVANTAI', null, function (res) {
                if (res.success) {
                    options.lstTuyen = res.data;
                } else {
                    options.lstTuyen = [];
                }
            }),
            app.getCategory('/mt/43/danhmuc', 'HS_NHANHIEU', null, function (res) {
                if (res.success) {
                    options.lstLoaiXe = res.data;
                } else {
                    options.lstLoaiXe = [];
                }
            }),
            app.getCategory('/mt/43/danhmuc', 'HS_LOAIFILE', options.maThuTuc, function (res) {
                if (res.success) {
                    DINHKEMDATA = res.data;
                } else {
                    DINHKEMDATA = [];
                }
            })
            ).done(function (data) {
        init();
        $('#loading10').hide();
    });

    var init = function () {
        if (options && options.fiIdHoso > 0) {
            var url = '/mt/43/hoso/t/' + options.fiIdHoso;
            app.makePost({
                url: url,
                data: JSON.stringify({}),
                success: function (d) {
                    if (d.success) {
                        options.hoso = d.data;
                        var editVM = new EditVM(options);
                        ko.applyBindings(editVM, document.getElementById('EditVM'));
                        $(".fiMaCkXn").select2({placeholder: '-- Chọn --', width: '200px', allowClear: true});
                        $(".fiMaTuyen").select2({placeholder: '-- Chọn --', width: '200px', allowClear: true});
                        $(".fiMaLoaixe").select2({placeholder: '-- Chọn --', width: '200px', allowClear: true});
                    }
                },
                error: function (e) {
                    app.Alert('Không lấy được dữ liệu hồ sơ');
                }
            });
        } else {
            options.lstDinhKem = DINHKEMDATA;
            var editVM = new EditVM(options);
            ko.applyBindings(editVM, document.getElementById('EditVM'));
            $(".fiMaCkXn").select2({placeholder: '-- Chọn --', width: '200px', allowClear: true});
            $(".fiMaTuyen").select2({placeholder: '-- Chọn --', width: '200px', allowClear: true});
            $(".fiMaLoaixe").select2({placeholder: '-- Chọn --', width: '200px', allowClear: true});
        }
    };
});

