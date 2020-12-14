/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* global app, CSRF_TOKEN_NAME, CSRF_TOKEN_VALUE, user, RAW_HS_STATUS */
function Mard10FormVM(options)
{
    var self = this;
    
    self.clearForm = function(){
        
    };
    
    /**
     * Đưa dữ liệu vào từ excel
     * @param {type} data
     * @returns {undefined}
     */
    self.import = function(data){
        if(!data){
            return;
        }
        // Tải lại dữ liệu
        getCategory("CUAKHAU", data.fiMaQgxk, function(res){
            if(res.success){
                self.fiMaCkxkList(mapCategory(res.data,"portcode", "portname"));
            }
            // Đưa dữ liệu vào form
            for(var key in data){
                if(self[key] && key != "fiTenHanghoa" && key != "lstHanghoa10"){
                    if(key == "fiNgayky" || key == "fiNgaytao" && data[key]){
                        self[key](new Date(data[key]));
                        continue;
                    }
                    self[key](data[key]);
                }
            }
            if(data.lstHanghoa10){
                for(var i = 0; i < data.lstHanghoa10.length; i++){
                    for(var j = 0; j < self.fiMdvSlList().length; j++){
                        if(data.lstHanghoa10[i].fiMdvSl == self.fiMdvSlList()[j].id){
                            data.lstHanghoa10[i].fiTendvSl = self.fiMdvSlList()[j].name;
                        }
                        if(data.lstHanghoa10[i].fiMaTlTinh == self.fiMdvSlList()[j].id){
                            data.lstHanghoa10[i].fiTentlTinh = self.fiMdvSlList()[j].name;
                        }
                        if(data.lstHanghoa10[i].fiMaTlBi == self.fiMdvSlList()[j].id){
                            data.lstHanghoa10[i].fiTenTlBi = self.fiMdvSlList()[j].name;
                        }
                    }
                }
                self.lstHanghoa10(mapTbdhanghoa10(data.lstHanghoa10));
            }
            self.fiTenQgxk($('#fiMaQgxk option:selected').text());
            if($('#fiMaCkxk option:selected').val()){
                self.fiTenCkxk($('#fiMaCkxk option:selected').text());
            }
            else{
                self.fiMaCkxk(null);
                self.fiTenCkxk(null);
            }
            self.fiTenCknk($('#fiMaCknk option:selected').text());
            self.fiTenDvkd($('#fiMaDvkd option:selected').text());
            self.fiTenDvgs($('#fiMaDvgs option:selected').text());
        });
    };
    /**
     * Thêm mới hoặc cập nhập đơn hàng
     * @returns {undefined}
     */
    self.updateHanghoaClick = function () {
        //console.log("self.hanghoaErrors() -> ", self.hanghoaErrors());
        if(self.hanghoaErrors().length > 0){
            self.hanghoaErrors.showAllMessages();
            return;
        }
        if (self.fiIdHh() == null || self.fiIdHh() == "") {
            var hanghoa = new Tbdhanghoa(self.lstHanghoa10().length + 1, -1 * new Date().getTime(), self.fiTenHh(), self.fiNoiSx(), self.fiSoluong(), self.fiMdvSl(), self.fiTendvSl(), self.fiTlTinh(), self.fiMaTlTinh(), self.fiTentlTinh(), self.fiTlBi(), self.fiMaTlBi(), self.fiTenTlBi(), self.fiLoaiBb(), self.fiSoHd());
            self.lstHanghoa10.push(hanghoa);
        } else {
            // Tìm phần tử và cập nhập
            var index = self.lstHanghoa10.firstIndexOf(function (item) {
                return item.fiIdHh() == self.fiIdHh();
            });
            if (index >= 0) {
                self.lstHanghoa10()[index].fiTenHh(self.fiTenHh());
                self.lstHanghoa10()[index].fiNoiSx(self.fiNoiSx());
                self.lstHanghoa10()[index].fiSoluong(self.fiSoluong());
                self.lstHanghoa10()[index].fiMdvSl(self.fiMdvSl());
                self.lstHanghoa10()[index].fiTendvSl(self.fiTendvSl());
                self.lstHanghoa10()[index].fiTlTinh(self.fiTlTinh());
                if(self.fiTlTinh()){
                    self.lstHanghoa10()[index].fiMaTlTinh(self.fiMaTlTinh());
                    self.lstHanghoa10()[index].fiTentlTinh(self.fiTentlTinh());
                }
                else{
                    self.lstHanghoa10()[index].fiMaTlTinh(null);
                    self.lstHanghoa10()[index].fiTentlTinh(null);
                }
                self.lstHanghoa10()[index].fiTlBi(self.fiTlBi());
                if(self.fiTlBi()){
                    self.lstHanghoa10()[index].fiMaTlBi(self.fiMaTlBi());
                    self.lstHanghoa10()[index].fiTenTlBi(self.fiTenTlBi());
                }
                else{
                    self.lstHanghoa10()[index].fiMaTlBi(null);
                    self.lstHanghoa10()[index].fiTenTlBi(null);
                }
                self.lstHanghoa10()[index].fiLoaiBb(self.fiLoaiBb());
                self.lstHanghoa10()[index].fiSoHd(self.fiSoHd());
            }
        }

        self.fiIdHh(null);
        self.fiTenHh(null);
        self.fiNoiSx(null);
        self.fiSoluong(null);
        self.fiMdvSl(null);
        self.fiTendvSl(null);
        self.fiTlTinh(null);
        self.fiMaTlTinh(null);
        self.fiTentlTinh(null);
        self.fiTlBi(null);
        self.fiMaTlBi(null);
        self.fiTenTlBi(null);
        self.fiLoaiBb(null);
        self.fiSoHd(null);
        self.hanghoaErrors.showAllMessages(false);
    };

/**
 * Ấn nút sửa hàng hóa
 * @param {type} item
 * @returns {undefined}
 */
    self.bSuaHhClick = function (item) {
        if(!item.fiIdHh()){
            item.fiIdHh(-1 * new Date().getTime());
        }
        self.fiIdHh(item.fiIdHh());
        self.fiTenHh(item.fiTenHh());
        self.fiNoiSx(item.fiNoiSx());
        self.fiSoluong(item.fiSoluong());
        self.fiMdvSl(item.fiMdvSl());
        if(item.fiTendvSl()){
            self.fiTendvSl(item.fiTendvSl());
        }
        else if($('#fiMdvSl option:selected').text()){
            self.fiTendvSl($('#fiMdvSl option:selected').text());
        }
        else{
            self.fiMdvSl(null);
        }
        self.fiTlTinh(item.fiTlTinh());
        self.fiMaTlTinh(item.fiMaTlTinh());
        if(item.fiTentlTinh()){
            self.fiTentlTinh(item.fiTentlTinh());
        }
        else if($('#fiMaTlTinh option:selected').text()){
            self.fiTentlTinh($('#fiMaTlTinh option:selected').text());
        }
        else{
            self.fiMaTlTinh(null);
        }
        self.fiTlBi(item.fiTlBi());
        self.fiMaTlBi(item.fiMaTlBi());
        if(item.fiTenTlBi()){
            self.fiTenTlBi(item.fiTenTlBi());
        }
        else if($('#fiMaTlBi option:selected').text()){
            self.fiTenTlBi($('#fiMaTlBi option:selected').text());
        }
        else{
            self.fiMaTlBi(null);
        }
        self.fiLoaiBb(item.fiLoaiBb());
        self.fiSoHd(item.fiSoHd());
    };

/**
 * Xóa hàng hóa
 * @param {type} item
 * @returns {undefined}
 */
    self.bXoaHhClick = function (item) {
        if (item) {
            self.lstHanghoa10.remove(function (hh) {
                return hh.fiIdHh() == item.fiIdHh();
            });
        }
    };
/**
 * Bật màn hình: Chọn văn bản
 * @returns {undefined}
 */
    self.chooseDocumentClick = function () {
        var html = [
            $('#select-document-template').html()
        ].join('');
        self.pop = app.popup({
            title: 'Chọn từ văn bản chấp thuận của Cục Thú y: ',
            html: html,
            width: 650,
            buttons: [
                {
                    name: 'Chọn',
                    class: 'btn',
                    icon: 'fa-check',
                    action: self.selectedDocumentClick
                }
            ]
        });
        var SelectedDocumentVM = function () {
            var vmSelf = this;
            vmSelf.documents = ko.observableArray([]);
            vmSelf.selected = ko.observable();
            vmSelf.fetch = function(){
                $.ajax({
                    type: 'POST',
                    cache: false,
                    crossDomain: true,
                    url: app.appContext + "/mard/10/quarantine",
                    contentType: "application/json; charset=utf-8",
                    dataType: "json",
                    beforeSend: function (xhr) {
                        xhr.setRequestHeader(CSRF_TOKEN_NAME, CSRF_TOKEN_VALUE);
                        $('#loading10').show();
                    },
                    success: function (res) {
                        //console.log("res -> ", res);
                        if(res && res.success){
                            //console.log("res.data -> ", res.data);
                            var cates = mapCategory(res.data, "documentid", "dispatchno");
                            //console.log("cates -> ", cates);
                            vmSelf.documents(cates);
                        }
                    },
                    error: function (x, t, m) {
                        self.clearForm();
                    },
                    complete: function (jqXHR, textStatus) {
                        $('#loading10').hide();
                    }
                });
            };
            vmSelf.fetch();
        };
        self.selectedDocumentVM = new SelectedDocumentVM();
        ko.applyBindings(self.selectedDocumentVM, document.getElementById('select-document'));
    };
/**
 * Xử lý sau khi đã chọn văn bản
 * @returns {undefined}
 */
    self.selectedDocumentClick = function () {
        if(!self.selectedDocumentVM.selected()){
            alert('Chưa chọn văn bản');
            return;
        }
        if(!self.lstHanghoa10()){
            self.lstHanghoa10([]);
        }
        //alert(self.selectedDocumentVM.selected() - 0);
        $.ajax({
            type: 'POST',
            cache: false,
            crossDomain: true,
            url: app.appContext + "/mard/10/quarantine/" + (self.selectedDocumentVM.selected()- 0),
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            beforeSend: function (xhr) {
                xhr.setRequestHeader(CSRF_TOKEN_NAME, CSRF_TOKEN_VALUE);
                $('#loading10').show();
            },
            success: function (res) {
                if(res && res.success && res.data){
                    // Lấy thông tin để đưa vào grid
                    self.fiTenDtxk(res.data.mealcompany);
                    self.fiMucdichSd(res.data.mealpurpose);
                    self.fiVbCtkd(res.data.dispatchno);
                    if(res.data.lstGoods){
                        var goods = res.data.lstGoods;
                        var assign = false;
                        var fiMdvSl = "TNE";
                        var fiTendvSl = null;
                        if(res.data.documenttype == 1){
                            fiMdvSl = "UNC";
                        }
                        for(var i = 0; i < self.fiMdvSlList().length; i++){
                            if(fiMdvSl == self.fiMdvSlList()[i].id){
                                fiTendvSl = self.fiMdvSlList()[i].name;
                                break;
                            }
                        }
                        if(!fiTendvSl){
                            fiMdvSl = null;
                        }
                        self.lstHanghoa10([]);
                        for(var i = 0; i < goods.length; i++){
                            var hanghoa = new Tbdhanghoa(self.lstHanghoa10().length + 1, -1 * new Date().getTime(), goods[i].goodname, goods[i].exporterstatename, goods[i].quantity, fiMdvSl, fiTendvSl, null, null, null, null, null, null, null, null);
                            self.lstHanghoa10.push(hanghoa);
                            if(!assign &&  goods[i].exporterstatecode){
                                self.fiMaQgxk(goods[0].exporterstatecode);
                                self.fiTenQgxk($('#fiMaQgxk option:selected').text());
                                getCategory("CUAKHAU", self.fiMaQgxk(), function(res){
                                    if(res.success){
                                        self.fiMaCkxkList(mapCategory(res.data,"portcode", "portname"));
                                        self.fiMaCkxk(goods[0].portofdestinationcode);
                                        self.fiTenCkxk($('#fiMaCkxk option:selected').text());
                                    }
                                });
                                assign = true;
                            }
                        }
                    }
                }
            },
            error: function (x, t, m) {
                self.clearForm();
            },
            complete: function (jqXHR, textStatus) {
                $('#loading10').hide();
                app.popupRemove(self.pop.selector);
            }
        });        
    };
    
    /**
     * Chọn quốc gia, đưa ra cửa khẩu
     * @returns {undefined}
     */
    self.fiMaQgxkChange = function(){
        if(self.fiMaQgxk()){
            getCategory("CUAKHAU", self.fiMaQgxk(), function(res){
                if(res.success){
                    self.fiMaCkxkList(mapCategory(res.data,"portcode", "portname"));
                }
            });
        }
        else{
            self.fiMaQgxkList([]);
        }
    };
    
    self.errorHanghoaText = ko.observable("");
    
    self.isValidForm =function(){
        //console.log("self.errors -> ", self.hosoErrors());
        self.errorHanghoaText("");
        // Xóa bỏ thành phần có chứa cookie, knockout sẽ bị lỗi
        delete self.selectedDocumentVM;
        delete self.pop;
        //console.log("self -> ", self);
        if(self.hosoErrors().length > 0){
            self.hosoErrors.showAllMessages();
        }
        var errorHanghoa = false;
        if(!self.lstHanghoa10() ||  self.lstHanghoa10().length <= 0){
            self.errorHanghoaText('* Chưa khai báo hàng hóa');
            return false;//errorHanghoa;
        }
        if(self.lstHanghoa10() && self.lstHanghoa10().length > 0){
            for(var i = 0; i < self.lstHanghoa10().length; i++){
                var hh = self.lstHanghoa10()[i];
                if(!hh.fiTendvSl()){
                    hh.fiTendvSl(hh.fiMdvSl());
                }
                if(!hh.fiTenHh() || !hh.fiNoiSx() || !hh.fiSoluong() || !hh.fiMdvSl() || !hh.fiTendvSl()){
                    errorHanghoa = true;
                    break;
                }
            }
        }
        if(errorHanghoa){
            self.errorHanghoaText('* Bổ sung thêm thông tin của hàng hóa trước khi lưu dữ liệu');
        }
        return self.hosoErrors().length <= 0 && !errorHanghoa;
    };

    self.toJSON = function () {
        var exclude = ["selectedDocumentVM", "hosoErrors", "hanghoaErrors","fiMdvSlList", "fiMaDvgsList", "fiMaTlTinhList", "fiMaTlBiList", "fiMaQgxkList", "fiMaCkxkList", "fiMaCknkList", "updateHanghoaClick", "bSuaHhClick", "bXoaHhClick", "chooseDocumentClick", "selectedDocumentClick", "toJSON", "fiMaDvkdList"];
        var copy = ko.toJS(self);
        for (var key in copy) {
            if (exclude.indexOf(key) >= 0) {
                delete copy[key];
            }
        }
        if (copy.lstHanghoa10 && copy.lstHanghoa10.length > 0) {
            for (var i = 0; i < copy.lstHanghoa10.length; i++) {
                delete copy.lstHanghoa10[i]["STT"];
                delete copy.lstHanghoa10[i]["bSua"];
                delete copy.lstHanghoa10[i]["bXoa"];
            }
        }
        return copy;
    };
    if(options && options.hoso){
        ko.mapping.fromJS(options && options.hoso, {}, self);
    }
    var hoso = options && options.hoso ? options.hoso : {};
    self.lstHanghoa10 = ko.observableArray(hoso && hoso.lstHanghoa10 ? mapTbdhanghoa10(hoso.lstHanghoa10) : null);
    self.fiIdHoso = ko.observable(hoso.fiIdHoso);
    self.fiMaHoso = ko.observable(hoso.fiMaHoso);
    self.fiTrangthai = ko.observable(hoso.fiTrangthai);
    self.fiNgaytao = ko.observable(hoso && hoso.fiNgaytao ? new Date(hoso.fiNgaytao) : new Date());
    self.fiNguoitao = ko.observable(hoso.fiNguoitao);
    
    self.fiMaDvkd = ko.observable(hoso.fiMaDvkd).extend({
        required : {message : 'Phải nhập', params : true},
        maxLength : {message : 'Tối đa 50 ký tự', params : 50}
    });
    self.fiTenDvkd = ko.observable(hoso.fiTenDvkd).extend({
        maxLength : {message : 'Tối đa 250 ký tự', params : 250}
    });
    self.fiMaDvkdList = ko.observable([]);
    
    self.fiMaDvgs = ko.observable(hoso.fiMaDvgs).extend({
        maxLength : {message : 'Tối đa 50 ký tự', params : 50}
    });
    self.fiTenDvgs = ko.observable(hoso.fiTenDvgs).extend({
        maxLength : {message : 'Tối đa 50 ký tự', params : 50}
    });
    self.fiMaDvgsList = ko.observableArray([]);
    
    self.fiDonkb = ko.observable(hoso.fiDonkb).extend({
        maxLength : {message : 'Tối đa 250 ký tự', params : 250}
    });
    
    self.fiSoVandon = ko.observable(hoso.fiSoVandon).extend({
        required: { message: 'Phải nhập', params : true},
        maxLength : {message : 'Tối đa 35 ký tự', params : 35}
    });
    self.fiSoTk = ko.observable(hoso.fiSoTk).extend({
        maxLength : {message : 'Tối đa 13 ký tự', params : 13}
    });
    self.fiTenCty = ko.observable(hoso.fiTenCty ? hoso.fiTenCty : user.companyName).extend({
        required: { message: 'Phải nhập', params : true},
        maxLength : {message : 'Tối đa 250 ký tự', params : 250}
    });
    self.fiSdtCty = ko.observable(hoso.fiSdtCty ? hoso.fiSdtCty : user.companyPhoneNumber).extend({
        maxLength : {message : 'Tối đa 50 ký tự', params : 50}
    });
    self.fiDiachiCty = ko.observable(hoso.fiDiachiCty? hoso.fiDiachiCty : user.companyAddress).extend({
        required: { message: 'Phải nhập', params : true},
        maxLength : {message : 'Tối đa 500 ký tự', params : 500}
    });
    self.fiEmailCty = ko.observable(hoso.fiEmailCty ? hoso.fiEmailCty : user.companyEmail).extend({
        maxLength : {message : 'Tối đa 50 ký tự', params : 50}
    });
    self.fiFaxCty = ko.observable(hoso.fiFaxCty? hoso.fiFaxCty : user.companyFax).extend({
        maxLength : {message : 'Tối đa 50 ký tự', params : 50}
    });
    self.fiIdHh = ko.observable(hoso.fiIdHh);
    self.fiTenHh = ko.observable(hoso.fiTenHh).extend({
        required: { message: 'Phải nhập', params : true},
        maxLength : {message : 'Tối đa 250 ký tự', params : 250}
    });
    self.fiNoiSx = ko.observable(hoso.fiNoiSx).extend({
        required: { message: 'Phải nhập', params : true},
        maxLength : {message : 'Tối đa 250 ký tự', params : 250}
    });
    self.fiSoluong = ko.observable(hoso.fiSoluong).extend({
        required: { message: 'Phải nhập', params : true},
        number: { message: 'Phải nhập số', params : true}
    });
    self.fiMdvSl = ko.observable(hoso.fiMdvSl).extend({
        required: { message: 'Phải nhập', params : true},
        maxLength: { message: '16 ký tự', params : 16}
    });
    self.fiTendvSl = ko.observable(hoso.fiTendvSl).extend({
        required: { message: 'Phải nhập', params : true},
        maxLength: { message: '255 ký tự', params : 255}
    });
    self.fiMdvSlList = ko.observableArray([]);
    
    self.fiMaTlTinh = ko.observable(hoso.fiMaTlTinh).extend({
        maxLength: { message: '18 ký tự', params : 18}
    });
    self.fiTentlTinh = ko.observable(hoso.fiTentlTinh).extend({
        maxLength: { message: '255 ký tự', params : 255}
    });
    self.fiTlTinh = ko.observable(hoso.fiTlTinh).extend({
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
                return val && self.fiMaTlTinh();
            },
            message: 'Phải nhập đơn vị tính'
        }
    });
    self.fiMaTlTinhList = ko.observableArray([]);
    
    self.fiMaTlBi = ko.observable(hoso.fiMaTlBi).extend({
        maxLength: { message: '18 ký tự', params : 18}
    });
    self.fiTenTlBi = ko.observable(hoso.fiTenTlBi).extend({
        maxLength: { message: '255 ký tự', params : 255}
    });
    self.fiTlBi = ko.observable(hoso.fiTlBi).extend({
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
                return val && self.fiMaTlBi();
            },
            message: 'Phải nhập đơn vị tính'
        }
    });
    self.fiMaTlBiList = ko.observableArray([]);
    
    self.fiLoaiBb = ko.observable(hoso.fiLoaiBb).extend({
        maxLength: { message: '255 ký tự', params : 255}
    });
    self.fiSoHd = ko.observable(hoso.fiSoHd).extend({
        maxLength: { message: '50 ký tự', params : 50}
    });
    self.fiTenDtxk = ko.observable(hoso.fiTenDtxk).extend({
        required: { message: 'Phải nhập', params : true},
        maxLength : {message : 'Tối đa 250 ký tự', params : 250}
    });
    self.fiMaQgxk = ko.observable(hoso.fiMaQgxk).extend({
        required: { message: 'Phải nhập', params : true},
        maxLength : {message : 'Tối đa 20 ký tự', params : 20}
    });
    self.fiTenQgxk = ko.observable(hoso.fiTenQgxk).extend({
        required: { message: 'Phải nhập', params : true},
        maxLength : {message : 'Tối đa 100 ký tự', params : 100}
    });
    self.fiMaQgxkList = ko.observableArray([]);
    self.fiMaCkxk = ko.observable(hoso.fiMaCkxk).extend({
        required : {message : 'Phải nhập', params : true},
        maxLength : {message : 'Tối đa 6 ký tự', params : 6}
    });
    self.fiTenCkxk = ko.observable(hoso.fiTenCkxk).extend({
        required: { message: 'Phải nhập', params : true},
        maxLength : {message : 'Tối đa 255 ký tự', params : 255}
    });
    self.fiMaCkxkList = ko.observableArray([]);
    self.fiTenDtnk = ko.observable(hoso.fiTenDtnk ? hoso.fiTenDtnk : user.companyName).extend({
        required: { message: 'Phải nhập', params : true},
        maxLength : {message : 'Tối đa 250 ký tự', params : 250}
    });
    self.fiTenQgnk = ko.observable(hoso && hoso.fiTenQgnk ?hoso.fiTenQgnk: "Việt Nam").extend({
        required: { message: 'Phải nhập', params : true},
        maxLength : {message : 'Tối đa 250 ký tự', params : 250}
    });
    self.fiPtvt = ko.observable(hoso.fiPtvt).extend({
        required: { message: 'Phải nhập', params : true},
        maxLength : {message : 'Tối đa 250 ký tự', params : 250}
    });
    self.fiMaCknk = ko.observable(hoso.fiMaCknk).extend({
        maxLength : {message : 'Tối đa 6 ký tự', params : 6}
    });
    self.fiTenCknk = ko.observable(hoso.fiTenCknk).extend({
        required: { message: 'Phải nhập', params : true},
        maxLength : {message : 'Tối đa 255 ký tự', params : 255}
    });
    self.fiMaCknkList = ko.observableArray([]);
    self.fiMucdichSd = ko.observable(hoso.fiMucdichSd).extend({
        required: { message: 'Phải nhập', params : true},
        maxLength : {message : 'Tối đa 500 ký tự', params : 500}
    });
    self.fiVbCtkd = ko.observable(hoso.fiVbCtkd).extend({
        maxLength : {message : 'Tối đa 250 ký tự', params : 250}
    });
    self.fiDdkd = ko.observable(hoso.fiDdkd).extend({
        required: { message: 'Phải nhập', params : true},
        maxLength : {message : 'Tối đa 250 ký tự', params : 250}
    });
    self.fiTgkd = ko.observable(hoso.fiTgkd).extend({
        required: { message: 'Phải nhập', params : true},
        maxLength : {message : 'Tối đa 250 ký tự', params : 250}
    });
    self.fiDdgs = ko.observable(hoso.fiDdgs).extend({
        maxLength : {message : 'Tối đa 250 ký tự', params : 250}
    });
    self.fiTggs = ko.observable(hoso.fiTggs).extend({
        maxLength : {message : 'Tối đa 250 ký tự', params : 250}
    });
    self.fiSobanGcn = ko.observable(hoso.fiSobanGcn).extend({
        maxLength : {message : 'Tối đa 250 ký tự', params : 250}
    });
    self.fiNoiky = ko.observable(hoso.fiNoiky).extend({
        required: { message: 'Phải nhập', params : true},
        maxLength : {message : 'Tối đa 250 ký tự', params : 250}
    });
    self.fiNgayky = ko.observable(hoso && hoso.fiNgayky ? new Date(hoso.fiNgayky) : null).extend({
        required: { message: 'Phải nhập', params : true}
    });
    self.fiNguoiky = ko.observable(hoso.fiNguoiky).extend({
        required: { message: 'Phải nhập', params : true},
        maxLength : {message : 'Tối đa 250 ký tự', params : 250}
    });
    self.fiTenHanghoa = ko.computed(function (){
        if(self.lstHanghoa10().length > 0){
            var name = "";
            for(var i = 0; i < self.lstHanghoa10().length; i++){
                name += (name == "" ? self.lstHanghoa10()[i].fiTenHh() : ", " + self.lstHanghoa10()[i].fiTenHh());
            }
            if(name.length > 255){
                name = name.substr(0, 252) + "...";
            }
            return name;
        }
    }, self);
    
    self.fiNguoiCn = ko.observable(hoso.fiNguoiCn);
    self.fiNguoitao = ko.observable(hoso.fiNguoitao);
    self.fiTrangthaiText = ko.dependentObservable(function(){
        if(RAW_HS_STATUS){
            for(var i = 0; i < RAW_HS_STATUS.length; i++ ){
                if(RAW_HS_STATUS[i].id == self.fiTrangthai()){
                    return RAW_HS_STATUS[i].name;
                }
            }
            return "Tạo mới";
        }
    }, self);
    
    var hosoVG = [self.fiSoVandon, self.fiTenCty, self.fiDiachiCty, self.fiTenDtxk, self.fiMaQgxk, self.fiTenQgxk, self.fiTenCkxk, self.fiTenDtnk, self.fiTenQgnk, self.fiPtvt, self.fiTenCknk, self.fiMucdichSd, self.fiDdkd, self.fiNoiky, self.fiNguoikyfiSoVandon, self.fiTenCty, self.fiDiachiCty, self.fiTenDtxk, self.fiMaQgxk, self.fiTenQgxk, self.fiTenCkxk, self.fiTenDtnk, self.fiPtvt, self.fiTenCknk, self.fiMucdichSd, self.fiDdkd, self.fiNoiky, self.fiNguoiky];
    self.hosoErrors = ko.validation.group(hosoVG, { deep: true, live: true, observable: true });
    var hanghoaVG = [self.fiTenHh, self.fiNoiSx, self.fiSoluong, self.fiMdvSl, self.fiTendvSl];
    self.hanghoaErrors = ko.validation.group(hanghoaVG, { deep: true, live: true, observable: true });
    
    getCategory("SOLUONG", null, function(res){
        if(res.success){
            self.fiMdvSlList(mapCategory(res.data,"unitcode", "unitname"));
        }
    });
    
    getCategory("TRONGLUONG", null, function(res){
        if(res.success){
            self.fiMaTlTinhList(mapCategory(res.data,"unitcode", "unitname"));
            self.fiMaTlBiList(mapCategory(res.data,"unitcode", "unitname"));
        }
    });
    getCategory("QUOCGIA", null, function(res){
        if(res.success){
            self.fiMaQgxkList(mapCategory(res.data,"countrycode", "countryname"));
            if(hoso.fiMaQgxk){
                self.fiMaQgxk(hoso.fiMaQgxk);
                self.fiTenQgxk(hoso.fiTenQgxk);
            }
            if(self.fiMaQgxk()){
                getCategory("CUAKHAU", self.fiMaQgxk(), function(res){
                    if(res.success){
                        self.fiMaCkxkList(mapCategory(res.data,"portcode", "portname"));
                        if(hoso.fiMaCkxk){
                            self.fiMaCkxk(hoso.fiMaCkxk);
                            self.fiTenCkxk(hoso.fiTenCkxk);
                        }
                    }
                });
            }
            else{
                self.fiMaCkxkList([]);
            }
        }
    });
    getCategory("CUAKHAU", "VN", function(res){
        if(res.success){
            self.fiMaCknkList(mapCategory(res.data,"portcode", "portname"));
            if(hoso.fiMaCknk){
                self.fiMaCknk(hoso.fiMaCknk);
                self.fiTenCknk(hoso.fiTenCknk);
            }
        }
    });
    getCategory("DVKD", null, function(res){
        if(res.success){
            self.fiMaDvkdList(mapCategory(res.data,"dvkdCode", "dvkdName"));
            self.fiMaDvgsList(mapCategory(res.data,"dvkdCode", "dvkdName"));
            if(hoso.fiMaDvkd){
                self.fiMaDvkd(hoso.fiMaDvkd);
                self.fiTenDvkd(hoso.fiTenDvkd);
            }
            if(hoso.fiMaDvgs){
                self.fiMaDvgs(hoso.fiMaDvgs);
                self.fiTenDvgs(hoso.fiTenDvgs);
            }
        }
    });
};

