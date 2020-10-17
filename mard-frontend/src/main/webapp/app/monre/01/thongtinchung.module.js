

function ThongTinChungViewModel(hoSo) {
	var self = this;
	
	self.contextPath = ko.observable(uriContextPath);
	
	self.thongTinChungModel = new ThongTinChungModel();
	self.danhSachCoQuanXuLy = ko.observableArray(hoSo.coQuanXuLyList);
	self.xemHoSo = ko.observable(xemHoSo);
	//set data
	self.thongTinChungModel.maCoQuan(hoSo.maCoQuan);
	self.thongTinChungModel.tenDN(hoSo.tenDN);
	self.thongTinChungModel.tenCoQuan(hoSo.tenCoQuan);
	self.thongTinChungModel.maSoThue(hoSo.maSoThue);
	self.thongTinChungModel.truSoChinh(hoSo.truSoChinh);
	self.thongTinChungModel.nguoiDaiDien(hoSo.nguoiDaiDien);
	self.thongTinChungModel.soDTNguoiDaiDien(hoSo.soDTNguoiDaiDien);
	self.thongTinChungModel.faxNguoiDaiDien(hoSo.faxNguoiDaiDien);
	self.thongTinChungModel.emailNguoiDaiDien(hoSo.emailNguoiDaiDien);
	self.thongTinChungModel.soGCNDKKD(hoSo.soGCNDKKD);
	self.thongTinChungModel.ngayCapGCNDKKD(hoSo.ngayCapGCNDKKDDateFormat);
	self.thongTinChungModel.noiCapGCNDKKD(hoSo.noiCapGCNDKKD);
	self.thongTinChungModel.enable($('#xemHoSo').val() == 'true' ? false : true);
	self.thongTinChungModel.valid.errors.showAllMessages(false);
	self.chonCoQuanXuLyChangeEvent = function(item) {
		var tenCoQuan = $('#maCoQuan :selected').text();
		$('#tenCoQuan').val(tenCoQuan);
		self.thongTinChungModel.tenCoQuan(tenCoQuan);
		if (self.thongTinChungModel.maCoQuan() == '-1') {
			tenCoQuan = '';
			$('#tenCoQuan').val(tenCoQuan);
			self.thongTinChungModel.tenCoQuan(tenCoQuan);
		}
	}
	
	self.valid = function() {
		if (self.thongTinChungModel.maCoQuan() == '-1') {
			self.thongTinChungModel.maCoQuan('-1');
			self.thongTinChungModel.tenCoQuan('');
			app.Alert(NSWLang["monre_01_error_message_thong_tin_chung"]);
			return false;
		}
		if (self.thongTinChungModel.valid.errors().length != 0) {
			self.thongTinChungModel.valid.errors.showAllMessages(true);
			app.Alert(NSWLang["monre_01_error_message_thong_tin_chung"]);
			return false;
		}
		return true;
	}
	
}

