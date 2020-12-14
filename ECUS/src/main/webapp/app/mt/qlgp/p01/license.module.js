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

        self.giayphep = new Tbdgiayphep();

        self.getGiayPhep = function (id) {
            
            app.makeGet({

                url: '/mt/qlgp/01/xemgiayphep/' + id,
                success: function (d) {
                    $('#loading_c4e6a343-dd41-b5c5-1ef9-75eeebba032d').hide();
                    var msg = '';
                    var fun = 'success';
                    console.log(d);
                    if (d.success) {
                        console.log("seach ok");
                        self.pagingVM.totalCount(d.total);
                        self.totalData(d.total);
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

        if (giayPhepId) {
            self.getGiayPhep(giayPhepId);
        }

        self.dong = function () {
            location.href = app.appContext + '/mt/qlgp/01/home/'+  procedureId;
        }
    }

    var vm = new ViewModel();
    ko.applyBindings(vm);
});
