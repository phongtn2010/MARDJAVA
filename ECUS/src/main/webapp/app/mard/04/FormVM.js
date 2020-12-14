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
    self.fiMaTrangthai = ko.observable(null);
    self.fiTenTrangthai = ko.observable(null);
    self.fiNgaygui = ko.observable(null);
    self.fiNgayCapphep = ko.observable(null);
    self.fiNgaytao = ko.observable(null);
    self.fiNguoitao = ko.observable(null);
    self.fiHoatdong = ko.observable(null);
    self.fiCheckXnd = ko.observable(null);
    self.fiMaTrangthaiphi = ko.observable(null);
    self.fiTenTrangthaiphi = ko.observable(null);

    self.fiMaLoaidon = ko.observable(null);
    self.fiTenLoaidon = ko.observable(null);
    self.fiMaCqxl = ko.observable(null);
    self.fiTenCqxl = ko.observable(null);
    self.fiSoXnDk = ko.observable(null);
    self.fiTenTochuc = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiDiachiTochuc = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 1000 ký tự', params: 1000}
    });
    self.fiSdtTochuc = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 50 ký tự', params: 50}
    });
    self.fiFaxEmail = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiMst = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiCmnd = ko.observable(null);
    self.fiNgaycapCmnd = ko.observable(null);
    self.fiNoicapCmnd = ko.observable(null);
    self.fiSoHopdong = ko.observable(null);
    self.fiTochucXk = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiDiachiXk = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 1000 ký tự', params: 1000}
    });
    self.fiManuocXk = ko.observable(null);
    self.fiTennuocXk = ko.observable(null);
    self.fiMaCuakhauXuat = ko.observable(null);
    self.fiTenCuakhauXuat = ko.observable(null);
    self.fiTochucNhap = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiDiachiNhap = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 1000 ký tự', params: 1000}
    });
    self.fiMaCuakhauNhap = ko.observable(null);
    self.fiTenCuakhauNhap = ko.observable(null);
    self.fiMaPhuongtien = ko.observable(null);
    self.fiTenPhuongtien = ko.observable(null);
    self.fiTenPhuongtienKhac = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiMucdichSd = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiGiayphepKd = ko.observable(null);
    self.fiDiadiemKd = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 1000 ký tự', params: 1000}
    });
    self.fiThoigianKd = ko.observable(null);
    self.fiSoGcn = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiNoihangDen = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 1000 ký tự', params: 1000}
    });
    self.fiNoiky = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiNgayky = ko.observable(null);
    self.fiNguoiky = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiChucvu = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });

    self.fiMaLoaiThucan = ko.observable(null);
    self.fiTenLoaiThucan = ko.observable(null);
    self.fiMaLoaiKiemtra = ko.observable(null);
    self.fiTenLoaiKiemtra = ko.observable(null);
    self.fiSoTbMiengiam = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiSoDkTochuc = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 50 ký tự', params: 50}
    });
    self.fiHang = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiDiachiBenban = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiSdtBenban = ko.observable(null);
    self.fiFaxBenban = ko.observable(null);
    self.fiNoiXuathang = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiBenMuahang = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiCmndBenmua = ko.observable(null);
    self.fiNgaycapCmndBenmua = ko.observable(null);
    self.fiNoicapCmndBenmua = ko.observable(null);
    self.fiDiachiBenmua = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 1000 ký tự', params: 1000}
    });
    self.fiSdtBenmua = ko.observable(null);
    self.fiFaxBenmua = ko.observable(null);
    self.fiMacangNoinhan = ko.observable(null);
    self.fiTencangNoinhan = ko.observable(null);
    self.fiThoigianNhaptu = ko.observable(null);
    self.fiThoigianNhapden = ko.observable(null);
    self.fiDiadiemTapket = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiNgayDangkyTu = ko.observable(null);
    self.fiNgayDangkyDen = ko.observable(null);
    self.fiDiadiemLaymau = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiNguoiLienhe = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });

    self.fiSdtTochucNhap = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiTochucNhapTrachnhiem = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiDiachiNhapTrachnhiem = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiSdtNhapTrachnhiem = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiSoBill = ko.observable(null);
    self.fiTenThuongnhanXk = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiDiachiThuongnhanXk = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 1000 ký tự', params: 1000}
    });
    self.fiSdtThuongnhanXk = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 1000 ký tự', params: 1000}
    });
    self.fiXuatxuHh = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiThoigianNkTu = ko.observable(null);
    self.fiThoigianNkDen = ko.observable(null);
    self.fiTgKiemtraTu = ko.observable(null);
    self.fiTgKiemtraDen = ko.observable(null);
    self.fiDiadiemKt = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });

    self.fiDukienCqKt = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });

    self.reason = ko.observable(null);

    // thong tin hien thi theo don
    self.isView1 = ko.observable(false);
    self.isView2 = ko.observable(false);
    self.isView3 = ko.observable(false);
    self.isView4 = ko.observable(false);
    self.isView123 = ko.observable(false);
    self.isView24 = ko.observable(false);
    self.isView34 = ko.observable(false);
    self.isView13 = ko.observable(false);
    self.isViewThongtinDn = ko.observable(true);

    self.isViewLoaiDon = ko.observable(false);

    self.btnViewGiay = ko.observable(false);

    // show btn upload file excel
    self.isViewExcel = ko.observable(false);

    //show truong so cong van mien giam khi chon 2d
    self.isViewSoCvMiengiam = ko.observable(false);

    // show phuong tien van chuyen khac
    self.isViewPhuongtienVckhac = ko.observable(false);

    self.lstHanghoa04 = ko.observableArray([]);
    self.lstHopdong04 = ko.observableArray([]);
    self.lstDinhkem04 = ko.observableArray([]);
    self.lstDinhkem04All = ko.observableArray([]);
    self.lstBaobi = ko.observableArray(mapCategory(options.hasOwnProperty('lstBaobi') ? options.lstBaobi : [], "fiMabaobi", "fiTenBaobi"));
    self.lstBophandung = ko.observableArray(mapCategory(options.hasOwnProperty('lstBophandung') ? options.lstBophandung : [], "maBpSudung", "tenBpSudung"));
    self.lstCqxl = ko.observableArray(mapCategory(options.hasOwnProperty('lstCqxl') ? options.lstCqxl : [], "maCoQuan", "tenCoQuan"));
    self.lstCuakhauXuat = ko.observableArray(mapCategory(options.hasOwnProperty('lstCuakhauXuat') ? options.lstCuakhauXuat : [], "portCode", "portName"));
    self.lstCangnhan = ko.observableArray(mapCategory(options.hasOwnProperty('lstCangnhan') ? options.lstCangnhan : [], "portCode", "portName"));
    self.lstCuakhauNhap = ko.observableArray(mapCategory(options.hasOwnProperty('lstCuakhauNhap') ? options.lstCuakhauNhap : [], "portCode", "portName"));
    self.lstDvTinhKlt = ko.observableArray(mapCategory(options.hasOwnProperty('lstDvTinhKlt') ? options.lstDvTinhKlt : [], "fiMaDonvitinh", "fiTenDonvitinh"));
    self.lstDvTinhKlbb = ko.observableArray(mapCategory(options.hasOwnProperty('lstDvTinhKlbb') ? options.lstDvTinhKlbb : [], "fiMaDonvitinh", "fiTenDonvitinh"));
    self.lstHanghoa = ko.observableArray(mapCategory(options.hasOwnProperty('lstHanghoa') ? options.lstHanghoa : [], "fiMaHanghoa", "fiTenHanghoa"));
    self.lstLoaiGiayto = ko.observableArray(mapCategory(options.hasOwnProperty('lstLoaiGiayto') ? options.lstLoaiGiayto : [], "fiMaLoaiGiayto", "fiTenLoaiGiayto"));
    self.lstLoaihang = ko.observableArray(mapCategory(options.hasOwnProperty('lstLoaihang') ? options.lstLoaihang : [], "fiMaLoaihang", "fiTenLoaihang"));
    self.lstLoaiThucan = ko.observableArray(mapCategory(options.hasOwnProperty('lstLoaiThucan') ? options.lstLoaiThucan : [], "maThucan", "tenThucan"));
    self.lstPhuongtien = ko.observableArray(mapCategory(options.hasOwnProperty('lstPhuongtien') ? options.lstPhuongtien : [], "fiMa", "fiTenPhuongtien"));
    self.lstNuocXuatkhau = ko.observableArray(mapCategory(options.hasOwnProperty('lstNuocXuatkhau') ? options.lstNuocXuatkhau : [], "maQuocgia", "tenQuocgia"));
    self.lstNuocXuatxu = ko.observableArray(mapCategory(options.hasOwnProperty('lstNuocXuatxu') ? options.lstNuocXuatxu : [], "maQuocgia", "tenQuocgia"));
    self.lstDvTiente = ko.observableArray(mapCategory(options.hasOwnProperty('lstDvTiente') ? options.lstDvTiente : [], "fiMaDvTiente", "fiTenDvTiente"));
    self.lstLoaidon = ko.observableArray(mapCategory(options.hasOwnProperty('lstLoaidon') ? options.lstLoaidon : [], "fiMaLoaidon", "fiTenLoaidon"));
    self.lstLoaiKiemtra = ko.observableArray(mapCategory(options.hasOwnProperty('lstLoaiKiemtra') ? options.lstLoaiKiemtra : [], "fiMaLoaiKiemtra", "fiTenLoaiKiemtra"));
    self.lstPhuongthucKt = ko.observableArray(mapCategory(options.hasOwnProperty('lstPhuongthucKt') ? options.lstPhuongthucKt : [], "maPhuongthuc", "tenPhuongthuc"));

    //Khoi tao gia tri ho so
    self.init = function (hoso) {
        // thông tin doanh nghiệp
        self.fiTenTochuc(hoso !== null && hoso.hasOwnProperty('fiTenTochuc') ? hoso.fiTenTochuc : user.companyName);
        self.fiDiachiTochuc(hoso !== null && hoso.hasOwnProperty('fiDiachiTochuc') ? hoso.fiDiachiTochuc : user.companyAddress);
        self.fiSdtTochuc(hoso !== null && hoso.hasOwnProperty('fiSdtTochuc') ? hoso.fiSdtTochuc : user.companyPhoneNumber);
        self.fiMst(hoso !== null && hoso.hasOwnProperty('fiMst') ? hoso.fiMst : user.username);
        if (hoso !== null) {
            self.fiIdHoso(hoso.hasOwnProperty('fiIdHoso') ? hoso.fiIdHoso : null);
            self.fiMaHoso(hoso.hasOwnProperty('fiMaHoso') ? hoso.fiMaHoso : null);
            self.fiMaTrangthai(hoso.hasOwnProperty('fiMaTrangthai') ? hoso.fiMaTrangthai : null);
            self.fiTenTrangthai(hoso.hasOwnProperty('fiTenTrangthai') ? hoso.fiTenTrangthai : null);
            self.fiNgaygui(hoso.hasOwnProperty('fiNgaygui') && hoso.fiNgaygui != null ? new Date(hoso.fiNgaygui) : null);
            self.fiNgayCapphep(hoso.hasOwnProperty('fiNgayCapphep') && hoso.fiNgayCapphep != null ? new Date(hoso.fiNgayCapphep) : null);
            self.fiNgaytao(hoso.hasOwnProperty('fiNgaytao') && hoso.fiNgaytao ? new Date(hoso.fiNgaytao) : null);
            self.fiNguoitao(hoso.hasOwnProperty('fiNguoitao') ? hoso.fiNguoitao : null);
            self.fiHoatdong(hoso.hasOwnProperty('fiHoatdong') ? hoso.fiHoatdong : null);
            self.fiCheckXnd(hoso.hasOwnProperty('fiCheckXnd') ? hoso.fiCheckXnd : null);
            self.fiMaTrangthaiphi(hoso.hasOwnProperty('fiMaTrangthaiphi') ? hoso.fiMaTrangthaiphi : null);
            self.fiTenTrangthaiphi(hoso.hasOwnProperty('fiTenTrangthaiphi') ? hoso.fiTenTrangthaiphi : null);

            self.fiMaLoaidon(hoso.hasOwnProperty('fiMaLoaidon') ? hoso.fiMaLoaidon : null);
            self.fiTenLoaidon(hoso.hasOwnProperty('fiTenLoaidon') ? hoso.fiTenLoaidon : null);
            self.fiMaCqxl(hoso.hasOwnProperty('fiMaCqxl') ? hoso.fiMaCqxl : null);
            self.fiTenCqxl(hoso.hasOwnProperty('fiTenCqxl') ? hoso.fiTenCqxl : null);
            self.fiSoXnDk(hoso.hasOwnProperty('fiSoXnDk') ? hoso.fiSoXnDk : null);
            self.fiFaxEmail(hoso.hasOwnProperty('fiFaxEmail') ? hoso.fiFaxEmail : null);
            self.fiCmnd(hoso.hasOwnProperty('fiCmnd') ? hoso.fiCmnd : null);
            self.fiNgaycapCmnd(hoso.hasOwnProperty('fiNgaycapCmnd') && hoso.fiNgaycapCmnd != null ? new Date(hoso.fiNgaycapCmnd) : null);
            self.fiNoicapCmnd(hoso.hasOwnProperty('fiNoicapCmnd') ? hoso.fiNoicapCmnd : null);
            self.fiSoHopdong(hoso.hasOwnProperty('fiSoHopdong') ? hoso.fiSoHopdong : null);
            self.fiTochucXk(hoso.hasOwnProperty('fiTochucXk') ? hoso.fiTochucXk : null);
            self.fiDiachiXk(hoso.hasOwnProperty('fiDiachiXk') ? hoso.fiDiachiXk : null);
            self.fiManuocXk(hoso.hasOwnProperty('fiManuocXk') ? hoso.fiManuocXk : null);
            self.fiTennuocXk(hoso.hasOwnProperty('fiTennuocXk') ? hoso.fiTennuocXk : null);
            self.fiMaCuakhauXuat(hoso.hasOwnProperty('fiMaCuakhauXuat') ? hoso.fiMaCuakhauXuat : null);
            self.fiTenCuakhauXuat(hoso.hasOwnProperty('fiTenCuakhauXuat') ? hoso.fiTenCuakhauXuat : null);
            self.fiTochucNhap(hoso.hasOwnProperty('fiTochucNhap') ? hoso.fiTochucNhap : null);
            self.fiDiachiNhap(hoso.hasOwnProperty('fiDiachiNhap') ? hoso.fiDiachiNhap : null);
            self.fiMaCuakhauNhap(hoso.hasOwnProperty('fiMaCuakhauNhap') ? hoso.fiMaCuakhauNhap : null);
            self.fiTenCuakhauNhap(hoso.hasOwnProperty('fiTenCuakhauNhap') ? hoso.fiTenCuakhauNhap : null);
            self.fiMaPhuongtien(hoso.hasOwnProperty('fiMaPhuongtien') ? hoso.fiMaPhuongtien : null);
            self.fiTenPhuongtien(hoso.hasOwnProperty('fiTenPhuongtien') ? hoso.fiTenPhuongtien : null);
            self.fiTenPhuongtienKhac(hoso.hasOwnProperty('fiTenPhuongtienKhac') ? hoso.fiTenPhuongtienKhac : null);
            self.fiMucdichSd(hoso.hasOwnProperty('fiMucdichSd') ? hoso.fiMucdichSd : null);
            self.fiGiayphepKd(hoso.hasOwnProperty('fiGiayphepKd') ? hoso.fiGiayphepKd : null);
            self.fiDiadiemKd(hoso.hasOwnProperty('fiDiadiemKd') ? hoso.fiDiadiemKd : null);
            self.fiThoigianKd(hoso.hasOwnProperty('fiThoigianKd') && hoso.fiThoigianKd != null ? new Date(hoso.fiThoigianKd) : null);
            self.fiSoGcn(hoso.hasOwnProperty('fiSoGcn') ? hoso.fiSoGcn : null);
            self.fiNoihangDen(hoso.hasOwnProperty('fiNoihangDen') ? hoso.fiNoihangDen : null);
            self.fiNoiky(hoso.hasOwnProperty('fiNoiky') ? hoso.fiNoiky : null);
            self.fiNgayky(hoso.hasOwnProperty('fiNgayky') && hoso.fiNgayky != null ? new Date(hoso.fiNgayky) : null);
            self.fiNguoiky(hoso.hasOwnProperty('fiNguoiky') ? hoso.fiNguoiky : null);
            self.fiChucvu(hoso.hasOwnProperty('fiChucvu') ? hoso.fiChucvu : null);

            self.fiMaLoaiThucan(hoso.hasOwnProperty('fiMaLoaiThucan') ? hoso.fiMaLoaiThucan : null);
            self.fiTenLoaiThucan(hoso.hasOwnProperty('fiTenLoaiThucan') ? hoso.fiTenLoaiThucan : null);
            self.fiMaLoaiKiemtra(hoso.hasOwnProperty('fiMaLoaiKiemtra') ? hoso.fiMaLoaiKiemtra : null);
            self.fiTenLoaiKiemtra(hoso.hasOwnProperty('fiTenLoaiKiemtra') ? hoso.fiTenLoaiKiemtra : null);
            self.fiSoTbMiengiam(hoso.hasOwnProperty('fiSoTbMiengiam') ? hoso.fiSoTbMiengiam : null);
            self.fiSoDkTochuc(hoso.hasOwnProperty('fiSoDkTochuc') ? hoso.fiSoDkTochuc : null);
            self.fiHang(hoso.hasOwnProperty('fiHang') ? hoso.fiHang : null);
            self.fiDiachiBenban(hoso.hasOwnProperty('fiDiachiBenban') ? hoso.fiDiachiBenban : null);
            self.fiSdtBenban(hoso.hasOwnProperty('fiSdtBenban') ? hoso.fiSdtBenban : null);
            self.fiFaxBenban(hoso.hasOwnProperty('fiFaxBenban') ? hoso.fiFaxBenban : null);
            self.fiNoiXuathang(hoso.hasOwnProperty('fiNoiXuathang') ? hoso.fiNoiXuathang : null);
            self.fiBenMuahang(hoso.hasOwnProperty('fiBenMuahang') ? hoso.fiBenMuahang : null);
            self.fiCmndBenmua(hoso.hasOwnProperty('fiCmndBenmua') ? hoso.fiCmndBenmua : null);
            self.fiNgaycapCmndBenmua(hoso.hasOwnProperty('fiNgaycapCmndBenmua') && hoso.fiNgaycapCmndBenmua != null ? new Date(hoso.fiNgaycapCmndBenmua) : null);
            self.fiNoicapCmndBenmua(hoso.hasOwnProperty('fiNoicapCmndBenmua') ? hoso.fiNoicapCmndBenmua : null);
            self.fiDiachiBenmua(hoso.hasOwnProperty('fiDiachiBenmua') ? hoso.fiDiachiBenmua : null);
            self.fiSdtBenmua(hoso.hasOwnProperty('fiSdtBenmua') ? hoso.fiSdtBenmua : null);
            self.fiFaxBenmua(hoso.hasOwnProperty('fiFaxBenmua') ? hoso.fiFaxBenmua : null);
            self.fiMacangNoinhan(hoso.hasOwnProperty('fiMacangNoinhan') ? hoso.fiMacangNoinhan : null);
            self.fiTencangNoinhan(hoso.hasOwnProperty('fiTencangNoinhan') ? hoso.fiTencangNoinhan : null);
            self.fiThoigianNhaptu(hoso.hasOwnProperty('fiThoigianNhaptu') && hoso.fiThoigianNhaptu != null ? new Date(hoso.fiThoigianNhaptu) : null);
            self.fiThoigianNhapden(hoso.hasOwnProperty('fiThoigianNhapden') && hoso.fiThoigianNhapden != null ? new Date(hoso.fiThoigianNhapden) : null);
            self.fiDiadiemTapket(hoso.hasOwnProperty('fiDiadiemTapket') ? hoso.fiDiadiemTapket : null);
            self.fiNgayDangkyTu(hoso.hasOwnProperty('fiNgayDangkyTu') && hoso.fiNgayDangkyTu != null ? new Date(hoso.fiNgayDangkyTu) : null);
            self.fiNgayDangkyDen(hoso.hasOwnProperty('fiNgayDangkyDen') && hoso.fiNgayDangkyDen != null ? new Date(hoso.fiNgayDangkyDen) : null);
            self.fiDiadiemLaymau(hoso.hasOwnProperty('fiDiadiemLaymau') ? hoso.fiDiadiemLaymau : null);
            self.fiNguoiLienhe(hoso.hasOwnProperty('fiNguoiLienhe') ? hoso.fiNguoiLienhe : null);

            self.fiSdtTochucNhap(hoso.hasOwnProperty('fiSdtTochucNhap') ? hoso.fiSdtTochucNhap : null);
            self.fiTochucNhapTrachnhiem(hoso.hasOwnProperty('fiTochucNhapTrachnhiem') ? hoso.fiTochucNhapTrachnhiem : null);
            self.fiDiachiNhapTrachnhiem(hoso.hasOwnProperty('fiDiachiNhapTrachnhiem') ? hoso.fiDiachiNhapTrachnhiem : null);
            self.fiSdtNhapTrachnhiem(hoso.hasOwnProperty('fiSdtNhapTrachnhiem') ? hoso.fiSdtNhapTrachnhiem : null);
            self.fiSoBill(hoso.hasOwnProperty('fiSoBill') ? hoso.fiSoBill : null);
            self.fiTenThuongnhanXk(hoso.hasOwnProperty('fiTenThuongnhanXk') ? hoso.fiTenThuongnhanXk : null);
            self.fiDiachiThuongnhanXk(hoso.hasOwnProperty('fiDiachiThuongnhanXk') ? hoso.fiDiachiThuongnhanXk : null);
            self.fiSdtThuongnhanXk(hoso.hasOwnProperty('fiSdtThuongnhanXk') ? hoso.fiSdtThuongnhanXk : null);
            self.fiXuatxuHh(hoso.hasOwnProperty('fiXuatxuHh') ? hoso.fiXuatxuHh : null);
            self.fiThoigianNkTu(hoso.hasOwnProperty('fiThoigianNkTu') && hoso.fiThoigianNkTu != null ? new Date(hoso.fiThoigianNkTu) : null);
            self.fiThoigianNkDen(hoso.hasOwnProperty('fiThoigianNkDen') && hoso.fiThoigianNkDen != null ? new Date(hoso.fiThoigianNkDen) : null);
            self.fiTgKiemtraTu(hoso.hasOwnProperty('fiTgKiemtraTu') && hoso.fiTgKiemtraTu != null ? new Date(hoso.fiTgKiemtraTu) : null);
            self.fiTgKiemtraDen(hoso.hasOwnProperty('fiTgKiemtraDen') && hoso.fiTgKiemtraDen != null ? new Date(hoso.fiTgKiemtraDen) : null);
            self.fiDiadiemKt(hoso.hasOwnProperty('fiDiadiemKt') ? hoso.fiDiadiemKt : null);

            self.fiDukienCqKt(hoso.hasOwnProperty('fiDukienCqKt') ? hoso.fiDukienCqKt : null);

            self.lstHanghoa04(mapTbdHanghoa04(hoso.hasOwnProperty('lstHanghoa04') ? hoso.lstHanghoa04 : []));
            self.lstHopdong04(mapTbdHopdong04(hoso.hasOwnProperty('lstHopdong04') ? hoso.lstHopdong04 : []));
            self.lstDinhkem04(mapFiles04VM(hoso.hasOwnProperty('lstDinhkem04') ? hoso.lstDinhkem04 : [], self.fiIdHoso()));

            if (self.fiIdHoso() != null && self.fiIdHoso() > 0) {
                self.isViewLoaiDon(true);
            } else {
                self.isViewLoaiDon(false);
            }

            if (self.fiMaLoaidon() == 1 || self.fiMaLoaidon() == "1") {
                self.isView1(true);
                self.isView2(false);
                self.isView3(false);
                self.isView4(false);
                self.isView123(true);
                self.isView24(false);
                self.isView34(false);
                self.isView13(true);
                self.btnViewGiay(true);
                self.isViewThongtinDn(true);
                self.isViewExcel(true);
            } else if (self.fiMaLoaidon() == 2 || self.fiMaLoaidon() == "2") {
                self.isView1(false);
                self.isView2(true);
                self.isView3(false);
                self.isView4(false);
                self.isView123(true);
                self.isView24(true);
                self.isView34(false);
                self.isView13(false);
                self.btnViewGiay(true);
                self.isViewThongtinDn(true);
                self.isViewExcel(true);
            } else if (self.fiMaLoaidon() == 3 || self.fiMaLoaidon() == "3") {
                self.isView1(false);
                self.isView2(false);
                self.isView3(true);
                self.isView4(false);
                self.isView123(true);
                self.isView24(false);
                self.isView34(true);
                self.isView13(true);
                self.btnViewGiay(true);
                self.isViewThongtinDn(true);
                self.isViewExcel(true);
            } else if (self.fiMaLoaidon() == 4 || self.fiMaLoaidon() == "4") {
                self.isView1(false);
                self.isView2(false);
                self.isView3(false);
                self.isView4(true);
                self.isView123(false);
                self.isView24(true);
                self.isView34(true);
                self.isView13(false);
                self.btnViewGiay(true);
                self.isViewThongtinDn(false);
                self.isViewExcel(true);
            } else {
                self.isView1(false);
                self.isView2(false);
                self.isView3(false);
                self.isView4(false);
                self.isView123(false);
                self.isView24(false);
                self.isView34(false);
                self.isView13(false);
                self.btnViewGiay(false);
                self.isViewThongtinDn(true);
                self.isViewExcel(false);
            }

            if (self.fiMaLoaiKiemtra() == '4' || self.fiMaLoaiKiemtra() == 4) {
                self.isViewSoCvMiengiam(true);
            } else {
                self.isViewSoCvMiengiam(false);
            }

            if ((self.fiMaPhuongtien() == "7" || self.fiMaPhuongtien() == 7)
                && (self.fiMaLoaidon() == '1' || self.fiMaLoaidon() == 1)) {
                self.isViewPhuongtienVckhac(true);
            } else {
                self.isViewPhuongtienVckhac(false);
            }

        } else {
            getDmTeptin();
        }
    };

    function getDmTeptin() {
        debugger;
        app.getCategory('/mard/p04/danhmuc', 'DM_TEPTIN', null, function (res) {
            if (res.success) {
                self.lstDinhkem04All(mapFiles04VM(res.data, self.fiIdHoso()));
            } else {
                self.lstDinhkem04All([]);
            }
        });
    }
    ;

    self.init(hosoInfo);

    self.toJSON = function () {
        var mapping = {
            ignore: ['isView1', 'init', 'isView2', 'isView3', 'isView4', 'isView123', 'isView24', 'isView34',
                'isView13', 'hosoErrors', 'errorHHMessage', 'errorDinhKemMessage', 'clickSelectLoaidon',
                'toJSON', 'isValidForm', 'lstBaobi', 'lstBophandung', 'lstCqxl', 'lstCuakhauXuat', 'lstCangnhan', 'lstCuakhauNhap',
                'lstDvTinhKlt', 'lstDvTinhKlbb', 'lstHanghoa', 'lstLoaiGiayto', 'lstLoaihang', 'lstLoaiThucan', 'lstPhuongtien',
                'lstNuocXuatkhau', 'lstNuocXuatxu', 'lstDvTiente', 'lstLoaidon', 'lstLoaiKiemtra', 'btnAddNewClickHh', 'editHhOnClick',
                'addOrUpdatePopupHh', 'removeHhOnClick', 'btnAddNewClickHopdongCnkdKtcl', 'removePopupHdKtcl', 'hangHoaVM', 'pop',
                'lydoErrors', 'isViewLoaiDon', 'clearfiNgayky', 'clearDate1', 'clearDate2', 'clearDate3', 'clearDate4', 'clearDate5',
                'clearDate6', 'clearDate7', 'clearDate8', 'clearDate9', 'clearDate10', 'clearDate11', 'viewHhOnClick', 'hosoDon1Errors',
                'hosoDon2Errors', 'validFile', 'hosoDon3Errors', 'hosoDon4Errors', 'clearDate12', 'validLoaiGiayto', 'validSohopdong',
                'validNgaycapGiayto', 'btnViewPageClick', 'btnViewGiay', 'xndTamVM', 'lstPhuongthucKt', 'lstDinhkem04All',
                'lstDinhkem04Temp', 'isViewThongtinDn', 'isViewSoCvMiengiam', 'soCvMiengiamErrors', 'fiTepTemp', 'canTemp',
                'canDeleteTemp', 'isViewExcel', 'doDownloadTemp', 'doDeleteTemp', 'btnUploadTemp', 'pageSizeOptions', 'currentPageIndex',
                'currentPageSize', 'recordCount', 'maxPageIndex', 'moveFirst', 'movePrevious', 'moveNext', 'moveLast', 'changePageIndex',
                'onPageSizeChange', 'currentPageRecordsLstHanghoa', 'isViewPhuongtienVckhac', 'ptienVcKhacErrors'
            ]
        };

        var copy = ko.mapping.fromJS(self, mapping);
        copy = ko.toJS(copy);

        for (var i = 0; i < copy.lstDinhkem04.length; i++) {
            delete copy.lstDinhkem04[i]['canUpload'];
            delete copy.lstDinhkem04[i]['canDownload'];
            delete copy.lstDinhkem04[i]['canDelete'];
            delete copy.lstDinhkem04[i]['doUpload'];
            delete copy.lstDinhkem04[i]['doDelete'];
            delete copy.lstDinhkem04[i]['downloadUrl'];
            delete copy.lstDinhkem04[i]['fiBatBuoc'];
            delete copy.lstDinhkem04[i]['isRequire'];
            delete copy.lstDinhkem04[i]["__ko_mapping__"];
        }

        delete copy['__ko_mapping__'];
        return copy;
    };

    self.viewHhOnClick = function (item) {
        self.addOrUpdatePopupHh(item, 'view', 'Xem chi tiết lô hàng', self.fiMaLoaidon());
        return false;
    };

    self.addOrUpdatePopupHh = function (item, action, title, maLoaidon) {
        var html = [
            $('#hanghoa-template').html()
        ].join('');
        delete self.pop;
        delete self.hangHoaVM;
        options.lstHanghoa04 = item;
        var lstHh = self.lstHanghoa04();

        self.hangHoaVM = new HanghoaVM(options, maLoaidon, lstHh)
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
                        if (!self.hangHoaVM.isValidHanghoa(maLoaidon)) {
                            app.Alert('Bạn phải nhập đầy đủ thông tin hàng hóa.');
                        } else {
                            debugger;
                            var hangHoaInfo = self.hangHoaVM.toJSON();
                            if (null == hangHoaInfo.fiIdHh) {
                                hangHoaInfo.fiIdHh = -1 * new Date().getTime();
                                var hangHoaModel = new TbdHanghoa04(hangHoaInfo);
                                self.lstHanghoa04.push(hangHoaModel);
                                $('#hanghoa_valid').hide();
                            } else {
                                for (var i = 0; i < self.lstHanghoa04().length; i++) {
                                    if (hangHoaInfo.fiIdHh == self.lstHanghoa04()[i].fiIdHh()) {
                                        var hangHoaModel = new TbdHanghoa04(hangHoaInfo);
                                        self.lstHanghoa04.replace(self.lstHanghoa04()[i], hangHoaModel);
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
        if (action == 'view' && item != null && item.fiIdHh() > 0) {
            $(".btn-save").hide();
        }
        ko.applyBindings(self.hangHoaVM, document.getElementById('hanghoa-vm'));
        $("#fiMaHang").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
        $("#fiMaNhomHh").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
        $("#fiMaNhomSp").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
        $("#fiMaBophanSd").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
        $("#fiMaBaobi").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
        $("#fiMaDvKlTinh").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
        $("#fiMaDvKlBaobi").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
        $("#fiMaNuocXx").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
        $("#fiMaDvTiente").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
        $("#fiMaPhuongthucKt").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
    };

    /**
     * hàm xử lý view xác nhận đơn tạm thời
     */
    self.btnViewPageClick = function () {
        var html = [
            $('#viewXndTam-template').html()
        ].join('');
        delete self.pop;
        delete self.xndTamVM;

        var dataHoso = self.toJSON();

        self.xndTamVM = new XacnhanDonVM(dataHoso);
        self.pop = app.popup({
            title: "Thông tin đơn đăng ký",
            html: html,
            width: 1024,
            buttons: [
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
        ko.applyBindings(self.xndTamVM, document.getElementById('viewXndTam-vm'));
        return false;
    };

    /**
     * Phân trang cho danh sách lô hàng
     */
    self.pageSizeOptions = ko.observableArray([1, 2, 5, 10, 20, 50, 100, 200, 500]); // list record hiển thị trên page
    self.currentPageIndex = ko.observable(self.lstHanghoa04().length > 0 ? 0 : -1); // tìm ra bản ghi đầu tiên
    self.currentPageSize = ko.observable(5); //hiển thị số bản ghi trong 1 trang mặc định
    self.recordCount = ko.computed(function () { // tổng số bản ghi
        return self.lstHanghoa04().length;
    });
    self.maxPageIndex = ko.computed(function () {
        return Math.ceil(self.lstHanghoa04().length / self.currentPageSize()) - 1;
    });
    self.currentPageRecordsLstHanghoa = ko.computed(function () {
        var newPageIndex = -1;
        var pageIndex = self.currentPageIndex();
        var maxPageIndex = self.maxPageIndex();
        if (pageIndex > maxPageIndex) {
            newPageIndex = maxPageIndex;
        } else if (pageIndex == -1) {
            if (maxPageIndex > -1) {
                newPageIndex = 0;
            } else {
                newPageIndex = -2;
            }
        } else {
            newPageIndex = pageIndex;
        }

        if (newPageIndex != pageIndex) {
            if (newPageIndex >= -1) {
                self.currentPageIndex(newPageIndex);
            }

            return [];
        }

        var pageSize = self.currentPageSize();
        var startIndex = pageIndex * pageSize;
        var endIndex = startIndex + pageSize;
        return self.lstHanghoa04().slice(startIndex, endIndex);
    }).extend({throttle: 5});
    self.moveFirst = function () {
        self.changePageIndex(0);
    };
    self.movePrevious = function () {
        self.changePageIndex(self.currentPageIndex() - 1);
    };
    self.moveNext = function () {
        self.changePageIndex(self.currentPageIndex() + 1);
    };
    self.moveLast = function () {
        self.changePageIndex(self.maxPageIndex());
    };
    self.changePageIndex = function (newIndex) {
        if (newIndex < 0
            || newIndex == self.currentPageIndex()
            || newIndex > self.maxPageIndex()) {
            return;
        }

        self.currentPageIndex(newIndex);
    };
    self.onPageSizeChange = function () {
        self.currentPageIndex(0);
    };
    // end phân trang
}
;

function HanghoaVM(op, maLoaidon, lstHh) {
    var self = this;
    var hh = op.lstHanghoa04;

    self.isViewHanghoakhac = ko.observable(false);
    self.isViewNhomHanghoakhac = ko.observable(false);
    self.isViewNhomSpkhac = ko.observable(false);

    self.isViewHH123 = ko.observable(false);
    self.isViewHH12 = ko.observable(false);
    self.isViewHH13 = ko.observable(false);
    self.isViewHH23 = ko.observable(false);
    self.isViewHH1 = ko.observable(false);
    self.isViewHH2 = ko.observable(false);
    self.isViewHH3 = ko.observable(false);
    self.isViewHH34 = ko.observable(false);
    self.isViewHH4 = ko.observable(false);
    self.isViewHH134 = ko.observable(false);

    self.isShowRequire = ko.observable(false);
    // disable phuong thuc kiem tra
    self.isViewPtkt = ko.observable(false);
    // view bphan su dụng khác
    self.isViewBpsdKhac = ko.observable(false);

    if (maLoaidon == 1 || maLoaidon == "1") {
        self.isViewHH123(true);
        self.isViewHH12(true);
        self.isViewHH13(true);
        self.isViewHH23(false);
        self.isViewHH1(true);
        self.isViewHH2(false);
        self.isViewHH3(false);
        self.isViewHH34(false);
        self.isViewHH4(false);
        self.isViewHH134(true);
    } else if (maLoaidon == 2 || maLoaidon == "2") {
        self.isViewHH123(true);
        self.isViewHH12(true);
        self.isViewHH13(false);
        self.isViewHH23(true);
        self.isViewHH1(false);
        self.isViewHH2(true);
        self.isViewHH3(false);
        self.isViewHH34(false);
        self.isViewHH4(false);
        self.isViewHH134(false);
    } else if (maLoaidon == 3 || maLoaidon == "3") {
        self.isViewHH123(true);
        self.isViewHH12(false);
        self.isViewHH13(true);
        self.isViewHH23(true);
        self.isViewHH1(false);
        self.isViewHH2(false);
        self.isViewHH3(true);
        self.isViewHH34(true);
        self.isViewHH4(false);
        self.isViewHH134(true);
    } else if (maLoaidon == 4 || maLoaidon == "4") {
        self.isViewHH123(false);
        self.isViewHH12(false);
        self.isViewHH13(false);
        self.isViewHH23(false);
        self.isViewHH1(false);
        self.isViewHH2(false);
        self.isViewHH3(false);
        self.isViewHH34(true);
        self.isViewHH4(true);
        self.isViewHH134(true);
    } else {
        self.isViewHH123(false);
        self.isViewHH12(false);
        self.isViewHH13(false);
        self.isViewHH23(false);
        self.isViewHH1(false);
        self.isViewHH2(false);
        self.isViewHH3(false);
        self.isViewHH34(false);
        self.isViewHH4(false);
        self.isViewHH134(false);
    }

    self.fiIdHh = ko.observable(hh ? hh.fiIdHh() : null);
    self.fiIdHoso = ko.observable(hh ? hh.fiIdHoso() : null);
    self.fiMaHoso = ko.observable(hh ? hh.fiMaHoso() : null);

    self.fiMaHang = ko.observable(hh ? hh.fiMaHang() : null);
    self.fiTenHang = ko.observable(hh ? hh.fiTenHang() : null);
    self.fiTenhangKhac = ko.observable(hh ? hh.fiTenhangKhac() : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiTenchitietHanghoa = ko.observable(hh ? hh.fiTenchitietHanghoa() : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiMaNhomHh = ko.observable(hh ? hh.fiMaNhomHh() : null);
    self.fiTenNhomHh = ko.observable(hh ? hh.fiTenNhomHh() : null);
    self.fiTenNhomHhKhac = ko.observable(hh ? hh.fiTenNhomHhKhac() : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiTenKhoahoc = ko.observable(hh ? hh.fiTenKhoahoc() : null);
    self.fiSoluong = ko.observable(hh ? hh.fiSoluong() : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 15 ký tự', params: 15},
        pattern: {
            message: 'Không được nhập chữ cái, số âm hoặc số thập phân',
            params: /^([0-9]{1,15})$/
        }
    });
    self.fiMaBaobi = ko.observable(hh ? hh.fiMaBaobi() : null);
    self.fiTenBaobi = ko.observable(hh ? hh.fiTenBaobi() : null);
    self.fiKhoiluongTinh = ko.observable(hh ? hh.fiKhoiluongTinh() : null).extend({
        maxLength: {message: 'Tối đa 31 ký tự', params: 31},
        pattern: {
            message: 'Không được nhập chữ cái, số âm hoặc số thập phân sau dấu phẩy quá 15 số',
            params: /^([0-9]{1,15}(\.[0-9]{1,15})?)$/
        }
    });
    self.fiMaDvKlTinh = ko.observable(hh ? hh.fiMaDvKlTinh() : null);
    self.fiTenDvKlTinh = ko.observable(hh ? hh.fiTenDvKlTinh() : null);
    self.fiKlTinhTheoTan = ko.observable(hh ? hh.fiKlTinhTheoTan() : null);
    self.fiKhoiluongBaoBi = ko.observable(hh ? hh.fiKhoiluongBaoBi() : null).extend({
        maxLength: {message: 'Tối đa 31 ký tự', params: 31},
        pattern: {
            message: 'Không được nhập chữ cái, số âm hoặc số thập phân sau dấu phẩy quá 15 số',
            params: /^([0-9]{1,15}(\.[0-9]{1,15})?)$/
        }
    });
    self.fiMaDvKlBaobi = ko.observable(hh ? hh.fiMaDvKlBaobi() : null);
    self.fiTenDvKlBaobi = ko.observable(hh ? hh.fiTenDvKlBaobi() : null);
    self.fiKlCabiTheoTan = ko.observable(hh ? hh.fiKlCabiTheoTan() : null);
    self.fiTenCosoSx = ko.observable(hh ? hh.fiTenCosoSx() : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiMasoNhasanxuat = ko.observable(hh ? hh.fiMasoNhasanxuat() : null);
    self.fiDiachiCosoSx = ko.observable(hh ? hh.fiDiachiCosoSx() : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 1000 ký tự', params: 1000}
    });
    self.fiMaHs = ko.observable(hh ? hh.fiMaHs() : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });

    self.fiMaBophanSd = ko.observable(hh ? hh.fiMaBophanSd() : null);
    self.fiTenBophanSd = ko.observable(hh ? hh.fiTenBophanSd() : null);
    self.fiTenBophanSdKhac = ko.observable(hh ? hh.fiTenBophanSdKhac() : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiMasoThucan = ko.observable(hh ? hh.fiMasoThucan() : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiMaNuocXx = ko.observable(hh ? hh.fiMaNuocXx() : null);
    self.fiNuocXuatxu = ko.observable(hh ? hh.fiNuocXuatxu() : null);
    self.fiGiatriHh = ko.observable(hh ? hh.fiGiatriHh() : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 16 ký tự', params: 16},
        pattern: {
            message: 'Không được nhập chữ cái, số âm hoặc số thập phân sau dấu phẩy quá 3 số',
            params: /^([0-9]{1,15}(\.[0-9]{1,3})?)$/
        }
    });
    self.fiMaDvTiente = ko.observable(hh ? hh.fiMaDvTiente() : '01');
    self.fiTenDvTiente = ko.observable(hh ? hh.fiTenDvTiente() : 'USD');

    //don 3
    self.fiMaNhomSp = ko.observable(hh ? hh.fiMaNhomSp() : null);
    self.fiNhomSp = ko.observable(hh ? hh.fiNhomSp() : null);
    self.fiNhomSpKhac = ko.observable(hh ? hh.fiNhomSpKhac() : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });

    // kiem tra phuong thuc - neu co hang hoa da khai bao truoc thi mac dinh cac hang hoa sau cua lo hang deu co chung kieu phuong thuc ktra
    self.fiMaPtKt_dongnhat = ko.observable(null);
    self.fiPtKt_dongnhat = ko.observable(null);
    if (hh == null && lstHh.length > 0 && (maLoaidon == "3" || maLoaidon == "4")) {
        self.fiMaPtKt_dongnhat(lstHh[0].fiMaPhuongthucKt());
        self.fiPtKt_dongnhat(lstHh[0].fiPhuongthucKt());
        self.isViewPtkt(true);
    } else if (hh) {
        self.isViewPtkt(true);
    } else {
        self.isViewPtkt(false);
    }
    self.fiMaPhuongthucKt = ko.observable(hh ? hh.fiMaPhuongthucKt() : self.fiMaPtKt_dongnhat());
    self.fiPhuongthucKt = ko.observable(hh ? hh.fiPhuongthucKt() : self.fiPtKt_dongnhat());

    self.fiSoVbPhuongthuc = ko.observable(hh ? hh.fiSoVbPhuongthuc() : null);
    self.fiHoatdong = ko.observable(hh ? hh.fiHoatdong() : null);

    self.lstHanghoa = op.lstHanghoa;
    self.lstBaobi = op.lstBaobi;
    self.lstDvTinhKlt = op.lstDvTinhKlt;
    self.lstDvTinhKlbb = op.lstDvTinhKlbb;
    self.lstLoaihang = op.lstLoaihang;
    self.lstBophandung = op.lstBophandung;
    self.lstNuocXuatxu = op.lstNuocXuatxu;
    self.lstDvTiente = op.lstDvTiente;
    self.lstPhuongthucKt = op.lstPhuongthucKt;
    self.lstNhomSp = ko.computed(function () {
        return ko.utils.arrayFilter(op.lstLoaihang, function (re) {
            return re.fiLoaiDonDangky == "1234";
        });
    });

    if (self.fiMaHang() === '578') {
        self.isViewHanghoakhac(true);
    } else {
        self.isViewHanghoakhac(false);
    }

    if (self.fiMaNhomHh() === '20' || self.fiMaNhomHh() === 20) {
        self.isViewNhomHanghoakhac(true);
    } else {
        self.isViewNhomHanghoakhac(false);
    }

    if (self.fiMaNhomSp() === '20' || self.fiMaNhomSp() === 20) {
        self.isViewNhomSpkhac(true);
    } else {
        self.isViewNhomSpkhac(false);
    }

    if (self.fiMaPhuongthucKt() == '2') {
        self.isShowRequire(true);
    } else {
        self.isShowRequire(false);
    }

    if (self.fiTenBophanSd() == 'Khác') {
        self.isViewBpsdKhac(true);
    } else {
        self.isViewBpsdKhac(false);
    }

    self.toJSON = function () {
        var exclude = ["toJSON", "fiStt", "errorsHanghoa1", "isValidHanghoa", "isViewHanghoakhac", "isViewNhomHanghoakhac",
            "isViewNhomSpkhac", "isViewHH123", "isViewHH12", "isViewHH13", "isViewHH2", "isViewHH23", "isViewHH34",
            "isViewHH1", "isViewHH2", "isViewHH3", "isViewHH4", "lstHanghoa", "lstBaobi", "lstDvTinhKlt", "lstDvTinhKlbb", "lstPhuongthucKt",
            "lstLoaihang", "lstBophandung", "lstNuocXuatxu", "lstDvTiente", "errorsHanghoa2", "errorsHanghoa3", "errorsHanghoa4",
            "isShowRequire", "lstNhomSp", "errorsTenHanghoaKhac", "errorsTenNhomHanghoaKhac", "errorsTenNhomSanphamKhac",
            "errorsKhoiluongTinh", "errorsKhoiluongCabi", "fiMaPtKt_dongnhat", "fiPtKt_dongnhat", "isViewPtkt", "isViewBpsdKhac",
            "errorsBpsdKhac", "isViewHH134"
        ];

        var model = ko.toJS(self);

        for (var key in model) {
            if (exclude.indexOf(key) >= 0) {
                delete model[key];
            }
        }

        return model;
    };

}
;

function XacnhanDonVM(data) {
    var self = this;
    self.isViewXndTamKdtv = ko.observable(false);
    self.isViewXndTamXncl = ko.observable(false);
    self.isViewXndTamKdtvAttp = ko.observable(false);
    self.isViewXndTamAttp = ko.observable(false);

    if (data !== null) {
        self.fiIdHoso = ko.observable(data.fiIdHoso ? data.fiIdHoso : null);
        self.fiMaHoso = ko.observable(data.fiMaHoso ? data.fiMaHoso : null);
        self.fiMaTrangthai = ko.observable(data.fiMaTrangthai ? data.fiMaTrangthai : null);
        self.fiTenTrangthai = ko.observable(data.fiTenTrangthai ? data.fiTenTrangthai : null);
        self.fiNgaygui = ko.observable(data.fiNgaygui ? new Date(data.fiNgaygui) : null);
        self.fiNgayCapphep = ko.observable(data.fiNgayCapphep ? new Date(data.fiNgayCapphep) : null);
        self.fiNgaytao = ko.observable(data.fiNgaytao ? new Date(data.fiNgaytao) : null);
        self.fiNguoitao = ko.observable(data.fiNguoitao ? data.fiNguoitao : null);
        self.fiHoatdong = ko.observable(data.fiHoatdong ? data.fiHoatdong : null);
        self.fiCheckXnd = ko.observable(data.fiCheckXnd ? data.fiCheckXnd : null);
        self.fiMaTrangthaiphi = ko.observable(data.fiMaTrangthaiphi ? data.fiMaTrangthaiphi : null);
        self.fiTenTrangthaiphi = ko.observable(data.fiTenTrangthaiphi ? data.fiTenTrangthaiphi : null);

        self.fiMaLoaidon = ko.observable(data.fiMaLoaidon ? data.fiMaLoaidon : null);
        self.fiTenLoaidon = ko.observable(data.fiTenLoaidon ? data.fiTenLoaidon : null);
        self.fiMaCqxl = ko.observable(data.fiMaCqxl ? data.fiMaCqxl : null);
        self.fiTenCqxl = ko.observable(data.fiTenCqxl ? data.fiTenCqxl : null);
        self.fiSoXnDk = ko.observable(data.fiSoXnDk ? data.fiSoXnDk : null);
        self.fiTenTochuc = ko.observable(data.fiTenTochuc ? data.fiTenTochuc : null);
        self.fiDiachiTochuc = ko.observable(data.fiDiachiTochuc ? data.fiDiachiTochuc : null);
        self.fiSdtTochuc = ko.observable(data.fiSdtTochuc ? data.fiSdtTochuc : null);
        self.fiFaxEmail = ko.observable(data.fiFaxEmail ? data.fiFaxEmail : null);
        self.fiMst = ko.observable(data.fiMst ? data.fiMst : null);
        self.fiCmnd = ko.observable(data.fiCmnd ? data.fiCmnd : null);
        self.fiNgaycapCmnd = ko.observable(data.fiNgaycapCmnd ? new Date(data.fiNgaycapCmnd) : null);
        self.fiNoicapCmnd = ko.observable(data.fiNoicapCmnd ? data.fiNoicapCmnd : null);
        self.fiSoHopdong = ko.observable(data.fiSoHopdong ? data.fiSoHopdong : null);
        self.fiTochucXk = ko.observable(data.fiTochucXk ? data.fiTochucXk : null);
        self.fiDiachiXk = ko.observable(data.fiDiachiXk ? data.fiDiachiXk : null);
        self.fiManuocXk = ko.observable(data.fiManuocXk ? data.fiManuocXk : null);
        self.fiTennuocXk = ko.observable(data.fiTennuocXk ? data.fiTennuocXk : null);
        self.fiMaCuakhauXuat = ko.observable(data.fiMaCuakhauXuat ? data.fiMaCuakhauXuat : null);
        self.fiTenCuakhauXuat = ko.observable(data.fiTenCuakhauXuat ? data.fiTenCuakhauXuat : null);
        self.fiTochucNhap = ko.observable(data.fiTochucNhap ? data.fiTochucNhap : null);
        self.fiDiachiNhap = ko.observable(data.fiDiachiNhap ? data.fiDiachiNhap : null);
        self.fiMaCuakhauNhap = ko.observable(data.fiMaCuakhauNhap ? data.fiMaCuakhauNhap : null);
        self.fiTenCuakhauNhap = ko.observable(data.fiTenCuakhauNhap ? data.fiTenCuakhauNhap : null);
        self.fiMaPhuongtien = ko.observable(data.fiMaPhuongtien ? data.fiMaPhuongtien : null);
        self.fiTenPhuongtien = ko.observable(data.fiTenPhuongtien ? data.fiTenPhuongtien : null);
        self.fiTenPhuongtienKhac = ko.observable(data.fiTenPhuongtienKhac ? data.fiTenPhuongtienKhac : null);
        self.fiMucdichSd = ko.observable(data.fiMucdichSd ? data.fiMucdichSd : null);
        self.fiGiayphepKd = ko.observable(data.fiGiayphepKd ? data.fiGiayphepKd : null);
        self.fiDiadiemKd = ko.observable(data.fiDiadiemKd ? data.fiDiadiemKd : null);
        self.fiThoigianKd = ko.observable(data.fiThoigianKd ? new Date(data.fiThoigianKd) : null);
        self.fiSoGcn = ko.observable(data.fiSoGcn ? data.fiSoGcn : null);
        self.fiNoihangDen = ko.observable(data.fiNoihangDen ? data.fiNoihangDen : null);
        self.fiNoiky = ko.observable(data.fiNoiky ? data.fiNoiky : null);
        self.fiNgayky = ko.observable(data.fiNgayky ? new Date(data.fiNgayky) : null);
        self.fiNguoiky = ko.observable(data.fiNguoiky ? data.fiNguoiky : null);
        self.fiChucvu = ko.observable(data.fiChucvu ? data.fiChucvu : null);

        self.fiMaLoaiThucan = ko.observable(data.fiMaLoaiThucan ? data.fiMaLoaiThucan : null);
        self.fiTenLoaiThucan = ko.observable(data.fiTenLoaiThucan ? data.fiTenLoaiThucan : null);
        self.fiMaLoaiKiemtra = ko.observable(data.fiMaLoaiKiemtra ? data.fiMaLoaiKiemtra : null);
        self.fiTenLoaiKiemtra = ko.observable(data.fiTenLoaiKiemtra ? data.fiTenLoaiKiemtra : null);
        self.fiSoTbMiengiam = ko.observable(data.fiSoTbMiengiam ? data.fiSoTbMiengiam : null);
        self.fiSoDkTochuc = ko.observable(data.fiSoDkTochuc ? data.fiSoDkTochuc : null);
        self.fiHang = ko.observable(data.fiHang ? data.fiHang : null);
        self.fiDiachiBenban = ko.observable(data.fiDiachiBenban ? data.fiDiachiBenban : null);
        self.fiSdtBenban = ko.observable(data.fiSdtBenban ? data.fiSdtBenban : null);
        self.fiFaxBenban = ko.observable(data.fiFaxBenban ? data.fiFaxBenban : null);
        self.fiNoiXuathang = ko.observable(data.fiNoiXuathang ? data.fiNoiXuathang : null);
        self.fiBenMuahang = ko.observable(data.fiBenMuahang ? data.fiBenMuahang : null);
        self.fiCmndBenmua = ko.observable(data.fiCmndBenmua ? data.fiCmndBenmua : null);
        self.fiNgaycapCmndBenmua = ko.observable(data.fiNgaycapCmndBenmua ? new Date(data.fiNgaycapCmndBenmua) : null);
        self.fiNoicapCmndBenmua = ko.observable(data.fiNoicapCmndBenmua ? data.fiNoicapCmndBenmua : null);
        self.fiDiachiBenmua = ko.observable(data.fiDiachiBenmua ? data.fiDiachiBenmua : null);
        self.fiSdtBenmua = ko.observable(data.fiSdtBenmua ? data.fiSdtBenmua : null);
        self.fiFaxBenmua = ko.observable(data.fiFaxBenmua ? data.fiFaxBenmua : null);
        self.fiMacangNoinhan = ko.observable(data.fiMacangNoinhan ? data.fiMacangNoinhan : null);
        self.fiTencangNoinhan = ko.observable(data.fiTencangNoinhan ? data.fiTencangNoinhan : null);
        self.fiThoigianNhaptu = ko.observable(data.fiThoigianNhaptu ? new Date(data.fiThoigianNhaptu) : null);
        self.fiThoigianNhapden = ko.observable(data.fiThoigianNhapden ? new Date(data.fiThoigianNhapden) : null);
        self.fiDiadiemTapket = ko.observable(data.fiDiadiemTapket ? data.fiDiadiemTapket : null);
        self.fiNgayDangkyTu = ko.observable(data.fiNgayDangkyTu ? new Date(data.fiNgayDangkyTu) : null);
        self.fiNgayDangkyDen = ko.observable(data.fiNgayDangkyDen ? new Date(data.fiNgayDangkyDen) : null);
        self.fiDiadiemLaymau = ko.observable(data.fiDiadiemLaymau ? data.fiDiadiemLaymau : null);
        self.fiNguoiLienhe = ko.observable(data.fiNguoiLienhe ? data.fiNguoiLienhe : null);

        self.fiSdtTochucNhap = ko.observable(data.fiSdtTochucNhap ? data.fiSdtTochucNhap : null);
        self.fiTochucNhapTrachnhiem = ko.observable(data.fiTochucNhapTrachnhiem ? data.fiTochucNhapTrachnhiem : null);
        self.fiDiachiNhapTrachnhiem = ko.observable(data.fiDiachiNhapTrachnhiem ? data.fiDiachiNhapTrachnhiem : null);
        self.fiSdtNhapTrachnhiem = ko.observable(data.fiSdtNhapTrachnhiem ? data.fiSdtNhapTrachnhiem : null);
        self.fiSoBill = ko.observable(data.fiSoBill ? data.fiSoBill : null);
        self.fiTenThuongnhanXk = ko.observable(data.fiTenThuongnhanXk ? data.fiTenThuongnhanXk : null);
        self.fiDiachiThuongnhanXk = ko.observable(data.fiDiachiThuongnhanXk ? data.fiDiachiThuongnhanXk : null);
        self.fiSdtThuongnhanXk = ko.observable(data.fiSdtThuongnhanXk ? data.fiSdtThuongnhanXk : null);
        self.fiXuatxuHh = ko.observable(data.fiXuatxuHh ? data.fiXuatxuHh : null);
        self.fiThoigianNkTu = ko.observable(data.fiThoigianNkTu ? new Date(data.fiThoigianNkTu) : null);
        self.fiThoigianNkDen = ko.observable(data.fiThoigianNkDen ? new Date(data.fiThoigianNkDen) : null);
        self.fiTgKiemtraTu = ko.observable(data.fiTgKiemtraTu ? new Date(data.fiTgKiemtraTu) : null);
        self.fiTgKiemtraDen = ko.observable(data.fiTgKiemtraDen ? new Date(data.fiTgKiemtraDen) : null);
        self.fiDiadiemKt = ko.observable(data.fiDiadiemKt ? data.fiDiadiemKt : null);

        self.fiDukienCqKt = ko.observable(data.fiDukienCqKt ? data.fiDukienCqKt : null);

        self.lstHanghoa = ko.observableArray(data.lstHanghoa04 ? data.lstHanghoa04 : []);
        self.lstHopdong = ko.observableArray(data.lstHopdong04 ? data.lstHopdong04 : []);

        if (self.fiMaLoaidon() == '1') {
            self.isViewXndTamKdtv(true);
            self.isViewXndTamXncl(false);
            self.isViewXndTamKdtvAttp(false);
            self.isViewXndTamAttp(false);
        } else if (self.fiMaLoaidon() == '2') {
            self.isViewXndTamKdtv(false);
            self.isViewXndTamXncl(true);
            self.isViewXndTamKdtvAttp(false);
            self.isViewXndTamAttp(false);
        } else if (self.fiMaLoaidon() == '3') {
            self.isViewXndTamKdtv(false);
            self.isViewXndTamXncl(false);
            self.isViewXndTamKdtvAttp(true);
            self.isViewXndTamAttp(false);
        } else if (self.fiMaLoaidon() == '4') {
            self.isViewXndTamKdtv(false);
            self.isViewXndTamXncl(false);
            self.isViewXndTamKdtvAttp(false);
            self.isViewXndTamAttp(true);
        } else {
            self.isViewXndTamKdtv(false);
            self.isViewXndTamXncl(false);
            self.isViewXndTamKdtvAttp(false);
            self.isViewXndTamAttp(false);
        }

        self.strNgayKy = ko.observable(null);
        var dt = self.fiNgayky();
        if (dt != null) {
            var d = (dt.getDate() >= 10) ? dt.getDate() : "0" + dt.getDate();
            var m = (dt.getMonth() >= 9) ? dt.getMonth() + 1 : "0" + (dt.getMonth() + 1);
            var y = dt.getFullYear();
            var strDateHtml = "Ngày <b>" + d + "</b> tháng <b>" + m + "</b> năm <b>" + y + "</b>";
            self.strNgayKy(strDateHtml);
        }

        self.fiHopdongMuabanText = ko.observable(null);
        self.fiHoadonMuabanText = ko.observable(null);
        self.fiPhieudongText = ko.observable(null);
        var hopdongStr = "";
        var hoadonStr = "";
        var phieudongStr = "";
        for (var i = 0; i < self.lstHopdong().length; i++) {
            if (self.lstHopdong()[i].fiMaLoaigiayto == 1) {
                var dt = new Date(self.lstHopdong()[i].fiNgaycapGiayto);
                if (dt != null) {
                    var d = (dt.getDate() >= 10) ? dt.getDate() : "0" + dt.getDate();
                    var m = (dt.getMonth() >= 10) ? dt.getMonth() : "0" + dt.getMonth();
                    var y = dt.getFullYear();
                    hopdongStr = "Số <b>" + self.lstHopdong()[i].fiSoHopdong + "</b> ngày <b>" + d + "/" + m + "/" + y + "</b>;";
                    self.fiHopdongMuabanText(hopdongStr);
                }
            }
            if (self.lstHopdong()[i].fiMaLoaigiayto == 2) {
                var dt1 = new Date(self.lstHopdong()[i].fiNgaycapGiayto);
                if (dt1 != null) {
                    var d1 = (dt1.getDate() >= 10) ? dt1.getDate() : "0" + dt1.getDate();
                    var m1 = (dt1.getMonth() >= 10) ? dt1.getMonth() : "0" + dt1.getMonth();
                    var y1 = dt1.getFullYear();
                    hoadonStr = "Số <b>" + self.lstHopdong()[i].fiSoHopdong + "</b> ngày <b>" + d1 + "/" + m1 + "/" + y1 + "</b>;";
                    self.fiHoadonMuabanText(hoadonStr);
                }
            }
            if (self.lstHopdong()[i].fiMaLoaigiayto == 3) {
                var dt2 = new Date(self.lstHopdong()[i].fiNgaycapGiayto);
                if (dt2 != null) {
                    var d2 = (dt2.getDate() >= 10) ? dt2.getDate() : "0" + dt2.getDate();
                    var m2 = (dt2.getMonth() >= 10) ? dt2.getMonth() : "0" + dt2.getMonth();
                    var y2 = dt2.getFullYear();
                    phieudongStr = "Số <b>" + self.lstHopdong()[i].fiSoHopdong + "</b> ngày <b>" + d2 + "/" + m2 + "/" + y2 + "</b>;";
                    self.fiPhieudongText(phieudongStr);
                }
            }
        }
        self.fiLoaiThucanText = ko.observable(self.fiMaLoaiThucan() == '1' ? 'Thức ăn chăn nuôi' : 'Thức ăn thủy sản');

        self.fiLoaiKtText = ko.observable(null);
        var loaiKtStr = "";
        if (self.fiMaLoaiKiemtra() == 1) {
            loaiKtStr = "2a";
        } else if (self.fiMaLoaiKiemtra() == 2) {
            loaiKtStr = "2b";
        } else if (self.fiMaLoaiKiemtra() == 3) {
            loaiKtStr = "2c";
        } else if (self.fiMaLoaiKiemtra() == 4) {
            loaiKtStr = "2d";
        }
        self.fiLoaiKtText(loaiKtStr);
    }
}