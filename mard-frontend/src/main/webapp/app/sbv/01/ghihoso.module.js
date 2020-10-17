
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
     
    function GhiHoSoViewModel(v1, v2) {
    	
    	var self = this;
    	self.idHoSo = idHoSo;
    	self.getHoSo = function(idHoSo) {
    		app.makePost({
				url :'/sbv/api/01/suaHoSo/' + self.idHoSo,
				data : JSON.stringify({}),
				success : function(d) {
					if (d.success) {
						if ($.isEmptyObject(container1VM)) {
					        container1VM = new ThongTinNgoaiTeViewModel(d.data);
					        ko.applyBindings(container1VM, document.getElementById("ThongTinNgoaiTeViewModel"));
					        v1 = container1VM;
					    }
					    
					   
					    if ($.isEmptyObject(container2VM)) {
					        container2VM = new ThongTinTepDinhKemViewModel(d.data);
					        ko.applyBindings(container2VM, document.getElementById("ThongTinTepDinhKemViewModel"));
					        v2 = container2VM;
					        v1.thongTinNgoaiTeModel.capGiayPhepLanDau.subscribe(function(value){
					        	
					        	if (value == 'true') {
					        		v2.capGiayPhepLanDau(true);
					        	} else {
					        		v2.capGiayPhepLanDau(false);
					        	}
					        });
					    }
					} 
				},
				error : function(e) {
					 toastr.error(e.message, NSWLang["common_msg_thong_bao"]);
				}
			});
    	}
    	
    	self.getHoSo();
    	self.validForm = function(isGuiHoSo, action) {
    		
    		if (v1.isValid(isGuiHoSo) == false) {
    			return false;
			}
    		
    		if (v1.thongTinNgoaiTeModel.capGiayPhepLanDau() == 'true' && v2.isValid(isGuiHoSo) == false) {
    			return false;
			}
    	
    		if (v1.thongTinNgoaiTeModel.soGiayPhepDaCap() != null && v1.thongTinNgoaiTeModel.soGiayPhepDaCap() != '') {
    			v1.timKiemGiayXacNhan(function(){
    				action();
    			});
    		} else {
    			action();
    		}
    		
    	}
    	
    	self.ghiLai = function(){
    		
    		self.validForm(false, function(){
    			self.save(false);
    		});
    		
    	}
    	self.guiHoSo = function(){
    	
    		self.validForm(true, function(){
    			self.save(true);
    		});
    		
    	}
    	self.save = function(isGuiHoSo) {
    		var v1Data = v1.getHoSo();
    		var data = {};
    		data.guiHoSo = isGuiHoSo;
    		var kySo = requiredSign;
    		if (isGuiHoSo && kySo) {
    			 CAPlugin.initPlugin();
    		     var cert = CAPlugin.getCert();
    		     if (cert == 'E04') {
    		    		app.Alert( NSWLang["sbv_01_token_error"]);
    		    		return false;
    		     }
    			data.serialNumber = cert;
    		}
    		if (isGuiHoSo && kySo && (data.serialNumber == null  || data.serialNumber.trim() == '')) {
				return;
			}
    		data.idHoSo = v1Data.idHoSo;
    		data.maChiNhanh = v1Data.maChiNhanh;
    		data.hinhThucXNK = v1Data.hinhThucXNK;
    		data.maCuaKhau = v1Data.maCuaKhau;
    		data.xuatNhapKhauTuNgayDateFormat = v1Data.xuatNhapKhauTuNgayDateFormat;
    		data.xuatNhapKhauDenNgayDateFormat = v1Data.xuatNhapKhauDenNgayDateFormat;
    		data.capGiayPhepLanDau = v1Data.capGiayPhepLanDau;
    		data.soGiayPhepDaCap = v1Data.soGiayPhepDaCap;
    		data.doiTacXuatNhapKhau = v1Data.doiTacXuatNhapKhau;
    		data.tienTeJsonString = v1Data.tienTeJsonString;
    		data.tepDinhKems = v2.getTepDinhKems();
    		data.ghiChu = v1Data.ghiChu;
    		
			app.makePost({
				url : "/sbv/api/01/save",
				data : JSON.stringify(data),
				success : function(d) {
					var href = app.appContext + "/sbv/01/home";
					if (!isGuiHoSo || !d.success) {
						if (d.data != null && d.data.idHoSo != null && d.data.idHoSo != 0) {
							href = app.appContext + "/sbv/01/edit/" + (d.data.idHoSo);
						} else {
							href = app.appContext + "/sbv/01/edit";
						}
					} 
					if (d.success) {
						if (isGuiHoSo) {
							 var post = {
                              		xmlContent: '',
                              		xmlEnvelop: d.data.xmlEnvelop,
                              		idHoSo: d.data.idHoSo,
                              		serialNumber: null,
                              		requiredSign: kySo
                              }
							if (kySo) {
								 var sign = CAPlugin.signXml(d.data.xmlContent, d.data.serialNumber);
								 post.xmlContent = sign;
								 self.send(post);
							} else {
								setTimeout(function(){
		                        	location.href = href;
		                        }, 2000);
								 self.thongBaoGuiHoSo(href, d.message, true);
							}
							 
						} else {
							location.href = href;
						}
					} 
					
				},
				error : function(e) {
					 var msg = e.message;
		             if (msg == null) msg = NSWLang["sbv_01_totalSizeUploadErrorDefault"];
					toastr.error(msg, NSWLang["common_msg_thong_bao"]);
				}
			});
    	}
    	
    	
    	self.send = function(postData) {
    		app.makePost({
                url: '/sbv/api/01/guiHS',
                data: JSON.stringify(postData),
                success: function (d) {
                    var msg = '';
                    var fun = 'success';
                    if (d.success) {
                        msg = d.message;
                        var href = app.appContext + "/sbv/01/home";
                        self.thongBaoGuiHoSo(href, d.message, true);
                        setTimeout(function(){
                        	location.href = href;
                        }, 2000);
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
                    var msg = e.message;
                    if (msg == null) msg = NSWLang["sbv_01_totalSizeUploadErrorDefault"];
                    toastr.error(msg, NSWLang["common_msg_thong_bao"]);
                    var href = app.appContext + "/sbv/01/edit/" + postData.idHoSo;
                    self.thongBaoGuiHoSo(href, msg, false);
                    setTimeout(function(){
                    	location.href = href;
                    }, 2000);
                }
            });
    	}
    	
    	
    	self.thongBaoGuiHoSo = function(href, message, success) {
    		var clz = 'alert alert-success toast-success';
    		var style = 'color: #fff;';
    		if (!success) {
    			style = 'color: #000;';
    			clz = 'alert alert-danger';
    		}
			  var pop = app.popup({
	                title: NSWLang["common_msg_thong_bao"],
	                html: '<div class="'+ clz +'" style="'+ style +'"><i class="fa fa-check" aria-hidden="true"></i> ' + NSWLang["common_msg_thong_bao"] + ' <b>'+ message +'</b></div>',
	                width: 400,
	                buttons: [
	                    {
	                        name: NSWLang["common_button_dong"],
	                        class: 'btn',
	                        icon: 'fa-remove',
	                        action: function () {
	                        	location.href = href;
	                        }
	                    }
	                ]
	            }, function(){
	            	$('button[class="close"]').click(function(){
	            		location.href = href;
	            	});
	            });
		}
    	
    }
    
    ghiHoSoViewModel = new GhiHoSoViewModel(container1VM, container2VM);

    ko.validation.locale("vi");

    ko.applyBindings(ghiHoSoViewModel, document.getElementById("GhiHoSoViewModel"));
    
});
