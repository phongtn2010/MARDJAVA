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
     
     self.showActionError = ko.observable(false);
     self.showActionSuccess = ko.observable(false);
     self.errorMessage = ko.observable('');
    
	
	self.xemGiayXacNhanClick = function(item) {
		 app.makePost({
	            url: '/sbv/api/01/layThongTinGP/' + item.idHoSo(),
	            data: JSON.stringify({}),
	            success: function (d) {
	                var fun = 'success';
	                if (d.success) {
	                	var callback = function (html) {
	                        var pop = app.popup({
	                            title: NSWLang["sbv_01_popup_xemgxn"] + ' - ' + item.maHoSo(),
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
	            		 console.log(d);
	            		 app.complieTemplate({
	            	            ministryCode: "sbv",
	            	            code: "01",
	            	            templateName: "xem_giay_xac_nhan",
	            	            data: d.data
	            	        }, callback);
	                } else {
	                    fun = 'error';
	                }
	               
	              
	            },
	            error: function (e) {
	            	console.log(e);
	            	toastr.error(e.message, NSWLang["common_msg_thong_bao"]);
	            }
	        });
		  
		
	}
	
	self.xemHoSoClick = function(item) {
		 app.makePost({
	            url: '/sbv/api/01/layThongTinHoSo/' + item.idHoSo(),
	            data: JSON.stringify({}),
	            success: function (d) {
	                var fun = 'success';
	                if (d.success) {
	                	var callback = function (html) {
	                        var pop = app.popup({
	                            title: NSWLang["sbv_01_popup_xemvanban"] + ' - ' + item.maHoSo(),
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
	            	            ministryCode: "sbv",
	            	            code: "01",
	            	            templateName: "xem_van_ban",
	            	            data: d.data
	            	        }, callback);
	                } else {
	                    fun = 'error';
	                }
	              
	              
	            },
	            error: function (e) {
	            	console.log(e);
	            	toastr.error(e.message, NSWLang["common_msg_thong_bao"]);
	            }
	        });
	}
	
	
	
	// danh sach ho so
	
	var SearchFormModel = function() {
		this.maHoSo = ko.observable(null);
		this.trangThai = ko.observable(-1);
		this.ngayTaoTuNgay = ko.observable(null);
		this.ngayTaoDenNgay = ko.observable(null);
		this.hinhThucXNK = ko.observable(null);
		this.maCuaKhau = ko.observable(null);
		this.cuaKhau = ko.observable(null);
		this.maSoThue = ko.observable(null);
		this.soGiayPhep = ko.observable(null);
	}
	
	self.searchForm = new SearchFormModel();
	
	self.danhSachHoSo = ko.observableArray();
	
	self.tongSoHoSo =  ko.observable(0);
	
	self.pagingVM = new PagingVM({pageSize: 15, totalCount: 0});
	
	self.totalData = ko.observable(0);
	
	self.layDanhSachHoSo = function(searchItem) {
		self.danhSachHoSo.removeAll();
		
		$('#loading_c4e6a343-dd41-b5c5-1ef9-75eeebba032d').show();
		
		var uri = "/sbv/api/01";
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
                			model.tenNganHang(item.tenNganHang);
                			model.ngayTao(item.ngayTao);
                			model.hinhThucXNK(item.hinhThucXNK == '1' ? NSWLang["sbv_01_msg_nhap_khau"] : NSWLang["sbv_01_msg_xuat_khau"]);
                			model.tenTrangThai(self.getStatusName(item.trangThai));
                			model.trangThai(item.trangThai);
                			model.soGiayPhep(item.soGiayPhep);
                			model.ngayCap(item.ngayCap);
                			
                			model.showButtonEdit(self.showButtonEdit(item.trangThai));
                			model.showButtonDelete(self.showButtonDelete(item.trangThai));
                			model.showButtonXemGXN(self.showButtonXemGXN(item.trangThai));
                			model.showButtonXinRut(self.showButtonXinRut(item.trangThai));
                			model.showButtonSend(self.showButtonSend(item.trangThai));
                			model.showButtonVanBan(self.showButtonVanBan(item.trangThai));
                			
    						self.danhSachHoSo.push(model);
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
	
	self.getStatusName = function(status) {
		
		if (status == '0') return NSWLang["sbv_01_status_01"];
		if (status == '1') return NSWLang["sbv_01_status_02"];
		if (status == '2') return NSWLang["sbv_01_status_03"];
		if (status == '3') return NSWLang["sbv_01_status_04"];
		if (status == '4') return NSWLang["sbv_01_status_05"];
		if (status == '5') return NSWLang["sbv_01_status_06"];
		if (status == '6') return NSWLang["sbv_01_status_07"];
		if (status == '7') return NSWLang["sbv_01_status_08"];
		if (status == '8') return NSWLang["sbv_01_status_09"];
		if (status == '9') return NSWLang["sbv_01_status_10"];
	}
	
	self.showButtonEdit = function(status) {
		
		if (status == 0) return true;
		if (status == 1) return true;
		if (status == 5) return true;
		
		return false;
	}
	
	self.showButtonDelete = function(status) {
		
		if (status == 0) return true;
		
		return false;
	}
	
	self.showButtonXemGXN = function(status) {
		
		if (status == 8) return true;
		
		return false;
	}

	
	self.showButtonXinRut = function(status) {
		
		if (status == 1) return true;
		if (status == 3) return true;
		if (status == 4) return true;
		if (status == 5) return true;
		
		return false;
	}
	
	self.showButtonSend = function(status) {
		
		if (status == 0) return true;
		if (status == 1) return true;
		if (status == 5) return true;
		
		return false;
	}
	
	self.showButtonVanBan = function(status) {
		
		return true;
	}
	
	self.searchByItem = {
			maHoSo: null,
			formNgayTao: null,
			toNgayTao: null,
			hinhThucXNK: -1,
			maCuaKhau: -1,
			trangThai: -1,
			pageIndex: 1
	}
	
	self.searching = function() {
		self.pagingVM.totalCount(0);
		self.searchByItem.maHoSo = self.searchForm.maHoSo();
		self.searchByItem.fromNgayTao = self.searchForm.ngayTaoTuNgay();
		self.searchByItem.toNgayTao = self.searchForm.ngayTaoDenNgay();
		self.searchByItem.maCuaKhau = self.searchForm.maCuaKhau();
		self.searchByItem.hinhThucXNK = self.searchForm.hinhThucXNK();
		self.searchByItem.trangThai = self.searchForm.trangThai();
		self.searchByItem.maSoThue = self.searchForm.maSoThue();
		self.searchByItem.soGiayPhep = self.searchForm.soGiayPhep();
		self.searchByItem.pageIndex = self.pagingVM.currentPage() < 1 ? 1 : self.pagingVM.currentPage();
		self.layDanhSachHoSo(self.searchByItem);
	}
	
	self.searchHoSo = function() {
		
		var from = $("#ngayTaoTuNgay").val();
		var to = $("#ngayTaoDenNgay").val();
		var f = self.toDate(from);
		var t = self.toDate(to);
		if (from != null && to != null) {
			if (f.getTime() > t.getTime()) {
				app.Alert( NSWLang["sbv_01_form_timkiem_ngaytao"]);
				return false;
			}
		}
		
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
	
	self.danhSachhinhThucXNK = ko.observableArray();
	self.danhSachhinhThucXNK.push({tenHinhThuc: NSWLang["sbv_01_msg_chon"], giaTri: -1});
	self.danhSachhinhThucXNK.push({tenHinhThuc:  NSWLang["sbv_01_msg_nhap_khau"], giaTri: 1});
	self.danhSachhinhThucXNK.push({tenHinhThuc:  NSWLang["sbv_01_msg_xuat_khau"], giaTri: 2});
	
	
	self.layDanhSachTrangThai = function() {
		
		var uri = "/sbv/api/01";
		self.danhSachTrangThai.removeAll();
		app.makePost({
            url: uri + '/layDsTrangThai',
            data: JSON.stringify({}),
            success: function (d) {
                if (d.success) {
                    self.danhSachTrangThai.push({tenTrangThai: NSWLang["sbv_01_msg_chon"], giaTri: -1});
            		d.data.forEach(function (item, index) {
            			self.danhSachTrangThai.push(item);
            	       });
                }
            },
            error: function (e) {
                console.log(e);
                toastr.error(e.message, NSWLang["common_msg_thong_bao"]);
            }
        });
	}
	
	self.layDanhSachTrangThai();
	
	self.danhSachCuaKhau = ko.observableArray();
	
	self.layDanhSachCuaKhau = function() {
		
		var uri = "/sbv/api/01";
		self.danhSachCuaKhau.removeAll();
		app.makePost({
            url: uri + '/layDsCuaKhau',
            data: JSON.stringify({}),
            success: function (d) {
                if (d.success) {
                    self.danhSachCuaKhau.push({tenCuaKhau: NSWLang["sbv_01_msg_chon"], maCuaKhau: '-1'});
            		d.data.forEach(function (item, index) {
            			self.danhSachCuaKhau.push(item);
            	       });
                }
            },
            error: function (e) {
                console.log(e);
                toastr.error(e.message, NSWLang["common_msg_thong_bao"]);
            }
        });
	}
	
	self.layDanhSachCuaKhau();
	
	// xoa ho so
	self.xoaHoSo = function(item) {
		
        var docCode = item.maHoSo();
        
        var postData = {
             
            };

            var pop = app.popup({
                title: NSWLang["common_msg_thong_bao"],
                html: '<i class="fa fa-3x fa-warning"></i> ' + NSWLang["common_msg_xoa_ho_so"] + ' <b>'+ docCode +'</b>',
                width: 400,
                buttons: [
                    {
                        name: NSWLang["common_button_toi_chac_chan"],
                        class: 'btn',
                        icon: 'fa-check',
                        action: function () {
                            app.makePost({
                                url: '/sbv/api/01/deleteHoSo/' + item.idHoSo(),
                                data: JSON.stringify(postData),
                                success: function (d) {
                                    var msg = '';
                                    var fun = 'success';
                                    if (d.success) {
                                        msg = NSWLang["common_msg_cap_nhat_du_lieu_thanh_cong"];
                                        app.popupRemove(pop.selector);
                                        self.searching();
                                    	
                                    } else {
                                        msg = data.message;
                                        fun = 'error';
                                    }
                                    app.toast({
                                        title: NSWLang["common_msg_thong_bao"],
                                        message: msg,
                                        function: fun
                                    });
                                },
                                error: function (e) {
                                    console.log(e);
                                    toastr.error(e.message, NSWLang["common_msg_thong_bao"]);
                                }
                            });
                        }
                    }
                ]
            });
	}
	
	
	self.themMoiHoSo = function() {
		
		location.href = app.appContext + '/sbv/01/edit';
		
	}
	
	self.chinhSuaHoSo = function(item) {
		
		location.href= app.appContext + '/sbv/01/edit/' + item.idHoSo();
		
	}
	
	self.xemHoSo = function(item) {
		
		location.href= app.appContext + '/sbv/01/view/' + item.idHoSo();
		
	}
	
	
	
	// ket qua xu ly
	
	self.xemLichSu = function(item) {
		var url =  '/sbv/api/01/layDsLichSuHS/' + item.idHoSo() + '/1';
		app.makePost({
            url: url,
            data: JSON.stringify({}),
            success: function (d) {
                var msg = '';
                var fun = 'success';
                if (d.success) {
                    msg = d.message;
                    var total = 0;
                    if (d.data != null && d.data.length > 0) {
                    	total = d.total;
                    }
                    var callback = function (html) {
                        var pop = app.popup({
                            title: NSWLang["sbv_01_lichsh_table_00"] + ' - ' + item.maHoSo(),
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
	           	            ministryCode: "sbv",
	           	            code: "01",
	           	            templateName: "lich_su_tac_dong",
	           	            data: d.data
	           	        }, callback);
	           		 
	           		$('#' +'lich-su-pagination').pagination({
	                    items: total,
	                    itemsOnPage: 10,
	                    cssStyle: 'light-theme',
	                    edges: 2,
	                    displayedPages: 5,
	                    prevText: NSWLang['monre_01_pagination_trang_truoc'],
	                    nextText: NSWLang['monre_01_pagination_trang_sau'],
	                    onPageClick: function (pageNumber, event) {
	                		var url = '/sbv/api/01/layDsLichSuHS/' + item.idHoSo() + '/' +pageNumber;
	                    	 app.bindData({
	                             ministryCode: 'sbv',
	                             code: '01',
	                             templateName: "lich_su_tac_dong_item",
	                             container: '#historyContainer',
	                             url: url,
	                             data: JSON.stringify({})
	                         }, function (d) {
	                             console.log(d);
	                         });
	                    	 
	                        return false;
	                    }
	                });
                   
                } else {
                    msg = d.message;
                    fun = 'error';
                }
                
            },
            error: function (e) {
                console.log(e);
                toastr.error(e.message, NSWLang["common_msg_thong_bao"]);
            }
        });
	
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
