/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function FormVM(options) {
    debugger
    var self = this;
    var hosoInfo = (options !== null && options.hasOwnProperty('hoso')) ? options.hoso : null;

    self.fiIdHoso = ko.observable(null);
    self.fiMaHoso = ko.observable(null);
    self.fiNgaygui = ko.observable(null);
    self.fiTenTt = ko.observable(null);
    self.fiTrangthai = ko.observable(null);
    self.fiHoatdong = ko.observable(null);

    self.tbdDoanhnghiep02 = ko.observable(null);
    self.tbdLydo02 = ko.observable(null);
    self.tbdNguoilienhe02 = ko.observable(null);
    self.tbdDonhang02List = ko.observableArray([]);
    self.tbdDinhkem02List = ko.observableArray([]);

    self.lstDvTinh = ko.observableArray(mapCategory(options.hasOwnProperty('lstDvTinh') ? options.lstDvTinh : [], "code", "name"));
    self.lstHinhthuc = ko.observableArray(mapCategory(options.hasOwnProperty('lstHinhthuc') ? options.lstHinhthuc : [], "code", "name"));
    self.lstVanchuyen = ko.observableArray(mapCategory(options.hasOwnProperty('lstVanchuyen') ? options.lstVanchuyen : [], "code", "name"));
    self.lstQuocgia = ko.observableArray(mapCategory(options.hasOwnProperty('lstQuocgia') ? options.lstQuocgia : [], "quocgiaCode", "quocgiaName"));

    var hosoVG = [];
    self.hosoErrors = ko.validation.group(hosoVG, {deep: true, live: true, observable: true});
    self.errorDinhKemMessage = ko.observable(null);

    //Khoi tao gia tri ho so
    self.init = function (hoso) {
        if (hoso !== null) {
            self.fiIdHoso(hoso.hasOwnProperty('fiIdHoso') ? hoso.fiIdHoso : null);
            self.fiMaHoso(hoso.hasOwnProperty('fiMaHoso') ? hoso.fiMaHoso : null);
            self.fiNgaygui(hoso.hasOwnProperty('fiNgaygui') ? new Date(hoso.fiNgaygui) : null);
            self.fiTenTt(hoso.hasOwnProperty('fiTenTt') ? hoso.fiTenTt : null);
            self.fiTrangthai(hoso.hasOwnProperty('fiTrangthai') ? hoso.fiTrangthai : null);
            self.fiHoatdong(hoso.hasOwnProperty('fiHoatdong') ? hoso.fiHoatdong : null);
            var DNotp = {
                doanhNghiep02: hoso.hasOwnProperty('tbdDoanhnghiep02') ? hoso.tbdDoanhnghiep02 : null
            };
            self.tbdDoanhnghiep02(new DoanhNghiep02FormVM(DNotp, hoso));
            var LyDoOtp = {
                lyDo02: hoso.hasOwnProperty('tbdLydo02') ? hoso.tbdLydo02 : null
            };
            self.tbdLydo02(new LyDo02FormVM(LyDoOtp));
            var NguoiLHOtp = {
                nguoiLH02: hoso.hasOwnProperty('tbdNguoilienhe02') ? hoso.tbdNguoilienhe02 : null
            };
            self.tbdNguoilienhe02(new NguoiLH02FormVM(NguoiLHOtp));

            self.tbdDonhang02List(mapHanghoa02(hoso.hasOwnProperty('tbdDonhang02List') ? hoso.tbdDonhang02List : []));

            // self.tbdDinhkem02List(mapFiles02VM(hoso.hasOwnProperty('tbdDinhkem02List') ? hoso.tbdDinhkem02List : [], self.fiIdHoso()));
            var lstFiles = hoso.hasOwnProperty('tbdDinhkem02List') ? hoso.tbdDinhkem02List : [];
            var groups = {};
            for (var i = 0; i < lstFiles.length; i++) {
                var file = lstFiles[i];
                var groupName = file.fiTenLoaiTl;
                if (!groups[groupName]) {
                    groups[groupName] = {
                        fiIdHoso: file.fiIdHoso,
                        fiLoaiTailieu: file.fiLoaiTailieu,
                        fiTenLoaiTl: file.fiTenLoaiTl,
                        fiTenTailieu: file.fiTenTailieu,
                        fiBatbuoc: file.fiBatbuoc,
                        fiIdDinhkem: file.fiIdDinhkem,
                        fiDuongdanTl: file.fiDuongdanTl,
                        fiHoatdong: file.fiHoatdong,
                        fiNguoitao: file.fiNguoitao,
                        fiNgaytao: file.fiNgaytao,
                        fiNgCapnhat: file.fiNgCapnhat,
                        fiSize: file.fiSize,
                        lstFiles: []
                    };
                }
                var cc = {
                    fiIdDinhkem: file.fiIdDinhkem,
                    fiTenTailieu: file.fiTenTailieu,
                    fiDuongdanTl: file.fiDuongdanTl,
                    fiSize: file.fiSize
                };
                if (cc.fiTenTailieu != null) {
                    groups[groupName].lstFiles.push(cc);
                }
            }
            lstFiles = [];
            for (var groupName in groups) {
                lstFiles.push(groups[groupName]);
            }
            self.tbdDinhkem02List(mapFiles02VM(lstFiles, self.fiIdHoso()));
        } else {
            self.tbdDoanhnghiep02(new DoanhNghiep02FormVM(options, hoso));
            self.tbdLydo02(new LyDo02FormVM(options));
            self.tbdNguoilienhe02(new NguoiLH02FormVM(options));
            getDmTeptin();
        }
    };

    function getDmTeptin() {
        app.getCategory('/moh/p02/danhmuc', 'DM_TEPTIN', null, function (res) {
            if (res.success) {
                self.tbdDinhkem02List(mapFiles02VM(res.data, self.fiIdHoso()));
            } else {
                self.tbdDinhkem02List([]);
            }
        });
    }

    self.init(hosoInfo);

//VALIDATE DATA ON FORM
//Convert to json object

    self.validFile = function () {
        var errorDinhkem = true;
        if (!self.tbdDinhkem02List() || self.tbdDinhkem02List().length <= 0) {
            errorDinhkem = false;
        } else {
            self.errorDinhKemMessage(null);
        }
        if (self.tbdDinhkem02List() && self.tbdDinhkem02List().length > 0) {
            for (var i = 0; i < self.tbdDinhkem02List().length; i++) {
                var attach = self.tbdDinhkem02List()[i];
                if (attach.isRequire()) {
                    if (!attach.lstFiles().length) {
                        $("#valid_dinhKem").show();
                        errorDinhkem = false;
                        break;
                    }
                }
            }
        }
        return errorDinhkem;

    };

    self.isValidForm = function () {
        //Kiem tra thong tin Ho so
        var errorHoso = true;
        if (!self.tbdDoanhnghiep02().isValidDn()) {
            errorHoso = false;
        }
        if (!self.tbdLydo02().isValidLydo()) {
            errorHoso = false;
        }
        if (!self.tbdNguoilienhe02().isValidNguoiLH02()) {
            errorHoso = false;
        }
        if (!self.tbdDonhang02List() || self.tbdDonhang02List().length <= 0) {
            $('#hanghoa_valid').show();
            errorHoso = false;
        } else {
            $('#hanghoa_valid').hide();
        }
        if (!self.validFile()) {
            errorHoso = false;
        }
        if (self.hosoErrors().length > 0) {
            self.hosoErrors.showAllMessages();
            errorHoso = false;
        }
        return errorHoso;
    };

    self.toJSON = function () {
        var mapping = {

            ignore: ['init', 'isValidForm', 'pop', 'toJSON', 'fiStt',
                'hosoErrors', 'errorDinhKemMessage', 'canTemp', 'canDeleteTemp',
                'doDeleteTemp', 'btnAddNewClickDH', 'editDonHangClick', 'popupHangHoa', 'removeDonHangClick']
        };
        var copy = ko.mapping.fromJS(self, mapping);
        copy = ko.toJS(copy);

        var fileArr = [];
        for (var i = 0; i < copy.tbdDinhkem02List.length; i++) {
            var fileObj = copy.tbdDinhkem02List[i];
            if (fileObj.lstFiles.length === 0) {
                var obj = {
                    fiIdHoso: fileObj.fiIdHoso,
                    fiLoaiTailieu: fileObj.fiLoaiTailieu,
                    fiTenLoaiTl: fileObj.fiTenLoaiTl,
                    fiTenTailieu: null,
                    fiBatbuoc: fileObj.fiBatbuoc,
                    fiIdDinhkem: null,
                    fiDuongdanTl: null,
                    fiHoatdong: fileObj.fiHoatdong,
                    fiNguoitao: fileObj.fiNguoitao,
                    fiNgaytao: fileObj.fiNgaytao,
                    fiNgCapnhat: fileObj.fiNgCapnhat,
                    fiSize: null
                };
                fileArr.push(obj);
            }
            for (var j = 0; j < fileObj.lstFiles.length; j++) {
                var obj1 = fileObj.lstFiles[j];
                var obj = {
                    fiIdHoso: fileObj.fiIdHoso,
                    fiLoaiTailieu: fileObj.fiLoaiTailieu,
                    fiTenLoaiTl: fileObj.fiTenLoaiTl,
                    fiTenTailieu: obj1.fiTenTailieu,
                    fiBatbuoc: fileObj.fiBatbuoc,
                    fiIdDinhkem: obj1.fiIdDinhkem,
                    fiDuongdanTl: obj1.fiDuongdanTl,
                    fiHoatdong: fileObj.fiHoatdong,
                    fiNguoitao: fileObj.fiNguoitao,
                    fiNgaytao: fileObj.fiNgaytao,
                    fiNgCapnhat: fileObj.fiNgCapnhat,
                    fiSize: obj1.fiSize
                };
                fileArr.push(obj);
            }
        }
        copy.tbdDinhkem02List = [];
        copy.tbdDinhkem02List = fileArr;

        delete copy['__ko_mapping__'];
        return copy;
    };

    //them don hang
    self.btnAddNewClickDH = function () {
        self.popupHangHoa(null, 'add', 'Thêm mới chi tiết đơn hàng');
        return false;
    };
    // sửa đơn hàng
    self.editDonHangClick = function (item) {
        self.popupHangHoa(item, 'edit', 'Sửa chi tiết đơn hàng');
        return false;
    };
    // Xem đơn hàng
    self.viewDonHangClick = function (item) {
        self.popupHangHoa(item, 'view', 'Xem chi tiết đơn hàng');
        return false;
    };

    self.popupHangHoa = function (item, action, title) {
        var html = [
            $('#thongtinhanghoa-template').html()
        ].join('');
        delete self.pop;
        delete self.hangHoaVM;
        options.tbdDonhang02List = item;
        self.hangHoaVM = new HangHoaFormVM(options);
        self.pop = app.popup({
            title: title,
            html: html,
            width: 1024,
            buttons: [
                {
                    name: 'Lưu',
                    class: 'btn btn-save',
                    icon: 'fa-save',
                    action: function () {
                        if (!self.hangHoaVM.isValid()) {
                            app.Alert('Bạn cần nhập đủ dữ liệu các trường BẮT BUỘC <span style="color:red">(*)</span>');
                        } else {
                            var hangHoaInfo = self.hangHoaVM.toJSON();
                            if (null == hangHoaInfo.fiIdDonhang) {
                                hangHoaInfo.fiIdDonhang = -1 * new Date().getTime();
                                var hangHoaModel = new HangHoa02(hangHoaInfo);
                                self.tbdDonhang02List.push(hangHoaModel);
                            } else {
                                for (var i = 0; i < self.tbdDonhang02List().length; i++) {
                                    if (hangHoaInfo.fiIdDonhang == self.tbdDonhang02List()[i].fiIdDonhang()) {
                                        var hangHoaModel = new HangHoa02(hangHoaInfo);
                                        self.tbdDonhang02List.replace(self.tbdDonhang02List()[i], hangHoaModel);
                                        break;
                                    }
                                }
                            }
                            app.popupRemove(self.pop.selector);
                            $('.modal-scrollable').hide();
                            $('.modal-backdrop').hide();
                            $('#hanghoa_valid').hide();
                        }
                    }
                },
                {
                    name: 'Đóng',
                    class: 'btn',
                    icon: 'fa-close',
                    action: function () {
                        app.popupRemove(self.pop.selector);
                        $('.modal-scrollable').hide();
                        $('.modal-backdrop').hide();
                    }
                }
            ]
        });


        if (action == 'view') {
            $(".btn-save").hide();
        }

        ko.applyBindings(self.hangHoaVM, document.getElementById('thongtinhanghoa-vm'));
        $("#fiMaDvTinh").select2({placeholder: '-- Chọn--', width: '100%', allowClear: true});
        $("#fiMaHinhthuc").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
        $("#fiMaVanchuyen").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
        $("#fiMaQuocgia").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
    };

    // xoa don hang tren bang
    self.removeDonHangClick = function (item) {

        if (item) {
            var pop = app.popup({
                title: 'Thông báo',
                html: '<b>Bạn chắc chắn muốn xoá dữ liệu của hàng hóa này?</b>',
                width: 450,
                buttons: [
                    {
                        name: NSWLang["common_button_toi_chac_chan"],
                        class: 'btn',
                        icon: 'fa-save',
                        action: function () {
                            self.tbdDonhang02List.remove(function (o) {
                                return o.fiIdDonhang() == item.fiIdDonhang();
                            });
                            for (var i = 0; i < self.tbdDonhang02List().length; i++) {
                                // self.lstDonhang03()[i].fi(i + 1);
                            }
                            app.popupRemove(pop.selector);
                            if (!self.tbdDonhang02List() || self.tbdDonhang02List().length <= 0) {

                                $('#hanghoa_valid').show();
                            } else {
                                $('#hanghoa_valid').hide();
                            }
                        }
                    },
                    {
                        name: 'Huỷ',
                        class: 'btn',
                        icon: 'fa-close',
                        action: function () {
                            app.popupRemove(pop.selector);
                        }
                    }
                ]
            });
        }

    }
}
;

function HangHoaFormVM(options) {
    var self = this;
    var hanghoa = options.tbdDonhang02List;

    self.isViewTenHinhthucKhac = ko.observable(false);

    self.fiMaDvTinh = ko.observable(hanghoa ? hanghoa.fiMaDvTinh() : null);
    self.fiTenDvTinh = ko.observable(hanghoa ? hanghoa.fiTenDvTinh() : null);
    self.fiMaHinhthuc = ko.observable(hanghoa ? hanghoa.fiMaHinhthuc() : null);
    self.fiTenHinhthuc = ko.observable(hanghoa ? hanghoa.fiTenHinhthuc() : null);
    self.fiMaVanchuyen = ko.observable(hanghoa ? hanghoa.fiMaVanchuyen() : null);
    self.fiTenVanchuyen = ko.observable(hanghoa ? hanghoa.fiTenVanchuyen() : null);
    self.fiMaQuocgia = ko.observable(hanghoa ? hanghoa.fiMaQuocgia() : null);
    self.fiTenQuocgia = ko.observable(hanghoa ? hanghoa.fiTenQuocgia() : null);

    self.fiIdDonhang = ko.observable(hanghoa ? hanghoa.fiIdDonhang() : null);
    self.fiIdHoso = ko.observable(hanghoa ? hanghoa.fiIdHoso() : null);
    self.fiLoaimau = ko.observable(hanghoa ? hanghoa.fiLoaimau() : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiNguongoc = ko.observable(hanghoa ? hanghoa.fiNguongoc() : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiSoluong = ko.observable(hanghoa ? hanghoa.fiSoluong() : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 10 ký tự', params: 10},
        pattern: {
            message: 'Không được nhập chữ cái, số âm, số thập phân hoặc giá trị bằng 0',
            params: /^([1-9][0-9]*)$/
        }
    });
    self.fiDonviTinh = ko.observable(hanghoa ? hanghoa.fiDonviTinh() : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 50 ký tự', params: 50}
    });
    self.fiHinhthuc = ko.observable(hanghoa ? hanghoa.fiHinhthuc() : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiNoigui = ko.observable(hanghoa ? hanghoa.fiNoigui() : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiNoiNhan = ko.observable(hanghoa ? hanghoa.fiNoiNhan() : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiDuongVanchuyen = ko.observable(hanghoa ? hanghoa.fiDuongVanchuyen() : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiHoatdong = ko.observable(hanghoa ? hanghoa.fiHoatdong() : null);
    self.fiNguoitao = ko.observable(hanghoa ? hanghoa.fiNguoitao() : null);
    self.fiNgaytao = ko.observable(hanghoa ? new Date(hanghoa.fiNgaytao()) : null);
    self.fiNgCapnhat = ko.observable(hanghoa ? new Date(hanghoa.fiNgCapnhat()) : null);

    self.fiHinhthucKhac = ko.observable(hanghoa ? hanghoa.fiHinhthucKhac() : null);

    self.lstDvTinh = options.lstDvTinh;
    self.lstVanchuyen = options.lstVanchuyen;
    self.lstHinhthuc = options.lstHinhthuc;
    self.lstQuocgia = options.lstQuocgia;

    if (self.fiMaHinhthuc() === "4") {
        self.isViewTenHinhthucKhac(true);
    } else {
        self.isViewTenHinhthucKhac(false);
    }

    var hanghoaVG = [self.fiLoaimau, self.fiNguongoc, self.fiSoluong, self.fiNoigui, self.fiNoiNhan, self.fiMaDvTinh, self.fiTenDvTinh, self.fiMaHinhthuc
                        , self.fiTenHinhthuc, self.fiMaVanchuyen, self.fiTenVanchuyen, self.fiTenQuocgia, self.fiMaQuocgia];
    self.hangHoaErrors = ko.validation.group(hanghoaVG, {deep: true, live: true, observable: true});

    self.toJSON = function () {

        var mapping = {
            ignore: ["init", "fiStt", "hangHoaErrors", "isValid", "toJSON", "__ko_mapping__", "validSoluong", "validDonvitinh", "validHinhthuc", "validVanchuyen"]
        };

        var copy = ko.mapping.fromJS(self, mapping);
        copy = ko.toJS(copy);
        delete copy['__ko_mapping__'];
        return copy;
    };

    //tự động cắt số 0 ở đầu số lượng
    self.validSoluong = function () {
        var soluongChuoi = self.fiSoluong().toString();
        var giatriChuyendoi = parseFloat(soluongChuoi, 10);

        if (giatriChuyendoi) {
            self.fiSoluong(giatriChuyendoi);
        }
    };

    self.validDonvitinh = function () {
        var error = true;
        if (self.fiMaDvTinh() === null || self.fiMaDvTinh() === undefined) {
            $("#fiDvTinh-lbl").show();
            error = false;
        } else {
            $("#fiDvTinh-lbl").hide();
        }
        return error;
    };

    self.validQuocgia = function () {
        if(self.fiMaQuocgia() === null || self.fiMaQuocgia() === undefined){
            $("#fiQuocgia-lbl").show();
        } else {
            $("#fiQuocgia-lbl").hide();
        }
    };

    self.validHinhthuc = function () {
        debugger;
        var error = true;
        if (self.fiMaHinhthuc() === null || self.fiMaHinhthuc() === undefined) {
            self.isViewTenHinhthucKhac(false);
            $("#fiHinhthuc-lbl").show();
            error = false;
        } else if(self.fiMaHinhthuc() === "4") {
            self.isViewTenHinhthucKhac(true);
            $("#fiHinhthuc-lbl").hide();
        } else{
            self.isViewTenHinhthucKhac(false);
            $("#fiHinhthuc-lbl").hide();
        }
        return error;
    };

    self.validVanchuyen = function () {
        var error = true;
        if (self.fiMaVanchuyen() === null || self.fiMaVanchuyen() === undefined) {
            $("#fiVanchuyen-lbl").show();
            error = false;
        } else {
            $("#fiVanchuyen-lbl").hide();
        }
        return error;
    };

    self.validTenHtKhac = function() {
      var error = true;
      if (self.fiHinhthucKhac() === "" || self.fiHinhthucKhac() === null || self.fiHinhthucKhac() === undefined) {
          $("#fiHinhthucKhac-lbl").show();
          error = false;
      } else {
          $("#fiHinhthucKhac-lbl").hide();
      }
      return error;
    };

    self.isValid = function () {
        var errors = true;
        self.validDonvitinh();
        self.validHinhthuc();
        self.validVanchuyen();
        self.validQuocgia();

        if (self.fiMaDvTinh() === null || self.fiMaDvTinh() === undefined) {
            $("#fiDvTinh-lbl").show();
            errors = false;
        }

        if (self.fiMaHinhthuc() === null || self.fiMaHinhthuc() === undefined) {
            $("#fiHinhthuc-lbl").show();
            errors = false;
        }

        if (self.fiMaVanchuyen() === null || self.fiMaVanchuyen() === undefined) {
            $("#fiVanchuyen-lbl").show();
            errors = false;
        }

        if (self.fiMaQuocgia() === null || self.fiMaQuocgia() === undefined) {
            $("#fiQuocgia-lbl").show();
            errors = false;
        }

        if (!self.validTenHtKhac() && self.fiMaHinhthuc() === "4") {
            errors = false;
        }

        if (self.hangHoaErrors().length > 0) {
            self.hangHoaErrors.showAllMessages();
            errors = false;
        }
        return errors;
    }

}
;

function DoanhNghiep02FormVM(option, hoso) {
    var self = this;
    var dn02 = option && option.doanhNghiep02 ? option.doanhNghiep02 : null;

    self.fiIdDoanhnghiep = ko.observable(dn02 ? dn02.fiIdDoanhnghiep : null);
    self.fiIdHoso = ko.observable(dn02 ? dn02.fiIdHoso : null);
    self.fiMaHoso = ko.observable(dn02 ? hoso.fiMaHoso : null);
    self.fiTrangthai = ko.observable(dn02 ? hoso.fiTrangthai : null);
    self.fiTenTt = ko.observable(dn02 ? hoso.fiTenTt : null);
    self.fiNgaytao = ko.observable(dn02 ? new Date(dn02.fiNgaytao) : null);
    self.fiMaSothue = ko.observable(dn02 ? dn02.fiMaSothue : user.username);
    self.fiTenDoanhnghiep = ko.observable(dn02 ? dn02.fiTenDoanhnghiep : user.companyName);
    self.fiNguoiDaidien = ko.observable(dn02 ? dn02.fiNguoiDaidien : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiDiachi = ko.observable(dn02 ? dn02.fiDiachi : user.companyAddress);
    self.fiChucvu = ko.observable(dn02 ? dn02.fiChucvu : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiSoCongvan = ko.observable(dn02 ? dn02.fiSoCongvan : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 10 ký tự', params: 10}
    });
    self.fiNoidungCongvan = ko.observable(dn02 ? dn02.fiNoidungCongvan : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiHoatdong = ko.observable(dn02 ? dn02.fiHoatdong : null);
    self.fiNguoitao = ko.observable(dn02 ? dn02.fiNguoitao : null);

    var doanhNghiepVG = [self.fiNguoiDaidien, self.fiChucvu, self.fiSoCongvan, self.fiNoidungCongvan];
    self.doanhNghiepErrors = ko.validation.group(doanhNghiepVG, {deep: true, live: true, observable: true});
    self.toJSON = function () {

        var exclude = ['toJSON', 'isValidDn'];

        var model = ko.toJS(self);

        for (var key in model) {
            if (exclude.indexOf(key) >= 0) {
                delete model[key];
            }
        }

        return model;
    };

    self.isValidDn = function () {
        debugger;
        var errorDn = true;
        if (self.doanhNghiepErrors().length > 0) {
            self.doanhNghiepErrors.showAllMessages();
            errorDn = false;
        }
        return errorDn;
    };
}

function LyDo02FormVM(option) {
    var self = this;
    var lyDo02 = option && option.lyDo02 ? option.lyDo02 : null;
    self.fiIdLydo = ko.observable(lyDo02 ? lyDo02.fiIdLydo : null);
    self.fiIdHoso = ko.observable(lyDo02 ? lyDo02.fiIdHoso : null);
    self.fiMucdichSd = ko.observable(lyDo02 ? lyDo02.fiMucdichSd : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 512 ký tự', params: 512}
    });
    self.fiTenTlDk = ko.observable(lyDo02 ? lyDo02.fiTenTlDk : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 512 ký tự', params: 512}
    });
    self.fiHoatdong = ko.observable(lyDo02 ? lyDo02.fiHoatdong : null);
    self.fiNguoitao = ko.observable(lyDo02 ? lyDo02.fiNguoitao : null);
    self.fiNgaytao = ko.observable(lyDo02 ? lyDo02.fiNgaytao : null);
    self.fiNgCapnhat = ko.observable(lyDo02 ? lyDo02.fiNgCapnhat : null);

    var LydoVG = [self.fiMucdichSd, self.fiTenTlDk];
    self.lydoErrors = ko.validation.group(LydoVG, {deep: true, live: true, observable: true});
    self.toJSON = function () {

        var exclude = ['toJSON', 'isValidLydo'];

        var model = ko.toJS(self);

        for (var key in model) {
            if (exclude.indexOf(key) >= 0) {
                delete model[key];
            }
        }

        return model;
    };

    self.isValidLydo = function () {
        var errorLydo = true;
        if (self.lydoErrors().length > 0) {
            self.lydoErrors.showAllMessages();
            errorLydo = false;
        }
        return errorLydo;
    };
}

function NguoiLH02FormVM(option) {
    var self = this;
    var ngLH02 = option && option.nguoiLH02 ? option.nguoiLH02 : null;
    self.fiIdNgLienhe = ko.observable(ngLH02 ? ngLH02.fiIdNgLienhe : null);
    self.fiIdHoso = ko.observable(ngLH02 ? ngLH02.fiIdHoso : null);
    self.fiTenNgLienhe = ko.observable(ngLH02 ? ngLH02.fiTenNgLienhe : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 100 ký tự', params: 100}
    });
    self.fiSoDt = ko.observable(ngLH02 ? ngLH02.fiSoDt : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 50 ký tự', params: 50}
    });
    self.fiEmail = ko.observable(ngLH02 ? ngLH02.fiEmail : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 50 ký tự', params: 50}
    });
    self.fiHoatdong = ko.observable(ngLH02 ? ngLH02.fiHoatdong : null);
    self.fiNguoitao = ko.observable(ngLH02 ? ngLH02.fiNguoitao : null);
    self.fiNgaytao = ko.observable(ngLH02 ? ngLH02.fiNgaytao : null);
    self.fiNgCapnhat = ko.observable(ngLH02 ? ngLH02.fiNgCapnhat : null);

    var NguoiLHVG = [self.fiTenNgLienhe, self.fiSoDt, self.fiEmail ];
    self.nguoiLHErrors = ko.validation.group(NguoiLHVG, {deep: true, live: true, observable: true});
    self.toJSON = function () {

        var exclude = ['toJSON', 'isValidNguoiLH02', 'validEmail'];

        var model = ko.toJS(self);

        for (var key in model) {
            if (exclude.indexOf(key) >= 0) {
                delete model[key];
            }
        }

        return model;
    };

    self.validEmail = function () {
        debugger;
        $('#email_valid').hide();
        var reg = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z])+$/;
        if (self.fiEmail() != null && self.fiEmail() != "" && self.fiEmail().trim() != "") {
            if (reg.test(self.fiEmail().trim()) == false) {
                $('#email_valid').show();
                return false;
            } else {
                $('#email_valid').hide();
            }
        }
        return true;
    };

    self.isValidNguoiLH02 = function () {
        debugger;
        var errorNguoiLH = true;
        if (!self.validEmail()) {
            errorNguoiLH = false;
        }
        if (self.nguoiLHErrors().length > 0) {
            self.nguoiLHErrors.showAllMessages();
            errorNguoiLH = false;
        }
        return errorNguoiLH;
    };
}




    