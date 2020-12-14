function BoSungToKhaiView() {
    var self = this;
    self.show = function(item, success) {
        var callback = function (html) {
            var pop = app.popup({
                title:  '<b style="text-transform: uppercase">' + NSWLang["mard.18.index.table.th.15"] + " - " + item.fiDocumentName() + '</b>',
                html: html,
                width: 960,
                buttons: [
                    {
                        name: NSWLang["common_button_gui"],
                        class: 'btn',
                        icon: 'fa fa-paper-plane',
                        action: function () {

                            var isOk = app.isFormVaild('form-bo-sung-to-khai-popup');

                            if (!isOk)
                                return;

                            var data = app.form2Object('#form-bo-sung-to-khai-popup');
                            app.makePost({
                                url: '/mard/api/18/saveSoToKhaiAndSoVanDonAndSend/' + item.fiIdHoSo(),
                                data: JSON.stringify({
                                    fiDeclarationNo: data.declarationNo,
                                    fiBillNo: data.billNo
                                }),
                                success: function (d) {
                                    app.popupRemove(pop.selector);
                                    self.thongBao(NSWLang["mard.18.action.success"] , true)
                                    success();
                                },
                                error: function (e) {
                                    self.thongBao(NSWLang["mard.18.action.error"], false)
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
            code: "18",
            templateName: "bo_sung_to_khai",
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
