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

    self.lstCssxHangHoas = ko.observableArray(mapTbdhsHhCssx10(data.hasOwnProperty('lstCssxHangHoas') ? data.lstCssxHangHoas : []));
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
        self.lstCssxHangHoas.push(new TbdhsHhCssx10({
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
            'onThemMoiCSSX', 'isVaild', 'isVaild', 'errorCssxMessage', 'toJSON'];
        for (var key in model) {
            if (_exclude.indexOf(key) >= 0) {
                delete model[key];
            }
        }

        return model;
    };
}

function EquipmentVM(data, formVM) {

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
    self.fiSoluongNk = ko.observable(data.hasOwnProperty('fiSoluongNk') ? data.fiSoluongNk : null).extend({
        number: {message: 'Phải nhập số', params: true},
        required: { message: NSWLang["common_msg_formvaild_required"], params: true }
    });
    
    self.fiHoatdong = ko.observable(data.hasOwnProperty('fiHoatdong') ? data.fiHoatdong : null);
    self.fiNguoitao = ko.observable(data.hasOwnProperty('fiNguoitao') ? data.fiNguoitao : null);
    self.fiNgaytao = ko.observable(data.hasOwnProperty('fiNgaytao') ? data.fiNgaytao : null);
    self.fiNgCapnhat = ko.observable(data.hasOwnProperty('fiNgCapnhat') ? data.fiNgCapnhat : null);

    self.lstLoaiHangHoas = ko.observableArray(mapTbdhsHhLoai10(data.hasOwnProperty('lstLoaiHangHoas') ? data.lstLoaiHangHoas : []));
    
    self.lstNhomTtb = ko.observableArray(mapCategory(data.hasOwnProperty('lstNhomTtb') ? data.lstNhomTtb : []));
    self.lstLoaiTtb = ko.observableArray(mapCategory(data.hasOwnProperty('lstLoaiTtb') ? data.lstLoaiTtb : []));
    self.lstPhanNhomTtb = ko.observableArray(mapCategory(data.hasOwnProperty('lstPhanNhomTtb') ? data.lstPhanNhomTtb : []));
    self.lstCoSoSanXuatTtb = ko.observableArray(mapCategory(data.hasOwnProperty('lstCoSoSanXuatTtb') ? data.lstCoSoSanXuatTtb : []));
    self.lstQuocGia = ko.observableArray(mapCategory(data.hasOwnProperty('lstQuocGia') ? data.lstQuocGia : [], 'fiMaQg', 'fiTenQg'));

    var vg = [self.fiTenTtb, self.fiLoaiTtb, self.fiPhannhom, self.fiNhomTtb, self.fiTenCsh
                , self.fiDiachiCsh, self.fiMaQaCsh, self.fiNhieuCssx, self.fiSoluongNk];
    self.tbErrors = ko.validation.group(vg, {deep: true, live: true, observable: true});

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
            fiPhannhom: self.fiPhannhom(),            
            fiNhomTtb: self.fiNhomTtb(),
            fiNhieuCssx: self.fiNhieuCssx(),
            fiDongGoi: self.fiDongGoi(),
            fiSoluongNk: self.fiSoluongNk(),
            fiHoatdong: self.fiHoatdong(),
            fiNguoitao: self.fiNguoitao(),
            fiNgaytao: self.fiNgaytao(),
            fiNgCapnhat: self.fiNgCapnhat(),
            lstLoaiHangHoas: []
        };
        var lstLoaiHangHoas = [];
        $(self.lstLoaiHangHoas()).each(function (index, item) {
            var pItem = {
                fiIdHhLoai: item.fiIdHhLoai(),
                fiIdHanghoa: item.fiIdHanghoa(),
                fiMaSpCl: item.fiMaSpCl(),
                fiDongGoiCl: item.fiDongGoiCl(),
                lstCssxHangHoas: []
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

            pItem.lstCssxHangHoas = lstCssxHangHoas;

            lstLoaiHangHoas.push(pItem);
        });

        hangHoa.lstLoaiHangHoas = lstLoaiHangHoas;
        return hangHoa;
    };

    self.initData = function () {
        if (self.fiLoaiTtb()) {
            self.fiTenLoaiTtb($('#trangthietbi-form').find('#fiLoaiTtb option:selected').text());
            if (!self.fiTenLoaiTtb()) {
                var index = self.lstLoaiTtb.firstIndexOf(function (o) {
                    return o.id == self.fiLoaiTtb();
                });
                self.fiTenLoaiTtb(self.lstLoaiTtb()[index].name);
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