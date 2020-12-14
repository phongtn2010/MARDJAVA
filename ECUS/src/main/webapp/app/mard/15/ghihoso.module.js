$(document).ready(function () {
    $(".select2").select2({placeholder: '', width: '100%'});
    $('.tooltips').tooltip();
    $('.date-picker').datepicker({rtl: false, orientation: "left", autoclose: true});
    $(".date-picker").datepicker({
        altFormat: "dd/mm/yy"
    });

    function GhiHoSoViewModel() {

        var self = this;
        self.moduelThongTinChung = null;
        self.moduleThongTinThuoc = null;
        self.moduleTepDinhKem = null;
        self.moduleThongTinKyViewModel = null;

        self.xemHoSo = ko.observable(false);
        self.formData = null;
        self.idHoSo = idHoSo;
        self.getHoSo = function (idHoSo) {
            app.makePost({
                url: '/mard/api/15/edit/' + self.idHoSo,
                data: JSON.stringify({}),
                error: function (e) {
                    $('#fiApplicationNo').focus();
                    self.formData = e;

                    self.moduelThongTinChung = new ThongTinChungViewModel(self);
                    ko.applyBindings(self.moduelThongTinChung, document.getElementById("ThongTinChungViewModel"));

                    self.moduleThongTinThuoc = new ChiTietThuocViewModel(self, self.moduelThongTinChung);
                    ko.applyBindings(self.moduleThongTinThuoc, document.getElementById("ChiTietThuocViewModel"));

                    self.moduleTepDinhKem = new ThongTinTepDinhKemViewModel(self);
                    ko.applyBindings(self.moduleTepDinhKem, document.getElementById("ThongTinTepDinhKemViewModel"));

                    self.moduleThongTinKyViewModel = new ThongTinKyViewModel(self, self.moduelThongTinChung);
                    ko.applyBindings(self.moduleThongTinKyViewModel, document.getElementById("ThongTinKyViewModel"));
                }
            });
        }


        self.getHoSo();

        self.validForm = function (isGuiHoSo, action) {
            //valid thong tin thuoc
            if (!self.moduleThongTinThuoc.isValid(isGuiHoSo)) {
                return false;
            }
            if (!self.moduleTepDinhKem.isValid(isGuiHoSo)) {
                return false;
            }

            action();
        }

        self.ghiLai = function () {
            self.validForm(false, function () {
                self.save(false);
            });

        }
        self.guiHoSo = function () {
            self.validForm(true, function () {
                self.save(true);
            });

        }
        self.save = function (isGuiHoSo) {
            var postData = {};
            postData.hoSo = self.moduelThongTinChung.convertData();
            postData.tepDinhKems = self.moduleTepDinhKem.convertData();
            postData.thuocs = self.moduleThongTinThuoc.convertData();
            postData.action = action;

            app.makePost({
                url: '/mard/api/15/save/' + self.idHoSo,
                data: ko.toJSON(postData),
                error: function (e) {
                    if (e.readyState == 4) {
                        if (idHoSo == 0) {
                            showToast(NSWLang["mard.15.msg.taoMoiHoSoNo"], false);
                        } else {
                            showToast(NSWLang["mard.15.msg.capNhatHoSoNo"], false);
                        }
                        return;
                    } else {
                        if (idHoSo == 0) {
                            showToast(NSWLang["mard.15.msg.taoMoiHoSoOk"], true);

                        } else {
                            showToast(NSWLang["mard.15.msg.capNhatHoSoOk"], true);
                        }
                    }
                    if (isGuiHoSo) {
                        if (idHoSo === 0) {
                            idHoSo = e.hoSo.fiIdHoSo;
                        }
                        var sendHoSoView = new SendHoSoView();
                        var item = new TbdHoSo15();
                        item.fiIdHoSo(e.hoSo.fiIdHoSo);
                        item.fiDocumentName(e.hoSo.fiDocumentName);
                        sendHoSoView.show(item);
                    } else {
                       if (action == 2) {
                           location.href = app.appContext + '/mard/15/ycs/' + e.hoSo.fiIdHoSo;
                       } else {
                           location.href = app.appContext + '/mard/15/edit/' + e.hoSo.fiIdHoSo;
                       }
                    }
                }
            });
        }


    }


    var ghiHoSoViewModel = new GhiHoSoViewModel();

    ko.validation.locale(locale);

    ko.applyBindings(ghiHoSoViewModel, document.getElementById("GhiHoSoViewModel"));

});
