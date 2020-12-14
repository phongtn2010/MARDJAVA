/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function FileVM(item, idHoso) {
    debugger;
    var self = this;
    self.fileTypeCode = ko.observable((item !== null && item.hasOwnProperty('fileTypeCode')) ? item.fileTypeCode : null);
    self.fileTypeName = ko.observable((item !== null && item.hasOwnProperty('fileTypeName')) ? item.fileTypeName : null);
    self.fileId = ko.observable((item !== null && item.hasOwnProperty('fileId')) ? item.fileId : null);
    self.attachmentId = ko.observable((item !== null && item.hasOwnProperty('attachmentId')) ? item.attachmentId : null);
    self.isRequired = ko.observable((item !== null && item.hasOwnProperty('isRequired')) ? item.isRequired : null);
    self.fileCode = ko.observable((item !== null && item.hasOwnProperty('fileCode')) ? item.fileCode : null);
    self.fileName = ko.observable((item !== null && item.hasOwnProperty('fileName')) ? item.fileName : null);
    self.attachmentListId = ko.observable((item !== null && item.hasOwnProperty('attachmentListId')) ? item.attachmentListId : null);
    self.nswfileCode = ko.observable((item !== null && item.hasOwnProperty('nswfileCode')) ? item.nswfileCode : null);
    self.isActive = ko.observable((item !== null && item.hasOwnProperty('isActive')) ? item.isActive : null);
    self.linkFile = ko.observable((item !== null && item.hasOwnProperty('linkFile')) ? item.linkFile : null);
    self.registrationId = ko.observable((item !== null && item.hasOwnProperty('registrationId')) ? item.registrationId : null);
    if (DINHKEMDATA != null) {
        var len = DINHKEMDATA.length;
        for (var i = 0; i <= len - 1; i++) {
            if (item.fileTypeCode == DINHKEMDATA[i].fileTypeCode) {
                self.isRequired(DINHKEMDATA[i].isRequire);
                break;
            }
        }
    }
    self.isRequired = ko.computed(function () {
        return (self.isRequired() == 1);
    }, this);

    self.canUpload = ko.computed(function () {
        return (self.fileName() === null);
    }, this);

    self.canDownload = ko.computed(function () {
        return self.fileName() !== null;
    }, this);

    self.canDelete = ko.computed(function () {
        return self.fileName() !== null;
    }, this);

    self.downloadUrl = ko.computed(function () {
        if (self.fileName()) {
            if (self.registrationId() === null) {
                return app.appContext + '/most/05/file/most/05/';
            } else {
                return app.appContext + '/most/05/download/';
            }
        }
        return null;
    }, this);




    function postFile(files, token) {
        var fd = new FormData();
        fd.append("file", files[0]);
        fd.append("token", token);
        fd.append("documentType", "BNNPTNT0300004");
        fd.append("fileCode", self.fileTypeCode());
        fd.append("fileName", self.fileTypeName());

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

        var fileName = files[0].name;

        $.ajax({
            type: 'POST',
            url: BNNPTNT.URL_UPLOAD_FILE,
            data: fd,
            dataType: 'multipart/form-data',
            contentType: false,
            processData: false,
            complete: function (e, x, s) {
                $('#loading10').hide();
                var data = JSON.parse(e.responseText);
                debugger;
                if (data.data) {
                    self.fileId(data.data.ItemId);
                    self.fileName(fileName);
                    self.linkFile(data.data.UrlFile);
                } else {
                    app.Alert('Lỗi Service: Không thể upload được file đính kèm');
                    return;
                }
                if (self.isRequired()) {
                    $("#dinhkem_valid").hide();
                }
            },
            error: function (j, t, e) {
                $('#loading10').hide();
                return;
            }
        });

    }

    self.doUpload = function (item, e) {


        $('#loading10').show();
        var files = e.target.files;
        if (!files || files.length <= 0) {
            return;
        }
        if (!Util.validateFieExtensionWithoutDom(files)) {
            $('#loading10').hide();
            //no remove this line
            e.target.value = '';
            return;
        }

        $.getJSON(BNNPTNT.URL_GET_TOKEN).done(function (data) {
            postFile(files, data.data);
        });

    };


    self.doDelete = function () {
        self.attachmentId(null);
        self.fileName(null);
        self.linkFile(null);
        self.registrationId(null);
        return;
    };

}
function mapFiles02VM(data, maHoSo) {
    return ko.utils.arrayMap(data, function (item, index) {
        return new FileVM(item, maHoSo);
    });
}



