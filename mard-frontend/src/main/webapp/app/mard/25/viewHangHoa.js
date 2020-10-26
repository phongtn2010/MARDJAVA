function Mard25ViewHangHoaVM () {
    var self=this;
    self.fiHSCode = ko.observable(null);
    self.fiHSStatus = ko.observable(null);
    self.mard25HangHoaItems  = ko.observableArray([]);

    self.getThongTinHangHoa =function() {
        $('#loading08').show();
        $.ajax({
            async: true,
            type: 'GET',
            cache: false,
            crossDomain: true,
            url: app.appContext + '/mard/25/hanghoa/find/' + idHoSo,
            beforeSend: function (xhr) {
                xhr.setRequestHeader(CSRF_TOKEN_NAME, CSRF_TOKEN_VALUE);
            },
            success: function (res) {
                console.log(res.data);
                self.mard25HangHoaItems(res.data);
                console.log(self.mard25HangHoaItems);
                $('#loading08').hide();
            },
            error: function (x, t, m) {
                $('#loading08').hide();
            },
        })
    }
}


$(document).ready(function () {
    var mard25ViewHangHoaVM = new Mard25ViewHangHoaVM();
    ko.applyBindings(mard25ViewHangHoaVM, document.getElementById('mardHangHoa25'));
    mard25ViewHangHoaVM.getThongTinHangHoa();
})
