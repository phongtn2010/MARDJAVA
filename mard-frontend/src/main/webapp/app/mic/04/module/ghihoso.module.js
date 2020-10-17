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
        self.idHoSo = idHoSo;
        self.tbdHoSo04 = new TbdHoSo04();
        self.dataApi = ko.observable(null);
        self.danhMucTinhTPs = ko.observableArray([{fiCode: '-1', fiName: i18nextko.t('choose')}]);
        self.danhMucCuaKhaus = ko.observableArray([{fiCode: '-1', fiName: i18nextko.t('choose')}, {fiCode: '1', fiName: i18nextko.t('fidmcuakhau.ok')}, {fiCode: '2', fiName: i18nextko.t('fidmcuakhau.not')}]);

        TbdNguoiThamDinh04ViewModel(self);
        ThongTinTepDinhKemViewModel(self);
        callApi(pathAPI + '/edit/' + self.idHoSo, null, function (d) {
            d.data.danhMucTinhTPs.forEach(function (value) {
                self.danhMucTinhTPs.push(value);
            });
            convertObjectToKnockout(d.data.hoSo, self.tbdHoSo04);
            self.dataApi(d.data);
        });


        self.validForm = function (isGuiHoSo, action) {

            $('#fiNoiDNCapPhep').parent().children('span[class="validationMessage"]').remove();
            $('#fiNhapKhauSach').parent().children('span[class="validationMessage"]').remove();

            var fields = ['fiNoiDNCapPhep'];
            fields.forEach(function (value) {
                self.tbdHoSo04[value].rules.remove(function (item) {
                    return item.rule == "notEqual";
                });
                self.tbdHoSo04[value].extend({
                    notEqual: i18nextko.t('choose')(),
                });
            })
            self.tbdHoSo04['fiNhapKhauSach'].rules.remove(function (item) {
                return item.rule == "notEqual";
            });
            self.tbdHoSo04['fiNhapKhauSach'].extend({
                notEqual: '-1',
            });

            if (self.tbdHoSo04.valid.errors().length > 0) {
                showError(self.tbdHoSo04);
                self.tbdHoSo04.valid.errors.showAllMessages();
                return false;
            }

            if (isGuiHoSo) {

                if (self.fullDataTable().length === 0 && parseInt(self.tbdHoSo04.fiNhapKhauSach()) === 1) {
                    self.openForm(null, function () {
                    });
                    showToast(i18nextko.t('TbdNguoiThamDinh04.guiHoSo')(), false);
                    return false;
                }
                self.tbdHoSo04["fiTenNguoiKy"].rules.remove(function (item) {
                    return item.rule == "required";
                });
                self.tbdHoSo04["fiTenNguoiKy"].extend({
                    required: true,
                });
            } else {
                self.tbdHoSo04["fiTenNguoiKy"].rules.remove(function (item) {
                    return item.rule == "required";
                });
                self.tbdHoSo04["fiTenNguoiKy"].extend({
                    required: true,
                });
            }

            if (!self.isValidTepDinhKem(isGuiHoSo)) {
                showToast(i18nextko.t('TbdDinhKem04.guihoso')(), false);
                return false;
            }

            if (self.tbdHoSo04.valid.errors().length > 0) {
                showError(self.tbdHoSo04);
                return false;
            }

            action();
            return true;
        }

        self.ghiLai = function () {
            callBack(function () {
                self.validForm(false, function () {
                    self.save(false);
                });
            })


        }
        self.guiHoSo = function () {
            callBack(function () {
                self.validForm(true, function () {
                    self.save(true);
                });
            })


        }
        self.save = function (isGuiHoSo) {
            var postData = {};
            postData.hoSo = convertKnockoutToObject(self.tbdHoSo04, createObject(self.tbdHoSo04));
            postData.hoSo.tbdNguoiThamDinh04DTOS = convertToArray(self.fullDataTable());
            postData.hoSo.tbdDinhKem04DTOS = self.getTepDinhKems();
            postData.action = action;

            callApi(pathAPI + '/save/' + self.idHoSo, postData, function (d) {
               console.log(d);

                if (isGuiHoSo) {
                   self.send(d.data.hoSo.fiIdHoSo);
                } else {
                    showToast(i18nextko.t('msgOK')(), true);
                    setTimeout(function () {
                        location.href = app.appContext + "/mic/04/edit/" + d.data.hoSo.fiIdHoSo;
                    }, 1000)
                }

            })

        }

        self.send = function (fiIdHoSo) {
            var v = new SendHoSoView();
            var post = {
                fiReason: null,
                fiXml: null,
                fiIdHoSo: fiIdHoSo,
                fiAction: 1
            }
            v.send('/send', post, false, function () {
                setTimeout(function () {
                    location.href = app.appContext + "/mic/04/home";
                }, 1000)
            });
        }

    }


    ghiHoSoViewModel = new GhiHoSoViewModel();

    ko.validation.locale(locale);

    ko.applyBindings(ghiHoSoViewModel, document.getElementById("form"));

});
