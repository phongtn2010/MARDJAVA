var moduelThongTinChung;
var moduleThongTinThuoc;
var moduleTepDinhKem;
var ghiHoSoViewModel;

$(document).ready(function () {
    $(".select2").select2({placeholder: '', width: '100%'});
    $('.tooltips').tooltip();
    $('.date-picker').datepicker({rtl: false, orientation: "left", autoclose: true});
    $(".date-picker").datepicker({
        altFormat: "dd/mm/yy"
    });

    function GhiHoSoViewModel() {

        var self = this;
        self.xemHoSo = ko.observable(false);
        self.formData = null;
        self.tbdHoSo14 = null;
        self.idHoSo = idHoSo;
        self.getHoSo = function (idHoSo) {
            app.makePost({
                url: '/mard/api/14/edit/' + self.idHoSo,
                data: JSON.stringify({}),
                error: function (e) {
                    $('#fiApplicationNo').focus();
                    self.formData = e;
                    self.tbdHoSo14 = convertObjectToKnockout(e.hoSo, new TbdHoSo14());
                    moduelThongTinChung = new ThongTinChungViewModel(self);
                    ko.applyBindings(moduelThongTinChung, document.getElementById("ThongTinChungViewModel"));

                    moduleThongTinThuoc = new ChiTietThuocViewModel(self, moduelThongTinChung);
                    ko.applyBindings(moduleThongTinThuoc, document.getElementById("ChiTietThuocViewModel"));

                    moduleTepDinhKem = new ThongTinTepDinhKemViewModel(self);
                    ko.applyBindings(moduleTepDinhKem, document.getElementById("ThongTinTepDinhKemViewModel"));
                }
            });
        }


        self.getHoSo();

        self.validForm = function (isGuiHoSo, action) {
            //valid thong tin thuoc
            if (!moduleThongTinThuoc.isValid(isGuiHoSo)) {
                return false;
            }
            if (!moduleTepDinhKem.isValid(isGuiHoSo)) {
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
            postData.hoSo = moduelThongTinChung.convertData();
            postData.tepDinhKems = moduleTepDinhKem.convertData();
            postData.thuocs = moduleThongTinThuoc.convertData();
            postData.action = action;

            app.makePost({
                url: '/mard/api/14/save/' + self.idHoSo,
                data: ko.toJSON(postData),
                error: function (e) {
                    if (e.readyState == 4) {
                        if (idHoSo == 0) {
                            showToast(NSWLang["mard.14.msg.taoMoiHoSoNo"], false);
                        } else {
                            showToast(NSWLang["mard.14.msg.capNhatHoSoNo"], false);
                        }
                        return;
                    } else {
                        if (idHoSo == 0) {
                            showToast(NSWLang["mard.14.msg.taoMoiHoSoOk"], true);

                        } else {
                            showToast(NSWLang["mard.14.msg.capNhatHoSoOk"], true);
                        }
                    }

                    if (isGuiHoSo) {
                        if (idHoSo === 0) {
                            idHoSo = e.hoSo.fiIdHoSo;
                        }
                        var sendHoSoView = new SendHoSoView();
                        var item = new TbdHoSo14();
                        item.fiIdHoSo(e.hoSo.fiIdHoSo);
                        item.fiDocumentName(e.hoSo.fiDocumentName);
                        sendHoSoView.show(item);
                    } else {
                       if (action == 2) {
                           location.href = app.appContext + '/mard/14/ycs/' + e.hoSo.fiIdHoSo;
                       } else {
                           location.href = app.appContext + '/mard/14/edit/' + e.hoSo.fiIdHoSo;
                       }
                    }
                }
            });
        }


    }


    ghiHoSoViewModel = new GhiHoSoViewModel();

    ko.validation.locale(locale);

    ko.applyBindings(ghiHoSoViewModel, document.getElementById("GhiHoSoViewModel"));

});
