/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function FileVM(item, idHoso) {
    var self = this;
    self.fiMaHoSo = ko.observable((item !== null && item.hasOwnProperty('fiMaHoSo')) ? item.fiMaHoSo : null);
    self.fiId = ko.observable((item !== null && item.hasOwnProperty('fiId')) ? item.fiId : null);
    self.fiIdDinhkem = ko.observable((item !== null && item.hasOwnProperty('fiIdDinhkem')) ? item.fiIdDinhkem : null);
    self.fiTenDinhKem = ko.observable((item !== null && item.hasOwnProperty('fiTenDinhKem')) ? item.fiTenDinhKem : null);
    self.fiRequired = ko.observable((item !== null && item.hasOwnProperty('fiRequired')) ? item.fiRequired : null);
    self.fiIdHoSo = ko.observable((item !== null && item.hasOwnProperty('fiIdHoSo')) ? item.fiIdHoSo : null);
    self.fiDuongDan = ko.observable((item !== null && item.hasOwnProperty('fiDuongDan')) ? item.fiDuongDan : null);
    self.fiMaDinhKem = ko.observable((item !== null && item.hasOwnProperty('fiMaDinhKem')) ? item.fiMaDinhKem : null);
    self.fiGuiid = ko.observable((item !== null && item.hasOwnProperty('fiGuiid')) ? item.fiGuiid : null);
    self.fiLoaiTepTin = ko.observable((item !== null && item.hasOwnProperty('fiLoaiTepTin')) ? item.fiLoaiTepTin : null);
    self.fiTenLoaiTep = ko.observable((item !== null && item.hasOwnProperty('fiTenLoaiTep')) ? item.fiTenLoaiTep : null);
    self.fiTenTepTin = ko.observable((item !== null && item.hasOwnProperty('fiTenTepTin')) ? item.fiTenTepTin : null);
    self.fiTepTinId = ko.observable((item !== null && item.hasOwnProperty('fiTepTinId')) ? item.fiTepTinId : null);
    self.fiNgayTao = ko.observable((item !== null && item.hasOwnProperty('fiNgayTao')) ? item.fiNgayTao : null);
    self.fiNguoiTao = ko.observable((item !== null && item.hasOwnProperty('fiNguoiTao')) ? item.fiNguoiTao : null);
    self.fiHoatDong = ko.observable((item !== null && item.hasOwnProperty('fiHoatDong')) ? item.fiHoatDong : null);
    self.lstFiles = ko.observableArray((item !== null && item.hasOwnProperty('lstFiles')) ? item.lstFiles : []);

    if (idHoso > 0 && DINHKEMDATA != null) {

        var len = DINHKEMDATA.length;
        for (var i = 0; i <= len - 1; i++) {
            if (item.fiMaDinhKem == DINHKEMDATA[i].fiMaDinhKem) {
                self.fiRequired(DINHKEMDATA[i].fiRequired);
                break;
            }
        }
    }

    self.isRequire = ko.computed(function () {
        return (self.fiRequired() == 1);
    }, this);

    self.canUpload = ko.computed(function () {
        return (self.fiTenTepTin() === null);
    }, this);
    

    self.canDownload = ko.computed(function () {
        return self.fiTenTepTin() !== null;
    }, this);

    self.canDelete = ko.computed(function () {
      return self.lstFiles().length >0;
    }, this);
    self.canDeleteSingle = ko.computed(function () {
       return self.fiTenTepTin() !== null;
    }, this);

    self.downloadUrl = ko.computed(function () {
        if (self.fiTenTepTin()) {
            if (self.fiIdHoSo() === null) {
                return app.appContext + '/bca/01/file/bca/01/' + self.fiGuiid();
            } else {
                return app.appContext + '/bca/01/download/' + self.fiGuiid() + '/' + self.fiIdDinhkem();
            }
        }
        return null;
    }, this);
    
    self.doDownloadFileItem = function (item, e) {
        var strUrl = "http://giamngheo.mic.gov.vn/Pages/NSW_UploadFile.aspx?idFile="+item.fiTepTinId;
        window.open(strUrl, "_blank"); 
    }
    
    self.doDeleteFileItem = function (item, e) {
        self.lstFiles(self.lstFiles().filter(obj => obj.fiTepTinId !== item.fiTepTinId));
    }

    self.doUpload = function (item, e) {
        $('#loading10').show();
        var files = e.target.files;
        if (!files || files.length <= 0) {
            return;
        }

        var timeNow = "";
        var dt = new Date();
        var d = (dt.getDate() >= 10) ? dt.getDate() : "0" + dt.getDate();
        var m = (dt.getMonth() >= 9) ? dt.getMonth() + 1 : "0" + (dt.getMonth() + 1);
        var y = dt.getFullYear();
        var hours = dt.getHours();
        var minutes = dt.getMinutes();
        timeNow += d + "/" + m + "/" + y + " " + hours + ":" + minutes;
        var tokenGen = md5(timeNow + "nqanhVnpt@123");

        var fd = new FormData();
        fd.append("file", files[0]);
        fd.append("token", tokenGen);
        fd.append("thoiGian", timeNow);

        var fileName = files[0].name;

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
        if (!Util.validateFieExtensionWithoutDom(files)) {
            $('#loading10').hide();
            //no remove this line
            e.target.value = '';
            return;
        }
        
        

        e.target.value = '';
        $.ajax({
            type: 'POST',
            url: 'http://103.16.1.85/_layouts/15/PagesNSW/NSW_UploadFile.aspx',
            data: fd,
            dataType: 'multipart/form-data',
            contentType: false,
            processData: false,
            complete: function (e, x, s) {
                $('#loading10').hide();
                var data = JSON.parse(e.responseText);
                if (data.iDFiles) {
//                    self.fiTepTinId(data.iDFiles);
//                    self.fiTenTepTin(fileName);
//                    self.fiDuongDan("http://giamngheo.mic.gov.vn/Pages/NSW_UploadFile.aspx?idFile=" + data.iDFiles);
                    var fileObj = {
                        fiTepTinId:data.iDFiles,
                        fiTenTepTin:fileName
                    }
                    self.lstFiles.push(fileObj);
                    
                }
                if(self.fiRequired()){
                   $("#valid-file").hide();  
                }
                

            },
            error: function (j, t, e) {
                $('#loading10').hide();
                return;
            }
        });

    };
    
    self.doUploadSingle = function (item, e) {
        $('#loading10').show();

        var files = e.target.files;
        if (!files || files.length <= 0) {
            return;
        }

        var timeNow = "";
        var dt = new Date();
        var d = (dt.getDate() >= 10) ? dt.getDate() : "0" + dt.getDate();
        var m = (dt.getMonth() >= 9) ? dt.getMonth() + 1 : "0" + (dt.getMonth() + 1);
        var y = dt.getFullYear();
        var hours = dt.getHours();
        var minutes = dt.getMinutes();
        timeNow += d + "/" + m + "/" + y + " " + hours + ":" + minutes;
        var tokenGen = md5(timeNow + "nqanhVnpt@123");

        var fd = new FormData();
        fd.append("file", files[0]);
        fd.append("token", tokenGen);
        fd.append("thoiGian", timeNow);

        var fileName = files[0].name;

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
        if (!Util.validateFieExtensionWithoutDom(files)) {
            $('#loading10').hide();
            //no remove this line
            e.target.value = '';
            return;
        }
        
        

        e.target.value = '';
        $.ajax({
            type: 'POST',
            url: 'http://103.16.1.85/_layouts/15/PagesNSW/NSW_UploadFile.aspx',
            data: fd,
            dataType: 'multipart/form-data',
            contentType: false,
            processData: false,
            complete: function (e, x, s) {
                $('#loading10').hide();
                var data = JSON.parse(e.responseText);
                debugger;
                if (data.iDFiles) {
                    self.fiTepTinId(data.iDFiles);
                    self.fiTenTepTin(fileName);
                    self.fiDuongDan("http://giamngheo.mic.gov.vn/Pages/NSW_UploadFile.aspx?idFile=" + data.iDFiles);
                    
                }
                 $("#valid-file").hide();

            },
            error: function (j, t, e) {
                $('#loading10').hide();
                return;
            }
        });

    };
    
    self.doDelete = function (item, e) {
        
        var pop = app.popup({
            title: 'Thông báo',
            html: '<b>Bạn chắc chắn muốn xoá dữ liệu của file này?</b>',
            width: 450,
            buttons: [
                {
                    name: NSWLang["common_button_toi_chac_chan"],
                    class: 'btn',
                    icon: 'fa-save',
                    action: function () {
                        
                        self.lstFiles([]);
//                        self.fiGuiid(null);
//                        self.fiTenTepTin(null);
//                        self.fiDuongDan(null);
//                        self.fiIdHoSo(null);
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
        return;
    };

    self.doDeleteNoPopup = function (item, e) {
        self.fiGuiid(null);
        self.fiTenTepTin(null);
        self.fiDuongDan(null);
        self.fiIdHoSo(null);
        return;
    };

}
function mapFilesVM(data, idHoso) {
    return ko.utils.arrayMap(data, function (item, index) {
        return new FileVM(item, idHoso);
    });
}



