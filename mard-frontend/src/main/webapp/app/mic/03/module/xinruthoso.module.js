function HuyHoSoView() {
    var self = this;
    self.show = function(item, success) {

        if (item.fiStatus() == 1  || item.fiStatus() == 2 || item.fiStatus() == 4 || item.fiStatus() == 5) {
            self.send(item, null, success);
            return;
        }


        NSWLang['lyDo'] = i18nextko.t('lyDo')();
        var callback = function (html) {
            var pop = app.popup({
                title:  '<b style="text-transform: uppercase">' + i18nextko.t('xinRutHS')() + " - " + item.fiDocumentName() + '</b>',
                html: html,
                width: 960,
                backdrop: true,
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
                            self.send(item, data.reason);

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
            templateName: "xin_rut_ho_so",
            data: []
        }, callback);
    }

    self.send = function(item, reason) {

        var post = {
            fiReason: reason,
            fiXml: null,
            fiIdHoSo: item.fiIdHoSo(),
            fiAction: 2
        };
        var v = new SendHoSoView();
        v.send('/send', post, true, function () {
            setTimeout(function () {
                location.reload();
            }, 1000)
        });
    }

}