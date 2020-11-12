var mapTrangthai = {}

function Mard25VM() {
    var self = this;
    self.fiCertNo = ko.observable(null);
    self.fiCompanyTaxCode = ko.observable(hosoUsername);
    self.fiHSCode = ko.observable(null);
    self.fiHSStatus = ko.observable(null);
    self.fiCounttry = ko.observable(null);
    self.sentStartDate = ko.observable(null);
    self.sentEndDate = ko.observable(null);
    self.licenseNo = ko.observable(null);
    self.fiProMadeIn = ko.observable(null);
    self.fiProName = ko.observable(null);
    self.licenseStartDate = ko.observable(null);
    self.licenseEndDate = ko.observable(null);
    // self.page = ko.observable(DEFAULT_PAGE_NUM);
    self.size = ko.observable(MAX_PAGE_SIZE);
    self.sortBy = ko.observable("fiHSCreatedDate");
    self.order = ko.observable("desc");

    self.mard25Items = ko.observableArray([]);
    self.selectedHoSo = ko.observable(null);

    self.lstCountry = ko.observableArray([]);
    self.lstPort = ko.observableArray([]);
    self.lstUOMAnimal = ko.observableArray([]);
    self.lstProfileStatus = ko.observableArray([]);
    self.lstHoSoType = ko.observableArray([]);
    self.lstDVXL = ko.observableArray([]);
    self.lstAtchType = ko.observableArray([]);

    self.giayPhepVM = ko.observable(new GiayPhepVM());
    self.xinRutHoSoVM = ko.observable(new XinRutHoSoVM());
    self.lichsuXuly = ko.observable(new HistoryPopupView());

    self.fiIdTCCD=ko.observable(null);
    self.fiNameTCCD=ko.observable(null);
    self.filstChiTieu = ko.observableArray([]);
    self.selectedHoSo=ko.observable(null);
    self.lstNhom = ko.observableArray([]);
    self.lstProvince = ko.observableArray([]);

    self.pagination = ko.observable(new PagingVM({
        pageSize: MAX_PAGE_SIZE,
        totalCount: 0,
        currentPage: 1
    }));

    self.currentPage = ko.observable(1);

    self.pagination().currentPage.subscribe(function (newCurrentPage) {
        self.currentPage(newCurrentPage);
        self.searchHoso(newCurrentPage);
    })
    self.getTenNhom = function (idNhom) {
        // console.log(idNhom);
        var lstNhomHangHoa = self.lstNhom();
        var pos = lstNhomHangHoa.find(function (e) {
            return e.fiCatType == Number(idNhom);
        })
        if (pos)
            return pos.fiCatTypeName;
        else return idNhom;
    }
    self.getProfileStatus = function (statuscode) {
        var lstProfileStatus = self.lstProfileStatus();
        var pos = lstProfileStatus.find(function (e) {
            return e.fiCatType == Number(statuscode);
        })
        if (pos)
            return pos.fiCatTypeName;
        else return statuscode;
    }
    self.getNoiKy = function(provinceId){
        var pos = self.lstProvince().find(function (e) {
            return e.provinceId == Number(provinceId);
        })
        if (pos)
            return pos.provinceName;
        else return provinceId;
    }
    self.getHoSoType = function (hsType) {
        var lstHoSoType = self.lstHoSoType();
        var pos = lstHoSoType.find(function (e) {
            return e.fiCatType == Number(hsType);
        })
        if (pos)
            return pos.fiCatTypeName.substring(0,2);
        else return hsType;
    }
    self.getHoSoTypeFull = function (hsType) {
        var lstHoSoType = self.lstHoSoType();
        var pos = lstHoSoType.find(function (e) {
            return e.fiCatType == Number(hsType);
        })
        if (pos)
            return pos.fiCatTypeName;
        else return hsType;
    }

    self.getUnitName = function (unitcode) {
        var lstUOMs = self.lstUOMAnimal();
        var pos = lstUOMs.find(function (e) {
            return e.unitcode == unitcode;
        })
        if (pos)
            return pos.unitname;
        else return '';
    }

    self.getCountryName = function (countrycode) {
        var lstCountry = self.lstCountry();
        var pos = lstCountry.find(function (e) {
            return e.countrycode == countrycode;
        })
        if (pos)
            return pos.countryname;
        else return ''
    }

    self.applyState = function () {
        var options = {};
        $('#loading10').show();
        $.when(
            // Get list country
            app.sendGetRequest("/mard/25/danhmuc/quocgia", function (res) {
                options['lstCountry'] = res.data;
                self.lstCountry(res.data);
            }),
            // Get list port
            app.sendGetRequest("/mard/25/danhmuc/cuakhau?countryCode=VN", function (res) {
                options['lstPort'] = res.data;
                self.lstPort(res.data);
            }),
            // Get UOMs
            app.sendGetRequest("/mard/25/danhmuc/unit?unitTypeId=4&systemId=6", function (res) {
                options['lstUOMAnimal'] = res.data;
                self.lstUOMAnimal(res.data);
            }),
            app.sendGetRequest("/mard/25/danhmuc/getby-catno/25", function (res) {
                options['lstProfileStatus'] = res.data;
                self.lstProfileStatus(res.data);
            }),
            app.sendGetRequest("/mard/25/danhmuc/getby-catno/2", function (res) {
                options['lstHoSoType'] = res.data;
                self.lstHoSoType(res.data);
            }),
            app.sendGetRequest("/mard/25/danhmuc/dvxl/1", function (res) {
                options['lstDVXL'] = res.data;
                self.lstDVXL(res.data);
            }),
            // Get profile status
            app.sendGetRequest("/mard/25/danhmuc/getby-catno/1", function (res) {
                self.lstNhom(res.data);
            }),
            // Get list province
            app.sendGetRequest("/mard/25/danhmuc/tinhthanh", function (res) {
                self.lstProvince(res.data);
            })
            // Get attach types
            // app.sendGetRequest("/mard/06/danhmuc/dinhkem?systemId=6", function (res) {
            //     options['lstAtchType'] = res.data;
            //     self.lstAtchType(res.data);
            // }),
            // // Get profile status
            // app.sendGetRequest("/mard/06/danhmuc/statusHoso?systemId=6", function (res) {
            //     options['lstProfileStatus'] = res.data;
            //     self.lstProfileStatus(res.data);
            //
            //     res.data.forEach(function (item) {
            //         mapTrangthai[item.id.toString()] = item.name
            //     });
            // })
        ).done(function (data) {
            $('#loading10').hide();
            self.searchHoso(1);
        })
    }

    self.btnSearch  = function() {
        self.searchHoso(1);
    }

    self.searchHoso = function (page) {
        var filter = {
            fiCertNo: self.fiCertNo(),
            fiHSCode: self.fiHSCode(),
            fiTenHangHoa: self.fiProName(),
            fiHSStatus: self.fiHSStatus(),
            fiCompanyTaxCode: hosoUsername,

            sentStartDate: self.sentStartDate(),
            sentEndDate: self.sentEndDate(),
            fiProCountryName: self.fiCounttry(),
            fiProMadeIn: self.fiProMadeIn(),
            licenseNo: self.licenseNo(),
            licenseStartDate: self.licenseStartDate(),
            licenseEndDate: self.licenseEndDate(),
            page: page,
            size: self.size(),
            sortBy: self.sortBy(),
            order: self.order()
        }
        console.log(filter);
        $.ajax({
            async: true,
            type: 'POST',
            cache: false,
            crossDomain: true,
            url: app.appContext + "/mard/25/hoso/timkiem",
            data: JSON.stringify(filter),
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            beforeSend: function (xhr) {
                xhr.setRequestHeader(CSRF_TOKEN_NAME, CSRF_TOKEN_VALUE);
                $('#loading08').show();
            },
            success: function (res) {
                if (res.success) {
                    var list = res.data ? res.data.data : [];
                    self.mard25Items(list);
                    self.pagination().update({
                        totalCount: res.data.total,
                        pageSize: MAX_PAGE_SIZE,
                        currentPage: page
                    })
                }
            },
            error: function (err) {
            },
            complete: function (jqXHR, textStatus) {
                $('#loading08').hide();
                window.stateChanging = false;
            }
        });
    }
    self.setValueForIndexPage = function(item){
        item.lstCountry = self.lstCountry();
        item.lstPort = self.lstPort();
        item.lstProfileStatus = self.lstProfileStatus();
        item.lstUOMAnimal = self.lstUOMAnimal();
        item.lstAtchType = self.lstAtchType();
        item.lstHD = ko.observableArray([]);
        item.lstHoaDon = ko.observableArray([]);
        item.lstPhieu = ko.observableArray([]);
        if(item.fiAttachmentList.length>0) {
            console.log(item.fiAttachmentList);
            item.lstHD=ko.computed(function () {
                return ko.utils.arrayFilter(item.fiAttachmentList, function (re) {
                    return re.fiFileTypeID == '1';
                });
            });
            item.lstHoaDon=ko.computed(function () {
                return ko.utils.arrayFilter(item.fiAttachmentList, function (re) {
                    return re.fiFileTypeID == '2';
                });
            });
            item.lstPhieu=ko.computed(function () {
                return ko.utils.arrayFilter(item.fiAttachmentList, function (re) {
                    return re.fiFileTypeID == '3';
                });
            });
        }
        item.ngayKy = ko.observable(null);
        item.thangKy = ko.observable(null);
        item.namKy = ko.observable(null);

        var ngayTao = new Date(item.fiHSCreatedDate);
        var ngay=ngayTao.getDay();
        var thang=ngayTao.getMonth();
        var nam=ngayTao.getFullYear();

        item.ngayKy(ngay);
        item.thangKy(thang);
        item.namKy(nam);
        return item;
    }
    self.viewHoSo = function(item) {

        console.log("10");
        var value = self.setValueForIndexPage(item);
        self.selectedHoSo(value);
        $('#mard25ViewHSModal').modal('show');
    }
    self.showLSXL = function (item) {
        self.lichsuXuly().show(item.fiNSWFileCode);
        return false;
    };



    self.viewHangHoaStatus = function(item) {
        window.location.href= app.appContext + "/mard/25/hanghoa/" + item.fiIdHS;
        return true;
    }

    self.deleteHoso = function (item) {
        console.log(item);
        // return;
        self.pop = app.popup({
            title: 'Thông báo',
            html: '<b>Bạn chắc chắn muốn xóa hồ sơ ' + item.fiNSWFileCode + '?</b>',
            width: 450,
            buttons: [
                {
                    name: NSWLang["common_button_toi_chac_chan"],
                    class: 'btn',
                    icon: 'fa-save',
                    action: function () {
                        app.popupRemove(self.pop.selector);
                        $.ajax({
                            async: true,
                            type: 'GET',
                            cache: false,
                            crossDomain: true,
                            url: app.appContext + "/mard/25/hoso/delete?fiIdHS=" + item.fiIdHS + "&fiTaxCode=" + hosoUsername,
                            beforeSend: function (xhr) {
                                xhr.setRequestHeader(CSRF_TOKEN_NAME, CSRF_TOKEN_VALUE);
                                $('#loading10').show();
                            },
                            success: function (res) {
                                $('#loading10').hide();
                                if (res.success) {
                                    app.Alert('Xóa hồ sơ thành công');
                                    self.searchHoso(self.currentPage());
                                } else {
                                    app.Alert(d.message);
                                }
                            },
                            error: function (err) {
                            },
                            complete: function (jqXHR, textStatus) {
                                $('#loading08').hide();
                            }
                        });
                    }
                },
                {
                    name: 'Huỷ',
                    class: 'btn',
                    icon: 'fa-close',
                    action: function () {
                        app.popupRemove(self.pop.selector);
                    }
                }
            ]
        })
    }

    self.requestCancelProfile = function () {
        if (self.xinRutHoSoVM().fiReason().length == 0) {
            app.Alert('Nhập lý do xin rút');
            return;
        }
        if (self.xinRutHoSoVM().fiSigner().length == 0) {
            app.Alert('Nhập người ký');
            return;
        }
        var body = {
            fiNSWFileCode: self.xinRutHoSoVM().fiNSWFileCode(),
            fiRequestedDate: self.xinRutHoSoVM().fiRequestedDate(),
            fiReason: self.xinRutHoSoVM().fiReason(),
            fiIdHS: self.xinRutHoSoVM().fiIdHS(),
            fiSigner: self.xinRutHoSoVM().fiSigner()
        };
        console.log(body);
        self.pop = app.popup({
            title: 'Thông báo',
            html: '<b>Bạn chắc chắn muốn gửi yêu cầu xin rút?</b>',
            width: 450,
            buttons: [
                {
                    name: NSWLang["common_button_toi_chac_chan"],
                    class: 'btn',
                    icon: 'fa-save',
                    action: function () {
                        app.popupRemove(self.pop.selector);
                        app.makePost({
                            url: '/mard/25/hoso/cancel',
                            data: JSON.stringify(body),
                            success: function (d) {
                                if (d && d.success) {
                                    app.Alert('Gửi yêu cầu thành công');
                                    self.searchHoso(self.currentPage());
                                    if ($('#modal_xin_rut').hasClass('in')) {
                                        $('#modal_xin_rut').modal('hide');
                                    }
                                } else {
                                    app.Alert(d.message);
                                }
                            },
                            error: function (e) {
                                app.Alert('Không gửi được yêu cầu');
                            }
                        });
                    }
                },
                {
                    name: 'Huỷ',
                    class: 'btn',
                    icon: 'fa-close',
                    action: function () {
                        app.popupRemove(self.pop.selector);
                    }
                }
            ]
        });
    }

    self.taiMauHoSo = function(data) {
        var link = document.createElement('a');
        link.href = '/mard/06/hoso/download/02/' + data.fiIdHS;
        link.target = '_blank';
        document.body.appendChild(link);
        link.click();
        link.remove();
    }


    self.goEditHoSo = function(item) {
        window.location.href= app.appContext + "/mard/25/edit/" + item.fiIdHS;
        return true;
    }
    self.goCopyHoSo = function(item) {
        window.location.href= app.appContext + "/mard/25/copy/" + item.fiIdHS;
        return true;
    }

    self.goYCRHoSo = function(item) {
        self.xinRutHoSoVM().update(item);
        $('#modal_xin_rut').modal('show');
    }



    self.viewLichSu = function (item, e) {
        self.lichsuXuly().show(item.fiNSWFileCode)
        return false;
    };

    self.chuyenTCCD = function (data,type,index) {
        console.log("vao ham");
        var value = self.setValueForIndexPage(index);
        self.selectedHoSo(value);
        console.log()
        app.makeGet({
            url: '/mard/25/chitieu/'+index.fiNSWFileCode,
            success: function(res) {
                self.filstChiTieu(res.data);
                console.log(res);
            },
            error: function (d) {

            }
        });
    }
    self.chuyenChiTieu =function(){
        self.selectedHoSo().fiIdDVXL=self.fiIdTCCD();
        self.selectedHoSo().fiNameDVXL=self.fiNameTCCD();
        self.pop = app.popup({
            title: 'Thông báo',
            html: '<b>Bạn chắc chắn muốn chuyển hồ sơ cho tổ chức chỉ định?</b>',
            width: 450,
            buttons: [
                {
                    name: NSWLang["common_button_toi_chac_chan"],
                    class: 'btn',
                    icon: 'fa-save',
                    action: function () {
                        app.popupRemove(self.pop.selector);
                        app.makePost({
                            url: '/mard/25/hoso/chuyenchitieu',
                            data: JSON.stringify(self.selectedHoSo()),
                            contentType: "application/json; charset=utf-8",
                            success: function (d) {
                                if (d && d.success) {
                                    app.Alert('Gửi yêu cầu thành công');
                                    self.searchHoso(self.currentPage());
                                    if ($('#modal_view_chuyen').hasClass('in')) {
                                        $('#modal_view_chuyen').modal('hide');
                                    }
                                } else {
                                    app.Alert(d.message);
                                }
                            },
                            error: function (e) {
                                app.Alert('Không gửi được yêu cầu');
                            }
                        });
                    }
                },
                {
                    name: 'Huỷ',
                    class: 'btn',
                    icon: 'fa-close',
                    action: function () {
                        app.popupRemove(self.pop.selector);
                    }
                }
            ]
        });
    }
    self.closeViewChuyen = function(){

    }
    self.thoatOnClick  = function () {
        $("#modal_view_chuyen").hide();
    }
}

function GiayPhepVM(options) {
    var gpVMSelf = this;
    gpVMSelf.companyName = hosoCompanyName;
    gpVMSelf.vsty = ko.observable((options && options.hasOwnProperty('vsty')) ?  options.vsty: null);
    gpVMSelf.cnkd = ko.observable((options && options.hasOwnProperty('cnkd')) ?  options.cnkd: null);

    gpVMSelf.update = function (data) {
        var re = new RegExp('\n', 'g');
        if (data.vsty) {
            var fiRecipient = data.vsty.fiRecipient ? data.vsty.fiRecipient : "";
            var fiResponseContent = data.vsty.fiResponseContent ? data.vsty.fiResponseContent : "";
            fiRecipient = fiRecipient.replace(',', '<br>');
            fiResponseContent = fiResponseContent.replace(re, '<br>');
            data.vsty.fiRecipient = fiRecipient;
            data.vsty.fiResponseContent = fiResponseContent;
        }
        if (data.cnkd) {
            var fiRecipient = data.cnkd.fiRecipient ? data.cnkd.fiRecipient : "";
            var fiResponseContent = data.cnkd.fiResponseContent ? data.cnkd.fiResponseContent : "";
            fiRecipient = fiRecipient.replace(',', '<br>');
            fiResponseContent = fiResponseContent.replace(re, '<br>');
            data.cnkd.fiRecipient = fiRecipient;
            data.cnkd.fiResponseContent = fiResponseContent;
        }
        gpVMSelf.vsty(data.vsty ? data.vsty : null);
        gpVMSelf.cnkd(data.cnkd ? data.cnkd : null);
    }

    gpVMSelf.convertHTML = function (content) {
        if (content) {
            var re = new RegExp('\n', 'g');
            return content.replace(re, '<br>');
        } else {
            return '';
        }
    }

    gpVMSelf.taiGiayPhep = function (data, type) {
        if (type == 'vsty') {
            var link = document.createElement('a');
            link.href = '/mard/06/gcn/download/vsty/' + gpVMSelf.vsty().fiNSWFileCode;
            link.target = '_blank';
            document.body.appendChild(link);
            link.click();
            link.remove();
        } else if (type == 'kdnk') {
            var link = document.createElement('a');
            link.href = '/mard/06/gcn/download/kdnk/' + gpVMSelf.cnkd().fiNSWFileCode;
            link.target = '_blank';
            document.body.appendChild(link);
            link.click();
            link.remove();
        }
    }

}

function XinRutHoSoVM () {
    var xinRutHoSoVMSelf = this;
    xinRutHoSoVMSelf.fiNSWFileCode = ko.observable(null);
    xinRutHoSoVMSelf.fiRequestedDate = ko.observable(null);
    xinRutHoSoVMSelf.fiReason = ko.observable('');
    xinRutHoSoVMSelf.fiIdHS = ko.observable(null);
    xinRutHoSoVMSelf.errorMsg = ko.observable('');
    xinRutHoSoVMSelf.fiHSStatus = ko.observable(null);
    xinRutHoSoVMSelf.fiSigner = ko.observable("");
    xinRutHoSoVMSelf.clearForm = function () {
        xinRutHoSoVMSelf.errorMsg('')
    }

    xinRutHoSoVMSelf.update = function (data) {
        xinRutHoSoVMSelf.fiNSWFileCode(data.fiNSWFileCode);
        xinRutHoSoVMSelf.fiIdHS(data.fiIdHS);
        xinRutHoSoVMSelf.fiRequestedDate(new Date());
        xinRutHoSoVMSelf.fiHSStatus(data.fiHSStatus);
        xinRutHoSoVMSelf.fiSigner = ko.observable('');
        xinRutHoSoVMSelf.fiReason = ko.observable('');
    }
}


$(document).ready(function () {
    $.fn.select2.defaults.set("theme", "bootstrap");
    $(".select2").select2({placeholder: '-- Tất cả --', width: '100%', allowClear: true});

    var vm = new Mard25VM();
    ko.applyBindings(vm, document.getElementById('mard06'));
    vm.applyState();
    $("#title_tab_vsty").click(function (e) {
        $("#tab_vsty").show();
        $("#tab_cnkd").hide();
    });
    $("#title_tab_kdnk").click(function (e) {
        $("#tab_cnkd").show();
        $("#tab_vsty").hide();
    })
})

