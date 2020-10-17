/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
ko.validation.rules.pattern.message = 'Invalid.';
ko.validation.init({registerExtenders: true, messagesOnModified: true, insertMessages: true, parseInputAttributes: true, messageTemplate: null}, true);

function Most04CreateVM(options) {
    self = this;
    
    self.most04FormVM = ko.observable(new Most04FormVM(options));
    self.most04FilesVM = ko.observable(new Most04FilesVM(options));

    self.btnTroLaiClick = function () {
        History.go(-1);
    };

    self.exportHref = ko.observable(app.appContext + "/most/04/hoso/bieumau/" + options.fiIdHoso);
}

$(document).ready(function () {

    var options = app.parseQuerystring();

    $.when(
            app.getCategory('/most/04/danhmuc', 'DM_NHOMHH', null, function (res) {
                if (res.success) {
                    options.lstNhomHangHoa = res.data;
                }
            }),
            app.getCategory('/most/04/danhmuc', 'DM_QUOCGIA', null, function (res) {
                if (res.success) {
                    options.lstQuocGia = res.data;
                } else {
                    options.lstQuocGia = [];
                }
            })
            ).done(function (data) {
                init();
            });

    var init = function () {
        if (options && options.fiIdHoso > 0) {
            var url = '/most/04/hoso/t/' + options.fiIdHoso;
            app.makePost({
                url: url,
                data: JSON.stringify({}),
                success: function (d) {
                    if (d.success) {
                        options.hoso = d.data;
                        var most04CreateVM = new Most04CreateVM(options);
                        ko.applyBindings(most04CreateVM, document.getElementById('Most04CreateVM'));
                    }
                },
                error: function (e) {
                    app.Alert('Không lấy được dữ liệu hồ sơ');
                }
            });
        } else {
            var most04CreateVM = new Most04CreateVM(options);
            ko.applyBindings(most04CreateVM, document.getElementById('Most04CreateVM'));
        }
    };
});

