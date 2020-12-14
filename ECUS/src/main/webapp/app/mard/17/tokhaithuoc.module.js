function ChiTietToKhaiThuoc(parent, dataItem, end) {
    var self = this;
    self.tbdThuoc17 = dataItem;

    self.moduleParent = parent;

    addRule(self.tbdThuoc17, false);

    self.save = function () {

        addRule(self.tbdThuoc17, true);
       if (self.tbdThuoc17.valid.errors().length > 0) {
            console.log("errors: " + ko.toJSON(self.tbdThuoc17.valid.errors));
            showError(self.tbdThuoc17.valid());
            self.tbdThuoc17.valid.errors.showAllMessages();
           return;
        }


        readKnockoutArrays(self.moduleParent.fiWeightUnits, function (loopItem) {
            if (loopItem.fiUnitCode == self.tbdThuoc17.fiWeightUnitCode()) self.tbdThuoc17.fiWeightUnitName(loopItem.fiUnitName);
        });
      /* readKnockoutArrays(self.moduleParent.fiMoneyUnits, function (loopItem){
           if (loopItem.fiMoneyUnitCode == self.tbdThuoc17.fiMoneyUnitCode()) self.tbdThuoc17.fiMoneyUnitName(loopItem.fiMoneyUnitName);
        });*/
        readKnockoutArrays(self.moduleParent.countries, function (loopItem) {
            if (loopItem.fiCountryCode == self.tbdThuoc17.fiCountryCode()) {
                self.tbdThuoc17.fiCountryName(loopItem.fiCountryName);
            }
        });

        if (self.tbdThuoc17.fiSort() == 0 && parent.thuocs().length > 0) {
            var endItem = parent.thuocs()[parent.thuocs().length - 1];
            self.tbdThuoc17.fiSort(endItem.fiSort() + 1);

        } else {
            self.tbdThuoc17.fiSort(1);
        }
        self.tbdThuoc17.fiIdHoSo(idHoSo);
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

            var data = convertKnockoutToObject(self.tbdThuoc17, createObject(self.tbdThuoc17));
            var callURL = '/mard/17/tbdThuoc17/update/' + self.tbdThuoc17.fiId();
            if (self.tbdThuoc17.fiId() == 0) {
                callURL = '/mard/17/tbdThuoc17/create';
            }
            app.makePost({
                url: callURL,
                data: JSON.stringify(data),
                error: function (e) {
                    if (e.readyState != 4) {
                        if (self.tbdThuoc17.fiId() == 0 || self.tbdThuoc17.fiId() == '' ||  self.tbdThuoc17.fiId() == null) {
                            parent.thuocs.push(convertObjectToKnockout(e, new TbdThuoc17()));
                            clearDataKnockout(self.tbdThuoc17);
                            $('#fiNameOfProduct').focus();
                            self.tbdThuoc17.fiProductType('-1');
                            self.tbdThuoc17.fiWeightUnitCode('-1');
                            self.tbdThuoc17.fiMoneyUnitCode('-1');
                            self.tbdThuoc17.fiId(0);
                            self.tbdThuoc17.fiCountryCode('-1');
                            self.tbdThuoc17.valid.errors.showAllMessages(false);
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
                        showToast(NSWLang["mard.17.action.success"], true);
                        self.close();
                    }

                }
            });
        } else {
            if (self.tbdThuoc17.enable()) {
                self.tbdThuoc17.fiId(new Date().getTime());
                var cp = cloneKnockoutObject(self.tbdThuoc17, new TbdThuoc17());
                cp.enable(false);
                parent.thuocs.push(cp);
            } else {
                var id = self.tbdThuoc17.fiId();
                readKnockoutArrays(parent.thuocs, function (loopItem) {
                    if (loopItem.fiId() == id) {
                        cloneKnockoutObject(self.tbdThuoc17, loopItem);
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
            item["fiProductType"].rules.remove(function (item) {
                return item.rule == "notEqual";
            });
            item["fiProductType"].extend({
                notEqual: '-1'
            });
            item["fiMoneyUnitCode"].rules.remove(function (item) {
                return item.rule == "notEqual";
            });
            item["fiMoneyUnitCode"].extend({
                notEqual: '-1'
            });

            item["fiWeightUnitCode"].rules.remove(function (item) {
                return item.rule == "notEqual";
            });
            item["fiCountryCode"].rules.remove(function (item) {
                return item.rule == "notEqual";
            });
            item["fiWeightUnitCode"].extend({
                notEqual: '-1'
            });
            item["fiCountryCode"].extend({
                notEqual: '-1'
            });
        }
         else {
            item["fiProductType"].rules.remove(function (item) {
                return item.rule == "notEqual";
            });
            item["fiWeightUnitCode"].rules.remove(function (item) {
                return item.rule == "notEqual";
            });
            item["fiCountryCode"].rules.remove(function (item) {
                return item.rule == "notEqual";
            });
        }
    }


}
