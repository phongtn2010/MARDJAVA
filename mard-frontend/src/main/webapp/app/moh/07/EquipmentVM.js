/**
 * {
 *      fiIdHanghoa: fiIdHanghoa, //Id cua bang hang hoa
 *      fiMstCsbh: fiMstCsbh,//ma so thue DN
 *      lstBaoHanhHangHoas: [],//Danh sach csbh da luu vao don
 *      lstBaoHanh: []//Danh sach csbh danh muc cua doanh nghiep
 * }
 * 
 * 
 */

/**
 * 
 * @param {type} data
 * @returns {undefined}
 */
function CoSoBaoHanhVM(data) {
    var self = this;

    self.fiIdCsbh = ko.observable(data.hasOwnProperty('fiIdCsbh') ? data.fiIdCsbh : null);
    self.fiStt = ko.observable(data.hasOwnProperty('fiStt') ? data.fiStt : null);
    self.fiMst = ko.observable(data.hasOwnProperty('fiMst') ? data.fiMst : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });

    self.fiTenCsbh = ko.observable(data.hasOwnProperty('fiTenCsbh') ? data.fiTenCsbh : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });

    self.fiDiachiCsbh = ko.observable(data.hasOwnProperty('fiDiachiCsbh') ? data.fiDiachiCsbh : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });

    self.fiSdtCdCsbh = ko.observable(data.hasOwnProperty('fiSdtCdCsbh') ? data.fiSdtCdCsbh : null);
    self.fiSdtDdCsbh = ko.observable(data.hasOwnProperty('fiSdtDdCsbh') ? data.fiSdtDdCsbh : null);

    self.currentPage = ko.observable(0);
    self.pageSize = ko.observable(6);
    self.totalCount = ko.observable(0);

    self.paging = ko.observable(new PagingVM({
        pageSize: self.pageSize(),
        totalCount: 0
    }));

    self.paging().currentPage.subscribe(function (newCurrentPage) {
        self.currentPage(newCurrentPage);
        self.search(null);
    });

    var vg = [self.fiMst, self.fiTenCsbh, self.fiDiachiCsbh];
    self.tbErrors = ko.validation.group(vg, {deep: true, live: true, observable: true});

    var lstBaoHanhHangHoas = data.hasOwnProperty('lstBaoHanhHangHoas') ? data.lstBaoHanhHangHoas : [];
    var lstBaoHanh = data.hasOwnProperty('lstBaoHanh') ? data.lstBaoHanh : [];

    //Danh sach csbh doanh nghiep da chon
    self.lstBaoHanhHangHoas = ko.observableArray(lstBaoHanhHangHoas);
    //Danh sach csbh cua doanh nghiep da tao
    self.lstBaoHanh = ko.observableArray(mapTbdCsbaohanh7(lstBaoHanh, lstBaoHanhHangHoas));

    self.isVaild = function () {
        //console.log(self.tbErrors());
        if (self.tbErrors().length > 0) {
            self.tbErrors.showAllMessages();
            return false;
        }
        return true;
    };

    self.onLuuCoSoBaoHanh = function () {
        if (self.isVaild()) {
            var data = {
                fiIdCsbh: self.fiIdCsbh(),
                fiMst: self.fiMst(),
                fiTenCsbh: self.fiTenCsbh(),
                fiDiachiCsbh: self.fiDiachiCsbh(),
                fiSdtCdCsbh: self.fiSdtCdCsbh(),
                fiSdtDdCsbh: self.fiSdtDdCsbh(),
                fiStt: self.fiStt()
            };
            var url = '/moh/07/csbh/taomoi';
            if (null == self.fiIdCsbh()) {
                url = '/moh/07/csbh/taomoi';
                data.fiIdCsbh = -1 * new Date().getTime();
                data.fiStt = self.lstBaoHanh().length + 1;
                self.lstBaoHanh.push(new TbdCsbaohanh7(data, null));
            } else {
                url = '/moh/07/csbh/capnhap';
                for (var i = 0; i < self.lstBaoHanh().length; i++) {
                    if (self.fiIdCsbh() == self.lstBaoHanh()[i].fiIdCsbh()) {
                        var item = new TbdCsbaohanh7(data, null);
                        self.lstBaoHanh.replace(self.lstBaoHanh()[i], item);
                        break;
                    }
                }
            }
            app.makePost({
                url: url,
                data: JSON.stringify(data),
                success: function (d) {
                    if (d && d.success) {
                        self.fiIdCsbh(d.data.fiIdCsbh);
                        self.search();
                        self.clearForm();
                    } else {
                        app.Alert('Không lưu được dữ liệu cơ sở bảo hành.');
                    }
                },
                error: function (e) {
                    app.Alert('Không lưu được dữ liệu cơ sở bảo hành.');
                }
            });

        }
    };

    self.onXoaCoSoBaoHanh = function (item) {
        delete self.popConfirm;
        self.popConfirm = app.popup({
            title: 'Thông báo',
            html: '<b>Bạn chắc chắn muốn xoá dữ liệu này?</b>',
            width: 450,
            buttons: [
                {
                    name: NSWLang["common_button_toi_chac_chan"],
                    class: 'btn',
                    icon: 'fa-save',
                    action: function () {
                        //TODO: Post len server de xoa du lieu tren server
                        //Xoa luon trong danh sach ma Doanh nghiep chon(neu co)
                        app.makePost({
                            url: '/moh/07/csbh/xoa/' + item.fiIdCsbh(),
                            data: JSON.stringify({}),
                            success: function (d) {
                                if (d && d.success) {
                                    self.lstBaoHanh.remove(function (o) {
                                        return o.fiIdCsbh() == item.fiIdCsbh();
                                    });
                                    for (var i = 0; i < self.lstBaoHanh().length; i++) {
                                        self.lstBaoHanh()[i].fiStt(i + 1);
                                    }
                                    self.search();
                                    app.popupRemove(self.popConfirm.selector);
                                    delete self.popConfirm;
                                } else {
                                    app.Alert('Không lưu được dữ liệu cơ sở bảo hành.');
                                }
                            },
                            error: function (e) {
                                app.Alert('Không lưu được dữ liệu cơ sở bảo hành.');
                            }
                        });
                    }
                },
                {
                    name: 'Đóng',
                    class: 'btn',
                    icon: 'fa-close',
                    action: function () {
                        app.popupRemove(self.popConfirm.selector);
                        delete self.popConfirm;
                    }
                }
            ]
        });
        return;
    };

    self.onSuaCoSoBaoHanh = function (item) {
        self.fiMst(item.fiMst());
        self.fiTenCsbh(item.fiTenCsbh());
        self.fiDiachiCsbh(item.fiDiachiCsbh());
        self.fiSdtCdCsbh(item.fiSdtDdCsbh());
        self.fiSdtDdCsbh(item.fiSdtDdCsbh());
        self.fiIdCsbh(item.fiIdCsbh());
        self.fiStt(item.fiStt());
    };

    self.onChecked = function (item) {
        //item.fiDaChon(!item.fiDaChon());
        var find = false;

        for (var i = 0; i < self.lstBaoHanhHangHoas().length; i++) {
            var o = self.lstBaoHanhHangHoas()[i];

            if (o.fiIdCsbh() == item.fiIdCsbh()) {
                o.fiTenCsbh(item.fiTenCsbh());
                o.fiDiachiCsbh(item.fiDiachiCsbh());
                o.fiSdtCdCsbh(item.fiSdtCdCsbh());
                o.fiSdtDdCsbh(item.fiSdtDdCsbh());
                find = true;
                break;
            }
        }

        if (!find) {
            self.lstBaoHanhHangHoas().push(new TbdhsHhBaohanh7({
                fiIdCsbh: item.fiIdCsbh(),
                fiMstCsbh: item.fiMst(),
                fiTenCsbh: item.fiTenCsbh(),
                fiDiachiCsbh: item.fiDiachiCsbh(),
                fiSdtCdCsbh: item.fiSdtCdCsbh(),
                fiSdtDdCsbh: item.fiSdtDdCsbh(),
                fiStt: self.lstBaoHanhHangHoas().length + 1
            }));
        }
        return true;
    };

    self.clearForm = function () {
        self.fiIdCsbh(null);
        self.fiTenCsbh(null);
        self.fiDiachiCsbh(null);
        self.fiSdtCdCsbh(null);
        self.fiSdtDdCsbh(null);
    };

    self.toJSON = function () {
        var model = ko.toJS(self);
        return model.lstBaoHanhHangHoas;
    };

    self.search = function (cb) {
        app.makePost({
            url: '/moh/07/csbh/search',
            data: JSON.stringify({
                currentPage: self.currentPage() - 1 < 0 ? 0 : self.currentPage() - 1,
                pageSize: self.pageSize()
            }),
            success: function (d) {
                if (d && d.success) {
                    var list = d.data ? mapTbdCsbaohanh7(d.data, lstBaoHanhHangHoas) : [];
                    self.lstBaoHanh([]);
                    self.lstBaoHanh(list);
                    self.totalCount(d.data ? d.total : 0);

                    self.paging().update({
                        totalCount: d.data ? d.total : 0,
                        pageSize: self.pageSize(),
                        currentPage: self.currentPage()
                    });
                    if (cb) {
                        cb();
                    }
                } else {
                    if (cb) {
                        cb();
                    }
                    app.Alert('Không lấy được dữ liệu cơ sở bảo hành.');
                }
            },
            error: function (e) {
                if (cb) {
                    cb();
                }
                app.Alert('Không lấy được dữ liệu cơ sở bảo hành.');
            }
        });
    };

}

function ChungLoaiVM(data, formVM) {
    var self = this;

    self.fiIdHhLoai = ko.observable(data.hasOwnProperty('fiIdHhLoai') ? data.fiIdHhLoai : (-1 * new Date().getTime()));
    self.fiStt = ko.observable(data.hasOwnProperty('fiStt') ? data.fiStt : null);
    self.fiIdHanghoa = ko.observable(data.hasOwnProperty('fiIdHanghoa') ? data.fiIdHanghoa : null);
    self.fiMaSpCl = ko.observable(data.hasOwnProperty('fiMaSpCl') ? data.fiMaSpCl : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });

    self.fiDongGoiCl = ko.observable(data.hasOwnProperty('fiDongGoiCl') ? data.fiDongGoiCl : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });

    var vg = [self.fiMaSpCl, self.fiDongGoiCl];
    self.tbErrors = ko.validation.group(vg, {deep: true, live: true, observable: true});

    self.errorCssxMessage = ko.observable(false);
    self.errorCssxFile = ko.observable(false);
    
    self.lstDinhKemHangHoas = ko.observableArray([]);
    
    var lstDinhKemHangHoas = data.hasOwnProperty('lstDinhKemHangHoas') ? data.lstDinhKemHangHoas : [];
    
    console.log(lstDinhKemHangHoas);
    var lstDinhKems = data.hasOwnProperty('lstTTBinhKems') ? data.lstTTBinhKems : [];
    if (lstDinhKemHangHoas.length > 0) {        
        self.lstDinhKemHangHoas(mapFilesVM(lstDinhKemHangHoas, null, formVM, 'frame3'));
    } else {
        var listFiles = [];
        $(lstDinhKems).each(function (index, item) {
            var pItem = {
                fiIdDinhKem: null,
                fiIdDt: null,
                fiLoaiDt: null,
                fiMaTep: null,
                fiLoaiTep: item.id,
                fiTenTep: null,
                fiTenLoaiTep: item.name,
                fiDuongDan: null,
                fiPathLocal: null,
                fiGuiId: null,
                fiBatBuoc: false
            };
            listFiles.push(pItem);
        });
        self.lstDinhKemHangHoas(mapFilesVM(listFiles, null, formVM, 'frame3'));
    }

    self.lstCssxHangHoas = ko.observableArray([]);
    self.lstCssxHangHoas(mapTbdhsHhCssx7(data.hasOwnProperty('lstCssxHangHoas') ? data.lstCssxHangHoas : []));

    self.lstQuocGia = ko.observableArray(data.hasOwnProperty('lstQuocGia') ? data.lstQuocGia : []);
    
    self.onXoaCoSoSanXuat = function (item) {
        delete self.popConfirm;
        self.popConfirm = app.popup({
            title: 'Thông báo',
            html: '<b>Bạn chắc chắn muốn xoá dữ liệu này?</b>',
            width: 450,
            buttons: [
                {
                    name: NSWLang["common_button_toi_chac_chan"],
                    class: 'btn',
                    icon: 'fa-save',
                    action: function () {
                        self.lstCssxHangHoas.remove(function (o) {
                            return o.fiIdHhCssx() == item.fiIdHhCssx();
                        });
                        for (var i = 0; i < self.lstCssxHangHoas().length; i++) {
                            self.lstCssxHangHoas()[i].fiStt(i + 1);
                        }
                        app.popupRemove(self.popConfirm.selector);
                        delete self.popConfirm;
                    }
                },
                {
                    name: 'Đóng',
                    class: 'btn',
                    icon: 'fa-close',
                    action: function () {
                        app.popupRemove(self.popConfirm.selector);
                        delete self.popConfirm;
                    }
                }
            ]
        });
        return;
    };

    self.onThemMoiCSSX = function () {
        self.lstCssxHangHoas.push(new TbdhsHhCssx7({
            fiIdHhCssx: -1 * new Date().getTime(),
            fiStt: self.lstCssxHangHoas().length + 1,
            fiIdHhLoai: self.fiIdHhLoai(),
            fiTenCssx: null,
            fiDiachiCssx: null,
            fiTenQgSx: null,
            fiMaQgSx: null
        }));
        $('#chungloai-form').find(".fiMaQgSx").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
        return false;
    };

    self.onFiMaQgSxChange = function () {
//        if (self.lstCuaKhau()) {
//
//            self.fiLhTenCuakhau(null);
//
//            var index = self.lstCuaKhau.firstIndexOf(function (item) {
//                return item.gateCode == self.fiLhMaCuakhau();
//            });
//
//            if (index >= 0) {
//                self.fiLhTenCuakhau(self.lstCuaKhau()[index].gateName);
//            }
//        }
    };

    self.onDelete = function (item) {

    };

    self.isVaild = function () {
        var isCssxVaild = true;
        if (self.tbErrors().length > 0) {
            self.tbErrors.showAllMessages();
            return false;
        }
        var len = self.lstCssxHangHoas().length;

        if (len > 0) {
            for (var i = 0; i <= len - 1; i++) {
                if (!self.lstCssxHangHoas()[i].fiTenCssx()
                        || !self.lstCssxHangHoas()[i].fiMaQgSx()
                        || !self.lstCssxHangHoas()[i].fiDiachiCssx()) {
                    isCssxVaild = false;
                    self.errorCssxMessage(true);
                    break;
                }
            }
            if(isCssxVaild) {
                self.errorCssxMessage(false);
            }
        } else {
            isCssxVaild = false;
            self.errorCssxMessage(true);
        }

        var len = self.lstDinhKemHangHoas().length;
        if (len > 0) {
            for (var i = 0; i <= len - 1; i++) {
                if (!self.lstDinhKemHangHoas()[i].fiTenTep()
                        || !self.lstDinhKemHangHoas()[i].fiMaTep()
                        || !self.lstDinhKemHangHoas()[i].fiDuongDan()) {
                    isCssxVaild = false;
                    self.errorCssxFile(true);
                    break;
                }
            }
            if(isCssxVaild) {
                self.errorCssxFile(false);
            }
        } else {
            isCssxVaild = false;
            self.errorCssxFile(true);
        }
        return isCssxVaild;
    };
    
    self.bindFullInfo = function(){
        var len = self.lstCssxHangHoas().length;
        if (len > 0) {
            for (var i = 0; i <= len - 1; i++) {
                var index = self.lstQuocGia.firstIndexOf(function (item) {
                    return item.id == self.lstCssxHangHoas()[i].fiMaQgSx();
                });                
                if (index >= 0) {
                    self.lstCssxHangHoas()[i].fiTenQgSx(self.lstQuocGia()[index].name);
                }                
            }
        }
    };

    self.toJSON = function () {
        
        var len = self.lstCssxHangHoas().length;
        if (len > 0) {
            for (var i = 0; i <= len - 1; i++) {
                var index = self.lstQuocGia.firstIndexOf(function (item) {
                    return item.id == self.lstCssxHangHoas()[i].fiMaQgSx();
                });                
                if (index >= 0) {
                    self.lstCssxHangHoas()[i].fiTenQgSx(self.lstQuocGia()[index].name);
                }                
            }
        }
        
        var model = ko.toJS(self);
        var _exclude = ['tbErrors', 'lstQuocGia', 'onXoaCoSoSanXuat',
            'onThemMoiCSSX', 'isVaild', 'isVaild', 'errorCssxMessage',
            'errorCssxFile'];
        for (var key in model) {
            if (_exclude.indexOf(key) >= 0) {
                delete model[key];
            }
        }

        return model;
    };
}

function EquipmentVM(data, formVM) {
    console.log(data);
    var self = this;
    self.fiStt = ko.observable(data.hasOwnProperty('fiStt') ? data.fiStt : 1);
    self.fiIdHanghoa = ko.observable(data.hasOwnProperty('fiIdHanghoa') ? data.fiIdHanghoa : (-1 * new Date().getTime()));
    self.fiIdHoso = ko.observable(data.hasOwnProperty('fiIdHoso') ? data.fiIdHoso : null);
    self.fiTenTtb = ko.observable(data.hasOwnProperty('fiTenTtb') ? data.fiTenTtb : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiLoaiTtb = ko.observable(data.hasOwnProperty('fiLoaiTtb') ? data.fiLoaiTtb : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiTenLoaiTtb = ko.observable();

    self.fiTenCsh = ko.observable(data.hasOwnProperty('fiTenCsh') ? data.fiTenCsh : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiDiachiCsh = ko.observable(data.hasOwnProperty('fiDiachiCsh') ? data.fiDiachiCsh : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiTenQgCsh = ko.observable(data.hasOwnProperty('fiTenQgCsh') ? data.fiTenQgCsh : null);
    self.fiMaQaCsh = ko.observable(data.hasOwnProperty('fiMaQaCsh') ? data.fiMaQaCsh : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiTieuchuan = ko.observable(data.hasOwnProperty('fiTieuchuan') ? data.fiTieuchuan : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiPhannhom = ko.observable(data.hasOwnProperty('fiPhannhom') ? data.fiPhannhom : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiTenPhannhom = ko.observable();

    self.fiNhomTtb = ko.observable(data.hasOwnProperty('fiNhomTtb') ? data.fiNhomTtb : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiNhieuCssx = ko.observable(data.hasOwnProperty('fiNhieuCssx') ? data.fiNhieuCssx : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiDongGoi = ko.observable(data.hasOwnProperty('fiDongGoi') ? data.fiDongGoi : null);
    self.fiSoDklh = ko.observable(data.hasOwnProperty('fiSoDklh') ? data.fiSoDklh : null).extend({
        maxLength: {message: 'Tối đa 50 ký tự', params: 50},
        required: {
            message: NSWLang["common_msg_formvaild_required"],
            onlyIf: function () {
                return formVM.fiMaThutuc() == PROCEDUCE.MOH_08;
            }
        }
    });
    self.fiDaCoDklh = ko.observable(data.hasOwnProperty('fiDaCoDklh') ? data.fiDaCoDklh : "0");
    self.fibDaCoDklh = ko.observable("1" == self.fiDaCoDklh());
    self.fiHoatdong = ko.observable(data.hasOwnProperty('fiHoatdong') ? data.fiHoatdong : null);
    self.fiNguoitao = ko.observable(data.hasOwnProperty('fiNguoitao') ? data.fiNguoitao : null);
    self.fiNgaytao = ko.observable(data.hasOwnProperty('fiNgaytao') ? data.fiNgaytao : null);
    self.fiNgCapnhat = ko.observable(data.hasOwnProperty('fiNgCapnhat') ? data.fiNgCapnhat : null);

    self.isShowSoDKLH = ko.computed(function () {
        return formVM.fiMaThutuc() == PROCEDUCE.MOH_08;
    });

    self.isShowCSBH = ko.computed(function () {
        return formVM.fiMaThutuc() == PROCEDUCE.MOH_07;
    });

    self.lstLoaiHangHoas = ko.observableArray(mapChungLoaiVM(data.hasOwnProperty('lstLoaiHangHoas') ? data.lstLoaiHangHoas : [], formVM));
    self.lstBaoHanhHangHoas = ko.observableArray(mapTbdhsHhBaohanh7(data.hasOwnProperty('lstBaoHanhHangHoas') ? data.lstBaoHanhHangHoas : []));

    self.lstNhomTtb = ko.observableArray(mapCategory(data.hasOwnProperty('lstNhomTtb') ? data.lstNhomTtb : []));
    self.lstLoaiTtb = ko.observableArray(mapCategory(data.hasOwnProperty('lstLoaiTtb') ? data.lstLoaiTtb : []));
    self.lstPhanNhomTtb = ko.observableArray(mapCategory(data.hasOwnProperty('lstPhanNhomTtb') ? data.lstPhanNhomTtb : []));
    self.lstCoSoSanXuatTtb = ko.observableArray(mapCategory(data.hasOwnProperty('lstCoSoSanXuatTtb') ? data.lstCoSoSanXuatTtb : []));
    self.lstQuocGia = ko.observableArray(mapCategory(data.hasOwnProperty('lstQuocGia') ? data.lstQuocGia : [], 'fiMaQg', 'fiTenQg'));

    var vg = [self.fiTenTtb, self.fiSoDklh, self.fiLoaiTtb, self.fiPhannhom, self.fiNhomTtb, self.fiTenCsh
                , self.fiDiachiCsh, self.fiMaQaCsh, self.fiTieuchuan, self.fiNhieuCssx];
    self.tbErrors = ko.validation.group(vg, {deep: true, live: true, observable: true});

    self.onKhaiBaoCoSoBaoHanh = function () {
        var html = [
            $('#cosobaohanh-template').html()
        ].join('');
        delete self.pop;
        delete self.cosobaohanhVM;

        self.cosobaohanhVM = new CoSoBaoHanhVM({
            fiIdHanghoa: self.fiIdHanghoa(),
            fiMst: formVM.fiMstDn(),
            lstBaoHanhHangHoas: self.lstBaoHanhHangHoas(),
            lstBaoHanh: []
        }, self);

        var cb = function () {
            self.pop = app.popup({
                title: 'Khai báo cơ sở bảo hành',
                html: html,
                width: 1024,
                buttons: [{
                        name: 'Lưu',
                        class: 'btn',
                        icon: 'fa-save',
                        action: function () {
                            self.lstBaoHanhHangHoas(mapTbdhsHhBaohanh7(self.cosobaohanhVM.toJSON()));
                            app.popupRemove(self.pop.selector);
                            delete self.pop;
                        }
                    },
                    {
                        name: 'Đóng',
                        class: 'btn',
                        icon: 'fa-close',
                        action: function () {
                            app.popupRemove(self.pop.selector);
                            delete self.pop;
                        }
                    }]
            }, function () {
                ko.applyBindings(self.cosobaohanhVM, document.getElementById('cosobaohanh-form'));
            });
        };

        self.cosobaohanhVM.search(cb);

        return false;
    };

    self.onXoaCoSoBaoHanh = function (item) {
        delete self.popConfirm;
        self.popConfirm = app.popup({
            title: 'Thông báo',
            html: '<b>Bạn chắc chắn muốn xoá dữ liệu này?</b>',
            width: 450,
            buttons: [
                {
                    name: NSWLang["common_button_toi_chac_chan"],
                    class: 'btn',
                    icon: 'fa-save',
                    action: function () {
                        self.lstBaoHanhHangHoas.remove(function (o) {
                            return o.fiIdCsbh() == item.fiIdCsbh();
                        });
                        for (var i = 0; i < self.lstBaoHanhHangHoas().length; i++) {
                            self.lstBaoHanhHangHoas()[i].fiStt(i + 1);
                        }
                        app.popupRemove(self.popConfirm.selector);
                        delete self.popConfirm;
                    }
                },
                {
                    name: 'Đóng',
                    class: 'btn',
                    icon: 'fa-close',
                    action: function () {
                        app.popupRemove(self.popConfirm.selector);
                        delete self.popConfirm;
                    }
                }
            ]
        });
        return;
    };

    self.onKhaiBaoChungLoai = function () {
        self.onEditChungLoai(null);
        return false;
    };

    self.onSuaChungLoaiHangHoa = function (item) {
        self.onEditChungLoai(item);
    };

    self.onXoaChungLoaiHangHoa = function (item) {
        var popConfirm = app.popup({
            title: 'Thông báo',
            html: '<b>Bạn chắc chắn muốn xoá dữ liệu này?</b>',
            width: 450,
            buttons: [
                {
                    name: NSWLang["common_button_toi_chac_chan"],
                    class: 'btn',
                    icon: 'fa-save',
                    action: function () {
                        self.lstLoaiHangHoas.remove(function (o) {
                            return o.fiIdHhLoai() == item.fiIdHhLoai();
                        });
                        for (var i = 0; i < self.lstLoaiHangHoas().length; i++) {
                            self.lstLoaiHangHoas()[i].fiStt(i + 1);
                        }
                        app.popupRemove(popConfirm.selector);
                    }
                },
                {
                    name: 'Đóng',
                    class: 'btn',
                    icon: 'fa-close',
                    action: function () {
                        app.popupRemove(popConfirm.selector);
                    }
                }
            ]
        });
    };

    self.onEditChungLoai = function (item) {
        var html = [
            $('#chungloai-template').html()
        ].join('');

        var obj = {};
        if (null != item) {
            obj = ko.toJS(item);
        }

        obj.lstQuocGia = self.lstQuocGia();
        obj.lstTTBinhKems = data.hasOwnProperty('lstTTBinhKems') ? data.lstTTBinhKems : [];

        self.chungLoaiVM = new ChungLoaiVM(obj, formVM);

        var popUp = app.popup({
            title: 'Khai báo chủng loại/mã sản phẩm',
            html: html,
            width: 1024,
            buttons: [{
                    name: 'Lưu',
                    class: 'btn',
                    icon: 'fa-save',
                    action: function () {
                        if (self.chungLoaiVM.isVaild()) {
                            self.chungLoaiVM.bindFullInfo();
                            if (null == item) {
                                self.chungLoaiVM.fiStt(self.lstLoaiHangHoas().length + 1);
                                self.lstLoaiHangHoas.push(self.chungLoaiVM);
                            } else {
                                var index = self.lstLoaiHangHoas.firstIndexOf(function (o) {
                                    return o.fiIdHhLoai() == item.fiIdHhLoai();
                                });
                                self.lstLoaiHangHoas.splice(index, 1, self.chungLoaiVM);
                            }
                            app.popupRemove(popUp.selector);
                        }
                    }
                },
                {
                    name: 'Đóng',
                    class: 'btn',
                    icon: 'fa-close',
                    action: function () {
                        app.popupRemove(popUp.selector);
                    }
                }
            ]
        }, function () {
            ko.applyBindings(self.chungLoaiVM, document.getElementById('chungloai-form'));
        });
    };

    self.isVaild = function () {
        self.initData();
        
        if (self.tbErrors().length > 0) {
            self.tbErrors.showAllMessages();
            return false;
        }
        return true;
    };

    self.toJS = function () {
        self.initData();
        var hangHoa = {
            fiIdHanghoa: self.fiIdHanghoa(),
            fiIdHoso: self.fiIdHoso(),
            fiTenTtb: self.fiTenTtb(),
            fiLoaiTtb: self.fiLoaiTtb(),
            fiTenLoaiTtb: self.fiTenLoaiTtb(),
            fiTenCsh: self.fiTenCsh(),
            fiDiachiCsh: self.fiDiachiCsh(),
            fiTenQgCsh: self.fiTenQgCsh(),
            fiMaQaCsh: self.fiMaQaCsh(),
            fiTieuchuan: self.fiTieuchuan(),
            fiPhannhom: self.fiPhannhom(),
            fiTenPhannhom: self.fiTenPhannhom(),
            fiNhomTtb: self.fiNhomTtb(),
            fiNhieuCssx: self.fiNhieuCssx(),
            fiDongGoi: self.fiDongGoi(),
            fiSoDklh: self.fiSoDklh(),
            fiDaCoDklh: self.fibDaCoDklh() ? "1" : "0",
            fiHoatdong: self.fiHoatdong(),
            fiNguoitao: self.fiNguoitao(),
            fiNgaytao: self.fiNgaytao(),
            fiNgCapnhat: self.fiNgCapnhat(),
            lstLoaiHangHoas: [],
            lstBaoHanhHangHoas: []
        };
        var lstLoaiHangHoas = [];
        
        $(self.lstLoaiHangHoas()).each(function (index, item) {
            var pItem = {
                fiIdHhLoai: item.fiIdHhLoai(),
                fiIdHanghoa: item.fiIdHanghoa(),
                fiMaSpCl: item.fiMaSpCl(),
                fiDongGoiCl: item.fiDongGoiCl(),
                lstCssxHangHoas: [],
                lstDinhKemHangHoas: []
            };

            var lstCssxHangHoas = [];
            $(item.lstCssxHangHoas()).each(function (idex, cssx) {
                lstCssxHangHoas.push({
                    fiIdHhCssx: cssx.fiIdHhCssx(),
                    fiTenCssx: cssx.fiTenCssx(),
                    fiDiachiCssx: cssx.fiDiachiCssx(),
                    fiTenQgSx: cssx.fiTenQgSx(),
                    fiMaQgSx: cssx.fiMaQgSx()
                });
            });
            
            var lstDinhKemHangHoas = [];
            
            $(item.lstDinhKemHangHoas()).each(function (idex, attach) {
                lstDinhKemHangHoas.push({
                    fiIdDinhKem: attach.fiIdDinhKem(),
                    fiIdDt: attach.fiIdDt(),
                    fiLoaiDt: attach.fiLoaiDt(),
                    fiMaTep: attach.fiMaTep(),
                    fiLoaiTep: attach.fiLoaiTep(),
                    fiTenTep: attach.fiTenTep(),
                    fiTenLoaiTep: attach.fiTenLoaiTep(),
                    fiDuongDan: attach.fiDuongDan(),
                    fiPathLocal: attach.fiPathLocal(),
                    fiGuiId: attach.fiGuiId()
                });
            });

            pItem.lstCssxHangHoas = lstCssxHangHoas;
            pItem.lstDinhKemHangHoas = lstDinhKemHangHoas;

            lstLoaiHangHoas.push(pItem);
        });

        hangHoa.lstLoaiHangHoas = lstLoaiHangHoas;

        var lstBaoHanhHangHoas = [];
        $(self.lstBaoHanhHangHoas()).each(function (index, item) {
            var pItem = {
                fiIdHhBh: item.fiIdHhBh(),
                fiIdHanghoa: item.fiIdHanghoa(),
                fiIdCsbh: item.fiIdCsbh(),
                fiMstCsbh: item.fiMstCsbh(),
                fiTenCsbh: item.fiTenCsbh(),
                fiDiachiCsbh: item.fiDiachiCsbh(),
                fiSdtCdCsbh: item.fiSdtCdCsbh(),
                fiSdtDdCsbh: item.fiSdtDdCsbh()
            };
            lstBaoHanhHangHoas.push(pItem);
        });

        hangHoa.lstBaoHanhHangHoas = lstBaoHanhHangHoas;
        //console.log(hangHoa);
        return hangHoa;
    };

    self.initData = function () {
        if (self.fiLoaiTtb()) {
            self.fiTenLoaiTtb($('#trangthietbi-form').find('#fiLoaiTtb option:selected').text());
            if (!self.fiTenLoaiTtb()) {
                var index = self.lstLoaiTtb.firstIndexOf(function (o) {
                    return o.id == self.fiLoaiTtb();
                });
                if(index >= 0) {
                    self.fiTenLoaiTtb(self.lstLoaiTtb()[index].name);
                }
            }
        }

        if (self.fiPhannhom()) {
            self.fiTenPhannhom($('#trangthietbi-form').find('#fiPhannhom option:selected').text());
            if (!self.fiTenPhannhom()) {
                var index = self.lstPhanNhomTtb.firstIndexOf(function (o) {
                    return o.id == self.fiPhannhom();
                });
                self.fiTenPhannhom(self.lstPhanNhomTtb()[index].name);
            }

        }
    };

    self.initData();

}

function mapEquipmentVM(data, formVM) {
    return ko.utils.arrayMap(data, function (item, index) {
        item.fiStt = index + 1;
        return new EquipmentVM(item, formVM);
    });
}

function mapChungLoaiVM(data, formVM) {
    return ko.utils.arrayMap(data, function (item, index) {
        item.fiStt = index + 1;
        return new ChungLoaiVM(item, formVM);
    });
}