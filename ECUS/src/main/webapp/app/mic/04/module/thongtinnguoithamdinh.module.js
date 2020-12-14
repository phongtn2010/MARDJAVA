function TbdNguoiThamDinh04ViewModel(self) {


    self.titles = ko.observableArray([]);
    self.dataTable = ko.observableArray([]);
    self.fullDataTable = ko.observableArray([]);
    self.totalElements = ko.observable(0);
    self.currentPage = ko.observable(1);
    self.pageSize = ko.observable(10);

    self.titles.push({key: 'fiHoTen', value: i18nextko.t('TbdNguoiThamDinh04.fiHoTen'), required: false, columnType: TABLE_COLUMN_DISPLAY_TEXT});
    self.titles.push({key: 'fiNgaySinh', value: i18nextko.t('TbdNguoiThamDinh04.fiNgaySinh'), required: false, dateFormat: 'DD/MM/YYYY', columnType: TABLE_COLUMN_DISPLAY_DATE});
    self.titles.push({key: 'fiTrinhDoNghiepVu', value: i18nextko.t('TbdNguoiThamDinh04.fiTrinhDoNghiepVu'), required: false, columnType: TABLE_COLUMN_DISPLAY_TEXT});
    self.titles.push({key: 'fiTrinhDoChuyenMon', value: i18nextko.t('TbdNguoiThamDinh04.fiTrinhDoChuyenMon'), required: false, columnType: TABLE_COLUMN_DISPLAY_TEXT});
    self.titles.push({key: 'fiTrinhDoNgoaiNgu', value: i18nextko.t('TbdNguoiThamDinh04.fiTrinhDoNgoaiNgu'), required: false, columnType: TABLE_COLUMN_DISPLAY_TEXT});
    self.titles.push({key: 'fiTrinhDoNgoaiNgu', value: i18nextko.t('TbdNguoiThamDinh04.fiThamNienCongTac'), required: false, columnType: TABLE_COLUMN_DISPLAY_TEXT});
    self.titles.push({key: 'actionEdit', value: i18nextko.t('TbdNguoiThamDinh04.btSua'), icon: 'fa fa-lg fa-edit', action: actionEdit, columnType: TABLE_COLUMN_DISPLAY_BUTTON});
    self.titles.push({key: 'actionDelete', value: i18nextko.t('TbdNguoiThamDinh04.btXoa'), icon: 'fa fa-lg fa-close', style: "color: red; font-weight: bold;", action: actionDelete, columnType: TABLE_COLUMN_DISPLAY_BUTTON});

    self.pageClick = function (page) {
        self.currentPage(page);
        self.loadTbdNguoiThamDinh04(page);
    }

    self.dataApi.subscribe(function (d) {
        if (d.hoSo.tbdNguoiThamDinh04DTOS) {
            d.hoSo.tbdNguoiThamDinh04DTOS.forEach(function (item) {
                self.fullDataTable.push(convertObjectToKnockout(item, new TbdNguoiThamDinh04()));
            })
        }

        self.loadTbdNguoiThamDinh04();
    })

    self.loadTbdNguoiThamDinh04 = function() {
        var calPage = Math.floor(self.fullDataTable().length / self.pageSize());
        if (self.fullDataTable().length % self.pageSize() !== 0) calPage ++;
        if (self.currentPage() > 1 && calPage < self.currentPage()) self.currentPage(self.currentPage() - 1);
        var from = (self.currentPage() - 1) * self.pageSize();
        var to = self.currentPage() * self.pageSize();
        var d = self.fullDataTable.slice(from, to);
        self.totalElements(self.fullDataTable().length);
        self.dataTable.removeAll();
        if (d) {
            d.forEach(function (value) {
                self.dataTable.push(value);
            })
        }
    }

    function actionEdit(item) {
        self.openForm(convertKnockoutToObject(item, createObject(item)));
    }

    function actionDelete(item) {
        self.callConfirm(function () {
            if (idHoSo > 0) {
                callApi('/mic/04/tbdNguoiThamDinh04/delete/' + idHoSo + "/" + item.fiId(), null, function (d) {
                    self.fullDataTable.remove(item);
                    self.loadTbdNguoiThamDinh04();
                    self.totalElements(self.fullDataTable().length);
                })
            } else {
                self.fullDataTable.remove(item);
                self.loadTbdNguoiThamDinh04();
                self.totalElements(self.fullDataTable().length);
            }
        });
    }

    self.callConfirm = function(p) {
        var pop = app.popup({
            title: NSWLang["common_msg_thong_bao"],
            html: '<i class="fa fa-3x fa-warning"></i> ' + i18nextko.t('saveConfirm')(),
            width: 400,
            buttons: [
                {
                    name: NSWLang["common_button_toi_chac_chan"],
                    class: 'btn',
                    icon: 'fa-check',
                    action: function () {
                        app.popupRemove(pop.selector);
                        p();
                    }
                }
            ]
        });
    }
    self.addNew = function () {
        self.openForm(null, function () {
            self.tbdHoSo03.fiTongSoXBPham(self.fullDataTable().length);
        });
    }

    self.openForm = function (item, endAction) {
        var callback = function (html) {
            var pop = app.popup({
                title: "<b style='text-transform: uppercase'>"+ (item === null ? i18nextko.t('TbdNguoiThamDinh04.themMoi')() : i18nextko.t('TbdNguoiThamDinh04.chinhSua')()) +"</b>",
                html: html,
                width: 960,
                backdrop: true,
                buttons: []
            }, function () {
                var p = new ChiTietToKhaiThietBi(self, item, endAction);
                ko.applyBindings(p, document.getElementById("form-popup"));
            });
            self.pop = pop;
        };

        app.complieTemplate({
            ministryCode: complieTemplateMinistryCode,
            code: complieTemplateCode,
            templateName: "to_khai_nguoi_tham_dinh",
            data: []
        }, callback);
    }

    self.uploadFileExcelChangeEvent = function( elemet, event) {

        var files = event.target.files;
        for (var i = 0, file; file = files[i]; i++) {
            var ext = file.name.substr(file.name.lastIndexOf('.') + 1);
            if ($.inArray(ext, ['xlsx', 'xls']) === -1) {
                $('#fileUploadExcel').val('');
                app.Alert(i18nextko.t('errorUpload')());
                return false;
            }
        }

        var param = {};
        param.mcode = "mic";
        param.pcode = "04";
        param.file = files[0];
        app.uploadFile({
            url: pathAPI + '/uploadFileExcel/' + idHoSo,
            data: param,
            success: function (d) {
                if (d.success) {
                    showToast(d.message, true);
                    if (isDevTest) {
                        console.log(d);
                    }
                    if (idHoSo !== 0)
                    self.fullDataTable.removeAll();
                    d.data.forEach(function (item) {
                        self.fullDataTable.push(convertObjectToKnockout(item, new TbdNguoiThamDinh04()));
                    })
                    self.loadTbdNguoiThamDinh04();
                } else {
                    showToast(d.message, false);
                }
                $('#fileUploadExcel').val('');
            },
            error: function (e) {
                $('#fileUploadExcel').val('');
                toastr.error(NSWLang["common_msg_thong_bao"], e.message);
            }
        });
    }

    self.buttonFileSelected = function (eleId) {
        $("#" + eleId).click();
    }
}
