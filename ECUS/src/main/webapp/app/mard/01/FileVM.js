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
        ufVMSelf.uploadedFiles([]);
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
        if (!files || files.length === 0) {
            return;
        } else {
            $('#loading01').show();
            var fiTenLoai = ufVMSelf.selectedAttachVM().fiAttachmentTypeName();
            var fiMaLoai = ufVMSelf.selectedAttachVM().fiAttachmentTypeCode();
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
                        formData.append('documentType', 'BNNPTNT0600004');
                        formData.append('fileCode', fiMaLoai);
                        formData.append('fileName', fiFileName);
                        formData.append('file', files[0]);

                        $.ajax({
                            type: 'POST',
                            cache: false,
                            crossDomain: true,
                            url: UPLOAD_URL,
                            data: formData,
                            processData: false,
                            contentType: false,
                            success: function (res) {
                                $('#loading01').hide();
                                if (res.status == 'Successful') {
                                    var file = new FileVM({
                                        fiAttachmentId: res.data.ItemId,
                                        fiLinkFile: res.data.UrlFile,
                                        fiFileName: files[0].name,
                                        fiAttachmentTypeName: fiTenLoai,
                                        fiAttachmentTypeCode: fiMaLoai
                                    });
                                    $('#btnfile').val('');
                                    ufVMSelf.uploadedFiles.push(file);
                                    ufVMSelf.selectedAttachVM().isUploaded(true);
                                    ufVMSelf.errorMsg('');
                                } else {
                                    ufVMSelf.errorMsg('Có lỗi tải file lên');
                                }
                            },
                            error: function (x, t, m) {
                                $('#loading01').hide();
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
                    $('#loading01').hide();
                },
                complete: function (jqXHR, textStatus) {
                }
            });
        }
    }

    ufVMSelf.removeFileUpload = function (file) {
        ufVMSelf.uploadedFiles.remove(function (item) {
            return item.fiAttachmentId() == file.fiAttachmentId();
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
    }

    ufVMSelf.saveUpload = function() {
        var lstFilesCurrent = ufVMSelf.selectedAttachVM().lstFiles();
        var uploadedFiles = ufVMSelf.uploadedFiles();
        ufVMSelf.selectedAttachVM().lstFiles(lstFilesCurrent.concat(uploadedFiles));
        ufVMSelf.uploadedFiles([]);
        var lstAtchTemp = ufVMSelf.lstAtch();
        lstAtchTemp.map(function (value, index) {
            if (value.fiAttachmentTypeCode() == ufVMSelf.selectedAttachVM().fiAttachmentTypeCode()) {
                lstAtchTemp[index] = ufVMSelf.selectedAttachVM();
            }
        });
        $('.upload-file').prop("value", "");
        if ($('#modal_addFile').hasClass('in')) {
            $('#modal_addFile').modal('hide');
        }
        if ($('#modal_addFile20A').hasClass('in')) {
            $('#modal_addFile20A').modal('hide');
        }
    }

    ufVMSelf.doDelete = function (data) {
        var popConfirm = app.popup({
            title: 'Thông báo',
            html: '<b>Bạn chắc chắn muốn xoá dữ liệu của file này?</b>',
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
    }

    ufVMSelf.validate = function () {
        var lstAttachment = ufVMSelf.lstAtch();
        var isMissingFile = false;
        for (var i = 0; i < lstAttachment.length; i++) {
            if (lstAttachment[i].isRequired() && lstAttachment[i].lstFiles().length == 0) {
                isMissingFile = true;
                break;
            }
        }
        return !isMissingFile;
    }

    ufVMSelf.toJSON = function () {
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
    atchVMSelf.fiAttachmentTypeCode = ko.observable((options && options.hasOwnProperty('fiAttachmentTypeCode')) ? options.fiAttachmentTypeCode : null);
    atchVMSelf.fiAttachmentTypeName = ko.observable((options && options.hasOwnProperty('fiAttachmentTypeName')) ? options.fiAttachmentTypeName : null);
    atchVMSelf.isUploaded = ko.observable((options && options.hasOwnProperty('isUploaded')) ? options.isUploaded: false);
    atchVMSelf.isRequired = ko.observable((options && options.hasOwnProperty('isRequired')) ? options.isRequired : false);
    atchVMSelf.errorMsg = ko.observable(null);

    atchVMSelf.lstFiles = ko.observableArray([]);
}

function FileVM(options) {
    var fileVMSelf = this;
    fileVMSelf.fiAttachmentId = ko.observable((options && options.hasOwnProperty('fiAttachmentId')) ? options.fiAttachmentId : null);
    fileVMSelf.fiAttachmentTypeCode = ko.observable((options && options.hasOwnProperty('fiAttachmentTypeCode')) ? options.fiAttachmentTypeCode : null);
    fileVMSelf.fiAttachmentTypeName = ko.observable((options && options.hasOwnProperty('fiAttachmentTypeName')) ? options.fiAttachmentTypeName : null);
    fileVMSelf.fiFileName = ko.observable((options && options.hasOwnProperty('fiFileName')) ? options.fiFileName : null);
    fileVMSelf.fiLinkFile = ko.observable((options && options.hasOwnProperty('fiLinkFile')) ? options.fiLinkFile : null);

    fileVMSelf.downloadFile = function (data) {
        window.location = app.appContext + '/mard/01/dinhkem/download/' + data.fiAttachmentId();
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
            fiAttachmentTypeName: lstAtchType[i].atchTypeName,
            isUploaded: false,
            isRequired: lstAtchType[i].required,
            fiAttachmentTypeCode: lstAtchType[i].atchTypeId
        });

        for (var j = 0; j < lstAtch.length; j++) {
            if (lstAtchType[i].atchTypeId === lstAtch[j].fiAttachmentTypeCode) {
                var file = new FileVM(lstAtch[j]);
                attachmentVM.lstFiles.push(file);
                attachmentVM.isUploaded(true);
            }
        }

        result.push(attachmentVM)

    }


    return result;
}
