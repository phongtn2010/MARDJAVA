/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function CuaKhau(d){
    var self = this;
    self.fiMaCuakhau = ko.observable(d.fiMaCuakhau);
    self.fiTenCuakhau = ko.observable(d.fiTenCuakhau);
    self.fiDaChon = ko.observable(0);
}

var mapCuaKhau = function (d) {
    return ko.utils.arrayMap(d, function (item, index) {
        return new CuaKhau(item);
    });
};

function CuaKhauVM(type, formVM) {
    var self = this;

    self.fiMaCuakhau = ko.observable();
    self.fiTenCuakhau = ko.observable();
    self.lstItems = ko.observableArray([]);

    self.currentPage = ko.observable(0);
    self.pageSize = ko.observable(10);
    self.totalCount = ko.observable(0);

    self.paging = ko.observable(new PagingVM({
        pageSize: self.pageSize(),
        totalCount: 0
    }));

    self.paging().currentPage.subscribe(function (newCurrentPage) {
        self.currentPage(newCurrentPage);
        self.search(null);
    });

    self.search = function (cb) {
        var data = {
            currentPage: self.currentPage() - 1 < 0 ? 0 : self.currentPage() - 1,
            pageSize: self.pageSize(),
            fiMaCuakhau: self.fiMaCuakhau(),
            fiTenCuakhau: self.fiTenCuakhau()
        };

        app.makePost({
            url: '/moh/09/CuaKhau',
            data: JSON.stringify(data),
            success: function (res) {
                if (res.success) {
                    var list = res.data ? mapCuaKhau(res.data) : [];
                    self.lstItems([]);
                    self.lstItems(list);
                    self.totalCount(res.data ? res.total : 0);

                    self.paging().update({
                        totalCount: res.data ? res.total : 0,
                        pageSize: self.pageSize(),
                        currentPage: self.currentPage()
                    });
                    if (cb) {
                        cb();
                    }
                }
            },
            error: function (e) { }
        });
    };
    
    self.doSelect = function (item) {
        formVM.updateGateInfo(item, type);
    };
    
    self.doSearch = function (item) {
        self.search(null);
    };
}