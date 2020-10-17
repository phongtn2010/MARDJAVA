/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var triggerTab = function (tab) {
    var $tab = $('#' + tab);
    if ($tab.length > 0) {// ?
        $tab.trigger('click');
    }
};
function ThongBaoVM(options) {
    self = this;
    var data = null;
    var code = '';
    debugger;
    if (options.thongbao) {
        data = options.thongbao;
        console.log(data);
        if (data) {
            code = data.dinhkem != null ? data.dinhkem.fiTenteptin : '';
        }
    }

    debugger;
    
    ko.mapping.fromJS(data, {}, self);
    
    self.fiNgayKy = ko.observable(data != null ? new Date(data.fiNgayKy).toDayFirstWithTime() : null);
    if(data != null){
        self.lstPheLieu(data.hasOwnProperty('lstPheLieu') ? mapTbdphelieu8(data.lstPheLieu) : []);
        self.errorPheLieuMessage = '';
        if(data.lstPheLieu != null && data.lstPheLieu.length<0){
            self.errorPheLieuMessage = 'Không có dữ liệu';
        }
        self.fiTenTep = ko.observable(data.dinhkem != null ? data.dinhkem.fiTenTep : null);
        self.fiDuongdan = ko.observable(data.dinhkem != null ? data.dinhkem.fiDuongdan : null);
        self.fiTenteptin = ko.observable(data.dinhkem != null ? data.dinhkem.fiTenteptin : null);
    }
    self.lstLohangNk = ko.observable(data != null ? data.lstLohangNk : null);
    self.exportHref = ko.observable(app.appContext + '/monre/08/tbfile/' + options.fiIdHoso + '/' + options.fiMaHoso + '/' + code);

    if (options.tab == "mau") {
        triggerTab('a-tab-monre08-2');
    }
}