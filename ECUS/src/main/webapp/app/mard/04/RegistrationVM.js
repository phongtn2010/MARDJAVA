function RegistrationVM(options) {
    var self = this;
    var hoso = options.hoso;
    var registrationVM = options.registrationVM;

    self.isViewAttp = ko.observable(false);
    self.isViewCnkd = ko.observable(false);
    self.isViewCnkdAttp = ko.observable(false);
    self.isViewCnkdXncl = ko.observable(false);
    self.isViewCnkdXncl3 = ko.observable(false);
    self.isViewCnkdXncl4 = ko.observable(false);
    if (hoso !== null) {
        self.fiTenCqxl = ko.observable(hoso ? hoso.fiTenCqxl : null);
        self.fiTenTochuc = ko.observable(hoso ? hoso.fiTenTochuc : null);
        self.fiDiachiTochuc = ko.observable(hoso ? hoso.fiDiachiTochuc : null);
        self.fiCmnd = ko.observable(hoso ? hoso.fiCmnd : null);
        self.fiNgaycapCmnd = ko.observable(hoso ? new Date(hoso.fiNgaycapCmnd) : null);
        self.fiNoicap = ko.observable(hoso ? hoso.fiNoicapCmnd : null);
        self.fiDienthoai = ko.observable(hoso ? hoso.fiSdtTochuc : null);
        self.fiEmail = ko.observable(hoso ? hoso.fiFaxEmail : null);

        self.fiNgaykyHs = ko.observable(hoso ? new Date(hoso.fiNgayky) : null);
        self.fiNguoiky = ko.observable(hoso ? hoso.fiNguoiky : null);
        self.fiChucdanh = ko.observable(hoso ? hoso.fiChucvu : null);
        self.fiDiadiemky = ko.observable(hoso ? hoso.fiNoiky : null);

        self.lstHanghoa = ko.observable((mapTbdHanghoa04(hoso ? hoso.lstHanghoa04 : [])));

        self.fiMaLoaidon = ko.observable(hoso ? hoso.fiMaLoaidon : null);
        self.fiMaLoaiKiemtra = ko.observable(hoso ? hoso.fiMaLoaiKiemtra : null);

        if (self.fiMaLoaidon() == '1') {
            self.isViewCnkd(true);
            self.isViewAttp(false);
            self.isViewCnkdAttp(false);
            self.isViewCnkdXncl(false);
            self.isViewCnkdXncl3(false);
            self.isViewCnkdXncl4(false);
        } else if ((self.fiMaLoaidon() == '2') && (self.fiMaLoaiKiemtra() == 1 || self.fiMaLoaiKiemtra() == 2)) {
            self.isViewCnkdXncl(true);
            self.isViewCnkd(false);
            self.isViewAttp(false);
            self.isViewCnkdAttp(false);
            self.isViewCnkdXncl3(false);
            self.isViewCnkdXncl4(false);
        } else if ((self.fiMaLoaidon() == '2') && (self.fiMaLoaiKiemtra() == 3)) {
            self.isViewCnkdXncl3(true);
            self.isViewCnkdXncl(false);
            self.isViewCnkd(false);
            self.isViewAttp(false);
            self.isViewCnkdAttp(false);
            self.isViewCnkdXncl4(false);
        } else if ((self.fiMaLoaidon() == '2') && (self.fiMaLoaiKiemtra() == 4)) {
            self.isViewCnkdXncl4(true);
            self.isViewCnkdXncl(false);
            self.isViewCnkd(false);
            self.isViewAttp(false);
            self.isViewCnkdAttp(false);
            self.isViewCnkdXncl3(false);
        } else if ((self.fiMaLoaidon() == '3')) {
            self.isViewCnkdAttp(true);
            self.isViewCnkdXncl(false);
            self.isViewCnkd(false);
            self.isViewAttp(false);
            self.isViewCnkdXncl3(false);
            self.isViewCnkdXncl4(false);
        } else if ((self.fiMaLoaidon() == '4')) {
            self.isViewAttp(true);
            self.isViewCnkdXncl(false);
            self.isViewCnkd(false);
            self.isViewCnkdAttp(false);
            self.isViewCnkdXncl3(false);
            self.isViewCnkdXncl4(false);
        }

    }
    if (registrationVM) {
        self.fiId = ko.observable(registrationVM ? registrationVM.fiId : null);
        self.fiIdHoso = ko.observable(registrationVM ? registrationVM.fiIdHoso : null);
        self.fiMaHoso = ko.observable(registrationVM ? registrationVM.fiMaHoso : null);
        self.fiSoXndon = ko.observable(registrationVM ? registrationVM.fiSoXndon : null);
        self.fiSo = ko.observable(registrationVM ? registrationVM.fiSo : null);
        self.fiLoaiThucan = ko.observable(registrationVM ? registrationVM.fiLoaiThucan : null);
        self.fiYcKtra = ko.observable(registrationVM ? registrationVM.fiYcKtra : null);
        self.fiGiayDki = ko.observable(registrationVM ? registrationVM.fiGiayDki : null);
        self.fiHopdong = ko.observable(registrationVM ? registrationVM.fiHopdong : null);
        self.fiDanhmuc = ko.observable(registrationVM ? registrationVM.fiDanhmuc : null);
        self.fiBansao = ko.observable(registrationVM ? registrationVM.fiBansao : null);
        self.fiGiayHopquy = ko.observable(registrationVM ? registrationVM.fiGiayHopquy : null);
        self.fiGiayChungnhan = ko.observable(registrationVM ? registrationVM.fiGiayChungnhan : null);
        self.fiGiayGiamdinh = ko.observable(registrationVM ? registrationVM.fiGiayGiamdinh : null);
        self.fiGiayHethong = ko.observable(registrationVM ? registrationVM.fiGiayHethong : null);
        self.fiHoadon = ko.observable(registrationVM ? registrationVM.fiHoadon : null);
        self.fiVandon = ko.observable(registrationVM ? registrationVM.fiVandon : null);
        self.fiTokhai = ko.observable(registrationVM ? registrationVM.fiTokhai : null);
        self.fiGiayXuatxu = ko.observable(registrationVM ? registrationVM.fiGiayXuatxu : null);
        self.fiMotaHanghoa = ko.observable(registrationVM ? registrationVM.fiMotaHanghoa : null);
        self.fiGiayCfs = ko.observable(registrationVM ? registrationVM.fiGiayCfs : null);
        self.fiMaunhan = ko.observable(registrationVM ? registrationVM.fiMaunhan : null);
        self.fiNhanphu = ko.observable(registrationVM ? registrationVM.fiNhanphu : null);
        self.fiDiadiem = ko.observable(registrationVM ? registrationVM.fiDiadiem : null);
        self.fiThoigian = ko.observable(registrationVM ? new Date(registrationVM.fiThoigian) : null);
        self.fiNgayky = ko.observable(registrationVM ? new Date(registrationVM.fiNgayky) : null);
        self.fiNguoikyDon = ko.observable(registrationVM ? registrationVM.fiNguoiky : null);
        self.fiChucvu = ko.observable(registrationVM ? registrationVM.fiChucvu : null);
        self.fiHoatdong = ko.observable(registrationVM ? registrationVM.fiHoatdong : null);
        self.fiNgaytao = ko.observable(registrationVM ? new Date(registrationVM.fiNgaytao) : null);
        self.fiNguoitao = ko.observable(registrationVM ? registrationVM.fiNguoitao : null);
        self.fiHosoDaydu = ko.observable(registrationVM ? registrationVM.fiHosoDaydu : null);
        self.fiHosoKdaydu = ko.observable(registrationVM ? registrationVM.fiHosoKdaydu : null);
        self.fiTiepnhan = ko.observable(registrationVM ? registrationVM.fiTiepnhan : null);

        // xác nhận đơn cntp
        self.fiTenNkCntp = ko.observable(hoso ? hoso.fiTochucNhap : null);
        self.fiDiachiNkCntp = ko.observable(hoso ? hoso.fiDiachiNhap : null);
        self.fiDienthoaiNkCntp = ko.observable(hoso ? hoso.fiSdtTochucNhap : null);
        self.fiTenTnCntp = ko.observable(hoso ? hoso.fiTochucNhapTrachnhiem : null);
        self.fiDiachiTnCntp = ko.observable(hoso ? hoso.fiDiachiNhapTrachnhiem : null);
        self.fiDienthoaiTnCntp = ko.observable(hoso ? hoso.fiSdtNhapTrachnhiem : null);
        self.fiSoHopdongCntp = ko.observable(hoso ? hoso.fiSoHopdong : null);
        self.fiSobillCntp = ko.observable(hoso ? hoso.fiSoBill : null);
        self.fiTenXkCntp = ko.observable(hoso ? hoso.fiTenThuongnhanXk : null);
        self.fiDiachiXkCntp = ko.observable(hoso ? hoso.fiDiachiThuongnhanXk : null);
        self.fiDienthoaiXkCntp = ko.observable(hoso ? hoso.fiSdtThuongnhanXk : null);
        self.fiXuatxuCntp = ko.observable(hoso ? hoso.fiXuatxuHh : null);
        self.fiTenNuocCntp = ko.observable(hoso ? hoso.fiTennuocXk : null);
        self.fiNgaytuCntp = ko.observable(hoso ? new Date(hoso.fiThoigianNkTu) : null);
        self.fiNgaydenCntp = ko.observable(hoso ? new Date(hoso.fiThoigianNkDen) : null);
        self.fiTenCkxuatCntp = ko.observable(hoso ? hoso.fiTenCuakhauXuat : null);
        self.fiTenCknhapCntp = ko.observable(hoso ? hoso.fiTenCuakhauNhap : null);
        self.fiNgaykiemTuCntp = ko.observable(hoso ? new Date(hoso.fiTgKiemtraTu) : null);
        self.fiNgaykiemDenCntp = ko.observable(hoso ? new Date(hoso.fiTgKiemtraDen) : null);
        self.fiDiadiemCntp = ko.observable(hoso ? hoso.fiDiadiemKt : null);
        self.fiTenPtienCntp = ko.observable(hoso ? hoso.fiTenPhuongtien : null);
        self.fiMucdichCntp = ko.observable(hoso ? hoso.fiMucdichSd : null);
        self.fiGpKiemdichCntp = ko.observable(hoso ? hoso.fiGiayphepKd : null);
        self.fiSobanCntp = ko.observable(hoso ? hoso.fiSoGcn : null);
        self.fiNoidenCntp = ko.observable(hoso ? hoso.fiNoihangDen : null);

        // xác nhận đơn attp
        self.fiChuhang = ko.observable(hoso ? hoso.fiTenTochuc : null);
        self.fiTenTnAttp = ko.observable(hoso ? hoso.fiTochucNhapTrachnhiem : null);
        self.fiDiachiTnAttp = ko.observable(hoso ? hoso.fiDiachiNhapTrachnhiem : null);
        self.fiDienthoaiTnAttp = ko.observable(hoso ? hoso.fiSdtNhapTrachnhiem : null);
        self.fiTenTnxkAttp = ko.observable(hoso ? hoso.fiTenThuongnhanXk : null);
        self.fiDiachiTnxkAttp = ko.observable(hoso ? hoso.fiDiachiThuongnhanXk : null);
        self.fiDienthoaiTnxkAttp = ko.observable(hoso ? hoso.fiSdtThuongnhanXk : null);
        self.fiNgaytuNKAttp = ko.observable(hoso ? new Date(hoso.fiThoigianNkTu) : null);
        self.fiNgaydenNKAttp = ko.observable(hoso ? new Date(hoso.fiThoigianNkDen) : null);
        self.fiTenCuakhauDiAttp = ko.observable(hoso ? hoso.fiTenCuakhauNhap : null);
        self.fiTenCuakhauDenAttp = ko.observable(hoso ? hoso.fiTenCuakhauXuat : null);
        self.fiNgaytuAttp = ko.observable(hoso ? new Date(hoso.fiTgKiemtraTu) : null);
        self.fiNgaydenAttp = ko.observable(hoso ? new Date(hoso.fiTgKiemtraDen) : null);
        self.fiDiadiemKiemtraAttp = ko.observable(hoso ? hoso.fiDiadiemKt : null);
        self.fiCqKiemtraAttp = ko.observable(hoso ? hoso.fiDukienCqKt : null);

        // xác nhận đơn xncl
        self.fiSoDkTochuc = ko.observable(hoso ? hoso.fiSoDkTochuc : null); // dung cho don xncl va attp
        self.fiHangXncl = ko.observable(hoso ? hoso.fiHang : null);
        self.fiDcBanXncl = ko.observable(hoso ? hoso.fiDiachiBenban : null);
        self.fiSdtBanXncl = ko.observable(hoso ? hoso.fiSdtBenban : null);
        self.fiFaxBanXncl = ko.observable(hoso ? hoso.fiFaxBenban : null);
        self.fiNoiXuatXncl = ko.observable(hoso ? hoso.fiNoiXuathang : null);
        self.fiBenMuaXncl = ko.observable(hoso ? hoso.fiBenMuahang : null);
        self.fiCmndMua = ko.observable(hoso ? hoso.fiCmndBenmua : null);
        self.fiNgaycapMua = ko.observable(hoso ? new Date(hoso.fiNgaycapCmndBenmua) : null);
        self.fiNoicapMua = ko.observable(hoso ? hoso.fiNoicapCmndBenmua : null);
        self.fiDcMuaXncl = ko.observable(hoso ? hoso.fiDiachiBenmua : null);
        self.fiSdtMuaXncl = ko.observable(hoso ? hoso.fiSdtBenmua : null);
        self.fiFaxMuaXncl = ko.observable(hoso ? hoso.fiFaxBenmua : null);
        self.fiNoiNhanXncl = ko.observable(hoso ? hoso.fiTencangNoinhan : null);
        self.fiNgaytuXncl = ko.observable(hoso ? new Date(hoso.fiThoigianNhaptu) : null);
        self.fiNgaydenXncl = ko.observable(hoso ? new Date(hoso.fiThoigianNhapden) : null);
        self.fiMucdichXncl = ko.observable(hoso ? hoso.fiMucdichSd : null);
        self.fiGiayphepXncl = ko.observable(hoso ? hoso.fiGiayphepKd : null);
        self.fiDiadiemXncl = ko.observable(hoso ? hoso.fiDiadiemKd : null);
        self.fiDkTungayXncl = ko.observable(hoso ? new Date(hoso.fiNgayDangkyTu) : null);
        self.fiDkDenngayXncl = ko.observable(hoso ? new Date(hoso.fiNgayDangkyDen) : null);
        self.fiDiadiemDkXncl = ko.observable(hoso ? hoso.fiDiadiemLaymau : null);
        self.fiNgLienheXncl = ko.observable(hoso ? hoso.fiNguoiLienhe : null);
        self.fiDiadiemTapketXncl = ko.observable(hoso ? hoso.fiDiadiemTapket : null);
        self.lstHopdong = ko.observable((mapTbdHopdong04(hoso && hoso.lstHopdong04 ? hoso.lstHopdong04 : [])));
        self.fiHopdongMuabanText = ko.observable(null);
        self.fiHoadonMuabanText = ko.observable(null);
        self.fiPhieudongText = ko.observable(null);
        var hopdongStr = "";
        var hoadonStr = "";
        var phieudongStr = "";
        for (var i = 0; i < self.lstHopdong().length; i++) {
            if (self.lstHopdong()[i].fiMaLoaigiayto() == 1) {
                var dt = new Date(self.lstHopdong()[i].fiNgaycapGiayto());
                var d = (dt.getDate() >= 10) ? dt.getDate() : "0" + dt.getDate();
                var m = (dt.getMonth() >= 10) ? dt.getMonth() : "0" + dt.getMonth();
                var y = dt.getFullYear();
                hopdongStr = "Số <b>" + self.lstHopdong()[i].fiSoHopdong() + "</b> ngày <b>" + d + "/" + m + "/" + y + "</b>;";
            }
            if (self.lstHopdong()[i].fiMaLoaigiayto() == 2) {
                var dt1 = new Date(self.lstHopdong()[i].fiNgaycapGiayto());
                var d1 = (dt1.getDate() >= 10) ? dt1.getDate() : "0" + dt1.getDate();
                var m1 = (dt1.getMonth() >= 10) ? dt1.getMonth() : "0" + dt1.getMonth();
                var y1 = dt1.getFullYear();
                hoadonStr = "Số <b>" + self.lstHopdong()[i].fiSoHopdong() + "</b> ngày <b>" + d1 + "/" + m1 + "/" + y1 + "</b>;";
            }
            if (self.lstHopdong()[i].fiMaLoaigiayto() == 3) {
                var dt2 = new Date(self.lstHopdong()[i].fiNgaycapGiayto());
                var d2 = (dt2.getDate() >= 10) ? dt2.getDate() : "0" + dt2.getDate();
                var m2 = (dt2.getMonth() >= 10) ? dt2.getMonth() : "0" + dt2.getMonth();
                var y2 = dt2.getFullYear();
                phieudongStr = "Số <b>" + self.lstHopdong()[i].fiSoHopdong() + "</b> ngày <b>" + d2 + "/" + m2 + "/" + y2 + "</b>;";
            }
        }
        self.fiHopdongMuabanText(hopdongStr);
        self.fiHoadonMuabanText(hoadonStr);
        self.fiPhieudongText(phieudongStr);
        self.fiLoaiThucanText = ko.observable(self.fiLoaiThucan() == '1' ? 'Thức ăn chăn nuôi' : 'Thức ăn thủy sản');
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

        // xác nhận đơn cnkd
        self.fiCososxCnkd = ko.observable(hoso ? hoso.fiTenCosoSx : null);
        self.fiMasoCnkd = ko.observable(hoso ? hoso.fiMaCosoSx : null);
        self.fiDiachiCosoCnkd = ko.observable(hoso ? hoso.fiDiachiSx : null);
        self.fiSoHopdongCnkd = ko.observable(hoso ? hoso.fiSoHopdong : null);
        self.fiTochucCnkd = ko.observable(hoso ? hoso.fiTochucXk : null);
        self.fiDiachiTochucCnkd = ko.observable(hoso ? hoso.fiDiachiXk : null);
        self.fiTenNuocxkCnkd = ko.observable(hoso ? hoso.fiTennuocXk : null);
        self.fiTenCuakhauXuatCnkd = ko.observable(hoso ? hoso.fiTenCuakhauXuat : null);
        self.fiTochucNkCnkd = ko.observable(hoso ? hoso.fiTochucNhap : null);
        self.fiDiachiNkCnkd = ko.observable(hoso ? hoso.fiDiachiNhap : null);
        self.fiTenCuakhauNhapCnkd = ko.observable(hoso ? hoso.fiTenCuakhauNhap : null);
        self.fiTenPhuongtienCnkd = ko.observable(hoso ? hoso.fiTenPhuongtien : null);
        self.fiMucdichCnkd = ko.observable(hoso ? hoso.fiMucdichSd : null);
        self.fiGiayphepCnkd = ko.observable(hoso ? hoso.fiGiayphepKd : null);
        self.fiDiadiemKiemdichCnkd = ko.observable(hoso ? hoso.fiDiadiemKd : null);
        self.fiNgayKiemdichCnkd = ko.observable(hoso ? new Date(hoso.fiThoigianKd) : null);
        self.fiSobanCnkd = ko.observable(hoso ? hoso.fiSoGcn : null);
        self.fiNoidenCnkd = ko.observable(hoso ? hoso.fiNoihangDen : null);

        self.samplingDateStr = ko.observable(null);
        var dt = self.fiThoigian();
        var hh = (dt.getHours() >= 10) ? dt.getHours() : "0" + dt.getHours();
        var mm = (dt.getMinutes() >= 10) ? dt.getMinutes() : "0" + dt.getMinutes();
        var d = (dt.getDate() >= 10) ? dt.getDate() : "0" + dt.getDate();
        var m = (dt.getMonth() >= 9) ? dt.getMonth() + 1 : "0" + (dt.getMonth() + 1);
        var y = dt.getFullYear();
        var strDateHtml = "<b> " + hh + "</b> giờ <b> " + mm + ", </b> ngày <b>" + d + "</b> tháng <b>" + m + "</b> năm <b>" + y + "</b>";
        self.samplingDateStr(strDateHtml);

        self.signDateDepStr = ko.observable(null);
        var dt = self.fiThoigian();
        var d = (dt.getDate() >= 10) ? dt.getDate() : "0" + dt.getDate();
        var m = (dt.getMonth() >= 9) ? dt.getMonth() + 1 : "0" + (dt.getMonth() + 1);
        var y = dt.getFullYear();
        var strDateHtml = "Ngày <b>" + d + "</b> tháng <b>" + m + "</b> năm <b>" + y + "</b>";
        self.signDateDepStr(strDateHtml);

        self.strNgayKy = ko.observable(null);
        var dt = self.fiNgayky();
        var d = (dt.getDate() >= 10) ? dt.getDate() : "0" + dt.getDate();
        var m = (dt.getMonth() >= 9) ? dt.getMonth() + 1 : "0" + (dt.getMonth() + 1);
        var y = dt.getFullYear();
        var strDateHtml = "Ngày <b>" + d + "</b> tháng <b>" + m + "</b> năm <b>" + y + "</b>";
        self.strNgayKy(strDateHtml);

        self.quarantineHourStr = ko.observable(null);
        var dt = self.fiThoigian();
        var h = (dt.getHours() >= 10) ? dt.getHours() : "0" + dt.getHours();
        var p = (dt.getMinutes() >= 10) ? dt.getMinutes() : "0" + dt.getMinutes();
        var strDateHtml = "<b>" + h + "</b> giờ<b>" + p + "</b>";
        self.quarantineHourStr(strDateHtml);

        self.signDateStr = ko.observable(null);
        var dt = self.fiNgaykyHs();
        var d = (dt.getDate() >= 10) ? dt.getDate() : "0" + dt.getDate();
        var m = (dt.getMonth() >= 9) ? dt.getMonth() + 1 : "0" + (dt.getMonth() + 1);
        var y = dt.getFullYear();
        var strDateHtml = "Ngày <b>" + d + "</b> tháng <b>" + m + "</b> năm <b>" + y + "</b>";
        self.signDateStr(strDateHtml);

    }


    self.btnTroLaiClick = function () {
        History.go(-1);
    };


}

$(document).ready(function () {
    var options = app.parseQuerystring();
    var init = function () {
        debugger;
        if (options && options.fiIdHoso > 0) {
            var url = '/mard/p04/hoso/t/' + options.fiIdHoso;
            var url_result = '/mard/p04/hoso/xacnhandon/' + options.fiMaHoso;
            app.makePost({
                url: url,
                data: JSON.stringify({}),
                success: function (d) {
                    if (d.success) {
                        options.hoso = d.data;
                        app.makePost({
                            url: url_result,
                            data: JSON.stringify({}),
                            success: function (obj) {
                                if (obj.success) {
                                    if (obj.data != null) {
                                        debugger;
                                        options.registrationVM = obj.data;
                                        var registrationVM = new RegistrationVM(options);
                                        ko.applyBindings(registrationVM, document.getElementById('RegistrationVM'));
                                    }
                                }
                            },
                            error: function (e) {
                                app.Alert('Không lấy được dữ liệu đơn');
                                var registrationVM = new RegistrationVM(options);
                                ko.applyBindings(registrationVM, document.getElementById('RegistrationVM'));
                            }
                        });
                    }
                },
                error: function (e) {
                    app.Alert('Không lấy được dữ liệu hồ sơ');
                }
            });
        }
    };
    init();
});
