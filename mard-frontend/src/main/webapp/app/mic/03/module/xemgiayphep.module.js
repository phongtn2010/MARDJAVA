function GiayPhepViewModel() {
    var self = this;
    // ket qua xu ly

    self.show = function (item) {
        callApi('/mic/api/03/edit/' + item.fiIdHoSo(), null, function (d) {
            var callback = function (html) {
                var pop = app.popup({
                    title: '',
                    html: html,
                    width: 1200,
                    buttons: [
                        {
                            name: NSWLang["common_button_dong"],
                            class: 'btn',
                            icon: 'fa-remove',
                            action: function () {
                                app.popupRemove(pop.selector);
                            }
                        }
                    ]
                }, function () {
                    var p = new GiayPhepPopupViewModel(d.data);
                    ko.applyBindings(p, document.getElementById("popupView"));
                });
            };

            app.complieTemplate({
                ministryCode: complieTemplateMinistryCode,
                code: complieTemplateCode,
                templateName: "xemgiayphep",
                data: d
            }, callback);
        })
    }
    
    self.xinSuaGayPhep = function (item) {
        NSWLang['lyDo'] = i18nextko.t('lyDo')();
        var callback = function (html) {
            var pop = app.popup({
                title:  '<b style="text-transform: uppercase">' + i18nextko.t('xinSuaGP')() + " - " + item.fiDocumentName() + '</b>',
                html: html,
                width: 960,
                buttons: [
                    {
                        name: NSWLang["common_button_gui"],
                        class: 'btn',
                        icon: 'fa fa-paper-plane',
                        action: function () {

                            var isOk = app.isFormVaild('form-sin-rut-ho-so-popup');

                            if (!isOk)
                                return;

                            var data = app.form2Object('#form-sin-rut-ho-so-popup');
                            var post = {
                                fiReason: data.reason,
                                fiXml: null,
                                fiIdHoSo: item.fiIdHoSo(),
                                fiAction: 3
                            };
                            var v = new SendHoSoView();
                            v.send('/send', post, true, function () {
                                setTimeout(function () {
                                    location.reload();
                                }, 1000)
                            });
                        }
                    },
                    {
                        name: NSWLang["common_button_dong"],
                        class: 'btn',
                        icon: 'fa-remove',
                        action: function () {
                            app.popupRemove(pop.selector);
                        }
                    }
                ]
            });
        };

        app.complieTemplate({
            ministryCode: complieTemplateMinistryCode,
            code: complieTemplateCode,
            templateName: "xin_sua_giay_phep",
            data: []
        }, callback);
    }
}

function GiayPhepPopupViewModel(d) {
    var self = this;
    if (d.hoSo.tbdGiayPhep03DTOS != null && d.hoSo.tbdGiayPhep03DTOS.length > 0) {
        d.hoSo.tbdGiayPhep03DTOS[0].fiNgayCapGP = moment(d.hoSo.tbdGiayPhep03DTOS[0].fiNgayCapGP).format('DD/MM/YYYY');
        d.hoSo.tbdGiayPhep03DTOS[0].fiNgayDeNghi = moment(d.hoSo.tbdGiayPhep03DTOS[0].fiNgayDeNghi).format('DD/MM/YYYY');
    }

    self.formData = d;

    self.tongSoBan = function (arr) {
        var sum = 0;
        arr.forEach(function (value) {
            sum += value.fiSoBan;
        });
        return sum;
    }

    self.titles = ko.observableArray([]);
    self.dataTable = ko.observableArray([]);
    self.totalElements = ko.observable(0);
    self.currentPage = ko.observable(1);
    self.pageSize = ko.observable(10);

    self.titles.push({key: '', value: i18nextko.t('TbdThietBi03.fiId')});
    self.titles.push({key: 'fiMaISBN', value: i18nextko.t('TbdThietBi03.fiMaISBN')});
    self.titles.push({key: 'fiTenGoc', value: i18nextko.t('TbdThietBi03.fiTenGoc')});
    self.titles.push({key: 'fiTenTiengViet', value: i18nextko.t('TbdThietBi03.fiTenTiengViet')});
    self.titles.push({key: 'fiTenTacGia', value: i18nextko.t('TbdThietBi03.fiTenTacGia')});
    self.titles.push({key: 'fiTenNhaCC', value: i18nextko.t('TbdThietBi03.fiTenNhaCC')});
    self.titles.push({key: 'fiTheLoai', value: i18nextko.t('TbdThietBi03.fiTheLoai')});
    self.titles.push({key: 'fiSoBan', value: i18nextko.t('TbdThietBi03.fiSoBan'), align: 'right'});
    self.titles.push({key: 'fiTomTat', value: i18nextko.t('TbdThietBi03.fiTomTat')});
    self.titles.push({key: 'fiSoLuongDia', value: i18nextko.t('TbdThietBi03.fiSoLuongDia'), align: 'right'});
    self.titles.push({key: 'fiSoLuongBang', value: i18nextko.t('TbdThietBi03.fiSoLuongBang') , align: 'right'});
    self.titles.push({key: 'fiSoLuongCatset', value: i18nextko.t('TbdThietBi03.fiSoLuongCatset'), align: 'right'});

    self.pageClick = function (page) {

    }

    self.loadTbdThietBi03 = function() {
        self.totalElements(0);
        self.dataTable.removeAll();

        if (d.hoSo.tbdGiayPhep03DTOS[0].tbdGPThietBi03DTOS) {
            d.hoSo.tbdGiayPhep03DTOS[0].tbdGPThietBi03DTOS.forEach(function (value, index) {
                if (index < 10)
                    self.dataTable.push(value);
            });
            self.totalElements(d.hoSo.tbdGiayPhep03DTOS[0].tbdGPThietBi03DTOS.length);
        }

    }
    self.loadTbdThietBi03();
}
