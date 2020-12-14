function HistoryView() {
    var self = this;
    // ket qua xu ly
    self.show = function(item) {
        var callback = function (html) {
            var pop = app.popup({
                title: '<b style="text-transform: uppercase">' + NSWLang["mard.20.popup.lichSuHoSo"] + ' - ' + item.fiDocumentName() + '</b>',
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
            ministryCode: "mard",
            code: "20",
            templateName: "lich_su_tac_dong",
            data: null
        }, callback);
    }
}

function HistoryPopupView(item) {
    var self = this;
    self.pageContents = ko.observableArray([]);

    var url =  '/mard/20/tbdKetQuaXuLy20/page?fiIdHoSo='+item.fiIdHoSo();
    var pageable = { size: 5, number: 0, sort: 'fiCreateDate', direction: 'desc'};
    self.historyPageingVM = new PagingVM({
        pageSize : pageable.size,
        totalCount : 0
    });

    //self.searching();
    self.goToPage = function(page) {
        if (page >= self.historyPageingVM.firstPage && page <= self.historyPageingVM.lastPage()) {
            self.historyPageingVM.setCurrentPage(page);
            self.searching();
        }

    };

    self.goToFirst = function() {
        self.historyPageingVM.setCurrentPage(self.historyPageingVM.firstPage);
        self.searching();
    };

    self.goToPrevious = function() {
        var previous = self.historyPageingVM.previousPage();
        if (previous != null) {
            self.historyPageingVM.setCurrentPage(previous);
            self.searching();
        }

    };

    self.goToNext = function() {
        var next = self.historyPageingVM.nextPage();
        if (next != null) {
            self.historyPageingVM.setCurrentPage(next);
            self.searching();
        }

    };

    self.goToLast = function() {
        self.historyPageingVM.setCurrentPage(self.historyPageingVM.lastPage());
        self.searching();
    };

    self.searching = function() {
        pageable.number = self.historyPageingVM.currentPage() - 1;
        app.makePost({
            url: url,
            data: JSON.stringify(pageable),
            error: function (d) {
                self.pageContents.removeAll();
                readArrayObjects(d.content, function (loopItem) {
                    self.pageContents.push(loopItem);
                });
                self.historyPageingVM.totalCount(d.totalElements);
                console.log("JSON.stringify(pageable): " + JSON.stringify(pageable));
                console.log("data: " + d);
            }
        });
    }


    self.searching();
}
