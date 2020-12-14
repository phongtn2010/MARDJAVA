
var container1VM;
var container2VM;
var container3VM;
var container4VM;
var container5VM;
var ghiHoSoViewModel;


$(document).ready(function() {
	
	
	 $(".select2").select2({placeholder: '',  width: '100%'});
	 $('.tooltips').tooltip();
     $('.date-picker').datepicker({rtl: false, orientation: "left", autoclose: true });
     $( ".date-picker" ).datepicker({
    	  altFormat: "dd/mm/yy"
    	});
     
     $('#maChiNhanh').focus();
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
	
    function GhiHoSoViewModel(v1, v2, v3, v4, v5) {
    	var self = this;
    	self.idHoSo = idHoSo;
    	self.xemHoSo = ko.observable(xemHoSo);
    	self.hoSo = null;
    	self.getHoSo = function(idHoSo) {
    		app.makePost({
				url :'/moit/api/06/suaHoSo/' + self.idHoSo,
				data : JSON.stringify({}),
				success : function(d) {
//					console.log(d);
					if (d.success) {
						self.hoSo = d.data;
						if ($.isEmptyObject(container4VM)) {
					        container4VM = new ThongTinTepDinhKemViewModel(d.data);
					        ko.applyBindings(container4VM, document.getElementById("ThongTinTepDinhKemViewModel"));
					        v4 = container4VM;
					    }
						 
						if ($.isEmptyObject(container1VM)) {
					        container1VM = new ThongTinChungViewModel(d.data, container4VM);
					        ko.applyBindings(container1VM, document.getElementById("ThongTinChungViewModel"));
					        v1 = container1VM;
					    }
						if ($.isEmptyObject(container2VM)) {
					        container2VM = new ThongTinHangHoaViewModel(d.data);
					        ko.applyBindings(container2VM, document.getElementById("ThongTinHangHoaViewModel"));
					        v2 = container2VM;
					    }
						 if ($.isEmptyObject(container3VM)) {
						        container3VM = new ChiTietHangHoaViewModel(d.data);
						        ko.applyBindings(container3VM, document.getElementById("ChiTietHangHoaViewModel"));
						        v3 = container3VM;
						    }
					   
					    if ($.isEmptyObject(container5VM)) {
					        container5VM = new XinSuaHoSoViewModel(d.data);
					        ko.applyBindings(container5VM, document.getElementById("XinSuaHoSoViewModel"));
					        v5 = container5VM;
					    }
					} 
				},
				error : function(e) {
					console.log(e);
					app.toast({
						title : NSWLang["common_msg_thong_bao"],
						message : e.message
					});
				}
			});
    	}
    	
    	self.getHoSo();
    	self.validForm = function(isGuiHoSo, action) {
    		
    		if (v1.isValid(isGuiHoSo) == false) {
    			return false;
			}
    		if (v2.isValid(isGuiHoSo) == false) {
    			return false;
			}
    		if (v3.isValid(isGuiHoSo) == false) {
    			return false;
			}
    		if (v4.isValid(isGuiHoSo) == false) {
    			return false;
			}
    		if (isYeuCauSua) {
    			if (v5.isValid(isGuiHoSo) == false) {
        			return false;
    			}
    		}
    		action();
    	}
    	
    	self.ghiLai = function(){
    		self.validForm(false, function(){
    			self.save(false);
    		});
    		
    	}
    	self.guiHoSo = function(){
    	
    		self.validForm(true, function(){
    			self.save(true, function(d){
    				self.send(d);
    			});
    		});
    		
    	}
    	
    	self.save = function(isGuiHoSo, success) {
    		var data = {};
    		data.idHoSo = idHoSo;
    		data.maSoThue = v1.thongTinChungModel.maSoThue();
    		data.tenDoanhNghiep = v1.thongTinChungModel.tenDoanhNghiep();
    		data.diaChiDoanhNghiep = v1.thongTinChungModel.diaChiDoanhNghiep();
    		data.dienThoai = v1.thongTinChungModel.dienThoai();
    		data.fax = v1.thongTinChungModel.fax();
    		data.email = v1.thongTinChungModel.email();
    		data.loaiHinh = v1.thongTinChungModel.loaiHinh();
    		data.soGiayChungNhanDKKD = v1.thongTinChungModel.soGiayChungNhanDKKD();
    		data.ngayCapGiayChungNhan = v1.thongTinChungModel.ngayCapGiayChungNhan();
    		data.diaChiSanXuat = v1.thongTinChungModel.diaChiSanXuat();
    		data.soGiayPhepTCTN = v1.thongTinChungModel.soGiayPhepTCTN();
    		data.ngayCapGiayPhep = v1.thongTinChungModel.ngayCapGiayPhep();
    		data.maTinhTP = v1.thongTinChungModel.maTinhTP();
    		data.noiCapGiayChungNhanDKKD = v1.thongTinChungModel.noiCapGiayChungNhanDKKD();
    		data.tenNguoiDaiDien = v1.thongTinChungModel.tenNguoiDaiDien();
    		data.daiDienChucVu = v1.thongTinChungModel.daiDienChucVu();
    		data.daiDienNamSinh = v1.thongTinChungModel.daiDienNamSinh();
    		data.daiDienGioiTinh = v1.thongTinChungModel.daiDienGioiTinh();
    		data.daiDienDiaChi = v1.thongTinChungModel.daiDienDiaChi();
    		
    		data.ngayCapGiayPhepTCTN = v1.thongTinChungModel.ngayCapGiayPhepTCTN();
    		data.loaiGiayPhep = v1.thongTinChungModel.loaiGiayPhep();
    		data.cuaKhaus = v2.getCuaKhauToJson();
    		data.phuongTiens = v2.getPhuongTienToJson();
    		data.mucDich = v2.thongTinHangHoaModel.mucDich();
    		data.hangHoas = v3.getHangHoas();
    		data.tepDinhKems = v4.getTepDinhKems();
    		data.lyDoSua = v5.xinSuaHoSoModel.lyDoSua();
    		data.isChinhSua = isYeuCauSua;
    		data.xemHoSo = xemHoSo;
    		data.guiHoSo = isGuiHoSo;
    		
    		
    		if (isGuiHoSo && requiredSign) {
    			 CAPlugin.initPlugin();
    		     var cert = CAPlugin.getCert();
    		     if (cert == 'E04') {
    		    		app.Alert( NSWLang["moit_06_token_error"]);
    		    		return false;
    		     }
    			data.serialNumber = cert;
    		}
    		if (isGuiHoSo && requiredSign && (data.serialNumber == null  || data.serialNumber.trim() == '')) {
    			console.log('Error: Chay lay duoc chung so!');
				return;
			}
//    		console.log(data);
			app.makePost({
				url : "/moit/api/06/save",
				data : JSON.stringify(data),
				success : function(d) {
					if (d.success) {
						 if (!isGuiHoSo) {
							 app.toast({
			                        title: NSWLang["common_msg_thong_bao"],
			                        message: d.message,
			                    });
							 if (d.data.isChinhSua) {
								 location.href = app.appContext + "/moit/06/edit/" + idHoSoGoc + "/ycs";
							 } else {
								 if (idHoSoGoc == 0) {
									 idHoSoGoc = d.data.idHoSo;
								 }
								 location.href = app.appContext + "/moit/06/edit/" + idHoSoGoc;
							 }
							 
						 } else {
							 if (requiredSign) {
								 var sign = CAPlugin.signXml(d.data.xmlEnvelop, d.data.serialNumber);
								 console.log(sign);
								 d.data.xmlEnvelop = sign;
							}
							 console.log(d);
							 success(d);
						 }
						
					} 
					
				},
				error : function(e) {
					console.log(e);
					toastr.error(e.message, NSWLang["common_msg_thong_bao"]);
				}
			});
    	}
    	
    	
    	
    	self.send = function(d) {
    		console.log(d);
    		 var href = app.appContext + "/moit/06/home";
    		app.makePost({
                url: '/moit/api/06/guiHS',
                data: JSON.stringify(d.data),
                success: function (responseData) {
                    if (responseData.success) {
                    	
                    	 app.toast({
                             title: NSWLang["common_msg_thong_bao"],
                             message:  NSWLang["moit_06_action_status_gui_ho_so_success"],
                         });
                        self.thongBaoGuiHoSo(href,  NSWLang["moit_06_action_status_gui_ho_so_success"], true);
                        setTimeout(function(){
                        	location.href = href;
                        }, 1000);
                    }
                },
                error: function (e) {
                    console.log(e);
                    var msg = e.message;
                    if (msg == undefined) msg = NSWLang["moit_06_action_status_gui_ho_so_error"];
                    toastr.error(msg, NSWLang["common_msg_thong_bao"]);
                    self.thongBaoGuiHoSo(href, msg, false);
                    setTimeout(function(){
                    	location.href = app.appContext + "/moit/06/edit/" + idHoSoGoc;
                    }, 1000);
                }
            });
    	}
    	
    	
    	self.thongBaoGuiHoSo = function(href, message, success) {
    		var cls = 'class="alert alert-success toast-success" style="color: #fff;"';
    		var icon = 'fa fa-check';
    		if (!success) {
    			cls = 'class="alert alert-danger" style="color: #000;background: red;"';
    			icon = 'fa fa-send-o';
    		}
			  var pop = app.popup({
	                title: NSWLang["common_msg_thong_bao"],
	                html: '<div '+ cls +' ><i class="'+ icon +'" aria-hidden="true"></i> ' + NSWLang["common_msg_thong_bao"] + ' <b>'+ message +'</b></div>',
	                width: 400,
	                buttons: [
	                    {
	                        name: NSWLang["common_button_dong"],
	                        class: 'btn',
	                        icon: 'fa-remove',
	                        action: function () {
	                        	if (success) {
	                        		location.href = href;
	                        	} else {
	                        		location.reload();
	                        	}
	                        	
	                        }
	                    }
	                ]
	            }, function(){
	            	$('button[class="close"]').click(function(){
	            		if (!success) {
	            			location.reload();
                    	}
	            	});
	            });
		}
    	
    }
    
    ghiHoSoViewModel = new GhiHoSoViewModel(container1VM, container2VM, container3VM,  container4VM, container5VM);
    
    ko.applyBindings(ghiHoSoViewModel, document.getElementById("GhiHoSoViewModel"));
    
});

