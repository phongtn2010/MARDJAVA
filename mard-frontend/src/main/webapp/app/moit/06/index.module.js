/**
 * @returns
 */
/**
 * @returns
 */
$(document).ready(function() {
function ViewModel() {

	var self = this;
	
	 $(".select2").select2({placeholder: '',  width: '100%'});
	  
     $('.date-picker').datepicker({rtl: false, orientation: "left", autoclose: true});
	
     //xem giay xac nhan
	self.xemGiayXacNhanClick = function(item) {
		 var gxn = new GiayXacNhanView();
		  gxn.show(item);
	}
	
	//yeu cau rut ho so
    self.huyHoSo = function(item) {
    		var huyHS = new HuyHoSoView();
    		huyHS.show(item, function(){
                  setTimeout(function(){
                	  location.reload();
                  }, 1000);
    		});
	}
    
	// danh sach ho so
	var SearchFormModel = function() {
		this.maHoSo = ko.observable(null);
		this.trangThai = ko.observable(-1);
		this.fromNgayNop = ko.observable(null).extend({dateVI: true, maxLength: 12});
		this.toNgayNop = ko.observable(null).extend({dateVI: true, maxLength: 12});
		this.fromNgayCapGiayPhep = ko.observable(null).extend({dateVI: true, maxLength: 12});
		this.toNgayCapGiayPhep = ko.observable(null).extend({dateVI: true, maxLength: 12});
		this.maSoGP = ko.observable(null);
		this.maSoThue = ko.observable(null);
        this.valid = ko.validatedObservable(this);
	}
	
	self.searchForm = new SearchFormModel();
	
	self.danhSachHoSo = ko.observableArray();
	
	self.tongSoHoSo =  ko.observable(0);
	
	self.pagingVM = new PagingVM({pageSize: 15, totalCount: 0});
	
	self.totalData = ko.observable(0);
	
	self.layDanhSachHoSo = function(searchItem) {

        self.searchForm['fromNgayNop'].rules.remove(function (item) {
            return item.rule == "dateVI";
        });
        self.searchForm['fromNgayNop'].extend({
            dateVI: true
        });
        self.searchForm['toNgayNop'].rules.remove(function (item) {
            return item.rule == "dateVI";
        });
        self.searchForm['toNgayNop'].extend({
            dateVI: true
        });
        self.searchForm['fromNgayCapGiayPhep'].rules.remove(function (item) {
            return item.rule == "dateVI";
        });
        self.searchForm['fromNgayCapGiayPhep'].extend({
            dateVI: true
        });
        self.searchForm['toNgayCapGiayPhep'].rules.remove(function (item) {
            return item.rule == "dateVI";
        });
        self.searchForm['toNgayCapGiayPhep'].extend({
            dateVI: true
        });

        self.searchForm['toNgayNop'].rules.remove(function (item) {
            return item.rule == "greaterThanOrEqual";
        });
        self.searchForm['toNgayNop'].extend({
            greaterThanOrEqual: self.searchForm.fromNgayNop()
        });

        self.searchForm['toNgayCapGiayPhep'].rules.remove(function (item) {
            return item.rule == "greaterThanOrEqual";
        });
        self.searchForm['toNgayCapGiayPhep'].extend({
            greaterThanOrEqual: self.searchForm.fromNgayCapGiayPhep()
        });

        if (self.searchForm.valid.errors().length > 0) {
            showError(self.searchForm.valid());
            self.searchForm.valid.errors.showAllMessages();
            return;
        }

		self.danhSachHoSo.removeAll();
		
		$('#loading_c4e6a343-dd41-b5c5-1ef9-75eeebba032d').show();
		
		var uri = "/moit/api/06";
		console.log(JSON.stringify(searchItem));
		self.danhSachHoSo.removeAll();
		app.makePost({
            url: uri + '/layDsHoSo',
            data: JSON.stringify(searchItem),
            success: function (d) {
                $('#loading_c4e6a343-dd41-b5c5-1ef9-75eeebba032d').hide();
                if (d.success) {
                    self.pagingVM.totalCount(d.total);
                    self.totalData(d.total);
                    if (d.total == 0 ) {
                    	self.pagingVM.currentPage(0);
                    }
            		if (d.data != null) {
            			d.data.forEach(function (item, index) {
            				item.soThuTu = (searchItem.pageIndex -1) * 15 + index + 1;
                			var model = new HoSoModel();
                			model.soThuTu(item.soThuTu);
                			model.idHoSo(item.idHoSo);
                			model.maHoSo(item.maHoSo);
                			model.tenDoanhNghiep(item.tenDoanhNghiep);
                			model.ngayNop(item.ngayNop);
                			model.ngayCapGiayPhep(item.ngayCapGiayPhep);
                			model.tenTrangThai(item.tenTrangThai);
                			model.trangThai(item.trangThai);
                			self.changeStatus(model);
                			
    						self.danhSachHoSo.push(model);
                	       });
            		}
            		
            		self.tongSoHoSo(d.total);
                } 
                
            },
            error: function (e) {
                $('#loading_c4e6a343-dd41-b5c5-1ef9-75eeebba032d').hide();
                toastr.error(e.message, NSWLang["common_msg_thong_bao"]);
            }
        });
		
	}
	
	self.changeStatus = function(item) {
		item.showButtonEdit(self.showButtonEdit(item.trangThai()));
		item.showButtonDelete(self.showButtonDelete(item.trangThai()));
		item.showButtonXinRut(self.showButtonXinRut(item.trangThai()));
		item.showButtonXemGXN(self.showButtonXemGXN(item.trangThai()));
		item.showButtonXinSua(self.showButtonXinSua(item.trangThai()));
	}
	
	self.showButtonEdit = function(status) {
		
		if (status == 0) return true;
		if (status == 1) return true;
		if (status == 7) return true;
		if (status == 4) return true;
		
		return false;
	}
	
	self.showButtonXinRut = function(status) {
		if (status == 1) return true;
		if (status == 5) return true;
		if (status == 7) return true;
		if (status == 9) return true;
		if (status == 10) return true;
		if (status == 15) return true;
		if (status == 16) return true;
		if (status == 4) return true;
		
		return false;
	}
	
	self.showButtonXinSua = function(status) {
		
		if (status == 5) return true;
		if (status == 9) return true;
		if (status == 10) return true;
		
		return false;
	}
	
	self.showButtonDelete = function(status) {
		
		if (status == 0) return true;
		
		return false;
	}
	
	self.showButtonXemGXN = function(status) {
		
		if (status == 15) return true;
		if (status == 16) return true;
		
		return false;
	}
	
	self.searchByItem = {
	}
	
	self.searching = function() {
		self.pagingVM.totalCount(0);
		if(self.searchForm.maHoSo() != null){
			self.searchByItem.maHoSo = self.searchForm.maHoSo().trim();
		}
		if(self.searchForm.fromNgayNop() != null){
			self.searchByItem.fromNgayNop = self.searchForm.fromNgayNop();
		}
		if(self.searchForm.toNgayNop() != null){
			self.searchByItem.toNgayNop = self.searchForm.toNgayNop();
		}
		if(self.searchForm.fromNgayCapGiayPhep() != null){
			self.searchByItem.fromNgayCapGiayPhep = self.searchForm.fromNgayCapGiayPhep();
		}
		if(self.searchForm.toNgayCapGiayPhep() != null){
			self.searchByItem.toNgayCapGiayPhep = self.searchForm.toNgayCapGiayPhep();
		}
		self.searchByItem.trangThai = self.searchForm.trangThai();
		self.searchByItem.maSoThue = self.searchForm.maSoThue();
		self.searchByItem.maSoGP = self.searchForm.maSoGP();
		self.searchByItem.pageIndex = self.pagingVM.currentPage() < 1 ? 1 : self.pagingVM.currentPage();
		self.layDanhSachHoSo(self.searchByItem);
		
	}
	
	self.searchHoSo = function() {		
		self.pagingVM.currentPage(1);
		self.searching();
	}
	self.validDate = function(d1, d2) {
		if (d1 != null && d1 != '' && d2 != null && d2 != '') {
			var f = self.toDate(d1);
			var t = self.toDate(d2);
			if (f != null && t != null) {
				if (f.getTime() > t.getTime()) {
					app.Alert( NSWLang["moit_06_form_timkiem_ngaytao"]);
					return false;
				}
			}
		}
		return true;
	}
	
	
	self.searching();
	
	self.goToPage = function (page) {
        if (page >= self.pagingVM.firstPage && page <= self.pagingVM.lastPage()) {
        	 self.pagingVM.setCurrentPage(page);
        	 self.searching();
        }
           
    };
    
	 self.goToFirst = function () {
	        self.pagingVM.setCurrentPage(self.pagingVM.firstPage);
	        self.searching();
	  };
	  
    self.goToPrevious = function () {
        var previous = self.pagingVM.previousPage();
        if (previous != null) {
        	 self.pagingVM.setCurrentPage(previous);
        	 self.searching();
        }
           
    };

    self.goToNext = function () {
        var next = self.pagingVM.nextPage();
        if (next != null) {
        	 self.pagingVM.setCurrentPage(next);
        	 self.searching();
        }
           
    };

    self.goToLast = function () {
        self.pagingVM.setCurrentPage(self.pagingVM.lastPage());
        self.searching();
    };
	
	self.danhSachTrangThai = ko.observableArray();
	self.layDanhSachTrangThai = function() {
		
		var uri = "/moit/api/06";
		self.danhSachTrangThai.removeAll();
		app.makePost({
            url: uri + '/layDsTrangThai',
            data: JSON.stringify({}),
            success: function (d) {
                if (d.success) {
                    self.danhSachTrangThai.push({tenTrangThai: NSWLang["moit_06_msg_chon"], idTrangThai: -1});
            		d.data.forEach(function (item, index) {
            			self.danhSachTrangThai.push(item);
            	       });
                }
            },
            error: function (e) {
                toastr.error(e.message, NSWLang["common_msg_thong_bao"]);
            }
        });
	}
	
	self.layDanhSachTrangThai();
	
	
	// xoa ho so
	self.xoaHoSo = function(item) {
		var xoaHS = new XoaHoSoView();
		xoaHS.show(item, function(){
			self.searching();
		});
	}
	
	
	self.themMoiHoSo = function() {
		location.href = app.appContext + '/moit/06/edit';
	}
	
	self.chinhSuaHoSo = function(item) {
		location.href= app.appContext + '/moit/06/edit/' + item.idHoSo();
	}
	
	self.xinSuaHoSo = function(item) {
		location.href= app.appContext + '/moit/06/edit/' + item.idHoSo() + '/ycs';
	}
	
	self.xemHoSo = function(item) {
		location.href= app.appContext + '/moit/06/view/' + item.idHoSo();
	}
	
	
	// ket qua xu ly
	self.xemLichSu = function(item) {
		var history = new HistoryView();
		history.show(item);
	}
	
	self.toDate = function(dateStr) {
		var splits = dateStr.split("/");
		var day = splits[0];
		var month = splits[1];
		var year = splits[2];
	    return new Date(year, month - 1, day);
	}
	
}

var vm = new ViewModel();
ko.applyBindings(vm);
});
