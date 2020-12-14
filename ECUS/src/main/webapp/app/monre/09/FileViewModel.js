/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* global app */
var lstFileType = [
    {
        'fiIdDk': '1',
        'fiMaLoaiTep': '1',
        'fiTenLoaiTep': 'Tài liệu khác',
        'fiTenTep': null,
        'fiIdTep': null,
        'fiDuongdan': null,
        'fiTenTepTin': null,
        'fiIdDt': null,
        'fiLoaiDt': null,
        'fiHoatdong': null,
        'fiNguoitao': null,
        'fiNgaytao': null,
        'fiNgayCapnhat': null
    }
];

var MDMConfig = {
    apiUrl: 'http://mdm1.monre.gov.vn:8800/',
    uploadUrl: 'api/core/mdm/nodes/upload?destinationPath=',
    downloadUrl: 'api/core/mdm/nodes/viewbyid/',
    applicationId: '48ED5B71-66DC-4725-9604-4C042E45FA3F',
    userId: '54e668e9-0e98-4c2f-bf63-d9bdb92386d3',
    rootFolder: 'DVCHQ',
    tenLinhVuc: 'Moi Truong',
    idTthc: '159', // BTNMT0900001
    client_key: 'MDM_AUTH_API',
    client_secret: 'secret'
};

function File09VM(item, idHoso) {
    var self = this;
    self.fiIdDk = ko.observable((item !== null && item.hasOwnProperty('fiIdDk')) ? item.fiIdDk : null);
    self.fiMaLoaiTep = ko.observable((item !== null && item.hasOwnProperty('fiMaLoaiTep')) ? item.fiMaLoaiTep : null);
    self.fiTenLoaiTep = ko.observable((item !== null && item.hasOwnProperty('fiTenLoaiTep')) ? item.fiTenLoaiTep : null);
    self.fiTenTep = ko.observable((item !== null && item.hasOwnProperty('fiTenTep')) ? item.fiTenTep : null);
    self.fiIdTep = ko.observable((item !== null && item.hasOwnProperty('fiIdTep')) ? item.fiIdTep : null);
    self.fiDuongdan = ko.observable((item !== null && item.hasOwnProperty('fiDuongdan')) ? item.fiDuongdan : null);
    self.fiTenTepTin = ko.observable((item !== null && item.hasOwnProperty('fiTenTepTin')) ? item.fiTenTepTin : null);
    self.fiIdDt = ko.observable(idHoso);
    self.fiLoaiDt = ko.observable((item !== null && item.hasOwnProperty('fiLoaiDt')) ? item.fiLoaiDt : null);
    self.fiHoatdong = ko.observable((item !== null && item.hasOwnProperty('fiHoatdong')) ? item.fiHoatdong : null);
    self.fiNguoitao = ko.observable((item !== null && item.hasOwnProperty('fiNguoitao')) ? item.fiNguoitao : null);
    self.fiNgaytao = ko.observable((item !== null && item.hasOwnProperty('fiNgaytao')) ? item.fiNgaytao : null);
    self.fiNgayCapnhat = ko.observable((item !== null && item.hasOwnProperty('fiNgayCapnhat')) ? item.fiNgayCapnhat : null);
    self.isValidate = ko.observable((item !== null && item.hasOwnProperty('isValidate')) ? item.isValidate : null);
    
    self.isRequire = ko.computed(function () {
        return (self.isValidate() == 1);
    }, this);

    self.showUploader = ko.computed(function () {
        return (self.fiIdTep() == null && self.fiIdDt() != null);
    }, this);

    self.bView = ko.computed(function () {
        return self.fiIdTep() != null;
    }, this);

    self.bDelete = ko.computed(function () {
        return self.fiIdTep() != null;
    }, this);

    self.viewUrl = ko.computed(function () {
        if (self.fiIdTep()) {
            return MDMConfig.apiUrl + MDMConfig.downloadUrl + self.fiIdTep();
        }
        return null;
    }, this);
}

function mapFiles09VM(dataFromServer, idHoso) {
    return ko.utils.arrayMap(dataFromServer, function (item, index) {
        return new File09VM(item, idHoso);
    });
}

function Monre09FilesVM(data) {
    var self = this;
    var hoso = (data !== null && data.hasOwnProperty('hoso')) ? data.hoso : null;
    //Id ho so & Ma ho so
    self.fiIdHoso = ko.observable(hoso !== null ? hoso.fiIdHoso : null);
    self.fiMaHoso = ko.observable(hoso !== null ? hoso.fiMaHoso : null);
    //Danh sach cac loai dinh kem trong ho so
    self.lstDinhKem9 = ko.observableArray(mapFiles09VM(data.dmDinhKem, self.fiIdHoso()));
    /**
     * Gan ID ho so cho tung attachment
     * @returns {undefined}
     */
    self.assignDocToAttachments = function () {
        for (var i = 0; i < self.lstDinhKem9().length; i++) {
            self.lstDinhKem9()[i].fiIdDt(self.fiIdHoso());
        }
    };
    /**
     * Init data on form
     * @returns {undefined}
     */
    self.init = function () {
        if (hoso) {
            if (hoso.lstDinhKem9) {
                var fiMaLoai = null;
                var pl = null;
                var index = -1;
                for (var i = 0; i < hoso.lstDinhKem9.length; i++) {
                    pl = hoso.lstDinhKem9[i];
                    fiMaLoai = pl.fiMaLoaiTep;
                    index = self.lstDinhKem9.firstIndexOf(function (item) {
                        return item.fiMaLoaiTep() == fiMaLoai;
                    });

                    if (index >= 0) {
                        self.lstDinhKem9()[index].fiDuongdan(pl.fiDuongdan);
                        self.lstDinhKem9()[index].fiHoatdong(pl.fiHoatdong);
                        self.lstDinhKem9()[index].fiIdDt(pl.fiIdDt);
                        self.lstDinhKem9()[index].fiIdTep(pl.fiIdTep);
                        self.lstDinhKem9()[index].fiLoaiDt(pl.fiLoaiDt);//1:ho so, 2: Thong bao 
                        self.lstDinhKem9()[index].fiMaLoaiTep(pl.fiMaLoaiTep);
                        self.lstDinhKem9()[index].fiNgayCapnhat(pl.fiNgayCapnhat);
                        self.lstDinhKem9()[index].fiNgaytao(pl.fiNgaytao);
                        self.lstDinhKem9()[index].fiNguoitao(pl.fiNguoitao);
                        self.lstDinhKem9()[index].fiTenTep(pl.fiTenTep);
                        self.lstDinhKem9()[index].fiTenLoaiTep(pl.fiTenLoaiTep);
                        self.lstDinhKem9()[index].fiTenTepTin(pl.fiTenteptin);

                    }

                }
            } else {
                self.assignDocToAttachments();
            }
        } else {
            self.assignDocToAttachments();
        }
    };
    /**
     * Onlick file attachment
     * @param {type} item
     * @returns {undefined}
     */
    self.viewFileOnClick = function (item) {

    };
    /**
     * Remove file
     * @param {type} item
     * @returns {undefined}
     */
    self.deleteFileOnClick = function (item) {
        if (item) {
            item.fiTenTep(null);
            item.fiIdTep(null);
            item.viewUrl(null);
        }
    };
    /**
     * Upload file
     * @param {type} item
     * @param {type} e
     * @returns {undefined}
     */
    self.fileUpload = function (item, e) {
        $('#loading10').show();
        var files = e.target.files;
        if (!files || files.length <= 0) {
            return;
        }

        var dt = new Date();
        var y = dt.getFullYear();
        var d = (dt.getDate() >= 10) ? dt.getDate() : "0" + dt.getDate();
        var m = (dt.getMonth() >= 9) ? dt.getMonth() + 1 : "0" + (dt.getMonth() + 1);

        var urlPath = MDMConfig.rootFolder + "/" + MDMConfig.tenLinhVuc + "/" + MDMConfig.idTthc + "/" + y + "/" + m + "/" + d + "/" + self.fiMaHoso();

        var fd = new FormData();
        fd.append("file", files[0]);
        //Check validate file
        if (!Util.uploadFileNameValidate(files[0].name)) {
            $('#loading10').hide();
            //no remove this line
            e.target.value = '';
            return;
        }

        if (!Util.validateFieExtensionWithoutDom(files)) {
            $('#loading10').hide();
            //no remove this line
            e.target.value = '';
            return;
        }
        //no remove this line
        e.target.value = '';

        $.ajax({
            type: 'POST',
            url: MDMConfig.apiUrl + MDMConfig.uploadUrl + urlPath,
            data: fd,
            //dataType: 'multipart/form-data',
            contentType: false,
            processData: false,
            beforeSend: function (xhr) {
                xhr.setRequestHeader('Authorization', "Basic " + btoa(MDMConfig.client_key + ":" + MDMConfig.client_secret));
                xhr.setRequestHeader("X-ApplicationId", MDMConfig.applicationId);
                xhr.setRequestHeader("X-User", MDMConfig.userId);
            },
            complete: function (e, x, s) {
                $('#loading10').hide();
                var data = JSON.parse(e.responseText);
                if (data.Data) {
                    var fileInfo = data.Data[0];
                    var fileId = fileInfo.NodeId;
                    //Update lai thong tin dinh kem
                    var index = self.lstDinhKem9.firstIndexOf(function (attachment) {
                        return attachment.fiMaLoaiTep() == item.fiMaLoaiTep();
                    });

                    if (index >= 0) {
                        self.lstDinhKem9()[index].fiIdTep(fileId);
                        self.lstDinhKem9()[index].fiLoaiDt(1);//1:ho so, 2: Thong bao 
                        self.lstDinhKem9()[index].fiTenTep(fileInfo.FileName);
                    } else {
                        app.Alert('Xảy ra lỗi khi lưu dữ liệu file, không tìm thấy loại file quy định.');
                        return;
                    }

                } else {
                    app.Alert('Lỗi Service: Không thể upload được file đính kèm');
                    return;
                }
            },
            error: function (j, t, e) {
                $('#loading10').hide();
                app.Alert('Lỗi Service: Không thể upload được file đính kèm');

                return;
            }
        });
    };
    /**
     * Validate file
     * @returns {Boolean}
     */
//    self.isValidForm = function () {
//        if(!self.fiMaHoso())
//            return true;
//        var isVaild = false;
//        if (self.lstDinhKem9()[0].fiIdTep()) {
//            isVaild = true;
//        }
//        return isVaild;
//    };
    self.isValidForm = function () {
        if (!self.fiMaHoso())
            return true;
        var isVaild = true;

        for (var i = 0; i < self.lstDinhKem9().length - 1; i++) {
            if (self.lstDinhKem9()[i].fiIdTep() == null && self.lstDinhKem9()[i].isValidate() ==1) {
                isVaild = false;
                break;
            }
        }
        return isVaild;
    };
    /**
     * Convert to json data
     * @returns {unresolved}
     */
    self.toJSON = function () {
        var files = ko.observableArray([]);
        for (var i = 0; i < self.lstDinhKem9().length; i++) {
            if (self.lstDinhKem9()[i].fiIdTep()) {
                files.push(self.lstDinhKem9()[i]);
            }
        }
        //xoa cac thuoc tinh khong can thiet
        for (var i = 0; i < files().length; i++) {
            files()[i].fiIdDk(null);
            delete files()[i]['showUploader'];
            delete files()[i]['bView'];
            delete files()[i]['bDelete'];
            delete files()[i]['viewUrl'];
        }
        return ko.toJS(files);
    };

    //INIT DATA
    self.init();
}
