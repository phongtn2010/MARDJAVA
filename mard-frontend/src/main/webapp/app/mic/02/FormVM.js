/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function FormVM(options) {
    var self = this;

    var hosoInfo = (options !== null && options.hasOwnProperty('hoso')) ? options.hoso : null;
    //Thong tin chung
    self.fiIdHoSo = ko.observable(null)
    self.fiMaHoSo = ko.observable(null)
    self.fiSoDonDeNghi = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiNoiCapGpTen = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiNoiCapGpMa = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiTtcTenToChuc = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiTtcDiaChi = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiTtcDienThoai = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiTtcFax = ko.observable(null);
    self.fiTtcEmail = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        email: {message: 'Email không đúng định dạng', params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiTtcMst = ko.observable(null);
    self.fiCmnd = ko.observable(null);
    self.fiNoiCapCmnd = ko.observable(null);
    self.fiNgayCapCmnd = ko.observable(null);
    self.fiNguoiLienHe = ko.observable(null);
    self.fiMucDichNk = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiMucDichNkKhac = ko.observable(null);
    self.fiDcDatMayLanDau = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiNguoiKy = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiChucDanh = ko.observable(null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiMaTrangThai = ko.observable(null);
    self.fiNgayTao = ko.observable(null);
    self.fiNguoiTao = ko.observable(null);
    self.fiHoatDong = ko.observable(null);
    self.fiNgayGui = ko.observable(null);
    self.fiNgayKy = ko.observable(null);
    self.fiTenTrangThai = ko.observable(null);
    self.fiNgaycapGp = ko.observable(null);
    self.lstThietBiNk02 = ko.observableArray([]);
    self.lstTeptin02 = ko.observableArray([]);
    self.lstNoiCP = ko.observableArray(mapCategory(options.hasOwnProperty('lstNoiCP') ? options.lstNoiCP : [], "fiMaTinhThanh", "fiTentinh"));
    self.lstMucDich = ko.observableArray(mapCategory(options.hasOwnProperty('lstMucDich') ? options.lstMucDich : [], "fiId", "fiTenMucdich"));
    var hosoVG = [self.fiSoDonDeNghi, self.fiNoiCapGpTen, self.fiNoiCapGpMa, self.fiTtcTenToChuc, self.fiTtcDiaChi, self.fiTtcDienThoai, self.fiTtcEmail, self.fiMucDichNk,
        self.fiDcDatMayLanDau, self.fiChucDanh, self.fiNguoiKy];
    self.hosoErrors = ko.validation.group(hosoVG, {deep: true, live: true, observable: true});
    self.htcErrors = ko.observable(null);
    self.errorDinhKemMessage = ko.observable(null);
    //upload templ
    self.fiTepTemp = ko.observable(null);
    self.canTemp = ko.computed(function () {
        return self.fiTepTemp() === null;
    }, this);

    self.canDeleteTemp = ko.computed(function () {
        return self.fiTepTemp() !== null;
    }, this);

    //Khoi tao gia tri ho so
    self.init = function (hoso) {

        self.fiTtcTenToChuc(hoso !== null && hoso.hasOwnProperty('fiTtcTenToChuc') ? hoso.fiTtcTenToChuc : user.companyName);
        self.fiTtcDiaChi(hoso !== null && hoso.hasOwnProperty('fiTtcDiaChi') ? hoso.fiTtcDiaChi : user.companyAddress);
        self.fiTtcDienThoai(hoso !== null && hoso.hasOwnProperty('fiTtcDienThoai') ? hoso.fiTtcDienThoai : user.companyPhoneNumber);
        self.fiTtcMst(hoso !== null && hoso.hasOwnProperty('fiTtcDienThoai') ? hoso.fiTtcMst : user.username);
        if (hoso !== null) {

            self.fiIdHoSo(hoso.hasOwnProperty('fiIdHoSo') ? hoso.fiIdHoSo : null)
            self.fiMaHoSo(hoso.hasOwnProperty('fiMaHoSo') ? hoso.fiMaHoSo : null)
            self.fiSoDonDeNghi(hoso.hasOwnProperty('fiSoDonDeNghi') ? hoso.fiSoDonDeNghi : null);
            self.fiNoiCapGpTen(hoso.hasOwnProperty('fiNoiCapGpTen') ? hoso.fiNoiCapGpTen : null);
            self.fiNoiCapGpMa(hoso.hasOwnProperty('fiNoiCapGpMa') ? hoso.fiNoiCapGpMa : null);
            self.fiTtcFax(hoso.hasOwnProperty('fiTtcFax') ? hoso.fiTtcFax : null);
            self.fiTtcEmail(hoso.hasOwnProperty('fiTtcEmail') ? hoso.fiTtcEmail : null);
            self.fiCmnd(hoso.hasOwnProperty('fiCmnd') ? hoso.fiCmnd : null);
            self.fiNoiCapCmnd(hoso.hasOwnProperty('fiNoiCapCmnd') ? hoso.fiNoiCapCmnd : null);
            self.fiNgayCapCmnd(hoso.hasOwnProperty('fiNgayCapCmnd') && hoso.fiNgayCapCmnd != null ? new Date(hoso.fiNgayCapCmnd) : null);
            self.fiNguoiLienHe(hoso.hasOwnProperty('fiNguoiLienHe') ? hoso.fiNguoiLienHe : null);
            self.fiMucDichNk(hoso.hasOwnProperty('fiMucDichNk') ? hoso.fiMucDichNk : null);
            self.fiMucDichNkKhac(hoso.hasOwnProperty('fiMucDichNkKhac') ? hoso.fiMucDichNkKhac : null);
            self.fiDcDatMayLanDau(hoso.hasOwnProperty('fiDcDatMayLanDau') ? hoso.fiDcDatMayLanDau : null);
            self.fiNguoiKy(hoso.hasOwnProperty('fiNguoiKy') ? hoso.fiNguoiKy : null);
            self.fiChucDanh(hoso.hasOwnProperty('fiChucDanh') ? hoso.fiChucDanh : null);
            self.fiMaTrangThai(hoso.hasOwnProperty('fiMaTrangThai') ? hoso.fiMaTrangThai : null);
            self.fiNgayTao(hoso.hasOwnProperty('fiNgayTao') && hoso.fiNgayTao != null ? new Date(hoso.fiNgayTao) : null);
            self.fiNguoiTao(hoso.hasOwnProperty('fiNguoiTao') ? hoso.fiNguoiTao : null);
            self.fiHoatDong(hoso.hasOwnProperty('fiHoatDong') ? hoso.fiHoatDong : null);
            self.fiNgayGui(hoso.hasOwnProperty('fiNgayGui') && hoso.fiNgayGui != null ? new Date(hoso.fiNgayGui) : null);
            self.fiNgayKy(hoso.hasOwnProperty('fiNgayKy') && hoso.fiNgayKy != null ? new Date(hoso.fiNgayKy) : null);
            self.fiChucDanh(hoso.hasOwnProperty('fiChucDanh') ? hoso.fiChucDanh : null);
            self.fiTenTrangThai(hoso.hasOwnProperty('fiTenTrangThai') ? hoso.fiTenTrangThai : null);
            self.fiNgaycapGp(hoso.hasOwnProperty('fiNgaycapGp') && hoso.fiNgaycapGp != null ? new Date(hoso.fiNgaycapGp) : null);
            self.lstThietBiNk02(MapTbdThietBiNk02(hoso.hasOwnProperty('lstThietBiNk02') ? hoso.lstThietBiNk02 : []));
            

            var lstFiles = hoso.hasOwnProperty('lstTeptin02') ? hoso.lstTeptin02 : [];
            var groups = {};
            for (var i = 0; i < lstFiles.length; i++) {
                var kk = lstFiles[i];
                var groupName = lstFiles[i].fiTenDinhKem;
                if (!groups[groupName]) {
                    groups[groupName] = {
                        fiMaHoSo: kk.fiMaHoSo,
                        fiId: kk.fiId,
                        fiIdDinhkem: kk.fiIdDinhkem,
                        fiTenDinhKem: kk.fiTenDinhKem,
                        fiIdHoSo: kk.fiIdHoSo,
                        fiDuongDan: kk.fiDuongDan,
                        fiMaDinhKem: kk.fiMaDinhKem,
                        fiGuiid: kk.fiGuiid,
                        fiLoaiTepTin: kk.fiLoaiTepTin,
                        fiTenLoaiTep: kk.fiTenLoaiTep,
                        fiTenTepTin: kk.fiTenTepTin,
                        fiTepTinId: kk.fiTepTinId,
                        fiNgayTao: kk.fiNgayTao,
                        fiNguoiTao: kk.fiNguoiTao,
                        fiHoatDong: kk.fiHoatDong,
                        lstFiles: []
                    };
                }
                var cc = {
                    fiTepTinId: lstFiles[i].fiTepTinId,
                    fiTenTepTin: lstFiles[i].fiTenTepTin
                };
                if(cc.fiTepTinId !=null){
                    groups[groupName].lstFiles.push(cc);
                }
            }
            debugger;
            lstFiles = [];
            for (var groupName in groups) {
                lstFiles.push(groups[groupName]);
            }
            self.lstTeptin02(mapFilesVM(lstFiles, self.fiIdHoSo()));

            setTenTrangthai(self.fiMaTrangThai());
            setMucDichNkKhac();

        } else {
            self.lstTeptin02(mapFilesVM(options.lstTeptin02, self.fiIdHoSo()));
        }
    };
    var setTenTrangthai = function (fiMaTrangThai) {
        for (var i = 0; i < RAW_HS_STATUS.length > 0; i++) {
            if (RAW_HS_STATUS[i].id == fiMaTrangThai) {
                self.fiTenTrangThai(RAW_HS_STATUS[i].name);
            }
        }
    };
    var setMucDichNkKhac = function () {
        if (self.fiMucDichNkKhac() !== null)
            $(".fiMucDichSuDungKhac").css("display", "inline");

    };

    self.init(hosoInfo);


//XU LY SU KIEN BUTTON, TABLE
//    validate md nk khac
    self.validateMD = function () {
        if (self.fiMucDichNkKhac() == null) {
            $('#fiMucDichSuDungKhac-lbl').show();

        } else {
            $('#fiMucDichSuDungKhac-lbl').hide();
        }
    };
    //Remove from toJSON
    self.isValidForm = function () {
        //Kiem tra thong tin Ho so

        var errorHoso = true;
        var errorDinhkem = true;



        if (!self.lstThietBiNk02() || self.lstThietBiNk02().length <= 0) {
            $('#valid-tbnk').show();
            errorHoso = false;

        }

        if (self.fiMucDichNk() == 5) {
            if (self.fiMucDichNkKhac() == null || self.fiMucDichNkKhac() == "") {
                $('#fiMucDichSuDungKhac-lbl').show();
                errorHoso = false;
            }

        }

        //Kiem tra thong tin dinh kem
        if (!self.lstTeptin02() || self.lstTeptin02().length <= 0) {
            self.errorDinhKemMessage(' Chưa khai báo thông tin đính kèm');
            errorDinhkem = false;
        } else {
            self.errorDinhKemMessage(null);
        }
        if (self.lstTeptin02() && self.lstTeptin02().length > 0) {
            for (var i = 0; i < self.lstTeptin02().length; i++) {
                var attach = self.lstTeptin02()[i];
                if (attach.isRequire()) {
                    if (!attach.lstFiles().length) {
                        errorDinhkem = false;
                        self.errorDinhKemMessage(' Chưa khai báo thông tin đính kèm');
                        break;
                    }
                }
            }
        }
        if (self.hosoErrors().length > 0) {
            self.hosoErrors.showAllMessages();
            errorHoso = false;
            return errorHoso;
        }

        return errorHoso && errorDinhkem;
    };
//VALIDATE DATA ON FORM
//Convert to json object

    

    self.toJSON = function () {

        var mapping = {

            ignore: ['canTemp', 'init', 'isValidForm', 'toJSON',
                'TbnkVM', 'btnAddNewNKClick', 'btnEditOnClick', 'btnRemoveOnClick',
                'btnUploadTemp', 'canTemp', 'hosoErrors', 'htcErrors',
                'changeUngDungKhac', 'errorDinhKemMessage', 'isValidForm', 'popupTBNK',
                '__ko_mapping__', 'pop', 'lstMucDich', 'lstNoiCP', 'mucdichAction'
            ]
        };
        var copy = ko.mapping.fromJS(self, mapping);
        copy = ko.toJS(copy);

        debugger;
        var filesArr = [];
        for (var i = 0; i < copy.lstTeptin02.length; i++) {
            var fileObj = copy.lstTeptin02[i];
            if(fileObj.lstFiles.length ===0){
                var obj = {
                    fiMaHoSo: fileObj.fiMaHoSo,
                    fiId: fileObj.fiId,
                    fiIdDinhkem: fileObj.fiIdDinhkem,
                    fiTenDinhKem: fileObj.fiTenDinhKem,
                    fiIdHoSo: fileObj.fiIdHoSo,
                    fiDuongDan: fileObj.fiDuongDan,
                    fiMaDinhKem: fileObj.fiMaDinhKem,
                    fiGuiid: fileObj.fiGuiid,
                    fiLoaiTepTin: fileObj.fiLoaiTepTin,
                    fiTenLoaiTep: fileObj.fiTenLoaiTep,
                    fiTenTepTin: null,
                    fiTepTinId: null,
                    fiNgayTao: fileObj.fiNgayTao,
                    fiNguoiTao: fileObj.fiNguoiTao,
                    fiHoatDong: fileObj.fiHoatDong
                };
                filesArr.push(obj);
            }
            
            for (var j = 0; j < fileObj.lstFiles.length; j++) {
                var obj1 = fileObj.lstFiles[j];
                var obj = {
                    fiMaHoSo: fileObj.fiMaHoSo,
                    fiId: fileObj.fiId,
                    fiIdDinhkem: fileObj.fiIdDinhkem,
                    fiTenDinhKem: fileObj.fiTenDinhKem,
                    fiIdHoSo: fileObj.fiIdHoSo,
                    fiDuongDan: fileObj.fiDuongDan,
                    fiMaDinhKem: fileObj.fiMaDinhKem,
                    fiGuiid: fileObj.fiGuiid,
                    fiLoaiTepTin: fileObj.fiLoaiTepTin,
                    fiTenLoaiTep: fileObj.fiTenLoaiTep,
                    fiTenTepTin: obj1.fiTenTepTin,
                    fiTepTinId: obj1.fiTepTinId,
                    fiNgayTao: fileObj.fiNgayTao,
                    fiNguoiTao: fileObj.fiNguoiTao,
                    fiHoatDong: fileObj.fiHoatDong
                };
                filesArr.push(obj);
            }
        }
        copy.lstTeptin02 = [];
        copy.lstTeptin02 = filesArr;



//        for (var i = 0; i < copy.lstTeptin02.length; i++) {
//            delete copy.lstTeptin02[i]['canUpload'];
//            delete copy.lstTeptin02[i]['canDownload'];
//            delete copy.lstTeptin02[i]['canDelete'];
//            delete copy.lstTeptin02[i]['doUpload'];
//            delete copy.lstTeptin02[i]['doDelete'];
//            delete copy.lstTeptin02[i]['downloadUrl'];
//            delete copy.lstTeptin02[i]['fiBatBuoc'];
//            delete copy.lstTeptin02[i]['isRequire'];
//            delete copy.lstTeptin02[i]['lstFiles'];
//            delete copy.lstTeptin02[i]["__ko_mapping__"];
//        }

        delete copy['__ko_mapping__'];
        return copy;
    };
    self.changeUngDungKhac = function () {
        if (self.fiMucDichSuDungKhac() === null || self.fiMucDichSuDungKhac === "") {
            $('#fiMucDichSuDungKhacHo-lbl').show();
        } else {
            $('#fiMucDichSuDungKhacHo-lbl').hide();
        }
    };
    self.btnRemoveOnClick = function (item) {
        if (item) {
            var pop = app.popup({
                title: 'Thông báo',
                html: '<b>Bạn chắc chắn muốn xoá dữ liệu của thiết bị nhập khẩu</b>',
                width: 450,
                buttons: [
                    {
                        name: NSWLang["common_button_toi_chac_chan"],
                        class: 'btn',
                        icon: 'fa-save',
                        action: function () {
                            debugger;
                            self.lstThietBiNk02.remove(function (o) {
                                return o.fiIdThietBi() === item.fiIdThietBi();
                            });
                            for (var i = 0; i < self.lstThietBiNk02().length; i++) {
                                self.lstThietBiNk02()[i].fiStt(i + 1);
                            }
                            app.popupRemove(pop.selector);
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
    };

    self.doDeleteTemp = function () {
        self.fiTepTemp(null);
    };
    
    self.doDownloadTemp = function(){
        var strUrl = app.appContext + "/mic/p02/downloadTemp";
        window.open(strUrl, "_blank"); 
    }

    self.btnUploadTemp = function (e) {
        $('#loading10').show();
        //20190505


        var files = $('#fileTemp')[0].files;
        if (!files || files.length <= 0) {
            return;
        }


        app.uploadFileMic({
            file: files[0],
            url: '/mic/p02/uploadTemp',
            success: function (d) {
                debugger;
//                var $el = $('#fileTemp');
//                $el.wrap('<form>').closest('form').get(0).reset();
//                $el.unwrap();

                console.log(d);

                var lstTenTv = options.lstDMTenTV;
                var lstKieuIn = options.lstDMKieuIn;
                var lstChatLuong = options.lstDMChatLuong;
                var lstKhuankho = options.lstDMDvKhuankho;
                var lstTocDo = options.lstDMDvTocDo;

                if (d.success === true && d.total) {

                    var flag = true;
                    var lstFileTmp = [];

                    for (var i = 0; i < d.data.length; i++) {
                        var obj = d.data[i];
                        obj.fiStt = self.lstThietBiNk02().length + 1;
                        obj.fiIdThietBi = -1 * ((new Date().getTime())+(i+1));

                        //tim ma cua ten may
                        var objTenTV = lstTenTv.find(fruit => fruit.fiDmTenmayTv.trim() === obj.fiTenMay.trim());
                        if(objTenTV==null || objTenTV==undefined){
                            flag = false;
                            app.Alert("Dữ liệu trong cột <b>Tên máy</b> ở dòng <b>"+(i+1)+"</b> không đúng định dạng của biểu mẫu");
                            break;
                        }
                        obj.fiMaTv = objTenTV.fiMaTenTv;
                        //tim ma cua ten kieu in
                        var objKieuIn = lstKieuIn.find(fruit => fruit.fiDmKieuIn.trim() === obj.fiKieuIn.trim());
                        if(objKieuIn==null || objKieuIn==undefined){
                            flag = false;
                            app.Alert("Dữ liệu trong cột <b>Kiểu in</b> ở dòng <b>"+(i+1)+"</b> không đúng định dạng của biểu mẫu");
                            break;
                        }
                        obj.fiMaKieuIn = objKieuIn.fiMaKieuIn;
                        //tim ma cua ten chat luong
                        var objChatLuong = lstChatLuong.find(fruit => fruit.fiDmChatLuong.trim() === obj.fiChatLuong.trim());
                        if(objChatLuong==null || objChatLuong==undefined){
                            flag = false;
                            app.Alert("Dữ liệu trong cột <b>Chất lượng</b> ở dòng <b>"+(i+1)+"</b> không đúng định dạng của biểu mẫu");
                            break;
                        }
                        obj.fiMaChatLuong = objChatLuong.fiMaChatLuong;
                        //tim ma cua ten khuan kho
                        var objKhuanKho = lstKhuankho.find(fruit => fruit.fiDvKichthuoc.trim() === obj.fiDonViTinhKhuonKho.trim());
                        if(objKhuanKho==null || objKhuanKho==undefined){
                            flag = false;
                            app.Alert("Dữ liệu trong cột <b>Đơn vị kích thước </b> ở dòng <b>"+(i+1)+"</b> không đúng định dạng của biểu mẫu");
                            break;
                        }
                        obj.fiMaKichThuoc = objKhuanKho.fiMaKT;
                        //tim ma cua ten tocdo
                        var objTocDo = lstTocDo.find(fruit => fruit.fiDvTocdo.trim() === obj.fiDonViTocDoIn.trim());
                        if(objTocDo==null || objTocDo==undefined){
                            flag = false;
                            app.Alert("Dữ liệu trong cột <b>Đơn vị tốc độ</b> ở dòng <b>"+(i+1)+"</b> không đúng định dạng của biểu mẫu");
                            break;
                        }
                        obj.fiMaTocdo = objTocDo.fiMaTocDo;

                        var tbnkModel = new TbdThietBiNk02(obj);
                        lstFileTmp.push(tbnkModel);
//                        self.lstThietBiNk02.push(tbnkModel);
                    }
                    debugger;
                    if(flag){
                        
                        for(var i=0;i<lstFileTmp.length;i++){
                          self.lstThietBiNk02.push(lstFileTmp[i]);  
                        }
                        self.fiTepTemp(files[0].name);
                        app.Alert("Thêm mới thành công dữ liệu thiết bị nhập khẩu từ file biểu mẫu");
                    }
                } else {
                    //open popup
                    app.Alert(d.message);
                }
                $('#fileTemp').val('');
                $('#valid-tbnk').hide();
            },
            error: function (e) {

                console.log(e);
            }
        });
    };


    self.btnAddNewNKClick = function () {
        self.popupTBNK(null)
        return false;
    };
    self.btnEditOnClick = function (item) {
        self.popupTBNK(item, 'edit');
        return false;
    }
    self.popupTBNK = function (item, action) {
        var html = [
            $('#dsthietbi-template').html()
        ].join('');
        delete self.pop;
        delete self.TBNKFormVM;
        options.lstThietBiNk02 = item;
        self.TbnkVM = new TBNKFormVM(options);
        self.pop = app.popup({
            title: 'Danh sách thiết bị nhập khẩu',
            html: html,
            width: 1024,
            buttons: [
                {
                    name: 'Lưu',
                    class: 'btn btn-save',
                    icon: 'fa-save',
                    action: function () {
                        if (self.TbnkVM.isValidTbnk()) {
                            app.Alert('Phải nhập đầy đủ thông tin thiết bị nhập khẩu');
                        } else {
                            var ThietbiNkInfo = self.TbnkVM.toJSON();
                            if (null == ThietbiNkInfo.fiIdThietBi) {
                                ThietbiNkInfo.fiIdThietBi = -1 * new Date().getTime();
                                ThietbiNkInfo.fiStt = self.lstThietBiNk02().length + 1;
                                var tbnkModel = new TbdThietBiNk02(ThietbiNkInfo);
                                self.lstThietBiNk02.push(tbnkModel);
                                $('#valid-tbnk').hide();
                            } else {
                                for (var i = 0; i < self.lstThietBiNk02().length; i++) {
                                    if (ThietbiNkInfo.fiIdThietBi == self.lstThietBiNk02()[i].fiIdThietBi()) {
                                        var tbnkModel = new TbdThietBiNk02(ThietbiNkInfo);
                                        self.lstThietBiNk02.replace(self.lstThietBiNk02()[i], tbnkModel);
                                        break;
                                    }
                                }
                            }
                            app.popupRemove(self.pop.selector);
                            $('.modal-scrollable').hide();
                            $('.modal-backdrop').hide();

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

        if (action != 'edit' && item != null && item.fiIdThietBi() > 0) {
            $(".btn-save").hide();
        }

        ko.applyBindings(self.TbnkVM, document.getElementById('dstb-form'));
        $("#fiMaChatLuong").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
        $("#fiMaKT").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
        $("#fiMaTocDo").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
        $("#fiMaKieuIn").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
        $("#fiMaTenTv").select2({placeholder: '-- Chọn --', width: '100%', allowClear: true});
    };
    self.mucdichAction = function () {
        var array = self.lstMucDich();
        var elemet = self.fiMucDichNk();
//        var found = self.lstMucDich().length;
        var getFruit = array.find(fruit => fruit.name === 'Khác');
        if (getFruit.id === elemet) {
            $(".fiMucDichSuDungKhac").css("display", "inline");

        } else {
            self.fiMucDichNkKhac(null);
            $(".fiMucDichSuDungKhac").css("display", "none");
        }
    }
}
;
function TBNKFormVM(options) {
    var self = this;

    var tbnk = options.lstThietBiNk02;
    self.fiStt = ko.observable(tbnk ? tbnk.fiStt() : null);
    self.fiIdThietBi = ko.observable(tbnk ? tbnk.fiIdThietBi() : null);
    self.fiTenMay = ko.observable(tbnk ? tbnk.fiTenMay() : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiKieuIn = ko.observable(tbnk ? tbnk.fiKieuIn() : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiSoMauIn = ko.observable(tbnk ? tbnk.fiSoMauIn() : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiModelMay = ko.observable(tbnk ? tbnk.fiModelMay() : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiSoDinhDanhMay = ko.observable(tbnk ? tbnk.fiSoDinhDanhMay() : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiNuocSx = ko.observable(tbnk ? tbnk.fiNuocSx() : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiNamSx = ko.observable(tbnk ? tbnk.fiNamSx() : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiSoLuong = ko.observable(tbnk ? tbnk.fiSoLuong() : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 15.3 ký tự', params: 19},
        pattern: {
            message: 'Bạn chỉ được nhập số ',
            params: /^[0-9]{1,12}(?:\.[0-9]{1,3})?$/
        }
    });
    self.fiChatLuong = ko.observable(tbnk ? tbnk.fiChatLuong() : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiKhuanKhoBanIn = ko.observable(tbnk ? tbnk.fiKhuanKhoBanIn() : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiDonViTinhKhuonKho = ko.observable(tbnk ? tbnk.fiDonViTinhKhuonKho() : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiTocDoIn = ko.observable(tbnk ? tbnk.fiTocDoIn() : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiDonViTocDoIn = ko.observable(tbnk ? tbnk.fiDonViTocDoIn() : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiGiaThietBi = ko.observable(tbnk ? tbnk.fiGiaThietBi() : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 15},
        pattern: {
            message: 'Bạn chỉ được nhập số hoặc số thập phân sau dấu phẩy 3 chữ số ',
            params: /^[0-9]{1,12}(?:\.[0-9]{1,3})?$/
        }
    });
    self.fiTenHangSx = ko.observable(tbnk ? tbnk.fiTenHangSx() : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiMaTv = ko.observable(tbnk ? tbnk.fiMaTv() : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiMaKieuIn = ko.observable(tbnk ? tbnk.fiMaKieuIn() : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiMaChatLuong = ko.observable(tbnk ? tbnk.fiMaChatLuong() : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiMaTocdo = ko.observable(tbnk ? tbnk.fiMaTocdo() : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiMaKichThuoc = ko.observable(tbnk ? tbnk.fiMaKichThuoc() : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });


    self.fiIdHoso = ko.observable(null);
    self.fiIdHoso = ko.observable(null);

    self.lstDMTenTV = options.lstDMTenTV;
    self.lstDMKieuIn = options.lstDMKieuIn;
    self.lstDMChatLuong = options.lstDMChatLuong;
    self.lstDMDvKhuankho = options.lstDMDvKhuankho;
    self.lstDMDvTocDo = options.lstDMDvTocDo;


    var tbnkVG = [self.fiTenMay, self.fiKieuIn, self.fiSoMauIn, self.fiModelMay, self.fiSoDinhDanhMay, self.fiNuocSx, self.fiNamSx,
        self.fiSoLuong, self.fiChatLuong, self.fiKhuanKhoBanIn, self.fiDonViTinhKhuonKho, self.fiTocDoIn, self.fiDonViTocDoIn, self.fiGiaThietBi,
        self.fiTenHangSx, self.fiMaTv, self.fiMaKieuIn, self.fiMaChatLuong, self.fiMaTocdo, self.fiMaKichThuoc];
    self.TbnkErrors = ko.validation.group(tbnkVG, {deep: true, live: true, observable: true});

    self.errorradiopxkMessage = ko.observable(null);
    self.errormucdicpxkMessage = ko.observable(null);

    self.toJSON = function () {

        var exclude = ["init", "fiStt", "isValidTbnk", "lstDMTenTV", "lstDMKieuIn",
            "lstDMChatLuong", "lstDMDvKhuankho", "lstDMDvTocDo", "TbnkErrors", "toJSON"];

        var model = ko.toJS(self);

        for (var key in model) {
            if (exclude.indexOf(key) >= 0) {
                delete model[key];
            }
        }

        return model;
    };

    self.isValidTbnk = function () {

        if (self.TbnkErrors().length > 0) {
            self.TbnkErrors.showAllMessages();
            return true;
        }
    };



}
;

    