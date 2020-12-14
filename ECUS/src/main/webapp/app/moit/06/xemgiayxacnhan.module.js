function GiayXacNhanView() {
	var self = this;
	self.show = function(item) {
		app.makePost({
            url: '/moit/api/06/layThongTinGP/' + item.idHoSo(),
            data: JSON.stringify({}),
            success: function (d) {
                var fun = 'success';
                if (d.success) {
                	if(d.data.ngayKy != null){
                		date = d.data.ngayKy.split('/');
                		d.data.ngayKy_Ngay = date[0];
                		d.data.ngayKy_Thang = date[1];
                		d.data.ngayKy_Nam = date[2];
                	}
                	if(d.data.ngayNop != null){
                		date = d.data.ngayNop.split('/');
                		d.data.ngayNop_Ngay = date[0];
                		d.data.ngayNop_Thang = date[1];
                		d.data.ngayNop_Nam = date[2];
                	}
                	if(d.data.ngayHetHan != null){
                		date = d.data.ngayHetHan.split('/');
                		d.data.ngayHetHan_Ngay = date[0];
                		d.data.ngayHetHan_Thang = date[1];
                		d.data.ngayHetHan_Nam = date[2];
                	}
                	if(d.data.hangHoas != null){
                		for(i=0; i< d.data.hangHoas.length; i++){
                			var trangThai = d.data.hangHoas[i].trangThai;
                			if(trangThai == 1){
                				var LoaiHangHoa = "Rắn";
	                			d.data.hangHoas[i].trangThai = LoaiHangHoa;
	                		}
	                		if(trangThai == 2){
	                			var LoaiHangHoa = "Lỏng";
	                			d.data.hangHoas[i].trangThai = LoaiHangHoa;
	                		}
	                		if(trangThai == 3){
	                			var LoaiHangHoa = "Khí";
	                			d.data.hangHoas[i].trangThai = LoaiHangHoa;
	                		}
                		}
                	}
                	var callback = function (html) {
                        var pop = app.popup({
                            title: NSWLang["moit_06_popup_xemgxn"] + ' - ' + item.maHoSo(),
                            html: html,
                            width: 960,
                            buttons: [
                                {
                                    name: NSWLang["common_button_dong"],
                                    class: 'btn',
                                    icon: 'fa-remove',
                                    action: function () {
                                   	 app.popupRemove(pop.selector);
                                    }
                                }
                            ]
                        });
                    };
            		 if(d.data.loaiGiayPhep == 2){
                            app.complieTemplate({
            	            ministryCode: "moit",
            	            code: "06",
            	            templateName: "xem_giay_xac_nhan_nhapkhau",
            	            data: d.data
            	        }, callback);
            	      }else if(d.data.loaiGiayPhep == 1){
                             app.complieTemplate({
            	            ministryCode: "moit",
            	            code: "06",
            	            templateName: "xem_giay_xac_nhan_xuatkhau",
            	            data: d.data
            	        }, callback);
            	      }else{
                         app.complieTemplate({
            	            ministryCode: "moit",
            	            code: "06",
            	            templateName: "xem_giay_xac_nhan",
            	            data: d.data
            	        }, callback);
            	      }

                } else {
                    fun = 'error';
                }
                app.toast({
                    title: NSWLang["common_msg_thong_bao"],
                    message: d.message,
                    function: fun
                });
              
            },
            error: function (e) {
            	toastr.error(e.message, NSWLang["common_msg_thong_bao"]);
            }
        });
	}
}