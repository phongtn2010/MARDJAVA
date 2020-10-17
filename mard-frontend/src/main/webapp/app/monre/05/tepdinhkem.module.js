function ThongTinTepDinhKemViewModel(hoSo) {
		
	var self = this;
	self.contextPath = ko.observable(uriContextPath);
	
	self.dsTepTinThemMoiHS = ko.observableArray();
	self.tepTinModel = new TepTinModel();
	self.accepFiles = ['jpg', 'pdf', 'tif', 'JPG', 'PDF', 'TIF'];
	
	self.shorten = function(value) {
		var length = 30;
		if (value == null) value = '';
		if (value.length <= length) return value;
		var sub = value.substring(0, length);
		for (var i = length; i < value.length; i++ ) {
			if (value[i] === ' ') {
				 sub += '...';
				 break;
			} else {
				sub += value[i];
			}
		}
		if (sub.length == value.length) sub = value.substring(0, length);
		return sub;
	}
	self.copyItem = function(item) {
		var pl = new TepTinModel();
		pl.index(item == null ? 0: item.index);
		pl.id(item == null ? '': item.id);
		pl.tenTepTin(item == null ? '': item.tenTepTin);
		pl.tenLoaiTep(item == null ? '': item.tenLoaiTep);
		pl.loaiTepTin(item == null ? '-1': item.loaiTepTin);
		pl.tenTepTinId(item == null ? 0: item.tenTepTinId);
		pl.idHS(item == null ? 0: item.idHS);
		return pl;
	}
	
	self.setTepTin = function(data) {
		var apiUrl = 'https://mdm.monre.gov.vn:8800/';
		 $(data).each(function(index, item){
			 item.link = apiUrl + "api/core/mdm/nodes/viewbyid/" + item.tenTepTinId;
			 item.name = item.tenTepTin;
  			 switch(item.loaiTepTin) {
  			 case 1:
  				 self.tepTinModel.tepLoai1.push(item);
  				 break;
  			 case 2:
  				self.tepTinModel.tepLoai2.push(item);
  				 break;
   			 case 3:
   				self.tepTinModel.tepLoai3.push(item);
  				 break;
   			 case 4:
   				self.tepTinModel.tepLoai4.push(item);
  				 break;
			 case 5:
				 self.tepTinModel.tepLoai5.push(item);
  				 break;
			 case 6:
				 self.tepTinModel.tepLoai6.push(item);
  				 break;
			 case 7:
				 self.tepTinModel.tepLoai7.push(item);
				 break;
   			 case 8:
   				 self.tepTinModel.tepLoai8.push(item);
  				 break;
  			 }
  		 });
	}
	
	self.layDanhSachTepTinTheoHS = function(){
		self.setTepTin(hoSo.tepDinhKemList);
	}
	
	self.layDanhSachTepTinTheoHS();
	
	self.xoaTep = function(loaiTep, item) {
		
		 switch(loaiTep) {
			 case 1:
				 if (item == null) {
					 self.tepTinModel.tepLoai1.removeAll();
				 } else {
					 self.tepTinModel.tepLoai1.remove(item);
				 }
				 break;
			 case 2:
				 if (item == null) {
					 self.tepTinModel.tepLoai2.removeAll();
				 } else {
					 self.tepTinModel.tepLoai2.remove(item);
				 }
				 break;
			 case 3:
				 if (item == null) {
					 self.tepTinModel.tepLoai3.removeAll();
				 } else {
					 self.tepTinModel.tepLoai3.remove(item);
				 }
				 break;
			 case 4:
				 if (item == null) {
					 self.tepTinModel.tepLoai4.removeAll();
				 } else {
					 self.tepTinModel.tepLoai4.remove(item);
				 }
				 break;
		 case 5:
			 if (item == null) {
				 self.tepTinModel.tepLoai5.removeAll();
			 } else {
				 self.tepTinModel.tepLoai5.remove(item);
			 }
				 break;
		 case 6:
			 if (item == null) {
				 self.tepTinModel.tepLoai6.removeAll();
			 } else {
				 self.tepTinModel.tepLoai6.remove(item);
			 }
				 break;
		 case 7:
			 if (item == null) {
				 self.tepTinModel.tepLoai7.removeAll();
			 } else {
				 self.tepTinModel.tepLoai7.remove(item);
			 }
			 break;
		 case 8:
			 if (item == null) {
				 self.tepTinModel.tepLoai8.removeAll();
			 } else {
				 self.tepTinModel.tepLoai8.remove(item);
			 }
			 break;
		 }
		 $(self.dsTepTinThemMoiHS()).each(function(index, pItem){
			 if (pItem != null && item != null && pItem.tenTepTinId() == item.tenTepTinId) {
				 self.dsTepTinThemMoiHS.remove(pItem);
			 }
		 });
		 $(self.dsTepTinThemMoiHS()).each(function(index, pItem){
			 pItem.index(index);
		 });
	}
	
	self.uploadFileChangeEvent = function(loaiTep, eleId, elemet, event) {
		var files = event.target.files;
		var idHS = idHoSo;
		for (var i = 0, file; file = files[i]; i++) {
			var ext = file.name.substr(file.name.lastIndexOf('.') + 1);
			if ($.inArray(ext, self.accepFiles) === -1) {
				$('#' + eleId).val('');
				app.Alert(NSWLang["monre_01_error_message_thong_tin_tep_tin_khong_hop_le"] + ' <b>' + self.accepFiles + "</b>");
				return false;
			}
		}
		var formData = new FormData();
		for (var i2 = 0, file2; file2 = files[i2]; i2++) {
			formData.append("file", file2);
		}
		var apiUrl = 'https://mdm.monre.gov.vn:8800/';
        var applicationId = '48ED5B71-66DC-4725-9604-4C042E45FA3F';
        var userId = 'e5e568d2-0226-4583-be08-fec5e36a8b4e';

        var dt = new Date();
        var y = dt.getFullYear();
        var d = (dt.getDate() >= 10) ? dt.getDate() : "0" + dt.getDate();
        var m = (dt.getMonth() >= 9) ? dt.getMonth() + 1 : "0" + (dt.getMonth() + 1);
        
        var mahoso = maHoSo;
        var rootFolder = "DVCHQ";
        var tenLinhVuc = 'Moi Truong';
        var idTthc = idHoSo; // BTNMT0600001
        var logicalDestinationPath = rootFolder + "/" + tenLinhVuc + "/" + idTthc + "/" + y + "/" + m + "/" + d + "/" + mahoso;
        $('#loading10').show();
		$.ajax({
			type: "POST",
			url: apiUrl + "api/core/mdm/nodes/upload?destinationPath=" + logicalDestinationPath,
            beforeSend: function (xhr) {
                xhr.setRequestHeader("Authorization", "Basic " + btoa('MDM_AUTH_API' + ":" + 'secret'));
                xhr.setRequestHeader("X-ApplicationId", applicationId);
                xhr.setRequestHeader("X-User", userId);
            },
			crossDomain: true,
			contentType: false,    
			data: formData,
			processData: false,
			cache: false,
			timeout: 60000000,
			success: function (result) {
				$('#' + eleId).val('');
			   if (result != null) {
					   $(result.Data).each(function(loopIndex, loopItem){
						   var postData = {
								   idHS: idHS,
								   index: self.dsTepTinThemMoiHS().length,
								   id: 0,
	    	        			   loaiTepTin: loaiTep,
	    	        			   tenLoaiTep: self.getTenLoaiTep(loaiTep),
	    	        			   tenTepTin: loopItem.FileName,
	    	        			   tenTepTinId: loopItem.NodeId
							  };
						   if (idHS <= 0) {
			        		   self.setTepTin(postData);
			        		   self.dsTepTinThemMoiHS.push(self.copyItem(postData));
							  } else {
								  app.makePost({
						                url: self.contextPath() + '/luuThongTinTepDKTheoHS/' + idHS,
						                data: JSON.stringify(postData),
						                success: function (d) {
						                    var msg = '';
						                    var fun = 'success';
						                    if (d.success) {
						                        msg = NSWLang["common_msg_cap_nhat_du_lieu_thanh_cong"];
						                        self.setTepTin(d.data);
						                    } else {
						                        msg = data.message;
						                        fun = 'error';
						                    }
						                   
						                },
						                error: function (e) {
						                    app.toast({
						                        title: NSWLang["common_msg_thong_bao"],
						                        message: e.message,
						                    });
						                }
						            });
							  }
					   });
			   }
			   
			  $('#loading10').hide();
			},
			error: function (e) {
					$('#' + eleId).val('');
					 toastr.error(NSWLang["monre_01_upload_errror"], NSWLang["common_msg_thong_bao"]);
				 $('#loading10').hide();
			}
		});
		return true;
	}
	

	
	self.xoaTepTin = function(loaiTep) {
		
		var idHS = idHoSo;
			 var pop = app.popup({
	             title: NSWLang["common_msg_thong_bao"],
	             html: '<i class="fa fa-3x fa-warning"></i> ' + NSWLang["monre_01_error_message_thong_tin_tep_tin_xoa_tat_ca"],
	             width: 400,
	             buttons: [
	                 {
	                     name: NSWLang["common_button_toi_chac_chan"],
	                     class: 'btn',
	                     icon: 'fa-check',
	                     action: function () {
	                         app.makePost({
	                             url: self.contextPath() + '/xoaLoaiTepTinTheoHS/' + idHS + '/' + loaiTep,
	                             data: JSON.stringify({}),
	                             success: function (d) {
	                                 var msg = '';
	                                 var fun = 'success';
	                                 if (d.success) {
	                                     msg = NSWLang["common_msg_cap_nhat_du_lieu_thanh_cong"];
	                                     app.popupRemove(pop.selector);
	                                     self.xoaTep(loaiTep, null);
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
	                                 app.popupRemove(pop.selector);
	                                 self.xoaTep(loaiTep, null);
	                             }
	                         });
	                     }
	                 }
	             ]
	         });
	}
	
	self.xoaMotFile = function(item) {
		var idHS = idHoSo;
			 var pop = app.popup({
	             title: NSWLang["common_msg_thong_bao"],
	             html: '<i class="fa fa-3x fa-warning"></i> ' + NSWLang["monre_01_error_message_thong_tin_tep_tin_xoa_mot"],
	             width: 400,
	             buttons: [
	                 {
	                     name: NSWLang["common_button_toi_chac_chan"],
	                     class: 'btn',
	                     icon: 'fa-check',
	                     action: function () {
	                         app.makePost({
	                             url: self.contextPath() + '/xoaTepTinIdTheoHS/' + idHS + '/' + item.id,
	                             data: JSON.stringify({}),
	                             success: function (d) {
	                                 var msg = '';
	                                 var fun = 'success';
	                                 if (d.success) {
	                                     msg = NSWLang["common_msg_cap_nhat_du_lieu_thanh_cong"];
	                                     app.popupRemove(pop.selector);
	                                     self.xoaTep(item.loaiTepTin, item);
	              		      		   
	              		      		   $(self.dsTepTinThemMoiHS()).each(function(index, item){
	              		      			   item.pos = index;
	              		      		   });
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
	                                 app.popupRemove(pop.selector);
	                                 self.xoaTep(item.loaiTepTin, item);
	                             }
	                         });
	                     }
	                 }
	             ]
	         });
	}
	
	self.valid = function(isGuiHoSo) {
		if (isGuiHoSo) {
			
			if (self.tepTinModel.tepLoai1().length == 0  
					|| self.tepTinModel.tepLoai6().length == 0 ) {
				
				app.Alert( NSWLang["monre_01_gui_ho_so_yeu_cau_thong_tin_tep_dinh_kem"]);
				return false;
			}
			if (loaiThuTuc == 1 || loaiThuTuc == 3) {
				if ( self.tepTinModel.tepLoai2().length == 0
						|| self.tepTinModel.tepLoai3().length == 0
						|| self.tepTinModel.tepLoai4().length == 0 
						|| self.tepTinModel.tepLoai5().length == 0 
						|| self.tepTinModel.tepLoai7().length == 0) {
					
					app.Alert( NSWLang["monre_01_gui_ho_so_yeu_cau_thong_tin_tep_dinh_kem"]);
					return false;
				}
			}
		}
		return true;
	}
		
	self.getTenLoaiTep = function(loaiTep) {
		 switch(loaiTep) {
			 case 1:
				 return NSWLang["error_monre_01_loai_ho_so_1"];
			 case 2:
				 return NSWLang["error_monre_01_loai_ho_so_2"];
			 case 3:
				 return NSWLang["error_monre_01_loai_ho_so_3"];
			 case 4:
				 return NSWLang["error_monre_01_loai_ho_so_4"];
			 case 5:
				 return NSWLang["error_monre_01_loai_ho_so_5"];
			 case 6:
				 return NSWLang["error_monre_01_loai_ho_so_6"];
			 case 7:
				 return NSWLang["error_monre_01_loai_ho_so_7"];
			 default:
				 return NSWLang["error_monre_01_loai_ho_so_8"];
		 }
	}
}
