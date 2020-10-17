/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function FormPxkinVM(options) {
    var self = this;
    var pxKinInfo = (options !== null && options.hasOwnProperty('pxKin')) ? options.pxKin : null;

    self.fiIdPhieuKb = ko.observable(null);
    self.fiMaDongViPhongXa = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 100 ký tự', params: 100}
    });
    self.fiTenDongViPhongXa = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 200 ký tự', params: 200}
    });
    self.fiMaHieu = ko.observable(null);
    self.fiSoSeri = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiHangSanXuat = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 500 ký tự', params: 500}
    });
    self.fiHoatDo = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 15.3 ký tự', params: 15},
        pattern: {
            message: 'Bạn chỉ được nhập số hoặc số thập phân sau dấu chấm 3 chữ số ',
            params: /^[0-9]{1,12}(?:\.[0-9]{1,3})?$/
        }
    });
    self.fiHoatDoDonVi = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 15.3 ký tự', params: 15.3}
    });
    self.fiTenHoatDoDV = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 15.3 ký tự', params: 15.3}
    });
    self.fiNgayXacDinhHoatDo = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiMaMucDichSuDung = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
//    self.fiMucDichSuDungKhac = ko.observable(null);
    self.fiMucDichSuDungKhac = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiXuatXuNguon = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiXuatXuNguonNgaycap = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiXuatXuNguonSgp = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiCamKetTraLaiNguon = ko.observable(null);
    self.fiTbMaHieu = ko.observable(null);
    self.fiTenHoatDoDonVi = ko.observable(null);
    self.fiTbSoSeri = ko.observable(null);
    self.fiTbHangNuocSanXuat = ko.observable(null);
    self.fiTbNamSanXuat = ko.observable(null);
    self.fiTbDiDongCoDinh = ko.observable(null);
    self.fiTbNoiDat = ko.observable(null);
    self.fiTbKhoiLuongUrani = ko.observable(null);
    self.fiHsCapgiayphepPxkId = ko.observable(null);
    self.fiIdHoso = ko.observable(null);
    self.fiMaHoso = ko.observable(null);
    self.fiHoatdong = ko.observable(null);
    self.fiNguoitao = ko.observable(null);
    self.fiNgaytao = ko.observable(null);
    self.fiNgCapnhat = ko.observable(null);
    self.lstMucdichsudung = ko.observableArray([]);

    self.lstDongViPX = ko.observableArray(mapCategory(options ? options.lstDongViPX : [], 'fiMa', 'fiTenDongvi'));
    self.lstMucDichKin = ko.observableArray(mapCategory(options ? options.lstMucDichKin : [], 'fiMa', 'fiTen'));
    self.lstDongVi = ko.observableArray(mapCategory(options ? options.lstDongVi : [], 'fiId', 'fiName'));
    var pxKinVG = [self.fiMaDongViPhongXa, self.fiTenDongViPhongXa, self.fiHangSanXuat, self.fiHoatDo, self.fiHoatDoDonVi, self.fiNgayXacDinhHoatDo, self.fiMaMucDichSuDung, self.fiXuatXuNguon, self.fiXuatXuNguonNgaycap, self.fiXuatXuNguonSgp];
    self.pxKinErrors = ko.validation.group(pxKinVG, {deep: true, live: true, observable: true});

    self.errorradiopxkMessage = ko.observable(null);
    self.errormucdicpxkMessage = ko.observable(null);
    //Khoi tao gia tri ho so
    self.init = function (pxKin) {
        if (pxKin !== null) {
            self.fiIdPhieuKb(pxKin.hasOwnProperty('fiIdPhieuKb') ? pxKin.fiIdPhieuKb() : null);
            self.fiMaDongViPhongXa(pxKin.hasOwnProperty('fiMaDongViPhongXa') ? pxKin.fiMaDongViPhongXa() : null);
            self.fiTenDongViPhongXa(pxKin.hasOwnProperty('fiTenDongViPhongXa') ? pxKin.fiTenDongViPhongXa() : null);
            self.fiMaHieu(pxKin.hasOwnProperty('fiMaHieu') ? pxKin.fiMaHieu() : null);
            self.fiSoSeri(pxKin.hasOwnProperty('fiSoSeri') ? pxKin.fiSoSeri() : null);
            self.fiHangSanXuat(pxKin.hasOwnProperty('fiHangSanXuat') ? pxKin.fiHangSanXuat() : null);
            self.fiHoatDo(pxKin.hasOwnProperty('fiHoatDo') ? pxKin.fiHoatDo() : null);
            self.fiHoatDoDonVi(pxKin.hasOwnProperty('fiHoatDoDonVi') ? pxKin.fiHoatDoDonVi() : null);
            self.fiTenHoatDoDonVi(pxKin.hasOwnProperty('fiTenHoatDoDonVi') ? pxKin.fiTenHoatDoDonVi() : null);
            self.fiNgayXacDinhHoatDo(pxKin.hasOwnProperty('fiNgayXacDinhHoatDo') ? new Date(pxKin.fiNgayXacDinhHoatDo()) : null);
            self.fiMaMucDichSuDung(pxKin.hasOwnProperty('fiMaMucDichSuDung') ? pxKin.fiMaMucDichSuDung() : null);
            self.fiMucDichSuDungKhac(pxKin.hasOwnProperty('fiMucDichSuDungKhac') ? pxKin.fiMucDichSuDungKhac() : null);
            self.fiXuatXuNguon(pxKin.hasOwnProperty('fiXuatXuNguon') ? pxKin.fiXuatXuNguon() : null);
            self.fiXuatXuNguonNgaycap(pxKin.hasOwnProperty('fiXuatXuNguonNgaycap') ? new Date(pxKin.fiXuatXuNguonNgaycap()) : null);
            self.fiXuatXuNguonSgp(pxKin.hasOwnProperty('fiXuatXuNguonSgp') ? pxKin.fiXuatXuNguonSgp() : null);
            self.fiCamKetTraLaiNguon(pxKin.hasOwnProperty('fiCamKetTraLaiNguon') ? pxKin.fiCamKetTraLaiNguon() : null);
            self.fiTbMaHieu(pxKin.hasOwnProperty('fiTbMaHieu') ? pxKin.fiTbMaHieu() : null);
            self.fiTbSoSeri(pxKin.hasOwnProperty('fiTbSoSeri') ? pxKin.fiTbSoSeri() : null);
            self.fiTbHangNuocSanXuat(pxKin.hasOwnProperty('fiTbHangNuocSanXuat') ? pxKin.fiTbHangNuocSanXuat() : null);
            self.fiTbNamSanXuat(pxKin.hasOwnProperty('fiTbNamSanXuat') ? pxKin.fiTbNamSanXuat() : null);
            self.fiTbDiDongCoDinh(pxKin.hasOwnProperty('fiTbDiDongCoDinh') ? pxKin.fiTbDiDongCoDinh() : null);
            self.fiTbNoiDat(pxKin.hasOwnProperty('fiTbNoiDat') ? pxKin.fiTbNoiDat() : null);
            self.fiTbKhoiLuongUrani(pxKin.hasOwnProperty('fiTbKhoiLuongUrani') ? pxKin.fiTbKhoiLuongUrani() : null);
            self.fiHsCapgiayphepPxkId(pxKin.hasOwnProperty('fiHsCapgiayphepPxkId') ? pxKin.fiHsCapgiayphepPxkId() : null);
            self.fiIdHoso(pxKin.hasOwnProperty('fiIdHoso') ? pxKin.fiIdHoso() : null);
            self.fiMaHoso(pxKin.hasOwnProperty('fiMaHoso') ? pxKin.fiMaHoso() : null);
            self.fiHoatdong(pxKin.hasOwnProperty('fiHoatdong') ? pxKin.fiHoatdong() : null);
            self.fiNguoitao(pxKin.hasOwnProperty('fiNguoitao') ? pxKin.fiNguoitao() : null);
            self.fiNgaytao(pxKin.hasOwnProperty('fiNgaytao') ? new Date(pxKin.fiNgaytao()) : null);
            self.fiNgCapnhat(pxKin.hasOwnProperty('fiNgCapnhat') ? pxKin.fiNgCapnhat() : null);

            //covert string to array
            var array = self.fiMaMucDichSuDung().split(";");
            self.lstMucdichsudung(array);
        }
    }
    self.init(pxKinInfo);

    self.mucdichAction = function () {
        var array = self.lstMucdichsudung();
        var found = array.find(function (element) {
            return element == 10;
        });
        if (found != null) {
            $(".fiMucDichSuDungKhac").css("display", "inline");
        } else {
            $(".fiMucDichSuDungKhac").css("display", "none");
        }
        if(self.lstMucdichsudung().length==0){
            $('#lstMDsudung').show();
        }else{
            $('#lstMDsudung').hide();
        }
        
    }
    self.isValAction = function () {
        var array = self.lstMucdichsudung();
        var found = array.find(function (element) {
            return element == 10;
        });
        if (found != null) {
            if (self.fiMucDichSuDungKhac() == null || self.fiMucDichSuDungKhac() == "") {
//                 self.fiMucDichSuDungKhac = ko.observable(null).extend({
//                    required: {message: NSWLang["common_msg_formvaild_required"], params: true}
//                });
                pxKinVG.push(self.fiMucDichSuDungKhac);
            }
            self.pxKinErrors = ko.validation.group(pxKinVG, {deep: true, live: true, observable: true});
        }
        
    }

    self.toJSON = function () {



        var exclude = ["getDetailXe", "lsgetDetailXetLoaiXe", "lstCuaKhauXuatNhap", "lstXe", "lstTuyen",
            "toJSON", "__ko_mapping__", "errors", "isValid"];

        var model = ko.toJS(self);

        for (var key in model) {
            if (exclude.indexOf(key) >= 0) {
                delete model[key];
            }
        }

        return model;
    };
     self.ngaycapPXKValid = function(){
        if (self.fiXuatXuNguonNgaycap() == null) {
            $("#valid-XXngayCap").show();
        } else {
            $("#valid-XXngayCap").hide();
        }
    }
    self.ngayXacDinhHDValid = function(){
        if (self.fiNgayXacDinhHoatDo() == null) {
            $("#valid-NgayXacDinhHD").show();
        } else {
            $("#valid-NgayXacDinhHD").hide();
        }
    }
    self.camketTLN = function(){
         if ($('#rdKhong').prop('checked')||$('#rdCo').prop('checked')) {
            $("#valid_camketNguon").hide();
        } 
    }
    
    self.isValid = function () {
        if ($('#rdDiDong').prop('checked')) {
            self.fiTbDiDongCoDinh(1);
        }
        if ($('#rdCoDinh').prop('checked')) {
            self.fiTbDiDongCoDinh(2);
        }
        if ($('#rdKhong').prop('checked')) {
            self.fiCamKetTraLaiNguon(1);
        }
        if ($('#rdCo').prop('checked')) {
            self.fiCamKetTraLaiNguon(2);
        }
        if (self.fiNgayXacDinhHoatDo() == null) {
            $("#valid-NgayXacDinhHD").show();
        }
        if (self.fiXuatXuNguonNgaycap() == null) {
            $("#valid-XXngayCap").show();
        } 
         if (self.fiCamKetTraLaiNguon() == null) {
            self.errorradiopxkMessage('Thông tin bắt buộc nhập');
            errorradiopxk = true;
            return errorradiopxk;
        }
        //covert array to string
        if (self.lstMucdichsudung().length > 0) {
            var lstmucdich = "";
            for (var i = 0; i < self.lstMucdichsudung().length; i++) {
                if (i == 0) {
                    lstmucdich = self.lstMucdichsudung()[0];
                } else {
                    lstmucdich = lstmucdich + ";" + self.lstMucdichsudung()[i];
                }
                self.fiMaMucDichSuDung(lstmucdich);
            }
        }
        self.isValAction();
        var errorradiopxk = true;
        var errormucdicpxk = true;
        self.errorradiopxkMessage(null);
        self.errormucdicpxkMessage(null);
        if (self.lstMucdichsudung().length <= 0) {
            $('#lstMDsudung').show();
            errormucdicpxk = true;
            return errormucdicpxk;
        }
       

//        if(self.fiCamKetTraLaiNguon == null){
//              $("#valid-CamKet").show();
//        } else {
//            $("#valid-CamKet").hide();
//        }
        
        if (self.pxKinErrors().length > 0) {
            self.pxKinErrors.showAllMessages();
            return true;
        }
        
    };

}
function FormPxKinQsdVM(options) {

    var self = this;
    var pxKinQsdInfo = (options !== null && options.hasOwnProperty('pxKinQsd')) ? options.pxKinQsd : null;
    self.STT = ko.observable(pxKinQsdInfo ? pxKinQsdInfo.STT() : null);

    self.fiIdNguonPxkPsd = ko.observable(null);
    self.fiMaDongViPhongXa = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 100 ký tự', params: 100}
    });
    self.fiTenDongViPhongXa = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiMaHieu = ko.observable(null);
    self.fiSoSeri = ko.observable(null);
    self.fiHangSanXuat = ko.observable(null);
    self.fiHoatDo = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 15.3 ký tự', params: 15},
        pattern: {
            message: 'Bạn chỉ được nhập số hoặc số thập phân sau dấu chấm 3 chữ số ',
            params: /^[0-9]{1,12}(?:\.[0-9]{1,3})?$/
        }
    });
    self.fiHoatDoDonVi = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiTenHoatDoDonVi = ko.observable(null);
    self.fiNgayXacDinhHoatDo = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiMaMucDichSuDung = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiMucDichSuDungKhac = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiTbMaHieu = ko.observable(null);
    self.fiTbSoSeri = ko.observable(null);
    self.fiTbHangSanXuat = ko.observable(null);
    self.fiTbMoTaHienTrang = ko.observable(null);
    self.fiXlBienPhapXuLy = ko.observable(null);
    self.fiXlDiaDiemLuuGiu = ko.observable(null);
    self.fiHsCapgiayphepPxkId = ko.observable(null);
    self.fiIdHoso = ko.observable(null);
    self.fiMaHoso = ko.observable(null);
    self.fiHoatdong = ko.observable(null);
    self.fiNguoitao = ko.observable(null);
    self.fiNgaytao = ko.observable(null);
    self.fiNgCapnhat = ko.observable(null);

    self.fiTbNamSanXuat = ko.observable(null);
    self.lstMucdichsudungqsd = ko.observableArray([]);

    self.lstDongViPX = ko.observableArray(mapCategory(options ? options.lstDongViPX : [], 'fiMa', 'fiTenDongvi'));
    self.lstMucDichKinQsd = ko.observableArray(mapCategory(options ? options.lstMucDichKin : [], 'fiMa', 'fiTen'));
    self.lstDongVi = ko.observableArray(mapCategory(options ? options.lstDongVi : [], 'fiId', 'fiName'));

    var pxKinQsdVG = [self.fiMaDongViPhongXa, self.fiTenDongViPhongXa,self.fiHoatDoDonVi, self.fiNgayXacDinhHoatDo, self.lstMucdichsudungqsd];
    self.pxKinQsdError = ko.validation.group(pxKinQsdVG, {deep: true, live: true, observable: true});

    self.errormucdicpxkqsdMessage = ko.observable(null);

    //Khoi tao gia tri ho so
    self.init = function (pxKinQsd) {
        if (pxKinQsd !== null) {

            self.fiIdNguonPxkPsd(pxKinQsd.hasOwnProperty('fiIdNguonPxkPsd') ? pxKinQsd.fiIdNguonPxkPsd() : null);
            self.fiMaDongViPhongXa(pxKinQsd.hasOwnProperty('fiMaDongViPhongXa') ? pxKinQsd.fiMaDongViPhongXa() : null);
            self.fiTenDongViPhongXa(pxKinQsd.hasOwnProperty('fiTenDongViPhongXa') ? pxKinQsd.fiTenDongViPhongXa() : null);
            self.fiMaHieu(pxKinQsd.hasOwnProperty('fiMaHieu') ? pxKinQsd.fiMaHieu() : null);
            self.fiSoSeri(pxKinQsd.hasOwnProperty('fiSoSeri') ? pxKinQsd.fiSoSeri() : null);
            self.fiHangSanXuat(pxKinQsd.hasOwnProperty('fiHangSanXuat') ? pxKinQsd.fiHangSanXuat() : null);
            self.fiHoatDo(pxKinQsd.hasOwnProperty('fiHoatDo') ? pxKinQsd.fiHoatDo() : null);
            self.fiHoatDoDonVi(pxKinQsd.hasOwnProperty('fiHoatDoDonVi') ? pxKinQsd.fiHoatDoDonVi() : null);
            self.fiTenHoatDoDonVi(pxKinQsd.hasOwnProperty('fiTenHoatDoDonVi') ? pxKinQsd.fiTenHoatDoDonVi() : null);
            self.fiNgayXacDinhHoatDo(pxKinQsd.hasOwnProperty('fiNgayXacDinhHoatDo') ? new Date(pxKinQsd.fiNgayXacDinhHoatDo()) : null);
            self.fiMaMucDichSuDung(pxKinQsd.hasOwnProperty('fiMaMucDichSuDung') ? pxKinQsd.fiMaMucDichSuDung() : null);
            self.fiMucDichSuDungKhac(pxKinQsd.hasOwnProperty('fiMucDichSuDungKhac') ? pxKinQsd.fiMucDichSuDungKhac() : null);
            self.fiTbMaHieu(pxKinQsd.hasOwnProperty('fiTbMaHieu') ? pxKinQsd.fiTbMaHieu() : null);
            self.fiTbSoSeri(pxKinQsd.hasOwnProperty('fiTbSoSeri') ? pxKinQsd.fiTbSoSeri() : null);
            self.fiTbHangSanXuat(pxKinQsd.hasOwnProperty('fiTbHangSanXuat') ? pxKinQsd.fiTbHangSanXuat() : null);
            self.fiTbMoTaHienTrang(pxKinQsd.hasOwnProperty('fiTbMoTaHienTrang') ? pxKinQsd.fiTbMoTaHienTrang() : null);
            self.fiXlBienPhapXuLy(pxKinQsd.hasOwnProperty('fiXlBienPhapXuLy') ? pxKinQsd.fiXlBienPhapXuLy() : null);
            self.fiXlDiaDiemLuuGiu(pxKinQsd.hasOwnProperty('fiXlDiaDiemLuuGiu') ? pxKinQsd.fiXlDiaDiemLuuGiu() : null);
            self.fiHsCapgiayphepPxkId(pxKinQsd.hasOwnProperty('fiHsCapgiayphepPxkId') ? pxKinQsd.fiHsCapgiayphepPxkId() : null);
            self.fiIdHoso(pxKinQsd.hasOwnProperty('fiIdHoso') ? pxKinQsd.fiIdHoso() : null);
            self.fiMaHoso(pxKinQsd.hasOwnProperty('fiMaHoso') ? pxKinQsd.fiMaHoso() : null);
            self.fiHoatdong(pxKinQsd.hasOwnProperty('fiHoatdong') ? pxKinQsd.fiHoatdong() : null);
            self.fiNguoitao(pxKinQsd.hasOwnProperty('fiNguoitao') ? pxKinQsd.fiNguoitao() : null);
            self.fiNgaytao(pxKinQsd.hasOwnProperty('fiNgaytao') ? new Date(pxKinQsd.fiNgaytao()) : null);
            self.fiNgCapnhat(pxKinQsd.hasOwnProperty('fiNgCapnhat') ? pxKinQsd.fiNgCapnhat() : null);
            self.fiTbNamSanXuat(pxKinQsd.hasOwnProperty('fiTbNamSanXuat') ? pxKinQsd.fiTbNamSanXuat() : null);
            var array = self.fiMaMucDichSuDung().split(";");
            self.lstMucdichsudungqsd(array);
        }
    }
    self.init(pxKinQsdInfo);


    self.mucdichqsdAction = function () {
        var array = self.lstMucdichsudungqsd();
        var found = array.find(function (element) {
            return element == 10;
        });
        if (found != null) {
            $(".fiMucDichSuDungKhac").css("display", "inline");
        } else {
            $(".fiMucDichSuDungKhac").css("display", "none");
        }
        if(self.lstMucdichsudungqsd().length==0){
            $('#lstMDsudungQsd').show();
        }else{
            $('#lstMDsudungQsd').hide();
        }
    }
    
    self.isValqsdAction = function () {
        var array = self.lstMucdichsudungqsd();
        var found = array.find(function (element) {
            return element == 10;
        });
        if (found != null) {
            if (self.fiMucDichSuDungKhac() == null || self.fiMucDichSuDungKhac() == "") {
                pxKinQsdVG.push(self.fiMucDichSuDungKhac);
            }
            self.pxKinQsdError = ko.validation.group(pxKinQsdVG, {deep: true, live: true, observable: true});
        }
    }
    
    self.ngayXacDinhHDQSDValid = function(){
        if (self.fiNgayXacDinhHoatDo() == null) {
            $("#valid-NgayXacDinhHDQSD").show();
        } else {
            $("#valid-NgayXacDinhHDQSD").hide();
        }
    }
    
    self.isValid = function () {
        self.isValqsdAction();
        var errormucdicpxkqsd = true;
         if (self.fiNgayXacDinhHoatDo() == null) {
            $("#valid-NgayXacDinhHDQSD").show();
        }
        self.errormucdicpxkqsdMessage(null);
        if (self.lstMucdichsudungqsd().length <= 0) {
            $('#lstMDsudungQsd').show();
            errormucdicpxkqsd = true;
            return errormucdicpxkqsd;
        }
       
        if (self.pxKinQsdError().length > 0) {
            self.pxKinQsdError.showAllMessages();
            return true;
        }
        
        
    };
    self.toJSON = function () {
        //covert array to string
        if (self.lstMucdichsudungqsd().length > 0) {
            var lstmucdichqsd = "";
            for (var i = 0; i < self.lstMucdichsudungqsd().length; i++) {
                if (i == 0) {
                    lstmucdichqsd = self.lstMucdichsudungqsd()[0];
                } else {
                    lstmucdichqsd = lstmucdichqsd + ";" + self.lstMucdichsudungqsd()[i];
                }
                self.fiMaMucDichSuDung(lstmucdichqsd);
            }
        }

        var exclude = ["getDetailXe", "lsgetDetailXetLoaiXe", "lstCuaKhauXuatNhap", "lstXe", "lstTuyen",
            "toJSON", "__ko_mapping__", "errors", "isValid"];

        var model = ko.toJS(self);

        for (var key in model) {
            if (exclude.indexOf(key) >= 0) {
                delete model[key];
            }
        }

        return model;
    };
}
function FormPxHoVM(options) {
    var self = this;
    var pxHoInfo = (options !== null && options.hasOwnProperty('pxHo')) ? options.pxHo : null;
    self.STT = ko.observable(pxHoInfo ? pxHoInfo.STT() : null);
    self.fiIdKbNguonPxh = ko.observable(null);
    self.fiMaDongViPhongXa = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 100 ký tự', params: 100}
    });
    self.fiTenDongViPhongXa = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiMaHieu = ko.observable(null);
    self.fiHangNuocSanXuat = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });

  self.fiHoatDo = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 15.3 ký tự', params: 15},
        pattern: {
            message: 'Bạn chỉ được nhập số hoặc số thập phân sau dấu chấm 3 chữ số ',
            params: /^[0-9]{1,12}(?:\.[0-9]{1,3})?$/
        }
    });
    self.fiHoatDoDonVi = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiMaMucDichSuDung = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiMucDichSuDungKhac = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiHsCapgiayphepPxkId = ko.observable(null);
    self.fiIdHoso = ko.observable(null);
    self.fiMaHoso = ko.observable(null);
    self.fiHoatdong = ko.observable(null);
    self.fiNguoitao = ko.observable(null);
    self.fiNgaytao = ko.observable(null);
    self.fiNgaycapnhat = ko.observable(null);
    self.fiTrangThaiVatLy = ko.observable(null);
    self.fiCongThucHoaHoc = ko.observable(null);

    self.lstMucdichsudungho = ko.observableArray([]);

//    var nguoiApTaiVG = [self.fiTenNguoidk, self.fiSocmndNguoidk, self.fiBksPhuongtien]

    self.lstDongViPX = ko.observableArray(mapCategory(options ? options.lstDongViPX : [], 'fiMa', 'fiTenDongvi'));
    self.lstMucDichHo = ko.observableArray(mapCategory(options ? options.lstMucDichHo : [], 'fiMa', 'fiTen'));
    self.lstDongVi = ko.observableArray(mapCategory(options ? options.lstDongVi : [], 'fiId', 'fiName'));

//    self.errorhsx = ko.observable(null);
//    self.errortdhd = ko.observable(null);


    var pxHoVG = [self.fiMaDongViPhongXa, self.fiHangNuocSanXuat, self.fiHoatDo, self.lstMucdichsudungho, self.fiHoatDoDonVi];
    self.pxHoError = ko.validation.group(pxHoVG, {deep: true, live: true, observable: true});

    self.errormucdicpxhMessage = ko.observable(null);

    //Khoi tao gia tri ho so
    self.init = function (pxHo) {

        if (pxHo !== null) {
            self.fiIdKbNguonPxh(pxHo.hasOwnProperty('fiIdKbNguonPxh') ? pxHo.fiIdKbNguonPxh() : null);
            self.fiMaDongViPhongXa(pxHo.hasOwnProperty('fiMaDongViPhongXa') ? pxHo.fiMaDongViPhongXa() : null);
            self.fiTenDongViPhongXa(pxHo.hasOwnProperty('fiTenDongViPhongXa') ? pxHo.fiTenDongViPhongXa() : null);
            self.fiMaHieu(pxHo.hasOwnProperty('fiMaHieu') ? pxHo.fiMaHieu() : null);
            self.fiHangNuocSanXuat(pxHo.hasOwnProperty('fiHangNuocSanXuat') ? pxHo.fiHangNuocSanXuat() : null);
            self.fiHoatDo(pxHo.hasOwnProperty('fiHoatDo') ? pxHo.fiHoatDo() : null);
            self.fiHoatDoDonVi(pxHo.hasOwnProperty('fiHoatDoDonVi') ? pxHo.fiHoatDoDonVi() : null);
            self.fiMaMucDichSuDung(pxHo.hasOwnProperty('fiMaMucDichSuDung') ? pxHo.fiMaMucDichSuDung() : null);
            self.fiMucDichSuDungKhac(pxHo.hasOwnProperty('fiMucDichSuDungKhac') ? pxHo.fiMucDichSuDungKhac() : null);
            self.fiHsCapgiayphepPxkId(pxHo.hasOwnProperty('fiHsCapgiayphepPxkId') ? pxHo.fiHsCapgiayphepPxkId() : null);
            self.fiIdHoso(pxHo.hasOwnProperty('fiIdHoso') ? pxHo.fiIdHoso() : null);
            self.fiMaHoso(pxHo.hasOwnProperty('fiMaHoso') ? pxHo.fiMaHoso() : null);
            self.fiHoatdong(pxHo.hasOwnProperty('fiHoatdong') ? pxHo.fiHoatdong() : null);
            self.fiNguoitao(pxHo.hasOwnProperty('fiNguoitao') ? pxHo.fiNguoitao() : null);
            self.fiNgaytao(pxHo.hasOwnProperty('fiNgaytao') ? new Date(pxHo.fiNgaytao()) : null);
            self.fiNgaycapnhat(pxHo.hasOwnProperty('fiNgaycapnhat') ? new Date(pxHo.fiNgaycapnhat()) : null);
            self.fiCongThucHoaHoc(pxHo.hasOwnProperty('fiCongThucHoaHoc') ? pxHo.fiCongThucHoaHoc() : null);
            self.fiTrangThaiVatLy(pxHo.hasOwnProperty('fiTrangThaiVatLy') ? pxHo.fiTrangThaiVatLy() : null);

            //covert string to array
            if(self.fiMaMucDichSuDung()!==null){ 
                var array = self.fiMaMucDichSuDung().split(";");
                self.lstMucdichsudungho(array);
            }
        }
    }
    self.init(pxHoInfo);

    self.mucdichhoAction = function () {
        var array = self.lstMucdichsudungho();
        var found = array.find(function (element) {
            return element == 10;
        });
        if (found != null) {
            $(".fiMucDichSuDungKhac").css("display", "inline");
        } else {
            $(".fiMucDichSuDungKhac").css("display", "none");
        }
        if(self.lstMucdichsudungho().length==0){
            $('#fiMaMucDichSuDungHo').show();
        }else{
            $('#fiMaMucDichSuDungHo').hide();
        }
    }
    self.isValhhoAction = function () {
        var array = self.lstMucdichsudungho();
        var found = array.find(function (element) {
            return element == 10;
        });
        if (found != null) {
            if (self.fiMucDichSuDungKhac() == null || self.fiMucDichSuDungKhac() == "") {
                pxHoVG.push(self.fiMucDichSuDungKhac);
            }
            self.pxHoError = ko.validation.group(pxHoVG, {deep: true, live: true, observable: true});
        }
    }
    self.isValid = function () {
        self.isValhhoAction();

       var errormucdicpxh = true;




//        self.errormucdicpxhMessage(null);
//        self.errorhsx(null);
//        self.errortdhd(null);

//        if (self.fiHangNuocSanXuat() === null) {
//            self.errorhsx('Thông tin bắt buộc nhập');
//            errormucdicpxh = true;
//        }
//        if (self.fiHoatDo() === null) {
//            self.errortdhd('Thông tin bắt buộc nhập');
//            errormucdicpxh = true;
//        }

        self.errormucdicpxhMessage(null);
        if (self.lstMucdichsudungho().length <= 0) {
             $('#fiMaMucDichSuDungHo').show();
            errormucdicpxh = true;
            return errormucdicpxh;
        }

        if (self.pxHoError().length > 0) {
            self.pxHoError.showAllMessages();
            return true;
        }
    };
    self.toJSON = function () {
        //covert array to string
        if (self.lstMucdichsudungho().length > 0) {
            var lstmucdichho = "";
            for (var i = 0; i < self.lstMucdichsudungho().length; i++) {
                if (i == 0) {
                    lstmucdichho = self.lstMucdichsudungho()[0];
                } else {
                    lstmucdichho = lstmucdichho + ";" + self.lstMucdichsudungho()[i];
                }
                self.fiMaMucDichSuDung(lstmucdichho);
            }
        }

        var exclude = ["getDetailXe", "lsgetDetailXetLoaiXe", "lstCuaKhauXuatNhap", "lstXe", "lstTuyen",
            "toJSON", "__ko_mapping__", "errors", "isValid"];

        var model = ko.toJS(self);

        for (var key in model) {
            if (exclude.indexOf(key) >= 0) {
                delete model[key];
            }
        }

        return model;
    };
}
function FormVM(options) {
    var self = this;
    var hosoInfo = (options !== null && options.hasOwnProperty('hoso')) ? options.hoso : null;

    //Thong tin chung
    self.fiIdHoso = ko.observable(null);
    self.fiMaHoso = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 50 ký tự', params: 50}
    });
    self.fiMaCoQuan = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 100 ký tự', params: 100}
    });
    self.fiSoGiayPhep = ko.observable(null);
    self.fiTenCoQuan = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiHinhThucCap = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 1 ký tự', params: 1}
    });
    self.fiNgayCap = ko.observable(null);
    self.fiTtcTenToChuc = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiTtcDiaChi = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiTtcDienThoai = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiTtTiepNhanEmail = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        email: {message: 'Email không đúng định dạng', params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiTtTiepNhanFax = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiTtTiepNhanQuocgia = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiTtcFax = ko.observable(null);
    self.fiLydo = ko.observable(null);
    self.fiTtcEmail = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        email: {message: 'Email không đúng định dạng', params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiNddHoTen = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiNddChucVu = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiNddCmnd = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiTtTiepNhanTen = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiTtTiepNhanDiaChi = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiTtTiepNhanDienThoai = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiNkcpxNgayDuKien = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiNkcpxMaTinh = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 100 ký tự', params: 100}
    });
    self.fiNkcpxTenTinh = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiNkcpxMaCuaKhau = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 100 ký tự', params: 100}
    });
    self.fiNkcpxTenCuaKhau = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 500 ký tự', params: 500}
    });



    self.fiLydocaplai = ko.observable(null);

    self.fiTrangThai = ko.observable(null);
    self.fiNguoiTao = ko.observable(null);
    self.fiNgayTao = ko.observable(null);
    self.fiNgayCapNhat = ko.observable(null);
    self.fiHoatdong = ko.observable(null);
    self.fiMaHoso = ko.observable(null);
    self.fiNgaygui = ko.observable(null);
    self.fiNgayCapPhep = ko.observable(null);
    

    self.errorNgaydkxk = ko.observable(null);
    self.errorNc = ko.observable(null);

    self.fiNgayTiepnhan = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiTenTrangthai = ko.observable(null);

    self.lstTbdhsPhieuKbNguonPxk06 = ko.observableArray([]);
    self.lstTbdhsPhieuNguonPxkQsd06 = ko.observableArray([]);
    self.lstTbdhsPhieuKbNguonPxh06 = ko.observableArray([]);
    self.lstTbdhsTeptin06 = ko.observableArray([]);

    //Danh muc
    self.lstLyDoDN = ko.observableArray(mapCategory(options.hasOwnProperty('lstLyDoDN') ? options.lstLyDoDN : [], "id", "name"));
    self.lstDonViXuLy = ko.observableArray(mapCategory(options.hasOwnProperty('lstDonViXuLy') ? options.lstDonViXuLy : [], "fiMa", "fiTen"));
    self.lstTinhThanh = ko.observableArray(mapCategory(options.hasOwnProperty('lstTinhThanh') ? options.lstTinhThanh : [], "fiMa", "fiTen"));
    self.lstCuaKhau = ko.observableArray(mapCategory(options.hasOwnProperty('lstCuaKhau') ? options.lstCuaKhau : [], "fiMaCuakhau", "fiTenCuakhau"));
    self.lstHinhthucCap = ko.observableArray(mapCategory(options ? options.lstHinhthucCap : [], 'id', 'name'));
    self.lstDongViPX = ko.observableArray(mapCategory(options ? options.lstDongViPX : [], 'fiMa', 'fiTenDongvi'));
//    self.lstMucDichKin = ko.observableArray(mapCategory(options ? options.lstMucDichKin : [], 'fiMa', 'fiTen'));
    self.lstMucDichHo = ko.observableArray(mapCategory(options ? options.lstMucDichHo : [], 'fiMa', 'fiTen'));
    self.lstDongVi = ko.observableArray(mapCategory(options ? options.lstDongVi : [], 'fiId', 'fiName'));
    self.lstQuocgia = ko.observableArray(mapCategory(options ? options.lstQuocgia : [], 'fiMaQuocgia', 'fiTenQuocgia'));

    var hosoVG = [self.fiMaCoQuan, self.fiTenCoQuan, self.fiHinhThucCap, self.fiTtcTenToChuc, self.fiTtcDiaChi, self.fiTtcDienThoai, self.fiTtcEmail,
        self.fiNddHoTen, self.fiNddChucVu, self.fiNddCmnd, self.fiTtTiepNhanTen, self.fiTtTiepNhanDiaChi, self.fiTtTiepNhanDienThoai, self.fiTtTiepNhanEmail
                , self.fiTtTiepNhanQuocgia, self.fiNkcpxNgayDuKien, self.fiNkcpxMaTinh, self.fiNkcpxTenTinh, self.fiNkcpxMaCuaKhau, self.fiNkcpxTenCuaKhau, self.fiNgayTiepnhan];

    self.hosoErrors = ko.validation.group(hosoVG, {deep: true, live: true, observable: true});
    self.errorlistpxkMessage = ko.observable(null);
    self.errorlistpxkqsdMessage = ko.observable(null);
    self.errorlistpxhoMessage = ko.observable(null);

    self.errorDinhKemMessage = ko.observable(null);
    //Khoi tao gia tri ho so
    self.init = function (hoso) {
        self.fiTtcTenToChuc(hoso !== null && hoso.hasOwnProperty('fiTtcTenToChuc') ? hoso.fiTtcTenToChuc : user.companyName);
        self.fiTtcDiaChi(hoso !== null && hoso.hasOwnProperty('fiTtcDiaChi') ? hoso.fiTtcDiaChi : user.companyAddress);
        self.fiTtcDienThoai(hoso !== null && hoso.hasOwnProperty('fiTtcDienThoai') ? hoso.fiTtcDienThoai : user.companyPhoneNumber);
        if (hoso !== null) {

            self.fiIdHoso(hoso.hasOwnProperty('fiIdHoso') ? hoso.fiIdHoso : null);
            self.fiMaHoso(hoso.hasOwnProperty('fiMaHoso') ? hoso.fiMaHoso : null);
            self.fiSoGiayPhep(hoso.hasOwnProperty('fiSoGiayPhep') ? hoso.fiSoGiayPhep : null);
            self.fiTenCoQuan(hoso.hasOwnProperty('fiTenCoQuan') ? hoso.fiTenCoQuan : null);
            self.fiMaCoQuan(hoso.hasOwnProperty('fiMaCoQuan') ? hoso.fiMaCoQuan : null);

            self.fiHinhThucCap(hoso.hasOwnProperty('fiHinhThucCap') ? hoso.fiHinhThucCap : null);
            self.fiNgayCap(hoso.hasOwnProperty('fiNgayCap') && hoso.fiNgayCap != null ? new Date(hoso.fiNgayCap) : null);
            self.fiNgayCapPhep(hoso.hasOwnProperty('fiNgayCapPhep') && hoso.fiNgayCapPhep != null ? new Date(hoso.fiNgayCapPhep) : null);
            self.fiTtcTenToChuc(hoso.hasOwnProperty('fiTtcTenToChuc') ? hoso.fiTtcTenToChuc : null);
            self.fiTtcDiaChi(hoso.hasOwnProperty('fiTtcDiaChi') ? hoso.fiTtcDiaChi : null);
            self.fiTtcDienThoai(hoso.hasOwnProperty('fiTtcDienThoai') ? hoso.fiTtcDienThoai : null);
            self.fiTtcFax(hoso.hasOwnProperty('fiTtcFax') ? hoso.fiTtcFax : null);
            self.fiTtcEmail(hoso.hasOwnProperty('fiTtcEmail') ? hoso.fiTtcEmail : null);
            self.fiNddHoTen(hoso.hasOwnProperty('fiNddHoTen') ? hoso.fiNddHoTen : null);
            self.fiLydo(hoso.hasOwnProperty('fiLydo') ? hoso.fiLydo : null);

            self.fiNddChucVu(hoso.hasOwnProperty('fiNddChucVu') ? hoso.fiNddChucVu : null);
            self.fiNddCmnd(hoso.hasOwnProperty('fiNddCmnd') ? hoso.fiNddCmnd : null);
            self.fiTtTiepNhanTen(hoso.hasOwnProperty('fiTtTiepNhanTen') ? hoso.fiTtTiepNhanTen : null);
            self.fiTtTiepNhanDiaChi(hoso.hasOwnProperty('fiTtTiepNhanDiaChi') ? hoso.fiTtTiepNhanDiaChi : null);

            self.fiTtTiepNhanDienThoai(hoso.hasOwnProperty('fiTtTiepNhanDienThoai') ? hoso.fiTtTiepNhanDienThoai : null);
            self.fiTtTiepNhanEmail(hoso.hasOwnProperty('fiTtTiepNhanEmail') ? hoso.fiTtTiepNhanEmail : null);
            self.fiTtTiepNhanFax(hoso.hasOwnProperty('fiTtTiepNhanFax') ? hoso.fiTtTiepNhanFax : null);
            self.fiTtTiepNhanQuocgia(hoso.hasOwnProperty('fiTtTiepNhanQuocgia') ? hoso.fiTtTiepNhanQuocgia : null);
            self.fiNkcpxNgayDuKien(hoso.hasOwnProperty('fiNkcpxNgayDuKien') && hoso.fiNkcpxNgayDuKien != null ? new Date(hoso.fiNkcpxNgayDuKien) : null);
            self.fiNkcpxMaTinh(hoso.hasOwnProperty('fiNkcpxMaTinh') ? hoso.fiNkcpxMaTinh : null);
            self.fiNkcpxTenTinh(hoso.hasOwnProperty('fiNkcpxTenTinh') ? hoso.fiNkcpxTenTinh : null);
            self.fiNkcpxMaCuaKhau(hoso.hasOwnProperty('fiNkcpxMaCuaKhau') ? hoso.fiNkcpxMaCuaKhau : null);
            self.fiNkcpxTenCuaKhau(hoso.hasOwnProperty('fiNkcpxTenCuaKhau') ? hoso.fiNkcpxTenCuaKhau : null);
            self.fiTrangThai(hoso.hasOwnProperty('fiTrangThai') ? hoso.fiTrangThai : 1);
            self.fiNguoiTao(hoso.hasOwnProperty('fiNguoiTao') ? hoso.fiNguoiTao : null);
            self.fiNgayTao(hoso.hasOwnProperty('fiNgayTao') && hoso.fiNgayTao != null ? new Date(hoso.fiNgayTao) : null);
            self.fiNgayCapNhat(hoso.hasOwnProperty('fiNgayCapNhat') && hoso.fiNgayCapNhat != null ? new Date(hoso.fiNgayCapNhat) : null);
            self.fiHoatdong(hoso.hasOwnProperty('fiHoatdong') ? hoso.fiHoatdong : 1);
            self.fiNgaygui(hoso.hasOwnProperty('fiNgaygui') && hoso.fiNgaygui != null ? new Date(hoso.fiNgaygui) : null);
            self.fiNkcpxTenCuaKhau(hoso.hasOwnProperty('fiNkcpxTenCuaKhau') ? hoso.fiNkcpxTenCuaKhau : null);
            self.fiNgayTiepnhan(hoso.hasOwnProperty('fiNgayTiepnhan') && hoso.fiNgayTiepnhan != null ? new Date(hoso.fiNgayTiepnhan) : null);
            self.fiLydocaplai(hoso.hasOwnProperty('fiLydocaplai') ? hoso.fiLydocaplai : null);
            




            self.lstTbdhsPhieuKbNguonPxk06(mapTbdhsPhieuKbNguonPxk06(hoso.hasOwnProperty('lstTbdhsPhieuKbNguonPxk06') ? hoso.lstTbdhsPhieuKbNguonPxk06 : []));
            self.lstTbdhsPhieuNguonPxkQsd06(mapTbdhsPhieuNguonPxkQsd06(hoso.hasOwnProperty('lstTbdhsPhieuNguonPxkQsd06') ? hoso.lstTbdhsPhieuNguonPxkQsd06 : []));
            self.lstTbdhsPhieuKbNguonPxh06(mapTbdhsPhieuKbNguonPxh06(hoso.hasOwnProperty('lstTbdhsPhieuKbNguonPxh06') ? hoso.lstTbdhsPhieuKbNguonPxh06 : []));
//            self.lstTbdhsTeptin06(mapFilesVM(hoso.hasOwnProperty('lstTbdhsTeptin06') ? hoso.lstTbdhsTeptin06 : [], self.fiMaHoso()));

            setTenTrangthai(self.fiTrangThai());

        }


//        $("#fiMaCqxl").val(self.fiMaCqxl()).select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
    };
    var setTenTrangthai = function (fiTrangThai) {
        for (var i = 0; i < RAW_HS_STATUS.length > 0; i++) {
            if (RAW_HS_STATUS[i].id == fiTrangThai) {
                self.fiTenTrangthai(RAW_HS_STATUS[i].name);
            }
        }
    };

    self.init(hosoInfo);

    //validate phong xa kin hoac phong xa ho
    self.isValidPhongXa = function () {
        var flag = false;

        if (self.lstTbdhsPhieuKbNguonPxk06().length > 0 ||
                self.lstTbdhsPhieuNguonPxkQsd06().length > 0 ||
                self.lstTbdhsPhieuKbNguonPxh06().length > 0) {
            flag = true;
        }


        return flag;
    }
   
    self.ngayDukienXKValid = function(){
        if (self.fiNkcpxNgayDuKien() == null) {
            $("#fiNkcpxNgayDuKien-lbl").show();
        } else {
            $("#fiNkcpxNgayDuKien-lbl").hide();
        }
    }
    
    self.ngayDukienValid = function(){
        if (self.fiNgayTiepnhan() == null) {
            $("#valid-ngayCapDk").show();
        } else {
            $("#valid-ngayCapDk").hide();
        }
         if (self.fiNkcpxNgayDuKien() == null) {
            $("#fiNkcpxNgayDuKien-lbl").show();
        } else {
            $("#fiNkcpxNgayDuKien-lbl").hide();
        }
    }

    
    //Remove from toJSON
    self.isValidForm = function () {
        //Kiem tra thong tin Ho so
//        delete self.xeVM;
        delete self.pop;

        var errorHoso = true;
        var errorpxk = true;
        var errorpxkqsd = true;
        var errorpxh = true;
        var errorDinhkem = true;
        
        if (self.fiNkcpxNgayDuKien() == null) {
            $("#fiNkcpxNgayDuKien-lbl").show();
        }
        
        if (self.fiNgayTiepnhan() == null) {
            $("#valid-ngayCapDk").show();
        }
        if (self.fiNkcpxNgayDuKien() == null) {
            $("#fiNkcpxNgayDuKien-lbl").show();
        }
            
        
        self.errorNgaydkxk(null);

        self.errorlistpxkMessage(null);
        self.errorlistpxkqsdMessage(null);
        self.errorlistpxhoMessage(null);
        self.errorDinhKemMessage(null);

        if (self.isValidht() === false) {
            errorHoso = false;
        }

        if (self.hosoErrors().length > 0) {
            self.hosoErrors.showAllMessages();
            errorHoso = false;
        }
        



        //Kiem tra thong tin dinh kem
        if (self.fiHinhThucCap() != 2) {
            if (!self.lstTbdhsTeptin06() || self.lstTbdhsTeptin06().length <= 0) {
                self.errorDinhKemMessage('* Chưa khai báo thông tin đính kèm');
                errorDinhkem = false;
                return errorDinhkem;
            } else {
                self.errorDinhKemMessage(null);
            }

            if (self.lstTbdhsTeptin06() && self.lstTbdhsTeptin06().length > 0) {
                for (var i = 0; i < self.lstTbdhsTeptin06().length; i++) {
                    var attach = self.lstTbdhsTeptin06()[i];
                    if (attach.isRequire()) {
                        if (!attach.fiIdTailieu() || !attach.fiTenTep() || !attach.fiDuongDan()) {
                            errorDinhkem = false;
                            self.errorDinhKemMessage('* Chưa khai báo thông tin đính kèm');
                            break;
                        }
                    }
                }
            }
        }

        if (!errorDinhkem) {
            self.errorDinhKemMessage('* Cần bổ sung thêm file đính kèm!');
        }

//        return errorHoso && errorpxk && errorDinhkem;
        return errorHoso && errorDinhkem;
    };
    //VALIDATE DATA ON FORM

    //XU LY SU KIEN BUTTON, TABLE
    self.removePhieuKbNguonPxkOnClick = function (item) {
        if (item) {
            var pop = app.popup({
                title: 'Thông báo',
                html: '<b>Bạn có chắc chắn muốn xóa không?</b>',
                width: 450,
                buttons: [
                    {
                        name: NSWLang["common_button_toi_chac_chan"],
                        class: 'btn',
                        icon: 'fa-save',
                        action: function () {
                            app.popupRemove(pop.selector);
                            self.lstTbdhsPhieuKbNguonPxk06.remove(function (o) {
                                return o.fiIdPhieuKb() == item.fiIdPhieuKb();
                            });
                            for (var i = 0; i < self.lstTbdhsPhieuKbNguonPxk06().length; i++) {
                                self.lstTbdhsPhieuKbNguonPxk06()[i].fiStt(i + 1);
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
    };
    self.addPhieuKbNguonPxkOnClick = function () {
        self.addpxk(null);
        return false;
    }
    self.editPhieuKbNguonPxkOnClick = function (item) {
        self.addpxk(item, 'edit');
        return false;
    }
    self.addpxk = function (item, action) {
        var html = [
            $('#khaibaopxk-template').html()
        ].join('');

        delete self.pop;
        delete self.FormPxkinVM;
        options.pxKin = item;
        self.pxKinVM = new FormPxkinVM(options);
        self.pop = app.popup({
            title: 'Đặc tính của nguồn',
            html: html,
            width: 1024,
            buttons: [
                {
                    name: 'Lưu',
                    class: 'btn btn-save',
                    icon: 'fa-save',
                    action: function () {
                        if (self.pxKinVM.isValid()) {
                            app.Alert('Bạn phải nhập vào đầy đủ thông tin của hồ sơ phóng xạ kín');
                        } else {
                            var pxKinInfo = self.pxKinVM.toJSON();
                            var hoatdo = self.pxKinVM.lstDongVi().find(obj => obj.id === pxKinInfo.fiHoatDoDonVi);
                            pxKinInfo.fiTenHoatDoDonVi = hoatdo.name;
                            if (null == pxKinInfo.fiIdPhieuKb) {
                                pxKinInfo.fiIdPhieuKb = -1 * new Date().getTime();
                                pxKinInfo.fiStt = self.lstTbdhsPhieuKbNguonPxk06().length + 1;
                                var pxKinModel = new TbdhsPhieuKbNguonPxk06(pxKinInfo);
                                self.lstTbdhsPhieuKbNguonPxk06.push(pxKinModel);
                            } else {
                                for (var i = 0; i < self.lstTbdhsPhieuKbNguonPxk06().length; i++) {
                                    if (pxKinInfo.fiIdPhieuKb == self.lstTbdhsPhieuKbNguonPxk06()[i].fiIdPhieuKb()) {
                                        var pxKinModel = new TbdhsPhieuKbNguonPxk06(pxKinInfo);
                                        self.lstTbdhsPhieuKbNguonPxk06.replace(self.lstTbdhsPhieuKbNguonPxk06()[i], pxKinModel);
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

        if (action != 'edit' && item != null && item.fiIdPhieuKb() > 0) {
            $(".btn-save").hide();
        }

        ko.applyBindings(self.pxKinVM, document.getElementById('khaibaopxk-vm'));
        var array = self.pxKinVM.lstMucdichsudung();
        var found = array.find(function (element) {
            return element == 10;
        });
        if (found != null) {
            $(".fiMucDichSuDungKhac").css("display", "inline");
        } else {
            $(".fiMucDichSuDungKhac").css("display", "none");
        }
        $("#fiTenDongViPhongXa").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
        $("#fiMaDongViPhongXa").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
        $("#fiMaMucDichSuDung").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
        $("#fixuatxu").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});

        if (self.pxKinVM.fiCamKetTraLaiNguon() == 1) {
            $('#rdKhong').prop('checked', true);
        }
        if (self.pxKinVM.fiCamKetTraLaiNguon() == 2) {
            $('#rdCo').prop('checked', true);
        }
        if (self.pxKinVM.fiTbDiDongCoDinh() == 1) {
            $('#rdDiDong').prop('checked', true);
        }
        if (self.pxKinVM.fiTbDiDongCoDinh() == 2) {
            $('#rdCoDinh').prop('checked', true);
        }
        return false;
    };
    self.addPxkQsdClick = function () {
        self.updatePxkQsd(null);
        return false;
    }
    self.editPxkQsdClick = function (item) {
        self.updatePxkQsd(item, 'edit');
        return false;
    }
    self.updatePxkQsd = function (item, action) {

        var html = [
            $('#khaibaopxkqsd-template').html()
        ].join('');
        delete self.pop;
//        delete self.xeVM;
        options.pxKinQsd = item;
        self.pxKinQsdVM = new FormPxKinQsdVM(options);
        self.pop = app.popup({
            title: 'Đặc tính của nguồn',
            html: html,
            width: 1024,
            buttons: [
                {
                    name: 'Lưu',
                    class: 'btn btn-save',
                    icon: 'fa-save',
                    action: function () {

                        if (self.pxKinQsdVM.isValid()) {
                            app.Alert('Bạn phải nhập vào đầy đủ thông tin của hồ sơ phóng xạ kín qua sử dụng');
                        } else {
                            var pxKinQsdInfo = self.pxKinQsdVM.toJSON();
                            var hoatdo = self.pxKinQsdVM.lstDongVi().find(obj => obj.id === pxKinQsdInfo.fiHoatDoDonVi);
                            pxKinQsdInfo.fiTenHoatDoDonVi = hoatdo.name;
                            if (null == pxKinQsdInfo.fiIdNguonPxkPsd) {
                                pxKinQsdInfo.fiIdNguonPxkPsd = -1 * new Date().getTime();
                                pxKinQsdInfo.STT = self.lstTbdhsPhieuNguonPxkQsd06().length + 1;

                                var pxKinQsdModel = new TbdhsPhieuNguonPxkQsd06(pxKinQsdInfo);
                                self.lstTbdhsPhieuNguonPxkQsd06.push(pxKinQsdModel);
                            } else {
                                for (var i = 0; i < self.lstTbdhsPhieuNguonPxkQsd06().length; i++) {
                                    if (pxKinQsdInfo.fiIdNguonPxkPsd == self.lstTbdhsPhieuNguonPxkQsd06()[i].fiIdNguonPxkPsd()) {
                                        var pxKinQsdModel = new TbdhsPhieuNguonPxkQsd06(pxKinQsdInfo);
                                        self.lstTbdhsPhieuNguonPxkQsd06.replace(self.lstTbdhsPhieuNguonPxkQsd06()[i], pxKinQsdModel);
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

        if (action != 'edit' && item != null && item.fiIdNguonPxkPsd() > 0) {
            $(".btn-save").hide();
        }

        ko.applyBindings(self.pxKinQsdVM, document.getElementById('khaibaopxkqsd-vm'));

        var array = self.pxKinQsdVM.lstMucdichsudungqsd();
        var found = array.find(function (element) {
            return element == 10;
        });
        if (found != null) {
            $(".fiMucDichSuDungKhac").css("display", "inline");
        } else {
            $(".fiMucDichSuDungKhac").css("display", "none");
        }
        $("#fiMaDongViPhongXa").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
        $("#fiHoatDoDonVi").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
        $("#fiMaMucDichSuDungqsd").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
        return false;
    };
    self.removePxkQsd = function (item) {
        if (item) {
            var pop = app.popup({
                title: 'Thông báo',
                html: '<b>Bạn có chắc chắn muốn xóa không??</b>',
                width: 450,
                buttons: [
                    {
                        name: NSWLang["common_button_toi_chac_chan"],
                        class: 'btn',
                        icon: 'fa-save',
                        action: function () {
                            app.popupRemove(pop.selector);
                            self.lstTbdhsPhieuNguonPxkQsd06.remove(function (o) {
                                return o.fiIdNguonPxkPsd() == item.fiIdNguonPxkPsd();
                            });
                            for (var i = 0; i < self.lstTbdhsPhieuNguonPxkQsd06().length; i++) {
                                self.lstTbdhsPhieuNguonPxkQsd06()[i].STT(i + 1);
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
    };
    self.addpxhClick = function () {
        self.addpxh(null);
        return false;
    }
    self.editpxhClick = function (item) {

        self.addpxh(item, 'edit');
        return false;
    }
    self.addpxh = function (item, action) {
        var html = [
            $('#khaibaopxh-template').html()
        ].join('');
        delete self.pop;

        options.pxHo = item;
        self.pxHoVM = new FormPxHoVM(options);
        self.pop = app.popup({
            title: 'Đặc tính của nguồn',
            html: html,
            width: 1024,
            buttons: [
                {
                    name: 'Lưu',
                    class: 'btn btn-save',
                    icon: 'fa-save',
                    action: function () {
                        if (self.pxHoVM.isValid()) {
                            app.Alert('Bạn phải nhập vào đầy đủ thông tin của hồ sơ phóng xạ hở');
                        } else {
                            var pxHoInfo = self.pxHoVM.toJSON();
                            var hoatdo = self.pxHoVM.lstDongVi().find(obj => obj.id === pxHoInfo.fiHoatDoDonVi);
                            pxHoInfo.fiTenHoatDoDonVi = hoatdo.name;
                            if (null == pxHoInfo.fiIdKbNguonPxh) {
                                pxHoInfo.fiIdKbNguonPxh = -1 * new Date().getTime();
                                pxHoInfo.STT = self.lstTbdhsPhieuKbNguonPxh06().length + 1;
                                var pxHoModel = new TbdhsPhieuKbNguonPxh06(pxHoInfo);
                                self.lstTbdhsPhieuKbNguonPxh06.push(pxHoModel);
                            } else {
                                for (var i = 0; i < self.lstTbdhsPhieuKbNguonPxh06().length; i++) {
                                    if (pxHoInfo.fiIdKbNguonPxh == self.lstTbdhsPhieuKbNguonPxh06()[i].fiIdKbNguonPxh()) {
                                        var pxHoModel = new TbdhsPhieuKbNguonPxh06(pxHoInfo);
                                        self.lstTbdhsPhieuKbNguonPxh06.replace(self.lstTbdhsPhieuKbNguonPxh06()[i], pxHoModel);
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
        if (action != 'edit' && item != null && item.fiIdKbNguonPxh() > 0) {
            $(".btn-save").hide();
        }

        ko.applyBindings(self.pxHoVM, document.getElementById('khaibaopxh-vm'));

        var array = self.pxHoVM.lstMucdichsudungho();
        var found = array.find(function (element) {
            return element == 10;
        });
        if (found != null) {
            $(".fiMucDichSuDungKhac").css("display", "inline");
        } else {
            $(".fiMucDichSuDungKhac").css("display", "none");
        }
        $("#fiMaDongViPhongXa").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
        $("#fiHoatDoDonVi").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
        $("#fiMaMucDichSuDung").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
        return false;
    };
    self.removepxh = function (item) {
        if (item) {
            var pop = app.popup({
                title: 'Thông báo',
                html: '<b>Bạn có chắc chắn muốn xóa không??</b>',
                width: 450,
                buttons: [
                    {
                        name: NSWLang["common_button_toi_chac_chan"],
                        class: 'btn',
                        icon: 'fa-save',
                        action: function () {
                            app.popupRemove(pop.selector);
                            self.lstTbdhsPhieuKbNguonPxh06.remove(function (o) {
                                return o.fiIdKbNguonPxh() == item.fiIdKbNguonPxh();
                            });
                            for (var i = 0; i < self.lstTbdhsPhieuKbNguonPxh06().length; i++) {
                                self.lstTbdhsPhieuKbNguonPxh06()[i].STT(i + 1);
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
    };

    self.htcapAction = function () {
        self.validHTC();
        //check validate hinh thuc cap
        var htValue = self.fiHinhThucCap();
        if (htValue == 1) {
            //cap moi bo het validate fiSoGiayPhep and fiNgayCap and fiLydocaplai
//            $("#valid-soGiayPhep").hide();
            $("#sogiaypheplabel").hide();
//            $("#valid-ngayCap").hide();
            $("#ngaycaplabel").hide();
//            $("#valid-fiLydocaplai").hide();
            $("#lydocaplailabel").hide();

            //disable
            $("#fiSoGiayPhep").attr("disabled", true);
            $("#fiNgaycapDk").attr("disabled", true);
            $("#fiLydocaplai1").attr("disabled", true);
        } else {
            //=2,=3 validate fiSoGiayPhep and fiNgayCap
            //=4 validate fiSoGiayPhep and fiNgayCap and fiLydocaplai
            if (self.fiSoGiayPhep() == null || self.fiNgayCap() == null) {
//                $("#valid-soGiayPhep").show();
                $("#sogiaypheplabel").show();
//                $("#valid-ngayCap").show();
                $("#ngaycaplabel").show();
            }
            //disable
            $("#fiSoGiayPhep").removeAttr("disabled");
            $("#fiNgaycapDk").removeAttr("disabled");

            if (htValue == 2 || htValue == 3) {
                $("#fiLydocaplai1").attr("disabled", true);
//                $("#valid-fiLydocaplai").hide();
                $("#lydocaplailabel").hide();
            }

            if (htValue == 4 && self.fiLydocaplai() == null) {
//                $("#valid-fiLydocaplai").show();
                $("#lydocaplailabel").show();
                $("#fiLydocaplai1").removeAttr("disabled");
            }
        }
    }

    self.isValidht = function () {
        self.htcapAction();
        self.validHTC();
        var flag = true;
        var htValue = self.fiHinhThucCap();

        if (htValue != 1) {
            if (self.fiSoGiayPhep() == null || self.fiNgayCap() == null||self.fiSoGiayPhep() == "") {
                flag = false;
                return flag;
            }
            if (htValue == 4 && self.fiLydocaplai() == null) {
                flag = false;
                return flag;
            }
        }
    }

    self.validHTC = function () {
        var htValue = self.fiHinhThucCap();
        if(htValue!=1){
            if (self.fiSoGiayPhep() != null && self.fiSoGiayPhep()!="") {
                $("#valid-soGiayPhep").hide();
                document.getElementById("sogiaypheplabel").style.display = "inline";
                document.getElementById("ngaycaplabel").style.display = "inline";
                document.getElementById("lydocaplailabel").style.display = "inline";
            }else {
                $("#valid-soGiayPhep").show();
            }
            if(self.fiNgayCap()!=null) {
                $("#valid-ngayCap").hide();
            } else {
                $("#valid-ngayCap").show();
            }
            if(htValue===4){
                if (self.fiLydocaplai() != null) {
                    $("#valid-fiLydocaplai").hide();
                }else{
                    $("#valid-fiLydocaplai").show();
                }
            }
        }else{
            $("#valid-soGiayPhep").hide();
            $("#valid-ngayCap").hide();
            $("#valid-fiLydocaplai").hide();
        }
        
        
    }


    self.getLstTeptin = function () {

        
        //reset input
        var idSlc = self.fiHinhThucCap();
        if (idSlc === 1) {
            //tamdt
            $("#fiSoGiayPhep").val("");
            $("#fiNgaycapDk").val("");
            self.fiSoGiayPhep = ko.observable(null);
            self.fiNgayCap = ko.observable(null);
        }
        if (idSlc != 4) {
            $("#fiLydocaplai1").val("");
            self.fiLydocaplai = ko.observable(null);
        }

        self.htcapAction();
        app.getCategory('/most/06/danhmuc', 'DM_TEPTIN', self.fiHinhThucCap(), function (res) {
            if (res.success) {
                self.lstTbdhsTeptin06(mapFilesVM(res.data, self.fiMaHoso()));
            } else {
                self.lstTbdhsTeptin06([]);
            }
        })
    }
    console.log(hosoInfo);
    if (self.fiHinhThucCap()) {
        self.htcapAction();
        app.getCategory('/most/06/danhmuc', 'DM_TEPTIN', self.fiHinhThucCap(), function (res) {
            if (res.success) {
                DINHKEMDATA = res.data;
                self.lstTbdhsTeptin06(mapFilesVM(hosoInfo.hasOwnProperty('lstTbdhsTeptin06') ? hosoInfo.lstTbdhsTeptin06 : [], self.fiMaHoso()));
            } else {
                DINHKEMDATA = [];
                self.lstTbdhsTeptin06(mapFilesVM(hosoInfo.hasOwnProperty('lstTbdhsTeptin06') ? hosoInfo.lstTbdhsTeptin06 : [], self.fiMaHoso()));
            }
        })
    }


    //XU LY SU KIEN BUTTON, TABLE

    //Convert to json object
    self.toJSON = function () {
        var mapping = {
            'ignore': ["removeCarOnClick", "addCarOnClick", "isValidForm", "init", "lstHinhthucCap", "lstLyDoDN",
                "hosoErrors", "lstDonViXuLy", "lstTinhThanh", "nguoiDkError", "lstDongVi", "lstDongViPX", "lstMucDichHo",
                "toJSON", "lstCuaKhau", "__ko_mapping__", 'fiDiaDiem', 'addpxh', 'addPxkQsdClick', "addpxhClick",
                "addpxk", "editCarOnClick", "editPxkQsdClick", "editpxhClick", "errorDinhKemMessage", "errorlistMessage",
                "pop", "pxKinVM", "removePxkQsd", "removepxh", "updatePxkQsd", "pxHoVM", "pxKinQsdVM",
                'errorlistMessage', 'errorDinhKemMessage', 'editCarOnClick', 'updateXeInfo', 'updatepxkQsdInfo']
        };

        var copy = ko.mapping.fromJS(self, mapping);
        copy = ko.toJS(copy);


        delete copy['__ko_mapping__'];
        return copy;
    };

}

