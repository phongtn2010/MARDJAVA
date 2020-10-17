/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* global CSRF_TOKEN_NAME, CSRF_TOKEN_VALUE, fiIdHoso, fiMaHoso, History, app */

ko.validation.rules.pattern.message = 'Invalid.';
ko.validation.init({
    registerExtenders: true,
    messagesOnModified: true,
    insertMessages: true,
    parseInputAttributes: true,
    messageTemplate: null
}, true);
var CreateGCNVM = function(options){
    
    var self = this;
    
    self.updateHanghoaClick = function(){
        //console.log("self.gcnHanghoaErrors() -> ", self.gcnHanghoaErrors());
        if(self.gcnHanghoaErrors().length > 0){
            self.gcnHanghoaErrors.showAllMessages();
            return;
        }
        if (self.hh_fiIdHh() == null || self.hh_fiIdHh() == "") {
            var hanghoa = new TbdhhGcn11(self.tbdhhgcn11().length + 1, 
                                        -1 * new Date().getTime(), 
                                        self.hh_fiTenHh(),
                                        self.hh_fiTenKh(),
                                        self.hh_fiMadvSl(),
                                        self.hh_fiTendvSl(),
                                        self.hh_fiSoluong(),
                                        self.hh_fiMadvKl(),
                                        self.hh_fiTendvKl(),
                                        self.hh_fiKhoiluong(),
                                        self.hh_fiMadvBi(),
                                        self.hh_fiTendvBi(),
                                        self.hh_fiKlbi(),
                                        self.hh_fiMadvTt(),
                                        self.hh_fiTendvTt(),
                                        self.hh_fiThetich(),
                                        self.hh_fiMadvTtbi(),
                                        self.hh_fiTendvTtbi(),
                                        self.hh_fiThetichbi());
            self.tbdhhgcn11.push(hanghoa);
        } else {
            // Tìm phần tử và cập nhập
            var index = self.tbdhhgcn11.firstIndexOf(function (item) {
                return item.fiIdHh() == self.hh_fiIdHh();
            });
            if (index >= 0) {
                self.tbdhhgcn11()[index].fiTenHh(self.hh_fiTenHh());
                self.tbdhhgcn11()[index].fiTenKh(self.hh_fiTenKh());
                self.tbdhhgcn11()[index].fiSoluong(self.hh_fiSoluong());
                if(self.hh_fiSoluong()){
                    self.tbdhhgcn11()[index].fiMadvSl(self.hh_fiMadvSl());
                    self.tbdhhgcn11()[index].fiTendvSl(self.hh_fiTendvSl());
                }
                else{
                    self.tbdhhgcn11()[index].fiMadvSl(null);
                    self.tbdhhgcn11()[index].fiTendvSl(null);
                }
                self.tbdhhgcn11()[index].fiKhoiluong(self.hh_fiKhoiluong());
                if(self.hh_fiKhoiluong()){
                    self.tbdhhgcn11()[index].fiMadvKl(self.hh_fiMadvKl());
                    self.tbdhhgcn11()[index].fiTendvKl(self.hh_fiTendvKl());
                }
                else{
                    self.tbdhhgcn11()[index].fiMadvKl(null);
                    self.tbdhhgcn11()[index].fiTendvKl(null);
                }
                self.tbdhhgcn11()[index].fiKlbi(self.hh_fiKlbi());
                if(self.hh_fiKlbi()){
                    self.tbdhhgcn11()[index].fiMadvBi(self.hh_fiMadvBi());
                    self.tbdhhgcn11()[index].fiTendvBi(self.hh_fiTendvBi());
                }
                else{
                    self.tbdhhgcn11()[index].fiMadvBi(null);
                    self.tbdhhgcn11()[index].fiTendvBi(null);
                }
                self.tbdhhgcn11()[index].fiThetich(self.hh_fiThetich());
                if(self.hh_fiThetich()){
                    self.tbdhhgcn11()[index].fiMadvTt(self.hh_fiMadvTt());
                    self.tbdhhgcn11()[index].fiTendvTt(self.hh_fiTendvTt());
                }
                else{
                    self.tbdhhgcn11()[index].fiMadvTt(null);
                    self.tbdhhgcn11()[index].fiTendvTt(null);
                }
                self.tbdhhgcn11()[index].fiThetichbi(self.hh_fiThetichbi());
                if(self.hh_fiThetichbi()){
                    self.tbdhhgcn11()[index].fiMadvTtbi(self.hh_fiMadvTtbi());
                    self.tbdhhgcn11()[index].fiTendvTtbi(self.hh_fiTendvTtbi());
                }
                else{
                    self.tbdhhgcn11()[index].fiMadvTtbi(null);
                    self.tbdhhgcn11()[index].fiTendvTtbi(null);
                }
            }
        }

        self.hh_fiIdHh(null);
        self.hh_fiTenHh(null);
        self.hh_fiTenKh(null);
        self.hh_fiMadvSl(null);
        self.hh_fiTendvSl(null);
        self.hh_fiSoluong(null);
        self.hh_fiMadvKl(null);
        self.hh_fiTendvKl(null);
        self.hh_fiKhoiluong(null);
        self.hh_fiMadvBi(null);
        self.hh_fiTendvBi(null);
        self.hh_fiKlbi(null);
        self.hh_fiMadvTt(null);
        self.hh_fiTendvTt(null);
        self.hh_fiThetich(null);
        self.hh_fiMadvTtbi(null);
        self.hh_fiTendvTtbi(null);
        self.hh_fiThetichbi(null);
        self.gcnHanghoaErrors.showAllMessages(false);
        
    };
    
    self.bSuaHhClick = function(item){
        if(!item.fiIdHh()){
            item.fiIdHh(-1 * new Date().getTime());
        }
        self.hh_fiIdHh(item.fiIdHh());
        self.hh_fiTenHh(item.fiTenHh());
        self.hh_fiTenKh(item.fiTenKh());
        self.hh_fiSoluong(item.fiSoluong());
        self.hh_fiMadvSl(item.fiMadvSl());
        if(item.fiTendvSl()){
            self.hh_fiTendvSl(item.fiTendvSl());
        }
        else if($('#fiMadvSl option:selected').text()){
            self.hh_fiTendvSl($('#fiMadvSl option:selected').text());
        }
        else{
            self.hh_fiMadvSl(null);
        }
        self.hh_fiKhoiluong(item.fiKhoiluong());
        self.hh_fiMadvKl(item.fiMadvKl());
        if(item.fiTendvKl()){
            self.hh_fiTendvKl(item.fiTendvKl());
        }
        else if($('#hh_fiMadvKl option:selected').text()){
            self.hh_fiTendvKl($('#hh_fiMadvKl option:selected').text());
        }
        else{
            self.hh_fiMadvKl(null);
        }
        self.hh_fiKlbi(item.fiKlbi());
        self.hh_fiMadvBi(item.fiMadvBi());
        if(item.fiTendvBi()){
            self.hh_fiTendvBi(item.fiTendvBi());
        }
        else if($('#hh_fiMadvBi option:selected').text()){
            self.hh_fiTendvBi($('#hh_fiMadvBi option:selected').text());
        }
        else{
            self.hh_fiMadvBi(null);
        }
        
        self.hh_fiThetich(item.fiThetich());
        self.hh_fiMadvTt(item.fiMadvTt());
        if(item.fiTendvTt()){
            self.hh_fiTendvTt(item.fiTendvBi());
        }
        else if($('#hh_fiMadvTt option:selected').text()){
            self.hh_fiTendvTt($('#hh_fiMadvTt option:selected').text());
        }
        else{
            self.hh_fiMadvTt(null);
        }
        
        self.hh_fiThetichbi(item.fiThetichbi());
        self.hh_fiMadvTtbi(item.fiMadvTtbi());
        if(item.fiTendvTtbi()){
            self.hh_fiTendvTtbi(item.fiTendvBi());
        }
        else if($('#hh_fiMadvBi option:selected').text()){
            self.hh_fiTendvTtbi($('#hh_fiMadvBi option:selected').text());
        }
        else{
            self.hh_fiMadvTtbi(null);
        }
    };
    self.bXoaHhClick = function(item){
        if (item) {
            self.tbdhhgcn11.remove(function (hh) {
                return hh.fiIdHh() == item.fiIdHh();
            });
        }
    };
    
    if(options && options.gcn11){
        ko.mapping.fromJS(options.gcn11, {}, self);
    }
    var gcn11 = options && options.gcn11? options.gcn11 : {};
    
    self.errorHanghoaText  = ko.observable();
    self.tbdhhgcn11 = ko.observableArray(gcn11 && gcn11.tbdhhgcn11 ? mapTbdhhgcn11(gcn11.tbdhhgcn11) : null);
    
    self.fiIdGcn = ko.observable(gcn11.fiIdGcn);
    
    self.fiLoaiCtList = ko.observableArray(mapCategory([{"id" : 1, "name" : "Kiểm dịch thực vật xuất khẩu"},{"id" : 2, "name" : "Kiểm dịch thực vật tái xuất khẩu"}],"id", "name"));
    self.fiLoaiCt = ko.observable(gcn11.fiLoaiCt).extend({
        required: { message: 'Thông tin phải nhập', params : true}
    });
    self.fiTenLoaiCt = ko.observable(gcn11.fiTenLoaiCt).extend({
        maxLength: { message: '250 ký tự', params : 250}
    });
    
    self.fiManuocXk = ko.observable(gcn11.fiManuocXk).extend({
        required: { message: 'Thông tin phải nhập', params : true}
    });
    self.fiTennuocXk = ko.observable(gcn11.fiTennuocXk).extend({
        required: { message: 'Thông tin phải nhập', params : true}
    });
    self.fiManuocXkList = ko.observableArray([]);
    self.fiManuocQc = ko.observable(gcn11.fiManuocQc);    
    self.fiTennuocQc = ko.observable(gcn11.fiTennuocQc);
    
    self.fiManuocQcList = ko.observableArray([]);
//    self.fiSoGcn = ko.observable(gcn11.fiSoGcn).extend({
//        required: { message: 'Thông tin phải nhập', params : true},
//        maxLength: { message: '50 ký tự', params : 50}
//    });
    self.fiNguoiXk = ko.observable(gcn11.fiNguoiXk).extend({
        required: { message: 'Thông tin phải nhập', params : true},
        maxLength: { message: '500 ký tự', params : 500}
    });
    self.fiDiachiXk = ko.observable(gcn11.fiDiachiXk).extend({
        required: { message: 'Thông tin phải nhập', params : true},
        maxLength: { message: '500 ký tự', params : 500}
    });
    self.fiTenNn = ko.observable(gcn11.fiTenNn).extend({
        required: { message: 'Thông tin phải nhập', params : true},
        maxLength: { message: '500 ký tự', params : 500}
    });
    self.fiDiachiNn = ko.observable(gcn11.fiDiachiNn).extend({
        required: { message: 'Thông tin phải nhập', params : true},
        maxLength: { message: '500 ký tự', params : 500}
    });
    self.fiSoluong = ko.observable(gcn11.fiSoluong).extend({
        required: { message: 'Thông tin phải nhập', params : true},
        maxLength: { message: '19 ký tự', params : 19},
        number: { message: 'Phải nhập số', params : true},
        pattern: {
            message: 'Phải nhập giá trị với tối đa 3 số ở phần thập phân ví dụ: 1.234',
            params: '^[0-9]{0,15}(?:\.[0-9]{0,3})?$'
        }
    });
    self.fiMabaobi = ko.observable(gcn11.fiMabaobi).extend({
        required: { message: 'Thông tin phải nhập', params : true}
    });
    self.fiTenbaobi = ko.observable(gcn11.fiTenbaobi).extend({
        required: { message: 'Thông tin phải nhập', params : true}
    });
    self.fiMabaobiList = ko.observableArray([]);
    self.fiHienthi = ko.observable(gcn11.fiHienthi).extend({
        required: { message: 'Thông tin phải nhập', params : true},
        maxLength: { message: '255 ký tự', params : 255}
    });
    self.fiQuycachDg = ko.observable(gcn11.fiQuycachDg).extend({
        required: { message: 'Thông tin phải nhập', params : true}
    });
    self.fiTenQuycachDg = ko.observable(gcn11.fiTenQuycachDg).extend({
        maxLength: { message: '250 ký tự', params : 250}
    });
    self.fiQuycachDgList = ko.observableArray([]);
    self.fiMakyhieu = ko.observable(gcn11.fiMakyhieu).extend({
        maxLength: { message: '500 ký tự', params : 500}
    });
    self.fiTenNsx = ko.observable(gcn11.fiTenNsx).extend({
        maxLength: { message: '35 ký tự', params : 35}
    });
    self.fiDiachiNsx = ko.observable(gcn11.fiDiachiNsx).extend({
        maxLength: { message: '250 ký tự', params : 250}
    });
    self.fiManuocSx = ko.observable(gcn11.fiManuocSx ? gcn11.fiManuocSx : "VN").extend({
        required: { message: 'Thông tin phải nhập', params : true}
    });
    self.fiTennuocSx = ko.observable(gcn11.fiTennuocSx ?gcn11.fiTennuocSx : "VIETNAM").extend({
        required: { message: 'Thông tin phải nhập', params : true}
    });
    self.fiManuocSxList = ko.observableArray([]);
    self.fiMatinh = ko.observable(gcn11.fiMatinh).extend({
        maxLength: { message: '2 ký tự', params : 2}
    });
    self.fiTentinh = ko.observable(gcn11.fiTentinh);
    self.fiMatinhList = ko.observableArray([]);
    self.fiHtcc = ko.observable(gcn11.fiHtcc).extend({
        required: { message: 'Thông tin phải nhập', params : true}
    });
    self.fiTenHtcc = ko.observable(gcn11.fiTenHtcc).extend({
        maxLength: { message: '250 ký tự', params : 250}
    });
    self.fiHtccList = ko.observableArray([]);
    self.fiPtcc = ko.observable(gcn11.fiPtcc).extend({
        maxLength: { message: '250 ký tự', params : 250}
    });
    self.fiSohieuPt = ko.observable(gcn11.fiSohieuPt).extend({
        maxLength: { message: '250 ký tự', params : 250}
    });
    self.fiCkNhap = ko.observable(gcn11.fiCkNhap).extend({
        required: { message: 'Thông tin phải nhập', params : true},
        maxLength: { message: '250 ký tự', params : 250}
    });
    
    // --- Bắt đầu phần hàng hóa---
    self.hh_fiIdHh = ko.observable();
    self.hh_fiTenHh = ko.observable().extend({
        required: { message: 'Thông tin phải nhập', params : true},
        maxLength: { message: '500 ký tự', params : 500}
    });
    self.hh_fiTenKh = ko.observable().extend({
        maxLength: { message: '500 ký tự', params : 500}
    });
    self.hh_fiSoluong = ko.observable().extend({
        number: { message: 'Phải nhập số', params : true},
        pattern: {
            message: 'Phải nhập giá trị với tối đa 3 số ở phần thập phân ví dụ: 1.234',
            params: '^[0-9]{0,15}(?:\.[0-9]{0,3})?$'
        },
        validation: {
            validator: function (val) {
                if(!val){
                    return true;
                }
                return val && self.hh_fiMadvSl();
            },
            message: 'Phải nhập đơn vị'
        }
    });
    self.hh_fiMadvSl = ko.observable();
    self.hh_fiTendvSl = ko.observable();
    self.hh_fiMadvSlList = ko.observableArray([]);
    self.hh_fiKhoiluong = ko.observable().extend({
        number: { message: 'Phải nhập số', params : true},
        pattern: {
            message: 'Phải nhập giá trị với tối đa 3 số ở phần thập phân ví dụ: 1.234',
            params: '^[0-9]{0,15}(?:\.[0-9]{0,3})?$'
        },
        validation: {
            validator: function (val) {
                if(!val){
                    return true;
                }
                return val && self.hh_fiMadvKl();
            },
            message: 'Phải nhập đơn vị'
        }
    });
    self.hh_fiMadvKl = ko.observable();
    self.hh_fiTendvKl = ko.observable();
    self.hh_fiMadvKlList = ko.observableArray([]);
    self.hh_fiKlbi = ko.observable().extend({
        number: { message: 'Phải nhập số', params : true},
        pattern: {
            message: 'Phải nhập giá trị với tối đa 3 số ở phần thập phân ví dụ: 1.234',
            params: '^[0-9]{0,15}(?:\.[0-9]{0,3})?$'
        },
        validation: {
            validator: function (val) {
                if(!val){
                    return true;
                }
                return val && self.hh_fiMadvBi();
            },
            message: 'Phải nhập đơn vị'
        }
    });
    self.hh_fiMadvBi = ko.observable();
    self.hh_fiTendvBi = ko.observable();
    self.hh_fiMadvBiList = ko.observableArray([]);
    self.hh_fiThetich = ko.observable().extend({
        number: { message: 'Phải nhập số', params : true},
        pattern: {
            message: 'Phải nhập giá trị với tối đa 3 số ở phần thập phân ví dụ: 1.234',
            params: '^[0-9]{0,15}(?:\.[0-9]{0,3})?$'
        },
        validation: {
            validator: function (val) {
                if(!val){
                    return true;
                }
                return val && self.hh_fiMadvTt();
            },
            message: 'Phải nhập đơn vị'
        }
    });
    self.hh_fiMadvTt = ko.observable();
    self.hh_fiTendvTt = ko.observable();
    self.hh_fiMadvTtList = ko.observableArray([]);
    self.hh_fiThetichbi = ko.observable().extend({
        number: { message: 'Phải nhập số', params : true},
        pattern: {
            message: 'Phải nhập giá trị với tối đa 3 số ở phần thập phân ví dụ: 1.234',
            params: '^[0-9]{0,15}(?:\.[0-9]{0,3})?$'
        },
        validation: {
            validator: function (val) {
                if(!val){
                    return true;
                }
                return val && self.hh_fiMadvTtbi();
            },
            message: 'Phải nhập đơn vị'
        }
    });
    self.hh_fiMadvTtbi = ko.observable();
    self.hh_fiTendvTtbi = ko.observable();
    self.hh_fiMadvTtbiList = ko.observableArray([]);
    //--- Kết thúc phần hàng hóa---
    
    self.fiTongkltinh = ko.observable(gcn11.fiTongkltinh).extend({
        number: { message: 'Phải nhập số', params : true},
        pattern: {
            message: 'Phải nhập giá trị với tối đa 3 số ở phần thập phân ví dụ: 1.234',
            params: '^[0-9]{0,15}(?:\.[0-9]{0,3})?$'
        }
    });
    self.fiMadvKl = ko.observable(gcn11.fiMadvKl);
    self.fiTendvKl = ko.observable(gcn11.fiTendvKl);
    self.fiMadvKlList = ko.observableArray([]);
    self.fiHienthiKl = ko.observable(gcn11.fiHienthiKl);
    self.fiTongklbi = ko.observable(gcn11.fiTongklbi).extend({
        number: { message: 'Phải nhập số', params : true},
        pattern: {
            message: 'Phải nhập giá trị với tối đa 3 số ở phần thập phân ví dụ: 1.234',
            params: '^[0-9]{0,15}(?:\.[0-9]{0,3})?$'
        }
    });
    self.fiKbBosung = ko.observable(gcn11.fiKbBosung).extend({
        maxLength: { message: '500 ký tự', params : 500}
    });
    self.fiMadvBi = ko.observable(gcn11.fiMadvBi);
    self.fiTendvBi = ko.observable(gcn11.fiTendvBi);
    self.fiMadvBiList = ko.observableArray([]);
    self.fiHienthiBi = ko.observable(gcn11.fiHienthiBi);
    self.fiMaHoso = ko.observable(options.fiMaHoso);
    self.fiIdHoso = ko.observable(options.fiIdHoso);
        
    self.gcnErrors = ko.validation.group([self.fiMabaobi,self.fiLoaiCt, self.fiManuocXk, self.fiTennuocXk, self.fiNguoiXk, self.fiDiachiXk, self.fiTenNn, self.fiDiachiNn, self.fiSoluong, self.fiMabaobi, self.fiHienthi, self.fiQuycachDg, self.fiManuocSx, self.fiHtcc], { deep: true, live: true, observable: true });
    self.gcnHanghoaErrors = ko.validation.group([self.hh_fiTenHh,self.hh_fiTenKh,self.hh_fiSoluong,self.hh_fiKhoiluong,self.hh_fiKlbi,self.hh_fiThetich,self.hh_fiThetichbi], { deep: true, live: true, observable: true });
    
    var gcn11 = options && options.gcn11 ? options.gcn11 : {};
    getCategory("QUOCGIA", null, function(res){
        if(res.success){
            self.fiManuocXkList(mapCategory(res.data,"statecode", "name"));
            self.fiManuocQcList(mapCategory(res.data,"statecode", "name"));
            self.fiManuocSxList(mapCategory(res.data,"statecode", "name"));
            if(gcn11.fiManuocXk){
                self.fiManuocXk(gcn11.fiManuocXk);
                self.fiTennuocXk(gcn11.fiTennuocXk);
            }
            if(gcn11.fiManuocQc){
                self.fiManuocQc(gcn11.fiManuocQc);
                self.fiTennuocQc(gcn11.fiTennuocQc);
            }
            if(gcn11.fiManuocSx){
                self.fiManuocSx(gcn11.fiManuocSx);
                self.fiTennuocSx(gcn11.fiTennuocSx); 
            }
            else{
                self.fiManuocSx("VN");
                self.fiManuocSx("VIETNAM"); 
            }
        }
    });
    
    getCategory("TINHTHANH", null, function(res){
        if(res.success){
            self.fiMatinhList(mapCategory(res.data,"provinceCode", "provinceName"));
            if(gcn11.fiMatinh){
                self.fiMatinh(gcn11.fiMatinh);
                self.fiTentinh(gcn11.fiTentinh);
            }
        }
    });
    
    getCategory("SOLUONG", null, function(res){
        if(res.success){
            self.fiMabaobiList(mapCategory(res.data,"unitcode", "unitname"));
            self.hh_fiMadvSlList(mapCategory(res.data,"unitcode", "unitname"));
            if(gcn11.fiMabaobi){
                self.fiMabaobi(gcn11.fiMabaobi);
                self.fiTenbaobi(gcn11.fiTenbaobi);
            }
        }
    });
    
    getCategory("TRONGLUONG", null, function(res){
        if(res.success){
            self.fiMadvKlList(mapCategory(res.data,"unitcode", "unitname"));
            if(gcn11.fiMadvKl){
                self.fiMadvKl(gcn11.fiMadvKl);
            }
            
            self.fiMadvBiList(mapCategory(res.data,"unitcode", "unitname"));
            if(gcn11.fiMadvBi){
                self.fiMadvBi(gcn11.fiMadvBi);
            }
            
            self.hh_fiMadvKlList(mapCategory(res.data,"unitcode", "unitname"));
            self.hh_fiMadvBiList(mapCategory(res.data,"unitcode", "unitname"));
        }
    });
    
    getCategory("THETICH", null, function(res){
        if(res.success){
            self.hh_fiMadvTtList(mapCategory(res.data,"unitcode", "unitname"));
            self.hh_fiMadvTtbiList(mapCategory(res.data,"unitcode", "unitname"));
            self.hh_fiMadvTtbiList(mapCategory(res.data,"unitcode", "unitname"));
        }
    });
    
    getCategory("DONGGOI", null, function(res){
        if(res.success){
            self.fiQuycachDgList(mapCategory(res.data,"id", "name"));
            if(gcn11.fiQuycachDg){
                self.fiQuycachDg(gcn11.fiQuycachDg);
            }
        }
    });
    
    getCategory("CHUYENCHO", null, function(res){
        if(res.success){
            self.fiHtccList(mapCategory(res.data,"id", "name"));
            if(gcn11.fiHtcc){
                self.fiHtcc(gcn11.fiHtcc);
            }
        }
    });

    self.toJSON = function () {
        var exclude = [ "errorHanghoaText" ];
        var copy = ko.toJS(self);
        for (var key in copy) {
            if (exclude.indexOf(key) >= 0 || key.endsWith("Errors") || key.endsWith("List")|| key.endsWith("Click") || key.startsWith("hh_")) {
                delete copy[key];
            }
        }
        if (copy.tbdhhgcn11 && copy.tbdhhgcn11.length > 0) {
            for (var i = 0; i < copy.tbdhhgcn11.length; i++) {
                delete copy.tbdhhgcn11[i]["bSua"];
                delete copy.tbdhhgcn11[i]["bXoa"];
            }
        }
        return copy;
    };
    
    self.btnGuiClick = function(){
        if(self.tbdhhgcn11().length <= 0){
            alert('Chưa nhập hàng hóa');
            return;
        }
        if(self.gcnErrors().length > 0){
            alert('Phải nhập đầy đủ thông tin yêu cầu (trường đánh dấu màu đỏ)');
            self.gcnErrors.showAllMessages();
            return;
        }
        var data = self.toJSON();
        $.ajax({
            async: true,
            type: 'POST',
            cache: false,
            crossDomain: true,
            url: app.appContext + '/mard/11/hoso/gcn/send',
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            beforeSend: function (xhr) {
                xhr.setRequestHeader(CSRF_TOKEN_NAME, CSRF_TOKEN_VALUE);
                $('#loading10').show();
            },
            success: function (res) {
                //console.log("res -> ", res);
                if(res && res.success){
                    self.fiIdGcn(res.data.fiIdGcn);
                    var data = {
                        type : "23",
                        function : "20",
                        fiIdHoso : self.fiIdHoso(),
                        fiMaHoso : self.fiMaHoso()
                    };
                    self.guiYcXuly(data);
                }
                else{
                    $('#loading10').hide();
                    alert('Gửi dữ liệu không thành công');
                    //History.go(-1);
                }
            },
            error: function (x, t, m) {
                $('#loading10').hide();
            },
            complete: function (jqXHR, textStatus) {
                //$('#loading10').hide();
            }
        });
    };
    
    self.btnTroLaiClick = function(){
        History.go(-1);
    };
    
    /**
     * Gửi hồ sơ
     * @param {type} data
     * @returns {undefined}
     */
    self.guiYcXuly = function(data){
        $.ajax({
            async: true,
            type: 'POST',
            cache: false,
            crossDomain: true,
            url: app.appContext + '/mard/11/hoso/xuly',
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            beforeSend: function (xhr) {
                xhr.setRequestHeader(CSRF_TOKEN_NAME, CSRF_TOKEN_VALUE);
                $('#loading10').show();
            },
            success: function (res) {
                //console.log("res -> ", res);
                // Thông báo kết quả
                if(res && res.success){
                    alert('Đã gửi yêu cầu thành công');
                    History.go(-1);
                }
                else{
                    alert('Đã gửi yêu cầu không thành công');
                    History.go(-1);
                }
            },
            error: function (x, t, m) {
                $('#loading10').hide();
            },
            complete: function (jqXHR, textStatus) {
                $('#loading10').hide();
            }
        });
    };
};
$(document).ready(function (){
    var options = app.parseQuerystring();
    $.ajax({
        async: true,
        type: 'POST',
        cache: false,
        crossDomain: true,
        url: app.appContext + '/mard/11/hoso/t/' + options.fiIdHoso,
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        beforeSend: function (xhr) {
            xhr.setRequestHeader(CSRF_TOKEN_NAME, CSRF_TOKEN_VALUE);
            $('#loading10').show();
        },
        success: function (res) {
            if(res.success){
                delete res.data.lstDinhkem11;
                delete res.data.lstHanghoa11;
                delete res.data.lstLichsu11;
                var vm = new CreateGCNVM(res.data);
                ko.applyBindings(vm, document.getElementById('gcn11Create'));
            }
        },
        error: function (x, t, m) {
            alert('Lỗi khi thực hiện yêu cầu');
        },
        complete: function (jqXHR, textStatus) {
            $('#loading10').hide();
        }
    });
});