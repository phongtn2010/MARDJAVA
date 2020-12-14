var MAX_PAGE_SIZE = 15;

var mapTrangthai = {};

function Mard08VM() {
    self = this;
    self.fromFiNgaygui = ko.observable(null);
    self.toFiNgaygui = ko.observable(null);
    self.fromFiNgayCp = ko.observable(null);
    self.toFiNgayCp = ko.observable(null);
    self.fiTrangthai = ko.observable(null);
    self.fiTrangthaiList = ko.observableArray([]);
    self.fiMaHoso = ko.observable(null);
    self.fiSoGiayphep = ko.observable(null);
    self.viewVM = ko.observable(null);
    self.xinRutHoSoVM = ko.observable(null);
    self.xinXoaHoSoVM = ko.observable(null);
    self.currentPage = ko.observable(1);

    self.lstCountry = ko.observableArray([]);
    self.lstProfileStatus = ko.observableArray([]);
    self.lstPort = ko.observableArray([]);
    self.lstUOMs = ko.observableArray([]);
    self.lstDocType = ko.observableArray([]);
    self.lstAtchType = ko.observableArray([]);

    self.lichsuXuly = ko.observable(new HistoryPopupView());

    self.selectedHoSo = ko.observable(null);
    self.giayPhepVM = ko.observable(new GiayPhepVM());

    self.mard08Items = ko.observableArray([]);
    self.totalCount = ko.observable(0);

    self.pageSize = ko.observable(MAX_PAGE_SIZE);
    self.paging = ko.observable(new PagingVM({
        pageSize: self.pageSize(),
        totalCount: 0,
        currentPage: 1
    }));

    self.currentPageSubscription = self.paging().currentPage.subscribe(function (newCurrentPage) {
        if (window.stateChanging) {
            return;
        }
        self.currentPage(newCurrentPage);
        self.search(newCurrentPage, true);
    });

    self.applyState = function () {
        $.when(
            // Get list country
            app.sendGetRequest("/mard/08/danhmuc/quocgia", function (res) {
                self.lstCountry(res.data);
            }),
            // Get list port
            app.sendGetRequest("/mard/08/danhmuc/cuakhau?countryCode=VN", function (res) {
                self.lstPort(res.data);
            }),
            // Get UOMs
            app.sendGetRequest("/mard/08/danhmuc/unit?unitTypeId=4&systemId=8", function (res) {
                self.lstUOMs(res.data);
            }),
            // Get profile status
            app.sendGetRequest("/mard/08/danhmuc/statusHoso?systemId=8", function (res) {
                self.lstProfileStatus(res.data);
                res.data.forEach(function (item) {
                    mapTrangthai[item.id.toString()] = item.name
                });
            }),
            // Get document types
            app.sendGetRequest("/mard/08/hoso/doctype", function (res) {
                self.lstDocType(res.data);
            })
        ).done(function (data) {

        })
    }

    self.getProfileStatus = function (statuscode) {
        var lstProfileStatus = self.lstProfileStatus();
        var pos = lstProfileStatus.find(function (e) {
            return e.id == statuscode;
        })
        if (pos)
            return pos.name;
        else return statuscode;
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

    self.getPortName = function (portcode) {
        var lstPort = self.lstPort();
        var pos = lstPort.find(function (e) {
            return e.portcode == portcode;
        })
        if (pos)
            return pos.portname;
        else return ''
    }

    self.getDocName = function (doctype) {
        var lstDocType = self.lstDocType();
        var pos = lstDocType.find(function (e) {
            return e.id == doctype;
        })
        if (pos)
            return pos.name;
        else return ''
    }

    self.getUnitName = function (unitcode) {
        var lstUOMs = self.lstUOMs();
        var pos = lstUOMs.find(function (e) {
            return e.unitcode == unitcode;
        })
        if (pos)
            return pos.unitname;
        else return '';
    }

    self.searchFieldEnter = function () {
        self.search(1, true);
    };

    self.search = function (page, pushState) {
        self.searchAfterHasCategory(page, pushState);
    };

    self.xemLichSuTacDong = function (item, e) {

    };

    self.bXemHoSo = function (item, e) {

        item.lstCountry = self.lstCountry();
        item.lstPort = self.lstPort();
        item.lstUOMs = self.lstUOMs();
        item.lstDocType = self.lstDocType();
        item.lstAtchType = self.lstAtchType();
        item.lstProfileStatus = self.lstProfileStatus();

        self.selectedHoSo(item);
        $('#mard08ViewHSModal').modal('show');
    };

    self.goViewHoSo = function (item, e) {
        window.location.href = app.appContext + "/mard/08/view/" + item.fiIdHS;
        return true;
    }

    self.viewGiayPhep = function (item) {
        var code = item.fiHSCode;
        $.ajax({
            async: true,
            type: 'GET',
            cache: false,
            crossDomain: true,
            url: app.appContext + "/mard/08/giayphep?code=" + code + "&type=all",
            beforeSend: function (xhr) {
                xhr.setRequestHeader(CSRF_TOKEN_NAME, CSRF_TOKEN_VALUE);
                $('#loading08').show();
            },
            success: function (res) {
                $('#loading08').hide();
                if (res.success) {
                    self.giayPhepVM().update({
                        vsty: res.data.vsty,
                        cnkd: res.data.cnkd
                    });
                    if (res.data.vsty && res.data.cnkd) {
                        $("#tab_vsty").show();
                        $("#tab_cnkd").hide();
                        $("#title_tab_vsty").removeClass('active');
                        $("#title_tab_vsty").addClass('active');
                        $("#title_tab_kdnk").removeClass('active');
                    } else if (res.data.vsty && !res.data.cnkd) {
                        $("#title_tab_vsty").show();
                        $("#title_tab_kdnk").hide();
                        $("#tab_vsty").show();
                        $("#tab_cnkd").hide();
                        $("#title_tab_vsty").removeClass('active');
                        $("#title_tab_vsty").addClass('active');
                    } else if (!res.data.vsty && res.data.cnkd) {
                        $("#title_tab_kdnk").show();
                        $("#title_tab_vsty").hide();
                        $("#tab_vsty").hide();
                        $("#tab_cnkd").show();
                        $("#title_tab_kdnk").removeClass('active');
                        $("#title_tab_kdnk").addClass('active');
                    }
                    $('#modal_viewGiayPhep').modal('show');
                }
            },
            error: function (err) {
            },
            complete: function (jqXHR, textStatus) {
                $('#loading08').hide();
            }
        });
    };

    self.searchAfterHasCategory = function (page, pushState) {
        // Tim kiem va update lai page
        page = page ? page : self.paging().currentPage();
        var data = {
            "fiCompanyTaxCode": "",
            "fiHSCode": self.fiMaHoso(),
            "fiHSStatus": (self.fiTrangthai() == null || self.fiTrangthai() == undefined) ? "-1" : self.fiTrangthai(),
            "sentStartDate": self.fromFiNgaygui() ? new Date(self.fromFiNgaygui()).getTime() : null,
            "sentEndDate": self.toFiNgaygui() ? new Date(self.toFiNgaygui()).getTime() : null,
            "licenseNo": self.fiSoGiayphep(),
            "licenseStartDate": self.fromFiNgayCp() ? new Date(self.fromFiNgayCp()).getTime() : null,
            "licenseEndDate": self.toFiNgayCp() ? new Date(self.toFiNgayCp()).getTime() : null,
            "sortBy": "fiHSCreatedDate",
            "order": "desc",
            size: self.pageSize(),
            page: self.paging().currentPage()
        };
        $.ajax({
            async: true,
            type: 'POST',
            cache: false,
            crossDomain: true,
            url: app.appContext + "/mard/08/hoso/timkiem",
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            beforeSend: function (xhr) {
                xhr.setRequestHeader(CSRF_TOKEN_NAME, CSRF_TOKEN_VALUE);
                $('#loading08').show();
            },
            success: function (res) {
                if (res.success) {
                    self.mard08Items([]);
                    var list = res.data ? res.data.data : [];
                    self.mard08Items(list);
                    self.paging().update({
                        totalCount: res.data ? res.data.total : 0,
                        pageSize: self.pageSize(),
                        currentPage: page
                    });
                    self.totalCount(res.data ? res.data.total : 0);
                    if (pushState) {
                        self.pushState(data);
                    }
                }
            },
            error: function (err) {
            },
            complete: function (jqXHR, textStatus) {
                $('#loading08').hide();
                window.stateChanging = false;
            }
        });
    };

    self.requestCancelProfile = function () {
        var xinRutHoSoVM = self.xinRutHoSoVM();
        if (!xinRutHoSoVM.fiReason() && xinRutHoSoVM.fiHSStatus() != 1) {
            xinRutHoSoVM.errorMsg(ERROR_FILL_FORM);
            return;
        }
        var data = {
            "fiReason": xinRutHoSoVM.fiReason(),
            "fiHSCode": xinRutHoSoVM.fiHSCode(),
            "fiIdHS": xinRutHoSoVM.fiIdHS(),
            "fiRequestedDate": new Date(xinRutHoSoVM.fiRequestedDate()).getTime()
        }
        if (!xinRutHoSoVM.isValid()) {

            return;
        }
        xinRutHoSoVM.clearForm();
        $('#loading10').show();
        $.ajax({
            type: 'POST',
            cache: false,
            crossDomain: true,
            url: app.appContext + '/mard/08/hoso/cancel',
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            beforeSend: function (xhr) {
                xhr.setRequestHeader(CSRF_TOKEN_NAME, CSRF_TOKEN_VALUE);
            },
            success: function (res) {
                $('#loading10').hide();
                if (res.success == true || res.success == 'true') {
                    self.search(self.currentPage(), true);
                    $('#modalSuccess').modal('show');
                } else {
                    $('#modalError').modal('show');
                }
                $('#modalConfirm').modal('toggle');
                $('#modalXinRut').modal('toggle');
            },
            error: function (x, t, m) {
                $('#loading10').hide();
                $('#modalError').modal('show');
                $('#modalConfirm').modal('toggle');
            },
            complete: function (jqXHR, textStatus) {
            }
        });
    }

    self.deleteProfile = function () {
        $.ajax({
            async: true,
            type: 'GET',
            cache: false,
            crossDomain: true,
            url: app.appContext + "/mard/08/hoso/delete?fiNSWFileCode=" + self.xinXoaHoSoVM().fiHSCode() + "&fiTaxCode=" + hosoUsername,
            beforeSend: function (xhr) {
                xhr.setRequestHeader(CSRF_TOKEN_NAME, CSRF_TOKEN_VALUE);
                $('#loading08').show();
            },
            success: function (res) {
                $('#loading08').hide();
                if (res.success) {
                    app.Alert('Xóa hồ sơ thành công');
                    self.search(self.currentPage(), true);
                    $('#modalXoaHoso').modal('hide');
                } else {
                    app.Alert(res.message);
                }
            },
            error: function (err) {
            },
            complete: function (jqXHR, textStatus) {
                $('#loading08').hide();
            }
        });
    }

    self.taiMauHoSo = function(data) {
        var downloadUrl = "";
        switch (data.fiHSType) {
            case 1:
                downloadUrl = '/mard/08/hoso/download/19_dv/' + data.fiIdHS;
                break;
            case 2:
                downloadUrl = '/mard/08/hoso/download/19_spdv/' + data.fiIdHS;
                break;
            case 3:
                downloadUrl = '/mard/08/hoso/download/20/' + data.fiIdHS;
                break;
            case 4:
            case 5:
                downloadUrl = '/mard/08/hoso/download/20a/' + data.fiIdHS;
                break;
            default:
                break;
        }
        if (!downloadUrl) return;
        var link = document.createElement('a');
        link.href = downloadUrl;
        link.target = '_blank';
        document.body.appendChild(link);
        link.click();
        link.remove();
    }

    self.goEditHoSo = function (item) {
        window.location.href = app.appContext + "/mard/08/edit/" + item.fiIdHS;
        return true;
    }

    self.goYCSHoSo = function (item) {
        window.location.href = app.appContext + "/mard/08/ycs/" + item.fiIdHS;
        return true;
    }

    self.ycXinRutHoSo = function (item) {
        self.xinRutHoSoVM(new XinRutHoSoVM(item));
        $('#modalXinRut').modal('show');
    }

    self.xoaHoso = function (item) {
        self.xinXoaHoSoVM(new XinXoaHoSoVM(item.fiHSCode));
        $('#modalXoaHoso').modal('show');
    }

    /**
     * Đưa dữ liệu vào state
     * @param {type} data
     * @returns {undefined}
     */
    self.pushState = function (data) {
        if (data.fromFiNgaytao) {
            data.fromFiNgaytao = data.fromFiNgaytao.getTime();
        }
        if (data.toFiNgaytao) {
            data.toFiNgaytao = data.toFiNgaytao.getTime();
        }
        delete data.start;
        window.stateChangeIsLocal = true;
        History.pushState(data, document.title, "?" + app.serializeQuerystring(data));
    };

    self.bXemLichSuClick = function (item, e) {
        self.lichsuXuly().show(item.fiHSCode);

        return false;
    };
}

function GiayPhepVM(options) {
    var gpVMSelf = this;
    gpVMSelf.companyName = "";

    gpVMSelf.vsty = ko.observable((options && options.hasOwnProperty('vsty')) ? options.vsty : null);
    gpVMSelf.cnkd = ko.observable((options && options.hasOwnProperty('cnkd')) ? options.cnkd : null);

    gpVMSelf.update = function (data) {
        var re = new RegExp('\n', 'g');
        if (data.vsty) {
            data.vsty.fiContent = data.vsty.fiContent.replace(re, '<br>')
            var fiRecipient = data.vsty.fiRecipient ? data.vsty.fiRecipient : "";
            fiRecipient = fiRecipient.replace(';#', '<br>');
            data.vsty.fiRecipient = fiRecipient;
        }

        if (data.cnkd) {
            data.cnkd.fiContent = data.cnkd.fiContent.replace(re, '<br>')
            var fiRecipient = data.cnkd.fiRecipient ? data.cnkd.fiRecipient : "";
            fiRecipient = fiRecipient.replace(';#', '<br>');
            data.cnkd.fiRecipient = fiRecipient;
        }
        gpVMSelf.vsty(data.vsty ? data.vsty : null);
        gpVMSelf.cnkd(data.cnkd ? data.cnkd : null);
    }

    gpVMSelf.taiGiayPhep = function (data, type) {
        if (type == 'vsty') {
            var link = document.createElement('a');
            link.href = '/mard/08/gcn/download/vsty/' + gpVMSelf.vsty().fiHSCode;
            link.target = '_blank';
            document.body.appendChild(link);
            link.click();
            link.remove();
        } else if (type == 'kdnk') {
            var link = document.createElement('a');
            link.href = '/mard/08/gcn/download/cnkd/' + gpVMSelf.cnkd().fiHSCode;
            link.target = '_blank';
            document.body.appendChild(link);
            link.click();
            link.remove();
        }
    }
}

function XinRutHoSoVM(item) {
    xinRutHoSoVMSelf = this;
    xinRutHoSoVMSelf.fiHSStatus = ko.observable(item.fiHSStatus);
    xinRutHoSoVMSelf.fiHSCode = ko.observable(item.fiHSCode);
    xinRutHoSoVMSelf.fiRequestedDate = ko.observable(new Date());
    xinRutHoSoVMSelf.fiReason = ko.observable(null).extend({
        required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
    });
    xinRutHoSoVMSelf.fiIdHS = ko.observable(item.fiIdHS);
    xinRutHoSoVMSelf.errorMsg = ko.observable('');

    xinRutHoSoVMSelf.isValid = function() {
        var errors = ko.validation.group({
            fiReason: xinRutHoSoVMSelf.fiReason
        }, { deep: true });
        return errors.length === 0;
    };

    xinRutHoSoVMSelf.clearForm = function () {
        xinRutHoSoVMSelf.errorMsg('')
    };

    xinRutHoSoVMSelf.sendRequestDeleteProfile = function () {
    }
}

function XinXoaHoSoVM(hsCode) {
    xinXoaHoSoVMSelf = this;
    xinXoaHoSoVMSelf.fiHSCode = ko.observable(hsCode);
}



function searchHoSoClick() {

}

$(document).ready(function () {
    $.fn.select2.defaults.set("theme", "bootstrap");
    $(".select2").select2({placeholder: '-- Tất cả --', width: '100%', allowClear: true});

    var vm = new Mard08VM();
    ko.applyBindings(vm, document.getElementById('mard08'));
    vm.applyState();
    vm.search(1, true)

    $("#title_tab_vsty").click(function (e) {
        $("#tab_vsty").show();
        $("#tab_cnkd").hide();
    });
    $("#title_tab_kdnk").click(function (e) {
        $("#tab_cnkd").show();
        $("#tab_vsty").hide();
    })
});
