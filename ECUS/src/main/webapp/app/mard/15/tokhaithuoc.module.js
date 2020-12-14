function ChiTietToKhaiThuoc(parent, dataItem, end) {
    var self = this;
    self.tbdThuoc15 = dataItem;

    self.moduleParent = parent;

    addRule(self.tbdThuoc15, false);

    self.save = function () {
        addRule(self.tbdThuoc15, true);
        if (self.tbdThuoc15.valid.errors().length > 0) {
            showError(self.tbdThuoc15.valid());
            self.tbdThuoc15.valid.errors.showAllMessages();
            return;
        }

        readKnockoutArrays(self.moduleParent.fiWeightUnits, function (loopItem) {

            if (loopItem.fiUnitCode === self.tbdThuoc15.fiQuantityUnitCode()) {
                self.tbdThuoc15.fiQuantityUnitName(loopItem.fiUnitName);
            }
        });

        if (self.tbdThuoc15.fiSort() === 0 && parent.thuocs().length > 0) {
            var endItem = parent.thuocs()[parent.thuocs().length - 1];
            self.tbdThuoc15.fiSort(endItem.fiSort() + 1);
        } else {
            self.tbdThuoc15.fiSort(1);
        }
        self.tbdThuoc15.fiIdHoSo(idHoSo);
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
            var data = convertKnockoutToObject(self.tbdThuoc15, createObject(self.tbdThuoc15));
            var callURL = '/mard/15/tbdThuoc15/update/' + self.tbdThuoc15.fiId();
            if (self.tbdThuoc15.fiId() == 0) {
                callURL = '/mard/15/tbdThuoc15/create';
            }
            app.makePost({
                url: callURL,
                data: JSON.stringify(data),
                error: function (e) {
                    if (e.readyState != 4) {
                        if (self.tbdThuoc15.fiId() == 0 || self.tbdThuoc15.fiId() == null) {
                            parent.thuocs.push(convertObjectToKnockout(e, new TbdThuoc15()));
                            clearDataKnockout(self.tbdThuoc15);
                            $('#fiNameOfGoods').focus();
                            self.tbdThuoc15.fiQuantityUnitCode('-1');
                            self.tbdThuoc15.fiId(0);
                            self.tbdThuoc15.valid.errors.showAllMessages(false);
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
                        showToast(NSWLang["mard.15.action.success"], true);
                        self.close();
                    }

                }
            });

        } else {
            if (self.tbdThuoc15.enable()) {
                self.tbdThuoc15.fiId(new Date().getTime());
                var cp = cloneKnockoutObject(self.tbdThuoc15, new TbdThuoc15());
                cp.enable(false);
                parent.thuocs.push(cp);

            } else {
                var id = self.tbdThuoc15.fiId();
                readKnockoutArrays(parent.thuocs, function (loopItem) {
                    if (loopItem.fiId() == id) {
                        cloneKnockoutObject(self.tbdThuoc15, loopItem);
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
            item["fiQuantityUnitCode"].extend({
                notEqual: '-1'
            });
        } else {
            item["fiQuantityUnitCode"].rules.remove(function (item) {
                return item.rule == "notEqual";
            });
        }
    }

}