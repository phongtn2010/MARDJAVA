/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function FileVM(item, idHoso) {
    var self = this;
    self.attachmentId = ko.observable((item !== null && item.hasOwnProperty('attachmentId')) ? item.attachmentId : null);
    self.isRequired = ko.observable((item !== null && item.hasOwnProperty('isRequired')) ? item.isRequired : null);
    self.attachmentName = ko.observable((item !== null && item.hasOwnProperty('attachmentName')) ? item.attachmentName : null);
    self.attachmentTypeName = ko.observable((item !== null && item.hasOwnProperty('attachmentTypeName')) ? item.attachmentTypeName : null);
    self.attachmentTypeCode = ko.observable((item !== null && item.hasOwnProperty('attachmentTypeCode')) ? item.attachmentTypeCode : null);
    self.attachmentListId = ko.observable((item !== null && item.hasOwnProperty('attachmentListId')) ? item.attachmentListId : null);
    self.nswfileCode = ko.observable((item !== null && item.hasOwnProperty('nswfileCode')) ? item.nswfileCode : null);
    self.createBy = ko.observable(null);
    self.createDate = ko.observable(null);
    self.isActive = ko.observable(null);
    self.linkfile = ko.observable((item !== null && item.hasOwnProperty('linkfile')) ? item.linkfile : null);
    self.registrationProfileId = ko.observable((item !== null && item.hasOwnProperty('registrationProfileId')) ? item.registrationProfileId : null);
    self.fiSize = ko.observable((item !== null && item.hasOwnProperty('fiSize')) ? item.fiSize : null);
    self.regisType = ko.observable((item !== null && item.hasOwnProperty('regisType')) ? item.regisType : null);

    //dung cho file dinh kem cua xac nhan thanh toan phi
    self.fiIdDk = ko.observable((item !== null && item.hasOwnProperty('fiIdDk')) ? item.fiIdDk : null);
    self.fiIdXnp = ko.observable((item !== null && item.hasOwnProperty('fiIdXnp')) ? item.fiIdXnp : null);
    self.fiTenDinhkem = ko.observable((item !== null && item.hasOwnProperty('fiTenDinhkem')) ? item.fiTenDinhkem : null);
    self.fiLinkfile = ko.observable((item !== null && item.hasOwnProperty('fiLinkfile')) ? item.fiLinkfile : null);
    self.fiGuiid = ko.observable((item !== null && item.hasOwnProperty('fiGuiid')) ? item.fiGuiid : null);
    self.fiDuongdan = ko.observable((item !== null && item.hasOwnProperty('fiDuongdan')) ? item.fiDuongdan : null);

    self.downloadFileDk = ko.computed(function () {
        if (self.fiTenDinhkem != null) {
            return app.appContext + '/mard/p04/downloadFileTtp/' + self.fiGuiid() + '/' + self.fiIdDk();
        }
        return null;
    }, this);

    self.isRequire = ko.computed(function () {
        return (self.isRequired() == 1);
    }, this);

    self.canDownload = ko.computed(function () {
        return self.attachmentName() !== null;
    }, this);

}

function mapFiles04VM(data, maHoSo) {
    return ko.utils.arrayMap(data, function (item, index) {
        return new FileVM(item, maHoSo);
    });
}
