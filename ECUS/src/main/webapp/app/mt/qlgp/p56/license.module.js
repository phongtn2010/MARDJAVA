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
        $('.date-picker').datepicker({rtl: false, orientation: "left", autoclose: true});

        self.showActionError = ko.observable(false);
        self.showActionSuccess = ko.observable(false);
        self.errorMessage = ko.observable('');
        

        self.giayphep = new Tbdgiayphep();
        self.hoso = new Tbdhoso();

        self.getGiayPhep = function (id) {
            app.makeGet({
                url: '/mt/qlgp/56/xemgiayphep/' + id,
                success: function (d) {
                    $('#loading_c4e6a343-dd41-b5c5-1ef9-75eeebba032d').hide();
                    var msg = '';
                    var fun = 'success';
                    console.log(d);
                    if (d.success) {
                        console.log("seach ok");
                        self.giayphep = app.convertObjectToObservable(d.data, self.giayphep);
                        console.log(self.giayphep);
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
                    console.log(e);
                    toastr.error(e.message, NSWLang["common_msg_thong_bao"]);
                    self.showActionSuccess(false);
                    self.showActionError(true);
                    self.errorMessage(e.message);
                    $('html,body').scrollTop(0);
                }
            });
        }
        self.getHoSo = function (id) {
            app.makePost({
                url: '/mt/qlgp/56/call_service',
                data: JSON.stringify({
                    URL_BACKEND: "/mt/56/hoso/getByIdHoso",
                    METHOD: "POST",
                    REQUEST: {
                        "fiIdHoSo": id
                    }
                }),
                success: function (d) {
                    $('#loading_c4e6a343-dd41-b5c5-1ef9-75eeebba032d').hide();
                    var msg = '';
                    var fun = 'success';
                    console.log(d);
                    if (d.success) {
                        console.log("seach ok");
                        self.hoso = app.convertObjectToObservable(d.data[0], self.hoso);
                        console.log("a = "+self.hoso);
                        self.getGiayPhep(d.data[0].fiIdGiayPhep);
                    } else {
                        msg = data.message;
                        fun = 'error';
                    }
                },
                error: function (e) {
                    $('#loading_c4e6a343-dd41-b5c5-1ef9-75eeebba032d').hide();
                    console.log(e);
                    toastr.error(e.message, NSWLang["common_msg_thong_bao"]);
                    self.showActionSuccess(false);
                    self.showActionError(true);
                    self.errorMessage(e.message);
                    $('html,body').scrollTop(0);
                }
            });
        }
        if (giayPhepId) {
            self.getHoSo(giayPhepId);
        }





        self.dong = function () {
        	if(type==1){
        		location.href = app.appContext + '/mt/qlgp/56/home/'+  procedureId;
        	}else{
        		location.href = app.appContext + '/mt/qlgp/qlhs/home';
        	}
            
        }
    }

    var vm = new ViewModel();
    ko.applyBindings(vm);
});
