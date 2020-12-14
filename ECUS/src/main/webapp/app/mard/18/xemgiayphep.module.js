function PopupViewGP() {
    var self = this;
    // ket qua xu ly

    self.show = function(item) {
        var url ='/mard/api/18/findGP/'+ item.fiIdHoSo();

        app.makePost({
            url: url,
            data: JSON.stringify({}),
            error: function (d) {

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
                        var popupViewHoSo = new PopupViewHoSo(d);
                        ko.applyBindings(popupViewHoSo, document.getElementById("form"));
                    });
                };

                app.complieTemplate({
                    ministryCode: "mard",
                    code: "18",
                    templateName: "xemgiayphep",
                    data: d

                }, callback);
               

            }
        });

    }
}

function PopupViewHoSo(d) {
    var self = this;
    self.formData = d;
    self.cuaNhapKhau = ko.observable("");
    self.thoiGianNhapKhau = ko.observable("");
    var idHoSo = d.hoSo.fiIdHoSo;
    var urlForThuocs = '/mard/18/tbdThuoc18/findByFiIdHoSo?fiIdHoSo=' + idHoSo;
    $.ajax({
        url: app.appContext +urlForThuocs,
        async: false,
        data: null,
        success: function (dThuocs) {
            self.cuaNhapKhau = dThuocs[0].fiGate;
            self.thoiGianNhapKhau = dThuocs[0].fiImportTimeFrom + " - " + dThuocs[0].fiImportTimeTo;
        },
        error: function (e) {

        }
    });

    self.downloadFileUrl = app.appContext  + "/mard/api/18/xuatGiayPhep/" + idHoSo;

}
