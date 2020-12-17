function ThongTinChungVM(data) {
    var ttcVMSelf = this;
    ttcVMSelf.fiProIdNhomTemp = ko.observable(null);
    ttcVMSelf.fiProIdPhanNhomTemp = ko.observable(null);
    ttcVMSelf.fiProIdLoaiTemp = ko.observable(null);
    ttcVMSelf.fiProIdPhanLoaiTemp = ko.observable(null);



    ttcVMSelf.fiProNhom2D = ko.observable(null);
    ttcVMSelf.fiProPhanNhom2D = ko.observable(null);
    ttcVMSelf.fiProLoai2D = ko.observable(null);
    ttcVMSelf.fiProPhanLoai2D = ko.observable(null);

    ttcVMSelf.lstDSHosoMK = ko.observableArray((data && data.hasOwnProperty('lstDSHosoMK')) ? data.lstDSHosoMK : []);
    ttcVMSelf.fiIdProduct25 = ko.observable(null);
    ttcVMSelf.fiProNameSelect = ko.observable(null);
    ttcVMSelf.lstChiTieuAT = ko.observableArray((data && data.hasOwnProperty('lstChiTieuAT')) ? data.lstChiTieuAT : []);
    ttcVMSelf.listCL = ko.observableArray((data && data.hasOwnProperty('listCL')) ? data.listCL : []);
    ttcVMSelf.listAT = ko.observableArray((data && data.hasOwnProperty('listAT')) ? data.listAT : []);
    ttcVMSelf.listSLKL = ko.observableArray((data && data.hasOwnProperty('listSLKL')) ? data.listSLKL : []);

    ttcVMSelf.isEditHS = ko.observable((data && data.hasOwnProperty('isEditHS')) ? data.isEditHS : null);
    ttcVMSelf.errors = ko.validation.group(ttcVMSelf);
    ttcVMSelf.isUpdateHangHoa = ko.observable(null);
    ttcVMSelf.selectedIndex = ko.observable(null);
    ttcVMSelf.selectedHangHoa = ko.observable(null);
    ttcVMSelf.lstProfileStatus = ko.observableArray((data && data.hasOwnProperty('lstProfileStatus')) ? data.lstProfileStatus : []);
    ttcVMSelf.fiHSStatus = ko.observable((data && data.hasOwnProperty('fiHSStatus')) ? data.fiHSStatus : null);
    ttcVMSelf.fiTaxCode = ko.observable((data && data.hasOwnProperty('fiTaxCode')) ? data.fiTaxCode : null);
    ttcVMSelf.fiHSCreatedDate = ko.observable((data && data.hasOwnProperty('fiHSCreatedDate')) ? new Date(data.fiHSCreatedDate) : new Date());
    ttcVMSelf.fiHSType = ko.observable((data && data.hasOwnProperty('fiHSType')) ? data.fiHSType : null).extend({
        required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
    });
    ttcVMSelf.fiNSWFileCodeReplace = ko.observable((data && data.hasOwnProperty('fiNSWFileCodeReplace')) ? data.fiNSWFileCodeReplace : null);
    ttcVMSelf.fiGDK = ko.observable((data && data.hasOwnProperty('fiGDK')) ? data.fiGDK : null);
    ttcVMSelf.fiGDKFile = ko.observable((data && data.hasOwnProperty('fiGDKFile')) ? data.fiGDKFile : null);

    ttcVMSelf.fiNSWFileCode = ko.observable((data && data.hasOwnProperty('fiNSWFileCode')) ? data.fiNSWFileCode : null);

    ttcVMSelf.fiTrangThaiHangHoa = ko.observable((data && data.hasOwnProperty('fiTrangThaiHangHoa')) ? data.fiTrangThaiHangHoa : null);

    //inc_thongtindangky.jsp
    ttcVMSelf.fiSellName = ko.observable((data && data.hasOwnProperty('fiSellName')) ? data.fiSellName : null).extend({
        required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
    });
    ttcVMSelf.lstCountry = ko.observableArray((data && data.hasOwnProperty('lstCountry')) ? data.lstCountry : []);
    ttcVMSelf.lstDMDVT = ko.observableArray((data && data.hasOwnProperty('lstDMDVT')) ? data.lstDMDVT : []);
    ttcVMSelf.lstDMDVTSL = ko.observableArray((data && data.hasOwnProperty('lstDMDVTSL')) ? data.lstDMDVTSL : []);
    ttcVMSelf.lstNhom = ko.observableArray((data && data.hasOwnProperty('lstNhom')) ? data.lstNhom : []);
    ttcVMSelf.lstPhanNhom = ko.observableArray([]);
    ttcVMSelf.lstLoai = ko.observableArray([]);
    ttcVMSelf.lstPhanLoai = ko.observableArray([]);
    ttcVMSelf.fiSellCountryCode = ko.observable((data && data.hasOwnProperty('fiSellCountryCode')) ? data.fiSellCountryCode : null).extend({
        required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
    });
    ttcVMSelf.fiSellCountryName = ko.observable((data && data.hasOwnProperty('fiSellCountryName')) ? data.fiSellCountryName : null);

    ttcVMSelf.fiSellAddress = ko.observable((data && data.hasOwnProperty('fiSellAddress')) ? data.fiSellAddress : null).extend({
        required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
    });
    ttcVMSelf.fiSellTel = ko.observable((data && data.hasOwnProperty('fiSellTel')) ? data.fiSellTel : null);
    //     .extend({
    //     // pattern: {
    //     //     params: '^0[1-9][0-9]{8,9}$',
    //     //     message: "Số điện thoại không hợp lệ."
    //     // }
    //     required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
    // });
    ttcVMSelf.fiSellFax = ko.observable((data && data.hasOwnProperty('fiSellFax')) ? data.fiSellFax : null);
    ttcVMSelf.fiSellExport = ko.observable((data && data.hasOwnProperty('fiSellExport')) ? data.fiSellExport : null).extend({
        required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
    });

    // ttcVMSelf.fiPurchName = ko.observable((data && data.hasOwnProperty('fiPurchName')) ? data.fiPurchName : null).
    // extend({
    //     required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
    // });
    // ttcVMSelf.fiPurchTel = ko.observable((data && data.hasOwnProperty('fiPurchTel')) ? data.fiPurchTel : null).extend({
    //     pattern: {
    //         params: '^0[1-9][0-9]{8,9}$',
    //         message: "Số điện thoại không hợp lệ."
    //     }
    // });
    // ttcVMSelf.fiPurchAddress = ko.observable((data && data.hasOwnProperty('fiPurchAddress')) ? data.fiPurchAddress : null).
    // extend({
    //     required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
    // });
    ttcVMSelf.fiPurchFax = ko.observable((data && data.hasOwnProperty('fiPurchFax')) ? data.fiPurchFax : null);
    ttcVMSelf.fiPurchReci = ko.observable((data && data.hasOwnProperty('fiPurchReci')) ? data.fiPurchReci : null).
    extend({
        required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
    });
    ttcVMSelf.fiPurchFromDate = ko.observable((data && data.hasOwnProperty('fiPurchFromDate')) ? new Date(data.fiPurchFromDate) : null).
    extend({
        required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
    });
    ttcVMSelf.fiPurchToDate = ko.observable((data && data.hasOwnProperty('fiPurchToDate')) ? new Date(data.fiPurchToDate) : null).
    extend({
        required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
    });

    ttcVMSelf.fiProductList = ko.observableArray((data && data.hasOwnProperty('fiProductList')) ? data.fiProductList : []).
    extend({
        required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
    });

    ttcVMSelf.fiProCVMienGiam = ko.observable((data && data.hasOwnProperty('fiProCVMienGiam')) ? data.fiProCVMienGiam : null);
    ttcVMSelf.fiProCVMienGiamNgay = ko.observable(null);
    ttcVMSelf.fiProCVMienGiamNgayText = ko.observable(null);

    ttcVMSelf.fiProName = ko.observable((data && data.hasOwnProperty('fiProName')) ? data.fiProName : null).
    extend({
        required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
    });
    ttcVMSelf.fiProCode = ko.observable((data && data.hasOwnProperty('fiProCode')) ? data.fiProCode : null).
    extend({
        required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
    });
    ttcVMSelf.fiProMadeIn = ko.observable((data && data.hasOwnProperty('fiProMadeIn')) ? data.fiProMadeIn : null).
    extend({
        required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
    });
    ttcVMSelf.fiProThanhPhan = ko.observable((data && data.hasOwnProperty('fiProThanhPhan')) ? data.fiProThanhPhan : null).
    extend({
        required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
    });
    ttcVMSelf.fiProColor = ko.observable((data && data.hasOwnProperty('fiProColor')) ? data.fiProColor : null).
    extend({
        required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
    });
    ttcVMSelf.fiProSoHieu = ko.observable((data && data.hasOwnProperty('fiProSoHieu')) ? data.fiProSoHieu : null).
    extend({
        required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
    });
    ttcVMSelf.fiProQuyChuan = ko.observable((data && data.hasOwnProperty('fiProQuyChuan')) ? data.fiProQuyChuan : null).
    extend({
        required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
    });

    ttcVMSelf.fiProCLList = ko.observableArray((data && data.hasOwnProperty('fiProCLList')) ? data.fiProCLList : []).
    extend({
        required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
    });
    ttcVMSelf.EfiProCLTarg = ko.observable(null).
    extend({
        required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
    });
    ttcVMSelf.EfiProCLCompare = ko.observable(null).
    extend({
        required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
    });
    ttcVMSelf.EfiProCLContent = ko.observable(null).
    extend({
        required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
    });
    ttcVMSelf.EfiProCLUnitID = ko.observable(null).
    extend({
        required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
    });

    ttcVMSelf.changeHoSoType =function(){
        ttcVMSelf.fiProductList([]);
    }
    ttcVMSelf.fiProValueVN  = ko.observable((data && data.hasOwnProperty('fiProValueVN ')) ? data.fiProValueVN  : null).
    extend({
        required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        number: {params: true},
        min: 0
    });
    ttcVMSelf.fiProValueUSD   = ko.observable((data && data.hasOwnProperty('fiProValueUSD  ')) ? data.fiProValueUSD  : null).
    extend({
        required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        number: {params: true},
        min: 0
    });

    ttcVMSelf.fiProATList = ko.observableArray((data && data.hasOwnProperty('fiProATList')) ? data.fiProATList : []).
    extend({
        required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
    });
    ttcVMSelf.EfiProATTarg = ko.observable(null).
    extend({
        required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
    });
    ttcVMSelf.EfiProATCompare = ko.observable(null).
    extend({
        required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
    });
    ttcVMSelf.EfiProATContent = ko.observable(null).
    extend({
        required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
    });
    ttcVMSelf.EfiProATUnitID = ko.observable(null).
    extend({
        required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
    });

    ttcVMSelf.fiProSLKLList = ko.observableArray((data && data.hasOwnProperty('fiProSLKLList')) ? data.fiProSLKLList : []).
    extend({
        required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
    });
    ttcVMSelf.EfiProSLKLMass = ko.observable(null).
    extend({
        required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        number: {params: true},
        min: 0
    });
    ttcVMSelf.EfiProSLKLMassTan = ko.observable(null).
    extend({
        required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        number: {params: true},
        min: 0
    });
    ttcVMSelf.EfiProSLKLMassUnitCode = ko.observable(null).
    extend({
        required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
    });
    ttcVMSelf.EfiProSLKLAmount = ko.observable(null).
    extend({
        required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        number: {params: true},
        min: 0
    });
    ttcVMSelf.EfiProSLKLAmountUnitCode = ko.observable(null).
    extend({
        required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
    });


    ttcVMSelf.fiPackageUnitName = ko.observable(null);
    ttcVMSelf.fiPackageUnitCode = ko.observable(null).
    extend({
        required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
    });
    ttcVMSelf.fiSignName = ko.observable((data && data.hasOwnProperty('fiSignName')) ? data.fiSignName : null).
    extend({
        required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
    });
    ttcVMSelf.fiSignPosition = ko.observable((data && data.hasOwnProperty('fiSignPosition')) ? data.fiSignPosition : null).
    extend({
        required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
    });
    ttcVMSelf.fiSignAddressCode = ko.observable((data && data.hasOwnProperty('fiSignAddressCode')) ? data.fiSignAddressCode : null).
    extend({
        required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
    });

    ttcVMSelf.fiHSTypeName = ko.observable((data && data.hasOwnProperty('fiHSTypeName')) ? data.fiHSTypeName : null);
    ttcVMSelf.lstProvince  = ko.observableArray((data && data.hasOwnProperty('lstProvince')) ? data.lstProvince : []);
    ttcVMSelf.lstHoSoType  = ko.observableArray((data && data.hasOwnProperty('lstHoSoType')) ? data.lstHoSoType : []);
    

    ttcVMSelf.fiProIdNhom = ko.observable(null);
    ttcVMSelf.fiProIdPhanNhom = ko.observable(null);
    ttcVMSelf.fiProIdLoai = ko.observable(null);
    ttcVMSelf.fiProIdPhanLoai = ko.observable(null);
    ttcVMSelf.fiProCountryCode = ko.observable((data && data.hasOwnProperty('fiProCountryCode')) ? data.fiProCountryCode : null);
    ttcVMSelf.fiProCountryName = ko.observable((data && data.hasOwnProperty('fiProCountryName')) ? data.fiProCountryName : null);
    ttcVMSelf.lstUOMAnimal = ko.observable((data && data.hasOwnProperty('lstUOMAnimal')) ? data.lstUOMAnimal : null);

    ttcVMSelf.errorMsg = ko.observable(null);


    ttcVMSelf.fiRegistrationNo = ko.observable((data && data.hasOwnProperty('fiRegistrationNo')) ? data.fiRegistrationNo : null);
    ttcVMSelf.fiProSLKLAmountUnitName = ko.observable((data && data.hasOwnProperty('fiProSLKLAmountUnitName')) ? data.fiProSLKLAmountUnitName : null);
    ttcVMSelf.fiProSLKLMassUnitName = ko.observable((data && data.hasOwnProperty('fiProSLKLMassUnitName')) ? data.fiProSLKLMassUnitName : null);
    ttcVMSelf.fiImporterName = ko.observable((data && data.hasOwnProperty('fiImporterName')) ? data.fiImporterName : null)
        .extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    ttcVMSelf.fiImporterAddress = ko.observable((data && data.hasOwnProperty('fiImporterAddress')) ? data.fiImporterAddress : null)
        .extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
        });
    ttcVMSelf.fiImporterTel = ko.observable((data && data.hasOwnProperty('fiImporterTel')) ? data.fiImporterTel : null);
        // .extend({
        //     required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
        // });
    ttcVMSelf.fiImporterFax = ko.observable((data && data.hasOwnProperty('fiImporterFax')) ? data.fiImporterFax : null).
    extend({
        number: {params: true}
    });
    ttcVMSelf.fiImporterEmail = ko.observable((data && data.hasOwnProperty('fiImporterEmail')) ? data.fiImporterEmail : null)
        .extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
            email: {params: true, message: NSWLang["common_msg_invalid_email"]}
        });


    //inc_thongtinkhac.jsp
    ttcVMSelf.fiAddressGath = ko.observable((data && data.hasOwnProperty('fiAddressGath')) ? data.fiAddressGath : null);
    // extend({
    //     required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
    // });
    ttcVMSelf.fiRegSamFromDate = ko.observable((data && data.hasOwnProperty('fiRegSamFromDate')&&data.fiRegSamFromDate) ? new Date(data.fiRegSamFromDate) : null);
    // extend({
    //     required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
    // });
    ttcVMSelf.fiRegSamToDate = ko.observable((data && data.hasOwnProperty('fiRegSamToDate')&&data.fiRegSamToDate!=null) ? new Date(data.fiRegSamToDate) : null);
    // extend({
    //     required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
    // });
    ttcVMSelf.fiAddressRegSample = ko.observable((data && data.hasOwnProperty('fiAddressRegSample')) ? data.fiAddressRegSample : null);
    // extend({
    //     required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
    // });

    ttcVMSelf.fiContactName = ko.observable((data && data.hasOwnProperty('fiContactName')) ? data.fiContactName : null).
    extend({
        required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
    });
    ttcVMSelf.fiContactTel = ko.observable((data && data.hasOwnProperty('fiContactTel')) ? data.fiContactTel : null);
        // .extend({
        // pattern: {
        //     params: '^0[1-9][0-9]{8,9}$',
        //     message: "Số điện thoại không hợp lệ."}
    // });
    ttcVMSelf.fiContactAddress = ko.observable((data && data.hasOwnProperty('fiContactAddress')) ? data.fiContactAddress : null);
    // extend({
    //     required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
    // });
    ttcVMSelf.fiContactEmail = ko.observable((data && data.hasOwnProperty('fiContactEmail')) ? data.fiContactEmail : null).extend({
        email: {params: true, message: NSWLang["common_msg_invalid_email"]}
    });

    ttcVMSelf.lstLoaiTienTe  = ko.observableArray((data && data.hasOwnProperty('lstLoaiTienTe')) ? data.lstLoaiTienTe : []);
    ttcVMSelf.fiSignAddressName  = ko.observable(null);
    ttcVMSelf.lstMaHoSoThayThe = ko.observableArray([]);

    ttcVMSelf.fiLinkGDK  = ko.observable(null);
    ttcVMSelf.fiFileNameGDK  = ko.observable(null);
    ttcVMSelf.fiFileIdGDK  = ko.observable(null);

    app.makeGet({
        url: '/mard/25/hoso/find-by-status?taxCode=' + ttcVMSelf.fiTaxCode() + '&from=26',
        success: function(res) {
            if (res.data){
                var arr=res.data;
                for (var i=0;i<arr.length;i++){
                    var item = {
                        fiNSWFileCodeR:arr[i].fiNSWFileCode,
                        fiIdHSR:arr[i].fiIdHS,
                        fiGDKR:arr[i].fiSoXacNhanDon
                    };
                    ttcVMSelf.lstMaHoSoThayThe.push(item);
                }
            }
        },
        error: function (d) {

        }
    });
    ttcVMSelf.changeMaHSThayThe =function(){
        var lstHoso = ttcVMSelf.lstMaHoSoThayThe();
        var pos = lstHoso.find(function (e) {
            return e.fiIdHSR == ttcVMSelf.fiNSWFileCodeReplace();
        })
        if (pos)
            ttcVMSelf.fiGDK(pos.fiGDKR);

    }
    ttcVMSelf.eventChangeNhom =function(){
        var id =ttcVMSelf.fiProIdNhom();
        if(id !== 'undefined'&&id!=null){
            app.makeGet({
                url: '/mard/25/danhmuc/getby-catparent/'+id,
                success: function(res) {
                    ttcVMSelf.lstPhanNhom(res.data);
                    if(ttcVMSelf.fiProIdPhanNhomTemp()!=null){
                        var idPhanNhom = ttcVMSelf.findCatIdByCatNote(ttcVMSelf.lstPhanNhom(),ttcVMSelf.fiProIdPhanNhomTemp());
                        ttcVMSelf.fiProIdPhanNhom(idPhanNhom);
                    }
                }
            });
        }
    }

    ttcVMSelf.eventChangePhanNhom =function(){
        var id =ttcVMSelf.fiProIdPhanNhom();
        if(id !== 'undefined'&&id!=null){
            ttcVMSelf.lstLoai([]);
            app.makeGet({
                url: '/mard/25/danhmuc/getby-catparent/'+id,
                success: function(res) {
                    ttcVMSelf.lstLoai(res.data);
                    if(ttcVMSelf.fiProIdLoaiTemp()!=null){
                        var idLoai = ttcVMSelf.findCatIdByCatNote(ttcVMSelf.lstLoai(),ttcVMSelf.fiProIdLoaiTemp());
                        ttcVMSelf.fiProIdLoai(idLoai);
                    }
                }
            });
        }
    }
    ttcVMSelf.eventChangeLoai =function(){
        var id =ttcVMSelf.fiProIdLoai();
        ttcVMSelf.lstPhanLoai([]);
        if(id !== 'undefined'&&id!=null){
            app.makeGet({
                url: '/mard/25/danhmuc/getby-catparent/'+id,
                success: function(res) {
                    ttcVMSelf.lstPhanLoai(res.data);
                    if(ttcVMSelf.fiProIdPhanLoaiTemp()!=null){
                        var idPhanLoai = ttcVMSelf.findCatIdByCatNote(ttcVMSelf.lstPhanLoai(),ttcVMSelf.fiProIdPhanLoaiTemp());
                        ttcVMSelf.fiProIdPhanLoai(idPhanLoai);
                    }
                }
            });
        }
    }

    ttcVMSelf.getProfileStatus = function (statuscode) {
        var lstProfileStatus = ttcVMSelf.lstProfileStatus();
        var pos = lstProfileStatus.find(function (e) {
            return e.fiCatType == Number(statuscode);
        })
        if (pos)
            return pos.fiCatTypeName;
        else return statuscode;
    }
    ttcVMSelf.getTenNhom = function (idNhom) {
        return ttcVMSelf.findCodeName(ttcVMSelf.lstNhom(),idNhom);
    }

    ttcVMSelf.eventChangeHangHoa =function(){
        var lst = ttcVMSelf.lstDSHosoMK();
        var pos = lst.find(function (e) {
            return e.fiIdProduct == ttcVMSelf.fiIdProduct25();
        });
        if (pos){
            // ko.mapping.fromJS(pos, {}, ttcVMSelf);
            ttcVMSelf.fiProCVMienGiam(pos.fiProCVMienGiam);
            ttcVMSelf.fiProCVMienGiamNgay(pos.fiProCVMienGiamNgay==null?null:new Date(pos.fiProCVMienGiamNgay));
            ttcVMSelf.fiProCVMienGiamNgayText(new Date(pos.fiProCVMienGiamNgay).toShortDateString());

            ttcVMSelf.fiProName(pos.fiProName);
            ttcVMSelf.fiProIdNhom(pos.fiProIdNhom);
            ttcVMSelf.fiProIdPhanNhom(pos.fiProIdPhanNhom);
            ttcVMSelf.fiProIdLoai(pos.fiProIdLoai);
            ttcVMSelf.fiProIdPhanLoai(pos.fiProIdPhanLoai);

            ttcVMSelf.fiProIdNhomTemp(pos.fiProIdNhom);
            ttcVMSelf.fiProIdPhanNhomTemp(pos.fiProIdPhanNhom);
            ttcVMSelf.fiProIdLoaiTemp(pos.fiProIdLoai);
            ttcVMSelf.fiProIdPhanLoaiTemp(pos.fiProIdPhanLoai);

            ttcVMSelf.fiProNhom2D(pos.fiProNameNhom);
            ttcVMSelf.fiProPhanNhom2D(pos.fiProNamePhanNhom);
            ttcVMSelf.fiProLoai2D(pos.fiProNameLoai);
            ttcVMSelf.fiProPhanLoai2D(pos.fiProNamePhanLoai);

            ttcVMSelf.fiProCode(pos.fiProCode);
            ttcVMSelf.fiProMadeIn(pos.fiProMadeIn);
            ttcVMSelf.fiProCountryCode(pos.fiProCountryCode);
            ttcVMSelf.fiProCountryName(pos.fiProCountryName);
            ttcVMSelf.fiProThanhPhan(pos.fiProThanhPhan);
            ttcVMSelf.fiProColor(pos.fiProColor);
            ttcVMSelf.fiProSoHieu(pos.fiProSoHieu);
            ttcVMSelf.fiProQuyChuan(pos.fiProQuyChuan);
            ttcVMSelf.fiProCVMienGiam(pos.fiProCVMienGiam);
            ttcVMSelf.fiProCVMienGiamNgay(pos.fiProCVMienGiamNgay);
            ttcVMSelf.fiPackageUnitName(pos.fiPackageUnitName);
            ttcVMSelf.fiPackageUnitCode(pos.fiPackageUnitCode);

            ko.utils.arrayForEach(pos.fiProATList, function(at) {
                at.isEnable=ko.observable(false);
                at.isUpdate=ko.observable(false);
                at.lstChiTieuAT = ttcVMSelf.lstChiTieuAT();
                at.fiIdProAT=null;
            });
            ko.utils.arrayForEach(pos.fiProCLList, function(cl) {
                cl.isEnable =ko.observable(false);
                cl.isUpdate =ko.observable(false);
                cl.lstChiTieuAT = ttcVMSelf.lstChiTieuAT();
                cl.fiIdProCL=null;
            });
            ttcVMSelf.fiProCLList(pos.fiProCLList);
            ttcVMSelf.fiProATList(pos.fiProATList);

        }else{
            ttcVMSelf.clearForm();
        }
    }

    ttcVMSelf.clearForm = function () {
        $("#fiProName").val('');
        $("#fiProIdNhom").val('');
        $("#fiProIdPhanNhom").val('');
        $("#fiProIdLoai").val('');
        $("#fiProIdPhanLoai").val('');
        $("#fiProCode").val('');
        $("#fiProMadeIn").val('');
        $("#fiProCountryCode").val('');
        $("#fiProThanhPhan").val('');
        $("#fiProColor").val('');
        $("#fiProSoHieu").val('');
        $("#fiProQuyChuan").val('');
        $("#fiProSLKLList").val('');
        $("#fiProATList").val('');
        $("#fiProCLList").val('');
        ttcVMSelf.fiProName(null);
        ttcVMSelf.fiProIdNhom(null);
        ttcVMSelf.fiProIdPhanNhom(null);
        ttcVMSelf.fiProIdLoai(null);
        ttcVMSelf.fiProIdPhanLoai(null);
        ttcVMSelf.fiProCode(null);
        ttcVMSelf.fiProMadeIn(null);
        ttcVMSelf.fiProCountryCode(null);
        ttcVMSelf.fiProThanhPhan(null);
        ttcVMSelf.fiProColor(null);
        ttcVMSelf.fiProSoHieu(null);
        ttcVMSelf.fiProQuyChuan(null);
        ttcVMSelf.fiProSLKLList([]);
        ttcVMSelf.fiProATList([]);
        ttcVMSelf.fiProCLList([]);
        ttcVMSelf.listCL([]);
        ttcVMSelf.listAT([]);
        ttcVMSelf.listSLKL([]);
        ttcVMSelf.fiProValueVN(null);
        ttcVMSelf.fiProValueUSD(null);
        ttcVMSelf.selectedHangHoa(null);
        ttcVMSelf.selectedIndex(null);
        ttcVMSelf.fiProCVMienGiam(null);
        ttcVMSelf.fiProCVMienGiamNgay(null);
        ttcVMSelf.fiProQuyChuan(null);

        ttcVMSelf.fiProIdNhomTemp(null);
        ttcVMSelf.fiProIdPhanNhomTemp(null);
        ttcVMSelf.fiProIdLoaiTemp(null);
        ttcVMSelf.fiProIdPhanLoaiTemp(null);

        ttcVMSelf.fiProNhom2D(null);
        ttcVMSelf.fiProPhanNhom2D(null);
        ttcVMSelf.fiProLoai2D(null);
        ttcVMSelf.fiProPhanLoai2D(null);
    }
    ttcVMSelf.validateHangHoa=function(){
        if(ttcVMSelf.fiHSType()!=4){
            if (ttcVMSelf.fiProIdNhom()==null){
                app.Alert("Chưa chọn nhóm TACN");
                return false;
            }
            if (ttcVMSelf.fiProIdPhanNhom()==null){
                app.Alert("Chưa chọn phân nhóm TACN");
                return false;
            }
            if (ttcVMSelf.fiProIdLoai()==null){
                app.Alert("Chưa chọn loại TACN");
                return false;
            }
            if (ttcVMSelf.fiProIdPhanLoai()==null){
                app.Alert("Chưa chọn phân loại TACN");
                return false;
            }
        }else{
            if(ttcVMSelf.fiIdProduct25()==null){
                app.Alert("Chưa chọn hàng hóa miễn kiểm");
                return false;
            }
        }
        return true;
    }
    ttcVMSelf.addProduct2D=function(){
        var getAllForm = [ttcVMSelf.fiProSLKLList, ttcVMSelf.fiProATList,ttcVMSelf.fiProCLList];
        ttcVMSelf.errors = ko.validation.group(getAllForm, {deep: true, live: true, observable: true});
        if (!ttcVMSelf.validate()) return;
        if(!ttcVMSelf.validateHangHoa()){
            return;
        }
        for (var i =0;i<ttcVMSelf.fiProSLKLList().length;i++){
            var massName=ttcVMSelf.findNameByCatNote(ttcVMSelf.fiProSLKLList()[i].fiProSLKLMassUnitCode);
            var amountName=ttcVMSelf.findNameByCatNote(ttcVMSelf.fiProSLKLList()[i].fiProSLKLAmountUnitCode);
            var getList = {
                fiProSLKLMass: ttcVMSelf.fiProSLKLList()[i].fiProSLKLMass,
                fiProSLKLMassTan: ttcVMSelf.fiProSLKLList()[i].fiProSLKLMassTan,
                fiProSLKLMassUnitName: massName,
                fiProSLKLMassUnitCode: ttcVMSelf.fiProSLKLList()[i].fiProSLKLMassUnitCode(),
                fiProSLKLAmount: ttcVMSelf.fiProSLKLList()[i].fiProSLKLAmount,
                fiProSLKLAmountUnitName: amountName,
                lstDMDVT: ttcVMSelf.lstDMDVT(),
                lstDMDVTSL: ttcVMSelf.lstDMDVTSL(),
                isEnable: ttcVMSelf.fiProSLKLList()[i].isEnable,
                isUpdate: ttcVMSelf.fiProSLKLList()[i].isUpdate,
                fiProSLKLAmountUnitCode: ttcVMSelf.fiProSLKLList()[i].fiProSLKLAmountUnitCode
            }
            ttcVMSelf.listSLKL.push(getList);
        }
        var kl;
        var sl;
        ko.utils.arrayForEach(ttcVMSelf.listSLKL(), function(slkl) {
            kl=slkl.fiProSLKLMass()+' '+slkl.fiProSLKLMassUnitName();
            sl=slkl.fiProSLKLAmount()+' '+slkl.fiProSLKLAmountUnitName();
        });
        var item ={
            fiIdProduct:null,
            fiProName: ttcVMSelf.fiProName(),
            fiTrangThaiHangHoa: ttcVMSelf.fiTrangThaiHangHoa(),
            fiProductKL: kl,
            fiProductSL: sl,
            fiProThanhPhan: ttcVMSelf.fiProThanhPhan(),
            fiProIdNhom: ttcVMSelf.fiProIdNhomTemp(),
            fiProNameNhom: ttcVMSelf.fiProNhom2D(),
            fiProIdPhanNhom: ttcVMSelf.fiProIdPhanNhomTemp(),
            fiProNamePhanNhom: ttcVMSelf.fiProPhanNhom2D,
            fiProIdLoai: ttcVMSelf.fiProIdLoaiTemp(),
            fiProNameLoai: ttcVMSelf.fiProLoai2D(),
            fiProIdPhanLoai: ttcVMSelf.fiProIdPhanLoaiTemp(),
            fiProNamePhanLoai: ttcVMSelf.fiProPhanLoai2D(),
            fiProCode: ttcVMSelf.fiProCode(),
            fiProMadeIn: ttcVMSelf.fiProMadeIn(),
            fiProCountryName: ttcVMSelf.fiProCountryName(),
            fiProCountryCode: ttcVMSelf.fiProCountryCode(),
            fiProValueVN: ttcVMSelf.fiProValueVN(),
            fiProColor: ttcVMSelf.fiProColor(),
            fiProSoHieu: ttcVMSelf.fiProSoHieu(),
            fiProQuyChuan: ttcVMSelf.fiProQuyChuan(),
            fiProValueUSD: ttcVMSelf.fiProValueUSD(),
            fiPackageUnitCode: ttcVMSelf.fiPackageUnitCode(),
            fiPackageUnitName: ttcVMSelf.fiPackageUnitName(),
            fiProCLList:  ttcVMSelf.fiProCLList(),
            fiProSLKLList: ttcVMSelf.listSLKL(),
            fiProATList: ttcVMSelf.fiProATList(),
            fiTaxCode: hosoUsername
        }
        if(ttcVMSelf.selectedHangHoa()!=null&&ttcVMSelf.selectedIndex()!=null){
            ttcVMSelf.fiProductList.splice(ttcVMSelf.selectedIndex(), 1);
            ttcVMSelf.fiProductList.splice(ttcVMSelf.selectedIndex(), 0, item);
        }else{
            ttcVMSelf.fiProductList.push(item);
        }
        ttcVMSelf.clearForm();
        $("#modal_addAnimal").modal('hide');
    }
    ttcVMSelf.addProduct=function(data){
        if (ttcVMSelf.fiHSType()==4){
            ttcVMSelf.addProduct2D();
            return;
        }
        var getAllForm = [ttcVMSelf.fiProSLKLList, ttcVMSelf.fiProATList,ttcVMSelf.fiProCLList];
        ttcVMSelf.errors = ko.validation.group(getAllForm, {deep: true, live: true, observable: true});
        if (!ttcVMSelf.validate()) return;
        if(!ttcVMSelf.validateHangHoa()){
         return;
        }
        for (var i =0;i<ttcVMSelf.fiProCLList().length;i++){
            var getList = {
                fiProCLTarg: ttcVMSelf.fiProCLList()[i].fiProCLTarg(),
                fiProCLCompare: ttcVMSelf.fiProCLList()[i].fiProCLCompare(),
                fiProCLContent: ttcVMSelf.fiProCLList()[i].fiProCLContent(),
                fiProCLUnitName: ttcVMSelf.fiProCLList()[i].fiProCLUnitName(),
                lstChiTieuAT: ttcVMSelf.lstChiTieuAT,
                isEnable: ttcVMSelf.fiProCLList()[i].isEnable(),
                isUpdate: ttcVMSelf.fiProCLList()[i].isUpdate(),
                fiProCLUnitID: ttcVMSelf.fiProCLList()[i].fiProCLUnitID
            }
            ttcVMSelf.listCL.push(getList);
        }

        for (var i =0;i<ttcVMSelf.fiProATList().length;i++){
            var getList = {
                fiProATTarg:  ttcVMSelf.fiProATList()[i].fiProATTarg(),
                fiProATCompare: ttcVMSelf.fiProATList()[i].fiProATCompare(),
                fiProATContent:  ttcVMSelf.fiProATList()[i].fiProATContent(),
                fiProATUnitName: ttcVMSelf.fiProATList()[i].fiProATUnitName(),
                lstChiTieuAT: ttcVMSelf.lstChiTieuAT,
                isEnable: ttcVMSelf.fiProATList()[i].isEnable(),
                isUpdate: ttcVMSelf.fiProATList()[i].isUpdate(),
                fiProATUnitID:  ttcVMSelf.fiProATList()[i].fiProATUnitID
        }
            ttcVMSelf.listAT.push(getList);
        }
        for (var i =0;i<ttcVMSelf.fiProSLKLList().length;i++){
            var massName=ttcVMSelf.findNameByCatNote(ttcVMSelf.fiProSLKLList()[i].fiProSLKLMassUnitCode());
            var amountName=ttcVMSelf.findNameByCatNote(ttcVMSelf.fiProSLKLList()[i].fiProSLKLAmountUnitCode());
            var getList = {
                fiProSLKLMass: ttcVMSelf.fiProSLKLList()[i].fiProSLKLMass(),
                fiProSLKLMassTan: ttcVMSelf.fiProSLKLList()[i].fiProSLKLMassTan(),
                fiProSLKLMassUnitName: massName,
                fiProSLKLMassUnitCode: ttcVMSelf.fiProSLKLList()[i].fiProSLKLMassUnitCode(),
                fiProSLKLAmount: ttcVMSelf.fiProSLKLList()[i].fiProSLKLAmount(),
                fiProSLKLAmountUnitName: amountName,
                lstDMDVT: ttcVMSelf.lstDMDVT(),
                lstDMDVTSL: ttcVMSelf.lstDMDVTSL(),
                isEnable: ttcVMSelf.fiProSLKLList()[i].isEnable(),
                isUpdate: ttcVMSelf.fiProSLKLList()[i].isUpdate(),
                fiProSLKLAmountUnitCode: ttcVMSelf.fiProSLKLList()[i].fiProSLKLAmountUnitCode()
            }
            ttcVMSelf.listSLKL.push(getList);
        }
        var kl;
        var sl;
        ko.utils.arrayForEach(ttcVMSelf.listSLKL(), function(slkl) {
            kl=slkl.fiProSLKLMass+' '+slkl.fiProSLKLMassUnitName;
            sl=slkl.fiProSLKLAmount+' '+slkl.fiProSLKLAmountUnitName;
        });
        var nameNhom=ttcVMSelf.findCodeName(ttcVMSelf.lstNhom(),ttcVMSelf.fiProIdNhom());
        var namePhanNhom=ttcVMSelf.findCodeName(ttcVMSelf.lstPhanNhom(),ttcVMSelf.fiProIdPhanNhom());
        var nameLoai=ttcVMSelf.findCodeName(ttcVMSelf.lstLoai(),ttcVMSelf.fiProIdLoai());
        var namePhanLoai=ttcVMSelf.findCodeName(ttcVMSelf.lstPhanLoai(),ttcVMSelf.fiProIdPhanLoai());

        var phanNhom=ttcVMSelf.findCatNoteById(ttcVMSelf.lstPhanNhom(),ttcVMSelf.fiProIdPhanNhom());
        var loai=ttcVMSelf.findCatNoteById(ttcVMSelf.lstLoai(),ttcVMSelf.fiProIdLoai());
        var phanLoai=ttcVMSelf.findCatNoteById(ttcVMSelf.lstPhanLoai(),ttcVMSelf.fiProIdPhanLoai());
        var item ={
            fiProName: ttcVMSelf.fiProName(),
            fiTrangThaiHangHoa: ttcVMSelf.fiTrangThaiHangHoa(),
            fiProductKL: kl,
            fiProductSL: sl,
            fiProThanhPhan: ttcVMSelf.fiProThanhPhan(),
            fiProIdNhom: ttcVMSelf.fiProIdNhom(),
            fiProNameNhom: nameNhom,
            fiProIdPhanNhom: phanNhom,
            fiProNamePhanNhom: namePhanNhom,
            fiProIdLoai: loai,
            fiProNameLoai: nameLoai,
            fiProIdPhanLoai: phanLoai,
            fiProNamePhanLoai: namePhanLoai,
            fiProCode: ttcVMSelf.fiProCode(),
            fiProMadeIn: ttcVMSelf.fiProMadeIn(),
            fiProCountryName: ttcVMSelf.fiProCountryName(),
            fiProCountryCode: ttcVMSelf.fiProCountryCode(),
            fiProValueVN: ttcVMSelf.fiProValueVN(),
            fiProColor: ttcVMSelf.fiProColor(),
            fiProSoHieu: ttcVMSelf.fiProSoHieu(),
            fiProQuyChuan: ttcVMSelf.fiProQuyChuan(),
            fiProValueUSD: ttcVMSelf.fiProValueUSD(),
            fiPackageUnitCode: ttcVMSelf.fiPackageUnitCode(),
            fiPackageUnitName: ttcVMSelf.fiPackageUnitName(),
            fiProCLList:  ttcVMSelf.listCL(),
            fiProSLKLList: ttcVMSelf.listSLKL(),
            fiProATList: ttcVMSelf.listAT(),
            fiTaxCode: ttcVMSelf.fiTaxCode()
        }
        if(ttcVMSelf.selectedHangHoa()!=null&&ttcVMSelf.selectedIndex()!=null){
            ttcVMSelf.fiProductList.splice(ttcVMSelf.selectedIndex(), 1);
            ttcVMSelf.fiProductList.splice(ttcVMSelf.selectedIndex(), 0, item);
        }else{
            ttcVMSelf.fiProductList.push(item);
        }
        ttcVMSelf.clearForm();
        $("#modal_addAnimal").modal('hide');

    }

    ttcVMSelf.updateAnimal= function () {
        var addProductValid = [ttcVMSelf.fiProName, ttcVMSelf.fiProIdNhom, ttcVMSelf.fiProIdPhanNhom,ttcVMSelf.fiProIdLoai,ttcVMSelf.fiProValueVN,ttcVMSelf.fiProColor,ttcVMSelf.fiProSoHieu,
            ttcVMSelf.fiProValueUSA,ttcVMSelf.fiProIdPhanLoai,ttcVMSelf.fiProCode,ttcVMSelf.fiProMadeIn,ttcVMSelf.fiProCountryCode,ttcVMSelf.fiProThanhPhan,ttcVMSelf.fiProQuyChuan,];
        var getAllForm = [ttcVMSelf.fiProSLKLList, ttcVMSelf.fiProATList,ttcVMSelf.fiProCLList];
        ttcVMSelf.errors = ko.validation.group(getAllForm,addProductValid, {deep: true, live: true, observable: true});
        if (!ttcVMSelf.validate()) return;

        for (var i =0;i<ttcVMSelf.fiProCLList().length;i++){
            var getList = {
                fiProCLTarg: ttcVMSelf.fiProCLList()[i].fiProCLTarg(),
                fiProCLCompare: ttcVMSelf.fiProCLList()[i].fiProCLCompare(),
                fiProCLContent: ttcVMSelf.fiProCLList()[i].fiProCLContent(),
                fiProCLUnitName: ttcVMSelf.fiProCLList()[i].fiProCLUnitName(),
                lstChiTieuAT: ttcVMSelf.lstChiTieuAT,
                isEnable: ttcVMSelf.fiProCLList()[i].isEnable(),
                isUpdate: ttcVMSelf.fiProCLList()[i].isUpdate(),
                fiProCLUnitID: ttcVMSelf.fiProCLList()[i].fiProCLUnitID
            }
            ttcVMSelf.listCL.push(getList);
        }

        for (var i =0;i<ttcVMSelf.fiProATList().length;i++){
            var getList = {
                fiProATTarg:  ttcVMSelf.fiProATList()[i].fiProATTarg(),
                fiProATCompare: ttcVMSelf.fiProATList()[i].fiProATCompare(),
                fiProATContent:  ttcVMSelf.fiProATList()[i].fiProATContent(),
                fiProATUnitName: ttcVMSelf.fiProATList()[i].fiProATUnitName(),
                lstChiTieuAT: ttcVMSelf.lstChiTieuAT,
                isEnable: ttcVMSelf.fiProATList()[i].isEnable(),
                isUpdate: ttcVMSelf.fiProATList()[i].isUpdate(),
                fiProATUnitID:  ttcVMSelf.fiProATList()[i].fiProATUnitID
            }
            ttcVMSelf.listAT.push(getList);
        }
        for (var i =0;i<ttcVMSelf.fiProSLKLList().length;i++){
            var massName=ttcVMSelf.findNameByCatNote(ttcVMSelf.fiProSLKLList()[i].fiProSLKLMassUnitCode());
            var amountName=ttcVMSelf.findNameByCatNote(ttcVMSelf.fiProSLKLList()[i].fiProSLKLAmountUnitCode());
            var getList = {
                fiProSLKLMass: ttcVMSelf.fiProSLKLList()[i].fiProSLKLMass(),
                fiProSLKLMassTan: ttcVMSelf.fiProSLKLList()[i].fiProSLKLMassTan(),
                fiProSLKLMassUnitName: ttcVMSelf.fiProSLKLList()[i].fiProSLKLMassUnitName(),
                fiProSLKLMassUnitCode: massName,
                fiProSLKLAmount: ttcVMSelf.fiProSLKLList()[i].fiProSLKLAmount(),
                fiProSLKLAmountUnitName: amountName,
                lstDMDVT: ttcVMSelf.lstDMDVT,
                isEnable: ttcVMSelf.fiProSLKLList()[i].isEnable(),
                isUpdate: ttcVMSelf.fiProSLKLList()[i].isUpdate(),
                fiProSLKLAmountUnitCode: ttcVMSelf.fiProSLKLList()[i].fiProSLKLAmountUnitCode()
            }
            ttcVMSelf.listSLKL.push(getList);
        }
        var kl;
        var sl;
        ko.utils.arrayForEach(ttcVMSelf.listSLKL(), function(slkl) {
            kl=slkl.fiProSLKLMass+' '+slkl.fiProSLKLMassUnitName;
            sl=slkl.fiProSLKLAmount+' '+slkl.fiProSLKLAmountUnitName;
        });
        var nameNhom=ttcVMSelf.findCodeName(ttcVMSelf.lstNhom(),ttcVMSelf.fiProIdNhom());
        var namePhanNhom=ttcVMSelf.findCodeName(ttcVMSelf.lstPhanNhom(),ttcVMSelf.fiProIdPhanNhom());
        var nameLoai=ttcVMSelf.findCodeName(ttcVMSelf.lstLoai(),ttcVMSelf.fiProIdLoai());
        var namePhanLoai=ttcVMSelf.findCodeName(ttcVMSelf.lstPhanLoai(),ttcVMSelf.fiProIdPhanLoai());

        var phanNhom=ttcVMSelf.findCatNoteById(ttcVMSelf.lstPhanNhom(),ttcVMSelf.fiProIdPhanNhom());
        var loai=ttcVMSelf.findCatNoteById(ttcVMSelf.lstLoai(),ttcVMSelf.fiProIdLoai());
        var phanLoai=ttcVMSelf.findCatNoteById(ttcVMSelf.lstPhanLoai(),ttcVMSelf.fiProIdPhanLoai());
        var item ={
            fiProName: ttcVMSelf.fiProName(),
            fiTrangThaiHangHoa: ttcVMSelf.fiTrangThaiHangHoa(),
            fiProductKL: kl,
            fiProductSL: sl,
            fiProThanhPhan: ttcVMSelf.fiProThanhPhan(),
            fiProIdNhom: ttcVMSelf.fiProIdNhom(),
            fiProNameNhom: nameNhom,
            fiProIdPhanNhom: phanNhom,
            fiProNamePhanNhom: namePhanNhom,
            fiProIdLoai: loai,
            fiProNameLoai: nameLoai,
            fiProIdPhanLoai: phanLoai,
            fiProNamePhanLoai: namePhanLoai,
            fiProCode: ttcVMSelf.fiProCode(),
            fiProMadeIn: ttcVMSelf.fiProMadeIn(),
            fiProCountryName: ttcVMSelf.fiProCountryName(),
            fiProCountryCode: ttcVMSelf.fiProCountryCode(),
            fiProValueVN: ttcVMSelf.fiProValueVN(),
            fiProColor: ttcVMSelf.fiProColor(),
            fiProSoHieu: ttcVMSelf.fiProSoHieu(),
            fiProQuyChuan: ttcVMSelf.fiProQuyChuan(),
            fiProValueUSD: ttcVMSelf.fiProValueUSD(),
            fiPackageUnitCode: ttcVMSelf.fiPackageUnitCode(),
            fiPackageUnitName: ttcVMSelf.fiPackageUnitName(),
            fiProCLList: ttcVMSelf.listCL(),
            fiProSLKLList: ttcVMSelf.listSLKL(),
            fiProATList: ttcVMSelf.listAT(),
            fiTaxCode: ttcVMSelf.fiTaxCode()
        }
        var index = ttcVMSelf.selectedIndex();
        ttcVMSelf.fiProductList.splice(index, 1);
        ttcVMSelf.fiProductList.splice(index, 0, item);
        ttcVMSelf.clearForm();
        if ($('#modal_updateAnimal').hasClass('in')) {
            $('#modal_updateAnimal').modal('hide')
        }
        ;
        if ($('#modal_updateAnimal').hasClass('in')) {
            $('#modal_updateAnimal').modal('hide')
        }

    }

    ttcVMSelf.updateListCL= function (item) {
        var chiTieuChatLuong = [item.fiProCLContent, item.fiProCLCompare, item.fiProCLUnitID,item.fiProCLTarg];
        ttcVMSelf.errors = ko.validation.group(chiTieuChatLuong, {deep: true, live: true, observable: true});
        if (!ttcVMSelf.validate()) return;
        var index = ttcVMSelf.selectedIndex();
        ttcVMSelf.fiProCLList.splice(index, 1);
        ttcVMSelf.fiProCLList.splice(index, 0, item);
        item.isUpdate(false);
        item.isEnable(false);
    }

    ttcVMSelf.updateListAT= function (item) {
        var chiTieuAT = [item.fiProATContent, item.fiProATCompare, item.fiProATUnitID,item.fiProATTarg];
        ttcVMSelf.errors = ko.validation.group(chiTieuAT, {deep: true, live: true, observable: true});
        if (!ttcVMSelf.validate()) return;
        var index = ttcVMSelf.selectedIndex();
        ttcVMSelf.fiProATList.splice(index, 1);
        ttcVMSelf.fiProATList.splice(index, 0, item);
        item.isUpdate(false);
        item.isEnable(false);
    }

    ttcVMSelf.updateListSLKT= function (item) {
        var chiTieuKL = [item.fiProSLKLMass, item.fiProSLKLMassTan, item.fiProSLKLAmount,item.fiProSLKLAmountUnitCode,item.fiProSLKLAmountUnitCode];
        ttcVMSelf.errors = ko.validation.group(chiTieuKL, {deep: true, live: true, observable: true});
        if (!ttcVMSelf.validate()) return;
        var index = ttcVMSelf.selectedIndex();
        ttcVMSelf.fiProSLKLList.splice(index, 1);
        ttcVMSelf.fiProSLKLList.splice(index, 0, item);
        item.isUpdate(false);
        item.isEnable(false);
    }

    ttcVMSelf.clearFormCL = function () {
        ttcVMSelf.errorMsg('');
        $("#EfiProCLContent").val('');
        $("#EfiProCLCompare").val('');
        $("#EfiProCLUnitID").val('');
        $("#EfiProCLTarg").val('');
        ttcVMSelf.EfiProCLContent(null);
        ttcVMSelf.EfiProCLCompare(null);
        ttcVMSelf.EfiProCLUnitID(null);
        ttcVMSelf.EfiProCLTarg(null);
    }

    ttcVMSelf.addThongTinChiTieuChatLuong=function () {
        var chiTieuChatLuong = [ttcVMSelf.EfiProCLContent, ttcVMSelf.EfiProCLCompare, ttcVMSelf.EfiProCLUnitID,ttcVMSelf.EfiProCLTarg];
        ttcVMSelf.errors = ko.validation.group(chiTieuChatLuong, {deep: true, live: true, observable: true});
        if (!ttcVMSelf.validate()) return;
        var unitName= ttcVMSelf.findNameByCatNote2(ttcVMSelf.lstChiTieuAT(),ttcVMSelf.EfiProCLUnitID());
        var item = {
            fiProCLTarg: ttcVMSelf.EfiProCLTarg(),
            fiProCLCompare: ttcVMSelf.EfiProCLCompare(),
            fiProCLContent: ttcVMSelf.EfiProCLContent(),
            fiProCLUnitName: unitName,
            lstChiTieuAT: ttcVMSelf.lstChiTieuAT,
            isEnable:ko.observable(false),
            isUpdate:ko.observable(false),
            fiProCLUnitID: ttcVMSelf.EfiProCLUnitID()
        }
        item.fiProCLTarg = ko.observable((item && item.hasOwnProperty('fiProCLTarg')) ? item.fiProCLTarg : null).extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
        });
        item.fiProCLCompare = ko.observable((item && item.hasOwnProperty('fiProCLCompare')) ? item.fiProCLCompare : null).extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
        });
        item.fiProCLContent = ko.observable((item && item.hasOwnProperty('fiProCLContent')) ? item.fiProCLContent : null).extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
        });
        item.fiProCLUnitName = ko.observable((item && item.hasOwnProperty('fiProCLUnitName')) ? item.fiProCLUnitName : null).extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
        });
        ttcVMSelf.fiProCLList.push(item);
        ttcVMSelf.clearFormCL();
    }
    ttcVMSelf.editHangHoa = function(item,index){
        ttcVMSelf.selectedIndex(index);
        // item.isEnable=true;
        item.isEnable(true);
        item.isUpdate(true);
    }
    ttcVMSelf.clearFormAT= function () {
        ttcVMSelf.errorMsg('');
        $("#EfiProATContent").val('');
        $("#EfiProATTarg").val('');
        $("#EfiProATCompare").val('');
        $("#EfiProATUnitID").val('');
        ttcVMSelf.EfiProATContent(null);
        ttcVMSelf.EfiProATTarg(null);
        ttcVMSelf.EfiProATCompare(null);
        ttcVMSelf.EfiProATUnitID(null);
    }
    ttcVMSelf.addThongTinChiTieuAT=function () {
        var chiTieuAT = [ttcVMSelf.EfiProATContent, ttcVMSelf.EfiProATTarg, ttcVMSelf.EfiProATCompare,ttcVMSelf.EfiProATUnitID];
        ttcVMSelf.errors = ko.validation.group(chiTieuAT, {deep: true, live: true, observable: true});
        if (!ttcVMSelf.validate()) return;
        var unitName= ttcVMSelf.findNameByCatNote2(ttcVMSelf.lstChiTieuAT(),ttcVMSelf.EfiProATUnitID());
        var item = {
            fiProATTarg: ttcVMSelf.EfiProATTarg(),
            fiProATCompare: ttcVMSelf.EfiProATCompare(),
            fiProATContent: ttcVMSelf.EfiProATContent(),
            isEnable:ko.observable(false),
            isUpdate:ko.observable(false),
            lstChiTieuAT: ttcVMSelf.lstChiTieuAT,
            fiProATUnitName: unitName,
            fiProATUnitID: ttcVMSelf.EfiProATUnitID()
        }
        item.fiProATTarg = ko.observable((item && item.hasOwnProperty('fiProATTarg')) ? item.fiProATTarg : null).extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
        });
        item.fiProATCompare = ko.observable((item && item.hasOwnProperty('fiProATCompare')) ? item.fiProATCompare : null).extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
        });
        item.fiProATContent = ko.observable((item && item.hasOwnProperty('fiProATContent')) ? item.fiProATContent : null).extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
        });
        item.fiProATUnitName = ko.observable((item && item.hasOwnProperty('fiProATUnitName')) ? item.fiProATUnitName : null).extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
        });
        ttcVMSelf.fiProATList.push(item);
        ttcVMSelf.clearFormAT();
    }
    ttcVMSelf.clearFormKL = function () {
        ttcVMSelf.errorMsg('');
        $("#EfiProSLKLMass").val('');
        $("#EfiProSLKLMassTan").val('');
        $("#EfiProSLKLAmount").val('');
        $("#EfiProSLKLAmountUnitCode").val('');
        $("#EfiProSLKLMassUnitCode").val('');
        ttcVMSelf.EfiProSLKLMass(null);
        ttcVMSelf.EfiProSLKLMassTan(null);
        ttcVMSelf.EfiProSLKLAmount(null);
        ttcVMSelf.EfiProSLKLAmountUnitCode(null);
        ttcVMSelf.EfiProSLKLMassUnitCode(null);
    }
    ttcVMSelf.addThongTinChiTieuKL=function () {
        var chiTieuKL = [ttcVMSelf.EfiProSLKLMass, ttcVMSelf.EfiProSLKLMassTan, ttcVMSelf.EfiProSLKLAmount,ttcVMSelf.EfiProSLKLAmountUnitCode,ttcVMSelf.EfiProSLKLMassUnitCode];
        ttcVMSelf.errors = ko.validation.group(chiTieuKL, {deep: true, live: true, observable: true});
        if (!ttcVMSelf.validate()) return;
        var massName=ttcVMSelf.findNameByCatNote(ttcVMSelf.EfiProSLKLMassUnitCode());
        var amountName=ttcVMSelf.findNameByCatNote(ttcVMSelf.EfiProSLKLAmountUnitCode());
        var item = {
            fiProSLKLMass: ttcVMSelf.EfiProSLKLMass(),
            fiProSLKLMassTan:ttcVMSelf.EfiProSLKLMassTan(),
            fiProSLKLMassUnitName: massName,
            fiProSLKLMassUnitCode: ttcVMSelf.EfiProSLKLMassUnitCode(),
            fiProSLKLAmount: ttcVMSelf.EfiProSLKLAmount(),
            isEnable:ko.observable(false),
            isUpdate:ko.observable(false),
            lstDMDVT: ttcVMSelf.lstDMDVT(),
            lstDMDVTSL: ttcVMSelf.lstDMDVTSL(),
            fiProSLKLAmountUnitName: amountName,
            fiProSLKLAmountUnitCode: ttcVMSelf.EfiProSLKLAmountUnitCode()
        }
        item.fiProSLKLMass = ko.observable((item && item.hasOwnProperty('fiProSLKLMass')) ? item.fiProSLKLMass : null).extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
            number: {params: true},
            min: 0
        });
        item.fiProSLKLMassTan = ko.observable((item && item.hasOwnProperty('fiProSLKLMassTan')) ? item.fiProSLKLMassTan : null).extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
            number: {params: true},
            min: 0
        });
        item.fiProSLKLAmountUnitCode = ko.observable((item && item.hasOwnProperty('fiProSLKLAmountUnitCode')) ? item.fiProSLKLAmountUnitCode : null).extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
        });
        item.fiProSLKLAmount = ko.observable((item && item.hasOwnProperty('fiProSLKLAmount')) ? item.fiProSLKLAmount : null).extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]},
            number: {params: true},
            min: 0
        });
        item.fiProSLKLMassUnitCode = ko.observable((item && item.hasOwnProperty('fiProSLKLMassUnitCode')) ? item.fiProSLKLMassUnitCode : null).extend({
            required: {params: true, message: NSWLang["common_msg_formvaild_required"]}
        });
        ttcVMSelf.fiProSLKLList.push(item);
        ttcVMSelf.clearFormKL();
    }
    ttcVMSelf.validate = function () {
        if (ttcVMSelf.errors().length > 0) {
            ttcVMSelf.errors.showAllMessages();
            return false;
        }
        return true;
    }
    ttcVMSelf.openAddHangHoa=function(){
        // ttcVMSelf.isUpdateHangHoa(false);
        $("#modal_addAnimal").modal("show");
    }
    ttcVMSelf.closeHangHoa =function(){
        ttcVMSelf.clearForm();
    }
    ttcVMSelf.openUpdateProduct = function (data, index, type) {
        if(ttcVMSelf.isEditHS()=='1'||ttcVMSelf.isEditHS()==1){
            ko.utils.arrayForEach(data.fiProATList, function(at) {
                at.isEnable=ko.observable(false);
                at.isUpdate=ko.observable(false);
                at.lstChiTieuAT = ttcVMSelf.lstChiTieuAT();
            });
            ko.utils.arrayForEach(data.fiProCLList, function(cl) {
                cl.isEnable =ko.observable(false);
                cl.isUpdate =ko.observable(false);
                cl.lstChiTieuAT = ttcVMSelf.lstChiTieuAT();
            });
            ko.utils.arrayForEach(data.fiProSLKLList, function(kl) {
                kl.isEnable=ko.observable(false);
                kl.isUpdate=ko.observable(false);
                kl.lstDMDVT = ttcVMSelf.lstDMDVT();
                kl.lstDMDVTSL = ttcVMSelf.lstDMDVTSL();
            });
        }
        console.log(data);
        ttcVMSelf.fiProIdPhanNhomTemp(data.fiProIdPhanNhom);
        ttcVMSelf.fiProIdLoaiTemp(data.fiProIdLoai);
        ttcVMSelf.fiProIdPhanLoaiTemp(data.fiProIdLoai);
        ko.mapping.fromJS(data, {}, ttcVMSelf);
        ttcVMSelf.selectedIndex(index);
        ttcVMSelf.selectedHangHoa(data);
        if (type == '1' || type == 1) {
            $("#modal_addAnimal").modal("show");
        } else {
            $("#modal_addAnimal").modal("show");
        }
    }


    ttcVMSelf.removeProduct = function (index) {
        ttcVMSelf.fiProductList.splice(index, 1);
    }

    ttcVMSelf.removeListCL = function (index) {
        ttcVMSelf.fiProCLList.splice(index, 1);
    }

    ttcVMSelf.removeListAT = function (index) {
        ttcVMSelf.fiProATList.splice(index, 1);
    }

    ttcVMSelf.removeListSLKT = function (index) {
        ttcVMSelf.fiProSLKLList.splice(index, 1);
    }
    ttcVMSelf.findNameByCatNote = function(code){
        var pos = ttcVMSelf.lstDMDVT().find(function (e) {
            return e.fiCatNote == code;
        })
        if (pos)
            return pos.fiCatTypeName;
        else
            return code;
    }
    ttcVMSelf.findNameByCatNote2 = function(lst,code){
        var pos = lst.find(function (e) {
            return e.fiCatNote == code;
        })
        if (pos)
            return pos.fiCatTypeName;
        else
            return code;
    }
    ttcVMSelf.findCodeName = function(lst,code){
        var pos = lst.find(function (e) {
            return e.fiidcat == Number(code);
        })
        if (pos)
            return pos.fiCatTypeName;
        else
            return code;
    }
    ttcVMSelf.findCatNoteById = function(lst,code){
        var pos = lst.find(function (e) {
            return e.fiidcat == Number(code);
        })
        if (pos)
            return pos.fiCatNote;
        else
            return code;
    }
    ttcVMSelf.findCatIdByCatNote = function(lst,code){
        var pos = lst.find(function (e) {
            return e.fiCatNote == code;
        });
        if (pos)
            return pos.fiidcat;
        else
            return code;
    }
    ttcVMSelf.changeFileGDK =function (data, e) {
        var files = e.target.files;
        app.uploadFile({
            file: files[0],
            mcode: 'mard',
            pcode: '25',
            url: '/mard/25/upload',
            success: function (d) {
                if(d.success){
                    ttcVMSelf.fiLinkGDK(d.data.urlFile);
                    ttcVMSelf.fiFileIdGDK(d.data.itemId);
                    ttcVMSelf.fiFileNameGDK(files[0].name);
                }else{
                    app.Alert("Có lỗi tải file lên");
                }
            },
            error: function (e) {
                app.Alert("Có lỗi tải file lên");
            }
        });
    }
}