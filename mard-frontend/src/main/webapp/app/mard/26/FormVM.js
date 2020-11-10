/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function HangHoaVM(op) {
    var self = this;
    var MAX_PAGE_SIZE = 10;

    self.lstProdutList = ko.observableArray(op.lstHangHoa);
    self.lstProduct =  [];
    self.groups = [];
    for(var i = 0; i < op.lstProduct.length; i++){
        if(self.groups.indexOf(op.lstProduct[i].group()) <= 0){
            self.groups.push(op.lstProduct[i].group());
        }
    }

    self.currentPage = ko.observable(0);
    self.pageSize = ko.observable(MAX_PAGE_SIZE);
    self.totalCount = ko.observable(0);

    self.paging = ko.observable(new PagingVM({
        pageSize: self.pageSize(),
        totalCount: 0
    }));

    self.paging().currentPage.subscribe(function (newCurrentPage) {
        self.currentPage(newCurrentPage);
        self.search(null);
    });

    self.search = function (cb, lstProduct) {

        var data = {
            currentPage: self.currentPage() - 1 < 0 ? 0 : self.currentPage() - 1,
            pageSize: self.pageSize(),
            inspectionType : op.inspectionType - 0
        };
        
        app.makeGet({
            url: '/mard/26/hanghoa/getlist?taxCode=' +hosoUsername,
            success: function (res) {
                if (res.success) {
                    lstProduct(res.data);
                }
            },
            error: function (e) {
                if (cb) {
                    cb();
                }
            }
        });
    };

    self.isValid = function () {
        return self.lstProduct.length > 0 || self.groups.length > 0;
    };

    self.onChange = function (item) {
        //console.log("self.groups -> ", self.groups);
        item.isSelected(!item.isSelected());
        item.lable(item.isSelected() === true ? 'Bỏ chọn' : 'Chọn');
        if (item.isSelected()) {
            var found = false;
            for(var i = 0; i < self.groups.length; i++){
                if(self.groups[i] == item.group()){
                    found = true;
                    break;
                }
            }
            if(found){
                return;
            }
            for (var i = 0; i < self.lstProdutList().length; i++) {
                if (item.group() == self.lstProdutList()[i].group()) {
                    self.lstProduct.push(self.lstProdutList()[i]);
                }
            }
            self.groups.push(item.group());
        } else {
            self.lstProduct.remove(function (o) {
                return o.group() == item.group();
            });
        }
        //console.log("self.lstProduct -> ", self.lstProduct);
    };
}

function FormVM(options) {
    var self = this;
    var hosoInfo = (options !== null && options.hasOwnProperty('hoso')) ? options.hoso : null;

    //Thong tin chung
    self.fiIdHoso = ko.observable(null);
    self.fiMaHoso = ko.observable(null);
    self.fiLoaiDon = ko.observable(options.maThuTuc);

    self.fiMstDn = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 13 ký tự', params: 13}
    });

    self.fiTenDn = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiDiachiDn = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });

    self.fiSdtDn = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 50 ký tự', params: 50}
    });

    self.fiFaxDn = ko.observable(null).extend({
        maxLength: {message: 'Tối đa 50 ký tự', params: 50}
    });
    self.fiEmailDn = ko.observable(null).extend({
        maxLength: {message: 'Tối đa 50 ký tự', params: 50},
        email: {message: 'Email không đúng định dạng', params: true}
    });

    self.fiNgayKy = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiDiadiemKy = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiNguoiKy = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 100 ký tự', params: 100}
    });

    self.fiNgaygui = ko.observable(null);
    self.fiHoatdong = ko.observable(1);
    self.fiNguoitao = ko.observable(null);
    self.fiNgaytao = ko.observable(null);
    self.fiNgCapnhat = ko.observable(null);
    self.fiTrangthai = ko.observable(0);
    self.fiTenTt = ko.observable(null);

    self.fiSoCv = ko.observable(null);
    self.fiNgaycapCv = ko.observable(null).extend({
        pattern: '[0-9]{2}/[0-9]{2}/[0-9]{4}'
    });

    self.fiCqgsBac = ko.observable(null).extend({
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });

    self.fiCqgsTrung = ko.observable(null).extend({
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });

    self.fiCqgsNam = ko.observable(null).extend({
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });

    self.fiMaCqgsBac = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });

    self.fiMaCqgsTrung = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });

    self.fiMaCqgsNam = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });

    self.fiMaThutuc = ko.observable(options.maThuTuc);
    self.fiTenThutuc = ko.observable(null);

    self.lstHanghoas = ko.observableArray((options && options.hasOwnProperty('lstHanghoas')) ? options.lstHanghoas :[]);

    //Danh muc
    self.lstCqgsBac = ko.observableArray(mapCategory(options ? options.lstCqgsBac : [], 'fiMaCqgs', 'fiTenCqgs'));
    self.lstCqgsNam = ko.observableArray(mapCategory(options ? options.lstCqgsNam : [], 'fiMaCqgs', 'fiTenCqgs'));
    self.lstCqgsTrung = ko.observableArray(mapCategory(options ? options.lstCqgsTrung : [], 'fiMaCqgs', 'fiTenCqgs'));

    var hosoVG = [self.fiMstDn, self.fiTenDn, self.fiDiachiDn, self.fiSdtDn,
        self.fiMaCqgsBac, self.fiMaCqgsTrung, self.fiMaCqgsNam, self.fiDiadiemKy, self.fiNguoiKy];

    self.hosoErrors = ko.validation.group(hosoVG, {deep: true, live: true, observable: true});
    self.errorHangHoaMessage = ko.observable(null);

    //Khoi tao gia tri ho so
    self.init = function (hoso) {
        self.fiTenDn(hoso !== null && hoso.hasOwnProperty('fiTenDn') ? hoso.fiTenDn : user.companyName);
        self.fiMstDn(hoso !== null && hoso.hasOwnProperty('fiMstDn') ? hoso.fiMstDn : user.username);
        self.fiDiachiDn(hoso !== null && hoso.hasOwnProperty('fiDiachiDn') ? hoso.fiDiachiDn : user.companyAddress);
        self.fiSdtDn(hoso !== null && hoso.hasOwnProperty('fiSdtDn') ? hoso.fiSdtDn : user.companyPhoneNumber);
        self.fiFaxDn(hoso !== null && hoso.hasOwnProperty('fiFaxDn') ? hoso.fiFaxDn : null);
        self.fiEmailDn(hoso !== null && hoso.hasOwnProperty('fiEmailDn') ? hoso.fiEmailDn : null);

        if (hoso !== null) {

            self.fiIdHoso(hoso.hasOwnProperty('fiIdHoso') ? hoso.fiIdHoso : null);
            self.fiMaHoso(hoso.hasOwnProperty('fiMaHoso') ? hoso.fiMaHoso : null);

            self.fiSoCv(hoso.hasOwnProperty('fiSoCv') ? hoso.fiSoCv : null);
            self.fiNgaycapCv(hoso.hasOwnProperty('fiNgaycapCv') ? new Date(hoso.fiNgaycapCv) : null);

            self.fiDiadiemKy(hoso.hasOwnProperty('fiDiadiemKy') ? hoso.fiDiadiemKy : null);
            self.fiNguoiKy(hoso.hasOwnProperty('fiNguoiKy') ? hoso.fiNguoiKy : null);
            self.fiNgayKy(hoso.hasOwnProperty('fiNgayKy') ? new Date(hoso.fiNgayKy) : null);

            self.fiMaThutuc(hoso.hasOwnProperty('fiMaThutuc') ? hoso.fiMaThutuc : options.maThuTuc);
            self.fiTenThutuc(hoso.hasOwnProperty('fiTenThutuc') ? hoso.fiTenThutuc : null);
            self.fiNgaygui(hoso.hasOwnProperty('fiNgaygui') ? hoso.fiNgaygui : null);

            self.fiHoatdong(hoso.hasOwnProperty('fiHoatdong') ? hoso.fiHoatdong : 1);
            self.fiNguoitao(hoso.hasOwnProperty('fiNguoitao') ? hoso.fiNguoitao : null);
            self.fiNgaytao(hoso.hasOwnProperty('fiNgaytao') ? new Date(hoso.fiNgaytao) : null);
            self.fiNgCapnhat(hoso.hasOwnProperty('fiNgCapnhat') ? hoso.fiNgCapnhat : null);
            self.fiTrangthai(hoso.hasOwnProperty('fiTrangthai') ? hoso.fiTrangthai : 0);
            self.fiTenTt(hoso.hasOwnProperty('fiTenTt') ? hoso.fiTenTt : null);

            self.fiCqgsBac(hoso.hasOwnProperty('fiCqgsBac') ? hoso.fiCqgsBac : null);
            self.fiMaCqgsBac(hoso.hasOwnProperty('fiMaCqgsBac') ? hoso.fiMaCqgsBac : null);
            self.fiCqgsTrung(hoso.hasOwnProperty('fiCqgsTrung') ? hoso.fiCqgsTrung : null);
            self.fiMaCqgsTrung(hoso.hasOwnProperty('fiMaCqgsTrung') ? hoso.fiMaCqgsTrung : null);
            self.fiCqgsNam(hoso.hasOwnProperty('fiCqgsNam') ? hoso.fiCqgsNam : null);
            self.fiMaCqgsNam(hoso.hasOwnProperty('fiMaCqgsNam') ? hoso.fiMaCqgsNam : null);

            self.lstHanghoas(mapTbdhsHanghoa26(hoso.hasOwnProperty('lstHanghoas') ? hoso.lstHanghoas : []));
        }

        self.hosoErrors.showAllMessages(false);
    };

    self.init(hosoInfo);
    //VALIDATE DATA ON FORM
    //Remove from toJSON
    self.isValidForm = function () {
        delete self.hoangHoaVM;
        delete self.pop;
        //Kiem tra thong tin Ho so
        var errorHoso = true;
        var errorHangHoa = true;

        if (self.hosoErrors().length > 0) {
            self.hosoErrors.showAllMessages();
            errorHoso = false;
            return errorHoso;
        }

        /*if (self.fiNgayKy() == null) {
         alert('Ngày ký là thông tin bắt buộc.');
         errorHoso = false;
         return errorHoso;
         }*/

        if (!self.lstHanghoas() || self.lstHanghoas().length <= 0) {
            self.errorHangHoaMessage('* Chưa khai báo thông tin hàng hoá');
            errorHangHoa = false;
            return errorHangHoa;
        }

        return errorHoso && errorHangHoa;
    };
    //VALIDATE DATA ON FORM

    //XU LY SU KIEN BUTTON, TABLE
    self.removeProductClick = function (item) {
        if (item) {
            var pop = app.popup({
                title: 'Thông báo',
                html: '<b>Bạn chắc chắn muốn xoá dữ liệu của sản phẩm này?</b>',
                width: 450,
                buttons: [
                    {
                        name: NSWLang["common_button_toi_chac_chan"],
                        class: 'btn',
                        icon: 'fa-save',
                        action: function () {
                            self.lstHanghoas.remove(function (o) {
                                return o.group() == item.group();
                            });
                            for (var i = 0; i < self.lstHanghoas().length; i++) {
                                self.lstHanghoas()[i].fiStt(i + 1);
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

    self.addProductOnClick = function () {
        var html = [
            $('#thongtinhanghoa-tmpl').html()
        ].join('');


        var data = {
            item: null,
            inspectionType : options.maThuTuc,
            lstProduct : self.lstHanghoas()
        };

        delete self.pop;
        delete self.hangHoaVM;
        //
        var cb = function () {

            self.pop = app.popup({
                title: 'Danh sách sản phẩm',
                html: html,
                width: 1024,
                buttons: [
                    {
                        name: 'Lưu',
                        class: 'btn',
                        icon: 'fa-save',
                        action: function () {
                            if (!self.hangHoaVM.isValid()) {
                                app.Alert('Bạn phải chọn ít nhất một sản phẩm.');
                            } else {

                                var products = ko.toJS(self.hangHoaVM.lstProduct);
                                for (var i = 0; i < products.length; i++) {
                                    var product = products[i];
                                    product.fiIdXe = -1 * new Date().getTime();
                                    product.fiStt = self.lstHanghoas().length + 1;
                                    var product = new TbdhsHanghoa26(product);
                                    self.lstHanghoas.push(product);
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
            }, function () {
                ko.applyBindings(self.hangHoaVM, document.getElementById('thongtinhanghoa-form'));
            });
        };

        self.hangHoaVM = new HangHoaVM(data);
        self.hangHoaVM.search(cb, self.lstProduct);

        return false;
    };

    self.onCqgsMienNam = function () {
        if (self.fiMaCqgsNam()) {
            self.fiCqgsNam($("#fiMaCqgsNam option:selected").text());
        } else {
            self.fiCqgsNam(null);
        }
    };
    self.onCqgsMienBac = function () {
        if (self.fiMaCqgsBac()) {
            self.fiCqgsBac($("#fiMaCqgsBac option:selected").text());
        } else {
            self.fiCqgsBac(null);
        }
    };
    self.onCqgsMienTrung = function () {
        if (self.fiMaCqgsTrung()) {
            self.fiCqgsTrung($("#fiMaCqgsTrung option:selected").text());
        } else {
            self.fiCqgsTrung(null);
        }
    };
    //XU LY SU KIEN BUTTON, TABLE

    //Convert to json object
    self.toJSON = function () {
        var exclude = ["onCqgsMienTrung", "onCqgsMienBac", "onCqgsMienNam", "updateXeInfo",
            "addProductOnClick", "isValidForm", "init", "hosoErrors", "errorHangHoaMessage",
            "lstCqgsBac", "lstCqgsNam", "lstCqgsTrung", "pop", "hangHoaVM"];
        
        self.fiCqgsNam($("#fiMaCqgsNam option:selected").text());
        self.fiCqgsBac($("#fiMaCqgsBac option:selected").text());
        self.fiCqgsTrung($("#fiMaCqgsTrung option:selected").text());
        
        var model = ko.toJS(self);

        for (var key in model) {
            if (exclude.indexOf(key) >= 0) {
                delete model[key];
            }
        }

        for (var i = 0; i < model.lstHanghoas.length; i++) {
            delete model.lstHanghoas[i]['fiIdHh'];
            delete model.lstHanghoas[i]['fiStt'];
            delete model.lstHanghoas[i]["__ko_mapping__"];
        }

        return model;
    };
}

