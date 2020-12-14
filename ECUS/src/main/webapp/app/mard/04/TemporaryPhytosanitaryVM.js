function TemporaryPhytosanitaryVM(options) {
    var self = this;
    var temporaryPhytosanitary = options.temporaryPhytosanitary;

    self.fiMaLoaiKiemtra = options.fiMaLoaiKiemtra;

    self.temporaryPhytosanitaryId = ko.observable(temporaryPhytosanitary ? temporaryPhytosanitary.temporaryPhytosanitaryId : null);
    self.nswFilecode = ko.observable(temporaryPhytosanitary ? temporaryPhytosanitary.nswFilecode : null);
    self.importer = ko.observable(temporaryPhytosanitary ? temporaryPhytosanitary.importer : null);
    self.importerPhone = ko.observable(temporaryPhytosanitary ? temporaryPhytosanitary.importerPhone : null);
    self.importerAddress = ko.observable(temporaryPhytosanitary ? temporaryPhytosanitary.importerAddress : null);
    self.departmentName = ko.observable(temporaryPhytosanitary ? temporaryPhytosanitary.departmentName : null);
    self.locationOfStorage = ko.observable(temporaryPhytosanitary ? temporaryPhytosanitary.locationOfStorage : null);
    self.inspectionDate = ko.observable(temporaryPhytosanitary ? new Date(temporaryPhytosanitary.inspectionDate) : null);
    self.quarantineResults = ko.observable(temporaryPhytosanitary ? temporaryPhytosanitary.quarantineResults : null);
    self.effectiveDateFrom = ko.observable(temporaryPhytosanitary ? new Date(temporaryPhytosanitary.effectiveDateFrom) : null);
    self.effectiveDateTo = ko.observable(temporaryPhytosanitary ? new Date(temporaryPhytosanitary.effectiveDateTo) : null);

    self.dispatchNo = ko.observable(temporaryPhytosanitary ? temporaryPhytosanitary.dispatchNo : null);
    self.signConfirmDate = ko.observable(temporaryPhytosanitary ? new Date(temporaryPhytosanitary.signConfirmDate) : null);
    self.signConfirmName = ko.observable(temporaryPhytosanitary ? temporaryPhytosanitary.signConfirmName : null);
    self.signConfirmAddress = ko.observable(temporaryPhytosanitary ? temporaryPhytosanitary.signConfirmAddress : null);
    self.linkFile = ko.observable(temporaryPhytosanitary ? temporaryPhytosanitary.linkFile : null);

    self.totalQuantity = ko.observable(temporaryPhytosanitary ? temporaryPhytosanitary.totalQuantity : null);
    self.totalQuantityByChar = ko.observable(temporaryPhytosanitary ? temporaryPhytosanitary.totalQuantityByChar : null);
    self.totalGrossWeight = ko.observable(temporaryPhytosanitary ? temporaryPhytosanitary.totalGrossWeight : null);
    self.totalGrossWeightByChar = ko.observable(temporaryPhytosanitary ? temporaryPhytosanitary.totalGrossWeightByChar : null);
    self.departmentLisenceName = ko.observable(temporaryPhytosanitary ? temporaryPhytosanitary.departmentLisenceName : null);
    self.departmentSuperiorName = ko.observable(temporaryPhytosanitary ? temporaryPhytosanitary.departmentSuperiorName : null);
    self.undiscovered = ko.observable(temporaryPhytosanitary ? temporaryPhytosanitary.undiscovered : null);
    self.undiscoveredContent = ko.observable(temporaryPhytosanitary ? temporaryPhytosanitary.undiscoveredContent : null);
    self.checkOutside = ko.observable(temporaryPhytosanitary ? temporaryPhytosanitary.checkOutside : null);
    self.checkOutsideContent = ko.observable(temporaryPhytosanitary ? temporaryPhytosanitary.checkOutsideContent : null);
    self.notifyDepartmentCode = ko.observable(temporaryPhytosanitary ? temporaryPhytosanitary.notifyDepartmentCode : null);
    self.notifyDepartmentName = ko.observable(temporaryPhytosanitary ? temporaryPhytosanitary.notifyDepartmentName : null);


    self.isActive = ko.observable(null);
    self.createDate = ko.observable(null);
    self.lstHangHoa = ko.observable(temporaryPhytosanitary.hangHoa);
    self.signResultDateStr = ko.observable(null);
    self.signResultDate = ko.observable(null);
    if (temporaryPhytosanitary) {
        self.signResultDate(temporaryPhytosanitary ? new Date(temporaryPhytosanitary.signResultDate) : null);
        var dt = self.signResultDate();
        var d = (dt.getDate() >= 10) ? dt.getDate() : "0" + dt.getDate();
        var m = (dt.getMonth() >= 9) ? dt.getMonth() + 1 : "0" + (dt.getMonth() + 1);
        var y = dt.getFullYear();
        var strViewHtml = "ngày <b>" + d + "</b> tháng <b>" + m + "</b> năm <b>" + y + "</b>";
        self.signResultDateStr(strViewHtml);
    }

    self.ngayKyStr = ko.observable(null);
    var nk = self.signConfirmDate();
    var d1 = (nk.getDate() >= 10) ? nk.getDate() : "0" + nk.getDate();
    var m1 = (nk.getMonth() >= 10) ? nk.getMonth() : "0" + nk.getMonth();
    var y1 = nk.getFullYear();
    var strSignDateHtml = "Ngày <b>" + d1 + "</b> tháng <b>" + m1 + "</b> năm <b>" + y1 + "</b>";
    self.ngayKyStr(strSignDateHtml);

    /**
     * button tro lai
     *
     */
    self.btnTroLaiClick = function () {
        History.go(-1);
    };

}

$(document).ready(function () {
    var options = app.parseQuerystring();
    var init = function () {
        debugger
        if (options && options.fiMaHoso !== null) {
            var url = '/mard/p04/hoso/giayTamCap/' + options.fiMaHoso;
            app.makePost({
                url: url,
                data: JSON.stringify({}),
                success: function (d) {
                    var msg = '';
                    if (d.success) {
                        options.temporaryPhytosanitary = d.data;
                        var vm = new TemporaryPhytosanitaryVM(options);
                        ko.applyBindings(vm, document.getElementById('TemporaryPhytosanitaryVM'));
                    } else {
                        msg = d.data.message ? d.data.message : 'Gửi yêu cầu thất bại, vui lòng thử lại!';
                        app.Alert(msg);
                    }
                },
                error: function (e) {
                    app.toast({
                        title: NSWLang["common_msg_thong_bao"],
                        message: NSWLang["common_msg_he_thong_chua_san_sang"],
                        function: 'success'
                    });
                }
            });
        }
    };
    init();
});