/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* global app, Storage, CHO_TIEP_NHAN, DA_GUI_THONG_BAO_AP_PHI, CSRF_TOKEN_NAME, CSRF_TOKEN_VALUE, DA_YC_NOP_BS_PHI, RAW_HS_STATUS, DA_XAC_NHAN_DON_KHAI_BAO_KD, BI_TU_CHOI, YEU_CAU_BO_SUNG, TU_CHOI_YC_XIN_RUT, TU_CHOI_YCCS, THONG_BAO_XU_LY_LO_HANG, TU_CHOI_YC_CS_GCN, QUYET_DINH_XU_LY_VSTY, GCN_14A, GCN_14B, GCN_15A, GCN_15B, GCN_15C, History */
ko.validation.rules.pattern.message = 'Invalid.';
ko.validation.init({
    registerExtenders: true,
    messagesOnModified: true,
    insertMessages: true,
    parseInputAttributes: true,
    messageTemplate: null
}, true);

var PaymentVM = function(options){
    var vmSelf = this;
    vmSelf.fiSotienCk = ko.observable(null).extend({
        required : {message : 'Phải nhập', params : true},
        number: { message: 'Phải nhập số', params : true},
        pattern: {
            message: 'Phải nhập giá trị với tối đa 3 số ở phần thập phân ví dụ: 10000.234',
            params: '^[0-9]{0,15}(?:\.[0-9]{0,3})?$'
        }
    });
    vmSelf.fiNdSotien = ko.observable(null).extend({
        required : {message : 'Phải nhập', params : true},
        maxLength: { message: '250 ký tự', params : 250}
    });
    vmSelf.fiNguoinop = ko.observable(null).extend({
        required : {message : 'Phải nhập', params : true},
        maxLength: { message: '250 ký tự', params : 250}
    });
    vmSelf.fiNgaynop = ko.observable(null).extend({
        required : {message : 'Phải nhập', params : true}
    });
    vmSelf.fiSohoadon = ko.observable(null).extend({
        maxLength: { message: '250 ký tự', params : 250}
    });
    vmSelf.fiChuthich = ko.observable(null).extend({
        maxLength: { message: '500 ký tự', params : 500}
    });
    vmSelf.fiMaLoai = ko.observable(4);
    vmSelf.fiTenTep = ko.observable(null);
    vmSelf.formData = null;
    vmSelf.fileUpload = function(data, e){
        var files = e.target.files;
        if(!files || files.length <= 0){
            return;
        }
        vmSelf.formData = new FormData();
        vmSelf.formData.append('file', files[0]);
        vmSelf.fiTenTep(files[0].name);
    };
    vmSelf.fullFormData = function(){
        if(vmSelf.paymentErrors().length > 0){
            vmSelf.paymentErrors.showAllMessages();
            return;
        }
        if(!vmSelf.formData){
            vmSelf.formData = new FormData();
        }
        vmSelf.formData.append("fiSotienCk", vmSelf.fiSotienCk());
        vmSelf.formData.append("fiNdSotien", vmSelf.fiNdSotien());
        vmSelf.formData.append("fiNguoinop", vmSelf.fiNguoinop());
        vmSelf.formData.append("fiNgaynop", vmSelf.fiNgaynop());
        vmSelf.formData.append("fiSohoadon", vmSelf.fiSohoadon());
        vmSelf.formData.append("fiChuthich", vmSelf.fiChuthich());
        vmSelf.formData.append("fiMaLoai", vmSelf.fiMaLoai());
        vmSelf.formData.append("fiIdHoso", options.fiIdHoso());
        vmSelf.formData.append("fiMaHoso", options.fiMaHoso());
        return vmSelf.formData;
    };
    var paymentVG = [vmSelf.fiSotienCk, vmSelf.fiNdSotien, vmSelf.fiNguoinop, vmSelf.fiNgaynop];
    vmSelf.paymentErrors = ko.validation.group(paymentVG, { deep: true, live: true, observable: true });
};
var MAX_PAGE_SIZE = 10;
function Mard10VM()
{
    self = this;
    self.fiTrangthai = ko.observable(null);
    self.fiTrangthaiList = ko.observableArray([]);
    self.fiMaDvkdList = ko.observableArray([]);
    self.fiMaHoso = ko.observable(null);
    self.fromFiNgaytao = ko.observable(null);
    self.toFiNgaytao = ko.observable(null);
    self.fiTenHanghoa = ko.observable(null);
    self.fiMaDvkd = ko.observable(null);
    //self.fiTenDvkd = ko.observable(null);
    self.mard10Items = ko.observableArray([]);
    self.totalCount = ko.observable(0);
    
    self.pageSize = ko.observable(MAX_PAGE_SIZE);
    self.paging = ko.observable(new PagingVM({
        pageSize: self.pageSize(),
        totalCount: 0
    }));

/**
 * Ấn nút chuyển trang
 * @param {type} newCurrentPage Trang mới
 */
    self.currentPageSubscription = self.paging().currentPage.subscribe(function (newCurrentPage) {
        if(window.stateChanging){
           return; 
        }
        self.search(newCurrentPage, true);
    });
    
    /**
     * Trường tìm kiếm thay đổi
     * @returns {undefined}
     */
    self.searchFieldEnter = function(){
        self.search(1, true);
    };
    
    /**
     * Đưa dữ liệu từ url xuống form tìm kiếm
     * @param {type} data
     * @returns {undefined}
     */
    self.applyState = function(data){
        if(!data){
            self.search(1, false);
        }
        else{
            self.fiTrangthai(data.fiTrangthai);
            self.fiMaHoso(data.fiMaHoso);
            self.fromFiNgaytao(data.fromFiNgaytao ? new Date(data.fromFiNgaytao) : null);
            self.toFiNgaytao(data.toFiNgaytao ? new Date(data.toFiNgaytao) : null);
            self.fiTenHanghoa(data.fiTenHanghoa);
            self.fiMaDvkd(data.fiMaDvkd);
            self.search(data.page ? data.page - 0 : 1, false);
        }
    };
    
    /**
     * Tải danh mục + tìm kiếm hồ sơ
     * @param {type} page
     * @param {type} pushState
     * @returns {undefined}
     */
    self.search = function (page, pushState) {
        if(!RAW_HS_STATUS || RAW_HS_STATUS.length <= 0){
            $.when(
                getCategory("HS_STATUS", null, function(res){
                    if(res.success){
                        RAW_HS_STATUS = res.data;
                        self.fiTrangthaiList(mapCategory(RAW_HS_STATUS));
                    }
                }), 
                getCategory("DVKD", null, function(res){
                    if(res.success){
                        self.fiMaDvkdList(mapCategory(res.data, "dvkdCode", "dvkdName"));
                    }
                })
            ).done(function ( data ) {
                self.searchAfterHasCatgory(page, pushState);
            });
        }
        else{
            self.searchAfterHasCatgory(page, pushState);
        }
        
    };
    /**
     * Tìm kiếm hồ sơ sau khi có danh mục
     * @param {type} page
     * @param {type} pushState
     * @returns {undefined}
     */
    self.searchAfterHasCatgory = function(page, pushState){
        // Tim kiem va update lai page
        page = page ? page : self.paging().currentPage();
        var data = {
            fiTrangthai : self.fiTrangthai(),
            fiMaHoso : self.fiMaHoso(),
            fiTenHanghoa : self.fiTenHanghoa(),
            //fiTenDvkd : self.fiTenDvkd(),
            fiMaDvkd : self.fiMaDvkd(),
            fromFiNgaytao : self.fromFiNgaytao(),
            toFiNgaytao : self.toFiNgaytao(),
            start : self.pageSize() * (page - 1) < 0 ? 0 : self.pageSize() * (page - 1),
            count : self.pageSize(),
            page : self.paging().currentPage()
        };
        $.ajax({
            async: true,
            type: 'POST',
            cache: false,
            crossDomain: true,
            url: app.appContext + "/mard/10/hoso/timkiem",
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            beforeSend: function (xhr) {
                xhr.setRequestHeader(CSRF_TOKEN_NAME, CSRF_TOKEN_VALUE);
                $('#loading10').show();
            },
            success: function (res) {
                if(res.success){
                    self.mard10Items([]);
                    var list = res.data ? mapTbdhoso10(res.data.data) : [];
                    self.mard10Items(list);
                    self.paging().update({
                        totalCount : res.data ? res.data.total : 0,
                        pageSize : self.pageSize(),
                        currentPage : page
                    });
                    self.totalCount(res.data? res.data.total : 0);
                    if(pushState){
                        self.pushState(data);
                    }
                }
            },
            error: function (x, t, m) {
                // log
            },
            complete: function (jqXHR, textStatus) {
                $('#loading10').hide();
                window.stateChanging = false;
            }
        });
    };
    /**
     * Đưa dữ liệu vào state
     * @param {type} data
     * @returns {undefined}
     */
    self.pushState = function(data){
        if(data.fromFiNgaytao){
            data.fromFiNgaytao = data.fromFiNgaytao.getTime();
        }
        if(data.toFiNgaytao){
            data.toFiNgaytao = data.toFiNgaytao.getTime();
        }
        delete data.start;
        window.stateChangeIsLocal = true;
        History.pushState(data, document.title, "?" + app.serializeQuerystring(data));
    };
    /**
     * Tìm kiếm hồ sơ
     * @returns {undefined}
     */
    self.searchHoSoClick = function(){
        self.search(1, true);
    };
    /**
     * Chuyển trang tạo mới hồ sơ
     * @param {type} e
     * @returns {Boolean}
     */
    self.btnAddNewClick = function(e){
        document.location = app.appContext + '/mard/10/create';
        return false;
    };

    self.dispose = function () {
        self.currentPageSubscription.dispose();
    };
    /**
     * Xem hồ sơ
     * @param {type} item
     * @param {type} e
     * @returns {Boolean}
     */
    self.bXemClick = function(item, e) {
        document.location = app.appContext + '/mard/10/view?fiIdHoso=' + item.fiIdHoso() ;
        return false;
    };
    /**
     * Sửa hồ sơ
     * @param {type} item
     * @param {type} e
     * @returns {Boolean}
     */
    self.bSuaClick = function(item, e) {
        document.location = app.appContext + '/mard/10/create?fiIdHoso=' + item.fiIdHoso() ;
        return false;
    };
    /**
     * Xin sửa hồ sơ (chuyển sang trang sửa)
     * @param {type} item
     * @param {type} e
     * @returns {Boolean}
     */
    self.bXinSuaClick = function(item, e) {
        document.location = app.appContext + '/mard/10/create?edit=true&fiIdHoso=' + item.fiIdHoso();
        return false;
    };
    /**
     * Hủy hồ sơ (xóa)
     * @param {type} item
     * @param {type} e
     * @returns {undefined}
     */
    self.bHuyClick = function(item, e) {
        if(confirm('Bạn có muốn hủy hồ sơ: ' + item.fiMaHoso())){
            $.ajax({
                async: true,
                type: 'POST',
                cache: false,
                crossDomain: true,
                url: app.appContext + "/mard/10/hoso/xoa/" + item.fiIdHoso(),
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                beforeSend: function (xhr) {
                    xhr.setRequestHeader(CSRF_TOKEN_NAME, CSRF_TOKEN_VALUE);
                    $('#loading10').show();
                },
                success: function (res) {
                    // //console.log("res -> ", res);
                    if(res.success){
                        alert('Hủy hồ sơ: ' + item.fiMaHoso() + ' thành công.');
                        self.search(self.paging().currentPage());
                    }
                },
                error: function (x, t, m) {
                },
                complete: function (jqXHR, textStatus) {
                    $('#loading10').hide();
                }
            });
        }
    };
    /**
     * Gửi yêu cầu xin hủy
     * @param {type} item
     * @param {type} e
     * @returns {undefined}
     */
    self.bXinHuyClick = function(item, e) {
        var html = [
            $('#cancel-template').html()
        ].join('');
        self. pop = app.popup({
            title: 'Xin hủy hồ sơ: ' + item.fiMaHoso(),
            html: html,
            width: 650,
            buttons: [
                {
                    name: 'Gửi',
                    class: 'btn',
                    icon: 'fa-check',
                    action: function () {
                        var val = $('#fiLydo').val();
                        if(!val || val == ""){
                            alert('Phải nhập lý do hủy');
                            return;
                        }
                        var data = {
                            fiIdHoso : item.fiIdHoso(),
                            fiMaHoso : item.fiMaHoso(),
                            fiLydo : val
                        };
                        data = JSON.stringify(data);
                        $.ajax({
                            async: true,
                            type: 'POST',
                            cache: false,
                            crossDomain: true,
                            url: app.appContext + "/mard/10/hoso/yc-huy",
                            data: data,
                            contentType: "application/json; charset=utf-8",
                            dataType: "json",
                            beforeSend: function (xhr) {
                                xhr.setRequestHeader(CSRF_TOKEN_NAME, CSRF_TOKEN_VALUE);
                                $('#loading10').show();
                            },
                            success: function (res) {
                                if(res && res.success){
                                    // 11 - 04, chua tiep nhan
                                    // 14 - 09, da tiep nhan
                                    if(CHO_TIEP_NHAN == item.fiTrangthai()){
                                        self.guiYcXuly({
                                            type : "11",
                                            "function" : "04",
                                            fiIdHoso : item.fiIdHoso(),
                                            fiMaHoso : item.fiMaHoso(),
                                            reason :val
                                        });
                                    }
                                    else{
                                        self.guiYcXuly({
                                            type : "14",
                                            "function" : "09",
                                            fiIdHoso : item.fiIdHoso(),
                                            fiMaHoso : item.fiMaHoso(),
                                            reason :val
                                        });
                                    }
                                }
                                else{
                                    $('#loading10').hide();
                                }
                            },
                            error: function (x, t, m) {
                                $('#loading10').hide();
                            },
                            complete: function (jqXHR, textStatus) {
                                app.popupRemove(self.pop.selector);
                                $('.modal-scrollable').hide();
                                $('.modal-backdrop').hide();
                            }
                        });
                    }
                }
            ]
        });
    };
    
    /**
     * Thông báo chuyển khoản khi ấn vào grid
     * @param {type} item
     * @param {type} e
     * @returns {undefined}
     */
    self.bThongBaoCKClick = function(item, e) {
        var html = [
            $('#payment-template').html()
        ].join('');
        self.pop = app.popup({
            title: 'Thông báo chuyển khoản',
            html: html,
            width: 650,
            buttons: [
                {
                    name: 'Gửi',
                    class: 'btn',
                    icon: 'fa-check',
                    action: function(){
                        if(!self.paymentVM){
                            return;
                        }
                        var formData = self.paymentVM.fullFormData();
                        if(!formData){
                            return;
                        }
                        $.ajax({
                            type: 'POST',
                            cache: false,
                            crossDomain: true,
                            url: app.appContext + '/mard/10/hoso/tb-thanhtoan',
                            data: formData,
                            contentType: false,
                            processData: false,
                            beforeSend: function (xhr) {
                                xhr.setRequestHeader(CSRF_TOKEN_NAME, CSRF_TOKEN_VALUE);
                                $('#loading10').show();
                            },
                            success: function (res) {
                                if(res && res.success){
                                    //self.guiYcXuly({
                                        res.data.type = "19";
                                        res.data.function = "16";
                                        res.data.fiIdHoso = item.fiIdHoso();
                                        res.data.fiMaHoso = item.fiMaHoso();
                                        res.data.attachment = res.data.dinhkem10;
                                        delete res.data.dinhkem10;
                                    //});
                                    self.guiYcPhi(res.data);
                                }
                                else{
                                    $('#loading10').hide();
                                }
                            },
                            error: function (x, t, m) {
                                self.clearForm();
                                $('#loading10').hide();
                            },
                            complete: function (jqXHR, textStatus) {
                                //$('#loading10').hide();
                                app.popupRemove(self.pop.selector);
                                $('.modal-scrollable').hide();
                                $('.modal-backdrop').hide();
                            }
                        });
                    }
                }
            ]
        });
        self.paymentVM = new PaymentVM(item);
        ko.applyBindings(self.paymentVM, document.getElementById('payment-form'));
    };
    /**
     * Yêu cầu xin sửa giấy chứng nhận
     * @param {type} item
     * @param {type} e
     * @returns {undefined}
     */
    self.bXinSuaGCNClick = function(item, e) {
        var html = [
            $('#gcn-template').html()
        ].join('');
        self.pop = app.popup({
            title: 'Xin sửa giấy chứng nhận hồ sơ: ' + item.fiMaHoso(),
            html: html,
            width: 650,
            buttons: [
                {
                    name: 'Gửi',
                    class: 'btn',
                    icon: 'fa-check',
                    action: function(){
                        var val = $('#fiLydo').val();
                        if(!val || val == ""){
                            alert('Phải nhập: Nội dung xin chỉnh sửa giấy Chứng nhận');
                            return;
                        }
                        var data = {
                            fiIdHoso : item.fiIdHoso(),
                            fiMaHoso : item.fiMaHoso(),
                            fiLydo : val,
                            fiLoaiGcn : $('#fiLoaiGcn1').val()
                        };
                        $.ajax({
                            type: 'POST',
                            cache: false,
                            crossDomain: true,
                            url: app.appContext + '/mard/10/hoso/yc-gcn',
                            data: JSON.stringify(data),
                            contentType: "application/json; charset=utf-8",
                            dataType: "json",
                            beforeSend: function (xhr) {
                                xhr.setRequestHeader(CSRF_TOKEN_NAME, CSRF_TOKEN_VALUE);
                                $('#loading10').show();
                            },
                            success: function (res) {
                                //console.log("res -> ", res);
                                if(res && res.success){
                                    var message = {
                                        type : "28",
                                        "function" : "31",
                                        fiIdHoso : item.fiIdHoso(),
                                        fiMaHoso : item.fiMaHoso(),
                                        reason : val,
                                        cerType : $('#fiLoaiGcn1').val() - 0
                                    };
                                    self.guiYcXuly(message);
                                }
                                else{
                                    $('#loading10').hide();
                                }

                            },
                            error: function (x, t, m) {
                                self.clearForm();
                                $('#loading10').hide();
                            },
                            complete: function (jqXHR, textStatus) {
                                //$('#loading10').hide();
                            }
                        });
                    }
                }
            ]
        });
    };
    self.createPopFiTrangThai = function(template, item){
        var html = [
            $('#' + template).html()
        ].join('');
        self.pop = app.popup({
            title: item.fiTenTrangthai(),
            html: html,
            width: 650,
            buttons: [
                {
                    name: 'Đóng',
                    class: 'btn',
                    icon: 'fa-check',
                    action: function(){
                        app.popupRemove(self.pop.selector);
                        $('.modal-scrollable').hide();
                        $('.modal-backdrop').hide();
                    }
                }
            ]
        });
        return self.pop;
    };
    /**
     * Từ trạng thái hồ sơ, hiển thị ra các thông tin khác (như thông báo phí, y/c bổ sung)
     * @param {type} item
     * @param {type} e
     * @returns {undefined}
     */
    self.fiTrangThaiClick = function(item, e) {
        switch (item.fiTrangthai()){
            case  QUYET_DINH_XU_LY_VSTY:
            case  GCN_14A:
            case  GCN_14B:
            case  GCN_15A:
            case  GCN_15B:
            case  GCN_15C:
                document.location = app.appContext + '/mard/10/view?fiIdHoso=' + item.fiIdHoso() + "&tab=mau";
                break;
            case TU_CHOI_YC_CS_GCN:
                self.createPopFiTrangThai('kqxinsuagcn-template',item);
                $.ajax({
                    type: 'POST',
                    cache: false,
                    crossDomain: true,
                    url: app.appContext + '/mard/10/hoso/kqxinsuagcn/' + item.fiMaHoso(),
                    contentType: "application/json; charset=utf-8",
                    dataType: "json",
                    beforeSend: function (xhr) {
                        xhr.setRequestHeader(CSRF_TOKEN_NAME, CSRF_TOKEN_VALUE);
                        $('#loading10').show();
                    },
                    success: function (res) {
                        if(res && res.success){
                            var KqxinsuagcnVM = function(options){
                                if(options){
                                    ko.mapping.fromJS(options, {}, this);
                                }
                            };
                            ko.applyBindings(new KqxinsuagcnVM(res.data), document.getElementById('kqxinsuagcn-form'));
                        }

                    },
                    error: function (x, t, m) {
                        self.clearForm();
                    },
                    complete: function (jqXHR, textStatus) {
                        $('#loading10').hide();
                    }
                });
            break;
            case THONG_BAO_XU_LY_LO_HANG:
                self.createPopFiTrangThai('lohangxl-template',item);
                $.ajax({
                    type: 'POST',
                    cache: false,
                    crossDomain: true,
                    url: app.appContext + '/mard/10/hoso/lohangxl/' + item.fiMaHoso(),
                    contentType: "application/json; charset=utf-8",
                    dataType: "json",
                    beforeSend: function (xhr) {
                        xhr.setRequestHeader(CSRF_TOKEN_NAME, CSRF_TOKEN_VALUE);
                        $('#loading10').show();
                    },
                    success: function (res) {
                        if(res && res.success){
                            var LohangXlVM = function(options){
                                if(options){
                                    ko.mapping.fromJS(options, {}, this);
                                }
                            };
                            ko.applyBindings(new LohangXlVM(res.data), document.getElementById('lohangxl-form'));
                        }

                    },
                    error: function (x, t, m) {
                        self.clearForm();
                    },
                    complete: function (jqXHR, textStatus) {
                        $('#loading10').hide();
                    }
                });
                break;
            case TU_CHOI_YCCS:
                self.createPopFiTrangThai('kqxinsua-template',item);
                $.ajax({
                    type: 'POST',
                    cache: false,
                    crossDomain: true,
                    url: app.appContext + '/mard/10/hoso/kqxinsua/' + item.fiMaHoso(),
                    contentType: "application/json; charset=utf-8",
                    dataType: "json",
                    beforeSend: function (xhr) {
                        xhr.setRequestHeader(CSRF_TOKEN_NAME, CSRF_TOKEN_VALUE);
                        $('#loading10').show();
                    },
                    success: function (res) {
                        if(res && res.success){
                            var KqxinsuaVM = function(options){
                                if(options){
                                    ko.mapping.fromJS(options, {}, this);
                                }
                            };
                            ko.applyBindings(new KqxinsuaVM(res.data), document.getElementById('kqxinsua-form'));
                        }

                    },
                    error: function (x, t, m) {
                        self.clearForm();
                    },
                    complete: function (jqXHR, textStatus) {
                        $('#loading10').hide();
                    }
                });
                break;
            //case DONG_Y_YC_XIN_RUT:
            case TU_CHOI_YC_XIN_RUT:
                self.createPopFiTrangThai('kqxinrut-template',item);
                $.ajax({
                    type: 'POST',
                    cache: false,
                    crossDomain: true,
                    url: app.appContext + '/mard/10/hoso/kqxinrut/' + item.fiMaHoso(),
                    contentType: "application/json; charset=utf-8",
                    dataType: "json",
                    beforeSend: function (xhr) {
                        xhr.setRequestHeader(CSRF_TOKEN_NAME, CSRF_TOKEN_VALUE);
                        $('#loading10').show();
                    },
                    success: function (res) {
                        if(res && res.success){
                            var KqxinrutVM = function(options){
                                if(options){
                                    ko.mapping.fromJS(options, {}, this);
                                }
                            };
                            ko.applyBindings(new KqxinrutVM(res.data), document.getElementById('kqxinrut-form'));
                        }

                    },
                    error: function (x, t, m) {
                        self.clearForm();
                    },
                    complete: function (jqXHR, textStatus) {
                        $('#loading10').hide();
                    }
                });
            break;
            case DA_XAC_NHAN_DON_KHAI_BAO_KD:
                self.createPopFiTrangThai('xacnhan-template',item);
                ko.applyBindings(item, document.getElementById('xacnhan-form'));
            break;
            case BI_TU_CHOI:
            case YEU_CAU_BO_SUNG:
                self.createPopFiTrangThai('kqtd-template',item);
                
                $.ajax({
                    type: 'POST',
                    cache: false,
                    crossDomain: true,
                    url: app.appContext + '/mard/10/hoso/kqtd/' + item.fiMaHoso(),
                    contentType: "application/json; charset=utf-8",
                    dataType: "json",
                    beforeSend: function (xhr) {
                        xhr.setRequestHeader(CSRF_TOKEN_NAME, CSRF_TOKEN_VALUE);
                        $('#loading10').show();
                    },
                    success: function (res) {
                        if(res && res.success){
                            var KqtdVM = function(options){
                                if(options){
                                    ko.mapping.fromJS(options, {}, this);
                                }
                            };
                            ko.applyBindings(new KqtdVM(res.data), document.getElementById('kqtd-form'));
                        }

                    },
                    error: function (x, t, m) {
                        self.clearForm();
                    },
                    complete: function (jqXHR, textStatus) {
                        $('#loading10').hide();
                    }
                });
                break;
            case DA_YC_NOP_BS_PHI:
            case DA_GUI_THONG_BAO_AP_PHI:
                self.createPopFiTrangThai('alert-payment-template',item);
                
                $.ajax({
                    type: 'POST',
                    cache: false,
                    crossDomain: true,
                    url: app.appContext + '/mard/10/hoso/tbphi/' + item.fiMaHoso(),
                    contentType: "application/json; charset=utf-8",
                    dataType: "json",
                    beforeSend: function (xhr) {
                        xhr.setRequestHeader(CSRF_TOKEN_NAME, CSRF_TOKEN_VALUE);
                        $('#loading10').show();
                    },
                    success: function (res) {
                        //console.log("res -> ", res);
                        if(res && res.success){
                            var TbPhiVM = function(options){
                                if(options){
                                    ko.mapping.fromJS(options, {}, this);
                                }
                                this.fiLoaiphiText = ko.dependentObservable(function(){
                                    if(this.fiLoaiphi){
                                        if(this.fiLoaiphi() == 1){
                                            return "Bổ sung";
                                        }
                                        return "Thường";
                                    }
                                }, this);
                            };
                            ko.applyBindings(new TbPhiVM(res.data), document.getElementById('alert-payment-form'));
                        }

                    },
                    error: function (x, t, m) {
                        self.clearForm();
                    },
                    complete: function (jqXHR, textStatus) {
                        $('#loading10').hide();
                    }
                });
                break;
            default:
                alert("Hồ sơ đang ở trạng thái: " + $(e.target).text());
                break;
        };
    };
    
    /**
     * Gửi yêu cầu xử lý nghiệp vụ
     * @param {type} message
     * @param {type} message
     * @returns {undefined}
     */
    self.guiYcPhi = function(message){
        $.ajax({
            type: 'POST',
            cache: false,
            crossDomain: true,
            url: app.appContext + '/mard/10/hoso/fee',
            data: JSON.stringify(message),
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            beforeSend: function (xhr) {
                xhr.setRequestHeader(CSRF_TOKEN_NAME, CSRF_TOKEN_VALUE);
                $('#loading10').show();
            },
            success: function (res) {
                //console.log("res -> ", res);
                if(res && res.success){
                    alert('Đã gửi yêu cầu thành công');
                    self.search(self.paging().currentPage());
                }
                else{
                    alert('Đã gửi yêu cầu không thành công');
                }
            },
            error: function (x, t, m) {
                self.clearForm();
            },
            complete: function (jqXHR, textStatus) {
                $('#loading10').hide();
            }
        });
    };
    self.guiYcXuly = function(message){
        $.ajax({
            type: 'POST',
            cache: false,
            crossDomain: true,
            url: app.appContext + '/mard/10/hoso/xuly',
            data: JSON.stringify(message),
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            beforeSend: function (xhr) {
                xhr.setRequestHeader(CSRF_TOKEN_NAME, CSRF_TOKEN_VALUE);
                $('#loading10').show();
            },
            success: function (res) {
                //console.log("res -> ", res);
                if(res && res.success){
                    alert('Đã gửi yêu cầu thành công');
                    self.search(self.paging().currentPage());
                }
                else{
                    alert('Đã gửi yêu cầu không thành công');
                }
            },
            error: function (x, t, m) {
                self.clearForm();
            },
            complete : function(){
                $('#loading10').hide();
            }
        });
    };
    
    self.clearForm = function(){
        
    };
};

$(document).ready(function(){
    var vm = new Mard10VM();
    ko.applyBindings(vm, document.getElementById('mard10'));
    vm.applyState(app.parseQuerystring());
    window.stateChangeIsLocal = false;
    window.stateChanging = true;
    (function(window, undefined){
        History.Adapter.bind(window,'statechange',function(){
            var state = History.getState(); 
            if (state.data && !window.stateChangeIsLocal) {
                window.stateChanging = true;
                vm.applyState(state.data);
            }
            else{
                window.stateChangeIsLocal = false;
            }
        });
    })(window);
});