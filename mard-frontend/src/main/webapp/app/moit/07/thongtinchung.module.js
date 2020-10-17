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
	self.thongTinChungModel.soGiayPhepDaCap(hoSo.soGiayPhepDaCap);
	self.thongTinChungModel.ngayCapGiayPhep(hoSo.ngayCapGiayPhep);
	self.thongTinChungModel.lyDoGiaHan(hoSo.lyDoGiaHan);
	self.thongTinChungModel.loaiGiayPhep(hoSo.loaiGiayPhep);
	self.thongTinChungModel.dienThoaiNoiSanXuat(hoSo.dienThoaiNoiSanXuat);
	self.thongTinChungModel.dienThoaiNguoiLienHe(hoSo.dienThoaiNguoiLienHe);
	self.thongTinChungModel.faxNoiSanXuat(hoSo.faxNoiSanXuat);
	self.thongTinChungModel.tenNguoiDaiDien(hoSo.tenNguoiDaiDien);
	self.thongTinChungModel.tenNguoiLienHe(hoSo.tenNguoiLienHe);
	self.thongTinChungModel.emailNguoiLienHe(hoSo.emailNguoiLienHe);
	self.thongTinChungModel.hinhThucXNK(hoSo.hinhThucXNK);
	self.thongTinChungModel.noiCapGDKKD(hoSo.noiCapGDKKD);
	self.thongTinChungModel.xemHoSo(xemHoSo);
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
	
	self.hinhThucXNKs = ko.observableArray();
	self.hinhThucXNKs.push({name: NSWLang['moit_06_form_ttc_loaihoso_01'], value: -1});
	self.hinhThucXNKs.push({name: "Nhập khẩu", value: 2});
	self.hinhThucXNKs.push({name: "Xuất khẩu", value: 1});
	
	self.editSoGP = ko.observable(hoSo.hangHoa7DTOs != null && hoSo.hangHoa7DTOs.length > 0 ? false: true);
	self.changeLoaiHoSo = ko.observable(true);
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
		/*if (self.thongTinChungModel.fax() == undefined || self.thongTinChungModel.fax().trim() == '') {
			self.thongTinChungModel.fax('');
			cssError('thongTinChungModel_fax');
			self.thongTinChungModel.valid.errors.showAllMessages();
			return false;
		} else {
			cssSuccess('thongTinChungModel_fax');
		}*/
		//email
		if (self.thongTinChungModel.email() == undefined || self.thongTinChungModel.email().trim() == '') {
			self.thongTinChungModel.email('');
			cssError('thongTinChungModel_email');
			self.thongTinChungModel.valid.errors.showAllMessages();
			return false;
		} else {
			cssSuccess('thongTinChungModel_email');
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
		
		if (self.thongTinChungModel.noiCapGDKKD() == undefined || self.thongTinChungModel.noiCapGDKKD().trim() == '') {
			self.thongTinChungModel.noiCapGDKKD('');
			cssError('thongTinChungModel_noiCapGDKKD');
			self.thongTinChungModel.valid.errors.showAllMessages();
			return false;
		} else {
			cssSuccess('thongTinChungModel_noiCapGDKKD');
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
		
		if (self.thongTinChungModel.dienThoaiNoiSanXuat() == undefined || self.thongTinChungModel.dienThoaiNoiSanXuat().trim() == '') {
			self.thongTinChungModel.dienThoaiNoiSanXuat('');
			cssError('thongTinChungModel_dienThoaiNoiSanXuat');
			self.thongTinChungModel.valid.errors.showAllMessages();
			return false;
		} else {
			cssSuccess('thongTinChungModel_dienThoaiNoiSanXuat');
		}
		/*if (self.thongTinChungModel.faxNoiSanXuat() == undefined || self.thongTinChungModel.faxNoiSanXuat().trim() == '') {
			self.thongTinChungModel.dienThoaiNoiSanXuat('');
			cssError('thongTinChungModel_faxNoiSanXuat');
			self.thongTinChungModel.valid.errors.showAllMessages();
			return false;
		} else {
			cssSuccess('thongTinChungModel_faxNoiSanXuat');
		}*/
		//loai giay phep
		if (self.thongTinChungModel.loaiGiayPhep() == undefined || self.thongTinChungModel.loaiGiayPhep() == -1) {
			self.thongTinChungModel.loaiGiayPhep('');
			cssError('thongTinChungModel_loaiGiayPhep');
			self.thongTinChungModel.valid.errors.showAllMessages();
			return false;
		} else {
			cssSuccess('thongTinChungModel_loaiGiayPhep');
		}
		if (self.thongTinChungModel.hinhThucXNK() == undefined || self.thongTinChungModel.hinhThucXNK() == -1) {
			self.thongTinChungModel.hinhThucXNK('-1');
			cssError('thongTinChungModel_hinhThucXNK');
			self.thongTinChungModel.valid.errors.showAllMessages();
			return false;
		} else {
			cssSuccess('thongTinChungModel_hinhThucXNK');
		}
		if (self.thongTinChungModel.tenNguoiDaiDien() == undefined || self.thongTinChungModel.tenNguoiDaiDien().trim() == '') {
			self.thongTinChungModel.tenNguoiDaiDien('');
			cssError('thongTinChungModel_tenNguoiDaiDien');
			self.thongTinChungModel.valid.errors.showAllMessages();
			return false;
		} else {
			cssSuccess('thongTinChungModel_tenNguoiDaiDien');
		}
		if (self.thongTinChungModel.tenNguoiLienHe() == undefined || self.thongTinChungModel.tenNguoiLienHe().trim() == '') {
			self.thongTinChungModel.tenNguoiLienHe('');
			cssError('thongTinChungModel_tenNguoiLienHe');
			self.thongTinChungModel.valid.errors.showAllMessages();
			return false;
		} else {
			cssSuccess('thongTinChungModel_tenNguoiLienHe');
		}
		if (self.thongTinChungModel.dienThoaiNguoiLienHe() == undefined || self.thongTinChungModel.dienThoaiNguoiLienHe().trim() == '') {
			self.thongTinChungModel.dienThoaiNguoiLienHe('');
			cssError('thongTinChungModel_dienThoaiNguoiLienHe');
			self.thongTinChungModel.valid.errors.showAllMessages();
			return false;
		} else {
			cssSuccess('thongTinChungModel_dienThoaiNguoiLienHe');
		}
		
		if (self.thongTinChungModel.emailNguoiLienHe() == undefined || self.thongTinChungModel.emailNguoiLienHe().trim() == '') {
			self.thongTinChungModel.emailNguoiLienHe('');
			cssError('thongTinChungModel_emailNguoiLienHe');
			self.thongTinChungModel.valid.errors.showAllMessages();
			return false;
		} else {
			cssSuccess('thongTinChungModel_emailNguoiLienHe');
		}
		
		if (self.thongTinChungModel.maTinhTP() == undefined || self.thongTinChungModel.maTinhTP() == '-1') {
			
			self.thongTinChungModel.maTinhTP('');
			cssError('thongTinChungModel_maTinh');
			self.thongTinChungModel.valid.errors.showAllMessages();
			return false;
		} else {
			cssSuccess('thongTinChungModel_maTinh');
		}
		
		//loai giay phep tien chat
		if (self.thongTinChungModel.loaiGiayPhep() == 2) {
			if (self.thongTinChungModel.soGiayPhepDaCap() == undefined || self.thongTinChungModel.soGiayPhepDaCap().trim() == '') {
				self.thongTinChungModel.soGiayPhepDaCap('');
				cssError('thongTinChungModel_soGiayPhepDaCap');
				self.thongTinChungModel.valid.errors.showAllMessages();
				return false;
			} else {
				cssSuccess('thongTinChungModel_soGiayPhepDaCap');
			}
			if (self.thongTinChungModel.lyDoGiaHan() == undefined || self.thongTinChungModel.lyDoGiaHan().trim() == '') {
				self.thongTinChungModel.lyDoGiaHan('');
				cssError('thongTinChungModel_lyDoGiaHan');
				self.thongTinChungModel.valid.errors.showAllMessages();
				return false;
			} else {
				cssSuccess('thongTinChungModel_lyDoGiaHan');
			}
		}
		if (self.thongTinChungModel.valid.errors().length > 0) {
			$(self.thongTinChungModel.valid.errors()).each(function(index, item){
				app.Alert(item);
				self.thongTinChungModel.valid.errors.showAllMessages();
				return false;
			});
			
			return false;
		}
		
		return true;
	}
	
	self.findGPs = ko.observableArray([]);
	self.searching = ko.observable(false);
	self.thongTinChungModel.soGiayPhepDaCap.subscribe(function(oldValue) {
		if (self.thongTinChungModel.loaiGiayPhep() == 2) {
            $.ajax({
                url: app.appContext + "/moit/api/07/findSoGP",
                dataType: "json",
                method: 'GET',
                data: {
                    maSoGP: oldValue
                },
                success: function (d) {
                    self.findGPs.removeAll();
                    if (d.data != null && d.data.length > 0) {
                        d.data.forEach(function(item, index){
                            self.findGPs.push(item.maSoGP);
                        })
                    } else {
                        self.findGPs.push(NSWLang["moit_07_form_cthanghoa_error_err_timKiemSoPK"]);
                    }

                }
            });
		}

	});
	
	self.searchItemClick = function(item) {
		self.thongTinChungModel.soGiayPhepDaCap(item);
		//v3.soGP(item);
		self.searching(false);
	}
	
}