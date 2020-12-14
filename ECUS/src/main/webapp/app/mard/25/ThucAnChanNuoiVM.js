function ThucAnChanNuoiVM(data) {
    var tacnVMSeft = this;

    tacnVMSeft.lstCountry = ko.observableArray((data && data.hasOwnProperty('lstCountry')) ? data.lstCountry : null);
    tacnVMSeft.lstPhanNhom = ko.observableArray((data && data.hasOwnProperty('lstPhanNhom')) ? data.lstPhanNhom : null);
    tacnVMSeft.lstLoai = ko.observableArray((data && data.hasOwnProperty('lstLoai')) ? data.lstPhanNhom : null);
    tacnVMSeft.lstNhom = ko.observableArray((data && data.hasOwnProperty('lstNhom')) ? data.lstPhanNhom : null);
    tacnVMSeft.lstPhanLoai = ko.observableArray((data && data.hasOwnProperty('lstPhanLoai')) ? data.lstPhanNhom : null);
    tacnVMSeft.fiProMadeIn = ko.observableArray((data && data.hasOwnProperty('fiProMadeIn')) ? data.lstPhanNhom : null);
    tacnVMSeft.fiProThanhPhan = ko.observableArray((data && data.hasOwnProperty('fiProThanhPhan')) ? data.lstPhanNhom : null);
    tacnVMSeft.fiProColor = ko.observableArray((data && data.hasOwnProperty('fiProColor')) ? data.lstPhanNhom : null);
    tacnVMSeft.fiProSoHieu = ko.observableArray((data && data.hasOwnProperty('fiProSoHieu')) ? data.lstPhanNhom : null);
    tacnVMSeft.fiProName =ko.observable((data && data.hasOwnProperty('fiProName')) ? data.fiSellName : null);

}