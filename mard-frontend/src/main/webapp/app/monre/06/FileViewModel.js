/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* global app */
var lstDinhKem = [
    {
        'fiIdDk': '1',
        'fiMaloaiTep': '1',
        'fiTenloaiTep': 'Giấy xác nhận ',
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
    },
    {
        'fiIdDk': '2',
        'fiMaloaiTep': '2',
        'fiTenloaiTep': 'Văn bản thông báo về lô hàng phế liệu nhập khẩu để kiểm tra, thông quan',
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
    },
    {
        'fiIdDk': '3',
        'fiMaloaiTep': '3',
        'fiTenloaiTep': 'Giấy xác nhận ký quỹ bảo đảm phế liệu nhập khẩu do Quỹ Bảo vệ môi trường Việt Nam hoặc ngân hàng thương mại nơi tổ chức, cá nhân ký quỹ bảo đảm phế liệu nhập khẩu cấp',
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
    },
    {
        'fiIdDk': '4',
        'fiMaloaiTep': '4',
        'fiTenloaiTep': 'Văn bản chứng nhận phù hợp quy chuẩn kỹ thuật môi trường đối với lô hàng phế liệu nhập khẩu của tổ chức chứng nhận phù hợp có tên trong danh sách đã được Bộ Tài nguyên và Môi trường chỉ định',
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
    },
    {
        'fiIdDk': '5',
        'fiMaloaiTep': '5',
        'fiTenloaiTep': 'Hợp đồng ủy thác nhập khẩu ký với tổ chức, cá nhân sử dụng phế liệu nhập khẩu làm nguyên liệu sản xuất đã được cấp Giấy xác nhận nhập khẩu phế liệu',
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
    },
    {
        'fiIdDk': '6',
        'fiMaloaiTep': '6',
        'fiTenloaiTep': 'Giấy xác nhận nhập khẩu phế liệu của tổ chức, cá nhân nhận ủy thác nhập khẩu phế liệu',
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
    },
    {
        'fiIdDk': '7',
        'fiMaloaiTep': '7',
        'fiTenloaiTep': 'Giấy xác nhận nhập khẩu phế liệu còn hiệu lực của tổ chức, cá nhân ủy thác nhập khẩu phế liệu',
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
    },
    {
        'fiIdDk': '-1',
        'fiMaloaiTep': '-1',
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
    apiUrl: 'https://mdm.monre.gov.vn:8800/',
    uploadUrl: 'api/core/mdm/nodes/upload?destinationPath=',
    downloadUrl: 'api/core/mdm/nodes/viewbyid/',
    applicationId: '48ED5B71-66DC-4725-9604-4C042E45FA3F',
    userId: 'e5e568d2-0226-4583-be08-fec5e36a8b4e',
    rootFolder: 'DVCHQ',
    tenLinhVuc: 'Moi Truong',
    idTthc: '159', // BTNMT0600001
    client_key: 'MDM_AUTH_API',
    client_secret: 'secret'
};

function File06VM(item, idHoso) {
    var self = this;

    self.fiIdDk = ko.observable((item !== null && item.hasOwnProperty('fiIdDk')) ? item.fiIdDk : null);
    self.fiMaloaiTep = ko.observable((item !== null && item.hasOwnProperty('fiMaloaiTep')) ? item.fiMaloaiTep : null);
    self.fiTenloaiTep = ko.observable((item !== null && item.hasOwnProperty('fiTenloaiTep')) ? item.fiTenloaiTep : null);
    self.fiTenTep = ko.observable((item !== null && item.hasOwnProperty('fiTenTep')) ? item.fiTenTep : null);
    self.fiIdTep = ko.observable((item !== null && item.hasOwnProperty('fiIdTep')) ? item.fiIdTep : null);
    self.fiDuongdan = ko.observable((item !== null && item.hasOwnProperty('fiDuongdan')) ? item.fiDuongdan : null);
    self.fiTenteptin = ko.observable((item !== null && item.hasOwnProperty('fiTenteptin')) ? item.fiTenteptin : null);
    //self.fiIdDt = ko.observable((item !== null && item.hasOwnProperty('fiIdDt')) ? item.fiIdDt : null);
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

function mapFiles06VM(dataFromServer, idHoso) {
    return ko.utils.arrayMap(dataFromServer, function (item, index) {
        return new File06VM(item, idHoso);
    });
}

function Monre06FilesVM(data) {
    var self = this;
    var hoso = (data !== null && data.hasOwnProperty('hoso')) ? data.hoso : null;
    //Id ho so & Ma ho so
    self.fiIdHoso = ko.observable(hoso !== null ? hoso.fiIdHoso : null);
    self.fiMaHoso = ko.observable(hoso !== null ? hoso.fiMaHoso : null);
    //Hinh thuc thong bao
    self.fiHinhthuc = ko.observable(hoso !== null ? hoso.fiHinhthuc : 0);
    //Danh sach cac loai dinh kem trong ho so
    self.lstDinhKem = ko.observableArray([]);
    /**
     * Update list dinh kem theo hinh thuc thong bao
     * @param {type} fiHt
     * @returns {undefined}
     */
    self.updateList = function (fiHt) {

        if (fiHt != null) {
            self.fiHinhthuc(fiHt);
        }
        var newList = [];

        if (self.fiHinhthuc() == 0) {
            newList.push(lstDinhKem[0]);
            newList.push(lstDinhKem[1]);
            newList.push(lstDinhKem[2]);
            newList.push(lstDinhKem[3]);
            newList.push(lstDinhKem[7]);

        } else {
            newList.push(lstDinhKem[1]);
            newList.push(lstDinhKem[2]);
            newList.push(lstDinhKem[3]);
            newList.push(lstDinhKem[4]);
            newList.push(lstDinhKem[5]);
            newList.push(lstDinhKem[6]);
            newList.push(lstDinhKem[7]);
        }
        self.lstDinhKem(mapFiles06VM(newList, self.fiIdHoso()));
    };
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
        self.updateList(self.fiHinhthuc());
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
                return;
            }
        });
    };
    /**
     * Validate file
     * @returns {Boolean}
     */
    self.isValidForm = function () {
        return true;
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
