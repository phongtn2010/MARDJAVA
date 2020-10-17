var TOKEN_URL = 'https://mcupload.mard.gov.vn/UploadFile/FileAttachments/GetToken';
var UPLOAD_URL = 'https://mcupload.mard.gov.vn/UploadFile/FileAttachments/Upload';

function UploadFileVM (lstAtch, lstAtchType) {
    var ufVMSelf = this;
    ufVMSelf.lstAtch = ko.observableArray([]);
    ufVMSelf.selectedAttachVM = ko.observable(null);
    ufVMSelf.errorMsg = ko.observable(null);
    ufVMSelf.uploadedFiles = ko.observableArray([]);

    if (lstAtch) {
        ufVMSelf.lstAtch(mapAttachmentVM(lstAtch, lstAtchType));
    }

    ufVMSelf.addFiles = function (atchVM) {
        ufVMSelf.selectedAttachVM($.extend(true, {}, atchVM));
        var lstFiles = [];
        ufVMSelf.uploadedFiles(lstFiles.concat(ufVMSelf.selectedAttachVM().lstFiles()));
    };

    ufVMSelf.isValid = function() {
        var lstAttachment = ufVMSelf.lstAtch();
        var isMissingFile = false;
        for (var i = 0; i< lstAttachment.length; i++) {
            if (lstAttachment[i].isRequired() && lstAttachment[i].lstFiles().length == 0) {
                isMissingFile = true;
                break;
            }
        }
        return !isMissingFile;
    };

    ufVMSelf.fileChange = function (data, e) {
        var files = e.target.files;
        if (!files || files.length == 0) {
            return;
        } else {

            $('#loading10').show();
            var fiTenLoai = ufVMSelf.selectedAttachVM().fiTenLoai();
            var fiMaLoai = ufVMSelf.selectedAttachVM().fiMaLoai();
            var fiFileName = files[0].name;

            // Upload file
            var token = null;

            $.ajax({
                type: 'GET',
                cache: false,
                url: TOKEN_URL,
                success: function (response) {
                    if (response.status == 'Successful') {
                        token = response.data;
                        var formData = new FormData();
                        formData.append('token', token);
                        formData.append('documentType', 'BNNPTNT0600012');
                        formData.append('fileCode', fiMaLoai);
                        formData.append('fileName', fiFileName);
                        formData.append('file', files[0]);

                        $.ajax({
                            type: 'POST',
                            cache: false,
                            url: UPLOAD_URL,
                            data: formData,
                            processData: false,
                            contentType: false,
                            success: function (res) {
                                $('#loading10').hide();
                                if (res.status == 'Successful') {
                                    var file = new FileVM({
                                        fiGuid: res.data.ItemId,
                                        fiDuongDan: res.data.UrlFile,
                                        fiTenTep: files[0].name,
                                        fiTenLoai: fiTenLoai,
                                        fiMaLoai: fiMaLoai
                                    });
                                    $("#btnfile3").val('');
                                    $("#btnfile20a").val('');
                                    ufVMSelf.uploadedFiles.push(file);
                                    ufVMSelf.selectedAttachVM().isUploaded(true);
                                    ufVMSelf.errorMsg('');
                                } else {
                                    ufVMSelf.errorMsg('Có lỗi tải file lên');
                                }
                            },
                            error: function (x, t, m) {
                                $('#loading10').hide();
                            },
                            complete: function (jqXHR, textStatus) {
                                $(e.target).val("");
                            }
                        })
                    } else {
                        ufVMSelf.errorMsg('Có lỗi tải file lên');
                    }
                },
                error: function (x, t, m) {
                    $('#loading10').hide();
                },
                complete: function (jqXHR, textStatus) {
                }
            });
        }
    }

    ufVMSelf.removeFileUpload = function (file) {
        ufVMSelf.uploadedFiles.remove(function (item) {
            return item.fiGuid() == file.fiGuid();
        })
    }

    ufVMSelf.cancelUpload = function() {
        ufVMSelf.uploadedFiles([]);
        ufVMSelf.selectedAttachVM().isUploaded(false);
        $('.upload-file').prop("value", "");
        if ($('#modal_addFile').hasClass('in')) {
            $('#modal_addFile').modal('hide');
        }
        if ($('#modal_addFile20A').hasClass('in')) {
            $('#modal_addFile20A').modal('hide');
        }
    };

    ufVMSelf.saveUpload = function() {
        ufVMSelf.selectedAttachVM().lstFiles(ufVMSelf.uploadedFiles());
        $('.upload-file').prop("value", "");
        if ($('#modal_addFile').hasClass('in')) {
            $('#modal_addFile').modal('hide');
        }
        if ($('#modal_addFile20A').hasClass('in')) {
            $('#modal_addFile20A').modal('hide');
        }
    };

    ufVMSelf.doDelete = function (data) {
        var popConfirm = app.popup({
            title: 'Thông báo',
            html: '<b>Bạn chắc chắn muốn xóa hết các tệp của mục này?</b>',
            width: 450,
            buttons: [
                {
                    name: NSWLang["common_button_toi_chac_chan"],
                    class: 'btn',
                    icon: 'fa-save',
                    action: function () {
                        data.lstFiles([]);
                        data.isUploaded(false);
                        $('.upload-file').prop("value", "");
                        app.popupRemove(popConfirm.selector);
                    }
                },
                {
                    name: 'Huỷ',
                    class: 'btn',
                    icon: 'fa-close',
                    action: function () {
                        app.popupRemove(popConfirm.selector);
                    }
                }
            ]
        });
        return;
    };

    ufVMSelf.getLstAttachments = function () {
        var lstAttachment = ufVMSelf.lstAtch();
        var result = [];
        for (var i = 0; i < lstAttachment.length; i++) {
            var lstFiles = JSON.parse(ko.toJSON(lstAttachment[i].lstFiles()));
            result = result.concat(lstFiles);
        }
        return result;
    }
}

function AttachmentVM (options) {
    var atchVMSelf = this;
    atchVMSelf.fiMaLoai = ko.observable((options && options.hasOwnProperty('fiMaLoai')) ? options.fiMaLoai : null);
    atchVMSelf.fiTenLoai = ko.observable((options && options.hasOwnProperty('fiTenLoai')) ? options.fiTenLoai : null);
    atchVMSelf.isUploaded = ko.observable((options && options.hasOwnProperty('isUploaded')) ? options.isUploaded: false);
    atchVMSelf.isRequired = ko.observable((options && options.hasOwnProperty('isRequired')) ? options.isRequired: false);
    atchVMSelf.errorMsg = ko.observable(null);

    atchVMSelf.lstFiles = ko.observableArray([]);
}

function FileVM(options) {
    var fileVMSelf = this;
    fileVMSelf.fiIdDinhkem = ko.observable((options && options.hasOwnProperty('fiIdDinhkem')) ? options.fiIdDinhkem : null);
    fileVMSelf.fiMaLoai = ko.observable((options && options.hasOwnProperty('fiMaLoai')) ? options.fiMaLoai : null);
    fileVMSelf.fiTenLoai = ko.observable((options && options.hasOwnProperty('fiTenLoai')) ? options.fiTenLoai : null);
    fileVMSelf.fiTenTep = ko.observable((options && options.hasOwnProperty('fiTenTep')) ? options.fiTenTep : null);
    fileVMSelf.fiNoiDung = ko.observable((options && options.hasOwnProperty('fiNoiDung')) ? options.fiNoiDung : null);
    fileVMSelf.fiHoatdong = ko.observable((options) && options.hasOwnProperty('fiHoatdong') ? options.fiHoatdong : 1);
    fileVMSelf.fiDuongDan = ko.observable((options && options.hasOwnProperty('fiDuongDan')) ? options.fiDuongDan : null);
    fileVMSelf.fiGuid = ko.observable((options && options.hasOwnProperty('fiGuid')) ? options.fiGuid : null);
    fileVMSelf.fiIdHS = ko.observable((options && options.hasOwnProperty('fiIdHS')) ? options.fiIdHS : null);

    fileVMSelf.downloadFile = function (data) {
        window.location = app.appContext + '/mard/09/dinhkem/download/' + data.fiGuid();
        return true;
    }
}

function getFileNameByUrl(url) {
    url = decodeURI(url);
    var lstString = url.split("\\");
    return lstString[lstString.length - 1];
}

function mapAttachmentVM(lstAtch, lstAtchType) {
    var result = [];

    for (var i = 0; i < lstAtchType.length; i++) {
        var attachmentVM = new AttachmentVM({
            fiTenLoai: lstAtchType[i].name,
            isUploaded: false,
            fiMaLoai: lstAtchType[i].id,
            isRequired: lstAtchType[i].required
        });

        for (var j = 0; j < lstAtch.length; j++) {
            if (lstAtchType[i].id === lstAtch[j].fiMaLoai) {
                var file = new FileVM(lstAtch[j]);
                attachmentVM.lstFiles.push(file);
                attachmentVM.isUploaded(true);
            }
        }

        result.push(attachmentVM)

    }

    return result;
}
