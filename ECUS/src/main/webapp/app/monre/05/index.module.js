/**
 * @returns
 */
/**
 * @returns
 */
$(document).ready(function() {
function ViewModel() {

	var self = this;
	self.contextPath = ko.observable($('#contextPath').val());
	 $(".select2").select2({placeholder: '',  width: '100%'});
	  
     $('.date-picker').datepicker({rtl: false, orientation: "left", autoclose: true});
     self.xinRutThatBai = ko.observable(false);
     self.xinRutThanhCong = ko.observable(false);
     self.actionMessage = ko.observable('');
	self.layCoSoSanXuatTheoGXN = function(idGXN, onSuccess) {
		var uri = $('#uriContextPath').val();
		app.makePost({
            url: uri + '/layThongTinCoSoSXTheoSoGXN/'+ idGXN,
            data: JSON.stringify({}),
            success: function (d) {
                if (d.success) {
            		onSuccess(d);
                } 
            },
            error: function (e) {
            }
        });
	}
	
	self.layPheLieuTheoGXN = function(idGXN, onSuccess) {
		var uri = $('#uriContextPath').val();
		app.makePost({
            url: uri + '/layThongTinPheLieuTheoSoGXN/'+ idGXN,
            data: JSON.stringify({}),
            success: function (d) {
                if (d.success) {
            		onSuccess(d);
                }
            },
            error: function (e) {
            }
        });
	}
	
	
	//xem giay xac nhan click
	self.xemGiayXacNhanClick = function(item) {
		var uri = $('#uriContextPath').val();
		var ctx = $('#contextPath').val();
		app.makePost({
            url: uri + '/layThongTinSoGXN/'+ item.idHS() +'/' + item.maHoSo(),
            data: JSON.stringify({}),
            success: function (d) {
                var msg = '';
                var fun = 'success';
                if (d.success) {
                	var data = {
                			gxn: d.data, ctx: ctx
                	};
                    msg = NSWLang["monre_01_error_message_thong_tin_giay_xac_nhan_tim_thay"] + '<b> ' + d.data.soGiayXN + "</b>";
                    
                    self.layCoSoSanXuatTheoGXN(d.data.idGxn, function(pResult) {
	                	data.coSoSanXuats = pResult.data;
	                	self.layPheLieuTheoGXN(d.data.idGxn, function(pResult) {
                      var klCongSuatTemp = [];
	                		$(pResult.data).each(function(index, item){
                      klCongSuatTemp.push(item.klCongSuat);
                      });
                      //handlerBar expression
	                    data.klCongSuats = klCongSuatTemp[0];
	                    data.pheLieus = pResult.data;
	                      	 var callback = function (html) {
	                             var pop = app.popup({
	                                 title: NSWLang["monre_01_xem_giay_xac_nhan_label_popup"] + ' - ' + item.maHoSo(),
	                                 html: html,
	                                 width: 960,
	                                 buttons: [
	                                     {
	                                         name: NSWLang["common_button_dong"],
	                                         class: 'btn',
	                                         icon: 'fa-remove',
	                                         action: function () {
	                                        	 app.popupRemove(pop.selector);
	                                         }
	                                     }
	                                 ]
	                             });
	                         };
	                		 
	                		 app.complieTemplate({
	                	            ministryCode: "monre",
	                	            code: "05",
	                	            templateName: "xem_giay_xac_nhan",
	                	            data: data
	                	        }, callback);
	                      });
                    });
                  
                   
                } else {
                    msg = NSWLang["monre_01_error_message_thong_tin_giay_xac_nhan_khong_tim_thay"] + '<b> ' + d.data.soGiayXN + "</b>";
                    fun = 'error';
                }
            },
            error: function (e) {
                $('#loading_thong-tin-co-soc4e6a343-dd41-b5c5-1ef9-75eeebba032d').hide();
                $('#loading_thong-phe-lieu-tu-giay-c4e6a343-dd41-b5c5-1ef9-75eeebba032d').hide();
                toastr.error(NSWLang["monre_01_error_message_thong_tin_giay_xac_nhan_khong_tim_thay"], NSWLang["common_msg_thong_bao"]);
            }
        });
	}
	
	
	//danh sach ho so
	
	var SearchFormModel = function() {
		
		this.maHoSo = ko.observable(null);
		
		this.trangThai = ko.observable(-1);
		
		this.ngayTaoTuNgay = ko.observable(null);
		
		this.ngayTaoDenNgay = ko.observable(null);
		
		this.ngayGuiTuNgay = ko.observable(null);
		
		this.ngayGuiDenNgay = ko.observable(null);
		this.maSoThue = ko.observable(null);
		this.soGiayXN = ko.observable(null);
	}
	
	self.searchForm = new SearchFormModel();
	
	self.danhSachHoSo = ko.observableArray();
	
	self.tongSoHoSo =  ko.observable(0);
	
	self.pagingVM = new PagingVM({pageSize: 15, totalCount: 0});

	self.totalData = ko.observable(0);
	
	self.layDanhSachHoSo = function(searchItem) {
		
		self.danhSachHoSo.removeAll();
		
		$('#loading_c4e6a343-dd41-b5c5-1ef9-75eeebba032d').show();
		
		var uri = $('#uriContextPath').val();
		self.danhSachHoSo.removeAll();
		app.makePost({
            url: uri + '/danhSachHoSo',
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
                			
            					var hoSoModel = new HoSoModel();
                    			hoSoModel.soThuTu(item.soThuTu);
                    			hoSoModel.idHS(item.idHS);
                    			hoSoModel.maHoSo(item.maHoSo);
                    			hoSoModel.tenDN(item.tenDN);
                    			hoSoModel.ngayGui(item.ngayGui);
                    			hoSoModel.ngayCap(item.ngayCap);
                    			hoSoModel.tenTrangThai(item.tenTrangThai);
                    			hoSoModel.trangThai(item.trangThai);
                    			hoSoModel.soGiayXN(item.soGiayXN);
                    			
                    			hoSoModel.showButtonEdit(self.showButtonEdit(item.trangThai));
                    			hoSoModel.showButtonDelete(self.showButtonDelete(item.trangThai));
                    			hoSoModel.showButtonXemGXN(self.showButtonXemGXN(item.trangThai));
                    			hoSoModel.showButtonTBPhi(self.showButtonTBPhi(item.trangThai));
                    			hoSoModel.showButtonXinRut(self.showButtonXinRut(item.trangThai));
                    			
        						self.danhSachHoSo.push(hoSoModel);
                	       });
            		}
            		
            		self.tongSoHoSo(d.total);
                }
                
            },
            error: function (e) {
                console.log(e);
                $('#loading_c4e6a343-dd41-b5c5-1ef9-75eeebba032d').hide();
                toastr.error(e.message, NSWLang["common_msg_thong_bao"]);
            }
        });
		
	}
	
self.showButtonEdit = function(status) {
		
		if (status == 0) return true;
		if (status == 1) return true;
		if (status == 6) return true;
		
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

	self.showButtonTBPhi = function(status) {
	
		if (status == 8) return true;
		
		return false;
	}
	
	self.showButtonXinRut = function(status) {
		
		if (status == 1) return true;
		if (status == 2) return true;
		if (status == 4) return true;
		if (status == 5) return true;
		if (status == 6) return true;
		if (status == 7) return true;
		if (status == 8) return true;
		if (status == 9) return true;
		if (status == 10) return true;
		if (status == 24) return true;
		
		return false;
	}
	self.searchByItem = {
			maHoSo: null,
			ngayTaoStart: null,
			ngayTaoEnd: null,
			ngayCapStart: null,
			ngayCapEnd: null,
			trangThai: -1,
			pageIndex: 1
	}
	
	self.searching = function() {
		self.pagingVM.totalCount(0);
		self.searchByItem.maHoSo = self.searchForm.maHoSo();
		self.searchByItem.ngayTaoStart = self.searchForm.ngayTaoTuNgay();
		self.searchByItem.ngayTaoEnd = self.searchForm.ngayTaoDenNgay();
		self.searchByItem.ngayCapStart = self.searchForm.ngayGuiTuNgay();
		self.searchByItem.ngayCapEnd = self.searchForm.ngayGuiDenNgay();
		self.searchByItem.trangThai = self.searchForm.trangThai();
		self.searchByItem.maSoThue = self.searchForm.maSoThue();
		self.searchByItem.soGXNDaCap = self.searchForm.soGiayXN();
		self.searchByItem.pageIndex = self.pagingVM.currentPage();
		self.layDanhSachHoSo(self.searchByItem);
	}
	
	self.searchHoSo = function() {
		self.pagingVM.currentPage(1);
		self.searching();
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
		
		var uri = $('#uriContextPath').val();
		self.danhSachTrangThai.removeAll();
		app.makePost({
            url: uri + '/danhSachTrangThai',
            data: JSON.stringify({}),
            success: function (d) {
                if (d.success) {
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
	
	
	
	
	self.xemHoSo = function(item) {
		
		location.href= self.contextPath() + '/view/' + item.idHS();
		
	}
	
	//ket qua xu ly
	self.pages = ko.observableArray();
	self.dsKetQuaXuLy = ko.observableArray();
	self.ketQuanXuLyCuaHS = ko.observable(0);
	

	
}

var vm = new ViewModel();
ko.applyBindings(vm);
});