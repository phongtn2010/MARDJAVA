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
                    onSuccess();
                    
                } else {
                    msg = NSWLang["monre_01_error_message_thong_tin_giay_xac_nhan_khong_tim_thay"] + '<b> ' + self.giayXacNhanModel.soGXNDaCap() + "</b>";
                    fun = 'error';
                }
                app.toast({
                    title: NSWLang["common_msg_thong_bao"],
                    message: msg,
                    function: fun
                });
            },
            error: function (e) {
                onError();
                app.toast({
                    title: NSWLang["common_msg_thong_bao"],
                    message: NSWLang["monre_01_error_message_thong_tin_giay_xac_nhan_khong_tim_thay"] + '<b> ' + self.giayXacNhanModel.soGXNDaCap() + "</b>"
                });
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
		var from = self.giayXacNhanModel.ngayCap();
		var to = self.giayXacNhanModel.ngayHetHan();
		var f = self.toDate(from);
		var t = self.toDate(to);
		if (f.getTime() > t.getTime()) {
			app.Alert( NSWLang["monre_01_ngaynhapkhonghople"]);
			return false;
		}
		
		return true;
	}

	self.toDate = function(dateStr) {
	    var splits = dateStr.split("/");
	    var year = splits[2];
	    var day = splits[0];
	    var month = parseInt(splits[1]);
	    return new Date(year, month - 1, day);
	}
	
}