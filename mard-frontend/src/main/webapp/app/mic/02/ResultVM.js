/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//var triggerTab = function (tab) {
//    var $tab = $('#' + tab);
//    if ($tab.length > 0) {
//        $tab.trigger('click');
//    }
//};


function SuaGpVM(fiMsg, item) {
    var self = this;

    self.fiIdHoso = ko.observable(item.hoso.fiIdHoSo);
    self.fiMaHoso = ko.observable(item.hoso.fiMaHoSo);
    self.fiSoGiayPhep = item.giayphep.fiSoGiayPhep;
    self.fiIdGp = ko.observable(item.giayphep.fiIdGiayphep);
    self.fiMsg = ko.observable(fiMsg);
    self.lstTeptin02 = ko.observableArray([]);
    self.fileDK = new FileVM(item, self.fiIdHoso());
    self.fiTenTepTin = self.fileDK.fiTenTepTin;
    console.log(self.fiTenTepTin());
    self.fiNoidungYc = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 2000 ký tự', params: 2000}
    });
    var lstVG = [self.fiNoidungYc];
    self.lstErrors = ko.validation.group(lstVG, {deep: true, live: true, observable: true});
    self.isValidForm = function () {
        lstErrors = true;
        if (self.fiTenTepTin() == null) {
            $("#valid-file").show();
            lstErrors = false;
        }
        if (self.lstErrors().length > 0) {
            self.lstErrors.showAllMessages();
            lstErrors = false;
        }
        return lstErrors;
    };
    self.makeRequest = function (cb) {
        if (!self.isValidForm())
            return;

        delete self.fileDK['canUpload'];
        delete self.fileDK['canDownload'];
        delete self.fileDK['canDelete'];
        delete self.fileDK['doUpload'];
        delete self.fileDK['doDelete'];
        delete self.fileDK['downloadUrl'];
        delete self.fileDK['fiBatBuoc'];
        delete self.fileDK['isRequire'];
        delete self.fileDK['doDeleteNoPopup'];
        delete self.fileDK["__ko_mapping__"];

        self.lstTeptin02.push(self.fileDK);


        app.makePost({

            url: '/mic/p02/giayphep/yc-sua',
            data: JSON.stringify({
                fiMaHoso: self.fiMaHoso(),
                fiIdHoso: self.fiIdHoso(),
                reason: self.fiNoidungYc(),
                idGP: self.fiIdGp(),
                idFile: self.fileDK.fiTepTinId(),
                tenFile: self.fileDK.fiTenTepTin(),
                urlFile: self.fileDK.fiDuongDan()
            }),
            success: function (d) {
                var msg = '';
                if (d.success) {
                    msg = NSWLang["common_msg_cap_nhat_du_lieu_thanh_cong"];
                    cb();
                } else {
                    msg = data.message ? data.message : 'Gửi yêu cầu thất bại, vui lòng thử lại!';
                }
                app.Alert(msg);
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

function ResultVM(options) {
    var self = this;
    self.formVM = ko.observable(new FormVM(options));
    self.fiIdGiayphep = ko.observable(null);
    self.fiSoGiayPhep = ko.observable(null);
    self.fiNoiCapGp = ko.observable(null);
    self.fiSoDonDeNghi = ko.observable(null);
    self.fiNgayDeNghi = ko.observable(null);
    self.fiTenToChuc = ko.observable(null);
    self.fiDiaChiTc = ko.observable(null);
    self.fiMdNhapKhau = ko.observable(null);
    self.fiDiaChiDatMay = ko.observable(null);
    self.fiTenNguoiKy = ko.observable(null);
    self.fiChucDanh = ko.observable(null);
    self.fiIdHoso = ko.observable(null);
    self.fiMaHoso = ko.observable(null);
    self.fiNguoitao = ko.observable(null);
    self.fiNgaytao = ko.observable(null);
    self.fiTrangthai = ko.observable(null);
    self.fiHoatDong = ko.observable(null);
    self.fiNgayCapnhat = ko.observable(null);
    self.fiNgayCapPhep = ko.observable(null);
    self.fiLinkGiayphep = ko.observable(null);
    self.strNgayCapPhep = ko.observable(null);
    self.strNgayDeNghi = ko.observable(null);
    self.strLinkGP = ko.observable(null);

    self.lstThietBiNk02 = ko.observableArray([]);
    

    var data = null;
    if (options.giayphep) {
        data = options.giayphep;

    }
    if (data) {
        ko.mapping.fromJS(data, {}, self);
        self.lstThietBiNk02 = ko.observableArray(data ? data.lstThietBiNk02 : []);
        self.fiNgayCapPhep(data ? new Date(data.fiNgayCapPhep) : null);
        self.fiNgayDeNghi(data ? new Date(data.fiNgayDeNghi) : null);
        var dt = self.fiNgayCapPhep();
        var d = (dt.getDate() >= 10) ? dt.getDate() : "0" + dt.getDate();
        var m = (dt.getMonth() >= 9) ? dt.getMonth() + 1 : "0" + (dt.getMonth() + 1);
        var y = dt.getFullYear();
        var strViewHtml = "ngày <b>" + d + "</b> tháng <b>" + m + "</b> năm <b>" + y + "</b>";
        self.strNgayCapPhep(strViewHtml);
        var fingaydn = self.fiNgayDeNghi();
        var ngaydn = (fingaydn.getDate() >= 10) ? fingaydn.getDate() : "0" + fingaydn.getDate();
        var thangdn = (fingaydn.getMonth() >= 9) ? fingaydn.getMonth() + 1 : "0" + (fingaydn.getMonth() + 1);
        var namdn = fingaydn.getFullYear();
        var strNgayDnHtml = "ngày <b>" + ngaydn + "</b> tháng <b>" + thangdn + "</b> năm <b>" + namdn + "</b>";
        self.strNgayDeNghi(strNgayDnHtml);
        self.strLinkGP(self.fiSoGiayPhep()+"/"+self.fiMaHoso());



    }

//    if (options.tab) {
//        triggerTab('a-tab-2');
//    }

    self.btnXinSuaClick = function () {
        var html = [
            $('#suaGp-tmpl').html()
        ].join('');
        delete self.SuaGpVM;
        delete self.pop;

        self.suaGpVM = new SuaGpVM('Bạn chắc chắn muốn gửi yêu cầu xin sửa giấy phép số:  ', options);
        if (!self.suaGpVM.isValidForm)
            return;
        self.pop = app.popup({
            title: 'Sửa giấy phép',
            html: html,
            width: 1000,
            buttons: [
                {
                    name: NSWLang["common_button_gui"],
                    class: 'btn',
                    icon: 'fa-save',
                    action: function () {
                        self.suaGpVM.makeRequest(function () {

                            app.popupRemove(self.pop.selector);
                            setTimeout(function () {
                                History.go(-1);
                            }, 500);
                        });

                    }
                },
                {
                    name: 'Đóng',
                    class: 'btn',
                    icon: 'fa-close',
                    action: function () {
                        app.popupRemove(self.pop.selector);
                    }
                }

            ]
        });

        ko.applyBindings(self.suaGpVM, document.getElementById('suaGp-form'));
        return false;
    };
}
//open popup data

self.popupTBNK = function (item) {
    var html = [
        $('#dsthietbiGP-template').html()
    ].join('');
    self.pop = app.popup({
        title: 'Danh sách thiết bị nhập khẩu',
        html: html,
        width: 1024,
        buttons: [

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
    });


    ko.applyBindings(item, document.getElementById('dstbGP-form'));
};