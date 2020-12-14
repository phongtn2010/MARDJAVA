	
	function AppViewModel(hoSo) {
		var self = this;
		self.contextPath = ko.observable(uriContextPath);
		self.dsCoSoSXTheoHS = ko.observableArray();
		self.pageOne = {};
		self.appPopup = null;
		
		self.layDanhSachCoSoSX = function(onSuccess) {
			var idHS = idHoSo;
			var urlTTP = self.contextPath() + '/danhSachCoSoSX';
			var data = {
					pageIndex: 1,
					idHS: idHS
			}
			app.makePost({
	            url: urlTTP,
	            data: JSON.stringify(data),
	            success: function (d) {
	            	if (d.success) {
	            		onSuccess(d);
	            	}
	            }
	        });
		}
		
		self.clickToShowPopup = function() {
			self.layDanhSachCoSoSX(function(d){
				self.pageOne = d;
				 var callback = function (html) {
					 var pop = app.popup({
		                 title: NSWLang["monre_01_danh_muc_co_sx"],
		                 html: html,
		                 width: 960,
		                 buttons: [
		                 ]
		             }, function(){
		            	 	appViewDanhMucCSSXModel = new AppViewDanhMucCSSXModel(self);
			           		ko.applyBindings(appViewDanhMucCSSXModel, document.getElementById("danhMucCoSoSXFormTemplate22222222222222"));
			           		appViewDanhMucCSSXModel.load();
		             });
					 
					 self.appPopup = pop;
				 }
			
				 app.complieTemplate({
		            ministryCode: "monre",
		            code: "01",
		            templateName: "danh_muc_so_so_san_xuat",
		            data: null
		        }, callback);
			});
			
		}
		
		self.closePopup = function() {
			app.popupRemove(self.appPopup.selector);
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
			hoSo.coSoSanXuatList.forEach(function (item, index) {
				item.index = index;
				item.soThuTu = index + 1;
				item.soThuTu2 = index + 1;
				var pl = self.copyItem(item);
				self.dsCoSoSXTheoHS.push(pl);
		       });
		}
		

		self.layDanhSachCoSoSXTheoHoSo();
		
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
		                                    self.dsCoSoSXTheoHS.remove(item);
		                                    $(self.dsCoSoSXTheoHS()).each(function(index, item){
		                                    	item.soThuTu2(index + 1);
		                                    	item.soThuTu(index + 1);
		                                    	item.index(index);
		                                    });
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
				self.dsCoSoSXTheoHS.remove(item);
				 $(self.dsCoSoSXTheoHS()).each(function(index, item){
	             	item.soThuTu2(index + 1);
	             	item.soThuTu(index + 1);
	             	item.index(index);
	             });
			}
			
		}
		
		self.valid = function(isGuiHoSo) {
			if (isGuiHoSo) {
				var count = 0;
				for (var i = 0; i < self.dsCoSoSXTheoHS().length; i++) {
					count++;
				}
				if (count == 0) {
					app.Alert(NSWLang["monre_01_gui_ho_so_yeu_cau_thong_tin_co_so_san_xuat"]);
					return false;
				}
			}
			return true;
		}
	}
	
	
	function AppViewDanhMucCSSXModel(model) {
		var self = this;
		
		self.load = function(){
			$(model.dsCoSoSXTheoHS()).each(function(index, item){
				item.checked(true);
				self.dsCoSoSXDangChon.push(item);
			});
			var d = model.pageOne;
			 self.pagingVM.totalCount(d.total);
    		 self.totalData(d.total);
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
			 self.loadDsTinhThanhPho();
		 }
		
		self.changeManufactories = function() {
			$(model.dsCoSoSXTheoHS()).each(function(index, item){
					item.index(index);
					item.soThuTu(index + 1);
			});
		}
			
		
		self.closePopup = function() {
			model.closePopup();
		}
		
		self.contextPath = ko.observable(uriContextPath);
		self.dsTatCaCoSoSX = ko.observableArray();
		self.dsTatCaTinhThanhPho = ko.observableArray();
		self.dsTatCaQuanHuyen = ko.observableArray();
		self.dsTatCaXaPhuong = ko.observableArray();
		self.dsCoSoSXDangChon = ko.observableArray();
		self.coSoSX = new CoSoSXModel();
		self.dsCoSoSXTheoHS = ko.observableArray();
		self.totalData = ko.observable(0);
		self.pagingVM = new PagingVM({pageSize: 5, totalCount: 0});
		self.maHuyenSelect = ko.observable('-1');
		self.maXaPhuongSelect = ko.observable('-1');
		
		self.coSoSX.maTinh.subscribe(function(newValue) {
			var maHuyen = '-1';
			if (self.coSoSX.maHuyen() != undefined && self.coSoSX.maHuyen() != '-1') maHuyen = self.coSoSX.maHuyen();
			self.maHuyenSelect('-1');
			self.maXaPhuongSelect('-1');
			self.loadDsQuanHuyen(self.coSoSX.maTinh(), maHuyen);
			self.loadDsXaPhuong('-1', '-1');
		});
		
	
		self.coSoSX.maHuyen.subscribe(function(newValue) {
			var maXaPhuong = '-1';
			if (self.coSoSX.maXaPhuong() != undefined && self.coSoSX.maXaPhuong() != '-1') maXaPhuong = self.coSoSX.maXaPhuong();
			self.loadDsXaPhuong(self.coSoSX.maHuyen(), maXaPhuong);
		});
		
		
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
		
		self.layDanhSachCoSoSX = function(pageIndex) {
			 self.lamMoiCoSoSX();
			var idHS = idHoSo;
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
	            		 self.pagingVM.totalCount(d.total);
	            		 self.totalData(d.total);
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
	            		
	            		self.coSoSX.maHuyen(self.maHuyenSelect());
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
	            		self.coSoSX.maXaPhuong(self.maXaPhuongSelect());
	            	}
	            }
	        });
		}
		
		self.luuThongThongTinCoSoSX = function(){
			
			if (self.coSoSX.valid.errors().length != 0) {
				self.coSoSX.valid.errors.showAllMessages();
				return;
			}
			
			var postData = {
				tbdThongTinCoSoSXId : self.coSoSX.tbdThongTinCoSoSXId(),
				tenCoSo : $('#tenCoSo').val().trim(),
				diaChiCoSo : $('#diaChiCoSo').val().trim(),
				email : $('#email').val().trim(),
				fax : $('#fax').val(),
				idCS : self.coSoSX.idCS(),
				idHS : idHoSo,
				maHuyen : $('#maHuyen').val().trim(),
				maTinh : $('#maTinh').val().trim(),
				maXaPhuong : $('#maXaPhuong').val().trim(),
				soDienThoai : $('#soDienThoai').val().trim(),
				tenHuyen : $('#maHuyen :selected').text().trim(),
				tenTinh : $('#maTinh :selected').text().trim(),
				tenXaPhuong : $('#maXaPhuong :selected').text().trim()
			};
			
			if (self.checkValid(postData)) {
				 app.makePost({
		             url: self.contextPath() + '/capNhapDanhMucCSSX',
		             data: JSON.stringify(postData),
		             success: function (d) {
		                 var msg = '';
		                 var fun = 'success';
		                 if (d.success) {
		                	 self.pagingVM.currentPage(1);
		                     msg = NSWLang["common_msg_cap_nhat_du_lieu_thanh_cong"];
		                     self.lamMoiCoSoSX();
		                     self.layDanhSachCoSoSX(1);
		                     var pItem = d.data;
		                     $(model.dsCoSoSXTheoHS()).each(function(index, item) {
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
		                 toastr.error(e.message, NSWLang["common_msg_thong_bao"]);
		             }
		         });
			} 
			
			
		}
		
		self.checkValid = function(postData) {
			if (postData.tenCoSo.trim() == "") {
				app.Alert(NSWLang["error_monre_01_TbsThongTinCoSoSX_tencoso_null"]);
				return false;
			}
			if (postData.tenCoSo.trim().length > 250) {
				app.Alert(NSWLang["error_monre_01_TbsThongTinCoSoSX_tencoso_maxlength"]);
				return false;
			}
			if (postData.diaChiCoSo.trim() == "") {
				app.Alert(NSWLang["error_monre_01_TbsThongTinCoSoSX_diaChiCoSo_null"]);
				return false;
			}
			if (postData.diaChiCoSo.trim().length > 250) {
				app.Alert(NSWLang["error_monre_01_TbsThongTinCoSoSX_diaChiCoSo_malength"]);
				return false;
			}
			if (postData.maTinh.trim() == "" || postData.maTinh.trim() == "-1") {
				app.Alert(NSWLang["error_monre_01_TbsThongTinCoSoSX_tenTinh_null"]);
				return false;
			}
			if (postData.maHuyen.trim() == "" || postData.maHuyen.trim() == "-1") {
				app.Alert(NSWLang["error_monre_01_TbsThongTinCoSoSX_tenHuyen_null"]);
				return false;
			}
			if (postData.maXaPhuong.trim() == "" || postData.maXaPhuong.trim() == "-1") {
				app.Alert(NSWLang["error_monre_01_TbsThongTinCoSoSX_tenXaPhuong_null"]);
				return false;
			}
			if (postData.email.trim().length > 50) {
				app.Alert(NSWLang["error_monre_01_TbsThongTinCoSoSX_email_maxlength"]);
				return false;
			}
			if (postData.fax.trim().length > 50) {
				app.Alert(NSWLang["error_monre_01_TbsThongTinCoSoSX_fax_maxlength"]);
				return false;
			}
			if (postData.soDienThoai.trim().length > 50) {
				app.Alert(NSWLang["error_monre_01_TbsThongTinCoSoSX_soDienThoai_maxlength"]);
				return false;
			}
			return true;
		}
		
		self.closeThongTinCoSoSanXuatClick = function() {

			
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
			self.maHuyenSelect(item.maHuyen());
			self.maXaPhuongSelect(item.maXaPhuong());
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
                                         self.lamMoiCoSoSX();
                                         $(model.dsCoSoSXTheoHS()).each(function(index, pitem) {
                                         	if (pitem.idCS() == item.idCS()) model.dsCoSoSXTheoHS.remove(pitem);
                                         });
                                         $(model.dsCoSoSXTheoHS()).each(function(index, pitem) {
                                         	pitem.index(index);
                                         	pitem.soThuTu2(index + 1);
                                         });
                                         self.pagingVM.currentPage(1);
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
                                     toastr.error(e.message, NSWLang["common_msg_thong_bao"]);
                                 }
                             });
                         }
                     }
                 ]
             });
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
		
		self.checkboxClick = function(pItem, event) {
			var exists = false;
			pItem.checked(event.target.checked);
			self.dsCoSoSXDangChon().forEach(function(item, index){
				if (pItem.idCS() == item.idCS()){ 
					exists = true;
					if (pItem.checked() == false) self.dsCoSoSXDangChon.remove(item);
					return false;
				}
			}) ;
			if (exists == false) {
				pItem.soThuTu2(self.dsCoSoSXDangChon().length + 1);
				pItem.index(self.dsCoSoSXDangChon().length);
				self.dsCoSoSXDangChon.push(pItem);
			}
		}
		
		self.chonCoSoSXClick = function(item) {
			model.dsCoSoSXTheoHS.removeAll();
        	$(self.dsCoSoSXDangChon()).each(function(index, item){
            	var pItem = {
            			tbdThongTinCoSoSXId: item.tbdThongTinCoSoSXId(),
            			idCS: item.idCS(),
            			soThuTu: index + 1,
            			soThuTu2: index + 1,
            			index: index,
            			tenCoSo: item.tenCoSo(),
            			diaChiCoSo: item.diaChiCoSo(),
            			maTinh: item.maTinh(),
            			maHuyen: item.maHuyen(),
            			maXaPhuong: item.maXaPhuong(),
            			tenTinh: item.tenTinh(),
            			tenHuyen: item.tenHuyen(),
            			tenXaPhuong: item.tenXaPhuong(),
            			fax: item.fax(),
            			email: item.email(),
            			soDienThoai: item.soDienThoai(),
            			canUpdate: item.canUpdate(),
            			canDelete: item.canDelete(),
            			check: item.checked()
            	};
            	model.dsCoSoSXTheoHS.push(self.copyItem(pItem));
            	
            });
        	self.closePopup();
		}
		
		
		 $(".select5").select2({placeholder: '',  width: '100%'});
		 
		 self.goToPage = function (page) {
		        if (page >= self.pagingVM.firstPage && page <= self.pagingVM.lastPage()) {
		        	 self.pagingVM.setCurrentPage(page);
		        	 self.layDanhSachCoSoSX(self.pagingVM.currentPage());
		        }
		           
		    };
		    
			 self.goToFirst = function () {
			        self.pagingVM.setCurrentPage(self.pagingVM.firstPage);
			        self.layDanhSachCoSoSX(self.pagingVM.currentPage());
			  };
			  
		    self.goToPrevious = function () {
		        var previous = self.pagingVM.previousPage();
		        if (previous != null) {
		        	 self.pagingVM.setCurrentPage(previous);
		        	 self.layDanhSachCoSoSX(self.pagingVM.currentPage());
		        }
		           
		    };

		    self.goToNext = function () {
		        var next = self.pagingVM.nextPage();
		        if (next != null) {
		        	 self.pagingVM.setCurrentPage(next);
		        	 self.layDanhSachCoSoSX(self.pagingVM.currentPage());
		        }
		           
		    };

		    self.goToLast = function () {
		        self.pagingVM.setCurrentPage(self.pagingVM.lastPage());
		        self.layDanhSachCoSoSX(self.pagingVM.currentPage());
		    };

	}


