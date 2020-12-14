function ChiTietToKhaiThuoc(parent, dataItem, end) {
    var self = this;
    self.tbdThuoc16 = dataItem;
    addRule(self.tbdThuoc16, false);

    self.moduleParent = parent;

    self.save = function () {
        addRule(self.tbdThuoc16, true);
        if (self.tbdThuoc16.valid.errors().length > 0) {
            showError(self.tbdThuoc16.valid());
            self.tbdThuoc16.valid.errors.showAllMessages();
            return;
        }

        readKnockoutArrays(self.moduleParent.fiWeightUnits, function (loopItem) {
            if (loopItem.fiUnitCode == self.tbdThuoc16.fiQuantityUnitCode()) self.tbdThuoc16.fiQuantityUnitName(loopItem.fiUnitName);
        });

        readKnockoutArrays(self.moduleParent.countries, function (loopItem) {
            if (loopItem.fiCountryCode == self.tbdThuoc16.fiExporterCode()) {
                self.tbdThuoc16.fiExporterName(loopItem.fiCountryName);
            }
        });
        if (self.tbdThuoc16.fiSort() == 0 && parent.thuocs().length > 0) {
            var endItem = parent.thuocs()[parent.thuocs().length - 1];
            self.tbdThuoc16.fiSort(endItem.fiSort() + 1);
        } else {
            self.tbdThuoc16.fiSort(1);
        }
        self.tbdThuoc16.fiIdHoSo(idHoSo);
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

            var data = convertKnockoutToObject(self.tbdThuoc16, createObject(self.tbdThuoc16));
            var callURL = '/mard/16/tbdThuoc16/update/' + self.tbdThuoc16.fiId();
            if (self.tbdThuoc16.fiId() == 0) {
                callURL = '/mard/16/tbdThuoc16/create';
            }
            app.makePost({
                url: callURL,
                data: JSON.stringify(data),
                error: function (e) {
                    if (e.readyState != 4) {

                        if (self.tbdThuoc16.fiId() == '' || self.tbdThuoc16.fiId() == 0 || self.tbdThuoc16.fiId() == null) {
                            parent.thuocs.push(convertObjectToKnockout(e, new TbdThuoc16()));
                            clearDataKnockout(self.tbdThuoc16);
                            self.tbdThuoc16.fiQuantityUnitCode('-1');
                            self.tbdThuoc16.fiExporterCode('-1');
                            self.tbdThuoc16.fiId(0);
                            $('#fiNameOfGoods').focus();
                            self.tbdThuoc16.valid.errors.showAllMessages(false);
                            if (end) {
                                end();
                            }
                        } else {
                            var id = e.fiId;
                            readKnockoutArrays(parent.thuocs, function (loopItem) {
                                if (loopItem.fiId() == id) {
                                    convertObjectToKnockout(e, loopItem);
                                }
                            })
                        }
                        showToast(NSWLang["mard.16.action.success"], true);
                        self.close();
                    }

                }
            });

        } else {
            if (self.tbdThuoc16.enable() ) {
                self.tbdThuoc16.fiId(new Date().getTime());
                var cp = cloneKnockoutObject(self.tbdThuoc16, new TbdThuoc16());
                cp.enable(false);
                parent.thuocs.push(cp);
            }  else {
                var id = self.tbdThuoc16.fiId();
                readKnockoutArrays(parent.thuocs, function (loopItem) {
                    if (loopItem.fiId() == id) {
                        cloneKnockoutObject(self.tbdThuoc16, loopItem);
                    }
                })
            }
            if (end) {
                end();
            }
            self.close();
        }


    }

    self.close = function () {
        app.popupRemove(parent.pop.selector);
    }

    $(".select5").select2({
        placeholder: '',
        width: '100%'
    });

    function addRule(item, isAdd) {
        if (isAdd) {
            item["fiQuantityUnitCode"].rules.remove(function (item) {
                return item.rule == "notEqual";
            });
            item["fiExporterCode"].rules.remove(function (item) {
                return item.rule == "notEqual";
            });
            item["fiQuantityUnitCode"].extend({
                notEqual: '-1'
            });
            item["fiExporterCode"].extend({
                notEqual: '-1'
            });
        } else {
            item["fiQuantityUnitCode"].rules.remove(function (item) {
                return item.rule == "notEqual";
            });
            item["fiExporterCode"].rules.remove(function (item) {
                return item.rule == "notEqual";
            });
        }
    }


}