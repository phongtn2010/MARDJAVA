var ThongBaoKhongdatYCXK = function () {
    var self = this;

    self.fiNSWFileCode = ko.observable(null);
    self.fiCreaterName = ko.observable(null);
    self.fiDispatchContent = ko.observable(null);
    self.fiFileName = ko.observable(null);
    self.fileAvailable = ko.observable(null);
    self.downloadLink = ko.observable(null);
    self.fiDispatchFile = "";

    self.showTB = function (fiNSWFileCode) {
        $("#loading01").show();
        app.makeGet({
            url: app.appContext + '/mard/01/giayphep/thongbao-khongdat?fiNSWFileCode=' + fiNSWFileCode,
            success: function (d) {
                $("#loading01").hide();
                $("#modal_xem_tb_khongdat_ycxk").modal('toggle');
                self.fiNSWFileCode(fiNSWFileCode);
                self.fiCreaterName(d.data.fiCreaterName);
                self.fiDispatchContent(d.data.fiDispatchContent);
                self.fiDispatchFile = d.data.fiDispatchFile;
                if (d.data.fiLinkFile || d.data.fiAttachmentID) {
                    if (d.data.fiLinkFile) {
                        self.downloadLink(d.data.fiLinkFile)
                    } else {
                        self.downloadLink(app.appContext + "/mard/01/dinhkem/download/" + d.data.fiAttachmentID)
                    }
                    self.fileAvailable(true)
                } else {
                    self.fileAvailable(false)
                }
            },
            error: function (e) {
                $("#loading01").hide();
                app.Alert('Có lỗi xảy ra, vui lòng thử lại sau');
            }
        });
    };

};