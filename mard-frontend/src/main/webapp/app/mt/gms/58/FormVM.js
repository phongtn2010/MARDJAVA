/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function FormVM(options) {
    var self = this;
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
    self.fiFaxDn = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiEmailDn = ko.observable(null).extend({
        maxLength: {message: 'Tối đa 250 ký tự', params: 250},
        email: {message: 'Email không đúng định dạng', params: true}
    });
    self.fiWebDn = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 50 ký tự', params: 50}
    });
    self.fiSoGpVtdb = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiNgaycapGp = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiCqCap = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });

    //Thông tin đề nghị cấp Giấy phép vận tải đường bộ quốc tế Việt Nam - Lào như sau
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

//    self.fiLoaihinhDn = ko.observable(null).extend({
//        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
//    });

    self.LoaihinhDn = {
        'BGTVT0600058': '1',
        'BGTVT0600059': '3',
        'BGTVT0600060': '2',
    };
    self.fiLoaihinhDn = ko.observable(null);

    self.fiLoaihinhDn = ko.observable(self.LoaihinhDn[options.maThuTuc]);



    self.fiLydo = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });

    self.isRequire = ko.observable(true);
    if (options.maThuTuc == "BGTVT0600058") {
        self.isRequire(false);
    }
    //Thông tin tệp đính kèm
    self.lstDinhKem = ko.observableArray([]);

    //Thông tin ký đơn
    self.fiTenNgKy = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiChucDanh = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiDiaDiem = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
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

    self.fiSoVb = ko.observable(null);
    self.fiNgaycapVb = ko.observable(null);
    self.fiMstDn = ko.observable(null);

    //Danh muc
    self.lstDonViXuLy = ko.observableArray(mapCategory(options ? options.lstDonViXuLy : [], 'fiMaCqxl', 'fiTenCqxl'));
    self.lstloaihinhDn = ko.observableArray(mapCategory(options ? options.lstloaihinhDn : [], 'id', 'name'));

    var hosoVG = [self.fiMaCqxl, self.fiTenDn, self.fiDiachiDn, self.fiDiachiDn, self.fiSdtDn,
        self.fiFaxDn, self.fiNgaycapGp, self.fiCqCap, self.fiSoGpVtdb, self.fiLoaihinhDn,
        self.fiTenNgKy, self.fiDiaDiem
    ];

    self.hosoErrors = ko.validation.group(hosoVG, {deep: true, live: true, observable: true});
    self.errorDinhKemMessage = ko.observable(null);
    self.errorCheckBoxmessage = ko.observable(null);

    //Khoi tao gia tri ho so
    self.init = function (hoso) {
        self.fiTenDn(hoso !== null && hoso.hasOwnProperty('fiTenDn') ? hoso.fiTenDn : user.companyName);
        self.fiMstDn(hoso !== null && hoso.hasOwnProperty('fiMstDn') ? hoso.fiMstDn : user.username);
        self.fiDiachiDn(hoso !== null && hoso.hasOwnProperty('fiDiachiDn') ? hoso.fiDiachiDn : user.companyAddress);
        self.fiSdtDn(hoso !== null && hoso.hasOwnProperty('fiSdtDn') ? hoso.fiSdtDn : user.companyPhoneNumber);
        self.fiFaxDn(hoso !== null && hoso.hasOwnProperty('fiFaxDn') ? hoso.fiFaxDn : null);
        self.fiEmailDn(hoso !== null && hoso.hasOwnProperty('fiEmailDn') ? hoso.fiEmailDn : null);
        self.fiWebDn(hoso !== null && hoso.hasOwnProperty('fiWebDn') ? hoso.fiWebDn : null);

        if (hoso !== null) {

            self.fiIdHoso(hoso.hasOwnProperty('fiIdHoso') ? hoso.fiIdHoso : null);
            self.fiMaHoso(hoso.hasOwnProperty('fiMaHoso') ? hoso.fiMaHoso : null);
            self.fiMaCqxl(hoso.hasOwnProperty('fiMaCqxl') ? hoso.fiMaCqxl : null);
            self.fiTenCqxl(hoso.hasOwnProperty('fiTenCqxl') ? hoso.fiTenCqxl : null);

            self.fiSoGpVtdb(hoso.hasOwnProperty('fiSoGpVtdb') ? hoso.fiSoGpVtdb : null);
            self.fiNgaycapGp(hoso.hasOwnProperty('fiNgaycapGp') && hoso.fiNgaycapGp != null ? new Date(hoso.fiNgaycapGp) : null);
            self.fiCqCap(hoso.hasOwnProperty('fiCqCap') ? hoso.fiCqCap : null);

            //Thông tin đề nghị cấp Giấy phép vận tải đường bộ quốc tế Việt Nam - Lào như sau
            self.fiVtTuyencodinh(hoso.hasOwnProperty('loaiHinhVantai') ? hoso.loaiHinhVantai.fiVtTuyencodinh : null);
            self.fiVtHkHopdong(hoso.hasOwnProperty('loaiHinhVantai') ? hoso.loaiHinhVantai.fiVtHkHopdong : null);
            self.fiVtHkDulich(hoso.hasOwnProperty('loaiHinhVantai') ? hoso.loaiHinhVantai.fiVtHkDulich : null);
            self.fiVtHanghoa(hoso.hasOwnProperty('loaiHinhVantai') ? hoso.loaiHinhVantai.fiVtHanghoa : null);

            self.fiLoaihinhDn(hoso.hasOwnProperty('fiLoaihinhDn') ? hoso.fiLoaihinhDn : null);
            self.fiLydo(hoso.hasOwnProperty('fiLydo') ? hoso.fiLydo : null);

            if (self.fiVtTuyencodinh() == 1) {
                $('#fiVtTuyencodinh').prop('checked', true);
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

            self.fiSoVb(hoso.hasOwnProperty('fiSoVb') ? hoso.fiSoVb : null);
            self.fiNgaycapVb(hoso.hasOwnProperty('fiNgaycapVb') && hoso.fiNgaycapVb != null ? new Date(hoso.fiNgaycapVb) : null);
            self.fiMstDn(hoso.hasOwnProperty('fiMstDn') ? hoso.fiMstDn : null);


        } else {
            self.lstDinhKem(mapFilesVM(options.lstDinhKem, self.fiIdHoso()));
        }

//        if (!self.fiMaCqxl()) {
//            self.fiMaCqxl('TCDBVN');
//            self.fiTenCqxl('Tổng Cục Đường Bộ Việt Nam');
//        }

        $("#fiMaCqxl").val(self.fiMaCqxl()).select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
    };

    self.init(hosoInfo);


    //VALIDATE DATA ON FORM
    //Remove from toJSON
    self.isValidForm = function () {
        //Kiem tra thong tin Ho so
        var errorHoso = true;
        var errorDinhkem = true;

        if (self.hosoErrors().length > 0) {
            self.hosoErrors.showAllMessages();
            errorHoso = false;
            return errorHoso;
        }
        //Kiem tra thong tin checkbox 
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
        if (self.fiLoaihinhDn() != 1 && (self.fiLydo() == null || self.fiLydo() == "")) {
            app.Alert('Bạn phải nhập vào lý do đề nghị');
            return false;
        }

        if (!errorDinhkem) {
            self.errorDinhKemMessage('* Cần bổ sung thêm file đính kèm!');
        }

        return errorHoso && errorDinhkem;
    }
    ;
    //VALIDATE DATA ON FORM

    //XU LY SU KIEN BUTTON, TABLE    
    //XU LY SU KIEN BUTTON, TABLE

    //Convert to json object
    self.toJSON = function () {
        var exclude = ["isValidForm", "init",
            "hosoErrors", "hosoErrors", "lstDonViXuLy", "lstTuyen", "lstLoaiXe", "lstCuaKhauDiDen",
            "toJSON", "lstCuaKhauXuatNhap", "__ko_mapping__", 'fiDiaDiem', 'fiChucDanh', 'fiTenNgKy',
            'fiVtTuyencodinh', 'fiVtHkHopdong', 'fiVtHkDulich', 'fiVtHanghoa', 'errorDinhKemMessage'];
        var model = ko.toJS(self);

        for (var key in model) {
            if (exclude.indexOf(key) >= 0) {
                delete model[key];
            }
        }

        for (var i = 0; i < model.lstDinhKem.length; i++) {
            delete model.lstDinhKem[i]['canUpload'];
            delete model.lstDinhKem[i]['canDownload'];
            delete model.lstDinhKem[i]['canDelete'];
            delete model.lstDinhKem[i]['doUpload'];
            delete model.lstDinhKem[i]['doDelete'];
            delete model.lstDinhKem[i]['downloadUrl'];
            delete model.lstDinhKem[i]["__ko_mapping__"];
            delete model.lstDinhKem[i]['fiBatBuoc'];
            delete model.lstDinhKem[i]['isRequire'];
        }

        //Fill chuKyDoanhNghiep object
        model.chuKyDoanhNghiep = {
            fiDiaDiem: self.fiDiaDiem(),
            fiChucDanh: self.fiChucDanh(),
            fiTenNgKy: self.fiTenNgKy()
        };
        //Fill loaiHinhVantai object
        model.loaiHinhVantai = {
            fiVtTuyencodinh: self.fiVtTuyencodinh(),
            fiVtHkHopdong: self.fiVtHkHopdong(),
            fiVtHkDulich: self.fiVtHkDulich(),
            fiVtHanghoa: self.fiVtHanghoa()
        };

        delete model['__ko_mapping__'];
        return model;
    };

    //Processing checkbox loai hinh hoat dong
    $('.checkLoaihinhhd').click(function () {
        //Only One Checkbox loai hinh hoat dong
        $('.checkLoaihinhhd').not(this).prop('checked', false);
        //set value Checkbox
        $('.checkLoaihinhhd').each(function () {
            if ($('#fiVtTuyencodinh').prop('checked')) {
                self.fiVtTuyencodinh(1);
            } else {
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
}

