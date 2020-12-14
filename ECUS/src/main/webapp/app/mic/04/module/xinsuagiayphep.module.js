    function SuaGiayPhepViewModel() {
    var self = this;

    self.show = function (item) {
        NSWLang['lyDo'] = i18nextko.t('lyDo')();
        var callback = function (html) {
            var pop = app.popup({
                title:  '<b style="text-transform: uppercase">' + i18nextko.t('xinSuaGP')() + " - " + item.fiDocumentName() + '</b>',
                html: html,
                width: 960,
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
                var v = new SuaGiayPhepPopupViewModel(item);
                ko.applyBindings(v, document.getElementById("popup-form"));

            });
        };

        app.complieTemplate({
            ministryCode: complieTemplateMinistryCode,
            code: complieTemplateCode,
            templateName: "xin_sua_giay_phep",
            data: []
        }, callback);
    }
}

function SuaGiayPhepPopupViewModel(item) {

    var self = this;

    self.accepFiles = ['jpg', 'pdf', 'tif', 'JPG', 'PDF', 'TIF'];

    self.xemHoSo = ko.observable(isView);
    self.danhMucTeps = ko.observableArray();
    self.selectedTep = ko.observable('DK_GP');
    self.teps = ko.observableArray();

    self.danhMucTepDuocChon = ko.observableArray([]);
    self.groupFileSelected = ko.observableArray([]);
    self.groupFileSelected.push(ko.observableArray([]));
    self.groupFileSelected.push(ko.observableArray([]));
    self.groupFileIndexSelected = ko.observable(0);
    self.totalFileSize = ko.observable(0);
    self.dataApi = ko.observable(null);

    self.tbdYeuCauSuaGP04 = new TbdYeuCauSuaGP04();
    self.tbdYeuCauSuaGP04.fiNgayYeuCau(new Date());


    callApi('/mic/api/04/giayPhep/findByFiIdHoSo/' + item.fiIdHoSo(), null, function (d) {
        self.dataApi(d.data);
    });

    self.dataApi.subscribe(function (d) {
        d.danhMucTepDinhKems.forEach(function(item, index){
            if (item.loaiTep == self.selectedTep()) {
                self.danhMucTepDuocChon.push(item);
            }
            self.groupFileSelected()[0].push(ko.observableArray([]));
        });
        self.tbdYeuCauSuaGP04.fiIdGiayPhep(d.tbdGiayPhep04DTO.fiId);
        layDanhSachTepTinTheoHS(d);
    })



    function layDanhSachTepTinTheoHS(d){
        var ds = [];
        d.danhMucTepDinhKems.forEach(function(t, tIndex){
            if (t.loaiTep == self.selectedTep()) {
                ds.push(t);
            }
        });
        ds.forEach(function(t, tIndex){
            $(d.tbdGiayPhep04DTO.tbdYeuCauSuaGP04DTOS).each(function(index, loopItem){
                if (t.maLoaiTep == loopItem.fiFileTypeCode) {
                    var tepTin = convertObjectToKnockout(loopItem, new TbdDinhKem04());
                    tepTin.link(urlDownload + loopItem.fiId);
                    self.groupFileSelected()[self.groupFileIndexSelected()]()[tIndex].push(tepTin);
                }

            });
        });
    }

    self.uploadFileChangeEvent = function(loaiTep, position, item, elemet, event) {

        var files = event.target.files;
        for (var i = 0, file; file = files[i]; i++) {
            var ext = file.name.substr(file.name.lastIndexOf('.') + 1);
            if ($.inArray(ext, self.accepFiles) === -1) {
                $('#fileUpload' + position).val('');
                app.Alert(i18nextko.t('errorUpload')());
                return false;
            }
        }

        var groupIndex = 0;
        uploadTo(files, function (d) {
            if (d.message === "0") {
                var iDFiles = d.iDFiles.split(",");
                iDFiles.forEach(function (value, index) {

                    var tepTin = new TbdDinhKemYCSGP04();
                    tepTin.fiId(parseInt(value));
                    tepTin.fiIdYeuCauSGP(null);
                    tepTin.fiFileGroup(item.loaiThuTuc);
                    tepTin.fiFileTypeCode(item.maLoaiTep + "");
                    tepTin.fiFileTypeName(item.tenTep);
                    tepTin.fiFileName(files[index].name);
                    tepTin.link(urlDownload + value);

                    self.groupFileSelected()[groupIndex]()[position].push(tepTin);
                })
                $('#fileUpload' + position).val('');
            }
        });

    }


    self.delete = function(item, groupPosition) {
        var pop = app.popup({
            title: NSWLang["common_msg_thong_bao"],
            html: '<i class="fa fa-3x fa-warning"></i> ' + NSWLang["common_msg_xoa_ho_so"],
            width: 400,
            backdrop: true,
            buttons: [
                {
                    name: NSWLang["common_button_toi_chac_chan"],
                    class: 'btn',
                    icon: 'fa-check',
                    action: function () {
                        app.popupRemove(pop.selector);
                        var arr = [];
                        if (item) {
                            arr.push(item);
                        } else {
                            $(self.groupFileSelected()[self.groupFileIndexSelected()]()[groupPosition]()).each(function(index, loopItem){
                                arr.push(loopItem);
                            });
                        }
                        $(arr).each(function(index, loopItem){
                            self.groupFileSelected()[self.groupFileIndexSelected()]()[groupPosition].remove(loopItem);
                        });
                    }
                }
            ]
        });
    }

    self.isValid = function(isGuiHoSo) {
        if (self.tbdYeuCauSuaGP04.valid.errors().length > 0) {
            showError(self.tbdYeuCauSuaGP04);
            return false;
        }
        var check = true;
        if (isGuiHoSo) {
            self.groupFileSelected()[self.groupFileIndexSelected()]().forEach(function (groupDetail, groupDetailIndex) {
                console.log(self.danhMucTepDuocChon()[groupDetailIndex]);
                if (self.danhMucTepDuocChon().length > groupDetailIndex &&  self.danhMucTepDuocChon()[groupDetailIndex].required) {
                    if (groupDetail().length == 0) {
                        check = false;
                        return false;
                    }
                }
            })
        }
        if (!check) {
            app.Alert( i18nextko.t('minLengthFile')());
        }
        return check;
    }


    self.getTepDinhKems = function() {
        var data = [];
        self.groupFileSelected()[self.groupFileIndexSelected()]().forEach(function (groupDetail, groupDetailIndex) {
            $(groupDetail()).each(function(tIndex, t){
                data.push(convertKnockoutToObject(t, createObject(t)));
            });
        })
        return data;
    }

    self.guiHoSo = function () {

        callBack(function () {
            if (self.isValid(true)) {
                var p = convertKnockoutToObject(self.tbdYeuCauSuaGP04, createObject(self.tbdYeuCauSuaGP04));
                p.tbdDinhKemYCSGP04DTOS = self.getTepDinhKems();
                callApi('/mic/api/04/tbdYeuCauSuaGP04/create', p, function (d) {
                    var post = {
                        fiReason: self.tbdYeuCauSuaGP04.fiNoiDung(),
                        fiXml: null,
                        fiIdHoSo: self.dataApi().tbdGiayPhep04DTO.fiIdHoSo,
                        fiAction: 3,
                        fiIdYeuCauSuaGP: d.data.fiId
                    };
                    var v = new SendHoSoView();
                    v.send('/send', post, false, function () {
                        setTimeout(function () {
                            location.reload();
                        }, 1000)
                    });
                })
            }
        })


    }


}