function ThongTinPheLieuViewModel() {
		
	var self = this;
	self.contextPath = ko.observable($('#uriContextPath').val());
	self.danhSachPheLieu = ko.observableArray();
	self.dsPheLieu = ko.observableArray();
	
	self.numberInputKeyPressEvent = function( value, data, event) {
		var dauChamPhay = 0;
		var phanThapPhan = 0;
		var phanNguyen = 0;
		for(var i = 0; i < value.length; i++) {
			if (value[i] === '.') {
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
        if (phanThapPhan + phanNguyen > 14) return false;
        if (phanNguyen == 15 && dauChamPhay == 0) return false;
        if (phanThapPhan == 3 && x == 8) return true;
        if (phanThapPhan == 3) return false;
        return true;
     }
	
	self.copyItem = function(item) {
		var pl = new PheLieuModel();
		pl.soThuTu(item == null ? 1: item.soThuTu);
		pl.index(item == null ? 0: item.index);
		pl.tenPheLieu(item == null ? '': item.tenPheLieu);
		pl.maHS(item == null ? '': item.maHS);
		pl.tenPheLieu2(item == null ? '-1': item.tenPheLieu2);
		pl.maHS2(item == null ? '-1': item.maHS2);
		pl.idPL(item == null ? 0: item.idPL);
		pl.idHS(item == null ? 0: item.idHS);
		pl.khoiLuong(item == null ? '': item.khoiLuong);
		pl.khoiLuong6(item == null ?  '': item.khoiLuong6);
		pl.klCongSuat(item == null ?  '': item.klCongSuat);
		pl.donViUyThac(item == null ?  '': item.donViUyThac);
		pl.donViUyThac2(item == null ?  '': item.donViUyThac);
		pl.taoMoi(item == null ?  1: item.taoMoi);
		pl.capNhat(0);
		pl.xoaBo(0);
		pl.enable(item == null ?  true: item.enable);
		pl.canUpdate(item == null ?  false: item.canUpdate);
		pl.canDelete(item == null ?  false: item.canDelete);
		
		return pl;
	}
	

	self.themDongCuoiCung = function() {
		var pl = self.copyItem(null);
		pl.soThuTu(self.dsPheLieu().length + 1);
		pl.index(self.dsPheLieu().length);
		self.dsPheLieu.push(pl);
		 $(".select3").select2({placeholder: '', width: '200'});
    	 $(".select4").select2({placeholder: '', width: '200'});
    	 $(".td-input-03").css('width', '200');
    	 $(".pl-td-chuc-nang").css('width', '220');
	}

	self.layDanhSachPheLeuTheoHoSo = function() {

		var idHS = parseInt($('#idHS').val());
		app.makePost({
            url: self.contextPath() + '/danhSachPL',
            data: JSON.stringify({}),
            success: function (d) {
            	if (d.success) {
                  	self.danhSachPheLieu.removeAll();
            		d.data.forEach(function (item, index) {
            			item.index = index;
            			item.soThuTu = index + 1;
						self.danhSachPheLieu.push(self.copyItem(item));
            	    });
            		
            		//lay danh sach phe lieu da co
            		app.makePost({
                        url: self.contextPath() + '/danhSachPLTheoHS/' + idHS,
                        data: JSON.stringify({}),
                        success: function (d) {
                        	if (d.success && d.data != null && d.data.length > 0) {
                              	self.dsPheLieu.removeAll();
                        		d.data.forEach(function (item, index) {
                        			item.index = index;
                        			item.soThuTu = index + 1;
                        			item.maHS2 = item.maHS;
                        			item.tenPheLieu2 = item.maHS;
                        			item.enable = false;
                        			item.taoMoi = 0;
            						self.dsPheLieu.push(self.copyItem(item));
                        	    });
                        	} 
                        	
                        	if ($('#xemHoSo').val() == 'false') {
                        		self.themDongCuoiCung();
                        	} else {
                        		 $(".select3").select2({placeholder: '', width: '200'});
                            	 $(".select4").select2({placeholder: '', width: '200'});
                            	 $(".td-input-03").css('width', '200');
                        	}
                        		
                        },
                        error: function(e){
                        	if ($('#xemHoSo').val() == 'false')
                        		self.themDongCuoiCung();
                        }
                    });
            	}
            }
        });
		
	}

	self.layDanhSachPheLeuTheoHoSo();


	self.themDongNhapPheLieu = function() {
		var idHS = parseInt($('#idHS').val());
		var loaiThuTuc = parseInt($('#loaiThuTucHienTai').val());
		var check = true;
		$(self.dsPheLieu()).each(function(index, item){
			if (item.valid.errors().length != 0 || item.tenPheLieu2() == '-1' || item.maHS2() == '-1'){
				item.valid.errors.showAllMessages();
				check = false;
				app.Alert(NSWLang["monre_01_error_message_thong_tin_phe_lieu"] + ' ' + (index + 1));
				if (loaiThuTuc == 3 || loaiThuTuc == 4) {
					item.valid2.errors.showAllMessages();
					return false;
				}
				return false;
			}
		});
		if (check) {
			var pl = self.dsPheLieu()[self.dsPheLieu().length - 1];
			if (idHS > 0 && self.dsPheLieu().length > 0) {
				//ghi vao db
				var postData = {
					idPL: pl.idPL(),
					idHS: idHS,
					tenPheLieu: pl.tenPheLieu(),
					maHS: pl.maHS2(),
					khoiLuong: pl.khoiLuong(),
					khoiLuong6: pl.khoiLuong6(),
					klCongSuat: pl.klCongSuat(),
					donViUyThac: pl.donViUyThac(),
					khoiLuongInput: pl.khoiLuong(),
					khoiLuong6Input: pl.khoiLuong6(),
					klCongSuatInput: pl.klCongSuat(),
					xoaBo: 0,
					taoMoi: 1,
					capNhat: 0
				};
				app.makePost({
                    url: self.contextPath() + '/capNhapPheLieuTheoHS',
                    data: JSON.stringify(postData),
                    success: function (d) {
                        var msg = '';
                        var fun = 'success';
                        if (d.success) {
                            msg = NSWLang["common_msg_cap_nhat_du_lieu_thanh_cong"];
                            var pl = self.dsPheLieu()[self.dsPheLieu().length -1];
                            pl.idPL(d.data[0].idPL);
                            pl.canUpdate(true);
                            pl.canDelete(true);
                            pl.enable(false);
                     		self.themDongCuoiCung();
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
                        app.toast({
                            title: NSWLang["common_msg_thong_bao"],
                            message: e.message,
                        });
                    }
                });
			} else {
				 pl.canUpdate(true);
                 pl.canDelete(true);
                 pl.enable(false);
				self.themDongCuoiCung();
			}
		}
	}
	
	self.capNhatDongPheLieuNhapClick = function(pItem) {
		pItem.enable(true);
		pItem.capNhat(1);
	}
	
	self.capNhatThongTinDongPheLieu = function(pl) {
		var idHS = parseInt($('#idHS').val());
		if (idHS > 0 && self.dsPheLieu().length > 0) {
			//ghi vao db
			var postData = {
				idPL: pl.idPL(),
				idHS: idHS,
				tenPheLieu: pl.tenPheLieu(),
				maHS: pl.maHS2(),
				khoiLuong: pl.khoiLuong(),
				khoiLuong6: pl.khoiLuong6(),
				klCongSuat: pl.klCongSuat(),
				donViUyThac: pl.donViUyThac(),
				khoiLuongInput: pl.khoiLuong(),
				khoiLuong6Input: pl.khoiLuong6(),
				klCongSuatInput: pl.klCongSuat(),
				xoaBo: 0,
				taoMoi: 0,
				capNhat: 1
			};
			app.makePost({
                url: self.contextPath() + '/capNhapPheLieuTheoHS',
                data: JSON.stringify(postData),
                success: function (d) {
                    var msg = '';
                    var fun = 'success';
                    if (d.success) {
                        msg = NSWLang["common_msg_cap_nhat_du_lieu_thanh_cong"];
                        pl.enable(false);
                        pl.capNhat(0);
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
                    app.toast({
                        title: NSWLang["common_msg_thong_bao"],
                        message: e.message,
                    });
                }
            });
		} else {
			 pl.enable(false);
             pl.capNhat(0);
		}
	}
	self.xoaDongPheLieuNhapClick = function(pItem) {
		
		var idHS = parseInt($('#idHS').val());
		if (idHS > 0 && pItem.idPL() > 0) {
			 var pop = app.popup({
	             title: NSWLang["common_msg_thong_bao"],
	             html: '<i class="fa fa-3x fa-warning"></i> ' + NSWLang["monre_01_confirm_xoa_bo_thong_tin_phe_lieu"] + ' <b>'+ pItem.maHS() +'</b>',
	             width: 400,
	             buttons: [
	                 {
	                     name: NSWLang["common_button_toi_chac_chan"],
	                     class: 'btn',
	                     icon: 'fa-check',
	                     action: function () {
	                         app.makePost({
	                             url: self.contextPath() + '/xoaPLTheoHS/' + pItem.idPL(),
	                             data: JSON.stringify({}),
	                             success: function (d) {
	                                 var msg = '';
	                                 var fun = 'success';
	                                 if (d.success) {
	                                     msg = NSWLang["common_msg_cap_nhat_du_lieu_thanh_cong"];
	                                     app.popupRemove(pop.selector);
	                                     self.dsPheLieu().forEach(function (item, index) {
	                                    	 if (item.maHS2() == pItem.maHS2()) {
	                                    		 self.dsPheLieu.remove(item);
	                                    	 }
	                             	    });
	                                     self.dsPheLieu().forEach(function (item, index) {
	                                    	item.index(index);
	                                    	item.soThuTu(index + 1);
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
	                             }
	                         });
	                     }
	                 }
	             ]
	         });
		} else {
			 self.dsPheLieu().forEach(function (item, index) {
            	 if (item.maHS2() == pItem.maHS2()) {
            		 self.dsPheLieu.remove(item);
            	 }
     	    });
             self.dsPheLieu().forEach(function (item, index) {
            	item.index(index);
            	item.soThuTu(index + 1);
     	    });
		}
		
	}
	
	self.chonTenPheLieuChangeEvent = function(eleId, maHSEleId, tdId, item) {
		item.maHS2(item.tenPheLieu2());
		item.tenPheLieu($('#' + eleId + ' :selected').text());
		item.maHS($('#' + maHSEleId + ' :selected').text());
		$('#' + maHSEleId).parent().find('.select2-selection__rendered').text(item.maHS());
		$('#' + maHSEleId).parent().find('.select2-selection__rendered').attr('title', item.maHS());
	}

	self.chonMaHSChangeEvent = function(eleId, maHSEleId, tdId, item) {
		item.tenPheLieu2(item.maHS2());
		item.maHS($('#' + maHSEleId + ' :selected').text());
		item.tenPheLieu($('#' + eleId + ' :selected').text());
		$('#' + eleId).parent().find('.select2-selection__rendered').text(item.tenPheLieu());
		$('#' + eleId).parent().find('.select2-selection__rendered').attr('title', item.tenPheLieu());
	}
	
	self.guiHoSo = function(isGuiHoSo) {
		var loaiThuTuc = parseInt($('#loaiThuTucHienTai').val());
		if (isGuiHoSo) {
			if (self.dsPheLieu().length == 1) {
				var pl0 = self.dsPheLieu()[0];
				if (pl0.valid.errors().length != 0) {
					pl0.valid.errors.showAllMessages(true);
					if (loaiThuTuc == 3 || loaiThuTuc == 4) {
						pl0.valid2.errors.showAllMessages(true);
					}
					app.Alert( NSWLang["monre_01_gui_ho_so_yeu_cau_thong_tin_phe_lieu"]);
					return false;
				}
				if (loaiThuTuc == 3 || loaiThuTuc == 4) {
					if (pl0.valid2.errors().length != 0) {
						pl0.valid2.errors.showAllMessages(true);
						app.Alert( NSWLang["monre_01_gui_ho_so_yeu_cau_thong_tin_phe_lieu"]);
						return false;
					}
				}
				if (pl0.maHS2() == '-1') {
					app.Alert(NSWLang["monre_01_error_message_thong_tin_phe_lieu"] + ' ' + ( 1));
					return false;
				}
			}
		}
		var check = true;
		$(self.dsPheLieu()).each(function(index, item){
			if (item.maHS2() != '-1' || item.khoiLuong() != '' || item.klCongSuat() != '') {
				if (item.valid.errors().length != 0) {
					check = false;
					item.valid.errors.showAllMessages(true);
					item.valid2.errors.showAllMessages(true);
					app.Alert(NSWLang["monre_01_error_message_thong_tin_phe_lieu"] + ' ' + ( index + 1));
					return false;
				}
			}
			if ((loaiThuTuc == 3 || loaiThuTuc == 4) && item.donViUyThac2() != '') {
				if (item.valid.errors().length != 0) {
					check = false;
					app.Alert(NSWLang["monre_01_error_message_thong_tin_phe_lieu"] + ' ' + ( index + 1));
					item.valid.errors.showAllMessages(true);
					item.valid2.errors.showAllMessages(true);
					return false;
				}
			}
		});
		if (!check) return false;
		$(self.dsPheLieu()).each(function(index, item){
			item.klCongSuatInput(item.klCongSuat());
			item.khoiLuong6Input(item.khoiLuong6());
			item.khoiLuongInput(item.khoiLuong());
			item.donViUyThac(item.donViUyThac2());
		});
		return true;
	}

		
}
