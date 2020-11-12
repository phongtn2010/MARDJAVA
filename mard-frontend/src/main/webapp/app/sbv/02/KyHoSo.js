function KyHoSoVM(data) {
    var kyHoSoVMSelf = this;
    kyHoSoVMSelf.fiSoDonDeNghi = ko.observable((data && data.hasOwnProperty('fiSoDonDeNghi')) ? data.fiSoDonDeNghi : null)
        .extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    kyHoSoVMSelf.fiNguoiKyHS = ko.observable((data && data.hasOwnProperty('fiNguoiKy')) ? data.fiNguoiKy : null)
        .extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    kyHoSoVMSelf.fiNoiKy = ko.observable((data && data.hasOwnProperty('fiNoiKy')) ? data.fiNoiKy : null)
        .extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    kyHoSoVMSelf.fiNgayKyHS = ko.observable((data && data.hasOwnProperty('fiNgayKy')) ? data.fiNgayKy : null)
        .extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });

    kyHoSoVMSelf.fiChucVuKy = ko.observable((data && data.hasOwnProperty('fiChucVuKy')) ? new Date(data.fiChucVuKy) : null);

}