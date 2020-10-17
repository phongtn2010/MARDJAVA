function ChiTietToKhaiKyThuat(parent, dataItem, endAction) {
    var self = this;
    self.tbdToKhaiKyThuat16 = dataItem;

    self.moduleParent = parent;
    self.fiPartUsedSelecteds = ko.observableArray([]);
    self.fiUsingValueSelecteds = ko.observableArray([]);

    self.convertStringToArray = function (a, arr, rootArr) {
        if (a) {
            var currentSelected = a.toString().split(';');
            if (currentSelected != null && currentSelected.length > 0) {
                readArrayObjects(currentSelected, function (item) {
                    arr.push(item);
                });
            }
        } else {
            arr.push("-1");
        }
    }
    self.convertArrayToString = function (a) {
        var mucDich = '';
        var findItem = ko.utils.arrayFilter(a(), function(prod) {
            return prod == '-1';
        });
        if (findItem[0]) return null;
        readKnockoutArrays(a, function (loopItem) {
            if (loopItem != '-1')
                mucDich += loopItem + ";";
        });
        if (mucDich.length > 0) {
            return mucDich.substr(0, mucDich.length - 1);
        }
        return null;
    }

    self.convertStringToArray(self.tbdToKhaiKyThuat16.fiPartUsed(), self.fiPartUsedSelecteds, parent.tbsBoPhan16s);
    self.convertStringToArray(self.tbdToKhaiKyThuat16.fiUsingValue(), self.fiUsingValueSelecteds, parent.tbsGiaTriSuDung16s);

    self.save = function () {

        readKnockoutArrays(self.fiPartUsedSelecteds, function (item) {
            console.log(item);
        })
        self.tbdToKhaiKyThuat16.fiPartUsed(self.convertArrayToString(self.fiPartUsedSelecteds));
        self.tbdToKhaiKyThuat16.fiUsingValue(self.convertArrayToString(self.fiUsingValueSelecteds));
        var fiUsings = ko.observableArray([]);
        readKnockoutArrays(self.fiUsingValueSelecteds, function (item) {
            var findItem = ko.utils.arrayFilter(parent.tbsGiaTriSuDung16s(), function(prod) {
                return prod.fiCode() == item;
            });
            if (findItem) fiUsings.push(findItem[0]);
        })
        self.validateDynamic(parent.tbsGiaTriSuDung16s, fiUsings);
        self.tbdToKhaiKyThuat16.fiIdHoSo(idHoSo);
        if (self.tbdToKhaiKyThuat16.fiSortDeclaration() == 0 && parent.toKhaiKyThuats().length > 0) {
            var endItem = parent.toKhaiKyThuats()[parent.toKhaiKyThuats().length - 1];
            self.tbdToKhaiKyThuat16.fiSortDeclaration(endItem.fiSortDeclaration() + 1);
        } else {
            self.tbdToKhaiKyThuat16.fiSortDeclaration(1);
        }

        if (self.tbdToKhaiKyThuat16.valid.errors().length > 0) {
            showError(self.tbdToKhaiKyThuat16);
            self.tbdToKhaiKyThuat16.valid.errors.showAllMessages();
            return;
        }
        self.callConfirm();
    }

    self.callConfirm = function() {
        var pop = app.popup({
            title: NSWLang["common_msg_thong_bao"],
            html: '<i class="fa fa-3x fa-warning"></i> ' + NSWLang["mard.16.confirmSave"],
            width: 400,
            buttons: [
                {
                    name: NSWLang["common_button_toi_chac_chan"],
                    class: 'btn',
                    icon: 'fa-check',
                    action: function () {
                        app.popupRemove(pop.selector);
                        self.callSave();
                    }
                }
            ]
        });
    }

    self.callSave = function() {

        if (idHoSo > 0) {

            var data = convertKnockoutToObject(self.tbdToKhaiKyThuat16, createObject(self.tbdToKhaiKyThuat16));
            var callURL = '/mard/16/tbdToKhaiKyThuat16/update/' + self.tbdToKhaiKyThuat16.fiId();
            if (self.tbdToKhaiKyThuat16.fiId() == 0 || self.tbdToKhaiKyThuat16.fiId() == null) {
                callURL = '/mard/16/tbdToKhaiKyThuat16/create';
            }
            app.makePost({
                url: callURL,
                data: JSON.stringify(data),
                error: function (e) {
                    if (e.readyState != 4) {
                        if (self.tbdToKhaiKyThuat16.fiId() == 0 || self.tbdToKhaiKyThuat16.fiId() == null) {
                            parent.toKhaiKyThuats.push(convertObjectToKnockout(e, new TbdToKhaiKyThuat16()));
                            clearDataKnockout(self.tbdToKhaiKyThuat16);
                            $('#fiNameOfGoodsDeclaration').focus();
                            self.tbdToKhaiKyThuat16.valid.errors.showAllMessages(false);
                        }
                        app.popupRemove(parent.pop.selector);
                        self.fiPartUsedSelecteds.removeAll();
                        self.fiUsingValueSelecteds.removeAll();
                        app.toast({
                            title: NSWLang["common_msg_thong_bao"],
                            message: NSWLang["mard.16.action.success"]
                        });
                        if (endAction) {
                            endAction();
                        }

                    } else {
                        toastr.error(NSWLang["mard.16.action.error"], NSWLang["common_msg_thong_bao"]);
                    }

                }
            });
        } else {
            if (self.tbdToKhaiKyThuat16.enable()) {
                self.tbdToKhaiKyThuat16.fiId(new Date().getTime());
                var cp = cloneKnockoutObject(self.tbdToKhaiKyThuat16, new TbdToKhaiKyThuat16());
                cp.enable(false);
                parent.toKhaiKyThuats.push(cp);
            }else {
                var id = self.tbdToKhaiKyThuat16.fiId();
                readKnockoutArrays(parent.toKhaiKyThuats, function (loopItem) {
                    if (loopItem.fiId() == id) {
                        cloneKnockoutObject(self.tbdToKhaiKyThuat16, loopItem);
                    }
                })
            }
            if (endAction) {
                endAction();
            }
            self.close();
        }
    }


    self.close = function () {
        app.popupRemove(parent.pop.selector);
    }

    self.checkBoxSelected = function (item, selected) {
        if (selected().indexOf(item) != -1) {
            selected.remove(item);
            self.clearData(item, selected);
        } else {
            selected.push(item);
        }
    }

    self.clearData = function (item, selected) {
        if (item.fiDisplayGroup()) {
            var grps = item.fiDisplayGroup().split(';');
            readArrayObjects(grps, function (loopItem2) {
                self.tbdToKhaiKyThuat16[loopItem2](null);
            });
        }
    }

    self.checkDisplayGroup = function (arrs, groups) {
        var check = false;
        readKnockoutArrays(arrs, function (loopItem) {
            var findItem = ko.utils.arrayFilter(parent.tbsGiaTriSuDung16s(), function(prod) {
                return prod.fiCode() == loopItem;
            });
            loopItem = findItem[0];
            if (loopItem) {
                if (loopItem.fiDisplayGroup()) {
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

    self.validateDynamic = function (a, b) {
        readKnockoutArrays(a, function (loopItem) {
            if (loopItem) {
                if (loopItem.fiDisplayGroup()) {
                    var grps = loopItem.fiDisplayGroup().split(';');
                    readArrayObjects(grps, function (loopItem2) {
                        self.tbdToKhaiKyThuat16[loopItem2].rules.remove(function (item) {
                            return item.rule == "required";
                        });
                    });
                }
            }
        });
        readKnockoutArrays(b, function (loopItem) {
            if (loopItem) {
                if (loopItem.fiDisplayGroup()) {
                    var grps = loopItem.fiDisplayGroup().split(';');
                    readArrayObjects(grps, function (loopItem2) {
                        self.tbdToKhaiKyThuat16[loopItem2].extend({
                            required: true,
                        });
                    });
                }
            }
        });
    }

    self.fiUsingValueSelecteds.subscribe(function () {
        var index = self.fiUsingValueSelecteds.indexOf('-1');
        var eleId = 'fiUsingValue';
        if (index > -1) {
            self.fiUsingValueSelecteds.splice(index, 1);
            var li = $($('#' + eleId).parent()).find('li');
            $(li[index]).remove();
        }
    })

    self.fiPartUsedSelecteds.subscribe(function () {
        var index = self.fiPartUsedSelecteds.indexOf('-1');
        var eleId = 'fiPartUsed';
        if (index > -1) {
            self.fiPartUsedSelecteds.splice(index, 1);
            var li = $($('#' + eleId).parent()).find('li');
            $(li[index]).remove();
        }
    })
    $(".select5").select2({
        placeholder: '',
        width: '100%'
    });
}