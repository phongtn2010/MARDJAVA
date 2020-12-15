
function ChiTietToKhaiThuoc(parent, dataItem, end) {
    var self = this;
    //self.testVM = ko.observableArray(['']);
    self.tbdThuoc18 = dataItem;
    self.moduleParent = parent;
    self.testVM = parent.giayphepTT20;
    
    addRule(self.tbdThuoc18, false);

    self.save = function () {
        addRule(self.tbdThuoc18, true);
       if (self.tbdThuoc18.valid.errors().length > 0) {
            console.log("errors: " + ko.toJSON(self.tbdThuoc18.valid.errors));
            showError(self.tbdThuoc18.valid());
            self.tbdThuoc18.valid.errors.showAllMessages();
           return;
        }
        readKnockoutArrays(self.moduleParent.fiWeightUnits, function (loopItem) {
            if (loopItem.fiUnitCode == self.tbdThuoc18.fiWeightUnitCode()) self.tbdThuoc18.fiWeightUnitName(loopItem.fiUnitName);
        });
        readKnockoutArrays(self.moduleParent.countries, function (loopItem) {
            if (loopItem.fiCountryCode == self.tbdThuoc18.fiCountryCode()) {
                self.tbdThuoc18.fiCountryName(loopItem.fiCountryName);
            }
        });
        var selectedValue = $('#fiLicenseFileNo').val();
        console.log("selectedValue tokhaithuoc: " + selectedValue);
       // self.tbdThuoc18.fiLicenseFileNo(selectedValue);

        if (self.tbdThuoc18.fiSort() == 0 && parent.thuocs().length > 0) {
            var endItem = parent.thuocs()[parent.thuocs().length - 1];
            self.tbdThuoc18.fiSort(endItem.fiSort() + 1);

        } else {
            self.tbdThuoc18.fiSort(1);
        }
        self.tbdThuoc18.fiIdHoSo(idHoSo);
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
            var data = convertKnockoutToObject(self.tbdThuoc18, createObject(self.tbdThuoc18));

            var callURL = '/mard/18/tbdThuoc18/update/' + self.tbdThuoc18.fiId();
            if (self.tbdThuoc18.fiId() == 0) {
                callURL = '/mard/18/tbdThuoc18/create';
            }
            app.makePost({
                url: callURL,
                data: JSON.stringify(data),
                error: function (e) {
                    if (e.readyState != 4) {

                        if (self.tbdThuoc18.fiId() == 0 || self.tbdThuoc18.fiId() == '' ||  self.tbdThuoc18.fiId() == null) {
                            parent.thuocs.push(convertObjectToKnockout(e, new TbdThuoc18()));
                            clearDataKnockout(self.tbdThuoc18);
                            $('#fiNameOfProduct').focus();
                            self.tbdThuoc18.fiProductType('-1');
                            self.tbdThuoc18.fiWeightUnitCode('-1');
                            self.tbdThuoc18.fiId(0);
                            self.tbdThuoc18.fiCountryCode('-1');
                            self.tbdThuoc18.valid.errors.showAllMessages(false);
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
                        showToast(NSWLang["mard.18.action.success"], true);
                        self.close();
                    }

                }
            });
        } else {
            if (self.tbdThuoc18.enable()) {
                self.tbdThuoc18.fiId(new Date().getTime());
                var cp = cloneKnockoutObject(self.tbdThuoc18, new TbdThuoc18());
                cp.enable(false);
                parent.thuocs.push(cp);
            } else {
                var id = self.tbdThuoc18.fiId();
                readKnockoutArrays(parent.thuocs, function (loopItem) {
                    if (loopItem.fiId() == id) {
                        cloneKnockoutObject(self.tbdThuoc18, loopItem);
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
            })
            item["fiProductType"].rules.remove(function (item) {
                return item.rule == "notEqual";
            });
            item["fiProductType"].extend({
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

//    ////--------------------------------------------------------------------------//
//    $.getJSON(app.appContext + '/mard/18/tbdGiayPhep18/findSoCongVanByMaThuTuc/' + taxCode, function (d) {
//        ko.utils.arrayPushAll(self.testVM, d);
//    });
    
    console.log("init  self.SelectedValue")
    self.SelectedValueOption =  ko.observable();
    self.SelectedValue = ko.observable();

    var isUpdatingValue;
    function updateSelectedValue(v) {
    	if (v !== '')
	        window.setTimeout(function () {
	            //self.SelectedValue(v);
	            self.tbdThuoc18.fiLicenseFileNo(v);
	        }, 0);
    }
    self.SelectedValueOption.subscribe(function (v) {
        updateSelectedValue(v);
    });

}