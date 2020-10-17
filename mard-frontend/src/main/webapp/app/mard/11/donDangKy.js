/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* global app, CSRF_TOKEN_NAME, CSRF_TOKEN_VALUE, user, RAW_HS_STATUS */
function Mard11FormVM(options)
{
    var self = this;

    self.clearForm = function () {

    };

    /**
     * Đưa dữ liệu vào từ excel
     * @param {type} data
     * @returns {undefined}
     */
    self.import = function (data) {
        if (!data) {
            return;
        }
        // Tải lại dữ liệu
        getCategory("CUAKHAU", data.fiMaqgNk, function (res) {
            if (res.success) {
                self.fiMackNkList(mapCategory(res.data, "portcode", "portname"));
            }
            // Đưa dữ liệu vào form
            for (var key in data) {
                if (self[key] && key != "fiTenHanghoa" && key != "lstHanghoa11") {
                    if ((key == "fiNgayky" || key == "fiNgaytao" || key == "fiNgaycmnd" || key == "fiThoigiandk") && data[key]) {
                        if (data[key]) {
                            self[key](new Date(data[key]));
                        }
                        continue;
                    }
                    self[key](data[key]);
                }
            }
            if (data.lstHanghoa11) {
                var fiIdHanghoa = 0;
                for (var i = 0; i < data.lstHanghoa11.length; i++) {
                    for (var j = 0; j < self.fiMadvSlList().length; j++) {
                        if (data.lstHanghoa11[i].fiMadvSl == self.fiMadvSlList()[j].id) {
                            data.lstHanghoa11[i].fiTendvSl = self.fiMadvSlList()[j].name;
                            break;
                        }
                    }
                    for (var j = 0; j < self.fiMadvKltList().length; j++) {
                        if (data.lstHanghoa11[i].fiMadvKlt == self.fiMadvKltList()[j].id) {
                            data.lstHanghoa11[i].fiTendvKlt = self.fiMadvKltList()[j].name;
                            break;
                        }
                    }
                    for (var j = 0; j < self.fiMadvBiList().length; j++) {
                        if (data.lstHanghoa11[i].fiMadvBi == self.fiMadvBiList()[j].id) {
                            data.lstHanghoa11[i].fiTendvBi = self.fiMadvBiList()[j].name;
                            break;
                        }
                    }
                    --fiIdHanghoa;
                    data.lstHanghoa11[i].fiIdHanghoa = fiIdHanghoa;
                }
                self.lstHanghoa11(mapTbdhanghoa11(data.lstHanghoa11));
            }
            self.fiTenqgNk($('#fiMaqgNk option:selected').text());
            self.fiTenckNk($('#fiMackNk option:selected').text());
            self.fiTenckXk($('#fiMackXk option:selected').text());
            self.fiTendvXl($('#fiMadvXl option:selected').text());
        });
    };
    /**
     * Thêm mới hoặc cập nhập đơn hàng
     * @returns {undefined}
     */
    self.updateHanghoaClick = function () {
        //console.log("self.hanghoaErrors() -> ", self.hanghoaErrors());
        if (self.hanghoaErrors().length > 0) {
            self.hanghoaErrors.showAllMessages();
            return;
        }
        if (self.fiIdHanghoa() == null || self.fiIdHanghoa() == "") {
            var hanghoa = new Tbdhanghoa(self.lstHanghoa11().length + 1,
                    -1 * new Date().getTime(),
                    self.fiTenHh(),
                    self.fiTenKh(),
                    self.fiCososx(),
                    self.fiMaCososx(),
                    self.fiDiachiCssx(),
                    self.fiSoluong(),
                    self.fiMadvSl(),
                    self.fiTendvSl(),
                    self.fiKlTinh(),
                    self.fiMadvKlt(),
                    self.fiTendvKlt(),
                    self.fiKlBi(),
                    self.fiMadvBi(),
                    self.fiTendvBi(),
                    self.fiMahs(),
                    self.fiSohd(),
                    self.fiMasp());
            self.lstHanghoa11.push(hanghoa);
        } else {
            // Tìm phần tử và cập nhập
            var index = self.lstHanghoa11.firstIndexOf(function (item) {
                return item.fiIdHanghoa() == self.fiIdHanghoa();
            });
            if (index >= 0) {
                self.lstHanghoa11()[index].fiTenHh(self.fiTenHh());
                self.lstHanghoa11()[index].fiTenKh(self.fiTenKh());
                self.lstHanghoa11()[index].fiCososx(self.fiCososx());
                self.lstHanghoa11()[index].fiMaCososx(self.fiMaCososx());
                self.lstHanghoa11()[index].fiDiachiCssx(self.fiDiachiCssx());
                self.lstHanghoa11()[index].fiSoluong(self.fiSoluong());
                self.lstHanghoa11()[index].fiKlTinh(self.fiKlTinh());
                self.lstHanghoa11()[index].fiKlBi(self.fiKlBi());
                if (self.fiSoluong()) {
                    self.lstHanghoa11()[index].fiMadvSl(self.fiMadvSl());
                    self.lstHanghoa11()[index].fiTendvSl(self.fiTendvSl());
                }
                if (self.fiKlTinh()) {
                    self.lstHanghoa11()[index].fiMadvKlt(self.fiMadvKlt());
                    self.lstHanghoa11()[index].fiTendvKlt(self.fiTendvKlt());
                } else {
                    self.lstHanghoa11()[index].fiMadvKlt(null);
                    self.lstHanghoa11()[index].fiTendvKlt(null);
                }
                self.lstHanghoa11()[index].fiKlBi(self.fiKlBi());
                if (self.fiKlBi()) {
                    self.lstHanghoa11()[index].fiMadvBi(self.fiMadvBi());
                    self.lstHanghoa11()[index].fiTendvBi(self.fiTendvBi());
                } else {
                    self.lstHanghoa11()[index].fiMadvBi(null);
                    self.lstHanghoa11()[index].fiTendvBi(null);
                }
                self.lstHanghoa11()[index].fiMahs(self.fiMahs());
                self.lstHanghoa11()[index].fiMasp(self.fiMasp());
                self.lstHanghoa11()[index].fiSohd(self.fiSohd());
            }
        }

        self.fiIdHanghoa(null);
        self.fiTenHh(null);
        self.fiTenKh(null);
        self.fiCososx(null);
        self.fiMaCososx(null);
        self.fiDiachiCssx(null);
        self.fiSoluong(null);
        self.fiMadvSl(null);
        self.fiTendvSl(null);
        self.fiKlTinh(null);
        self.fiMadvKlt(null);
        self.fiTendvKlt(null);
        self.fiKlBi(null);
        self.fiMadvBi(null);
        self.fiTendvBi(null);
        self.fiMahs(null);
        self.fiMasp(null);
        self.fiSohd(null);
        self.hanghoaErrors.showAllMessages(false);
    };

    /**
     * Ấn nút sửa hàng hóa
     * @param {type} item
     * @returns {undefined}
     */
    self.bSuaHhClick = function (item) {
        if (!item.fiIdHanghoa()) {
            item.fiIdHanghoa(-1 * new Date().getTime());
        }
        self.fiIdHanghoa(item.fiIdHanghoa());
        self.fiTenHh(item.fiTenHh());
        self.fiTenKh(item.fiTenKh());
        self.fiCososx(item.fiCososx());
        self.fiSoluong(item.fiSoluong());
        self.fiMadvSl(item.fiMadvSl());
        if (item.fiTendvSl()) {
            self.fiTendvSl(item.fiTendvSl());
        } else if ($('#fiMadvSl option:selected').text()) {
            self.fiTendvSl($('#fiMadvSl option:selected').text());
        } else {
            self.fiMadvSl(null);
        }
        self.fiKlTinh(item.fiKlTinh());
        self.fiMadvKlt(item.fiMadvKlt());
        if (item.fiTendvKlt()) {
            self.fiTendvKlt(item.fiTendvKlt());
        } else if ($('#fiMadvKlt option:selected').text()) {
            self.fiTendvKlt($('#fiMadvKlt option:selected').text());
        } else {
            self.fiMadvKlt(null);
        }
        self.fiKlBi(item.fiKlBi());
        self.fiMadvBi(item.fiMadvBi());
        if (item.fiTendvBi()) {
            self.fiTendvBi(item.fiTendvBi());
        } else if ($('#fiMadvBi option:selected').text()) {
            self.fiTendvBi($('#fiMadvBi option:selected').text());
        } else {
            self.fiMadvBi(null);
        }
        //self.fiLoaiBb(item.fiLoaiBb());
        self.fiSohd(item.fiSohd());
        self.fiDiachiCssx(item.fiDiachiCssx());
        self.fiMahs(item.fiMahs());
        self.fiMasp(item.fiMasp());
        self.fiMaCososx(item.fiMaCososx());
    };

    /**
     * Xóa hàng hóa
     * @param {type} item
     * @returns {undefined}
     */
    self.bXoaHhClick = function (item) {
        if (item) {
            self.lstHanghoa11.remove(function (hh) {
                return hh.fiIdHanghoa() == item.fiIdHanghoa();
            });
        }
    };

    /**
     * Chọn quốc gia, đưa ra cửa khẩu
     * @returns {undefined}
     */
    self.fiMaqgNkChange = function () {
        if (self.fiMaqgNk()) {
            getCategory("CUAKHAU", self.fiMaqgNk(), function (res) {
                if (res.success) {
                    self.fiMackNkList(mapCategory(res.data, "portcode", "portname"));
                }
            });
        } else {
            self.fiMackNkList([]);
        }
    };

    self.errorHanghoaText = ko.observable("");

    self.isValidForm = function () {
        //console.log("self.errors -> ", self.hosoErrors());
        self.errorHanghoaText("");
        // Xóa bỏ thành phần có chứa cookie, knockout sẽ bị lỗi
        delete self.pop;
        //console.log("self -> ", self);
        if (self.hosoErrors().length > 0) {
            self.hosoErrors.showAllMessages();
        }
        var errorHanghoa = false;
        if (!self.lstHanghoa11() || self.lstHanghoa11().length <= 0) {
            self.errorHanghoaText('* Chưa khai báo hàng hóa');
            return false;//errorHanghoa;
        }
//        if(self.lstHanghoa11() && self.lstHanghoa11().length > 0){
//            for(var i = 0; i < self.lstHanghoa11().length; i++){
//                var hh = self.lstHanghoa11()[i];
//                if(!hh.fiTendvSl()){
//                    hh.fiTendvSl(hh.fiMadvSl());
//                }
//                if(!hh.fiTenHh() || !hh.fiCososx() || !hh.fiSoluong() || !hh.fiMadvSl() || !hh.fiTendvSl()){
//                    errorHanghoa = true;
//                    break;
//                }
//            }
//        }
        if (errorHanghoa) {
            self.errorHanghoaText('* Bổ sung thêm thông tin của hàng hóa trước khi lưu dữ liệu');
        }
        return self.hosoErrors().length <= 0 && !errorHanghoa;
    };

    self.toJSON = function () {
        var exclude = ["hosoErrors", "errorHanghoaText", "hanghoaErrors", "fiMadvSlList", "fiMaDvgsList", "fiMadvKltList", "fiMadvBiList", "fiMaqgNkList", "fiMackXkList", "fiMackNkList", "updateHanghoaClick", "bSuaHhClick", "bXoaHhClick", "chooseDocumentClick", "selectedDocumentClick", "toJSON", "fiMadvXlList"];
        var copy = ko.toJS(self);
        for (var key in copy) {
            if (exclude.indexOf(key) >= 0) {
                delete copy[key];
            }
        }
        if (copy.lstHanghoa11 && copy.lstHanghoa11.length > 0) {
            for (var i = 0; i < copy.lstHanghoa11.length; i++) {
                delete copy.lstHanghoa11[i]["bSua"];
                delete copy.lstHanghoa11[i]["bXoa"];
            }
        }
        return copy;
    };
    if (options && options.hoso) {
        ko.mapping.fromJS(options.hoso, {}, self);
    }
    var hoso = options && options.hoso ? options.hoso : {};
    self.lstHanghoa11 = ko.observableArray(hoso && hoso.lstHanghoa11 ? mapTbdhanghoa11(hoso.lstHanghoa11) : null);
    self.fiIdHoso = ko.observable(hoso.fiIdHoso);
    self.fiMaHoso = ko.observable(hoso.fiMaHoso);
    self.fiTrangthai = ko.observable(hoso.fiTrangthai);
    self.fiNgaytao = ko.observable(hoso && hoso.fiNgaytao ? new Date(hoso.fiNgaytao) : new Date());
    self.fiNguoitao = ko.observable(hoso.fiNguoitao);

    self.fiMadvXl = ko.observable(hoso.fiMadvXl).extend({
        required: {message: 'Thông tin phải nhập', params: true},
        maxLength: {message: 'Tối đa 50 ký tự', params: 50}
    });
    self.fiTendvXl = ko.observable(hoso.fiTendvXl).extend({
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiMadvXlList = ko.observable([]);

    self.fiDtDangky = ko.observable(hoso.fiDtDangky ? hoso.fiDtDangky : user.companyName).extend({
        required: {message: 'Thông tin phải nhập', params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiSodt = ko.observable(hoso.fiSodt ? hoso.fiSodt : user.companyPhoneNumber).extend({
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiDiachi = ko.observable(hoso.fiDiachi ? hoso.fiDiachi : user.companyAddress).extend({
        required: {message: 'Thông tin phải nhập', params: true},
        maxLength: {message: 'Tối đa 500 ký tự', params: 500}
    });
    self.fiEmail = ko.observable(hoso.fiEmail ? hoso.fiEmail : user.companyEmail).extend({
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiSocmnd = ko.observable(hoso.fiSocmnd).extend({
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiNgaycmnd = ko.observable(hoso.fiNgaycmnd ? new Date(hoso.fiNgaycmnd) : null).extend({
    });
    self.fiNoicmnd = ko.observable(hoso.fiNoicmnd).extend({
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });

    // - Bat dau phan hang hoa
    self.fiIdHanghoa = ko.observable();
    self.fiTenHh = ko.observable(hoso.fiTenHh).extend({
        required: {message: 'Thông tin phải nhập', params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiTenKh = ko.observable(hoso.fiTenKh).extend({
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiCososx = ko.observable(hoso.fiCososx).extend({
        required: {message: 'Thông tin phải nhập', params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiMaCososx = ko.observable(hoso.fiMaCososx).extend({
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiDiachiCssx = ko.observable(hoso.fiMaCososx).extend({
        required: {message: 'Thông tin phải nhập', params: true},
        maxLength: {message: 'Tối đa 500 ký tự', params: 500}
    });
    self.fiMadvSl = ko.observable(hoso.fiMadvSl).extend({
        maxLength: {message: 'Tối đa 16 ký tự', params: 16}
    });
    self.fiTendvSl = ko.observable(hoso.fiTendvSl).extend({
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiSoluong = ko.observable(hoso.fiSoluong).extend({
        number: {message: 'Phải nhập số', params: true},
        pattern: {
            message: 'Phải nhập giá trị với tối đa 3 số ở phần thập phân ví dụ: 1.234',
            params: '^[0-9]{0,15}(?:\.[0-9]{0,3})?$'
        },
        validation: {
            validator: function (val) {
                if (!val) {
                    return true;
                }
                return val && self.fiMadvSl();
            },
            message: 'Phải nhập đơn vị tính'
        }
    });
    self.fiMadvSlList = ko.observableArray([]);

    self.fiMadvKlt = ko.observable(hoso.fiMadvKlt).extend({
        maxLength: {message: 'Tối đa 18 ký tự', params: 18}
    });
    self.fiTendvKlt = ko.observable(hoso.fiTendvKlt).extend({
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiKlTinh = ko.observable(hoso.fiKlTinh).extend({
        number: {message: 'Phải nhập số', params: true},
        pattern: {
            message: 'Phải nhập giá trị với tối đa 3 số ở phần thập phân ví dụ: 1.234',
            params: '^[0-9]{0,15}(?:\.[0-9]{0,3})?$'
        },
        validation: {
            validator: function (val) {
                if (!val) {
                    return true;
                }
                return val && self.fiMadvKlt();
            },
            message: 'Phải nhập đơn vị tính'
        }
    });
    self.fiMadvKltList = ko.observableArray([]);

    self.fiMadvBi = ko.observable(hoso.fiMadvBi).extend({
        maxLength: {message: 'Tối đa 18 ký tự', params: 18}
    });
    self.fiTendvBi = ko.observable(hoso.fiTendvBi).extend({
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiKlBi = ko.observable(hoso.fiKlBi).extend({
        number: {message: 'Phải nhập số', params: true},
        pattern: {
            message: 'Phải nhập giá trị với tối đa 3 số ở phần thập phân ví dụ: 1.234',
            params: '^[0-9]{0,15}(?:\.[0-9]{0,3})?$'
        },
        validation: {
            validator: function (val) {
                if (!val) {
                    return true;
                }
                return val && self.fiMadvBi();
            },
            message: 'Phải nhập đơn vị tính'
        }
    });
    self.fiMadvBiList = ko.observableArray([]);

    self.fiMahs = ko.observable(hoso.fiMahs).extend({
        maxLength: {message: 'Tối đa 12 ký tự', params: 12}
    });

    self.fiMasp = ko.observable(hoso.fiMasp).extend({
        maxLength: {message: 'Tối đa 18 ký tự', params: 18}
    });
    self.fiSohd = ko.observable(hoso.fiSohd).extend({
        maxLength: {message: 'Tối đa 50 ký tự', params: 50}
    });
    // -- Het phan hang hoa

    self.fiDtXk = ko.observable(hoso.fiDtXk ? hoso.fiDtXk : user.companyName).extend({
        required: {message: 'Thông tin phải nhập', params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiDiachidtxk = ko.observable(hoso.fiDiachidtxk ? hoso.fiDiachidtxk : user.companyAddress).extend({
        required: {message: 'Thông tin phải nhập', params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiPtCc = ko.observable(hoso.fiPtCc).extend({
        required: {message: 'Thông tin phải nhập', params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiMackXk = ko.observable(hoso.fiMackXk).extend({
        required: {message: 'Thông tin phải nhập', params: true},
        maxLength: {message: 'Tối đa 6 ký tự', params: 6}
    });
    self.fiTenckXk = ko.observable(hoso.fiTenckXk).extend({
        required: {message: 'Thông tin phải nhập', params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiMackXkList = ko.observableArray([]);

    self.fiDtNk = ko.observable(hoso.fiDtNk).extend({
        required: {message: 'Thông tin phải nhập', params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });

    self.fiDiachidtnk = ko.observable(hoso.fiDiachidtnk).extend({
        required: {message: 'Thông tin phải nhập', params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });

    self.fiMaqgNk = ko.observable(hoso.fiMaqgNk).extend({
        required: {message: 'Thông tin phải nhập', params: true},
        maxLength: {message: 'Tối đa 6 ký tự', params: 6}
    });
    self.fiTenqgNk = ko.observable(hoso.fiTenqgNk).extend({
        required: {message: 'Thông tin phải nhập', params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiMaqgNkList = ko.observable([]);

    self.fiMackNk = ko.observable(hoso.fiMackNk).extend({
        required: {message: 'Thông tin phải nhập', params: true},
        maxLength: {message: 'Tối đa 6 ký tự', params: 6}
    });
    self.fiTenckNk = ko.observable(hoso.fiTenckNk).extend({
        required: {message: 'Thông tin phải nhập', params: true},
        maxLength: {message: 'Tối đa 255 ký tự', params: 255}
    });
    self.fiMackNkList = ko.observableArray([]);

    self.fiMucdichsd = ko.observable(hoso.fiMucdichsd).extend({
        required: {message: 'Thông tin phải nhập', params: true},
        maxLength: {message: 'Tối đa 500 ký tự', params: 500}
    });

    self.fiDiadiemdk = ko.observable(hoso.fiDiadiemdk).extend({
        required: {message: 'Thông tin phải nhập', params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiThoigiandk = ko.observable(hoso.fiThoigiandk ? new Date(hoso.fiThoigiandk) : null).extend({
        required: {message: 'Thông tin phải nhập', params: true}
    });
    self.fiDdTgGs = ko.observable(hoso.fiDdTgGs).extend({
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });

    self.fiSobangcn = ko.observable(hoso.fiSobangcn).extend({
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiNoiky = ko.observable(hoso.fiNoiky).extend({
        required: {message: 'Thông tin phải nhập', params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiNgayky = ko.observable(hoso && hoso.fiNgayky ? new Date(hoso.fiNgayky) : null).extend({
        required: {message: 'Thông tin phải nhập', params: true}
    });
    self.fiNguoiky = ko.observable(hoso.fiNguoiky).extend({
        required: {message: 'Thông tin phải nhập', params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiTenHanghoa = ko.computed(function () {
        if (self.lstHanghoa11().length > 0) {
            var name = "";
            for (var i = 0; i < self.lstHanghoa11().length; i++) {
                name += (name == "" ? self.lstHanghoa11()[i].fiTenHh() : ", " + self.lstHanghoa11()[i].fiTenHh());
            }
            if (name.length > 255) {
                name = name.substr(0, 252) + "...";
            }
            return name;
        }
    }, self);

    self.fiNguoiCn = ko.observable(hoso.fiNguoiCn);
    self.fiNguoitao = ko.observable(hoso.fiNguoitao);
    self.fiTrangthaiText = ko.dependentObservable(function () {
        if (RAW_HS_STATUS) {
            for (var i = 0; i < RAW_HS_STATUS.length; i++) {
                if (RAW_HS_STATUS[i].id == self.fiTrangthai()) {
                    return RAW_HS_STATUS[i].name;
                }
            }
            return "Tạo mới";
        }
    }, self);

    var hosoVG = [self.fiMadvXl, self.fiTendvXl, self.fiDtDangky, self.fiSodt, self.fiDiachi,
        self.fiEmail, self.fiSocmnd, self.fiNoicmnd, self.fiDtXk, self.fiDiachidtxk,
        self.fiPtCc, self.fiMackXk, self.fiTenckXk, self.fiDtNk, self.fiDiachidtnk,
        self.fiMaqgNk, self.fiTenqgNk, self.fiMackNk, self.fiTenckNk, self.fiMucdichsd,
        self.fiDiadiemdk, self.fiThoigiandk, self.fiDdTgGs, self.fiSobangcn, self.fiNoiky,
        self.fiNgayky, self.fiNguoiky];
    self.hosoErrors = ko.validation.group(hosoVG, {deep: true, live: true, observable: true});
    var hanghoaVG = [self.fiTenHh, self.fiTenKh, self.fiCososx, self.fiMaCososx, self.fiDiachiCssx,
        self.fiMadvSl, self.fiTendvSl, self.fiSoluong, self.fiMadvKlt, self.fiTendvKlt, self.fiKlTinh,
        self.fiMadvBi, self.fiTendvBi, self.fiKlBi, self.fiMahs, self.fiSohd, self.fiMasp];
    self.hanghoaErrors = ko.validation.group(hanghoaVG, {deep: true, live: true, observable: true});

    getCategory("SOLUONG", null, function (res) {
        if (res.success) {
            self.fiMadvSlList(mapCategory(res.data, "unitcode", "unitname"));
        }
    });

    getCategory("TRONGLUONG", null, function (res) {
        if (res.success) {
            self.fiMadvKltList(mapCategory(res.data, "unitcode", "unitname"));
            self.fiMadvBiList(mapCategory(res.data, "unitcode", "unitname"));
        }
    });

    getCategory("QUOCGIA", null, function (res) {
        if (res.success) {
            self.fiMaqgNkList(mapCategory(res.data, "statecode", "name"));
            if (hoso.fiMaqgNk) {
                self.fiMaqgNk(hoso.fiMaqgNk);
                self.fiTenqgNk(hoso.fiTenqgNk);
            }
            if (self.fiMaqgNk()) {
                getCategory("CUAKHAU", self.fiMaqgNk(), function (res) {
                    if (res.success) {
                        self.fiMackNkList(mapCategory(res.data, "portcode", "portname"));
                        if (hoso.fiMackNk) {
                            self.fiMackNk(hoso.fiMackNk);
                            self.fiTenckNk(hoso.fiTenckNk);
                        }
                    }
                });
            } else {
                self.fiMackNkList([]);
            }
        }
    });

    getCategory("DVKD", null, function (res) {
        if (res.success) {
            self.fiMadvXlList(mapCategory(res.data, "dvkdCode", "dvkdName"));
            if (hoso.fiMadvXl) {
                self.fiMadvXl(hoso.fiMadvXl);
                self.fiTendvXl(hoso.fiTendvXl);
            }
        }
    });

    getCategory("CUAKHAU", "VN", function (res) {
        if (res.success) {
            self.fiMackXkList(mapCategory(res.data, "portcode", "portname"));
            if (hoso.fiMackXk) {
                self.fiMackXk(hoso.fiMackXk);
                self.fiTenckXk(hoso.fiTenckXk);
            }
        }
    });
}
;

