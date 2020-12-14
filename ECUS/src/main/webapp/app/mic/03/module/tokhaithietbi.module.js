function ChiTietToKhaiThietBi(parent, dataItem, end) {
    var self = this;
    // console.log(dataItem);
    self.tbdThietBi03  = new TbdThietBi03();
    self.tbdThietBi03.fiIdHoSo(idHoSo);
    if (dataItem) {
        convertObjectToKnockout(dataItem, self.tbdThietBi03);
    }
    self.save = function () {
        if (self.tbdThietBi03.valid.errors().length > 0) {
            showError(self.tbdThietBi03.valid(), "TbdThietBi03_");
            self.tbdThietBi03.valid.errors.showAllMessages();
            return;
        }
        self.tbdThietBi03.fiIdHoSo(idHoSo);
        self.callConfirm();
    }

    self.callConfirm = function() {
        var pop = app.popup({
            title: NSWLang["common_msg_thong_bao"],
            html: '<i class="fa fa-3x fa-warning"></i> ' + i18nextko.t('saveConfirm')(),
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

        var data = convertKnockoutToObject(self.tbdThietBi03, createObject(self.tbdThietBi03));
        if (isDevTest) {
            console.log(data);
        }

        var callURL = '/mic/03/tbdThietBi03/update/' + self.tbdThietBi03.fiId();
        if (!self.tbdThietBi03.fiId()) {
            callURL = '/mic/03/tbdThietBi03/create';
        }
        if (idHoSo > 0) {
            callApi(callURL, data, function (d) {
                self.push(d.data, callURL.endsWith('create') ? true : false);
            })
        } else {
            if (!self.tbdThietBi03.fiId()) {
                data.fiId = new Date().getTime();
            }
            self.push(data, callURL.endsWith('create') ? true : false);

        }

        var sum = 0;
        parent.fullDataTable().forEach(function (item) {
            sum += parseFloat(item.fiSoLuongBang());
            sum += parseFloat(item.fiSoLuongCatset());
            sum += parseFloat(item.fiSoLuongDia());
        });
       // parent.tbdHoSo03.fiTongSoBangDia(sum);
        parent.addName(self.tbdThietBi03.fiTenNhaCC());
        self.close();
    }

    self.push = function(data, isAddNew) {
        if (isAddNew) {
            parent.fullDataTable.push(convertObjectToKnockout(data, new TbdThietBi03()));
            parent.loadTbdThietBi03();
        } else {
            parent.dataTable().forEach(function (value) {
                if (value.fiId() === data.fiId) {
                    convertObjectToKnockout(data, value);
                }
            })
        }
    }

    self.close = function () {
        app.popupRemove(parent.pop.selector);
    }


}