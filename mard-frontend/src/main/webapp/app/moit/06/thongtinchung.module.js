function ThongTinChungViewModel(hoSo) {
	var self = this;
	
	self.maHoSo = ko.observable(hoSo.maHoSo);
	self.trangThaiHoSo = ko.observable(hoSo.trangThaiHoSo);
	self.thongTinChungModel = new ThongTinChungModel();
	self.thongTinChungModel.maSoThue(hoSo.maSoThue);
	self.thongTinChungModel.tenDoanhNghiep(hoSo.tenDoanhNghiep);
	self.thongTinChungModel.diaChiDoanhNghiep(hoSo.diaChiDoanhNghiep);
	self.thongTinChungModel.fax(hoSo.fax);
	self.thongTinChungModel.email(hoSo.email);
	self.thongTinChungModel.dienThoai(hoSo.dienThoai);
	self.thongTinChungModel.loaiHinh(hoSo.loaiHinh);
	self.thongTinChungModel.soGiayChungNhanDKKD(hoSo.soGiayChungNhanDKKD);
	self.thongTinChungModel.ngayCapGiayChungNhan(hoSo.ngayCapGiayChungNhan);
	self.thongTinChungModel.diaChiSanXuat(hoSo.diaChiSanXuat);
	self.thongTinChungModel.soGiayPhepTCTN(hoSo.soGiayPhepTCTN);
	self.thongTinChungModel.ngayCapGiayPhep(hoSo.ngayCapGiayPhep);
	self.thongTinChungModel.ngayCapGiayPhepTCTN(hoSo.ngayCapGiayPhepTCTN);
	self.thongTinChungModel.loaiGiayPhep(hoSo.loaiGiayPhep);
	self.thongTinChungModel.xemHoSo(xemHoSo);
	self.thongTinChungModel.maTinhTP(hoSo.maTinhTP);
	self.thongTinChungModel.noiCapGiayChungNhanDKKD(hoSo.noiCapGiayChungNhanDKKD);
	self.thongTinChungModel.tenNguoiDaiDien(hoSo.tenNguoiDaiDien);
	self.thongTinChungModel.daiDienChucVu(hoSo.daiDienChucVu);
	self.thongTinChungModel.daiDienNamSinh(hoSo.daiDienNamSinh);
	self.thongTinChungModel.daiDienGioiTinh(hoSo.daiDienGioiTinh);
	self.thongTinChungModel.daiDienDiaChi(hoSo.daiDienDiaChi);
	self.thongTinChungModel.maTinhTP(hoSo.maTinhTP);
	
	self.loaiHoSos = ko.observableArray();
	self.loaiHoSos.push({name: NSWLang['moit_06_form_ttc_loaihoso_01'], value: -1});
	self.loaiHoSos.push({name: NSWLang['moit_06_form_ttc_loaihoso_02'], value: 1});
	self.loaiHoSos.push({name: NSWLang['moit_06_form_ttc_loaihoso_03'], value: 2});
	
	self.loaiHinhs = ko.observableArray();
	self.loaiHinhs.push({name: NSWLang['moit_06_form_ttc_loaihinh_01'], value: -1});
	self.loaiHinhs.push({name: NSWLang['moit_06_form_ttc_loaihinh_02'], value: 1});
	self.loaiHinhs.push({name: NSWLang['moit_06_form_ttc_loaihinh_03'], value: 2});
	self.loaiHinhs.push({name: NSWLang['moit_06_form_ttc_loaihinh_04'], value: 3});
	self.loaiHinhs.push({name: NSWLang['moit_06_form_ttc_loaihinh_05'], value: 4});
	self.thongTinChungModel.valid.errors.showAllMessages(false);
	
	self.gioiTinhs = ko.observableArray();
	self.gioiTinhs.push({name: NSWLang['moit_06_form_ttc_loaihinh_01'], value: -1});
	self.gioiTinhs.push({name: NSWLang['moit_06_gioiTinhNam'], value: 1});
	self.gioiTinhs.push({name: NSWLang['moit_06_gioiTinhNu'], value: 2});
	self.provinces = ko.observableArray();
	self.provinces.push({name: NSWLang['moit_06_form_ttc_loaihinh_01'], value: -1});
	hoSo.provinces.forEach(function(item, index){
		self.provinces.push({name: item.provinceName, value: item.provinceCode});
	});

	self.isValid = function(isGuiHoSo) {
		
		//ten doanh nghiep
		if (self.thongTinChungModel.tenDoanhNghiep() == null || self.thongTinChungModel.tenDoanhNghiep().trim() == '') {
			self.thongTinChungModel.tenDoanhNghiep('');
			cssError('thongTinChungModel_tenDoanhNghiep');
			self.thongTinChungModel.valid.errors.showAllMessages();
			return false;
		} else {
			cssSuccess('thongTinChungModel_tenDoanhNghiep');
		}
		
		//ma so thue
		if (self.thongTinChungModel.maSoThue() == undefined || self.thongTinChungModel.maSoThue().trim() == '') {
			self.thongTinChungModel.maSoThue('');
			cssError('thongTinChungModel_maSoThue');
			self.thongTinChungModel.valid.errors.showAllMessages();
			return false;
		} else {
			cssSuccess('thongTinChungModel_maSoThue');
		}
		
		//dia chi
		if (self.thongTinChungModel.diaChiDoanhNghiep() == undefined || self.thongTinChungModel.diaChiDoanhNghiep().trim() == '') {
			self.thongTinChungModel.diaChiDoanhNghiep('');
			cssError('thongTinChungModel_diaChiDoanhNghiep');
			self.thongTinChungModel.valid.errors.showAllMessages();
			return false;
		} else {
			cssSuccess('thongTinChungModel_diaChiDoanhNghiep');
		}
		
		//dient thoai
		if (self.thongTinChungModel.dienThoai() == undefined || self.thongTinChungModel.dienThoai().trim() == '') {
			self.thongTinChungModel.dienThoai('');
			cssError('thongTinChungModel_dienThoai');
			self.thongTinChungModel.valid.errors.showAllMessages();
			return false;
		} else {
			cssSuccess('thongTinChungModel_dienThoai');
		}
		//fax
		if (self.thongTinChungModel.fax() == undefined || self.thongTinChungModel.fax().trim() == '') {
			self.thongTinChungModel.fax('');
			cssError('thongTinChungModel_fax');
			self.thongTinChungModel.valid.errors.showAllMessages();
			return false;
		} else {
			cssSuccess('thongTinChungModel_fax');
		}
		//email
		if (self.thongTinChungModel.email() == undefined || self.thongTinChungModel.email().trim() == '') {
			self.thongTinChungModel.email('');
			cssError('thongTinChungModel_email');
			self.thongTinChungModel.valid.errors.showAllMessages();
			return false;
		} else {
			cssSuccess('thongTinChungModel_email');
		}
		//noi cap chung nhan
		if (self.thongTinChungModel.noiCapGiayChungNhanDKKD() == undefined || self.thongTinChungModel.noiCapGiayChungNhanDKKD().trim() == '') {
			self.thongTinChungModel.noiCapGiayChungNhanDKKD('');
			cssError('thongTinChungModel_noiCapGiayChungNhanDKKD');
			self.thongTinChungModel.valid.errors.showAllMessages();
			return false;
		} else {
			cssSuccess('thongTinChungModel_noiCapGiayChungNhanDKKD');
		}
		//ten nguoi dai dien
		if (self.thongTinChungModel.tenNguoiDaiDien() == undefined || self.thongTinChungModel.tenNguoiDaiDien().trim() == '') {
			self.thongTinChungModel.tenNguoiDaiDien('');
			cssError('thongTinChungModel_tenNguoiDaiDien');
			self.thongTinChungModel.valid.errors.showAllMessages();
			return false;
		} else {
			cssSuccess('thongTinChungModel_tenNguoiDaiDien');
		}
		//ten nguoi dai dien
		if (self.thongTinChungModel.daiDienChucVu() == undefined || self.thongTinChungModel.daiDienChucVu().trim() == '') {
			self.thongTinChungModel.daiDienChucVu('');
			cssError('thongTinChungModel_daiDienChucVu');
			self.thongTinChungModel.valid.errors.showAllMessages();
			return false;
		} else {
			cssSuccess('thongTinChungModel_daiDienChucVu');
		}
		//ten nguoi dai dien
		if (self.thongTinChungModel.daiDienNamSinh() == undefined || self.thongTinChungModel.daiDienNamSinh().trim() == '') {
			self.thongTinChungModel.daiDienNamSinh('');
			cssError('thongTinChungModel_daiDienNamSinh');
			self.thongTinChungModel.valid.errors.showAllMessages();
			return false;
		} else {
			cssSuccess('thongTinChungModel_daiDienNamSinh');
		}
		//gioi tinh
		if (self.thongTinChungModel.daiDienGioiTinh() == undefined || self.thongTinChungModel.daiDienGioiTinh()== '-1') {
			self.thongTinChungModel.daiDienGioiTinh('-1');
			cssError('thongTinChungModel_daiDienGioiTinh');
			self.thongTinChungModel.valid.errors.showAllMessages();
			return false;
		} else {
			cssSuccess('thongTinChungModel_daiDienGioiTinh');
		}
		//dia chi thuong tru
		if (self.thongTinChungModel.daiDienDiaChi() == undefined || self.thongTinChungModel.daiDienDiaChi().trim() == '') {
			self.thongTinChungModel.daiDienDiaChi('');
			cssError('thongTinChungModel_daiDienDiaChi');
			self.thongTinChungModel.valid.errors.showAllMessages();
			return false;
		} else {
			cssSuccess('thongTinChungModel_daiDienDiaChi');
		}
		//dia chi thuong tru
		if (self.thongTinChungModel.maTinhTP() == undefined || self.thongTinChungModel.maTinhTP() == '-1') {
			
			self.thongTinChungModel.maTinhTP('');
			cssError('thongTinChungModel_maTinh');
			self.thongTinChungModel.valid.errors.showAllMessages();
			return false;
		} else {
			cssSuccess('thongTinChungModel_maTinh');
		}
		
		//so gcn
		if (self.thongTinChungModel.soGiayChungNhanDKKD() == undefined || self.thongTinChungModel.soGiayChungNhanDKKD().trim() == '') {
			self.thongTinChungModel.soGiayChungNhanDKKD('');
			cssError('thongTinChungModel_soGiayChungNhanDKKD');
			self.thongTinChungModel.valid.errors.showAllMessages();
			return false;
		} else {
			cssSuccess('thongTinChungModel_soGiayChungNhanDKKD');
		}
		//ngay cap gcn
		if (self.thongTinChungModel.ngayCapGiayChungNhan() == undefined || self.thongTinChungModel.ngayCapGiayChungNhan().trim() == '') {
			self.thongTinChungModel.ngayCapGiayChungNhan('');
			cssError('thongTinChungModel_ngayCapGiayChungNhan');
			self.thongTinChungModel.valid.errors.showAllMessages();
			return false;
		} else {
			cssSuccess('thongTinChungModel_ngayCapGiayChungNhan');
		}
		//loai hinh
		if (self.thongTinChungModel.loaiHinh() == undefined || self.thongTinChungModel.loaiHinh() == -1) {
			cssError('thongTinChungModel_loaiHinh');
			self.thongTinChungModel.valid.errors.showAllMessages();
			return false;
		} else {
			cssSuccess('thongTinChungModel_loaiHinh');
		}
		//dia chi san xuat
		if (self.thongTinChungModel.diaChiSanXuat() == undefined || self.thongTinChungModel.diaChiSanXuat().trim() == '') {
			self.thongTinChungModel.diaChiSanXuat('');
			cssError('thongTinChungModel_diaChiSanXuat');
			self.thongTinChungModel.valid.errors.showAllMessages();
			return false;
		} else {
			cssSuccess('thongTinChungModel_diaChiSanXuat');
		}
		
		//loai giay phep tien chat
		if (self.thongTinChungModel.soGiayPhepTCTN() != undefined && self.thongTinChungModel.soGiayPhepTCTN().trim() != '') {
			if (self.thongTinChungModel.ngayCapGiayPhepTCTN() == undefined || self.thongTinChungModel.ngayCapGiayPhepTCTN().trim() == '') {
				self.thongTinChungModel.ngayCapGiayPhepTCTN('');
				cssError('thongTinChungModel_ngayCapGiayPhepTCTN');
				self.thongTinChungModel.valid.errors.showAllMessages();
				return false;
			} else {
				cssSuccess('thongTinChungModel_ngayCapGiayPhepTCTN');
			}
		} else if (self.thongTinChungModel.ngayCapGiayPhepTCTN() != undefined && self.thongTinChungModel.ngayCapGiayPhepTCTN().trim() != '') {
			if (self.thongTinChungModel.soGiayPhepTCTN() == undefined || self.thongTinChungModel.soGiayPhepTCTN().trim() == '') {
				self.thongTinChungModel.soGiayPhepTCTN('');
				cssError('thongTinChungModel_soGiayPhepTCTN');
				self.thongTinChungModel.valid.errors.showAllMessages();
				return false;
			} else {
				cssSuccess('thongTinChungModel_soGiayPhepTCTN');
			}
		}
		//loai giay phep
		if (self.thongTinChungModel.loaiGiayPhep() == undefined || self.thongTinChungModel.loaiGiayPhep() == -1) {
			self.thongTinChungModel.loaiGiayPhep('');
			cssError('thongTinChungModel_loaiGiayPhep');
			self.thongTinChungModel.valid.errors.showAllMessages();
			return false;
		} else {
			cssSuccess('thongTinChungModel_loaiGiayPhep');
		}
		
		if (self.thongTinChungModel.valid.errors().length > 0) {
			$(self.thongTinChungModel.valid.errors()).each(function(index, item){
				app.Alert(item);
				self.thongTinChungModel.valid.errors.showAllMessages();
				if (item.startsWith('Email')) {
					cssError('thongTinChungModel_email');
					self.thongTinChungModel.email('');
					
				}
				
				self.thongTinChungModel.valid.errors.showAllMessages();
				return false;
			});
			
			return false;
		}
		
		return true;
	}

    self.thongTinChungModel.loaiGiayPhep.subscribe(function(oldValue) {
        app.makePost({
            url: "/moit/api/06/capNhatLoaiGiayPhep/" + idHoSo + '/' + self.thongTinChungModel.loaiGiayPhep(),
            data: JSON.stringify({}),
            success: function (d) {
            },
            error: function (e) {
            }
        });
    });
}