
function  numberToText(value) {
	var text = '';
	var soTy = 1000000000;
	var soTrieu = 1000000;
	var soNghin = 1000;
	if (value > 999999) {
		//hang ty
		var nTy = parseInt(value / soTy);
		if (nTy > 0) {
			text += docNghin(nTy) + 'tỷ, ';
		}
		
		var nTrieu = parseInt((value % soTy) / soTrieu);
		if (nTrieu > 0) {
			text += docNghin(nTrieu) + 'triệu, ';
		}
		
		
		var nNghin = parseInt(((value % soTy) % soTrieu) / soNghin);
		
		if (nNghin < 100 && nNghin > 0) {
			text += 'không trăm ';
		}
		if (nNghin < 10 && nNghin) {
			text += 'linh ';
		}
		if (nNghin > 0) {
			text += docNghin(nNghin) + 'nghìn, ';
		}
		
		
		var nTram = parseInt(((value % soTy) % soTrieu) % soNghin);
		if (nTram < 100 && nTram > 0) {
			text += 'không trăm ';
		}
		if (nTram > 0) {
			text += docNghin(nTram);
		}
		
	} else {
		text = docNghin(value);
	}
	text = text.trim();
	if (text.endsWith(',')) {
		text = text.substring(0, text.length - 1);
	}
	return text;
}


function docNghin(number) {
	var soNghin = 1000;
	var soTram = 100;
	var soChuc = 10;
	var text = '';
	var nNghin = parseInt(number / soNghin);
	if (nNghin > 0) {
		
		var duNghin = nNghin % 10;
		if (nNghin > 100)  duNghin = nNghin % 100;
		if (duNghin > 0) {
			var soChan = nNghin - duNghin;
			if (soChan > 0) {
				text += getNumberName(soChan);
			}
			if (duNghin > 10) {
				var du = parseInt(duNghin % 10);
				text += getNumberName(duNghin - du);
				if (du > 0)
				text += getNumberName(du);
				text += 'nghìn, ';
			} else {
				text +=  getNumberName(duNghin) + 'nghìn, ';
			}
			
		} else {
			text += getNumberName(nNghin) + 'nghìn, ';
		}
	}
	var nTram = parseInt((number % soNghin) / soTram);
	if (nTram > 0) {
		text += getNumberName(nTram) + 'trăm ';
	} else if (nNghin > 0) {
		text += getNumberName(nTram) + 'trăm '
	}
	var nChuc = parseInt(((number % soNghin) % soTram) / soChuc);
	var nDonVi = parseInt((((number % soNghin) % soTram) % soChuc));
	if (nChuc > 0) {
		if (nChuc == 1) {
			text += getNumberName(10);
		} else {
			text += getNumberName(nChuc) + 'mươi ';
		}
	} else if (nDonVi > 0 && number > 10) {
		text += getNumberName(-1);
	}
	
	if (nDonVi > 0) text += getNumberName(nDonVi);
//	console.log(text);
	return text;
}

function getNumberName(number) {
	if (number == 1) return 'một ';
	if (number == 2) return 'hai ';
	if (number == 3) return 'ba ';
	if (number == 4) return 'bốn ';
	if (number == 5) return 'năm ';
	if (number == 6) return 'sáu ';
	if (number == 7) return 'bảy ';
	if (number == 8) return 'tám ';
	if (number == 9) return 'chín ';
	if (number == 10) return 'mười ';
	if (number == 20) return 'hai mươi ';
	if (number == 30) return 'ba mươi ';
	if (number == 40) return 'bốn mươi ';
	if (number == 50) return 'năm mươi ';
	if (number == 60) return 'sáu mươi ';
	if (number == 70) return 'bảy mươi ';
	if (number == 80) return 'tám mươi ';
	if (number == 90) return 'chín mươi ';
	if (number == 100) return 'một trăm ';
	if (number == 200) return 'hai trăm ';
	if (number == 300) return 'ba trăm ';
	if (number == 400) return 'bốn trăm ';
	if (number == 500) return 'năm trăm ';
	if (number == 600) return 'sáu trăm ';
	if (number == 700) return 'bảy trăm ';
	if (number == 800) return 'tám trăm ';
	if (number == 900) return 'chín trăm ';
	if (number == -2) return 'mươi ';
	if (number == -1) return 'linh ';
	if (number == 0) return 'không ';
	return "không ";
}
function ThongTinNgoaiTeViewModel(hoSo) {
	var self = this;
	self.thongTinNgoaiTeModel = new ThongTinNgoaiTeModel();
	self.danhSachTienTe = ko.observableArray();
	self.dsLoaiTienTe = ko.observableArray(hoSo.loaiTienTe1s);
	self.isLoadPage = ko.observable(true);
	self.moneyValue = ko.observable('');
	self.showButtonAdd = ko.observable(false);
	self.dsChiNhanh = ko.observableArray(hoSo.chiNhanhNganHang1s);
	self.dsCuaKhau = ko.observableArray(hoSo.cuaKhau1s);
	self.thongTinNgoaiTeModel.capGiayPhepLanDau(hoSo.capGiayPhepLanDau + '');
	self.thongTinNgoaiTeModel.maCuaKhau(hoSo.maCuaKhau);
	self.thongTinNgoaiTeModel.xuatNhapKhauTuNgay(hoSo.xuatNhapKhauTuNgayDateFormat);
	self.thongTinNgoaiTeModel.xuatNhapKhauDenNgay(hoSo.xuatNhapKhauDenNgayDateFormat);
	self.thongTinNgoaiTeModel.soGiayPhepDaCap(hoSo.soGiayPhepDaCap);
	self.thongTinNgoaiTeModel.doiTacXuatNhapKhau(hoSo.doiTacXuatNhapKhau);
	self.thongTinNgoaiTeModel.ghiChu(hoSo.ghiChu);
	self.thongTinChungModel = new ThongTinChungModel();
	self.thongTinChungModel.maSoThue = ko.observable(hoSo.maSoThue);
	self.thongTinChungModel.ngayTao = ko.observable(hoSo.ngayTaoDateFormat);
	self.thongTinChungModel.tenNganHang = ko.observable(hoSo.tenNganHang);
	self.thongTinChungModel.diaChi = ko.observable(hoSo.diaChi);
	self.thongTinChungModel.dienThoai = ko.observable(hoSo.dienThoai);
	self.thongTinChungModel.fax = ko.observable(hoSo.fax);
	self.thongTinChungModel.tenTrangThai = ko.observable(hoSo.tenTrangThai);
	self.thongTinChungModel.hinhThucXNK = ko.observable(hoSo.hinhThucXNK + '');
	self.thongTinChungModel.maCoQuan = ko.observable(hoSo.maChiNhanh);
	
	self.formatCurrency = function(value) {
      var text =  value.toFixed(1).replace(/(\d)(?=(\d{3})+\.)/g, "$1.");
      text = text.substring(0, text.length - 2);
      return text;
	}
	
	self.layDanhSachTienTe = function() {
		hoSo.tienTes.forEach(function(item, index) {
			var tt = new ThongTinTienTeModel();
			tt.idTienTe(item.idTienTe);
			tt.idHoSo(item.idHoSo);
			tt.soThuTu(index + 1);
			tt.soLuongNgoaiTeBangSo(self.formatCurrency(parseInt(item.soLuongNgoaiTeBangSo)));
			tt.soLuongNgoaiTeBangChu(item.soLuongNgoaiTeBangChu);
			tt.maLoaiTienTe(item.maLoaiTienTe);
			tt.ghiChu(item.ghiChu);
			tt.enable(false);
			tt.isCreate(false);
			tt.isUpdate(true);
			tt.isDelete(true);
			self.danhSachTienTe.push(tt);
		});
		if (self.danhSachTienTe().length == 0) {
			self.createEndItem();
		} 
		self.showButtonAdd(true);
		 $(".select5").select2({placeholder: '',  width: '100%'});
	}

	setTimeout(function(){
		self.layDanhSachTienTe();
	}, 300);
	
	
	self.saveItem = function(item) {
		if (item.valid.errors().length > 0) {
			item.valid.errors.showAllMessages();
			return;
		}
		if (item.maLoaiTienTe() == '-1') {
			app.Alert(NSWLang["sbv_01_form_error_01"]);
			return;
		}
		
		item.isCreate(false);
		item.isDelete(true);
		self.createEndItem();
		$(".select5").select2({placeholder: '',  width: '100%'});
	}
	
	self.createEndItem = function() {
		var tt = new ThongTinTienTeModel();
		tt.soThuTu(self.danhSachTienTe().length + 1);
		self.danhSachTienTe.push(tt);
	}
	
	self.changePosition = function(){
		$(self.danhSachTienTe()).each(function(index, item){
			item.soThuTu(index + 1);
		});
	}

	self.editItem = function(item) {
		item.isCreate(true);
		item.isUpdate(false);
		item.isDelete(false);
		item.enable(true);
	}
	
	self.deleteItem = function(item) {
		if (item.idTienTe() > 0) {
			var pop = app.popup({
	            title: NSWLang["common_msg_thong_bao"],
	            html: '<i class="fa fa-3x fa-warning"></i> ' + NSWLang["common_msg_xoa_ho_so"],
	            width: 400,
	            buttons: [
	                {
	                    name: NSWLang["common_button_toi_chac_chan"],
	                    class: 'btn',
	                    icon: 'fa-check',
	                    action: function () {
	                        app.makePost({
	                            url: '/sbv/api/01/deleteTTHS/' + item.idTienTe(),
	                            data: JSON.stringify({}),
	                            success: function (d) {
	                                if (d.success) {
	                                    app.popupRemove(pop.selector);
	                                    app.toast({
	            							title : NSWLang["common_msg_thong_bao"],
	            							message : d.message
	            						});
	                                    self.danhSachTienTe.remove(item);
	                                    self.changePosition();
	                                } 
	                               
	                            },
	                            error: function (e) {
	                                console.log(e);
	                            }
	                        });
	                    }
	                }
	            ]
	        });
		} else {
			self.danhSachTienTe.remove(item);
            self.changePosition();
		}
		
	}
	
	self.numberInputKeyPressEvent = function(item, value, data, event) {
	
		var x = event.which || event.keyCode;
		var keys = [ 48, 49, 50, 51, 52, 53, 54, 55, 56, 57];
		if ($.inArray(x, keys) === -1) { 
           return false;
        }
		
        return true;
     }
	
	self.numberInputKeyUpEvent = function(item, value, data, event) {
		
		var x = event.which || event.keyCode;
		var keys = [ 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 8];
		if ($.inArray(x, keys) === -1) { 
           return false;
        }
		if (item.soLuongNgoaiTeBangSo() == '') {
			item.soLuongNgoaiTeBangChu('');
			return false;
		}
		var so = item.soLuongNgoaiTeBangSo();
		so = so.replace(/\./g, '');
		var word = numberToText(parseInt(so));
		word = word.trim().charAt(0).toUpperCase() + word.trim().slice(1);
		item.soLuongNgoaiTeBangChu(word);
		value = value.replace(/\./g, '');
		
		item.soLuongNgoaiTeBangSo(self.formatCurrency(parseInt(value)));
        return true;
     }
	
	self.capGiayPhepLanDauClick = function() {
		if (self.thongTinNgoaiTeModel.capGiayPhepLanDau()) {
			self.thongTinNgoaiTeModel.soGiayPhepDaCap('');
		}
	}
	
	
	
	self.change = function() {
		var maCN = $('#maChiNhanh').val();
		
		if (maCN == null || maCN == '-1') {
			self.dsCuaKhau.removeAll();
			self.dsCuaKhau.push({maCuaKhau: '-1', tenCuaKhau: NSWLang["sbv_01_msg_chon"]});
			return false;
		}
		
		var uri = "/sbv/api/01/layDsCuaKhauTheoCNNH/" + maCN;
			app.makePost({
				url : uri,
				data : JSON.stringify({}),
				success : function(d) {
					if (d.success) {
						self.dsCuaKhau.removeAll();
						self.dsCuaKhau.push({maCuaKhau: '-1', tenCuaKhau: NSWLang["sbv_01_msg_chon"]});
						d.data.forEach(function(item, index) {
							self.dsCuaKhau.push(item);
						});
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
	
	self.cssError = function(id) {
		var ele = $('#' + id);
		ele.focus();
		ele.css('border', '1px solid #f00');
		var p = $('span[aria-labelledby="select2-'+ id+'-container"]');
		p.css('border', '1px solid #f00');
	}
	self.cssSuccess = function(id) {
		var ele = $('#' + id);
		ele.removeAttr('style');
		var p = $('span[aria-labelledby="select2-'+ id+'-container"]');
		p.removeAttr('style');
	}
	
	
	self.isValid = function(isGuiHoSo){
		if (self.thongTinChungModel.maCoQuan() == undefined || self.thongTinChungModel.maCoQuan() == '-1' || self.thongTinChungModel.maCoQuan().trim() == '') {
			app.Alert(NSWLang["sbv_01_form_error_02"]);
			self.cssError('maChiNhanh');
			return false;
		} else {
			self.cssSuccess('maChiNhanh');
		}
		
		if (self.thongTinNgoaiTeModel.maCuaKhau() == undefined || self.thongTinNgoaiTeModel.maCuaKhau() == '-1' || self.thongTinNgoaiTeModel.maCuaKhau().trim() == '') {
			app.Alert(NSWLang["sbv_01_form_error_06"]);
			self.cssError('maCuaKhau');
			return false;
		} else {
			self.cssSuccess('maCuaKhau');
		}
		if (self.thongTinNgoaiTeModel.xuatNhapKhauTuNgay() == undefined || self.thongTinNgoaiTeModel.xuatNhapKhauTuNgay() == '-1' || self.thongTinNgoaiTeModel.xuatNhapKhauTuNgay().trim() == '') {
			app.Alert(NSWLang["sbv_01_form_error_03"]);
			self.cssError('xuatNhapKhauTuNgay');
			return false;
		} else {
			self.cssSuccess('xuatNhapKhauTuNgay');
		}
		if (self.thongTinNgoaiTeModel.xuatNhapKhauDenNgay() == undefined || self.thongTinNgoaiTeModel.xuatNhapKhauDenNgay() == '-1' || self.thongTinNgoaiTeModel.xuatNhapKhauDenNgay().trim() == '') {
			app.Alert(NSWLang["sbv_01_form_error_03"]);
			self.cssError('xuatNhapKhauDenNgay');
			return false;
		} else {
			self.cssSuccess('xuatNhapKhauDenNgay');
		}
		
		if (self.thongTinNgoaiTeModel.doiTacXuatNhapKhau() == undefined || self.thongTinNgoaiTeModel.doiTacXuatNhapKhau() == '-1' || self.thongTinNgoaiTeModel.doiTacXuatNhapKhau().trim() == '') {
			app.Alert(NSWLang["sbv_01_form_error_04"]);
			self.cssError('doiTacXuatNhapKhau');
			return false;
		} else {
			self.cssSuccess('doiTacXuatNhapKhau');
		}
		
		var from = $("#xuatNhapKhauTuNgay").val();
		var to = $("#xuatNhapKhauDenNgay").val();
		var f = self.toDate(from);
		var t = self.toDate(to);
		if (f.getTime() > t.getTime()) {
			app.Alert( NSWLang["sbv_01_form_tiente_error_7"]);
			return false;
		}
		for (var k = 0; k < self.danhSachTienTe().length; k++) {
			var item = self.danhSachTienTe()[k];
			if (item.soLuongNgoaiTeBangSo() != '' || item.soLuongNgoaiTeBangChu() != '' || item.maLoaiTienTe() != '-1') {
				if (item.soLuongNgoaiTeBangSo() == undefined || item.soLuongNgoaiTeBangSo() == '0' || item.soLuongNgoaiTeBangSo() == '') {
					app.Alert( NSWLang["sbv_01_form_tiente_error_5"]);
					self.cssError('tienTes_'+ k +'_soLuongNgoaiTeBangSo');
					return false;
				}
				self.cssSuccess('tienTes_'+ k +'_soLuongNgoaiTeBangSo');
				if (item.soLuongNgoaiTeBangChu() == undefined || item.soLuongNgoaiTeBangChu() == '') {
					app.Alert( NSWLang["sbv_01_form_tiente_error_5"]);
					self.cssError('tienTes_'+ k +'_soLuongNgoaiTeBangChu');
					return false;
				}
				self.cssSuccess('tienTes_'+ k +'_soLuongNgoaiTeBangChu');
				if (item.maLoaiTienTe() == undefined || item.maLoaiTienTe() == '' || item.maLoaiTienTe() == '-1') {
					app.Alert( NSWLang["sbv_01_form_tiente_error_5"]);
					self.cssError('tienTes_'+ k +'_maLoaiTienTe');
					return false;
				}
				self.cssSuccess('tienTes_'+ k +'_maLoaiTienTe');
			}
		}
		if (isGuiHoSo) {
			if (self.danhSachTienTe().length == 1) {
				var item = self.danhSachTienTe()[0];
				if (item.soLuongNgoaiTeBangSo() == undefined || item.soLuongNgoaiTeBangSo() == '0' || item.soLuongNgoaiTeBangSo() == '') {
					app.Alert( NSWLang["sbv_01_form_tiente_error_5"]);
					return false;
				}
				if (item.soLuongNgoaiTeBangChu() == undefined || item.soLuongNgoaiTeBangChu() == '') {
					app.Alert( NSWLang["sbv_01_form_tiente_error_5"]);
					return false;
				}
				if (item.maLoaiTienTe() == undefined || item.maLoaiTienTe() == '' || item.maLoaiTienTe() == '-1') {
					app.Alert( NSWLang["sbv_01_form_tiente_error_5"]);
					return false;
				}
			}
			
		}
		return true;
	}
	
	self.toDate = function(dateStr) {
		var splits = dateStr.split("/");
		var day = splits[0];
		var month = splits[1];
		var year = splits[2];
	    return new Date(year, month - 1, day);
	}
	
	self.getHoSo = function() {
		
		var data = {};
		data.idHoSo = hoSo.idHoSo;
		data.maChiNhanh = self.thongTinChungModel.maCoQuan();
		data.hinhThucXNK = parseInt(self.thongTinNgoaiTeModel.hinhThucXNK());
		data.maCuaKhau = self.thongTinNgoaiTeModel.maCuaKhau();
		data.xuatNhapKhauTuNgayDateFormat = self.thongTinNgoaiTeModel.xuatNhapKhauTuNgay();
		data.xuatNhapKhauDenNgayDateFormat = self.thongTinNgoaiTeModel.xuatNhapKhauDenNgay();
		data.capGiayPhepLanDau = self.thongTinNgoaiTeModel.capGiayPhepLanDau();
		data.soGiayPhepDaCap = self.thongTinNgoaiTeModel.soGiayPhepDaCap();
		data.doiTacXuatNhapKhau = self.thongTinNgoaiTeModel.doiTacXuatNhapKhau();
		data.ghiChu = self.thongTinNgoaiTeModel.ghiChu();
		var ars = [];
		if (self.danhSachTienTe().length > 0) {
			self.danhSachTienTe().forEach(function(item, index) {
				var tt = {} ;
				tt.idTienTe = item.idTienTe() + '';
				tt.idHoSo = item.idHoSo();
				var value = item.soLuongNgoaiTeBangSo().replace(/\./g, '');
				tt.soLuongNgoaiTeBangSo = value;
				tt.soLuongNgoaiTeBangChu = item.soLuongNgoaiTeBangChu();
				tt.maLoaiTienTe = item.maLoaiTienTe();
				tt.ghiChu = item.ghiChu();
				ars.push(tt);
			});
		}
		data.tienTeJsonString = ko.toJSON(ars);
		
		return data;
	}
	
	self.timKiemGiayXacNhan = function(onSuccess) {
		app.makePost({
            url:  '/sbv/api/01/findGiayXN/' + self.thongTinNgoaiTeModel.soGiayPhepDaCap(),
            data: JSON.stringify({}),
            success: function (d) {
                var msg = '';
                var fun = 'success';
                if (d.success) {
                	console.log(d.data);
                	 app.toast({
                         title: NSWLang["common_msg_thong_bao"],
                         message: msg,
                         function: fun
                     });
                    onSuccess();
                }
               
            },
            error: function (e) {
                console.log(e);
                toastr.error(e.message, NSWLang["common_msg_thong_bao"]);
            }
        });
	}
	
	
}

function numberToEnglish(n, custom_join_character) {

    var string = n.toString(),
        units, tens, scales, start, end, chunks, chunksLen, chunk, ints, i, word, words;

    var and = custom_join_character || '';

    /* Is number zero? */
    if (parseInt(string) === 0) {
        return 'không';
    }

    /* Array of units as words */
    units = ['', 'một', 'hai', 'ba', 'bốn', 'năm', 'sáu', 'bảy', 'tám', 'chín', 'mười', 'mười một', 'mười hai', 'mười ba', 'mười bốn', 'mười năm', 'mười sáu', 'mười bảy', 'mười tám', 'mười chín'];

    /* Array of tens as words */
    tens = ['', '', 'hai mươi', 'ba mươi', 'bốn mươi', 'năm mươi', 'sáu mươi', 'bảy mươi', 'tám mươi', 'chín mươi'];

    /* Array of scales as words */
    scales = ['', 'nghìn', 'triệu', 'tỷ', 'nghìn tỷ', 'nghìn triệu triệu', 'quintillion', 'sextillion', 'septillion', 'octillion', 'nonillion', 'decillion', 'undecillion', 'duodecillion', 'tredecillion', 'quatttuor-decillion', 'quindecillion', 'sexdecillion', 'septen-decillion', 'octodecillion', 'novemdecillion', 'vigintillion', 'centillion'];

    /* Split user arguemnt into 3 digit chunks from right to left */
    start = string.length;
    chunks = [];
    while (start > 0) {
        end = start;
        chunks.push(string.slice((start = Math.max(0, start - 3)), end));
    }

    /* Check if function has enough scale words to be able to stringify the user argument */
    chunksLen = chunks.length;
    if (chunksLen > scales.length) {
        return '';
    }

    /* Stringify each integer in each chunk */
    words = [];
    for (i = 0; i < chunksLen; i++) {

        chunk = parseInt(chunks[i]);

        if (chunk) {

            /* Split chunk into array of individual integers */
            ints = chunks[i].split('').reverse().map(parseFloat);

            /* If tens integer is 1, i.e. 10, then add 10 to units integer */
            if (ints[1] === 1) {
                ints[0] += 10;
            }

            /* Add scale word if chunk is not zero and array item exists */
            if ((word = scales[i])) {
                words.push(word);
            }

            /* Add unit word if array item exists */
            if ((word = units[ints[0]])) {
                words.push(word);
            }

            /* Add tens word if array item exists */
            if ((word = tens[ints[1]])) {
                words.push(word);
            }

            /* Add 'and' string after units or tens integer if: */
            if (ints[0] || ints[1]) {

                /* Chunk has a hundreds integer or chunk is the first of multiple chunks */
                if (ints[2] || !i && chunksLen) {
                    words.push(and);
                }

            }

            /* Add hundreds word if array item exists */
            if ((word = units[ints[2]])) {
                words.push(word + ' trăm');
            }

        }

    }

    return words.reverse().join(' ');

}


