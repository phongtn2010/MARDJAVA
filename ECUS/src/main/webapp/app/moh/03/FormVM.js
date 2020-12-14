/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function FormVM(options) {
    var self = this;
    var hosoInfo = (options !== null && options.hasOwnProperty('hoso')) ? options.hoso : null;

    self.fiIdHoso = ko.observable(null);
    self.fiMaHoso = ko.observable(null);
    self.fiNgaynop = ko.observable(null);
    self.fiTenTt = ko.observable(null);
    self.fiTrangthai = ko.observable(null);
    self.fiHoatdong = ko.observable(null);

    self.doanhnghiep03 = ko.observable(null);
    self.lstDonhang03 = ko.observableArray([]);
    self.lstCuakhau03 = ko.observableArray([]);
    self.lstDinhkem03 = ko.observableArray([]);

    self.lstDmCuakhau = ko.observableArray(mapCategory(options.hasOwnProperty('lstDmCuakhau') ? options.lstDmCuakhau : [], "fiCuakhauCode", "fiTenCuakhau"));
    self.lstDuoclieu = ko.observableArray(mapCategory(options.hasOwnProperty('lstDuoclieu') ? options.lstDuoclieu : [], "id", "fiTenDuoclieu"));
    self.lstDvt = ko.observableArray(mapCategory(options.hasOwnProperty('lstDvt') ? options.lstDvt : [], "code", "name"));
    self.lstTccl = ko.observableArray(mapCategory(options.hasOwnProperty('lstTccl') ? options.lstTccl : [], "id", "name"));
    self.lstQuocgia = ko.observableArray(mapCategory(options.hasOwnProperty('lstQuocgia') ? options.lstQuocgia : [], "fiMaQg", "fiTenQg"));

    var hosoVG = [];
    self.hosoErrors = ko.validation.group(hosoVG, {deep: true, live: true, observable: true});
    self.errorDinhKemMessage = ko.observable(null);

    // upload bieu mau excell
    self.fiTepTemp = ko.observable(null);
    self.canTemp = ko.computed(function () {
        return self.fiTepTemp() === null;
    }, this);

    self.canDeleteTemp = ko.computed(function () {
        return self.fiTepTemp() !== null;
    }, this);

    //Khoi tao gia tri ho so
    self.init = function (hoso) {
        if (hoso !== null) {
            self.fiIdHoso(hoso.hasOwnProperty('fiIdHoso') ? hoso.fiIdHoso : null);
            self.fiMaHoso(hoso.hasOwnProperty('fiMaHoso') ? hoso.fiMaHoso : null);
            self.fiNgaynop(hoso.hasOwnProperty('fiNgaynop') ? new Date(hoso.fiNgaynop) : null);
            self.fiTenTt(hoso.hasOwnProperty('fiTenTt') ? hoso.fiTenTt : null);
            self.fiTrangthai(hoso.hasOwnProperty('fiTrangthai') ? hoso.fiTrangthai : null);
            self.fiHoatdong(hoso.hasOwnProperty('fiHoatdong') ? hoso.fiHoatdong : null);
            var DNotp = {
                dn03: hoso.hasOwnProperty('doanhnghiep03') ? hoso.doanhnghiep03 : null
            };
            self.doanhnghiep03(new DoanhNghiep03FormVM(DNotp, hoso));

            self.lstDonhang03(mapHanghoa03(hoso.hasOwnProperty('lstDonhang03') ? hoso.lstDonhang03 : []));
            self.lstCuakhau03(mapCuakhau03(hoso.hasOwnProperty('lstCuakhau03') ? hoso.lstCuakhau03 : []));

            // self.lstDinhkem03(mapFiles03VM(hoso.hasOwnProperty('lstDinhkem03') ? hoso.lstDinhkem03 : [], self.fiIdHoso()));
            var lstFiles = hoso.hasOwnProperty('lstDinhkem03') ? hoso.lstDinhkem03 : [];
            var groups = {};
            for (var i = 0; i < lstFiles.length; i++) {
                debugger;
                var groupName = lstFiles[i].fiTenLoaiTl;
                if (!groups[groupName]) {
                    groups[groupName] = {
                        fiIdDinhkem: lstFiles[i].fiIdDinhkem,
                        fiIdHoso: lstFiles[i].fiIdHoso,
                        fiLoaiTailieu: lstFiles[i].fiLoaiTailieu,
                        fiTenLoaiTl: lstFiles[i].fiTenLoaiTl,
                        fiTenTailieu: lstFiles[i].fiTenTailieu,
                        fiDuongdanTl: lstFiles[i].fiDuongdanTl,
                        fiIdTailieu: lstFiles[i].fiIdTailieu,
                        fiBatbuoc: lstFiles[i].fiBatbuoc,
                        fiHoatdong: lstFiles[i].fiHoatdong,
                        fiNguoitao: lstFiles[i].fiNguoitao,
                        fiNgaytao: lstFiles[i].fiNgaytao,
                        fiSize: lstFiles[i].fiSize,
                        lstFiles: []
                    };
                }
                var cc = {
                    fiIdDinhkem: lstFiles[i].fiIdDinhkem,
                    fiTenTailieu: lstFiles[i].fiTenTailieu,
                    fiDuongdanTl: lstFiles[i].fiDuongdanTl,
                    fiSize: lstFiles[i].fiSize
                };
                if (cc.fiTenTailieu != null) {
                    groups[groupName].lstFiles.push(cc);
                }
            }
            lstFiles = [];
            for (var groupName in groups) {
                lstFiles.push(groups[groupName]);
            }
            self.lstDinhkem03(mapFiles03VM(lstFiles, self.fiIdHoso()));
        } else {
            self.doanhnghiep03(new DoanhNghiep03FormVM(options, hoso));
            getDmTeptin();
        }
    };

    function getDmTeptin() {
        app.getCategory('/moh/p03/danhmuc', 'DM_TEPTIN', null, function (res) {
            if (res.success) {
                self.lstDinhkem03(mapFiles03VM(res.data, self.fiIdHoso()));
            } else {
                self.lstDinhkem03([]);
            }
        });
    }

    self.init(hosoInfo);

    //VALIDATE DATA ON FORM
    //Convert to json object

    self.validFile = function () {
        var errorDinhkem = true;
        if (!self.lstDinhkem03() || self.lstDinhkem03().length <= 0) {
            errorDinhkem = false;
        } else {
            self.errorDinhKemMessage(null);
        }
        if (self.lstDinhkem03() && self.lstDinhkem03().length > 0) {
            for (var i = 0; i < self.lstDinhkem03().length; i++) {
                var attach = self.lstDinhkem03()[i];
                if (attach.isRequire()) {
                    if (!attach.lstFiles().length) {
                        $("#valid_dinhKem").show();
                        errorDinhkem = false;
                        break;
                    }
                }
            }
        }
        return errorDinhkem;

    };

    self.showValidCuakhau = function () {
        for (var i = 0; i < self.lstCuakhau03().length; i++) {
            var cuakhau = self.lstCuakhau03()[i];
            if (cuakhau.fiTenCuakhau() === undefined || cuakhau.fiTenCuakhau() === ""
                || cuakhau.fiMaCuakhau() === undefined || cuakhau.fiMaCuakhau() === "") {
                $('#cuakhau_lbl_' + (i + 1)).show();
            } else {
                $('#cuakhau_lbl_' + (i + 1)).hide();
            }
        }
    }

    self.showValidHH = function () {
        var flag = true;
        var hh = self.doanhnghiep03().validNgayCap();
        if (hh == false) {
            flag = false;
        }
        return flag;
    }

    self.showValidGPS = function () {
        var flag = true;
        var hhgps = self.doanhnghiep03().validNgayGSP();
        if (hhgps == false) {
            flag = false;
        }
        return flag;
    }

    self.isValidForm = function () {
        //Kiem tra thong tin Ho so
        var errorHoso = true;
        if (!self.doanhnghiep03().isValidDn()) {
            errorHoso = false;
        }

        if (!self.lstDonhang03() || self.lstDonhang03().length <= 0) {
            $('#hanghoa_valid').show();
            errorHoso = false;
        } else {
            $('#hanghoa_valid').hide();
        }

        if (!self.lstCuakhau03() || self.lstCuakhau03().length <= 0) {
            $('#cuakhau_valid').show();
            errorHoso = false;
        } else {
            $('#cuakhau_valid').hide();
        }

        if (!self.lstCuakhau03() || self.lstCuakhau03().length === 0) {

            $('#cuakhau_valid').show();
            errorHoso = false;
        } else {
            $('#cuakhau_valid').hide();
            self.showValidCuakhau();
            for (var i = 0; i < self.lstCuakhau03().length; i++) {
                var cuakhau = self.lstCuakhau03()[i];
                if (!cuakhau.fiTenCuakhau() || cuakhau.fiTenCuakhau().trim() == ""
                ) {
                    errorHoso = false;
                    $('#cuakhau_lbl_').show();
                    break;
                } else {
                    $('#cuakhau_lbl_').hide();
                }

            }

        }

        if (!self.validFile()) {
            errorHoso = false;
        }

        if (self.hosoErrors().length > 0) {
            self.hosoErrors.showAllMessages();
            errorHoso = false;
        }

        return errorHoso;
    };

    self.toJSON = function () {
        var mapping = {

            ignore: ['init', 'isValidForm', 'pop', 'toJSON', 'lstDmCuakhau', 'lstDuoclieu', 'lstDvt', 'lstTccl',
                'hosoErrors', 'errorDinhKemMessage', 'canDeleteTemp', 'lstQuocgia', 'viewDonHangClick',
                'doDeleteTemp', 'btnAddNewClickHH', 'editDonHangClick', 'popupHangHoa03', 'removeDonHangClick',
                'btnAddNewClickCuakhau', 'removeCuakhauClick', 'doDownloadTemp', 'canTemp', 'fiTepTemp', 'doDeleteTemp',
                'btnUploadTemp']
        };
        var copy = ko.mapping.fromJS(self, mapping);
        copy = ko.toJS(copy);

        var fileArr = [];
        for (var i = 0; i < copy.lstDinhkem03.length; i++) {
            var fileObj = copy.lstDinhkem03[i];
            if (fileObj.lstFiles.length === 0) {
                var obj = {
                    fiIdDinhkem: null,
                    fiIdHoso: fileObj.fiIdHoso,
                    fiLoaiTailieu: fileObj.fiLoaiTailieu,
                    fiTenLoaiTl: fileObj.fiTenLoaiTl,
                    fiTenTailieu: null,
                    fiDuongdanTl: null,
                    fiIdTailieu: fileObj.fiIdTailieu,
                    fiBatbuoc: fileObj.fiBatbuoc,
                    fiHoatdong: fileObj.fiHoatdong,
                    fiNguoitao: fileObj.fiNguoitao,
                    fiNgaytao: fileObj.fiNgaytao,
                    fiSize: null
                };
                fileArr.push(obj);
            }
            for (var j = 0; j < fileObj.lstFiles.length; j++) {
                var obj1 = fileObj.lstFiles[j];
                var obj = {
                    fiIdDinhkem: obj1.fiIdDinhkem,
                    fiIdHoso: fileObj.fiIdHoso,
                    fiLoaiTailieu: fileObj.fiLoaiTailieu,
                    fiTenLoaiTl: fileObj.fiTenLoaiTl,
                    fiTenTailieu: obj1.fiTenTailieu,
                    fiDuongdanTl: obj1.fiDuongdanTl,
                    fiIdTailieu: fileObj.fiIdTailieu,
                    fiBatbuoc: fileObj.fiBatbuoc,
                    fiHoatdong: fileObj.fiHoatdong,
                    fiNguoitao: fileObj.fiNguoitao,
                    fiNgaytao: fileObj.fiNgaytao,
                    fiSize: obj1.fiSize
                };
                fileArr.push(obj);
            }
        }
        copy.lstDinhkem03 = [];
        copy.lstDinhkem03 = fileArr;

        delete copy['__ko_mapping__'];
        return copy;
    };

    //Thêm chi tiết đơn hàng
    self.btnAddNewClickHH = function () {
        var item = new HangHoa03({
            fiSttHH: self.lstDonhang03().length + 1,
            fiIdDonhang: -1 * new Date().getTime()
        });
        self.popupHangHoa03(null, 'add', 'Thêm mới chi tiết đơn hàng');
        return false;
    };
    // sửa đơn hàng
    self.editDonHangClick = function (item) {
        self.popupHangHoa03(item, 'edit', 'Sửa chi tiết đơn hàng');
        return false;
    };

    // xem đơn hàng
    self.viewDonHangClick = function (item) {
        self.popupHangHoa03(item, 'view', 'Xem chi tiết đơn hàng');
        return false;
    };

    self.popupHangHoa03 = function (item, action, title) {
        var html = [
            $('#thongtinhanghoa-template').html()
        ].join('');
        delete self.pop;
        delete self.hangHoaVM;
        options.lstDonhang03 = item;
        var tenDuoclieuOld = item.fiTenDuoclieu();
        self.hangHoaVM = new HangHoaFormVM(options, self.lstDonhang03());
        self.pop = app.popup({
            title: title,
            html: html,
            width: 1024,
            buttons: [
                {
                    name: 'Lưu',
                    class: 'btn btn-save',
                    icon: 'fa-save',
                    action: function () {
                        debugger;
                        if (!self.hangHoaVM.isValid()) {
                            app.Alert('Bạn cần nhập đủ dữ liệu các trường BẮT BUỘC <span style="color:red">(*)</span>');
                            return;
                        } else if ((!self.hangHoaVM.isValidDuplicate() && action !== 'edit') || (!self.hangHoaVM.isValidDuplicate()
                        && action === 'edit' && tenDuoclieuOld !== self.hangHoaVM.fiTenDuoclieu())) {
                            app.Alert('Tên dược liệu đã được khai báo đơn hàng. Vui lòng chọn tên dược liệu khác.');
                            return;
                        } else {
                            var hangHoaInfo = self.hangHoaVM.toJSON();
                            if (null == hangHoaInfo.fiIdDonhang) {
                                hangHoaInfo.fiIdDonhang = -1 * new Date().getTime();
                                var hangHoaModel = new HangHoa03(hangHoaInfo);
                                self.lstDonhang03.push(hangHoaModel);
                            } else {
                                for (var i = 0; i < self.lstDonhang03().length; i++) {
                                    if (hangHoaInfo.fiIdDonhang == self.lstDonhang03()[i].fiIdDonhang()) {
                                        var hangHoaModel = new HangHoa03(hangHoaInfo);
                                        self.lstDonhang03.replace(self.lstDonhang03()[i], hangHoaModel);
                                        break;
                                    }
                                }
                            }
                            app.popupRemove(self.pop.selector);
                            $('.modal-scrollable').hide();
                            $('.modal-backdrop').hide();
                            $('#hanghoa_valid').hide();
                        }
                    }
                },
                {
                    name: 'Đóng',
                    class: 'btn',
                    icon: 'fa-close',
                    action: function () {
                        app.popupRemove(self.pop.selector);
                        $('.modal-scrollable').hide();
                        $('.modal-backdrop').hide();
                    }
                }
            ]
        });


        if (action == 'view') {
            $(".btn-save").hide();
        }

        ko.applyBindings(self.hangHoaVM, document.getElementById('thongtinhanghoa-vm'));
        $("#fiMaDuoclieu").select2({placeholder: '-- Chọn dược liệu --', width: '100%', allowClear: true});
        $("#fiMaDvTinh").select2({placeholder: '-- Chọn đơn vị tính --', width: '100%', allowClear: true});
        $("#fiMaTccl").select2({placeholder: '-- Chọn tiêu chuẩn --', width: '100%', allowClear: true});
        $("#fiMaQgSx").select2({placeholder: '-- Chọn quốc gia --', width: '100%', allowClear: true});
        $("#fiMaQgCc").select2({placeholder: '-- Chọn quốc gia --', width: '100%', allowClear: true});
    };

    // Xóa đơn hàng hóa
    self.removeDonHangClick = function (item) {
        if (item) {
            var pop = app.popup({
                title: 'Thông báo',
                html: '<b>Bạn chắc chắn muốn xoá dữ liệu của hàng hóa này?</b>',
                width: 450,
                buttons: [
                    {
                        name: NSWLang["common_button_toi_chac_chan"],
                        class: 'btn',
                        icon: 'fa-save',
                        action: function () {
                            self.lstDonhang03.remove(function (o) {
                                return o.fiIdDonhang() == item.fiIdDonhang();
                            });
                            for (var i = 0; i < self.lstDonhang03().length; i++) {
                                // self.lstDonhang03()[i].fi(i + 1);
                            }
                            app.popupRemove(pop.selector);
                            if (!self.lstDonhang03() || self.lstDonhang03().length <= 0) {

                                $('#hanghoa_valid').show();
                            } else {
                                $('#hanghoa_valid').hide();
                            }
                        }
                    },
                    {
                        name: 'Huỷ',
                        class: 'btn',
                        icon: 'fa-close',
                        action: function () {
                            app.popupRemove(pop.selector);
                        }
                    }
                ]
            });
        }
    }

    self.doDownloadTemp = function () {
        var strUrl = app.appContext + "/moh/p03/downloadTemp";
        window.open(strUrl, "_blank");
    };

    self.doDeleteTemp = function () {
        self.fiTepTemp(null);
    };

    self.btnUploadTemp = function () {
        debugger;
        $('#loading10').show();

        var files = $('#fileTemp')[0].files;
        if (!files || files.length <= 0) {
            return;
        }
        //Check validate file
        if (!Util.uploadFileNameValidate(files[0].name)) {
            $('#loading10').hide();
            //no remove this line
            e.target.value = '';
            return;
        }
        //check name utf8
        if (Util.hasUnicode(files[0].name)) {
            $('#loading10').hide();
            //no remove this line
            e.target.value = '';
            return;
        }
        var fileName = files[0].name;
        var extensionFile = fileName.split('.').pop();
        // check upload chi cho upload excell
        if (extensionFile === "xlsx" || extensionFile === "xls") {
            app.uploadFileMic({
                file: files[0],
                url: '/moh/p03/uploadTemp',
                success: function (d) {
                    var lstDuoclieu = options.lstDuoclieu;
                    var lstDvt = options.lstDvt;
                    var lstTccl = options.lstTccl;
                    var lstQuocgia = options.lstQuocgia;

                    if (d.success === true && d.total) {
                        var flag = true;
                        var lstFileTmp = [];
                        for (var i = 0; i < d.data.length; i++) {
                            var obj = d.data[i];
                            obj.fiIdDonhang = -1 * ((new Date().getTime()) + (i + 1));
                            // tim ma ten duoc lieu
                            var duoclieu = lstDuoclieu.find(dl => dl.fiTenDuoclieu.trim() === obj.fiTenDuoclieu.trim());
                            if (duoclieu == null || duoclieu == undefined) {
                                flag = false;
                                app.Alert("Dữ liệu trong cột <b>Tên dược liệu</b> ở dòng <b>" + (i + 1) + "</b> không đúng định dạng của biểu mẫu");
                                break;
                            }
                            obj.fiMaDuoclieu = duoclieu.id;
                            // tim ma cua don vi tinh
                            var dvtinh = lstDvt.find(dvt => dvt.name.trim() === obj.fiTenDvTinh.trim());
                            if (dvtinh == null || dvtinh == undefined) {
                                flag = false;
                                app.Alert("Dữ liệu trong cột <b>Đơn vị tính</b> ở dòng <b>" + (i + 1) + "</b> không đúng định dạng của biểu mẫu");
                                break;
                            }
                            obj.fiMaDvTinh = dvtinh.code;
                            // tim ma cua tieu chuan chat luong
                            var tccl = lstTccl.find(tc => tc.name.trim() === obj.fiTccl.trim());
                            if (tccl == null || tccl == undefined) {
                                flag = false;
                                app.Alert("Dữ liệu trong cột <b>Tiêu chuẩn chất lượng</b> ở dòng <b>" + (i + 1) + "</b> không đúng định dạng của biểu mẫu");
                                break;
                            }
                            obj.fiMaTccl = tccl.id;
                            // tim ma quoc gia cua nuoc san xuat
                            var qgsx = lstQuocgia.find(qg => qg.fiTenQg.trim() === obj.fiTenQgSx.trim());
                            if (qgsx == null || qgsx == undefined) {
                                flag = false;
                                app.Alert("Dữ liệu trong cột <b>Tên nước sản xuất</b> ở dòng <b>" + (i + 1) + "</b> không đúng định dạng của biểu mẫu");
                                break;
                            }
                            obj.fiMaQgSx = qgsx.fiMaQg;
                            // tim ma quoc gia cua nuoc cung cap
                            var qgcc = lstQuocgia.find(qg => qg.fiTenQg.trim() === obj.fiTenQgCc.trim());
                            if (qgcc == null || qgcc == undefined) {
                                flag = false;
                                app.Alert("Dữ liệu trong cột <b>Tên nước cung cấp</b> ở dòng <b>" + (i + 1) + "</b> không đúng định dạng của biểu mẫu");
                                break;
                            }
                            obj.fiMaQgCc = qgsx.fiMaQg;

                            var donhangModel = new HangHoa03(obj);
                            lstFileTmp.push(donhangModel);
                        }
                        if (flag) {
                            debugger;
                            self.fiTepTemp(files[0].name);
                            $('#fileTemp').val('');
                            for (var i = 0; i < lstFileTmp.length; i++) {
                                for (var j = 0; j < self.lstDonhang03().length; j++) {
                                    if (lstFileTmp[i].fiTenDuoclieu().trim() !== "Các dược liệu khác dùng làm thuốc chưa được liệt kê"
                                        && lstFileTmp[i].fiTenDuoclieu().trim() === self.lstDonhang03()[j].fiTenDuoclieu().trim()) {
                                        app.Alert('Tên dược liệu nhập khẩu <b>' + lstFileTmp[i].fiTenDuoclieu() + '</b> đã được khai báo');
                                        return;
                                    }
                                }
                                self.lstDonhang03.push(lstFileTmp[i]);
                            }

                            app.Alert('Thêm mới thành công dữ liệu hàng hóa nhập khẩu dược liệu từ file biểu mẫu');
                        }
                    } else if (d.success === true && d.data.length === 0) {
                        app.Alert("Không có bản ghi nào trong file Excel.");
                    } else {
                        app.Alert(d.message);
                    }
                    $('#fileTemp').val('');
                    $('#hanghoa_valid').hide();
                },
                error: function (e) {
                    console.log(e);
                }
            });
        } else {
            $('#loading10').hide();
            app.Alert("Không đúng định dạng file Excel");
            return;
        }
    };

    // Thêm cửa khẩu mới - sự kiện button
    self.btnAddNewClickCuakhau = function () {
        var item = new Cuakhau03({
            fiStt: self.lstCuakhau03().length + 1,
            fiIdCuakhau: -1 * new Date().getTime()
        });
        self.lstCuakhau03.push(item);
        $("#fiMaCuakhau-" + item.fiIdCuakhau()).select2({placeholder: '--- Chọn ---', width: '100%', allowClear: true});
        $('#cuakhau_valid').hide();
    };

    // xoa thong tin cua khau
    self.removeCuakhauClick = function (item) {
        self.lstCuakhau03.remove(function (o) {
            return o.fiIdCuakhau() === item.fiIdCuakhau();
        });
        for (var i = 0; i < self.lstCuakhau03().length; i++) {
            self.lstCuakhau03()[i].fiStt(i + 1);
        }
        if (self.lstCuakhau03().length === 0) {
            $('#cuakhau_valid').show();
        }
    };

}
;

function HangHoaFormVM(options, lstHanghoa) {
    debugger;
    var self = this;
    var hanghoa = options.lstDonhang03;

    self.isViewTenDuoclieuKhac = ko.observable(false);
    // self.isDisableView = ko.observable(false);
    self.isViewTenTcclKhac = ko.observable(false);

    self.fiIdDonhang = ko.observable(hanghoa ? hanghoa.fiIdDonhang() : null);
    self.fiIdHoso = ko.observable(hanghoa ? hanghoa.fiIdHoso() : null);
    self.fiMaDuoclieu = ko.observable(hanghoa ? hanghoa.fiMaDuoclieu() : null);
    self.fiTenDuoclieu = ko.observable(hanghoa ? hanghoa.fiTenDuoclieu() : null);
    self.fiMaHs = ko.observable(hanghoa ? hanghoa.fiMaHs() : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 20 ký tự', params: 20}
    });
    self.fiBophanDung = ko.observable(hanghoa ? hanghoa.fiBophanDung() : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiTenKh = ko.observable(hanghoa ? hanghoa.fiTenKh() : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiMaDvTinh = ko.observable(hanghoa ? hanghoa.fiMaDvTinh() : null);
    self.fiTenDvTinh = ko.observable(hanghoa ? hanghoa.fiTenDvTinh() : null);
    self.fiSoluong = ko.observable(hanghoa ? hanghoa.fiSoluong() : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 10 ký tự', params: 10},
        pattern: {
            message: 'Không được nhập chữ cái, số âm, số thập phân hoặc giá trị bằng 0',
            params: /^([1-9][0-9]*)$/
        }
    });
    self.fiMaTccl = ko.observable(hanghoa ? hanghoa.fiMaTccl() : null);
    self.fiTccl = ko.observable(hanghoa ? hanghoa.fiTccl() : null);
    self.fiMaQgSx = ko.observable(hanghoa ? hanghoa.fiMaQgSx() : null);
    self.fiTenQgSx = ko.observable(hanghoa ? hanghoa.fiTenQgSx() : null);
    self.fiCosoSx = ko.observable(hanghoa ? hanghoa.fiCosoSx() : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 512 ký tự', params: 512}
    });
    self.fiMaQgCc = ko.observable(hanghoa ? hanghoa.fiMaQgCc() : null);
    self.fiTenQgCc = ko.observable(hanghoa ? hanghoa.fiTenQgCc() : null);
    self.fiCosoCc = ko.observable(hanghoa ? hanghoa.fiCosoCc() : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 512 ký tự', params: 512}
    });
    self.fiGhichu = ko.observable(hanghoa ? hanghoa.fiGhichu() : null);
    self.fiHoatdong = ko.observable(hanghoa ? hanghoa.fiHoatdong() : null);
    self.fiNguoitao = ko.observable(hanghoa ? hanghoa.fiNguoitao() : null);
    self.fiNgaytao = ko.observable(hanghoa ? new Date(hanghoa.fiNgaytao()) : null);
    self.fiTenKhac = ko.observable(hanghoa ? hanghoa.fiTenKhac() : null);
    self.fiTcclKhac = ko.observable(hanghoa ? hanghoa.fiTcclKhac() : null);

    self.lstDuoclieu = options.lstDuoclieu;
    self.lstDvt = options.lstDvt;
    self.lstTccl = options.lstTccl;
    self.lstQuocgia = options.lstQuocgia;

    if (self.fiMaDuoclieu() === "620" || self.fiMaDuoclieu() === 620) {
        self.isViewTenDuoclieuKhac(true);
        // self.isDisableView(true);
    } else {
        self.isViewTenDuoclieuKhac(false);
        // self.isDisableView(false);
    }

    if (self.fiMaTccl() === "7" || self.fiMaTccl() === 7) {
        self.isViewTenTcclKhac(true);
    } else {
        self.isViewTenTcclKhac(false);
    }

    var hanghoaVG = [self.fiMaHs, self.fiBophanDung, self.fiTenKh, self.fiSoluong, self.fiCosoSx, self.fiCosoCc];
    self.hangHoaErrors = ko.validation.group(hanghoaVG, {deep: true, live: true, observable: true});

    self.toJSON = function () {

        var mapping = {
            ignore: ["init", "hangHoaErrors", "isValid", "toJSON", "__ko_mapping__", "getDataDL", "validDonvitinh",
                "validTccl", "validNuocSx", "validNuocCc", "validTenKhac", "validSoluong", "isValidDuplicate"]
        };

        var copy = ko.mapping.fromJS(self, mapping);
        copy = ko.toJS(copy);
        delete copy['__ko_mapping__'];
        return copy;
    };

    //tự động cắt số 0 ở đầu số lượng
    self.validSoluong = function () {
        var soluongChuoi = self.fiSoluong().toString();
        var giatriChuyendoi = parseFloat(soluongChuoi, 10);

        if (giatriChuyendoi) {
            self.fiSoluong(giatriChuyendoi);
        }
    };

    // xử lý sự kiện khi lấy tên dược liệu
    self.getDataDL = function () {
        debugger;
        for (var i = 0; i < options.lstDuoclieu.length; i++) {
            if (self.fiMaDuoclieu() === options.lstDuoclieu[i].id) {
                self.fiMaHs(options.lstDuoclieu[i].fiMaHs);
                self.fiBophanDung(options.lstDuoclieu[i].fiBophanDung);
                self.fiTenKh(options.lstDuoclieu[i].fiTenLatinh);
                break;
            }
        }

        if (self.fiMaDuoclieu() === 620) {
            self.fiTenKhac(null);
            self.isViewTenDuoclieuKhac(true);
            // self.isDisableView(true);
        } else {
            self.isViewTenDuoclieuKhac(false);
            // self.isDisableView(false);

            // check trùng những dược liệu khác dươc liệu khác
            for (var i = 0; i < lstHanghoa.length; i++) {
                if (lstHanghoa[i].fiTenDuoclieu() === self.fiTenDuoclieu()) {
                    $('#isCheckTrungDl-lbl').show();
                    break;
                } else {
                    $('#isCheckTrungDl-lbl').hide();
                }
            }
        }

        if (self.fiMaDuoclieu() === undefined) {
            $('#fiDuoclieu-lbl').show();
            self.fiMaHs(null);
            self.fiBophanDung(null);
            self.fiTenKh(null);
            self.fiTenKhac(null);
        } else {
            $('#fiDuoclieu-lbl').hide();
        }
    };

    // valid trường đơn vị tính
    self.validDonvitinh = function () {
        var error = true;
        if (self.fiMaDvTinh() === null || self.fiMaDvTinh() === undefined) {
            $("#fiDonvitinh-lbl").show();
            error = false;
        } else {
            $("#fiDonvitinh-lbl").hide();
        }
        return error;
    };

    // valid trường tiêu chuẩn chất lượng
    self.validTccl = function () {
        debugger;
        var error = true;
        if (self.fiMaTccl() === null || self.fiMaTccl() === undefined) {
            $("#fiTccl-lbl").show();
            error = false;
        } else {
            $("#fiTccl-lbl").hide();
        }
        if (self.fiMaTccl() === 7) {
            self.isViewTenTcclKhac(true);
        } else {
            self.isViewTenTcclKhac(false);
        }
        return error;
    };

    // valid trường tên nước sản xuất
    self.validNuocSx = function () {
        var error = true;
        if (self.fiMaQgSx() === null || self.fiMaQgSx() === undefined) {
            $("#fiNuocSx-lbl").show();
            error = false;
        } else {
            $("#fiNuocSx-lbl").hide();
        }
        return error;
    };

    // valid trường tên nước cung cấp
    self.validNuocCc = function () {
        var error = true;
        if (self.fiMaQgCc() === null || self.fiMaQgCc() === undefined) {
            $("#fiNuocCc-lbl").show();
            error = false;
        } else {
            $("#fiNuocCc-lbl").hide();
        }
        return error;
    };

    // valid trường tên dược liệu khác
    self.validTenKhac = function () {
        var error = true;
        if (self.fiTenKhac() === null || self.fiTenKhac() === '' || self.fiTenKhac() === undefined) {
            $("#fiDuoclieuKhac-lbl").show();
            error = false;
        } else {
            $("#fiDuoclieuKhac-lbl").hide();
        }
        return error;
    };

    // valid trường tên tiêu chuẩn chất lượng khác
    self.validTenTcclKhac = function () {
        var error = true;
        if (self.fiTcclKhac() === null || self.fiTcclKhac() === '' || self.fiTcclKhac() === undefined) {
            $("#fiTcclKhac-lbl").show();
            error = false;
        } else {
            $("#fiTcclKhac-lbl").hide();
        }
        return error;
    }

    self.isValidDuplicate = function () {
        var errorDuplicate = true;
        if (self.fiMaDuoclieu() !== 620) {
            for (var i = 0; i < lstHanghoa.length; i++) {
                if (lstHanghoa[i].fiTenDuoclieu() === self.fiTenDuoclieu()) {
                    $('#isCheckTrungDl-lbl').show();
                    errorDuplicate = false;
                    break;
                }
            }
        }
        return errorDuplicate;
    }

    self.isValid = function () {
        var errors = true;
        if (self.fiMaDuoclieu() === null || self.fiMaDuoclieu() === undefined) {
            $('#fiDuoclieu-lbl').show();
            errors = false;
        }
        if (!self.validDonvitinh()) {
            errors = false;
        }
        if (!self.validTccl()) {
            errors = false;
        }
        if (!self.validNuocSx()) {
            errors = false;
        }
        if (!self.validNuocCc()) {
            errors = false;
        }
        if (!self.validTenKhac() && (self.fiMaDuoclieu() === "620" || self.fiMaDuoclieu() === 620)) {
            errors = false;
        }
        if (!self.validTenTcclKhac() && (self.fiMaTccl() === "7" || self.fiMaTccl() === 7)) {
            errors = false;
        }
        if (self.hangHoaErrors().length > 0) {
            self.hangHoaErrors.showAllMessages();
            errors = false;
        }
        return errors;
    }

}
;

function DoanhNghiep03FormVM(option, hoso) {
    var self = this;
    var doanhnghiep = option && option.dn03 ? option.dn03 : null;

    self.fiTenTt = ko.observable(doanhnghiep ? hoso.fiTenTt : null);
    self.fiIdDoanhnghiep = ko.observable(doanhnghiep ? doanhnghiep.fiIdDoanhnghiep : null);
    self.fiIdHoso = ko.observable(doanhnghiep ? doanhnghiep.fiIdHoso : null);
    self.fiMaSothue = ko.observable(doanhnghiep ? doanhnghiep.fiMaSothue : user.username);
    self.fiTenDn = ko.observable(doanhnghiep ? doanhnghiep.fiTenDn : user.companyName);
    self.fiMaHoso = ko.observable(doanhnghiep ? hoso.fiMaHoso : null);
    self.fiDiachi = ko.observable(doanhnghiep ? doanhnghiep.fiDiachi : user.companyAddress);
    self.fiNguoiDaidien = ko.observable(doanhnghiep ? doanhnghiep.fiNguoiDaidien : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiChucvu = ko.observable(doanhnghiep ? doanhnghiep.fiChucvu : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiSoDkkd = ko.observable(doanhnghiep ? doanhnghiep.fiSoDkkd : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiNgaycapDk = ko.observable(doanhnghiep ? new Date(doanhnghiep.fiNgaycapDk) : null);
    self.fiSoGsp = ko.observable(doanhnghiep ? doanhnghiep.fiSoGsp : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiNgaycapGsp = ko.observable(doanhnghiep ? new Date(doanhnghiep.fiNgaycapGsp) : null);
    self.fiMucdichSd = ko.observable(doanhnghiep ? doanhnghiep.fiMucdichSd : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 512 ký tự', params: 512}
    });
    self.fiHoatdong = ko.observable(doanhnghiep ? doanhnghiep.fiHoatdong : null);
    self.fiNguoitao = ko.observable(doanhnghiep ? doanhnghiep.fiNguoitao : null);
    self.fiNgaytao = ko.observable(doanhnghiep ? new Date(doanhnghiep.fiNgaytao) : null);

    var doanhNghiepVG = [self.fiNguoiDaidien, self.fiChucvu, self.fiSoDkkd, self.fiSoGsp, self.fiMucdichSd];
    self.doanhNghiepErrors = ko.validation.group(doanhNghiepVG, {deep: true, live: true, observable: true});

    self.clearfiNgayCapDk = function () {
        self.fiNgaycapDk(null);
        // Khong highlight ngay chon khi da clear
        $('#fiNgaycapDk').datepicker('setDate', null);
    };

    self.clearfiNgayCapGsp = function () {
        self.fiNgaycapGsp(null);
        // Khong highlight ngay chon khi da clear
        $('#fiNgaycapGsp').datepicker('setDate', null);
    };

    validNgayCapDk = function () {
        var error = true;
        if (self.fiNgaycapDk() === null || self.fiNgaycapDk() === undefined || self.fiNgaycapDk() === "") {
            $("#fiNgayCapDk-lbl").show();
            error = false;
        } else {
            $("#fiNgayCapDk-lbl").hide();
        }
        return error;
    };

    validNgayCapGsp = function () {
        var error = true;
        if (self.fiNgaycapGsp() === null || self.fiNgaycapGsp() === undefined || self.fiNgaycapGsp() === "") {
            $("#fiNgayCapGsp-lbl").show();
            error = false;
        } else {
            $("#fiNgayCapGsp-lbl").hide();
        }
        return error;
    };

    self.toJSON = function () {

        var exclude = ['toJSON', 'isValidDn', 'clearfiNgayCapDk', 'clearfiNgayCapGsp', 'validNgayCapDk', 'validNgayCapGsp'];

        var model = ko.toJS(self);

        for (var key in model) {
            if (exclude.indexOf(key) >= 0) {
                delete model[key];
            }
        }

        return model;
    };

    self.validNgayCap = function () {
        var flag = true;
        var from = new Date();
        var to = self.fiNgaycapDk();
        if (from && to) {
            if (to.getTime() > from.getTime()) {
                flag = false;
            }
        }
        return flag;
    }

    self.validNgayGSP = function () {
        var flag = true;
        var from = new Date();
        var to = self.fiNgaycapGsp();
        if (from && to) {
            if (to.getTime() > from.getTime()) {
                flag = false;
            }
        }
        return flag;
    }

    self.isValidDn = function () {
        var errorDn = true;
        if (!validNgayCapDk()) {
            errorDn = false;
        }
        if (!validNgayCapGsp()) {
            errorDn = false;
        }
        if (self.doanhNghiepErrors().length > 0) {
            self.doanhNghiepErrors.showAllMessages();
            errorDn = false;
        }
        return errorDn;
    };
}