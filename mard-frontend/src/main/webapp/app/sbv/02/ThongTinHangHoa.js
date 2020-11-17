function ThongTinHangHoaVM(data) {
    var tthhVMSelf = this;
    tthhVMSelf.productVM = ko.observable(new ProductVM(data));
    tthhVMSelf.fiIdCuaKhau = ko.observable((data && data.hasOwnProperty('fiIdCuaKhau')) ? data.fiIdCuaKhau : null);
    tthhVMSelf.fiThoiGianXNK = ko.observable((data && data.hasOwnProperty('fiIdCuaKhau')) ? data.fiThoiGianXNK : null);
    tthhVMSelf.fiSoGiayDaCap = ko.observable((data && data.hasOwnProperty('fiSoGiayDaCap')) ? data.fiSoGiayDaCap : null);
    tthhVMSelf.fiCapLanDau = ko.observable((data && data.hasOwnProperty('fiCapLanDau')) ? data.fiCapLanDau : null);
    tthhVMSelf.lstCuaKhau  = ko.observableArray((data && data.hasOwnProperty('lstCuaKhau')) ? data.lstCuaKhau :[]);

}