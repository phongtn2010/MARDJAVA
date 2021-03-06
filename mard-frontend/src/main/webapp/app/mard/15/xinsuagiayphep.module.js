function XinSuaGiayPhepViewModel() {
    var self = this;
    self.show = function(item, success) {
        var callback = function (html) {
            var pop = app.popup({
                title: NSWLang["mard.15.index.table.xinSuaGiayPhep"] + " - " + item.fiDocumentName(),
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
                            app.makePost({
                                url: '/mard/api/15/send',
                                data: JSON.stringify({
                                    fiReason: data.reason,
                                    fiXml: null,
                                    fiIdHoSo: item.fiIdHoSo(),
                                    fiAction: 4
                                }),
                                success: function (d) {

                                    app.popupRemove(pop.selector);
                                    self.thongBao(NSWLang["mard.15.action.success"] , true)
                                    success();
                                },
                                error: function (e) {
                                    self.thongBao(NSWLang["mard.15.action.error"], false)
                                    success();
                                }
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
            ministryCode: "mard",
            code: "15",
            templateName: "xin_sua_giay_phep",
            data: []
        }, callback);
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
                        setTimeout(function () {
                            location.reload();
                        }, 1000);
                    }
                }
            ]
        }, function(){
            $('button[class="close"]').click(function(){
                app.popupRemove(pop.selector);
                setTimeout(function () {
                    location.reload();
                }, 1000);
            });
        });
    }
}