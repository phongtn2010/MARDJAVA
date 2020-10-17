function ChiTietToKhaiThietBi(parent, dataItem, end) {
    var self = this;
    // console.log(dataItem);
    self.tbdNguoiThamDinh04  = new TbdNguoiThamDinh04();
    self.tbdNguoiThamDinh04.fiIdHoSo(idHoSo);
    $('.date-picker').datepicker({rtl: false, orientation: "left", autoclose: true});

    if (dataItem) {
        convertObjectToKnockout(dataItem, self.tbdNguoiThamDinh04);
        self.tbdNguoiThamDinh04.fiNgaySinh(moment(self.tbdNguoiThamDinh04.fiNgaySinh()).format('DD/MM/YYYY'));
    }
    self.save = function () {
        if (self.tbdNguoiThamDinh04.valid.errors().length > 0) {
            showError(self.tbdNguoiThamDinh04.valid(), "TbdNguoiThamDinh04_");
            self.tbdNguoiThamDinh04.valid.errors.showAllMessages();
            return;
        }
        self.tbdNguoiThamDinh04.fiIdHoSo(idHoSo);
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

        self.tbdNguoiThamDinh04.fiNgaySinh(moment(self.tbdNguoiThamDinh04.fiNgaySinh(), 'DD/MM/YYYY').toDate());
        var data = convertKnockoutToObject(self.tbdNguoiThamDinh04, createObject(self.tbdNguoiThamDinh04));

        //
        if (isDevTest) {
            console.log(data);
        }
        if (idHoSo > 0) {
            var callURL = '/mic/04/tbdNguoiThamDinh04/update/' + self.tbdNguoiThamDinh04.fiId();
            if (!self.tbdNguoiThamDinh04.fiId()) {
                callURL = '/mic/04/tbdNguoiThamDinh04/create';
            }
            callApi(callURL, data, function (d) {
                self.push(d.data, callURL.endsWith('create') ? true : false);
            })
        } else {
            if (!self.tbdNguoiThamDinh04.fiId()) {
                data.fiId = new Date().getTime();
            }
            self.push(data, !self.tbdNguoiThamDinh04.fiId() ? true : false);
        }
        self.close();
    }

    self.push = function(data, isAddNew) {
        if (isAddNew) {
            parent.fullDataTable.push(convertObjectToKnockout(data, new TbdNguoiThamDinh04()));
            parent.loadTbdNguoiThamDinh04();
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
