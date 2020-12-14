var container1VM;
var container2VM;
var container3VM;
var container4VM;
var container5VM;
var ghiHoSoViewModel;

$(document).ready(function() {

	$(".select2").select2({
		placeholder : '',
		width : '100%'
	});

	$('.tooltips').tooltip();

	$('.date-picker').datepicker({
		rtl : false,
		orientation : "left",
		autoclose : true
	});

	$(".date-picker").datepicker({
		altFormat : "dd/mm/yy"
	});

	function GhiHoSoViewModel(v1, v2, v3, v4, v5) {

		var self = this;

		self.getHoSo = function() {

			app.makePost({
				url : uriContextPath + '/getHoSo/' + idHoSo,
				data : JSON.stringify({}),
				success : function(d) {
					if (d.success) {
						if ($.isEmptyObject(container1VM)) {
							container1VM = new ThongTinChungViewModel(d.data);
							ko.applyBindings(container1VM, document.getElementById("thong_tin_chung"));
							v1 = container1VM;
						}

						if ($.isEmptyObject(container4VM)) {
							container4VM = new ThongTinTepDinhKemViewModel(d.data);
							ko.applyBindings(container4VM, document.getElementById("ThongTinTepDinhKemViewModel"));
							v4 = container4VM;
						}

						if ($.isEmptyObject(container5VM)) {
							container5VM = new GiayXacNhanViewModel(d.data);
							ko.applyBindings(container5VM, document.getElementById("GiayXacNhanViewModel"));
							v5 = container5VM;
						}
					}

				},
				error : function(e) {
					toastr.error(e.message, NSWLang["common_msg_thong_bao"]);
				}
			});

		}
		self.getHoSo();
		self.validForm = function(isGuiHoSo) {

			if (v1.valid() == false) {
				return false;
			}
			
			if (v5.valid(isGuiHoSo) == false) {
				return false;
			}
			return true;
		}

		self.save = function(guiHoSo, callback) {
			var postData = {};
			postData.idHS = idHoSo;
			postData.guiHoSo = guiHoSo;
			postData.maCoQuan = v1.thongTinChungModel.maCoQuan();
			postData.tenDN = v1.thongTinChungModel.tenDN();
			postData.tenCoQuan = v1.thongTinChungModel.tenCoQuan();
			postData.maSoThue = v1.thongTinChungModel.maSoThue();
			postData.truSoChinh = v1.thongTinChungModel.truSoChinh();
			postData.nguoiDaiDien = v1.thongTinChungModel.nguoiDaiDien();
			postData.soDTNguoiDaiDien = v1.thongTinChungModel.soDTNguoiDaiDien();
			postData.faxNguoiDaiDien = v1.thongTinChungModel.faxNguoiDaiDien();
			postData.emailNguoiDaiDien = v1.thongTinChungModel.emailNguoiDaiDien();
			postData.soGCNDKKD = v1.thongTinChungModel.soGCNDKKD();
			postData.ngayCapGCNDKKDDateFormat = v1.thongTinChungModel.ngayCapGCNDKKD();
			postData.noiCapGCNDKKD = v1.thongTinChungModel.noiCapGCNDKKD();

			// thong tin giay xac nhan
			postData.soGXNDaCap = v5.giayXacNhanModel.soGXNDaCap();
			postData.ngayCapDateFormat = v5.giayXacNhanModel.ngayCap();
			postData.ngayHetHanDateFormat = v5.giayXacNhanModel.ngayHetHan();
			postData.lyDo = v5.giayXacNhanModel.lyDo();

			app.makePost({
				url : uriContextPath + '/save',
				data : JSON.stringify(postData),
				success : function(d) {
				
					if (d.success) {
						var href = app.appContext + uriContextPath + '/edit/' + d.data.idHS;
						app.toast({
							title : NSWLang["common_msg_thong_bao"],
							message : d.message
						});
						if (guiHoSo) {
							 href = app.appContext + uriContextPath + '/home';
						}
						if (guiHoSo) {
							callback();
						} else {
							location.href = href;
						}
					} else {
						toastr.error(e.message, NSWLang["common_msg_thong_bao"]);
					}
				},
				error : function(e) {
					toastr.error(e.message, NSWLang["common_msg_thong_bao"]);
				}
			});

		}

		self.ghiLai = function() {

			if (self.validForm(false) == false)
				return;
			if (loaiThuTuc == 2 || loaiThuTuc == 4) {
				v5.timKiemGiayXacNhan(function() {
					self.save(false, function(){});
				}, function() {
					app.Alert(NSWLang["monre_01_error_message_thong_tin_giay_xac_nhan_khong_tim_thay"] + '<b> ' + v5.giayXacNhanModel.soGXNDaCap() + "</b>");
				});

			} else {
				self.save(false, function(){});
			}
		}
		
		self.guiHoSo = function() {
			if (self.validForm(true) == false)
				return;
			if (loaiThuTuc == 2 || loaiThuTuc == 4) {
				v5.timKiemGiayXacNhan(function() {
					self.save(true, function(){
						$('#form').submit();
					});
				}, function() {
					app.Alert(NSWLang["monre_01_error_message_thong_tin_giay_xac_nhan_khong_tim_thay"] + '<b> ' + v5.giayXacNhanModel.soGXNDaCap() + "</b>");
				});

			} else {
				self.save(true, function(){
					$('#form').submit();
				});
			}
		}
		

	}

	ghiHoSoViewModel = new GhiHoSoViewModel(container1VM, container2VM, container3VM, container4VM, container5VM);

	ko.applyBindings(ghiHoSoViewModel, document.getElementById("GhiHoSoViewModel"));

});
