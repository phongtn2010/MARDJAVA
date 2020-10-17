var TOKEN_URL = 'https://mcupload.mard.gov.vn/UploadFile/FileAttachments/GetToken';
var UPLOAD_URL = 'https://mcupload.mard.gov.vn/UploadFile/FileAttachments/Upload';

var SuaGCNVM = function (title, cert, callback) {
    var self = this;

    self.title = ko.observable(title);
    self.lstAtch = ko.observableArray([]);
    self.fiReason = ko.observable(null).extend({
        required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
    });

    self.onAddFile = function () {
        self.lstAtch.push(new AttachSuaGCNVM())
    };

    self.onDelete = function (index) {
        self.lstAtch.splice(index, 1)
    };

    self.fileChange = function (fileVM, file) {
        if (file) {
            $('#loading10').show();
            var fiTenLoai = "Tệp đính kèm xin sửa GCN";
            var fiMaLoai = "99";
            var fiFileName = file.name;

            // var formData = new FormData();
            // formData.append('file', file);
            // formData.append('fiTenLoai', fiTenLoai);
            // formData.append('fiMaLoai', fiMaLoai);
            //
            // $.ajax({
            //     type: 'POST',
            //     cache: false,
            //     crossDomain: true,
            //     url: app.appContext + '/mard/09/dinhkem/create',
            //     data: formData,
            //     processData: false,
            //     contentType: false,
            //     beforeSend: function (xhr) {
            //         xhr.setRequestHeader(CSRF_TOKEN_NAME, CSRF_TOKEN_VALUE);
            //     },
            //     success: function (res) {
            //         $('#loading10').hide();
            //         if (res.success == true) {
            //             fileVM.fiDuongDan(res.data.UrlFile);
            //         } else {
            //             alert(res.message)
            //         }
            //     },
            //     error: function (x, t, m) {
            //         $('#loading10').hide();
            //     },
            //     complete: function (jqXHR, textStatus) {
            //     }
            // });

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
                        formData.append('file', file);

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
                                    fileVM.fiDuongDan(res.data.UrlFile);
                                    fileVM.fiGuid(res.data.ItemId);
                                } else {
                                    alert(res.message);
                                }
                            },
                            error: function (x, t, m) {
                                $('#loading10').hide();
                            },
                            complete: function (jqXHR, textStatus) {
                            }
                        })
                    } else {
                        alert(res.message)
                    }
                },
                error: function (x, t, m) {
                    $('#loading10').hide();
                },
                complete: function (jqXHR, textStatus) {
                }
            });
        }
    };

    self.onSend = function () {
        var fiIDCv = "";
        var fiCertType = "";
        var certTypeNo = cert.fiCerTypeNo();

        if ([1,2].includes(certTypeNo)) {
            fiIDCv = cert.fiIdTransportCer();
            fiCertType = "gvc";
        } else if ([3,4].includes(certTypeNo)) {
            fiIDCv = cert.fiIdQuarantineCer();
            fiCertType = "cnkd";
        } else {
            fiIDCv = cert.fiIdQualityCer();
            fiCertType = "xncl";
        }


        var data = ko.toJS(self);
        if (!data.fiReason || data.fiReason.length == 0) {
            app.Alert("Vui lòng nhập lý do xin sửa");
            return
        }
        var dataToAdd = {
            fiReason: data.fiReason,
            lstAtch: data.lstAtch,
            fiNSWFileCode: cert.fiNSWFileCode(),
            fiCertificateNo: cert.fiCertificateNo(),
            fiIdCv: fiIDCv,
            fiTypeCert: fiCertType
        };

        app.makePost({
            url: '/mard/09/xinsuagcn',
            data: JSON.stringify(dataToAdd),
            success: function (res) {
                // $("#modal_dsGiayphep").modal('hidden');
                if (res.success) {
                    callback(res.success);
                    $("#modal_req_edit_cert").modal('toggle');
                    self.fiReason(null);
                    self.lstAtch([]);
                    // alert("Xin sửa giấy chứng nhận thành công")
                } else {
                    alert(res.message)
                }

            },
            error: function (res) {
                $("#modal_req_edit_cert").modal('toggle');
                alert("Có lỗi xảy ra, vui lòng thử lại sau")
            }
        })

    };

    return self;
};

var AttachSuaGCNVM = function () {
    var selfAt = this;

    selfAt.fiMaLoai =  ko.observable(-1);

    selfAt.fiTenLoai = ko.observable("Tệp đính kèm xin sửa GCN");

    selfAt.fiTenTep = ko.observable(null);

    selfAt.fiDuongDan = ko.observable(null);

    selfAt.fiGuid = ko.observable(null);

};
