
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
        self.tbdHoSo18 = null;
        self.idHoSo = idHoSo;
        self.getHoSo = function (idHoSo) {
            app.makePost({
                url: '/mard/api/18/edit/' + self.idHoSo,
                data: JSON.stringify({}),
                error: function (e) {
                    $('#fiApplicationNo').focus();
                    self.formData = e;
                    self.tbdHoSo18 = convertObjectToKnockout(e.hoSo, new TbdHoSo18());
                    self.moduelThongTinChung = new ThongTinChungViewModel(self);
                    ko.applyBindings(self.moduelThongTinChung, document.getElementById("ThongTinChungViewModel"));
                    //console.log("self.moduelThongTinChung.tbdHoSo18.fiExperimentName " + self.moduelThongTinChung.tbdHoSo18.fiExperimentName());

                    self.moduleThongTinThuoc = new ChiTietThuocViewModel(self, self.moduelThongTinChung);
                    ko.applyBindings(self.moduleThongTinThuoc, document.getElementById("ChiTietThuocViewModel"));
                    //console.log("self.moduelThongTinChung.tbdHoSo18.fiExperimentName " + self.moduelThongTinChung.tbdHoSo18.fiExperimentName());

                    self.moduleTepDinhKem = new ThongTinTepDinhKemViewModel(self);
                    ko.applyBindings(self.moduleTepDinhKem, document.getElementById("ThongTinTepDinhKemViewModel"));
                   // console.log("self.moduelThongTinChung.tbdHoSo18.fiExperimentName " + self.moduelThongTinChung.tbdHoSo18.fiExperimentName());
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
            postData.hoSo.fiExperimentName = self.moduleThongTinThuoc.layTenTT();
            postData.tepDinhKems = self.moduleTepDinhKem.convertData();
            postData.thuocs = self.moduleThongTinThuoc.convertData();
            postData.action = action;


            postData.thuocs.forEach(function (dataThuocs) {

                var ps = [];
                dataThuocs.fiTepDinhKemThuocs.forEach(function(dataTep){
                    var t = {};
                    t = convertKnockoutToObject(dataTep, createObject(new TepTinThuocModel()));
                    ps.push(t);
                })
                dataThuocs.fiTepDinhKemThuocs = ps;

            })
            app.makePost({
                url: '/mard/api/18/save/' + self.idHoSo,
                data: ko.toJSON(postData),
                error: function (e) {
                    if (e.readyState == 4) {
                        if (idHoSo == 0) {
                            showToast(NSWLang["mard.18.msg.taoMoiHoSoNo"], false);
                        } else {
                            showToast(NSWLang["mard.18.msg.capNhatHoSoNo"], false);
                        }
                        return;
                    } else {
                        if (idHoSo == 0) {
                            showToast(NSWLang["mard.18.msg.taoMoiHoSoOk"], true);

                        } else {
                            showToast(NSWLang["mard.18.msg.capNhatHoSoOk"], true);
                        }
                    }

                    if (isGuiHoSo) {
                        if (idHoSo === 0) {
                            idHoSo = e.hoSo.fiIdHoSo;
                        }
                        var sendHoSoView = new SendHoSoView();
                        var item = new TbdHoSo18();
                        item.fiIdHoSo(e.hoSo.fiIdHoSo);
                        item.fiDocumentName(e.hoSo.fiDocumentName);
                        sendHoSoView.show(item);
                    } else {
                       if (action == 2) {
                           location.href = app.appContext + '/mard/18/ycs/' + e.hoSo.fiIdHoSo;
                       } else {
                           location.href = app.appContext + '/mard/18/edit/' + e.hoSo.fiIdHoSo;
                       }
                    }
                }
            });

        }


    }


    ghiHoSoViewModel = new GhiHoSoViewModel();

    ko.validation.locale(locale);

    ko.applyBindings(ghiHoSoViewModel, document.getElementById("GhiHoSoViewModel"));
    console.log("ghiHoSoViewModel: " + ko.toJSON(ghiHoSoViewModel));

});
