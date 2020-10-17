function HistoryView() {
    var self = this;
    // ket qua xu ly
    self.show = function(item) {
        var callback = function (html) {
            var pop = app.popup({
                title: '<b style="text-transform: uppercase">' + i18nextko.t('TbdKetQuaXuLy.xemLS')() + ' - ' + item.fiDocumentName() + '</b>',
                html: html,
                width: 960,
                buttons: [
                ]
            }, function(){
                var mHistoryPopupView = new HistoryPopupView(item);
                ko.applyBindings(mHistoryPopupView, document.getElementById("lich_su_tac_dong"));
            });

            self.appPopup = pop;
        }

        app.complieTemplate({
            ministryCode: complieTemplateMinistryCode,
            code: complieTemplateCode,
            templateName: "lich_su_tac_dong",
            data: null
        }, callback);
    }
}

function HistoryPopupView(item) {
    var self = this;

    self.titles = ko.observableArray([]);
    self.dataTable = ko.observableArray([]);
    self.totalElements = ko.observable(0);
    self.currentPage = ko.observable(1);
    self.pageable = { size: 10, number: 1, sort: 'fiCreateDate', direction: 'desc'}
    self.pageSize = ko.observable(self.pageable.size);

    self.titles.push({key: 'fiNameOfRegistration', value: i18nextko.t('TbdKetQuaXuLy.donVi'), columnType: TABLE_COLUMN_DISPLAY_TEXT});
    self.titles.push({key: 'fiProcessor', value: i18nextko.t('TbdKetQuaXuLy.nguoiXuLy'), columnType: TABLE_COLUMN_DISPLAY_TEXT});
    self.titles.push({key: 'fiProcessDate', value: i18nextko.t('TbdKetQuaXuLy.ngayXuLy'), dateFormat: 'DD/MM/YYYY HH:mm', columnType: TABLE_COLUMN_DISPLAY_DATE});
    self.titles.push({key: 'fiContent', value: i18nextko.t('TbdKetQuaXuLy.noiDung'), columnType: TABLE_COLUMN_DISPLAY_TEXT});
    self.titles.push({key: 'fiStatusName', value: i18nextko.t('TbdKetQuaXuLy.trangThai'), columnType: TABLE_COLUMN_DISPLAY_TEXT});
    self.titles.push({key: 'fiLink', value: i18nextko.t('TbdKetQuaXuLy.taiLieu'), icon: 'fa fa-download', columnType: TABLE_COLUMN_DISPLAY_LINK_LIST_BLANK});

    self.pageClick = function (page) {
        self.currentPage(page);
        self.load(page);
    }

    self.load = function(page) {
        self.pageable.number = self.currentPage() - 1;
        callApi('/mic/04/tbdKetQuaXuLy04/page?fiIdHoSo='+item.fiIdHoSo(), self.pageable, function (d) {
            self.dataTable.removeAll();
            self.totalElements(d.data.totalElements);
            if (d.data.content) {
                d.data.content.forEach(function (item) {
                    var links = [];
                    if (item.fiLink && !item.fiLink.startsWith("http")) {
                        var fileIds = item.fiLink.split('|');
                       
                        if (fileIds) {
                            fileIds.forEach(function (value, index) {
                                 if (value)
                                links.push(urlDownload + value);
                            });
                        }
                    } else if(item.fiLink){
						links.push(item.fiLink);
					}
					item.fiLink = links;
                    var v = convertObjectToKnockout(item, new KetQuaXuLy03DTO());
                    self.dataTable.push(v);
                })
            }
        });

    }

    self.load(1);

}
