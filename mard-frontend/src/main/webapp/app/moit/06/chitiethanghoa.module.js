function ChiTietHangHoaViewModel(hoSo) {
	var self = this;
	self.hangHoas = ko.observableArray();
	self.donViTinhs = ko.observableArray();
	self.saveFast = ko.observable(saveFast);
	self.donViTinhs.push({name: NSWLang['moit_06_form_hanghoa_trangthai_0'], value: '-1'});
	self.donViTinhs.push({name: 'MLT', value: 'MLT'});
	self.donViTinhs.push({name: 'LTR', value: 'LTR'});
	self.donViTinhs.push({name: 'GRM', value: 'GRM'});
	self.donViTinhs.push({name: 'KGM', value: 'KGM'});
	self.donViTinhs.push({name: 'TNE', value: 'TNE'});
	
	self.xemHoSo = ko.observable(xemHoSo);
	self.trangThaiHangHoas = ko.observableArray();
	self.trangThaiHangHoas.push({name: NSWLang['moit_06_form_hanghoa_trangthai_0'], value: -1});
	self.trangThaiHangHoas.push({name: NSWLang['moit_06_form_hanghoa_trangthai_1'], value: 1});
	self.trangThaiHangHoas.push({name: NSWLang['moit_06_form_hanghoa_trangthai_2'], value: 2});
	self.trangThaiHangHoas.push({name: NSWLang['moit_06_form_hanghoa_trangthai_3'], value: 3});
	self.tienChats = ko.observableArray([]);
	 self.getTienChats = function() {
			self.tienChats.removeAll();
			self.tienChats.push({
				name : NSWLang["moit_06_msg_chon"],
				congThucHoaHoc : -1
			});
			hoSo.tienChats.forEach(function(item, index) {
				item.name =  item.tenKhoaHoc + ' (' + item.congThucHoaHoc + ')';
				self.tienChats.push(item);
			});
			$(hoSo.hangHoas).each(function(index, item){
				var hh = new HangHoaModel();
				hh.chiTiet(item.chiTiet);
				hh.idHoSo(item.idHoSo);
				hh.soLuong(item.soLuong);
				hh.donViTinh(item.donViTinh);
				hh.tenHangHoa(item.tenHangHoa);
				hh.tenTCTN(item.tenTCTN);
				hh.hamLuong(item.hamLuong);
				hh.trangThai(item.trangThai);
				hh.enable(false);
				hh.idHangHoa(item.idHangHoa);
				hh.xemHoSo(xemHoSo);
				self.hangHoas.push(hh);
			});
			if (!xemHoSo) {
				self.hangHoas.push(new HangHoaModel());
			}
			
		}

		self.getTienChats();
		
		self.addHangHoa = function(item) {
			if (!self.validHangHoa(false, true)) return false;
			if (hoSo.idHoSo > 0 && saveFast) {
				var data = {
						idHangHoa : item.idHangHoa(),
						chiTiet : item.chiTiet(),
						idHoSo : item.idHoSo(),
						soLuong : parseFloat(item.soLuong()),
						donViTinh : item.donViTinh(),
						tenHangHoa : item.tenHangHoa(),
						tenTCTN : item.tenTCTN(),
						hamLuong : parseFloat(item.hamLuong()),
						trangThai : item.trangThai()
				};
				 app.makePost({
                     url:'/moit/api/06/addHangHoa/' + hoSo.idHoSo,
                     data: JSON.stringify(data),
                     success: function (d) {
                         var msg = d.message;
                         var fun = 'success';
                         if (d.success) {
                             app.toast({
                                 title: NSWLang["common_msg_thong_bao"],
                                 message: msg,
                                 function: fun
                             });
                            item.idHangHoa(d.data.idHangHoa);
                            self.hangHoas()[self.hangHoas().length - 1].enable(false);
                 			self.hangHoas.push(new HangHoaModel());
                 			$(".select5").select2({
                 				placeholder : '',
                 				width : '100%'
                 			});
                         } 
                         
                     },
                     error: function (e) {
                         toastr.error(NSWLang["common_msg_thong_bao"], e.message);
                     }
                 });
			} else {
				self.hangHoas()[self.hangHoas().length - 1].enable(false);
				self.hangHoas.push(new HangHoaModel());
				$(".select5").select2({
					placeholder : '',
					width : '100%'
				});
			}
			
		}
		
		self.editHangHoa = function(item){
			item.enable(true);
			item.update(true);
		}
		self.updateHangHoa = function(item){
			if (item.idHangHoa() > 0 && saveFast) {
				data = {
						idHangHoa : item.idHangHoa(),
						chiTiet : item.chiTiet(),
						idHoSo : item.idHoSo(),
						soLuong : parseFloat(item.soLuong()),
						donViTinh : item.donViTinh(),
						tenHangHoa : item.tenHangHoa(),
						tenTCTN : item.tenTCTN(),
						hamLuong : parseFloat(item.hamLuong()),
						trangThai : item.trangThai()
				};
				app.makePost({
                    url:'/moit/api/06/updateHangHoa',
                    data: JSON.stringify(data),
                    success: function (d) {
                        var msg = d.message;
                        var fun = 'success';
                        if (d.success) {
                            item.update(false);
                            item.enable(false);
                            app.toast({
                                title: NSWLang["common_msg_thong_bao"],
                                message: msg,
                                function: fun
                            });
                        } else {
                            toastr.error(NSWLang["common_msg_thong_bao"], d.message);
                        }
                        
                    },
                    error: function (e) {
                        toastr.error(NSWLang["common_msg_thong_bao"], e.message);
                    }
                });
			} else {
				 item.update(false);
                 item.enable(false);
			}
		}
		self.deleteHangHoa = function(item) {
			if (item.idHangHoa() > 0 && saveFast) {
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
		                             url:'/moit/api/06/xoaHangHoa/' + item.idHangHoa(),
		                             data: JSON.stringify({}),
		                             success: function (d) {
		                                 var msg = d.message;
		                                 var fun = 'success';
		                                 if (d.success) {
		                                     app.popupRemove(pop.selector);
		                                     self.hangHoas.remove(item);
		                                     app.toast({
			                                     title: NSWLang["common_msg_thong_bao"],
			                                     message: msg,
			                                     function: fun
			                                 });
		                                 } else {
		                                     toastr.error(NSWLang["common_msg_thong_bao"], d.message);
		                                 }
		                                 
		                             },
		                             error: function (e) {
		                                 app.popupRemove(pop.selector);
		                                 toastr.error(NSWLang["common_msg_thong_bao"], e.message);
		                             }
		                         });
		                     }
		                 }
		             ]
		         });
			} else {
				self.hangHoas.remove(item);
			}
		}
		
		self.validHangHoa = function(isGuiHoSo, isAdd) {
			var success = true;
			var checkEnd = false;
			var end = self.hangHoas()[self.hangHoas().length - 1];
			if (end.tenHangHoa().trim() == '' && (end.tenTCTN() == undefined || end.tenTCTN() == '-1')
					&& end.chiTiet().trim() == '' && end.hamLuong() == ''
						&& end.soLuong() == '' && end.trangThai() == -1 && end.donViTinh() == '-1') {
				checkEnd = true;
			}
			if(!isGuiHoSo && checkEnd && !isAdd){
				
				return true;
			}
			$(self.hangHoas()).each(function(index, item){
				if (index == self.hangHoas().length - 1 && checkEnd) {
					if (!isGuiHoSo && !isAdd) {
						return false;
					}
				}
				if (self.hangHoas().length > 1 && checkEnd && !isAdd) {
					return false;
				}
				if (item.tenHangHoa() == null || item.tenHangHoa().trim() == '') {
					cssError('hangHoa_tenHangHoa_' + index);
					success = false;
					item.tenHangHoa('');
					return false;
				} else {
					cssSuccess('hangHoa_tenHangHoa_' + index);
				}
				if (item.tenTCTN() == null || item.tenTCTN() == '-1') {
					cssError('hangHoa_tenTCTN_' + index);
					success = false;
					return false;
				} else {
					cssSuccess('hangHoa_tenTCTN_' + index);
				}
				
				if (item.hamLuong() == null || item.hamLuong() == '') {
					cssError('hangHoa_hamLuong_' + index);
					success = false;
					item.hamLuong('');
					return false;
				} else {
					cssSuccess('hangHoa_hamLuong_' + index);
				}
				
				if (item.trangThai() == null || item.trangThai() == -1) {
					cssError('hangHoa_trangThai_' + index);
					success = false;
					return false;
				} else {
					cssSuccess('hangHoa_trangThai_' + index);
				}
				if (item.chiTiet() == null || item.chiTiet().trim() == '') {
					cssError('hangHoa_chiTiet_' + index);
					success = false;
					item.chiTiet('');
					return false;
				} else {
					cssSuccess('hangHoa_chiTiet_' + index);
				}
				if (item.soLuong() == null || item.soLuong() == '') {
					cssError('hangHoa_soLuong_' + index);
					success = false;
					item.soLuong('');
					return false;
				} else {
					cssSuccess('hangHoa_soLuong_' + index);
				}
				
				if (item.donViTinh() == null || item.donViTinh() == undefined || item.donViTinh() == '' || item.donViTinh().startsWith('--') || item.donViTinh() == '-1') {
					cssError('hangHoa_donViTinh_' + index);
					success = false;
					item.donViTinh('');
					return false;
				} else {
					cssSuccess('hangHoa_donViTinh_' + index);
				}
				
				
			});
			return success;
		}
		
		self.isValid = function(isGuiHoSo) {
			
			return self.validHangHoa(isGuiHoSo, false);
		}
		
		self.getHangHoas = function(){
			var hhs = [];
			$(self.hangHoas()).each(function(index, item){
				hhs.push({
					idHangHoa : item.idHangHoa(),
					chiTiet : item.chiTiet(),
					idHoSo : item.idHoSo(),
					soLuong : parseFloat(item.soLuong()),
					donViTinh : item.donViTinh(),
					tenHangHoa : item.tenHangHoa(),
					tenTCTN : item.tenTCTN(),
					hamLuong : parseFloat(item.hamLuong()),
					trangThai : item.trangThai(),
					update: item.update()
				});
			});
			return hhs;
		}
		
		self.soLuongNumberInputKeyPressEvent = function( value, data, event) {
			return self.checkInputNumber( value, data, event, 15, 2);
	     }
		self.hamLuongNumberInputKeyPressEvent = function( value, data, event) {
			return self.checkInputNumber( value, data, event, 5, 2);
	     }
		
		self.checkInputNumber = function( value, data, event, pn, ptp) {
			var dauChamPhay = 0;
			var phanThapPhan = 0;
			var phanNguyen = 0;
			for(var i = 0; i < value.length; i++) {
				if (value[i] == '.') {
					dauChamPhay++;
					continue;
				} 
				if (dauChamPhay == 0){
					phanNguyen++;
				} else {
					if (dauChamPhay == 1) phanThapPhan++;
				}
			}
			var x = event.which || event.keyCode;
			var keys = [8, 46, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57];
			 if (x == 8) return true;
			 
			if (dauChamPhay > 1) {
				return false;
			}
	        if ($.inArray(x, keys) === -1) { 
	           return false;
	        }
	        if (phanThapPhan + phanNguyen > pn) return false;
	        if (phanNguyen == pn && dauChamPhay == 0) return false;
	        if (phanThapPhan == ptp && x == 8) return true;
	        if (phanThapPhan == ptp) return false;
	        return true;
		}
		
		self.keypressdownSoLuong = function(item) {
			   var event = window.event;
			   var sl = sl = item.soLuong();;
			    if (sl != undefined && sl != '') {
			    	sl = sl.toString();
			    	var chars = sl.split('');
			    	for (var i = 0; i < chars.length; i++) {
			    		if (chars[i] == '.' && event.key == '.') {
			    			return false;
			    		}
			    	}
			    }
			    return true;
			}
		
		self.keypressdownHamLuong = function(item) {
			   var event = window.event;
			   var sl = sl = item.hamLuong();;
			    if (sl != undefined && sl != '') {
			    	sl = sl.toString();
			    	var chars = sl.split('');
			    	for (var i = 0; i < chars.length; i++) {
			    		if (chars[i] == '.' && event.key == '.') {
			    			return false;
			    		}
			    	}
			    }
			    return true;
			}

}


