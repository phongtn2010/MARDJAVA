function ChiTietToKhaiThuoc(parent, dataItem, end) {
    var self = this;
    self.tbdThuoc14 = dataItem;

    self.moduleParent = parent;

    addRule(self.tbdThuoc14, false);

    self.save = function () {
        addRule(self.tbdThuoc14, true);
        if (self.tbdThuoc14.valid.errors().length > 0) {
            showError(self.tbdThuoc14.valid());
            self.tbdThuoc14.valid.errors.showAllMessages();
            return;
        }

        readKnockoutArrays(self.moduleParent.fiWeightUnits, function (loopItem) {
            if (loopItem.fiUnitCode == self.tbdThuoc14.fiWeightUnitCode()) self.tbdThuoc14.fiWeightUnitName(loopItem.fiUnitName);
        });

        if (self.tbdThuoc14.fiSort() == 0 && parent.thuocs().length > 0) {
            var endItem = parent.thuocs()[parent.thuocs().length - 1];
            self.tbdThuoc14.fiSort(endItem.fiSort() + 1);
        } else {
            self.tbdThuoc14.fiSort(1);
        }
        self.tbdThuoc14.fiIdHoSo(idHoSo);
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

            var data = convertKnockoutToObject(self.tbdThuoc14, createObject(self.tbdThuoc14));
            var callURL = '/mard/14/tbdThuoc14/update/' + self.tbdThuoc14.fiId();
            if (self.tbdThuoc14.fiId() == 0) {
                callURL = '/mard/14/tbdThuoc14/create';
            }
            app.makePost({
                url: callURL,
                data: JSON.stringify(data),
                error: function (e) {
                    if (e.readyState != 4) {

                        if (self.tbdThuoc14.fiId() == 0 || self.tbdThuoc14.fiId() == null) {
                            parent.thuocs.push(convertObjectToKnockout(e, new TbdThuoc14()));
                            clearDataKnockout(self.tbdThuoc14);
                            $('#fiNameOfGoods').focus();
                            self.tbdThuoc14.fiTypeGood('-1');
                            self.tbdThuoc14.fiWeightUnitCode('-1');
                            self.tbdThuoc14.fiId(0);
                            self.tbdThuoc14.valid.errors.showAllMessages(false);
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
                        showToast(NSWLang["mard.14.action.success"], true);
                        self.close();
                    }

                }
            });
        } else {
            if (self.tbdThuoc14.enable()) {
                self.tbdThuoc14.fiId(new Date().getTime());
                var cp = cloneKnockoutObject(self.tbdThuoc14, new TbdThuoc14());
                cp.enable(false);
                parent.thuocs.push(cp);
            } else {
                var id = self.tbdThuoc14.fiId();
                readKnockoutArrays(parent.thuocs, function (loopItem) {
                    if (loopItem.fiId() == id) {
                        cloneKnockoutObject(self.tbdThuoc14, loopItem);
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
            item["fiTypeGood"].rules.remove(function (item) {
                return item.rule == "notEqual";
            });
            item["fiTypeGood"].extend({
                notEqual: '-1'
            });
            item["fiWeightUnitCode"].rules.remove(function (item) {
                return item.rule == "notEqual";
            });
            item["fiWeightUnitCode"].extend({
                notEqual: '-1'
            });
        } else {
            item["fiTypeGood"].rules.remove(function (item) {
                return item.rule == "notEqual";
            });
            item["fiWeightUnitCode"].rules.remove(function (item) {
                return item.rule == "notEqual";
            });
        }
    }


}