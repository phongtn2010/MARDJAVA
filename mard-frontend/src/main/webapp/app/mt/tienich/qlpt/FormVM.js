/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function FormVM(options) {
    var self = this;
    var phuongtienInfo = (options !== null && options.hasOwnProperty('phuongtien')) ? options.phuongtien : null;

    //Thong tin chung
    self.fiIdXe = ko.observable(null);
    self.fiBksXe = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiSoKhung = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiSoMay = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiNamHsd = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiNamSx = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiMaQgia = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiTenQgia = ko.observable(null);
    self.fiMaNhanhieu = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
    });
    self.fiTenNhanhieu = ko.observable(null);
    self.fiMaLoaixe = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiTenLoaixe = ko.observable(null);
    self.fiSoGhe = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiMaMauson = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
    });
    self.fiTenMauson = ko.observable(null);
    self.fiTenChuxe = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });



    self.fiHoatdong = ko.observable(1);
    self.fiSua = ko.observable(1);
    self.fiNguoitao = ko.observable(null);
    self.fiNgaytao = ko.observable(null);
    self.fiNgCapnhat = ko.observable(null);


    //Danh muc
    self.lstLoaixe = ko.observableArray(mapCategory(options ? options.lstLoaixe : [], 'id', 'name'));
    self.lstMauson = ko.observableArray(mapCategory(options ? options.lstMauson : [], 'fiMaMauson', 'fiTenMauson'));
    self.lstNhanhieu = ko.observableArray(mapCategory(options ? options.lstNhanhieu : [], 'fiMaNhanhieu', 'fiTenHieu'));
    self.lstQuocgia = ko.observableArray(mapCategory(options ? options.lstQuocgia : [], 'fiMaQuocgia', 'fiTenQuocgia'));

    var phuongtienVG = [self.fiBksXe, self.fiSoKhung, self.fiSoMay, self.fiMaQgia
                , self.fiMaNhanhieu, self.fiMaLoaixe, self.fiSoGhe, self.fiTenChuxe
                , self.fiMaMauson, self.fiTenMauson, self,fiNamSx , self.fiNamHsd];

    self.phuongtienErrors = ko.validation.group(phuongtienVG, {deep: true, live: true, observable: true});
    self.errorXeMessage = ko.observable(null);
    self.errorDinhKemMessage = ko.observable(null);
    //Khoi tao gia tri Phương tiện
    self.init = function (phuongtien) {
        
        if (phuongtien !== null) {
            self.fiIdXe(phuongtien.hasOwnProperty('fiIdXe') ? phuongtien.fiIdXe : null);
            self.fiBksXe(phuongtien.hasOwnProperty('fiBksXe') ? phuongtien.fiBksXe : null);
            self.fiMaLoaixe(phuongtien.hasOwnProperty('fiMaLoaixe') ? phuongtien.fiMaLoaixe : null);
            self.fiTenLoaixe(phuongtien.hasOwnProperty('fiTenLoaixe') ? phuongtien.fiTenLoaixe : null);
            self.fiMaMauson(phuongtien.hasOwnProperty('fiMaMauson') ? phuongtien.fiMaMauson : null);
            self.fiTenMauson(phuongtien.hasOwnProperty('fiTenMauson') ? phuongtien.fiTenMauson : null);
            self.fiMaNhanhieu(phuongtien.hasOwnProperty('fiMaNhanhieu') ? phuongtien.fiMaNhanhieu : null);
            self.fiTenNhanhieu(phuongtien.hasOwnProperty('fiTenNhanhieu') ? phuongtien.fiTenNhanhieu : null);
            self.fiMaQgia(phuongtien.hasOwnProperty('fiMaQgia') ? phuongtien.fiMaQgia : null);
            self.fiTenQgia(phuongtien.hasOwnProperty('fiTenQgia') ? phuongtien.fiTenQgia : null);
            self.fiNamHsd(phuongtien.hasOwnProperty('fiNamHsd') ? phuongtien.fiNamHsd : null);
            self.fiNamSx(phuongtien.hasOwnProperty('fiNamSx') ? phuongtien.fiNamSx : null);
            self.fiSoGhe(phuongtien.hasOwnProperty('fiSoGhe') ? phuongtien.fiSoGhe : null);
            self.fiSoKhung(phuongtien.hasOwnProperty('fiSoKhung') ? phuongtien.fiSoKhung : null);
            self.fiSoMay(phuongtien.hasOwnProperty('fiSoMay') ? phuongtien.fiSoMay : null);
            self.fiTenChuxe(phuongtien.hasOwnProperty('fiTenChuxe') ? phuongtien.fiTenChuxe : null);

            self.fiNgaytao(phuongtien.hasOwnProperty('fiNgaytao') ? new Date(phuongtien.fiNgaytao) : null);
            self.fiNguoitao(phuongtien.hasOwnProperty('fiNguoitao') ? phuongtien.fiNguoitao : null);

        }

    };

    self.init(phuongtienInfo);

    //VALIDATE DATA ON FORM
    //Remove from toJSON
    self.isValidForm = function () {
        //Kiem tra thong tin Phương tiện
        var errorphuongtien = true;
        if (self.phuongtienErrors().length > 0) {
            self.phuongtienErrors.showAllMessages();
            
            app.Alert('Phải nhập đúng và đủ thông tin các trường dữ liệu yêu cầu (đánh dấu màu đỏ).');
            errorphuongtien = false;
            return errorphuongtien;
        }
//        if (self.fiNamHsd() === '' || self.fiNamHsd() === null
//                || self.fiNamHsd() === undefined) {
//            app.Alert("Năm hết niên hạn sử dụng chưa được nhập");
//            errorphuongtien = false;
//            return errorphuongtien;
//        }
//        if (self.fiNamSx() === '' || self.fiNamSx() === null
//                || self.fiNamSx() === undefined) {
//            app.Alert("Năm sản xuất chưa được nhập");
//            errorphuongtien = false;
//            return errorphuongtien;
//        }
        if (new Date(self.fiNamSx()).getTime() > new Date(self.fiNamHsd()).getTime()) {
            app.Alert("Năm sản xuất không được lớn hơn Năm hết niên hạn sử dụng");
            errorphuongtien = false;
            return errorphuongtien;
        }
        if (self.fiNamSx() > new Date().getFullYear()) {
            app.Alert("Năm sản xuất không được lớn hơn Năm hiện tại");
            errorphuongtien = false;
            return errorphuongtien;
        }
        if (self.fiNamHsd() < new Date().getFullYear()) {
            app.Alert("Năm hết niên hạn sử dụng không được bé hơn Năm hiện tại");
            errorphuongtien = false;
            return errorphuongtien;
        }


        return errorphuongtien;
    };



    //Convert to json object
    self.toJSON = function () {
        var exclude = ["isValidForm", "init", "phuongtienErrors", "lstLoaixe", "lstMauson", "lstNhanhieu", "lstQuocgia",
            "toJSON", "__ko_mapping__"];

        var copy = ko.toJS(self);

        for (var key in copy) {
            if (exclude.indexOf(key) >= 0) {
                delete copy[key];
            }
        }

        delete copy['__ko_mapping__'];
        return copy;
    };
}

