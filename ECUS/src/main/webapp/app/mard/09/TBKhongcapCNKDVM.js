function TBKhongcapCNKDVM() {
    var self = this;

    self.fiAttachmentList = ko.observableArray([])
    self.fiCreatorName = ko.observable(null);
    self.fiDepartment = ko.observable(null);
    self.fiReason = ko.observable(null);
    self.fiRequestDate = ko.observable(null);
    self.fiDescription = ko.observable(null);
    self.fiNSWFileCode = ko.observable(null);
    self.fiQualityResult = ko.observable(null);

    var hs = null;

    self.showThongbao = function (hoso) {
        $("#loading10").show();
        hs = hoso;
        app.makeGet({
            url: '/mard/09/giayphep/view' + '?type=' + 'cnkdkd' + '&code=' + hoso.fiHSCode(),
            success: function (res) {
                if (res.success) {

                    $("#modal_xemThongbaoKhongcapCNKD").modal('toggle');
                    $("#loading10").hide();
                    self.fiAttachmentList(res.data[0].fiAttachmentList);
                    self.fiCreatorName(res.data[0].fiCreaterName ? res.data[0].fiCreaterName : "Nguyễn Văn A");
                    self.fiDepartment(res.data[0].fiDepartment ? res.data[0].fiDepartment : "Chi cục thú y vùng I");
                    self.fiQualityResult(res.data[0].fiQualityResult);
                    self.fiReason(res.data[0].fiReason);
                    self.fiRequestDate(new Date(res.data[0].fiRequestDate));
                    self.fiDescription(res.data[0].fiDescription);
                    self.fiNSWFileCode(res.data[0].fiNSWFileCode);
                }
            },
            error: function (e) {
                $("#loading10").hide();
            }
        });
    };

    return self;
}
