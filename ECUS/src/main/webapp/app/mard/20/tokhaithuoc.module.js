function ChiTietToKhaiThuoc(parent, dataItem, end) {
    var self = this;
    self.tbdThuoc20 = dataItem;

    self.moduleParent = parent;

    //addRule(self.tbdThuoc20, false);

    self.save = function () {
        //addRule(self.tbdThuoc20, true);
       if (self.tbdThuoc20.valid.errors().length > 0) {

            showError(self.tbdThuoc20.valid());
            self.tbdThuoc20.valid.errors.showAllMessages();
           return;
        }
        readKnockoutArrays(self.moduleParent.fiWeightUnits, function (loopItem) {
            if (loopItem.fiUnitCode == self.tbdThuoc20.fiWeightUnitCode()) self.tbdThuoc20.fiWeightUnitName(loopItem.fiUnitName);
        });
        readKnockoutArrays(self.moduleParent.countries, function (loopItem) {
            if (loopItem.fiCountryCode == self.tbdThuoc20.fiCountryCode()) {
                self.tbdThuoc20.fiCountryName(loopItem.fiCountryName);
            }
        });

        if (self.tbdThuoc20.fiSort() == 0 && parent.thuocs().length > 0) {
            var endItem = parent.thuocs()[parent.thuocs().length - 1];
            self.tbdThuoc20.fiSort(endItem.fiSort() + 1);

        } else {
            self.tbdThuoc20.fiSort(1);
        }
        self.tbdThuoc20.fiIdHoSo(idHoSo);
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

            var data = convertKnockoutToObject(self.tbdThuoc20, createObject(self.tbdThuoc20));
            var callURL = '/mard/20/tbdThuoc20/update/' + self.tbdThuoc20.fiId();
            if (self.tbdThuoc20.fiId() == 0) {
                callURL = '/mard/20/tbdThuoc20/create';
            }
            app.makePost({
                url: callURL,
                data: JSON.stringify(data),
                error: function (e) {
                    if (e.readyState != 4) {

                        if (self.tbdThuoc20.fiId() == 0 || self.tbdThuoc20.fiId() == '' ||  self.tbdThuoc20.fiId() == null) {
                            parent.thuocs.push(convertObjectToKnockout(e, new TbdThuoc20()));
                            clearDataKnockout(self.tbdThuoc20);
                            $('#fiNameOfProduct').focus();
                           // self.tbdThuoc20.fiProductType('-1');
                           // self.tbdThuoc20.fiWeightUnitCode('-1');
                           // self.tbdThuoc20.fiId(0);
                           // self.tbdThuoc20.fiCountryCode('-1');
                            self.tbdThuoc20.valid.errors.showAllMessages(false);
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
                        showToast(NSWLang["mard.20.action.success"], true);
                        self.close();
                    }

                }
            });
        } else {
            if (self.tbdThuoc20.enable()) {
                self.tbdThuoc20.fiId(new Date().getTime());
                var cp = cloneKnockoutObject(self.tbdThuoc20, new TbdThuoc20());
                cp.enable(false);
                parent.thuocs.push(cp);
            } else {
                var id = self.tbdThuoc20.fiId();
                readKnockoutArrays(parent.thuocs, function (loopItem) {
                    if (loopItem.fiId() == id) {
                        cloneKnockoutObject(self.tbdThuoc20, loopItem);
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
            item["fiImportTimeFrom"].rules.remove(function (item){
                return item.rule == "dateVI"
            });
            item["fiImportTimeFrom"].extend( {
                dateVI: true
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
