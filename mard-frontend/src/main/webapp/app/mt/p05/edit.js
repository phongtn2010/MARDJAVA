
/**
 * @returns
 */
/**
 * @returns
 */
$(document).ready(function () {
    function ViewModel() {
        var self = this;
        self.timeout = 30000;
        self.accepFiles = ['jpg', 'pdf', 'tif'];
        self.files = ko.observableArray(); // danh sach tat cả file dinh kem
        self.contextPath = ko.observable($('#contextPath').val());


        $('.date-picker').datepicker({rtl: false, orientation: "left", autoclose: true});

        self.showActionError = ko.observable(false);
        self.showActionSuccess = ko.observable(false);
        self.errorMessage = ko.observable('');

        self.VBCTKTT = ko.observableArray();
        self.GPVTLV = ko.observableArray();
        self.HDTPT = ko.observableArray();
        self.GDK_003 = ko.observableArray();
        self.GCN_001 = ko.observableArray();
        self.VBCC = ko.observableArray();
        self.GTK = ko.observableArray();
        self.DKPT = ko.observableArray();
        self.HDTMTS = ko.observableArray();

        // danh sach ho so

        self.hoSoChiTiet = new HosoChiTietModel();

        self.phuongtien = new Tbdphuongtien();
        
        self.danhSachThuTucFile = ko.observableArray(0);
        
        self.danhSachDonVi = ko.observableArray(0);

        self.danhSachTuyen = ko.observableArray(0);

        self.danhSachCuaKhau = ko.observableArray(0);

        self.danhSachNhanHieu = ko.observableArray(0);

        self.userCust = new UserCustom();
        if (!editMode) {
            $("#detailForm :input").prop("disabled", true);
        }
        
        app.makePost({
            url: '/mt/05/call_service',
            data: JSON.stringify({
                URL_BACKEND: "/mt/danhmuc/file/search",
                METHOD: "POST",
                REQUEST: {"maThuTuc" : procedureId}
            }),
            success: function (d) {
                $('#loading_c4e6a343-dd41-b5c5-1ef9-75eeebba032d').hide();
                var msg = '';
                var fun = 'success';
                if (d.success) {
                    for (const item of d.data) {
                        var itemBind = {};
                        self.danhSachThuTucFile.push(app.convertObjectToObservable(item, new Tbddanhmucfile()));
                    }
                } else {
                    msg = data.message;
                    fun = 'error';
                }
            },
            error: function (e) {
                $('#loading_c4e6a343-dd41-b5c5-1ef9-75eeebba032d').hide();
                
                toastr.error(e.message, NSWLang["common_msg_thong_bao"]);
                self.showActionSuccess(false);
                self.showActionError(true);
                self.errorMessage(e.message);
                $('html,body').scrollTop(0);
            }
        });
        
        app.makePost({
            url: '/mt/05/call_service',
            data: JSON.stringify({
                URL_BACKEND: "/mt/danhmuc/tuyen/search",
                METHOD: "POST",
                REQUEST: {}
            }),
            success: function (d) {
                $('#loading_c4e6a343-dd41-b5c5-1ef9-75eeebba032d').hide();
                var msg = '';
                var fun = 'success';
                
                if (d.success) {
                    for (const item of d.data) {
                        var itemBind = {};
                        self.danhSachTuyen.push(app.convertObjectToObservable(item, itemBind));
                    }
                } else {
                    msg = data.message;
                    fun = 'error';
                }
            },
            error: function (e) {
                $('#loading_c4e6a343-dd41-b5c5-1ef9-75eeebba032d').hide();
                
                toastr.error(e.message, NSWLang["common_msg_thong_bao"]);
                self.showActionSuccess(false);
                self.showActionError(true);
                self.errorMessage(e.message);
                $('html,body').scrollTop(0);
            }
        });

        app.makePost({
            url: '/mt/05/call_service',
            data: JSON.stringify({
                URL_BACKEND: "/mt/danhmuc/bophan/search",
                METHOD: "POST",
                REQUEST: {}
            }),
            success: function (d) {
                $('#loading_c4e6a343-dd41-b5c5-1ef9-75eeebba032d').hide();
                var msg = '';
                var fun = 'success';
                
                if (d.success) {
                    for (const item of d.data) {
                        var itemBind = {};
                        self.danhSachDonVi.push(app.convertObjectToObservable(item, itemBind));
                    }
                } else {
                    msg = data.message;
                    fun = 'error';
                }
            },
            error: function (e) {
                $('#loading_c4e6a343-dd41-b5c5-1ef9-75eeebba032d').hide();
                
                toastr.error(e.message, NSWLang["common_msg_thong_bao"]);
                self.showActionSuccess(false);
                self.showActionError(true);
                self.errorMessage(e.message);
                $('html,body').scrollTop(0);
            }
        });

        app.makePost({
            url: '/mt/05/call_service',
            data: JSON.stringify({
                URL_BACKEND: "/mt/danhmuc/nhanhieu/search",
                METHOD: "POST",
                REQUEST: {}
            }),
            success: function (d) {
                $('#loading_c4e6a343-dd41-b5c5-1ef9-75eeebba032d').hide();
                var msg = '';
                var fun = 'success';
                
                if (d.success) {
                    for (const item of d.data) {
                        var itemBind = {};
                        self.danhSachNhanHieu.push(app.convertObjectToObservable(item, itemBind));
                    }
                } else {
                    msg = data.message;
                    fun = 'error';
                }
            },
            error: function (e) {
                $('#loading_c4e6a343-dd41-b5c5-1ef9-75eeebba032d').hide();
                
                toastr.error(e.message, NSWLang["common_msg_thong_bao"]);
                self.showActionSuccess(false);
                self.showActionError(true);
                self.errorMessage(e.message);
                $('html,body').scrollTop(0);
            }
        });

        app.makePost({
            url: '/mt/05/call_service',
            data: JSON.stringify({
                URL_BACKEND: "/mt/danhmuc/cuakhau/search",
                METHOD: "POST",
                REQUEST: {"fiIdNhomTt": 3}
            }),
            success: function (d) {
                $('#loading_c4e6a343-dd41-b5c5-1ef9-75eeebba032d').hide();
                var msg = '';
                var fun = 'success';
                
                if (d.success) {
                    for (const item of d.data) {
                        var itemBind = {};
                        self.danhSachCuaKhau.push(app.convertObjectToObservable(item, itemBind));
                    }
                } else {
                    msg = data.message;
                    fun = 'error';
                }
            },
            error: function (e) {
                $('#loading_c4e6a343-dd41-b5c5-1ef9-75eeebba032d').hide();
                
                toastr.error(e.message, NSWLang["common_msg_thong_bao"]);
                self.showActionSuccess(false);
                self.showActionError(true);
                self.errorMessage(e.message);
                $('html,body').scrollTop(0);
            }
        });

        if (userCustom) {
            self.userCust = app.convertObjectToObservable(userCustom, self.userCust);
            self.hoSoChiTiet.Tbdhoso.fiTendoanhnghiep(userCustom.companyName);
            self.hoSoChiTiet.Tbdhoso.fiDiachi(userCustom.companyAddress);
            self.hoSoChiTiet.Tbdhoso.fiDienthoai(userCustom.companyPhoneNumber);
            self.hoSoChiTiet.Tbdhoso.fiFax(userCustom.companyFax);
            self.hoSoChiTiet.Tbdhoso.fiEmail(userCustom.companyEmail);
        }

        if (hoSoId) {
            app.makePost({
                url: '/mt/05/call_service',
                data: JSON.stringify({
                    URL_BACKEND: "/mt/05/hoso/detail",
                    METHOD: "POST",
                    REQUEST: hoSoId
                }),
                success: function (d) {
                    $('#loading_c4e6a343-dd41-b5c5-1ef9-75eeebba032d').hide();
                    var msg = '';
                    var fun = 'success';
                    if (d.success) {
                        self.hoSoChiTiet = app.convertObjectToObservable(d.data, self.hoSoChiTiet);
                        for (const phuongtien of d.data.Tbdphuongtien) {
                            self.hoSoChiTiet.Tbdphuongtien.push(app.convertObjectToObservable(phuongtien, new Tbdphuongtien()));
                        }
                        for (const file of d.data.Tbddinhkem) {
                            if (file.fiSothutu == 1) {
                                self.GPVTLV.push(app.convertObjectToObservable(file, new Tbddinhkem()));
                            }
                            if (file.fiSothutu == 2) {
                                self.VBCTKTT.push(app.convertObjectToObservable(file, new Tbddinhkem()));
                            }
                            if (file.fiSothutu == 3) {
                                self.HDTPT.push(app.convertObjectToObservable(file, new Tbddinhkem()));
                            }
                            if (file.fiSothutu == 4) {
                                self.GCN_001.push(app.convertObjectToObservable(file, new Tbddinhkem()));
                            }
                            if (file.fiSothutu == 5 && self.hoSoChiTiet.Tbdhoso.fiLoaihoso() == 'BGTVT0600005') {
                                self.GDK_003.push(app.convertObjectToObservable(file, new Tbddinhkem()));
                            }
                            if (file.fiSothutu == 5 && self.hoSoChiTiet.Tbdhoso.fiLoaihoso() != 'BGTVT0600005') {
                                self.DKPT.push(app.convertObjectToObservable(file, new Tbddinhkem()));
                            }
                            if (file.fiSothutu == 6) {
                                self.GTK.push(app.convertObjectToObservable(file, new Tbddinhkem()));
                            }
                            if (file.fiSothutu == 7) {
                                self.HDTMTS.push(app.convertObjectToObservable(file, new Tbddinhkem()));
                            }
                        }
                    } else {
                        msg = data.message;
                        fun = 'error';
                    }
                    app.toast({
                        title: NSWLang["common_msg_thong_bao"],
                        message: msg,
                        function: fun
                    });
                },
                error: function (e) {
                    $('#loading_c4e6a343-dd41-b5c5-1ef9-75eeebba032d').hide();
                    
                    toastr.error(e.message, NSWLang["common_msg_thong_bao"]);
                    self.showActionSuccess(false);
                    self.showActionError(true);
                    self.errorMessage(e.message);
                    $('html,body').scrollTop(0);
                }
            });
        } else {
            self.hoSoChiTiet.Tbdhoso.fiTrangthai(0);
            self.hoSoChiTiet.Tbdhoso.fiTenTrangthai('Mới tạo');
            self.hoSoChiTiet.Tbdhoso.fiNgaytao(new Date());
            self.hoSoChiTiet.Tbdhoso.fiLoaihoso(procedureId);
            self.hoSoChiTiet.Tbdhoso.fiTenThutuc(procedureId);
            self.hoSoChiTiet.Tbdhoso.fiLoaihinh(getLoaihinh(procedureId));
            self.hoSoChiTiet.Tbdhoso.fiManguoitao(userCustom.username);
            self.hoSoChiTiet.Tbdhoso.fiNguoitao(userCustom.companyName);
        }

        function getLoaihinh(procedureId) {
            if (procedureId === 'BGTVT0600005') {
                return 1;
            }
            if (procedureId === 'BGTVT0600006') {
                return 2;
            }
            if (procedureId === 'BGTVT0600007') {
                return 3;
            }
            if (procedureId === 'BGTVT0600008') {
                return 4;
            }
        };

        self.dong = function () {
            location.href = app.appContext + '/mt/05/home/' + self.hoSoChiTiet.Tbdhoso.fiLoaihoso();
        }

        self.luuHoSo = function (item) {
            if (self.isValidateForm()) {
                pop = app.popup({
                    title: NSWLang["common_msg_thong_bao"],
                    html: '<i class="fa fa-3x fa-warning"></i> ' + 'Bạn có chắc chắn muốn lưu hồ sơ' + '</b>',
                    width: 400,
                    buttons: [
                        {
                            name: NSWLang["common_button_toi_chac_chan"],
                            class: 'btn',
                            icon: 'fa-check',
                            action: function () {
                                self.action(item, 0)
                            }
                        }
                    ]
                });
            }
        }
        self.guiHoSo = function (item) {
            if (self.isValidateForm()) {
                pop = app.popup({
                    title: NSWLang["common_msg_thong_bao"],
                    html: '<i class="fa fa-3x fa-warning"></i> ' + 'Bạn có chắc chắn muốn gửi hồ sơ' + '</b>',
                    width: 400,
                    buttons: [
                        {
                            name: NSWLang["common_button_toi_chac_chan"],
                            class: 'btn',
                            icon: 'fa-check',
                            action: function () {
                                self.action(item, 1)
                            }
                        }
                    ]
                });
            }
        }
        self.action = function (item, functionType) {
            self.hoSoChiTiet.Tbddinhkem = [];
            self.hoSoChiTiet.Tbddinhkem.push(self.VBCTKTT());
            self.hoSoChiTiet.Tbddinhkem.push(self.GPVTLV());
            self.hoSoChiTiet.Tbddinhkem.push(self.HDTPT());
            self.hoSoChiTiet.Tbddinhkem.push(self.GCN_001());
            self.hoSoChiTiet.Tbddinhkem.push(self.GDK_003());
            self.hoSoChiTiet.Tbddinhkem.push(self.GTK());
            self.hoSoChiTiet.Tbddinhkem.push(self.HDTMTS());
            self.hoSoChiTiet.Tbddinhkem.push(self.DKPT());
            $('#loading_c4e6a343-dd41-b5c5-1ef9-75eeebba032d').show();
            if (self.files().length > 0) {
                app.uploadMutipleFile({
                    url: '/mt/05/saveWithFile/' + functionType,
                    data: app.convertFormObservableJson(self.hoSoChiTiet),
                    timeout: self.timeout,
                    success: function (d) {
                        $('#loading_c4e6a343-dd41-b5c5-1ef9-75eeebba032d').hide();
                        var msg = '';
                        var fun = 'success';
                        
                        if (d.success) {
                            self.files = ko.observableArray();
                            msg = 'Lưu thành công!';
                            location.href = app.appContext + '/mt/05/home/' + self.hoSoChiTiet.Tbdhoso.fiLoaihoso();
                        } else {
                            msg = d.message;
                            fun = 'error';
                        }
                        app.toast({
                            title: NSWLang["common_msg_thong_bao"],
                            message: msg,
                            function: fun
                        });
                    },
                    error: function (e) {
                        $('#loading_c4e6a343-dd41-b5c5-1ef9-75eeebba032d').hide();
                        
                        toastr.error(e.message, NSWLang["common_msg_thong_bao"]);
                        self.showActionSuccess(false);
                        self.showActionError(true);
                        self.errorMessage(e.message);
                        $('html,body').scrollTop(0);
                    }
                });
            } else {
                app.makePost({
                    url: '/mt/05/call_service',
                    data: JSON.stringify({
                        URL_BACKEND: "/mt/05/hoso/save/" + functionType,
                        METHOD: "POST",
                        REQUEST: app.convertFormObservableJson(self.hoSoChiTiet)
                    }),
                    timeout: self.timeout,
                    success: function (d) {
                        $('#loading_c4e6a343-dd41-b5c5-1ef9-75eeebba032d').hide();
                        var msg = '';
                        var fun = 'success';
                        
                        if (d.success) {
                            msg = 'Lưu thành công!';
                            location.href = app.appContext + '/mt/05/home/' + self.hoSoChiTiet.Tbdhoso.fiLoaihoso();
                        } else {
                            msg = data.message;
                            fun = 'error';
                        }
                        app.toast({
                            title: NSWLang["common_msg_thong_bao"],
                            message: msg,
                            function: fun
                        });
                    },
                    error: function (e) {
                        $('#loading_c4e6a343-dd41-b5c5-1ef9-75eeebba032d').hide();
                        
                        toastr.error(e.message, NSWLang["common_msg_thong_bao"]);
                        self.showActionSuccess(false);
                        self.showActionError(true);
                        self.errorMessage(e.message);
                        $('html,body').scrollTop(0);
                    }
                });
            }
        }

        self.uploadFileChangeEvent = function (thutu, eleId, elemet, event) {
            var files = event.target.files;
            var maxSize = 1048576 // 1MB
            for (var i = 0, file; file = files[i]; i++) {
                var ext = file.name.substr(file.name.lastIndexOf('.') + 1);
                if ($.inArray(ext.toLowerCase(), self.accepFiles) === -1) {
                    $('#' + eleId).val('');
                    alert(NSWLang['file_msg_file_duoc_phep_tai_len'].format(': ' + self.accepFiles.join(', ')));
                    return false;
                }
                if (file.size > maxSize) {
                    $('#' + eleId).val('');
                    alert(NSWLang['file_msg_dung_luong_toi_da'].format(1));
                    return false;
                }
            }
            var totalSize = 0;
            var totalMB = 5242880;//5MB
            $(files).each(function (index, item) {
                totalSize += item.size;
            });
            if (totalSize > totalMB) {
                $('#' + eleId).val('');
                cssError(eleId);
                alert(NSWLang['file_msg_dung_luong_toi_da'].format(5));
                return false;
            }
            for (var i = 0, file; file = files[i]; i++) {
                var dinhkem = new Tbddinhkem();
                dinhkem.fiTenDinhkem(file.name);
                dinhkem.fiIdHoso(hoSoId);
                dinhkem.fiTenFile(file.name);
                dinhkem.fiSothutu(thutu);
                dinhkem.file = file;
                if (thutu == 1) {
                    dinhkem.fiMaDinhkem('GPVTLV');
                    self.GPVTLV.push(dinhkem);
                } else if (thutu == 2) {
                    dinhkem.fiMaDinhkem('VBCTKTT');
                    self.VBCTKTT.push(dinhkem);
                } else if (thutu == 3) {
                    dinhkem.fiMaDinhkem('HDTPT');
                    self.HDTPT.push(dinhkem);
                } else if (thutu == 4) {
                    dinhkem.fiMaDinhkem('GCN_001');
                    self.GCN_001.push(dinhkem);
                } else if (thutu == 5 && self.hoSoChiTiet.Tbdhoso.fiLoaihoso() == 'BGTVT0600005') {
                    dinhkem.fiMaDinhkem('GDK_003');
                    self.GDK_003.push(dinhkem);
                } else if (thutu == 5 && self.hoSoChiTiet.Tbdhoso.fiLoaihoso() != 'BGTVT0600005') {
                    dinhkem.fiMaDinhkem('DKPT');
                    self.DKPT.push(dinhkem);
                } else if (thutu == 6) {
                    dinhkem.fiMaDinhkem('GTK');
                    self.GTK.push(dinhkem);
                } else if (thutu == 7) {
                    dinhkem.fiMaDinhkem('HDTMTS');
                    self.HDTMTS.push(dinhkem);
                }
                self.files.push(file);
            }
        }

        self.xoaMotFile = function (item) {
            if (item.fiSothutu() === 1) {
                self.GPVTLV.remove(item);
                resetInput($("#GPVTLV"));
            } else if (item.fiSothutu() === 2) {
                self.VBCTKTT.remove(item);
                resetInput($("#VBCTKTT"));
            } else if (item.fiSothutu() === 3) {
                self.HDTPT.remove(item);
                resetInput($("#HDTPT"));
            } else if (item.fiSothutu() === 4) {
                self.GCN_001.remove(item);
                resetInput($("#GCN_001"));
            } else if (item.fiSothutu() === 5 && self.hoSoChiTiet.Tbdhoso.fiLoaihoso() == 'BGTVT0600005') {
                self.GDK_003.remove(item);
                resetInput($("#GDK_003"));
            } else if (item.fiSothutu() === 5 && self.hoSoChiTiet.Tbdhoso.fiLoaihoso() != 'BGTVT0600005') {
                self.DKPT.remove(item);
                resetInput($("#DKPT"));
            } else if (item.fiSothutu() === 6) {
                self.GTK.remove(item);
                resetInput($("#GTK"));
            } else if (item.fiSothutu() === 7) {
                self.HDTMTS.remove(item);
                resetInput($("#HDTMTS"));
            }
            self.files.remove(item);
        }

        self.xoaTepTin = function (loaiTep) {
            if (loaiTep === '1') {
                for (var item in self.GPVTLV()) {
                    self.files.remove(item);
                }
                self.GPVTLV.removeAll();
                resetInput($("#GPVTLV"));
            } else if (loaiTep === '2') {
                for (var item in self.VBCTKTT()) {
                    self.files.remove(item);
                }
                self.VBCTKTT.removeAll();
                resetInput($("#VBCTKTT"));
            } else if (loaiTep === '3') {
                for (var item in self.HDTPT()) {
                    self.files.remove(item);
                }
                self.HDTPT.removeAll();
                resetInput($("#HDTPT"));
            } else if (loaiTep === '4') {
                for (var item in self.GCN_001()) {
                    self.files.remove(item);
                }
                self.GCN_001.removeAll();
                resetInput($("#GCN_001"));
            } else if (loaiTep === '5' && self.hoSoChiTiet.Tbdhoso.fiLoaihoso() == 'BGTVT0600005') {
                for (var item in self.GDK_003()) {
                    self.files.remove(item);
                }
                self.GDK_003.removeAll();
                resetInput($("#GDK_003"));
            } else if (loaiTep === '5' && self.hoSoChiTiet.Tbdhoso.fiLoaihoso() != 'BGTVT0600005') {
                for (var item in self.DKPT()) {
                    self.files.remove(item);
                }
                self.DKPT.removeAll();
                resetInput($("#DKPT"));
            } else if (loaiTep === '6') {
                for (var item in self.GTK()) {
                    self.files.remove(item);
                }
                self.GTK.removeAll();
                resetInput($("#GTK"));
            } else if (loaiTep === '7') {
                for (var item in self.HDTMTS()) {
                    self.files.remove(item);
                }
                self.HDTMTS.removeAll();
                resetInput($("#HDTMTS"));
            }
        }

        self.themPhuongtien = function () {
            if (app.checkValidate(self.phuongtien)) {
                self.phuongtien.editing(false);
                self.hoSoChiTiet.Tbdphuongtien.push(app.cloneObject(self.phuongtien, new Tbdphuongtien()));
                app.resetObservable(self.phuongtien);
                self.errors2.showAllMessages(false);
            } else {
                self.errors2.showAllMessages(true);
            }
        }

        self.xoaPhuongtien = function (item) {
            self.hoSoChiTiet.Tbdphuongtien.splice(self.hoSoChiTiet.Tbdphuongtien.indexOf(item), 1);
        }
        self.suaPhuongtien = function (item) {
            item.editing(true);
        }
        self.editOk = function (item) {
            if (app.checkValidate(item)) {
                item.editing(false);
            } else {
                self.errors3().showAllMessages(true);
            }
        }

        self.chonTuyenVanTai = function () {
            if (self.hoSoChiTiet.Tbdhoso.fiMatuyen()) {
                for (const tuyen of self.danhSachTuyen()) {
                    if (tuyen.fiMaTuyen() === self.hoSoChiTiet.Tbdhoso.fiMatuyen()) {
                        self.getBenXeById(tuyen.fiBenDi(), self.hoSoChiTiet.Tbdhoso.fiGadi, self.hoSoChiTiet.Tbdhoso.fiTinhdi);
                        self.getBenXeById(tuyen.fiBenDen(), self.hoSoChiTiet.Tbdhoso.fiGaden, self.hoSoChiTiet.Tbdhoso.fiTinhden);
                        self.hoSoChiTiet.Tbdhoso.fiQuangduong(tuyen.fiKhoangcach());
                        self.hoSoChiTiet.Tbdhoso.fiMotatuyen(tuyen.fiHanhtrinh());
                        // self.hoSoChiTiet.Tbdhoso.fiSogiaytochapthuan(tuyen.fiSocvChapthuan());
                        // self.hoSoChiTiet.Tbdhoso.fiNgaychapthuan(tuyen.fiLlDacap());
                    }
                }
            }
        }

        self.getTinhById = function (id, func) {
            app.makePost({
                url: '/mt/05/call_service',
                data: JSON.stringify({
                    URL_BACKEND: "/mt/danhmuc/tinhthanh/getById",
                    METHOD: "POST",
                    REQUEST: id
                }),
                success: function (d) {
                    $('#loading_c4e6a343-dd41-b5c5-1ef9-75eeebba032d').hide();
                    var msg = '';
                    var fun = 'success';
                    
                    if (d.success) {
                        func(d.data.fiTen);
                    } else {
                        msg = data.message;
                        fun = 'error';
                    }
                },
                error: function (e) {
                    $('#loading_c4e6a343-dd41-b5c5-1ef9-75eeebba032d').hide();
                    
                    toastr.error(e.message, NSWLang["common_msg_thong_bao"]);
                    self.showActionSuccess(false);
                    self.showActionError(true);
                    self.errorMessage(e.message);
                    $('html,body').scrollTop(0);
                }
            });
        }

        self.getBenXeById = function (id, funcGa, funcTinh) {
            app.makePost({
                url: '/mt/05/call_service',
                data: JSON.stringify({
                    URL_BACKEND: "/mt/danhmuc/benxe/getById",
                    METHOD: "POST",
                    REQUEST: id
                }),
                success: function (d) {
                    $('#loading_c4e6a343-dd41-b5c5-1ef9-75eeebba032d').hide();
                    var msg = '';
                    var fun = 'success';
                    
                    if (d.success) {
                        funcGa(d.data.fiTenBen);
                        self.getTinhById(d.data.fiMaTinh, funcTinh);
                    } else {
                        msg = data.message;
                        fun = 'error';
                    }
                },
                error: function (e) {
                    $('#loading_c4e6a343-dd41-b5c5-1ef9-75eeebba032d').hide();
                    
                    toastr.error(e.message, NSWLang["common_msg_thong_bao"]);
                    self.showActionSuccess(false);
                    self.showActionError(true);
                    self.errorMessage(e.message);
                    $('html,body').scrollTop(0);
                }
            });
        }

        function resetInput(controlId) {
            controlId.replaceWith(controlId.val('').clone(true));
        };

        self.isValidateForm = function () {
            if (!app.checkValidate(self.hoSoChiTiet)) {
                self.errors.showAllMessages();
                app.AlertWithBtn("Bạn chưa nhập đủ thông tin yêu cầu");
                return false;
            }
            if (!(self.hoSoChiTiet.Tbsloaihinhvantai.fixedRoadTransport()
                || self.hoSoChiTiet.Tbsloaihinhvantai.contractRoadTransport()
                || self.hoSoChiTiet.Tbsloaihinhvantai.passengerTransport()
                || self.hoSoChiTiet.Tbsloaihinhvantai.cargoTransport())) {
                app.AlertWithBtn("Bạn phải chọn ít nhất 1 loại hình vận tải");
                return false;
            }
            if (self.hoSoChiTiet.Tbdphuongtien().length == 0) {
                app.AlertWithBtn("Phương tiện không được trống");
                return false;
            }
            if (procedureId === 'BGTVT0600005' && (
                self.GPVTLV().length == 0
                || self.VBCTKTT().length == 0
                || self.HDTPT().length == 0
                || self.GCN_001().length == 0
                || self.GDK_003().length == 0
            )) {
                app.AlertWithBtn("File đính kèm không được trống");
                return false;
            }
            if (procedureId === 'BGTVT0600006' && (
                self.GPVTLV().length == 0
                || self.VBCTKTT().length == 0
                || self.HDTPT().length == 0
                || self.GCN_001().length == 0
                || self.DKPT().length == 0
            )) {
                app.AlertWithBtn("File đính kèm không được trống");
                return false;
            }
            if (procedureId === 'BGTVT0600007' && (
                self.GPVTLV().length == 0
                || self.VBCTKTT().length == 0
                || self.HDTMTS().length == 0
                || self.GCN_001().length == 0
                || self.DKPT().length == 0
            )) {
                app.AlertWithBtn("File đính kèm không được trống");
                return false;
            }
            if (procedureId === 'BGTVT0600008' && (
                self.GPVTLV().length == 0
                || self.VBCTKTT().length == 0
                || self.HDTMTS().length == 0
                || self.GCN_001().length == 0
                || self.DKPT().length == 0
            )) {
                app.AlertWithBtn("File đính kèm không được trống");
                return false;
            }
            return true;
        };

        function base64ToArrayBuffer(base64) {
            var binaryString = window.atob(base64);
            var binaryLen = binaryString.length;
            var bytes = new Uint8Array(binaryLen);
            for (var i = 0; i < binaryLen; i++) {
                var ascii = binaryString.charCodeAt(i);
                bytes[i] = ascii;
            }
            return bytes;
        }

        var saveByteArray = (function () {
            var a = document.createElement("a");
            document.body.appendChild(a);
            a.style = "display: none";
            return function (data, name) {
                var blob = new Blob(data, {type: "octet/stream"}),
                    url = window.URL.createObjectURL(blob);
                a.href = url;
                a.download = name;
                a.click();
                window.URL.revokeObjectURL(url);
            };
        }());

        function fileToBytes(theFile) {
            var reader = new FileReader();
            var fileByteArray = [];
            reader.readAsArrayBuffer(theFile);
            reader.onloadend = function (evt) {
                if (evt.target.readyState == FileReader.DONE) {
                    var arrayBuffer = evt.target.result,
                        array = new Uint8Array(arrayBuffer);
                    for (var i = 0; i < array.length; i++) {
                        fileByteArray.push(array[i]);
                    }
                }
            }
            return fileByteArray;
        }

        self.downloadAll = function (loaiTep) {
            if (loaiTep === '1') {
                for (var i = 0; i < self.GPVTLV().length; i++) {
                    self.download(self.GPVTLV()[i]);
                }
            } else if (loaiTep === '2') {
                for (var i = 0; i < self.VBCTKTT().length; i++) {
                    self.download(self.VBCTKTT()[i]);
                }
            } else if (loaiTep === '3') {
                for (var i = 0; i < self.HDTPT().length; i++) {
                    self.download(self.HDTPT()[i]);
                }
            } else if (loaiTep === '4') {
                for (var i = 0; i < self.GCN_001().length; i++) {
                    self.download(self.GCN_001()[i]);
                }
            } else if (loaiTep === '5' && self.hoSoChiTiet.Tbdhoso.fiLoaihoso() == 'BGTVT0600005') {
                for (var i = 0; i < self.GDK_003().length; i++) {
                    self.download(self.GDK_003()[i]);
                }
            } else if (loaiTep === '5') {
                for (var i = 0; i < self.DKPT().length; i++) {
                    self.download(self.DKPT()[i]);
                }
            } else if (loaiTep === '6') {
                for (var i = 0; i < self.GTK().length; i++) {
                    self.download(self.GTK()[i]);
                }
            } else if (loaiTep === '7') {
                for (var i = 0; i < self.HDTMTS().length; i++) {
                    self.download(self.HDTMTS()[i]);
                }
            }
        }

        self.download = function (item) {
            if (item.fiIdDinhkem()) {
                $('#loading_c4e6a343-dd41-b5c5-1ef9-75eeebba032d').show();
                app.makeGet({
                    url: "/mt/05/download/" + item.fiIdDinhkem(), // my URL
                    responseType: 'blob',
                    headers: {'Content-Type': 'image/png', 'X-Requested-With': 'XMLHttpRequest'},
                    success: function (result) {
                        saveByteArray([base64ToArrayBuffer(result.data)], item.fiTenFile());
                        $('#loading_c4e6a343-dd41-b5c5-1ef9-75eeebba032d').hide();
                    }
                });
            } else {
                saveByteArray([fileToBytes(item.file)], item.fiTenFile());
            }
        }

        self.changeFixedRoadTransport = function () {
            self.hoSoChiTiet.Tbdhoso.fixedRoadTransport(self.hoSoChiTiet.Tbsloaihinhvantai.fixedRoadTransport());
            if (!self.hoSoChiTiet.Tbsloaihinhvantai.fixedRoadTransport()) {
                self.hoSoChiTiet.Tbdhoso.fiTinhdi('');
                self.hoSoChiTiet.Tbdhoso.fiGadi('');
                self.hoSoChiTiet.Tbdhoso.fiTinhden('');
                self.hoSoChiTiet.Tbdhoso.fiGaden('');
                self.hoSoChiTiet.Tbdhoso.fiQuangduong('');
                self.hoSoChiTiet.Tbdhoso.fiMatuyen('');
                self.hoSoChiTiet.Tbdhoso.fiSogiaytochapthuan('');
                self.hoSoChiTiet.Tbdhoso.fiNgaychapthuan('');
                self.hoSoChiTiet.Tbdhoso.fiCuakhau('');
            }
        }
        self.getTenCuaKhau = function (maCuaKhau) {
            var match = ko.utils.arrayFirst(self.danhSachCuaKhau(), function (item) {
                return item.fiMaCuakhau() === maCuaKhau;
            });
            if (match) {
                return match.fiTenCuakhau();
            }
            return '';
        }
        self.getTenNhanhieu = function (idnhanhieu) {
            var match = ko.utils.arrayFirst(self.danhSachNhanHieu(), function (item) {
                return item.fiMaNhanhieu() === idnhanhieu;
            });
            if (match) {
                return match.fiTenHieu();
            }
            return '';
        }
        self.danhSachTrangThai = ko.observableArray(0);
        app.makePost({
            url: '/mt/05/call_service',
            data: JSON.stringify({
                URL_BACKEND: "/mt/danhmuc/trangthai/search",
                METHOD: "POST",
                REQUEST: {}
            }),
            success: function (d) {
                $('#loading_c4e6a343-dd41-b5c5-1ef9-75eeebba032d').hide();
                var msg = '';
                var fun = 'success';
                
                if (d.success) {
                    var tatca = {};
                    tatca["fiTenTrangthai"] = ko.observable("--- Tất cả ----");
                    tatca["fiTrangthaiId"] = ko.observable(null);
                    self.danhSachTrangThai.push(tatca);
                    for (const item of d.data) {
                        var itemBind = {};
                        self.danhSachTrangThai.push(app.convertObjectToObservable(item, itemBind));
                    }
                } else {
                    msg = data.message;
                    fun = 'error';
                }
            },
            error: function (e) {
                $('#loading_c4e6a343-dd41-b5c5-1ef9-75eeebba032d').hide();
                
                toastr.error(e.message, NSWLang["common_msg_thong_bao"]);
                self.showActionSuccess(false);
                self.showActionError(true);
                self.errorMessage(e.message);
                $('html,body').scrollTop(0);
            }
        });
        self.getTenTrangthai = function (idTrangthai) {
            var match = ko.utils.arrayFirst(self.danhSachTrangThai(), function (item) {
                return item.fiTrangthaiId() == idTrangthai;
            });
            if (match) {
                return match.fiTenTrangthai();
            }
            return '';
        }


    }

    ko.validation.init({
        insertMessages: true,
        messagesOnModified: true,
        decorateElement: true,
        parseInputAttributes: true,
        errorElementClass: 'wrong-field',
        grouping: {
            deep: true,
            live: true,
            observable: true
        }
    }, true);

    ko.bindingHandlers.datepicker = {
        init: function (element, valueAccessor, allBindingsAccessor) {
            var options = allBindingsAccessor().datepickerOptions || {};

            $(element).datepicker(options);

            //handle the field changing
            ko.utils.registerEventHandler(element, "change", function () {
                var observable = valueAccessor();
                observable($(element).datepicker("getDate"));
            });

            //handle disposal (if KO removes by the template binding)
            ko.utils.domNodeDisposal.addDisposeCallback(element, function () {
                $(element).datepicker("destroy");
            });

        },
        update: function (element, valueAccessor) {
            var value = ko.utils.unwrapObservable(valueAccessor()),
                $el = $(element);

            //handle date data coming via json from Microsoft
            if (String(value).indexOf('/Date(') == 0) {
                value = new Date(parseInt(value.replace(/\/Date\((.*?)\)\//gi, "$1")));
            }

            var current = $el.datepicker("getDate");

            if (value - current !== 0) {
                $el.datepicker("setDate", value);
            }
        }
    };
    ko.validation.makeBindingHandlerValidatable('datepicker');

    var vm = new ViewModel();

    vm.errors = ko.validation.group(vm.hoSoChiTiet);

    vm.errors2 = ko.validation.group(vm.phuongtien, {deep: true});

    vm.errors3 = ko.computed(function () {
        return ko.validation.group(vm.hoSoChiTiet.Tbdphuongtien(), {deep: true})
    });

    ko.applyBindings(vm);
});

