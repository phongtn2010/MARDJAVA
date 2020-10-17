function ChiTietThuocViewModel(parent, moduleThongTinChung) {
    var self = this;
    self.moduleThongTinChung = moduleThongTinChung;
    self.xemHoSo = ko.observable(parent.xemHoSo);
    self.thuocs = ko.observableArray();
    self.fiWeightUnits = ko.observableArray();
    self.customPagination = new CustomPagination([], 5);

    self.fiWeightUnits.push({fiUnitName: NSWLang["mard.15.select.option"], fiUnitCode: '-1'});
    $.getJSON(app.appContext + '/mard/14/cmonUnit14/findAll', function (d) {
        ko.utils.arrayPushAll(self.fiWeightUnits, d);
        setTimeout(function () {
            self.layDanhSachHangHoaTheoHS();
        }, 1);
    });

    self.fiPurposes = ko.observableArray([]);
    self.fiPurposeSelecteds = ko.observableArray([]);
    self.fiPurposesShowInput = ko.observableArray([ko.observable(false), ko.observable(false), ko.observable(false)]);


    self.layDanhMucMucDich = function () {
        readArrayObjects(parent.formData.danhMucMucDichs, function (item) {
            self.fiPurposes.push(convertObjectToKnockout(item, new TbsMucDich15()));
        });
    }
    self.layDanhMucMucDich();

    if (parent.formData.hoSo.fiPurposes) {
        var currentSelected = parent.formData.hoSo.fiPurposes.split(';');
        if (currentSelected != null && currentSelected.length > 0) {
            readArrayObjects(currentSelected, function (item, index) {
                self.fiPurposeSelecteds.push(self.fiPurposes()[parseInt(item) - 1]);
            });
        }
    }
    self.checkBoxSelected = function (item) {
        if (self.fiPurposeSelecteds.indexOf(item) != -1) {
            self.fiPurposeSelecteds.remove(item);
            self.clearData(item);
        } else {
            self.fiPurposeSelecteds.push(item);
        }
    }

    self.radioButtonClick = function(item) {
        self.fiPurposeSelecteds.removeAll();
        return true;
    }
    self.clearData = function (item) {
        if (item.fiDisplayGroup()) {
            var grps = item.fiDisplayGroup().split(';');
            readArrayObjects(grps, function (loopItem2) {
                self.moduleThongTinChung.tbdHoSo15[loopItem2](null);
            });
        }
    }

    self.checkDisplayGroup = function (groups) {
        var check = false;
        readKnockoutArrays(self.fiPurposeSelecteds, function (loopItem) {
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

        self.fiTypeGoods.push({fiCode: '-1', fiName: NSWLang["mard.15.select.option"]});

        readArrayObjects(parent.formData.danhMucThuocs, function (item) {
            self.fiTypeGoods.push(item);
        });

        readArrayObjects(parent.formData.thuocs, function (item) {
            item.enable = false;
            self.thuocs.push(convertObjectToKnockout(item, new TbdThuoc15()));
        }, function () {
        });
        self.customPagination.loadPage(self.thuocs());
    };


    self.addHangHoa = function (item) {
        self.openForm(new TbdThuoc15(), function () {
            self.customPagination.lastPage(true);
            self.customPagination.loadPage(self.thuocs());
        });
    }

    self.editHangHoa = function (item) {
        self.openForm(cloneKnockoutObject(item, new TbdThuoc15()));
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
                $.getJSON(app.appContext + '/mard/15/tbdThuoc15/delete/' + item.fiId(), function (d) {
                    self.thuocs.remove(item);
                    self.customPagination.lastPage(false);
                    self.customPagination.loadPage(self.thuocs());
                    app.popupRemove(pop.selector);
                })
            } else {
                self.thuocs.remove(item);
                self.customPagination.lastPage(false);
                self.customPagination.loadPage(self.thuocs());
            }
        })

    }

    self.isValid = function (isGuiHoSo) {
        var check = true;
        if (action === 2) {
            self.moduleThongTinChung.tbdHoSo15["fiReasonCorrection"].rules.remove(function (item) {
                return item.rule == "required";
            });
            self.moduleThongTinChung.tbdHoSo15["fiReasonCorrection"].extend({
                required: true,
            });
        }
        readKnockoutArrays(self.thuocs, function (item, index) {
            if (index == self.thuocs().length - 1 && item.valid.errors().length == 10) return true;
            check = item.valid.errors().length == 0;
            showError(item.valid(), index);
            item.valid.errors.showAllMessages();
        });
        if (isGuiHoSo) {
            if (self.thuocs().length == 0) {
                app.Alert(NSWLang["mard.15.thuoc.notValid"]);
                check = false;
                goToElement("#ChiTietThuocViewModel");
            }
        }

        readKnockoutArrays(self.fiPurposes, function (loopItem) {
            if (loopItem != undefined) {
                if (loopItem.fiDisplayGroup() != null && loopItem.fiDisplayGroup() != undefined) {
                    var grps = loopItem.fiDisplayGroup().split(';');
                    readArrayObjects(grps, function (loopItem2) {
                        self.moduleThongTinChung.tbdHoSo15[loopItem2].rules.remove(function (item) {
                            return item.rule == "required";
                        });
                    });
                }
            }
        });

        readKnockoutArrays(self.fiPurposeSelecteds, function (loopItem) {
            if (loopItem != undefined) {
                if (loopItem.fiDisplayGroup() != null && loopItem.fiDisplayGroup() != undefined) {
                    var grps = loopItem.fiDisplayGroup().split(';');
                    readArrayObjects(grps, function (loopItem2) {
                        self.moduleThongTinChung.tbdHoSo15[loopItem2].extend({
                            required: true,
                        });
                    });
                }
            }
        });

        var mucDich = '';
        self.fiPurposeSelecteds().forEach(function (item, index) {
            if (item != undefined && item != null) {
                mucDich += item.fiCode() + ";";
            }
        });
        if (mucDich.endsWith(";")) {
            self.moduleThongTinChung.tbdHoSo15.fiPurposes(mucDich.substring(0, mucDich.length - 1));
        }
        if (self.moduleThongTinChung.tbdHoSo15.valid.errors().length > 0) {
            showError(self.moduleThongTinChung.tbdHoSo15);
            self.moduleThongTinChung.tbdHoSo15.valid.errors.showAllMessages();
            return false;
        }

        return check;
    }

    self.convertData = function () {
        var data = [];
        self.thuocs().forEach(function (item, index) {
            item.fiSort(index);
            readKnockoutArrays(self.fiWeightUnits, function (loopItem) {
                if (loopItem.fiUnitCode == item.fiQuantityUnitCode()) item.fiQuantityUnitName(loopItem.fiUnitName);
            });
            if (idHoSo == 0) item.fiId(0);
            data.push(convertKnockoutToObject(item, createObject(new TbdThuoc15())));
        });

        return data;
    }

    self.openForm = function (item, endAction) {
        var callback = function (html) {
            var pop = app.popup({
                title: "<b style='text-transform: uppercase'>"+ NSWLang["mard.15.form.thongTinThuoc"] +"</b>",
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
            code: "15",
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
            $('#fileUploadExcel' + position).val('');
            app.Alert( NSWLang["mard.14.uploadSize"]);
            return false;
        }
        var findId = idHoSo;
        for (var k = 0; k < files.length; k++) {
            var param = {};
            param.mcode = "mard";
            param.pcode = "15";
            param.file = files[k];
            app.uploadFile({
                url: '/mard/api/15/uploadFileExcel/' + findId,
                data: param,
                success: function (d) {
                    if (d.success) {
                        $('#fileUploadExcel').val('');
                        readArrayObjects(d.data, function (item) {
                            item.enable = false;
                            if (!item.fiId) {
                                item.fiId = new Date().getTime();
                            }
                            self.thuocs.push(convertObjectToKnockout(item, new TbdThuoc15()));
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
 

