function TbdToKhaiKyThuat16ViewModel(parent) {
    var self = this;
    self.toKhaiKyThuats = ko.observableArray([]);

    self.tbsGiaTriSuDung16s = ko.observableArray([convertObjectToKnockout({fiName: NSWLang["mard.16.select.option"], fiCode: '-1'}, new TbsGiaTriSuDung16())]);
    self.tbsBoPhan16s = ko.observableArray([convertObjectToKnockout({fiName: NSWLang["mard.16.select.option"], fiCode: '-1'}, new TbsBoPhan16())]);
    self.customPagination = new CustomPagination([], 5);

    readArrayObjects(parent.formData.tbsBoPhan16s, function (item) {
        self.tbsBoPhan16s.push(convertObjectToKnockout(item, new TbsBoPhan16()));
    });
    readArrayObjects(parent.formData.tbsGiaTriSuDung16s, function (item) {
        self.tbsGiaTriSuDung16s.push(convertObjectToKnockout(item, new TbsGiaTriSuDung16()));
    });

    self.layDanhSachHangHoaTheoHS = function () {


        readArrayObjects(parent.formData.toKhaiKyThuats, function (item) {
            item.enable = false;
            self.toKhaiKyThuats.push(convertObjectToKnockout(item, new TbdToKhaiKyThuat16()));
        });
        self.customPagination.loadPage(self.toKhaiKyThuats());
    };

    self.layDanhSachHangHoaTheoHS();
    self.addHangHoa = function () {
        self.openForm(new TbdToKhaiKyThuat16(), function () {
            self.customPagination.lastPage(true);
            self.customPagination.loadPage(self.toKhaiKyThuats());
        });
    }

    self.editHangHoa = function (item) {
        item.enable(false);
        self.openForm(cloneKnockoutObject(item, new TbdToKhaiKyThuat16()));
    }

    self.callConfirm = function(affter) {
        var pop = app.popup({
            title: NSWLang["common_msg_thong_bao"],
            html: '<i class="fa fa-3x fa-warning"></i> ' + NSWLang["common_msg_xoa_ho_so"],
            width: 400,
            buttons: [
                {
                    name: NSWLang["common_button_toi_chac_chan"],
                    class: 'btn',
                    icon: 'fa-check',
                    action: function () {
                        app.popupRemove(pop.selector);
                        if (affter) {
                            affter();
                        }
                    }
                }
            ]
        });
    }

    self.deleteHangHoa = function (item) {
        self.callConfirm(function () {
            if (idHoSo > 0) {
                $.getJSON(app.appContext + '/mard/16/tbdToKhaiKyThuat16/delete/' + item.fiId(), function (d) {
                    self.toKhaiKyThuats.remove(item);
                    self.customPagination.firstPage(true);
                    self.customPagination.loadPage(self.toKhaiKyThuats());
                })
            } else {
                self.toKhaiKyThuats.remove(item);
                self.customPagination.firstPage(true);
                self.customPagination.loadPage(self.toKhaiKyThuats());
            }
        })

    }

    self.isValid = function (isGuiHoSo) {
        var check = true;
        readKnockoutArrays(self.toKhaiKyThuats, function (item, index) {
            check = item.valid.errors().length == 0;
            showError(item.valid(), index);
            item.valid.errors.showAllMessages();
        });
        if (isGuiHoSo) {
            if (self.toKhaiKyThuats().length == 0) {
                app.Alert(NSWLang["mard.16.loiToKhaiKyThuat"]);
                check = false;
                goToElement("#TbdToKhaiKyThuat16ViewModel");
            }
        }
        return check;
    }


    self.pop = null;
    self.openForm = function (item, endAction) {
        var callback = function (html) {
            var pop = app.popup({
                title: NSWLang["mard.16.form.toKhaiKyThuat"],
                html: html,
                width: 960,
                backdrop: true,
                buttons: []
            }, function () {
                var p = new ChiTietToKhaiKyThuat(self, item, endAction);
                ko.applyBindings(p, document.getElementById("form-sin-rut-ho-so-popup"));
            });
            self.pop = pop;
        };

        app.complieTemplate({
            ministryCode: "mard",
            code: "16",
            templateName: "to_khai_ky_thuat",
            data: []
        }, callback);
    }

    self.convertData = function () {
        var data = [];
        self.toKhaiKyThuats().forEach(function (item, index) {
            item.fiSortDeclaration(index);
            if (idHoSo == 0) item.fiId(0);
            data.push(convertKnockoutToObject(item, createObject(new TbdToKhaiKyThuat16())));
        });

        return data;
    }

    self.accepFiles = ['xlsx', 'xls'];
    self.uploadFileChangeEvent = function(elemet, event) {
        var files = event.target.files;
        for (var i = 0, file; file = files[i]; i++) {
            var ext = file.name.substr(file.name.lastIndexOf('.') + 1);
            if ($.inArray(ext, self.accepFiles) === -1) {
                $('#fileUploadExcelToKhaiKyThuat').val('');
                app.Alert( NSWLang["mard.14.uploadInfo"]);
                return false;
            }
        }
        var totalMB = 1024 * 1024 * 5;// 5MB

        if (files[0].size > totalMB) {
            $('#fileUploadExcelToKhaiKyThuat').val('');
            app.Alert( NSWLang["mard.14.uploadSize"]);
            return false;
        }
        var findId = idHoSo;
        for (var k = 0; k < files.length; k++) {
            var param = {};
            param.mcode = "mard";
            param.pcode = "16";
            param.file = files[k];
            app.uploadFile({
                url: '/mard/api/16/uploadFileExcel/toKhaiKyThuat/' + findId,
                data: param,
                success: function (d) {
                    if (d.success) {
                        $('#fileUploadExcelToKhaiKyThuat').val('');
                        readArrayObjects(d.data, function (item) {
                            item.enable = false;
                            self.toKhaiKyThuats.push(convertObjectToKnockout(item, new TbdToKhaiKyThuat16()));
                        }, function () {
                        });
                        self.customPagination.loadPage(self.toKhaiKyThuats());
                    } else {
                        $('#fileUploadExcelToKhaiKyThuat').val('');
                        toastr.error(NSWLang["common_msg_thong_bao"],  NSWLang["mard.14.loiCapNhatDuLieu"]);
                    }

                },
                error: function (e) {
                    toastr.error(NSWLang["common_msg_thong_bao"],  NSWLang["mard.14.loiCapNhatDuLieu"]);
                    $('#fileUploadExcel').val('');

                }
            });

        }

    }


}
