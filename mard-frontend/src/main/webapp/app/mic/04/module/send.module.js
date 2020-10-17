function SendHoSoView() {
    var self = this;
    self.send = function (pathURL, data, showPopup, success) {
        callBack(function () {
            callApi(pathAPI + pathURL, data, function (reponseData) {
                if (success)
                    success();
                self.thongBao();
            }, true);
        }, showPopup);
    }

    self.thongBao = function (message) {
        var cls = 'class="alert alert-success toast-success" style="color: #fff;"';
        var icon = 'fa fa-check';

        var pop = app.popup({
            title: NSWLang["common_msg_thong_bao"],
            html: '<div ' + cls + ' ><i class="' + icon + '" aria-hidden="true"></i> ' + NSWLang["common_msg_thong_bao"] + ' <b>' + i18nextko.t('msgOK')() + '</b></div>',
            width: 400,
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
        });

    }

}