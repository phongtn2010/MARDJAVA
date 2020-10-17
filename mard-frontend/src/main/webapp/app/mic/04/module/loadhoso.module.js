function LoadHoSoView(self) {

	self.searchForm = new SearchFormModel();

	self.danhSachHoSo = ko.observableArray();

    self.titles = ko.observableArray([]);
    self.dataTable = ko.observableArray([]);
    self.totalElements = ko.observable(0);
    self.currentPage = ko.observable(1);
    self.pageSize = ko.observable(15);

    self.titles.push({key: 'actionXemLichSu', value: i18nextko.t('tableHoSo.1'), icon: 'fa fa-lg fa-history', action: actionXemLichSu, columnType: TABLE_COLUMN_DISPLAY_BUTTON});
    self.titles.push({key: 'fiDocumentName', value: i18nextko.t('tableHoSo.3'), align: 'center', action: actionXemChiTietHoSo, columnType: TABLE_COLUMN_DISPLAY_BUTTON});
    self.titles.push({key: 'fiDispatchNo', value: i18nextko.t('tableHoSo.4'), align: 'center', columnType: TABLE_COLUMN_DISPLAY_TEXT});
    self.titles.push({key: 'fiSignConfirmDate', value: i18nextko.t('tableHoSo.5'), align: 'center', dateType: true, dateFormat: 'DD/MM/YYYY', columnType: TABLE_COLUMN_DISPLAY_DATE});
    self.titles.push({key: 'fiSendDate', value: i18nextko.t('tableHoSo.6'), align: 'center', dateType: true, dateFormat: 'DD/MM/YYYY HH:mm', columnType: TABLE_COLUMN_DISPLAY_DATE});
    self.titles.push({key: 'fiStatusName', value: i18nextko.t('tableHoSo.7'), columnType: TABLE_COLUMN_DISPLAY_TEXT});
    self.titles.push({key: 'actionXemHoSo', value: i18nextko.t('tableHoSo.8'), icon: 'fa fa-eye', action: actionXemHoSo, columnType: TABLE_COLUMN_DISPLAY_BUTTON});
    self.titles.push({key: 'actionXemGiayPhep', value: i18nextko.t('tableHoSo.xemGiayPhep'), icon: 'fa fa-eye', action: actionXemGiayPhep, columnType: TABLE_COLUMN_DISPLAY_BUTTON});
    self.titles.push({key: 'actionSuaGiayPhep', value: i18nextko.t('tableHoSo.suaGiayPhep'), icon: 'fa fa-lg fa-edit request-cancel', action: actionSuaGiayPhep, columnType: TABLE_COLUMN_DISPLAY_BUTTON});
    self.titles.push({key: 'actionXinRutHoSo', value: i18nextko.t('tableHoSo.10'), icon: 'fa fa-lg fa-arrow-circle-o-down', action: actionXinRutHoSo, columnType: TABLE_COLUMN_DISPLAY_BUTTON});
    self.titles.push({key: 'actionSuaHoSo', value: i18nextko.t('tableHoSo.11'), icon: 'fa fa-lg fa-edit request-cancel', action: actionSuaHoSo, columnType: TABLE_COLUMN_DISPLAY_BUTTON });
    self.titles.push({key: 'actionXoaHoSo', value: i18nextko.t('tableHoSo.12'), icon: 'fa fa-lg fa-close', style: "color: red; font-weight: bold;", action: actionXoaHoSo, columnType: TABLE_COLUMN_DISPLAY_BUTTON});

    function actionXemChiTietHoSo(item) {
        if (isDevTest) {
            console.log("actionXemChiTietHoSo:");
            console.log(convertKnockoutToObject(item, createObject(item)));
        }
        location.href = app.appContext + "/mic/04/view/" + item.fiIdHoSo();
    }

    function actionXemGiayPhep(item) {
        if (isDevTest) {
            console.log("actionXemGiayPhep:");
            console.log(convertKnockoutToObject(item, createObject(item)));
        }
      var v = new GiayPhepViewModel();
      v.show(item);
    }

    function actionSuaGiayPhep(item) {
        if (isDevTest) {
            console.log("actionSuaGiayPhep:");
            console.log(convertKnockoutToObject(item, createObject(item)));
        }
        var v = new SuaGiayPhepViewModel();
        v.show(item);
    }

    function actionXemHoSo(item) {
        if (isDevTest) {
            console.log("actionXemHoSo:");
            console.log(convertKnockoutToObject(item, createObject(item)));
        }
        var v = new HoSoViewModel();
        v.show(item);
    }
     function actionSuaHoSo(item) {
         location.href = app.appContext + '/mic/04/edit/' + item.fiIdHoSo();
	}


    function actionXinRutHoSo(item) {
        if (isDevTest) {
            console.log("actionXinRutHoSo:");
            console.log(convertKnockoutToObject(item, createObject(item)));
        }
        var v = new HuyHoSoView();
        v.show(item);
    }

    function actionXoaHoSo(item) {
        if (isDevTest) {
            console.log("actionXoaHoSo:");
            console.log(convertKnockoutToObject(item, createObject(item)));
        }
        var v = new XoaHoSoView();
        v.show(item);
    }

    function actionXemLichSu(item) {
        if (isDevTest) {
            console.log("actionXemLichSu:");
            console.log(convertKnockoutToObject(item, createObject(item)));
        }
        var history = new HistoryView();
        history.show(item);
    }

	self.danhSachTrangThai = ko.observableArray();

	self.layDanhSachTrangThai = function() {
		self.danhSachTrangThai.removeAll();
		callApi(pathAPI + '/findAllStatus', null, function (d) {
            self.danhSachTrangThai.push({fiCode: '-1', fiStatusName: i18nextko.t('choose')});
            readArrayObjects(d.data, function(item) {
                self.danhSachTrangThai.push(item);
            });
        })
	}
	self.layDanhSachTrangThai();

	self.load = function(page) {

        if (self.searchForm.valid.errors().length > 0) {
            showError(self.searchForm.valid());
            self.searchForm.valid.errors.showAllMessages();
            return;
        }
		$('#showLoadingIcon').show();

        var searchItem = convertKnockoutToObject(self.searchForm, createObject(self.searchForm));
        searchItem.pageIndex = page - 1;
        if (searchItem.fiStatus == '-1') searchItem.fiStatus = null;

        callApi('/mic/04/tbdHoSo04/page', searchItem, function (d) {
            self.dataTable.removeAll();
            self.totalElements(d.data.totalElements);
            if (d.data.content) {
                d.data.content.forEach(function (item) {
                    var hoSo = convertObjectToKnockout(item, new HoSoDTO());
                    self.checkShowHideButton(hoSo);
                    self.dataTable.push(hoSo);
                })
            }
        });

	}

	self.load(1);

	self.checkShowHideButton = function(item) {
		item.actionSuaHoSoEnable(self.showButtonEdit(item.fiStatus()));
		item.actionXoaHoSoEnable(self.showButtonDelete(item.fiStatus()));
		item.actionXemGiayPhepEnable(self.showButtonXemGXN(item.fiStatus()));
		item.actionXinRutHoSoEnable(self.showButtonXinRut(item.fiStatus()));
		item.actionXinSuaHoSoEnable(self.showButtonXinSuaHoSo(item.fiStatus()));
		item.actionSuaGiayPhepEnable(self.showButtonXinSuaGiayPhep(item.fiStatus()));
	}

	self.showButtonEdit = function(status) {
		if (status === 0) return true;
		if (status === 1) return true;
		if (status === 4) return true;
		if (status === 5) return true;

		return false;
	}

	self.showButtonDelete = function(status) {
		if (status === 0) return true;
		return false;
	}

	self.showButtonXemGXN = function(status) {
		if (status === 11) return true;
        if (status === 12) return true;
		if (status === 14) return true;
        if (status === 15) return true;
		return false;
	}

	self.showButtonXinRut = function(status) {
		if (status === 1) return true;
		if (status === 2) return true;
		if (status === 3) return true;
        if (status === 4) return true;
        if (status === 5) return true;
        if (status === 16) return true;
		return false;
	}

	self.showButtonXinSuaHoSo = function(status) {
		if (status === 3) return true;
		return false;
	}

    self.showButtonXinSuaGiayPhep = function(status) {
        if (status === 11) return true;
        if (status === 14) return true;
        if (status === 15) return true;
        return false;
    }

	self.searchHoSo = function() {
        self.currentPage(1);
        self.load(1);
	}


	self.pageClick = function (page) {
		self.currentPage(page);
		self.load(page);
    }
}