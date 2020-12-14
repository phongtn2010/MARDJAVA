function ViewVM (options) {
    var viewVMSelf = this;
    viewVMSelf.fiHSType = ko.observable(options.fiHSType);
    if (options.fiHSType < 4) {
        viewVMSelf.kdnkVM = ko.observable(new KiemDichNhapKhauVM(options));
        viewVMSelf.ktclVM = ko.observable(null);
    } else if (options.fiHSType == 4) {
        viewVMSelf.ktclVM = ko.observable(new KiemTraChatLuongVM(options));
        viewVMSelf.kdnkVM = ko.observable(null);
    }
}