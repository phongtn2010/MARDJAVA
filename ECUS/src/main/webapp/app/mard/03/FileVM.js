/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function FileVM(item, idHoso) {
    var self = this;
    self.fiFileId = ko.observable((item !== null && item.hasOwnProperty('fiFileId')) ? item.fiFileId : null);
    self.id = ko.observable((item !== null && item.hasOwnProperty('id')) ? item.id : null);
    self.fileCode = ko.observable((item !== null && item.hasOwnProperty('fileCode')) ? item.fileCode : null);
    self.fileNameUpload = ko.observable((item !== null && item.hasOwnProperty('fileNameUpload')) ? item.fileNameUpload : null);
    self.isActive = ko.observable((item !== null && item.hasOwnProperty('isActive')) ? item.isActive : null);
    self.isRequired = ko.observable((item !== null && item.hasOwnProperty('isRequired')) ? item.isRequired : null);
    self.fiIdHoSo = ko.observable((item !== null && item.hasOwnProperty('fiIdHoSo')) ? item.fiIdHoSo : null);
    self.linkfile = ko.observable((item !== null && item.hasOwnProperty('linkfile')) ? item.linkfile : null);
    self.fileName = ko.observable((item !== null && item.hasOwnProperty('fileName')) ? item.fileName : null);

    self.isRequire = ko.computed(function () {
        return (self.isRequired() == 1);
    }, this);

    self.canUpload = ko.computed(function () {
        return (self.fileNameUpload() === null);
    }, this);

    self.canDownload = ko.computed(function () {
        return self.fileNameUpload() !== null;
    }, this);

    self.canDelete = ko.computed(function () {
        return self.fileNameUpload() !== null;
    }, this);


    function postFile(files, token) {
        var fd = new FormData();
        fd.append("file", files[0]);
        fd.append("token", token);
        fd.append("documentType", "BNNPTNT0300004");
        fd.append("fileCode", self.fileCode());
        fd.append("fileName", self.fileName());

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
                if (data.data) {
                    self.id(data.data.ItemId);
                    self.fileNameUpload(fileName);
                    self.linkfile(data.data.UrlFile);
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

        $.getJSON(BNNPTNT.URL_GET_TOKEN).done(function( data ) {
            postFile(files, data.data);
        });

    };


    self.doDelete = function () {
        self.attachmentId(null);
        self.attachmentName(null);
        self.linkfile(null);
        self.registrationProfileId(null);
        return ;
    };

}
function mapFiles03VM(data, maHoSo) {
    return ko.utils.arrayMap(data, function (item, index) {
        return new FileVM(item, maHoSo);
    });
}



