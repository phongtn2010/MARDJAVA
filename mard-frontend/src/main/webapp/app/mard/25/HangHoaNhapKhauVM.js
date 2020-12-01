function RegAnimalVM(options) {
    var regAnimalVMSelf = this;
    regAnimalVMSelf.productVM = ko.observable(new ProductVM(options, ['fiProductBusinessName', 'fiProductScienceName', 'fiSizeOrType',  'fiQuantity', 'fiPackageUnitCode', 'fiOriginCountryCode']));
    regAnimalVMSelf.exporterVM = ko.observable(new ExporterVM(options, ['fiExporterCountryName', 'fiExporterCountryAddress']));
    regAnimalVMSelf.productMfrVM = ko.observable(new ProdMfrVM(options, ['fiProcessingName', 'fiProcessingAddress']));
    regAnimalVMSelf.isoLocationVM = ko.observable(new IsoLocationVM(options, ['fiLocationQuarantineName', 'fiLocationQuarantineAddress']));

    regAnimalVMSelf.lstPurpose = ko.observableArray([
        "Kinh doanh thực phẩm",
        "Làm giống nuôi thương phẩm",
        "Làm giống bố mẹ",
        "Làm thủ công mĩ nghệ",
        "Làm cảnh",
        "Chế biến thực phẩm",
        "Khác"
    ])
    regAnimalVMSelf.fiTimeQuarantine = ko.observable(null)
        .extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    regAnimalVMSelf.fiBordergateName = ko.observable(null)
        .extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    regAnimalVMSelf.fiPurpose = ko.observable(null)
        .extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    regAnimalVMSelf.fiRelatedDocuments = ko.observable(null);

    regAnimalVMSelf.applyState = function (data) {
        if (data.fiProductList) {
            regAnimalVMSelf.productVM().fiProductList(data.fiProductList);
        }
        if (data.fiExporterCountryList) {
            regAnimalVMSelf.exporterVM().fiExporterCountryList(data.fiExporterCountryList);
        }
        if (data.fiProcessingList) {
            regAnimalVMSelf.productMfrVM().fiProcessingList(data.fiProcessingList);
        }
        if (data.fiLocationQuarantineList) {
            regAnimalVMSelf.isoLocationVM().fiLocationQuarantineList(data.fiLocationQuarantineList);
        }

        regAnimalVMSelf.fiTimeQuarantine((data && data.hasOwnProperty('fiTimeQuarantine')) ? data.fiTimeQuarantine : null);
        regAnimalVMSelf.fiBordergateName((data && data.hasOwnProperty('fiBordergateName')) ? data.fiBordergateName : null);
        regAnimalVMSelf.fiPurpose((data && data.hasOwnProperty('fiPurpose')) ? data.fiPurpose : null);
        regAnimalVMSelf.fiRelatedDocuments((data && data.hasOwnProperty('fiRelatedDocuments')) ? data.fiRelatedDocuments : null);
    }

    regAnimalVMSelf.validateObject = function () {
        return {
            fiTimeQuarantine: regAnimalVMSelf.fiTimeQuarantine,
            fiBordergateName: regAnimalVMSelf.fiBordergateName,
            fiPurpose: regAnimalVMSelf.fiPurpose,
            fiProductList: regAnimalVMSelf.productVM().fiProductList,
            fiExporterCountryList: regAnimalVMSelf.exporterVM().fiExporterCountryList,
            fiProcessingList: regAnimalVMSelf.productMfrVM().fiProcessingList,
            fiLocationQuarantineList: regAnimalVMSelf.isoLocationVM().fiLocationQuarantineList
        }
    }
}

function RegAnimalProductVM(options) {
    var regAnimalProdVMSelf = this;
    regAnimalProdVMSelf.productVM = ko.observable(new ProductVM(options, ['fiProductBusinessName', 'fiSizeOrType',  'fiQuantity', 'fiPackageUnitCode', 'fiOriginCountryCode']));
    regAnimalProdVMSelf.exporterVM = ko.observable(new ExporterVM(options, ['fiExporterCountryName', 'fiExporterCountryAddress']));
    regAnimalProdVMSelf.productMfrVM = ko.observable(new ProdMfrVM(options, ['fiProcessingName', 'fiProcessingAddress']));

    regAnimalProdVMSelf.lstPurpose = ko.observableArray([
        "Kinh doanh thực phẩm",
        "Làm giống nuôi thương phẩm",
        "Làm giống bố mẹ",
        "Làm thủ công mĩ nghệ",
        "Làm cảnh",
        "Chế biến thực phẩm",
        "Khác"
    ])

    regAnimalProdVMSelf.fiTimeQuarantine = ko.observable(null)
        .extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    regAnimalProdVMSelf.fiBordergateName = ko.observable(null)
        .extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    regAnimalProdVMSelf.fiPurpose = ko.observable()
        .extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    regAnimalProdVMSelf.fiPurpose.subscribe(function (item) {
        if (item && item == 'Kinh doanh thực phẩm') {
            regAnimalProdVMSelf.productMfrVM().isRequireApprovalNumber(true);
        } else {
            regAnimalProdVMSelf.productMfrVM().isRequireApprovalNumber(false);
        }
    })
    regAnimalProdVMSelf.fiRelatedDocuments = ko.observable(null);

    regAnimalProdVMSelf.applyState = function(data) {
        if (data.fiProductList) {
            regAnimalProdVMSelf.productVM().fiProductList(data.fiProductList);
        }
        if (data.fiExporterCountryList) {
            regAnimalProdVMSelf.exporterVM().fiExporterCountryList(data.fiExporterCountryList);
        }
        if (data.fiProcessingList) {
            regAnimalProdVMSelf.productMfrVM().fiProcessingList(data.fiProcessingList);
        }

        regAnimalProdVMSelf.fiTimeQuarantine((data && data.hasOwnProperty('fiTimeQuarantine')) ? data.fiTimeQuarantine : null);
        regAnimalProdVMSelf.fiBordergateName((data && data.hasOwnProperty('fiBordergateName')) ? data.fiBordergateName : null);
        regAnimalProdVMSelf.fiPurpose((data && data.hasOwnProperty('fiPurpose')) ? data.fiPurpose : null);
        regAnimalProdVMSelf.fiRelatedDocuments((data && data.hasOwnProperty('fiRelatedDocuments')) ? data.fiRelatedDocuments : null)
    }

    regAnimalProdVMSelf.validateObject = function () {
        return {
            fiTimeQuarantine: regAnimalProdVMSelf.fiTimeQuarantine,
            fiBordergateName: regAnimalProdVMSelf.fiBordergateName,
            fiPurpose: regAnimalProdVMSelf.fiPurpose,
            fiProductList: regAnimalProdVMSelf.productVM().fiProductList,
            fiExporterCountryList: regAnimalProdVMSelf.exporterVM().fiExporterCountryList,
            fiProcessingList: regAnimalProdVMSelf.productMfrVM().fiProcessingList,
        }
    }
}

function HangHoaNhapKhauVM (options) {
    var kdnkVMSelf = this;

    kdnkVMSelf.fiHSStatus = ko.observable((options && options.hasOwnProperty('fiHSStatus')) ? options.fiHSStatus : null);
    kdnkVMSelf.fiIdHS = ko.observable((options && options.hasOwnProperty('fiIdHS')) ? options.fiIdHS : null);
    kdnkVMSelf.fiNSWFileCode = ko.observable((options && options.hasOwnProperty('fiNSWFileCode')) ? options.fiNSWFileCode : null);
    kdnkVMSelf.fiReason = ko.observable((options && options.hasOwnProperty('fiReason')) ? options.fiReason : null);
    if (options.isRequestEdit) {
        kdnkVMSelf.fiReason.extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
        })
    }
    kdnkVMSelf.thongtinChungVM = ko.observable(new ThongTinChungVM(options));
    kdnkVMSelf.kyHoSoVM = ko.observable(new KyHoSoVM(options));
    kdnkVMSelf.lstProfileStatus = ko.observableArray((options && options.hasOwnProperty('lstProfileStatus')) ? options.lstProfileStatus : []);
    kdnkVMSelf.lstNhom = ko.observableArray((options && options.hasOwnProperty('lstNhom')) ? options.lstNhom : []);
    kdnkVMSelf.regAnimalVM = ko.observable(new RegAnimalVM(options));
    kdnkVMSelf.regAnimalProductVM = ko.observable(new RegAnimalProductVM(options));

    kdnkVMSelf.fiProductList = ko.observableArray((options && options.hasOwnProperty('fiProductList')) ? options.fiProductList : null);


    // kdnkVMSelf.uploadFileVM = ko.observable(new UploadFileVM(options.fiAttachmentList ? options.fiAttachmentList: [], options.lstAtchType ? options.lstAtchType : []));
    kdnkVMSelf.uploadFileVM = ko.observable(new UploadFileVM(options));

    kdnkVMSelf.errorMsg = ko.observable(null);

    kdnkVMSelf.getProfileStatus = function (statuscode) {
        var lstProfileStatus = kdnkVMSelf.lstProfileStatus();
        var pos = lstProfileStatus.find(function (e) {
            return e.fiCatType == Number(statuscode);
        })
        if (pos)
            return pos.fiCatTypeName;
        else return statuscode;
    }

    kdnkVMSelf.validateForm = function () {
        var ttc=kdnkVMSelf.thongtinChungVM();
        var benBan = [ttc.fiSellName,ttc.fiSellAddress,ttc.fiSellCountryCode,ttc.fiSellExport];
        var benMua = [ttc.fiImporterName,ttc.fiImporterAddress,ttc.fiPurchReci,ttc.fiImporterTel,ttc.fiPurchFromDate];
        var diaDiemTapKet = [ttc.fiAddressGath,ttc.fiRegSamFromDate,ttc.fiAddressRegSample,ttc.fiProductList];
        var thongTinLienHe = [ttc.fiContactName,ttc.fiContactAddress];
        var thongTinKy = [ttc.fiSignName,ttc.fiSignAddress,ttc.fiSignPosition];
        if(ttc.fiNSWFileCodeReplace()!=null){
            if (ttc.fiFileNameGDK()==null){
                app.Alert("Bạn chưa đính kèm file GDK");
                return false;
            }
        }
        kdnkVMSelf.errors = ko.validation.group({benBan,benMua,thongTinKy,thongTinLienHe,diaDiemTapKet}, {deep: true, live: true, observable: true});
        // kdnkVMSelf.errors = ko.validation.group(kdnkVMSelf.thongtinChungVM, {deep: true, live: true, observable: true});
        if (kdnkVMSelf.errors().length > 0) {
            kdnkVMSelf.errors.showAllMessages();
            return false;
        }
        return true;
    }
    kdnkVMSelf.validateUploadFiles = function () {
        var ttc=kdnkVMSelf.uploadFileVM();
        var checkFiles= [ttc.lstHD,ttc.lstHoaDon,ttc.lstPhieu,ttc.lstKQ,ttc.lstTC,ttc.lstCNLH,ttc.lstCNPT,ttc.lstAtch];
        kdnkVMSelf.errors = ko.validation.group({checkFiles}, {deep: true, live: true, observable: true});
        if (kdnkVMSelf.errors().length > 0) {
            kdnkVMSelf.errors.showAllMessages();
            return false;
        }
        return true;
    }

    kdnkVMSelf.validateAttachment = function () {
        var uploadFileVM=kdnkVMSelf.uploadFileVM();
        if(uploadFileVM.lstHD().length<1){
            app.Alert("Chưa đính kèm file thông tin hợp đồng");
            return false;
        }
        if(uploadFileVM.lstHoaDon().length<1){
            app.Alert("Chưa đính kèm file thông tin hóa đơn");
            return false;
        }
        if(uploadFileVM.lstPhieu().length<1){
            app.Alert("Chưa đính kèm file thông tin phiếu đóng gói");
            return false;
        }
        if(uploadFileVM.lstKQ().length<1){
            app.Alert("Chưa đính kèm file Phiếu kết quả phân tích chất lượng của nước xuất khẩu cấp cho lô hàng");
            return false;
        }
        if(uploadFileVM.lstTC().length<1){
            app.Alert("Chưa đính kèm file Bản tiêu chuẩn công bố áp dụng của tổ chức, cá nhân nhập khẩu");
            return false;
        }
        var checkGroupFood=false;
        ko.utils.arrayForEach(kdnkVMSelf.thongtinChungVM().fiProductList(),function (product) {
            if (product.fiProIdNhom()==1||product.fiProIdNhom()==4){
                checkGroupFood=true;
            }
        });
        if(checkGroupFood){
            if(uploadFileVM.lstCNLH().length<1){
                app.Alert("Chưa đính kèm file Giấy chứng nhận lưu hành tự do (đối với nguyên liệu đơn, thức ăn truyền thống)");
                return false;
            }
        }
        ko.utils.arrayForEach(kdnkVMSelf.thongtinChungVM().fiProductList(),function (product) {
            if (product.fiProIdNhom()==1){
                checkGroupFood=true;
            }
        });
        if(checkGroupFood){
            if(uploadFileVM.lstCNPT().length<1){
                app.Alert("Chưa đính kèm file Giấy chứng nhận phân tích nguy cơ và kiểm soát điểm tới hạn (đối với nguyên liệu đơn)");
                return false;
            }
        }
    }

    kdnkVMSelf.getData = function () {
        var body = {
            "fiIdHS": kdnkVMSelf.fiIdHS(),
            "fiNSWFileCode": kdnkVMSelf.fiNSWFileCode(),
            "fiReason": kdnkVMSelf.fiReason(),
            "fiHSStatus": kdnkVMSelf.fiHSStatus(),
            "fiHSType": kdnkVMSelf.thongtinChungVM().fiHSType(),
            "fiHSCreatedDate": new Date(kdnkVMSelf.thongtinChungVM().fiHSCreatedDate()).getTime(),
            "fiNSWFileCodeReplace": kdnkVMSelf.thongtinChungVM().fiNSWFileCodeReplace(),
            "fiGDK": kdnkVMSelf.thongtinChungVM().fiGDK(),
            // "fiGDKFile": kdnkVMSelf.thongtinChungVM().fiGDKFile(),

            "fiSellName": kdnkVMSelf.thongtinChungVM().fiSellName(),
            "fiSellCountryCode": kdnkVMSelf.thongtinChungVM().fiSellCountryCode(),
            "fiSellCountryName": kdnkVMSelf.thongtinChungVM().fiSellCountryName(),
            "fiSellAddress": kdnkVMSelf.thongtinChungVM().fiSellAddress(),
            "fiSellTel": kdnkVMSelf.thongtinChungVM().fiSellTel(),
            "fiSellFax": kdnkVMSelf.thongtinChungVM().fiSellFax(),
            "fiSellExport": kdnkVMSelf.thongtinChungVM().fiSellExport(),

            // "fiPurchName": kdnkVMSelf.thongtinChungVM().fiPurchName(),
            // "fiPurchTel": kdnkVMSelf.thongtinChungVM().fiPurchTel(),
            // "fiPurchAddress": kdnkVMSelf.thongtinChungVM().fiPurchAddress(),
            // "fiPurchFax": kdnkVMSelf.thongtinChungVM().fiPurchFax(),
            "fiPurchReci": kdnkVMSelf.thongtinChungVM().fiPurchReci(),
            "fiPurchFromDate": new Date(kdnkVMSelf.thongtinChungVM().fiPurchFromDate()).getTime(),
            "fiPurchToDate": new Date(kdnkVMSelf.thongtinChungVM().fiPurchToDate()).getTime(),

            "fiTaxCode": kdnkVMSelf.thongtinChungVM().fiTaxCode(),
            "fiImporterName": kdnkVMSelf.thongtinChungVM().fiImporterName(),
            "fiImporterAddress": kdnkVMSelf.thongtinChungVM().fiImporterAddress(),
            "fiImporterTel": kdnkVMSelf.thongtinChungVM().fiImporterTel(),
            "fiImporterFax": kdnkVMSelf.thongtinChungVM().fiImporterFax(),
            "fiImporterEmail": kdnkVMSelf.thongtinChungVM().fiImporterEmail(),

            "fiProductList": kdnkVMSelf.thongtinChungVM().fiProductList(),

            "fiAddressGath": kdnkVMSelf.thongtinChungVM().fiAddressGath(),
            "fiRegSamFromDate": new Date(kdnkVMSelf.thongtinChungVM().fiRegSamFromDate()).getTime(),
            "fiRegSamToDate": new Date(kdnkVMSelf.thongtinChungVM().fiRegSamToDate()).getTime(),
            "fiAddressRegSample": kdnkVMSelf.thongtinChungVM().fiAddressRegSample(),

            "fiContactName": kdnkVMSelf.thongtinChungVM().fiContactName(),
            "fiContactTel": kdnkVMSelf.thongtinChungVM().fiContactTel(),
            "fiContactAddress": kdnkVMSelf.thongtinChungVM().fiContactAddress(),
            "fiContactEmail": kdnkVMSelf.thongtinChungVM().fiContactEmail(),

            "fiSignName": kdnkVMSelf.thongtinChungVM().fiSignName(),
            "fiSignPosition": kdnkVMSelf.thongtinChungVM().fiSignPosition(),
            "fiSignAddressCode": kdnkVMSelf.thongtinChungVM().fiSignAddressCode(),
            "fiSignAddressName": kdnkVMSelf.thongtinChungVM().fiSignAddressName(),

            "fiProCVMienGiam": kdnkVMSelf.thongtinChungVM().fiProCVMienGiam(),
            "fiProCVMienGiamNgay": kdnkVMSelf.thongtinChungVM().fiProCVMienGiamNgay()?new Date(kdnkVMSelf.thongtinChungVM().fiProCVMienGiamNgay()).getTime():null,

            "fiAttachmentList": kdnkVMSelf.uploadFileVM().fiAttachmentList()
        }
        console.log(body);
        return body;
    }
}
