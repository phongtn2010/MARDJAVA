function Mard25EditVM () {
    var editVMSefl = this;
    editVMSefl.kdnkVM = ko.observable(null);
    editVMSefl.isEditable = ko.observable(true)
    editVMSefl.applyState = function (options) {
        options["isEditHS"]="1";
        if (isCopy) {
            options["fiIdHS"]=null;
            options["fiNSWFileCode"]=null;
            options["fiSoXacNhanDon"]=null;
            for (var i =0;i<options.fiProductList.length;i++){
                options.fiProductList[i].fiIdHS=null;
                options.fiProductList[i].fiIdProduct=null;
                options.fiProductList[i].fiTrangThaiHangHoa=null;
                var getLstCL = options.fiProductList[i].fiProCLList;
                var getLstAT = options.fiProductList[i].fiProATList;
                var getLstSLKL = options.fiProductList[i].fiProSLKLList;
                for (var j =0;j<getLstCL.length;j++){
                    getLstCL[j].fiIdProduct=null;
                    getLstCL[j].fiIdProCL=null;
                }
                for (var j =0;j<getLstAT.length;j++){
                    getLstAT[j].fiIdProduct=null;
                    getLstAT[j].fiIdProAT=null;
                }
                for (var j =0;j<getLstSLKL.length;j++){
                    getLstSLKL[j].fiIdProduct=null;
                    getLstSLKL[j].fiIdProSLKL=null;
                }
            }
            for (var i =0;i<options.fiAttachmentList.length;i++){
                options.fiAttachmentList[i].fiIdHS=null;
                options.fiAttachmentList[i].fiIdDinhkem=null;
            }
        }
        editVMSefl.kdnkVM(new HangHoaNhapKhauVM(options));
    }
    editVMSefl.saveRegProfile = function () {
        if (!editVMSefl.kdnkVM().validateFormDangKy()){
            return;
        }
        if (!editVMSefl.kdnkVM().validateAttachment()){
            return;
        }
        var body = editVMSefl.kdnkVM().getData();
        // return;
        if (!body) return;
        editVMSefl.pop = app.popup({
            title: 'Thông báo',
            html: '<b>Bạn chắc chắn muốn lưu hồ sơ?</b>',
            width: 450,
            buttons: [
                {
                    name: NSWLang["common_button_toi_chac_chan"],
                    class: 'btn',
                    icon: 'fa-save',
                    action: function () {
                        app.popupRemove(editVMSefl.pop.selector);
                        app.makePost({
                            url: '/mard/25/hoso/create',
                            data: JSON.stringify(body),
                            success: function (d) {
                                if (d && d.success) {
                                    app.Alert('Lưu hồ sơ thành công');
                                    window.location.href = app.appContext + '/mard/25/';
                                } else {
                                    app.Alert(d.message);
                                }
                            },
                            error: function (e) {
                                if(e.hasOwnProperty('message')) {
                                    app.Alert(e.message);
                                } else {
                                    if (e.status === 403 || (e.hasOwnProperty('responseText') && e.responseText.includes('<meta charset="utf-8" />'))) {
                                        app.Alert('Phiên làm việc hết hạn, vui lòng đăng nhập lại!');
                                    } else {
                                        app.Alert('Không lưu được hồ sơ');
                                    }

                                }
                            }
                        });
                    }
                },
                {
                    name: 'Huỷ',
                    class: 'btn',
                    icon: 'fa-close',
                    action: function () {
                        app.popupRemove(editVMSefl.pop.selector);
                    }
                }
            ]
        });
    }

    editVMSefl.sendRegProfile = function () {
        if (!editVMSefl.kdnkVM().validateFormDangKy()){
            return;
        }
        if (!editVMSefl.kdnkVM().validateAttachment()){
            return;
        }
        var body = editVMSefl.kdnkVM().getData();
        // return;
        if (!body) return;
        // editVMSefl.verifySignature = function (signature, doc) {
        //
        //     var data = {
        //         'signatureXml': signature,
        //         'messageXml': doc.sign.fiXml,
        //         'msgFunc': doc.sign.fiFunc,
        //         'msgType': doc.sign.fiMsgType,
        //         'documentCode': doc.data.fiMaHoso,
        //         'ministryCode': 'MARD',
        //         'proceduceCode': '25'
        //     };
        //     app.makePost({
        //             url: '/mard/25/verify',
        //             data: JSON.stringify(data),
        //             success: function (d) {
        //             app.makePost({
        //                 url: '/mard/25/hoso/guihoso',
        //                 data: JSON.stringify(doc.data),
        //                 success: function (d) {
        //                     app.Alert('Gửi hồ sơ thành công');
        //                     setTimeout(function () {
        //                         History.go(-1);
        //                     }, 1500);
        //                 },
        //                 error: function (e) {
        //                     if(e.hasOwnProperty('message')) {
        //                         app.Alert(e.message);
        //                     } else {
        //                         if (e.status === 403 || (e.hasOwnProperty('responseText') && e.responseText.includes('<meta charset="utf-8" />'))) {
        //                             app.Alert('Phiên làm việc hết hạn, vui lòng đăng nhập lại!');
        //                         } else {
        //                             app.Alert('Không gửi được hồ sơ');
        //                         }
        //
        //                     }
        //                 }
        //             });
        //         }
        //     });
        // };

        editVMSefl.pop = app.popup({
            title: 'Thông báo',
            html: '<b>Bạn chắc chắn muốn gửi hồ sơ?</b>',
            width: 450,
            buttons: [
                {
                    name: NSWLang["common_button_toi_chac_chan"],
                    class: 'btn',
                    icon: 'fa-save',
                    action: function () {
                        app.popupRemove(editVMSefl.pop.selector);
                        app.makePost({
                            url: '/mard/25/hoso/send',
                            data: JSON.stringify(body),
                            success: function (d) {
                                // if (!app.requireSigning) {
                                    if (d && d.success) {
                                        app.Alert('Gửi hồ sơ thành công');
                                        setTimeout(function () {
                                            window.location.href = app.appContext + '/mard/25/';
                                        }, 1500);
                                    } else {
                                        app.Alert(d.message);
                                    }
                                // } else {
                                //     var result = d.sign;
                                //     var onSuccess = function (res) {
                                //         if (res.status == 'ok') {
                                //             editVMSefl.verifySignature(res.outputData, d);
                                //         } else {
                                //             app.Alert('Ký số không thành công, vui lòng thử lại.');
                                //         }
                                //     };
                                //     var onFailed = function (e) {
                                //         app.Alert('Ký số không thành công, vui lòng thử lại.');
                                //     };
                                //
                                //     RTVNSignClient.ping(function(res){
                                //         RTVNSignClient.create64("xml", result.fiHashEncode, onSuccess, onFailed);
                                //     }, function(e){
                                //         app.Alert('Bạn chưa cài hoặc chưa mở phần mềm ký số, vui lòng vào trang chủ để tải về và cài đặt theo hướng dẫn.');
                                //     });
                                // }
                            },
                            error: function (e) {
                                if(e.hasOwnProperty('message')) {
                                    app.Alert(e.message);
                                } else {
                                    if (e.status === 403 || (e.hasOwnProperty('responseText') && e.responseText.includes('<meta charset="utf-8" />'))) {
                                        app.Alert('Phiên làm việc hết hạn, vui lòng đăng nhập lại!');
                                    } else {
                                        app.Alert('Không gửi được hồ sơ');
                                    }

                                }
                            }
                        });
                    }
                },
                {
                    name: 'Huỷ',
                    class: 'btn',
                    icon: 'fa-close',
                    action: function () {
                        app.popupRemove(editVMSefl.pop.selector);
                    }
                }
            ]
        });
    }

    editVMSefl.btnBack = function () {
        History.go(-1);
    }
    editVMSefl.goIndexPage = function () {
        window.location.href = app.appContext + "/mard/25/";
    }
}

function init(options) {
    var mard25EditVM = new Mard25EditVM();
    ko.applyBindings(mard25EditVM, document.getElementById('mard25Edit'));
    mard25EditVM.applyState(options);
}
function getThongTinHoSo(callback) {
    $('#loading08').show();
    $.ajax({
        async: true,
        type: 'GET',
        cache: false,
        crossDomain: true,
        url: app.appContext + '/mard/25/hoso/find' + "?idHoSo=" + idHoSo,
        beforeSend: function (xhr) {
            xhr.setRequestHeader(CSRF_TOKEN_NAME, CSRF_TOKEN_VALUE);
        },
        success: function (res) {
            callback(res);
            $('#loading08').hide();
        },
        error: function (x, t, m) {
            $('#loading08').hide();
        },
    })
}
$(document).ready(function () {
    var options = {};
    getThongTinHoSo(function (data) {
        options=data.data;
        $('#loading10').show();
        $.when(
            // Get list country
            app.sendGetRequest("/mard/25/danhmuc/quocgia", function (res) {
                options['lstCountry'] = res.data;
            }),
            // Get list province
            app.sendGetRequest("/mard/25/danhmuc/tinhthanh", function (res) {
                options['lstProvince'] = res.data;
            }),
            // Get list port
            app.sendGetRequest("/mard/25/danhmuc/cuakhau?countryCode=VN", function (res) {
                options['lstPort'] = res.data;
            }),
            // Get UOMs
            app.sendGetRequest("/mard/25/danhmuc/unit?unitTypeId=4&systemId=6", function (res) {
                options['lstUOMAnimal'] = res.data;
            }),
            // Get profile status
            app.sendGetRequest("/mard/25/danhmuc/getby-catno/1", function (res) {
                options['lstNhom'] = res.data;
                options['lstPhanNhom'] = res.data;
                options['lstPhanLoai'] = res.data;
                options['lstLoai'] = res.data;
            })
            ,
            app.sendGetRequest("/mard/25/danhmuc/getby-catno/11", function (res) {
                options['lstAtchType'] = res.data;
            })
            ,
            app.sendGetRequest("/mard/25/danhmuc/getby-catno/12", function (res) {
                options['lstLoaiHoSoDangKy'] = res.data;
            }),
            app.sendGetRequest("/mard/25/danhmuc/getby-catno/25", function (res) {
                options['lstProfileStatus'] = res.data;
            }),
            app.sendGetRequest("/mard/25/danhmuc/getby-catno/2", function (res) {
                options['lstHoSoType'] = res.data;
            }),
            // Get danh muc tien te
            app.sendGetRequest("/mard/25/danhmuc/getby-catno/26", function (res) {
                options['lstLoaiTienTe'] = res.data;
            }),//danh muc loai file dinh kem khac
            app.sendGetRequest("/mard/25/danhmuc/getby-catno/12", function (res) {
                options['lstLoaiFileDinhKemKhac'] = res.data;
            }),
            // Get danh muc dvt
            app.sendGetRequest("/mard/25/danhmuc/getby-catno/10", function (res) {
                options['lstDMDVT'] = res.data;
            }),
            // Get danh muc dvt
            app.sendGetRequest("/mard/25/danhmuc/getby-catno/3", function (res) {
                options['lstChiTieuAT'] = res.data;
            }),
            // Get danh muc dvt
            app.sendGetRequest("/mard/25/danhmuc/getby-catno/7", function (res) {
                options['lstDMDVTSL'] = res.data;
            }),
            // Get danh muc dvt
            app.sendGetRequest("/mard/25/dshosomienkiem/"+hosoUsername, function (res) {
                options['lstDSHosoMK'] = res.data;
            })
        ).done(function (data) {
            $('#loading10').hide();
            init(options);
        })
    })
})
