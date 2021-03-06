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


        
        self.hoSoChiTiet = new HosoChiTietModel();        
        self.phuongtien = new Tbdphuongtien();
        self.tbgiahan = new TbdGiaHan();

        self.danhSachFile = ko.observableArray(0);
        self.danhSachThuTucFile = ko.observableArray();
        self.danhSachDonVi = ko.observableArray(0);


        self.danhSachTuyen = ko.observableArray(0);

        self.danhSachCuaKhau = ko.observableArray(0);

        self.danhSachNhanHieu = ko.observableArray(0);

        self.userCust = new UserCustom();


        app.makePost({
            url: '/mt/18/call_service',
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
            url: '/mt/18/call_service',
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
            url: '/mt/18/call_service',
            data: JSON.stringify({
                URL_BACKEND: "/mt/danhmuc/cqxl/getbyMaThuTuc/" + procedureId,
                METHOD: "GET",
                REQUEST: {}
            }),
            success: function (d) {
                $('#loading_c4e6a343-dd41-b5c5-1ef9-75eeebba032d').hide();
                var msg = '';
                var fun = 'success';
                
//                var item = {fiTenCqxl: 'DEMO', fiIdCqxl: 1};
//                self.danhSachDonVi.push(app.convertObjectToObservable(item, {}));

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

        //giahan

        function loadGiaHan(){
        	 app.makePost({
                 url: '/mt/18/call_service',
                 data: JSON.stringify({
                     URL_BACKEND: "/mt/18/giaHan/getById",
                     METHOD: "POST",
                     REQUEST: hoSoId
                 }),
                 success: function (d) {
                     $('#loading_c4e6a343-dd41-b5c5-1ef9-75eeebba032d').hide();
                     var msg = '';
                     var fun = 'success';

                     if (d.success) {
                     	self.hoSoChiTiet.TbdGiaHan= app.convertObjectToObservable(d.data, self.hoSoChiTiet.TbdGiaHan) ;
                     	 self.hoSoChiTiet.TbdGiaHan.fiLoaiGiaHan(self.hoSoChiTiet.TbdGiaHan.fiLoaiGiaHan().toString());
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
             //
        }


        function saveGiaHan(id ){
        	self.hoSoChiTiet.TbdGiaHan.fiIdHoso(id);
        	 app.makePost({
                 url: '/mt/18/call_service',
                 data: JSON.stringify({
                     URL_BACKEND: "/mt/18/giaHan/save",
                     METHOD: "POST",
                     REQUEST: app.convertFormObservableJson(self.hoSoChiTiet.TbdGiaHan)
                 }),
                 timeout: self.timeout,
                 success: function (d) {
                     $('#loading_c4e6a343-dd41-b5c5-1ef9-75eeebba032d').hide();
                     var msg = '';
                     var fun = 'success';
                     
                     if (d.success) {
                         msg = 'Lưu thành công!';
                         location.href = app.appContext + '/mt/18/home/' + self.hoSoChiTiet.Tbdhoso.fiLoaihoso();
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
        ////



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
                url: '/mt/18/call_service',
                data: JSON.stringify({
                    URL_BACKEND: "/mt/18/hoso/detail",
                    METHOD: "POST",
                    REQUEST: hoSoId
                }),
                success: function (d) {
                    $('#loading_c4e6a343-dd41-b5c5-1ef9-75eeebba032d').hide();
                    var msg = '';
                    var fun = 'success';
                    if (d.success) {
                        self.hoSoChiTiet = app.convertObjectToObservable(d.data, self.hoSoChiTiet);


                        self.danhSachFile.removeAll();
                        for (const file of d.data.Tbddinhkem) {

                            self.danhSachFile.push({
                                ma: file.fiMaDinhkem,
                                fileDK: app.convertObjectToObservable(file, new Tbddinhkem())
                            });

                        }
                        if (!editMode) {
                            $("#detailForm :input").prop("disabled", true);
                        }
                        loadGiaHan();


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
            //self.hoSoChiTiet.Tbdhoso.fiTenThutuc(titleLabel);
            self.hoSoChiTiet.Tbdhoso.fiLoaihinh(getLoaihinh(procedureId));
            self.hoSoChiTiet.Tbdhoso.fiManguoitao(userCustom.username);
            self.hoSoChiTiet.Tbdhoso.fiNguoitao(userCustom.companyName);
        }

        function getLoaihinh(procedureId) {
            if (procedureId === 'BGTVT0600018') {
                return 1;
            }
            if (procedureId === 'BGTVT0600035') {
                return 2;
            }
            if (procedureId === 'BGTVT0600057') {
                return 3;
            }
            if (procedureId === 'BGTVT0600065') {
                return 4;
            }
        };

        self.dong = function () {
            location.href = app.appContext + '/mt/18/home/' + self.hoSoChiTiet.Tbdhoso.fiLoaihoso();
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
                    url: '/mt/18/saveWithFile/' + functionType,
                    data: app.convertFormObservableJson(self.hoSoChiTiet),
                    timeout: self.timeout,
                    success: function (d) {
                        $('#loading_c4e6a343-dd41-b5c5-1ef9-75eeebba032d').hide();
                        var msg = '';
                        var fun = 'success';
                        
                        if (d.success) {
                            self.danhSachFileCheck = ko.observableArray(0);
                            msg = 'Lưu thành công!';
                            location.href = app.appContext + '/mt/18/home/' + self.hoSoChiTiet.Tbdhoso.fiLoaihoso();
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
                    url: '/mt/18/call_service',
                    data: JSON.stringify({
                        URL_BACKEND: "/mt/18/hoso/save/" + functionType,
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
                            location.href = app.appContext + '/mt/18/home/' + self.hoSoChiTiet.Tbdhoso.fiLoaihoso();

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
                dinhkem.fiTenDinhkem(file.name);
                dinhkem.fiIdHoso(hoSoId);
                dinhkem.fiTenFile(file.name);
                dinhkem.fiSothutu(data.fiIdDanhmuc());
                dinhkem.file = file;
                dinhkem.fiMaDinhkem(data.fiMaDanhmuc());

                self.danhSachFile.push({ma: data.fiMaDanhmuc(), fileDK: dinhkem});
                self.danhSachFileCheck.push({ma: data.fiMaDanhmuc(), fileDK: dinhkem});
                //self.files.push(file);
            }
        }

        self.xoaMotFile = function (item) {
            var vId;
            self.danhSachFile.remove(function (file) {
                if (file.fileDK == item) {
                    vId = file.ma;
                }
                return file.fileDK == item;
            });
            totalSize -= item.file.size;
            resetInput($("#" + vId));
            //self.files.remove(item);
            self.danhSachFileCheck.remove(function (file1) {
                return file1.fileDK == item;
            });
        }

        self.xoaTepTin = function (maDanhMuc) {
            var vId;
            var itemm;
            self.danhSachFile.remove(function (file) {

                itemm = file.fileDK;
                if (file.ma == maDanhMuc) {
                    totalSize -= itemm.file.size;
                    //self.files.remove(itemm);

                }
                return file.ma == maDanhMuc;
            });
            self.danhSachFileCheck.remove(function (file1) {
                return file1.ma == maDanhMuc;
            });

            resetInput($("#" + maDanhMuc));
        }


    //============ HoSo Xe ===========
        self.danhSachBKS = ko.observableArray();
        app.makePost({
            url: '/mt/18/call_service',
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




        function resetInput(controlId) {
            controlId.replaceWith(controlId.val('').clone(true));
        };

        self.isValidateForm = function () {
            if (!app.checkValidate(self.hoSoChiTiet)) {
                self.errors.showAllMessages();
                app.AlertWithBtn("Bạn chưa nhập đủ thông tin yêu cầu");
                return false;
            }

            var flag = true;
            var check = ko.utils.arrayFirst(self.danhSachThuTucFile(), function (item) {
                if (self.danhSachFile().length == 0) {
                    flag = false;
                    return false;
                }
                if (item.fiMaDanhmuc() != 'HS_GTK') {
                    if (self.getDsByName(item.fiMaDanhmuc()).length == 0) {
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
            if (item.fiIdDinhkem()) {
                $('#loading_c4e6a343-dd41-b5c5-1ef9-75eeebba032d').show();
                app.makeGet({
                    url: "/mt/18/download/" + item.fiIdDinhkem(), // my URL
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


        self.danhSachTrangThai = ko.observableArray(0);
        app.makePost({
            url: '/mt/18/call_service',
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

                if (item.ma == name) {
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