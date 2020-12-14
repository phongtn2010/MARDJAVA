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

    //Thong tin chung
    self.fiIdHoso = ko.observable(null);
    self.fiMaHoso = ko.observable(null);
    self.fiNgaynop = ko.observable(null);
    self.fiMaLoaidon = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiTenLoaidon = ko.observable(null);

    self.isFirstGroup = ko.computed(function () {
        return null != self.fiMaLoaidon() && [1, 2, 3, 4, 5, 6].indexOf(self.fiMaLoaidon()) >= 0;
    }, self);

    self.isSecondGroup = ko.computed(function () {
        return null != self.fiMaLoaidon() && [7, 8, 9].indexOf(self.fiMaLoaidon()) >= 0;
    }, self);

    self.fiMucDichNk = ko.observable(null).extend({
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });


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
    self.fiTenCkhauEn = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 2000 ký tự', params: 2000}
    });

    //doanhNghiep
    self.fiIdDn = ko.observable(null);
    self.fiMstDn = ko.observable(null);
    self.fiTenDn = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiTenDnEn = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiMaTinh = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiTenTinh = ko.observable(null);
    self.fiDiachiDn = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiDiachiDnEn = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiNguoiDd = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiChucvuNgDd = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });

    //Don hang
    self.fiIdDonhang = ko.observable(null);
    self.fiTenHang = ko.observable(null).extend({
        required: {
            message: NSWLang["common_msg_formvaild_required"],
            onlyIf: function () {
                return self.isFirstGroup();
            }
        },
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiBaoChe = ko.observable(null).extend({
        maxLength: {message: 'Tối đa 255 ký tự', params: 255},
        required: {
            message: NSWLang["common_msg_formvaild_required"],
            onlyIf: function () {
                return self.isFirstGroup();
            }
        }
    });
    self.fiBaoCheEn = ko.observable(null).extend({
        maxLength: {message: 'Tối đa 255 ký tự', params: 255},
        required: {
            message: NSWLang["common_msg_formvaild_required"],
            onlyIf: function () {
                return self.isFirstGroup();
            }
        }
    });
    self.fiDongGoi = ko.observable(null).extend({
        maxLength: {message: 'Tối đa 1000 ký tự', params: 1000},
        required: {
            message: NSWLang["common_msg_formvaild_required"],
            onlyIf: function () {
                return self.isFirstGroup();
            }
        }
    });
    self.fiDongGoiEn = ko.observable(null).extend({
        maxLength: {message: 'Tối đa 1000 ký tự', params: 1000},
        required: {
            message: NSWLang["common_msg_formvaild_required"],
            onlyIf: function () {
                return self.isFirstGroup();
            }
        }
    });
    self.fiHoatChat = ko.observable(null).extend({
        maxLength: {message: 'Tối đa 1000 ký tự', params: 1000},
        required: {
            message: NSWLang["common_msg_formvaild_required"],
            onlyIf: function () {
                return self.isFirstGroup();
            }
        }
    });
    self.fiHamLuong = ko.observable(null).extend({
        maxLength: {message: 'Tối đa 255 ký tự', params: 255},
        required: {
            message: NSWLang["common_msg_formvaild_required"],
            onlyIf: function () {
                return self.isFirstGroup();
            }
        }
    });
    self.fiMaNglieu = ko.observable(null).extend({
        maxLength: {message: 'Tối đa 255 ký tự', params: 255},
        required: {
            message: NSWLang["common_msg_formvaild_required"],
            onlyIf: function () {
                return self.isSecondGroup();
            }
        }
    });
    self.fiTenNglieu = ko.observable(null);
    self.fiTenNglieuNsx = ko.observable(null).extend({
        required: {
            message: NSWLang["common_msg_formvaild_required"],
            onlyIf: function () {
                return self.isSecondGroup();
            }
        },
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });

    self.fiSoDkLh = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiMaDvtinh = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiTenDvtinh = ko.observable(null);
    self.fiTenDvtinhEn = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiSoLuong = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        number: {message: 'Chỉ được nhập số, giá trị tối đa 5 số ở phần thập nhập', params: true},
        pattern: {
            message: 'Phải nhập giá trị với tối đa 5 số ở phần thập phân ví dụ: 1.12345',
            params: '^[0-9]{0,15}(?:\.[0-9]{0,5})?$'
        }
    });
    self.fiTccl = ko.observable(null).extend({
        required: {
            message: NSWLang["common_msg_formvaild_required"],
            onlyIf: function () {
                return self.isSecondGroup();
            }
        },
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiTcclEn = ko.observable(null).extend({
        required: {
            message: NSWLang["common_msg_formvaild_required"],
            onlyIf: function () {
                return self.isSecondGroup();
            }
        },
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiTenCoSoSx = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 500 ký tự', params: 500}
    });
    self.fiTenCoSoSxEn = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 500 ký tự', params: 500}
    });
    self.fiDiachiCssx = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 1000 ký tự', params: 1000}
    });
    self.fiDiachiCssxEn = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 1000 ký tự', params: 1000}
    });
    self.fiMaQgSx = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiTenQgSx = ko.observable(null);
    self.fiTenQgSxEn = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiTenCoSoNk = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 500 ký tự', params: 500}
    });
    self.fiTenCoSoNkEn = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 500 ký tự', params: 500}
    });
    self.fiDiachiCsNk = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiDiachiCsNkEn = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiMaQgNk = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiTenQgNk = ko.observable(null);
    self.fiTenQgNkEn = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });

    //End don hang

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
    self.lstGroupDinhKems = ko.observableArray([]);

    //Danh muc
    self.lstTinhThanh = ko.observableArray(mapCategory(options ? options.lstTinhThanh : [], 'fiMaTinh', 'fiTenTinh'));
    self.lstDonViTinh = ko.observableArray(mapCategory(options ? options.lstDonViTinh : [], 'fiMaDvtinh', 'fiTenDvtinh'));
    self.ltsNuocSanXuat = ko.observableArray(mapCategory(options ? options.ltsNuocSanXuat : [], 'fiMaQg', 'fiTenQg'));
    self.lstCuaKhauNhap = ko.observableArray(mapCategory(options ? options.lstCuaKhauNhap : [], 'fiMaCuakhau', 'fiTenCuakhau'));
    self.lstLoaiDonHang = ko.observableArray(mapCategory(options ? options.lstLoaiDonHang : [], 'fiMaLoaidon', 'fiTenLoaidon'));
    self.lstNguyenLieu = ko.observableArray(mapCategory(options ? options.lstNguyenLieu : [], 'fiMaNl', 'fiTenNl'));
    self.lstMucDichNhapKhau = ko.observableArray(mapCategory(options ? options.lstMucDichNhapKhau : [], 'fiMaMdnk', 'fiTenMdnk'));

    var hosoVG = [self.fiMaLoaidon, self.fiMucDichNk, self.fiMaCuaKhau, self.fiTenCkhauEn, self.fiMstDn, self.fiTenDnEn
                , self.lstCuaKhaus, self.fiMaTinh, self.fiDiachiDn, self.fiDiachiDnEn, self.fiNguoiDd, self.fiChucvuNgDd
                , self.fiTenHang, self.fiBaoChe, self.fiBaoCheEn, self.fiDongGoi
                , self.fiDongGoiEn, self.fiHoatChat, self.fiHamLuong, self.fiMaNglieu, self.fiTenNglieuNsx,
                , self.fiSoDkLh, self.fiMaDvtinh, self.fiTenDvtinhEn, self.fiSoLuong
                , self.fiTccl, self.fiTcclEn, self.fiTenCoSoSx, self.fiTenCoSoSxEn
                , self.fiDiachiCssx, self.fiDiachiCssxEn, self.fiMaQgSx, self.fiTenQgSxEn
                , self.fiTenCoSoNk, self.fiTenCoSoNkEn, self.fiDiachiCsNk, self.fiDiachiCsNkEn
                , self.fiMaQgNk, self.fiTenQgNkEn];

    self.hosoErrors = ko.validation.group(hosoVG, {deep: true, live: true, observable: true});
    self.errorNguyenLieuMessage = ko.observable(null);
    self.errorDinhKemMessage = ko.observable(null);


    //Khoi tao gia tri ho so
    self.init = function (hoso) {
        self.fiIdDn(hoso !== null && hoso.hasOwnProperty('fiIdDn') ? hoso.fiIdDn : null);
        self.fiMstDn(hoso !== null && hoso.hasOwnProperty('fiMstDn') ? hoso.fiMstDn : user.username);
        self.fiTenDn(hoso !== null && hoso.hasOwnProperty('fiTenDn') ? hoso.fiTenDn : user.companyName);
        self.fiTenDnEn(hoso !== null && hoso.hasOwnProperty('fiTenDnEn') ? hoso.fiTenDnEn : user.companyName);
        self.fiDiachiDn(hoso !== null && hoso.hasOwnProperty('fiDiachiDn') ? hoso.fiDiachiDn : user.companyAddress);
        self.fiDiachiDnEn(hoso !== null && hoso.hasOwnProperty('fiDiachiDnEn') ? hoso.fiDiachiDnEn : user.companyAddress);
        self.fiNguoitao(hoso !== null && hoso.hasOwnProperty('fiNguoitao') ? hoso.fiNguoitao : user.username);
        self.fiNguoiDd(user.hasOwnProperty('representerName') ? user.representerName : '');

        if (hoso !== null) {
            self.fiMaTinh(hoso.doanhNghiep !== null && hoso.doanhNghiep.hasOwnProperty('fiMaTinh') ? hoso.doanhNghiep.fiMaTinh : null);
            self.fiTenTinh(hoso.doanhNghiep !== null && hoso.doanhNghiep.hasOwnProperty('fiTenTinh') ? hoso.doanhNghiep.fiTenTinh : null);
            self.fiNguoiDd(hoso.doanhNghiep !== null && hoso.doanhNghiep.hasOwnProperty('fiNguoiDd') ? hoso.doanhNghiep.fiNguoiDd : null);
            self.fiChucvuNgDd(hoso.doanhNghiep !== null && hoso.doanhNghiep.hasOwnProperty('fiChucvuNgDd') ? hoso.doanhNghiep.fiChucvuNgDd : null);

            self.fiIdHoso(hoso.hasOwnProperty('fiIdHoso') ? hoso.fiIdHoso : null);
            self.fiMaHoso(hoso.hasOwnProperty('fiMaHoso') ? hoso.fiMaHoso : null);
            self.fiNgaynop(hoso.hasOwnProperty('fiNgaynop') ? new Date(hoso.fiNgaynop) : null);
            self.fiMaLoaidon(hoso.hasOwnProperty('fiMaLoaidon') ? hoso.fiMaLoaidon : null);
            self.fiTenLoaidon(hoso.hasOwnProperty('fiTenLoaidon') ? hoso.fiTenLoaidon : null);
            self.fiMucDichNk(hoso.hasOwnProperty('fiMucDichNk') ? hoso.fiMucDichNk : null);

            self.fiHoatdong(hoso.hasOwnProperty('fiHoatdong') ? hoso.fiHoatdong : 1);
            self.fiNguoitao(hoso.hasOwnProperty('fiNguoitao') ? hoso.fiNguoitao : null);
            self.fiNgaytao(hoso.hasOwnProperty('fiNgaytao') ? new Date(hoso.fiNgaytao) : null);
            self.fiNgCapnhat(hoso.hasOwnProperty('fiNgCapnhat') ? hoso.fiNgCapnhat : null);
            self.fiTrangthai(hoso.hasOwnProperty('fiTrangthai') ? hoso.fiTrangthai : 0);
            self.fiTenTt(hoso.hasOwnProperty('fiTenTt') ? hoso.fiTenTt : null);

            self.fiSoCongvan(hoso.hasOwnProperty('fiSoCongvan') ? hoso.fiSoCongvan : null);
            self.fiNgaycapCv(hoso.hasOwnProperty('fiNgaycapCv') ? new Date(hoso.fiNgaycapCv) : null);
            self.fiMaThutuc(hoso.hasOwnProperty('fiMaThutuc') ? hoso.fiMaThutuc : options.maThuTuc);
            self.fiTenThutuc(hoso.hasOwnProperty('fiTenThutuc') ? hoso.fiTenThutuc : null);

            //Don hang
            self.fiIdDonhang(hoso.donHang.hasOwnProperty('fiIdDonhang') ? hoso.donHang.fiIdDonhang : null);
            self.fiTenHang(hoso.donHang.hasOwnProperty('fiTenHang') ? hoso.donHang.fiTenHang : null);
            self.fiBaoChe(hoso.donHang.hasOwnProperty('fiBaoChe') ? hoso.donHang.fiBaoChe : null);
            self.fiBaoCheEn(hoso.donHang.hasOwnProperty('fiBaoCheEn') ? hoso.donHang.fiBaoCheEn : null);
            self.fiDongGoi(hoso.donHang.hasOwnProperty('fiDongGoi') ? hoso.donHang.fiDongGoi : null);
            self.fiDongGoiEn(hoso.donHang.hasOwnProperty('fiDongGoiEn') ? hoso.donHang.fiDongGoiEn : null);
            self.fiHoatChat(hoso.donHang.hasOwnProperty('fiHoatChat') ? hoso.donHang.fiHoatChat : null);
            self.fiHamLuong(hoso.donHang.hasOwnProperty('fiHamLuong') ? hoso.donHang.fiHamLuong : null);

            self.fiMaNglieu(hoso.donHang.hasOwnProperty('fiMaNglieu') ? hoso.donHang.fiMaNglieu : null);
            self.fiTenNglieu(hoso.donHang.hasOwnProperty('fiTenNglieu') ? hoso.donHang.fiTenNglieu : null);
            self.fiTenNglieuNsx(hoso.donHang.hasOwnProperty('fiTenNglieuNsx') ? hoso.donHang.fiTenNglieuNsx : null);
            self.fiSoDkLh(hoso.donHang.hasOwnProperty('fiSoDkLh') ? hoso.donHang.fiSoDkLh : null);
            self.fiMaDvtinh(hoso.donHang.hasOwnProperty('fiMaDvtinh') ? hoso.donHang.fiMaDvtinh : null);
            self.fiTenDvtinh(hoso.donHang.hasOwnProperty('fiTenDvtinh') ? hoso.donHang.fiTenDvtinh : null);
            self.fiTenDvtinhEn(hoso.donHang.hasOwnProperty('fiTenDvtinh') ? hoso.donHang.fiTenDvtinh : null);
            self.fiSoLuong(hoso.donHang.hasOwnProperty('fiSoLuong') ? hoso.donHang.fiSoLuong : null);
            self.fiTccl(hoso.donHang.hasOwnProperty('fiTccl') ? hoso.donHang.fiTccl : null);
            self.fiTcclEn(hoso.donHang.hasOwnProperty('fiTcclEn') ? hoso.donHang.fiTcclEn : null);

            self.fiTenCoSoSx(hoso.donHang.hasOwnProperty('fiTenCoSoSx') ? hoso.donHang.fiTenCoSoSx : null);
            self.fiTenCoSoSxEn(hoso.donHang.hasOwnProperty('fiTenCoSoSxEn') ? hoso.donHang.fiTenCoSoSxEn : null);
            self.fiDiachiCssx(hoso.donHang.hasOwnProperty('fiDiachiCssx') ? hoso.donHang.fiDiachiCssx : null);
            self.fiDiachiCssxEn(hoso.donHang.hasOwnProperty('fiDiachiCssxEn') ? hoso.donHang.fiDiachiCssxEn : null);
            self.fiMaQgSx(hoso.donHang.hasOwnProperty('fiMaQgSx') ? hoso.donHang.fiMaQgSx : null);
            self.fiTenQgSx(hoso.donHang.hasOwnProperty('fiTenQgSx') ? hoso.donHang.fiTenQgSx : null);
            self.fiTenQgSxEn(hoso.donHang.hasOwnProperty('fiTenQgSxEn') ? hoso.donHang.fiTenQgSxEn : null);

            self.fiTenCoSoNk(hoso.donHang.hasOwnProperty('fiTenCoSoNk') ? hoso.donHang.fiTenCoSoNk : null);
            self.fiTenCoSoNkEn(hoso.donHang.hasOwnProperty('fiTenCoSoNk') ? hoso.donHang.fiTenCoSoNk : null);
            self.fiDiachiCsNk(hoso.donHang.hasOwnProperty('fiDiachiCsNk') ? hoso.donHang.fiDiachiCsNk : null);
            self.fiDiachiCsNkEn(hoso.donHang.hasOwnProperty('fiDiachiCsNkEn') ? hoso.donHang.fiDiachiCsNkEn : null);
            self.fiMaQgNk(hoso.donHang.hasOwnProperty('fiMaQgNk') ? hoso.donHang.fiMaQgNk : null);
            self.fiTenQgNk(hoso.donHang.hasOwnProperty('fiTenQgNk') ? hoso.donHang.fiTenQgNk : null);
            self.fiTenQgNkEn(hoso.donHang.hasOwnProperty('fiTenQgNkEn') ? hoso.donHang.fiTenQgNkEn : null);

            self.fiMaCuaKhau(hoso.donHang.hasOwnProperty('fiMaCuaKhau') ? hoso.donHang.fiMaCuaKhau : null);
            self.fiTenCuaKhau(hoso.donHang.hasOwnProperty('fiTenCuaKhau') ? hoso.donHang.fiTenCuaKhau : null);
            self.fiTenCkhauEn(hoso.donHang.hasOwnProperty('fiTenCkhauEn') ? hoso.donHang.fiTenCkhauEn : null);

            self.lstNguyenLieus(mapTbdhsNglieu18(hoso.donHang.hasOwnProperty('lstNguyenLieus') ? hoso.donHang.lstNguyenLieus : []));
            self.lstDinhKems(mapTbdhsFile18(hoso.hasOwnProperty('lstDinhKems') ? hoso.lstDinhKems : []
                    , self.fiIdHoso()
                    , self));
            self.lstCuaKhaus(mapTbdhsCuaKhau(hoso.donHang.hasOwnProperty('lstCuaKhaus') ? hoso.donHang.lstCuaKhaus : []));

        } else {
            self.lstDinhKems(mapFilesVM(options.lstDinhKems, self.fiIdHoso(), self));
        }
        self.hosoErrors.showAllMessages(false);

        //group file attachment
        var len = self.lstDinhKems().length;
        for (var i = 0; i < len; i++) {
            var item = self.lstDinhKems()[i];
            var idx = arrayFirstIndexOf(self.lstGroupDinhKems(), function (el) {
                return el.fiLoaiTep() === item.fiLoaiTep();
            });

            if (idx < 0) {

                if (null !== item.fiDuongDan()) {
                    item.files.push(new UrlItem(item.fiDuongDan()));
                }
                self.lstGroupDinhKems.push(item);
            } else {
                var exitItem = self.lstGroupDinhKems()[idx];
                if (null !== item.fiDuongDan()) {
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
            return {success: errorHoso, message: 'Bạn phải nhập vào các thông tin bắt buộc (*)'};
        }

        if (self.isFirstGroup()) {
            if (!self.lstNguyenLieus() || self.lstNguyenLieus().length <= 0) {
                //self.errorNguyenLieuMessage('* Chưa khai báo thông tin nguyên liệu');
                errorHoso = false;
                return {success: errorHoso, message: 'Chưa khai báo thông tin nguyên liệu'};
            }

            if (self.lstNguyenLieus() && self.lstNguyenLieus().length > 0) {
                for (var i = 0; i < self.lstNguyenLieus().length; i++) {
                    var item = self.lstNguyenLieus()[i];
                    if (!item.fiTongKl() || !item.fiMaNglieu() || !item.fiTenNglieuNsx()) {
                        errorNguyenLieu = false;
                        break;
                    }
                }
            }

            if (!errorNguyenLieu) {
                errorHoso = false;
                //self.errorNguyenLieuMessage('Bổ sung thêm thông tin của nguyên liệu trước khi lưu dữ liệu');
                return {success: errorHoso, message: 'Bổ sung thêm thông tin của nguyên liệu trước khi lưu dữ liệu'};
            }
        } else {
            errorNguyenLieu = true;
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
            return {success: errorDinhkem, message: 'Thông tin file đính kèm chưa được cung cấp.'};
            //self.errorDinhKemMessage('* Cần bổ sung thêm file đính kèm!');
        }

        return {success: errorHoso && errorNguyenLieu && errorDinhkem, message: null};
    }
    ;
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
        var item = new TbdhsNglieu18({
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
        //item.fiLoaiNglieu(options.lstNguyenLieu[idx].fiLoaiNl);
        item.fiTenNglieu(options.lstNguyenLieu[idx].fiTenNl);
        
    };
//XU LY SU KIEN BUTTON, TABLE    
//Convert to json object
    self.toJSON = function () {
        var exclude = ["xoaNguyenLieuClick", "themNguyenLieuClick",
            "isValidForm", "init",
            "hosoErrors", "errorNguyenLieuMessage", "errorDinhKemMessage",
            "lstMucDichNhapKhau", "lstTinhThanh", "lstDonViTinh",
            "toJSON", "ltsNuocSanXuat", "__ko_mapping__", 'lstCuaKhauNhap',
            'lstLoaiDonHang', 'lstNguyenLieu',
            'pop', 'lstCuaKhaus', 'fiMaNglieuChange', 'isFirstGroup',
            'isSecondGroup'];

        self.fiTenQgSx($('#fiMaQgSx option:selected').text());
        self.fiTenQgNk($('#fiMaQgNk option:selected').text());
        self.fiTenTinh($('#fiMaTinh option:selected').text());
        self.fiTenDvtinh($('#fiMaDvtinh option:selected').text());
        self.fiTenLoaidon($('#fiMaLoaidon option:selected').text());
        self.fiTenNglieu($('#fiMaNglieu option:selected').text());
        
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
            fiMstDn: self.fiMstDn().trim(),
            fiTenDn: self.fiTenDn().trim(),
            fiTenDnEn: self.fiTenDnEn().trim(),
            fiMaTinh: self.fiMaTinh().trim(),
            fiTenTinh: self.fiTenTinh().trim(),
            fiDiachiDn: self.fiDiachiDn().trim(),
            fiDiachiDnEn: self.fiDiachiDnEn().trim(),
            fiNguoiDd: self.fiNguoiDd().trim(),
            fiChucvuNgDd: self.fiChucvuNgDd().trim()
        };

        for (var i = 0; i < model.lstNguyenLieus.length; i++) {
            delete model.lstNguyenLieus[i]['fiStt'];
        }

        model.donHang = {
            fiIdDonhang: self.fiIdDonhang(),
            fiTenHang: null != self.fiTenHang() ? self.fiTenHang().trim() : null,
            fiBaoChe: null != self.fiBaoChe() ? self.fiBaoChe().trim() : null,
            fiBaoCheEn: null != self.fiBaoCheEn() ? self.fiBaoCheEn().trim() : null,
            fiDongGoi: null != self.fiDongGoi() ? self.fiDongGoi().trim() : null,
            fiDongGoiEn: null != self.fiDongGoiEn() ? self.fiDongGoiEn().trim() : null,
            fiHoatChat: null != self.fiHoatChat() ? self.fiHoatChat().trim() : null,
            fiHamLuong: null != self.fiHamLuong() ? self.fiHamLuong().trim() : null,
            fiMaNglieu: null != self.fiMaNglieu() ? self.fiMaNglieu().trim() : null,
            fiTenNglieu: null != self.fiTenNglieu() ? self.fiTenNglieu().trim() : null,
            fiSoDkLh: null != self.fiSoDkLh() ? self.fiSoDkLh().trim() : null,
            fiMaDvtinh: null != self.fiMaDvtinh() ? self.fiMaDvtinh().trim() : null,
            fiTenDvtinh: null != self.fiTenDvtinh() ? self.fiTenDvtinh().trim() : null,
            fiTenDvtinhEn: null != self.fiTenDvtinhEn() ? self.fiTenDvtinhEn().trim() : null,
            fiSoLuong: null != self.fiSoLuong() ? self.fiSoLuong() : null,
            fiTccl: null != self.fiTccl() ? self.fiTccl().trim() : null,
            fiTcclEn: null != self.fiTcclEn() ? self.fiTcclEn().trim() : null,
            fiTenCoSoSx: null != self.fiTenCoSoSx() ? self.fiTenCoSoSx().trim() : null,
            fiTenCoSoSxEn: null != self.fiTenCoSoSxEn() ? self.fiTenCoSoSxEn().trim() : null,
            fiDiachiCssx: null != self.fiDiachiCssx() ? self.fiDiachiCssx().trim() : null,
            fiDiachiCssxEn: null != self.fiDiachiCssxEn() ? self.fiDiachiCssxEn().trim() : null,
            fiMaQgSx: null != self.fiMaQgSx() ? self.fiMaQgSx().trim() : null,
            fiTenQgSx: null != self.fiTenQgSx() ? self.fiTenQgSx().trim() : null,
            fiTenQgSxEn: null != self.fiTenQgSxEn() ? self.fiTenQgSxEn().trim() : null,
            fiTenCoSoNk: null != self.fiTenCoSoNk() ? self.fiTenCoSoNk().trim() : null,
            fiTenCoSoNkEn: null != self.fiTenCoSoNkEn() ? self.fiTenCoSoNkEn().trim() : null,
            fiDiachiCsNk: null != self.fiDiachiCsNk() ? self.fiDiachiCsNk().trim() : null,
            fiDiachiCsNkEn: null != self.fiDiachiCsNkEn() ? self.fiDiachiCsNkEn().trim() : null,
            fiMaQgNk: null != self.fiMaQgNk() ? self.fiMaQgNk().trim() : null,
            fiTenQgNk: null != self.fiTenQgNk() ? self.fiTenQgNk().trim() : null,
            fiTenQgNkEn: null != self.fiTenQgNkEn() ? self.fiTenQgNkEn().trim() : null,
            fiTenCkhauEn: null != self.fiTenCkhauEn() ? self.fiTenCkhauEn().trim() : null,
            lstNguyenLieus: model.lstNguyenLieus,
            lstCuaKhaus: model.lstCuaKhaus,
            fiTenNglieuNsx: self.fiTenNglieuNsx
        };

        var _exclude = ['fiIdDonhang', 'fiMaCuaKhau', 'fiTenCuaKhau',
            'fiTenHang', 'fiBaoChe', 'fiBaoCheEn',
            'fiDongGoi', 'fiDongGoiEn', 'fiHoatChat', 'fiHamLuong',
            'fiMaNglieu', 'fiTenNglieu', 'fiSoDkLh',
            'fiMaDvtinh', 'fiTenDvtinh', 'fiSoLuong', 'fiTccl', 'fiTcclEn',
            'fiTenCoSoSx', 'fiTenCoSoSxEn', 'fiDiachiCssx', 'fiDiachiCssxEn',
            'fiMaQgSx', 'fiTenQgSx', 'fiTenQgSxEn', 'fiTenCoSoNk',
            'fiTenCoSoNkEn', 'fiTenCoSoNkEn', 'fiDiachiCsNk', 'fiDiachiCsNkEn',
            'fiMaQgNk', 'fiTenQgNk', 'fiTenQgNkEn',
            'fiIdDn', 'fiMstDn', 'fiTenDn', 'fiTenDnEn', 'fiMaTinh', 'fiTenTinh',
            'fiDiachiDn', 'fiDiachiDnEn', 'fiNguoiDd', 'fiChucvuNgDd', 'fiTenHang', 'fiTenDvtinhEn',
            'lstNguyenLieus', 'lstGroupDinhKems', 'lstCuaKhaus'];
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

