/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function XeVM(op) {
    var self = this;
    var xe = op.item;
    self.fiId = ko.observable(null);
    self.fiIdXe = ko.observable(xe ? xe.fiIdXe() : null);
    self.fiIdHoso = ko.observable(xe ? xe.fiIdHoso() : null);
    self.fiStt = ko.observable(xe ? xe.fiStt() : null);

    self.fiBksXe = ko.observable(xe != null ? xe.fiBksXe() : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });

    self.fiSoGhe = ko.observable(xe ? xe.fiSoGhe() : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiNamSx = ko.observable(xe ? xe.fiNamSx() : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiMaNhanhieu = ko.observable(xe ? xe.fiMaNhanhieu() : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
    });
    self.fiTenHieu = ko.observable(xe ? xe.fiTenHieu() : null);
    self.fiSoKhung = ko.observable(xe ? xe.fiSoKhung() : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiSoMay = ko.observable(xe ? xe.fiSoMay() : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiMauSon = ko.observable(xe ? xe.fiMauSon() : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
    });
    self.fiDncpDenNg = ko.observable(xe != null ? new Date(xe.fiDncpDenNg()) : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiDncpTuNg = ko.observable(xe != null ? new Date(xe.fiDncpTuNg()) : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiHinhthuc = ko.observable(xe ? xe.fiHinhthuc() : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiMaCkXn = ko.observable(xe ? xe.fiMaCkXn() : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiTenCkXn = ko.observable(xe ? xe.fiTenCkXn() : null);

    self.lstXe = op.lstXe;
    self.lstHinhThuc = op.lstHinhThuc;
    self.lstCuaKhauXuatNhap = op.lstCuaKhauXuatNhap;

    var xeVG = [self.fiBksXe, self.fiSoGhe, self.fiNamSx, self.fiMaNhanhieu,
        self.fiTenHieu, self.fiSoKhung, self.fiSoMay, self.fiMauSon, self.fiDncpTuNg, self.fiDncpDenNg,
        self.fiHinhthuc, self.fiMaCkXn, self.fiTenCkXn];
    self.errors = ko.validation.group(xeVG, {deep: true, live: true, observable: true});

    self.getDetailXe = function () {
        if (self.fiId()) {
            $('#loading10').show();
            app.getCategory('/mt/13/danhmuc', 'HS_XE_CHITIET', self.fiId(), function (d) {
                if (d.success) {
                    var xe = d.data;
                    if (xe) {
                        self.fiBksXe(xe.fiBksXe);
                        self.fiSoGhe(xe.fiSoGhe);
                        self.fiMaNhanhieu(xe.fiMaNhanhieu);
                        self.fiTenHieu(xe.fiTenNhanhieu);
                        self.fiSoKhung(xe.fiSoKhung);
                        self.fiSoMay(xe.fiSoMay);
                        self.fiMauSon(xe.fiTenMauson);
                        self.fiNamSx(xe.fiNamSx);
                    }
                }
                $('#loading10').hide();
            });
        }
    };

    self.toJSON = function () {
        var exclude = ["getDetailXe", "lstLoaiXe", "lstCuaKhauXuatNhap", "lstXe",
            "toJSON", "__ko_mapping__", "errors", "isValid"];

        var model = ko.toJS(self);

        for (var key in model) {
            if (exclude.indexOf(key) >= 0) {
                delete model[key];
            }
        }

        return model;
    };

    self.isValid = function () {
        var errorphuongtien = false;
        if (new Date(self.fiDncpTuNg()).getTime() > new Date(self.fiDncpDenNg()).getTime()) {
            app.Alert('Thời gian đề nghị cấp giấy phép từ ngày không được lớn hơn Thời gian đề nghị cấp giấy phép đến ngày');
            errorphuongtien = true;
            return errorphuongtien;
        }

        if (self.errors().length > 0) {
            app.Alert('Bạn phải nhập vào đầy đủ thông tin của xe.');
            self.errors().showAllMessages();
            errorphuongtien = true;
            return errorphuongtien;
        }
        return errorphuongtien;

    };
}

function FormVM(options) {
    var self = this;
    self.tuyencodinh = ko.observable(false);
    var hosoInfo = (options !== null && options.hasOwnProperty('hoso')) ? options.hoso : null;

    //Thong tin chung
    self.fiIdHoso = ko.observable(null);
    self.fiMaHoso = ko.observable(null);
    self.fiMaCqxl = ko.observable(null);
    self.fiTenCqxl = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiTenDn = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiDiachiDn = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiSdtDn = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiFaxDn = ko.observable(null);
    self.fiSoGp = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiNgaycap = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });

    // Loai hinh kinh doanh van tai
    self.fiVtTuyencodinh = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiVtHkHopdong = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiVtHkDulich = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiVtHanghoa = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiLoaihinhDn = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
    });

    self.LoaihinhDn = {
        'BGTVT0600061': '1',
        'BGTVT0600062': '4',
        'BGTVT0600063': '3',
        'BGTVT0600064': '2'
    };
    self.fiLoaihinhDn = ko.observable(null);

    self.fiLoaihinhDn = ko.observable(self.LoaihinhDn[options.maThuTuc]);

    self.fiLydo = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });

    self.isRequire = ko.observable(true);
    if (options.maThuTuc == 'BGTVT0600061') {
        self.isRequire(false);
    }
    // thong tin tuyen
    self.fiMaTuyen = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiTenTuyen = ko.observable(null);
    self.fiBenDi = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiMaTinhDi = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiTenTinhDi = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiMaTinhDen = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiTenTinhDen = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiBenDen = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiCuly = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiHanhtrinh = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiSoCv = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiNgaycapCv = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });

    //Thông tin tệp đính kèm
    self.lstDinhKem = ko.observableArray([]);

    // Thong tin ky don
    self.fiTenNgKy = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiChucDanh = ko.observable(null).extend({
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiDiaDiem = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });

//Thông tin hồ sơ
    self.fiHoatdong = ko.observable(1);
    self.fiNguoitao = ko.observable(null);
    self.fiNgaytao = ko.observable(null);
    self.fiNgCapnhat = ko.observable(null);
    self.fiTrangthai = ko.observable(0);
    self.fiTenTt = ko.observable(null);

    self.fiIdThutuc = ko.observable(null);
    self.fiMaThutuc = ko.observable(options.maThuTuc);
    self.fiTenThutuc = ko.observable(null);
    self.fiNgaygui = ko.observable(null);

    self.fiNgaycapGp = ko.observable(null);
    self.fiMstDn = ko.observable(null);
    self.fiSogpDc = ko.observable(null);

    //Danh muc
    self.lstXe = ko.observableArray(hosoInfo ? hosoInfo.lstXe : []);
    self.lstDonViXuLy = ko.observableArray(mapCategory(options ? options.lstDonViXuLy : [], 'fiMaCqxl', 'fiTenCqxl'));
    self.lstloaihinhDn = ko.observableArray(mapCategory(options ? options.lstloaihinhDn : [], 'id', 'name'));
    self.lstTuyen = ko.observableArray(mapCategory(options ? options.lstTuyen : [], 'fiMaTuyen', 'fiTenTuyen'));
    self.lstHinhThuc = ko.observableArray(mapCategory(options ? options.lstHinhThuc : [], 'id', 'name'));
    self.lstCuaKhauXuatNhap = ko.observableArray(mapCategory(options ? options.lstCuaKhauXuatNhap : [], 'fiMaCuakhau', 'fiTenCuakhau'));

    var hosoVG = [self.fiMaCqxl, self.fiTenDn, self.fiDiachiDn, self.fiSdtDn,
        self.fiLoaihinhDn, self.fiMstDn, self.fiTenNgKy, self.fiDiaDiem,
        self.fiSoGp, self.fiNgaycap];

    self.hosoErrors = ko.validation.group(hosoVG, {deep: true, live: true, observable: true});
    var tuyenVG = [self.fiMaTuyen, self.fiTenTuyen, self.fiBenDi, self.fiMaTinhDi, self.fiTenTinhDi
                , self.fiMaTinhDen, self.fiTenTinhDen, self.fiBenDen, self.fiCuly, self.fiHanhtrinh
                , self.fiNgaycapCv, self.fiSoCv];
    self.tuyenErrors = ko.validation.group(tuyenVG, {deep: true, live: true, observable: true});
    self.errorXeMessage = ko.observable(null);
    self.errorDinhKemMessage = ko.observable(null);
    self.errorCheckBoxmessage = ko.observable(null);
    //Khoi tao gia tri ho so
    self.init = function (hoso) {
        self.fiTenDn(hoso !== null && hoso.hasOwnProperty('fiTenDn') ? hoso.fiTenDn : user.companyName);
        self.fiMstDn(hoso !== null && hoso.hasOwnProperty('fiMstDn') ? hoso.fiMstDn : user.username);
        self.fiDiachiDn(hoso !== null && hoso.hasOwnProperty('fiDiachiDn') ? hoso.fiDiachiDn : user.companyAddress);
        self.fiSdtDn(hoso !== null && hoso.hasOwnProperty('fiSdtDn') ? hoso.fiSdtDn : user.companyPhoneNumber);
        self.fiFaxDn(hoso !== null && hoso.hasOwnProperty('fiFaxDn') ? hoso.fiFaxDn : null);

        if (hoso !== null) {
            //Thong tin chung
            self.fiIdHoso(hoso.hasOwnProperty('fiIdHoso') ? hoso.fiIdHoso : null);
            self.fiMaHoso(hoso.hasOwnProperty('fiMaHoso') ? hoso.fiMaHoso : null);
            self.fiMaCqxl(hoso.hasOwnProperty('fiMaCqxl') ? hoso.fiMaCqxl : null);
            self.fiTenCqxl(hoso.hasOwnProperty('fiTenCqxl') ? hoso.fiTenCqxl : null);
            self.fiSoGp(hoso.hasOwnProperty('fiSoGp') ? hoso.fiSoGp : null);
            self.fiNgaycap(hoso.hasOwnProperty('fiNgaycap') ? new Date(hoso.fiNgaycap) : null);

//             Loai hinh kinh doanh van tai
            self.fiVtTuyencodinh(hoso.hasOwnProperty('loaiHinhVantai') ? hoso.loaiHinhVantai.fiVtTuyencodinh : null);
            self.fiVtHkHopdong(hoso.hasOwnProperty('loaiHinhVantai') ? hoso.loaiHinhVantai.fiVtHkHopdong : null);
            self.fiVtHkDulich(hoso.hasOwnProperty('loaiHinhVantai') ? hoso.loaiHinhVantai.fiVtHkDulich : null);
            self.fiVtHanghoa(hoso.hasOwnProperty('loaiHinhVantai') ? hoso.loaiHinhVantai.fiVtHanghoa : null);

            self.fiLoaihinhDn(hoso.hasOwnProperty('fiLoaihinhDn') ? hoso.fiLoaihinhDn : null);
            self.fiLydo(hoso.hasOwnProperty('fiLydo') ? hoso.fiLydo : null);

            if (self.fiVtTuyencodinh() == 1) {
                $('#fiVtTuyencodinh').prop('checked', true);
                self.tuyencodinh(true);
            }
            if (self.fiVtHkDulich() == 1) {
                $('#fiVtHkDulich').prop('checked', true);
            }
            if (self.fiVtHanghoa() == 1) {
                $('#fiVtHanghoa').prop('checked', true);
            }
            if (self.fiVtHkHopdong() == 1) {
                $('#fiVtHkHopdong').prop('checked', true);
            }

            // thong tin tuyen
            self.fiMaTuyen(hoso.hasOwnProperty('fiMaTuyen') ? hoso.fiMaTuyen : null);
            self.fiTenTuyen(hoso.hasOwnProperty('fiTenTuyen') ? new Date(hoso.fiTenTuyen) : null);
            self.fiBenDi(hoso.hasOwnProperty('fiBenDi') ? hoso.fiBenDi : null);
            self.fiMaTinhDi(hoso.hasOwnProperty('fiMaTinhDi') ? hoso.fiMaTinhDi : null);
            self.fiTenTinhDi(hoso.hasOwnProperty('fiTenTinhDi') ? hoso.fiTenTinhDi : null);
            self.fiMaTinhDen(hoso.hasOwnProperty('fiMaTinhDen') ? hoso.fiMaTinhDen : null);
            self.fiTenTinhDen(hoso.hasOwnProperty('fiTenTinhDen') ? hoso.fiMaTinhDen : null);
            self.fiBenDen(hoso.hasOwnProperty('fiBenDen') ? hoso.fiBenDen : null);
            self.fiCuly(hoso.hasOwnProperty('fiCuly') ? hoso.fiCuly : null);
            self.fiHanhtrinh(hoso.hasOwnProperty('fiHanhtrinh') ? hoso.fiHanhtrinh : null);
            self.fiSoCv(hoso.hasOwnProperty('fiSoCv') ? hoso.fiSoCv : null);
            self.fiNgaycapCv(hoso.hasOwnProperty('fiNgaycapCv') && hoso.fiNgaycapCv != null ? new Date(hoso.fiNgaycapCv) : null);

            //Thông tin tệp đính kèm
            self.lstDinhKem(mapFilesVM(hoso.hasOwnProperty('lstDinhKem') ? hoso.lstDinhKem : [], self.fiIdHoso()));

            //Thông tin ký đơn
            self.fiTenNgKy(hoso.chuKyDoanhNghiep.hasOwnProperty('fiTenNgKy') ? hoso.chuKyDoanhNghiep.fiTenNgKy : null);
            self.fiChucDanh(hoso.chuKyDoanhNghiep.hasOwnProperty('fiChucDanh') ? hoso.chuKyDoanhNghiep.fiChucDanh : null);
            self.fiDiaDiem(hoso.chuKyDoanhNghiep.hasOwnProperty('fiDiaDiem') ? hoso.chuKyDoanhNghiep.fiDiaDiem : null);

            //Thông tin hồ sơ
            self.fiIdThutuc(hoso.hasOwnProperty('fiIdThutuc') ? hoso.fiIdThutuc : null);
            self.fiMaThutuc(hoso.hasOwnProperty('fiMaThutuc') ? hoso.fiMaThutuc : options.maThuTuc);
            self.fiTenThutuc(hoso.hasOwnProperty('fiTenThutuc') ? hoso.fiTenThutuc : null);
            self.fiNgaygui(hoso.hasOwnProperty('fiNgaygui') && hoso.fiNgaygui != null ? hoso.fiNgaygui : null);

            self.fiHoatdong(hoso.hasOwnProperty('fiHoatdong') ? hoso.fiHoatdong : 1);
            self.fiNguoitao(hoso.hasOwnProperty('fiNguoitao') ? hoso.fiNguoitao : null);
            self.fiNgaytao(hoso.hasOwnProperty('fiNgaytao') ? new Date(hoso.fiNgaytao) : null);
            self.fiNgCapnhat(hoso.hasOwnProperty('fiNgCapnhat') ? hoso.fiNgCapnhat : null);
            self.fiTrangthai(hoso.hasOwnProperty('fiTrangthai') ? hoso.fiTrangthai : 0);
            self.fiTenTt(hoso.hasOwnProperty('fiTenTt') ? hoso.fiTenTt : null);
            self.fiSogpDc(hoso.hasOwnProperty('fiSogpDc') ? hoso.fiSogpDc : null);

            self.fiNgaycapGp(hoso.hasOwnProperty('fiNgaycapGp') && hoso.fiNgaycapGp != null ? new Date(hoso.fiNgaycapGp) : null);
            self.fiMstDn(hoso.hasOwnProperty('fiMstDn') ? hoso.fiMstDn : null);

            self.lstXe(mapTbdhsXe61(hoso.hasOwnProperty('lstXe') ? hoso.lstXe : []));
            self.lstDinhKem(mapFilesVM(hoso.hasOwnProperty('lstDinhKem') ? hoso.lstDinhKem : [], self.fiIdHoso()));
        } else {
            self.lstDinhKem(mapFilesVM(options.lstDinhKem, self.fiIdHoso()));
        }

//        if (!self.fiMaCqxl()) {
//            self.fiMaCqxl('TCDBVN');
//            self.fiTenCqxl('Tổng Cục Đường Bộ Việt Nam');
//        }

        $("#fiMaCqxl").val(self.fiMaCqxl()).select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
        $(".fiLoaihinhDn").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});

        self.hosoErrors.showAllMessages(false);
    };

    self.init(hosoInfo);
    //VALIDATE DATA ON FORM
    //Remove from toJSON
    self.isValidForm = function () {
        delete self.xeVM;
        delete self.pop;
        //Kiem tra thong tin Ho so
        var errorHoso = true;
        var errorXe = true;
        var errorDinhkem = true;
        if (self.hosoErrors().length > 0) {
            self.hosoErrors.showAllMessages();
            errorHoso = false;
            return errorHoso;
        }
        if (self.fiLoaihinhDn() != 1 && (self.fiLydo() == null || self.fiLydo() == "")) {
            app.Alert('Bạn phải nhập vào lý do đề nghị');
            return false;
        }

        //Kiểm tra checkbox va tuyen
        if ((self.fiVtTuyencodinh() == 0 && self.fiVtHanghoa() == 0
                && self.fiVtHkDulich() == 0 && self.fiVtHkHopdong() == 0)
                || self.fiVtTuyencodinh() == null || !self.fiVtHanghoa() == null
                || !self.fiVtHkDulich() == null || !self.fiVtHkHopdong() == null) {
            self.errorCheckBoxmessage('* Chưa chọn loại hình hoạt động');
            errorHoso = false;
            return errorHoso;
        } else {
            self.errorCheckBoxmessage(null);
        }
        if (self.fiVtTuyencodinh() == 1 && self.tuyenErrors().length > 0) {
            self.tuyenErrors.showAllMessages();
            errorHoso = false;
            return errorHoso;
        }
        //Kiem tra thong tin Xe

        if (!self.lstXe() || self.lstXe().length <= 0) {
            self.errorXeMessage('* Chưa khai báo thông tin xe');
            errorXe = false;
            return errorXe;
        }



        if (!errorXe) {
            self.errorXeMessage('* Bổ sung thêm thông tin của Xe trước khi lưu dữ liệu');
            return errorXe;
        }

        //Kiem tra thong tin dinh kem
        if (!self.lstDinhKem() || self.lstDinhKem().length <= 0) {
            self.errorDinhKemMessage('* Chưa khai báo thông tin đính kèm');
            errorDinhkem = false;
            return errorDinhkem;
        } else {
            self.errorDinhKemMessage(null);
        }

        if (self.lstDinhKem() && self.lstDinhKem().length > 0) {
            for (var i = 0; i < self.lstDinhKem().length; i++) {
                var attach = self.lstDinhKem()[i];
                if (attach.isRequire()) {
                    if (!attach.fiGuiid() || !attach.fiTenTep() || !attach.fiDuongDan()) {
                        errorDinhkem = false;
                        break;
                    }
                }
            }
        }

        if (!errorDinhkem) {
            self.errorDinhKemMessage('* Cần bổ sung thêm file đính kèm!');
        }

        return errorHoso && errorXe && errorDinhkem;
    };
    //VALIDATE DATA ON FORM

    //XU LY SU KIEN BUTTON, TABLE
    self.removeCarOnClick = function (item) {
        if (item) {
            var pop = app.popup({
                title: 'Thông báo',
                html: '<b>Bạn chắc chắn muốn xoá dữ liệu của xe này?</b>',
                width: 450,
                buttons: [
                    {
                        name: NSWLang["common_button_toi_chac_chan"],
                        class: 'btn',
                        icon: 'fa-save',
                        action: function () {
                            self.lstXe.remove(function (o) {
                                return o.fiIdXe() == item.fiIdXe();
                            });
                            for (var i = 0; i < self.lstXe().length; i++) {
                                self.lstXe()[i].fiStt(i + 1);
                            }
                            app.popupRemove(pop.selector);
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
    };

    self.addCarOnClick = function () {
        self.updateXeInfo(null);
        return false;
    };

    self.editCarOnClick = function (item) {
        self.updateXeInfo(item);
        return false;
    };

    self.updateXeInfo = function (item) {
        var html = [
            $('#thongtinxe-template').html()
        ].join('');

        var data = {
            item: item,
            lstCuaKhauXuatNhap: self.lstCuaKhauXuatNhap(),
            lstHinhThuc: self.lstHinhThuc()
        };

        delete self.pop;
        delete self.xeVM;

        var cb = function () {
            self.xeVM = new XeVM(data);
            self.pop = app.popup({
                title: 'Cập nhật thông tin xe',
                html: html,
                width: 1024,
                buttons: [
                    {
                        name: 'Lưu',
                        class: 'btn',
                        icon: 'fa-save',
                        action: function () {
                            if (self.xeVM.isValid()) {
                                app.Alert('Bạn phải nhập vào đầy đủ thông tin của xe.');
                            } else {
                                var xeInfo = self.xeVM.toJSON();
                                if (null == xeInfo.fiIdXe) {
                                    xeInfo.fiIdXe = -1 * new Date().getTime();
                                    xeInfo.fiStt = self.lstXe().length + 1;
                                    var xeModel = new TbdhsXe61(xeInfo);
                                    self.lstXe.push(xeModel);
                                } else {
                                    for (var i = 0; i < self.lstXe().length; i++) {
                                        if (xeInfo.fiIdXe == self.lstXe()[i].fiIdXe()) {
                                            var xeModel = new TbdhsXe61(xeInfo);
                                            self.lstXe.replace(self.lstXe()[i], xeModel);
                                            break;
                                        }
                                    }
                                }

                                app.popupRemove(self.pop.selector);
                                $('.modal-scrollable').hide();
                                $('.modal-backdrop').hide();
                            }
                        }
                    },
                    {
                        name: 'Đóng',
                        class: 'btn',
                        icon: 'fa-check',
                        action: function () {
                            app.popupRemove(self.pop.selector);
                            $('.modal-scrollable').hide();
                            $('.modal-backdrop').hide();
                        }
                    }
                ]
            });

            ko.applyBindings(self.xeVM, document.getElementById('thongtinxe-vm'));

            if (item != null) {
                $("#fiBksXe-New").val(item.fiBksXe()).select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
                $("#fiMaCkXn-New").val(item.fiMaCkXn()).select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
                $("#fiHinhthuc-New").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
            } else {
                $("#fiBksXe-New").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
                $("#fiMaCkXn-New").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
                $("#fiHinhthuc-New").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});

            }

        };

        app.makePost({
            url: '/mt/13/xe/findall',
            data: JSON.stringify({
                pageSize: 10000,
                currentPage: 0
            }),
            success: function (d) {
                var msg = '';
                if (d.success) {
                    data.lstXe = d.data;
                    cb();
                } else {
                    msg = data.message ? data.message : 'Không load được danh mục xe, vui lòng thử lại!';
                    app.Alert(msg);
                }
            },
            error: function (e) {
                app.toast({
                    title: NSWLang["common_msg_thong_bao"],
                    message: NSWLang["common_msg_he_thong_chua_san_sang"],
                    function: 'success'
                });
            }
        });
    };

    self.getTuyenInfoOnClick = function () {
        if (self.fiMaTuyen()) {
            $('#loading10').show();
            app.getCategory('/mt/13/danhmuc', 'HS_TUYENVANTAI_CHITIET', self.fiMaTuyen(), function (d) {
                if (d.success) {
                    var tuyenInfo = d.data;
                    if (tuyenInfo) {
                        self.fiTenTuyen(tuyenInfo.fiTenTuyen);
                        self.fiBenDi(tuyenInfo.fiTenBenDi);
                        self.fiMaTinhDi(tuyenInfo.fiMaTinhDi);
                        self.fiTenTinhDi(tuyenInfo.fiTenTinhDi);
                        self.fiMaTinhDen(tuyenInfo.fiMaTinhDen);
                        self.fiTenTinhDen(tuyenInfo.fiTenTinhDen);
                        self.fiBenDen(tuyenInfo.fiTenBenDen);
                        self.fiCuly(tuyenInfo.fiKhoangcach);
                        self.fiHanhtrinh(tuyenInfo.fiHanhtrinh);
                    }
                    $('#loading10').hide();

                }
            });
        }
    };
    //XU LY SU KIEN BUTTON, TABLE , CHECKBOX

    //Processing checkbox loai hinh hoat dong
    $('.checkLoaihinhhd').click(function () {
        //Only One Checkbox loai hinh hoat dong
        $('.checkLoaihinhhd').not(this).prop('checked', false);
        //set value Checkbox
        $('.checkLoaihinhhd').each(function () {
            if ($('#fiVtTuyencodinh').prop('checked')) {
                self.fiVtTuyencodinh(1);
                self.tuyencodinh(true);
            } else {
                self.tuyencodinh(false);
                self.fiVtTuyencodinh(0);
            }
            if ($('#fiVtHkHopdong').prop('checked')) {
                self.fiVtHkHopdong(1);
            } else {
                self.fiVtHkHopdong(0);
            }
            if ($('#fiVtHkDulich').prop('checked')) {
                self.fiVtHkDulich(1);
            } else {
                self.fiVtHkDulich(0);
            }
            if ($('#fiVtHanghoa').prop('checked')) {
                self.fiVtHanghoa(1);
            } else {
                self.fiVtHanghoa(0);
            }
        });
    });
    //XU LY SU KIEN BUTTON, TABLE , CHECKBOX
    //Convert to json object
    self.toJSON = function () {
        var exclude = ["removeCarOnClick", "addCarOnClick", "isValidForm", "init",
            "hosoErrors", "hosoErrors", "lstDonViXuLy", "lstTuyen", "lstLoaiXe", "lstCuaKhauDiDen",
            "toJSON", "lstCuaKhauXuatNhap", "__ko_mapping__", 'fiDiaDiem2', 'fiChucDanh', 'fiTenNgKy',
            'getTuyenInfoOnClick', 'errorXeMessage', 'errorDinhKemMessage', 'pop', 'editCarOnClick', 'updateXeInfo'];

        var model = ko.toJS(self);

        for (var key in model) {
            if (exclude.indexOf(key) >= 0) {
                delete model[key];
            }
        }
        if (self.fiVtTuyencodinh() != 1) {
            delete model.fiMaTuyen;
            delete model.fiTenTuyen;
            delete model.fiBenDi;
            delete model.fiMaTinhDi;
            delete model.fiTenTinhDi;
            delete model.fiMaTinhDen;
            delete model.fiTenTinhDen;
            delete model.fiBenDen;
            delete model.fiCuly;
            delete model.fiHanhtrinh;
            delete model.fiNgaycapCv;
            delete model.fiSoCv;

        }
        for (var i = 0; i < model.lstDinhKem.length; i++) {
            delete model.lstDinhKem[i]['canUpload'];
            delete model.lstDinhKem[i]['canDownload'];
            delete model.lstDinhKem[i]['canDelete'];
            delete model.lstDinhKem[i]['doUpload'];
            delete model.lstDinhKem[i]['doDelete'];
            delete model.lstDinhKem[i]['downloadUrl'];
            delete model.lstDinhKem[i]['fiBatBuoc'];
            delete model.lstDinhKem[i]['isRequire'];
            delete model.lstDinhKem[i]["__ko_mapping__"];
        }

        //Fill chuKyDoanhNghiep object
        model.chuKyDoanhNghiep = {
            fiDiaDiem: self.fiDiaDiem(),
            fiChucDanh: self.fiChucDanh(),
            fiTenNgKy: self.fiTenNgKy()
        };
        model.loaiHinhVantai = {
            fiVtTuyencodinh: self.fiVtTuyencodinh(),
            fiVtHkHopdong: self.fiVtHkHopdong(),
            fiVtHkDulich: self.fiVtHkDulich(),
            fiVtHanghoa: self.fiVtHanghoa()
        };

        return model;
    };
}

