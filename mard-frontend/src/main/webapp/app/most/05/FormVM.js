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
    self.fiMaCoQuan = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 100 ký tự', params: 100}
    });
    self.fiTenCoQuan = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });

    self.fiHinhThucCap = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 1 ký tự', params: 1}
    });
    self.fiSoGiayPhep = ko.observable(null);
    self.fiNgayCap = ko.observable(null);
    self.fiNgayCapPhep = ko.observable(null);
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
    self.fiTtcFax = ko.observable(null);
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
        maxLength: {message: 'Tối đa 50 ký tự', params: 50}
    });
    self.fiTtBenCungCapTen = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiTtBenCungCapDiaChi = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiTtBenCungCapDienThoai = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 50 ký tự', params: 50}
    });
    self.fiTtBenCungCapFax = ko.observable(null);
    self.fiTtBenCungCapEmail = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        email: {message: 'Email không đúng định dạng', params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiNkcpxNgayDuKien = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiNkcpxMaTinh = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 50 ký tự', params: 50}
    });
    self.fiNkcpxTenTinh = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiNkcpxMaCuaKhau = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 50 ký tự', params: 50}
    });
    self.fiNkcpxTenCuaKhau = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 500 ký tự', params: 500}
    });
    ///////////
//    self.visibleLyDoXinSua = ko.observable(false);
//    self.fiLydo = ko.observable(null).extend({
//        maxLength: {message: 'Tối đa 2000 ký tự', params: 50}
//    });
    ////////////
    self.fiHoatdong = ko.observable(null);
    self.fiLydocaplai = ko.observable(null);
    self.fiNguoitao = ko.observable(null);
    self.fiNgaytao = ko.observable(null);
    self.fiNgaysua = ko.observable(null);
    self.fiNgaygui = ko.observable(null);
    self.fiTrangthai = ko.observable(null);
    self.fiTenTrangthai = ko.observable(null);
    self.fiMaHoso = ko.observable(null);
    self.lstTbdhsNkpxTtpnpxk05 = ko.observableArray([]);
    self.lstTbdhsTtpPxh05 = ko.observableArray([]);
    self.lstHinhThuccap = ko.observableArray(mapCategory(options.hasOwnProperty('lstHinhThuccap') ? options.lstHinhThuccap : [], "id", "name"));
    self.lstLyDoDN = ko.observableArray(mapCategory(options.hasOwnProperty('lstLyDoDN') ? options.lstLyDoDN : [], "id", "name"));
    self.lstTinhThanh = ko.observableArray(mapCategory(options.hasOwnProperty('lstTinhThanh') ? options.lstTinhThanh : [], "fiMa", "fiTen"));
    self.lstCuaKhau = ko.observableArray(mapCategory(options.hasOwnProperty('lstCuaKhau') ? options.lstCuaKhau : [], "fiMaCuakhau", "fiTenCuakhau"));
//    self.lstTrangThai = ko.observableArray(options.hasOwnProperty('lstTrangThai') ? options.lstTrangThai : null);
    self.lstTeptin05 = ko.observableArray([]);
    self.lstCQXL = ko.observableArray(mapCategory(options.hasOwnProperty('lstCQXL') ? options.lstCQXL : [], "fiMa", "fiTen"));
    //Danh muc
    var hosoVG = [self.fiHinhThucCap, self.fiTtcTenToChuc, self.fiTtcDiaChi, self.fiTtcDienThoai, self.fiTtcEmail, self.fiMaCoQuan,
        self.fiNddHoTen, self.fiNddChucVu, self.fiNddCmnd, self.fiTtBenCungCapTen, self.fiTtBenCungCapDiaChi, self.fiTtBenCungCapDienThoai,
        self.fiTtBenCungCapEmail, self.fiNkcpxNgayDuKien, self.fiNkcpxMaTinh, self.fiNkcpxTenTinh, self.fiNkcpxMaCuaKhau, self.fiNkcpxTenCuaKhau];
    self.hosoErrors = ko.validation.group(hosoVG, {deep: true, live: true, observable: true});

    //validate hinh thuc cap
    self.htcErrors = ko.observable(null);


    self.errorlistpxkMessage = ko.observable(null);
    self.errorlistpxhoMessage = ko.observable(null);
    self.errorDinhKemMessage = ko.observable(null);
    self.errorsoGiayPhepMessage = ko.observable(null);
    self.errorngaycapMessage = ko.observable(null);
    self.errorlydoMessage = ko.observable(null);
    //Khoi tao gia tri ho so
    self.init = function (hoso) {
        debugger;
        self.fiTtcTenToChuc(hoso !== null && hoso.hasOwnProperty('fiTtcTenToChuc') ? hoso.fiTtcTenToChuc : user.companyName);
        self.fiTtcDiaChi(hoso !== null && hoso.hasOwnProperty('fiTtcDiaChi') ? hoso.fiTtcDiaChi : user.companyAddress);
        self.fiTtcDienThoai(hoso !== null && hoso.hasOwnProperty('fiTtcDienThoai') ? hoso.fiTtcDienThoai : user.companyPhoneNumber);
        if (hoso !== null) {
            self.fiIdHoso(hoso.hasOwnProperty('fiIdHoso') ? hoso.fiIdHoso : null);
            self.fiMaHoso(hoso.hasOwnProperty('fiMaHoso') ? hoso.fiMaHoso : null);
            self.fiMaCoQuan(hoso.hasOwnProperty('fiMaCoQuan') ? hoso.fiMaCoQuan : null);
            self.fiTenCoQuan(hoso.hasOwnProperty('fiTenCoQuan') ? hoso.fiTenCoQuan : null);
            self.fiHinhThucCap(hoso.hasOwnProperty('fiHinhThucCap') ? hoso.fiHinhThucCap : null);
            self.fiSoGiayPhep(hoso.hasOwnProperty('fiSoGiayPhep') ? hoso.fiSoGiayPhep : null);
            self.fiNgayCap(hoso.hasOwnProperty('fiNgayCap') && hoso.fiNgayCap != null ? hoso.fiNgayCap : null);
            if(self.fiNgayCap()!=null){
            self.fiNgayCap(hoso.hasOwnProperty('fiNgayCap') && hoso.fiNgayCap != null ? new Date(hoso.fiNgayCap) : null);
                }
            self.fiNgayCapPhep(hoso.hasOwnProperty('fiNgayCapPhep') && hoso.fiNgayCapPhep != null ? new Date(hoso.fiNgayCapPhep) : null);
            self.fiTtcDiaChi(hoso.hasOwnProperty('fiTtcDiaChi') ? hoso.fiTtcDiaChi : null);
            self.fiTtcFax(hoso.hasOwnProperty('fiTtcFax') ? hoso.fiTtcFax : null);
            self.fiTtcEmail(hoso.hasOwnProperty('fiTtcEmail') ? hoso.fiTtcEmail : null);
            self.fiNddChucVu(hoso.hasOwnProperty('fiNddChucVu') ? hoso.fiNddChucVu : null);
            self.fiNddCmnd(hoso.hasOwnProperty('fiNddCmnd') ? hoso.fiNddCmnd : null);
            self.fiTtBenCungCapTen(hoso.hasOwnProperty('fiTtBenCungCapTen') ? hoso.fiTtBenCungCapTen : null);
            self.fiTtBenCungCapDiaChi(hoso.hasOwnProperty('fiTtBenCungCapDiaChi') ? hoso.fiTtBenCungCapDiaChi : null);
            self.fiTtBenCungCapDienThoai(hoso.hasOwnProperty('fiTtBenCungCapDienThoai') ? hoso.fiTtBenCungCapDienThoai : null);
            self.fiTtBenCungCapFax(hoso.hasOwnProperty('fiTtBenCungCapFax') ? hoso.fiTtBenCungCapFax : null);
            self.fiTtBenCungCapEmail(hoso.hasOwnProperty('fiTtBenCungCapEmail') ? hoso.fiTtBenCungCapEmail : null);
            self.fiNkcpxNgayDuKien(hoso.hasOwnProperty('fiNkcpxNgayDuKien') && hoso.fiNkcpxNgayDuKien != null ? new Date(hoso.fiNkcpxNgayDuKien) : null);
            self.fiNkcpxMaTinh(hoso.hasOwnProperty('fiNkcpxMaTinh') ? hoso.fiNkcpxMaTinh : null);
            self.fiNkcpxTenTinh(hoso.hasOwnProperty('fiNkcpxTenTinh') ? hoso.fiNkcpxTenTinh : null);
            self.fiNkcpxMaCuaKhau(hoso.hasOwnProperty('fiNkcpxMaCuaKhau') ? hoso.fiNkcpxMaCuaKhau : null);
            self.fiNkcpxTenCuaKhau(hoso.hasOwnProperty('fiNkcpxTenCuaKhau') ? hoso.fiNkcpxTenCuaKhau : null);
            self.fiNddHoTen(hoso !== null && hoso.hasOwnProperty('fiNddHoTen') ? hoso.fiNddHoTen : null);
            self.fiHoatdong(hoso.hasOwnProperty('fiHoatdong') ? hoso.fiHoatdong : null);
            self.fiLydocaplai(hoso.hasOwnProperty('fiLydocaplai') ? hoso.fiLydocaplai : null);
            self.fiNguoitao(hoso.hasOwnProperty('fiNguoitao') ? hoso.fiNguoitao : null);
            self.fiNgaytao(hoso.hasOwnProperty('fiNgaytao') && hoso.fiNgaytao != null ? new Date(hoso.fiNgaytao) : null);
            self.fiNgaysua(hoso.hasOwnProperty('fiNgaysua') && hoso.fiNgaysua != null ? new Date(hoso.fiNgaysua) : null);
            self.fiNgaygui(hoso.hasOwnProperty('fiNgaygui') && hoso.fiNgaygui != null ? new Date(hoso.fiNgaygui) : null);
            self.fiTrangthai(hoso.hasOwnProperty('fiTrangthai') ? hoso.fiTrangthai : null);
            self.fiMaHoso(hoso.hasOwnProperty('fiMaHoso') ? hoso.fiMaHoso : null);

            self.lstTbdhsNkpxTtpnpxk05(mapTbdhsNkpxTtpnpxk05(hoso.hasOwnProperty('lstTbdhsNkpxTtpnpxk05') ? hoso.lstTbdhsNkpxTtpnpxk05 : []));
            self.lstTbdhsTtpPxh05(mapTbdhsTtpPxh05(hoso.hasOwnProperty('lstTbdhsTtpPxh05') ? hoso.lstTbdhsTtpPxh05 : []));
//            self.lstTeptin05(mapFilesVM(hoso.hasOwnProperty('lstTeptin05') ? hoso.lstTeptin05 : [], self.fiMaHoso()));

            setTenTrangthai(self.fiTrangthai());
        }
    };
    var setTenTrangthai = function (fiTrangthai) {
        for (var i = 0; i < RAW_HS_STATUS.length > 0; i++) {
            if (RAW_HS_STATUS[i].id == fiTrangthai) {
                self.fiTenTrangthai(RAW_HS_STATUS[i].name);
            }
        }
    };
    self.init(hosoInfo);


//XU LY SU KIEN BUTTON, TABLE
    self.removePXKOnClick = function (item) {
        if (item) {
            var pop = app.popup({
                title: 'Thông báo',
                html: '<b>Bạn chắc chắn muốn xoá dữ liệu của nguồn phóng xạ kín này?</b>',
                width: 450,
                buttons: [
                    {
                        name: NSWLang["common_button_toi_chac_chan"],
                        class: 'btn',
                        icon: 'fa-save',
                        action: function () {
                            self.lstTbdhsNkpxTtpnpxk05.remove(function (o) {
                                return o.fiIdTtpnpxk() == item.fiIdTtpnpxk();
                            });
                            for (var i = 0; i < self.lstTbdhsNkpxTtpnpxk05().length; i++) {
                                self.lstTbdhsNkpxTtpnpxk05()[i].fiStt(i + 1);
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
    self.btnAddNewClickPXK = function () {
        self.btnUpdatePXK(null)
        return false;
    }
    self.btnEditClickPXK = function (item) {
        self.btnUpdatePXK(item, 'edit');
        return false;
    }

    self.btnUpdatePXK = function (item, action) {
        var html = [
            $('#phongXaKin-template').html()
        ].join('');
        options.phongXaKin = item;
        self.phongXaKinVM = new FormPhongXaKinVM(options);
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
                        if (self.phongXaKinVM.isValid()) {
                            app.Alert('Bạn phải nhập vào đầy đủ thông tin của hồ sơ phóng xạ kín.');
                        } else {
                            if(self.phongXaKinVM.lstMucdichsudung().includes("10")){
                                if(self.phongXaKinVM.fiMucDichSuDungKhac() === null || self.phongXaKinVM.fiMucDichSuDungKhac()===""){
                                    app.Alert('Bạn phải nhập vào đầy đủ thông tin của hồ sơ phóng xạ kín.');
                                    $("#fiMucDichSuDungKhacKin-lbl").show();
                                    return;
                                }else{
                                    $("#fiMucDichSuDungKhacKin-lbl").hide();
                                }
                            }else{
                                $("#fiMucDichSuDungKhacKin-lbl").hide();
                            }
                            
                            
                            var phongXaKinInfo = self.phongXaKinVM.toJSON();
                            var hoatdo = self.phongXaKinVM.lstHoatDoDonVi().find(obj => obj.id === phongXaKinInfo.fiHoatDoDonVi);
                            phongXaKinInfo.fiTenHoatDoDonVi = hoatdo.name;
                            if (null == phongXaKinInfo.fiIdTtpnpxk) {

                                phongXaKinInfo.fiIdTtpnpxk = -1 * new Date().getTime();
                                phongXaKinInfo.fiStt = self.lstTbdhsNkpxTtpnpxk05().length + 1;
                                var phongXaKinModel = new TbdhsNkpxTtpnpxk05(phongXaKinInfo);
                                self.lstTbdhsNkpxTtpnpxk05.push(phongXaKinModel);
                            } else {
                                for (var i = 0; i < self.lstTbdhsNkpxTtpnpxk05().length; i++) {
                                    if (phongXaKinInfo.fiIdTtpnpxk == self.lstTbdhsNkpxTtpnpxk05()[i].fiIdTtpnpxk()) {
                                        var phongXaKinModel = new TbdhsNkpxTtpnpxk05(phongXaKinInfo);
                                        self.lstTbdhsNkpxTtpnpxk05.replace(self.lstTbdhsNkpxTtpnpxk05()[i], phongXaKinModel);
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
        if (action != 'edit' && item != null && item.fiIdTtpnpxk() > 0) {
            $(".btn-save").hide();
        }
        ko.applyBindings(self.phongXaKinVM, document.getElementById('IdPhongXaKinVM'));
        var array = self.phongXaKinVM.lstMucdichsudung();
        var found = array.find(function (element) {
            return element == 10;
        });
        if (found != null) {
            $(".fiMucDichSuDungKhac").css("display", "inline");
        } else {
            $(".fiMucDichSuDungKhac").css("display", "none");
        }

        if (self.phongXaKinVM.fiCamKetTraNguon() == 1) {
            $('#rdKhong').prop('checked', true);
        }
        if (self.phongXaKinVM.fiCamKetTraNguon() == 2) {
            $('#rdCo').prop('checked', true);
        }
        if (self.phongXaKinVM.fiTbDiDongCoDinh() == 1) {
            $('#rdDiDong').prop('checked', true);
        }
        if (self.phongXaKinVM.fiTbDiDongCoDinh() == 2) {
            $('#rdCoDinh').prop('checked', true);
        }

        $("#fiTenDongViPhongXa").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
        $("#fiHoatDoDonVi").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
        $("#fiMaMucDichSuDung").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
        return false;
    };

    self.removePXHOnClick = function (item) {
        if (item) {
            var pop = app.popup({
                title: 'Thông báo',
                html: '<b>Bạn chắc chắn muốn xoá dữ liệu của nguồn phóng xạ hở này?</b>',
                width: 450,
                buttons: [
                    {
                        name: NSWLang["common_button_toi_chac_chan"],
                        class: 'btn',
                        icon: 'fa-save',
                        action: function () {
                            self.lstTbdhsTtpPxh05.remove(function (o) {
                                return o.fiIdTtpPxh() == item.fiIdTtpPxh();
                            });
                            for (var i = 0; i < self.lstTbdhsTtpPxh05().length; i++) {
                                self.lstTbdhsTtpPxh05()[i].fiStt(i + 1);
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

    self.btnAddNewClickPXH = function () {
        self.updatePXH(null)
        return false;
    }
    self.btnEditClickPXH = function (item) {
        self.updatePXH(item, 'edit')
        return false;
    }

    self.updatePXH = function (item, action) {
        var html = [
            $('#phongXahHo-template').html()
        ].join('');
        options.phongXaHo = item;
        self.phongXaHoVM = new FormPhongXaHoVM(options);
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

                        if (self.phongXaHoVM.isValid()) {
                            app.Alert('Bạn phải nhập vào đầy đủ thông tin của nguồn phóng xạ hở.');
                        } else {
                            if(self.phongXaHoVM.lstMucdichsudungho().includes("10")){
                                if(self.phongXaHoVM.fiMucDichSuDungKhac()===null || self.phongXaHoVM.fiMucDichSuDungKhac()===""){
                                    app.Alert('Bạn phải nhập vào đầy đủ thông tin của nguồn phóng xạ hở.');
                                    $('#fiMucDichSuDungKhacHo-lbl').show();
                                    return;
                                }else{
                                    $('#fiMucDichSuDungKhacHo-lbl').hide();
                                }
                            }else{
                                $('#fiMucDichSuDungKhacHo-lbl').hide();
                            }


                            var pxhInfo = self.phongXaHoVM.toJSON();
                            var hoatdo = self.phongXaHoVM.lstHoatDoDonVi().find(obj => obj.id === pxhInfo.fiHoatDoDonVi);
                            pxhInfo.fiTenHoatDoDonVi = hoatdo.name;


                            if (null == pxhInfo.fiIdTtpPxh) {
                                pxhInfo.fiIdTtpPxh = -1 * new Date().getTime();
                                pxhInfo.fiStt = self.lstTbdhsTtpPxh05().length + 1;
                                var pxhModel = new TbdhsTtpPxh05(pxhInfo);
                                self.lstTbdhsTtpPxh05.push(pxhModel);
                            } else {
                                for (var i = 0; i < self.lstTbdhsTtpPxh05().length; i++) {
                                    if (pxhInfo.fiIdTtpPxh == self.lstTbdhsTtpPxh05()[i].fiIdTtpPxh()) {
                                        var pxhModel = new TbdhsTtpPxh05(pxhInfo);
                                        self.lstTbdhsTtpPxh05.replace(self.lstTbdhsTtpPxh05()[i], pxhModel);
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
        if (action != 'edit' && item != null && item.fiIdTtpPxh() > 0) {
            $(".btn-save").hide();
        }
        ko.applyBindings(self.phongXaHoVM, document.getElementById('phongXahHo-vm'));
        var array = self.phongXaHoVM.lstMucdichsudungho();
        var found = array.find(function (element) {
            return element == 10;
        });
        if (found != null) {
            $(".fiMucDichSuDungKhac").show();
//            $(".fiMucDichSuDungKhac").css("display", "inline");
        } else {
            $(".fiMucDichSuDungKhac").hide();
//            $(".fiMucDichSuDungKhac").css("display", "none");
        }
        $("#fiTenDongViPhongXa").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
        $("#fiHoatDoDonVi").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
        $("#fiMaMucDichSuDung").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
        return false;
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
            $("#soGiayPhep").attr("disabled", true);
            $("#ngayCap").attr("disabled", true);
            $("#fiLydocaplai").attr("disabled", true);
        } else {
            //=2,=3 validate fiSoGiayPhep and fiNgayCap
            //=4 validate fiSoGiayPhep and fiNgayCap and fiLydocaplai
            if (self.fiSoGiayPhep() == null || self.fiNgayCap() == null || self.fiSoGiayPhep() == "" || self.fiNgayCap() == "") {
//                $("#valid-soGiayPhep").show();
                $("#sogiaypheplabel").show();
//                $("#valid-ngayCap").show();
                $("#ngaycaplabel").show();
            }
            //disable
            $("#soGiayPhep").removeAttr("disabled");
            $("#ngayCap").removeAttr("disabled");

            if (htValue == 2 || htValue == 3) {
                $("#fiLydocaplai").attr("disabled", true);
//                $("#valid-fiLydocaplai").hide();
                $("#lydocaplailabel").hide();
            }

            if (htValue == 4 && self.fiLydocaplai() == null) {
//                $("#valid-fiLydocaplai").show();
                $("#lydocaplailabel").show();
                $("#fiLydocaplai").removeAttr("disabled");
            }
        }
    }

    self.isValidht = function () {
        self.htcapAction();
        self.validHTC();
        var flag = true;
        var htValue = self.fiHinhThucCap();

        if (htValue != 1) {
            if (self.fiSoGiayPhep() == null || self.fiNgayCap() == null || self.fiSoGiayPhep() == "" || self.fiNgayCap() == "") {
                flag = false;
            }
            if (htValue == 4 && self.fiLydocaplai() == null) {
                flag = false;
            }
        }
        return flag;
    }

    self.validHTC = function () {
        
        var htValue = self.fiHinhThucCap();
        if(htValue!=1){
            if (self.fiSoGiayPhep() != null && self.fiSoGiayPhep() != "")
                $("#valid-soGiayPhep").hide();
            else
                $("#valid-soGiayPhep").show();
            if (self.fiNgayCap() != null)
                $("#valid-ngayCap").hide();
            else
                $("#valid-ngayCap").show();
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
            $("#soGiayPhep").val("");
            $("#ngayCap").val("");
            self.fiSoGiayPhep = ko.observable(null);
            self.fiNgayCap = ko.observable(null);
        }
        if (idSlc != 4) {
            $("#fiLydocaplai").val("");
            self.fiLydocaplai = ko.observable(null);
        }


        self.htcapAction();
        app.getCategory('/most/p05/danhmuc', 'DM_TEPTIN', self.fiHinhThucCap(), function (res) {
            if (res.success) {
                self.lstTeptin05(mapFilesVM(res.data, self.fiMaHoso()));
            } else {
                self.lstTeptin05([]);
            }
        })
    }
    if (self.fiHinhThucCap()) {
        self.htcapAction();
        app.getCategory('/most/p05/danhmuc', 'DM_TEPTIN', self.fiHinhThucCap(), function (res) {
            if (res.success) {
                DINHKEMDATA = res.data;
                self.lstTeptin05(mapFilesVM(hosoInfo.hasOwnProperty('lstTeptin05') ? hosoInfo.lstTeptin05 : [], self.fiMaHoso()));
            } else {
                DINHKEMDATA = [];
                self.lstTeptin05(mapFilesVM(hosoInfo.hasOwnProperty('lstTeptin05') ? hosoInfo.lstTeptin05 : [], self.fiMaHoso()));
            }
        })
    }


    //validate phong xa kin hoac phong xa ho
    self.isValidPhongXa = function () {
        var flag = false;

        if (self.lstTbdhsNkpxTtpnpxk05().length > 0 || self.lstTbdhsTtpPxh05().length > 0) {
            flag = true;
        }

        return flag;
    }
    
    //valid ngay du kien nhap khau
    self.validNgayDuKienNKhau = function(){
        if(self.fiNkcpxNgayDuKien() === null || self.fiNkcpxNgayDuKien()===""){
            $("#fiNkcpxNgayDuKien-lbl").show();
        }else{
            $("#fiNkcpxNgayDuKien-lbl").hide();
        }
    }
    //Remove from toJSON
    self.isValidForm = function () {
        //self.isValidht();
        //Kiem tra thong tin Ho so
        var errorHoso = true;
        var errorDinhkem = true;
        self.errorlistpxkMessage(null);
        self.errorlistpxhoMessage(null);
        self.errorDinhKemMessage(null);

        self.validNgayDuKienNKhau();
        //validate hinh thuc cap
//        if(!self.isValidht()){
//            errorHoso = false;
//        }

        if (self.isValidht() === false) {
            errorHoso = false;
        }

        if (self.hosoErrors().length > 0) {
            self.hosoErrors.showAllMessages();
            errorHoso = false;
        }

        //Kiem tra thong tin dinh kem
        if (!self.lstTeptin05() || self.lstTeptin05().length <= 0) {
            self.errorDinhKemMessage('* Chưa khai báo thông tin đính kèm');
            errorDinhkem = false;
        } else {
            self.errorDinhKemMessage(null);
        }
        if (self.lstTeptin05() && self.lstTeptin05().length > 0) {
            for (var i = 0; i < self.lstTeptin05().length; i++) {
                var attach = self.lstTeptin05()[i];
                if (attach.isRequire()) {
                    if (!attach.fiIdTailieu() || !attach.fiTenTep() || !attach.fiDuongDan()) {
                        errorDinhkem = false;
                        self.errorDinhKemMessage('* Chưa khai báo thông tin đính kèm');
                        break;
                    }
                }
            }
        }

        return errorHoso && errorDinhkem;
    };
//VALIDATE DATA ON FORM
//Convert to json object
    self.toJSON = function () {
        var mapping = {
            ignore: ['btnAddNewClickPXH', 'btnAddNewClickPXK', 'btnEditClickPXH', 'btnEditClickPXK',
                'btnUpdatePXK', 'errorDinhKemMessage', 'errorlistpxkMessage', 'errorlistpxhoMessage', 'getLstDinhKem', 'hosoErrors',
                'init', 'isValidForm', 'lstCQXL', 'lstCuaKhau', 'lstLyDoDN', 'lstHinhThuccap', 'removePXHOnClick', 'init',
                'lstTinhThanh', 'phongXaHoVM', 'phongXaKinVM', 'pop',
                'removePXKOnClick', 'toJSON', 'updatePXH']
        };
        var copy = ko.mapping.fromJS(self, mapping);
        copy = ko.toJS(copy);
        for (var i = 0; i < copy.lstTeptin05.length; i++) {
            delete copy.lstTeptin05[i]['canUpload'];
            delete copy.lstTeptin05[i]['canDownload'];
            delete copy.lstTeptin05[i]['canDelete'];
            delete copy.lstTeptin05[i]['doUpload'];
            delete copy.lstTeptin05[i]['doDelete'];
            delete copy.lstTeptin05[i]['downloadUrl'];
            delete copy.lstTeptin05[i]['fiBatBuoc'];
            delete copy.lstTeptin05[i]['isRequire'];
            delete copy.lstTeptin05[i]["__ko_mapping__"];
        }

        delete copy['__ko_mapping__'];
        return copy;
    };
}
;
function FormPhongXaKinVM(options) {
    var self = this;
    var phongXaKinInfo = (options !== null && options.hasOwnProperty('phongXaKin')) ? options.phongXaKin : null;

    self.fiIdHoso = ko.observable(null);
    self.fiMaHoso = ko.observable(null);
    self.fiIdTtpnpxk = ko.observable(null);
    self.fiMaDongViPhongXa = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 50 ký tự', params: 50}
    });
    self.fiTenDongViPhongXa = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiMaHieu = ko.observable(null);

    self.fiSoSeri = ko.observable(null);
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
        maxLength: {message: 'Tối đa 1 ký tự', params: 1}
    });
    self.fiNgayXacDinhHoatDo = ko.observable(null);

    self.fiMaMucDichSuDung = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiCamKetTraNguon = ko.observable(null);
    self.fiMucDichSuDungKhac = ko.observable(null);
    self.fiTbNoiDat = ko.observable(null);
    self.fiTbMaHieu = ko.observable(null);
    self.fiTbSoSeri = ko.observable(null);
    self.fiTbHangNuocSanXuat = ko.observable(null);
    self.fiTbNamSanXuat = ko.observable(null);
    self.fiTbDiDongCoDinh = ko.observable(null);
    self.fiTbKhoiLuongUrani = ko.observable(null);
    self.fiHoatdong = ko.observable(null);
    self.fiMaHoso = ko.observable(null);
    self.fiNguoitao = ko.observable(null);
    self.fiNgaytao = ko.observable(null);
    self.fiNgaycapnhap = ko.observable(null);
    self.fiTenHoatDoDonVi = ko.observable(null);
    self.lstMucdichsudung = ko.observableArray([]);
    self.lstDongViPX = ko.observableArray(mapCategory(options.hasOwnProperty('lstDongViPX') ? options.lstDongViPX : [], "fiMa", "fiTenDongvi"));
    self.lstHoatDoDonVi = ko.observableArray(mapCategory(options.hasOwnProperty('lstHoatDoDonVi') ? options.lstHoatDoDonVi : [], "fiId", "fiName"));
    self.lstNguonPXK = ko.observableArray(mapCategory(options.hasOwnProperty('lstNguonPXK') ? options.lstNguonPXK : [], "fiMa", "fiTen"));

    var pxkVG = [self.fiMaDongViPhongXa, self.fiTenDongViPhongXa, self.fiHangSanXuat, self.fiHoatDo, self.fiHoatDoDonVi,
        self.lstMucdichsudung];
    self.pxkErrors = ko.validation.group(pxkVG, {deep: true, live: true, observable: true});

    self.errorradiopxkMessage = ko.observable(null);
    self.errormucdicpxkMessage = ko.observable(null);
    self.init = function (pxKin) {
        if (pxKin !== null) {
            self.fiIdHoso(pxKin.hasOwnProperty('fiIdHoso') ? pxKin.fiIdHoso() : null);
            self.fiMaHoso(pxKin.hasOwnProperty('fiMaHoso') ? pxKin.fiMaHoso() : null);
            self.fiIdTtpnpxk(pxKin.hasOwnProperty('fiIdTtpnpxk') ? pxKin.fiIdTtpnpxk() : null);
            self.fiMaDongViPhongXa(pxKin.hasOwnProperty('fiMaDongViPhongXa') ? pxKin.fiMaDongViPhongXa() : null);
            self.fiTenDongViPhongXa(pxKin.hasOwnProperty('fiTenDongViPhongXa') ? pxKin.fiTenDongViPhongXa() : null);
            self.fiMaHieu(pxKin.hasOwnProperty('fiMaHieu') ? pxKin.fiMaHieu() : null);
            self.fiSoSeri(pxKin.hasOwnProperty('fiSoSeri') ? pxKin.fiSoSeri() : null);
            self.fiHangSanXuat(pxKin.hasOwnProperty('fiHangSanXuat') ? pxKin.fiHangSanXuat() : null);
            self.fiHoatDo(pxKin.hasOwnProperty('fiHoatDo') ? pxKin.fiHoatDo() : null);
            self.fiHoatDoDonVi(pxKin.hasOwnProperty('fiHoatDoDonVi') ? pxKin.fiHoatDoDonVi() : null);
            self.fiTenHoatDoDonVi(pxKin.hasOwnProperty('fiTenHoatDoDonVi') ? pxKin.fiTenHoatDoDonVi() : null);
//            if( self.fiNgayXacDinhHoatDo()==null){
//                self.fiNgayXacDinhHoatDo(pxKin.hasOwnProperty('fiNgayXacDinhHoatDo') ? pxKin.fiNgayXacDinhHoatDo() : null);
//            }
            self.fiNgayXacDinhHoatDo(pxKin.hasOwnProperty('fiNgayXacDinhHoatDo') ? pxKin.fiNgayXacDinhHoatDo() : null);

            if (self.fiNgayXacDinhHoatDo() != null)
                self.fiNgayXacDinhHoatDo(new Date(self.fiNgayXacDinhHoatDo()));


            self.fiMaMucDichSuDung(pxKin.hasOwnProperty('fiMaMucDichSuDung') ? pxKin.fiMaMucDichSuDung() : null);
            self.fiCamKetTraNguon(pxKin.hasOwnProperty('fiCamKetTraNguon') ? pxKin.fiCamKetTraNguon() : null);
            self.fiTbMaHieu(pxKin.hasOwnProperty('fiTbMaHieu') ? pxKin.fiTbMaHieu() : null);
            self.fiTbSoSeri(pxKin.hasOwnProperty('fiTbSoSeri') ? pxKin.fiTbSoSeri() : null);
            self.fiTbHangNuocSanXuat(pxKin.hasOwnProperty('fiTbHangNuocSanXuat') ? pxKin.fiTbHangNuocSanXuat() : null);
            self.fiTbNamSanXuat(pxKin.hasOwnProperty('fiTbNamSanXuat') ? pxKin.fiTbNamSanXuat() : null);
            self.fiTbDiDongCoDinh(pxKin.hasOwnProperty('fiTbDiDongCoDinh') ? pxKin.fiTbDiDongCoDinh() : null);
            self.fiTbKhoiLuongUrani(pxKin.hasOwnProperty('fiTbKhoiLuongUrani') ? pxKin.fiTbKhoiLuongUrani() : null);
            self.fiHoatdong(pxKin.hasOwnProperty('fiHoatdong') ? pxKin.fiHoatdong() : null);
            self.fiMaHoso(pxKin.hasOwnProperty('fiMaHoso') ? pxKin.fiMaHoso() : null);
            self.fiHoatdong(pxKin.hasOwnProperty('fiHoatdong') ? pxKin.fiHoatdong() : null);
            self.fiNguoitao(pxKin.hasOwnProperty('fiNguoitao') ? pxKin.fiNguoitao() : null);
            self.fiNgaytao(pxKin.hasOwnProperty('fiNgaytao') ? pxKin.fiNgaytao() : null);
            self.fiNgaycapnhap(pxKin.hasOwnProperty('fiNgaycapnhap') ? pxKin.fiNgaycapnhap() : null);
            self.fiMucDichSuDungKhac(pxKin.hasOwnProperty('fiMucDichSuDungKhac') ? pxKin.fiMucDichSuDungKhac() : null);
            self.fiTbNoiDat(pxKin.hasOwnProperty('fiTbNoiDat') ? pxKin.fiTbNoiDat() : null);
            //covert string to array
            var array = self.fiMaMucDichSuDung().split(";");
            self.lstMucdichsudung(array);

        }
    }
    self.init(phongXaKinInfo);

    self.changeUngDungKhacKin = function(){
        if(self.fiMucDichSuDungKhac()===null || self.fiMucDichSuDungKhac()===""){
            $("#fiMucDichSuDungKhacKin-lbl").show();
        }else{
            $("#fiMucDichSuDungKhacKin-lbl").hide();
        }
    }

    self.mucdichAction = function () {
        var array = self.lstMucdichsudung();
        var found = array.find(function (element) {
            return element == 10;
        });
        if (found != null) {
            $(".fiMucDichSuDungKhac").css("display", "inline");
            
            if(self.fiMucDichSuDungKhac()===null || self.fiMucDichSuDungKhac()===""){
                $("#fiMucDichSuDungKhacKin-lbl").show();
            }else{
                $("#fiMucDichSuDungKhacKin-lbl").hide();
            }
            
        } else {
            self.fiMucDichSuDungKhac(null);
            $(".fiMucDichSuDungKhac").css("display", "none");
            $("#fiMucDichSuDungKhacKin-lbl").hide();
        }
        if (array.length > 0)
            $('#fiMaMucDichSuDungEr').hide();
        else
            $('#fiMaMucDichSuDungEr').show();

    }

    self.toJSON = function () {
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
        var exclude = ["init", "fiStt", "isValid", "lstDongViPX", "lstHoatDoDonVi",
            "lstNguonPXK", "pxkErrors", "toJSON"];

        var model = ko.toJS(self);

        for (var key in model) {
            if (exclude.indexOf(key) >= 0) {
                delete model[key];
            }
        }

        return model;
    };
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
            self.fiCamKetTraNguon(1);
        }
        if ($('#rdCo').prop('checked')) {
            self.fiCamKetTraNguon(2);
        }
        var errorradiopxk = true;
        var errormucdicpxk = true;
         if (self.fiCamKetTraNguon() == null) {
            self.errorradiopxkMessage('Thông tin bắt buộc nhập');
            errorradiopxk = true;
            return errorradiopxk;
        }
        self.errorradiopxkMessage(null);
        self.errormucdicpxkMessage(null);
        if (self.lstMucdichsudung().length <= 0) {
            self.errormucdicpxkMessage('Thông tin bắt buộc nhập');
            self.pxkErrors.showAllMessages();
            errormucdicpxk = true;
            return  errormucdicpxk;
        }
       
        if (self.pxkErrors().length > 0) {
            self.pxkErrors.showAllMessages();
            return true;
        }
    };

}
;

function FormPhongXaHoVM(options) {
    var self = this;

    var pxhInfo = options.phongXaHo;

    self.fiIdHoso = ko.observable(null);
    self.fiMaHoso = ko.observable(null);
    self.fiIdTtpPxh = ko.observable(null);
    self.fiMaDongViPhongXa = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 50 ký tự', params: 50}
    });
    self.fiTenDongViPhongXa = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiHangSanXuat = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiCongThucHoaHoc = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 2000 ký tự', params: 2000}
    });
    self.fiTrangThaiVatLy = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiTongHoatDoTrongNam = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        pattern: {
            message: 'Bạn chỉ được nhập số hoặc số thập phân sau dấu chấm 3 chữ số',
            params: /^[0-9]{1,12}(?:\.[0-9]{1,3})?$/
        }
    });
    self.fiHoatDoDonVi = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 1 ký tự', params: 1}
    });
    self.fiMaMucDichSuDung = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiMucDichSuDungKhac = ko.observable(null).extend({
        maxLength: {message: 'Tối đa 500 ký tự', params: 500}
    });
    self.fiTrangthai = ko.observable(null);
    self.fiTenHoatDoDonVi = ko.observable(null);
    self.fiNguoitao = ko.observable(null);
    self.fiHoatdong = ko.observable(null);
    self.fiNgaytao = ko.observable(null);
    self.fiNgCapnhat = ko.observable(null);
    self.lstMucdichsudungho = ko.observableArray([]);
    console.log(options);
    self.lstDongViPX = ko.observableArray(mapCategory(options.hasOwnProperty('lstDongViPX') ? options.lstDongViPX : [], "fiMa", "fiTenDongvi"));
    self.lstHoatDoDonVi = ko.observableArray(mapCategory(options.hasOwnProperty('lstHoatDoDonVi') ? options.lstHoatDoDonVi : [], "fiId", "fiName"));
    self.lstNguonPXK = ko.observableArray(mapCategory(options.hasOwnProperty('lstNguonPXK') ? options.lstNguonPXK : [], "fiMa", "fiTen"));

    var pxHoVG = [self.fiMaDongViPhongXa, self.fiHangSanXuat
                , self.fiCongThucHoaHoc, self.fiTrangThaiVatLy, self.fiTongHoatDoTrongNam, self.fiHoatDoDonVi
                , self.lstMucdichsudungho]
    self.pxhError = ko.validation.group(pxHoVG, {deep: true, live: true, observable: true});

    self.errormucdicpxhMessage = ko.observable(null);
//    self.errorhsx = ko.observable(null);
//    self.errorcthh = ko.observable(null);
//    self.errorttvl = ko.observable(null);
    self.errortdhd = ko.observable(null);

    self.init = function (pxHo) {
        if (pxHo !== null) {
            self.fiIdHoso(pxHo.hasOwnProperty('fiIdHoso') ? pxHo.fiIdHoso() : null);
            self.fiMaHoso(pxHo.hasOwnProperty('fiMaHoso') ? pxHo.fiMaHoso() : null);
            self.fiIdTtpPxh(pxHo.hasOwnProperty('fiIdTtpPxh') ? pxHo.fiIdTtpPxh() : null);
            self.fiMaDongViPhongXa(pxHo.hasOwnProperty('fiMaDongViPhongXa') ? pxHo.fiMaDongViPhongXa() : null);
            self.fiTenDongViPhongXa(pxHo.hasOwnProperty('fiTenDongViPhongXa') ? pxHo.fiTenDongViPhongXa() : null);
            self.fiHangSanXuat(pxHo.hasOwnProperty('fiHangSanXuat') ? pxHo.fiHangSanXuat() : null);
            self.fiCongThucHoaHoc(pxHo.hasOwnProperty('fiCongThucHoaHoc') ? pxHo.fiCongThucHoaHoc() : null);
            self.fiHoatDoDonVi(pxHo.hasOwnProperty('fiHoatDoDonVi') ? pxHo.fiHoatDoDonVi() : null);
            self.fiTenHoatDoDonVi(pxHo.hasOwnProperty('fiTenHoatDoDonVi') ? pxHo.fiTenHoatDoDonVi() : null);
            self.fiTongHoatDoTrongNam(pxHo.hasOwnProperty('fiTongHoatDoTrongNam') ? pxHo.fiTongHoatDoTrongNam() : null);
            self.fiTrangThaiVatLy(pxHo.hasOwnProperty('fiTrangThaiVatLy') ? pxHo.fiTrangThaiVatLy() : null);
            self.fiMaMucDichSuDung(pxHo.hasOwnProperty('fiMaMucDichSuDung') ? pxHo.fiMaMucDichSuDung() : null);
            self.fiHoatdong(pxHo.hasOwnProperty('fiHoatdong') ? pxHo.fiHoatdong() : null);
            self.fiMaHoso(pxHo.hasOwnProperty('fiMaHoso') ? pxHo.fiMaHoso() : null);
            self.fiHoatdong(pxHo.hasOwnProperty('fiHoatdong') ? pxHo.fiHoatdong() : null);
            self.fiNguoitao(pxHo.hasOwnProperty('fiNguoitao') ? pxHo.fiNguoitao() : null);
            self.fiNgaytao(pxHo.hasOwnProperty('fiNgaytao') ? pxHo.fiNgaytao() : null);
            self.fiMucDichSuDungKhac(pxHo.hasOwnProperty('fiMucDichSuDungKhac') ? pxHo.fiMucDichSuDungKhac() : null);
            //covert string to array
            var array = self.fiMaMucDichSuDung().split(";");
            self.lstMucdichsudungho(array);
            //tim ra




        }
    }
    self.init(pxhInfo);

    self.changeUngDungKhacHo = function () {
        if (self.fiMucDichSuDungKhac() === null || self.fiMucDichSuDungKhac === "") {
            $('#fiMucDichSuDungKhacHo-lbl').show();
        } else {
            $('#fiMucDichSuDungKhacHo-lbl').hide();
        }
    }

    self.mucdichhoAction = function () {
        var array = self.lstMucdichsudungho();
        var found = array.find(function (element) {
            return element == 10;
        });
        if (found != null) {
            $(".fiMucDichSuDungKhac").show();
            if (self.fiMucDichSuDungKhac() === null || self.fiMucDichSuDungKhac === "") {
                $('#fiMucDichSuDungKhacHo-lbl').show();
            } else {
                $('#fiMucDichSuDungKhacHo-lbl').hide();
            }
        } else {
            self.fiMucDichSuDungKhac(null);
            $(".fiMucDichSuDungKhac").hide();
            $('#fiMucDichSuDungKhacHo-lbl').hide();
        }
        if (self.lstMucdichsudungho().length == 0) {
            $('#fiMaMucDichSuDungHo').show();
        } else {
            $('#fiMaMucDichSuDungHo').hide();
        }

        //valid ung dung khac

    }
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
        var exclude = ["init", "htcapAction", "getLstTeptin", "isValid", "lstDongViPX", "lstHoatDoDonVi",
            "lstNguonPXK", "pxkErrors", "toJSON"];

        var model = ko.toJS(self);

        for (var key in model) {
            if (exclude.indexOf(key) >= 0) {
                delete model[key];
            }
        }

        return model;
    };

    self.isValid = function () {
        var errormucdicpxh = false;

        self.errormucdicpxhMessage(null);
//        self.errorhsx(null);
//        self.errorcthh(null);
//        self.errorttvl(null);
//        self.errortdhd(null);

//        if (self.fiHangSanXuat() == null) {
//            self.errorhsx('Thông tin bắt buộc nhập');
//            errormucdicpxh = true;
//        }

//        if (self.fiCongThucHoaHoc() == null) {
//            self.errorcthh('Thông tin bắt buộc nhập');
//            errormucdicpxh = true;
//        }
//
//        if (self.fiTrangThaiVatLy() == null) {
//            self.errorttvl('Thông tin bắt buộc nhập');
//            errormucdicpxh = true;
//        }
//
//        if (self.fiTongHoatDoTrongNam() == null) {
//            self.errortdhd('Thông tin bắt buộc nhập');
//            errormucdicpxh = true;
//        }
        if (self.lstMucdichsudungho().length <= 0) {
            $('#fiMaMucDichSuDungHo').show();
            errormucdicpxh = true;
            return errormucdicpxh;
        }


        if (self.fiTongHoatDoTrongNam() == null) {
            self.errortdhd('Thông tin bắt buộc nhập');
            errormucdicpxh = true;
        }


//
//        if (self.lstMucdichsudungho().length <= 0) {
//            self.errormucdicpxhMessage('Thông tin bắt buộc nhập');
//            errormucdicpxh = true;
//            return errormucdicpxh;
//        }


        if (self.pxhError().length > 0) {
            self.pxhError.showAllMessages();
            return true;
        }
    };
    //xu ly radio button
}
;
    