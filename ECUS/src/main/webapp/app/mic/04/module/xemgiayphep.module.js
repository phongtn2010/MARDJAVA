function GiayPhepViewModel() {
    var self = this;
    // ket qua xu ly

    self.show = function (item) {
        callApi('/mic/api/04/edit/' + item.fiIdHoSo(), null, function (d) {
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
    d.hoSo.tbdGiayPhep04DTOS[0].fiNgayCapGP = moment(d.hoSo.tbdGiayPhep04DTOS[0].fiNgayCapGP).format('DD/MM/YYYY');
    d.hoSo.tbdGiayPhep04DTOS[0].fiNgayDeNghi = moment(d.hoSo.tbdGiayPhep04DTOS[0].fiNgayDeNghi).format('DD/MM/YYYY');
    if (d.hoSo.tbdGiayPhep04DTOS[0].fiLinkGP) {
        d.hoSo.tbdGiayPhep04DTOS[0].fiLinkGP = urlDownload + d.hoSo.tbdGiayPhep04DTOS[0].fiLinkGP
    }
    self.formData = d;

    self.tongSoBan = function (arr) {
        var sum = 0;
        arr.forEach(function (value) {
            sum += value.fiSoBan;
        });
        return sum;
    }
}