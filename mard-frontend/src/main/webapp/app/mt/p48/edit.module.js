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
        self.customPagination = new CustomPagination([], 5);

        
        // danh sach ho so

        self.hoSoChiTiet = new HosoChiTietModel();

        self.phuongtien = new Tbdphuongtien();
        
        /*self.danhSachThuTucFile = ko.observableArray([
        	new Tbddanhmucfile(1, 'VBCTKTT', 'Văn bản chấp thuận khai thác tuyến, văn bản thay thế phương tiện hoặc văn bản bổ sung phương tiện của cơ quan quản lý tuyến và hợp đồng đón trả khách tại bến xe ở Việt Nam và Lào *'),
        	new Tbddanhmucfile(1, 'GPVTLV', 'Giấy phép vận tải đường bộ quốc tế Việt - Lào*'),
        	new Tbddanhmucfile(1, 'HDTPT', 'Hợp đồng thuê phương tiện hoặc hợp đồng hợp tác kinh doanh giữa các đơn vị kinh doanh vận tải hoặc hợp đồng dịch vụ giữa thành viên và hợp tác xã *'),
        	new Tbddanhmucfile(1, 'GTK', 'Giấy tờ khác (nếu có)')
        ]);*/
        self.danhSachFile = ko.observableArray(0);
        self.danhSachFileCheck = ko.observableArray(0);
        self.danhSachThuTucFile = ko.observableArray();
        self.danhSachDonVi = ko.observableArray(0);

        self.danhSachTuyen = ko.observableArray(0);

        self.danhSachCuaKhau = ko.observableArray(0);

        self.danhSachNhanHieu = ko.observableArray(0);

        self.userCust = new UserCustom();

        
        app.makePost({
            url: '/mt/48/call_service',
            data: JSON.stringify({
                URL_BACKEND: "/mt/file/getAll/" + procedureId,
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
            url: '/mt/48/call_service',
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
            url: '/mt/48/call_service',
            data: JSON.stringify({
                URL_BACKEND: "/mt/danhmuc/cqxl/getbyMaThuTuc/" + procedureId,
                METHOD: "GET",
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
            url: '/mt/48/call_service',
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
            url: '/mt/48/call_service',
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
            self.hoSoChiTiet.Tbdhoso.fiTenDoanhNghiep(userCustom.companyName);
            self.hoSoChiTiet.Tbdhoso.fiDiaChi(userCustom.companyAddress);
            self.hoSoChiTiet.Tbdhoso.fiDienThoai(userCustom.companyPhoneNumber);
            self.hoSoChiTiet.Tbdhoso.fiFax(userCustom.companyFax);
        }



        function getLoaihinh(procedureId) {
            if (procedureId === 'BGTVT0600048') {
                return 1;
            }
            if (procedureId === 'BGTVT0600049') {
                return 2;
            }
            if (procedureId === 'BGTVT0600050') {
                return 3;
            }
            if (procedureId === 'BGTVT0600051') {
                return 4;
            }
        };

        self.dong = function () {
            location.href = app.appContext + '/mt/48/home/' + self.hoSoChiTiet.Tbdhoso.fiLoaiHoSo();
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
            ko.utils.arrayFirst(self.danhSachFile(), function (item) {
            	self.hoSoChiTiet.Tbddinhkem.push(item.fileDK)
            });
            $('#loading_c4e6a343-dd41-b5c5-1ef9-75eeebba032d').show();

            if (self.danhSachFileCheck().length > 0) {
                app.uploadMutipleFile({
                    url: '/mt/48/saveWithFile/' + functionType,
                    data: app.convertFormObservableJson(self.hoSoChiTiet),
                    timeout: self.timeout,
                    success: function (d) {
                        $('#loading_c4e6a343-dd41-b5c5-1ef9-75eeebba032d').hide();
                        var msg = '';
                        var fun = 'success';
                        
                        if (d.success) {
                            self.files = ko.observableArray();
                            self.danhSachFileCheck = ko.observableArray(0);
                            msg = 'Lưu thành công!';
                            location.href = app.appContext + '/mt/48/home/' + self.hoSoChiTiet.Tbdhoso.fiLoaiHoSo();
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
                    url: '/mt/48/call_service',
                    data: JSON.stringify({
                        URL_BACKEND: "/mt/48/hoso/save/" + functionType,
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

                            location.href = app.appContext + '/mt/48/home/' + self.hoSoChiTiet.Tbdhoso.fiLoaiHoSo();
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
        // -- file
        self.danhSachFileCheck = ko.observableArray(0);
        var totalSize = 0;
        self.uploadFileChangeEvent = function (data, event) {

            var files = event.target.files;
            var eleId = data.fiMaDanhmuc();
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

            var totalMB = 5242880;//5MB
            var this_total = 0;
            $(files).each(function (index, item) {
                totalSize += item.size;
                this_total += item.size;
            });

            if (totalSize > totalMB) {
                $('#' + eleId).val('');
                //cssError(eleId);
                alert(NSWLang['file_msg_dung_luong_toi_da'].format(5));
                totalSize -= this_total;
                return false;
            }
            
            for (var i = 0, file; file = files[i]; i++) {
                var dinhkem = new Tbddinhkem();
                dinhkem.fiTenChungTu(file.name);
                dinhkem.fiIdHoSo(hoSoId);
                dinhkem.fiTenFile(file.name);
                dinhkem.fiSothutu(data.fiIdDanhmuc());
                dinhkem.file = file;
                dinhkem.fiMaChungTu(data.fiMaDanhmuc());
                
                self.danhSachFile.push({ma : data.fiMaDanhmuc(), fileDK : dinhkem});
                self.danhSachFileCheck.push({ma : data.fiMaDanhmuc(), fileDK : dinhkem});
                //self.files.push(file);
            }
        }

        self.xoaMotFile = function (item) {
            
            var vId ;
            self.danhSachFile.remove(function(file) {
            	if(file.fileDK == item){
            		vId = file.ma;
            	}
                return file.fileDK == item;
            });
            totalSize -= item.file.size;
            resetInput($("#" + vId));
            //self.files.remove(item);
            self.danhSachFileCheck.remove(function(file1) {
                return file1.fileDK == item;
            });
        }

        self.xoaTepTin = function (maDanhMuc) {
        	var vId;
        	var itemm;
            
        	self.danhSachFile.remove(function(file) {

        		itemm = file.fileDK;
        		if(file.ma == maDanhMuc){
                    totalSize -= itemm.file.size;
                    //self.files.remove(itemm);

                }
        		return file.ma == maDanhMuc;
        	});
            self.danhSachFileCheck.remove(function(file1) {
                return file1.ma == maDanhMuc;
            });

            resetInput($("#" + maDanhMuc));
        }
        //----
        /*self.themPhuongtien = function () {
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
        }*/
/* thêm phương tiện */
        if (hoSoId) {
            app.makePost({
                url: '/mt/48/call_service',
                data: JSON.stringify({
                    URL_BACKEND: "/mt/48/hoso/detail",
                    METHOD: "POST",
                    REQUEST: hoSoId
                }),
                success: function (d) {
                    $('#loading_c4e6a343-dd41-b5c5-1ef9-75eeebba032d').hide();
                    var msg = '';
                    var fun = 'success';
                    if (d.success) {

                        self.hoSoChiTiet = app.convertObjectToObservable(d.data, self.hoSoChiTiet);
                        self.hoSoChiTiet.Tbdhoso.fixedRoadTransport(d.data.Tbsloaihinhvantai.fixedRoadTransport);
                        var i = 1;
                        for (const phuongtien of d.data.Tbdphuongtien) {
                            var pt = app.convertObjectToObservable(phuongtien, new Tbdphuongtien());
                            pt.fiStt(i);
                            self.hoSoChiTiet.Tbdphuongtien.push(pt);
                            i++;
                        }
                        self.customPagination.loadPage(self.hoSoChiTiet.Tbdphuongtien());
                        self.danhSachFile.removeAll();
                        for (const file of d.data.Tbddinhkem) {

                            self.danhSachFile.push({ma : file.fiMaChungTu, fileDK : app.convertObjectToObservable(file, new Tbddinhkem())});

                        }
                        if (!editMode) {
                            $("#detailForm :input").prop("disabled", true);
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
            self.hoSoChiTiet.Tbdhoso.fiIdTrangThai(0);
            self.hoSoChiTiet.Tbdhoso.fiTenTrangThai('Mới tạo');
            self.hoSoChiTiet.Tbdhoso.fiNgayTao(new Date());
            self.hoSoChiTiet.Tbdhoso.fiLoaiHoSo(procedureId);
            //self.hoSoChiTiet.Tbdhoso.fiTenThuTuc(procedureId);
            self.hoSoChiTiet.Tbdhoso.fiLoaiHinh(getLoaihinh(procedureId));
            self.hoSoChiTiet.Tbdhoso.fiMaNguoiTao(userCustom.username);
            self.hoSoChiTiet.Tbdhoso.fiNguoiTao(userCustom.companyName);
        }
        self.danhSachBKS = ko.observableArray(0);
        app.makePost({
            url: '/mt/48/call_service',
            data: JSON.stringify({
                URL_BACKEND: "/mt/pt/qlpt/getBKS/" + userCustom.username,
                METHOD: "GET",
                REQUEST: {}
            }),
            success: function (d) {
                $('#loading_c4e6a343-dd41-b5c5-1ef9-75eeebba032d').hide();
                var msg = '';
                var fun = 'success';
                
                if (d.success) {
                    for (const item of d.data) {
                        var itemBind = {};
                        //self.danhSachBKS.push(app.convertObjectToObservable(item, itemBind));
                        self.danhSachBKS.push({id : item, name : item});

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
        function XeVM(op) {
            var form = this;
            var xe = op;
            form.fiIdXe = ko.observable(xe ? xe.fiStt() : null);
            form.id = ko.observable();
            form.fiBksXe = ko.observable(xe ? xe.fiBienSo() : null).extend({
                required: {message: 'Biển số không được trống !', params: true}
            });
            form.fiMaNhanHieu = ko.observable(xe ? xe.fiMaNhanHieu() : null);
            form.fiTenNhanHieu = ko.observable(xe ? self.getTenNhanhieu(xe.fiMaNhanHieu()) : null);
            form.fiTuNgay = ko.observable(xe ? xe.fiTuNgay() : null).extend({required: {message: 'Từ ngày cấp phép không được trống!', params: true}});
            form.fiDenNgay = ko.observable(xe ? xe.fiDenNgay() : null).extend({required: {message: 'Đến ngày cấp phép không được trống!', params: true}});
            form.fiSoGhe = ko.observable(xe ? xe.fiTrongTai() : null);
            form.fiTenChuxe = ko.observable(xe ? xe.fiTenSoHuu() : null);
            form.fiNamSx = ko.observable(xe ? xe.fiNamSanXuat() : null);
            form.fiSoKhung = ko.observable(xe ? xe.fiSoKhung() : null);
            form.fiSoMay = ko.observable(xe ? xe.fiSoMay() : null);
            form.fiMauSon = ko.observable(xe ? xe.fiMauSon() : null);
            form.fiMaCuaKhau = ko.observable(xe ? xe.fiMaCuaKhau() : null).extend({required: {message: 'Mã cửa khẩu không được trống!', params: true}});
            form.fiHinhThucHD = ko.observable(xe ? xe.fiHinhThucHD() : null).extend({required: {message: 'Hình thức hoạt động không được trống!', params: true}});
            //form. = ko.observable().extend({required: {message: 'Đơn vị không được trống!'}});
            form.lstBKS= self.danhSachBKS();
            form.lstNhanHieu= self.danhSachNhanHieu();
            form.lstCuaKhau= self.danhSachCuaKhau();
            form.objectTypeDate = ['fiTuNgay', 'fiDenNgay'];
            form.getDetailXe = function (data) {
            	
                if (data.fiBksXe()) {
                    $('#loading10').show();
                    app.makePost({
                        url: '/mt/48/call_service',
                        data: JSON.stringify({
                            URL_BACKEND: "/mt/qlpt/getByBksXe2?BksXe=" + data.fiBksXe(),
                            METHOD: "GET",
                            REQUEST: {}
                        }),
                        success: function (d) {
                            $('#loading10').hide();
                            var msg = '';
                            var fun = 'success';
                            
                            if (d.success) {
                                var xe = d.data;
                                if (xe) {
                                    form.fiBksXe(xe.fiBksXe);
                                    form.fiSoGhe(xe.fiSoGhe);
                                    form.fiTenChuxe(xe.fiTenChuxe);
                                    form.fiNamSx(xe.fiNamSx);
                                    form.fiSoKhung(xe.fiSoKhung);
                                    form.fiSoMay(xe.fiSoMay);
                                    form.fiMaNhanHieu(xe.fiMaNhanhieu);
                                    form.fiTenNhanHieu(xe.fiTenNhanhieu);
                                    form.fiMauSon(xe.fiTenMauson);

                                }
                            } else {
                                msg = data.message;
                                fun = 'error';
                            }

                        },
                        error: function (e) {
                            $('#loading10').hide();
                            
                            toastr.error(e.message, NSWLang["common_msg_thong_bao"]);
                            self.showActionSuccess(false);
                            self.showActionError(true);
                            self.errorMessage(e.message);
                            $('html,body').scrollTop(0);
                        }
                    });
                }
            };
        }



        self.updateXe = function (item){
            
            self.xeVM = new XeVM(item);
            $.ajax({
                url: context + '/app/mt/p48/templates/update_xe.html',
                method: 'GET',
                async: false,
                success: function (html) {
                    pop = app.popup({
                        title: 'Cập nhật thông tin xe',
                        html: html,
                        width: 1024,
                        buttons: [
                            {
                                name: 'Lưu',
                                class: 'btn',
                                icon: 'fa-save',
                                action: function () {
                                    
                                    if(!app.checkValidate(self.xeVM)){
                                        app.AlertWithBtn('Bạn phải nhập vào đầy đủ thông tin của xe.');
                                        self.errors3.showAllMessages(true);
                                    }
                                    else {
                                        self.errors3.showAllMessages(false);
                                        if(self.xeVM.fiIdXe() == null){
                                            var pt = new Tbdphuongtien();
                                            pt.fiStt(self.hoSoChiTiet.Tbdphuongtien().length + 1);
                                            pt.fiBienSo(self.xeVM.fiBksXe())
                                            pt.fiTenSoHuu(self.xeVM.fiTenChuxe())
                                            pt.fiMaNhanHieu(self.xeVM.fiMaNhanHieu())
                                            pt.fiTrongTai(self.xeVM.fiSoGhe())
                                            pt.fiNamSanXuat(self.xeVM.fiNamSx())
                                            pt.fiSoKhung(self.xeVM.fiSoKhung())
                                            pt.fiSoMay(self.xeVM.fiSoMay())
                                            pt.fiMauSon(self.xeVM.fiMauSon())
                                            pt.fiTuNgay(self.xeVM.fiTuNgay())
                                            pt.fiDenNgay(self.xeVM.fiDenNgay())
                                            pt.fiHinhThucHD(self.xeVM.fiHinhThucHD())
                                            pt.fiMaCuaKhau(self.xeVM.fiMaCuaKhau())
                                            pt.fiTenNhanHieu(self.xeVM.fiTenNhanHieu());
                                            self.hoSoChiTiet.Tbdphuongtien.push(pt);
                                            self.customPagination.lastPage(true);
                                            self.customPagination.loadPage(self.hoSoChiTiet.Tbdphuongtien());

                                        }else{
                                            var old = ko.utils.arrayFirst(self.hoSoChiTiet.Tbdphuongtien(), function (item) {
                                                return item.fiStt() == self.xeVM.fiIdXe();
                                            });
                                            item.fiBienSo(self.xeVM.fiBksXe())
                                            item.fiTenSoHuu(self.xeVM.fiTenChuxe())
                                            item.fiMaNhanHieu(self.xeVM.fiMaNhanHieu())
                                            item.fiTrongTai(self.xeVM.fiSoGhe())
                                            item.fiNamSanXuat(self.xeVM.fiNamSx())
                                            item.fiSoKhung(self.xeVM.fiSoKhung())
                                            item.fiSoMay(self.xeVM.fiSoMay())
                                            item.fiMauSon(self.xeVM.fiMauSon())
                                            item.fiTuNgay(self.xeVM.fiTuNgay())
                                            item.fiDenNgay(self.xeVM.fiDenNgay())
                                            item.fiHinhThucHD(self.xeVM.fiHinhThucHD())
                                            item.fiMaCuaKhau(self.xeVM.fiMaCuaKhau())
                                            item.fiTenNhanHieu(self.xeVM.fiTenNhanHieu());
                                            self.hoSoChiTiet.Tbdphuongtien.replace(old, item);
                                        }

                                        app.popupRemove(pop.selector);
                                        $('.modal-scrollable').hide();
                                        $('.modal-backdrop').hide();
                                    }
                                }
                            },
                            {
                                name: 'Đóng',
                                class: 'btn',
                                icon: 'fa-check',
                                action: function () {
                                    app.popupRemove(pop.selector);
                                    $('.modal-scrollable').hide();
                                    $('.modal-backdrop').hide();
                                }
                            }
                        ]
                    });
                    self.errors3 = ko.validation.group(self.xeVM, {deep: true});
                    ko.applyBindings(self.xeVM, pop[0]);
                    $('.example').datepicker({
                        format: "dd/mm/yyyy"
                    }).on('change', function(){
                        $('.datepicker').hide();
                    });
                    if (item != null) {
                        $("#fiBksXe-New").val(item.fiBienSo()).select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
                        $("#fiHTHD-New").val(item.fiHinhThucHD()).select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
                        $("#fiCuaKhau-New").val(item.fiMaCuaKhau()).select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
                        $("#fiMaCkXn-New").val(item.fiMaNhanHieu()).select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
                    } else {
                        $("#fiBksXe-New").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
                        $("#fiCuaKhau-New").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
                        $("#fiHTHD-New").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
                        $("#fiMaCkXn-New").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
                    }
                }
            });

        }

        self.xoaPhuongtien = function (item) {
            self.hoSoChiTiet.Tbdphuongtien.splice(self.hoSoChiTiet.Tbdphuongtien.indexOf(item), 1);
            for (var i = 0; i < self.hoSoChiTiet.Tbdphuongtien().length; i++) {
                self.hoSoChiTiet.Tbdphuongtien()[i].fiStt(i + 1);
            }
            self.customPagination.firstPage(true);
            self.customPagination.loadPage(self.hoSoChiTiet.Tbdphuongtien());
        }
        self.themPhuongtien = function () {
            self.updateXe(null);
        }
        self.suaPhuongtien = function (item) {
            self.updateXe(item);
        }

        /*---- end phương tiện -----*/
        self.editOk = function (item) {
            if (app.checkValidate(item)) {
                item.editing(false);
            } else {
                self.errors3().showAllMessages(true);
            }
        }

        self.chonTuyenVanTai = function () {

            if (self.hoSoChiTiet.Tbdhoso.fiMaTuyen()) {
                for (const tuyen of self.danhSachTuyen()) {
                    if (tuyen.fiMaTuyen() === self.hoSoChiTiet.Tbdhoso.fiMaTuyen()) {
                        self.getBenXeById(tuyen.fiBenDi(), self.hoSoChiTiet.Tbdhoso.fiBenDi, self.hoSoChiTiet.Tbdhoso.fiTenTinhDi);
                        self.getBenXeById(tuyen.fiBenDen(), self.hoSoChiTiet.Tbdhoso.fiBenDen, self.hoSoChiTiet.Tbdhoso.fiTenTinhDen);
                        self.hoSoChiTiet.Tbdhoso.fiCuLy(tuyen.fiKhoangcach());
                        self.hoSoChiTiet.Tbdhoso.fiHanhTrinh(tuyen.fiHanhtrinh());
                        // self.hoSoChiTiet.Tbdhoso.fiSogiaytochapthuan(tuyen.fiSocvChapthuan());
                        // self.hoSoChiTiet.Tbdhoso.fiNgaychapthuan(tuyen.fiLlDacap());
                    }
                }
            }
        }

        self.getTinhById = function (fiMa, func) {
            app.makePost({
                url: '/mt/48/call_service',
                data: JSON.stringify({
                    URL_BACKEND: "/mt/danhmuc/tinhthanh/search",
                    METHOD: "POST",
                    REQUEST: {fiMa:fiMa}
                }),
                success: function (d) {
                    $('#loading_c4e6a343-dd41-b5c5-1ef9-75eeebba032d').hide();
                    var msg = '';
                    var fun = 'success';
                    
                    if (d.success) {
                        d.data.forEach(function(value, index){
                            if(value.fiMa == fiMa){
                                func(value.fiTen);
                                return value;
                            }
                        })

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

        self.getBenXeById = function (fiMaBen, funcGa, funcTinh) {
            app.makePost({
                url: '/mt/48/call_service',
                data: JSON.stringify({
                    URL_BACKEND: "/mt/danhmuc/benxe/search",
                    METHOD: "POST",
                    REQUEST: {fiMaBen: fiMaBen}
                }),
                success: function (d) {
                    $('#loading_c4e6a343-dd41-b5c5-1ef9-75eeebba032d').hide();
                    var msg = '';
                    var fun = 'success';
                    if (d.success) {
                        if(d.data.length>0){
                            funcGa(d.data[0].fiTenBen);
                            self.getTinhById(d.data[0].fiMaTinh, funcTinh);
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
        	var flag = true;
        	var check = ko.utils.arrayFirst(self.danhSachThuTucFile(), function (item) {
        		
        		if(self.danhSachFile().length == 0){
        			flag = false;
        			return false;
        		}
        		if(item.fiMaDanhmuc() != 'GTK'){
        			if(self.getDsByName(item.fiMaDanhmuc()).length == 0){
        				flag = false;
        				return false;
        			}
        		}
                
            });
            if (!check && !flag) {
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

        self.downloadAll = function (maDanhMuc) {
             for (var i = 0; i < self.getDsByName(maDanhMuc).length; i++) {
            	 
                 self.download(self.getDsByName(maDanhMuc)[i]);
             }
            
        }

        self.download = function (item) {
            if (item.fiIdDinhKem()) {
                $('#loading_c4e6a343-dd41-b5c5-1ef9-75eeebba032d').show();
                
                app.makeGet({

                    url: "/mt/48/download/" + item.fiIdDinhKem(), // my URL
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
                self.hoSoChiTiet.Tbdhoso.fiMaTuyen('');
                self.hoSoChiTiet.Tbdhoso.fiTenTinhDi('');
                self.hoSoChiTiet.Tbdhoso.fiBenDi('');
                self.hoSoChiTiet.Tbdhoso.fiTenTinhDen('');
                self.hoSoChiTiet.Tbdhoso.fiBenDen('');
                self.hoSoChiTiet.Tbdhoso.fiCuLy('');
                self.hoSoChiTiet.Tbdhoso.fiHanhTrinh('');
                self.hoSoChiTiet.Tbdhoso.fiSoCongVan('');
                self.hoSoChiTiet.Tbdhoso.fiCoQuanCapPhep('');
                self.hoSoChiTiet.Tbdhoso.fiNgayCapCongVan('');
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
            url: '/mt/48/call_service',
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

        self.getDsByName = function (name) {
        	self.list = ko.observableArray();
            ko.utils.arrayFirst(self.danhSachFile(), function (item) {
            	
                if(item.ma == name){
                	self.list.push(item.fileDK);
                }
            });
            return self.list();
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