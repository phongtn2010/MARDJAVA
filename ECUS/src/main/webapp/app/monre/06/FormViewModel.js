/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function Monre06FormVM(options)
{
    var self = this;

    var hosoInfo = (options !== null && options.hasOwnProperty('hoso')) ? options.hoso : null;

    self.fiIdHoso = ko.observable(null);
    self.fiMaHoso = ko.observable(null);

    self.fiMaCqCap = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 50 ký tự', params: 50}
    });
    self.fiTenCqCap = ko.observable(null);
    self.fiMstDn = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 13 ký tự', params: 13}
    });
    self.fiTenDn = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 100 ký tự', params: 100}
    });
    self.fiDiachiTsc = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 100 ký tự', params: 100}
    });
//    self.fiDtDn = ko.observable(null).extend({
//        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
//        maxLength: {message: 'Tối đa 500 ký tự', params: 50}
//    });

    self.fiNgDaidien = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 100 ký tự', params: 100}
    });
    self.fiNgLienhe = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiChvuNgLh = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 50 ký tự', params: 50}
    });
    self.fiSdtNgLh = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 50 ký tự', params: 50}
    });
    self.fiFaxNgLh = ko.observable(null).extend({
        maxLength: {message: 'Tối đa 50 ký tự', params: 50}
    });
    self.fiEmailNgLh = ko.observable(null).extend({
        maxLength: {message: 'Tối đa 50 ký tự', params: 50}
    });

    self.fiSoGcn = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 100 ký tự', params: 100}
    });
    self.fiNgaycapGcn = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiCqCapGcn = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiHieuluctungay = ko.observable(null);
    self.fiHieulucdenngay = ko.observable(null);
    self.fiHinhthuc = ko.observable(0);

    self.fiTenPlNk = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 2000 ký tự', params: 2000}
    });
    self.fiXuatxuPl = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiTenTcxk = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 500 ký tự', params: 500}
    });
    self.fiCangXk = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiCuakhauNk = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiTgDukien = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });

    self.fiHoatdong = ko.observable(null);
    self.fiNguoitao = ko.observable(null);
    self.fiNgaytao = ko.observable(null);
    self.fiNgCapnhat = ko.observable(null);
    self.fiTrangthai = ko.observable(0);
    self.fiTenTt = ko.observable(null);
    self.fiSoTbNk = ko.observable(null);
    self.fiNgaycapTb = ko.observable(null);

    //Remove from toJSON
    self.lstCuaKhau = ko.observableArray(options ? options.lstCuaKhau : []);
    //Remove from toJSON
    self.lstDonViXuLy = ko.observableArray(options ? options.lstDonViXuLy : []);
    //Remove from toJSON
    self.dsLoaiPheLieu = ko.observableArray(null);
    //Remove from toJSON
    self.lstLoHang = ko.observableArray([]);

    self.lstLoaiPheLieu = ko.observableArray([]);

    var hosoVG = [self.fiTenDn, self.fiMaCqCap, self.fiMstDn, self.fiDiachiTsc, self.fiDtDn, self.fiNgDaidien
                , self.fiNgLienhe, self.fiChvuNgLh, self.fiSdtNgLh, self.fiSoGcn, self.fiNgaycapGcn, self.fiCqCapGcn,
        self.fiTenPlNk, self.fiXuatxuPl, self.fiTenTcxk, self.fiCangXk, self.fiCuakhauNk, self.fiTgDukien];
    //Remove from toJSON
    self.hosoErrors = ko.validation.group(hosoVG, {deep: true, live: true, observable: true});

    //Thong tin lo hang
    self.fiIdLohang = ko.observable(null);//Remove from toJSON
    self.fiIdpl = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });//Remove from toJSON
    self.fiTenloaiPl = ko.observable(null);//Remove from toJSON
    self.fiMaHs = ko.observable(null);//Remove from toJSON
    self.fiLhTen = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });//Remove from toJSON
    self.fiLhTgian = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });//Remove from toJSON
    self.fiLhMaCuakhau = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });//Remove from toJSON
    self.fiLhTenCuakhau = ko.observable(null);//Remove from toJSON
    self.fiLhKluong = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        number: {message: 'Giá trị nhập vào phải là số', params: true},
        pattern: {
            message: 'Phải nhập giá trị với tối đa 3 số ở phần thập phân ví dụ: 1.234',
            params: '^[0-9]{0,15}(?:\.[0-9]{0,3})?$'
        }
    });//Remove from toJSON
    self.fiKhoiLuongDuocPhep = ko.observable(null);//Remove from toJSON
    self.fiKhoiLuongConLai = ko.computed(function () {
        if (self.fiLhKluong()) {
            var len = self.lstLoHang().length;
            var tongKlDaDung = parseFloat(self.fiLhKluong());
            var item = null;

            for (var i = 0; i < len; i++) {
                item = self.lstLoHang()[i];
                if (item.fiIdpl() == self.fiIdpl()) {
                    tongKlDaDung += parseFloat(item.fiLhKluong());
                }
            }

            var num = self.fiKhoiLuongDuocPhep() - tongKlDaDung;
            num = isNaN(num) ? null : num < 0 ? null : num;
            return num;
        }
        return null;
    }, this);//Remove from toJSON

    var lohangVG = [self.fiIdpl, self.fiLhTen, self.fiLhTgian, self.fiLhMaCuakhau, self.fiLhKluong];
    self.lohangErrors = ko.validation.group(lohangVG, {deep: true, live: true, observable: true});//Remove from toJSON
    self.errorThongTinPheLieuMessage = ko.observable(null);
    //Remove from toJSON
    self.fiLhIdLoaiPlChange = function () {

        if (self.dsLoaiPheLieu()) {

            self.fiMaHs(null);
            self.fiKhoiLuongDuocPhep(null);

            var index = self.dsLoaiPheLieu.firstIndexOf(function (item) {
                return item.fiIdpl == self.fiIdpl();
            });

            if (index >= 0) {
                self.fiMaHs(self.dsLoaiPheLieu()[index].fiMahs);
                self.fiTenloaiPl(self.dsLoaiPheLieu()[index].fiTenphelieu);
                self.fiKhoiLuongDuocPhep(self.dsLoaiPheLieu()[index].fiKhoiluong6);
            }
        }
    };

    self.fiLhMaCuakhauChange = function () {

        if (self.lstCuaKhau()) {

            self.fiLhTenCuakhau(null);

            var index = self.lstCuaKhau.firstIndexOf(function (item) {
                return item.gateCode == self.fiLhMaCuakhau();
            });

            if (index >= 0) {
                self.fiLhTenCuakhau(self.lstCuaKhau()[index].gateName);
            }
        }
    };

    //Remove from toJSON
    self.getGiayXacNhan01 = function (gxn, cb) {
        if (!gxn) {
            app.Alert('Thông tin số giấy xác nhận chưa được cung cấp.');
            return;
        }
        //Neu chon lai GXN thi hien thi confirm xac nhan su thay doi de xoa thong tin hang hoa

        app.makePost({
            url: '/monre/06/hoso/gxn01/' + gxn,
            data: JSON.stringify({}),
            success: function (d) {
                if (d && d.success) {
                    var gxn = d.data;
                    self.fiNgaycapGcn(gxn ? new Date(gxn.fiNgayky) : null);
                    self.fiCqCapGcn(gxn ? gxn.fiCoquancap : null);
                    self.fiHieulucdenngay(gxn ? new Date(gxn.fiHieulucdenngay) : null);
                    self.fiHieuluctungay(gxn ? new Date(gxn.fiHieuluctungay) : null);
                    self.dsLoaiPheLieu(gxn ? gxn.lstThongtinphelieu : []);
                    if (cb) {
                        cb();
                    }
                } else {
                    app.Alert('Không tìm thấy dữ liệu giấy xác nhận này.');
                }
            },
            error: function (e) {
                app.Alert('Không tìm thấy dữ liệu giấy xác nhận này.');
            }
        });
    };

    self.getThongTinPheLieu = function (id) {
        if (self.dsLoaiPheLieu) {
            var index = self.dsLoaiPheLieu.firstIndexOf(function (item) {
                return item.fiIdpl == id;
            });

            if (index >= 0) {
                return self.dsLoaiPheLieu()[index];
            }
        }
        return null;
    };

    /**
     * Khoi tao du lieu tu data tra ve
     * @param {type} data
     * @returns {undefined}
     */
    self.initPheLieu = function (data) {
        var len = data.length;
        var plItem = null;
        var plLohang = null;
        var len2 = 0;
        var pheLieu = null;
        for (var i = 0; i < len; i++) {
            plItem = data[i];
            if (plItem.lstLohangPheLieu) {
                len2 = plItem.lstLohangPheLieu.length;
                for (var j = 0; j < len2; j++) {
                    plLohang = plItem.lstLohangPheLieu[j];
                    pheLieu = self.getThongTinPheLieu(plItem.fiIdpl);
                    if (pheLieu) {
                        self.lstLoHang.push(new TbdlohangVM(self.lstLoHang().length + 1, {
                            fiIdLohang: -1 * new Date().getTime(),
                            fiMaHs: plItem.fiMaHs,
                            fiKhoiLuongDuocPhep: pheLieu.fiKhoiluong6,
                            fiKhoiLuongConLai: pheLieu.fiKhoiluong6 - plLohang.fiLhKluong,
                            fiLhTen: plLohang.fiLhTen,
                            fiLhTgian: plLohang.fiLhTgian ? new Date(plLohang.fiLhTgian) : new Date(),
                            fiLhMaCuakhau: plLohang.fiLhMaCuakhau,
                            fiLhTenCuakhau: plLohang.fiLhTenCuakhau,
                            fiLhKluong: plLohang.fiLhKluong,
                            fiIdHoso: plItem.fiIdHoso,
                            fiIdpl: plItem.fiIdpl,
                            fiTenloaiPl: plItem.fiTenloaiPl
                        }));
                    }
                }
            }
        }
    };

    //Thong tin lo hang
    //Remove from toJSON    
    self.init = function (hoso) {
        self.fiTenDn(hoso !== null && hoso.hasOwnProperty('fiTenDn') ? hoso.fiTenDn : user.companyName);
        self.fiMstDn(hoso !== null && hoso.hasOwnProperty('fiMstDn') ? hoso.fiMstDn : user.username);
        self.fiDiachiTsc(hoso !== null && hoso.hasOwnProperty('fiDiachiTsc') ? hoso.fiDiachiTsc : user.companyAddress);
        //self.fiDtDn(hoso !== null && hoso.hasOwnProperty('fiDtDn') ? hoso.fiDtDn : user.companyPhoneNumber);
        self.fiNgDaidien(hoso !== null && hoso.hasOwnProperty('fiNgDaidien') ? hoso.fiNgDaidien : null);
        if (hoso !== null) {
            self.fiNgLienhe(hoso !== null && hoso.hasOwnProperty('fiNgLienhe') ? hoso.fiNgLienhe : null);
            self.fiChvuNgLh(hoso !== null && hoso.hasOwnProperty('fiChvuNgLh') ? hoso.fiChvuNgLh : null);
            self.fiSdtNgLh(hoso !== null && hoso.hasOwnProperty('fiSdtNgLh') ? hoso.fiSdtNgLh : null);
            self.fiFaxNgLh(hoso !== null && hoso.hasOwnProperty('fiFaxNgLh') ? hoso.fiFaxNgLh : null);
            self.fiEmailNgLh(hoso !== null && hoso.hasOwnProperty('fiEmailNgLh') ? hoso.fiEmailNgLh : null);

            self.fiIdHoso(hoso.hasOwnProperty('fiIdHoso') ? hoso.fiIdHoso : null);
            self.fiMaHoso(hoso.hasOwnProperty('fiMaHoso') ? hoso.fiMaHoso : null);
            self.fiMaCqCap(hoso.hasOwnProperty('fiMaCqCap') ? hoso.fiMaCqCap : null);
            self.fiTenCqCap(hoso.hasOwnProperty('fiTenCqCap') ? hoso.fiTenCqCap : null);

            self.fiSoGcn(hoso.hasOwnProperty('fiSoGcn') ? hoso.fiSoGcn : 0);
            self.fiNgaycapGcn(hoso.hasOwnProperty('fiNgaycapGcn') ? new Date(hoso.fiNgaycapGcn) : null);
            self.fiCqCapGcn(hoso.hasOwnProperty('fiCqCapGcn') ? hoso.fiCqCapGcn : null);
            self.fiHieulucdenngay(hoso.hasOwnProperty('fiHieulucdenngay') ? new Date(hoso.fiHieulucdenngay) : null);
            self.fiHieulucdenngay(hoso.hasOwnProperty('fiHieulucdenngay') ? new Date(hoso.fiHieulucdenngay) : null);
            self.fiHinhthuc(hoso.hasOwnProperty('fiHinhthuc') ? hoso.fiHinhthuc : 0);

            self.fiTenPlNk(hoso.hasOwnProperty('fiTenPlNk') ? hoso.fiTenPlNk : null);
            self.fiXuatxuPl(hoso.hasOwnProperty('fiXuatxuPl') ? hoso.fiXuatxuPl : null);
            self.fiTenTcxk(hoso.hasOwnProperty('fiTenTcxk') ? hoso.fiTenTcxk : null);
            self.fiCangXk(hoso.hasOwnProperty('fiCangXk') ? hoso.fiCangXk : null);
            self.fiCuakhauNk(hoso.hasOwnProperty('fiCuakhauNk') ? hoso.fiCuakhauNk : null);
            self.fiTgDukien(hoso.hasOwnProperty('fiTgDukien') ? new Date(hoso.fiTgDukien) : null);

            self.fiHoatdong(hoso.hasOwnProperty('fiHoatdong') ? hoso.fiHoatdong : null);
            self.fiNguoitao(hoso.hasOwnProperty('fiNguoitao') ? hoso.fiNguoitao : null);
            self.fiNgaytao(hoso.hasOwnProperty('fiNgaytao') ? new Date(hoso.fiNgaytao) : null);
            self.fiNgCapnhat(hoso.hasOwnProperty('fiNgCapnhat') ? hoso.fiNgCapnhat : null);
            self.fiTrangthai(hoso.hasOwnProperty('fiTrangthai') ? hoso.fiTrangthai : null);
            self.fiTenTt(hoso.hasOwnProperty('fiTenTt') ? hoso.fiTenTt : null);
            self.fiSoTbNk(hoso.hasOwnProperty('fiSoTbNk') ? hoso.fiSoTbNk : null);
            self.fiNgaycapTb(hoso.hasOwnProperty('fiNgaycapTb') ? hoso.fiNgaycapTb : null);

            if (self.fiSoGcn()) {
                self.getGiayXacNhan01(self.fiSoGcn(), function () {
                    if (hoso.lstLoaiPheLieu) {
                        self.initPheLieu(hoso.lstLoaiPheLieu);
                    }
                });
            }
        }

        if (!self.fiMaCqCap()) {
            self.fiMaCqCap('000');
        }

        $("#fiMaCqCap").val(self.fiMaCqCap()).select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
    };

    self.init(hosoInfo);
    //VALIDATE DATA ON FORM
    //Remove from toJSON
    self.isValidForm = function () {
        console.log(self.hosoErrors());
        if (self.hosoErrors().length > 0) {
            self.hosoErrors.showAllMessages();
            return false;
        }

        var errorHanghoa = false;

        if (!self.lstLoHang() || self.lstLoHang().length <= 0) {
            self.errorThongTinPheLieuMessage('* Chưa khai báo thông tin lô hàng');
            return errorHanghoa;
        }

        if (self.lstLoHang() && self.lstLoHang().length > 0) {
            for (var i = 0; i < self.lstLoHang().length; i++) {
                var hh = self.lstLoHang()[i];
                if (!hh.fiIdpl() || !hh.fiMaHs() || !hh.fiLhTen() || !hh.fiLhTgian() || !hh.fiLhMaCuakhau() || !hh.fiLhKluong()) {
                    errorHanghoa = true;
                    break;
                }
            }
        }

        if (errorHanghoa) {
            self.errorThongTinPheLieuMessage('* Bổ sung thêm thông tin của lô hàng trước khi lưu dữ liệu');
        }



        return self.hosoErrors().length <= 0 && !errorHanghoa;
    };
    //VALIDATE DATA ON FORM

    //XU LY SU KIEN BUTTON, TABLE
    //Remove from toJSON
    self.btnThemLoHang = function () {
        if (self.lohangErrors().length > 0) {
            self.lohangErrors.showAllMessages();
            return;
        }
        if (!self.fiIdLohang()) {
            var lohang = new TbdlohangVM(self.lstLoHang().length + 1, {
                fiIdLohang: -1 * new Date().getTime(),
                fiMaHs: self.fiMaHs(),
                fiKhoiLuongDuocPhep: self.fiKhoiLuongDuocPhep(),
                fiKhoiLuongConLai: self.fiKhoiLuongConLai(),
                fiLhTen: self.fiLhTen(),
                fiLhTgian: self.fiLhTgian(),
                fiLhMaCuakhau: self.fiLhMaCuakhau(),
                fiLhTenCuakhau: self.fiLhTenCuakhau(),
                fiLhKluong: self.fiLhKluong(),
                fiIdHoso: self.fiIdHoso(),
                fiIdpl: self.fiIdpl(),
                fiTenloaiPl: self.fiTenloaiPl()
            });
            self.lstLoHang.push(lohang);
        } else {
            var index = self.lstLoHang.firstIndexOf(function (item) {
                return item.fiIdLohang() == self.fiIdLohang();
            });

            if (index >= 0) {
                self.lstLoHang()[index].fiMaHs(self.fiMaHs());
                self.lstLoHang()[index].fiKhoiLuongDuocPhep(self.fiKhoiLuongDuocPhep());
                self.lstLoHang()[index].fiKhoiLuongConLai(self.fiKhoiLuongConLai());
                self.lstLoHang()[index].fiLhTen(self.fiLhTen());
                self.lstLoHang()[index].fiLhTgian(self.fiLhTgian());
                self.lstLoHang()[index].fiLhMaCuakhau(self.fiLhMaCuakhau());
                self.lstLoHang()[index].fiLhTenCuakhau(self.fiLhTenCuakhau());
                self.lstLoHang()[index].fiLhKluong(self.fiLhKluong());
                self.lstLoHang()[index].fiIdHoso(self.fiIdHoso());
                self.lstLoHang()[index].fiIdpl(self.fiIdpl());
                self.lstLoHang()[index].fiTenloaiPl(self.fiTenloaiPl());
            }
        }

        self.resetLoHangForm();
    };
    //Remove from toJSON
    self.bSuaLoHangClick = function (item) {
        if (item) {
            self.fiIdLohang(item.fiIdLohang());
            self.fiIdpl(item.fiIdpl());
            self.fiTenloaiPl(item.fiTenloaiPl());
            self.fiMaHs(item.fiMaHs());
            self.fiLhTen(item.fiLhTen());
            self.fiLhTgian(item.fiLhTgian());
            self.fiLhMaCuakhau(item.fiLhMaCuakhau());
            self.fiLhTenCuakhau(item.fiLhTenCuakhau());
            self.fiLhKluong(item.fiLhKluong());
            self.fiKhoiLuongDuocPhep(item.fiKhoiLuongDuocPhep());

            $("#fiLhMaCuakhau").select2('destroy').val(item.fiLhMaCuakhau()).select2({placeholder: '-- Chọn --', width: '200px', allowClear: true});
            $("#fiTenphelieu").select2('destroy').val(item.fiIdpl()).select2({placeholder: '-- Chọn --', width: '200px', allowClear: true});
        }
    };
    //Remove from toJSON
    self.bXoaLoHangClick = function (item) {
        if (item) {
            self.lstLoHang.remove(function (o) {
                return o.fiIdLohang() == item.fiIdLohang();
            });
        }
    };
    //Remove from toJSON
    self.bTimGiayXacNhanClick = function () {
        if (!self.fiSoGcn()) {
            app.Alert('Bạn phải nhập vào số giấy xác nhận!');
            return;
        }
        self.getGiayXacNhan01(self.fiSoGcn());
    };
    //XU LY SU KIEN BUTTON, TABLE

    //HAM XU LY    
    //Remove from toJSON
    self.resetLoHangForm = function () {
        self.fiIdLohang(null);
        self.fiIdpl(null);
        self.fiTenloaiPl(null);
        self.fiMaHs(null);
        self.fiLhTen(null);
        self.fiLhTgian(null);
        self.fiLhMaCuakhau(null);
        self.fiLhTenCuakhau(null);
        self.fiLhKluong(null);
        self.fiKhoiLuongDuocPhep(null);
    };
    //Convert to json object
    self.toJSON = function () {
        var mapping = {
            'ignore': ["resetLoHangForm", "getGiayXacNhan01", "bTimGiayXacNhanClick", "bXoaLoHangClick",
                "bSuaLoHangClick", "btnThemLoHang", "isValidForm", "init", "fiLhMaCuakhauChange", "fiLhIdLoaiPlChange",
                "toJSON", "popup", "__ko_mapping__", "lohangErrors", 'fiKhoiLuongConLai', 'fiKhoiLuongDuocPhep',
                'fiLhKluong', 'fiLhTenCuakhau', 'fiLhMaCuakhau', 'fiLhTgian', 'fiLhTen', 'fiMaHs', 'fiTenloaiPl', 'fiIdpl',
                'fiIdLohang', 'hosoErrors', 'dsLoaiPheLieu', 'lstLoHang', 'lstDonViXuLy', 'lstCuaKhau', 'errorThongTinPheLieuMessage',
                'initPheLieu', 'getThongTinPheLieu']
        };

        //Tao du lieu cho lstLoaiPheLieu tu lstLoHang
        var len = self.lstLoHang().length;
        var index = -1;
        var item = null;
        var lohang = null;

        for (var i = 0; i < len; i++) {
            item = self.lstLoHang()[i];
            index = -1;
            lohang = null;
            if (item) {
                index = self.lstLoaiPheLieu.firstIndexOf(function (lh) {
                    return lh.fiIdpl() == item.fiIdpl();
                });

                if (index < 0) {
                    lohang = new Tbdloaipl6({
                        fiIdLoaiPl: null,
                        fiIdpl: item.fiIdpl(),
                        fiTenloaiPl: item.fiTenloaiPl(),
                        fiMaHs: item.fiMaHs(),
                        fiIdHoso: item.fiIdHoso(),
                        lstLohangPheLieu: []
                    });
                    self.lstLoaiPheLieu.push(lohang);
                } else {
                    self.lstLoaiPheLieu()[index].lstLohangPheLieu([]);
                }
            }
        }

        len = self.lstLoaiPheLieu().length;
        item = null;
        lohang = null;
        var len2 = self.lstLoHang().length;
        var item2 = null;
        for (var i = 0; i < len; i++) {
            item = self.lstLoaiPheLieu()[i];
            for (var j = 0; j < len2; j++) {
                item2 = self.lstLoHang()[j];
                if (item.fiIdpl() == item2.fiIdpl()) {
                    lohang = new Tbdlohangpl6({
                        fiIdLohang: null,
                        fiLhTen: item2.fiLhTen(),
                        fiLhTgian: item2.fiLhTgian(),
                        fiLhMaCuakhau: item2.fiLhMaCuakhau(),
                        fiLhTenCuakhau: item2.fiLhTenCuakhau(),
                        fiLhKluong: item2.fiLhKluong(),
                        fiIdLoaiPl: item.fiIdpl(),
                        fiIdHoso: item2.fiIdHoso()
                    });
                    item.lstLohangPheLieu.push(lohang);
                }
            }
        }

        var copy = ko.mapping.fromJS(self, mapping);
        copy = ko.toJS(copy);

        delete copy['__ko_mapping__'];
        return copy;
    };
}
