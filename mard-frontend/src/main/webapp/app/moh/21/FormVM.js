/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function arrayFirstIndexOf(array, predicate, predicateOwner) {
    for (var i = 0, j = array.length; i < j; i++) {
        if (predicate.call(predicateOwner, array[i])) {
            return i;
        }
    }
    return -1;
}
function FormVM(options) {
    var self = this;
    var hosoInfo = (options !== null && options.hasOwnProperty('hoso')) ? options.hoso : null;
    var FIRST_GROUP = [1, 2, 3];
    var SECOND_GROUP = [4, 5, 6, 7, 8, 9];
    var GROUP_PRO23_LOAIDON = [1];//Nhom loai don hien thi thuoc tinh thuoc
    var CONSTANT = {
        THU_TUC: {
            PRO_21: 21,
            PRO_22: 22,
            PRO_23: 23
        }
    };

    var proceduceId = function () {
        var pName = document.location.pathname;
        var items = pName.split('/');
        return items[items.length - 2];
    };

    self.fiThuTucId = ko.observable(proceduceId());

    //Thong tin chung
    self.fiIdHoso = ko.observable(null);
    self.fiMaHoso = ko.observable(null);
    self.fiNgaynop = ko.observable(null);
    self.fiLoaiDon = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });

    self.isFirstGroup = ko.computed(function () {
        return null != self.fiLoaiDon() && FIRST_GROUP.indexOf(self.fiLoaiDon()) >= 0;
    }, self);

    self.isSecondGroup = ko.computed(function () {
        return null != self.fiLoaiDon() && SECOND_GROUP.indexOf(self.fiLoaiDon()) >= 0;
    }, self);

    self.fiHoatdong = ko.observable(1);
    self.fiNguoitao = ko.observable(null);
    self.fiNgaytao = ko.observable(null);
    self.fiNgCapnhat = ko.observable(null);
    self.fiTrangthai = ko.observable(0);
    self.fiTenTt = ko.observable(null);
    self.fiSoCongvan = ko.observable(null);
    self.fiNgaycapCv = ko.observable(null).extend({
        pattern: '[0-9]{2}/[0-9]{2}/[0-9]{4}'
    });
    self.fiMaThutuc = ko.observable(options.maThuTuc);
    self.fiTenThutuc = ko.observable(null);

    self.fiMaCuaKhau = ko.observable(null);
    self.fiTenCuaKhau = ko.observable(null);

    //doanhNghiep
    self.fiIdDn = ko.observable(null);
    self.fiMstDn = ko.observable(null);
    self.fiTenDn = ko.observable(null).extend({
        required: {message: '30' + NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiMaTinh = ko.observable(null).extend({
        required: {message: '29' + NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiTenTinh = ko.observable(null);
    self.fiDiachiDn = ko.observable(null).extend({
        required: {message: '28' + NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiNguoiDd = ko.observable(null).extend({
        required: {message: '27' + NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiChucvuNgDd = ko.observable(null).extend({
        required: {message: '26' + NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiTenDnEn = ko.observable(null).extend({
        maxLength: {message: 'Tối đa 255 ký tự', params: 255},
        required: {
            message: '25' + NSWLang["common_msg_formvaild_required"],
            onlyIf: function () {
                if (proceduceId() == CONSTANT.THU_TUC.PRO_21 || proceduceId() == CONSTANT.THU_TUC.PRO_22) {
                    return self.isSecondGroup();
                } else {
                    return true;
                }
            }
        }
    });
    self.fiDiachiDnEn = ko.observable(null).extend({
        maxLength: {message: 'Tối đa 255 ký tự', params: 255},
        required: {
            message: '24' + NSWLang["common_msg_formvaild_required"],
            onlyIf: function () {
                if (proceduceId() == CONSTANT.THU_TUC.PRO_21 || proceduceId() == CONSTANT.THU_TUC.PRO_22) {
                    return self.isSecondGroup();
                } else {
                    return true;
                }
            }
        }
    });

    //Don hang
    self.fiIdDonhang = ko.observable(null);
    self.fiXuatXu = ko.observable(null).extend({
        required: {message: '23' + NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiTenThuoc = ko.observable(null).extend({
        maxLength: {message: 'Tối đa 255 ký tự', params: 255},
        required: {
            message: '22' + NSWLang["common_msg_formvaild_required"],
            onlyIf: function () {
                if (proceduceId() == CONSTANT.THU_TUC.PRO_21 || proceduceId() == CONSTANT.THU_TUC.PRO_22) {
                    return true;
                } else {//Thu tuc 23
                    return (self.fiLoaiDon() == 1);
                }
            }
        }
    });
    self.fiMaHang = ko.observable(null).extend({
        required: {
            message: '21' + NSWLang["common_msg_formvaild_required"],
            onlyIf: function () {
                if (proceduceId() == CONSTANT.THU_TUC.PRO_21 || proceduceId() == CONSTANT.THU_TUC.PRO_22) {
                    return false;
                } else {//Thu tuc 23
                    return (self.fiLoaiDon() == 2);
                }
            }
        }
    });
    self.fiTenHang = ko.observable(null).extend({
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiBaoChe = ko.observable(null).extend({
        maxLength: {message: 'Tối đa 255 ký tự', params: 255},
        required: {
            message: '20' + NSWLang["common_msg_formvaild_required"],
            onlyIf: function () {
                if (proceduceId() == CONSTANT.THU_TUC.PRO_21 || proceduceId() == CONSTANT.THU_TUC.PRO_22) {
                    return true;
                } else {//Thu tuc 23
                    return GROUP_PRO23_LOAIDON.indexOf(self.fiLoaiDon()) >= 0;
                }
            }
        }
    });
    self.fiDongGoi = ko.observable(null).extend({
        maxLength: {message: 'Tối đa 255 ký tự', params: 255},
        required: {
            message: '19' + NSWLang["common_msg_formvaild_required"],
            onlyIf: function () {
                if (proceduceId() == CONSTANT.THU_TUC.PRO_21 || proceduceId() == CONSTANT.THU_TUC.PRO_22) {
                    return true;
                } else {//Thu tuc 23
                    return GROUP_PRO23_LOAIDON.indexOf(self.fiLoaiDon()) >= 0;
                }
            }
        }
    });
    self.fiHoatChat = ko.observable(null).extend({
        maxLength: {message: 'Tối đa 255 ký tự', params: 255},
        required: {
            message: '18' + NSWLang["common_msg_formvaild_required"],
            onlyIf: function () {
                if (proceduceId() == CONSTANT.THU_TUC.PRO_21 || proceduceId() == CONSTANT.THU_TUC.PRO_22) {
                    return true;
                } else {//Thu tuc 23
                    return GROUP_PRO23_LOAIDON.indexOf(self.fiLoaiDon()) >= 0;
                }
            }
        }
    });
    self.fiHamLuong = ko.observable(null).extend({
        maxLength: {message: 'Tối đa 255 ký tự', params: 255},
        required: {
            message: '17' + NSWLang["common_msg_formvaild_required"],
            onlyIf: function () {
                if (proceduceId() == CONSTANT.THU_TUC.PRO_21 || proceduceId() == CONSTANT.THU_TUC.PRO_22) {
                    return true;
                } else {//Thu tuc 23
                    return GROUP_PRO23_LOAIDON.indexOf(self.fiLoaiDon()) >= 0;
                }
            }
        }
    });
    self.fiSoDkLh = ko.observable(null).extend({
        required: {message: '16' + NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiSoGpNkVn = ko.observable(null).extend({
        maxLength: {message: 'Tối đa 255 ký tự', params: 255},
        required: {
            message: '15' + NSWLang["common_msg_formvaild_required"],
            onlyIf: function () {
                return self.fiXuatXu() == 2;
            }
        }
    });
    self.fiNgayGpNkVn = ko.observable(null).extend({
        pattern: '[0-9]{2}/[0-9]{2}/[0-9]{4}',
        required: {
            message: '14' + NSWLang["common_msg_formvaild_required"],
            onlyIf: function () {                
                return self.fiXuatXu() == 2;
            }
        }
    });
    
    //
    self.visibleFiSoGpNkNn = ko.computed(function () {
        if (proceduceId() == CONSTANT.THU_TUC.PRO_23) {
            return true;
        } else if (proceduceId() == CONSTANT.THU_TUC.PRO_21) {
            return self.isSecondGroup();
        }
        return false;
    });
    
    self.fiSoGpNkNn = ko.observable(null).extend({
        maxLength: {message: 'Tối đa 255 ký tự', params: 255},
        required: {
            message: '13' + NSWLang["common_msg_formvaild_required"],
            onlyIf: function () {
                return self.visibleFiSoGpNkNn();
            }
        }
    });
    self.fiNgayGpNkNn = ko.observable(null).extend({
        pattern: '[0-9]{2}/[0-9]{2}/[0-9]{4}',
        required: {
            message: '12' + NSWLang["common_msg_formvaild_required"],
            onlyIf: function () {
                return self.visibleFiSoGpNkNn();
            }
        }
    });
    self.fiNoicapGpNn = ko.observable(null).extend({
        maxLength: {message: 'Tối đa 255 ký tự', params: 255},
        required: {
            message: '11' + NSWLang["common_msg_formvaild_required"],
            onlyIf: function () {
                return self.visibleFiSoGpNkNn();
            }
        }
    });
    self.fiHieulucGpNn = ko.observable(null).extend({
        pattern: '[0-9]{2}/[0-9]{2}/[0-9]{4}',
        required: {
            message: '10' + NSWLang["common_msg_formvaild_required"],
            onlyIf: function () {
                return self.visibleFiSoGpNkNn();
            }
        }
    });
    self.fiMaDvtinh = ko.observable(null).extend({
        required: {message: '9' + NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiTenDvtinh = ko.observable(null);
    self.fiSoLuong = ko.observable(null).extend({
        required: {message: '8' + NSWLang["common_msg_formvaild_required"], params: true},
        number: {message: 'Phải nhập số', params: true},
        maxLength: {message: 'Độ dài tối đa là 10', params: 10}
    });
    self.fiTccl = ko.observable(null).extend({
        maxLength: {message: 'Tối đa 255 ký tự', params: 255},
        required: {
            message: NSWLang["common_msg_formvaild_required"],
            onlyIf: function () {
                return proceduceId() == CONSTANT.THU_TUC.PRO_23 && self.fiLoaiDon() == 2;
            }
        }
    });
    self.fiBoPhanDung = ko.observable(null);
    self.fiTenKhac = ko.observable(null).extend({
        required: {message: '7' + NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiMaQgSx = ko.observable(null).extend({
        required: {message: '6' + NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiTenQgSx = ko.observable(null);
    self.fiTenCoSoSx = ko.observable(null).extend({
        required: {message: '5' + NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiDiachiCssx = ko.observable(null).extend({
        required: {message: '4' + NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });

    self.fiMaQgNk = ko.observable(null).extend({
        required: {message: '3' + NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiTenQgNk = ko.observable(null);
    self.fiTenCoSoNk = ko.observable(null).extend({
        required: {message: '2' + NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiDiachiCsNk = ko.observable(null).extend({
        required: {message: '1' + NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });

    self.fiCosoCppFsc = ko.observable(null);
    self.fiGhiChu = ko.observable(null);

    self.lstNguyenLieus = ko.observableArray([]);
    self.lstDinhKems = ko.observableArray([]);
    self.lstCuaKhaus = ko.observableArray([]).extend({
        minArrayLength: {
            params: {
                minLength: 1,
                objectType: "Cửa khẩu dự định nhập khẩu"
            },
            message: 'Phải chọn ít nhất 1 cửa khẩu.'
        }
    });

    //
    self.visibleNhomThuocTinhThuoc = ko.computed(function () {
        if (proceduceId() == CONSTANT.THU_TUC.PRO_21 || proceduceId() == CONSTANT.THU_TUC.PRO_22) {
            return true;
        } else {//Thu tuc 23
            return GROUP_PRO23_LOAIDON.indexOf(self.fiLoaiDon()) >= 0;
        }
    });

    self.visibleThongTinChungTiengAnh = ko.computed(function () {
        if (proceduceId() == CONSTANT.THU_TUC.PRO_21 || proceduceId() == CONSTANT.THU_TUC.PRO_22) {
            return self.isSecondGroup();
        } else {//Thu tuc 23
            return true;
        }
    });

    self.visibleTenNguyenLieu = ko.computed(function () {
        if (proceduceId() == CONSTANT.THU_TUC.PRO_21 || proceduceId() == CONSTANT.THU_TUC.PRO_22) {
            return false;
        } else {//Thu tuc 23
            return (self.fiLoaiDon() == 2);
        }
    });

    self.visibleTenThuoc = ko.computed(function () {
        if (proceduceId() == CONSTANT.THU_TUC.PRO_21 || proceduceId() == CONSTANT.THU_TUC.PRO_22) {
            return true;
        } else {//Thu tuc 23
            return (self.fiLoaiDon() == 1);
        }
    });

    self.visibleFiSoGpNkVn = ko.computed(function () {
        return (self.fiXuatXu() == 2);
    });    

    self.visibleFiTccl = ko.computed(function () {
        return proceduceId() == CONSTANT.THU_TUC.PRO_23 && self.fiLoaiDon() == 2;
    });
    self.lstGroupDinhKems = ko.observableArray([]);
    //Danh muc
    self.lstXuatXuHangHoa = ko.observableArray(mapCategory(options ? options.lstXuatXuHangHoa : [], 'id', 'name'));
    self.lstCoSoDeNghiCap = ko.observableArray(mapCategory(options ? options.lstCoSoDeNghiCap : [], 'id', 'name'));
    self.lstTinhThanh = ko.observableArray(mapCategory(options ? options.lstTinhThanh : [], 'fiMaTinh', 'fiTenTinh'));
    self.lstDonViTinh = ko.observableArray(mapCategory(options ? options.lstDonViTinh : [], 'fiMaDvtinh', 'fiTenDvtinh'));
    self.ltsNuocSanXuat = ko.observableArray(mapCategory(options ? options.ltsNuocSanXuat : [], 'fiMaQg', 'fiTenQg'));
    self.lstCuaKhauNhap = ko.observableArray(mapCategory(options ? options.lstCuaKhauNhap : [], 'fiMaCuakhau', 'fiTenCuakhau'));
    self.lstLoaiDonHang = ko.observableArray(mapCategory(options ? options.lstLoaiDonHang : [], 'fiMaLoaidon', 'fiTenLoaidon'));
    self.lstNguyenLieu = ko.observableArray(mapCategory(options ? options.lstNguyenLieu : [], 'fiMaNl', 'fiTenNl'));

    var hosoVG = [self.fiTenDn, self.fiChucvuNgDd, self.fiMstDn, self.fiDiachiDn, self.fiMaTinh, self.fiNguoiDd
                , self.lstCuaKhaus, self.fiXuatXu, self.fiSoDkLh, self.fiSoLuong, self.fiTenCoSoSx, self.fiMaQgSx, self.fiDiachiCssx
                , self.fiMaQgNk, self.fiTenCoSoNk, self.fiDiachiCsNk, self.fiTccl, self.fiTenThuoc, self.fiBaoChe
                , self.fiDongGoi, self.fiHoatChat, self.fiHamLuong, self.fiMaHang, self.fiTenDnEn, self.fiDiachiDnEn
                , self.fiSoDkLh, self.fiSoGpNkVn, self.fiSoGpNkNn, self.fiNoicapGpNn
    ];
    // , self.fiNgayGpNkVn, self.fiHieulucGpNn, self.fiNgayGpNkNn

    self.hosoErrors = ko.validation.group(hosoVG, {deep: true, live: true, observable: true});
    self.errorNguyenLieuMessage = ko.observable(null);
    self.errorDinhKemMessage = ko.observable(null);


    //Khoi tao gia tri ho so
    self.init = function (hoso) {
        self.fiIdDn(hoso !== null && hoso.hasOwnProperty('fiIdDn') ? hoso.fiIdDn : null);
        self.fiMstDn(hoso !== null && hoso.hasOwnProperty('fiMstDn') ? hoso.fiMstDn : user.username);
        self.fiTenDn(hoso !== null && hoso.hasOwnProperty('fiTenDn') ? hoso.fiTenDn : user.companyName);
        self.fiDiachiDn(hoso !== null && hoso.hasOwnProperty('fiDiachiDn') ? hoso.fiDiachiDn : user.companyAddress);

        if (hoso !== null) {
            self.fiMaTinh(hoso.doanhNghiep !== null && hoso.doanhNghiep.hasOwnProperty('fiMaTinh') ? hoso.doanhNghiep.fiMaTinh : null);
            self.fiTenTinh(hoso.doanhNghiep !== null && hoso.doanhNghiep.hasOwnProperty('fiTenTinh') ? hoso.doanhNghiep.fiTenTinh : null);
            self.fiNguoiDd(hoso.doanhNghiep !== null && hoso.doanhNghiep.hasOwnProperty('fiNguoiDd') ? hoso.doanhNghiep.fiNguoiDd : null);
            self.fiChucvuNgDd(hoso.doanhNghiep !== null && hoso.doanhNghiep.hasOwnProperty('fiChucvuNgDd') ? hoso.doanhNghiep.fiChucvuNgDd : null);
            self.fiTenDnEn(hoso.doanhNghiep !== null && hoso.doanhNghiep.hasOwnProperty('fiTenDnEn') ? hoso.doanhNghiep.fiTenDnEn : null);
            self.fiDiachiDnEn(hoso.doanhNghiep !== null && hoso.doanhNghiep.hasOwnProperty('fiDiachiDnEn') ? hoso.doanhNghiep.fiDiachiDnEn : null);

            self.fiIdHoso(hoso.hasOwnProperty('fiIdHoso') ? hoso.fiIdHoso : null);
            self.fiMaHoso(hoso.hasOwnProperty('fiMaHoso') ? hoso.fiMaHoso : null);
            self.fiNgaynop(hoso.hasOwnProperty('fiNgaynop') ? new Date(hoso.fiNgaynop) : null);

            self.fiHoatdong(hoso.hasOwnProperty('fiHoatdong') ? hoso.fiHoatdong : 1);
            self.fiNguoitao(hoso.hasOwnProperty('fiNguoitao') ? hoso.fiNguoitao : user.username);
            self.fiNgaytao(hoso.hasOwnProperty('fiNgaytao') ? new Date(hoso.fiNgaytao) : null);
            self.fiNgCapnhat(hoso.hasOwnProperty('fiNgCapnhat') ? hoso.fiNgCapnhat : null);
            self.fiTrangthai(hoso.hasOwnProperty('fiTrangthai') ? hoso.fiTrangthai : 0);
            self.fiTenTt(hoso.hasOwnProperty('fiTenTt') ? hoso.fiTenTt : null);

            self.fiSoCongvan(hoso.hasOwnProperty('fiSoCongvan') ? hoso.fiSoCongvan : null);
            self.fiNgaycapCv(hoso.hasOwnProperty('fiNgaycapCv') ? new Date(hoso.fiNgaycapCv) : null);

            self.fiLoaiDon(hoso.hasOwnProperty('fiLoaiDon') ? hoso.fiLoaiDon : null);
            self.fiMaThutuc(hoso.hasOwnProperty('fiMaThutuc') ? hoso.fiMaThutuc : options.maThuTuc);
            self.fiTenThutuc(hoso.hasOwnProperty('fiTenThutuc') ? hoso.fiTenThutuc : null);
            self.fiMaCuaKhau(hoso.hasOwnProperty('fiMaCuaKhau') ? hoso.fiMaCuaKhau : null);
            self.fiTenCuaKhau(hoso.hasOwnProperty('fiTenCuaKhau') ? hoso.fiTenCuaKhau : null);

            //Don hang
            self.fiIdDonhang(hoso.donHang.hasOwnProperty('fiIdDonhang') ? hoso.donHang.fiIdDonhang : null);
            self.fiXuatXu(hoso.donHang.hasOwnProperty('fiXuatXu') ? hoso.donHang.fiXuatXu : null);
            self.fiMaHang(hoso.donHang.hasOwnProperty('fiMaHang') ? hoso.donHang.fiMaHang : null);
            self.fiTenHang(hoso.donHang.hasOwnProperty('fiTenHang') ? hoso.donHang.fiTenHang : null);
            self.fiBaoChe(hoso.donHang.hasOwnProperty('fiBaoChe') ? hoso.donHang.fiBaoChe : null);
            self.fiHoatChat(hoso.donHang.hasOwnProperty('fiHoatChat') ? hoso.donHang.fiHoatChat : null);
            self.fiHamLuong(hoso.donHang.hasOwnProperty('fiHamLuong') ? hoso.donHang.fiHamLuong : null);
            self.fiDongGoi(hoso.donHang.hasOwnProperty('fiDongGoi') ? hoso.donHang.fiDongGoi : null);

            self.fiSoDkLh(hoso.donHang.hasOwnProperty('fiSoDkLh') ? hoso.donHang.fiSoDkLh : null);
            self.fiSoGpNkVn(hoso.donHang.hasOwnProperty('fiSoGpNkVn') ? hoso.donHang.fiSoGpNkVn : null);
            self.fiNgayGpNkVn(hoso.donHang.hasOwnProperty('fiNgayGpNkVn') ? new Date(hoso.donHang.fiNgayGpNkVn) : null);
            self.fiSoGpNkNn(hoso.donHang.hasOwnProperty('fiSoGpNkNn') ? hoso.donHang.fiSoGpNkNn : null);
            self.fiNgayGpNkNn(hoso.donHang.hasOwnProperty('fiNgayGpNkNn') ? new Date(hoso.donHang.fiNgayGpNkNn) : null);
            self.fiNoicapGpNn(hoso.donHang.hasOwnProperty('fiNoicapGpNn') ? hoso.donHang.fiNoicapGpNn : null);
            self.fiHieulucGpNn(hoso.donHang.hasOwnProperty('fiHieulucGpNn') ? new Date(hoso.donHang.fiHieulucGpNn) : null);
            self.fiMaDvtinh(hoso.donHang.hasOwnProperty('fiMaDvtinh') ? hoso.donHang.fiMaDvtinh : null);
            self.fiTenDvtinh(hoso.donHang.hasOwnProperty('fiTenDvtinh') ? hoso.donHang.fiTenDvtinh : null);
            self.fiSoLuong(hoso.donHang.hasOwnProperty('fiSoLuong') ? hoso.donHang.fiSoLuong : null);
            self.fiTccl(hoso.donHang.hasOwnProperty('fiTccl') ? hoso.donHang.fiTccl : null);
            self.fiBoPhanDung(hoso.donHang.hasOwnProperty('fiBoPhanDung') ? hoso.donHang.fiBoPhanDung : null);
            self.fiTenKhac(hoso.donHang.hasOwnProperty('fiTenKhac') ? hoso.donHang.fiTenKhac : null);

            self.fiMaQgSx(hoso.donHang.hasOwnProperty('fiMaQgSx') ? hoso.donHang.fiMaQgSx : null);
            self.fiTenQgSx(hoso.donHang.hasOwnProperty('fiTenQgSx') ? hoso.donHang.fiTenQgSx : null);
            self.fiTenCoSoSx(hoso.donHang.hasOwnProperty('fiTenCoSoSx') ? hoso.donHang.fiTenCoSoSx : null);
            self.fiDiachiCssx(hoso.donHang.hasOwnProperty('fiDiachiCssx') ? hoso.donHang.fiDiachiCssx : null);

            self.fiMaQgNk(hoso.donHang.hasOwnProperty('fiMaQgNk') ? hoso.donHang.fiMaQgNk : null);
            self.fiTenQgNk(hoso.donHang.hasOwnProperty('fiTenQgNk') ? hoso.donHang.fiTenQgNk : null);
            self.fiTenCoSoNk(hoso.donHang.hasOwnProperty('fiTenCoSoNk') ? hoso.donHang.fiTenCoSoNk : null);
            self.fiDiachiCsNk(hoso.donHang.hasOwnProperty('fiDiachiCsNk') ? hoso.donHang.fiDiachiCsNk : null);

            self.fiCosoCppFsc(hoso.donHang.hasOwnProperty('fiCosoCppFsc') ? hoso.donHang.fiCosoCppFsc : null);
            self.fiGhiChu(hoso.donHang.hasOwnProperty('fiGhiChu') ? hoso.donHang.fiGhiChu : null);

            self.fiTenThuoc(hoso.donHang.hasOwnProperty('fiTenHang') ? hoso.donHang.fiTenHang : null);

            self.lstNguyenLieus(mapTbdhsNglieu19(hoso.donHang.hasOwnProperty('lstNguyenLieus') ? hoso.donHang.lstNguyenLieus : []));
            self.lstDinhKems(mapTbdhsFile19(hoso.hasOwnProperty('lstDinhKems') ? hoso.lstDinhKems : []
                    , self.fiIdHoso()
                    , self));
            self.lstCuaKhaus(mapTbdhsCuaKhau(hoso.hasOwnProperty('lstCuaKhaus') ? hoso.lstCuaKhaus : []));
        } else {
            self.lstDinhKems(mapFilesVM(options.lstDinhKems, self.fiIdHoso(), self));
        }
        self.hosoErrors.showAllMessages(false);
        
        //group file attachment
        var len = self.lstDinhKems().length;
        for (var i = 0; i < len; i++) {
            var item = self.lstDinhKems()[i];
            var idx = arrayFirstIndexOf(self.lstGroupDinhKems(), function(el) {
                return el.fiLoaiTep() === item.fiLoaiTep();    
            });
            
            if (idx < 0) {
                
                if(null !== item.fiDuongDan()) {
                    item.files.push(new UrlItem(item.fiDuongDan()));
                }
                self.lstGroupDinhKems.push(item);                
            } else {
                var exitItem = self.lstGroupDinhKems()[idx];
                if(null !== item.fiDuongDan()) {
                    exitItem.files.push(new UrlItem(item.fiDuongDan()));
                }
            }
        }
    };

    self.init(hosoInfo);
    //VALIDATE DATA ON FORM
    //Remove from toJSON
    self.isValidForm = function () {
        //Kiem tra thong tin Ho so
        var errorHoso = true;
        var errorDinhkem = true;
        var errorNguyenLieu = true;
        
        
        if (self.hosoErrors().length > 0) {
            self.hosoErrors.showAllMessages();
            errorHoso = false;
            return { success: errorHoso , message: null };
        }
        
        if(self.visibleFiSoGpNkVn()){
            if(!self.fiNgayGpNkVn()) {
                errorHoso = false;
                return { success: errorHoso , message: null };
            }
        }
        
        if(self.visibleFiSoGpNkNn()){
            if(!self.fiNgayGpNkNn() || !self.fiHieulucGpNn()) {
                errorHoso = false;
                return { success: errorHoso , message: null };
            }
        }

        if (!self.lstNguyenLieus() || self.lstNguyenLieus().length <= 0) {
            self.errorNguyenLieuMessage('* Chưa khai báo thông tin nguyên liệu');
            errorNguyenLieu = false;
            return { success: errorNguyenLieu , message: null };
        }

        if (self.lstNguyenLieus() && self.lstNguyenLieus().length > 0) {
            for (var i = 0; i < self.lstNguyenLieus().length; i++) {
                var item = self.lstNguyenLieus()[i];
                if (!item.fiLoaiNglieu() || !item.fiMaNglieu() || (!item.fiTongKl() && isNaN(item.fiTongKl()))) {
                    errorNguyenLieu = false;
                    break;
                }
            }
        }

        if (!errorNguyenLieu) {
            self.errorNguyenLieuMessage('* Bổ sung thêm thông tin của nguyên liệu trước khi lưu dữ liệu');
            return { success: errorNguyenLieu , message: null };
        }

        if (self.lstDinhKems() && self.lstDinhKems().length > 0) {
            for (var i = 0; i < self.lstDinhKems().length; i++) {
                var attach = self.lstDinhKems()[i];
                if (attach.isRequire()) {
                    if (!attach.fiTenTep() || !attach.fiDuongDan()) {
                        errorDinhkem = false;
                        break;
                    }
                }
            }
        }

        if (!errorDinhkem) {
            self.errorDinhKemMessage('* Cần bổ sung thêm file đính kèm!');
        }

        return { success: errorHoso && errorNguyenLieu && errorDinhkem , message: null };
    };
    //VALIDATE DATA ON FORM

    //XU LY SU KIEN BUTTON, TABLE
    self.xoaNguyenLieuClick = function (item) {
        if (item) {
            var pop = app.popup({
                title: 'Thông báo',
                html: '<b>Bạn chắc chắn muốn xoá dữ liệu của nguyên liệu này?</b>',
                width: 450,
                buttons: [
                    {
                        name: NSWLang["common_button_toi_chac_chan"],
                        class: 'btn',
                        icon: 'fa-save',
                        action: function () {
                            self.lstNguyenLieus.remove(function (o) {
                                return o.fiIdNglieu() == item.fiIdNglieu();
                            });
                            for (var i = 0; i < self.lstNguyenLieus().length; i++) {
                                self.lstNguyenLieus()[i].fiStt(i + 1);
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
    self.themNguyenLieuClick = function () {
        var item = new TbdhsNglieu19({
            fiStt: self.lstNguyenLieus().length + 1,
            fiIdNglieu: -1 * new Date().getTime()
        });
        self.lstNguyenLieus.push(item);
        for (var i = 0; i < self.lstNguyenLieus().length; i++) {
            self.lstNguyenLieus()[i].fiStt(i + 1);
        }
        $("#fiMaNglieu-" + item.fiStt()).select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
    };

    self.fiMaNglieuChange = function (item) {
        var idx = options.lstNguyenLieu.Search('fiMaNl', item.fiMaNglieu());
        item.fiLoaiNglieu(options.lstNguyenLieu[idx].fiLoaiNl);
        item.fiTenNglieu(options.lstNguyenLieu[idx].fiTenNl);
    };
    //XU LY SU KIEN BUTTON, TABLE

    //Convert to json object
    self.toJSON = function () {
        var exclude = ["xoaNguyenLieuClick", "themNguyenLieuClick", "isValidForm", "init",
            "hosoErrors", "errorNguyenLieuMessage", "errorDinhKemMessage", "lstMucDichNhapKhau", "lstTinhThanh", "lstDonViTinh",
            "toJSON", "ltsNuocSanXuat", "__ko_mapping__", 'lstCuaKhauNhap', 'lstLoaiDonHang', 'lstNguyenLieu',
            'pop', 'lstCuaKhaus', 'fiMaNglieuChange', 'isFirstGroup', 'isSecondGroup', 'fiTenThuoc', 'lstCoSoDeNghiCap',
            'lstXuatXuHangHoa', 'fiThuTucId', 'visibleNhomThuocTinhThuoc', 'visibleThongTinChungTiengAnh',
            'visibleTenNguyenLieu', 'visibleTenThuoc', 'visibleFiSoGpNkVn', 'visibleFiSoGpNkNn', 'visibleFiTccl', 'fiThuTucId'];

        self.fiTenQgSx($('#fiMaQgSx option:selected').text());
        self.fiTenQgNk($('#fiMaQgNk option:selected').text());
        self.fiTenTinh($('#fiMaTinh option:selected').text());
        self.fiTenDvtinh($('#fiMaDvtinh option:selected').text());


        self.fiTenHang(self.fiTenThuoc());
        if (proceduceId() == CONSTANT.THU_TUC.PRO_23 && self.fiLoaiDon() == 2) {
            self.fiTenHang($('#fiMaHang option:selected').text());
        }

        var model = ko.toJS(self);

        var lstCuaKhau = [];
        for (var i = 0; i < model.lstCuaKhaus.length; i++) {
            var idx = model.lstCuaKhauNhap.Search('id', model.lstCuaKhaus[i]);
            if (idx >= 0) {
                lstCuaKhau.push({'fiMaCkhau': model.lstCuaKhaus[i], 'fiTenCkhau': model.lstCuaKhauNhap[idx].name});
            }
        }

        //delete prop not use
        for (var key in model) {
            if (exclude.indexOf(key) >= 0) {
                delete model[key];
            }
        }

        model.lstCuaKhaus = lstCuaKhau;
        
        var dinhKem = [];
        var cloneObject = function (obj) {
            var o = {};
            o.fiDuongDan = null;
            o.fiDuongDanTep = null;
            o.fiGuiid = null;
            o.fiHoatdong = 1;
            o.fiIdDk = obj.fiIdDk;
            o.fiIdHoso = obj.fiIdHoso;
            o.fiLoaiTep = obj.fiLoaiTep;
            o.fiNguoitao = obj.fiNguoitao;
            o.fiTenLoaiTep = obj.fiTenLoaiTep;
            o.fiTenTep = null;
            return o;
        };

        for (var i = 0; i < model.lstGroupDinhKems.length; i++) {
            delete model.lstGroupDinhKems[i]['canUpload'];
            delete model.lstGroupDinhKems[i]['canDownload'];
            delete model.lstGroupDinhKems[i]['canDelete'];
            delete model.lstGroupDinhKems[i]['doUpload'];
            delete model.lstGroupDinhKems[i]['doDelete'];
            delete model.lstGroupDinhKems[i]['downloadUrl'];
            delete model.lstGroupDinhKems[i]['fiBatBuoc'];
            delete model.lstGroupDinhKems[i]['isRequire'];
            delete model.lstGroupDinhKems[i]['__ko_mapping__'];
            var t = model.lstGroupDinhKems[i];
            if (null !== t.files && t.files.length > 0) {
                for (var j = 0; j < t.files.length; j++) {
                    var o = cloneObject(model.lstGroupDinhKems[i]);
                    o.fiTenTep = t.files[j].Url;
                    o.fiDuongDan = t.files[j].Url;
                    o.fiDuongDanTep = t.files[j].Url;

                    dinhKem.push(o);
                }
            } else {
                dinhKem.push(t);
            }
            //delete model.lstDinhKems[i]['files'];
        }

        delete model.lstDinhKems;
        model.lstDinhKems = dinhKem;
        
        model.doanhNghiep = {
            fiIdDn: self.fiIdDn(),
            fiMstDn: self.fiMstDn(),
            fiTenDn: self.fiTenDn(),
            fiMaTinh: self.fiMaTinh(),
            fiTenTinh: self.fiTenTinh(),
            fiDiachiDn: self.fiDiachiDn(),
            fiNguoiDd: self.fiNguoiDd(),
            fiChucvuNgDd: self.fiChucvuNgDd(),
            fiTenDnEn: self.fiTenDnEn(),
            fiDiachiDnEn: self.fiDiachiDnEn()
        };

        for (var i = 0; i < model.lstNguyenLieus.length; i++) {
            delete model.lstNguyenLieus[i]['fiStt'];
        }

        model.donHang = {
            fiIdDonhang: self.fiIdDonhang(),
            fiXuatXu: self.fiXuatXu(),
            fiMaHang: self.fiMaHang(),
            fiTenHang: self.fiTenHang(),
            fiBaoChe: self.fiBaoChe(),
            fiHoatChat: self.fiHoatChat(),
            fiHamLuong: self.fiHamLuong(),
            fiDongGoi: self.fiDongGoi(),
            fiSoDkLh: self.fiSoDkLh(),
            fiSoGpNkVn: self.fiSoGpNkVn(),
            fiNgayGpNkVn: self.fiNgayGpNkVn(),
            fiSoGpNkNn: self.fiSoGpNkNn(),
            fiNgayGpNkNn: self.fiNgayGpNkNn(),
            fiNoicapGpNn: self.fiNoicapGpNn(),
            fiHieulucGpNn: self.fiHieulucGpNn(),
            fiMaDvtinh: self.fiMaDvtinh(),
            fiTenDvtinh: self.fiTenDvtinh(),
            fiSoLuong: self.fiSoLuong(),
            fiTccl: self.fiTccl(),
            fiBoPhanDung: self.fiBoPhanDung(),
            fiTenKhac: self.fiTenKhac(),
            fiMaQgSx: self.fiMaQgSx(),
            fiTenQgSx: self.fiTenQgSx(),
            fiTenCoSoSx: self.fiTenCoSoSx(),
            fiDiachiCssx: self.fiDiachiCssx(),
            fiMaQgNk: self.fiMaQgNk(),
            fiTenQgNk: self.fiTenQgNk(),
            fiTenCoSoNk: self.fiTenCoSoNk(),
            fiDiachiCsNk: self.fiDiachiCsNk(),
            fiCosoCppFsc: self.fiCosoCppFsc(),
            fiGhiChu: self.fiGhiChu(),
            lstNguyenLieus: model.lstNguyenLieus
        };

        var _exclude = ['fiIdDonhang', 'fiXuatXu', 'fiMaHang',
            'fiTenHang', 'fiBaoChe', 'fiHoatChat', 'fiHamLuong',
            'fiDongGoi', 'fiSoDkLh', 'fiSoGpNkVn', 'fiNgayGpNkVn',
            'fiSoGpNkNn', 'fiNgayGpNkNn', 'fiNoicapGpNn', 'fiHieulucGpNn',
            'fiMaDvtinh', 'fiTenDvtinh', 'fiSoLuong', 'fiTccl',
            'fiBoPhanDung', 'fiTenKhac', 'fiMaQgSx', 'fiTenQgSx',
            'fiTenCoSoSx', 'fiDiachiCssx', 'fiMaQgNk', 'fiTenQgNk',
            'fiTenCoSoNk', 'fiDiachiCsNk', 'fiCosoCppFsc', 'fiGhiChu', 'lstNguyenLieus',
        'fiTenDnEn','fiDiachiDnEn', 'lstGroupDinhKems'];
        for (var key in model) {
            if (_exclude.indexOf(key) >= 0) {
                delete model[key];
            }
        }
        
        return model;
    };

    self.lstCuaKhaus.subscribe(function (newValue) {
        //console.log(newValue);
    });
}

