/**
 * @returns
 */
/**
 * @returns
 */
$(document).ready(function () {
    function ViewModel() {
        var self = this;
        self.accepFiles = ['jpg', 'pdf', 'tif'];
        self.files = ko.observableArray(); // danh sach tat cả file dinh kem
        self.contextPath = ko.observable($('#contextPath').val());


        $('.date-picker').datepicker({rtl: false, orientation: "left", autoclose: true});

        self.showActionError = ko.observable(false);
        self.showActionSuccess = ko.observable(false);
        self.errorMessage = ko.observable('');

        self.HDBX = ko.observableArray();
        self.LVVC_02 = ko.observableArray();
        self.DKPT = ko.observableArray();
        self.HDTPT = ko.observableArray();
        self.GCN_001 = ko.observableArray();
        self.GTK = ko.observableArray();
        self.LVVCHH = ko.observableArray();
        self.LVHH = ko.observableArray();
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
            url: '/mt/qlgp/23/call_service',
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
            url: '/mt/qlgp/23/call_service',
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
            url: '/mt/qlgp/23/call_service',
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
            url: '/mt/qlgp/23/call_service',
            data: JSON.stringify({
                URL_BACKEND: "/mt/danhmuc/cuakhau/search",
                METHOD: "POST",
                REQUEST: {
                    "fiIdNhomTt": 6
                }
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
            url: '/mt/qlgp/23/call_service',
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
                url: '/mt/qlgp/23/call_service',
                data: JSON.stringify({
                    URL_BACKEND: "/mt/23/hoso/detail",
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
            if (procedureId === 'BGTVT0600023') {
                return 1;
            }
            if (procedureId === 'BGTVT0600024') {
                return 2;
            }
            if (procedureId === 'BGTVT0600025') {
                return 3;
            }
            if (procedureId === 'BGTVT0600026') {
                return 4;
            }
        };

        self.dong = function () {
            location.href = app.appContext + '/mt/qlgp/23/home/' + self.hoSoChiTiet.Tbdhoso.fiLoaihoso();
        }

        self.uploadFileChangeEvent = function (thutu, eleId, elemet, event) {
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
                dinhkem.fiSothutu(thutu);
                dinhkem.file = file;
                if (thutu == 0 && self.hoSoChiTiet.Tbdhoso.fiLoaihoso() == 'BGTVT0600024') {
                    dinhkem.fiMaDinhkem('LVHH');
                    self.LVHH.push(dinhkem);
                } else if (thutu == 0 && self.hoSoChiTiet.Tbdhoso.fiLoaihoso() == 'BGTVT0600025') {
                    dinhkem.fiMaDinhkem('LVVCHH');
                    self.LVVCHH.push(dinhkem);
                } else if (thutu == 1) {
                    dinhkem.fiMaDinhkem('HDBX');
                    self.HDBX.push(dinhkem);
                }
                else if (thutu == 2) {
                    dinhkem.fiMaDinhkem('LVVC_02');
                    self.LVVC_02.push(dinhkem);
                } else if (thutu == 3) {
                    dinhkem.fiMaDinhkem('DKPT');
                    self.DKPT.push(dinhkem);
                } else if (thutu == 4) {
                    dinhkem.fiMaDinhkem('HDTPT');
                    self.HDTPT.push(dinhkem);
                } else if (thutu == 5) {
                    dinhkem.fiMaDinhkem('GCN_001');
                    self.GCN_001.push(dinhkem);
                } else if (thutu == 6) {
                    dinhkem.fiMaDinhkem('GTK');
                    self.GTK.push(dinhkem);
                }
                self.files.push(file);
            }
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
                url: '/mt/23/call_service',
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
                url: '/mt/qlgp/23/call_service',
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

        self.isValidateForm = ko.computed(function () {
            return app.checkValidate(self.hoSoChiTiet)
                // && self.HDBX().length > 0
                // && self.LVVC_02().length > 0
                // && self.DKPT().length > 0
                // && self.HDTPT().length > 0
                // && self.GCN_001().length > 0
                && (self.hoSoChiTiet.Tbsloaihinhvantai.fixedRoadTransport()
                    || self.hoSoChiTiet.Tbsloaihinhvantai.contractRoadTransport()
                    || self.hoSoChiTiet.Tbsloaihinhvantai.passengerTransport()
                    || self.hoSoChiTiet.Tbsloaihinhvantai.cargoTransport())
                && self.hoSoChiTiet.Tbdphuongtien().length > 0;
        });

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
                    url: "/mt/qlgp/23/download/" + item.fiIdDinhkem(), // my URL
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
