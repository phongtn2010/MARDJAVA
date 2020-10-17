/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function NguoiTnVM(d, formVM) {
    var self = this;
    
    //var query = app.parseQuerystring();
    
    self.fiStt = ko.observable(d.hasOwnProperty('fiStt') ? d.fiStt : 1);    
    self.fiIdNguoiTn = ko.observable(d.hasOwnProperty('fiIdNguoiTn') ? d.fiIdNguoiTn : -1 * new Date().getTime());
    self.fiIdHoso = ko.observable(d.hasOwnProperty('fiIdHoso') ? d.fiIdHoso : formVM.fiIdHoso());
    
    self.fiTenNgTn = ko.observable(d.hasOwnProperty('fiTenNgTn') ? d.fiTenNgTn : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiDiachiNgTn = ko.observable(d.hasOwnProperty('fiDiachiNgTn') ? d.fiDiachiNgTn : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 500 ký tự', params: 500}
    });
    self.fiSdtNgTn = ko.observable(d.hasOwnProperty('fiSdtNgTn') ? d.fiSdtNgTn : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 50 ký tự', params: 50}
    });
    self.fiFaxNgTn = ko.observable(d.hasOwnProperty('fiFaxNgTn') ? d.fiFaxNgTn : null).extend({
        maxLength: {message: 'Tối đa 50 ký tự', params: 50}
    });
    self.fiEmailNgTn = ko.observable(d.hasOwnProperty('fiEmailNgTn') ? d.fiEmailNgTn : null).extend({
        maxLength: {message: 'Tối đa 255 ký tự', params: 50}
    });
    
    self.fiHoatdong = ko.observable(1);
    self.fiNguoitao = ko.observable(formVM.fiNguoitao());

    var vg = [self.fiTenNgTn, self.fiDiachiNgTn, self.fiSdtNgTn];
    self.formErrors = ko.validation.group(vg, {deep: true, live: true, observable: true});

    self.isVaild = function () {
        if (self.formErrors().length > 0) {
            self.formErrors.showAllMessages();
            return false;
        }
        return true;
    };

    self.toJson = function () {
        return {
            fiIdHoso: self.fiIdHoso(),
            fiTenNgTn: self.fiTenNgTn(),
            fiDiachiNgTn: self.fiDiachiNgTn(),
            fiSdtNgTn: self.fiSdtNgTn(),
            fiFaxNgTn: self.fiFaxNgTn(),
            fiEmailNgTn: self.fiEmailNgTn(),
            fiHoatdong: self.fiHoatdong(),
            fiNguoitao: self.fiNguoitao()
        };
    };
}

function mapNguoiTnVM(data, formVM) {    
    return ko.utils.arrayMap(data, function (item, index) {   
        item.fiStt = index + 1;
        return new NguoiTnVM(item, formVM);
    });
}