/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
ko.validation.rules.pattern.message = 'Invalid.';
ko.validation.init({registerExtenders: true, messagesOnModified: true, insertMessages: true, parseInputAttributes: true, messageTemplate: null}, true);

function EditVM(options) {
    var BIEN_SO_XE_DA_TON_TAI = "1";
    var BIEN_SO_XE_THAY_DOI_DA_TON_TAI = "2";


    self = this;
    self.formVM = ko.observable(new FormVM(options));
    self.formVM().phuongtienErrors.showAllMessages(false);
    self.btnLuu = ko.observable(true);


    /**
     * Luu phương tiện
     * @returns {undefined}
     */
    self.btnLuuClick = function () {
        var cb = function (d) {
            self.formVM().fiIdXe(d.data.fiIdXe);
            self.formVM().fiNguoitao(d.data.fiNguoitao);
        };

        if (!self.formVM().isValidForm()) {
            return;
        }

        var fiIdXe = self.formVM().fiIdXe();
        var data = self.formVM().toJSON();
        
        delete data['__ko_mapping__'];

        var url = !fiIdXe || fiIdXe <= 0 ? '/mt/qlpt/phuongtien/taomoi' : '/mt/qlpt/phuongtien/capnhap';

        app.makePost({
            url: url,
            data: JSON.stringify(data),
            success: function (d) {
                if (d && d.success) {
                    app.Alert('Lưu dữ liệu thành công');
                    cb(d);
//                    History.go(-1);
                } else {
                    app.Alert('Lưu dữ liệu không thành công');
                }
            },
            error: function (e) {
                if (e.message === BIEN_SO_XE_DA_TON_TAI) {
                    app.Alert('Biển số xe đã tồn tại');
                } else if (e.message === BIEN_SO_XE_THAY_DOI_DA_TON_TAI) {
                    app.Alert('Biển số xe bạn thay đổi đã tồn tại');
                } else {
                    app.Alert('Lưu dữ liệu không thành công');
                }
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


$(document).ready(function () {

    var options = app.parseQuerystring();
    $('#loading10').show();
    $.when(
            app.getCategory('/mt/qlpt/danhmuc', 'PT_LOAIHINH', null, function (res) {
                if (res.success) {
                    options.lstLoaixe = res.data;
                } else {
                    options.lstLoaixe = [];
                }
            }),
            app.getCategory('/mt/qlpt/danhmuc', 'PT_MAUSON', null, function (res) {
                if (res.success) {
                    options.lstMauson = res.data;
                } else {
                    options.lstMauson = [];
                }
            }),
            app.getCategory('/mt/qlpt/danhmuc', 'PT_NHANHIEU', null, function (res) {
                if (res.success) {
                    options.lstNhanhieu = res.data;
                } else {
                    options.lstNhanhieu = [];
                }
            }),
            app.getCategory('/mt/qlpt/danhmuc', 'PT_QUOCGIA', null, function (res) {
                if (res.success) {
                    options.lstQuocgia = res.data;
                } else {
                    options.lstQuocgia = [];
                }
            })
            ).done(function (data) {
        init();
        $('#loading10').hide();
    });

    var init = function () {
        if (options && options.fiIdPhuongtien > 0) {
            var url = '/mt/qlpt/phuongtien/t/' + options.fiIdPhuongtien;
            app.makePost({
                url: url,
                data: JSON.stringify({}),
                success: function (d) {
                    if (d.success) {
                        options.phuongtien = d.data;
                        var editVM = new EditVM(options);
                        ko.applyBindings(editVM, document.getElementById('EditVM'));
                        $("#fiMaQgia").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
                        $("#fiMaNhanhieu").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
                        $("#fiMaLoaixe").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
                        $("#fiMaMauson").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
                    }
                },
                error: function (e) {
                    app.Alert('Không lấy được dữ liệu hồ sơ');
                }
            });
        } else {
            var editVM = new EditVM(options);
            ko.applyBindings(editVM, document.getElementById('EditVM'));
            $("#fiMaQgia").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
            $("#fiMaNhanhieu").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
            $("#fiMaLoaixe").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
            $("#fiMaMauson").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
        }
    };
});

