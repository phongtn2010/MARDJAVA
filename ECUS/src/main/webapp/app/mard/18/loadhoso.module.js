function LoadHoSoView(self) {

	self.searchForm = new SearchFormModel();

	self.danhSachHoSo = ko.observableArray();

	self.pagingVM = new PagingVM({
		pageSize : 15,
		totalCount : 0
	});


	self.danhSachTrangThai = ko.observableArray();

	self.layDanhSachTrangThai = function() {
		self.danhSachTrangThai.removeAll();
		app.makePost({
			url : '/mard/18/tbsTrangThai18/findAll',
			data : ko.toJSON({
				"number" : 0,
				"size" : 100,
				"sort" : "fiId",
				"direction" : "asc"
			}),
			error : function(e) {
				self.danhSachTrangThai.push({fiCode: '-1', fiStatusName: NSWLang["mard.18.select.option"]});
				readArrayObjects(e, function(item) {
					self.danhSachTrangThai.push(item);
				});
			}
		});
	}
	self.layDanhSachTrangThai();

	self.load = function(page) {
        self.searchForm['fromFiSendDate'].rules.remove(function (item) {
            return item.rule == "dateVI";
        });
        self.searchForm['fromFiSendDate'].extend({
            dateVI: true
        });
        self.searchForm['toFiSendDate'].rules.remove(function (item) {
            return item.rule == "dateVI";
        });
        self.searchForm['toFiSendDate'].extend({
            dateVI: true
        });
        self.searchForm['fromFiSignConfirmDate'].rules.remove(function (item) {
            return item.rule == "dateVI";
        });
        self.searchForm['fromFiSignConfirmDate'].extend({
            dateVI: true
        });
        self.searchForm['toFiSignConfirmDate'].rules.remove(function (item) {
            return item.rule == "dateVI";
        });
        self.searchForm['toFiSignConfirmDate'].extend({
            dateVI: true
        });

        self.searchForm['toFiSendDate'].rules.remove(function (item) {
            return item.rule == "greaterThanOrEqual";
        });
        self.searchForm['toFiSendDate'].extend({
            greaterThanOrEqual: self.searchForm.fromFiSendDate()
        });

        self.searchForm['toFiSignConfirmDate'].rules.remove(function (item) {
            return item.rule == "greaterThanOrEqual";
        });
        self.searchForm['toFiSignConfirmDate'].extend({
            greaterThanOrEqual: self.searchForm.fromFiSignConfirmDate()
        });

        if (self.searchForm.valid.errors().length > 0) {
            showError(self.searchForm.valid());
            self.searchForm.valid.errors.showAllMessages();
            return;
        }
		$('#showLoadingIcon').show();
		app.makePost({
			url : encode('/mard/18/tbdHoSo18/page', self.searchForm),
			data : ko.toJSON({
				"number" : page - 1,
				"size" : self.pagingVM.pageSize(),
				"sort" : "fiIdHoSo",
				"direction" : "desc"
			}),
			error : function(e) {
				self.danhSachHoSo.removeAll();
				readArrayObjects(e.content, function(item) {
					var tbd = convertObjectToKnockout(item, new TbdHoSo());
					self.checkShowHideButton(tbd);
					self.danhSachHoSo.push(tbd);
				});
				self.pagingVM.totalCount(e.totalElements);
                if (e.totalElements == 0) {
                    self.pagingVM.currentPage(0);
                }
				$('#showLoadingIcon').hide();
			}
		});

	}

	self.load(1);

	self.checkShowHideButton = function(item) {
		item.showButtonEdit(self.showButtonEdit(item.fiStatus()));
		item.showButtonDelete(self.showButtonDelete(item.fiStatus()));
		item.showButtonXemGXN(self.showButtonXemGXN(item.fiStatus()));
		item.showButtonXinRut(self.showButtonXinRut(item.fiStatus()));
		item.showButtonXinSuaHoSo(self.showButtonXinSuaHoSo(item.fiStatus()));
		item.showButtonXinSuaGP(self.showButtonXinSuaGP(item.fiStatus()));
		item.showButtonBoSungToKhai(self.showButtonBoSungToKhai(item.fiStatus()));
	}

	self.showButtonEdit = function(status) {
		if (status == 0) return true;
		if (status == 1) return true;
		if (status == 5) return true;
		//if (status == 7) return true;

		return false;
	}
	self.showButtonBoSungToKhai = function(status){
		if (status == 1) {return true;}
		else if(status == 3) {return true;}
		else if(status == 16) {return true;}
		else if(status == 6) {return true;}
		else if(status == 8) {return true;}
		else if(status == 26) {return true;}
		return false;
	}

	self.showButtonDelete = function(status) {
		if (status == 0) return true;
		return false;
	}

	self.showButtonXemGXN = function(status) {
		if (status == 18) return true;
		if (status == 19) return true;
		if (status == 22) return true;

		return false;
	}

	self.showButtonXinRut = function(status) {
		if (status == 1) return true;
		if (status == 3) return true;
		if (status == 5) return true;
		if (status == 6) return true;
		if (status == 11) return true;
		return false;
	}

	self.showButtonXinSuaHoSo = function(status) {
		if (status == 3) return true;
		if (status == 11) return true;
		return false;
	}

    self.showButtonThongBaoPhi = function(status) {
        if (status == 15) return true;
        if (status == 16) return true;
        if (status == 17) return true;
        if (status == 20) return true;
		if (status == 21) return true;
        return false;
    }
	self.showButtonXinSuaGP = function(status){
		if (status == 18) return true;
		if (status == 19) return true;
		return false;
	}
	self.searching = function() {
		self.pagingVM.totalCount(0);
		self.load(self.pagingVM.currentPage());
	}


	self.searchHoSo = function() {
		self.pagingVM.currentPage(1);
		self.searching();
	}

	self.goToPage = function(page) {
		if (page >= self.pagingVM.firstPage && page <= self.pagingVM.lastPage()) {
			self.pagingVM.setCurrentPage(page);
			self.searching();
		}

	};

	self.goToFirst = function() {
		self.pagingVM.setCurrentPage(self.pagingVM.firstPage);
		self.searching();
	};

	self.goToPrevious = function() {
		var previous = self.pagingVM.previousPage();
		if (previous != null) {
			self.pagingVM.setCurrentPage(previous);
			self.searching();
		}

	};

	self.goToNext = function() {
		var next = self.pagingVM.nextPage();
		if (next != null) {
			self.pagingVM.setCurrentPage(next);
			self.searching();
		}

	};

	self.goToLast = function() {
		self.pagingVM.setCurrentPage(self.pagingVM.lastPage());
		self.searching();
	};

	function encode(url, knockoutObject) {
		if (!knockoutObject)
			return url;
		url += "?";
		for ( var key in knockoutObject) {
			if (key == 'valid') continue;
			url += key + "=";
			var value = knockoutObject[key]();
			if (value) {
				if (key != 'fiStatus' || (key == 'fiStatus' && value != '-1')) {
					url += value;
				}
			}

			url += "&";
		}
		// if (isDevTest) {
         //    console.log(url);
		// }
		return url;//encodeURI(url);
	}

}
