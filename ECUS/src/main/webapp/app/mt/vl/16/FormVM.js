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
    self.fiMaCqxl = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiTenCqxl = ko.observable(null);
    self.fiTenDn = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiDiachiDn = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiSoGtVb = ko.observable(null).extend({
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
        maxLength: {message: 'Tối đa 50 ký tự', params: 50}
    });
    self.fiSoGpVtdb = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiNgaycapGp = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });

    //Thong tin tuyen
    self.fiMaTuyen = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiTenTuyen = ko.observable(null);
    self.fiBenDi = ko.observable(null);
    self.fiMaTinhDi = ko.observable(null);
    self.fiTenTinhDi = ko.observable(null);
    self.fiMaTinhDen = ko.observable(null);
    self.fiTenTinhDen = ko.observable(null);
    self.fiBenDen = ko.observable(null);
    self.fiKhoangcach = ko.observable(null);
    self.fiHanhtrinh = ko.observable(null);
    self.fiMaCkXn = ko.observable(null);
    self.fiTenCkXn = ko.observable(null);

    self.fiTenNgKy = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiChucDanh = ko.observable(null).extend({
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiDiaDiem2 = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });

    self.fiIdThutuc = ko.observable(null);
    self.fiMaThutuc = ko.observable(options.maThuTuc);
    self.fiTenThutuc = ko.observable(null);
    self.fiNgaygui = ko.observable(null);

    self.fiHoatdong = ko.observable(1);
    self.fiNguoitao = ko.observable(null);
    self.fiNgaytao = ko.observable(null);
    self.fiNgCapnhat = ko.observable(null);
    self.fiTrangthai = ko.observable(0);
    self.fiTenTt = ko.observable(null);
    self.fiDiaDiem = ko.observable(null);
    self.fiNgayDk = ko.observable(null);
    self.fiNgayNgung = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiNgayDchinh = ko.observable(null);
    self.fiSoVb = ko.observable(null);
    self.fiNgaycapVb = ko.observable(null);
    self.fiMstDn = ko.observable(null);
    self.fiSoChuyen = ko.observable(null);

    self.lstXe = ko.observableArray(hosoInfo ? hosoInfo.lstXe : []);
    self.lstDinhKem = ko.observableArray([]);

    //Danh muc
    self.lstDonViXuLy = ko.observableArray(mapCategory(options ? options.lstDonViXuLy : [], 'fiMaCqxl', 'fiTenCqxl'));
    self.lstTuyen = ko.observableArray(mapCategory(options ? options.lstTuyen : [], 'fiMaTuyen', 'fiTenTuyen'));
    self.lstLoaiXe = ko.observableArray(mapCategory(options ? options.lstLoaiXe : [], 'fiMaPhtien', 'fiTenPhtien'));
    self.lstCuaKhauDiDen = ko.observableArray(mapCategory(options ? options.lstCuaKhauDiDen : [], 'fiMaCuakhau', 'fiTenCuakhau'));
    self.lstCuaKhauXuatNhap = ko.observableArray(mapCategory(options ? options.lstCuaKhauXuatNhap : [], 'fiMaCuakhau', 'fiTenCuakhau'));

    var hosoVG = [self.fiMaCqxl, self.fiTenDn, self.fiDiachiDn, self.fiSoGtVb, self.fiDiachiDn, self.fiSdtDn
                , self.fiSoGpVtdb, self.fiNgaycapGp, self.fiMaTuyen, self.fiNgayNgung,
        self.fiMstDn, self.fiTenNgKy, self.fiDiaDiem2,  self.fiFaxDn];

    self.hosoErrors = ko.validation.group(hosoVG, {deep: true, live: true, observable: true});
    self.errorXeMessage = ko.observable(null);
    self.errorDinhKemMessage = ko.observable(null);
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

            self.fiSoGtVb(hoso.hasOwnProperty('fiSoGtVb') ? hoso.fiSoGtVb : null);
            self.fiSoGpVtdb(hoso.hasOwnProperty('fiSoGpVtdb') ? hoso.fiSoGpVtdb : null);
            self.fiNgaycapGp(hoso.hasOwnProperty('fiNgaycapGp') && hoso.fiNgaycapGp != null ? new Date(hoso.fiNgaycapGp) : null);

            self.fiMaTuyen(hoso.hasOwnProperty('fiMaTuyen') ? hoso.fiMaTuyen : null);
            self.fiTenTuyen(hoso.hasOwnProperty('fiTenTuyen') ? new Date(hoso.fiTenTuyen) : null);
            self.fiBenDi(hoso.hasOwnProperty('fiBenDi') ? hoso.fiBenDi : null);
            self.fiMaTinhDi(hoso.hasOwnProperty('fiMaTinhDi') ? hoso.fiMaTinhDi : null);
            self.fiTenTinhDi(hoso.hasOwnProperty('fiTenTinhDi') ? hoso.fiTenTinhDi : null);
            self.fiMaTinhDen(hoso.hasOwnProperty('fiMaTinhDen') ? hoso.fiMaTinhDen : null);
            self.fiTenTinhDen(hoso.hasOwnProperty('fiTenTinhDen') ? hoso.fiTenTinhDen : null);
            self.fiBenDen(hoso.hasOwnProperty('fiBenDen') ? hoso.fiBenDen : null);
            self.fiKhoangcach(hoso.hasOwnProperty('fiKhoangcach') ? hoso.fiKhoangcach : null);
            self.fiHanhtrinh(hoso.hasOwnProperty('fiHanhtrinh') ? hoso.fiHanhtrinh : null);
            self.fiMaCkXn(hoso.hasOwnProperty('fiMaCkXn') ? hoso.fiMaCkXn : null);
            self.fiTenCkXn(hoso.hasOwnProperty('fiTenCkXn') ? hoso.fiTenCkXn : null);

            self.fiTenNgKy(hoso.hasOwnProperty('chuKyDoanhNghiep') ? hoso.chuKyDoanhNghiep.fiTenNgKy : null);
            self.fiChucDanh(hoso.hasOwnProperty('chuKyDoanhNghiep') ? hoso.chuKyDoanhNghiep.fiChucDanh : null);
            self.fiDiaDiem2(hoso.hasOwnProperty('chuKyDoanhNghiep') ? hoso.chuKyDoanhNghiep.fiDiaDiem : null);

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

            self.fiDiaDiem(hoso.hasOwnProperty('fiDiaDiem') ? hoso.fiDiaDiem : null);
            self.fiNgayDk(hoso.hasOwnProperty('fiNgayDk') ? new Date(hoso.fiNgayDk) : null);
            self.fiNgayNgung(hoso.hasOwnProperty('fiNgayNgung') ? new Date(hoso.fiNgayNgung) : null);
            self.fiNgayDchinh(hoso.hasOwnProperty('fiNgayDchinh') ? new Date(hoso.fiNgayDchinh) : null);
            self.fiSoVb(hoso.hasOwnProperty('fiSoVb') ? hoso.fiSoVb : null);
            self.fiNgaycapVb(hoso.hasOwnProperty('fiNgaycapVb') && hoso.fiNgaycapVb !=null  ? new Date(hoso.fiNgaycapVb) : null);

            self.fiSoChuyen(hoso.hasOwnProperty('fiSoChuyen') ? hoso.fiSoChuyen : null);

            self.lstXe(mapTbdhsXe2(hoso.hasOwnProperty('lstXe') ? hoso.lstXe : []));
            self.lstDinhKem(mapFilesVM(hoso.hasOwnProperty('lstDinhKem') ? hoso.lstDinhKem : [], self.fiIdHoso()));
        } else {
            self.lstDinhKem(mapFilesVM(options.lstDinhKem, self.fiIdHoso()));
        }

        if (!self.fiMaCqxl()) {
            self.fiMaCqxl('TCDBVN');
            self.fiTenCqxl('Tổng Cục Đường Bộ Việt Nam');
        }

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

        //Kiem tra thong tin dinh kem
        if (!self.lstDinhKem() || self.lstDinhKem().length <= 0) {
            self.errorDinhKemMessage('* Chưa khai báo thông tin đính kèm');
            errorDinhkem = false;
            return errorDinhkem;
        }else {
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

        return errorHoso && errorDinhkem;
    };
    //VALIDATE DATA ON FORM

    //XU LY SU KIEN BUTTON, TABLE
    //XU LY SU KIEN BUTTON, TABLE

    //Convert to json object
    self.toJSON = function () {
        var exclude = ["isValidForm", "init",
            "hosoErrors", "hosoErrors", "lstDonViXuLy", "lstTuyen", "lstLoaiXe", "lstCuaKhauDiDen",
            "toJSON", "lstCuaKhauXuatNhap", "__ko_mapping__", 'fiDiaDiem2', 'fiChucDanh', 'fiTenNgKy',
            'errorXeMessage', 'errorDinhKemMessage'];

        var copy = ko.toJS(self);
        for (var key in copy) {
            if (exclude.indexOf(key) >= 0) {
                delete copy[key];
            }
        }

        for (var i = 0; i < copy.lstDinhKem.length; i++) {
            delete copy.lstDinhKem[i]['canUpload'];
            delete copy.lstDinhKem[i]['canDownload'];
            delete copy.lstDinhKem[i]['canDelete'];
            delete copy.lstDinhKem[i]['doUpload'];
            delete copy.lstDinhKem[i]['doDelete'];
            delete copy.lstDinhKem[i]['downloadUrl'];
            delete copy.lstDinhKem[i]["__ko_mapping__"];
            delete copy.lstDinhKem[i]['fiBatBuoc'];
            delete copy.lstDinhKem[i]['isRequire'];
        }

        //Fill chuKyDoanhNghiep object
        copy.chuKyDoanhNghiep = {
            fiDiaDiem: self.fiDiaDiem2(),
            fiChucDanh: self.fiChucDanh(),
            fiTenNgKy: self.fiTenNgKy()
        };

        delete copy['__ko_mapping__'];
        return copy;
    };
}

