/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function FormVM(data) {
    var self = this;

    var hosoInfo = (data !== null && data.hasOwnProperty('hoso')) ? data.hoso : {};

    self.fiIdHoso = ko.observable(null);
    self.fiMaHoso = ko.observable(null);
    self.fiSoVbDn = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 20 ký tự', params: 20}
    });
    self.fiMaDvNhan = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiTenDvNhan = ko.observable(null);
    self.fiMstDn = ko.observable(null);
    self.fiTenDn = ko.observable(null);
    self.fiDiachiDn = ko.observable(null);
    self.fiTenTinh = ko.observable(null);
    self.fiMaTinh = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiTenQuan = ko.observable(null);
    self.fiMaQuan = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiLoaihinh = ko.observable(null);
    self.fiPbanQuanly = ko.observable(null);
    self.fiTenDnEn = ko.observable(null);
    self.fiTenVtat = ko.observable(null);
    self.fiSoDkkd = ko.observable(null);
    self.fiNamTlap = ko.observable(null);
    self.fiWebDn = ko.observable(null);
    self.fiSdtDn = ko.observable(null);
    self.fiFaxDn = ko.observable(null);
    self.fiEmailDn = ko.observable(null);
    self.fiTenNdd = ko.observable(null);
    self.fiSoCmndNdd = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 50 ký tự', params: 50}
    });
    self.fiNgaycapCmnd = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiNoiCapCmnd = ko.observable(null);
    self.fiSdtCodinh = ko.observable(null);
    self.fiSdtDd = ko.observable(null);
    self.fiMaMdichNk = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiTenMdichNk = ko.observable(NSWLang["moh_" + data.maThuTuc + "_tenthutuc"]);
    
    self.visibleNgayCapCMT = ko.computed(function () {
        return !self.fiNgaycapCmnd();
    });
    
    var fiMucDichNhapKhau = function () {
        var item = data.maThuTuc;
        var d = item.substring(item.length - 2, item.length);
        return d;
    };
    self.fiMaMdichNk(fiMucDichNhapKhau());

    self.fiHoatdong = ko.observable(1);
    self.fiNguoitao = ko.observable(null);
    self.fiNgaytao = ko.observable(null);
    self.fiNgCapnhat = ko.observable(null);
    self.fiTrangthai = ko.observable(0);
    self.fiTenTt = ko.observable(null);
    self.fiNgaynop = ko.observable(null);
    self.fiSoGp = ko.observable(null);
    self.fiNgaycapGp = ko.observable(null).extend({
        pattern: '[0-9]{2}/[0-9]{2}/[0-9]{4}'
    });
    self.fiMaThutuc = ko.observable(null);
    self.fiTenThutuc = ko.observable(null);

    self.lstHangHoas = new ko.observableArray([]);

    self.lstTinhThanh = ko.observableArray(mapCategory(data.hasOwnProperty('lstTinhThanh') ? data.lstTinhThanh : [], 'fiMaTinh', 'fiTenTinh'));
    self.lstQuocGia = ko.observableArray(mapCategory(data.hasOwnProperty('lstQuocGia') ? data.lstQuocGia : []));
    self.lstDonViNhan = ko.observableArray(mapCategory(data.hasOwnProperty('lstDonViNhan') ? data.lstDonViNhan : []));
    self.lstMucDichNhapKhau = ko.observableArray(mapCategory(data.hasOwnProperty('lstMucDichNhapKhau') ? data.lstMucDichNhapKhau : [], 'fiMaMdnk', 'fiTenMdnk'));
    self.lstQuanHuyen = ko.observableArray(mapCategory(data.hasOwnProperty('lstQuanHuyen') ? data.lstQuanHuyen : [], 'fiMaQuan', 'fiTenQuan'));

    var hosoVG = [self.fiMaDvNhan, self.fiMaTinh, self.fiMaQuan,
        self.fiSoCmndNdd, self.fiMaMdichNk, self.fiSoVbDn, self.fiNgaycapCmnd];
    self.hosoErrors = ko.validation.group(hosoVG, {deep: true, live: true, observable: true});
    self.errorHangHoaMessage = ko.observable(null);

    self.init = function (hoso) {

        self.fiIdHoso(hoso.hasOwnProperty('fiIdHoso') ? hoso.fiIdHoso : null);
        self.fiMaHoso(hoso.hasOwnProperty('fiMaHoso') ? hoso.fiMaHoso : null);
        self.fiSoVbDn(hoso.hasOwnProperty('fiSoVbDn') ? hoso.fiSoVbDn : null);
        self.fiMaDvNhan(hoso.hasOwnProperty('fiMaDvNhan') ? hoso.fiMaDvNhan : null);
        self.fiTenDvNhan(hoso.hasOwnProperty('fiTenDvNhan') ? hoso.fiTenDvNhan : null);

        self.fiMstDn(hoso.hasOwnProperty('fiMstDn') ? hoso.fiMstDn : user.username);
        self.fiTenDn(hoso.hasOwnProperty('fiTenDn') ? hoso.fiTenDn : user.companyName);
        self.fiDiachiDn(hoso.hasOwnProperty('fiDiachiDn') ? hoso.fiDiachiDn : user.companyAddress);

        self.fiTenTinh(hoso.hasOwnProperty('fiTenTinh') ? hoso.fiTenTinh : null);
        self.fiMaTinh(hoso.hasOwnProperty('fiMaTinh') ? hoso.fiMaTinh : null);
        self.fiTenQuan(hoso.hasOwnProperty('fiTenQuan') ? hoso.fiTenQuan : null);
        self.fiMaQuan(hoso.hasOwnProperty('fiMaQuan') ? hoso.fiMaQuan : null);
        self.fiLoaihinh(hoso.hasOwnProperty('fiLoaihinh') ? hoso.fiLoaihinh : null);
        self.fiPbanQuanly(hoso.hasOwnProperty('fiPbanQuanly') ? hoso.fiPbanQuanly : null);
        self.fiTenDnEn(hoso.hasOwnProperty('fiTenDnEn') ? hoso.fiTenDnEn : null);
        self.fiTenVtat(hoso.hasOwnProperty('fiTenVtat') ? hoso.fiTenVtat : null);
        self.fiSoDkkd(hoso.hasOwnProperty('fiSoDkkd') ? hoso.fiSoDkkd : null);
        self.fiNamTlap(hoso.hasOwnProperty('fiNamTlap') ? hoso.fiNamTlap : null);

        self.fiWebDn(hoso.hasOwnProperty('fiWebDn') ? hoso.fiWebDn : 'www.tech.vn');
        self.fiSdtDn(hoso.hasOwnProperty('fiSdtDn') ? hoso.fiSdtDn : '0123456789');
        self.fiFaxDn(hoso.hasOwnProperty('fiFaxDn') ? hoso.fiFaxDn : '12345678');
        self.fiEmailDn(hoso.hasOwnProperty('fiEmailDn') ? hoso.fiEmailDn : 'company@gmail.com');

        self.fiTenNdd(hoso.hasOwnProperty('fiTenNdd') ? hoso.fiTenNdd : 'Nguyễn Văn A');
        self.fiSoCmndNdd(hoso.hasOwnProperty('fiSoCmndNdd') ? hoso.fiSoCmndNdd : '123456789');
        self.fiNgaycapCmnd(hoso.hasOwnProperty('fiNgaycapCmnd') ? new Date(hoso.fiNgaycapCmnd) : null);
        self.fiNoiCapCmnd(hoso.hasOwnProperty('fiNoiCapCmnd') ? hoso.fiNoiCapCmnd : 'CA Hà Nội');
        self.fiSdtCodinh(hoso.hasOwnProperty('fiSdtCodinh') ? hoso.fiSdtCodinh : '04.12345678');
        self.fiSdtDd(hoso.hasOwnProperty('fiSdtDd') ? hoso.fiSdtDd : '0987654321');
        self.fiMaMdichNk(hoso.hasOwnProperty('fiMaMdichNk') ? hoso.fiMaMdichNk : fiMucDichNhapKhau());

        self.fiTenMdichNk(hoso.hasOwnProperty('fiTenMdichNk') ? hoso.fiTenMdichNk : null);

        self.fiHoatdong(1);
        self.fiNguoitao(hoso.hasOwnProperty('fiNguoitao') ? hoso.fiNguoitao : null);
        self.fiNgaytao(hoso.hasOwnProperty('fiNgaytao') ? new Date(hoso.fiNgaytao) : null);
        self.fiNgCapnhat(hoso.hasOwnProperty('fiNgCapnhat') ? hoso.fiNgCapnhat : null);
        self.fiTrangthai(hoso.hasOwnProperty('fiTrangthai') ? hoso.fiTrangthai : 0);
        self.fiTenTt(hoso.hasOwnProperty('fiTenTt') ? hoso.fiTenTt : null);
        self.fiNgaynop(hoso.hasOwnProperty('fiNgaynop') ? new Date(hoso.fiNgaynop) : null);
        self.fiSoGp(hoso.hasOwnProperty('fiSoChungnhan') ? hoso.fiSoChungnhan : null);
        self.fiNgaycapGp(hoso.hasOwnProperty('fiNgaycapGcn') ? new Date(hoso.fiNgaycapGcn) : null);
        self.fiMaThutuc(hoso.hasOwnProperty('fiMaThutuc') ? hoso.fiMaThutuc : data.maThuTuc);
        self.fiTenThutuc(hoso.hasOwnProperty('fiTenThutuc') ? hoso.fiTenThutuc : null);

        self.lstHangHoas(mapTbdhsHanghoa1(data.hasOwnProperty('hoso') ? hoso.lstHangHoas : []));
        self.hosoErrors.showAllMessages(false);
    };


    self.init(hosoInfo);

    self.onAddProduct = function () {
        self.lstHangHoas.push(new TbdhsHanghoa1({
            fiStt: self.lstHangHoas().length + 1,
            fiIdHanghoa: -1 * new Date().getTime(),
            fiIdHoso: self.fiIdHoso(),
            fiTenCp: null,
            fiHamLuong: null,
            fiTacDungCp: null,
            fiDviTinh: null,
            fiSoLuong: null,
            fiTenNsx: null
        }));
        return false;
    };

    self.onDeleteProduct = function (item) {
        delete self.popConfirm;
        self.popConfirm = app.popup({
            title: 'Thông báo',
            html: '<b>Bạn chắc chắn muốn xoá dữ liệu này?</b>',
            width: 450,
            buttons: [
                {
                    name: NSWLang["common_button_toi_chac_chan"],
                    class: 'btn',
                    icon: 'fa-save',
                    action: function () {
                        self.lstHangHoas.remove(function (o) {
                            return o.fiIdHanghoa() == item.fiIdHanghoa();
                        });
                        for (var i = 0; i < self.lstHangHoas().length; i++) {
                            self.lstHangHoas()[i].fiStt(i + 1);
                        }
                        app.popupRemove(self.popConfirm.selector);
                        delete self.popConfirm;
                    }
                },
                {
                    name: 'Đóng',
                    class: 'btn',
                    icon: 'fa-close',
                    action: function () {
                        app.popupRemove(self.popConfirm.selector);
                        delete self.popConfirm;
                    }
                }
            ]
        });
        return false;
    };

    self.onFiMaTinhChange = function () {
        if (self.fiMaTinh()) {

            self.fiTenTinh(null);

            var index = self.lstTinhThanh.firstIndexOf(function (item) {
                return item.id == self.fiMaTinh();
            });

            if (index >= 0) {
                self.fiTenTinh(self.lstTinhThanh()[index].name);
            }

            app.getCategory('/moh/07/danhmuc', 'DANHMUC_QUANHUYEN', self.fiMaTinh(), function (res) {
                if (res.success) {
                    self.lstQuanHuyen(mapCategory(null != res.data ? res.data : [], "fiMaQuan", "fiTenQuan"));
                } else {
                    self.lstQuanHuyen([]);
                }
            });
        }
    };

    self.onFiMaDvNhanChange = function () {
        if (self.fiMaDvNhan()) {
            self.fiTenDvNhan(null);
            var index = self.lstDonViNhan.firstIndexOf(function (item) {
                return item.id == self.fiMaDvNhan();
            });
            if (index >= 0) {
                self.fiTenDvNhan(self.lstDonViNhan()[index].name);
            }
        }
    };

    self.onFiMaQuanChange = function () {
        if (self.fiMaQuan()) {
            self.fiTenQuan(null);
            var index = self.lstQuanHuyen.firstIndexOf(function (item) {
                return item.id == self.fiMaQuan();
            });
            if (index >= 0) {
                self.fiTenQuan(self.lstQuanHuyen()[index].name);
            }
        }
    };

    self.isValidForm = function () {

        var errorHangHoa = true;
        
        if (self.hosoErrors().length > 0) {
            self.hosoErrors.showAllMessages();
            return false;
        }
        
        if(!self.fiNgaycapCmnd()) {
            return false;
        }

        if (self.lstHangHoas().length <= 0) {
            self.errorHangHoaMessage('Thông tin chế phẩm yêu cầu phải nhập.');
            return false;
        }

        if (self.lstHangHoas() && self.lstHangHoas().length > 0) {
            for (var i = 0; i < self.lstHangHoas().length; i++) {
                var product = self.lstHangHoas()[i];
                if (!product.fiTenCp()
                        || !product.fiHamLuong()
                        || !product.fiTacDungCp()
                        || !product.fiDviTinh()
                        || !product.fiSoLuong()
                        || !product.fiTenNsx()) {
                    self.errorHangHoaMessage('Thông tin chi tiết chế phẩm yêu cầu phải nhập đầy đủ.');
                    errorHangHoa = false;
                    break;
                }
            }

            if (!errorHangHoa)
                return errorHangHoa;
            else {
                self.errorHangHoaMessage(null);
            }
        }

        return true;
    };

    self.toJSON = function () {
        var hosoJs = {
            fiIdHoso: self.fiIdHoso(),
            fiMaHoso: self.fiMaHoso(),
            fiSoVbDn: self.fiSoVbDn(),
            fiMaDvNhan: self.fiMaDvNhan(),
            fiTenDvNhan: self.fiTenDvNhan(),
            fiMstDn: self.fiMstDn(),
            fiTenDn: self.fiTenDn(),
            fiDiachiDn: self.fiDiachiDn(),
            fiTenTinh: self.fiTenTinh(),
            fiMaTinh: self.fiMaTinh(),
            fiTenQuan: self.fiTenQuan(),
            fiMaQuan: self.fiMaQuan(),
            fiLoaihinh: self.fiLoaihinh(),
            fiPbanQuanly: self.fiPbanQuanly(),
            fiTenDnEn: self.fiTenDnEn(),
            fiTenVtat: self.fiTenVtat(),
            fiSoDkkd: self.fiSoDkkd(),
            fiNamTlap: self.fiNamTlap(),
            fiWebDn: self.fiWebDn(),
            fiSdtDn: self.fiSdtDn(),
            fiFaxDn: self.fiFaxDn(),
            fiEmailDn: self.fiEmailDn(),
            fiTenNdd: self.fiTenNdd(),
            fiSoCmndNdd: self.fiSoCmndNdd(),
            fiNgaycapCmnd: self.fiNgaycapCmnd(),
            fiNoiCapCmnd: self.fiNoiCapCmnd(),
            fiSdtCodinh: self.fiSdtCodinh(),
            fiSdtDd: self.fiSdtDd(),
            fiMaMdichNk: self.fiMaMdichNk(),
            fiTenMdichNk: $('#fiMaMdichNk option:selected').text(),

            fiHoatdong: self.fiHoatdong(),
            fiNguoitao: self.fiNguoitao(),
            fiNgaytao: self.fiNgaytao(),
            fiNgCapnhat: self.fiNgCapnhat(),
            fiTrangthai: self.fiTrangthai(),
            fiTenTt: self.fiTenTt(),
            fiNgaynop: self.fiNgaynop(),
            fiSoGp: self.fiSoGp(),
            fiNgaycapGp: self.fiNgaycapGp(),
            fiMaThutuc: data.maThuTuc,
            fiTenThutuc: self.fiTenThutuc(),
            lstHangHoas: ko.toJS(self.lstHangHoas()),
            lstDinhKems: [],
            lstThanhToans: []
        };

        return hosoJs;
    };

    ko.bindingHandlers.datepicker = {
        init: function (element, valueAccessor, allBindingsAccessor) {
            var options = allBindingsAccessor().datepickerOptions || {};

            $(element).datepicker(options);

            //handle the field changing
            ko.utils.registerEventHandler(element, "change", function () {
                var observable = valueAccessor();
                observable($(element).datepicker("getDate"));
            });

            //handle disposal (if KO removes by the template binding)
            ko.utils.domNodeDisposal.addDisposeCallback(element, function () {
                $(element).datepicker("destroy");
            });

        },
        update: function (element, valueAccessor) {
            var value = ko.utils.unwrapObservable(valueAccessor()),
                    $el = $(element);

            //handle date data coming via json from Microsoft
            if (String(value).indexOf('/Date(') == 0) {
                value = new Date(parseInt(value.replace(/\/Date\((.*?)\)\//gi, "$1")));
            }

            var current = $el.datepicker("getDate");

            if (value - current !== 0) {
                $el.datepicker("setDate", value);
            }
        }
    };
    ko.validation.makeBindingHandlerValidatable('datepicker');
}
