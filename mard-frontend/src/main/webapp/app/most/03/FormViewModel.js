/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

MA_PT_DO_KHAC = '-1';
function TbdHanghoaVM(options) {
    var self = this;
    var item = options ? options : null;
    var hangHoaData = item.hangHoa;

    self.fiIdHh = ko.observable(hangHoaData ? hangHoaData.fiIdHh() : null);

    self.fiMaHh = ko.observable(hangHoaData ? hangHoaData.fiMaHh() : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiTenHh = ko.observable(hangHoaData ? hangHoaData.fiTenHh() : null).extend({
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });

    self.fiTenHhKhac = ko.observable(hangHoaData ? hangHoaData.fiTenHh() : null).extend({
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    if(MA_PT_DO_KHAC === self.fiMaHh()) {
        self.visibleTenHhKhac = ko.observable(true);
    } else {
        self.visibleTenHhKhac = ko.observable(false);
    }

    self.fiSotk = ko.observable(hangHoaData ? hangHoaData.fiSotk() : null).extend({
        maxLength: {message: 'Tối đa 12 ký tự', params: 12}
    });
    self.fiIdHoso = ko.observable(hangHoaData ? hangHoaData.fiIdHoso() : null);
    self.fiMaHs = ko.observable(hangHoaData ? hangHoaData.fiMaHs() : null).extend({
        maxLength: {message: 'Tối đa 12 ký tự', params: 12}
    });
    self.fiKieu = ko.observable(hangHoaData ? hangHoaData.fiKieu() : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 50 ký tự', params: 50}
    });
    self.fiKyhieu = ko.observable(hangHoaData ? hangHoaData.fiKyhieu() : null).extend({
        maxLength: {message: 'Tối đa 50 ký tự', params: 50}
    });
    self.fiTenNsx = ko.observable(hangHoaData ? hangHoaData.fiTenNsx() : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiMaQg = ko.observable(hangHoaData ? hangHoaData.fiMaQg() : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 50 ký tự', params: 50}
    });
    self.fiTenQg = ko.observable(hangHoaData ? hangHoaData.fiTenQg() : null);
    self.fiPhamvido = ko.observable(hangHoaData ? hangHoaData.fiPhamvido() : null).extend({
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiCapCx = ko.observable(hangHoaData ? hangHoaData.fiCapCx() : null).extend({        
        maxLength: {message: 'Tối đa 50 ký tự', params: 50}
    });
    self.fiGhiChu = ko.observable(hangHoaData ? hangHoaData.fiGhiChu() : null).extend({
        maxLength: {message: 'Tối đa 50 ký tự', params: 1000}
    });

    self.fiDactinhKt = ko.observable(hangHoaData ? hangHoaData.fiDactinhKt() : null);
    self.fiMaql = ko.observable(hangHoaData ? hangHoaData.fiMaql() : null);
    self.fiNguoitao = ko.observable(hangHoaData ? hangHoaData.fiNguoitao() : null);
    self.fiHoatdong = ko.observable(hangHoaData ? hangHoaData.fiHoatdong() : null);
    self.fiNgaytao = ko.observable(hangHoaData ? hangHoaData.fiNgaytao() : null);
    self.stt = ko.observable(hangHoaData ? hangHoaData.stt() : null);

    self.lstPhuongTienDo = ko.observableArray(item ? item.lstPhuongTienDo : []);
    self.lstQuocGia = ko.observableArray(item ? item.lstQuocGia : []);

    var lstVG = [self.fiMaHh, self.fiKieu, self.fiTenNsx, self.fiMaQg];
    self.lstErrors = ko.validation.group(lstVG, {deep: true, live: true, observable: true});

    self.isValidForm = function () {
        if (self.lstErrors().length > 0) {
            self.lstErrors.showAllMessages();
            return false;
        }

        if (self.fiMaHh() === MA_PT_DO_KHAC && (self.fiTenHhKhac() === null || self.fiTenHhKhac() === '')) {
            app.Alert('Bạn chưa nhập vào tên phương tiện đo');
            return false;
        }

        return true;
    };
    self.reset = function () {
        self.lstErrors.showAllMessages(false);
        self.fiIdHh(null);
        self.fiMaHh(null);
        self.fiTenHh(null);
        self.fiTenHhKhac(null);
        self.visibleTenHhKhac(false);
        self.fiSotk(null);
        self.fiIdHoso(null);
        self.fiMaHs(null);
        self.fiDactinhKt(null);
        self.fiKieu(null);
        self.fiKyhieu(null);
        self.fiTenNsx(null);
        self.fiMaQg(null);
        self.fiTenQg(null);
        self.fiPhamvido(null);
        self.fiCapCx(null);
        self.fiGhiChu(null);
        self.fiMaql(null);
        self.fiNguoitao(null);
        self.fiHoatdong(null);
        self.fiNgaytao(null);
    };

    self.fiMaHhChange = function () {
        if (self.fiMaHh() === MA_PT_DO_KHAC) {
            self.visibleTenHhKhac(true);
        } else {
            self.visibleTenHhKhac(false);
        }
    };


}

function ToKhaiHaiQuanVM(options) {
    var self = this;
    var item = options ? options : null;
    self.sotk = ko.observable('300024189050').extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 12 ký tự', params: 12}
    });
    self.mahq2 = ko.observable('03PA');
    self.mahq = ko.observable('03PA').extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 6 ký tự', params: 6}
    });
    self.namdk = ko.observable('2014').extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 6 ký tự', params: 6},
        number: {message: 'Giá trị nhập vào phải là số', params: true}
    });

    var searchVG = [self.sotk, self.mahq, self.namdk];
    self.searchFormErrors = ko.validation.group(searchVG, {deep: true, live: true, observable: true});
    //Thong tin to khai
    self.fiSoTk = ko.observable(null);
    self.fiMaHq = ko.observable(null);
    self.fiNgayDk = ko.observable(null);
    self.fiNgayDKVN = ko.observable(self.fiNgayDk).extend({vnDateShort: true});
    //Danh sach hang hoa
    self.lstHanghoa = ko.observableArray([]);

    //Danh sach don vi hai quan
    self.lstHaiQuan = ko.observableArray(item ? item.lstHaiQuan().haiQuan : []);

    self.isVaildForm = function () {
        if (self.searchFormErrors().length > 0) {
            self.searchFormErrors.showAllMessages();
            return false;
        }
        return true;
    };

    self.cloneToKhaiInfo = function (index) {
        return new Tbdtokhaihq3ViewModel(index, self);
    };
    
    self.onSelectedHQ = function (item){
       self.mahq($("#lstHaiQuan").val());
    };

    self.onEnterMahq = function(){
        $("#lstHaiQuan").val(self.mahq());
    };

    self.onBtnToKhaiSearchClick = function () {
        if (!self.isVaildForm()) {
            return;
        }

        var data = {};
        data.mst = '';
        data.sotk = self.sotk();
        data.mahq = self.mahq();
        data.namdk = self.namdk();
        app.makePost({
            url: '/most/03/tokhai',
            data: JSON.stringify(data),
            success: function (d) {
                if (d.success && !!d.data.fiSoTk) {
                    var mapping = {
                        'ignore': ['lstHanghoa', 'lstHaiQuan', 'searchFormErrors', 'mahq2', 'sotk', '__ko_mapping__', 'namdk', 'onBtnToKhaiSearchClick']
                    };
                    ko.mapping.fromJS(d.data, mapping, self);
                    self.lstHanghoa(ListTokhaiHangHoaResponseModel(d.data.lstHanghoa));
                } else {
                    var mapping = {
                        'ignore': ['lstHanghoa', 'lstHaiQuan', 'searchFormErrors', 'mahq2', 'sotk', '__ko_mapping__', 'namdk', 'onBtnToKhaiSearchClick']
                    };
                    self.fiSoTk(null);
                    self.fiMaHq('');
                    
                    self.lstHanghoa([]);
                    app.Alert(NSWLang["common_msg_khonglayduocthongtintokhai"]);
                }
            },
            error: function (e) {
                app.toast({
                    title: NSWLang["common_msg_thong_bao"],
                    message: NSWLang["common_msg_he_thong_chua_san_sang"],
                    function: 'success'
                });
            }
        });
    };
}

function Most03FormVM(options)
{
    var self = this;

    var hosoInfo = (options !== null && options.hasOwnProperty('hoso')) ? options.hoso : null;

    self.toKhaiHQs = ko.observableArray(null);
    self.hangHoas = ko.observableArray(null);
    self.errorHanghoaText = ko.observable(null);

    self.fiIdHoso = ko.observable(null);
    self.fiMaHoso = ko.observable(null);
    self.fiTrangthai = ko.observable(null);

    self.fiTenTt = ko.observable(null);
    self.fiReasonSDBS = ko.observable(null).extend({
        maxLength: {message: 'Tối đa 2000 ký tự', params: 2000}
    });
    self.fiNgaytao = ko.observable(null);
    self.fiNgaygui = ko.observable(null);
    self.fiHoatdong = ko.observable(null);
    self.fiNguoitao = ko.observable(null);

    self.fiLoaiHoso = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiLydoDc = ko.observable(null).extend({
        maxLength: {message: 'Tối đa 500 ký tự', params: 500}
    });
    self.fiTenCoso = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 100 ký tự', params: 100}
    });
    self.fiDiachiTsc = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiSdt = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 50 ký tự', params: 50}
    });
    self.fiDiachiVpgg = ko.observable(null).extend({
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiEmail = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 50 ký tự', params: 50}
    });
    self.fiFax = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 50 ký tự', params: 50}
    });
    self.fiSoDkkd = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 50 ký tự', params: 50}
    });
    self.fiNgaycap = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        ExceedCurrentDate: {message: "Ngày bạn nhập không được lớn hơn ngày hiện tại"}
    });
    self.fiCqCap = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiMstDn = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 15 ký tự', params: 15}
    });
    self.fiDnMienTnm = ko.observable(null).extend({
        maxLength: {message: 'Tối đa 500 ký tự', params: 500}
    });
    self.fiLydoDnMien = ko.observable(null).extend({
        maxLength: {message: 'Tối đa 2000 ký tự', params: 2000}
    });
    self.fiNguoiDaidien = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 100 ký tự', params: 100}
    });
    self.fiChucvuNguoidaidien = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 50 ký tự', params: 50}
    });
    
    
    self.visibleLyDoSDBS = ko.observable(false);

    self.lstLoaiHoSo = ko.observableArray(options ? options.lstLoaiHoSo : []);
    self.lstPhuongTienDo = ko.observableArray([]);
    self.lstHaiQuan = ko.observableArray([]);
    self.lstQuocGia = ko.observableArray([]);

    var hosoVG = [self.fiLoaiHoso, self.fiTenCoso, self.fiDiachiTsc,
        self.fiSdt, self.fiSoDkkd, self.fiCqCap, self.fiNgaycap, self.fiMstDn,
        self.fiNguoiDaidien, self.fiChucvuNguoidaidien];
    self.hosoErrors = ko.validation.group(hosoVG, {deep: true, live: true, observable: true});

    self.init = function (hoso) {
        self.fiTenCoso(hoso !== null && hoso.hasOwnProperty('fiTenCoso') ? hoso.fiTenCoso : user.companyName);
        self.fiDiachiTsc(hoso !== null && hoso.hasOwnProperty('fiDiachiTsc') ? hoso.fiDiachiTsc : user.companyAddress);
        self.fiSdt(hoso !== null && hoso.hasOwnProperty('fiSdt') ? hoso.fiSdt : user.companyPhoneNumber);
        self.fiDiachiVpgg(hoso !== null && hoso.hasOwnProperty('fiDiachiVpgg') ? hoso.fiDiachiVpgg : null);
        self.fiEmail(hoso !== null && hoso.hasOwnProperty('fiEmail') ? hoso.fiEmail : user.companyEmail);
        self.fiFax(hoso !== null && hoso.hasOwnProperty('fiFax') ? hoso.fiFax : user.companyFax);
        self.fiSoDkkd(hoso !== null && hoso.hasOwnProperty('fiSoDkkd') ? hoso.fiSoDkkd : user.registrationNo);
        self.fiNgaycap(hoso !== null && hoso.hasOwnProperty('fiNgaycap') ? new Date(hoso.fiNgaycap) : "");
        self.fiMstDn(hoso !== null && hoso.hasOwnProperty('fiMstDn') ? hoso.fiMstDn : user.username);

        if (hoso !== null) {
            self.toKhaiHQs(hoso.toKhaiHQs ? ListTbdHaiQuanModel(hoso.toKhaiHQs) : null);
            self.hangHoas(hoso.hangHoas ? ListTbdhanghoaModel(hoso.hangHoas) : null);

            self.fiIdHoso(hoso.hasOwnProperty('fiIdHoso') ? hoso.fiIdHoso : null);
            self.fiMaHoso(hoso.hasOwnProperty('fiMaHoso') ? hoso.fiMaHoso : null);
            self.fiTrangthai(hoso.hasOwnProperty('fiTrangthai') ? hoso.fiTrangthai : null);

            self.fiTenTt(hoso.hasOwnProperty('fiTenTt') ? hoso.fiTenTt : null);
            self.fiReasonSDBS(hoso.hasOwnProperty('fiReasonSDBS') ? hoso.fiReasonSDBS : null);
            self.fiNgaytao(hoso.hasOwnProperty('fiNgaytao') ? hoso.fiNgaytao : null);
            self.fiNgaygui(hoso.hasOwnProperty('fiNgaygui') ? hoso.fiNgaygui : null);
            self.fiHoatdong(hoso.hasOwnProperty('fiHoatdong') ? hoso.fiHoatdong : null);
            self.fiNguoitao(hoso.hasOwnProperty('fiNguoitao') ? hoso.fiNguoitao : null);

            self.fiLoaiHoso(hoso.hasOwnProperty('fiLoaiHoso') ? hoso.fiLoaiHoso : null);
            self.fiLydoDc(hoso.hasOwnProperty('fiLydoDc') ? hoso.fiLydoDc : null);
            self.fiCqCap(hoso.hasOwnProperty('fiCqCap') ? hoso.fiCqCap : null);
            self.fiDnMienTnm(hoso.hasOwnProperty('fiDnMienTnm') ? hoso.fiDnMienTnm : null);
            self.fiLydoDnMien(hoso.hasOwnProperty('fiLydoDnMien') ? hoso.fiLydoDnMien : null);    
            self.fiNguoiDaidien(hoso.hasOwnProperty('fiNguoiDaidien') ? hoso.fiNguoiDaidien : null);
            self.fiChucvuNguoidaidien(hoso.hasOwnProperty('fiChucvuNguoidaidien') ? hoso.fiChucvuNguoidaidien : null);
            
            if ([STATUS_DA_TIEP_NHAN, STATUS_YEUCAU_BOSUNG_HOSO, STATUS_DA_BOSUNG_HOSO, STATUS_DA_SUA_HOSO].indexOf(self.fiTrangthai()) >= 0) {
                self.visibleLyDoSDBS(true);
            }
        }
    };

    self.init(hosoInfo);
    //VALIDATE DATA ON FORM
    self.isValidForm = function () {
        delete self.hanghoaVM;
        delete self.toKhaiHaiQuanVM;
        delete self.popup;
        
        var haveReason = true;
        //Kiem tra xem co can nhap ly do sưa doi bo sung khong
        if (self.visibleLyDoSDBS()) {
            if (self.fiReasonSDBS() === null || self.fiReasonSDBS() === '') {
//                app.Alert('Bạn phải nhập vào lý do sửa hồ sơ.');
                $('#fiLydoDc').parent().append("<span class = 'validationMessage'>Lý do bổ sung không được bỏ trống</span>");
                $('#fiLydoDc').focus();
                haveReason = false;
            }
        }
        if (self.hosoErrors().length > 0) {
            self.hosoErrors.showAllMessages();
            return false;
        }

        if(!haveReason){
            return haveReason;
        }

        var errorHanghoa = false;
        if (!self.hangHoas() || self.hangHoas().length <= 0) {
            self.errorHanghoaText('* Chưa khai báo hàng hóa');
            return errorHanghoa;
        }
        if (self.hangHoas() && self.hangHoas().length > 0) {
            for (var i = 0; i < self.hangHoas().length; i++) {
                var hh = self.hangHoas()[i];
                if (!hh.fiTenHh() || !hh.fiTenNsx() || !hh.fiMaQg()) {
                    errorHanghoa = true;
                    break;
                }
            }
        }

        if (errorHanghoa) {
            self.errorHanghoaText('* Bổ sung thêm thông tin của hàng hóa trước khi lưu dữ liệu');
        }

        return self.hosoErrors().length <= 0 && !errorHanghoa;
    };
    //VALIDATE DATA ON FORM

    //XU LY SU KIEN BUTTON, TABLE
    self.bThemMoiToKhai = function () {
        var html = $('#tokhai-template').html();
        delete self.toKhaiHaiQuanVM;
        delete self.popup;

        self.toKhaiHaiQuanVM = new ToKhaiHaiQuanVM({lstHaiQuan:self.lstHaiQuan});
        self.popup = app.popup({
            title: 'Tra cứu tờ khai',
            html: html,
            width: 800,
            buttons: [
                {
                    name: NSWLang["common_button_luu"],
                    class: 'btn',
                    icon: 'fa-save',
                    action: function () {
                        if (!self.toKhaiHaiQuanVM.isVaildForm())
                            return;
                        if(self.toKhaiHQs() == null || !self.toKhaiHaiQuanVM.fiSoTk()){
                            app.AlertWithBtn(NSWLang["most_03_message_tokhai_chuachon"]);
                            return;
                        }
                        var item = self.toKhaiHaiQuanVM.cloneToKhaiInfo(self.toKhaiHQs().length + 1);
                        var index = self.toKhaiHQs.firstIndexOf(function (obj) {
                            return item.fiSoTk() === obj.fiSoTk();
                        });
                        if (index < 0) {
                            self.toKhaiHQs.push(item);
                        }
                        var count = self.toKhaiHaiQuanVM.lstHanghoa().length;
                        var idx = self.hangHoas().length;
                        var fiMql = null;
                        for (var i = 0; i < count; i++) {
                            if (self.toKhaiHaiQuanVM.lstHanghoa()[i].isChecked()) {
                                fiMql = self.toKhaiHaiQuanVM.lstHanghoa()[i].fiMaQl();
                                var io = self.hangHoas.firstIndexOf(function (obj) {
                                    return fiMql === obj.fiMaql();
                                });
                                if (io < 0) {
                                    var hh = new TbdHangHoaModel(-1 * new Date().getTime(), ++idx, self.toKhaiHaiQuanVM.lstHanghoa()[i]);
                                    hh.fiSotk(item.fiSoTk());
                                    delete hh['isChecked'];
                                    self.hangHoas.push(hh);
                                }
                            }
                        }
                        app.popupRemove(self.popup.selector);
                    }
                }
            ]
        }, function (_popup) {
            ko.applyBindings(self.toKhaiHaiQuanVM, document.getElementById('tokhai-form'));
        });
    };


    self.bXoaToKhai = function (item) {
        if (item) {
            self.toKhaiHQs.remove(function (tk) {
                return tk.fiIdTk() === item.fiIdTk();
            });
        }
    };

    self.onViewToKhaiClick = function (item) {
        var html = [
            $('#tokhai-tmpl').html()
        ].join('');
        delete self.Pop;

        self.Pop = app.popup({
            title: 'Thông tin tờ khai',
            html: html,
            width: 880,
            buttons: []
        }, function () {
            ko.applyBindings(item, document.getElementById('tokhai-form'));
        });
    };

    self.bThemMoiHangHoa = function () {
        self.showHangHoaPopup(null);
    };

    self.bSuaHangHoaClick = function (d) {
        self.showHangHoaPopup(d);
    };

    self.bXoaHangHoaClick = function (item) {
        if (item) {
            self.hangHoas.remove(function (hh) {
                return hh.fiIdHh() === item.fiIdHh();
            });
        }
    };

    //XU LY SU KIEN BUTTON, TABLE

    //HAM XU LY
    self.afterImportExcel = function (data) {
        if (!data) {
            return;
        }
        self.init(data);
    };

    self.showHangHoaPopup = function (d) {
        delete self.popup;
        delete self.hanghoaVM;

        var html = [
            $('#hanghoa-template').html()
        ].join('');
        var phuongtien = self.lstPhuongTienDo();
        phuongtien.push({fiTen: "Khác", fiMa:"-1"});
        var data = {
            lstQuocGia: self.lstQuocGia(),
            lstPhuongTienDo: phuongtien,
            hangHoa: d
        };

        self.hanghoaVM = new TbdHanghoaVM(data);

        self.popup = app.popup({
            title: 'Thêm mới phương tiện',
            html: html,
            width: 650,
            height : 500,
            buttons: [
                {
                    name: NSWLang["common_button_luu"],
                    class: 'btn',
                    icon: 'fa-save',
                    action: function () {
                        if (!self.hanghoaVM.isValidForm()) {
                            return;
                        }
                        var mapping = {
                            'ignore': ['lstErrors', 'lstQuocGia', 'lstPhuongTienDo', 'isValidForm',
                                'reset', 'isChecked', '__ko_mapping__', 'visibleTenHhKhac', 'fiMaHhChange']
                        };
                        
                        var hanghoaItem = ko.mapping.fromJS(self.hanghoaVM, mapping);
                        if (hanghoaItem.fiMaHh() === MA_PT_DO_KHAC) {
                            hanghoaItem.fiTenHh(hanghoaItem.fiTenHhKhac());
                        } else {
                            hanghoaItem.fiTenHh($('#fiMaHh option:selected').text());
                        }
                        delete hanghoaItem['fiTenHhKhac'];
                        
                        hanghoaItem.fiTenQg($('#fiMaQg option:selected').text());
                        
                        //Them moi hang hoa
                        if (self.hanghoaVM.fiIdHh() === null || self.hanghoaVM.fiIdHh() === "") {
                            hanghoaItem.stt(self.hangHoas().length + 1);
                            hanghoaItem.fiIdHh(-1 * new Date().getTime());
                            self.hangHoas.push(hanghoaItem);
                        } else {//Cap nhat hang hoa
                            var oldItem = ko.utils.arrayFirst(self.hangHoas(), function (item) {
                                return item.fiIdHh() === hanghoaItem.fiIdHh();
                            });

                            if (oldItem) {
                                oldItem.fiIdHh(hanghoaItem.fiIdHh());
                                oldItem.fiSotk(hanghoaItem.fiSotk());
                                oldItem.fiIdHoso(hanghoaItem.fiIdHoso());
                                oldItem.fiMaHs(hanghoaItem.fiMaHs());
                                oldItem.fiMaHh(hanghoaItem.fiMaHh());
                                oldItem.fiTenHh(hanghoaItem.fiTenHh());
                                oldItem.fiTenNsx(hanghoaItem.fiTenNsx());
                                oldItem.fiMaQg(hanghoaItem.fiMaQg());
                                oldItem.fiTenQg(hanghoaItem.fiTenQg());
                                oldItem.fiKyhieu(hanghoaItem.fiKyhieu());
                                oldItem.fiKieu(hanghoaItem.fiKieu());
                                oldItem.fiPhamvido(hanghoaItem.fiPhamvido());
                                oldItem.fiCapCx(hanghoaItem.fiCapCx());
                                oldItem.fiDactinhKt(hanghoaItem.fiDactinhKt());
                                oldItem.fiGhiChu(hanghoaItem.fiGhiChu());
                                oldItem.fiNgaytao(hanghoaItem.fiNgaytao());
                                oldItem.fiHoatdong(hanghoaItem.fiHoatdong());
                                oldItem.fiNguoitao(hanghoaItem.fiNguoitao());
                                oldItem.fiMaql(hanghoaItem.fiMaql());
                                oldItem.stt(hanghoaItem.stt());
                            }
                        }
                        app.popupRemove(self.popup.selector);
                    }
                }
            ]
        }, function (popup) {
            ko.applyBindings(self.hanghoaVM, document.getElementById('hanghoa-form'));
        });
    };

    self.toJSON = function () {
        var mapping = {
            'ignore': ["lstLoaiHoSo", "lstLoaiPhuongTienDo", "lstPhuongTienDo",
                "lstQuocGia", "errorHanghoaText", "hosoErrors", "isValidForm", "bThemMoiToKhai",
                "bXoaToKhai", "bThemMoiHangHoa", "bSuaHangHoaClick", "bXoaHangHoaClick", "showHangHoaPopup",
                "toJSON", "hanghoaVM", "popup", "toKhaiHaiQuanVM", "__ko_mapping__", 'afterImportExcel', 'visibleLyDoSDBS']
        };

        var copy = ko.mapping.fromJS(self, mapping);
        copy = ko.toJS(copy);
        if (copy.hangHoas && copy.hangHoas.length > 0) {
            for (var i = 0; i < copy.hangHoas.length; i++) {
                delete copy.hangHoas[i]["bSua"];
                delete copy.hangHoas[i]["bXoa"];
                delete copy.hangHoas[i]["__ko_mapping__"];
            }
        }

        if (copy.toKhaiHQs && copy.toKhaiHQs.length > 0) {
            for (var i = 0; i < copy.toKhaiHQs.length; i++) {
                delete copy.toKhaiHQs[i]["__ko_mapping__"];
                delete copy.toKhaiHQs[i]["fiNgayDKVN"];
                delete copy.toKhaiHQs[i]["fiNgayCapHoaDon"];
            }
        }
        delete copy['__ko_mapping__'];
        return copy;
    };

    //DANH MUC---------------------------------------------------------------------------------------
    //Lay danh muc Quoc Gia
    app.getCategory('/most/03/danhmuc', 'DM_QUOCGIA', null, function (res) {
        if (res.success) {
            self.lstQuocGia(res.data);
        } else {
            self.lstQuocGia([]);
        }
    });
    //Lay danh muc Phuong tien mau
    app.getCategory('/most/03/danhmuc', 'DM_MPTD', null, function (res) {
        if (res.success) {
            self.lstPhuongTienDo(res.data);
        } else {
            self.lstPhuongTienDo([]);
        }
    });    
    
    //Lay danh muc don vi hai quan
    app.getCategory('/most/03/danhmuc', 'DM_DVHAIQUAN', null, function (res) {
        if (res.success) {
            self.lstHaiQuan(res.data);
        } else {
            self.lstHaiQuan([]);
        }
    });    
}
