function HistoryPopupView() {
    var self = this;
    self.mahoso = "";
    self.show = function(mahoso) {
        self.mahoso = mahoso;
        self.fiHSCode(mahoso);
        $("#loading10").show();
        self.searching();
    };

    var pageable = { size: 5, number: 0, sort: 'fiCreateDate', direction: 'desc'};
    self.historyPageingVM = new PagingVM({
        pageSize : pageable.size,
        totalCount : 0
    });

    self.fiHSCode = ko.observable();
    self.historyItems = ko.observableArray([]);

    self.historyItems(ko.utils.arrayMap([], function (item) {
        var itemVM = {};
        ko.mapping.fromJS(item, {}, itemVM);
        itemVM.fiStatus = ko.observable(mapTrangthai[item.fiStatus.toString()]);
        return itemVM;
    }));

    //self.searching();
    self.goToPage = function(page) {
        if (page >= self.historyPageingVM.firstPage && page <= self.historyPageingVM.lastPage()) {
            self.historyPageingVM.setCurrentPage(page);
            self.searchingAfterShow();
        }
    };

    self.goToFirst = function() {
        self.historyPageingVM.setCurrentPage(self.historyPageingVM.firstPage);
        self.searchingAfterShow();
    };

    self.goToPrevious = function() {
        var previous = self.historyPageingVM.previousPage();
        if (previous != null) {
            self.historyPageingVM.setCurrentPage(previous);
            self.searchingAfterShow();
        }

    };

    self.goToNext = function() {
        var next = self.historyPageingVM.nextPage();
        if (next != null) {
            self.historyPageingVM.setCurrentPage(next);
            self.searchingAfterShow();
        }
    };

    self.goToLast = function() {
        self.historyPageingVM.setCurrentPage(self.historyPageingVM.lastPage());
        self.searchingAfterShow();
    };

    self.searching = function() {
        pageable.number = self.historyPageingVM.currentPage() - 1;
        app.makeGet({
            url: '/mard/01/lichsu?fiHSCode=' + self.mahoso + '&p=' + pageable.number + '&s=5',
            success: function(res) {
                $("#loading10").hide();
                self.historyPageingVM.totalCount(res.total);
                self.historyItems(ko.utils.arrayMap(res.data, function (item) {
                    var itemVM = {};
                    ko.mapping.fromJS(item, {}, itemVM);
                    itemVM.fiStatus = ko.observable(mapTrangthai[item.fiStatus.toString()]);
                    return itemVM;
                }));
                $("#modal_lichsuXuly").modal('toggle');

            },
            error: function (d) {
                $("#loading10").hide();
                self.pageContents.removeAll();
                readArrayObjects(d.content, function (loopItem) {
                    self.pageContents.push(loopItem);
                });
                self.historyPageingVM.totalCount(d.totalElements);
            }
        });
    }

    self.searchingAfterShow = function() {
        pageable.number = self.historyPageingVM.currentPage() - 1;
        app.makeGet({
            url: '/mard/01/lichsu?fiHSCode=' + self.mahoso + '&p=' + pageable.number + '&s=5',
            success: function(res) {
                self.historyPageingVM.totalCount(res.total);
                self.historyItems(ko.utils.arrayMap(res.data, function (item) {
                    var itemVM = {};
                    ko.mapping.fromJS(item, {}, itemVM);
                    itemVM.fiStatus = ko.observable(mapTrangthai[item.fiStatus.toString()]);
                    return itemVM;
                }));

            },
            error: function (d) {
                $("#loading10").hide();
                self.pageContents.removeAll();
                readArrayObjects(d.content, function (loopItem) {
                    self.pageContents.push(loopItem);
                });
                self.historyPageingVM.totalCount(d.totalElements);
            }
        });
    }
}