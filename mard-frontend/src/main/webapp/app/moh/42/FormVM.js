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
    
    var fiType = function () {
        var pName = document.location.pathname;
        var items = pName.split('/');
        return items[items.length - 2];
    };
    
    //Thong tin chung
    self.fiIdHoso = ko.observable(null);
    self.fiMaHoso = ko.observable(null);
    self.fiNgaynop = ko.observable(null);
    self.fiMucDichNk = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
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
    self.fiLoaiDon = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiMaThutuc = ko.observable(options.maThuTuc);
    self.fiTenThutuc = ko.observable(null);

    //doanhNghiep
    self.fiIdDn = ko.observable(null);
    self.fiMstDn = ko.observable(null);
    self.fiTenDn = ko.observable(null).extend({
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
    self.fiSoDk = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiMaHang = ko.observable(null);
    self.fiTenHang = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiLoaiHang = ko.observable(null);
    self.fiTenKhac = ko.observable(null);
    self.fiSoLuong = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        number: {message: 'Phải nhập số', params: true},
        maxLength: {message: 'Độ dài tối đa là 10', params: 10}
    });
    self.fiMaDvtinh = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiTenDvtinh = ko.observable(null);
    self.fiMaQgSx = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiTenQgSx = ko.observable(null);
    self.fiTenCoSoSx = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiGhiChu = ko.observable(null);
    self.fiMaQgCc = ko.observable(null);
    //self.fiHoatdong = ko.observable(null);
    //self.fiNguoitao = ko.observable(null);
    self.fiTenQgCc = ko.observable(null);
    self.fiTenCoSoCc = ko.observable(null);
    //self.fiNgaytao = ko.observable(null);
    //self.fiNgCapnhat = ko.observable(null);
    self.fiBoPhanDung = ko.observable(null);
    self.fiTccl = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiBaoChe = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiHoatChat = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiHamLuong = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiDongGoi = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiHanDung = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });

    self.lstNguyenLieus = ko.observableArray([]);
    self.lstDinhKems = ko.observableArray([]);
    self.lstCuaKhaus = ko.observableArray([]);
    self.lstGroupDinhKems = ko.observableArray([]);
    //Danh muc
    self.lstMucDichNhapKhau = ko.observableArray(mapCategory(options ? options.lstMucDichNhapKhau : [], 'fiMaMdnk', 'fiTenMdnk'));
    self.lstTinhThanh = ko.observableArray(mapCategory(options ? options.lstTinhThanh : [], 'fiMaTinh', 'fiTenTinh'));
    self.lstDonViTinh = ko.observableArray(mapCategory(options ? options.lstDonViTinh : [], 'fiMaDvtinh', 'fiTenDvtinh'));
    self.ltsNuocSanXuat = ko.observableArray(mapCategory(options ? options.ltsNuocSanXuat : [], 'fiMaQg', 'fiTenQg'));
    self.lstCuaKhauNhap = ko.observableArray(mapCategory(options ? options.lstCuaKhauNhap : [], 'fiMaCuakhau', 'fiTenCuakhau'));
    self.lstLoaiDonHang = ko.observableArray(mapCategory(options ? options.lstLoaiDonHang : [], 'fiMaLoaidon', 'fiTenLoaidon'));
    self.lstNguyenLieu = ko.observableArray(mapCategory(options ? options.lstNguyenLieu : [], 'fiMaNl', 'fiTenNl'));

    var hosoVG = [self.fiTenDn, self.fiMstDn, self.fiDiachiDn, self.fiMaTinh, self.fiMucDichNk, self.fiNguoiDd,
        , self.fiLoaiDon, self.fiTenHang, self.fiTenKhac, self.fiTccl,
        self.fiSoLuong, self.fiMaDvtinh, self.fiTenCoSoSx, self.fiMaQgSx,
        self.fiChucvuNgDd];
    if (fiType() === 34) {    
        hosoVG.push(self.fiTenCoSoCc);
        hosoVG.push(self.fiTenQgCc);       
    }

    self.hosoErrors = ko.validation.group(hosoVG, {deep: true, live: true, observable: true});
    self.errorNguyenLieuMessage = ko.observable(null);
    self.errorDinhKemMessage = ko.observable(null);
    self.visibleCuaKhau = ko.observable(false);

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

            //Cua khau du dinh nhap khau
            //TODO: lstCuaKhaus

            self.fiIdHoso(hoso.hasOwnProperty('fiIdHoso') ? hoso.fiIdHoso : null);
            self.fiMaHoso(hoso.hasOwnProperty('fiMaHoso') ? hoso.fiMaHoso : null);
            self.fiNgaynop(hoso.hasOwnProperty('fiNgaynop') ? new Date(hoso.fiNgaynop) : null);

            self.fiMucDichNk(hoso.hasOwnProperty('fiMucDichNk') ? hoso.fiMucDichNk : null);
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

            //Don hang
            self.fiIdDonhang(hoso.donHang.hasOwnProperty('fiIdDonhang') ? hoso.donHang.fiIdDonhang : null);
            self.fiSoDk(hoso.donHang.hasOwnProperty('fiSoDk') ? hoso.donHang.fiSoDk : null);
            self.fiMaHang(hoso.donHang.hasOwnProperty('fiMaHang') ? hoso.donHang.fiMaHang : null);
            self.fiTenHang(hoso.donHang.hasOwnProperty('fiTenHang') ? hoso.donHang.fiTenHang : null);
            self.fiLoaiHang(hoso.donHang.hasOwnProperty('fiLoaiHang') ? hoso.fiLoaiHang : null);
            self.fiTenKhac(hoso.donHang.hasOwnProperty('fiTenKhac') ? hoso.donHang.fiTenKhac : null);
            self.fiSoLuong(hoso.donHang.hasOwnProperty('fiSoLuong') ? hoso.donHang.fiSoLuong : null);
            self.fiMaDvtinh(hoso.donHang.hasOwnProperty('fiMaDvtinh') ? hoso.donHang.fiMaDvtinh : null);
            self.fiTenDvtinh(hoso.donHang.hasOwnProperty('fiTenDvtinh') ? hoso.donHang.fiTenDvtinh : null);
            self.fiMaQgSx(hoso.donHang.hasOwnProperty('fiMaQgSx') ? hoso.donHang.fiMaQgSx : null);
            self.fiTenQgSx(hoso.donHang.hasOwnProperty('fiTenQgSx') ? hoso.donHang.fiTenQgSx : null);
            self.fiTenCoSoSx(hoso.donHang.hasOwnProperty('fiTenCoSoSx') ? hoso.donHang.fiTenCoSoSx : null);
            self.fiGhiChu(hoso.donHang.hasOwnProperty('fiGhiChu') ? hoso.donHang.fiGhiChu : null);
            self.fiMaQgCc(hoso.donHang.hasOwnProperty('fiMaQgCc') ? hoso.donHang.fiMaQgCc : null);
            self.fiTenQgCc(hoso.donHang.hasOwnProperty('fiTenQgCc') ? hoso.donHang.fiTenQgCc : null);
            self.fiTenCoSoCc(hoso.donHang.hasOwnProperty('fiTenCoSoCc') ? hoso.donHang.fiTenCoSoCc : null);
            self.fiBoPhanDung(hoso.donHang.hasOwnProperty('fiBoPhanDung') ? hoso.donHang.fiBoPhanDung : null);
            self.fiTccl(hoso.donHang.hasOwnProperty('fiTccl') ? hoso.donHang.fiTccl : null);
            self.fiBaoChe(hoso.donHang.hasOwnProperty('fiBaoChe') ? hoso.donHang.fiBaoChe : null);
            self.fiHoatChat(hoso.donHang.hasOwnProperty('fiHoatChat') ? hoso.donHang.fiHoatChat : null);
            self.fiHamLuong(hoso.donHang.hasOwnProperty('fiHamLuong') ? hoso.donHang.fiHamLuong : null);
            self.fiDongGoi(hoso.donHang.hasOwnProperty('fiDongGoi') ? hoso.donHang.fiDongGoi : null);
            self.fiHanDung(hoso.donHang.hasOwnProperty('fiHanDung') ? hoso.donHang.fiHanDung : null);

            //self.lstNguyenLieus(mapTbdhsNglieu38(hoso.hasOwnProperty('lstNguyenLieus') ? hoso.lstNguyenLieus : []));
            self.lstDinhKems(mapTbdhsFile39(hoso.hasOwnProperty('lstDinhKems') ? hoso.lstDinhKems : []
                    , self.fiIdHoso()
                    , self));
            //self.lstCuaKhaus(mapTbdhsCuaKhau(hoso.hasOwnProperty('lstCuaKhaus') ? hoso.lstCuaKhaus : []));
        } else {
            self.lstDinhKems(mapFilesVM(options.lstDinhKems
                    , self.fiIdHoso()
                    , self));
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
        if (self.hosoErrors().length > 0) {
            self.hosoErrors.showAllMessages();
            errorHoso = false;
            return errorHoso;
        }

        //Kiem tra thong tin dinh kem
//        if (!self.lstDinhKems() || self.lstDinhKems().length <= 0) {
//            self.errorDinhKemMessage('* Chưa khai báo thông tin đính kèm');
//            errorDinhkem = false;
//            return errorDinhkem;
//        }

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

        return errorHoso && errorDinhkem;
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
        var item = new TbdhsNglieu38({
            fiStt: self.lstNguyenLieus().length + 1,
            fiIdNglieu: -1 * new Date().getTime()
        });
        self.lstNguyenLieus.push(item);
        for (var i = 0; i < self.lstNguyenLieus().length; i++) {
            self.lstNguyenLieus()[i].fiStt(i + 1);
        }
        $("#fiMaNglieu-" + item.fiStt()).select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
    };
    //XU LY SU KIEN BUTTON, TABLE

    //Convert to json object
    self.toJSON = function () {
        var exclude = ["xoaNguyenLieuClick", "themNguyenLieuClick", "isValidForm", "init",
            "hosoErrors", "errorNguyenLieuMessage", "errorDinhKemMessage", "lstMucDichNhapKhau", "lstTinhThanh", "lstDonViTinh",
            "toJSON", "ltsNuocSanXuat", "__ko_mapping__", 'lstCuaKhauNhap', 'lstLoaiDonHang', 'lstNguyenLieu',
            'pop', 'lstCuaKhaus', 'visibleCuaKhau'];
        
        self.fiTenQgSx($('#fiMaQgSx option:selected').text());
        self.fiTenQgCc($('#fiMaQgCc option:selected').text());
        self.fiTenTinh($('#fiMaTinh option:selected').text());
        self.fiTenDvtinh($('#fiMaDvtinh option:selected').text());
        
        var model = ko.toJS(self);

        var lstCuaKhau = [];
        for (var i = 0; i < model.lstCuaKhaus.length; i++) {
            var idx = model.lstCuaKhauNhap.Search('id', model.lstCuaKhaus[i]);
            if (idx >= 0) {
                lstCuaKhau.push({'fiMaCkhau': model.lstCuaKhaus[i], 'fiTenCkhau': model.lstCuaKhauNhap[idx].name});
            }
        }

        //
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
            fiChucvuNgDd: self.fiChucvuNgDd()
        };
        model.donHang = {
            fiIdDonhang: self.fiIdDonhang(),
            fiSoDk: self.fiSoDk(),
            fiMaHang: self.fiMaHang(),
            fiTenHang: self.fiTenHang(),
            fiLoaiHang: self.fiLoaiHang(),
            fiTenKhac: self.fiTenKhac(),
            fiSoLuong: self.fiSoLuong(),
            fiMaDvtinh: self.fiMaDvtinh(),
            fiTenDvtinh: self.fiTenDvtinh(),
            fiMaQgSx: self.fiMaQgSx(),
            fiTenQgSx: self.fiTenQgSx(),
            fiTenCoSoSx: self.fiTenCoSoSx(),
            fiGhiChu: self.fiGhiChu(),
            fiMaQgCc: self.fiMaQgCc(),
            //fiHoatdong: self.fiHoatdong,
            fiTenQgCc: self.fiTenQgCc(),
            fiTenCoSoCc: self.fiTenCoSoCc(),
            fiBoPhanDung: self.fiBoPhanDung(),
            fiTccl: self.fiTccl(),
            fiBaoChe: self.fiBaoChe(),
            fiHoatChat: self.fiHoatChat(),
            fiHamLuong: self.fiHamLuong(),
            fiDongGoi: self.fiDongGoi(),
            fiHanDung: self.fiHanDung()
        };
        
        var _exclude = ['fiBaoChe', 'fiBoPhanDung', 'fiChucvuNgDd',
                    'fiDiachiDn', 'fiDongGoi', 'fiGhiChu', 'fiTenCoSoSx',
                    'fiTenDvtinh', 'fiTenHang', 'fiTenKhac', 'fiMstDn',
                    'fiHamLuong', 'fiHanDung', 'fiHoatChat', 'fiIdDn',
                    'fiIdDonhang', 'fiLoaiHang', 'fiMaDvtinh', 'fiTenQgCc',
                    'fiTenQgSx', 'fiTenTinh', 'fiMstDn', 'fiNguoiDd',
                    'fiMaHang', 'fiMaQgCc', 'fiMaQgSx', 'fiMaTinh',
                    'fiSoDk', 'fiSoLuong', 'fiTccl', 'fiTenCoSoCc', 'fiTenDn'];
        for (var key in model) {
            if (_exclude.indexOf(key) >= 0) {
                delete model[key];
            }
        }
        delete model.lstGroupDinhKems;
        return model;
    };

    self.lstCuaKhaus.subscribe(function (newValue) {
        //console.log(newValue);
    });
}

