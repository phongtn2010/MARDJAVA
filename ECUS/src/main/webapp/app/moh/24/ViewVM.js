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
    self.portNames = ko.observable(null);
    self.showCert = ko.observable(false);
    self.lstHangHoa = ko.observableArray([]);

    self.fnNgayGuiText = self.formVM().fiNgaytao().toDateString();
    if (options.tab) {
        self.showCert(true);
    }

    var proceduceId = function () {
        var pName = document.location.pathname;
        var items = pName.split('/');
        return items[items.length - 2];
    };

    self.initHangHoa = function () {
        //Tao listHangHoa de phuc vu hien thi don
        if (self.formVM().isFirstGroup()) {
            var count = self.formVM().lstNguyenLieus().length;
            for (var i = 0; i < count; i++) {
                var d = {};

                d.fiTenHang = self.formVM().fiTenHang();
                d.fiHoatChat = self.formVM().fiHoatChat();
                d.fiSoDkLh = self.formVM().fiSoDkLh();
                d.fiSoLuong = self.formVM().fiSoLuong();

                d.fiBaoChe = self.formVM().fiBaoChe();
                d.fiDongGoi = self.formVM().fiDongGoi();
                d.fiTenDvtinh = self.formVM().fiTenDvtinh();
                d.fiTenCoSoSx = self.formVM().fiTenCoSoSx();
                d.fiDiachiCssx = self.formVM().fiDiachiCssx();
                d.fiTenQgSx = self.formVM().fiTenQgSx();
                d.fiTenCoSoNk = self.formVM().fiTenCoSoNk();
                d.fiDiachiCsNk = self.formVM().fiDiachiCsNk();
                d.fiTenQgNk = self.formVM().fiTenQgNk();
                d.fiTccl = self.formVM().fiTccl();

                d.fiTenNglieu = self.formVM().lstNguyenLieus()[i].fiTenNglieu();
                d.fiTongKl = self.formVM().lstNguyenLieus()[i].fiTongKl();
                self.lstHangHoa.push(new hangHoaItem(d));
            }

            for (var i = 0; i < count; i++) {
                var d = {};
                d.fiTenHang = self.formVM().fiTenHang();
                d.fiHoatChat = self.formVM().fiHoatChat();
                d.fiSoDkLh = self.formVM().fiSoDkLh();
                d.fiSoLuong = self.formVM().fiSoLuong();

                d.fiBaoChe = self.formVM().fiBaoCheEn();
                d.fiDongGoi = self.formVM().fiDongGoiEn();
                d.fiTenDvtinh = self.formVM().fiTenDvtinhEn();
                d.fiTenCoSoSx = self.formVM().fiTenCoSoSxEn();
                d.fiDiachiCssx = self.formVM().fiDiachiCssxEn();
                d.fiTenQgSx = self.formVM().fiTenQgSxEn();
                d.fiTenCoSoNk = self.formVM().fiTenCoSoNkEn();
                d.fiDiachiCsNk = self.formVM().fiDiachiCsNkEn();
                d.fiTenQgNk = self.formVM().fiTenQgNkEn();
                d.fiTccl = self.formVM().fiTcclEn();

                d.fiTenNglieu = self.formVM().lstNguyenLieus()[i].fiTenNglieu();
                d.fiTongKl = self.formVM().lstNguyenLieus()[i].fiTongKl();
                self.lstHangHoa.push(new hangHoaItem(d));
            }
        } else {
            var d = {};
            d.fiTenNglieu = self.formVM().fiTenNglieu();
            d.fiTenDvtinh = self.formVM().fiTenDvtinhEn();
            d.fiSoLuong = self.formVM().fiSoLuong();
            d.fiTccl = self.formVM().fiTccl();

            d.fiTenCoSoSx = self.formVM().fiTenCoSoSx();
            d.fiDiachiCssx = self.formVM().fiDiachiCssx();
            d.fiTenQgSx = self.formVM().fiTenQgSx();
            d.fiTenCoSoNk = self.formVM().fiTenCoSoNk();
            d.fiDiachiCsNk = self.formVM().fiDiachiCsNk();
            d.fiTenQgNk = self.formVM().fiTenQgNk();

            self.lstHangHoa.push(new hangHoaItem(d));

            var d2 = {};
            d2.fiTenNglieu = self.formVM().fiTenNglieu();
            d2.fiTenDvtinh = self.formVM().fiTenDvtinhEn();
            d2.fiSoLuong = self.formVM().fiSoLuong();
            d2.fiTccl = self.formVM().fiTccl();

            d2.fiTenCoSoSx = self.formVM().fiTenCoSoSxEn();
            d2.fiDiachiCssx = self.formVM().fiDiachiCssxEn();
            d2.fiTenQgSx = self.formVM().fiTenQgSxEn();
            d2.fiTenCoSoNk = self.formVM().fiTenCoSoNkEn();
            d2.fiDiachiCsNk = self.formVM().fiDiachiCsNkEn();
            d2.fiTenQgNk = self.formVM().fiTenQgNkEn();

            self.lstHangHoa.push(new hangHoaItem(d2));            
        }
    };

    self.getPortName = function () {
        var model = ko.toJS(self.formVM());
        var portNames = '';
        for (var i = 0; i < model.lstCuaKhaus.length; i++) {
            var idx = model.lstCuaKhauNhap.Search('id', model.lstCuaKhaus[i]);
            if (idx >= 0) {
                portNames += ', ' + model.lstCuaKhauNhap[idx].name;
            }
        }
        return portNames;
    };

    self.portNames(self.getPortName());

    self.title = ko.observable(NSWLang["moh_" + proceduceId() + "_tenthutuc"]);

    /**
     * Tro lai man hinh danh sach
     * @returns {undefined}
     */
    self.btnTroLaiClick = function () {
        History.go(-1);
    };

    self.initHangHoa();
    self.formVM().hosoErrors.showAllMessages(false);
}
var DINHKEMDATA = null;
$(document).ready(function () {

    var options = app.parseQuerystring();
    $('#loading10').show();
    var documentType = '/1';

    $.when(
            app.getCategory('/moh/18/danhmuc', 'DANHMUC_TINHTHANH', null, function (res) {
                if (res.success) {
                    options.lstTinhThanh = res.data;
                } else {
                    options.lstTinhThanh = [];
                }
            }),
            app.getCategory('/moh/18/danhmuc', 'DANHMUC_LOAIDONHANG', options.maThuTuc + documentType, function (res) {
                if (res.success) {
                    options.lstLoaiDonHang = res.data;
                } else {
                    options.lstLoaiDonHang = [];
                }
            }),
            app.getCategory('/moh/18/danhmuc', 'DANHMUC_CUAKHAU_NHAPKHAU', null, function (res) {
                if (res.success) {
                    options.lstCuaKhauNhap = res.data;
                } else {
                    options.lstCuaKhauNhap = [];
                }
            }),
            app.getCategory('/moh/18/danhmuc', 'DANHMUC_NGUYENLIEU', null, function (res) {
                if (res.success) {
                    options.lstNguyenLieu = res.data;
                } else {
                    options.lstNguyenLieu = [];
                }
            }),
            app.getCategory('/moh/18/danhmuc', 'DANHMUC_DONVITINH', null, function (res) {
                if (res.success) {
                    options.lstDonViTinh = res.data;
                } else {
                    options.lstDonViTinh = [];
                }
            }),
            app.getCategory('/moh/18/danhmuc', 'DANHMUC_NUOCSANXUAT', null, function (res) {
                if (res.success) {
                    options.ltsNuocSanXuat = res.data;
                } else {
                    options.ltsNuocSanXuat = [];
                }
            }),
            app.getCategory('/moh/18/danhmuc', 'DANHMUC_LOAIFILE', options.maThuTuc, function (res) {
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

    var cb = function () {
        var view = new ViewVM(options);
        ko.applyBindings(view, document.getElementById('ViewVM'));
        $("#fiMaTinh").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
        $("#fiMaCuaKhau").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
        $("#fiMucDichNk").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
        $("#fiMaDvtinh").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
        $("#fiMaQgSx").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
        $("#fiMaQgNk").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
        $("#fiMaLoaidon").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
        $("#fiMaNglieu").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
        $(".fiMaNglieu").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
    };

    var init = function () {

        if (options && options.fiIdHoso > 0) {
            var url = '/moh/18/hoso/t/' + options.fiIdHoso;
            var url_result = '/moh/18/hoso/vanban';
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

