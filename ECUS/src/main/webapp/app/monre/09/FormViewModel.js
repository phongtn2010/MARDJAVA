function ThongTinGen09FormVM(options)
{
    var self = this;
    var thongTinGenInfo = (options != null && options.hasOwnProperty('tTGen')) ? options.tTGen : null;
    //Thong Tin Gen
//    self.stt = ko.observable(thongTinGenInfo ? thongTinGenInfo.stt : null);
    self.fiIdNguongen = ko.observable(null);
    self.fiIdHoso = ko.observable(null);
    self.fiMaNguongen = ko.observable(null);
    self.fiTenKhac = ko.observable(null);
    self.fiThongTinNguonGen = ko.observable(null);
    self.fiMoTaNguonGen = ko.observable(null);
    self.fiNgaycapnhat = ko.observable(null);
    self.fiNgaytao = ko.observable(null);
    self.fiHoatdong = ko.observable(null);
    self.isShowDel = ko.observable(true);
    self.fiTenThongThuong = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiTenKhoaHoc = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    var thongTinGenVG = [self.fiTenThongThuong, self.fiTenKhoaHoc];

    self.thongTinGenErrors = ko.validation.group(thongTinGenVG, {deep: true, live: true, observable: true});
    self.init = function (tTGen) {
        if (tTGen != null) {
            self.fiIdNguongen(tTGen.hasOwnProperty('fiIdNguongen') ? tTGen.fiIdNguongen() : null);
            self.fiIdHoso(tTGen.hasOwnProperty('fiIdHoso') ? tTGen.fiIdHoso() : null);
            self.fiMaNguongen(tTGen.hasOwnProperty('fiMaNguongen') ? tTGen.fiMaNguongen() : null);
            self.fiThongTinNguonGen(tTGen.hasOwnProperty('fiThongTinNguonGen') ? tTGen.fiThongTinNguonGen() : null);
            self.fiMoTaNguonGen(tTGen.hasOwnProperty('fiMoTaNguonGen') ? tTGen.fiMoTaNguonGen() : null);
            self.fiNgaycapnhat(tTGen.hasOwnProperty('fiNgaycapnhat') ? new Date(tTGen.fiNgaycapnhat()) : null);
            self.fiNgaytao(tTGen.hasOwnProperty('fiNgaytao') ? new Date(tTGen.fiNgaytao()) : null);
            self.fiHoatdong(tTGen.hasOwnProperty('fiHoatdong') ? tTGen.fiHoatdong() : null);
            self.fiTenThongThuong(tTGen.hasOwnProperty('fiTenThongThuong') ? tTGen.fiTenThongThuong() : null);
            self.fiTenKhoaHoc(tTGen.hasOwnProperty('fiTenKhoaHoc') ? tTGen.fiTenKhoaHoc() : null);
            self.fiTenKhac(tTGen.hasOwnProperty('fiTenKhac') ? tTGen.fiTenKhac() : null);
            self.isShowDel(tTGen.hasOwnProperty('isShowDel') ? tTGen.isShowDel() : false);

        }
    };
    self.init(thongTinGenInfo);
//        VALIDATE
    self.isValid = function () {
        if (self.thongTinGenErrors().length > 0) {
            self.thongTinGenErrors.showAllMessages();
            return true;
        }else{
             $("#isValidNguonGen").css("display", "none");
        }

    };
    self.toJSON = function () {
        
        var exclude = ["thongTinGenErrors",
            "toJSON", "__ko_mapping__", "isValid", "init"];

        var model = ko.toJS(self);

        for (var key in model) {
            if (exclude.indexOf(key) >= 0) {
                delete model[key];
            }
        }

        return model;
    };
}



// form-vm mau gen
function mauGen09FormVM(options)
{
    var self = this;
    var mauInfo = (options != null && options.hasOwnProperty('mauGen')) ? options.mauGen : null;
//    self.stt = ko.observable(mauInfo ? mauInfo.stt : null);
    self.fiIdMaugen = ko.observable(null);
    self.fiIdHoso = ko.observable(null);

    self.fiTenMau = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    
    self.fiTenMauKhoaHoc = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    
    self.fiSoLuong = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 8 ký tự', params: 8}
    });
    
    self.fiDonViTinh = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    
    self.fiDiaDiem = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    
    self.fiCachThucThuThapMau = ko.observable(null);
    self.fiNgaycap = ko.observable(null);
    self.fiNgaytao = ko.observable(null);
    self.fiHoatdong = ko.observable(null);

    //khoi tao list
    self.slcNguonGen = ko.observableArray([]);
    self.fiTenNguonGen = ko.observable(null);
    self.fiIdNguonGen = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    var mauGenVG = [self.fiTenMau, self.fiTenMauKhoaHoc,self.fiDonViTinh, self.fiDiaDiem,self.fiIdNguonGen,self.fiSoLuong];
    self.mauGenErrors = ko.validation.group(mauGenVG, {deep: true, live: true, observable: true});

    self.init = function (mauGen) {
        if (mauGen !== null) {
            
            self.fiIdMaugen(mauGen.hasOwnProperty('fiIdMaugen') ? mauGen.fiIdMaugen() : null);
            self.fiIdHoso(mauGen.hasOwnProperty('fiIdHoso') ? mauGen.fiIdHoso() : null);
            self.slcNguonGen(mauGen.hasOwnProperty('slcNguonGen') ? mauGen.slcNguonGen() : null);
            self.fiTenMau(mauGen.hasOwnProperty('fiTenMau') ? mauGen.fiTenMau() : null);
            self.fiTenMauKhoaHoc(mauGen.hasOwnProperty('fiTenMauKhoaHoc') ? mauGen.fiTenMauKhoaHoc() : null);
            self.fiSoLuong(mauGen.hasOwnProperty('fiSoLuong') ? mauGen.fiSoLuong() : null);
            self.fiDonViTinh(mauGen.hasOwnProperty('fiDonViTinh') ? mauGen.fiDonViTinh() : null);
            self.fiDiaDiem(mauGen.hasOwnProperty('fiDiaDiem') ? mauGen.fiDiaDiem() : null);
            self.fiCachThucThuThapMau(mauGen.hasOwnProperty('fiCachThucThuThapMau') ? mauGen.fiCachThucThuThapMau() : null);
            self.fiNgaytao(mauGen.hasOwnProperty('fiNgaytao') ? new Date(mauGen.fiNgaytao()) : null);
            self.fiNgaycap(mauGen.hasOwnProperty('fiNgaycap') ? new Date(mauGen.fiNgaycap()) : null);
            self.fiHoatdong(mauGen.hasOwnProperty('fiHoatdong') ? mauGen.fiHoatdong() : null);
            
            self.fiTenNguonGen(mauGen.hasOwnProperty('fiTenNguonGen') ? mauGen.fiTenNguonGen() : null);
            self.fiIdNguonGen(mauGen.hasOwnProperty('fiIdNguonGen') ? mauGen.fiIdNguonGen() : null);
            
        }
         if (!self.fiIdNguonGen()) {
            self.fiIdNguonGen('000');
            self.fiTenNguonGen($('#fiIdNguonGen').find("option:selected").text());
        }
        $("#fiIdNguonGen").val(self.fiIdNguonGen()).select2({placeholder: '---Chọn---', width: '100%', allowClear: true});
        
        self.mauGenErrors.showAllMessages(false);
    };

    self.init(mauInfo);
    self.toJSON = function () {
        var exclude = ["mauGenErrors", "init",
            "toJSON", "__ko_mapping__", "slcNguonGen", "isValid"];

        var model = ko.toJS(self);

        for (var key in model) {
            if (exclude.indexOf(key) >= 0) {
                delete model[key];
            }
        }

        return model;
    };
    self.isValid = function () {
        if (self.mauGenErrors().length > 0) {
            self.mauGenErrors.showAllMessages();
            return true;
        }
        else{
             $("#isValidMauGen").css("display", "none");
        }
        
        //fghfhffhf
    };
}
function Monre09FormVM(options) {
    var self = this;
    var hosoInfo = (options !== null && options.hasOwnProperty('hoso')) ? options.hoso : null;
    self.fiIdHoso = ko.observable(null);
    self.fiMaHoso = ko.observable(null);
    self.fiMaCoQuan = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 50 ký tự', params: 50}
    });
    self.fiTenCoQuan = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 50 ký tự', params: 50}
    });
    self.fiMaSoThue = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 13 ký tự', params: 13}
    });
    self.fiTenDn = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiSoGcnDkkd = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiNgaycapGcnDkkd = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiNoicapGcnDkkd = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiTruSoChinh = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiNguoiDaiDien = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiThoiGianBatDau = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiThoiGianKetThuc = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiTenToChuc = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiNguoiDaiDienCc = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiDiaChiCc = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiChucVuCc = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 50 ký tự', params: 50}
    });
    self.fiSdtCc = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 50 ký tự', params: 50}
    });
    self.fiSuDungNguonGen = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 500 ký tự', params: 500}
    });
    self.fiSoLuong = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 500 ký tự', params: 500}
    });
    self.fiMucDich = ko.observableArray([]);
//            .extend({
//        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
//    });
    
    self.fiFaxCc = ko.observable(null);
    self.fiCachThucThuThap = ko.observable(null);
//    self.fiEmailDn = ko.observable(null);
    self.fiSovb = ko.observable(null);
    self.fiNgaytao = ko.observable(null);
    self.fiNguoitao = ko.observable(null);
    self.fiCapnhat = ko.observable(null);
    self.fiHoatdong = ko.observable(null);
    self.fiNguoitao = ko.observable(null);
    
    self.isValidNguonGen = ko.observable(null);
    self.isValidMauGen = ko.observable(null);
    self.isValidMucDich = ko.observable(null);
    
    self.fiNgCapnhat = ko.observable(null);
    self.fiTrangthai = ko.observable(0);
    self.fiTenTt = ko.observable(null);

    self.fiSdtDn = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 50 ký tự', params: 50}
    });
    self.fiFaxDn = ko.observable(null).extend({
        maxLength: {message: 'Tối đa 50 ký tự', params: 50}
    });
    self.fiEmailDn = ko.observable(null).extend({
         email: {message: 'Email không đúng định dạng', params: true},
        maxLength: {message: 'Tối đa 50 ký tự', params: 50}
    });

    self.lstNguongen9 = ko.observableArray([]);
    self.lstMaugen9 = ko.observableArray([]);
    self.lstDinhKem9 = ko.observableArray([]);
    self.lstTmp = ko.observableArray([]);


    self.lstDonViXuLy = ko.observableArray(mapCategory(options.hasOwnProperty('lstDonViXuLy') ? options.lstDonViXuLy : [], "fiMa", "fiTen"));

    var hosoVG = [self.fiMaCoQuan,
        self.fiMaSoThue, self.fiTenDn,
        self.fiSoGcnDkkd, self.fiNgaycapGcnDkkd
                , self.fiNoicapGcnDkkd, self.fiTruSoChinh,
        self.fiSoGcnDkkd, self.fiNgaycapGcnDkkd,
        self.fiNoicapGcnDkkd, self.fiTruSoChinh,
        self.fiNguoiDaiDien, self.fiSdtDn,
        self.fiThoiGianBatDau, self.fiThoiGianKetThuc, self.fiTenToChuc,
        self.fiNguoiDaiDienCc, self.fiDiaChiCc, self.fiChucVuCc,
        self.fiSdtCc, self.fiSuDungNguonGen, self.fiSoLuong,self.fiMucDich];


    self.hosoErrors = ko.validation.group(hosoVG, {deep: true, live: true, observable: true});


    self.init = function (hoso) {

       
        self.fiTenDn(hoso !== null && hoso.hasOwnProperty('fiTenDn') ? hoso.fiTenDn : user.companyName);
        self.fiMaSoThue(hoso !== null && hoso.hasOwnProperty('fiMaSoThue') ? hoso.fiMaSoThue : user.username);
        self.fiTruSoChinh(hoso !== null && hoso.hasOwnProperty('fiTruSoChinh') ? hoso.fiTruSoChinh : user.companyAddress);
        self.fiSdtDn(hoso !== null && hoso.hasOwnProperty('fiSdtDn') ? hoso.fiSdtDn : user.companyPhoneNumber);
        if (hoso !== null) {
            self.fiNguoiDaiDien(hoso !== null && hoso.hasOwnProperty('fiNguoiDaiDien') ? hoso.fiNguoiDaiDien : null);
            self.fiSoGcnDkkd(hoso !== null && hoso.hasOwnProperty('fiSoGcnDkkd') ? hoso.fiSoGcnDkkd : null);
            self.fiIdHoso(hoso.hasOwnProperty('fiIdHoso') ? hoso.fiIdHoso : null);
            self.fiMaHoso(hoso.hasOwnProperty('fiMaHoso') ? hoso.fiMaHoso : null);
            self.fiMaCoQuan(hoso !== null && hoso.hasOwnProperty('fiMaCoQuan') ? hoso.fiMaCoQuan : null);
            self.fiTenCoQuan(hoso !== null && hoso.hasOwnProperty('fiTenCoQuan') ? hoso.fiTenCoQuan : null);
            self.fiMaSoThue(hoso !== null && hoso.hasOwnProperty('fiMaSoThue') ? hoso.fiMaSoThue : null);
            self.fiTenDn(hoso !== null && hoso.hasOwnProperty('fiTenDn') ? hoso.fiTenDn : user.companyName);
            self.fiSoGcnDkkd(hoso !== null && hoso.hasOwnProperty('fiSoGcnDkkd') ? hoso.fiSoGcnDkkd : null);
            self.fiNgaycapGcnDkkd(hoso !== null && hoso.hasOwnProperty('fiNgaycapGcnDkkd') ? new Date(hoso.fiNgaycapGcnDkkd) : null);
            self.fiNoicapGcnDkkd(hoso !== null && hoso.hasOwnProperty('fiNoicapGcnDkkd') ? hoso.fiNoicapGcnDkkd : null);
            self.fiTruSoChinh(hoso !== null && hoso.hasOwnProperty('fiTruSoChinh') ? hoso.fiTruSoChinh : null);
            self.fiNguoiDaiDien(hoso !== null && hoso.hasOwnProperty('fiNguoiDaiDien') ? hoso.fiNguoiDaiDien : null);
            self.fiThoiGianBatDau(hoso !== null && hoso.hasOwnProperty('fiThoiGianBatDau') ? new Date(hoso.fiThoiGianBatDau) : null);
            self.fiThoiGianKetThuc(hoso !== null && hoso.hasOwnProperty('fiThoiGianKetThuc') ? new Date(hoso.fiThoiGianKetThuc) : null);
            self.fiTenToChuc(hoso !== null && hoso.hasOwnProperty('fiTenToChuc') ? hoso.fiTenToChuc : null);
            self.fiNguoiDaiDienCc(hoso !== null && hoso.hasOwnProperty('fiNguoiDaiDienCc') ? hoso.fiNguoiDaiDienCc : null);
            self.fiDiaChiCc(hoso !== null && hoso.hasOwnProperty('fiDiaChiCc') ? hoso.fiDiaChiCc : null);
            self.fiChucVuCc(hoso !== null && hoso.hasOwnProperty('fiChucVuCc') ? hoso.fiChucVuCc : null);
            self.fiSdtCc(hoso !== null && hoso.hasOwnProperty('fiSdtCc') ? hoso.fiSdtCc : null);
            self.fiSuDungNguonGen(hoso !== null && hoso.hasOwnProperty('fiSuDungNguonGen') ? hoso.fiSuDungNguonGen : null);
            self.fiSoLuong(hoso !== null && hoso.hasOwnProperty('fiSoLuong') ? hoso.fiSoLuong : null);
            self.fiFaxCc(hoso !== null && hoso.hasOwnProperty('fiFaxCc') ? hoso.fiFaxCc : null);
            self.fiCachThucThuThap(hoso !== null && hoso.hasOwnProperty('fiCachThucThuThap') ? hoso.fiCachThucThuThap : null);
            self.fiMucDich(hoso !== null && hoso.hasOwnProperty('fiMucDich') ? hoso.fiMucDich.toString() : null);
            self.fiTrangthai(hoso !== null && hoso.hasOwnProperty('fiTrangthai') ? hoso.fiTrangthai : null);
            self.fiTenTt(hoso !== null && hoso.hasOwnProperty('fiTenTt') ? hoso.fiTenTt : null);
            self.fiFaxDn(hoso !== null && hoso.hasOwnProperty('fiFaxDn') ? hoso.fiFaxDn : null);
            self.fiEmailDn(hoso !== null && hoso.hasOwnProperty('fiEmailDn') ? hoso.fiEmailDn : null);
            self.fiSovb(hoso !== null && hoso.hasOwnProperty('fiSovb') ? hoso.fiSovb : null);
            self.fiNgaytao(hoso.hasOwnProperty('fiNgaytao') ? new Date(hoso.fiNgaytao) : null);
            self.fiNguoitao(hoso !== null && hoso.hasOwnProperty('fiNguoitao') ? hoso.fiNguoitao : null);
            self.fiCapnhat(hoso !== null && hoso.hasOwnProperty('fiCapnhat') ? hoso.fiCapnhat : null);
            self.fiHoatdong(hoso !== null && hoso.hasOwnProperty('fiHoatdong') ? hoso.fiHoatdong : null);
            self.lstNguongen9(hoso.hasOwnProperty('lstNguongen9') ? mapTbdnguongen9(hoso.lstNguongen9) : []);
            self.lstMaugen9(hoso.hasOwnProperty('lstMaugen9') ? mapTbdMauGen9(hoso.lstMaugen9) : []);
//            self.lstNguongen9(mapTbdnguongen9(hoso.hasOwnProperty('lstNguongen9') ? hoso.lstNguongen9 : []));
//            self.lstMaugen9(mapTbdMauGen9(hoso.hasOwnProperty('lstMaugen9') ? hoso.lstMaugen9 : []));
        }
        if (!self.fiMaCoQuan()) {
            self.fiMaCoQuan('000');
            self.fiTenCoQuan($('#fiMaCoQuan').find("option:selected").text());
        }
        $("#fiMaCoQuan").val(self.fiMaCoQuan()).select2({placeholder: '---Chọn---', width: '100%', allowClear: true});
        
        self.hosoErrors.showAllMessages(false);
    };
    self.init(hosoInfo);
    
    self.mucdichAction = function () {
        var array = self.fiMucDich();
        var found = array.find(function (element) {
            return element == 10;
        });
        if (found != null) {
            $("#mucdichAction").css("display", "inline");
        } else {
            $("#mucdichAction").css("display", "none");
        }
    }
    //jaskfhasdhfjkas
    
    //VALIDATE DATA ON FORM
    //Remove from toJSON
    self.isValidDate = function(){
        var st =self.fiThoiGianBatDau();
        var end =self.fiThoiGianKetThuc();
        if (st.getTime() > end.getTime()) {
            app.Alert("Thời gian thu thập không được nhỏ hơn thời gian kết thúc!")
            return false;
        }
        return true;
    };
   self.changeMucdich= function(){
        $("#mucdichAction").css("display", "none");
    };
    self.isValidForm = function () {
        var flag = true;
        if (self.hosoErrors().length > 0) {
            self.hosoErrors.showAllMessages();
            flag = false;
        }
        if(self.fiMucDich() == 0){
            //dinhpv
            self.isValidMucDich('Thông tin bắt buộc');
            flag =  false;
        }else {
               $("#mucdichAction").css("display", "none");  
        }

        if(self.lstNguongen9().length===0){
            //tamdt1
            
            self.isValidNguonGen('Thông tin bắt buộc');
            flag =  false;
        }
        if(self.lstMaugen9().length===0){
            self.isValidMauGen('Thông tin bắt buộc');
            flag = false;
        }
        return flag;
    };

    // form-vm thong tin nguon gen

    // popup them nguon gen dang ky
    self.bThemNguonGenDKClick = function () {
        self.NguonGenDKClick(null);
        return false;
    };

    //them moi va sua nguon gen
    self.saveOrUpdateNguonGen = function(data){
        
        var url = '/monre/09/nguongen/insertOrUpdate';
        app.makePost({
            url: url,
            data: JSON.stringify(ko.toJS(data)),
            success: function (d) {
                if (d && d.success) {
                    
                    //day xuong table
                    console.log(d);
                    data.stt = self.lstNguongen9().length + 1;
                    
                    if(data.fiIdNguongen == null){
                        data.fiIdNguongen = d.data.fiIdNguongen;    
                        var nguonGenObj = new Tbdnguongen9(data);
                        self.lstNguongen9.push(nguonGenObj);
                    }else{
                        //sua
                        //tim den thang do roi replace
                        for (var i = 0; i < self.lstNguongen9().length; i++) {
                            if (data.fiIdNguongen == self.lstNguongen9()[i].fiIdNguongen()) {
                                var nguonGenObj = new Tbdnguongen9(data);
                                self.lstNguongen9.replace(self.lstNguongen9()[i], nguonGenObj);
                                break;
                            }
                        }
                       
                        //update laij cho danh sach mau gen
                        for(var i=0;i<self.lstMaugen9().length;i++){
                            var mgObj = self.lstMaugen9()[i];
                            if(mgObj.fiIdNguonGen() === data.fiIdNguongen){
                                mgObj.fiTenNguonGen(data.fiTenThongThuong);
                                break;
                            }
                        }
                        ko.computed(function () {
                            return self.lstMaugen9(ko.utils.unwrapObservable(self.lstMaugen9));
                        });
                        
                        
                    }
                }else{
                    return null;
                }
            },
            error: function (e) {
                app.Alert('Lưu dữ liệu không thành công');
            }
        });
    }


    self.NguonGenDKClick = function (item) {
        
        var html = [
            $('#thongTinGenDK-template').html()
        ].join('');
        delete self.thongTinGenpop;
        delete self.ThongTinGen09FormVM;
        options.tTGen = item;
        self.ttGen = new ThongTinGen09FormVM(options);
        self.thongTinGenpop = app.popup({
            title: 'Nguồn gen đăng ký tiếp cận',
            html: html,
            width: 1000,
            buttons: [
                {
                    name: 'Lưu',
                    class: 'btn blue',
                    icon: 'fa-check',
                    action: function () {
                        if (self.ttGen.isValid()) {
                            app.Alert('Vui lòng điền đủ các thông tin');
                        } else {
                            
                            var thongTinGenInput = self.ttGen.toJSON();
                            //save db
                            self.saveOrUpdateNguonGen(thongTinGenInput);


                            app.popupRemove(self.thongTinGenpop.selector);
                            $('.modal-scrollable').hide();
                            $('.modal-backdrop').hide();
                        }
                    }
                },
                {
                    name: 'Đóng',
                    class: 'btn',
                    icon: 'fa-remove',
                    action: function () {
                        app.popupRemove(self.thongTinGenpop.selector);
                        $('.modal-scrollable').hide();
                        $('.modal-backdrop').hide();
                    }
                }
            ]
        },
                function () {
                    ko.applyBindings(self.ttGen, document.getElementById('thongTinGenpop'));
                });
        return false;
    };
// sua thong tin gen
    self.editTTGenClick = function (item) {
        
        self.NguonGenDKClick(item);
        return false;
    };
    //xoa thong tin gen
    self.removeTTGenClick = function (item) {
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
                            self.lstNguongen9.remove(function (o) {
                                return o.fiIdNguongen == item.fiIdNguongen;
                            });
                            for (var i = 0; i < self.lstNguongen9().length; i++) {
                                self.lstNguongen9()[i].fiStt(i + 1);
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
///////////////////////////////////////////////////////////////
// them mau gen
    self.bThemMauGenClick = function () {
        self.MauGenClick(null);
        return false;
    };

    self.editMauGenClick = function (item) {
        self.MauGenClick(item);
        return false;
    }

    self.MauGenClick = function (item) {
        var html = [
            $('#mauNguonGen-template').html()
        ].join('');
        delete self.thongTinMauGenpop;
        delete self.mauGen09FormVM;
        options.mauGen = item;
        self.mauGen = new mauGen09FormVM(options);
        self.mauGen.slcNguonGen = ko.observableArray(mapCategory(self.lstNguongen9(), "fiIdNguongen", "fiTenThongThuong"));

        self.thongTinMauGenpop = app.popup({
            title: 'Mẫu nguồn gen dự kiến tiếp cận',
            html: html,
            width: 1000,
            buttons: [
                {
                    name: 'Lưu',
                    class: 'btn blue',
                    icon: 'fa-check',
                    action: function () {
                        if (self.mauGen.isValid()) {
                            app.Alert('Vui lòng điền đủ các thông tin mẫu nguồn gen');
                        } else {
                            var mauGenInput = self.mauGen.toJSON();
                            mauGenInput.stt = self.lstMaugen9().length + 1;
                            
                            var nguonGenObj = self.lstNguongen9().find( obj => obj.fiIdNguongen() === mauGenInput.fiIdNguonGen);
                            mauGenInput.fiTenNguonGen = nguonGenObj.fiTenThongThuong();
                            
                            if (null == mauGenInput.fiIdMaugen) {
                                mauGenInput.fiIdMaugen = -1 * new Date().getTime();
                                
                                var mauObj = new TbdMauGen9(mauGenInput);
                                
                                //TamDT
                                self.lstMaugen9.push(mauObj);
                                
                            } else {
                                for (var i = 0; i < self.lstMaugen9().length; i++) {
                                    if (mauGenInput.fiIdMaugen == self.lstMaugen9()[i].fiIdMaugen()) {
                                        var mauObj = new TbdMauGen9(mauGenInput);
                                        self.lstMaugen9.replace(self.lstMaugen9()[i], mauObj);
                                        break;
                                    }
                                }
                            }
                            
                            //update table nguon gen 1405
                            //tim den nguon gen do va cap nhat 1 cot
                            for(var i= 0 ;i<self.lstNguongen9().length;i++){
                                var ngObj = self.lstNguongen9()[i];
                                if(ngObj.fiIdNguongen() === mauGenInput.fiIdNguonGen){
                                    ngObj.isShowDel(false);
                                    break;
                                }
                                
                            }
                            
                            //update view
                            ko.computed(function () {
                                   return self.lstNguongen9(ko.utils.unwrapObservable(self.lstNguongen9));
                            });
                            
                            app.popupRemove(self.thongTinMauGenpop.selector);
                            $('.modal-scrollable').hide();
                            $('.modal-backdrop').hide();
                        }
                    }
                },
                {
                    name: 'Đóng',
                    class: 'btn',
                    icon: 'fa-remove',
                    action: function () {
                        app.popupRemove(self.thongTinMauGenpop.selector);
                        $('.modal-scrollable').hide();
                        $('.modal-backdrop').hide();
                    }
                }
            ]
        },
        function () {
//            $("#fiTenNguonGen").select2({placeholder: '---Chọn---', width: '100%', allowClear: true});
            ko.applyBindings(self.mauGen, document.getElementById('mauNguonGen-vm'));
        });
        return false;
    };
    self.removeMauGenClick = function (item) {
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
                            
                            self.lstMaugen9.remove(function (o) {
                                return o.fiIdMaugen == item.fiIdMaugen;
                            });
//                            for (var i = 0; i < self.lstMaugen9().length; i++) {
//                                self.lstMaugen9()[i].fiStt(i + 1);
//                            }
                            
                            
                            //show button xoa cho nguon gen
                            for(var i= 0 ;i<self.lstNguongen9().length;i++){
                                var ngObj = self.lstNguongen9()[i];
                                if(ngObj.fiIdNguongen() === item.fiIdNguonGen()){
                                    ngObj.isShowDel(true);
                                    break;
                                }
                            }
                            
                            //update view
                            ko.computed(function () {
                                   return self.lstNguongen9(ko.utils.unwrapObservable(self.lstNguongen9));
                            });
                            
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
    }
    //VALIDATE DATA ON FORM

    //HAM XU LY    
    //Remove from toJSON
    //Convert to json object
    self.toJSON = function () {
        console.log("selffffffffffffffffffffffffffffffffff");
        console.log(self);
        self.fiTenCoQuan($('#fiMaCoQuan').find("option:selected").text());
        var mapping = {
            'ignore': ['isValidForm', 'init','isValid',
                'toJSON', 'lohangErrors', '__ko_mapping__', 'errorPheLieuMessage','MauGenClick','NguonGenDKClick',
                'bThemMauGenClick','bThemNguonGenDKClick','editMauGenClick','editTTGenClick',
                'fiKhoiluong', 'hosoErrors', 'lstDonViXuLy','removeMauGenClick','removeTTGenClick'
                ,'thongTinGenpop','thongTinMauGenpop','lstTmp']
        };
        var copy = ko.mapping.fromJS(self, mapping);
        copy = ko.toJS(copy);

        delete copy['__ko_mapping__'];
        return copy;
    };
//open popupview

  self.OpenNguonGenClick = function (item) {
        self.NguonGenPopup(item);
        return false;
    };
    self.NguonGenPopup = function (item) {
        
        var html = [
            $('#thongTinGenDK-template').html()
        ].join('');
        delete self.thongTinGenpop;
        delete self.ThongTinGen09FormVM;
        options.tTGen = item;
        self.ttGen = new ThongTinGen09FormVM(options);
        self.thongTinGenpop = app.popup({
            title: 'Nguồn gen đăng ký tiếp cận',
            html: html,
            width: 1000,
            buttons: [
               
                {
                    name: 'Đóng',
                    class: 'btn',
                    icon: 'fa-remove',
                    action: function () {
                        app.popupRemove(self.thongTinGenpop.selector);
                        $('.modal-scrollable').hide();
                        $('.modal-backdrop').hide();
                    }
                }
            ]
        },
                function () {
                    ko.applyBindings(self.ttGen, document.getElementById('thongTinGenpop'));
                });
        return false;
    };
     self.OpenMauGenClick = function (item) {
        self.MauGenPopup(item);
        return false;
    }

    self.MauGenPopup = function (item) {
        var html = [
            $('#mauNguonGen-template').html()
        ].join('');
        delete self.thongTinMauGenpop;
        delete self.mauGen09FormVM;
        options.mauGen = item;
        self.mauGen = new mauGen09FormVM(options);
        self.mauGen.slcNguonGen = ko.observableArray(mapCategory(self.lstNguongen9(), "fiIdNguongen", "fiTenThongThuong"));

        self.thongTinMauGenpop = app.popup({
            title: 'Mẫu nguồn gen dự kiến tiếp cận',
            html: html,
            width: 1000,
            buttons: [
                {
                    name: 'Đóng',
                    class: 'btn',
                    icon: 'fa-remove',
                    action: function () {
                        app.popupRemove(self.thongTinMauGenpop.selector);
                        $('.modal-scrollable').hide();
                        $('.modal-backdrop').hide();
                    }
                }
            ]
        },
                function () {
                    ko.applyBindings(self.mauGen, document.getElementById('mauNguonGen-vm'));
                });
        return false;
    };
}