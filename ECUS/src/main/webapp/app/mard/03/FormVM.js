/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function FormVM(options) {
    var self = this;
    var hosoInfo = (options !== null && options.hasOwnProperty('hoso')) ? options.hoso : null;

    //thong tin chung ho so
    self.fiMaHoSo = ko.observable(null);
    self.fiIdHoSo = ko.observable(null);
    self.fiTrangThai = ko.observable(null);
    self.fiTrangThaiMa = ko.observable(null);
    self.fiNgayTao = ko.observable(null);
    self.fiSoDonKhaiBao = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiSoCongVanCap = ko.observable(null);
    self.fiSoGcnKdNk = ko.observable(null);
    self.fiMaCQ = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 12 ký tự', params: 12}
    });
    self.fiTenCQ = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiMaNoiDK = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 12 ký tự', params: 12}
    });
    self.fiTenNoiDK = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiMaLoaiSp = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 12 ký tự', params: 12}
    });
    self.fiTenLoaiSp = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });

    //thong tin doanh nghiep
    self.fiTenDn = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiMstDn = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiDiaChiDn = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiSdtDn = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiFaxDn = ko.observable(null);
    self.fiEmailDn = ko.observable(null);

    //thong tin hang hoa 1
    self.fiSoHopDongCt = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });

    // thong tin hang hoa 2
    self.fiGiaTriLoHang = ko.observable(null);
    self.fiGcnXk = ko.observable(null);
    self.fiNgayCapGcnXk = ko.observable(null);
    self.fiToChucXk = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiMaNuocXk = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiTenNuocXk = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiMaCuaKhauXuat = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiTenCuaKhauXuat = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiToChucNk = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiMaNuocNk = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiTenNuocNk = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiPtVanChuyen = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiMaCuaKhauNhap = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiTenCuaKhauNhap = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiMucDichSuDung = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiVbChapThuanKiemDich = ko.observable(null);
    self.fiDiaDiemKiemDich = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiTgKiemDichTu = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiTgKiemDichDen = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiDiaDiemGs = ko.observable(null);
    self.fiTgGsTu = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiTgGsDen = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiSoGcnKiemDich = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });


    //thong tin ky
    self.fiNoiKy = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiNgayKy = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiNguoiKy = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });


    self.reason = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 500 ký tự', params: 500}
    });

    //thong tin hien thi hang hoa
    self.isView1 = ko.observable(false);
    self.isView2 = ko.observable(false);
    self.isView3 = ko.observable(false);

    self.lstTepTin03 = ko.observableArray([]);
    self.lstHangHoa03 = ko.observableArray([]);
    self.lstCQXL = ko.observableArray(mapCategory(options.hasOwnProperty('lstCQXL') ? options.lstCQXL : [], "maCoQuan", "tenCoQuan"));
    self.lstRegPlace = ko.observableArray(mapCategory(options.hasOwnProperty('lstRegPlace') ? options.lstRegPlace : [], "maDky", "tenDky"));
    self.lstSoLuongDvt = ko.observableArray(mapCategory(options.hasOwnProperty('lstSoLuongDvt') ? options.lstSoLuongDvt : [], "maDvt", "tenDvt"));
    self.lstDvt = ko.observableArray(mapCategory(options.hasOwnProperty('lstDvt') ? options.lstDvt : [], "maDvt", "tenDvt"));
    self.lstCuaKhau = ko.observableArray(mapCategory(options.hasOwnProperty('lstCuaKhau') ? options.lstCuaKhau : [], "portCode", "portName"));
    self.lstQuocGia = ko.observableArray(mapCategory(options.hasOwnProperty('lstQuocGia') ? options.lstQuocGia : [], "maQuocgia", "tenQuocgia"));
    self.lstLoaiSp = ko.observableArray(mapCategory(options.hasOwnProperty('lstLoaiSp') ? options.lstLoaiSp : [], "maLoaiSp", "tenLoaiSp"));

    //=====================================================================================================================

    var lydoVG = [self.reason]
    var hosoVG = [
        self.fiSoDonKhaiBao, self.fiMaCQ, self.fiTenCQ, self.fiMaNoiDK, self.fiTenNoiDK, self.fiMaLoaiSp, self.fiTenLoaiSp, self.fiTenDn, self.fiMstDn,
        self.fiDiaChiDn, self.fiSdtDn, self.fiSoHopDongCt, self.fiToChucXk, self.fiMaNuocXk, self.fiTenNuocXk, self.fiMaCuaKhauXuat, self.fiTenCuaKhauXuat,
        self.fiToChucNk, self.fiMaNuocNk, self.fiTenNuocNk, self.fiPtVanChuyen, self.fiMaCuaKhauNhap, self.fiTenCuaKhauNhap, self.fiMucDichSuDung,
        self.fiDiaDiemKiemDich, self.fiTgKiemDichTu, self.fiTgKiemDichDen, self.fiTgGsTu, self.fiTgGsDen, self.fiSoGcnKiemDich, self.fiNoiKy, self.fiNgayKy, self.fiNguoiKy
    ];
    self.hosoErrors = ko.validation.group(hosoVG, {deep: true, live: true, observable: true});
    self.lydoErrors = ko.validation.group(lydoVG, {deep: true, live: true, observable: true});
    self.htcErrors = ko.observable(null);
    self.errorDinhKemMessage = ko.observable(null);

    self.clearNgayKy = function () {
        self.fiNgayKy(null);
    };
    self.clearNgayCapGcnXk = function () {
        self.fiNgayCapGcnXk(null);
    };
    self.clearTgKiemDichTu = function () {
        self.fiTgKiemDichTu(null);
    };
    self.clearTgKiemDichDen = function () {
        self.fiTgKiemDichDen(null);
    };
    self.clearTgGsTu = function () {
        self.fiTgGsTu(null);
    };
    self.clearTgGsDen = function () {
        self.fiTgGsDen(null);
    };

    // lay theo loai san pham
    self.changeLoaiSp = function () {
        self.lstHangHoa03 = ko.observableArray([]);
        if (self.fiMaLoaiSp() == 1) {
            self.isView1(true);
            self.isView2(false);
        } else {
            self.isView1(false);
            self.isView2(true);
        }
    }

    //lay cac truong so cong van và so gcn theo noi dang ky
    self.changeNoiDk = function () {
        if (self.fiMaNoiDK() == 1) {
            self.isView3(false);
        } else {
            self.isView3(true);
            getLstKddv();
            getLstKdSpdv();
        }
    }

    //Khoi tao gia tri ho so
    self.init = function (hoso) {
        self.fiTenDn(hoso !== null && hoso.hasOwnProperty('fiTenDn') ? hoso.fiTenDn : user.companyName);
        self.fiDiaChiDn(hoso !== null && hoso.hasOwnProperty('fiDiaChiDn') ? hoso.fiDiaChiDn : user.companyAddress);
        self.fiSdtDn(hoso !== null && hoso.hasOwnProperty('fiSdtDn') ? hoso.fiSdtDn : user.companyPhoneNumber);
        self.fiMstDn(hoso !== null && hoso.hasOwnProperty('fiMstDn') ? hoso.fiMstDn : user.username);
        self.fiFaxDn(hoso !== null && hoso.hasOwnProperty('fiFaxDn') ? hoso.fiFaxDn : null);
        self.fiEmailDn(hoso !== null && hoso.hasOwnProperty('fiEmailDn') ? hoso.fiEmailDn : null);

        if (hoso !== null) {
            self.fiMaHoSo(hoso.hasOwnProperty('fiMaHoSo') ? hoso.fiMaHoSo : null);
            self.fiIdHoSo(hoso.hasOwnProperty('fiIdHoSo') ? hoso.fiIdHoSo : null);
            self.fiTrangThai(hoso.hasOwnProperty('fiTrangThai') ? hoso.fiTrangThai : null);
            self.fiTrangThaiMa(hoso.hasOwnProperty('fiTrangThaiMa') ? hoso.fiTrangThaiMa : null);
            self.fiNgayTao(hoso.hasOwnProperty('fiNgayTao') ? new Date(hoso.fiNgayTao) : null);
            self.fiSoDonKhaiBao(hoso.hasOwnProperty('fiSoDonKhaiBao') ? hoso.fiSoDonKhaiBao : null);
            self.fiSoCongVanCap(hoso.hasOwnProperty('fiSoCongVanCap') ? hoso.fiSoCongVanCap : null);
            self.fiSoGcnKdNk(hoso.hasOwnProperty('fiSoGcnKdNk') ? hoso.fiSoGcnKdNk : null);
            self.fiMaCQ(hoso.hasOwnProperty('fiMaCQ') ? hoso.fiMaCQ : null);
            self.fiTenCQ(hoso.hasOwnProperty('fiTenCQ') ? hoso.fiTenCQ : null);
            self.fiMaNoiDK(hoso.hasOwnProperty('fiMaNoiDK') ? hoso.fiMaNoiDK : null);
            self.fiTenNoiDK(hoso.hasOwnProperty('fiTenNoiDK') ? hoso.fiTenNoiDK : null);
            self.fiMaLoaiSp(hoso.hasOwnProperty('fiMaLoaiSp') ? hoso.fiMaLoaiSp : null);
            self.fiTenLoaiSp(hoso.hasOwnProperty('fiTenLoaiSp') ? hoso.fiTenLoaiSp : null);
            self.fiSoHopDongCt(hoso.hasOwnProperty('fiSoHopDongCt') ? hoso.fiSoHopDongCt : null);
            self.fiGiaTriLoHang(hoso.hasOwnProperty('fiGiaTriLoHang') ? hoso.fiGiaTriLoHang : null);
            self.fiGcnXk(hoso.hasOwnProperty('fiGcnXk') ? hoso.fiGcnXk : null);
            self.fiNgayCapGcnXk(hoso.hasOwnProperty('fiNgayCapGcnXk') && hoso.fiNgayCapGcnXk != null ? new Date(hoso.fiNgayCapGcnXk) : null);
            self.fiToChucXk(hoso.hasOwnProperty('fiToChucXk') ? hoso.fiToChucXk : null);
            self.fiMaNuocXk(hoso.hasOwnProperty('fiMaNuocXk') ? hoso.fiMaNuocXk : null);
            self.fiTenNuocXk(hoso.hasOwnProperty('fiTenNuocXk') ? hoso.fiTenNuocXk : null);
            self.fiMaCuaKhauXuat(hoso.hasOwnProperty('fiMaCuaKhauXuat') ? hoso.fiMaCuaKhauXuat : null);
            self.fiTenCuaKhauXuat(hoso.hasOwnProperty('fiTenCuaKhauXuat') ? hoso.fiTenCuaKhauXuat : null);
            self.fiToChucNk(hoso.hasOwnProperty('fiToChucNk') ? hoso.fiToChucNk : null);
            self.fiMaNuocNk(hoso.hasOwnProperty('fiMaNuocNk') ? hoso.fiMaNuocNk : null);
            self.fiTenNuocNk(hoso.hasOwnProperty('fiTenNuocNk') ? hoso.fiTenNuocNk : null);
            self.fiPtVanChuyen(hoso.hasOwnProperty('fiPtVanChuyen') ? hoso.fiPtVanChuyen : null);
            self.fiMaCuaKhauNhap(hoso.hasOwnProperty('fiMaCuaKhauNhap') ? hoso.fiMaCuaKhauNhap : null);
            self.fiTenCuaKhauNhap(hoso.hasOwnProperty('fiTenCuaKhauNhap') ? hoso.fiTenCuaKhauNhap : null);
            self.fiMucDichSuDung(hoso.hasOwnProperty('fiMucDichSuDung') ? hoso.fiMucDichSuDung : null);
            self.fiVbChapThuanKiemDich(hoso.hasOwnProperty('fiVbChapThuanKiemDich') ? hoso.fiVbChapThuanKiemDich : null);
            self.fiDiaDiemKiemDich(hoso.hasOwnProperty('fiDiaDiemKiemDich') ? hoso.fiDiaDiemKiemDich : null);
            self.fiTgKiemDichTu(hoso.hasOwnProperty('fiTgKiemDichTu') ? new Date(hoso.fiTgKiemDichTu) : null);
            self.fiTgKiemDichDen(hoso.hasOwnProperty('fiTgKiemDichDen') ? new Date(hoso.fiTgKiemDichDen) : null);
            self.fiDiaDiemGs(hoso.hasOwnProperty('fiDiaDiemGs') ? hoso.fiDiaDiemGs : null);
            self.fiTgGsTu(hoso.hasOwnProperty('fiTgGsTu') ? new Date(hoso.fiTgGsTu) : null);
            self.fiTgGsDen(hoso.hasOwnProperty('fiTgGsDen') ? new Date(hoso.fiTgGsDen) : null);
            self.fiSoGcnKiemDich(hoso.hasOwnProperty('fiSoGcnKiemDich') ? hoso.fiSoGcnKiemDich : null);
            self.fiNoiKy(hoso.hasOwnProperty('fiNoiKy') ? hoso.fiNoiKy : null);
            self.fiNgayKy(hoso.hasOwnProperty('fiNgayKy') ? new Date(hoso.fiNgayKy) : null);
            self.fiNguoiKy(hoso.hasOwnProperty('fiNguoiKy') ? hoso.fiNguoiKy : null);

            self.lstTepTin03(mapFiles03VM(hoso.hasOwnProperty('lstTepTin03') ? hoso.lstTepTin03 : [], self.fiIdHoSo()));
            self.lstHangHoa03(MapHangHoa03(hoso.hasOwnProperty('lstHangHoa03') ? hoso.lstHangHoa03 : []));

            //huongmk
            //dung cho view xac nhan don kiem dich dong vat
            self.fiTenHang = ko.observable(hoso && hoso.lstHangHoa03 ? hoso.lstHangHoa03[0].productName : null);
            self.fiNoiSx = ko.observable(hoso && hoso.lstHangHoa03 ? hoso.lstHangHoa03[0].productFrom : null);
            self.fiSoluongHH = ko.observable(hoso && hoso.lstHangHoa03 ? hoso.lstHangHoa03[0].quantity : null);
            self.fiTrongluong = ko.observable(hoso && hoso.lstHangHoa03 ? hoso.lstHangHoa03[0].netWeight : null);
            self.fiTrongluongcabi = ko.observable(hoso && hoso.lstHangHoa03 ? hoso.lstHangHoa03[0].grossWeight : null);
            self.fiLoaibaobi = ko.observable(hoso && hoso.lstHangHoa03 ? hoso.lstHangHoa03[0].packings : null);
            self.strNgayKy = ko.observable(null);
            if (self.fiNgayKy() !== null) {
                var dt = self.fiNgayKy();
                var d = (dt.getDate() >= 10) ? dt.getDate() : "0" + dt.getDate();
                var m = (dt.getMonth() >= 9) ? dt.getMonth() + 1 : "0" + (dt.getMonth() + 1);
                var y = dt.getFullYear();
                var strViewHtml = "ngày <b>" + d + "</b> tháng <b>" + m + "</b> năm <b>" + y + "</b>";
                self.strNgayKy(strViewHtml);
            }
            //end

            if (self.fiMaLoaiSp() == 1) {
                self.isView1(true);
                self.isView2(false);
            } else {
                self.isView1(false);
                self.isView2(true);
            }

            if (self.fiMaNoiDK() == 1) {
                self.isView3(false);
            } else {
                self.isView3(true);
            }

        } else {
            getDmTeptin();
        }

        //huongmk
        //check so giay chung nhan kiem dich cua BNN da cap co trung voi so gcn nhap vao k? co: fill data ra.
        self.fillHosoBySoGcn = function () {
            if (self.fiMaLoaiSp() == 1) {
                for (var i = 0; i < self.lstKddv().length; i++) {
                    if (self.lstKddv()[i].fiSoGcn !== null && self.fiSoGcnKdNk() === self.lstKddv()[i].fiSoGcn) {
                        self.lstHangHoa03(mapHanghoaSpdv03(self.lstKddv()[i].hasOwnProperty('lstHanghoaKddv03') ? self.lstKddv()[i].lstHanghoaKddv03 : []));
                    }
                }
            } else {
                for (var i = 0; i < self.lstKdSpdv().length; i++) {
                    if (self.lstKdSpdv()[i].fiSoGcn !== null && self.fiSoGcnKdNk() === self.lstKdSpdv()[i].fiSoGcn) {
                        self.lstHangHoa03(mapHanghoaSpdv03(self.lstKdSpdv()[i].hasOwnProperty('lstHanghoaSpdv') ? self.lstKdSpdv()[i].lstHanghoaSpdv : []));
                    }
                }
            }
        }
    };

    function getDmTeptin() {
        app.getCategory('/mard/p03/danhmuc', 'DM_TEPTIN', null, function (res) {
            if (res.success) {
                self.lstTepTin03(mapFiles03VM(res.data, self.fiIdHoSo()));
            } else {
                self.lstTepTin03([]);
            }
        });
    }

    // huongmk
    // lay list danh sach kiem dich dong vat va san pham dong vat
    self.lstKddv = ko.observableArray([]);
    self.lstKdSpdv = ko.observableArray([]);

    function getLstKddv() {
        app.getCategory('/mard/p03/kddv/getData', null, null, function (res) {
            if (res.success) {
                self.lstKddv(res.data);
                console.log(self.lstKddv())
            } else {
                self.lstKddv([]);
            }
        });
    }

    function getLstKdSpdv() {
        app.getCategory('/mard/p03/kdspdv/getData', null, null, function (res) {
            if (res.success) {
                self.lstKdSpdv(res.data);
                console.log(self.lstKdSpdv())
            } else {
                self.lstKdSpdv([]);
            }
        });
    }
    // end

    self.init(hosoInfo);

    self.btnAddHangHoa03 = function () {
        var productType = self.fiMaLoaiSp();
        if (productType == null) {
            app.Alert('Vui lòng chọn loại sản phẩm trước khi thêm hàng hóa');
            return;
        }
        self.popupHangHoa03(null, null, 'Thêm mới hàng hóa', productType);
        return false;
    };
    self.popupHangHoa03 = function (item, action, title, productType) {
        var html = [
            $('#hanghoa-template').html()
        ].join('');
        options.lstHangHoa03 = item;
        self.hangHoaVM = new HangHoaFormVM(options, productType);
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
                        debugger;
                        if (!self.hangHoaVM.validFormHH() || !self.hangHoaVM.isValidHangHoa(productType)) {
                            app.Alert('Bạn cần nhập đủ dữ liệu các trường BẮT BUỘC <span style="color:red">(*)</span>');
                        } else {
                            debugger;
                            var HangHoaInfo = self.hangHoaVM.toJSON();
                            if (null == HangHoaInfo.productId) {
                                HangHoaInfo.productId = -1 * new Date().getTime();
                                HangHoaInfo.fiStt = self.lstHangHoa03().length + 1;
                                var HangHoaModel = new HangHoa03(HangHoaInfo);
                                self.lstHangHoa03.push(HangHoaModel);
                                $('#hanghoa_valid').hide();
                            } else {
                                for (var i = 0; i < self.lstHangHoa03().length; i++) {
                                    if (HangHoaInfo.productId == self.lstHangHoa03()[i].productId()) {
                                        var HangHoaModel = new HangHoa03(HangHoaInfo);
                                        self.lstHangHoa03.replace(self.lstHangHoa03()[i], HangHoaModel);
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
                    icon: 'fa-close',
                    action: function () {
                        app.popupRemove(self.pop.selector);
                        $('.modal-scrollable').hide();
                        $('.modal-backdrop').hide();
                    }
                }
            ]
        });

        if (action === 'view' && item != null && item.productId() > 0) {
            $(".btn-save").hide();
        }
        ko.applyBindings(self.hangHoaVM, document.getElementById('hanghoa-form'));
        $("#animalMale").select2({placeholder: '-- Chọn tinh biệt --', width: '100%', allowClear: true});
        $("#quantityUnitCode").select2({placeholder: '-- Chọn đơn vị tính --', width: '100%', allowClear: true});
        $("#grossWeightUnitCode").select2({placeholder: '-- Chọn đơn vị tính --', width: '100%', allowClear: true});
        $("#netWeightUnitCode").select2({placeholder: '-- Chọn đơn vị tính --', width: '100%', allowClear: true});
    };

    //==================================================================

    // validate dinh dang email
    self.validEmail = function () {
        var flag = true;
        $('#email_valid').hide();
        var reg = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z])+$/;
        if (self.contactEmail() != null && self.contactEmail() != "") {
            if (reg.test(self.contactEmail()) == false) {
                $('#email_valid').show();
                flag = false;
            } else {
                $('#email_valid').hide();
            }
        }
        return flag;
    };
    self.validFile = function () {
        var errorDinhkem = true;
        if (!self.lstTepTin03() || self.lstTepTin03().length <= 0) {
            errorDinhkem = false;
        } else {
            self.errorDinhKemMessage(null);
        }
        if (self.lstTepTin03() && self.lstTepTin03().length > 0) {
            for (var i = 0; i < self.lstTepTin03().length; i++) {
                var attach = self.lstTepTin03()[i];
                if (attach.isRequire()) {
                    if (!attach.id() || !attach.fileNameUpload()) {
                        $("#dinhkem_valid").show();
                        errorDinhkem = false;
                        break;
                    }
                }
            }
        }
        return errorDinhkem;

    };


    self.isValidLydo = function () {
        var errorLydo = true;
        if (!self.isValidForm()) {
            errorLydo = false;
        }
        if (self.lydoErrors().length > 0) {
            self.lydoErrors.showAllMessages();
            errorLydo = false;
        }
        return errorLydo;
    }
    self.isValidForm = function () {
        //Kiem tra thong tin Ho so

        var errorHoso = true;
        var errorDinhkem = true;
        var errorHH = true;


        if (!self.lstHangHoa03() || self.lstHangHoa03().length <= 0) {
            $('#hanghoa_valid').show();
            errorHH = false;
        } else {
            $('#hanghoa_valid').hide();
        }


        if (self.hosoErrors().length > 0) {
            self.hosoErrors.showAllMessages();
            errorHoso = false;

        }
        return errorHoso && errorDinhkem && errorHH;
    };

    //VALIDATE DATA ON FORM
    //Convert to json object

    self.toJSON = function () {

        var mapping = {
            ignore: ['popupHangHoa', 'init', 'isValidForm', 'pop', 'toJSON', 'btnAddNewClickHH', 'editPopupHH', 'lstCQXL',
                'lstRegPlace', 'lstSoLuongDvt', 'lstDvt', 'lstCuaKhau', 'lstQuocGia', 'lstLoaiSp', 'hosoErrors', 'lydoErrors',
                'htcErrors', 'errorDinhKemMessage', 'clearNgayKy', 'clearNgayCapGcnXk', 'clearTgKiemDichTu', 'clearTgKiemDichDen',
                'clearTgGsTu', 'clearTgGsDen', 'changeLoaiSp', 'btnAddHangHoa03', 'popupHangHoa03', 'validEmail', 'validFile',
                'isValidLydo', 'removePopupHH', 'hangHoaVM', 'changeNoiDk', 'viewPopupHH'
            ]
        };
        var copy = ko.mapping.fromJS(self, mapping);
        copy = ko.toJS(copy);
        for (var i = 0; i < copy.lstTepTin03.length; i++) {
            delete copy.lstTepTin03[i]['canUpload'];
            delete copy.lstTepTin03[i]['canDownload'];
            delete copy.lstTepTin03[i]['canDelete'];
            delete copy.lstTepTin03[i]['doUpload'];
            delete copy.lstTepTin03[i]['doDelete'];
            delete copy.lstTepTin03[i]['downloadUrl'];
            delete copy.lstTepTin03[i]['isRequire'];
            delete copy.lstTepTin03[i]['isRequired'];
            delete copy.lstTepTin03[i]["__ko_mapping__"];
        }


        delete copy['__ko_mapping__'];
        return copy;
    };

    self.removePopupHH = function (item) {
        self.lstHangHoa03.remove(function (o) {
            return o.productId() === item.productId();
        });
        for (var i = 0; i < self.lstHangHoa03().length; i++) {
            self.lstHangHoa03()[i].fiStt(i + 1);
        }
    };

    self.editPopupHH = function (item) {
        var productType = self.fiMaLoaiSp();
        self.popupHangHoa03(item, "edit", 'Sửa hàng hóa', productType);
        return false;
    };

    self.viewPopupHH = function (item) {
        var productType = self.fiMaLoaiSp();
        self.popupHangHoa03(item, "view", 'Xem hàng hóa', productType);
        return false;
    };

};

function HangHoaFormVM(options, productType) {
    var self = this;

    var hanghoa = options.lstHangHoa03;
    self.productTypeHH = ko.observable(productType);
    self.isViewByType = ko.observable(false);
    self.isViewByType2 = ko.observable(false);

    if (productType == 1) {
        self.isViewByType(true);
    }
    if (productType == 2) {
        self.isViewByType2(true);
    }

    self.productSort = ko.observable(hanghoa ? hanghoa.fiStt() : null);
    self.productId = ko.observable(hanghoa ? hanghoa.productId() : null);
    self.fiHsCode = ko.observable(hanghoa ? hanghoa.fiHsCode() : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.productName = ko.observable(hanghoa ? hanghoa.productName() : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.productFrom = ko.observable(hanghoa ? hanghoa.productFrom() : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.quantity = ko.observable(hanghoa ? hanghoa.quantity() : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.quantityUnitCode = ko.observable(hanghoa ? hanghoa.quantityUnitCode() : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.quantityUnitName = ko.observable(hanghoa ? hanghoa.quantityUnitName() : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });

    //type = 1
    self.animalBreed = ko.observable(hanghoa ? hanghoa.animalBreed() : null);
    self.animalMale = ko.observable(hanghoa ? hanghoa.animalMale() : null);
    self.animalMaleName = ko.observable(hanghoa ? hanghoa.animalMaleName() : null);
    self.animalAge = ko.observable(hanghoa ? hanghoa.animalAge() : null);

    // type = 2
    self.netWeight = ko.observable(hanghoa ? hanghoa.netWeight() : null);
    self.netWeightUnitCode = ko.observable(hanghoa ? hanghoa.netWeightUnitCode() : null);
    self.netWeightUnitName = ko.observable(hanghoa ? hanghoa.netWeightUnitName() : null);
    self.grossWeight = ko.observable(hanghoa ? hanghoa.grossWeight() : null);
    self.grossWeightUnitCode = ko.observable(hanghoa ? hanghoa.grossWeightUnitCode() : null);
    self.grossWeightUnitName = ko.observable(hanghoa ? hanghoa.grossWeightUnitName() : null);
    self.packings = ko.observable(hanghoa ? hanghoa.packings() : null);

    self.lstGiong = ko.observableArray(mapCategory(options.hasOwnProperty('lstGiong') ? options.lstGiong : [], "maGiong", "tenGiong"));
    self.lstDvt = ko.observableArray(mapCategory(options.hasOwnProperty('lstDvt') ? options.lstDvt : [], "maDvt", "tenDvt"));


    self.errorHHMessage = ko.observable(null);
    var hanghoaVG = [
        self.fiHsCode, self.productName, self.quantity, self.quantityUnitCode, self.quantityUnitName, self.productFrom
    ];
    self.hangHoaErrors = ko.validation.group(hanghoaVG, {deep: true, live: true, observable: true});

    self.toJSON = function () {

        var exclude = ["init", "fiStt", "registrationTypeHH", "isValidHangHoa", "lstDvt", "errorHHMessage", "btnAddNewChiTieu", "toJSON"
            , "lstGiong", "checkValueData", "hangHoaErrors", "productTypeHH"
        ];

        var model = ko.toJS(self);

        for (var key in model) {
            if (exclude.indexOf(key) >= 0) {
                delete model[key];
            }
        }

        return model;
    };

    self.validFormHH = function () {
        debugger;
        var hangHoaErrors = true;
        if (self.hangHoaErrors().length > 0) {
            self.hangHoaErrors.showAllMessages();
            hangHoaErrors = false;
        }
        return hangHoaErrors;
    }

    self.isValidHangHoa = function (productType) {
        var hangHoaErrors = true;
        //tamdt
        if (productType == 1) {
            // if()
        } else {

        }

        return hangHoaErrors;
    };

};




    