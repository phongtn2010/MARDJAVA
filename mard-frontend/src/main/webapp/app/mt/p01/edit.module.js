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

            self.danhSachFile = ko.observableArray(0);
            self.danhSachThuTucFile = ko.observableArray();
            // danh sach ho so

            self.hoSoChiTiet = new HosoChiTietModel();

            self.danhSachDonVi = ko.observableArray(0);

            self.userCust = new UserCustom();

            if (userCustom) {
                self.userCust = app.convertObjectToObservable(userCustom, self.userCust);
                self.hoSoChiTiet.Tbdhoso.fiTendoanhnghiep(userCustom.companyName);
                self.hoSoChiTiet.Tbdhoso.fiDiachi(userCustom.companyAddress);
                self.hoSoChiTiet.Tbdhoso.fiDienthoai(userCustom.companyPhoneNumber);
                self.hoSoChiTiet.Tbdhoso.fiFax(userCustom.companyFax);
                self.hoSoChiTiet.Tbdhoso.fiEmail(userCustom.companyEmail);
            }
            if (!editMode) {
                $("#detailForm :input").prop("disabled", true);
            }
            app.makePost({
                url: '/mt/01/call_service',
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
                url: '/mt/01/call_service',
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


            if (hoSoId) {
                app.makePost({
                    url: '/mt/01/call_service',
                    data: JSON.stringify({
                        URL_BACKEND: "/mt/01/hoso/detail",
                        METHOD: "POST",
                        REQUEST: hoSoId
                    }),
                    success: function (d) {
                        $('#loading_c4e6a343-dd41-b5c5-1ef9-75eeebba032d').hide();
                        var msg = '';
                        var fun = 'success';
                        if (d.success) {
                            self.hoSoChiTiet = app.convertObjectToObservable(d.data, self.hoSoChiTiet);
                            for (const file of d.data.Tbddinhkem) {
                            	
                           	 self.danhSachFile.push({ma : file.fiMaDinhkem, fileDK : app.convertObjectToObservable(file, new Tbddinhkem())});
                               
                           }
                        } else {
                            app.toast({
                                title: NSWLang["common_msg_thong_bao"],
                                message: NSWLang["mt.msg.err"],
                                function: fun
                            });
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
            } else {
                self.hoSoChiTiet.Tbdhoso.fiTrangthai(0);
                self.hoSoChiTiet.Tbdhoso.fiTenTrangthai('Mới tạo');
                self.hoSoChiTiet.Tbdhoso.fiNgaytao(new Date());
                self.hoSoChiTiet.Tbdhoso.fiLoaihoso(procedureId);
               // self.hoSoChiTiet.Tbdhoso.fiTenThutuc(titleLabel);
                self.hoSoChiTiet.Tbdhoso.fiLoaihinh(getLoaihinh(procedureId));
                self.hoSoChiTiet.Tbdhoso.fiManguoitao(userCustom.username);
                self.hoSoChiTiet.Tbdhoso.fiNguoitao(userCustom.companyName);
            }


            self.dong = function () {
                location.href = app.appContext + '/mt/01/home/' + self.hoSoChiTiet.Tbdhoso.fiLoaihoso();
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
                        url: '/mt/01/saveWithFile/' + functionType,
                        data: app.convertFormObservableJson(self.hoSoChiTiet),
                        files: self.files,
                        mcode: "mt",
                        pcode: "01",
                        timeout: self.timeout,
                        success: function (d) {
                            $('#loading_c4e6a343-dd41-b5c5-1ef9-75eeebba032d').hide();
                            var msg = '';
                            var fun = 'success';
                            if (d.success) {
                                self.danhSachFileCheck = ko.observableArray(0);
                                if (hoSoId) {
                                    msg = NSWLang["mt.msg.update.success"];
                                } else {
                                    msg = NSWLang["mt.msg.add.success"];
                                }
                                app.toast({
                                    title: NSWLang["common_msg_thong_bao"],
                                    message: msg,
                                    function: fun
                                });
                                location.href = app.appContext + '/mt/01/home/' + self.hoSoChiTiet.Tbdhoso.fiLoaihoso();
                            } else {
                                msg = d.message;
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
                } else {
                    app.makePost({
                        url: '/mt/01/call_service',
                        data: JSON.stringify({
                            URL_BACKEND: "/mt/01/hoso/save/" + functionType,
                            METHOD: "POST",
                            REQUEST: app.convertFormObservableJson(self.hoSoChiTiet)
                        }),
                        timeout: self.timeout,
                        success: function (d) {
                            $('#loading_c4e6a343-dd41-b5c5-1ef9-75eeebba032d').hide();
                            var msg = '';
                            var fun = 'success';
                            if (d.success) {
                                if (hoSoId) {
                                    msg = NSWLang["mt.msg.update.success"];
                                } else {
                                    msg = NSWLang["mt.msg.add.success"];
                                }
                                location.href = app.appContext + '/mt/01/home/' + self.hoSoChiTiet.Tbdhoso.fiLoaihoso();
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

            function resetInput(controlId) {
                controlId.replaceWith(controlId.val('').clone(true));
            };

            self.isValidateForm = function () {
                //validate form
                if (!app.checkValidate(self.hoSoChiTiet)) {
                    self.errors.showAllMessages();
                    app.AlertWithBtn("Bạn chưa nhập đủ thông tin yêu cầu");
                    return false;
                }
                //validate loai hinh van tai
                if (!(self.hoSoChiTiet.Tbsloaihinhvantai.fixedRoadTransport()
                    || self.hoSoChiTiet.Tbsloaihinhvantai.contractRoadTransport()
                    || self.hoSoChiTiet.Tbsloaihinhvantai.passengerTransport()
                    || self.hoSoChiTiet.Tbsloaihinhvantai.cargoTransport()
                    || self.hoSoChiTiet.Tbsloaihinhvantai.passengerTaxi())) {
                    self.errors.showAllMessages();
                    app.AlertWithBtn("Bạn phải chọn ít nhất 1 loại hình vận tải");
                    return false;
                }
                //validate file dinh kem
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
                download(item);
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
            function download(item) {
                if (item.fiIdDinhkem()) {
                    $('#loading_c4e6a343-dd41-b5c5-1ef9-75eeebba032d').show();
                    app.makeGet({
                        url: "/mt/01/download/" + item.fiIdDinhkem(), // my URL
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

            function getLoaihinh(procedureId) {
                if (procedureId === 'BGTVT0600001') {
                    return 1;
                }
                if (procedureId === 'BGTVT0600002') {
                    return 2;
                }
                if (procedureId === 'BGTVT0600003') {
                    return 3;
                }
                if (procedureId === 'BGTVT0600004') {
                    return 4;
                }
            };

            self.danhSachTrangThai = ko.observableArray(0);
            app.makePost({
                url: '/mt/01/call_service',
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
            errorElementClass: 'wrong-field'
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

        vm.errors = ko.validation.group(vm, {deep: true});

        ko.applyBindings(vm);
    }
);
