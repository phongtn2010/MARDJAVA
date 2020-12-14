/**
 * @returns
 */
/**
 * @returns
 */
$(document).ready(function () {
    function ViewModel() {
        var self = this;
        self.accepFiles = ['jpg', 'jpeg', 'pdf', 'tif'];
        self.files = ko.observableArray(); // danh sach tat cả file dinh kem
        self.contextPath = ko.observable($('#contextPath').val());


        $('.date-picker').datepicker({rtl: false, orientation: "left", autoclose: true});

        self.showActionError = ko.observable(false);
        self.showActionSuccess = ko.observable(false);
        self.errorMessage = ko.observable('');

        self.GDD = ko.observableArray();
        self.HDTPT = ko.observableArray();
        self.DKPT = ko.observableArray();
        self.GCN_001 = ko.observableArray();
        self.GTK = ko.observableArray();

        // danh sach ho so

        self.hoSoChiTiet = new HosoChiTietModel();

        self.phuongtien = new Tbdphuongtien();

        self.danhSachDonVi = ko.observableArray(0);

        self.danhSachTuyen = ko.observableArray(0);

        self.danhSachCuaKhau = ko.observableArray(0);

        self.danhSachNhanHieu = ko.observableArray(0);

        self.userCust = new UserCustom();

        $("#detailForm :input").prop("disabled", true);
        app.makePost({
            url: '/mt/qlgp/48/call_service',
            data: JSON.stringify({
                URL_BACKEND: "/mt/danhmuc/tuyen/search",
                METHOD: "POST",
                REQUEST: {}
            }),
            success: function (d) {
                $('#loading_c4e6a343-dd41-b5c5-1ef9-75eeebba032d').hide();
                var msg = '';
                var fun = 'success';
                console.log(d);
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
                console.log(e);
                toastr.error(e.message, NSWLang["common_msg_thong_bao"]);
                self.showActionSuccess(false);
                self.showActionError(true);
                self.errorMessage(e.message);
                $('html,body').scrollTop(0);
            }
        });

        app.makePost({
            url: '/mt/qlgp/48/call_service',
            data: JSON.stringify({
                URL_BACKEND: "/mt/danhmuc/cqxl/getbyMaThuTuc/" + procedureId,
                METHOD: "GET",
                REQUEST: {}
            }),
            success: function (d) {
                $('#loading_c4e6a343-dd41-b5c5-1ef9-75eeebba032d').hide();
                var msg = '';
                var fun = 'success';
                console.log(d);
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
                console.log(e);
                toastr.error(e.message, NSWLang["common_msg_thong_bao"]);
                self.showActionSuccess(false);
                self.showActionError(true);
                self.errorMessage(e.message);
                $('html,body').scrollTop(0);
            }
        });

        app.makePost({
            url: '/mt/qlgp/48/call_service',
            data: JSON.stringify({
                URL_BACKEND: "/mt/danhmuc/nhanhieu/search",
                METHOD: "POST",
                REQUEST: {}
            }),
            success: function (d) {
                $('#loading_c4e6a343-dd41-b5c5-1ef9-75eeebba032d').hide();
                var msg = '';
                var fun = 'success';
                console.log(d);
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
                console.log(e);
                toastr.error(e.message, NSWLang["common_msg_thong_bao"]);
                self.showActionSuccess(false);
                self.showActionError(true);
                self.errorMessage(e.message);
                $('html,body').scrollTop(0);
            }
        });

        app.makePost({
            url: '/mt/qlgp/48/call_service',
            data: JSON.stringify({
                URL_BACKEND: "/mt/danhmuc/cuakhau/search",
                METHOD: "POST",
                REQUEST: {"fiIdNhomTt": 6}
            }),
            success: function (d) {
                $('#loading_c4e6a343-dd41-b5c5-1ef9-75eeebba032d').hide();
                var msg = '';
                var fun = 'success';
                console.log(d);
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
                console.log(e);
                toastr.error(e.message, NSWLang["common_msg_thong_bao"]);
                self.showActionSuccess(false);
                self.showActionError(true);
                self.errorMessage(e.message);
                $('html,body').scrollTop(0);
            }
        });

        app.makePost({
            url: '/mt/qlgp/48/call_service',
            data: JSON.stringify({
                URL_BACKEND: "/mt/file/getAll/" + procedureId,
                METHOD: "POST",
                REQUEST: {}
            }),
            success: function (d) {
                $('#loading_c4e6a343-dd41-b5c5-1ef9-75eeebba032d').hide();
                var msg = '';
                var fun = 'success';
                console.log(d);
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
                console.log(e);
                toastr.error(e.message, NSWLang["common_msg_thong_bao"]);
                self.showActionSuccess(false);
                self.showActionError(true);
                self.errorMessage(e.message);
                $('html,body').scrollTop(0);
            }
        });

        self.danhSachThuTucFile = ko.observableArray();

        self.danhSachFile = ko.observableArray(0);
        if (hoSoId) {
            app.makePost({
                url: '/mt/qlgp/48/call_service',
                data: JSON.stringify({
                    URL_BACKEND: "/mt/27/hoso/detail",
                    METHOD: "POST",
                    REQUEST: hoSoId
                }),
                success: function (d) {
                    $('#loading_c4e6a343-dd41-b5c5-1ef9-75eeebba032d').hide();
                    var msg = '';
                    var fun = 'success';
                    if (d.success) {
                        console.log("seach ok");
                        self.hoSoChiTiet = app.convertObjectToObservable(d.data, self.hoSoChiTiet);
                        for (const phuongtien of d.data.Tbdphuongtien) {
                            self.hoSoChiTiet.Tbdphuongtien.push(app.convertObjectToObservable(phuongtien, new Tbdphuongtien()));
                        }
                        self.danhSachFile.removeAll();
                        for (const file of d.data.Tbddinhkem) {

                            self.danhSachFile.push({ma : file.fiMaDinhkem, fileDK : app.convertObjectToObservable(file, new Tbddinhkem())});

                        }
                        console.log(self.hoSoChiTiet);
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
                    console.log(e);
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

        self.getDsByName = function (name) {
            self.list = ko.observableArray();
            ko.utils.arrayFirst(self.danhSachFile(), function (item) {

                if(item.ma == name){
                    self.list.push(item.fileDK);
                }
            });
            return self.list();
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

        console.log(check)
        if (!check && !flag) {
            app.AlertWithBtn("File đính kèm không được trống");
            return false;
        }



        function getLoaihinh(procedureId) {
            if (procedureId === 'BGTVT0600027') {
                return 1;
            }
            if (procedureId === 'BGTVT0600028') {
                return 2;
            }
            if (procedureId === 'BGTVT0600029') {
                return 3;
            }
            if (procedureId === 'BGTVT0600030') {
                return 4;
            }
        };


        self.dong = function () {
            location.href = app.appContext + '/mt/qlgp/48/home/' + self.hoSoChiTiet.Tbdhoso.fiLoaihoso();
        }

        self.isValidateForm = ko.computed(function () {
            return app.checkValidate(self.hoSoChiTiet)
                && (self.hoSoChiTiet.Tbsmucdichchuyendi.fiCongvu()
                    || self.hoSoChiTiet.Tbsmucdichchuyendi.fiKinhdoanh()
                    || self.hoSoChiTiet.Tbsmucdichchuyendi.fiCanhan()
                    || self.hoSoChiTiet.Tbsmucdichchuyendi.fiKhac())
                && self.hoSoChiTiet.Tbdphuongtien().length > 0;
            // && self.GDD().length > 0
            // && self.HDTPT().length > 0
            // && self.DKPT().length > 0
            // && self.GCN_001().length > 0;
        });

        self.uploadFileChangeEvent = function (loaiTep, eleId, elemet, event) {
            var files = event.target.files;
            console.log(files);
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
                    alert(NSWLang['file_msg_dung_luong_toi_da'].format(3));
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
                dinhkem.fiSothutu(loaiTep);
                dinhkem.file = file;
                if (loaiTep == 2) {
                    dinhkem.fiMaDinhkem('HDTPT');
                    self.HDTPT.push(dinhkem);
                } else if (loaiTep == 1) {
                    dinhkem.fiMaDinhkem('GDD');
                    self.GDD.push(dinhkem);
                } else if (loaiTep == 3) {
                    dinhkem.fiMaDinhkem('DKPT');
                    self.DKPT.push(dinhkem);
                } else if (loaiTep == 4) {
                    dinhkem.fiMaDinhkem('GCN_001');
                    self.GCN_001.push(dinhkem);
                } else if (loaiTep == 5) {
                    dinhkem.fiMaDinhkem('GTK');
                    self.GTK.push(dinhkem);
                }
                self.files.push(file);
            }
        }

        self.xoaMotFile = function (item) {
            console.log(item);
            if (item.fiSothutu() === 2) {
                self.HDTPT.remove(item);
                resetInput($("#HDCM"));
            } else if (item.fiSothutu() === 1) {
                self.GDD.remove(item);
                resetInput($("#GDD"));
            } else if (item.fiSothutu() === 3) {
                self.DKPT.remove(item);
                resetInput($("#DKPT"));
            } else if (item.fiSothutu() === 4) {
                self.GCN_001.remove(item);
                resetInput($("#GCN_001"));
            } else if (item.fiSothutu() === 5) {
                self.GTK.remove(item);
                resetInput($("#GTK"));
            }
            self.files.remove(item);
        }

        self.xoaTepTin = function (loaiTep) {
            if (loaiTep === '2') {
                for (var item in self.HDTPT()) {
                    self.files.remove(item);
                }
                self.HDTPT.removeAll();
                resetInput($("#HDTPT"));
            } else if (loaiTep === '1') {
                for (var item in self.GDD()) {
                    self.files.remove(item);
                }
                self.GDD.removeAll();
                resetInput($("#GDD"));
            } else if (loaiTep === '3') {
                for (var item in self.DKPT()) {
                    self.files.remove(item);
                }
                self.DKPT.removeAll();
                resetInput($("#DKPT"));
            } else if (loaiTep === '4') {
                for (var item in self.GCN_001()) {
                    self.files.remove(item);
                }
                self.GCN_001.removeAll();
                resetInput($("#GCN_001"));
            }
            else if (loaiTep === '5') {
                for (var item in self.GTK()) {
                    self.files.remove(item);
                }
                self.GTK.removeAll();
                resetInput($("#GTK"));
            }
        }

        self.themPhuongtien = function () {
            self.phuongtien.editing(false);
            self.hoSoChiTiet.Tbdphuongtien.push(app.cloneObject(self.phuongtien));
            app.resetObservable(self.phuongtien);
        }

        self.xoaPhuongtien = function (item) {
            self.hoSoChiTiet.Tbdphuongtien.splice(self.hoSoChiTiet.Tbdphuongtien.indexOf(item), 1);
        }
        self.suaPhuongtien = function (item) {
            item.editing(true);
        }
        self.editOk = function (item) {
            item.editing(false);
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
                url: '/mt/48/call_service',
                data: JSON.stringify({
                    URL_BACKEND: "/mt/danhmuc/tinhthanh/getById",
                    METHOD: "POST",
                    REQUEST: id
                }),
                success: function (d) {
                    $('#loading_c4e6a343-dd41-b5c5-1ef9-75eeebba032d').hide();
                    var msg = '';
                    var fun = 'success';
                    console.log(d);
                    if (d.success) {
                        console.log(d.data.fiTen);
                        func(d.data.fiTen);
                    } else {
                        msg = data.message;
                        fun = 'error';
                    }
                },
                error: function (e) {
                    $('#loading_c4e6a343-dd41-b5c5-1ef9-75eeebba032d').hide();
                    console.log(e);
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
                url: '/mt/48/call_service',
                data: JSON.stringify({
                    URL_BACKEND: "/mt/danhmuc/benxe/getById",
                    METHOD: "POST",
                    REQUEST: id
                }),
                success: function (d) {
                    $('#loading_c4e6a343-dd41-b5c5-1ef9-75eeebba032d').hide();
                    var msg = '';
                    var fun = 'success';
                    console.log(d);
                    if (d.success) {
                        console.log(d.data.fiTenBen);
                        funcGa(d.data.fiTenBen);
                        self.getTinhById(d.data.fiMaTinh, funcTinh);
                    } else {
                        msg = data.message;
                        fun = 'error';
                    }
                },
                error: function (e) {
                    $('#loading_c4e6a343-dd41-b5c5-1ef9-75eeebba032d').hide();
                    console.log(e);
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

        self.download = function (item) {
            if (item.fiIdDinhkem()) {
                $('#loading_c4e6a343-dd41-b5c5-1ef9-75eeebba032d').show();
                app.makeGet({
                    url: "/mt/48/download/" + item.fiIdDinhkem(), // my URL
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
    }

    ko.validation.init({
        insertMessages: true,
        messagesOnModified: true,
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
});
