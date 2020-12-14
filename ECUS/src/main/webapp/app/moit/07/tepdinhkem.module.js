function ThongTinTepDinhKemViewModel(hoSo) {
	var self = this;
//	console.log(hoSo);
	self.accepFiles = ['jpg', 'pdf', 'tif', 'JPG', 'PDF', 'TIF'];
	
	self.xemHoSo = ko.observable(xemHoSo);
	self.danhMucTeps = ko.observableArray();
	self.selectedTep = ko.observable('XNK_TC_MA_TUY');
	
	self.teps = ko.observableArray();
	
	hoSo.danhMucTepDinhKems.forEach(function(item, index){
		self.danhMucTeps.push(item);
		self.teps.push(ko.observableArray([]));
	});
	
	self.layDanhSachTepTinTheoHS = function(){
		 hoSo.danhMucTepDinhKems.forEach(function(t, tIndex){
     		 $(hoSo.tepDinhKems).each(function(index, loopItem){
     			 if (t.maLoaiTep == loopItem.maLoaiTep) {
     				 var tepTin = new TepTinModel();
                     tepTin.idTepTin(loopItem.idTepTin);
                     tepTin.idHoSo(loopItem.idHoSo);
                     tepTin.guID(loopItem.guID);
                     tepTin.duongDanFile(loopItem.duongDanFile);
                     tepTin.tenTepDinhKem(loopItem.tenTepDinhKem);
                     tepTin.maLoaiTep(loopItem.maLoaiTep);
                     tepTin.link(app.appContext +  '/moit/api/07/download/' + loopItem.idTepTin);
                     self.teps()[tIndex].push(tepTin);
     			 }
    			
    		 });
     	});
	}
	
	self.layDanhSachTepTinTheoHS();
	
	self.totalFileSize = ko.observable(hoSo.totalFileSize);
	self.uploadFileChangeEvent = function(loaiTep, position, elemet, event) {
		var files = event.target.files;
		for (var i = 0, file; file = files[i]; i++) {
			var ext = file.name.substr(file.name.lastIndexOf('.') + 1);
			if ($.inArray(ext, self.accepFiles) === -1) {
				$('#fileUpload' + position).val('');
				app.Alert(NSWLang["moit_06_form_teptin_error_3"]);
				return false;
			}
		}
		var totalMB = 1024 * 1024 * 4;// 3MB
		
	   	$(files).each(function(index, item){
	   		self.totalFileSize(self.totalFileSize() + item.size);
	   	});
	   	 if (self.totalFileSize() > totalMB) {
	   		cssError('fileUpload' + position);
	   	  	$(files).each(function(index, item){
		   		self.totalFileSize(self.totalFileSize() - item.size);
		   	});
	   	  	$('#fileUpload' + position).val('');
	   		 app.Alert(NSWLang["moit_06_totalSizeUploadError"] + ' 4MB!');
	   		 return false;
	   	 }
		 var findId = idHoSo;
			for (var k = 0; k < files.length; k++) {
				var param = {};
				param.mcode = "moit";
				param.pcode = "07";
				param.file = files[k];
		        app.uploadFile({
		          url: '/moit/api/07/upload/' + findId + '/' + loaiTep,
		          data: param,
		          success: function (d) {
		            if (d.success) {
		            	 var tepTin = new TepTinModel();
			                tepTin.idTepTin(d.data.idTepTin);
			                tepTin.idHoSo(findId);
			                tepTin.guID(d.data.guID);
			                tepTin.duongDanFile(d.data.duongDanFile);
			                tepTin.tenTepDinhKem(d.data.tenTepDinhKem);
			                tepTin.maLoaiTep(d.data.maLoaiTep);
			                tepTin.loaiTep(d.data.loaiTep);
			                tepTin.size(d.data.size);
			                if (idHoSo > 0) {
			                	  tepTin.link(app.appContext +  '/moit/api/07/download/' + d.data.idTepTin);
			                } else {
			                	tepTin.link(app.appContext +  '/moit/api/07/getfile/moit/07/' + d.data.guID + '.' + d.data.loaiTep);
			                }
			                self.teps()[position].push(tepTin);
		            }
		             $('#fileUpload' + position).val('');
		          },
		          error: function (e) {
		          	console.log(e);
		          	 $('#fileUpload' + position).val('');
		          	toastr.error(NSWLang["common_msg_thong_bao"], e.message);
		          }
		      });
	        
	        cssSuccess('fileUpload' + position);
		}
		
	}
	
	
	
	self.xoaTepTin = function(position) {
		
		var idHS = idHoSo;
		if (idHS > 0) {
			var pop = app.popup({
	             title: NSWLang["common_msg_thong_bao"],
	             html: '<i class="fa fa-3x fa-warning"></i> ' + NSWLang["common_msg_xoa_ho_so"],
	             width: 400,
	             buttons: [
	                 {
	                     name: NSWLang["common_button_toi_chac_chan"],
	                     class: 'btn',
	                     icon: 'fa-check',
	                     action: function () {
	                    	 $(self.teps()[position]()).each(function(index, loopItem){
	                    		 app.makePost({
		                             url:'/moit/api/07/xoaTepDK/' + loopItem.idTepTin(),
		                             data: JSON.stringify({}),
		                             success: function (d) {
		                                 var msg = d.message;
		                                 var fun = 'success';
		                                 if (d.success) {
		                                     app.popupRemove(pop.selector);
		                                     self.teps()[position].remove(loopItem);
		                                     app.toast({
			                                     title: NSWLang["common_msg_thong_bao"],
			                                     message: msg,
			                                     function: fun
			                                 });
		                                     self.totalFileSize(self.totalFileSize() - d.data.size);
		                                 } else {
		                                     toastr.error(NSWLang["common_msg_thong_bao"], d.message);
		                                 }
		                                
		                             },
		                             error: function (e) {
		                                 console.log(e);
		                                 app.popupRemove(pop.selector);
		                                 toastr.error(NSWLang["common_msg_thong_bao"], e.message);
		                             }
		                         });
	        				 });
	                        
	                     }
	                 }
	             ]
	         });
		} else {
			$(self.teps()[position]()).each(function(index, loopItem){
				 self.totalFileSize(self.totalFileSize() - loopItem.size());
				  self.teps()[position].remove(loopItem);
			 });
		}
	}
	
	
	self.xoaMotFile = function(item, position) {
		var idHS = idHoSo;
		if (idHS > 0) {
			var pop = app.popup({
	             title: NSWLang["common_msg_thong_bao"],
	             html: '<i class="fa fa-3x fa-warning"></i> ' + NSWLang["common_msg_xoa_ho_so"],
	             width: 400,
	             buttons: [
	                 {
	                     name: NSWLang["common_button_toi_chac_chan"],
	                     class: 'btn',
	                     icon: 'fa-check',
	                     action: function () {
	                         app.makePost({
	                             url:'/moit/api/07/xoaTepDK/' + item.idTepTin(),
	                             data: JSON.stringify({}),
	                             success: function (d) {
	                                 var msg = d.message;
	                                 var fun = 'success';
	                                 if (d.success) {
	                                     app.popupRemove(pop.selector);
	                                     self.teps()[position].remove(item);
	                                     app.toast({
		                                     title: NSWLang["common_msg_thong_bao"],
		                                     message: msg,
		                                     function: fun
		                                 });
	                                     self.totalFileSize(self.totalFileSize() - d.data.size);
	                                 } else {
	                                     toastr.error(NSWLang["common_msg_thong_bao"], d.message);
	                                 }
	                                 
	                             },
	                             error: function (e) {
	                                 console.log(e);
	                                 app.popupRemove(pop.selector);
	                                 toastr.error(NSWLang["common_msg_thong_bao"], e.message);
	                             }
	                         });
	                     }
	                 }
	             ]
	         });
		} else {
			 self.totalFileSize(self.totalFileSize() - item.size());
			 self.teps()[position].remove(item);
		}
			 
	}
	
	
	 cssError = function(id) {
	 		var ele = $('#' + id);
	 		ele.focus();
	 		ele.css('border', '1px solid #f00');
	 		var p = $('span[aria-labelledby="select2-'+ id+'-container"]');
	 		p.css('border', '1px solid #f00');
	 	}
	  cssSuccess = function(id) {
	 		var ele = $('#' + id);
	 		ele.removeAttr('style');
	 		var p = $('span[aria-labelledby="select2-'+ id+'-container"]');
	 		p.removeAttr('style');
	 	}
	
	self.isValid = function(isGuiHoSo) {
		if (isGuiHoSo) {
   			for (var i = 0; i <  hoSo.danhMucTepDinhKems.length; i++) {
   			 var item = hoSo.danhMucTepDinhKems[i];
   				if (item.loaiTep == self.selectedTep() && item.required) {
       				if (self.teps()[i]().length == 0) {
       					app.Alert( NSWLang["moit_06_form_teptin_error_message"]);
       					return false;
       				}
   				}
   			}
   		 }
		return true;
	}
	
	
	self.getTepDinhKems = function() {
		var data = [];
		hoSo.danhMucTepDinhKems.forEach(function(item, index){
			 if (item.loaiTep == self.selectedTep()) {
				 $(self.teps()[index]()).each(function(tIndex, t){
					 data.push({
							idTepTin : t.idTepTin(),
							idHoSo : t.idHoSo(),
							guID : t.guID(),
							duongDanFile : t.duongDanFile(),
							tenTepDinhKem : t.tenTepDinhKem(),
							maLoaiTep : t.maLoaiTep()
						});
					});
			 }
	     });
		return data;
	}
}
