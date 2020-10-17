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
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
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

    self.fiSoluongDoan = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 2 ký tự', params: 2}
    });

    self.fiThongtinDoan = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 500 ký tự', params: 500}
    });

    self.fiNgayky = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });

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

    self.lstNhomHangHoa = ko.observableArray([]);
    self.lstDinhKem = ko.observableArray([]);

    self.fiLydo = ko.observable(null).extend({
        maxLength: {message: 'Tối đa 2000 ký tự', params: 50}
    });

    self.visibleLyDoXinSua = ko.observable(false);

    //Danh muc
    self.lstHinhthuc = ko.observableArray(mapCategory(options ? options.lstHinhthuc : [], "id", "name"));
    self.lstCqxl = ko.observableArray(mapCategory(options ? options.lstCqxl : [], "fiMaCqxl", "fiTenCqxl"));




    var hosoVG = [self.fiMst, self.fiTenDn, self.fiDiachiDn, self.fiSoDondk, self.fiMaCoquan, self.fiTenCoquan,
        self.fiSoluongDoan, self.fiThongtinDoan, self.fiNguoiky, self.fiDiadiemky];

    self.hosoErrors = ko.validation.group(hosoVG, {deep: true, live: true, observable: true});
    self.errorHHMessage = ko.observable(null);
    self.errorDinhKemMessage = ko.observable(null);
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
            self.fiSoluongDoan(hoso.hasOwnProperty('fiSoluongDoan') ? hoso.fiSoluongDoan : null);
            self.fiThongtinDoan(hoso.hasOwnProperty('fiThongtinDoan') ? hoso.fiThongtinDoan : null);
            self.fiNgayky(hoso.hasOwnProperty('fiNgayky') ? hoso.fiNgayky : null);
            self.fiNguoiky(hoso.hasOwnProperty('fiNguoiky') ? hoso.fiNguoiky : null);
            self.fiDiadiemky(hoso.hasOwnProperty('fiDiadiemky') ? hoso.fiDiadiemky : null);

            self.fiNgaygui(hoso.hasOwnProperty('fiNgaygui') ? hoso.fiNgaygui : null);
            self.fiHoatdong(hoso.hasOwnProperty('fiHoatdong') ? hoso.fiHoatdong : null);
            self.fiNguoitao(hoso.hasOwnProperty('fiNguoitao') ? hoso.fiNguoitao : null);
            self.fiNgaytao(hoso.hasOwnProperty('fiNgaytao') ? new Date(hoso.fiNgaytao) : null);
            self.fiNgCapnhat(hoso.hasOwnProperty('fiNgCapnhat') ? hoso.fiNgCapnhat : null);
            self.fiTrangthai(hoso.hasOwnProperty('fiTrangthai') ? hoso.fiTrangthai : null);
            self.fiTenTt(hoso.hasOwnProperty('fiTenTt') ? hoso.fiTenTt : null);
            self.fiSoGp(hoso.hasOwnProperty('fiSoGp') ? hoso.fiSoGp : null);
            self.fiNgaycapGp(hoso.hasOwnProperty('fiNgaycapGp') ? hoso.fiNgaycapGp : null);
            self.fiIdHosocha(hoso.hasOwnProperty('fiIdHosocha') ? hoso.fiIdHosocha : null);
            self.fiIsHosotam(hoso.hasOwnProperty('fiIsHosotam') ? hoso.fiIsHosotam : null);


            self.lstNhomHangHoa(mapTbdhsNhomHanghoa01(hoso.hasOwnProperty('lstNhomHangHoa') ? hoso.lstNhomHangHoa : []));
            self.lstDinhKem(mapFilesVM(hoso.hasOwnProperty('lstDinhKem') ? hoso.lstDinhKem : [], self.fiIdHoso()));
            self.fiLydo(hoso.hasOwnProperty('fiLydo') ? hoso.fiLydo : null);
        } else {
            self.lstDinhKem(mapFilesVM(options.lstDinhKem, self.fiIdHoso()));
        }
    };

    self.init(hosoInfo);

    //validate ngay nhap vao ra
    self.showValidThoiGianVao = function (dateStart, dateEnd, stt) {
        debugger;
        if (dateStart === null)
            $("#fiThoigianvaoTungay_lbl_" + stt).show();
        else
            $("#fiThoigianvaoTungay_lbl_" + stt).hide();
        if (dateEnd === null)
            $("#fiThoigianvaoDenngay_lbl_" + stt).show();
        else
            $("#fiThoigianvaoDenngay_lbl_" + stt).hide();

    }

    self.validTimeOut = function (ngayCap, dateStart, dateEnd, htValue, stt) {
        var flag = true;
        if (htValue === 2) {
            //hinh thuc tam nhap xuat
            if (dateStart === null) {
                $("#fiThoigianraTungay_lbl_" + stt).show();
                flag = false;
            }
            else {
                $("#fiThoigianraTungay_lbl_" + stt).hide();
            }

            if (dateEnd === null) {
                $("#fiThoigianraDenngay_lbl_" + stt).show();
                flag = false;
            }
            else {
                $("#fiThoigianraDenngay_lbl_" + stt).hide();
            }

        //dinhpv
        } else {
            if (ngayCap === null) {
                $("#fiNgaycapHochieu_lbl_" + stt).show();
                flag = false;
            }
            else {
                $("#fiNgaycapHochieu_lbl_" + stt).hide();
            }
        }
        return flag;
    }

    self.errorDinhKemvalue = function(){
        if (self.lstDinhKem() && self.lstDinhKem().length > 0) {
            for (var i = 0; i < self.lstDinhKem().length; i++) {
                var attach = self.lstDinhKem()[i];
                if (attach.isRequire()) {
                    if (!attach.fiGuiid() || !attach.fiTenTep() || !attach.fiDuongDan()) {
//                        self.errorDinhKemMessage('* Cần bổ sung thêm file đính kèm!');
                        $('#errorDKMessage').show();
                        break;
                    }
            $('#errorDKMessage').hide();
                }
            }
        }
    }


    //VALIDATE DATA ON FORM
    //Remove from toJSON
    self.isValidForm = function () {
        var flag = true;
        var errorDinhkem = true;


//        if (self.visibleLyDoXinSua()) {
//            if (!self.fiLydo()) {
//                app.Alert('Bạn phải nhập vào lý do xin sửa hồ sơ!');
//                return false;
//            }
//        }

        self.errorDinhKemMessage = ko.observable(null);
        //Kiem tra thong tin dinh kem
        self.errorDinhKemvalue();
        if (!self.lstDinhKem() || self.lstDinhKem().length <= 0) {
//            self.errorDinhKemMessage('* Chưa khai báo thông tin đính kèm');
            errorDinhkem = false;
            return errorDinhkem;
        }

        if (self.lstDinhKem() && self.lstDinhKem().length > 0) {
            for (var i = 0; i < self.lstDinhKem().length; i++) {
                var attach = self.lstDinhKem()[i];
                if (attach.isRequire()) {
                    if (!attach.fiGuiid() || !attach.fiTenTep() || !attach.fiDuongDan()) {
//                        self.errorDinhKemMessage('* Cần bổ sung thêm file đính kèm!');
                        errorDinhkem = false;
                        break;
                    }
                }
            }
        }
        
        if (self.hosoErrors().length > 0) {
            self.hosoErrors.showAllMessages();
            flag = false;
            return flag;
        }

        //validate nhom hang hoa
        var nhomHHsize = self.lstNhomHangHoa().length;
        if (nhomHHsize == 0) {
            $("#lbl-nhomHH").show();
            flag = false;
        } else {
            //valid thong tin ben trong cua tung tab
            debugger;
            for (var i = 0; i < nhomHHsize; i++) {
                var nHHObj = self.lstNhomHangHoa()[i];

                //show msg file image
                if (nHHObj.fiTenAnh() != null && nHHObj.fiDuongDan() != null) {
                    $("#file_lbl_" + (i + 1)).hide();
                } else {
                    $("#file_lbl_" + (i + 1)).show();
                }


                //validate time in, time out
                self.showValidThoiGianVao(nHHObj.fiThoigianvaoTungay(), nHHObj.fiThoigianvaoDenngay(), i + 1);
                flag = self.validTimeOut(nHHObj.fiNgaycapHochieu(), nHHObj.fiThoigianraTungay(), nHHObj.fiThoigianraDenngay(), nHHObj.fiHinhthuc(), i + 1);


                //validate thong tin nhom hang
                if (nHHObj.nhomHHErrors().length > 0) {
                    nHHObj.nhomHHErrors.showAllMessages();
                    flag = false;
                }
                //validate hang hoa
                var lstHH = nHHObj.lstHanghoa01s();
                var lstHHSize = nHHObj.lstHanghoa01s().length;
                if(lstHHSize>0){
                    $("#hh_lbl_"+(i+1)).hide();
                    for (var j = 0; j < lstHHSize; j++) {
                        if (lstHH[j].hanghoaError().length > 0) {
                            lstHH[j].hanghoaError.showAllMessages();
                            flag = false;
                        }
                    }
                }else{
                    debugger;
                    flag = false;
                    $("#hh_lbl_"+(i+1)).show();
                }

//                if (!flag)
//                    activeTabs(nHHObj.STT() - 1);
            }
        }



        return flag && errorDinhkem;
    };
//VALIDATE DATA ON FORM

//XU LY SU KIEN BUTTON, TABLE


    self.addNhomHHClick = function () {
        var item = new TbdhsNhomHanghoa01({
            STT: self.lstNhomHangHoa().length + 1,
            fiIdNhh: -1 * new Date().getTime(),
            fiTenNhh: "Tab " + (self.lstNhomHangHoa().length + 1)
        });
        self.lstNhomHangHoa.push(item);
        for (var i = 0; i < self.lstNhomHangHoa().length; i++) {
            self.lstNhomHangHoa()[i].STT(i + 1);
        }
        self.binTabAndcontent(self.lstNhomHangHoa().length - 1);

        $("#lbl-nhomHH").hide();
        console.log(self.lstNhomHangHoa());
    };

    self.addHanghoaClick = function (data) {
        for (var i = 0; i < self.lstNhomHangHoa().length; i++) {
            if (self.lstNhomHangHoa()[i].fiIdNhh() === data.fiIdNhh()) {
                var item = new TbdhsHanghoa01({
                    STT: self.lstNhomHangHoa()[i].lstHanghoa01s().length + 1,
                    fiIdNhh: self.lstNhomHangHoa()[i].fiIdNhh(),
                    fiId: -1 * new Date().getTime()
                });

                self.lstNhomHangHoa()[i].lstHanghoa01s.push(item);
                $("#hh_lbl_"+(i+1)).hide();
                break;
            }
        }
    };
    self.removeNhomHHClick = function (item) {
        if (item) {
            var pop = app.popup({
                title: 'Thông báo',
                html: '<b>Bạn chắc chắn muốn xoá dữ liệu của nhóm hàng hoá này?</b>',
                width: 450,
                buttons: [
                    {
                        name: NSWLang["common_button_toi_chac_chan"],
                        class: 'btn',
                        icon: 'fa-save',
                        action: function () {
                            self.lstNhomHangHoa.remove(function (o) {
                                return o.fiIdNhh() === item.fiIdNhh();
                            });
                            for (var i = 0; i < self.lstNhomHangHoa().length; i++) {
                                self.lstNhomHangHoa()[i].STT(i + 1);
                            }
                            self.binTabAndcontent(self.lstNhomHangHoa().length - 1);
                            app.popupRemove(pop.selector);

                            //validate lbl danh sach tab nhom hang
                            if (self.lstNhomHangHoa().length == 0) {
                                $("#lbl-nhomHH").show();
                            } else {
                                $("#lbl-nhomHH").hide();
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
    }
//XU LY SU KIEN BUTTON, TABLE

//Convert to json object
    self.toJSON = function () {
        var mapping = {
            ignore: ['addHanghoaClick', 'addNhomHHClick', 'binTabAndcontent', 'errorDinhKemMessage', 'errorHHMessage',
                'hosoErrors', 'init', 'isValidForm', 'lstCqxl', 'lstHinhthuc', 'toJSON', 'visibleLyDoXinSua']
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
            delete copy.lstDinhKem[i]["__ko_mapping__"];
        }

        delete copy['__ko_mapping__'];
        return copy;
    };

    function activeTabs(i) {
        var tab = document.getElementsByClassName('tab');
        var tabContent = document.getElementsByClassName('tab-import');
        app.addclass(tab[i], 'active');
        app.addclass(tabContent[i], 'active');
        tab[i].id = 'a-tab-bca-' + (i + 1);
        tab[i].children[0].setAttribute('href', '#tab-bca-' + (i + 1));
        tabContent[i].id = 'tab-bca-' + (i + 1);
        tab[i].scrollIntoView();
    }

//bind tab and content
    self.binTabAndcontent = function (currentTab) {
        var tab = document.getElementsByClassName('tab');
        var tabContent = document.getElementsByClassName('tab-import');
        for (var i = 0; i < tab.length; i++) {
            if (i === currentTab) {
                app.addclass(tab[i], 'active');
                app.addclass(tabContent[i], 'active');
            } else {
                app.removeclass(tab[i], 'active');
                app.removeclass(tabContent[i], 'active');
            }
            tab[i].id = 'a-tab-bca-' + (i + 1);
            tab[i].children[0].setAttribute('href', '#tab-bca-' + (i + 1));
            tabContent[i].id = 'tab-bca-' + (i + 1);
            tab[i].scrollIntoView();
        }
    }
}
