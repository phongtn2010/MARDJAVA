function ChiTietHangHoaViewModel(hoSo, moduleThongTinChung) {
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
	self.loaiHoSoGiaHan = ko.observable(hoSo.loaiGiayPhep == 2 ? true : false);
	self.trangThaiHangHoas = ko.observableArray();
	self.trangThaiHangHoas.push({name: NSWLang['moit_06_form_hanghoa_trangthai_0'], value: -1});
	self.trangThaiHangHoas.push({name: NSWLang['moit_06_form_hanghoa_trangthai_1'], value: 1});
	self.trangThaiHangHoas.push({name: NSWLang['moit_06_form_hanghoa_trangthai_2'], value: 2});
	self.trangThaiHangHoas.push({name: NSWLang['moit_06_form_hanghoa_trangthai_3'], value: 3});
	self.tienChats = ko.observableArray([]);
	self.copyTienChats = ko.observableArray([]);
	self.showErrorMaHonHop = ko.observable(false);
	self.showErrorHamLuong = ko.observable(false);
	self.showErrorHamLuongMin4A = ko.observable(false);
	self.showErrorHamLuongMin4B = ko.observable(false);
	
	
	moduleThongTinChung.thongTinChungModel.loaiGiayPhep.subscribe(function(oldValue) {
		if (oldValue == 2) {
			self.loaiHoSoGiaHan(true);
			capNhatLoaiHoSo(2);
		} else {
			if (oldValue == 1) {
				capNhatLoaiHoSo(1);
			}
			self.loaiHoSoGiaHan(false);
			moduleThongTinChung.editSoGP(true);
			moduleThongTinChung.thongTinChungModel.soGiayPhepDaCap(null);
			moduleThongTinChung.thongTinChungModel.lyDoGiaHan(null);
			self.soGP(null);
		}
	});
	moduleThongTinChung.thongTinChungModel.soGiayPhepDaCap.subscribe(function(oldValue) {
		self.soGP(oldValue);
	});
	function capNhatLoaiHoSo(loaiHoSo) {
		 app.makePost({
	            url: '/moit/api/07/capNhatLoaiHoSo/' + idHoSo + "/"  + loaiHoSo,
	            data: JSON.stringify({}),
	            success: function (d) {
	            },
	            error: function (e) {
	            }
	        });
	}
	
	self.soGP = ko.observable(hoSo.soGiayPhepDaCap);
	self.ct = new ChiTietHangHoaModel();
	self.maCASs = ko.observableArray([]);
	 self.getTienChats = function() {
			self.copyTienChats.removeAll();
			self.copyTienChats.push({
				name : NSWLang["moit_06_msg_chon"],
				maCAS : -1
			});
			hoSo.tienChats.forEach(function(item, index) {
				item.name = item.maCAS +  ' - ' + item.tenTiengViet + ' - ('+ item.loaiTienChat+')';
				self.copyTienChats.push(item);
			});
			
			self.pushHangHoa(hoSo.hangHoa7DTOs);
			
		}

	 self.pushHangHoa = function(data) {
		 data.forEach(function(item, index) {
				 var md =  new ChiTietHangHoaModel();
				 self.setItem(md, item)
				self.hangHoas.push(md);
			});
	 }
	 
	 self.setItem = function(md, item){
			md.congThucHoaHoc( item.congThucHoaHoc);
			md.donViTinh( item.donViTinh);
			md.hamLuong( item.hamLuong);
			md.idHangHoa( item.idHangHoa);
			md.idHoSo( item.idHoSo);
			md.maHS( item.maHS);
			md.maHonHop( item.maHonHop);
			md.moTa( item.moTa);
			md.soLuong( item.soLuong);
			md.soLuongConLai( item.soLuongConLai);
			md.soLuongDaNhap( item.soLuongDaNhap);
			md.soLuongHonHop( item.soLuongHonHop);
			md.tenKhoaHoc( item.tenKhoaHoc);
			md.tenThuongMai( item.tenThuongMai);
			md.tenTiengAnh( item.tenTiengAnh);
			md.tenTiengViet( item.tenTiengViet);
			md.maCAS( item.maCAS);
			md.loaiTienChat(item.loaiTienChat);
			md.trangThaiHangHoa( item.trangThaiHangHoa);
			
			if (item.trangThaiHangHoa == 1) {
				item.tenTrangThaiHangHoa = NSWLang['moit_06_form_hanghoa_trangthai_1'];
			} else if (item.trangThaiHangHoa == 2) {
				item.tenTrangThaiHangHoa = NSWLang['moit_06_form_hanghoa_trangthai_2'];
			} else if (item.trangThaiHangHoa == 3) {
				item.tenTrangThaiHangHoa = NSWLang['moit_06_form_hanghoa_trangthai_3'];
			} else {
				item.tenTrangThaiHangHoa = '';
			}
			md.tenTrangThaiHangHoa( item.tenTrangThaiHangHoa);
	 }
		self.getTienChats();
		
		self.ct.soLuongDaNhap.subscribe(function(oldValue) {
			var sl = parseFloat(oldValue);
			if (sl > self.ct.soLuong()){
				self.ct.soLuongConLai('0');
				return false;
			}
			var conLai = (parseFloat(self.ct.soLuong()).toFixed(5) - sl).toFixed(5);
			if (conLai != 'NaN')
			self.ct.soLuongConLai(conLai);
		});
		
		self.ct.code.subscribe(function(value) {
			if (self.loaiHoSoGiaHan() && value != '-1') {
				self.copyTienChats().forEach(function(item, index){
					if (item.maCAS == value) {
						self.ct.idCu(item.hangHoa.idHangHoa);
						self.ct.maCAS(item.hangHoa.maCAS);
						self.ct.maHS(item.hangHoa.maHoSoChat);
						self.ct.tenTiengViet(item.hangHoa.tenChatTiengViet);
						self.ct.tenTiengAnh(item.hangHoa.tenChatTiengAnh);
						self.ct.tenKhoaHoc(item.hangHoa.tenIUPAC);
						self.ct.congThucHoaHoc(item.hangHoa.congThucHoaHoc);
						self.ct.hamLuong(item.hangHoa.hamLuong);
						self.ct.tenThuongMai(item.hangHoa.tenHangHoa);
						self.ct.maHonHop(item.hangHoa.maHoSoHonHop);
						self.ct.soLuong(item.hangHoa.soLuong);
						self.ct.donViTinh(item.hangHoa.tenDonVi);
						self.ct.moTa(item.hangHoa.moTaHangHoa);
						self.ct.trangThaiHangHoa(item.hangHoa.trangThaiChat);
					}
				});
			} else  {
				changeLoaiCapMoi(value);
			}
			
		});
		
		function changeLoaiCapMoi(value) {
			if (value == -1) {
				
				if (self.ct.maHS().toString().lastIndexOf(';') != -1) {
					var maCAS = self.ct.maCAS().split(';');
					if (maCAS.length != self.maCASs().length) {
						self.ct.maCAS(self.ct.maCAS().substring(0, self.ct.maCAS().toString().lastIndexOf(';')));
						self.ct.maHS(self.ct.maHS().substring(0, self.ct.maHS().toString().lastIndexOf(';')));
						self.ct.tenTiengViet(self.ct.tenTiengViet().substring(0, self.ct.tenTiengViet().toString().lastIndexOf(';')));
						self.ct.tenTiengAnh(self.ct.tenTiengAnh().substring(0, self.ct.tenTiengAnh().toString().lastIndexOf(';')));
						self.ct.tenKhoaHoc(self.ct.tenKhoaHoc().substring(0, self.ct.tenKhoaHoc().toString().lastIndexOf(';')));
						self.ct.congThucHoaHoc(self.ct.congThucHoaHoc().substring(0, self.ct.congThucHoaHoc().toString().lastIndexOf(';')));
						self.ct.loaiTienChat(self.ct.loaiTienChat().substring(0, self.ct.loaiTienChat().toString().lastIndexOf(';')));
						self.ct.hamLuong(self.ct.hamLuong().substring(0, self.ct.hamLuong().toString().lastIndexOf(';')));
					}
					
				}
				
				cssSuccess('ct_hamLuong');
				return;
			}
			self.copyTienChats().forEach(function(item, index){
				if (item.maCAS == value) {
					var maCas = self.ct.maCAS().split(';');
					if (maCas.length == self.maCASs().length) {
						var hl = self.ct.hamLuong();
						if (hl) {
							self.ct.hamLuong(hl + '; ');
						}
						
						if (!self.loaiHoSoGiaHan()) {
							cssError('ct_hamLuong');
						}
					
					}
					var maCAS = self.ct.maCAS().split(';');
					var tenTiengViet = self.ct.tenTiengViet().split(';');
					var tenTiengAnh = self.ct.tenTiengAnh().split(';');
					var tenKhoaHoc = self.ct.tenKhoaHoc().split(';');
					var congThucHoaHoc = self.ct.congThucHoaHoc().split(';');
					var loaiTienChat = self.ct.loaiTienChat().split(';');
					var maHS = self.ct.maHS().split(';');
					var hamLuong = self.ct.hamLuong().split(';');
					
					var maCASa = '';
					var maHSa = '';
					var tenTiengVieta = '';
					var tenTiengAnha = '';
					var tenKhoaHoca = '';
					var congThucHoaHoca = '';
					var loaiTienChata = '';
					var hamLuonga = '';
					for (var i = 0; i < self.maCASs().length; i++) {
						maHSa += maHS[i] + ";";
						maCASa += maCAS[i] + ";";
						tenTiengVieta += tenTiengViet[i] + ";";
						tenTiengAnha += tenTiengAnh[i] + ";";
						tenKhoaHoca += tenKhoaHoc[i] + ";";
						congThucHoaHoca += congThucHoaHoc[i] + ";";
						loaiTienChata += loaiTienChat[i] + ";";
						hamLuonga += hamLuong[i] + ";";
					}
					maCASa += item.maCAS;
					maHSa += item.maHS;
					tenTiengVieta += item.tenTiengViet;
					tenTiengAnha += item.tenTiengAnh;
					tenKhoaHoca += item.tenKhoaHoc;
					congThucHoaHoca += item.congThucHoaHoc;
					loaiTienChata += item.loaiTienChat;
					
					
					
					self.ct.maCAS(maCASa);
					self.ct.maHS(maHSa);
					self.ct.tenTiengViet(tenTiengVieta);
					self.ct.tenTiengAnh(tenTiengAnha);
					self.ct.tenKhoaHoc(tenKhoaHoca);
					self.ct.congThucHoaHoc(congThucHoaHoca);
					self.ct.loaiTienChat(loaiTienChata);
				
					
					if (self.loaiHoSoGiaHan()) {
						hamLuonga += item.hamLuong;
						self.ct.hamLuong(hamLuonga);
						self.ct.soLuong(item.soLuong);
						self.ct.donViTinh(item.tenDonVi);
						self.ct.tenThuongMai(item.tenHangHoa);
						self.ct.donViTinh(item.tenDonVi);
						self.ct.trangThaiHangHoa(item.trangThaiChat);
						self.ct.moTa(item.moTaHangHoa);
						self.ct.maHonHop(item.maHonHop);
					}
					if (self.maCASs().length == 0 && !self.loaiHoSoGiaHan()) {
						cssError('ct_tenThuongMai');
					}
					return false;
				}
			})
		}
		
		self.save = function() {
			
			var data = {
						idHangHoa : self.ct.idHangHoa(),
						maCAS : self.ct.maCAS(),
						idHoSo : hoSo.idHoSo,
						maHS : self.ct.maHS(),
						congThucHoaHoc : self.ct.congThucHoaHoc(),
						tenTiengAnh : self.ct.tenTiengAnh(),
						tenTiengViet : self.ct.tenTiengViet(),
						tenKhoaHoc : self.ct.tenKhoaHoc(),
						tenThuongMai : self.ct.tenThuongMai(),
						maHonHop : self.ct.maHonHop(),
						hamLuong : self.ct.hamLuong(),
						soLuongHonHop : self.ct.soLuongHonHop(),
						trangThaiHangHoa : self.ct.trangThaiHangHoa(),
						donViTinh : self.ct.donViTinh(),
						moTa : self.ct.moTa(),
						soLuong : self.ct.soLuong(),
						soLuongDaNhap : self.ct.soLuongDaNhap(),
						soLuongConLai : self.ct.soLuongConLai(),
						xoaMaCAS: self.ct.xoaMaCAS(),
						loaiTienChat: self.ct.loaiTienChat()
						
				};
			if (data.idHangHoa == undefined) data.idHangHoa = 0;
			if (data.soLuong == undefined) data.soLuong = 0;
			if (data.soLuongDaNhap == undefined) data.soLuongDaNhap = 0;
			if (data.soLuongConLai == undefined) data.soLuongConLai = 0;
			if (data.idHoSo == undefined) data.idHoSo = 0;
			
			if (self.maCASs().length == 0 && self.ct.code() == '-1') {
				cssError('ct_maCAS');
				return;
			} else {
				cssSuccess('ct_maCAS');
			}
			if (data.maHS == null || data.maHS == undefined || data.maHS.trim() == '') {
				cssError('ct_maHS');
				return;
			} else {
				cssSuccess('ct_maHS');
			}
			
			if (data.congThucHoaHoc == null || data.congThucHoaHoc == undefined || data.congThucHoaHoc.trim() == '') {
				cssError('ct_congThucHoaHoc');
				return;
			} else {
				cssSuccess('ct_congThucHoaHoc');
			}

			
			if (data.tenTiengViet == null || data.tenTiengViet == undefined || data.tenTiengViet.trim() == '') {
				cssError('ct_tenTiengViet');
				return;
			} else {
				cssSuccess('ct_tenTiengViet');
			}
			if (data.tenTiengAnh == null || data.tenTiengAnh == undefined || data.tenTiengAnh.trim() == '') {
				cssError('ct_tenTiengAnh');
				return;
			} else {
				cssSuccess('ct_tenTiengAnh');
			}
			if (data.tenKhoaHoc == null || data.tenKhoaHoc == undefined || data.tenKhoaHoc.trim() == '') {
				cssError('ct_tenKhoaHoc');
				return;
			} else {
				cssSuccess('ct_tenKhoaHoc');
			}
			if (data.tenThuongMai == null || data.tenThuongMai == undefined || data.tenThuongMai.trim() == '') {
				cssError('ct_tenThuongMai');
				return;
			} else {
				cssSuccess('ct_tenThuongMai');
			}
			if (data.maHonHop == null || data.maHonHop == undefined || data.maHonHop.trim() == '') {
				cssError('ct_maHonHop');
				return;
			} else {
				cssSuccess('ct_maHonHop');
			}
			
			if (data.hamLuong == null || data.hamLuong == undefined || data.hamLuong.trim() == '') {
				cssError('ct_hamLuong');
				return;
			} else {
				cssSuccess('ct_hamLuong');
			}
			
			
			var maHHs = self.ct.hamLuong().toString().split(';');
			var maCASs = self.ct.maCAS().toString().split(';');
			var loaiTienChats = data.loaiTienChat.split(';');
			if (maHHs.length  != maCASs.length) {
				cssError('ct_hamLuong');
				self.showErrorHamLuong(true);
				return;
			} else {
				self.showErrorHamLuong(false);
				cssSuccess('ct_hamLuong');
			}
			
			for (var i = 0; i < maHHs.length; i++) {
				if (maHHs[i].trim() == '') {
					cssError('ct_hamLuong');
					self.showErrorHamLuong(true);
					return;
				} 
				var value = parseFloat(maHHs[i]);
				if ((loaiTienChats[i] == 'IV.A' && value < 1) || value > 100) {
					self.showErrorHamLuongMin4A(true);
					return;
				}
				if ((loaiTienChats[i] == 'IV.B' && value < 5)  || value > 100) {
					self.showErrorHamLuongMin4B(true);
					return;
				}
			}
			
			
			if (data.soLuong == null || data.soLuong == undefined || data.soLuong == '') {
				cssError('ct_soLuong');
				return;
			} else {
				cssSuccess('ct_soLuong');
			}
			if (data.donViTinh == null || data.donViTinh == undefined || data.donViTinh == '-1') {
				cssError('ct_donViTinh');
				return;
			} else {
				cssSuccess('ct_donViTinh');
			}
			if (data.trangThaiHangHoa == null || data.trangThaiHangHoa == undefined  || data.trangThaiHangHoa == '-1') {
				cssError('ct_trangThaiHangHoa');
				return;
			} else {
				cssSuccess('ct_trangThaiHangHoa');
			}
			if (data.moTa == null || data.moTa == undefined || data.moTa.trim() == '' || data.moTa == '-1') {
				cssError('ct_moTa');
				return;
			} else {
				cssSuccess('ct_moTa');
			}
			
			if (self.loaiHoSoGiaHan()) {
				if (data.soLuongDaNhap == null || data.soLuongDaNhap == undefined || data.soLuongDaNhap.toString().trim() == '') {
					cssError('ct_soLuongDaNhap');
					return;
				} else {
					cssSuccess('ct_soLuongDaNhap');
				}
				
				if (parseFloat(data.soLuongDaNhap) > self.ct.soLuong()) {
					app.Alert(NSWLang["moit_07_form_cthanghoa_error_soLuongDaNhapKhongDuocLonHon"]);
					return false;
				}
				
			}
			if (hoSo.idHoSo == 0) {
				
				 if (self.ct.idHangHoa() == 0) {
					 data.idHangHoa = -1;
                  	 self.pushHangHoa([data]);
                  	 self.formatItem(self.hangHoas()[0]);
                  	 self.ct.idHangHoa(-1);
                } else {
               	  self.hangHoas().forEach(function(item, index){
                   	  if (item.idHangHoa() == data.idHangHoa) {
                   		  self.setItem(item, data);
                   		  self.formatItem(item);
                   	  } 
                      });
                }
				 if (self.loaiHoSoGiaHan()) {
                 	app.popupRemove(self.appPopup.selector);
                 }
				 moduleThongTinChung.editSoGP(false);
            	 moduleThongTinChung.changeLoaiHoSo(false);
				return;
			}
			
			app.makePost({
                url:'/moit/api/07/addHangHoa/' + hoSo.idHoSo,
                data: JSON.stringify(data),
                success: function (d) {
                    var msg = d.message;
                    var fun = 'success';
                    if (d.success) {
                    	moduleThongTinChung.editSoGP(false);
                    	 moduleThongTinChung.changeLoaiHoSo(false);
                        app.toast({
                            title: NSWLang["common_msg_thong_bao"],
                            message: msg,
                            function: fun
                        });
                        if (self.ct.idHangHoa() == 0) {
	                       	 self.pushHangHoa([d.data]);
	                       	var endItem = self.hangHoas()[self.hangHoas().length - 1];
	                       	endItem.idCu(self.ct.idCu());
	                       	self.formatItem(endItem);
	                       	
	                       	 
	                     } else {
	                    	  self.hangHoas().forEach(function(item, index){
	                        	  if (item.idHangHoa() == d.data.idHangHoa) {
	                        		  self.setItem(item, d.data);
	                        			item.idCu(self.ct.idCu());
	                        		  self.formatItem(item);
	                        		  return false;
	                        	  } 
	                           });
	                     }
                        
                        self.tienChats().forEach(function(item, index) {
    						if (item.maCAS == d.data.maCAS) {
    							self.tienChats.remove(item);
    						}
    					});
                        if (self.loaiHoSoGiaHan()) {
                        	app.popupRemove(self.appPopup.selector);
                        }
                    } 
                    
                },
                error: function (e) {
                    toastr.error(NSWLang["common_msg_thong_bao"], e.message);
                }
            });
			
		}
		
		self.xoaMaCAS = function(item) {
			self.maCASs().forEach(function(p,index){
				if (p == item) {
					var maCAS = self.ct.maCAS().split(';');
					var tenTiengViet = self.ct.tenTiengViet().split(';');
					var tenTiengAnh = self.ct.tenTiengAnh().split(';');
					var tenKhoaHoc = self.ct.tenKhoaHoc().split(';');
					var congThucHoaHoc = self.ct.congThucHoaHoc().split(';');
					var loaiTienChat = self.ct.loaiTienChat().split(';');
					var maHS = self.ct.maHS().split(';');
					var hamLuong = self.ct.hamLuong().split(';');
					
					var maCASa = '';
					var maHSa = '';
					var tenTiengVieta = '';
					var tenTiengAnha = '';
					var tenKhoaHoca = '';
					var congThucHoaHoca = '';
					var loaiTienChata = '';
					var hamLuonga = '';
					for (var i = 0; i < self.maCASs().length; i++) {
						if (i == index) continue;
						maHSa += ";" + maHS[i] ;
						maCASa +=  ";" + maCAS[i];
						tenTiengVieta += ";" + tenTiengViet[i] ;
						tenTiengAnha += ";" + tenTiengAnh[i] ;
						tenKhoaHoca += ";" + tenKhoaHoc[i] ;
						congThucHoaHoca += ";" + congThucHoaHoc[i] ;
						loaiTienChata += ";" + loaiTienChat[i] ;
						hamLuonga += ";" + hamLuong[i] ;
					}
					self.ct.maCAS(maCASa.substring(1));
					self.ct.maHS(maHSa.substring(1));
					self.ct.tenTiengViet(tenTiengVieta.substring(1));
					self.ct.tenTiengAnh(tenTiengAnha.substring(1));
					self.ct.tenKhoaHoc(tenKhoaHoca.substring(1));
					self.ct.congThucHoaHoc(congThucHoaHoca.substring(1));
					self.ct.loaiTienChat(loaiTienChata.substring(1));
					self.ct.hamLuong(hamLuonga.substring(1));
					
					self.maCASs.remove(item);
				}
				
			})
		}
		
		
		self.checkStatus = function(item) {
			if (item.trangThaiHangHoa == 1) {
				item.tenTrangThaiHangHoa = NSWLang['moit_06_form_hanghoa_trangthai_1'];
			} else if (item.trangThaiHangHoa == 2) {
				item.tenTrangThaiHangHoa = NSWLang['moit_06_form_hanghoa_trangthai_2'];
			} else if (item.trangThaiHangHoa == 3) {
				item.tenTrangThaiHangHoa = NSWLang['moit_06_form_hanghoa_trangthai_3'];
			} else {
				item.tenTrangThaiHangHoa = '';
			}
		}
		
		self.deleteHangHoa = function(item){
			if (item.idHangHoa() > 0) {
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
		                             url:'/moit/api/07/xoaHangHoa/' + item.idHangHoa(),
		                             data: JSON.stringify({}),
		                             success: function (d) {
		                                 if (d.success) {
		                                     app.popupRemove(pop.selector);
		                                     self.hangHoas.remove(item);
		                                     if (self.hangHoas().length == 0) {
		                                    	 moduleThongTinChung.editSoGP(true);
		                                    	 moduleThongTinChung.changeLoaiHoSo(true);
		                                     }
		                                    
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
				if (self.hangHoas().length == 0) {
               	 moduleThongTinChung.editSoGP(false);
               	 moduleThongTinChung.changeLoaiHoSo(false);
                }
				self.hangHoas.remove(item);
			}
		}
		
		
		
		self.isValid = function(isGuiHoSo) {
			if (isGuiHoSo) {
				if (self.hangHoas().length == 0) {
					app.Alert(NSWLang["moit_07_form_cthanghoa_error_thieuHangHoa"]);
					return false;
				}
			}
			return true;
		}
		
		self.getHangHoas = function(){
			var hhs = [];
			$(self.hangHoas()).each(function(index, item){
				hhs.push({
					idHangHoa : item.idHangHoa(),
					maCAS : item.maCAS(),
					idHoSo : hoSo.idHoSo,
					maHS : item.maHS(),
					congThucHoaHoc : item.congThucHoaHoc(),
					tenTiengAnh : item.tenTiengAnh(),
					tenTiengViet : item.tenTiengViet(),
					tenKhoaHoc : item.tenKhoaHoc(),
					tenThuongMai : item.tenThuongMai(),
					maHonHop : item.maHonHop(),
					hamLuong : item.hamLuong(),
					soLuongHonHop : item.soLuongHonHop(),
					trangThaiHangHoa : item.trangThaiHangHoa(),
					donViTinh : item.donViTinh(),
					moTa : item.moTa(),
					soLuong : item.soLuong(),
					soLuongDaNhap : item.soLuongDaNhap(),
					soLuongConLai : item.soLuongConLai(),
					xoaMaCAS: item.xoaMaCAS()
				});
			});
			return hhs;
		}
		
		self.soLuongNumberInputKeyPressEvent = function( value, data, event) {
			return self.checkInputNumber( value, data, event, 12, 6, [8, 46, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57]);
	     }
		self.hamLuongNumberInputKeyPressEvent = function( value, data, event) {
			var numbers = value.split(';');
			if (numbers != undefined && numbers.length > 1) value = numbers[numbers.length - 1].trim();
			if (parseFloat(value) > 100 || parseFloat(value) < 0) return false;
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
			var keys = [8, 46, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 59];
			var x = event.which || event.keyCode;
			 if (x == 8) return true;
			 
			if (dauChamPhay > 1) {
				return false;
			}
	        if ($.inArray(x, keys) === -1) { 
	           return false;
	        }
	       
	        return true;
	     }
		
		
		self.checkInputNumber = function( value, data, event, pn, ptp, keys) {
			var dauChamPhay = 0;
			var phanThapPhan = 0;
			var phanNguyen = 0;
			for(var i = 0; i < value.length; i++) {
				if (value[i] == '.') {
					if (dauChamPhay > 0) {
						return false;
					}
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
			 if (x == 8) return true;
			 
			
	        if ($.inArray(x, keys) === -1) { 
	           return false;
	        }
	        if (phanThapPhan + phanNguyen > pn) return false;
	        if (phanNguyen == pn && dauChamPhay == 0) return false;
	        if (phanThapPhan == ptp && x == 8) return true;
	        if (phanThapPhan == ptp) return false;
	        return true;
		}
		
		self.formatItem = function(item) {
			self.ct.code('-1');
			self.maCASs.removeAll();
			if (item != null && item.maCAS != null) {
				var maCA = item.maCAS().split(';');
				if (maCA != null) {
					maCA.forEach(function(p, index){
						if (p != '-1') {
							self.maCASs.push(p);
						}
					});
					self.tienChats.removeAll();
					self.copyTienChats().forEach(function(item, index) {
						if (self.maCASs.indexOf(item.maCAS) == -1) {
							self.tienChats.push(item);
						}
					});
				}
			} else {
				self.tienChats.removeAll();
				self.copyTienChats().forEach(function(loopItem, index) {
					if (self.loaiHoSoGiaHan()) {
						var exists = false;
						for (var i = 0; i < self.hangHoas().length; i++) {
							if (loopItem.hangHoa) {
								if (self.hangHoas()[i].maCAS() == loopItem.hangHoa.maCAS
										&& self.hangHoas()[i].maHonHop() == loopItem.hangHoa.maHoSoHonHop
										&& self.hangHoas()[i].hamLuong() == loopItem.hangHoa.hamLuong) {
									exists = true;
								}
							}
						}
						if (!exists) {
							self.tienChats.push(loopItem);
						}
						
					} else {
						self.tienChats.push(loopItem);
					}
					
				});
			}
			self.ct.maCAS( item == null ? '': item.maCAS());
			self.ct.congThucHoaHoc( item == null ? '': item.congThucHoaHoc());
			self.ct.donViTinh(  item == null ? '': item.donViTinh());
			self.ct.hamLuong(  item == null ? '': item.hamLuong());
			self.ct.idHangHoa(  item == null ? '0': item.idHangHoa());
			self.ct.idHoSo(  item == null ? '0': item.idHoSo());
			self.ct.maHS(  item == null ? '': item.maHS());
			self.ct.maHonHop( item == null ? '':  item.maHonHop());
			self.ct.moTa(  item == null ? '': item.moTa());
			self.ct.trangThaiHangHoa(  item == null ? '': item.trangThaiHangHoa());
			self.ct.soLuong(  item == null ? '': item.soLuong());
			self.ct.soLuongConLai(  item == null ? '': item.soLuongConLai());
			self.ct.soLuongDaNhap(  item == null ? '': item.soLuongDaNhap());
			self.ct.soLuongHonHop(  item == null ? '': item.soLuongHonHop());
			self.ct.tenKhoaHoc(  item == null ? '': item.tenKhoaHoc());
			self.ct.tenThuongMai( item == null ? '':  item.tenThuongMai());
			self.ct.tenTiengAnh(  item == null ? '': item.tenTiengAnh());
			self.ct.tenTiengViet(  item == null ? '': item.tenTiengViet());
			self.ct.loaiTienChat(  item == null ? '': item.loaiTienChat());
			self.showErrorHamLuong(false);
			self.showErrorHamLuongMin4A(false);
			self.showErrorHamLuongMin4B(false);
           	self.showErrorMaHonHop(false);
         
		}
		self.chinhSuaHangHoaGH = ko.observable(false);
		self.addHangHoa = function(item) {
			
			if (self.loaiHoSoGiaHan()) {
				if (!self.soGP()) {
					self.soGP('-1');
				}
				if (item != null) self.chinhSuaHangHoaGH(true);
				else self.chinhSuaHangHoaGH(false);
				 app.makePost({
			            url: '/moit/api/07/capNhatSoGiayPhep/' + idHoSo + "?soGP="  + self.soGP(),
			            data: JSON.stringify({}),
			            success: function (d) {
			            },
			            error: function (e) {
			            }
			        });
				 
				 app.makePost({
			            url: '/moit/api/07/layDsTienChat?maSoGP=' + self.soGP(),
			            data: JSON.stringify({}),
			            success: function (d) {
			            	 if (d.data != null && d.data.length > 0) {
			            		 self.copyTienChats.removeAll();
				            	 self.copyTienChats.push({
				      				name : NSWLang["moit_06_msg_chon"],
				      				maCAS : -1
				      			});
			            		 d.data.forEach(function(item, index){
			            			 item.name = item.hangHoa.maCAS +  ' - ' + item.hangHoa.tenHangHoa;
			            			 self.copyTienChats.push(item);
				            	 })
				            	
			            	 } else {
			            		 self.copyTienChats.removeAll();
				            	 self.copyTienChats.push({
				      				name : NSWLang["moit_06_msg_chon"],
				      				maCAS : -1
				      			});
			            	 }
			            	 if (item != null) {
									self.formatItem(item);
								} else {
									self.formatItem(null);
								}
			            },
			            error: function (e) {
			                toastr.error(e.message, NSWLang["common_msg_thong_bao"]);
			            }
			        });
			} else {
				 self.copyTienChats.removeAll();
            	 self.copyTienChats.push({
      				name : NSWLang["moit_06_msg_chon"],
      				maCAS : -1
      			});
            	 if (moduleThongTinChung.thongTinChungModel.loaiGiayPhep() == '1') {
            		 hoSo.tienChats.forEach(function(item, index) {
     					item.name = item.maCAS +  ' - ' + item.tenTiengViet + ' - ('+ item.loaiTienChat+')';
     					self.copyTienChats.push(item);
     				});
            	 }
				
				if (item != null) {
					self.formatItem(item);
				} else {
					self.formatItem(null);
				}
			}
			
			var callback = function (html) {
				 var pop = app.popup({
	                title: NSWLang["moit_07_form_cthanghoa_popupTitle"],
	                html: html,
                     backdrop: true,
	                width: 960,
	                buttons: [
	                ]
	            }, function(){
		           	ko.applyBindings(self, document.getElementById("formChiTietHangHoa"));
		           		
	            });
				 $(".select5").select2({placeholder: '',  width: '100%'});
				 $('.date-picker').datepicker({rtl: false, orientation: "left", autoclose: true});
				 self.appPopup = pop;
			 }
		
			 app.complieTemplate({
	           ministryCode: "moit",
	           code: "07",
	           templateName: "chiTietHangHoa",
	           data: null
	       }, callback);
		}
		
		self.close = function(){
			app.popupRemove(self.appPopup.selector);
		}
		
		self.keypressdown = function(loai) {
			   var event = window.event;
			   var sl = self.ct.soLuong();
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
		
		self.keypressdownSoLuongDaNhap = function() {
			   var event = window.event;
			   var sl = self.ct.soLuongDaNhap();
			    if (sl != undefined && sl != '') {
			    	sl = sl.toString();
			    	var chars = sl.split('');
			    	for (var i = 0; i < chars.length; i++) {
			    		if (chars[i] == '.' && event.key == '.') {
			    			return false;
			    		}
			    	}
			    }
			    sl += event.key;
			    if (parseFloat(sl) > parseFloat(self.ct.soLuong())) return false;
			    return true;
			}
		
		
		
}
