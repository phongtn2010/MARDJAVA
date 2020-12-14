var container1VM;
var container2VM;
var container3VM;
var container4VM;
var container5VM;
var container6VM;
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

						if ($.isEmptyObject(container2VM)) {
							container2VM = new AppViewModel(d.data);
							ko.applyBindings(container2VM, document.getElementById("test"));
							v2 = container2VM;
						}

						if ($.isEmptyObject(container3VM)) {
							container3VM = new ThongTinPheLieuViewModel(d.data);
							ko.applyBindings(container3VM, document.getElementById("ThongTinPheLieuViewModel"));
							v3 = container3VM;
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
			if (loaiThuTuc === 2 || loaiThuTuc === 4) {
				if (v5.valid() == false) {
					return false;
				}
			}
			//kiem tra thong tin co so san xuat dinh kem bat buoc
			if (v2.valid(isGuiHoSo) == false) {
				return false;
			}
			//kiem tra thong tin phe lieu dinh kem bat buoc
			if (v3.valid(isGuiHoSo) == false) {
				return false;
			}
			//kiem tra file dinh kem bat buoc
			if (v4.valid(isGuiHoSo) == false) {
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

			var coSoSXs = [];
			$(v2.dsCoSoSXTheoHS()).each(function(index, item) {
				var pItem = {
					tbdThongTinCoSoSXId : item.tbdThongTinCoSoSXId(),
					idCS : item.idCS(),
					idHS : idHoSo,
					tenCoSo : item.tenCoSo(),
					diaChiCoSo : item.diaChiCoSo(),
					maTinh : item.maTinh(),
					maHuyen : item.maHuyen(),
					maXaPhuong : item.maXaPhuong(),
					tenTinh : item.tenTinh(),
					tenHuyen : item.tenHuyen(),
					tenXaPhuong : item.tenXaPhuong(),
					fax : item.fax(),
					email : item.email(),
					soDienThoai : item.soDienThoai()
				};
				coSoSXs.push(pItem);
			});
			postData.coSoSanXuatJsonString = ko.toJSON(coSoSXs);

			var pheLieus = [];
			$(v3.dsPheLieu()).each(function(index, item) {
				var pItem = {
					idPL : item.idPL(),
					idHS : idHoSo,
					tenPheLieu : item.tenPheLieu(),
					maHS : item.maHS2(),
					khoiLuong : item.khoiLuong(),
					khoiLuong6 : item.khoiLuong6(),
					klCongSuat : item.klCongSuat(),
					khoiLuongInput : item.khoiLuong(),
					khoiLuong6Input : item.khoiLuong6(),
					klCongSuatInput : item.klCongSuatInput(),
					donViUyThac : item.donViUyThac2(),
				};
				if (pItem.tenPheLieu != '-1' && pItem.maHS != '-1' && (pItem.idPL == 0 || item.capNhat() == 1)) {
					pheLieus.push(pItem);
				}
			});
			postData.pheLieuJsonString = ko.toJSON(pheLieus);

			app.makePost({
				url : uriContextPath + '/save',
				data : JSON.stringify(postData),
				success : function(d) {
					if (d.success) {
						var href = app.appContext + uriContextPath + '/edit/' + d.data.idHS;
						if (guiHoSo) {
							callback();
						} else {
							location.href = href;
						}
						
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
			self.save(true, function(){
				$('#form').submit();
			});
		}

	}

	ghiHoSoViewModel = new GhiHoSoViewModel(container1VM, container2VM, container3VM, container4VM, container5VM);

	ko.applyBindings(ghiHoSoViewModel, document.getElementById("GhiHoSoViewModel"));

});
