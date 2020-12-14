function ThongTinHangHoaViewModel(hoSo) {
	var self = this;
// console.log(hoSo);
	self.thongTinHangHoaModel = new ThongTinHangHoaModel();
	self.thongTinHangHoaModel.mucDich(hoSo.mucDich);
	self.thongTinHangHoaModel.xemHoSo(xemHoSo);
	self.saveFast = ko.observable(saveFast);
	self.cuaKhaus = ko.observableArray([]);
	self.phuongTiens = ko.observableArray();
	self.haiQuans = ko.observableArray([]);
	self.addNewCuaKhau = ko.observable(false);
	self.getCuaKhaus = function() {
		self.cuaKhaus.removeAll();
		self.cuaKhaus.push({
			tenCuaKhau : NSWLang["moit_06_msg_chon"],
			maCuaKhau : -1,
		});
		app.makePost({
			url : '/moit/api/06/layDsCuaKhau',
			data : JSON.stringify({}),
			success : function(d) {
				// console.log(d);
				if (d.success) {

					d.data.forEach(function(item, index) {
						self.cuaKhaus.push(item);
					});
					$(hoSo.cuaKhaus).each(function(index, item){
//						console.log(item);
						self.thongTinHangHoaModel.cuaKhaus.push(self.copyCK({
							tenCuaKhau : item.tenCuaKhau,
							maCuaKhau: item.maCuaKhau,
							idCuaKhau : item.idCuaKhau,
							idHoSo: hoSo.idHoSo
						}));
					});
					if (self.thongTinHangHoaModel.cuaKhaus().length == 0) {
						self.thongTinHangHoaModel.cuaKhaus.push(self.copyCK({
							tenCuaKhau : NSWLang["moit_06_msg_chon"],
							maCuaKhau: -1,
							idCuaKhau : -1,
							idHoSo: hoSo.idHoSo
						}));
					}
					
					$(".select5").select2({
						placeholder : '',
						width : '100%'
					});
				}
			},
			error : function(e) {
				console.log(e);
				toastr.error(e.message, NSWLang["common_msg_thong_bao"]);
			}
		});
	}
	
	self.copyCK = function(item) {
		var ck = new CKModel();
		ck.idCuaKhau(item.idCuaKhau);
		ck.tenCuaKhau(item.tenCuaKhau);
		ck.maCuaKhau(item.maCuaKhau);
		ck.idHoSo(item.idHoSo);
		return ck;
	}
	
	self.copyHQ = function(item) {
		var ck = new HQModel();
		ck.tenHaiQuan(item.tenHaiQuan);
		ck.idHaiQuan(item.idHaiQuan);
		ck.maHaiQuan(item.maHaiQuan);
		return ck;
	}
 
	self.getCuaKhaus();

	self.copyPT = function(item) {
		var ck = new PTModel();
		ck.tenPhuongTien(item.tenPhuongTien);
		ck.loaiPhuongTien(item.loaiPhuongTien);
		ck.idPhuongTien(item.idPhuongTien);
		ck.idHoSo(item.idHoSo);
		return ck;
	}
	
	self.getPhuongTiens = function() {
		self.phuongTiens.removeAll();
		self.phuongTiens.push(self.copyPT({
			tenPhuongTien : NSWLang["moit_06_msg_chon"],
			idPhuongTien : -1,
			loaiPhuongTien: '-1',
			idHoSo: idHoSo
		}));
		app.makePost({
			url : '/moit/api/06/layDsPhuongTien',
			data : JSON.stringify({}),
			success : function(d) {
				if (d.success) {
					d.data.forEach(function(item, index) {
						self.phuongTiens.push(item);
					});
					$(hoSo.phuongTiens).each(function(index, item){
						self.thongTinHangHoaModel.phuongTiens.push(self.copyPT({
							tenCuaKhau : '',
							loaiPhuongTien: item.loaiPhuongTien,
							idPhuongTien : item.idPhuongTien
						}));
					});
					if (self.thongTinHangHoaModel.phuongTiens().length == 0) {
						self.thongTinHangHoaModel.phuongTiens.push(self.copyPT({
							tenPhuongTien : NSWLang["moit_06_msg_chon"],
							loaiPhuongTien: -1,
							idPhuongTien : -1,
							idHoSo: hoSo.idHoSo,
						}));
					}
					
					$(".select5").select2({
						placeholder : '',
						width : '100%'
					});
				}
			},
			error : function(e) {
				console.log(e);
				toastr.error(e.message, NSWLang["common_msg_thong_bao"]);
			}
		});
	}

	self.getPhuongTiens();

	self.deletePhuongTien = function(item) {
		console.log(item);
		if (item.idPhuongTien() > 0) {
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
	                            url: '/moit/api/06/deletePhuongTien/' + item.idPhuongTien(),
	                            data: JSON.stringify({}),
	                            success: function (d) {
	                            	console.log(d);
	                                if (d.success) {
	                                    app.popupRemove(pop.selector);
	                                    app.toast({
	            							title : NSWLang["common_msg_thong_bao"],
	            							message : d.message
	            						});
	                                    self.thongTinHangHoaModel.phuongTiens.remove(item);
	                                    if (self.thongTinHangHoaModel.phuongTiens().length == 0) {
	                                   	 self.addDefaultPhuongTien();
	                                   }
	                                } 
	                               
	                            },
	                            error: function (e) {
	                                console.log(e);
	                            }
	                        });
	                    }
	                }
	            ]
	        });
		} else {
			self.thongTinHangHoaModel.phuongTiens.remove(item);
			if (self.thongTinHangHoaModel.phuongTiens().length == 0) {
            	 self.addDefaultPhuongTien();
            }
		}
	}
	self.deleteCuaKhau = function(item) {
		if (item.idCuaKhau() > 0) {
			
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
	                            url: '/moit/api/06/deleteCuaKhau/' + item.idCuaKhau(),
	                            data: JSON.stringify({}),
	                            success: function (d) {
	                                if (d.success) {
	                                    app.popupRemove(pop.selector);
	                                    app.toast({
	            							title : NSWLang["common_msg_thong_bao"],
	            							message : d.message
	            						});
	                                    self.thongTinHangHoaModel.cuaKhaus.remove(item);
	                                    if (self.thongTinHangHoaModel.cuaKhaus().length == 0) {
	                                    	 self.addDefaultCuaKhau();
	                                    }
	                                   
	                                } 
	                               
	                            },
	                            error: function (e) {
	                                console.log(e);
	                            }
	                        });
	                    }
	                }
	            ]
	        });
		} else {
			self.thongTinHangHoaModel.cuaKhaus.remove(item);
			 if (self.thongTinHangHoaModel.cuaKhaus().length == 0) {
             	 self.addDefaultCuaKhau();
             }
		}
	}
	
	self.addDefaultCuaKhau = function(){
		self.thongTinHangHoaModel.cuaKhaus.push(self.copyCK({
			tenCuaKhau : NSWLang["moit_06_msg_chon"],
			idCuaKhau : -1,
			maCuaKhau: -1
		}));
	}
	self.addDefaultPhuongTien = function(){
		self.thongTinHangHoaModel.phuongTiens.push(self.copyPT({
			tenPhuongTien : NSWLang["moit_06_msg_chon"],
			idPhuongTien : -1,
			loaiPhuongTien: -1
		}));
	}
	
	
	self.addCuaKhau = function(item) {
		if (self.validCuaKhau(-1, false)) {
			if (hoSo.idHoSo > 0 && item.idCuaKhau() < 1 && item.maCuaKhau() != "-1") {
				var data = {
						idCuaKhau: 0,
						idHoSo: hoSo.idHoSo,
						maCuaKhau: item.maCuaKhau(),
						tenCuaKhau: item.tenCuaKhau(),
						hoatDong: 1
				};
				app.makePost({
                    url: '/moit/api/06/addCuaKhau/' + hoSo.idHoSo,
                    data: JSON.stringify(data),
                    success: function (d) {
                        if (d.success) {
                            app.toast({
    							title : NSWLang["common_msg_thong_bao"],
    							message : d.message
    						});
                           item.idCuaKhau(d.data.idCuaKhau);
                			self.addDefaultCuaKhau();
                			$(".select5").select2({
                				placeholder : '',
                				width : '100%'
                			});
                        } 
                    },
                    error: function (e) {
                        console.log(e);
                        toastr.error(e.message, NSWLang["common_msg_thong_bao"]);
                    }
                });
			} else if (item.maCuaKhau() != "-1"){
				item.idCuaKhau(item.idCuaKhau());
				self.addDefaultCuaKhau();
				$(".select5").select2({
					placeholder : '',
					width : '100%'
				});
			}
			
		} 
	}
	
	self.addPhuongTien = function(item) {
		if (self.validPhuongTien(-1, false)) {
			if (hoSo.idHoSo > 0 && item.idPhuongTien() < 1 && item.loaiPhuongTien() != "-1") {
				var data = {
						idPhuongTien: 0,
						idHoSo: hoSo.idHoSo,
						loaiPhuongTien: item.loaiPhuongTien(),
						hoatDong: 1
				};
				app.makePost({
	                url: '/moit/api/06/addPhuongTien/' + hoSo.idHoSo,
	                data: JSON.stringify(data),
	                success: function (d) {
	                    if (d.success) {
	                        app.toast({
								title : NSWLang["common_msg_thong_bao"],
								message : d.message
							});
	        				self.addDefaultPhuongTien();
	        				item.idPhuongTien(d.data.idPhuongTien);
	        				$(".select5").select2({
	        					placeholder : '',
	        					width : '100%'
	        				});
	                    } 
	                },
	                error: function (e) {
	                    console.log(e);
	                    toastr.error(e.message, NSWLang["common_msg_thong_bao"]);
	                }
	            });
			} else if (item.loaiPhuongTien() != "-1") {
				item.idPhuongTien(item.idPhuongTien());
				self.addDefaultPhuongTien();
				$(".select5").select2({
					placeholder : '',
					width : '100%'
				});

			}
		}
		
	}
	
	
	
	self.validCuaKhau = function(currentP, guiHoSo) {
		var notExists = true;
		$(self.thongTinHangHoaModel.cuaKhaus()).each(function(index, item){
			var count = 0;
			var pos = 0;
			var p = [];
			
			$(self.thongTinHangHoaModel.cuaKhaus()).each(function(index2, item2){
				cssSuccess('thongTinHangHoa_cuaKhau_' + index2);
				if (item2.maCuaKhau() == item.maCuaKhau()){
					count++;
					pos = index2;
					p.push(index2);
					
				}
				
			});
			if (p.length > 1) {
				$(p).each(function(index2, item2){
					cssError('thongTinHangHoa_cuaKhau_' + item2);
				});
			}
			
			
			if (count > 1) {
				notExists = false;
				if (currentP != -1) pos = currentP; 
				cssError('thongTinHangHoa_cuaKhau_' + pos);
				app.Alert( NSWLang["moit_06_form_hanghoa_error_tencuakhau_exist"] + ' ' + (pos + 1));
				return false;
			}
			if (item.maCuaKhau() == -1) {
				notExists = false;
				if (index == self.thongTinHangHoaModel.cuaKhaus().length - 1) {
					notExists = true;
					return true;
				}
				cssError('thongTinHangHoa_cuaKhau_' + index);
				app.Alert( NSWLang["moit_06_form_hanghoa_error_tencuakhau_empty"] + ' ' + (index + 1));
				return false;
			}
		});
		if (guiHoSo) {
			if (self.thongTinHangHoaModel.cuaKhaus().length == 1 && self.thongTinHangHoaModel.cuaKhaus()[0].maCuaKhau() == -1) {
				cssError('thongTinHangHoa_cuaKhau_' + 0);
				app.Alert( NSWLang["moit_06_form_hanghoa_error_tencuakhau_empty"] + ' ' + (0 + 1));
				return false;
			}
		}
		return notExists;
	}
	
	self.validPhuongTien = function(currentP, guiHoSo) {
		var notExists = true;
		$(self.thongTinHangHoaModel.phuongTiens()).each(function(index, item){
			var count = 0;
			var pos = 0;
			var p = [];
			$(self.thongTinHangHoaModel.phuongTiens()).each(function(index2, item2){
				cssSuccess('thongTinHangHoa_phuongTien_' + index2);
				if (item2.loaiPhuongTien() == item.loaiPhuongTien()) {
					count++;
					pos = index2;
					p.push(index2);
				}
				
			});
			if (p.length > 1) {
				$(p).each(function(index2, item2){
					cssError('thongTinHangHoa_phuongTien_' + item2);
				});
			}
			
			if (count > 1) {
				notExists = false;
				if (currentP != -1) pos = currentP; 
				cssError('thongTinHangHoa_phuongTien_' + pos);
				app.Alert( NSWLang["moit_06_form_hanghoa_error_tenphuongtien_exist"] + ' ' + (pos + 1));
				return false;
			}
			if (item.loaiPhuongTien() == -1) {
				notExists = false;
				
				if (index == self.thongTinHangHoaModel.phuongTiens().length - 1) {
					notExists = true;
					return true;
				}
				cssError('thongTinHangHoa_phuongTien_' + index);
				app.Alert( NSWLang["moit_06_form_hanghoa_error_tenphuongtien_empty"] + ' ' + (index + 1));
				return false;
			}
		});
		if (guiHoSo) {
			if (self.thongTinHangHoaModel.phuongTiens().length == 1 && self.thongTinHangHoaModel.phuongTiens()[0].loaiPhuongTien() == -1) {
				cssError('thongTinHangHoa_phuongTien_' + 0);
				app.Alert( NSWLang["moit_06_form_hanghoa_error_tenphuongtien_empty"] + ' ' + (0 + 1));
				return false;
			}
		}
		return notExists;
	}
	
	
	
	
	self.selectCuaKhauChangeEvent = function(item, position) {
		self.validCuaKhau(position, false);
	}
	self.selectPhuongTienChangeEvent = function(item, position) {
		self.validPhuongTien(position, false);
	}
	
	self.isValid = function(isGuiHoSo) {
		if (!isGuiHoSo) {
			if (self.thongTinHangHoaModel.valid.errors().length > 0) {
				$(self.thongTinHangHoaModel.valid.errors()).each(function(index, item){
					app.Alert(item);
					self.thongTinHangHoaModel.valid.errors.showAllMessages();
					return false;
				});
				return false;
			}
			
		} 
		if (isGuiHoSo) {
			
			if (self.thongTinHangHoaModel.mucDich() == undefined || self.thongTinHangHoaModel.mucDich().trim() == '') {
				self.thongTinHangHoaModel.mucDich('');
				cssError('thongTinHangHoaModel_mucDich');
				return false;
			} else {
				cssSuccess('thongTinHangHoaModel_mucDich');
			}
			
			if (self.thongTinHangHoaModel.cuaKhaus()[0].maCuaKhau == '-1') {
				cssError('thongTinHangHoa_cuaKhau_' + 0);
				return false;
			}
			
			if (self.thongTinHangHoaModel.phuongTiens()[0].loaiPhuongTien == '-1') {
				cssError('thongTinHangHoa_phuongTien_' + 0);
				return false;
			}
			
		}
		if (!validNgayThang(isGuiHoSo)) {
			return false;
		}
		
		if (isGuiHoSo) {
			
			if (self.thongTinHangHoaModel.valid.errors().length > 0) {
				$(self.thongTinHangHoaModel.valid.errors()).each(function(index, item){
					app.Alert(item);
					self.thongTinHangHoaModel.valid.errors.showAllMessages();
					return false;
				});
				
				return false;
			}
			if (!self.validCuaKhau(-1, true)) {
				return false;
			}
			
			if (!self.validPhuongTien(-1, true)) {
				return false;
			}
			
		} else {
			if (self.cuaKhaus().length > 1) {
				if (!self.validCuaKhau(-1, false)) {
					return false;
				}
			}
			if (self.phuongTiens().length > 1) {
				if (!self.validPhuongTien(-1, false)) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	function validNgayThang(isGuiHoSo) {
		
		
		return true;
	}
	self.validDate = function(d1, d2) {
		if (d1 != null && d1 != '' && d2 != null && d2 != '') {
			var f = self.toDate(d1);
			var t = self.toDate(d2);
			if (f != null && t != null) {
				if (f.getTime() > t.getTime()) {
					app.Alert( NSWLang["moit_06_form_hanghoa_error_xnk_between"]);
					return false;
				}
			}
		}
		return true;
	}
	
	self.toDate = function(dateStr) {
		var splits = dateStr.split("/");
		var day = splits[0];
		var month = splits[1];
		var year = splits[2];
	    return new Date(year, month - 1, day);
	}
	
	self.getPhuongTienToJson = function() {
		var p = [];
		self.thongTinHangHoaModel.phuongTiens().forEach(function(item, index){
			if (item.loaiPhuongTien() != '-1') {
				var data = {
						idPhuongTien: item.idPhuongTien(),
						idHoSo: hoSo.idHoSo,
						loaiPhuongTien: item.loaiPhuongTien(),
						hoatDong: 1
				};
				p.push(data);
			}
			
		});
		return p;
	}
	self.getCuaKhauToJson = function() {
		var p = [];
		self.thongTinHangHoaModel.cuaKhaus().forEach(function(item, index){
			if (item.maCuaKhau() != '-1') {
				var data = {
						idCuaKhau: item.idCuaKhau(),
						idHoSo: hoSo.idHoSo,
						maCuaKhau: item.maCuaKhau(),
						tenCuaKhau: item.tenCuaKhau(),
						hoatDong: 1
				};
				p.push(data);
			}
			
		});
		return p;
	}
}