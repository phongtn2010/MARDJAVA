/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var addController = function () {};
addController.prototype = {
    ministryCode: 'moh',
    code: 'typea',
    templates: ["themthietbi", "quanhuyen"],
    pagination: {
        isReady: false,
        currentPage: 1,
        pageSize: 10
    },
    thietBi: null,
    nopphi: null,
    dinhKem: null,
    container: null,
    dialog: null,
    isView: null,
    countryList: [],
    init: function (obj) {
        var self = this;
        var op = $.extend(true, {}, obj);
        this.container = '#' + op.container;
        this.dialog = op.uploadDialog;
        this.countryList = op.countries;
        $('.date-picker').datepicker({rtl: false, orientation: "left", autoclose: true, dateFormat: 'dd/mm/yy'});

        this.isView = op.isView;
        if (this.thietBi === null) {
            this.thietBi = new addEquipController();
            this.thietBi.init({container: 'baohanh-container',
                data: {
                    dialog: this.dialog,
                    data: op.data.thietBi,
                    baoHanh: op.data.listOfTbdbaohanh
                }
            });
        }

        if (this.nopphi === null) {
            this.nopphi = new nopPhiController();
            this.nopphi.init({container: 'nopphi-container',
                data: op.data.listOfTbdthanhtoan,
                dialog: this.dialog,
                isView: op.isView
            });
        }

        if (this.dinhKem === null) {
            this.dinhKem = new dinhKemController();
            this.dinhKem.init({container: 'listDinhKem',
                dialog: this.dialog,
                data: op.data.taptinList,
                isView: op.isView
            });
        }

        if (op.isView === "none") {
            $("#btnAddEquipment").html(NSWLang["common_button_view"]);
        }

        var ddlTinh = $("#fiMatinh");
        var ddlMaDv = $("#fiMadv");
        ddlMaDv.val(ddlMaDv.attr('data')).select2({placeholder: '', width: '100%', selectOnClose: true});

        var proCode = ddlTinh.attr('data');
        //var provinceId = $("option[value="+provinceCode+"]").attr('data');
        ddlTinh.off('change').on('change', function () {
            var me = $(this);
            var proCode = me.val();
            //find donvinhanhoso by province
            var donvi = ddlMaDv.find("option[provincecode = " + proCode + "]").val();
            ddlMaDv.val(donvi).select2({placeholder: '', width: '100%', selectOnClose: true});
            self.buildDistrictDdl(proCode);
            return false;
        });

        if (!!proCode && proCode != -1) {
            ddlTinh.val(proCode).select2({placeholder: '', width: '100%', selectOnClose: true});
            self.buildDistrictDdl(proCode);
        } else {
            ddlTinh.select2({placeholder: '', width: '100%', selectOnClose: true});
            $("#fiMaquanhuyen").select2({placeholder: '', width: '100%', selectOnClose: true});
        }
        this.registerEvents();
        ddlMaDv.change();
    },
    registerEvents: function () {
        var self = this;
        var callback = function () {
            $("#fiTentrangtb").focus();
        }
        $("#btnAddEquipment").on('click', function (e) {
            self.view(NSWLang["moh_typea_themtb_khaibaotb"], callback);
            return false;
        });
        $("#add").on('click', function (e) {
            self.view1(NSWLang["moh_typea_themtb_khaibaotb"], 1200);
            return false;
        });
        $("#btnLuu").on('click', function (e) {
            e.stopPropagation();
            e.preventDefault();
            self.save(false);
            return false;
        });
        $("#btnGui").on('click', function (e) {
            e.stopPropagation();
            e.preventDefault();
            var popup = app.popup({
                title: NSWLang["common_msg_thong_bao"],
                html: '<i class="fa fa-3x fa-warning"></i> <b>' + NSWLang["common_msg_gui_ho_so"] + '</b>',
                width: 400,
                buttons: [
                    {
                        name: NSWLang["common_button_toi_chac_chan"],
                        class: 'btn',
                        icon: 'fa-check',
                        action: function () {
                            app.popupRemove(popup.selector, function () {
                                self.save(true);
                            });
                        }
                    }
                ]
            });
            return false;
        });
        window.addEventListener('message', function (event) {
            var loaiTapTin;
            var tenLoaiTapTin;
            var data = JSON.parse(event.data);
            if (data.frameId == "frame1") {
                var loaiTapTin = self.dinhKem.uploadInfor.maTaiLieu;
                var tenLoaiTapTin = self.dinhKem.uploadInfor.tenTaiLieu;
            } else if (data.frameId == "frame2") {
                loaiTapTin = self.thietBi.uploadInfor.maTaiLieu;
                tenLoaiTapTin = self.thietBi.uploadInfor.tenTaiLieu;
            } else if (data.frameId == "frame3") {
                loaiTapTin = self.nopphi.uploadInfor.maTaiLieu;
                tenLoaiTapTin = self.nopphi.uploadInfor.tenTaiLieu;
            }
            if (data.action == 'onUploadSuccessFromDVCTTBYTE') {
                $("#dialog").dialog("close");
                $("#fileIdLabel" + data.frameId).html('<a target="_blank" href="' + data.fileURL + '">File uploaded : ' + data.fileName + ' (id:' + data.fileId + ')</a>');
                phuluc = {fiLoai: loaiTapTin, fiTenloai: tenLoaiTapTin, fiMataptin: data.fileId, fiTentaptin: data.fileName, fiLoaiobject: "0", fiUrltaptin: data.fileURL};

                if (data.frameId == "frame1") {
                    self.dinhKem.uploadInfor = phuluc;
                    self.dinhKem.save();
                } else if (data.frameId == "frame2") {
                    self.thietBi.uploadInfor = phuluc;
                } else if (data.frameId == "frame3") {
                    self.nopphi.taptin = phuluc;
                }
            }
        });
        $("#btnTroLai").on('click', function (e) {
            e.stopPropagation();
            e.preventDefault();
            document.location = app.appContext + "/moh/06/home";
        });
        $("#list-container").on('click', '.fa-close, .fa-remove', function () {
            var me = $(this);
            var pop = app.popup({
                title: NSWLang["common_button_thong_bao"],
                html: '<b>' + NSWLang["common_msg_xoa_ho_so"] + '</b>',
                width: 400,
                height: 100,
                buttons: [
                    {
                        name: NSWLang["common_button_toi_chac_chan"],
                        class: 'btn',
                        icon: 'fa-check',
                        action: function () {
                            me.parents("tr").remove();
                            self.thietBi.list.pop();
                            self.thietBi.baohanh = [];
                            self.thietBi.baohanhClone = [];
                            app.popupRemove(pop.selector);
                        }
                    }
                ]
            });
        });
        $("#fiMadv").on('change', function () { //fill province by donvinhanhoso
            provinceCode = $(this).find('option:selected').attr('provincecode');
            $("#fiMatinh").val(provinceCode).select2({placeholder: '', width: '100%', selectOnClose: true});
            self.buildDistrictDdl(provinceCode);
            var madv = $(this).val();
            app.makePost({
                url: "/moh/01/dvnhanhs",
                data: JSON.stringify({fiContent: madv}),
                success: function (d) {
                    self.nopphi.showPaymentInfo(d.data ? (data.data.fiSotaikhoan ? data.data.fiSotaikhoan : '') : '');
                }
            });
        });
    },
    view: function (title, callback) {
        var self = this;
        var param = {
            thietbi: self.thietBi.list,
            baohanh: self.thietBi.baohanh,
            countries: self.countryList,
            isView: self.isView
        };

        var callback = function (html) {
            var popup = app.popup({
                title: "<span class='caption-subject bold uppercase' style='font-size:20px'>" + title + "</span>",
                html: html,
                width: 1200,
                height: 450,
                buttons: [
                    {
                        name: NSWLang["common_button_dong"],
                        class: 'btn fa-lg',
                        icon: 'fa-close',
                        action: function () {
                            app.popupRemove(popup.selector);
                        }
                    }
                ]
            });

            self.thietBi.registerEvents();
            self.thietBi.bindGridEvent();
            self.thietBi.changeDropdown();
            if (self.thietBi.list.length > 0) {
                if (self.thietBi.list[0].fiNhomtb == 0) {
                    $("#baohanhlist").hide();
                }
                if (self.thietBi.list[0].fiPhannhom == 0 & self.thietBi.list[0].fiNhieucssx == 0) {
                    $(".condition").hide();
                }
                $("#giaithich").hide();
                $("#form-draftTB input").attr("readonly", "readonly");
                $("#form-draftTB select").select2('enable', false);
                $("#form-draftTB select").attr("disable", "true");
                $("#bhForm input").attr("readonly", "readonly");
                $(".action").remove();
            } else {
                $("#addEquip").show();
                $("#huyTB").show();
            }
            setTimeout(function () {
                $("#fiTentrangtb").focus();
            }, 1000);
//             $("#fiTentrangtb").focus();
        };
        app.complieTemplate({
            ministryCode: self.ministryCode,
            code: self.code,
            templateName: self.templates[0],
            data: param
            ,
        }, callback);
    },
    save: function (send) {
        var self = this;
        var thietbi = self.thietBi.list[0];
        if (self.isVaid(send)) {
            var tthoso = app.form2Object("#form-tths");
            var tenTinh = $("#fiMatinh :selected").html();
            var tenQuanhuyen = $("#fiMaquanhuyen :selected").html();
            var tenDonVi = $("#fiMadv :selected").html();
            tthoso.fiTentinh = tenTinh;
            tthoso.fiTenquanhuyen = tenQuanhuyen;
            tthoso.fiTendv = tenDonVi;
            var nopphi = self.nopphi.list;
            var baohanh = self.thietBi.baohanh;

            if (!tthoso.fiIdHoso) {
                tthoso.fiIdHoso = "0";
            }
            tthoso.thietBi = thietbi;
            tthoso.listOfTbdbaohanh = baohanh;
            tthoso.listOfTbdthanhtoan = nopphi;
            tthoso.taptinList = self.dinhKem.list;

            var url = "/moh/01/save";
            if (send) {
                url = "/moh/01/send";
                if (app.requireSigning) {
                    url = '/moh/01/xml';
                }
            }

            var announce = function (message, funct) {
                app.toast({
                    title: NSWLang["common_msg_thong_bao"],
                    message: message,
                    function: funct
                });
            };

            var afterSigning = function (xml) {
                action = '/moh/01/sendwithsignature';
                var id = $('#fiIdhoso').attr('value');
                if (id === '') {
                    $('#fiIdHoso').attr('value', 0);
                    id = 0;
                }
                app.makePost({
                    url: action,
                    data: JSON.stringify({fiIdHoso: id, signedXml: xml}),
                    success: function (d) {
                        if (d.success) {
                            announce(NSWLang["common_msg_sendsuccess"], 'success');
                            setTimeout(function () {
                                document.location = app.appContext + "/moh/06/home";
                            }, 2000);
                        } else {
                            onFail(d);
                        }
                    },
                    error: function (e) {
                        onFail(e);
                    }
                });
            };

            var onFail = function (d) {
                var message = NSWLang["common_msg_he_thong_chua_san_sang"]
//                if (d.message != null) {
//                    message = d.message;
//                }
                announce(message, 'error');
            }
            var send = send;
            app.makePost({
                url: url,
                data: JSON.stringify(tthoso),
                success: function (d) {
                    if (send) {
                        if (app.requireSigning) {
                            var xmlContent = d.xmlData;
//                            CASigner.sign(xmlContent, '', afterSigning);
                            //afterSigning(xmlContent);
                        } else {
                            announce(NSWLang["common_msg_sendsuccess"], 'success');
                            setTimeout(function () {
                                document.location = app.appContext + "/moh/06/home";
                            }, 1500);
                        }
                    } else {
                        announce(NSWLang["common_msg_cap_nhat_du_lieu_thanh_cong"], 'success');
                        $("#fiIdhoso").val(d.data.fiIdhoso);
                        $("#fiMaHoso").val(d.data.fiMaHoso);
                        setTimeout(function () {
                            document.location = app.appContext + "/moh/06/home";
                        }, 1500);
                    }

                },
                error: function (d) {
                    if (send) {
                        if (d.data != null && !!d.data.fiIdHoso) {
                            $("#fiIdHoso").val(d.data.fiIdHoso);
                            if ($('#fiMaHoso').length != 0) {
                                $("#form-tths").append('<input type="hidden" id="fiMaHoso" name="fiMaHoso" value="' + d.data.fiMaHoso + '"/>');
                                $("#form-tths").append('<input type="hidden" id="fiTrangthai" name="fiTrangthai" value="' + d.data.fiTrangthai + '"/>');
                                $("#form-tths").append('<input type="hidden" id="fiTentrangthai" name="fiTentrangthai" value="' + d.data.fiTentrangthai + '"/>');
                            }
                        }
                        onFail(d);
                    } else {
                        announce(NSWLang["moh_06_common_eror_luuhosothatbai"], 'error');
                    }
                }
            });
        } else {
            $("#btnGui").show();
            $("#btnLuu").show();
        }
    },
    buildDistrictDdl: function (proCode) {
        var self = this;
        var cb = function (html) {
            var ddlQuanHuyen = $("#fiMaquanhuyen");
            var dataId = ddlQuanHuyen.attr('data');
            ddlQuanHuyen.html(html);

            if (parseInt(dataId) > 0) {
                ddlQuanHuyen.val(dataId).select2({placeholder: '', width: '100%', selectOnClose: true});
            } else {
                ddlQuanHuyen.select2({placeholder: '', width: '100%', selectOnClose: true});
            }
        };
        app.makePost({
            url: "/moh/01/district/" + proCode,
            success: function (d) {
                app.complieTemplate({
                    ministryCode: self.ministryCode,
                    code: self.code,
                    templateName: self.templates[1],
                    data: d.data
                }, cb);
            }
        });
    },
    isVaid: function (send) {
        var isSuccess = true;

        var isSuccess = app.isFormVaild('form-tths');
        if (!isSuccess) {
            return isSuccess;
        }

        isSuccess = this.thietBi.isVaild();
        if (!isSuccess) {
            return isSuccess;
        }

        isSuccess = this.dinhKem.isVaild(send);
        if (!isSuccess) {
            return isSuccess;
        }
        if (send) {
            if (this.nopphi.list.length === 0) {
                isSuccess = this.nopphi.list.length > 0;
                app.AlertWithBtn(NSWLang['moh_06_xac_nhan_nop_phi'] + ' ' + NSWLang["common_msg_chua_nhap"]);
                return isSuccess;
            }
        }
        return isSuccess;
    },
};
