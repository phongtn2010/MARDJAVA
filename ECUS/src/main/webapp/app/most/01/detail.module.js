/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var DetailController = function () {
};
DetailController.prototype = {
    ministryCode: 'most',
    code: '01',
    templates: [],
    toKhai: null,
    hangHoa: null,
    hopDong: null,
    vanDon: null,
    hoaDon: null,
    dmHangHoa: null,
    gcnTaiLieu: null,
    taiLieuKhac: null,
    /*
     * 1: Hop dong
     * 2: Van don
     * 3: Danh muc hang hoa
     * 4: Hoa don
     * 5: GCN
     */
    fileType: [1, 2, 3, 4, 5, 6],
    init: function (obj) {
        var self = this;
        var op = $.extend(true, {}, obj);

        this.loadTemplates();

        var formContainer = $('#form-ddk');
        var cbfiIdTckt = formContainer.find('#fiMaTckt'),
            cbfiIdTcdg = formContainer.find('#fiMaTcdg'),
            cbfiMaQcvn = formContainer.find('#fiMaQcvn');

        $('#lb-qcvn-name').hide();
        $('#lb-qcvn-valname').hide();
        var fiTrangThai = $('#fiTrangThai').attr('value');
        if (fiTrangThai === "0") {
            $('#pnl-import').show();
        }

        cbfiIdTckt.val(cbfiIdTckt.attr('data')).select2({placeholder: '', width: '100%'});
        cbfiIdTcdg.val(cbfiIdTcdg.attr('data')).select2({placeholder: '', width: '100%'});
        cbfiMaQcvn.val(cbfiMaQcvn.attr('data')).select2({placeholder: '', width: '100%'});

        cbfiIdTckt.change(function () {
            $('#fiTenTcht').attr('value', $(this).find("option:selected").text());
        });
        cbfiIdTcdg.change(function () {
            $('#fiTenTcdg').attr('value', $(this).find("option:selected").text());
        });

        if (obj.fiMaQcvn === '8') {
            $('#lb-qcvn-name').show();
            $('#lb-qcvn-valname').show();
            $('#fiTenQcvn').val(obj.fiTenQcvn);
        }

        cbfiMaQcvn.change(function () {
            if ($(this).val() === '8') {
                $('#lb-qcvn-name').show();
                $('#lb-qcvn-valname').show();
                $('#fiTenQcvn').val('').focus();
            } else {
                $('#fiTenQcvn').attr('value', $(this).find("option:selected").text());
                $('#lb-qcvn-name').hide();
                $('#lb-qcvn-valname').hide();
            }
        });

        formContainer.find('.date-picker').datepicker({rtl: false, orientation: "left", autoclose: true});
        formContainer.find('#fiDtNnk').focus();
        if (op.tepDinhKem !== null) {
            var totalFileSize = 0;
            for (var i = 0, len = op.tepDinhKem.length; i < len; i++) {
                totalFileSize += op.tepDinhKem[i].fiFileSize;
            }

            $('#fiTotalFileSize').attr('value', totalFileSize);
        }

        if (this.toKhai === null) {
            this.toKhai = new ToKhaiController();
            this.toKhai.init({container: 'tokhai-container', toKhaiHQ: op.toKhaiHQ, IsView: op.IsView});
        }

        if (this.hangHoa === null) {
            this.hangHoa = new HangHoaController();
            this.hangHoa.init({
                container: 'hanghoa-container',
                hangHoa1: op.hangHoa1,
                pager: 'hanghoa-pager',
                IsView: op.IsView
            });
        }

        if (this.hopDong === null) {
            this.hopDong = new HopDongController();

            this.hopDong.init({
                containerId: 'hopdong-container',
                templateName: 'hopdong-danhsach',
                fileType: self.fileType[0],
                data: op.tepDinhKem !== null ? op.tepDinhKem.getArray('fiMaLoai', self.fileType[0]) : [],
                IsView: op.IsView
            });
        }

        if (this.vanDon === null) {
            this.vanDon = new VanDonController();
            this.vanDon.init({
                containerId: 'vandon-container',
                templateName: 'vandon-danhsach',
                fileType: self.fileType[1],
                data: op.tepDinhKem !== null ? op.tepDinhKem.getArray('fiMaLoai', self.fileType[1]) : [],
                IsView: op.IsView
            });
        }

        if (this.dmHangHoa === null) {
            this.dmHangHoa = new DMHangHoaController();
            this.dmHangHoa.init({
                containerId: 'dmhanghoa-container',
                templateName: 'dmhanghoa-danhsach',
                fileType: self.fileType[2],
                data: op.tepDinhKem !== null ? op.tepDinhKem.getArray('fiMaLoai', self.fileType[2]) : [],
                IsView: op.IsView
            });
        }

        if (this.hoaDon === null) {
            this.hoaDon = new HoaDonController();
            this.hoaDon.init({
                containerId: 'hoadon-container',
                templateName: 'hoadon-danhsach',
                fileType: self.fileType[3],
                data: op.tepDinhKem !== null ? op.tepDinhKem.getArray('fiMaLoai', self.fileType[3]) : [],
                IsView: op.IsView
            });
        }

        if (this.gcnTaiLieu === null) {
            this.gcnTaiLieu = new GCNController();
            this.gcnTaiLieu.init({
                containerId: 'gcn-container',
                templateName: 'gcn-danhsach',
                fileType: self.fileType[4],
                data: op.tepDinhKem !== null ? op.tepDinhKem.getArray('fiMaLoaiTaiLieu', self.fileType[4]) : [],
                IsView: op.IsView
            });
        }

        if (this.taiLieuKhac === null) {
            this.taiLieuKhac = new TLKController();
            this.taiLieuKhac.init({
                containerId: 'tlk-container',
                templateName: 'tlk-danhsach',
                fileType: self.fileType[5],
                data: op.tepDinhKem !== null ? op.tepDinhKem.getArray('fiMaLoaiTaiLieu', self.fileType[5]) : [],
                IsView: op.IsView
            });
        }
        this.registerEvents();
    },
    setData: function (obj) {
        var op = $.extend(true, {}, obj);
        var formContainer = $('#form-ddk');

        var cbfiIdTckt = formContainer.find('#fiMaTckt'),
            cbfiIdTcdg = formContainer.find('#fiMaTcdg'),
            cbfiMaQcvn = formContainer.find('#fiMaQcvn');

        //formContainer.find('#fiNguoiNk').val(obj.fiNguoiNk);
        //formContainer.find('#fiDiachiNnk').val(obj.fiDiachiNnk);
        formContainer.find('#fiDtNnk').val(obj.fiDtNnk);
        formContainer.find('#fiFaxNnk').val(obj.fiFaxNnk);
        formContainer.find('#fiNguoiLh').val(obj.fiNguoiLh);
        formContainer.find('#fiEmailNnk').val(obj.fiEmailNnk);
        formContainer.find('#fiDiachiKho').val(obj.fiDiachiKho);
        formContainer.find('#fiEmailNnk').val(obj.fiEmailNnk);
        formContainer.find('#fiGhichu').val(obj.fiGhichu);

        obj.fiTuNgay = Util.convertToDateTime(obj.fiTuNgay, false);
        obj.fiDenNgay = Util.convertToDateTime(obj.fiDenNgay, false);

        formContainer.find('#fiTuNgay').val(obj.fiTuNgay);
        formContainer.find('#fiDenNgay').val(obj.fiDenNgay);

        cbfiIdTckt.attr('data', obj.fiMaTckt);
        cbfiIdTcdg.attr('data', obj.fiMaTcdg);
        cbfiMaQcvn.attr('data', obj.fiMaQcvn);

        formContainer.find('#fiTenTcdg').attr('value', obj.fiTenTcdg);
        formContainer.find('#fiTenTcht').attr('value', obj.fiTenTcht);
        formContainer.find('#fiTrangThai').attr('value', obj.fiTrangThai);

        cbfiIdTckt.val(cbfiIdTckt.attr('data')).select2({placeholder: '', width: 435});
        cbfiIdTcdg.val(cbfiIdTcdg.attr('data')).select2({placeholder: '', width: 435});
        cbfiMaQcvn.val(cbfiMaQcvn.attr('data')).select2({placeholder: '', width: 435});

        if (obj.fiMaQcvn === '8') {
            $('#lb-qcvn-name').show();
            $('#lb-qcvn-valname').show();
            $('#fiTenQcvn').val(obj.fiTenQcvn);
        }

        if (this.toKhai === null) {
            this.toKhai = new ToKhaiController();
        }
        if (this.hangHoa === null) {
            this.hangHoa = new HangHoaController();
        }

        this.toKhai.setData({toKhaiHQ: op.toKhaiHQ});
        this.hangHoa.setData({hangHoa1: op.hangHoa1, pager: 'hanghoa-pager'});
        this.hopDong.setData({data: op.tepDinhKem !== null ? op.tepDinhKem.getArray('fiMaLoai', this.fileType[0]) : []});
        this.hoaDon.setData({data: op.tepDinhKem !== null ? op.tepDinhKem.getArray('fiMaLoai', this.fileType[2]) : []});
        this.vanDon.setData({data: op.tepDinhKem !== null ? op.tepDinhKem.getArray('fiMaLoai', this.fileType[1]) : []});
        this.dmHangHoa.setData({data: op.tepDinhKem !== null ? op.tepDinhKem.getArray('fiMaLoai', this.fileType[3]) : []});
    },
    loadTemplates: function () {
        var count = this.templates.length;
        if (count <= 0)
            return;

        for (var i = 0; i < count; i++) {
            app.getTemplate({
                ministryCode: this.ministryCode,
                code: this.code,
                templateName: this.templates[i]
            }, null);
        }
    },
    isVaid: function () {
        var isSuccess = false;

        if ($('#fiMaQcvn').val() === '8') {
            if ($('#fiTenQcvn').val() === '') {
                app.Alert(NSWLang['common_ten_quy_chuan_viet_nam'] + ' ' + NSWLang["common_msg_chua_nhap"]);
                $('#fiTenQcvn').focus();
                return isSuccess;
            }
        }

        /*isSuccess = this.toKhai.isVaild();
        if (!isSuccess) {
            return isSuccess;
        }*/

        isSuccess = this.hangHoa.isVaild();
        if (!isSuccess) {
            return isSuccess;
        }

        isSuccess = this.hangHoa.isFullLicense();
        var tccnVal = $('#fiMaTcdg').val();
        var fiTrangThai = $('#fiTrangThai').attr('value');

        if (isSuccess) {
            if (tccnVal !== '-1' && tccnVal !== '' && tccnVal !== null) {
                app.Alert(NSWLang["most_01_msg_khongcantccn"]);
                isSuccess = false;
                return isSuccess;
            }
        } else {
            if (fiTrangThai === "0" || fiTrangThai === "1" || typeof (fiTrangThai) == 'undefined') {
                if (tccnVal === '-1' || tccnVal === '' || tccnVal === null) {
                    app.Alert(NSWLang["most_01_msg_phaichontccn"]);
                    isSuccess = false;
                    return isSuccess;
                }
            }
        }

        isSuccess = this.dmHangHoa.isVaild();
        if (!isSuccess) {
            return isSuccess;
        }

        //Neu co hang hoa duoc lua chon la co giay chung nhan thi moi kiem tra
        if (this.hangHoa.checkProductLisence()) {
            isSuccess = this.gcnTaiLieu.isVaild();
            if (!isSuccess) {
                return isSuccess;
            }
        }

        return isSuccess;
    },
    save: function (send) {
        var self = this;
        //Kiem tra thong tin don
        var isOk = app.isFormVaild('form-ddk');
        if (!isOk) {
            $("#btnGui").show();
            return;
        }

        isOk = self.validateDateOnForm('fiTuNgay', 'fiDenNgay');
        if (!isOk) {
            $("#btnGui").show();
            return;
        }

        //Kiem tra cac thong tin khac    
        isOk = self.isVaid();
        if (!isOk) {
            $("#btnGui").show();
            return;
        }

        var registration = app.form2Object('#form-ddk');

        var id = $('#fiIdHoso').attr('value');
        if (id === '') {
            $('#fiIdHoso').attr('value', 0);
            id = 0;
        }

        registration.toKhaiHQ = self.toKhai.List;
        registration.hangHoa1 = self.hangHoa.List;
        registration.tepDinhKem = self.hopDong.list.concat(self.vanDon.list, self.hoaDon.list,
            self.dmHangHoa.list, self.gcnTaiLieu.list, self.taiLieuKhac.list);

        var action = '/most/01/save';
        if (send) {
            action = '/most/01/send';
            if (CASigner.requireCA) {
                action = '/most/01/xml';
            }
        }

        var afterSigning = function (xml) {
            console.log("after signing =>", xml);
            action = '/most/01/sendwithsignature';
            id = $('#fiIdHoso').attr('value');
            if (id === '') {
                $('#fiIdHoso').attr('value', 0);
                id = 0;
            }
            app.makePost({
                url: action,
                data: JSON.stringify({
                    fiIdHoso: id,
                    fiSignedXml: xml,
                    fiIdCqxl: $('#fiIdCqxl').attr('value')
                }),
                success: function (d) {
                    if (d.success) {
                        onSuccess();
                        setTimeout(function () {
                            history.go(-1);
                        }, 2000);
                    } else {
                        onFail(d);
                    }
                },
                error: function (e) {
                    onFail();
                }
            });
        };

        var onSuccess = function (d) {
            if (send) {
                app.Alert(NSWLang["common_msg_sendsuccess"]);
                setTimeout(function () {
                    history.go(-1);
                }, 1500);
            } else {
                app.Alert(NSWLang["common_msg_cap_nhat_du_lieu_thanh_cong"]);
                if (d.data !== null) {
                    var op = d.data;
                    self.hangHoa.List = op.hangHoa1;
                    self.hangHoa.buildPager();
                    self.gcnTaiLieu.list = op.tepDinhKem.getArray('fiMaLoaiTaiLieu', self.fileType[4]);
                    self.gcnTaiLieu.bindGrid();
                    self.hopDong.setData({data: op.tepDinhKem !== null ? op.tepDinhKem.getArray('fiMaLoai', self.fileType[0]) : []});
                    self.hoaDon.setData({data: op.tepDinhKem !== null ? op.tepDinhKem.getArray('fiMaLoai', self.fileType[3]) : []});
                    self.vanDon.setData({data: op.tepDinhKem !== null ? op.tepDinhKem.getArray('fiMaLoai', self.fileType[1]) : []});
                    self.dmHangHoa.setData({data: op.tepDinhKem !== null ? op.tepDinhKem.getArray('fiMaLoai', self.fileType[2]) : []});
                }
            }
        };
        var onFail = function (d) {
            $("#btnGui").show();
            if (d !== null) {
                if (typeof (d.data) !== 'undefined' && Array.isArray(d.data)) {
                    app.Alert(Util.getErrorMsg(d.data[0]));
                } else {
                    if (d.message !== '') {
                        app.Alert(d.message);
                    } else {
                        app.Alert(NSWLang['common_msg_he_thong_chua_san_sang']);
                    }
                }
            }
        };

        if (registration.fiMaTcdg === '-1') {
            registration.fiMaTcdg = null;
            registration.fiTenTcdg = null;
        }

        //Neu ton tai hang hoa chua check co giay chung nhan thi phai chon TCCN
        if (!this.hangHoa.isNoLisence() && registration.fiMaTcdg === null) {
            app.Alert(NSWLang["most_common_msg_phaichontochucchungnhan"]);
            return;
        }
        //Neu ton tai hang hoa check co giay chung nhan nhung chua chon giay chung nhan thi return false
        var pErrorName = this.hangHoa.hasLisenceButNoAttach();
        if (pErrorName !== null) {
            app.Alert(NSWLang["most_common_msg_tontaihanghoachuacogcn"] + ": " + pErrorName);
            return;
        }

        app.makePost({
            url: action,
            data: JSON.stringify(registration),
            success: function (d) {
                //Ky so truoc khi gui di
                $('#fiIdHoso').attr('value', d.data.fiIdHoso);
                $('#fiMaHoSo').attr('value', d.data.fiMaHoSo);
                registration.fiIdHoso = d.fiIdHoso;
                if (send) {
                    if (CASigner.requireCA) {
                        var xmlContent = d.data;
                        console.log("before signing =>", xmlContent);
                        CASigner.sign(xmlContent, '', afterSigning);
                        //afterSigning(xmlContent);
                    } else {
                        onSuccess(d);
                    }
                } else {
                    onSuccess(d);
                }
            },
            error: function (e) {
                onFail(e);
            }
        });
    },
    registerEvents: function () {
        var self = this;
        $("#btnLuu").on('click', function (e) {
            e.stopPropagation();
            e.preventDefault();
            self.save(false);
            return false;
        });

        $("#btnGui").off('click').on('click', function (e) {
            e.stopPropagation();
            e.preventDefault();
            $("#btnGui").hide();
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

        $("#btnTroLai").on('click', function (e) {
            e.stopPropagation();
            e.preventDefault();
            history.go(-1);
        });

        $("#btnImport").on('click', function (e) {
            e.stopPropagation();
            e.preventDefault();

            if (Util.validateAttachByDom('file-import-excel', ['.xlsx'])) {
                app.toast({
                    title: NSWLang["common_msg_thong_bao"],
                    message: NSWLang["common_msg_dangimport"],
                    function: 'success',
                    timeOut: 1000
                });

                var file = $('#file-import-excel')[0].files[0];
                var cb = function (d) {
                    var data = d.data;
                    if (d.success) {
                        self.setData(data);
                    } else {
                        var error = data[0];
                        if (error.error === 'HH' || error.error === 'HS' || error.error === 'TK') {
                            var sheetName = NSWLang['common_excel_sheet_' + e.error.toLowerCase()];
                            app.Alert(sheetName);
                        } else {
                            app.Alert(Util.getErrorMsg(data[0]));
                        }
                    }
                };
                var uploadFile = function (file, cb) {
                    app.uploadFile({
                        url: '/most/01/import',
                        file: file,
                        success: function (d) {
                            cb(d);
                        },
                        error: function (e) {
                            console.log(e);
                        }
                    });
                };

                uploadFile(file, cb);
            }

            return false;
        });
    },
    validateDateOnForm: function (t1, t2) {

        var e1 = $('#' + t1),
            e2 = $('#' + t2);
        var valE1 = e1.val().toString().trim().toValidDate(),
            valE2 = e2.val().toString().trim().toValidDate();

        var fieldName1 = e1.attr('field');
        var fieldName2 = e2.attr('field');
        var now = new Date().toDayFirstString().toValidDate();


        if (Util.compareDate(now, valE1) == 1) {
            app.Alert(NSWLang[fieldName1] + ' <b>' + NSWLang['common_msg_khongnhohon'] + '</b> ' + NSWLang['common_msg_ngayhientai']);
            e1.focus();
            return false;
        }

        if (Util.compareDate(now, valE2) == 1) {
            app.Alert(NSWLang[fieldName2] + ' <b>' + NSWLang['common_msg_khongnhohon'] + '</b> ' + NSWLang['common_msg_ngayhientai']);
            e2.focus();
            return false;
        }

        if (Util.compareDate(valE1, valE2) == 1) {
            app.Alert(NSWLang[fieldName2] + ' <b>' + NSWLang['common_msg_khongnhohon'] + '</b> ' + NSWLang[fieldName1]);
            return false;
        }

        return true;
    }
};
