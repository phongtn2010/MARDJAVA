var HoSoController = function() {};
HoSoController.prototype={
    ministryCode: 'most',
    code: '02',
    templates: [],
    fileType: [1, 2, 3, 4, 5, 6],
    toKhai: null,
    hangHoa: null,
    taiLieu: null,
    hopDong: null,
    dmHangHoa: null,
    chungNhan:null,
    init: function(obj){
        var self = this;
        var op = $.extend(true, {}, obj);
        var coquanxl = $("#fiMaCqCap");
        if(obj.data.fiTrangthai == 0){
            coquanxl.val(coquanxl.attr('data')).select2({placeholder: '', width: '100%',autoclose: true});
        }
        console.log(op.data);
        //trigger JS module
        if (this.hangHoa === null) {
            this.hangHoa = new HangHoaController();
            this.hangHoa.init({
                container: 'hanghoa-container', 
                hangHoa: op.data.hangHoas, 
                pager: 'hanghoa-pager', 
                IsView: op.isView
            });
        }
        if (this.toKhai === null) {
            this.toKhai = new ToKhaiController();
            this.toKhai.init({
                container: 'tokhai-container', 
                toKhaiHQ: op.data.toKhaiHQs, 
                IsView: op.isView});
        }
        
        op.data.tepDinhKems = op.data.tepDinhKems == undefined ? null : op.data.tepDinhKems;
        if (this.dmHangHoa === null) {
            this.dmHangHoa = new DMHangHoaController();
            this.dmHangHoa.init({containerId: 'dmhanghoa-container',
                templateName: 'dmhanghoa-danhsach',
                fileType: self.fileType[1],
                data: op.data.tepDinhKems !== null ? op.data.tepDinhKems.getArray('fiMaLoai', self.fileType[1]) : [],
                IsView: op.isView});
        }
        
        if (this.chungNhan === null) {
            this.chungNhan = new ChungNhanController();
            this.chungNhan.init({
                containerId: 'chungnhan-container',
                templateName: 'chungnhanxuatxu-danhsach',
                fileType: self.fileType[2],
                data: op.data.tepDinhKems !== null ? op.data.tepDinhKems.getArray('fiMaLoai', self.fileType[2]) : [],
                IsView: op.isView
            });
        }
        
        if (this.hopDong === null) {
            this.hopDong = new HopDongController();
            this.hopDong.init({
                containerId: 'hopdong-container',
                templateName: 'hopdong-danhsach',
                fileType: self.fileType[0],
                data: op.data.tepDinhKems !== null ? op.data.tepDinhKems.getArray('fiMaLoai', self.fileType[0]) : [],
                IsView: op.isView
            });
        }
        
        if (this.taiLieu === null) {
            this.taiLieu = new TaiLieuKhacController();
            this.taiLieu.init({
                containerId: 'tailieukhac-container',
                templateName: 'tailieukhac-danhsach',
                fileType: self.fileType[4],
                data: op.data.tepDinhKems !== null ? op.data.tepDinhKems.getArray('fiMaLoaiTaiLieu', self.fileType[4]) : [],
                IsView: op.isView
            });
        }
        this.registerEvents();
        this.loadTemplates();
        $('.date-picker').datepicker({rtl: false, orientation: "left", autoclose: true, todayHighlight: true});
       
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
    setData: function (obj) {
        var op = $.extend(true, {}, obj);
        var formContainer = $('#form-dn');
        if (!$("#fiMstDn").val())
            formContainer.find('#fiMstDn').val(obj.fiMstDn);
        if (!$("#fiFaxNnk").val())
            formContainer.find('#fiFaxNnk').val(obj.fiFaxNnk);
        if (!$("#fiNguoiDd").val())
            formContainer.find('#fiNguoiDd').val(obj.fiNguoiDd);
        if (!$("#fiTenDnNk").val())
            formContainer.find('#fiTenDnNk').val(obj.fiTenDnNk);
        if (!$("#fiDiachiDnNk").val())
            formContainer.find('#fiDiachiDnNk').val(obj.fiDiachiDnNk);
        if (!$("#fiDtDnNk").val())
            formContainer.find('#fiDtDnNk').val(obj.fiDtDnNk);
        $('#fiDiachiKho').val(obj.fiDiachiKho);        
        $('#fiMaCqCap').attr('data', obj.fiMaCqCap);
        $('#fiMaCqCap').val( $('#fiMaCqCap').attr('data')).select2({placeholder: '', width: 435});
         
        this.toKhai.setData({toKhaiHQ: op.toKhaiHQs});
        this.hangHoa.setData({hangHoa: op.hangHoas, pager: 'hanghoa-pager',container: 'hanghoa-container'});
        this.hopDong.setData({data: op.tepDinhKems !== null ? op.tepDinhKems.getArray('fiMaLoai', this.fileType[0]) : []});
        this.dmHangHoa.setData({data: op.tepDinhKems !== null ? op.tepDinhKems.getArray('fiMaLoai', this.fileType[1]) : []});
        this.chungNhan.setData({data: op.tepDinhKems !== null ? op.tepDinhKems.getArray('fiMaLoai', this.fileType[2]) : []});
        this.taiLieu.setData({data: op.tepDinhKems !== null ? op.tepDinhKems.getArray('fiMaLoaiTaiLieu', this.fileType[4]) : []});

    },
    registerEvents: function () {
        var self = this;
        $("#btnLuu").on('click', function (e) {
            e.stopPropagation();
            e.preventDefault();
            self.save(false);
            return false;
        });
        $("#btnTroLai").on('click', function (e) {
            e.stopPropagation();
            e.preventDefault();
            document.location = app.appContext + "/most/02/home";
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
                        url: '/most/02/import',
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
     save: function (send) {
        var self = this;
        //Kiem tra thong tin don
        var isOk = app.isFormVaild('form-dn') && app.isFormVaild('form-ttc');
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

        var registration = app.form2Object('#form-dn');
        var id = $('#fiIdHoso').attr('value');
        if(!id){
            registration.fiIdHoso=0;
        }
        if (id === '') {
            $('#fiIdHoso').attr('value', 0);
            id = 0;
        }	
        var ttc = app.form2Object('#form-ttc');
        for(var name in ttc){
            registration[name]= ttc[name];
        }
	registration.fiDiachiKho=$("#fiDiachiKho").val();
        if(registration.fiTrangthai == 0)
            registration.fiTenCqCap=$("#fiMaCqCap").find('option:selected').html();
        
        registration.toKhaiHQs = self.toKhai.List;
        registration.hangHoas = self.hangHoa.List;
        registration.tepDinhKems = self.hopDong.list.concat(self.dmHangHoa.list, self.chungNhan.list, self.taiLieu.list);
        var action = '/most/02/save';
        if (send) {
            action = '/most/02/send';
            if (app.requireSigning) {
                action = '/most/02/xml';
            }
        }
        var afterSigning = function (xml) {
            console.log("after signing =>", xml);
            action = '/most/02/sendwithsignature';
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
                            document.location = app.appContext + "/most/02/home";
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
                    document.location = app.appContext + "/most/02/home";
                }, 1500);
            } else {
                app.Alert(NSWLang["common_msg_cap_nhat_du_lieu_thanh_cong"]);
                if (d.data !== null) {
                    self.hangHoa.List = d.data.hangHoas;
                    self.hangHoa.buildPager();          
                     setTimeout(function () {
                    document.location = app.appContext + "/most/02/home";
                }, 1500);
                }
            }
        };
        var onFail = function (d) {
            $("#btnGui").show();
            if (d !== null) {
                if (typeof (d.data) !== 'undefined' && Array.isArray(d.data)) {
                    app.Alert(Util.getErrorMsg(d.data[0]));
                } else {
                    app.Alert(d.message);
                }
            } else {
                if( d !== null) {
                    if(d.data == null)
                        app.Alert(d.message);
                } else {
                    app.Alert(NSWLang['common_msg_he_thong_chua_san_sang']);
                }
            }
        };

        console.log(registration);
        app.makePost({
            url: action,
            data: JSON.stringify(registration),
            success: function (d) {
                //Ky so truoc khi gui di
                $('#fiIdHoso').attr('value', d.data.fiIdHoso);
                $('#fiMaHoSo').attr('value', d.data.fiMaHoSo);
                $('#fiTrangthai').attr('value', d.data.fiTrangthai);
                $('#fiTenTT').attr('value', d.data.fiTenTT);
                registration.fiIdHoso = d.fiIdHoso;
                if (send) {
                    if (app.requireSigning) {
                        var xmlContent = d.data;
                        console.log("before signing =>", xmlContent);
//                        CASigner.sign(xmlContent, '', afterSigning);
                        //afterSigning(xmlContent);
                    } else {
                        onSuccess(d);
                    }
                } else {
                    onSuccess(d);
                }
            },
            error: function (d) {
                if (d.data != null && !!d.data.fiIdHoso) {
                    $('#fiIdHoso').attr('value', d.data.fiIdHoso);
                    $('#fiMaHoSo').attr('value', d.data.fiMaHoSo);
                    $('#fiTrangthai').attr('value', d.data.fiTrangthai);
                    $('#fiTenTT').attr('value', d.data.fiTenTT);
                }
                onFail(d);
            }
        });
    },
    isVaid: function () {
        var isSuccess = false;
        isSuccess = this.hangHoa.validateData();
        if(!isSuccess){
            app.AlertWithBtn("Bạn chưa nhập đủ thông tin chi tiết hàng hóa");
            return isSuccess;
        }
        if ($('#fiMaCqCap').val() === '-1' || !$('#fiMaCqCap').val()) {
                alert(NSWLang['most_02_coquanxuly'] + ' ' + NSWLang["common_msg_chua_nhap"]);
                $('#fiMaCqCap').focus();
                return isSuccess;
        }

//        if(!$('#fiDiachiKho').val()){
//             alert(NSWLang['most_02_diachikho'] + ' ' + NSWLang["common_msg_chua_nhap"]);
//                $('#fiDiachiKho').focus();
//                return isSuccess;
//        }

    //        isSuccess = this.toKhai.isVaild();
    //        if (!isSuccess) {
    //            return isSuccess;
    //        }

        isSuccess = this.hangHoa.isVaild();
        if (!isSuccess) {
            return isSuccess;
        }

//        isSuccess = this.hopDong.isVaild();
//        if (!isSuccess) {
//            return isSuccess;
//       }
//
//        isSuccess = this.dmHangHoa.isVaild();
//        if (!isSuccess) {
//            return isSuccess;
//        }

//        isSuccess = this.chungNhan.isValid();
//        if (!isSuccess) {
//            return isSuccess;
//        }

        return isSuccess;
    }
}
