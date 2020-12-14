function HuyHoSoView() {
    var self = this;
    self.show = function(item, success) {
        if (item.fiStatus() == 1 || item.fiStatus() == 5 || item.fiStatus() == 6) {
            var pop = app.popup({
                title: NSWLang["common_msg_thong_bao"],
                html: '<i class="fa fa-3x fa-warning"></i> ' + NSWLang["mard.19.index.table.th.12"] + ' <b>'+ item.fiDocumentName() +'</b>',
                width: 400,
                buttons: [
                    {
                        name: NSWLang["common_button_toi_chac_chan"],
                        class: 'btn',
                        icon: 'fa-check',
                        action: function () {
                            self.send(pop, item, null, success);
                        }
                    }
                ]
            });
            return;
        }
        var callback = function (html) {
            var pop = app.popup({
                title:  '<b style="text-transform: uppercase">' + NSWLang["mard.19.index.table.th.12"] + " - " + item.fiDocumentName() + '</b>',
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
                            self.send(pop, item, data.reason, success);
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
            ministryCode: "mard",
            code: "19",
            templateName: "xin_rut_ho_so",
            data: []
        }, callback);
    }

    self.send = function(pop, item, reason, success) {
        app.makePost({
            url: '/mard/api/19/send',
            data: JSON.stringify({
                fiReason: reason,
                fiXml: null,
                fiIdHoSo: item.fiIdHoSo(),
                fiAction: 3
            }),
            success: function (d) {

                app.popupRemove(pop.selector);
                self.thongBao(NSWLang["mard.19.action.success"] , true)
                success();

            },
            error: function (e) {
                self.thongBao(NSWLang["mard.19.action.error"], false)
                success();
            }
        });
    }
    self.thongBao = function( message, success) {
        var cls = 'class="alert alert-success toast-success" style="color: #fff;"';
        var icon = 'fa fa-check';
        if (!success) {
            cls = 'class="alert alert-danger" style="color: #000;background: red;"';
            icon = 'fa fa-send-o';
        }
        var pop = app.popup({
            title: NSWLang["common_msg_thong_bao"],
            html: '<div '+ cls +' ><i class="'+ icon +'" aria-hidden="true"></i> ' + NSWLang["common_msg_thong_bao"] + ' <b>'+ message +'</b></div>',
            width: 400,
            buttons: [
                {
                    name: NSWLang["common_button_dong"],
                    class: 'btn',
                    icon: 'fa-remove',
                    action: function () {
                        app.popupRemove(pop.selector);
                        if (success) {
                            location.reload();
                        }
                    }
                }
            ]
        }, function(){
            $('button[class="close"]').click(function(){
                app.popupRemove(pop.selector);
                if (success) {
                    location.reload();
                }
            });
        });
    }

}
