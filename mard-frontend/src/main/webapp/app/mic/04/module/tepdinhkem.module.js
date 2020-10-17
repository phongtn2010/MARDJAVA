function ThongTinTepDinhKemViewModel(self) {
    self.accepFiles = ['jpg', 'pdf', 'tif', 'JPG', 'PDF', 'TIF'];

    self.xemHoSo = ko.observable(isView);
    self.danhMucTeps = ko.observableArray();
    self.selectedTep = ko.observable('DK_HS');
    self.teps = ko.observableArray();

    self.danhMucTepDuocChon = ko.observableArray([]);
    self.groupFileSelected = ko.observableArray([]);
    self.groupFileSelected.push(ko.observableArray([]));
    self.groupFileSelected.push(ko.observableArray([]));
    self.groupFileIndexSelected = ko.observable(0);
    self.totalFileSize = ko.observable(0);
    self.dataApi.subscribe(function (d) {
        d.danhMucTepDinhKems.forEach(function(item, index){
            if (item.loaiTep == self.selectedTep()) {
                self.danhMucTepDuocChon.push(item);
            }
            self.groupFileSelected()[0].push(ko.observableArray([]));
        });
        self.layDanhSachTepTinTheoHS(d);
    })

    self.layDanhSachTepTinTheoHS = function(d){
        var ds = [];
        d.danhMucTepDinhKems.forEach(function(t, tIndex){
            if (t.loaiTep == self.selectedTep()) {
                ds.push(t);
            }
        });
        if (d.hoSo.tbdDinhKem04DTOS) {
            ds.forEach(function(t, tIndex){
                $(d.hoSo.tbdDinhKem04DTOS).each(function(index, loopItem){
                    if (t.maLoaiTep == loopItem.fiFileTypeCode) {
                        var tepTin = convertObjectToKnockout(loopItem, new TbdDinhKem03());
                        tepTin.link(urlDownload + loopItem.fiId);
                        self.groupFileSelected()[self.groupFileIndexSelected()]()[tIndex].push(tepTin);
                    }

                });
            });
        }

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

                    var tepTin = new TbdDinhKem03();
                    tepTin.fiId(parseInt(value));
                    tepTin.fiIdHoSo(idHoSo);
                    tepTin.fiFileGroup(item.loaiThuTuc);
                    tepTin.fiFileTypeCode(item.maLoaiTep + "");
                    tepTin.fiFileTypeName(item.tenTep);
                    tepTin.fiFileName(files[index].name);
                    tepTin.link(urlDownload + value);

                    if (idHoSo > 0) {
                        callApi('/mic/04/tbdDinhKem04/create', convertKnockoutToObject(tepTin, createObject(tepTin)), function (d) {
                            self.groupFileSelected()[groupIndex]()[position].push(tepTin);
                        })
                    } else {
                        self.groupFileSelected()[groupIndex]()[position].push(tepTin);
                    }
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
                            if (idHoSo > 0) {
                                var url = '/mic/04/tbdDinhKem04/delete/' + idHoSo + "/" + loopItem.fiId();
                                callApi(url, null, function (d) {
                                    self.groupFileSelected()[self.groupFileIndexSelected()]()[groupPosition].remove(loopItem);
                                })
                            } else {
                                self.groupFileSelected()[self.groupFileIndexSelected()]()[groupPosition].remove(loopItem);
                            }

                        });
                    }
                }
            ]
        });
    }



    self.isValidTepDinhKem = function(isGuiHoSo) {
        var check = true;
        if (isGuiHoSo) {
            for(var groupDetailIndex = 0; groupDetailIndex < self.groupFileSelected()[self.groupFileIndexSelected()]().length; groupDetailIndex++) {
                var groupDetail = self.groupFileSelected()[self.groupFileIndexSelected()]()[groupDetailIndex];
                if (isDevTest) {
                    console.log(self.danhMucTepDuocChon()[groupDetailIndex]);
                    console.log("Size: " + groupDetail().length);
                }

                if (  self.danhMucTepDuocChon()[groupDetailIndex] && self.danhMucTepDuocChon()[groupDetailIndex].required) {
                    if (groupDetail().length == 0) {
                        check = false;
                        return false;
                    }
                }
            }

        }
        console.log(check);
        if (!check) {
           app.Alert(i18nextko.t('TbdDinhKem04.guihoso')());
        }
        return check;
    }


    self.getTepDinhKems = function() {
        var data = [];
        self.groupFileSelected()[self.groupFileIndexSelected()]().forEach(function (groupDetail, groupDetailIndex) {
            // console.log("groupDetailIndex = " + groupDetailIndex + " : " + groupDetail().length + " > " + self.danhMucTepDuocChon()[groupDetailIndex].required);
            $(groupDetail()).each(function(tIndex, t){
                data.push(convertKnockoutToObject(t, createObject(t)));
            });
        })
        return data;
    }

    self.buttonFileSelected = function (eleId) {
        $("#" + eleId).click();
    }
}
