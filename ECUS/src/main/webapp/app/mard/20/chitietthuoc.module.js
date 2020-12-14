function ChiTietThuocViewModel(parent, moduleThongTinChung) {
    var self = this;
    self.moduleThongTinChung = moduleThongTinChung;
    self.xemHoSo = ko.observable(parent.xemHoSo);
    self.thuocs = ko.observableArray();
    self.fiWeightUnits = ko.observableArray();
    self.customPagination = new CustomPagination([], 5);
    self.countries = ko.observableArray();

    self.fiWeightUnits.push({fiUnitName: NSWLang["mard.20.select.option"], fiUnitCode: '-1'});

    $.getJSON(app.appContext + '/mard/14/cmonUnit14/findAll', function (d) {
        ko.utils.arrayPushAll(self.fiWeightUnits, d);
        setTimeout(function () {
            self.layDanhSachHangHoaTheoHS();
        }, 1);
    });
    self.countries.push({fiCountryName: NSWLang["mard.20.select.option"], fiCountryCode: '-1', fiCountryID: 0});
    $.getJSON(app.appContext + '/mard/14/cmonCountry14/findAll', function (d) {
        ko.utils.arrayPushAll(self.countries, d);
    });
    self.fiCertificateType = ko.observableArray([]);
    self.fiCertificateTypeSelecteds = ko.observableArray([]);
    self.fiCertificateTypeShowInput = ko.observableArray([ko.observable(false), ko.observable(false), ko.observable(false)]);

    self.layDanhMucLoaiCN = function () {
        readArrayObjects(parent.formData.danhMucLoaiCN, function (item) {
            self.fiCertificateType.push(convertObjectToKnockout(item, new TbsLoaiCN20()));
        });
    }
    self.layDanhMucLoaiCN();

    if (parent.formData.hoSo.fiCertificateType) {
        var currentSelected = parent.formData.hoSo.fiCertificateType.split(';');
        if (currentSelected != null && currentSelected.length > 0) {
            readArrayObjects(currentSelected, function (item, index) {
                self.fiCertificateTypeSelecteds.push(self.fiCertificateType()[parseInt(item) - 1]);
            });
        }
    }
    self.checkBoxCTSelected = function (item) {
        if (self.fiCertificateTypeSelecteds.indexOf(item) != -1) {
            self.fiCertificateTypeSelecteds.remove(item);
            self.clearData(item);
        } else {
            self.fiCertificateTypeSelecteds.push(item);
            
        }
    }

    self.clearData = function (item) {
        if (item.fiDisplayGroup()) {
            var grps = item.fiDisplayGroup().split(';');
            readArrayObjects(grps, function (loopItem2) {
                self.moduleThongTinChung.tbdHoSo20[loopItem2](null);
            });
        }
    }


    self.checkCTDisplayGroup = function (groups) {
        var check = false;
        readKnockoutArrays(self.fiCertificateTypeSelecteds, function (loopItem) {
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



    self.fiProductTypes = ko.observableArray([]);

    self.layDanhSachHangHoaTheoHS = function () {


        self.fiProductTypes.push({fiCode: '-1', fiName: NSWLang["mard.20.select.option"]});

        readArrayObjects(parent.formData.danhMucThuocs, function (item) {
            self.fiProductTypes.push(item);
        });

        readArrayObjects(parent.formData.thuocs, function (item) {
            item.enable = false;
            self.thuocs.push(convertObjectToKnockout(item, new TbdThuoc20()));


        }, function () {
        });


        self.customPagination.loadPage(self.thuocs());
    };




    self.editTepDinhKemThuoc = function (item){
        var tepDinhKemThuoc = new TepDinhKemThuocView();
        tepDinhKemThuoc.show(item, "tep_dinh_kem_thuoc");
    }
    self.viewTepDinhKemThuoc = function (item){
        var tepDinhKemThuoc = new TepDinhKemThuocView();
        tepDinhKemThuoc.show(item, "tep_dinh_kem_thuoc_view");
    }
    self.addHangHoa = function (item) {
        self.openForm(new TbdThuoc20(), function () {
            self.customPagination.lastPage(true);
                    self.customPagination.loadPage(self.thuocs());
        });
    }

    self.editHangHoa = function (item) {
        item.enable(false);
        self.openForm(cloneKnockoutObject(item, new TbdThuoc20()));
    }
    self.updateHangHoa = function (item) {
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
            if (idHoSo > 0) {
                $.getJSON(app.appContext + '/mard/20/tbdThuoc20/delete/' + item.fiId(), function (d) {
                    self.thuocs.remove(item);
                    self.customPagination.lastPage(false);
                    self.customPagination.loadPage(self.thuocs());
                })
            } else {
                self.thuocs.remove(item);
                self.customPagination.lastPage(false);
                self.customPagination.loadPage(self.thuocs());
            }
        })

    }
    self.addTep = function(tep, tepThuoc){
        var self = this;
        tepThuoc.push(tep);
    }


    self.isValid = function (isGuiHoSo) {
        var check = true;
        if (action === 2) {
            self.moduleThongTinChung.tbdHoSo20["fiReasonCorrection"].rules.remove(function (item) {
                return item.rule == "required";
            });
            self.moduleThongTinChung.tbdHoSo20["fiReasonCorrection"].extend({
                required: true,
            });
        }
        readKnockoutArrays(self.thuocs, function (item, index) {
            if (index == self.thuocs().length - 1 && item.valid.errors().length == 8 ) return true;
            if (idHoSo > 0 && item.fiTepDinhKemThuocs().length == 0) {
                $.ajax({
                    url: app.appContext + '/mard/20/tbdDinhKem20/findByFiProductId/' + item.fiId(),
                    dataType: 'json',
                    async: false,
                    data: null,
                    success: function(d) {
                        if(d.length > 0){
                            for(var index = 0; index < d.length; index++){
                                var tep = new TepTinThuocModel();
                                tep.fiId(d[index].fiId); //??? sao lai lấy ID vào đây
                                tep.fiFileName(d[index].fiFileName);
                                tep.fiFileTypeCode(d[index].fiFileTypeCode);
                                tep.fiFileGroup(d[index].fiFileGroup);
                                tep.fiPath(d[index].fiPath);
                                self.addTep(tep, item.fiTepDinhKemThuocs);
                            }
                        }

                    }
                });
            }
            check = item.valid.errors().length == 0 ;
            showError(item.valid(), index);
            item.valid.errors.showAllMessages();
        });
        if (isGuiHoSo) {

            if (self.thuocs().length == 0) {
                app.Alert(NSWLang["mard.20.thuoc.notValid"]);
                check = false;
                goToElement("#ChiTietThuocViewModel");
            }
            else {
                var TepThuocIsValid = '';

                self.thuocs().forEach(function (itemThuoc, indexThuoc) {
                if(itemThuoc.fiTepDinhKemThuocs().length == 0){
                    TepThuocIsValid += ((indexThuoc + 1) + ',');
                    check = false;
                }
                else {
                    check = true;
                }
            });
                if(TepThuocIsValid != null && TepThuocIsValid != undefined && TepThuocIsValid!= ''){
                    TepThuocIsValid = TepThuocIsValid.substring(0, TepThuocIsValid.length - 1);
                    app.Alert('Tệp đính kèm theo hàng hóa chưa đầy đủ, tại dòng hàng thứ ' + TepThuocIsValid );
                    check = false;
                }
            }
        }

        //fiCertificateTypes
        readKnockoutArrays(self.fiCertificateType, function (loopItemCT) {
            if (loopItemCT != undefined) {
                if (loopItemCT.fiDisplayGroup() != null && loopItemCT.fiDisplayGroup() != undefined) {
                    var grpsCT = loopItemCT.fiDisplayGroup().split(';');
                    readArrayObjects(grpsCT, function (loopItemCT2) {
                        self.moduleThongTinChung.tbdHoSo20[loopItemCT2].rules.remove(function (item) {
                            return item.rule == "required";
                        });
                    });
                }
            }
        });

        readKnockoutArrays(self.fiCertificateTypeSelecteds, function (loopItemCT) {
            if (loopItemCT != undefined) {
                if (loopItemCT.fiDisplayGroup() != null && loopItemCT.fiDisplayGroup() != undefined) {
                    var grpsCT = loopItemCT.fiDisplayGroup().split(';');
                    readArrayObjects(grpsCT, function (loopItemCT2) {
                        self.moduleThongTinChung.tbdHoSo20[loopItemCT2].extend({
                            required: true,
                            maxLength: 500
                        });
                    });
                }
            }
        });

        //fiCertificateType
        var LoaiCN = '';
        self.fiCertificateTypeSelecteds().forEach(function (item, index) {
            if (item != undefined && item != null) {
                LoaiCN += item.fiCode() + ";";
            }
        });

        if (LoaiCN.endsWith(";")) {
            self.moduleThongTinChung.tbdHoSo20.fiCertificateType(LoaiCN.substring(0, LoaiCN.length - 1));
        }

        if (self.moduleThongTinChung.tbdHoSo20.valid.errors().length > 0) {
            showError(self.moduleThongTinChung.tbdHoSo20);
            self.moduleThongTinChung.tbdHoSo20.valid.errors.showAllMessages();
            return false;
        }

        return check;
    }

    self.convertData = function () {
        var data = [];
        self.thuocs().forEach(function (item, index) {
            item.fiSort(index);
            readKnockoutArrays(self.fiWeightUnits, function (loopItem) {
                if (loopItem.fiUnitCode == item.fiWeightUnitCode()) item.fiWeightUnitName(loopItem.fiUnitName);
            });
            if (idHoSo == 0) item.fiId(0);
            data.push(convertKnockoutToObject(item, createObject(new TbdThuoc20())));
        });

        return data;
    }

    self.openForm = function (item, endAction) {
        var callback = function (html) {
            var pop = app.popup({
                title: "<b style='text-transform: uppercase'>"+ NSWLang["mard.20.form.thongTinThuoc"] +"</b>",
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
            code: "20",
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
                app.Alert( NSWLang["mard.20.loiKieuFileExcel"]);
                return false;
            }
        }
        var totalMB = 1024 * 1024 * 5;// 5MB

        if (files[0].size > totalMB) {
            $('#fileUploadExcel' + position).val('');
            app.Alert( NSWLang["mard.20.uploadSize"]);
            return false;
        }
        var findId = idHoSo;
        for (var k = 0; k < files.length; k++) {
            var param = {};
            param.mcode = "mard";
            param.pcode = "20";
            param.file = files[k];
            app.uploadFile({
                url: '/mard/api/20/uploadFileExcel/' + findId,
                data: param,
                success: function (d) {
                    if (d.success) {
                        $('#fileUploadExcel').val('');
                        readArrayObjects(d.data, function (item) {
                            item.enable = false;
                            if (!item.fiId) {
                                item.fiId = new Date().getTime();
                            }
                            self.thuocs.push(convertObjectToKnockout(item, new TbdThuoc20()));
                        }, function () {
                        });
                        self.customPagination.firstPage(true);
                        self.customPagination.loadPage(self.thuocs());
                    } else {
                        $('#fileUploadExcel').val('');
                        toastr.error(NSWLang["common_msg_thong_bao"],  NSWLang["mard.20.loiCapNhatDuLieu"]);
                    }

                },
                error: function (e) {
                    toastr.error(NSWLang["common_msg_thong_bao"],  NSWLang["mard.20.loiCapNhatDuLieu"]);
                    $('#fileUploadExcel').val('');


                }
            });

        }

    }



    /*self.SelectedHour.subscribe(function (v) {
        if (!isUpdatingSelectedHour) {
            var digits = v.replace(/\D/g, '');
            var isAM = (v.toLowerCase().indexOf('pm') == -1);
            if (parseInt(digits) > 1259 || parseInt(digits.slice(2)) > 60) {
                return;
            }
            if (digits.length == 3) {
                v = digits.substring(0, 1) + ':' + digits.substring(1, 3) + (isAM ? ' AM' : ' PM');
                updateSelectedHour(v);
            } else if (digits.length == 4) {
                v = digits.substring(0, 2) + ':' + digits.substring(2, 4) + (isAM ? ' AM' : ' PM');
                updateSelectedHour(v);
            }
        }
    });*/




}
 

