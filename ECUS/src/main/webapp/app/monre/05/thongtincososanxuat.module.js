
function ThongTinCoSoSanXuatViewModel() {
	
	var self = this;
	self.contextPath = ko.observable($('#uriContextPath').val());
	self.dsTatCaCoSoSX = ko.observableArray();
	self.dsTatCaTinhThanhPho = ko.observableArray();
	self.dsTatCaQuanHuyen = ko.observableArray();
	self.dsTatCaXaPhuong = ko.observableArray();
	self.dsCoSoSXDangChon = ko.observableArray();
	self.coSoSX = new CoSoSXModel();
	self.dsCoSoSXTheoHS = ko.observableArray();
	self.pages = ko.observableArray();
	self.maHuyen = ko.computed(function() {

		return self.coSoSX.maHuyen();

	}, this);

	self.tenHuyen = ko.computed(function() {

		return self.coSoSX.tenHuyen();

	}, this);

	self.maXaPhuong = ko.computed(function() {

		return self.coSoSX.maXaPhuong();

	}, this);

	self.tenXaPhuong = ko.computed(function() {

		return self.coSoSX.tenXaPhuong();

	}, this);
	
	self.xemThongTinCoSoSanXuatClick = function() {
		self.dsTatCaXaPhuong.removeAll();
		self.coSoSX.valid.errors.showAllMessages(false);
		$("#xemThongTinCoSoSanXuat").modal({
			show : true
		});
		$('#xemThongTinCoSoSanXuat').css('width', '70%');
		$('#xemThongTinCoSoSanXuat').css('margin', 'auto');
		$('#xemThongTinCoSoSanXuat').css('top', '1%');
		$('#xemThongTinCoSoSanXuat').css('left', '0');
		$('#xemThongTinCoSoSanXuat').css('right', '0');
		self.loadDsTinhThanhPho();
		self.loadDsXaPhuong('-1', '-1');
		self.layDanhSachCoSoSX(1);
	}
	self.chonTinhThanhPhoChangeEvent = function(item) {
		self.coSoSX.tenTinh($('#maTinh :selected').text());
		self.loadDsQuanHuyen(self.coSoSX.maTinh(), '-1');
		self.loadDsXaPhuong('-1', '-1');
	}

	self.chonQuanHuyenChangeEvent = function() {
		self.coSoSX.tenHuyen($('#maHuyen :selected').text());
		self.coSoSX.maHuyen($('#maHuyen :selected').val());
		self.dsTatCaXaPhuong.removeAll();
		self.loadDsXaPhuong(self.coSoSX.maHuyen(), '-1');
		if (self.coSoSX.maHuyen() == '-1') self.coSoSX.tenHuyen('');
	}

	self.chonXaPhuongChangeEvent = function() {
		self.coSoSX.tenXaPhuong($('#maXaPhuong :selected').text());
		self.coSoSX.maXaPhuong($('#maXaPhuong :selected').val());
		if (self.coSoSX.maXaPhuong() == '-1') self.coSoSX.tenXaPhuong('');
	}
	
	self.copyItem = function(item) {
		var pl = new CoSoSXModel();
		pl.tbdThongTinCoSoSXId(item.tbdThongTinCoSoSXId);
		pl.idCS(item.idCS);
		pl.idHS(0);
		pl.soThuTu(item.soThuTu);
		pl.soThuTu2(item.soThuTu2);
		pl.index(item.index);
		pl.tenCoSo(item.tenCoSo);
		pl.diaChiCoSo(item.diaChiCoSo);
		pl.maTinh(item.maTinh);
		pl.maHuyen(item.maHuyen);
		pl.maXaPhuong(item.maXaPhuong);
		pl.tenTinh(item.tenTinh);
		pl.tenHuyen(item.tenHuyen);
		pl.tenXaPhuong(item.tenXaPhuong);
		pl.fax(item.fax);
		pl.email(item.email);
		pl.soDienThoai(item.soDienThoai);
		pl.canUpdate(item.canUpdate);
		pl.canDelete(item.canDelete);
		
		return pl;
	}
	self.layDanhSachCoSoSXTheoHoSo = function() {
		var idHSInput = $('#idHS').val();
		if (idHSInput == undefined || idHSInput == '') idHSInput = '0';
		var idHS = parseInt(idHSInput);
		var urlTTP = self.contextPath() + '/danhSachCssxTheoHS/' + idHS;
		var data = {
		}
		app.makePost({
            url: urlTTP,
            data: JSON.stringify(data),
            success: function (d) {
            	if (d.success && d.data != null && d.data.length > 0) {
                  	self.dsCoSoSXDangChon.removeAll();
                  	self.dsCoSoSXTheoHS.removeAll();
            		d.data.forEach(function (item, index) {
            			item.index = index;
            			item.soThuTu = index + 1;
            			item.soThuTu2 = index + 1;
            			var pl = self.copyItem(item);
						self.dsCoSoSXDangChon.push(pl);
						self.dsCoSoSXTheoHS.push(pl);
            	       });
            	}
            }
        });

	}
	

	self.layDanhSachCoSoSXTheoHoSo();
	
	self.layDanhSachCoSoSX = function(pageIndex) {
		 self.lamMoiCoSoSX();
		var idHSInput = $('#idHS').val();
		if (idHSInput == undefined || idHSInput == '') idHSInput = '0';
		var idHS = parseInt(idHSInput);
		var urlTTP = self.contextPath() + '/danhSachCoSoSX';
		var data = {
				pageIndex: pageIndex,
				idHS: idHS
		}
		self.dsTatCaCoSoSX.removeAll();
		app.makePost({
            url: urlTTP,
            data: JSON.stringify(data),
            success: function (d) {
            	if (d.success) {
            		self.pages.removeAll();
                  	if (d.data != null && d.data.length > 0) {
                  		
                  		$(d.data[0].pages).each(function(index, item){
                  			self.pages.push(item);
                  		});
                  	}
            		d.data.forEach(function (item, index) {
            			item.index = index;
            			var pl = self.copyItem(item);
						$(self.dsCoSoSXDangChon()).each(function(pIndex, pItem){
							if (item.idCS == pItem.idCS()) {
								pl.checked(true);
								pl.tbdThongTinCoSoSXId(pItem.tbdThongTinCoSoSXId());
							}
						});
						self.dsTatCaCoSoSX.push(pl);
            	       });
            	}
            }
        });
	}
	
	self.loadDsTinhThanhPho = function() {
		var urlTTP = self.contextPath() + '/danhSachTTP';
		app.makePost({
            url: urlTTP,
            data: JSON.stringify({}),
            success: function (d) {
            	if (d.success) {
            		self.dsTatCaTinhThanhPho.removeAll();
            		d.data.forEach(function (item) {
            			 self.dsTatCaTinhThanhPho.push(item);
            	       });
            	}
            }
        });
	}

	self.loadDsQuanHuyen = function(maTinh, maHuyen) {
		var urlTTP = self.contextPath() + '/danhSachQH/' + maTinh;
		app.makePost({
            url: urlTTP,
            data: JSON.stringify({}),
            success: function (d) {
            	if (d.success) {
            		self.dsTatCaQuanHuyen.removeAll();
            		d.data.forEach(function (item) {
            			 self.dsTatCaQuanHuyen.push(item);
            	       });
            		self.coSoSX.maHuyen(maHuyen);
            	}
            }
        });
	}

	self.loadDsXaPhuong = function(maHuyen, maXaPhuong) {
		var urlTTP = self.contextPath() + '/danhSachXP/' + maHuyen;
		app.makePost({
            url: urlTTP,
            data: JSON.stringify({}),
            success: function (d) {
            	self.dsTatCaXaPhuong.removeAll();
            	if (d.success) {
            		d.data.forEach(function (item) {
            			 self.dsTatCaXaPhuong.push(item);
            	       });
            		self.coSoSX.maXaPhuong(maXaPhuong);
            	}
            }
        });
	}
	
	self.luuThongThongTinCoSoSX = function(){
		if (self.coSoSX.maTinh() === '-1') {
			self.coSoSX.tenTinh('');
		}
		if (self.coSoSX.maHuyen() === '-1') {
			self.coSoSX.tenHuyen('');
		}
		if (self.coSoSX.maXaPhuong() === '-1') {
			self.coSoSX.tenXaPhuong('');
		}
		if (self.coSoSX.valid.errors().length != 0) {
			self.coSoSX.valid.errors.showAllMessages();
			return;
		}
		var postData = {
			tbdThongTinCoSoSXId : self.coSoSX.tbdThongTinCoSoSXId(),
			tenCoSo : self.coSoSX.tenCoSo(),
			diaChiCoSo : self.coSoSX.diaChiCoSo(),
			email : self.coSoSX.email(),
			fax : self.coSoSX.fax(),
			idCS : self.coSoSX.idCS(),
			idHS : self.coSoSX.idHS(),
			maHuyen : self.coSoSX.maHuyen(),
			maTinh : self.coSoSX.maTinh(),
			maXaPhuong : self.coSoSX.maXaPhuong(),
			soDienThoai : self.coSoSX.soDienThoai(),
			tenHuyen : self.coSoSX.tenHuyen(),
			tenTinh : self.coSoSX.tenTinh(),
			tenXaPhuong : self.coSoSX.tenXaPhuong(),
			canUpdate: self.coSoSX.canUpdate()
		};
		
		 app.makePost({
             url: self.contextPath() + '/capNhapDanhMucCSSX',
             data: JSON.stringify(postData),
             success: function (d) {
                 var msg = '';
                 var fun = 'success';
                 if (d.success) {
                     msg = NSWLang["common_msg_cap_nhat_du_lieu_thanh_cong"];
                     self.lamMoiCoSoSX();
                     self.layDanhSachCoSoSX(1);
                     var pItem = d.data;
                     $(self.dsCoSoSXTheoHS()).each(function(index, item) {
             			if (item.idCS() == pItem.idCS) {
             				item.tenCoSo(pItem.tenCoSo);
             				item.diaChiCoSo(pItem.diaChiCoSo);
             			}
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
                 app.toast({
                     title: NSWLang["common_msg_thong_bao"],
                     message: e.message
                 });
             }
         });
	}
	self.closeThongTinCoSoSanXuatClick = function() {

		self.dsCoSoSXDangChon.removeAll();
		$(self.dsCoSoSXTheoHS()).each(function(index, item) {
			self.dsCoSoSXDangChon.push(item);
		});
		 self.lamMoiCoSoSX();
		$("#xemThongTinCoSoSanXuat").modal('hide');
	}
	
	self.chinhSuaDanhMucCoSoSX = function(item){
		self.coSoSX.tenCoSo(item.tenCoSo());
		self.coSoSX.diaChiCoSo(item.tenCoSo());
		self.coSoSX.email(item.email());
		self.coSoSX.fax(item.fax());
		self.coSoSX.idCS(item.idCS());
		self.coSoSX.idHS('');
		self.coSoSX.soDienThoai(item.soDienThoai());
		self.coSoSX.maTinh(item.maTinh());
		self.coSoSX.tenTinh(item.tenTinh());
		self.coSoSX.maHuyen(item.maHuyen());
		self.coSoSX.tenHuyen(item.tenHuyen());
		self.coSoSX.maXaPhuong(item.maXaPhuong());
		self.coSoSX.tenXaPhuong(item.tenXaPhuong());
		self.dsTatCaQuanHuyen.removeAll();
		self.dsTatCaXaPhuong.removeAll();
		self.loadDsQuanHuyen(item.maTinh(), item.maHuyen());
		self.loadDsXaPhuong(item.maHuyen(), item.maXaPhuong());
		$('#select2-maTinh-container').text(self.coSoSX.tenTinh());
		$('#select2-maTinh-container').attr('title', self.coSoSX.tenTinh());
	
	}
	
	self.xoaDanhMucCoSoSX = function(item){
		var idHSInput = $('#idHS').val();
		if (idHSInput == undefined || idHSInput == '') idHSInput = '0';
		var idHS = parseInt(idHSInput);
		var postData = {
				
				tbdThongTinCoSoSXId: item.tbdThongTinCoSoSXId(),
				idHS: idHS,
				idCS: item.idCS()
		};
		var pop = app.popup({
            title: NSWLang["common_msg_thong_bao"],
            html: '<i class="fa fa-3x fa-warning"></i> ' + NSWLang["common_msg_xoa_ho_so"] + ' <b>'+ item.tenCoSo() +'</b>',
            width: 400,
            buttons: [
                {
                    name: NSWLang["common_button_toi_chac_chan"],
                    class: 'btn',
                    icon: 'fa-check',
                    action: function () {
                        app.makePost({
                            url: self.contextPath() + '/xoaCSSX/' + item.idCS(),
                            data: JSON.stringify(postData),
                            success: function (d) {
                                var msg = '';
                                var fun = 'success';
                                if (d.success) {
                                    msg = NSWLang["common_msg_cap_nhat_du_lieu_thanh_cong"];
                                    app.popupRemove(pop.selector);
                                    self.layDanhSachCoSoSX(1);
                                    self.copyDsCoSoSX(item);
                                    self.lamMoiCoSoSX();
                                } else {
                                    fun = 'error';
                                    app.popupRemove(pop.selector);
                                    msg = NSWLang["common_msg_cap_nhat_du_lieu_thanh_cong"];
                                }
                                app.toast({
                                    title: NSWLang["common_msg_thong_bao"],
                                    message: msg,
                                    function: fun
                                });
                            },
                            error: function (e) {
                                app.popupRemove(pop.selector);
                                app.toast({
                                    title: NSWLang["common_msg_thong_bao"],
                                    message: e.message
                                });
                            }
                        });
                    }
                }
            ]
        });
	}
	
	self.xoaCoSoSXTheoHS = function(item){
		if (item.tbdThongTinCoSoSXId() > 0) {
			
			var url = self.contextPath() + '/xoaCSSXTheoHS/' + item.tbdThongTinCoSoSXId();
			var pop = app.popup({
	            title: NSWLang["common_msg_thong_bao"],
	            html: '<i class="fa fa-3x fa-warning"></i> ' + NSWLang["common_msg_xoa_ho_so"] + ' <b>'+ item.tenCoSo() +'</b>',
	            width: 400,
	            buttons: [
	                {
	                    name: NSWLang["common_button_toi_chac_chan"],
	                    class: 'btn',
	                    icon: 'fa-check',
	                    action: function () {
	                        app.makePost({
	                            url: url,
	                            data: JSON.stringify({}),
	                            success: function (d) {
	                                var msg = '';
	                                var fun = 'success';
	                                if (d.success) {
	                                    msg = NSWLang["common_msg_cap_nhat_du_lieu_thanh_cong"];
	                                    app.popupRemove(pop.selector);
	                                    self.copyDsCoSoSX(item);
	                                } else {
	                                    fun = 'error';
	                                    app.popupRemove(pop.selector);
	                                    msg = NSWLang["common_msg_cap_nhat_du_lieu_thanh_cong"];
	                                }
	                                app.toast({
	                                    title: NSWLang["common_msg_thong_bao"],
	                                    message: msg,
	                                    function: fun
	                                });
	                            },
	                            error: function (e) {
	                                app.popupRemove(pop.selector);
	                                app.toast({
	                                    title: NSWLang["common_msg_thong_bao"],
	                                    message: e.message
	                                });
	                            }
	                        });
	                    }
	                }
	            ]
	        });
		}else {
			 self.copyDsCoSoSX(item);
		}
		
	}
	
	self.lamMoiCoSoSX = function() {
		
		self.coSoSX.tenCoSo('');
		self.coSoSX.diaChiCoSo('');
		self.coSoSX.email('');
		self.coSoSX.fax('');
		self.coSoSX.idCS(0);
		self.coSoSX.idHS('');
		self.coSoSX.soDienThoai('');
		self.coSoSX.tenCoSo('');
		self.coSoSX.maTinh('-1');
		self.coSoSX.tenTinh('');
		self.coSoSX.maHuyen('-1');
		self.coSoSX.tenHuyen('');
		self.coSoSX.maXaPhuong('-1');
		self.coSoSX.tenXaPhuong('');
		self.loadDsQuanHuyen('-1', '-1');
		self.loadDsXaPhuong('-1', '-1');
		self.coSoSX.valid.errors.showAllMessages(false);
		$('#select2-maTinh-container').text($($('#maTinh option')[0]).text());
		$('#select2-maTinh-container').attr($($('#maTinh option')[0]).text());
	}
	
	self.selectIndex = function(eleId, text) {
		$('#' + eleId).text(text);
		$('#' + eleId).attr('title', text);
	}
	
	self.checkboxClick = function(pItem) {
		var exists = false;
		self.dsCoSoSXDangChon().forEach(function(item, index){
			if (pItem.idCS() === item.idCS()) exists = true;
			if (pItem.checked() === false && pItem.idCS() === item.idCS()) self.dsCoSoSXDangChon.remove(item);
		}) ;
		if (exists === false && pItem.checked()) {
			pItem.soThuTu2(self.dsCoSoSXDangChon().length + 1);
			pItem.index(self.dsCoSoSXDangChon().length);
			self.dsCoSoSXDangChon.push(pItem);
		}
	}
	
	self.chonCoSoSXClick = function() {
		self.copyDsCoSoSX(null);
		self.closeThongTinCoSoSanXuatClick();
	}
	
	self.copyDsCoSoSX = function(pItem) {
		self.dsCoSoSXTheoHS.removeAll();
		self.dsCoSoSXDangChon().forEach(function(item, index){
			if (pItem != null && item.idCS() == pItem.idCS()) {
				self.dsCoSoSXDangChon.remove(item);
			} 
		});
		self.dsCoSoSXDangChon().forEach(function(item, index){
			item.index(index);
			item.soThuTu2(index + 1);
			self.dsCoSoSXTheoHS.push(item);
		});
	}
	
	
}


