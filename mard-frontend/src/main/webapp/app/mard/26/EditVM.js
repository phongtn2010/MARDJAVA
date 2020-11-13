/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
ko.validation.rules.pattern.message = 'Invalid.';
ko.validation.init({
    registerExtenders: true,
    messagesOnModified: true,
    insertMessages: true,
    parseInputAttributes: true,
    messageTemplate: null
}, true);

function EditVM(options) {
    var edit26VMSefl = this;
    edit26VMSefl.idHS = ko.observable(idHS);

    edit26VMSefl.form26VM = ko.observable(null);
    edit26VMSefl.applyState =function () {
        edit26VMSefl.form26VM(new FormVM(options));
        edit26VMSefl.form26VM().applyStates();
    }

    edit26VMSefl.btnLuuClick= function () {
        var body = edit26VMSefl.form26VM().getData();
        console.log(body);
        edit26VMSefl.pop = app.popup({
            title: 'Thông báo',
            html: '<b>Bạn chắc chắn muốn lưu hồ sơ?</b>',
            width: 450,
            buttons: [
                {
                    name: NSWLang["common_button_toi_chac_chan"],
                    class: 'btn',
                    icon: 'fa-save',
                    action: function () {
                        app.popupRemove(edit26VMSefl.pop.selector);
                        app.makePost({
                            url: '/mard/26/hoso/create',
                            data: JSON.stringify(body),
                            success: function (d) {
                                if (d && d.success) {
                                    app.Alert('Lưu hồ sơ thành công');
                                    window.location.href = app.appContext + '/mard/26/';
                                } else {
                                    app.Alert(d.message);
                                }
                            },
                            error: function (e) {
                                if(e.hasOwnProperty('message')) {
                                    app.Alert(e.message);
                                } else {
                                    if (e.status === 403 || (e.hasOwnProperty('responseText') && e.responseText.includes('<meta charset="utf-8" />'))) {
                                        app.Alert('Phiên làm việc hết hạn, vui lòng đăng nhập lại!');
                                    } else {
                                        app.Alert('Không lưu được hồ sơ');
                                    }

                                }
                            }
                        });
                    }
                },
                {
                    name: 'Huỷ',
                    class: 'btn',
                    icon: 'fa-close',
                    action: function () {
                        app.popupRemove(edit26VMSefl.pop.selector);
                    }
                }
            ]
        });
    }
    edit26VMSefl.btnGuiClick =function () {
        edit26VMSefl.pop = app.popup({
            title: 'Thông báo',
            html: '<b>Bạn chắc chắn muốn gửi hồ sơ?</b>',
            width: 450,
            buttons: [
                {
                    name: NSWLang["common_button_toi_chac_chan"],
                    class: 'btn',
                    icon: 'fa-save',
                    action: function () {
                        app.popupRemove(edit26VMSefl.pop.selector);
                        app.makePost({
                            url: '/mard/26/hoso/send',
                            data: JSON.stringify(body),
                            success: function (d) {
                                // if (!app.requireSigning) {
                                if (d && d.success) {
                                    app.Alert('Gửi hồ sơ thành công');
                                    setTimeout(function () {
                                        window.location.href = app.appContext + '/mard/26/';
                                    }, 1500);

                                } else {
                                    app.Alert(d.message);
                                }
                            },
                            error: function (e) {
                                if(e.hasOwnProperty('message')) {
                                    app.Alert(e.message);
                                } else {
                                    if (e.status === 403 || (e.hasOwnProperty('responseText') && e.responseText.includes('<meta charset="utf-8" />'))) {
                                        app.Alert('Phiên làm việc hết hạn, vui lòng đăng nhập lại!');
                                    } else {
                                        app.Alert('Không gửi được hồ sơ');
                                    }

                                }
                            }
                        });
                    }
                },
                {
                    name: 'Huỷ',
                    class: 'btn',
                    icon: 'fa-close',
                    action: function () {
                        app.popupRemove(edit26VMSefl.pop.selector);
                    }
                }
            ]
        });
    }
    edit26VMSefl.btnTroLaiClick= function () {
        document.location = app.appContext + '/mard/26/home';
        return false;
    }
}
function init(data) {

    var edit26VM = new EditVM(data);
    ko.applyBindings(edit26VM, document.getElementById('edit26Page'));

    edit26VM.applyState(data);
}
function getThongTinHoSo(callback) {
    $('#loading08').show();
    $.ajax({
        async: true,
        type: 'GET',
        cache: false,
        crossDomain: true,
        url: app.appContext + '/mard/26/hoso/find' + "?id=" + idHS,
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
    var options={};
    getThongTinHoSo(function (response) {
        options['fiTbdHoso26'] = response.data;
        $.when(
            app.sendGetRequest('/mard/26/danhmuc/getby-catno/1', function (res) {
                if (res.success) {
                    options['fiTrangthaiList'] = res.data;
                }
            })
        ).done(function (data) {
            init(options);
        });
    });


});

