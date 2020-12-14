function TableViewController(params) {
  var self = this;
  self.pageSize = ko.observable(params.pageSize ? params.pageSize : 15);
  self.displayFrom = ko.observable(0);
  self.displayTo = ko.observable(0);
  self.titles = ko.observableArray([]);
  self.pagingUI = ko.observable(params.pagingUI ? params.pagingUI : true);
  self.rows = params.rows;//ko.observableArray([params.rows]);
  self.pagingVM = new PagingVM({
    pageSize: self.pageSize(),
    totalCount: params.totalElements(0),
  });
  self.pViewPaging = new ViewPaging();

  self.pagingVM.currentPage(params.currentPage());

  params.currentPage.subscribe(function (value) {
    self.pagingVM.setCurrentPage(value);
    loadPageInfo();
  });
  params.totalElements.subscribe(function (value) {
    self.pagingVM.totalCount(value);
    loadPageInfo();
  });

  self.rows.subscribe(function (value) {
  });

  if (params.titles) {
    params.titles().forEach(function (value) {
      self.titles.push(value);
    });

  }

  function loadPageInfo() {
    var from = (self.pagingVM.currentPage() - 1) * self.pageSize() + 1;
    var to = (self.pagingVM.currentPage()) * self.pageSize();
    if (self.pagingVM.totalCount() == 0) {
      from = 0;
      to = 0;
    } else if (self.pagingVM.totalCount() < to) {
      to = self.pagingVM.totalCount();
    }
    self.displayFrom(from);
    self.displayTo(to);
  }

  // var info = i18nextko.t('pagination.display', { fromIndex: '23232',  interpolation: { escapeValue: false }})();
  self.onClick = function (action) {
    if (params && params.confirm) {
      self.confirm(action);
    } else {
      action();
    }
  }
  self.goToPage = function (page) {
    if (page >= self.pagingVM.firstPage && page <= self.pagingVM.lastPage()) {
      self.pagingVM.setCurrentPage(page);
      params.pageClick(self.pagingVM.currentPage());
      self.pViewPaging.currentPage(page);
    }

  };

  self.goToFirst = function () {
    self.pagingVM.setCurrentPage(1);
    params.pageClick(1);
  };

  self.goToPrevious = function () {
    var previous = self.pagingVM.previousPage();
    if (previous != null) {
      self.pagingVM.setCurrentPage(previous);
      params.pageClick(self.pagingVM.currentPage());
    }

  };

  self.goToNext = function () {
    var next = self.pagingVM.nextPage();
    if (next != null) {
      self.pagingVM.setCurrentPage(next);
      params.pageClick(next);
    }

  };

  self.goToLast = function () {
    var goToLast = self.pagingVM.lastPage();
    if (goToLast != self.pagingVM.currentPage()) {
      self.pagingVM.setCurrentPage(goToLast);
      params.pageClick(goToLast);
    }

  };

}

ko.components.register('table-view', {
  viewModel: TableViewController,
  template: {element: 'table-view-template'}
});

function ViewPaging() {
  var self = this;
  self.getPages = ko.observableArray([]);
  self.firstPageActive = ko.observable(false);
  self.previousPageActive = ko.observable(false);
  self.nextPageActive = ko.observable(false);
  self.lastPageActive = ko.observable(false);
  self.totalCount = ko.observable(0);
  self.currentPage = ko.observable(1);
  self.pageSize = ko.observable(10);

  self.totalCount.subscribe(function (value) {
    console.log('totalCount: ' + value);
    // self.calculator(value);
  });

  self.currentPage.subscribe(function (value) {
    // self.calculator(self.totalCount());
  });

  self.calculator = function (value) {
    if (self.pageSize() === 0) {
      self.pageSize(1);
    }
    var countPage = Math.floor(value / self.pageSize());
    if (self.totalCount() % self.pageSize() !== 0) {
      countPage++;
    }
    self.getPages.removeAll();
    for (var i = 1; i <= countPage; i++) {
      self.getPages.push(i);
    }
  }

}

ko.applyBindings();