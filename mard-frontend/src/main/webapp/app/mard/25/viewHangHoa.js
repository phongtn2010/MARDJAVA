function Mard25ViewHangHoaVM () {
    self.fiHSCode = ko.observable(null);
    self.fiTrangThaiHangHoa = ko.observable(null);
    self.mard25HangHoaItems  = ko.observableArray([]);
}

function init(options) {
    var mard25ViewHangHoaVM = new Mard25ViewHangHoaVM();
    ko.applyBindings(mard25ViewHangHoaVM, document.getElementById('mardHangHoa25'));
    // self.mard25HangHoaItems  = ko.observableArray([]);
}

function getThongTinHoSo(callback) {
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
            callback(res);
            $('#loading08').hide();
        },
        error: function (x, t, m) {
            $('#loading08').hide();
        },
    })
}

$(document).ready(function () {
    var options = {};
    getThongTinHoSo(function (data) {
        self.mard25HangHoaItems=data.data;
        console.log(self.mard25HangHoaItems);
        // $('#loading10').show();
    })
    init(options);
})
