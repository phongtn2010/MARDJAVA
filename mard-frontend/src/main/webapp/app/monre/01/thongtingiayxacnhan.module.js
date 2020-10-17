function GiayXacNhanViewModel(hoSo) {
	
	var self = this;
	self.xemHoSo = ko.observable(xemHoSo);
	self.giayXacNhanModel = new GiayXacNhanModel();
	self.giayXacNhanModel.soGXNDaCap(hoSo.soGXNDaCap);
	self.giayXacNhanModel.ngayCap(hoSo.ngayCapDateFormat);
	self.giayXacNhanModel.ngayHetHan(hoSo.ngayHetHanDateFormat);
	self.giayXacNhanModel.lyDo(hoSo.lyDo);
	if (hoSo.soGXNDaCap != null) {
		  self.giayXacNhanModel.exists(true);
	}
	self.giayXacNhanModel.valid.errors.showAllMessages(false);
	self.timKiemGiayXacNhan = function(onSuccess, onError) {
		app.makePost({
            url: uriContextPath + '/layThongTinSoGXN/0/' + self.giayXacNhanModel.soGXNDaCap(),
            data: JSON.stringify({}),
            success: function (d) {
                var msg = '';
                var fun = 'success';
                if (d.success) {
                    msg = NSWLang["monre_01_error_message_thong_tin_giay_xac_nhan_tim_thay"] + '<b> ' + self.giayXacNhanModel.soGXNDaCap() + "</b>";
                    self.giayXacNhanModel.ngayCap(d.data.hieuLucTuNgayDateFormat);
                    self.giayXacNhanModel.ngayHetHan(d.data.hieuLucDenNgayDateFormat);
                    self.giayXacNhanModel.exists(true);
                    app.toast({
                        title: NSWLang["common_msg_thong_bao"],
                        message: msg,
                        function: fun
                    });
                    onSuccess();
                    
                } else {
                	toastr.error(NSWLang["monre_01_error_message_thong_tin_giay_xac_nhan_khong_tim_thay"] + '<b> ' + self.giayXacNhanModel.soGXNDaCap() + "</b>", NSWLang["common_msg_thong_bao"]);
                }
                
            },
            error: function (e) {
                onError();
                toastr.error(NSWLang["monre_01_error_message_thong_tin_giay_xac_nhan_khong_tim_thay"] + '<b> ' + self.giayXacNhanModel.soGXNDaCap() + "</b>", NSWLang["common_msg_thong_bao"]);
                self.giayXacNhanModel.ngayCap('');
                self.giayXacNhanModel.ngayHetHan('');
                self.giayXacNhanModel.exists(false);
            }
        });
	}
	self.thongTinGXNClick = function(){
		if (self.giayXacNhanModel.soGXNDaCap() == 'null' || self.giayXacNhanModel.soGXNDaCap() == null) {
			app.Alert( NSWLang["monre_01_error_message_thong_tin_giay_xac_nhan"]);
			return;
		}
		self.timKiemGiayXacNhan(function(){}, function(){}) ;
	}
	
	self.valid = function() {
		if (self.giayXacNhanModel.valid.errors().length != 0) {
			self.giayXacNhanModel.valid.errors.showAllMessages(true);
			app.Alert(NSWLang["monre_01_error_message_thong_tin_giay_xac_nhan"]);
			return false;
		}
		
		return self.validDate(self.giayXacNhanModel.ngayCap(), self.giayXacNhanModel.ngayHetHan());
	}
	
	self.validDate = function(d1, d2) {
		if (d1 != null && d1 != '' && d2 != null && d2 != '' && d1 != undefined  && d2 != undefined) {
			var f = self.toDate(d1);
			var t = self.toDate(d2);
			if (f != null && t != null) {
				if (f.getTime() > t.getTime()) {
					app.Alert('Ngày cấp không được lớn hơn ngày hết hạn!');
					return false;
				} else {
					return true;
				}
			}
		}
		app.Alert(NSWLang["monre_01_error_message_thong_tin_giay_xac_nhan"]);
		return false;
	}

	self.toDate = function(dateStr) {
		var splits = dateStr.split("/");
		var day = splits[0];
		var month = splits[1];
		var year = splits[2];
	    return new Date(year, month - 1, day);
	}
	
}