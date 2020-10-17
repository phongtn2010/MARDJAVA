/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function FormVM(data) {
    var self = this;

    var hosoInfo = (data !== null && data.hasOwnProperty('hoso')) ? data.hoso : {};

    self.fiIdHoso = ko.observable(null);
    self.fiMaHoso = ko.observable(null);
    self.fiSoVbDn = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 20 ký tự', params: 20}
    });
    self.fiMaDvNhan = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiTenDvNhan = ko.observable(null);
    self.fiMstDn = ko.observable(null);
    self.fiTenDn = ko.observable(null);
    self.fiDiachiDn = ko.observable(null);
    self.fiTenTinh = ko.observable(null);
    self.fiMaTinh = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiTenQuan = ko.observable(null);
    self.fiMaQuan = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiLoaihinh = ko.observable(null);
    self.fiPbanQuanly = ko.observable(null);
    self.fiTenDnEn = ko.observable(null);
    self.fiTenVtat = ko.observable(null);
    self.fiSoDkkd = ko.observable(null);
    self.fiNamTlap = ko.observable(null);
    self.fiWebDn = ko.observable(null);
    self.fiSdtDn = ko.observable(null);
    self.fiFaxDn = ko.observable(null);
    self.fiEmailDn = ko.observable(null);
    self.fiTenNdd = ko.observable(null);
    self.fiSoCmndNdd = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 50 ký tự', params: 50}
    });
    self.fiNgaycapCmnd = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiNoiCapCmnd = ko.observable(null);
    self.fiSdtCodinh = ko.observable(null);
    self.fiSdtDd = ko.observable(null);
    self.fiSoDklh = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiDacoSoDklh = ko.observable(false);
    
    self.visibleNgayCapCMT = ko.computed(function () {
        return !self.fiNgaycapCmnd();
    });

    self.fiHoatdong = ko.observable(1);
    self.fiNguoitao = ko.observable(null);
    self.fiNgaytao = ko.observable(null);
    self.fiNgCapnhat = ko.observable(null);
    self.fiTrangthai = ko.observable(0);
    self.fiTenTt = ko.observable(null);
    self.fiNgaynop = ko.observable(null);
    self.fiSoChungnhan = ko.observable(null);
    self.fiNgaycapGcn = ko.observable(null).extend({
        pattern: '[0-9]{2}/[0-9]{2}/[0-9]{4}'
    });
    self.fiMaThutuc = ko.observable(null);
    self.fiTenThutuc = ko.observable(null);

    self.lstTinhThanh = ko.observableArray(mapCategory(data.hasOwnProperty('lstTinhThanh') ? data.lstTinhThanh : [], 'fiMaTinh', 'fiTenTinh'));
    self.lstQuocGia = ko.observableArray(mapCategory(data.hasOwnProperty('lstQuocGia') ? data.lstQuocGia : []));
    self.lstDonViNhan = ko.observableArray(mapCategory(data.hasOwnProperty('lstDonViNhan') ? data.lstDonViNhan : []));
    self.lstQuanHuyen = ko.observableArray(mapCategory(data.hasOwnProperty('lstQuanHuyen') ? data.lstQuanHuyen : [], 'fiMaQuan', 'fiTenQuan'));
    
    /*
    self.lstDinhKems = ko.observableArray([]);
    self.DinhKems = ko.computed(function(){
        var p = self.fiDacoSoDklh() ? "1":"0";
        app.getCategory('/moh/11/danhmuc', 'DANHMUC_TAILIEU', p, function (res) {
            if (res.success) {
                var items = res.data;
                var listFiles = [];
                $(items).each(function (index, item) {
                    var pItem = {
                        fiIdDinhKem: null,
                        fiIdDt: null,
                        fiLoaiDt: null,
                        fiMaTep: null,                            
                        fiTenTep: null,
                        fiLoaiTep: item.fiMaTailieu,
                        fiTenLoaiTep: item.fiTenTailieu,
                        fiDuongDan: null,
                        fiPathLocal: null,
                        fiGuiId: null,
                        fiBatBuoc: item.fiBatBuoc
                    };
                    listFiles.push(pItem);
                });
                self.lstDinhKems(mapFilesVM(listFiles, null, self, 'frame1'));
            } else {
                self.lstDinhKems([]);
            }
        });
        
    });
    
    */

    var hosoVG = [self.fiMaDvNhan, self.fiMaTinh, self.fiMaQuan,
        self.fiSoCmndNdd, self.fiSoVbDn, self.fiNgaycapCmnd, self.fiSoDklh];
    self.hosoErrors = ko.validation.group(hosoVG, {deep: true, live: true, observable: true});
    
    self.init = function (hoso) {

        self.fiIdHoso(hoso.hasOwnProperty('fiIdHoso') ? hoso.fiIdHoso : null);
        self.fiMaHoso(hoso.hasOwnProperty('fiMaHoso') ? hoso.fiMaHoso : null);
        self.fiSoVbDn(hoso.hasOwnProperty('fiSoVbDn') ? hoso.fiSoVbDn : null);
        self.fiMaDvNhan(hoso.hasOwnProperty('fiMaDvNhan') ? hoso.fiMaDvNhan : null);
        self.fiTenDvNhan(hoso.hasOwnProperty('fiTenDvNhan') ? hoso.fiTenDvNhan : null);

        self.fiMstDn(hoso.hasOwnProperty('fiMstDn') ? hoso.fiMstDn : user.username);
        self.fiTenDn(hoso.hasOwnProperty('fiTenDn') ? hoso.fiTenDn : user.companyName);
        self.fiDiachiDn(hoso.hasOwnProperty('fiDiachiDn') ? hoso.fiDiachiDn : user.companyAddress);

        self.fiTenTinh(hoso.hasOwnProperty('fiTenTinh') ? hoso.fiTenTinh : null);
        self.fiMaTinh(hoso.hasOwnProperty('fiMaTinh') ? hoso.fiMaTinh : null);
        self.fiTenQuan(hoso.hasOwnProperty('fiTenQuan') ? hoso.fiTenQuan : null);
        self.fiMaQuan(hoso.hasOwnProperty('fiMaQuan') ? hoso.fiMaQuan : null);
        self.fiLoaihinh(hoso.hasOwnProperty('fiLoaihinh') ? hoso.fiLoaihinh : null);
        self.fiPbanQuanly(hoso.hasOwnProperty('fiPbanQuanly') ? hoso.fiPbanQuanly : null);
        self.fiTenDnEn(hoso.hasOwnProperty('fiTenDnEn') ? hoso.fiTenDnEn : null);
        self.fiTenVtat(hoso.hasOwnProperty('fiTenVtat') ? hoso.fiTenVtat : null);
        self.fiSoDkkd(hoso.hasOwnProperty('fiSoDkkd') ? hoso.fiSoDkkd : null);
        self.fiNamTlap(hoso.hasOwnProperty('fiNamTlap') ? hoso.fiNamTlap : null);

        self.fiWebDn(hoso.hasOwnProperty('fiWebDn') ? hoso.fiWebDn : 'www.tech.vn');
        self.fiSdtDn(hoso.hasOwnProperty('fiSdtDn') ? hoso.fiSdtDn : '0123456789');
        self.fiFaxDn(hoso.hasOwnProperty('fiFaxDn') ? hoso.fiFaxDn : '12345678');
        self.fiEmailDn(hoso.hasOwnProperty('fiEmailDn') ? hoso.fiEmailDn : 'company@gmail.com');

        self.fiTenNdd(hoso.hasOwnProperty('fiTenNdd') ? hoso.fiTenNdd : 'Nguyễn Văn A');
        self.fiSoCmndNdd(hoso.hasOwnProperty('fiSoCmndNdd') ? hoso.fiSoCmndNdd : '123456789');
        self.fiNgaycapCmnd(hoso.hasOwnProperty('fiNgaycapCmnd') ? new Date(hoso.fiNgaycapCmnd) : null);
        self.fiNoiCapCmnd(hoso.hasOwnProperty('fiNoiCapCmnd') ? hoso.fiNoiCapCmnd : 'CA Hà Nội');
        self.fiSdtCodinh(hoso.hasOwnProperty('fiSdtCodinh') ? hoso.fiSdtCodinh : '04.12345678');
        self.fiSdtDd(hoso.hasOwnProperty('fiSdtDd') ? hoso.fiSdtDd : '0987654321');
        self.fiSoDklh(hoso.hasOwnProperty('fiSoDklh') ? hoso.fiSoDklh : null);

        self.fiDacoSoDklh(hoso.hasOwnProperty('fiDacoSoDklh') ? (parseInt(hoso.fiDacoSoDklh) > 0 ? true:false) : false);

        self.fiHoatdong(1);
        self.fiNguoitao(hoso.hasOwnProperty('fiNguoitao') ? hoso.fiNguoitao : null);
        self.fiNgaytao(hoso.hasOwnProperty('fiNgaytao') ? new Date(hoso.fiNgaytao) : null);
        self.fiNgCapnhat(hoso.hasOwnProperty('fiNgCapnhat') ? hoso.fiNgCapnhat : null);
        self.fiTrangthai(hoso.hasOwnProperty('fiTrangthai') ? hoso.fiTrangthai : 0);
        self.fiTenTt(hoso.hasOwnProperty('fiTenTt') ? hoso.fiTenTt : null);
        self.fiNgaynop(hoso.hasOwnProperty('fiNgaynop') ? new Date(hoso.fiNgaynop) : null);
        self.fiSoChungnhan(hoso.hasOwnProperty('fiSoChungnhan') ? hoso.fiSoChungnhan : null);
        self.fiNgaycapGcn(hoso.hasOwnProperty('fiNgaycapGcn') ? new Date(hoso.fiNgaycapGcn) : null);
        self.fiMaThutuc(hoso.hasOwnProperty('fiMaThutuc') ? hoso.fiMaThutuc : data.maThuTuc);
        self.fiTenThutuc(hoso.hasOwnProperty('fiTenThutuc') ? hoso.fiTenThutuc : null);
        
        self.hosoErrors.showAllMessages(false);
    };
    
    self.init(hosoInfo);
    
    self.OnBlurEvent = function(d,e){
        if(self.fiSoDklh()) {
            var url = '/moh/11/dklh/check/' + self.fiSoDklh();
            app.makePost({
                url: url,
                data: JSON.stringify({}),
                success: function (d) {
                    if (d && d.success) {
                        self.fiDacoSoDklh(parseInt(d.total) > 0);
                    } else {
                        self.fiDacoSoDklh(false);
                    }
                },
                error: function (e) {
                    self.fiDacoSoDklh(false);
                }
            });
        }
        return true;
    };
    
    self.OnEnterEvent = function(d,e){
        if(e.keyCode === 13) {
            if(self.fiSoDklh()) {
                var url = '/moh/11/dklh/check/' + self.fiSoDklh();
                app.makePost({
                    url: url,
                    data: JSON.stringify({}),
                    success: function (d) {
                        if (d && d.success) {
                            self.fiDacoSoDklh(parseInt(d.total) > 0);
                        } else {
                            self.fiDacoSoDklh(false);
                        }
                    },
                    error: function (e) {
                        self.fiDacoSoDklh(false);
                    }
                });
            }
        }
        
        return true;
    };
    
    self.onFiMaTinhChange = function () {
        if (self.fiMaTinh()) {

            self.fiTenTinh(null);

            var index = self.lstTinhThanh.firstIndexOf(function (item) {
                return item.id == self.fiMaTinh();
            });

            if (index >= 0) {
                self.fiTenTinh(self.lstTinhThanh()[index].name);
            }

            app.getCategory('/moh/07/danhmuc', 'DANHMUC_QUANHUYEN', self.fiMaTinh(), function (res) {
                if (res.success) {
                    self.lstQuanHuyen(mapCategory(null != res.data ? res.data : [], "fiMaQuan", "fiTenQuan"));
                } else {
                    self.lstQuanHuyen([]);
                }
            });
        }
    };

    self.onFiMaDvNhanChange = function () {
        if (self.fiMaDvNhan()) {
            self.fiTenDvNhan(null);
            var index = self.lstDonViNhan.firstIndexOf(function (item) {
                return item.id == self.fiMaDvNhan();
            });
            if (index >= 0) {
                self.fiTenDvNhan(self.lstDonViNhan()[index].name);
            }
        }
    };

    self.onFiMaQuanChange = function () {
        if (self.fiMaQuan()) {
            self.fiTenQuan(null);
            var index = self.lstQuanHuyen.firstIndexOf(function (item) {
                return item.id == self.fiMaQuan();
            });
            if (index >= 0) {
                self.fiTenQuan(self.lstQuanHuyen()[index].name);
            }
        }
    };

    self.isValidForm = function () {
        
        if (self.hosoErrors().length > 0) {
            self.hosoErrors.showAllMessages();
            return false;
        }
        
        if(!self.fiNgaycapCmnd()) {
            return false;
        }

        return true;
    };

    self.toJSON = function () {
        var hosoJs = {
            fiIdHoso: self.fiIdHoso(),
            fiMaHoso: self.fiMaHoso(),
            fiSoVbDn: self.fiSoVbDn(),
            fiMaDvNhan: self.fiMaDvNhan(),
            fiTenDvNhan: self.fiTenDvNhan(),
            fiMstDn: self.fiMstDn(),
            fiTenDn: self.fiTenDn(),
            fiDiachiDn: self.fiDiachiDn(),
            fiTenTinh: self.fiTenTinh(),
            fiMaTinh: self.fiMaTinh(),
            fiTenQuan: self.fiTenQuan(),
            fiMaQuan: self.fiMaQuan(),
            fiLoaihinh: self.fiLoaihinh(),
            fiPbanQuanly: self.fiPbanQuanly(),
            fiTenDnEn: self.fiTenDnEn(),
            fiTenVtat: self.fiTenVtat(),
            fiSoDkkd: self.fiSoDkkd(),
            fiNamTlap: self.fiNamTlap(),
            fiWebDn: self.fiWebDn(),
            fiSdtDn: self.fiSdtDn(),
            fiFaxDn: self.fiFaxDn(),
            fiEmailDn: self.fiEmailDn(),
            fiTenNdd: self.fiTenNdd(),
            fiSoCmndNdd: self.fiSoCmndNdd(),
            fiNgaycapCmnd: self.fiNgaycapCmnd(),
            fiNoiCapCmnd: self.fiNoiCapCmnd(),
            fiSdtCodinh: self.fiSdtCodinh(),
            fiSdtDd: self.fiSdtDd(),
            fiSoDklh: self.fiSoDklh(),
            fiDacoSoDklh: self.fiDacoSoDklh() ? "1" : "0",

            fiHoatdong: self.fiHoatdong(),
            fiNguoitao: self.fiNguoitao(),
            fiNgaytao: self.fiNgaytao(),
            fiNgCapnhat: self.fiNgCapnhat(),
            fiTrangthai: self.fiTrangthai(),
            fiTenTt: self.fiTenTt(),
            fiNgaynop: self.fiNgaynop(),
            fiSoChungnhan: self.fiSoChungnhan(),
            fiNgaycapGcn: self.fiNgaycapGcn(),
            fiMaThutuc: data.maThuTuc,
            fiTenThutuc: self.fiTenThutuc(),
            lstDinhKems: [],
            lstThanhToans: []
        };

        return hosoJs;
    };

    ko.bindingHandlers.datepicker = {
        init: function (element, valueAccessor, allBindingsAccessor) {
            var options = allBindingsAccessor().datepickerOptions || {};

            $(element).datepicker(options);

            //handle the field changing
            ko.utils.registerEventHandler(element, "change", function () {
                var observable = valueAccessor();
                observable($(element).datepicker("getDate"));
            });

            //handle disposal (if KO removes by the template binding)
            ko.utils.domNodeDisposal.addDisposeCallback(element, function () {
                $(element).datepicker("destroy");
            });

        },
        update: function (element, valueAccessor) {
            var value = ko.utils.unwrapObservable(valueAccessor()),
                    $el = $(element);

            //handle date data coming via json from Microsoft
            if (String(value).indexOf('/Date(') == 0) {
                value = new Date(parseInt(value.replace(/\/Date\((.*?)\)\//gi, "$1")));
            }

            var current = $el.datepicker("getDate");

            if (value - current !== 0) {
                $el.datepicker("setDate", value);
            }
        }
    };
    
    ko.validation.makeBindingHandlerValidatable('datepicker');
    
    ko.bindingHandlers.executeOnEnter = {
        init: function (element, valueAccessor, allBindings, viewModel) {
            var callback = valueAccessor();
            $(element).keypress(function (event) {
                var keyCode = (event.which ? event.which : event.keyCode);
                if (keyCode === 13) {
                    callback.call(viewModel);
                    return false;
                }
                return true;
            });
        }
    };
}
