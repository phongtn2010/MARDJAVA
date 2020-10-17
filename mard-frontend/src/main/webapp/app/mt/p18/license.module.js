/**
 * @returns
 */
/**
 * @returns
 */
$(document).ready(function () {

    function ViewModel() {
        var self = this;
        self.contextPath = ko.observable($('#contextPath').val());
        self.totalData = ko.observable(0);
        self.pagingVM = new PagingVM({pageSize: 15, totalCount: 0});
        $('.date-picker').datepicker({rtl: false, orientation: "left", autoclose: true});

        self.showActionError = ko.observable(false);
        self.showActionSuccess = ko.observable(false);
        self.errorMessage = ko.observable('');

        self.danhsachgiayphep = ko.observableArray();
        self.listItem = ko.observableArray();                
        //KHAI BAO
        
        self.nameCQXL = ko.observable();
        
        self.Tbdgiayphep = new Tbdgiayphep();
        self.Tbdgiayphepgiahan = new Tbdgiayphepgiahan();
        self.Tbdgiayphepdinhkem = new Tbdgiayphepdinhkem();
        self.Tbdhoso = new Tbdhoso();
        self.searchModel = {
            fiIdGiayphep: ko.observable()

        };

        var Page = function(){
          this.currentPage = ko.observable(0);
            this.pageSize = ko.observable(10);
        }
        self.page = new Page();
        self.pagingVM = new PagingVM({pageSize: 10, totalCount: 0, currentPage : 1});

          self.danhsachgiayphep.removeAll();
          self.page.currentPage(self.pagingVM.currentPage());
            app.makePost({
                url: '/mt/18/call_service',
                data: JSON.stringify({
                    URL_BACKEND: "/mt/18/giayphep/license_detail/" + giayPhepId,
                    URL_GET_TOTAL:"/mt/18/giayphep/license_detail/getTotal/" + giayPhepId ,
                    METHOD: "POST",
                    REQUEST: app.convertFormObservableJson(self.page)
                }),
                success: function (d) {
                    $('#loading_c4e6a343-dd41-b5c5-1ef9-75eeebba032d').hide();
                    var msg = '';
                    var fun = 'success';
                    
                    if (d.success) {
                    	self.Tbdgiayphep = app.convertObjectToObservable(d.data[0], self.Tbdgiayphep) ;
                    	loadGiaHan(d.data[0].fiIdGiayphep);
                    	self.searchModel.fiIdGiayphep(d.data[0].fiIdGiayphep);
                    	loadTbdDinhKem(self.searchModel);
                    	loadThongtinDoanhNghiep(giayPhepId);

                    } else {
                        msg = d.message;
                        fun = 'error';
                    }
                    app.toast({
                        title: NSWLang["common_msg_thong_bao"],
                        message: msg,
                        function: fun
                    });
                },
                error: function (e) {
                    $('#loading_c4e6a343-dd41-b5c5-1ef9-75eeebba032d').hide();
                    
                    toastr.error(e.message, NSWLang["common_msg_thong_bao"]);
                    self.showActionSuccess(false);
                    self.showActionError(true);
                    self.errorMessage(e.message);
                    $('html,body').scrollTop(0);
                }
            });
        function loadGiaHan(id){
            app.makePost({
                url: '/mt/18/call_service',
                data: JSON.stringify({
                    URL_BACKEND: "/mt/18/giayPhepGiaHan/getById" ,
                    METHOD: "POST",
                    REQUEST:id
                }),
                success: function (d) {
                    $('#loading_c4e6a343-dd41-b5c5-1ef9-75eeebba032d').hide();
                    var msg = '';
                    var fun = 'success';
                    
                    if (d.success) {
                    	self.Tbdgiayphepgiahan = app.convertObjectToObservable(d.data, self.Tbdgiayphepgiahan) ;
                    	self.Tbdgiayphepgiahan.fiLoaiGiaHan(self.Tbdgiayphepgiahan.fiLoaiGiaHan().toString());
                    } else {
                        msg = d.message;
                        fun = 'error';
                    }
//                    app.toast({
//                        title: NSWLang["common_msg_thong_bao"],
//                        message: msg,
//                        function: fun
//                    });
                },
                error: function (e) {
                    $('#loading_c4e6a343-dd41-b5c5-1ef9-75eeebba032d').hide();
                    
                    toastr.error(e.message, NSWLang["common_msg_thong_bao"]);
                    self.showActionSuccess(false);
                    self.showActionError(true);
                    self.errorMessage(e.message);
                    $('html,body').scrollTop(0);
                }
            });
        }

        function loadTbdDinhKem(searchModel){

            app.makePost({
                url: '/mt/18/call_service',
                data: JSON.stringify({
                    URL_BACKEND: "/mt/18/giayphepdinhkem/search" ,
                    METHOD: "POST",
                    REQUEST: app.convertFormObservableJson(self.searchModel)
                }),
                success: function (d) {
                    $('#loading_c4e6a343-dd41-b5c5-1ef9-75eeebba032d').hide();
                    var msg = '';
                    var fun = 'success';
                   // 
                    if (d.success) {
                    	self.Tbdgiayphepdinhkem = app.convertObjectToObservable(d.data[0], self.Tbdgiayphepdinhkem) ;
                    } else {
                        msg = d.message;
                        fun = 'error';
                    }
//                    app.toast({
//                        title: NSWLang["common_msg_thong_bao"],
//                        message: msg,
//                        function: fun
//                    });
                },
                error: function (e) {
                    $('#loading_c4e6a343-dd41-b5c5-1ef9-75eeebba032d').hide();
                    
                    toastr.error(e.message, NSWLang["common_msg_thong_bao"]);
                    self.showActionSuccess(false);
                    self.showActionError(true);
                    self.errorMessage(e.message);
                    $('html,body').scrollTop(0);
                }
            }); 
        }
            
       
        function loadThongtinDoanhNghiep(id){
            app.makePost({
                url: '/mt/18/call_service',
                data: JSON.stringify({
                    URL_BACKEND: "/mt/18/hoso/getById" ,  
                    METHOD: "POST",
                    REQUEST:id
                }),
                success: function (d) {
                    $('#loading_c4e6a343-dd41-b5c5-1ef9-75eeebba032d').hide();
                    var msg = '';
                    var fun = 'success';
                    
                    if (d.success) {
                    	self.Tbdhoso = app.convertObjectToObservable(d.data, self.Tbdhoso) ;                       	
                    	loadTenCQXL(d.data.fiIdBophan);
                    	
                    } else {
                        msg = d.message;
                        fun = 'error';
                    }
//                    app.toast({
//                        title: NSWLang["common_msg_thong_bao"],
//                        message: msg,
//                        function: fun
//                    });
                },
                error: function (e) {
                    $('#loading_c4e6a343-dd41-b5c5-1ef9-75eeebba032d').hide();
                    
                    toastr.error(e.message, NSWLang["common_msg_thong_bao"]);
                    self.showActionSuccess(false);
                    self.showActionError(true);
                    self.errorMessage(e.message);
                    $('html,body').scrollTop(0);
                }
            }); 
        }
        function loadTenCQXL(id_cqxl){
        	
            app.makePost({
                url: '/mt/18/call_service',
                data: JSON.stringify({
                    URL_BACKEND: "/mt/danhmuc/cqxl/getById" ,  
                    METHOD: "POST",
                    REQUEST:id_cqxl
                }),
                success: function (d) {
                    $('#loading_c4e6a343-dd41-b5c5-1ef9-75eeebba032d').hide();
                    var msg = '';
                    var fun = 'success';
                    
                    if (d.success) {
                    	self.nameCQXL(d.data.fiTenCqxl);
                    	//self.nameCQXL = d.data.fiTenCqxl;   
                    	//self.nameCQXL = app.convertObjectToObservable(d.data, self.nameCQXL) ;   
                    } else {
                        msg = d.message;
                        fun = 'error';
                    }
//                    app.toast({
//                        title: NSWLang["common_msg_thong_bao"],
//                        message: msg,
//                        function: fun
//                    });
                },
                error: function (e) {
                    $('#loading_c4e6a343-dd41-b5c5-1ef9-75eeebba032d').hide();
                    
                    toastr.error(e.message, NSWLang["common_msg_thong_bao"]);
                    self.showActionSuccess(false);
                    self.showActionError(true);
                    self.errorMessage(e.message);
                    $('html,body').scrollTop(0);
                }
            }); 
        }
       
            
        
        self.dong = function () {
        
//        	//thêm vào
//        	location.href = app.appContext + '/mt/18/home/'+  procedureId;
//        	
        	
        	if(type==1){
        		location.href = app.appContext + '/mt/18/home/'+  procedureId;
        	}else{
        		location.href = app.appContext + '/mt/qlhs/home';
        	}
            
        }
    }

    var vm = new ViewModel();
    $("#listLicense :input").prop("disabled", true);
    ko.applyBindings(vm);
});
