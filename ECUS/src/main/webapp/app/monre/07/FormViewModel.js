/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/***
 * 
 * @param {type} opt {
 *  fiIdHoso: String, 
 *  lstItems: [], 
 *  lstSelectedItems: [],
 *  lstTinhThanh: [],
 *  lstQuanHuyen: [],
 *  lstXaPhuong: [],
 *  cb: function(d){} 
 *  }
 * @returns {undefined}
 */

var CoSoSanXuatVM = function (opt) {
    var self = this;
    var MAX_PAGE_SIZE = 4;

    self.fiIdCssx = ko.observable(null);
    self.fiTenCssx = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 230}
    });
    self.fiDiachiCssx = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 230}
    });
    self.fiSdtCssx = ko.observable(null).extend({
        maxLength: {message: 'Tối đa 50 ký tự', params: 50}
    });
    self.fiFaxCssx = ko.observable(null).extend({
        maxLength: {message: 'Tối đa 50 ký tự', params: 50}
    });
    self.fiEmailCssx = ko.observable(null).extend({
        maxLength: {message: 'Tối đa 50 ký tự', params: 50}
    });
    self.fiMaTinh = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 50 ký tự', params: 50}
    });
    self.fiTenTinh = ko.observable(null);
    self.fiMaHuyen = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 50 ký tự', params: 50}
    });
    self.fiTenHuyen = ko.observable(null);
    self.fiMaXaphuong = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 50 ký tự', params: 50}
    });
    self.fiTenXaphuong = ko.observable(null);
    self.fiHoatdong = ko.observable(null);
    self.fiNguoitao = ko.observable(null);
    self.fiNgCapnhat = ko.observable(null);
    self.fiIsSelected = ko.observable(false);

    self.fiIdHoso = ko.observable(opt.hasOwnProperty('fiIdHoso') ? opt.fiIdHoso : 0);
    var callback = opt.cb;
    //Danh sach CSSX do DN tao
    self.lstItems = ko.observableArray(opt ? opt.lstItems : []);
    //Danh sach CSSX do DN chon
    self.lstSelectedItems = ko.observableArray(opt ? opt.lstSelectedItems : []);
    //Danh sach tinh/thanh pho
    self.lstTinhThanh = ko.observableArray(opt ? mapTbsprovince1(opt.lstTinhThanh) : []);
    //Danh sach Quan/Huyen
    self.lstQuanHuyen = ko.observableArray([]);
    //Danh sach Xa/Phuong
    self.lstXaPhuong = ko.observableArray([]);

    var propValidate = [self.fiTenCssx, self.fiDiachiCssx, self.fiMaTinh, self.fiMaHuyen, self.fiMaXaphuong];
    self.lstErrors = ko.validation.group(propValidate, {deep: true, live: true, observable: true});
    self.lstErrors.showAllMessages(false);
    //
    self.initData = function (d) {
        self.fiIdCssx(d ? d.fiIdCssx : null);
        self.fiTenCssx(d ? d.fiTenCssx : null);
        self.fiDiachiCssx(d ? d.fiDiachiCssx : null);
        self.fiSdtCssx(d ? d.fiSdtCssx : null);
        self.fiFaxCssx(d ? d.fiFaxCssx : null);
        self.fiEmailCssx(d ? d.fiEmailCssx : null);
        self.fiMaTinh(d ? d.fiMaTinh : null);
        self.fiTenTinh(d ? d.fiTenTinh : null);
        self.fiMaHuyen(d ? d.fiMaHuyen : null);
        self.fiTenHuyen(d ? d.fiTenHuyen : null);
        self.fiMaXaphuong(d ? d.fiMaXaphuong : null);
        self.fiTenXaphuong(d ? d.fiTenXaphuong : null);
        self.fiHoatdong(d ? d.fiHoatdong : null);
        self.fiNguoitao(d ? d.fiNguoitao : null);
        self.fiNgCapnhat(d ? d.fiNgCapnhat : null);
        self.fiIsSelected(d ? d.fiIsSelected : false);
    };

    self.getFormData = function () {
        var item = null;
        item = new Tbdcososx7(0, {
            fiIdCssx: self.fiIdCssx() ? self.fiIdCssx() : -1 * new Date().getTime(),
            fiTenCssx: self.fiTenCssx(),
            fiDiachiCssx: self.fiDiachiCssx(),
            fiSdtCssx: self.fiSdtCssx(),
            fiFaxCssx: self.fiFaxCssx(),
            fiEmailCssx: self.fiEmailCssx(),
            fiMaTinh: self.fiMaTinh(),
            fiTenTinh: $('#fiMaTinh option:selected').text(),
            fiMaHuyen: self.fiMaHuyen(),
            fiTenHuyen: $('#fiMaHuyen option:selected').text(),
            fiMaXaphuong: self.fiMaXaphuong(),
            fiTenXaphuong: $('#fiMaXaphuong option:selected').text(),
            fiHoatdong: 1,
            fiNguoitao: self.fiNguoitao(),
            fiNgCapnhat: self.fiNgCapnhat(),
            fiIsSelected: self.fiIsSelected()
        });

        return item;
    };

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

    self.search = function (cb) {
        var data = {
            currentPage: self.currentPage() - 1 < 0 ? 0 : self.currentPage() - 1,
            pageSize: self.pageSize()
        };

        app.makePost({
            url: '/monre/07/cssx/search',
            data: JSON.stringify(data),
            success: function (res) {
                if (res.success) {
                    var list = res.data ? mapTbdcososx7(res.data) : [];
                    self.lstItems([]);
                    self.lstItems(list);
                    for (var i = 0; i < self.lstSelectedItems().length; i++) {
                        var cssxItem = self.lstSelectedItems()[i];

                        var index = self.lstItems.firstIndexOf(function (item) {
                            return item.fiIdCssx() == cssxItem.fiIdCssx();
                        });

                        if (index >= 0) {
                            self.lstItems()[index].fiIsSelected(true);
                        }
                    }

                    self.totalCount(res.data ? res.total : 0);

                    self.paging().update({
                        totalCount: res.data ? res.total : 0,
                        pageSize: self.pageSize(),
                        currentPage: self.currentPage()
                    });

                    if (cb) {
                        cb();
                    }
                }
            },
            error: function (e) {
                app.Alert('Không lấy được dữ liệu danh mục Cơ sơ sản xuất.');
                return;
            }
        });
    };

    self.btnLuuCSSXClick = function () {
        if (self.lstErrors().length > 0) {
            self.lstErrors.showAllMessages();
            return;
        }
        //Save data
        var newItem = self.getFormData();

        var onSuccess = function () {
            //Update lai danh sach CSSX ma DN da chon cho ho so neu co
            var index = self.lstSelectedItems.firstIndexOf(function (item) {
                return item.fiIdCssx() == self.fiIdCssx();
            });

            if (index >= 0) {
                self.lstSelectedItems()[index].fiIdCssx(newItem.fiIdCssx());
                self.lstSelectedItems()[index].fiTenCssx(newItem.fiTenCssx());
                self.lstSelectedItems()[index].fiDiachiCssx(newItem.fiDiachiCssx());
                self.lstSelectedItems()[index].fiSdtCssx(newItem.fiSdtCssx());
                self.lstSelectedItems()[index].fiFaxCssx(newItem.fiFaxCssx());
                self.lstSelectedItems()[index].fiEmailCssx(newItem.fiEmailCssx());
                self.lstSelectedItems()[index].fiMaTinh(newItem.fiMaTinh());
                self.lstSelectedItems()[index].fiTenTinh(newItem.fiTenTinh());
                self.lstSelectedItems()[index].fiMaHuyen(newItem.fiMaHuyen());
                self.lstSelectedItems()[index].fiTenHuyen(newItem.fiTenHuyen());
                self.lstSelectedItems()[index].fiMaXaphuong(newItem.fiMaXaphuong());
                self.lstSelectedItems()[index].fiTenXaphuong(newItem.fiTenXaphuong());
                self.lstSelectedItems()[index].fiHoatdong(newItem.fiHoatdong());
                self.lstSelectedItems()[index].fiNguoitao(newItem.fiNguoitao());
                self.lstSelectedItems()[index].fiNgCapnhat(newItem.fiNgCapnhat());
                self.lstSelectedItems()[index].fiIsSelected(newItem.fiIsSelected());

                callback(self.lstSelectedItems());
            }

            self.search(null);
            self.lstErrors.showAllMessages(false);
        };

        app.makePost({
            url: self.fiIdCssx() ? '/monre/07/cssx/update' : '/monre/07/cssx/insert',
            data: JSON.stringify(ko.toJS(newItem)),
            success: function (res) {
                if (res.success) {
                    onSuccess();
                } else {
                    app.Alert('Lưu dữ liệu không thành công, vui lòng thử lại!');
                    return;
                }
            },
            error: function (e) {
                app.Alert('Lưu dữ liệu không thành công, vui lòng thử lại!');
                console.log('exception: ', e);
                return;
            }
        });

        self.resetForm();
    };

    //Reset form nhap
    self.resetForm = function () {
        self.initData(null);
        self.lstErrors.showAllMessages(false);
    };

    //Remove from toJSON
    self.bSuaCSSXClick = function (item) {
        if (item) {
            var cb = function () {                
                self.fiIdCssx(item.fiIdCssx());
                self.fiTenCssx(item.fiTenCssx());
                self.fiDiachiCssx(item.fiDiachiCssx());
                self.fiSdtCssx(item.fiSdtCssx());
                self.fiFaxCssx(item.fiFaxCssx());
                self.fiEmailCssx(item.fiEmailCssx());
                self.fiMaTinh(item.fiMaTinh());
                self.fiTenTinh(item.fiTenTinh());
                self.fiMaHuyen(item.fiMaHuyen());
                self.fiTenHuyen(item.fiTenHuyen());
                self.fiMaXaphuong(item.fiMaXaphuong());
                self.fiTenXaphuong(item.fiTenXaphuong());
                self.fiHoatdong(item.fiHoatdong());
                self.fiNguoitao(item.fiNguoitao());
                self.fiNgCapnhat(item.fiNgCapnhat());
                $("#fiMaHuyen").select2('destroy').val(self.fiMaHuyen()).select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
                $("#fiMaXaphuong").select2('destroy').val(self.fiMaXaphuong()).select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
                $("#fiMaTinh").select2('destroy').val(self.fiMaTinh()).select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
            };
            $.when(
                    getCategory("QUANHUYEN", item.fiMaTinh(), function (res) {
                        if (res.success) {
                            self.lstQuanHuyen(mapTbsdistrict1(res.data));
                        }
                    }),
                    getCategory("XAPHUONG", item.fiMaHuyen(), function (res) {
                        if (res.success) {
                            self.lstXaPhuong(mapTbsward1(res.data));
                        }
                    })
                    ).done(function (d) {
                cb();
            });
        }
    };
    //Remove from toJSON 
    self.bXoaCSSXClick = function (item) {
        if (item) {
            //Post data to server
            var data = {

            };
            app.makePost({
                url: '/monre/07/cssx/delete/' + (self.fiIdHoso() ? self.fiIdHoso() : 0) + '/' + item.fiIdCssx(),
                data: JSON.stringify(data),
                success: function (res) {
                    if (res.success) {
                        self.search(null);
                        app.Alert('Xoá dữ liệu danh mục thành công!');
                        //Cap nhat lai du lieu danh sach
                        self.lstItems.remove(function (o) {
                            return o.fiIdCssx() == item.fiIdCssx();
                        });
                        //Cap nhat lai danh sach CSSX ma DN chon cho ho so
                        self.lstSelectedItems.remove(function (o) {
                            return o.fiIdCssx() == item.fiIdCssx();
                        });
                        callback(self.lstSelectedItems());
                    } else {
                        app.Alert('Danh mục dữ liệu đang được sử dụng!');
                        return;
                    }
                },
                error: function (e) {
                    app.Alert('Xoá dữ liệu không thành công, vui lòng thử lại!');
                    console.log('exception: ', e);
                    return;
                }
            });
        } else {
            app.Alert('Bạn phải chọn danh mục cần xoá');
            return;
        }
    };

    self.toggleAssociation = function (item) {
        if (item.fiIsSelected()) {
            self.lstSelectedItems().push(item);
        } else {

            self.lstSelectedItems.remove(function (o) {
                return o.fiIdCssx() == item.fiIdCssx();
            });
        }
        return true;
    };

    self.fiTinhThanhChange = function () {
        if (self.fiMaTinh()) {
            getCategory("QUANHUYEN", self.fiMaTinh(), function (res) {
                if (res.success) {
                    self.lstQuanHuyen(mapTbsdistrict1(res.data));
                }
            });
        }
    };

    self.fiQuanHuyenChange = function () {
        if (self.fiMaHuyen()) {
            getCategory("XAPHUONG", self.fiMaHuyen(), function (res) {
                if (res.success) {
                    self.lstXaPhuong(mapTbsward1(res.data));
                }
            });
        }
    };
    
    //Remove from toJSON 
    self.btnResetClick = function(){
        self.resetForm();
    };
};

function Monre07FormVM(options)
{
    var self = this;

    var hosoInfo = (options !== null && options.hasOwnProperty('hoso')) ? options.hoso : null;

    self.fiIdHoso = ko.observable(null);
    self.fiMaHoso = ko.observable(null);
    self.fiMaCqCap = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 50 ký tự', params: 50}
    });
    self.fiTenCqCap = ko.observable(null);
    self.fiMstDn = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 13 ký tự', params: 13}
    });
    self.fiTenDn = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiSoDkkd = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiNgaycapDkkd = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiNoicapDkkd = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiDiachiTsc = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiSoGxn = ko.observable(null).extend({
        maxLength: {message: 'Tối đa 100 ký tự', params: 100}
    });
    self.fiNgaycapGxn = ko.observable(null);
    self.fiCqCapGxn = ko.observable(null).extend({
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });

    self.fiNgaygui = ko.observable(null);
    self.fiSoVbCt = ko.observable(null);
    self.fiNgaycapVb = ko.observable(null);

    self.fiHoatdong = ko.observable(null);
    self.fiNguoitao = ko.observable(null);
    self.fiNgaytao = ko.observable(null);
    self.fiNgCapnhat = ko.observable(null);
    self.fiTrangthai = ko.observable(0);
    self.fiTenTt = ko.observable(null);

    self.fiSdtDn = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 50 ký tự', params: 50}
    });
    self.fiFaxDn = ko.observable(null).extend({
        maxLength: {message: 'Tối đa 50 ký tự', params: 50}
    });
    self.fiEmailDn = ko.observable(null).extend({
        maxLength: {message: 'Tối đa 50 ký tự', params: 50}
    });

    self.lstCosoSx = ko.observableArray([]);
    self.lstPheLieu = ko.observableArray([]);
    self.lstDonViXuLy = ko.observableArray(options ? options.lstDonViXuLy : []);
    self.lstTinhThanh = ko.observableArray(options ? options.lstTinhThanh : []);

    var hosoVG = [self.fiTenDn, self.fiMaCqCap, self.fiMstDn, self.fiDiachiTsc, self.fiSoDkkd, self.fiNgaycapDkkd
                , self.fiNoicapDkkd, self.fiSoGxn];

    self.hosoErrors = ko.validation.group(hosoVG, {deep: true, live: true, observable: true});

    //Thong tin Phe lieu nhap khau
    self.fiIdPl = ko.observable(null);
    self.fiTenPl = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiMaHs = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiKhoiluong = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        number: {message: 'Giá trị nhập vào phải là số', params: true},
        pattern: {
            message: 'Phải nhập giá trị với tối đa 3 số ở phần thập phân ví dụ: 1.234',
            params: '^[0-9]{0,15}(?:\.[0-9]{0,3})?$'
        }
    });
    //fiIdHoso, fiHoatdong, fiNguoitao, fiNgaytao, fiNgCapnhat

    var lohangVG = [self.fiTenPl, self.fiMaHs, self.fiKhoiluong];
    self.lohangErrors = ko.validation.group(lohangVG, {deep: true, live: true, observable: true});
    self.errorCSSXMessage = ko.observable(null);
    self.errorPheLieuMessage = ko.observable(null);

    self.init = function (hoso) {
        self.fiTenDn(hoso !== null && hoso.hasOwnProperty('fiTenDn') ? hoso.fiTenDn : user.companyName);
        self.fiMstDn(hoso !== null && hoso.hasOwnProperty('fiMstDn') ? hoso.fiMstDn : user.username);
        self.fiDiachiTsc(hoso !== null && hoso.hasOwnProperty('fiDiachiTsc') ? hoso.fiDiachiTsc : user.companyAddress);
        self.fiSoDkkd(hoso !== null && hoso.hasOwnProperty('fiSoDkkd') ? hoso.fiSoDkkd : null);
        self.fiNgaycapDkkd(hoso !== null && hoso.hasOwnProperty('fiNgaycapDkkd') ? new Date(hoso.fiNgaycapDkkd) : null);
        self.fiNoicapDkkd(hoso !== null && hoso.hasOwnProperty('fiNoicapDkkd') ? hoso.fiNoicapDkkd : null);
        self.fiSdtDn(hoso !== null && hoso.hasOwnProperty('fiSdtDn') ? hoso.fiSdtDn : user.companyPhoneNumber);
        if (hoso !== null) {
            self.fiFaxDn(hoso !== null && hoso.hasOwnProperty('fiFaxDn') ? hoso.fiFaxDn : null);
            self.fiEmailDn(hoso !== null && hoso.hasOwnProperty('fiEmailDn') ? hoso.fiEmailDn : null);

            self.fiIdHoso(hoso.hasOwnProperty('fiIdHoso') ? hoso.fiIdHoso : null);
            self.fiMaHoso(hoso.hasOwnProperty('fiMaHoso') ? hoso.fiMaHoso : null);
            self.fiMaCqCap(hoso.hasOwnProperty('fiMaCqCap') ? hoso.fiMaCqCap : null);
            self.fiTenCqCap(hoso.hasOwnProperty('fiTenCqCap') ? hoso.fiTenCqCap : null);

            self.fiSoGxn(hoso.hasOwnProperty('fiSoGxn') ? hoso.fiSoGxn : null);
            self.fiNgaycapGxn(hoso.hasOwnProperty('fiNgaycapGxn') ? (hoso.fiNgaycapGxn ? new Date(hoso.fiNgaycapGxn) : null) : null);
            self.fiCqCapGxn(hoso.hasOwnProperty('fiCqCapGxn') ? hoso.fiCqCapGxn : null);

            self.fiNgaygui(hoso.hasOwnProperty('fiNgaygui') ? (hoso.fiNgaygui ? new Date(hoso.fiNgaygui) : null) : null);
            self.fiSoVbCt(hoso.hasOwnProperty('fiSoVbCt') ? hoso.fiSoVbCt : null);
            self.fiNgaycapVb(null);

            self.fiHoatdong(hoso.hasOwnProperty('fiHoatdong') ? hoso.fiHoatdong : null);
            self.fiNguoitao(hoso.hasOwnProperty('fiNguoitao') ? hoso.fiNguoitao : null);
            self.fiNgaytao(hoso.hasOwnProperty('fiNgaytao') ? new Date(hoso.fiNgaytao) : null);
            self.fiNgCapnhat(hoso.hasOwnProperty('fiNgCapnhat') ? hoso.fiNgCapnhat : null);
            self.fiTrangthai(hoso.hasOwnProperty('fiTrangthai') ? hoso.fiTrangthai : null);
            self.fiTenTt(hoso.hasOwnProperty('fiTenTt') ? hoso.fiTenTt : null);
            
            self.lstCosoSx(hoso.hasOwnProperty('lstCosoSx') ? mapTbdcososx7(hoso.lstCosoSx) : []);
            self.lstPheLieu(hoso.hasOwnProperty('lstPheLieu') ? mapTbdphelieu7(hoso.lstPheLieu) : []);
        }

        if (!self.fiMaCqCap()) {
            self.fiMaCqCap('000');
            self.fiTenCqCap($('#fiMaCqCap').find("option:selected").text());
        }

        $("#fiMaCqCap").val(self.fiMaCqCap()).select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
        self.hosoErrors.showAllMessages(false);
    };

    self.init(hosoInfo);
    //VALIDATE DATA ON FORM
    //Remove from toJSON
    self.isValidForm = function () {
        if (self.hosoErrors().length > 0) {
            self.hosoErrors.showAllMessages();
            return false;
        }

        var errorHanghoa = false;

        if (!self.lstPheLieu() || self.lstPheLieu().length <= 0) {
            self.errorPheLieuMessage('* Chưa khai báo thông tin lô hàng');
            return errorHanghoa;
        }

        if (self.lstPheLieu() && self.lstPheLieu().length > 0) {
            for (var i = 0; i < self.lstPheLieu().length; i++) {
                var hh = self.lstPheLieu()[i];
                if (!hh.fiIdPl() || !hh.fiMaHs() || !hh.fiKhoiluong() || !hh.fiTenPl()) {
                    errorHanghoa = true;
                    break;
                }
            }
        }
        if (errorHanghoa) {
            self.errorPheLieuMessage('* Bổ sung thêm thông tin của phế liệu trước khi lưu dữ liệu');
        }
        return self.hosoErrors().length <= 0 && !errorHanghoa;
    };
    //VALIDATE DATA ON FORM

    //XU LY SU KIEN BUTTON, TABLE
    //Remove from toJSON
    self.btnThemPhelieuClick = function () {
        if (self.lohangErrors().length > 0) {
            self.lohangErrors.showAllMessages();
            return;
        }
        if (!self.fiIdPl()) {
            var newItem = new Tbdphelieu7(self.lstPheLieu().length + 1, {
                fiIdPl: -1 * new Date().getTime(),
                fiMaHs: self.fiMaHs(),
                fiKhoiluong: self.fiKhoiluong(),
                fiIdHoso: self.fiIdHoso(),
                fiTenPl: self.fiTenPl()
            });
            self.lstPheLieu.push(newItem);
        } else {
            var index = self.lstPheLieu.firstIndexOf(function (item) {
                return item.fiIdPl() == self.fiIdPl();
            });

            if (index >= 0) {
                self.lstPheLieu()[index].fiIdPl(self.fiIdPl());
                self.lstPheLieu()[index].fiTenPl(self.fiTenPl());
                self.lstPheLieu()[index].fiMaHs(self.fiMaHs());
                self.lstPheLieu()[index].fiKhoiluong(self.fiKhoiluong());
                self.lstPheLieu()[index].fiIdHoso(self.fiIdHoso());
            }
        }

        self.resetPheLieuForm();
    };
    //Remove from toJSON
    self.bSuaPhelieuClick = function (item) {
        if (item) {
            self.fiIdPl(item.fiIdPl());
            self.fiTenPl(item.fiTenPl());
            self.fiMaHs(item.fiMaHs());
            self.fiKhoiluong(item.fiKhoiluong());
        }
    };
    //Remove from toJSON 
    self.bXoaPhelieuClick = function (item) {
        if (item) {
            self.lstPheLieu.remove(function (o) {
                return o.fiIdPl() == item.fiIdPl();
            });
        }
    };
    //Remove from toJSON 
    self.bResetClick = function () {
        self.resetPheLieuForm();
    };
    
    //Remove from toJSON 
    self.bXoaCoSoSxClick = function (item) {
        if (item) {
            self.lstCosoSx.remove(function (o) {
                return o.fiIdCssx() == item.fiIdCssx();
            });
        }
    };
        
    self.bThemCoSoSxClick = function () {
        var html = [
            $('#cssx-tmpl').html()
        ].join('');
        delete self.coSoSanXuatVM;
        delete self.cssxPop;

        var cb = function () {
            self.cssxPop = app.popup({
                title: '',
                html: html,
                width: 1000,
                buttons: [
                    {
                        name: 'Chọn',
                        class: 'btn blue',
                        icon: 'fa-check',
                        action: function () {
                            if (!self.coSoSanXuatVM) {
                                return;
                            }
                            self.lstCosoSx([]);
                            self.lstCosoSx(self.coSoSanXuatVM.lstSelectedItems());
                            app.popupRemove(self.cssxPop.selector);
                        }
                    },
                    {
                        name: 'Đóng',
                        class: 'btn blue',
                        icon: 'fa-close',
                        action: function () {                            
                            app.popupRemove(self.cssxPop.selector);
                        }
                    }
                ]
            }, function () {
                $("#fiMaHuyen").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
                $("#fiMaXaphuong").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
                $("#fiMaTinh").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
                ko.applyBindings(self.coSoSanXuatVM, document.getElementById('cssx-form'));
                self.coSoSanXuatVM.lstErrors.showAllMessages(false);
            });
        };

        self.coSoSanXuatVM = new CoSoSanXuatVM({
            fiIdHoso: self.fiIdHoso(),
            lstItems: [],
            lstSelectedItems: self.lstCosoSx(),
            lstTinhThanh: self.lstTinhThanh(),
            cb: function (d) {
                self.lstCosoSx(d);
            }
        });
        self.coSoSanXuatVM.search(cb);

        return false;
    };
    /**
     * Xem chi tiet CSSX
     * @param {type} item
     * @returns {Boolean}
     */
    self.bXemCoSoSxClick = function (item) {
        var html = [
            $('#cssx-tmpl').html()
        ].join('');
        
        self.cssxPop = app.popup({
            title: 'Thông tin cơ sở sản xuất',
            html: html,
            width: 1000,
            buttons: [                
                {
                    name: 'Đóng',
                    class: 'btn blue',
                    icon: 'fa-close',
                    action: function () {                            
                        app.popupRemove(self.cssxPop.selector);
                        delete self.cssxPop;
                    }
                }
            ]
        }, function () {            
            ko.applyBindings(item, document.getElementById('cssx-form'));
        });

        return false;
    };
    //XU LY SU KIEN BUTTON, TABLE

    //HAM XU LY    
    //Remove from toJSON
    self.resetPheLieuForm = function () {
        self.fiIdPl(null);
        self.fiTenPl(null);
        self.fiMaHs(null);
        self.fiKhoiluong(null);
        self.lohangErrors.showAllMessages(false);
    };
    //Convert to json object
    self.toJSON = function () {
        self.fiTenCqCap($('#fiMaCqCap').find("option:selected").text());
        var mapping = {
            'ignore': ["resetPheLieuForm", "bThemCoSoSxClick", "bXoaCoSoSxClick", "bXoaPhelieuClick",
                "bSuaPhelieuClick", "btnThemPhelieuClick", "isValidForm", "init",
                "toJSON", "lohangErrors", "__ko_mapping__", "errorCSSXMessage", 'errorPheLieuMessage',
                'fiKhoiluong', 'fiMaHs', 'fiTenPl', 'fiIdPl', 'hosoErrors', 'lstTinhThanh', 'lstDonViXuLy',
                'cssxPop', 'coSoSanXuatVM']
        };

        var copy = ko.mapping.fromJS(self, mapping);
        copy = ko.toJS(copy);

        delete copy['__ko_mapping__'];
        return copy;
    };
}
