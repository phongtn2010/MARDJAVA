function ChiTietCuaKhauViewModel(hoSo, parent) {
	var self = this;
	
	self.danhSachCuaKhau= ko.observableArray();
	self.danhSachHSCuaKhau= ko.observableArray();
	self.tongSoHoSo =  ko.observable(0);
	self.dsCuaKhauDangChon = ko.observableArray();
	parent.dsCKs.removeAll();
	if(hoSo.idHoSo != null){
		hoSo.cuaKhaus.forEach(	        					
				function (item, index) {
				
    			var model = new CKModel();
    			//model.soThuTu(item.soThuTu);
    			model.idHoSo(hoSo.idHoSo);
    			model.maCuaKhau(item.maCuaKhau);
    			model.tenCuaKhau(item.tenCuaKhau);  
    			model.idCuaKhau(item.idCuaKhau);
			    self.danhSachHSCuaKhau.push(model);
			    
			   // self.dsCuaKhauDangChon(model);
			  
			    parent.dsCKs.push(model);
			    
			    
    	       }
			);
	}
	var SearchFormModel = function() {
		this.tenCuaKhau = ko.observable(null);
		this.maCuaKhau = ko.observable(null);
		this.pageSize = ko.observable(10);
		this.pageIndex = ko.observable(1);
	}
	self.searchForm = new SearchFormModel();	
	self.totalData = ko.observable(0);
	
	
	self.pagingVM = new PagingVM({pageSize: 10, totalCount: 0});
	layDanhSachCK({tenCuaKhau: null,maCuaKhau: null, pageSize: 10, pageIndex:1 });
	function layDanhSachCK(searchItem) {
	
		app.makePost({
	        url: '/moit/api/06/findByNameAndCode',
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
	        			//console.log(d.data);
	        			self.danhSachCuaKhau.removeAll();
	        			d.data.forEach(	        					
	        				function (item, index) {
	        				
	        				item.soThuTu = (searchItem.pageIndex -1) * 10 + index + 1;
	        				item.enable = true;
	            			var model = new CKModel();
	            			
	            			model.soThuTu(item.soThuTu);
	            			
	            			model.idHoSo(hoSo.idHoSo);
	            			model.maCuaKhau(item.maCuaKhau);
	            			model.tenCuaKhau(item.tenCuaKhau); 
	            			
	            			model.idCuaKhau(item.idCuaKhau);
	            		
	            			
	            			self.danhSachHSCuaKhau().forEach(function(it, index){
	            				
	            				if(it.maCuaKhau()== item.maCuaKhau){
	            					
	            					
	            					item.enable = false;
	            			  		}	            				
	            				
	            			});
	            			
	            			model.enable = ko.observable(item.enable);
	            			
						    self.danhSachCuaKhau.push(model);
						   
	            	       }
	        			);

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
		self.searchByItem = {
				tenCuaKhau: null,maCuaKhau: null, pageSize: 10, pageIndex:1 
				
		}
		var searching = function() {
			self.pagingVM.totalCount(0);
			if(self.searchForm.maCuaKhau() != null){
				self.searchByItem.maCuaKhau = self.searchForm.maCuaKhau().trim();
			}
			if(self.searchForm.tenCuaKhau() != null){
				self.searchByItem.tenCuaKhau = self.searchForm.tenCuaKhau().trim();
			}
			self.searchByItem.pageSize = self.searchForm.pageSize();
			self.searchByItem.pageIndex = self.pagingVM.currentPage() < 1 ? 1 : self.pagingVM.currentPage();
			//console.log(self.searchByItem.pageIndex);
			layDanhSachCK(self.searchByItem);
			
		}
		
		self.goToPage = function (page) {
	        if (page >= self.pagingVM.firstPage && page <= self.pagingVM.lastPage()) {
	        	 self.pagingVM.setCurrentPage(page);
	        	 searching();
	        }
	           
	    };
	    
		 self.goToFirst = function () {
		        self.pagingVM.setCurrentPage(self.pagingVM.firstPage);
		        searching();
		  };
		  
	    self.goToPrevious = function () {
	        var previous = self.pagingVM.previousPage();
	        if (previous != null) {
	        	 self.pagingVM.setCurrentPage(previous);
	        	 searching();
	        }
	           
	    };

	    self.goToNext = function () {
	        var next = self.pagingVM.nextPage();
	        if (next != null) {
	        	 self.pagingVM.setCurrentPage(next);
	        	 searching();
	        }
	           
	    };

	    self.goToLast = function () {
	        self.pagingVM.setCurrentPage(self.pagingVM.lastPage());
	        searching();
	    };
		
	    
	    self.searchCuaKhau = function() {		
			self.pagingVM.currentPage(1);
			searching();
			
		} 
		
		
//		
		
		self.checkboxClick = function(pItem, event) {
			//var exists = false;
			pItem.checked(event.target.checked);		
		
			if(pItem.checked() == false){
				//self.dsCuaKhauDangChon.remove(item);
				self.danhSachCuaKhau().forEach(function(item, index){
					if (pItem.idCuaKhau() == item.idCuaKhau()){ 
						exists = true;
						if (pItem.checked() == false) self.dsCuaKhauDangChon.remove(item);
						return false;
					}
				}) ;
				
				
			}else{
				
				self.dsCuaKhauDangChon.push(pItem);
			}
			
		}
		
		self.chon = function() {
			
			$('#loading_c4e6a343-dd41-b5c5-1ef9-75eeebba032d').show();
			self.dsCuaKhauDangChon().forEach(function(it, index){	
				self.danhSachCuaKhau().forEach(function(item, index){	
					if(item.maCuaKhau() == it.maCuaKhau()){	
						item.checked(false);
						item.enable(false);
						
						//pItem.enable(true);
				  	}		
				});
				
			});
			self.dsCuaKhauDangChon().forEach(function(it, index){				
				self.danhSachHSCuaKhau.push(it);
			});
			self.dsCuaKhauDangChon.removeAll();
		}
		self.checkDelete = function(pItem) {
			//console.log(pItem);
			self.danhSachCuaKhau().forEach(function(it, index){				
				if(it.maCuaKhau() == pItem.maCuaKhau()){	
					//console.log(it.enable());
					it.enable(true);
					
			  	}					
				
			});
		
			for(var i = 0; i < self.danhSachHSCuaKhau().length; i++ ){
				if (pItem.idCuaKhau() == self.danhSachHSCuaKhau()[i].idCuaKhau()){ 					
					self.danhSachHSCuaKhau.remove(self.danhSachHSCuaKhau()[i]);
					return false;
				}
			}
			
			
		}
		self.save = function() {
			parent.dsCKs.removeAll();
			self.danhSachHSCuaKhau().forEach(function(item, index){
				var data= {
						idCuaKhau: 0,
						idHoSo: hoSo.idHoSo,
						maCuaKhau: item.maCuaKhau,
						tenCuaKhau: item.tenCuaKhau,
						hoatDong: 1
						}
				parent.dsCKs.push(data);
			}) ;
		
			app.popupRemove(parent.appPopup.selector);
			
		}
		
		self.closePopup = function(){		
			 app.popupRemove(parent.appPopup.selector);
		}
		
		
		
}
