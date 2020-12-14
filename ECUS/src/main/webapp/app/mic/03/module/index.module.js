/**
 * @returns
 */
/**
 * @returns
 */
$(document).ready(function () {
    function ViewModel() {

        var self = this;

        self.showActionSuccess = ko.observable(false);
        self.errorMessage = ko.observable('');

        self.contextPath = ko.observable($('#contextPath').val());

        $(".select2").select2({placeholder: '', width: '100%'});

        $('.date-picker').datepicker({rtl: false, orientation: "left", autoclose: true});

        var pathURL = '';


        //xem giay xac nhan
        self.xemGiayXacNhanClick = function (item) {
            var gxn = new PopupViewGP();
            gxn.show(item);
        }

        //yeu cau rut ho so
        self.huyHoSo = function (item) {
            var view = new HuyHoSoView();
            view.show(item, function () {
                setTimeout(function () {
                    location.reload();
                }, 1000);
            });
        }

        self.xemChiTietHoSo = function (item) {
            location.href = app.appContext + '/mic/03/view/' + item.fiIdHoSo();
        }

        self.xinSua = function (item) {
            item.xinSua = ko.observable(1);
            location.href = app.appContext + '/mic/03/ycs/' + item.fiIdHoSo();

        }


        // danh sach ho so
        var loadHoSo = new LoadHoSoView(this);

        // xoa ho so
        self.xoaHoSo = function (item) {
            var xoaHoSoView = new XoaHoSoView();
            xoaHoSoView.show(item, function () {
                setTimeout(function () {
                    location.reload();
                }, 1000);
            });
        }


        self.themMoiHoSo = function () {

            location.href = app.appContext + '/mic/03/edit';

        }
        self.reset = function () {
            self.searchForm.fiDocumentName('');
            self.searchForm.fromFiSendDate('');
        }


        self.chinhSuaHoSo = function (item) {

            location.href = app.appContext + '/mic/03/edit/' + item.fiIdHoSo();

        }

        self.xemHoSo = function (item) {
            var viewPopup = new PopupView();
            viewPopup.show(item);
        }
        self.thongBaoPhi = function (item) {
            var view = new ThongBaoPhiView();
            view.show(item);
        }
        // ket qua xu ly
        self.xemLichSu = function (item) {
            var history = new HistoryView();
            history.show(item);
        }

        self.toDate = function (dateStr) {
            var splits = dateStr.split("/");
            var day = splits[0];
            var month = splits[1];
            var year = splits[2];
            return new Date(year, month - 1, day);
        }

    }

  //  ko.validation.locale(locale);

    var vm = new ViewModel();
    ko.applyBindings(vm, document.getElementById("index"));
});
