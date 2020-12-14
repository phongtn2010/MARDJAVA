function ThongBaoPhiView() {
    var self = this;
    // ket qua xu ly

    self.show = function(item) {
        $.getJSON(app.appContext + '/mard/14/tbdThongBaoPhi14/findByFiIdHoSo?fiIdHoSo='+item.fiIdHoSo(), function (d) {
            var tbdThongBaoPhi14 = d;
            $.getJSON(app.appContext + '/mard/14/tbdThanhToan14/findByFiIdHoSo?fiIdHoSo='+item.fiIdHoSo(), function (d) {
                var tbdThanhToan14 = d;
                var callback = function (html) {
                    var pop = app.popup({
                        title: NSWLang["mard.15.index.table.xinSuaGiayPhep"] + ' - ' + item.fiDocumentName(),
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
                    });
                };

                app.complieTemplate({
                    ministryCode: "mard",
                    code: "14",
                    templateName: "thong_bao_thu_phi",
                    data: {tbdThongBaoPhi14: tbdThongBaoPhi14, tbdThanhToan14: tbdThanhToan14}
                }, callback);
            });

        })
    }
}