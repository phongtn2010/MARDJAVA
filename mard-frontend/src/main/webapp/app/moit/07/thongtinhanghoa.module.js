function ThongTinHangHoaViewModel(hoSo) {
	var self = this;
	self.thongTinHangHoaModel = new ThongTinHangHoaModel();
	self.thongTinHangHoaModel.mucDich(hoSo.mucDich);
	self.thongTinHangHoaModel.xuatNhapKhauTuNgay(hoSo.xuatNhapKhauTuNgay);
	self.thongTinHangHoaModel.xuatNhapKhauDenNgay(hoSo.xuatNhapKhauDenNgay);
	self.thongTinHangHoaModel.soLanThucHien(hoSo.soLanThucHien);
	self.thongTinHangHoaModel.xemHoSo(xemHoSo);
	self.saveFast = ko.observable(saveFast);
	self.cuaKhaus = ko.observableArray([]);
	self.phuongTiens = ko.observableArray();
	self.haiQuans = ko.observableArray([]);
	self.addNewCuaKhau = ko.observable(false);
    self.cuaKhausSelected = ko.observableArray(['-1']);
    self.phuongTiensSelected = ko.observableArray(['-1']);
    self.haiQuansSelected = ko.observableArray(['-1']);

    
    self.dsCKs = ko.observableArray([]);
	self.dsCKsText = ko.observable('');
	if(hoSo.idHoSo != null && hoSo.idHoSo != 0){
		if(hoSo.cuaKhaus.length > 0){
			hoSo.cuaKhaus.forEach(function(item, index){
				var data= {
						idCuaKhau: 0,
						idHoSo: hoSo.idHoSo,
						maCuaKhau: ko.observable(item.maCuaKhau),
						tenCuaKhau: ko.observable(item.tenCuaKhau),
						hoatDong: 1
						}
//				console.log(index);
//				console.log(data);
				self.dsCKs.push(data);
			}) ;
		
			
			
		}
	}
	self.dsCKs.subscribe(function(d){
	  	console.log(d);
	  	var msg = '';
	  	d.forEach(function(item, index){
	        msg += item.tenCuaKhau() + "; ";
		});
	  	self.dsCKsText(msg);
	  });
	  
	
	
	self.getCuaKhaus = function() {
		self.cuaKhaus.removeAll();
		self.cuaKhaus.push({
			tenCuaKhau : NSWLang["moit_06_msg_chon"],
			maCuaKhau : '-1'
		});
		app.makePost({
			url : '/moit/api/07/layDsCuaKhau',
			data : JSON.stringify({}),
			success : function(d) {
				if (d.success) {

					d.data.forEach(function(item, index) {
						self.cuaKhaus.push(item);
					});

					var msg = '';
					hoSo.cuaKhaus.forEach(function(item, index){
				        msg += item.tenCuaKhau + "; ";
					});
				  	self.dsCKsText(msg);

                    $(".select5").select2({
						placeholder : '',
						width : '100%'
					});
				}
			},
			error : function(e) {
				toastr.error(e.message, NSWLang["common_msg_thong_bao"]);
			}
		});
	}
	

	self.getCuaKhaus();


	self.getPhuongTiens = function() {
		self.phuongTiens.removeAll();
		self.phuongTiens.push({
			tenPhuongTien : NSWLang["moit_06_msg_chon"],
			idPhuongTien : -1,
			loaiPhuongTien: '-1',
			idHoSo: idHoSo
		});
		app.makePost({
			url : '/moit/api/07/layDsPhuongTien',
			data : JSON.stringify({}),
			success : function(d) {
				if (d.success) {
					d.data.forEach(function(item, index) {
						self.phuongTiens.push(item);
					});
					$(hoSo.phuongTiens).each(function(index, item){
                        self.phuongTiensSelected.push(item.loaiPhuongTien);
					});

					$(".select5").select2({
						placeholder : '',
						width : '100%'
					});
				}
			},
			error : function(e) {
				toastr.error(e.message, NSWLang["common_msg_thong_bao"]);
			}
		});
	}

	self.getPhuongTiens();

	self.getHaiQuans = function() {
		self.haiQuans.removeAll();
		self.haiQuans.push({
			tenHaiQuan : NSWLang["moit_06_msg_chon"],
			maHaiQuan : '-1',
			idHaiQuan: 0
		});
		app.makePost({
			url : '/moit/api/07/layDsHaiQuan',
			data : JSON.stringify({}),
			success : function(d) {
				if (d.success) {
					d.data.forEach(function(item, index) {
						self.haiQuans.push(item);
					});
					$(hoSo.haiQuans).each(function(index, item){
                        self.haiQuansSelected.push(item.maHaiQuan);
					});

                    $(".select5").select2({
						placeholder : '',
						width : '100%'
					});
				}
			},
			error : function(e) {
				toastr.error(e.message, NSWLang["common_msg_thong_bao"]);
			}
		});
	}

	self.getHaiQuans();

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

        /*var findCuaKhau = ko.utils.arrayFilter(self.cuaKhausSelected(), function(prod) {
            return prod == '-1';
        });

        if (findCuaKhau[0] && self.cuaKhausSelected().length > 1) {
            cssError('cuaKhaus');
            return false;
        }*/
        var findPhuongTien = ko.utils.arrayFilter(self.phuongTiensSelected(), function(prod) {
            return prod == '-1';
        });

        if (findPhuongTien[0] && self.phuongTiensSelected().length > 1) {
            cssError('phuongTiens');
            return false;
        }

        var findHaiQuan = ko.utils.arrayFilter(self.haiQuansSelected(), function(prod) {
            return prod == '-1';
        });

        if (findHaiQuan[0] && self.haiQuansSelected().length > 1) {
            cssError('haiQuans');
            return false;
        }

		if (isGuiHoSo) {
			
			if (self.thongTinHangHoaModel.mucDich() == undefined || self.thongTinHangHoaModel.mucDich().trim() == '') {
				self.thongTinHangHoaModel.mucDich('');
				cssError('thongTinHangHoaModel_mucDich');
				return false;
			} else {
				cssSuccess('thongTinHangHoaModel_mucDich');
			}


            if (self.dsCKsText() == '') {
                cssError('cuaKhaus');
                return false;
            }

            if (findPhuongTien[0] || self.phuongTiensSelected().length == 0) {
                cssError('phuongTiens');
                return false;
            }

            if (findHaiQuan[0] || self.haiQuansSelected().length == 0) {
                cssError('haiQuans');
                return false;
            }
		}
		if (!validNgayThang(isGuiHoSo)) {
			return false;
		}
		

		return true;
	}
	
	function validNgayThang(isGuiHoSo) {
		/*if (!isGuiHoSo && (self.thongTinHangHoaModel.xuatNhapKhauTuNgay() == null || self.thongTinHangHoaModel.xuatNhapKhauTuNgay() == '')
				&& self.thongTinHangHoaModel.xuatNhapKhauDenNgay() == null || self.thongTinHangHoaModel.xuatNhapKhauDenNgay() == '') {
			return true;
		}*/
		if (self.thongTinHangHoaModel.xuatNhapKhauTuNgay() == undefined || self.thongTinHangHoaModel.xuatNhapKhauTuNgay().trim() == '') {
			self.thongTinHangHoaModel.xuatNhapKhauTuNgay('');
			cssError('thongTinHangHoaModel_xuatNhapKhauTuNgay');
			return false;
		} else {
			cssSuccess('thongTinHangHoaModel_xuatNhapKhauTuNgay');
		}
		if (self.thongTinHangHoaModel.xuatNhapKhauDenNgay() == undefined || self.thongTinHangHoaModel.xuatNhapKhauDenNgay().trim() == '') {
			self.thongTinHangHoaModel.xuatNhapKhauDenNgay('');
			cssError('thongTinHangHoaModel_xuatNhapKhauDenNgay');
			return false;
		} else {
			cssSuccess('thongTinHangHoaModel_xuatNhapKhauDenNgay');
		}
		if (!self.validDate(self.thongTinHangHoaModel.xuatNhapKhauTuNgay(), self.thongTinHangHoaModel.xuatNhapKhauDenNgay())) {
			self.thongTinHangHoaModel.xuatNhapKhauTuNgay('');
			cssError('thongTinHangHoaModel_xuatNhapKhauTuNgay');
			return false;
		} else {
			cssSuccess('thongTinHangHoaModel_xuatNhapKhauTuNgay');
		}
		var check1 = false, check2 = false;
		if (self.thongTinHangHoaModel.xuatNhapKhauTuNgay() == undefined || self.thongTinHangHoaModel.xuatNhapKhauTuNgay().trim() == '') check1 = true;
		if (self.thongTinHangHoaModel.xuatNhapKhauDenNgay() == undefined || self.thongTinHangHoaModel.xuatNhapKhauDenNgay().trim() == '') check2 = true;
		if (!check1 || !check2) {
			if (self.thongTinHangHoaModel.xuatNhapKhauTuNgay() == undefined || self.thongTinHangHoaModel.xuatNhapKhauTuNgay().trim() == '') {
				self.thongTinHangHoaModel.xuatNhapKhauTuNgay('');
				cssError('thongTinHangHoaModel_xuatNhapKhauTuNgay');
				return false;
			} else {
				cssSuccess('thongTinHangHoaModel_xuatNhapKhauTuNgay');
			}
			if (self.thongTinHangHoaModel.xuatNhapKhauDenNgay() == undefined || self.thongTinHangHoaModel.xuatNhapKhauDenNgay().trim() == '') {
				self.thongTinHangHoaModel.xuatNhapKhauDenNgay('');
				cssError('thongTinHangHoaModel_xuatNhapKhauDenNgay');
				return false;
			} else {
				cssSuccess('thongTinHangHoaModel_xuatNhapKhauDenNgay');
			}
			if (!self.validDate(self.thongTinHangHoaModel.xuatNhapKhauTuNgay(), self.thongTinHangHoaModel.xuatNhapKhauDenNgay())) {
				self.thongTinHangHoaModel.xuatNhapKhauTuNgay('');
				cssError('thongTinHangHoaModel_xuatNhapKhauTuNgay');
				return false;
			} else {
				cssSuccess('thongTinHangHoaModel_xuatNhapKhauTuNgay');
			}
			return true;
		}
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
        self.phuongTiensSelected().forEach(function(item, index){
            var findItem = ko.utils.arrayFilter(self.phuongTiens(), function(prod) {
                return item != '-1' && prod.loaiPhuongTien == item;
            });
            if (findItem[0]) {
                var item = findItem[0];
                var data = {
                    idPhuongTien: 0,
                    idHoSo: hoSo.idHoSo,
                    loaiPhuongTien: item.loaiPhuongTien,
                    hoatDong: 1
                };
                p.push(data);
            }
        });
		return p;
	}
	/*self.getCuaKhauToJson = function() {
		var p = [];
        self.cuaKhausSelected().forEach(function(item, index){
            var findItem = ko.utils.arrayFilter(self.cuaKhaus(), function(prod) {
                return item != '-1' && prod.maCuaKhau == item;
            });
            if (findItem[0]) {
                var item = findItem[0];
                var data = {
                    idCuaKhau: 0,
                    idHoSo: hoSo.idHoSo,
                    maCuaKhau: item.maCuaKhau,
                    tenCuaKhau: item.tenCuaKhau,
                    hoatDong: 1
                };
                p.push(data);
            }

        });
		return p;
	}*/
	
	self.getCuaKhauToJson = function() {
		var p = [];
		
		self.dsCKs().forEach(function(item, index){
            var data = {
					idCuaKhau: 0,
					idHoSo: hoSo.idHoSo,
					maCuaKhau: item.maCuaKhau(),
					tenCuaKhau: item.tenCuaKhau(),
					hoatDong: 1
				};
//            	console.log(data);
				p.push(data);
		});
		
		return p;
	}
	self.getHaiQuanToJson = function() {
		var p = [];

        self.haiQuansSelected().forEach(function(item, index){
            var findItem = ko.utils.arrayFilter(self.haiQuans(), function(prod) {
                return item != '-1' && prod.maHaiQuan == item;
            });
            if (findItem[0]) {
                var item = findItem[0];
                var data = {
                    idHaiQuan: 0,
                    idHoSo: hoSo.idHoSo,
                    maHaiQuan: item.maHaiQuan,
                    hoatDong: 1
                };
                p.push(data);
            }
        });

		return p;
	}

    self.cuaKhausSelected.subscribe(function () {
        var index = self.cuaKhausSelected.indexOf('-1');
        var eleId = 'cuaKhaus';
        if (index > -1) {
            self.cuaKhausSelected.splice(index, 1);
            var li = $($('#' + eleId).parent()).find('li');
            $(li[index]).remove();
        }
    })

    self.phuongTiensSelected.subscribe(function () {
        var index = self.phuongTiensSelected.indexOf('-1');
        var eleId = 'phuongTiens';
        if (index > -1) {
            self.phuongTiensSelected.splice(index, 1);
            var li = $($('#' + eleId).parent()).find('li');
            $(li[index]).remove();
        }
    })

    self.haiQuansSelected.subscribe(function () {
        var index = self.haiQuansSelected.indexOf('-1');
        var eleId = 'haiQuans';
        if (index > -1) {
            self.haiQuansSelected.splice(index, 1);
            var li = $($('#' + eleId).parent()).find('li');
            $(li[index]).remove();
        }
    })
    
    self.show = function() {
    	
		var callback = function (html) {
				 var pop = app.popup({
	                title: "Thông tin cửa khẩu",
	                html: html,
	                 backdrop: true,
	                width: 960,
	                buttons: [
	                ]
	            }, function(){
	            	var a= new ChiTietCuaKhauViewModel(hoSo, self);
		           	ko.applyBindings(a, document.getElementById("formCuaKhau"));
		           		
	            });
				 $(".select5").select2({placeholder: '',  width: '100%'});
				 $('.date-picker').datepicker({rtl: false, orientation: "left", autoclose: true});
				 self.appPopup = pop;
			 }
		
			 app.complieTemplate({
	           ministryCode: "moit",
	           code: "07",
	           templateName: "thongTinCuaKhau",
	           data: null
	       }, callback);
		}
	
	
	self.closePopup = function() {
		app.popupRemove(self.appPopup.selector);
	}


}