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
        self.tbdHoSo03 = new TbdHoSo03();
        self.dataApi = ko.observable(null);
        self.danhMucTinhTPs = ko.observableArray([{fiCode: '-1', fiName: i18nextko.t('choose')}]);
        self.saveOrSend = ko.observable(false);

        TbdThietB03ViewModel(self);
        ThongTinTepDinhKemViewModel(self);
        callApi('/mic/api/03/edit/' + self.idHoSo, null, function (d) {
            d.data.danhMucTinhTPs.forEach(function (value) {
                self.danhMucTinhTPs.push(value);
            });
            convertObjectToKnockout(d.data.hoSo, self.tbdHoSo03);

            self.dataApi(d.data);
        });


        self.validForm = function (isGuiHoSo, action) {

            self.saveOrSend(true);
            $('#fiNoiDNCapPhep').parent().children('span[class="validationMessage"]').remove();
            $('#fiCuaKhauNhap').parent().children('span[class="validationMessage"]').remove();
            $('#fiDiaDiemKy' +
                '').parent().children('span[class="validationMessage"]').remove();

            var fields = ['fiNoiDNCapPhep', 'fiCuaKhauNhap', 'fiDiaDiemKy'];
            fields.forEach(function (value) {
                self.tbdHoSo03[value].rules.remove(function (item) {
                    return item.rule == "notEqual";
                });
                self.tbdHoSo03[value].extend({
                    notEqual: i18nextko.t('choose')(),
                });
            })

            if (isGuiHoSo) {
                if (self.fullDataTable().length == 0) {
                    self.openForm(null, function () {
                    });
                    showToast(i18nextko.t('TbdThietBi03.guiHoSo')(), false);
                    return false;
                }
                self.tbdHoSo03["fiTenNguoiKy"].rules.remove(function (item) {
                    return item.rule == "required";
                });
                self.tbdHoSo03["fiTenNguoiKy"].extend({
                    required: true,
                });
            } else {
                self.tbdHoSo03["fiTenNguoiKy"].rules.remove(function (item) {
                    return item.rule == "required";
                });
                self.tbdHoSo03["fiTenNguoiKy"].extend({
                    required: true,
                });
            }

            if (self.tbdHoSo03.valid.errors().length > 0) {
                self.tbdHoSo03.valid.errors.showAllMessages();
                showError(self.tbdHoSo03);
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

            postData.hoSo = convertKnockoutToObject(self.tbdHoSo03, createObject(self.tbdHoSo03));
            postData.hoSo.tbdThietBi03DTOS = convertToArray(self.fullDataTable());
            postData.hoSo.tbdDinhKem03DTOS = self.getTepDinhKems();
            console.log(postData);
            postData.action = action;

            callApi(pathAPI + '/save/' + self.idHoSo, postData, function (d) {
                console.log(d);

                if (isGuiHoSo) {
                    self.send(d.data.hoSo.fiIdHoSo);
                } else {
                    showToast(i18nextko.t('msgOK')(), true);
                    setTimeout(function () {
                        location.href = app.appContext + "/mic/03/edit/" + d.data.hoSo.fiIdHoSo;
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
                    location.href = app.appContext + "/mic/03/home";
                }, 1000)
            });
        }

    }


    ghiHoSoViewModel = new GhiHoSoViewModel();

    ko.validation.locale(locale);

    ko.applyBindings(ghiHoSoViewModel, document.getElementById("form"));

});
