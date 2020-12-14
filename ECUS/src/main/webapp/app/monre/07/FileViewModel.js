/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* global app */
var lstFileType = [
    {
        'fiIdDk': '1',
        'fiMaloaiTep': '1',
        'fiTenloaiTep': 'Tài liệu khác',
        'fiTenTep': null,
        'fiIdTep': null,
        'fiDuongdan': null,
        'fiTenteptin': null,
        'fiIdDt': null,
        'fiLoaiDt': null,
        'fiHoatdong': null,
        'fiNguoitao': null,
        'fiNgaytao': null,
        'fiNgCapnhat': null
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
    idTthc: '159', // BTNMT0700001
    client_key: 'MDM_AUTH_API',
    client_secret: 'secret'
};

function File07VM(item, idHoso) {
    var self = this;

    self.fiIdDk = ko.observable((item !== null && item.hasOwnProperty('fiIdDk')) ? item.fiIdDk : null);
    self.fiMaloaiTep = ko.observable((item !== null && item.hasOwnProperty('fiMaloaiTep')) ? item.fiMaloaiTep : null);
    self.fiTenloaiTep = ko.observable((item !== null && item.hasOwnProperty('fiTenloaiTep')) ? item.fiTenloaiTep : null);
    self.fiTenTep = ko.observable((item !== null && item.hasOwnProperty('fiTenTep')) ? item.fiTenTep : null);
    self.fiIdTep = ko.observable((item !== null && item.hasOwnProperty('fiIdTep')) ? item.fiIdTep : null);
    self.fiDuongdan = ko.observable((item !== null && item.hasOwnProperty('fiDuongdan')) ? item.fiDuongdan : null);
    self.fiTenteptin = ko.observable((item !== null && item.hasOwnProperty('fiTenteptin')) ? item.fiTenteptin : null);
    self.fiIdDt = ko.observable(idHoso);
    self.fiLoaiDt = ko.observable((item !== null && item.hasOwnProperty('fiLoaiDt')) ? item.fiLoaiDt : null);
    self.fiHoatdong = ko.observable((item !== null && item.hasOwnProperty('fiHoatdong')) ? item.fiHoatdong : null);
    self.fiNguoitao = ko.observable((item !== null && item.hasOwnProperty('fiNguoitao')) ? item.fiNguoitao : null);
    self.fiNgaytao = ko.observable((item !== null && item.hasOwnProperty('fiNgaytao')) ? item.fiNgaytao : null);
    self.fiNgCapnhat = ko.observable((item !== null && item.hasOwnProperty('fiNgCapnhat')) ? item.fiNgCapnhat : null);

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

function mapFiles07VM(dataFromServer, idHoso) {
    return ko.utils.arrayMap(dataFromServer, function (item, index) {
        return new File07VM(item, idHoso);
    });
}

function Monre07FilesVM(data) {
    var self = this;
    var hoso = (data !== null && data.hasOwnProperty('hoso')) ? data.hoso : null;
    //Id ho so & Ma ho so
    self.fiIdHoso = ko.observable(hoso !== null ? hoso.fiIdHoso : null);
    self.fiMaHoso = ko.observable(hoso !== null ? hoso.fiMaHoso : null);
    //Danh sach cac loai dinh kem trong ho so
    self.lstDinhKem = ko.observableArray(mapFiles07VM(lstFileType, self.fiIdHoso()));
    /**
     * Gan ID ho so cho tung attachment
     * @returns {undefined}
     */
    self.assignDocToAttachments = function () {
        for (var i = 0; i < self.lstDinhKem().length; i++) {
            self.lstDinhKem()[i].fiIdDt(self.fiIdHoso());
        }
    };
    /**
     * Init data on form
     * @returns {undefined}
     */
    self.init = function () {
        if (hoso) {
            if (hoso.lstDinhKem) {
                var fiMaLoai = null;
                var pl = null;
                var index = -1;
                for (var i = 0; i < hoso.lstDinhKem.length; i++) {
                    pl = hoso.lstDinhKem[i];
                    fiMaLoai = pl.fiMaloaiTep;
                    index = self.lstDinhKem.firstIndexOf(function (item) {
                        return item.fiMaloaiTep() == fiMaLoai;
                    });

                    if (index >= 0) {
                        self.lstDinhKem()[index].fiDuongdan(pl.fiDuongdan);
                        self.lstDinhKem()[index].fiHoatdong(pl.fiHoatdong);
                        self.lstDinhKem()[index].fiIdDt(pl.fiIdDt);
                        self.lstDinhKem()[index].fiIdTep(pl.fiIdTep);
                        self.lstDinhKem()[index].fiLoaiDt(pl.fiLoaiDt);//1:ho so, 2: Thong bao 
                        self.lstDinhKem()[index].fiMaloaiTep(pl.fiMaloaiTep);
                        self.lstDinhKem()[index].fiNgCapnhat(pl.fiNgCapnhat);
                        self.lstDinhKem()[index].fiNgaytao(pl.fiNgaytao);
                        self.lstDinhKem()[index].fiNguoitao(pl.fiNguoitao);
                        self.lstDinhKem()[index].fiTenTep(pl.fiTenTep);
                        self.lstDinhKem()[index].fiTenloaiTep(pl.fiTenloaiTep);
                        self.lstDinhKem()[index].fiTenteptin(pl.fiTenteptin);
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
        console.log(item);
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
                    var index = self.lstDinhKem.firstIndexOf(function (attachment) {
                        return attachment.fiMaloaiTep() == item.fiMaloaiTep();
                    });

                    if (index >= 0) {
                        self.lstDinhKem()[index].fiIdTep(fileId);
                        self.lstDinhKem()[index].fiLoaiDt(1);//1:ho so, 2: Thong bao 
                        self.lstDinhKem()[index].fiTenTep(fileInfo.FileName);
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
                console.log('NSW:error: ', e);
                return;
            }
        });
    };
    /**
     * Validate file
     * @returns {Boolean}
     */
    self.isValidForm = function () {
        if(!self.fiMaHoso())
            return true;
        var isVaild = false;
        if (self.lstDinhKem()[0].fiIdTep()) {
            isVaild = true;
        }
        return isVaild;
    };
    /**
     * Convert to json data
     * @returns {unresolved}
     */
    self.toJSON = function () {
        var files = ko.observableArray([]);
        for (var i = 0; i < self.lstDinhKem().length; i++) {
            if (self.lstDinhKem()[i].fiIdTep()) {
                files.push(self.lstDinhKem()[i]);
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
