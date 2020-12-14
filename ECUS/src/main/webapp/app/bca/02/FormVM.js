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
    self.fiMst = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 13 ký tự', params: 13}
    });

    self.fiTenDn = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });

    self.fiDiachiDn = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });

    self.fiSoDondk = ko.observable(null).extend({
        maxLength: {message: 'Tối đa 50 ký tự', params: 50}
    });

    self.fiMaCoquan = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 50 ký tự', params: 50}
    });

    self.fiTenCoquan = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });

    self.fiNguoiDaidien = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 100 ký tự', params: 100}
    });
    self.fiChucvuDaidien = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 50 ký tự', params: 50}
    });
    self.fiSoCmnd = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 50 ký tự', params: 50}
    });
    self.fiNgaycapCmnd = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiNoicapCmnd = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiHoadonSo = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 500 ký tự', params: 500}
    });
    self.fiHoadonNgay = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiHoadonTencqc = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 500 ký tự', params: 500}
    });
    self.fiTenHanghoa = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 500 ký tự', params: 500}
    });
    self.fiHanhtrinhvcTu = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 500 ký tự', params: 500}
    });
    self.fiHanhtrinhvcQua = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 500 ký tự', params: 500}
    });
    self.fiHanhtrinhvcDen = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 500 ký tự', params: 500}
    });
    self.fiThoigianvcTu = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiThoigianvcDen = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiNgayky = ko.observable(null);
    self.fiNguoiky = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiDiadiemky = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiSdt = ko.observable(null);


    self.fiNgaygui = ko.observable(null);
    self.fiHoatdong = ko.observable(1);
    self.fiNguoitao = ko.observable(null);
    self.fiNgaytao = ko.observable(null);
    self.fiNgCapnhat = ko.observable(null);
    self.fiTrangthai = ko.observable(0);
    self.fiTenTt = ko.observable(null);

    self.fiSoGp = ko.observable(null);
    self.fiNgaycapGp = ko.observable(null).extend({
        pattern: '[0-9]{2}/[0-9]{2}/[0-9]{4}'
    });

    self.fiIdHosocha = ko.observable(null);
    self.fiIsHosotam = ko.observable(null);

    self.lstNguoiDieukhien = ko.observableArray([]);
    self.lstDinhKem = ko.observableArray([]);

    self.fiLydo = ko.observable(null).extend({
        maxLength: {message: 'Tối đa 2000 ký tự', params: 50}
    });

    self.visibleLyDoXinSua = ko.observable(false);

    //Danh muc
    self.lstLoainguoi = ko.observableArray(mapCategory(options ? options.lstLoainguoi : [], "id", "name"));
    self.lstDonvi = ko.observableArray(mapCategory(options ? options.lstDonvi : [], "id", "name"));
    self.lstCqxl = ko.observableArray(mapCategory(options ? options.lstCqxl : [], "fiMaCqxl", "fiTenCqxl"));

    var hosoVG = [self.fiMst, self.fiTenDn, self.fiDiachiDn, self.fiSoDondk, self.fiMaCoquan, self.fiTenCoquan,
        self.fiNguoiDaidien, self.fiChucvuDaidien, self.fiSoCmnd, self.fiNgaycapCmnd, self.fiNoicapCmnd, self.fiHoadonSo,
        self.fiHoadonNgay, self.fiHoadonTencqc, self.fiTenHanghoa, self.fiHanhtrinhvcTu, self.fiHanhtrinhvcQua,
        self.fiHanhtrinhvcDen, self.fiThoigianvcTu, self.fiThoigianvcDen, self.fiNguoiky, self.fiDiadiemky];

    self.hosoErrors = ko.validation.group(hosoVG, {deep: true, live: true, observable: true});
    self.errorHHMessage = ko.observable(null);
    self.errorDinhKemMessage = ko.observable(null);
    self.errorNguoiDkMessage = ko.observable(null);
    //Khoi tao gia tri ho so
    self.init = function (hoso) {
        self.fiTenDn(hoso !== null && hoso.hasOwnProperty('fiTenDn') ? hoso.fiTenDn : user.companyName);
        self.fiMst(hoso !== null && hoso.hasOwnProperty('fiMst') ? hoso.fiMst : user.username);
        self.fiDiachiDn(hoso !== null && hoso.hasOwnProperty('fiDiachiTsc') ? hoso.fiDiachiTsc : user.companyAddress);
        self.fiSdt(hoso !== null && hoso.hasOwnProperty('fiSdt') ? hoso.fiSdt : user.companyPhoneNumber);

        if (hoso !== null) {

            self.fiIdHoso(hoso.hasOwnProperty('fiIdHoso') ? hoso.fiIdHoso : null);
            self.fiMaHoso(hoso.hasOwnProperty('fiMaHoso') ? hoso.fiMaHoso : null);

            self.fiSoDondk(hoso.hasOwnProperty('fiSoDondk') ? hoso.fiSoDondk : null);
            self.fiMaCoquan(hoso.hasOwnProperty('fiMaCoquan') ? hoso.fiMaCoquan : null);
            self.fiTenCoquan(hoso.hasOwnProperty('fiTenCoquan') ? hoso.fiTenCoquan : null);
            self.fiNguoiDaidien(hoso.hasOwnProperty('fiNguoiDaidien') ? hoso.fiNguoiDaidien : null);
            self.fiChucvuDaidien(hoso.hasOwnProperty('fiChucvuDaidien') ? hoso.fiChucvuDaidien : null);
            self.fiSoCmnd(hoso.hasOwnProperty('fiSoCmnd') ? hoso.fiSoCmnd : null);
            self.fiNgaycapCmnd(hoso.hasOwnProperty('fiNgaycapCmnd') ? new Date(hoso.fiNgaycapCmnd) : null);
            self.fiNoicapCmnd(hoso.hasOwnProperty('fiNoicapCmnd') ? hoso.fiNoicapCmnd : null);
            self.fiHoadonSo(hoso.hasOwnProperty('fiHoadonSo') ? hoso.fiHoadonSo : null);
            self.fiHoadonNgay(hoso.hasOwnProperty('fiHoadonNgay') ? new Date(hoso.fiHoadonNgay) : null);
            self.fiHoadonTencqc(hoso.hasOwnProperty('fiHoadonTencqc') ? hoso.fiHoadonTencqc : null);
            self.fiTenHanghoa(hoso.hasOwnProperty('fiTenHanghoa') ? hoso.fiTenHanghoa : null);
            self.fiHanhtrinhvcTu(hoso.hasOwnProperty('fiHanhtrinhvcTu') ? hoso.fiHanhtrinhvcTu : null);
            self.fiHanhtrinhvcQua(hoso.hasOwnProperty('fiHanhtrinhvcQua') ? hoso.fiHanhtrinhvcQua : null);
            self.fiHanhtrinhvcDen(hoso.hasOwnProperty('fiHanhtrinhvcDen') ? hoso.fiHanhtrinhvcDen : null);
            self.fiThoigianvcTu(hoso.hasOwnProperty('fiThoigianvcTu') ? new Date(hoso.fiThoigianvcTu) : null);
            self.fiThoigianvcDen(hoso.hasOwnProperty('fiThoigianvcDen') ? new Date(hoso.fiThoigianvcDen) : null);
            self.fiNgayky(hoso.hasOwnProperty('fiNgayky') ? new Date(hoso.fiNgayky) : null);
            self.fiNguoiky(hoso.hasOwnProperty('fiNguoiky') ? hoso.fiNguoiky : null);
            self.fiDiadiemky(hoso.hasOwnProperty('fiDiadiemky') ? hoso.fiDiadiemky : null);

            self.fiNgaygui(hoso.hasOwnProperty('fiNgaygui') ? new Date(hoso.fiNgaygui) : null);
            self.fiHoatdong(hoso.hasOwnProperty('fiHoatdong') ? hoso.fiHoatdong : null);
            self.fiNguoitao(hoso.hasOwnProperty('fiNguoitao') ? hoso.fiNguoitao : null);
            self.fiNgaytao(hoso.hasOwnProperty('fiNgaytao') ? new Date(hoso.fiNgaytao) : null);
            self.fiNgCapnhat(hoso.hasOwnProperty('fiNgCapnhat') ? hoso.fiNgCapnhat : null);
            self.fiTrangthai(hoso.hasOwnProperty('fiTrangthai') ? hoso.fiTrangthai : null);
            self.fiTenTt(hoso.hasOwnProperty('fiTenTt') ? hoso.fiTenTt : null);
            self.fiSoGp(hoso.hasOwnProperty('fiSoGp') ? hoso.fiSoGp : null);
            self.fiNgaycapGp(hoso.hasOwnProperty('fiNgaycapGp') ? new Date(hoso.fiNgaycapGp) : null);
            self.fiIdHosocha(hoso.hasOwnProperty('fiIdHosocha') ? hoso.fiIdHosocha : null);
            self.fiIsHosotam(hoso.hasOwnProperty('fiIsHosotam') ? hoso.fiIsHosotam : null);


            self.lstNguoiDieukhien(mapTbdhsNguoidk02(hoso.hasOwnProperty('lstNguoiDieukhien') ? hoso.lstNguoiDieukhien : []));
            self.lstDinhKem(mapFilesVM(hoso.hasOwnProperty('lstDinhKem') ? hoso.lstDinhKem : [], self.fiIdHoso()));
            self.fiLydo(hoso.hasOwnProperty('fiLydo') ? hoso.fiLydo : null);

        } else {
            self.lstDinhKem(mapFilesVM(options.lstDinhkems, self.fiIdHoso()));
        }
    };

    self.init(hosoInfo);
    
    self.changeValidDate = function(){
        if(self.fiNgaycapCmnd()===null) $("#fiNgaycapCmnd-lbl").show();
        else $("#fiNgaycapCmnd-lbl").hide();
        
        if(self.fiHoadonNgay()===null) $("#fiHoadonNgay-lbl").show();
        else $("#fiHoadonNgay-lbl").hide();
        
        if(self.fiThoigianvcTu()===null) $("#fiThoigianvcTu-lbl").show();
        else $("#fiThoigianvcTu-lbl").hide();
        
        if(self.fiThoigianvcDen()===null) $("#fiThoigianvcDen-lbl").show();
        else $("#fiThoigianvcDen-lbl").hide();
    }
    
    //VALIDATE DATA ON FORM
    //Remove from toJSON
    self.isValidForm = function () {
        //Kiem tra thong tin Ho so
        var errorHoso = true;
        var errorNguoiDk = true;
        var errorDinhkem = true;

        self.changeValidDate();

        self.errorDinhKemMessage(null);
        self.errorNguoiDkMessage(null);
        if (self.visibleLyDoXinSua()) {
            if (!self.fiLydo()) {
                app.Alert('Bạn phải nhập vào lý do xin sửa hồ sơ!');
                return false;
            }
        }
        
        if(self.validNguoiDKItem()===false){
            errorHoso = false;
        }
        
        if (self.hosoErrors().length > 0) {

            self.hosoErrors.showAllMessages();
            errorHoso = false;
            return errorHoso;
        }

//        
        //Kiem tra thong tin dinh kem
        if (!self.lstDinhKem() || self.lstDinhKem().length <= 0) {
            self.errorDinhKemMessage('* Chưa khai báo thông tin đính kèm');
            errorDinhkem = false;
            return errorDinhkem;
        }

        if (self.lstDinhKem() && self.lstDinhKem().length > 0) {
            for (var i = 0; i < self.lstDinhKem().length; i++) {
                var attach = self.lstDinhKem()[i];
                if (attach.isRequire()) {
                    if (!attach.fiGuiid() || !attach.fiTenTep() || !attach.fiDuongDan()) {
                        self.errorDinhKemMessage('* Cần bổ sung thêm file đính kèm!');
                        errorDinhkem = false;
                        break;
                    }
                }
            }
        }

        //Kiem tra thong tin nguoi dieu khien
        if (!self.lstNguoiDieukhien || self.lstNguoiDieukhien().length <= 0) {
            self.errorNguoiDkMessage('* Chưa khai báo đủ thông tin người điều khiển');
            errorNguoiDk = false;
            return errorNguoiDk;
        }
        
        

        return errorHoso && errorDinhkem;
//        return errorHoso;
    };
    //VALIDATE DATA ON FORM

    //XU LY SU KIEN BUTTON, TABLE
    self.removeNguoiDKOnClick = function (item) {
        if (item) {

            var pop = app.popup({
                title: 'Thông báo',
                html: '<b>Bạn chắc chắn muốn xoá dữ liệu của hàng hoá này?</b>',
                width: 450,
                buttons: [
                    {
                        name: NSWLang["common_button_toi_chac_chan"],
                        class: 'btn',
                        icon: 'fa-save',
                        action: function () {
                            self.lstNguoiDieukhien.remove(function (o) {
                                return o.fiId() == item.fiId();
                            });
                            for (var i = 0; i < self.lstNguoiDieukhien().length; i++) {
                                self.lstNguoiDieukhien()[i].STT(i + 1);
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
    self.addNguoiDK = function () {
        
        if(self.validNguoiDKItem()!=false){
            var item = new TbdhsNguoidk02({
                STT: self.lstNguoiDieukhien().length + 1,
                fiId: -1 * new Date().getTime(),
            });
            self.lstNguoiDieukhien.push(item);
            for (var i = 0; i < self.lstNguoiDieukhien().length; i++) {
                self.lstNguoiDieukhien()[i].STT(i + 1);
            }
        }
        
        
        
    };
    //tamdt
    self.validNguoiDKItem = function(){
        var flag = true;
        var ndkSize = self.lstNguoiDieukhien().length;
        if(ndkSize>0){
            var objLast = self.lstNguoiDieukhien()[ndkSize-1];
            
            //show lbl err (Loai,ten,cmnd,bks)
            if(objLast.fiLoai() === undefined) {
                flag = false;
                $("#fiLoai_lbl_"+ndkSize).show();
            }else $("#fiLoai_lbl_"+ndkSize).hide();
            
            if(objLast.fiTenNguoidk()===null) {
                flag = false;
                $("#fiTenNguoidk_lbl_"+ndkSize).show();
            }else $("#fiTenNguoidk_lbl_"+ndkSize).hide(); 
            
            if(objLast.fiSocmndNguoidk()===null) {
                flag = false;
                $("#fiSocmndNguoidk_lbl_"+ndkSize).show();
            }else $("#fiSocmndNguoidk_lbl_"+ndkSize).hide();
            
            if(objLast.fiBksPhuongtien()===null) {
                flag = false;
                $("#fiBksPhuongtien_lbl_"+ndkSize).show();
            }else $("#fiBksPhuongtien_lbl_"+ndkSize).hide();
            
            if(objLast.flagValid1()===false || objLast.flagValid2()===false || objLast.flagValid3()===false){
                flag = false;
            }
        }
        return flag;
    }

    self.addNguoiDKvalue = function () {
        for (var i = 0; i < self.lstNguoiDieukhien().length; i++) {
            if (self.lstNguoiDieukhien()[i].fiLoai() == null) {
                $('#fiLoaiErroor_' + (i + 1)).show();
                $('#valBKSErroor_' + (i + 1)).show();
                $('#valCMTErroor_' + (i + 1)).show();
                $('#valTNErroor_' + (i + 1)).show();
            }
        }
    }

    //XU LY SU KIEN BUTTON, TABLE

    //Convert to json object
    self.toJSON = function () {
        var mapping = {
            ignore: ['addNguoiDK', 'errorDinhKemMessage', 'errorHHMessage', 'hosoErrors', 'init', 'isValidForm', 'lstCqxl',
                'lstDonvi', 'lstLoainguoi', 'removeNguoiDKOnClick', 'toJSON', 'visibleLyDoXinSua']
        };


        var copy = ko.mapping.fromJS(self, mapping);
        copy = ko.toJS(copy);


        for (var i = 0; i < copy.lstDinhKem.length; i++) {
            delete copy.lstDinhKem[i]['canUpload'];
            delete copy.lstDinhKem[i]['canDownload'];
            delete copy.lstDinhKem[i]['canDelete'];
            delete copy.lstDinhKem[i]['doUpload'];
            delete copy.lstDinhKem[i]['doDelete'];
            delete copy.lstDinhKem[i]['downloadUrl'];
            delete copy.lstDinhKem[i]['fiBatBuoc'];
            delete copy.lstDinhKem[i]['isRequire'];
            delete copy.lstDinhKem[i]['deleteFile'];
            delete copy.lstDinhKem[i]["__ko_mapping__"];
        }

        delete copy['__ko_mapping__'];
        return copy;
    };
}
