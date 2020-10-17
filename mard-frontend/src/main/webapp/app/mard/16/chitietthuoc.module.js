function ChiTietThuocViewModel(parent, moduleThongTinChung) {
    var self = this;
    self.moduleThongTinChung = moduleThongTinChung;
    self.xemHoSo = ko.observable(parent.xemHoSo);
    self.thuocs = ko.observableArray();
    self.fiWeightUnits = ko.observableArray();
    self.countries = ko.observableArray();
    self.customPagination = new CustomPagination([], 5);

    self.fiWeightUnits.push({fiUnitName: NSWLang["mard.16.select.option"], fiUnitCode: '-1'});
    $.getJSON(app.appContext + '/mard/14/cmonUnit14/findAll', function (d) {
        ko.utils.arrayPushAll(self.fiWeightUnits, d);
        setTimeout(function () {
            self.layDanhSachHangHoaTheoHS();
        }, 1);
    });

    self.countries.push({fiCountryName: NSWLang["mard.16.select.option"], fiCountryCode: '-1', fiCountryID: 0});
    $.getJSON(app.appContext + '/mard/14/cmonCountry14/findAll', function (d) {
        ko.utils.arrayPushAll(self.countries, d);
    });

    self.fiPurposes = ko.observableArray([]);
    self.fiPurposeSelecteds = ko.observableArray([]);

    self.fiDocument = ko.observableArray([]);
    self.fiDocumentSelecteds = ko.observableArray([]);

    self.getLoaiGiayTo = function() {
        readArrayObjects(parent.formData.tbsLoaiGiayTo16s, function (item) {
            self.fiDocument.push(convertObjectToKnockout(item, new TbsLoaiGiayTo16()));
        });
    }

    self.getLoaiGiayTo();
    self.layDanhMucMucDich = function () {
        readArrayObjects(parent.formData.danhMucMucDichs, function (item) {
            self.fiPurposes.push(convertObjectToKnockout(item, new TbsMucDich16()));
        });
    }
    self.layDanhMucMucDich();

    if (parent.formData.hoSo.fiPurposes) {
        var currentSelected = parent.formData.hoSo.fiPurposes.toString().split(';');
        if (currentSelected != null && currentSelected.length > 0) {
            readArrayObjects(currentSelected, function (item, index) {
                self.fiPurposeSelecteds.push(self.fiPurposes()[parseInt(item) - 1]);
            });
        }
    }

    if (parent.formData.hoSo.fiDocument) {
        var currentSelected = parent.formData.hoSo.fiDocument.toString().split(';');
        if (currentSelected != null && currentSelected.length > 0) {
            readArrayObjects(currentSelected, function (item, index) {
                self.fiDocumentSelecteds.push(self.fiDocument()[parseInt(item) - 1]);
            });
        }
    }

    self.checkBoxSelected = function (item, selected) {
        if (selected().indexOf(item) != -1) {
            selected.remove(item);

        } else {
            selected.push(item);
        }
        self.clearData(item);
    }

    self.radioButtonClick = function(item) {
       self.fiPurposeSelecteds.removeAll();
        return true;
    }
    self.clearData = function (item) {
        if (item.fiDisplayGroup()) {
            var grps = item.fiDisplayGroup().split(';');
            readArrayObjects(grps, function (loopItem2) {
                self.moduleThongTinChung.tbdHoSo16[loopItem2](null);
            });
        }
    }

    self.checkDisplayGroup = function (arrs, groups) {
        var check = false;
        readKnockoutArrays(arrs, function (loopItem) {
            if (loopItem != undefined) {
                if (loopItem.fiDisplayGroup() != null && loopItem.fiDisplayGroup() != undefined) {
                    groups.forEach(function (item, index) {
                        var grps = loopItem.fiDisplayGroup().split(';');
                        readArrayObjects(grps, function (loopItem2) {
                            if (item == loopItem2) check = true;
                        })
                    })
                }
            }
        });
        return check;
    }

    self.fiTypeGoods = ko.observableArray([]);

    self.layDanhSachHangHoaTheoHS = function () {

        self.fiTypeGoods.push({fiCode: '-1', fiName: NSWLang["mard.16.select.option"]});

        readArrayObjects(parent.formData.danhMucThuocs, function (item) {
            self.fiTypeGoods.push(item);
        });

        readArrayObjects(parent.formData.thuocs, function (item) {
            item.enable = false;
            self.thuocs.push(convertObjectToKnockout(item, new TbdThuoc16()));
        }, function () {
        });
        self.customPagination.loadPage(self.thuocs());
    };


    self.addHangHoa = function (item) {
        self.openForm(new TbdThuoc16(), function () {
            self.customPagination.lastPage(true);
            self.customPagination.loadPage(self.thuocs());
        });
    }

    self.editHangHoa = function (item) {
        item.enable(false);
        self.openForm(cloneKnockoutObject(item, new TbdThuoc16()));
    }

    self.addEndRow = function () {


    }


    self.save = function (item, end) {

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
            if (idHoSo> 0) {
                $.getJSON(app.appContext + '/mard/16/tbdThuoc16/delete/' + item.fiId(), function (d) {
                    self.thuocs.remove(item);
                    self.customPagination.loadPage(self.thuocs());
                    if (self.thuocs().length == 0) {
                        self.addEndRow();
                    }
                    self.customPagination.lastPage(false);
                    self.customPagination.loadPage(self.thuocs());
                    app.popupRemove(pop.selector);

                })
            } else {
                self.thuocs.remove(item);
                if (self.thuocs().length == 0) {
                    self.addEndRow();
                }
                self.customPagination.lastPage(false);
                self.customPagination.loadPage(self.thuocs());
            }
        })

    }

    self.isValid = function (isGuiHoSo) {
        var check = true;
        showError(self.moduleThongTinChung.tbdHoSo16);
        if (action === 2) {
            self.moduleThongTinChung.tbdHoSo16["fiReasonCorrection"].rules.remove(function (item) {
                return item.rule == "required";
            });
            self.moduleThongTinChung.tbdHoSo16["fiReasonCorrection"].extend({
                required: true,
            });
        }
        readKnockoutArrays(self.thuocs, function (item, index) {
            check = item.valid.errors().length == 0;
            showError(item.valid(), index);
            item.valid.errors.showAllMessages();
        });
        if (isGuiHoSo) {
            if (self.thuocs().length == 0) {
                app.Alert(NSWLang["mard.16.thuoc.notValid"]);
                goToElement("#ChiTietThuocViewModel");
                check = false;
            }
        }

        self.validateDynamic(self.fiPurposes, self.fiPurposeSelecteds);
        self.validateDynamic(self.fiDocument, self.fiDocumentSelecteds);

        self.moduleThongTinChung.tbdHoSo16.fiPurposes(self.convertArrayToString(self.fiPurposeSelecteds));
        self.moduleThongTinChung.tbdHoSo16.fiDocument(self.convertArrayToString(self.fiDocumentSelecteds));
        if (self.moduleThongTinChung.tbdHoSo16.valid.errors().length > 0) {
            showError(self.moduleThongTinChung.tbdHoSo16);
            self.moduleThongTinChung.tbdHoSo16.valid.errors.showAllMessages();
            return false;
        }
        return check;
    }

    self.convertArrayToString = function(a) {
        var mucDich = '';
        readKnockoutArrays(a, function (loopItem) {
                mucDich += loopItem.fiCode() + ";";
        });
        return mucDich.substr(0, mucDich.length - 1);
    }
    self.validateDynamic = function(a, b) {
        readKnockoutArrays(a, function (loopItem) {
            if (loopItem != undefined) {
                if (loopItem.fiDisplayGroup() != null && loopItem.fiDisplayGroup() != undefined) {
                    var grps = loopItem.fiDisplayGroup().split(';');
                    readArrayObjects(grps, function (loopItem2) {
                        self.moduleThongTinChung.tbdHoSo16[loopItem2].rules.remove(function (item) {
                            return item.rule == "required";
                        });
                    });
                }
            }
        });

        readKnockoutArrays(b, function (loopItem) {
            if (loopItem != undefined) {
                if (loopItem.fiDisplayGroup() != null && loopItem.fiDisplayGroup() != undefined) {
                    var grps = loopItem.fiDisplayGroup().split(';');
                    readArrayObjects(grps, function (loopItem2) {
                        self.moduleThongTinChung.tbdHoSo16[loopItem2].extend({
                            required: true,
                        });
                    });
                }
            }
        });
    }


    self.convertData = function () {
        var data = [];
        self.thuocs().forEach(function (item, index) {
            item.fiSort(index);
            readKnockoutArrays(self.fiWeightUnits, function (loopItem) {
                if (loopItem.fiUnitCode == item.fiQuantityUnitCode()) item.fiQuantityUnitName(loopItem.fiUnitName);
            });
            if (idHoSo == 0) item.fiId(0);
            data.push(convertKnockoutToObject(item, createObject(new TbdThuoc16())));
        });

        return data;
    }

    self.openForm = function (item, endAction) {
        var callback = function (html) {
            var pop = app.popup({
                title: "<b style='text-transform: uppercase'>"+ NSWLang["mard.16.form.thongTinThuoc"] +"</b>",
                html: html,
                width: 960,
                backdrop: true,
                buttons: []
            }, function () {
                var p = new ChiTietToKhaiThuoc(self, item, endAction);
                ko.applyBindings(p, document.getElementById("form-sin-rut-ho-so-popup"));
            });
            self.pop = pop;
        };

        app.complieTemplate({
            ministryCode: "mard",
            code: "16",
            templateName: "to_khai_thuoc",
            data: []
        }, callback);
    }


    self.accepFiles = ['xlsx', 'xls'];
    self.uploadFileChangeEvent = function(elemet, event) {
        var files = event.target.files;
        for (var i = 0, file; file = files[i]; i++) {
            var ext = file.name.substr(file.name.lastIndexOf('.') + 1);
            if ($.inArray(ext, self.accepFiles) === -1) {
                $('#fileUploadExcel').val('');
                app.Alert( NSWLang["mard.14.loiKieuFileExcel"]);
                return false;
            }
        }
        var totalMB = 1024 * 1024 * 5;// 5MB

        if (files[0].size > totalMB) {
            $('#fileUploadExcel').val('');
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
                url: '/mard/api/16/uploadFileExcel/thuoc/' + findId,
                data: param,
                success: function (d) {
                    if (d.success) {
                        $('#fileUploadExcel').val('');
                        readArrayObjects(d.data, function (item) {
                            item.enable = false;
                            if (!item.fiId) {
                                item.fiId = new Date().getTime();
                            }
                            self.thuocs.push(convertObjectToKnockout(item, new TbdThuoc16()));
                        }, function () {
                        });
                        self.customPagination.firstPage(true);
                        self.customPagination.loadPage(self.thuocs());
                    } else {
                        $('#fileUploadExcel').val('');
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
 

