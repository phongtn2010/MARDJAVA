function TbdThietB03ViewModel(self) {


    self.titles = ko.observableArray([]);
    self.dataTable = ko.observableArray([]);
    self.fullDataTable = ko.observableArray([]);
    self.totalElements = ko.observable(0);
    self.currentPage = ko.observable(1);
    self.pageSize = ko.observable(10);

    self.titles.push({key: 'fiMaISBN', value: i18nextko.t('TbdThietBi03.fiMaISBN'), required: true, columnType: TABLE_COLUMN_DISPLAY_TEXT});
    self.titles.push({key: 'fiTenGoc', value: i18nextko.t('TbdThietBi03.fiTenGoc'), required: true, columnType: TABLE_COLUMN_DISPLAY_TEXT});
    self.titles.push({key: 'fiTenTiengViet', value: i18nextko.t('TbdThietBi03.fiTenTiengViet'), required: true, columnType: TABLE_COLUMN_DISPLAY_TEXT});
    self.titles.push({key: 'fiTenTacGia', value: i18nextko.t('TbdThietBi03.fiTenTacGia'), required: true, columnType: TABLE_COLUMN_DISPLAY_TEXT});
    self.titles.push({key: 'fiTenNhaCC', value: i18nextko.t('TbdThietBi03.fiTenNhaCC'), required: true, columnType: TABLE_COLUMN_DISPLAY_TEXT});
    self.titles.push({key: 'fiTheLoai', value: i18nextko.t('TbdThietBi03.fiTheLoai'), required: true, columnType: TABLE_COLUMN_DISPLAY_TEXT});
    self.titles.push({key: 'fiSoBan', value: i18nextko.t('TbdThietBi03.fiSoBan'), align: 'right', required: true, columnType: TABLE_COLUMN_DISPLAY_TEXT});
    self.titles.push({key: 'fiTomTat', value: i18nextko.t('TbdThietBi03.fiTomTat'), columnType: TABLE_COLUMN_DISPLAY_TEXT});
    self.titles.push({key: 'fiSoLuongDia', value: i18nextko.t('TbdThietBi03.fiSoLuongDia'), align: 'right', required: true, columnType: TABLE_COLUMN_DISPLAY_TEXT});
    self.titles.push({key: 'fiSoLuongBang', value: i18nextko.t('TbdThietBi03.fiSoLuongBang') , align: 'right', required: true, columnType: TABLE_COLUMN_DISPLAY_TEXT});
    self.titles.push({key: 'fiSoLuongCatset', value: i18nextko.t('TbdThietBi03.fiSoLuongCatset'), align: 'right', required: true, columnType: TABLE_COLUMN_DISPLAY_TEXT});
    self.titles.push({key: 'fiHinhThucKhac', value: i18nextko.t('TbdThietBi03.fiHinhThucKhac'), align: 'left', required: true, columnType: TABLE_COLUMN_DISPLAY_TEXT});
    self.titles.push({key: 'actionEdit', value: i18nextko.t('TbdThietBi03.btSua'), icon: 'fa fa-lg fa-edit', action: actionEdit, columnType: TABLE_COLUMN_DISPLAY_BUTTON});
    self.titles.push({key: 'actionDelete', value: i18nextko.t('TbdThietBi03.btXoa'), icon: 'fa fa-lg fa-close', style: "color: red; font-weight: bold;", action: actionDelete, columnType: TABLE_COLUMN_DISPLAY_BUTTON});

    self.pageClick = function (page) {
        self.currentPage(page);
        self.loadTbdThietBi03(page);
    }

    self.dataApi.subscribe(function (d) {
        if (d.hoSo.tbdThietBi03DTOS) {
            d.hoSo.tbdThietBi03DTOS.forEach(function (item) {
                self.fullDataTable.push(convertObjectToKnockout(item, new TbdThietBi03()));
            })
            self.loadTbdThietBi03();
            self.tinhTongSoBan();
        }

    })

    self.addName = function(name) {
        var tenNhaCC = '';
        var tongXBP = 0;
        self.fullDataTable().forEach(function (item, index) {
            tenNhaCC += item.fiTenNhaCC();
            if (index < self.fullDataTable().length - 1) tenNhaCC += ',';
            tongXBP += parseInt(item.fiSoBan());
        });
        if (self.tbdHoSo03.fiTenNhaCC()) {
            tenNhaCC = self.tbdHoSo03.fiTenNhaCC() + ", ";
        }
        tenNhaCC += name;
        self.tbdHoSo03.fiTenNhaCC(tenNhaCC);
        self.tbdHoSo03.fiTongSoXBPham(tongXBP);
        self.tbdHoSo03.fiTongSoTenXBP(self.fullDataTable().length);
    }


    self.loadTbdThietBi03 = function() {
        var calPage = Math.floor(self.fullDataTable().length / 10);
        if (self.fullDataTable().length % 10 !== 0) calPage ++;
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
        self.tbdHoSo03.fiTongSoTenXBP(self.fullDataTable().length);
        self.tinhTongSoBan();
    }

    function actionEdit(item) {
        self.openForm(convertKnockoutToObject(item, createObject(item)));
    }

    function actionDelete(item) {
        self.callConfirm(function () {
            if (idHoSo > 0) {
                callApi('/mic/03/tbdThietBi03/delete/' + idHoSo + "/" + item.fiId(), null, function (d) {
                    var sum = 0;
                    sum += parseFloat(item.fiSoLuongBang());
                    sum += parseFloat(item.fiSoLuongCatset());
                    sum += parseFloat(item.fiSoLuongDia());
                    //self.tbdHoSo03.fiTongSoBangDia(self.tbdHoSo03.fiTongSoBangDia() - sum);
                    self.fullDataTable.remove(item);
                    self.loadTbdThietBi03();
                    self.tinhTongSoBan();
                })
            } else {
                self.fullDataTable.remove(item);
                self.loadTbdThietBi03();
                self.tinhTongSoBan();
            }
        });
    }

    self.tinhTongSoBan = function() {

        var total = 0;
        for (var i = 0; i < self.fullDataTable().length; i++) {
            total += self.fullDataTable()[i].fiSoBan();
        }
        self.tbdHoSo03.fiTongSoXBPham(total);
        callApi('/mic/api/03/save/'+ idHoSo +'/update/'+ self.fullDataTable().length +'/' + self.tbdHoSo03.fiTongSoXBPham(), null, function (d) {});
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
                        self.fullDataTable.push(convertObjectToKnockout(item, new TbdThietBi03()));
                    })
                    self.loadTbdThietBi03();
                    var tenNCC = '';
                    for (var i = 0; i < self.fullDataTable().length; i++) {
                        tenNCC += self.fullDataTable()[i].fiTenNhaCC();
                        if (i < self.fullDataTable().length - 1) tenNCC += ', ';
                    }
                    self.tbdHoSo03.fiTenNhaCC(tenNCC);
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

    self.openForm = function (item, endAction) {
        var callback = function (html) {
            var pop = app.popup({
                title: "<b style='text-transform: uppercase'>"+ (item === null ? i18nextko.t('TbdThietBi03.themMoi')() : i18nextko.t('TbdThietBi03.chinhSua')()) +"</b>",
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
            templateName: "to_khai_thiet_bi",
            data: []
        }, callback);
    }

}
