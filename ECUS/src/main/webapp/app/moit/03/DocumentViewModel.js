/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
ko.validation.rules.pattern.message = 'Invalid.';
ko.validation.init({registerExtenders: true, messagesOnModified: true, insertMessages: true, parseInputAttributes: true, messageTemplate: null}, true);

function Most03CreateVM(options) {
    self = this;
    
    self.formViewModel = new Most03FormVM(options);
    self.formViewModel.fiNgaycapText = ko.observable(self.formViewModel.fiNgaycap).extend({vnDateShort: true});
    self.formViewModel.fiLoaiHosoText = ko.dependentObservable(function () {
        if (self.formViewModel.lstLoaiHoSo()) {
            for (var i = 0; i < self.formViewModel.lstLoaiHoSo().length; i++) {
                if (self.formViewModel.lstLoaiHoSo()[i].id == self.formViewModel.fiLoaiHoso()) {
                    return self.formViewModel.lstLoaiHoSo()[i].name;
                }
            }
            return "";
        }
    }, self);
    
    self.most03FormVM = ko.observable(self.formViewModel);
    self.most03FilesVM = ko.observable(new Most03FilesVM(options));

    self.btnTroLaiClick = function () {
        History.go(-1);
    };

    self.exportHref = ko.observable(app.appContext + "/most/03/hoso/bieumau/" + options.fiIdHoso);
}

$(document).ready(function () {

    var options = app.parseQuerystring();

    $.when(
            app.getCategory('/most/03/danhmuc', 'DM_LOAIHOSO', null, function (res) {
                if (res.success) {
                    options.lstLoaiHoSo = res.data;
                }
            }),
            app.getCategory('/most/03/danhmuc', 'HS_LOAIPTDO', null, function (res) {
                if (res.success) {
                    options.lstLoaiPhuongTienDo = res.data;
                }
            })
            ).done(function (data) {
        init();
    });

    var init = function () {
        if (options && options.fiIdHoso > 0) {
            var url = '/most/03/hoso/t/' + options.fiIdHoso;
            app.makePost({
                url: url,
                data: JSON.stringify({}),
                success: function (d) {
                    if (d.success) {
                        options.hoso = d.data;
                        var most03CreateVM = new Most03CreateVM(options);
                        ko.applyBindings(most03CreateVM, document.getElementById('Most03CreateVM'));
                    }
                },
                error: function (e) {
                    app.Alert('Không lấy được dữ liệu hồ sơ');
                }
            });
        } else {
            var most03CreateVM = new Most03CreateVM(options);
            ko.applyBindings(most03CreateVM, document.getElementById('Most03CreateVM'));
        }
    };
});

