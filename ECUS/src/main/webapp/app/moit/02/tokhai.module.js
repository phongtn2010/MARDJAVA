var ToKhaiController = function(){};
ToKhaiController.prototype={
    ministryCode: 'most',
    code: '02',
    templates: ['tokhai-danhsach', 'tokhai-chitiet','tokhai-hanghoa'],
    pagination: {
        isReady: false,
        currentPage: 0,
        pageSize: 10
    },
    container: '#tokhai-container',
    List: [],
    IsView:null,
    init: function(obj){
        var op = $.extend(true, {}, obj);
       
        if (obj.hasOwnProperty('toKhaiHQ')) {
            if (obj.toKhaiHQ != null) {
                for (i = 0; i < obj.toKhaiHQ.length; i++) {
                    delete obj.toKhaiHQ[i].errors;
                }
            }
            this.List = obj.toKhaiHQ;            
            if (this.List == null)
                this.List = [];
        }
//        $("#fiDVHQ").select2();
        this.IsView = op.IsView;
         this.loadTemplates();
         this.registerEvents();
         this.buildPager(this.List);
       
    },
    loadTemplates: function () {
        var count = this.templates.length;
        if (count <= 0)
            return;
        for (var i = 0; i < count; i++) {
            app.getTemplate({
                ministryCode: this.ministryCode,
                code: this.code,
                templateName: this.templates[i]
            }, null);
        }
    },
    registerEvents: function () {
        var self = this;
        $("#btnThemMoiToKhai").on('click', function (e) {
            e.preventDefault();
            self.addPopup(-1);
            return false;
        });
        
        
    },
    setData: function (obj) {
        var op = $.extend(true, {}, obj);
        if (!op.hasOwnProperty('toKhaiHQ')) {
            this.List = [];
        } else {
            this.List = op['toKhaiHQ'] !== null ? op['toKhaiHQ'] : [];
        }

        this.bindGrid();
    },
    bindGrid: function () {
        var self = this;
        var list = [];
        var length =  self.List.length;
        for(var i = 0; i<length; i++){       
            var clone = $.extend(true,{}, self.List[i]);
            list.push(clone);
            
        }
        list.map(function(element) {
            return element.IsView = self.IsView;
        });
        var cb = function (html) {
            $(self.container).html(html);
            self.bindEventsGrid();

            $(self.container).find('.tooltips').tooltip();
        };

        app.complieTemplate({
            ministryCode: self.ministryCode,
            code: self.code,
            templateName: self.templates[0],
            data: list
        }, cb);

    },
    bindEventsGrid: function () {
        var self = this;
        var con = $(self.container);
        
         con.find('.fa-edit').off('click').on('click', function (e) {
            e.preventDefault();
            var me = $(this);
            var id = me.attr('item');
            self.addPopup(id);
            return false;
        });

        con.find('.fa-remove').off('click').on('click', function (e) {
            e.preventDefault();
            var me = $(this);
            var id = me.attr('item');
            var i = self.List.Search('fiIdTk', id);
            var docCode = me.attr('code');
            if (i > -1) {
                var pop = app.popup({
                    title: NSWLang["common_msg_thong_bao"],
                    html: '<i class="fa fa-3x fa-warning"></i> ' + NSWLang["common_msg_xoatokhai"] + ' <b>' + docCode + '</b>',
                    width: 400,
                    buttons: [
                        {
                            name: NSWLang["common_button_toi_chac_chan"],
                            class: 'btn',
                            icon: 'fa-check',
                            action: function () {
                                var msg = '';
                                var fun = 'success';

                                msg = NSWLang["common_msg_cap_nhat_du_lieu_thanh_cong"];
                                app.popupRemove(pop.selector);
                                self.List.splice(i, 1);
                                self.bindGrid();

                                app.toast({
                                    title: NSWLang["common_msg_thong_bao"],
                                    message: msg,
                                    function: fun
                                });
                            }
                        }
                    ]
                });
            }
            return false;
        });
            
        con.find('.fa-search').off('click').on('click', function (e) {
            e.preventDefault();
            var me = $(this);
            var id = me.attr('item');
            self.view(id);
            return false;
        });
    },
    view: function (id) {
        var self = this;
        var callback = function (html) {
            var popup = app.popup({
                title: NSWLang["most_02_tokhai_popup_thongtintokhai"],
                html: html,
                width: 900,
                buttons: [
                    {
                        name: NSWLang["common_button_dong"],
                        class: 'btn',
                        icon: 'fa-close',
                        action: function () {
                            app.popupRemove(popup.selector);
                        }
                    }
                ]
            });
        };

        var i = self.List.Search('fiIdTk', id);

        app.complieTemplate({
            ministryCode: self.ministryCode,
            code: self.code,
            templateName: self.templates[1],
            data: self.List[i]
        }, callback);
    },
    addPopup: function (id) {
        var self = this;
        var tempData = null;
        var callback = function (html) {
            var tokhaiData = null;
            var popup = app.popup({
                title: NSWLang["most_02_tokhai_popup_thongtintokhai"],
                html: html,
                width: 850,
                buttons: [
                    {
                        name: NSWLang["common_button_luu"],
                        class: 'btn',
                        icon: 'fa-check',
                        action: function () {
                            var data = null;
                                var formData = app.form2Object('#tokhai-form-popup');
                            var isExist = false;
                            for(var i = 0; i< self.List.length; i++){
                                if(formData.fiSoTk == self.List[i].fiSoTk){
                                    isExist = true;
                                    break;
                                }
                            }
                            if(isExist){
                                tokhaiData = tempData.data;
                                console.log(tempData);
                            }
                            if (tokhaiData !== null ) {
                                data = tokhaiData;
                                data.fiDiachiNnk = tokhaiData.fiDiachiNnk;
                                data.fiDiachiNxk = tokhaiData.fiDiachiNxk;
                                data.fiDtNnk = tokhaiData.fiDtNnk;
                                data.fiGhichu = tokhaiData.fiGhichu;
                                data.fiHoatdong = tokhaiData.fiHoatdong;
                                data.fiGhichu = tokhaiData.fiGhichu;
                                data.fiMaDvNk = tokhaiData.fiMaDvNk;
                                data.fiNguoiNk = tokhaiData.fiNguoiNk;
                                data.fiNguoiXk = tokhaiData.fiNguoiXk;
                                data.fiNuocXk = tokhaiData.fiNuocXk;
                                data.fiSoHoadon = tokhaiData.fiSoHoadon;
                                data.fiNgayCapHd = tokhaiData.fiNgayCapHd;
                                if(!!parseInt(tokhaiData.fiSoluong))
                                    data.fiSoluong = parseInt(tokhaiData.fiSoluong);
                                if(!!parseInt(tokhaiData.fiTong))
                                    data.fiTong = parseInt(tokhaiData.fiTong);
                                
                                
                                var temp = data.toKhaiHQD2s
                                for (var i = 0 ; i < temp.length; i++){
                                    delete temp[i].fiMaQl;
                                    delete temp[i].fiNuocSx;
                                    delete temp[i].fiStt;
                                    if(!!parseFloat(temp[i].fiKlSl)){
                                        temp[i].fiKlSl = parseFloat(temp[i].fiKlSl);
                                    } 
                                    else
                                        delete temp[i].fiKlSl;
                                }
                                data.toKhaiHQD2s = temp;
                                 console.log(data);
                                if (id <= 0) {
                                    data.fiIdTk = 1 - (self.List.length - 1);
                                    self.List.push(data);
                                } else {
                                    var i = self.List.Search('fiIdTk', id);
                                    if (i > -1) {
                                        self.List[i] = data;
                                    }
                                }
                                
                                self.bindGrid();
                                
                                //Get all checked checkboxes
                                $('#tokhai-hanghoa-container input:checked').each(function () {
                                    var me = $(this);
                                    console.log(window.controller.hangHoa);
                                    window.controller.hangHoa.addProductFromToKhai({

                                        'fiTenHh': me.attr('fiTenHh'),                                        
                                        'fiMaDv': me.attr('fiTenDv'),
                                        'fiKlSl': me.attr('fiKlSl'),
                                        'fiMaHs': me.attr('fiMaHs'),
//                                      'fiMaql': me.attr('fiMaql'),
                                        'fiSoTk': formData.fiSoTk
                                    });                                    
                                    //refresh lish
                                    window.controller.hangHoa.buildPager();
                                     app.popupRemove(popup.selector);
                                });
                                app.popupRemove(popup.selector);
                                console.log(self.List);
                            } else {
                                if(isExist){
                                    app.Alert(NSWLang["most_02_tokhai_tontai"]);
                                }
                                else
                                    app.Alert(NSWLang["common_msg_khonglayduocthongtintokhai"]);
                            }
                        }
                    }
                ]
            });
            
            if(id>=0){
                data.fiSoTk = tempData.data.fiSoTk;
                data.fiMaHq = tempData.data.fiMaHq;
                data.fiNamdk = tempData.data.fiNamdk;
                self.getDetailDeclaration(data, function (d) {
                    console.log(d);
                    delete d.data.lstHanghoa.fiMaQl;
                    //Bind data
                    self.buildPager(d.data.lstHanghoa);
                    popup.find('#cbAllProducts').off('click').on('click', function (e) {
                        var me = $(this);
                        //e.preventDefault();

                        var status = me.attr("data");
                        if (status === "1") {
                            status = false;
                            me.attr("data", "0");
                        } else {
                            status = true;
                            me.attr("data", "1");
                        }
                        $('#tokhai-hanghoa-container input').each(function () {
                            $(this).prop("checked", status);
                        });
                        //return false;
                    });
                });
            }
            var searchFun = function () {
                var isOk = app.isFormVaild('tokhai-form-popup');
                if (!isOk)
                    return;

                var data = app.form2Object('#tokhai-form-popup');
                data.fiIdTk = id;
                //Lay thong tin to khai
                self.getDetailDeclaration(data, function (d) {
                    var result = d.data;
//                    console.log(d);
                    data.toKhaiHQD2s = result.lstHanghoa;
                    delete data.toKhaiHQD2s.fiMaQl;
                    
                    data.fiNguoiNk = result.fiNguoiNk;
                    data.fiNuocXk = result.fiNuocXk;
                    data.fiSoHoadon = result.fiSoHoadon;
                    data.fiSoTk = result.fiSoTk;
                    data.fiDiachiNnk = result.fiDiachiNnk;
                    data.fiDtNnk = result.fiDtNnk;                    
                    data.fiNguoiNk = result.fiNguoiNk;
                    data.fiNguoiXk = result.fiNguoiXk;
                    data.fiNuocXk = result.fiNuocXk;
                    data.fiDiachiNxk = result.fiDiachiNxk;
                    data.fiSoHoadon = result.fiSoHoadon;
                    var dat = new Date(result.fiNgayCapHd);
                    data.fiNgayCapHd = dat.getDate()+"/"+dat.getMonth()+"/"+dat.getFullYear();
                    data.fiSoluong = result.fiSoluong;
                    data.fiTong = result.fiTong
                    if (!!result.ngayphathanhhd && result.ngayphathanhhd != undefine)
                        data.fiNgayCapHd = new Date(result.ngayphathanhhd).toDayFirstString();
                    data.fiSoluong = result.fiSoluong;
                    data.fiTong = result.fiTong;

                    var d = new Date(result.fiNgayDk);
                    data.fiNgayDk = d.toDayFirstString();
                        
                    //Thong tin hang hoa`
                    var product = null;
                    console.log(result);
                    /*if (result.lstHanghoa !== null) {
                        for (var i = 0, j = result.lstHanghoa.length; i < j; i++) {
                            product = result.lstHanghoa[i];
                            data.toKhaiHQD1.push({
                                fiMaHs: product.maHang,
                                fiTenHh: product.tenHang,
                                fiKlSl: product.luong,
                                fiTenDv: product.maDvt,
                                fiIdTk: result.tkid
                            });
                        }
                    }*/
                    if (id <= 0) { 
                        data.fiIdTk = 1 - (self.List.length - 1);
                    }
                    popup.find('#lbTKSo').text(data.fiSoTk);
                    popup.find('#lbTKMaHq').text(data.fiMaHq);                    
                    popup.find('#lbTKNgayDK').text(data.fiNgayDk);
                    //Luu tam lai de lat day vao danh sach to khai neu nguoi dung nhan button luu
                    tokhaiData = data;
                    //Bind data
                    self.buildPager(data.toKhaiHQD2s);
                    
                    popup.find('#cbAllProducts').off('click').on('click', function (e) {
                        var me = $(this);
                        //e.preventDefault();

                        var status = me.attr("data");
                        if (status === "1") {
                            status = false;
                            me.attr("data", "0");
                        } else {
                            status = true;
                            me.attr("data", "1");
                        }
                        $('#tokhai-hanghoa-container input').each(function () {
                            $(this).prop("checked", status);
                        });
                        //return false;
                    });
                });
            };

            popup.find('.date-picker').datepicker({rtl: false, orientation: "left", autoclose: true});
            $(popup.find('.tokhai-form')[0]).attr('id', 'tokhai-form-popup');
            $(popup.find('.tokhai-hanghoa-pager')[0]).attr('id', 'tokhai-hanghoa-pager');
            $(popup.find('.tokhai-hanghoa-container')[0]).attr('id', 'tokhai-hanghoa-container');

            popup.find('#btnToKhaiSearch').off('click').on('click', function (e) {
                searchFun();
                return false;
            });
            
             popup.find('#fiDVHQ').off('change').on('change', function (e) {
                var _self = $(this);
                popup.find('#fiMaHq').val(_self.val());    
                return;
            });
            
            //Fake data
            if (id <= 0) {
                popup.find('#fiSoTk').val('300002649611');
                popup.find('#fiNamdk').val('2014');
                popup.find('#fiMaHq').val('03PA');
            } 
        };

        if (id <= 0) {//Them moi to khai
            app.complieHtml({
                container: '#tokhai-tmpl',
                data: {}
            }, callback);

        } else { //Chinh sua thong tin to khai
            var i = self.List.Search('fiIdTk', id);
            if (i > -1) {
                
                var op = {};
                $(self.List).each(function(index, element){
                    if(id == element.fiIdTk){
                        op.data=element;
                    }
                })
                var data = {};
                data.fiSoTk = op.data.fiSoTk;
                data.fiMaHq = op.data.fiMaHq;
                 var date = new Date(op.data.fiNgayDk);
                var year = date.getFullYear();
                data.fiNamdk = year;
                op.data.fiNamdk=year;
                tempData = op;
                op.container = '#tokhai-tmpl';
                app.complieHtml(op, callback);
            }
        }
    },
    getDetailDeclaration: function (obj, cb) {
        var data = {};
        data.mst = '';
        data.sotk = obj.fiSoTk;
        data.mahq = obj.fiMaHq;
        data.namdk = obj.fiNamdk;
        app.makePost({
            url: '/most/02/tokhai',
            data: JSON.stringify(data),
            success: function (d) {
                if (d.success && d.data.sotk !== null) {
                    cb(d);
                } else {
                    app.Alert(NSWLang["common_msg_khonglayduocthongtintokhai"]);
                }
            },
            error: function (e) {
                app.toast({
                    title: NSWLang["common_msg_thong_bao"],
                    message: NSWLang["common_msg_he_thong_chua_san_sang"],
                    function: 'success'
                });
            }
        });
    },
    selfRequestDetailDeclaration: function (id) {
        var self = this;
        
        self.getDetailDeclaration(data, function (d) {
            var result = d.data;
            data.toKhaiHQD2s = [];

            data.fiSoHoadon = result.sohd;
            data.fiNguoiNk = result.tendvdt;
            data.fiNuocXk = result.nuocxk;
            data.fiNgayCapHd = new Date(result.ngayphathanhhd).toDayFirstString();
            data.fiSoluong = result.soluongkien;
            data.fiTong = result.tongtrongluong;
            data.fiNuocNk = result.nuocnk;

            var product = null;
            if (result.lstHanghoa !== null) {
                for (var i = 0, j = result.lstHanghoa.length; i < j; i++) {
                    product = result.lstHanghoa[i];
                    data.toKhaiHQD2s.push({
                        fiMaHs: product.maHang,
                        fiTenHh: product.tenHang,
                        fiKlSl: product.luong,
                        fiTenDv: product.maDvt,
                        fiIdTk: result.tkid
                    });
                }
            }

            var i = self.List.Search('fiIdTk', id);
            if (i > -1) {
                self.List[i] = data;
            }
        });
    },
    buildPager: function (obj) {
        var self = this;
        self.bindGrid();
        var pages = JsPaginate.paginate(self.pagination.pageSize, obj);
        var bindGrid = function (lst) {
            app.complieTemplate({
                ministryCode: self.ministryCode,
                code: self.code,
                templateName: self.templates[2],
                data: lst
            }, function (html) {
                $('#tokhai-hanghoa-container').html(html);
            });
        };

        if (pages.length > 0) {
            bindGrid(pages[self.pagination.currentPage].items);
        } else {
            bindGrid([]);
        }
        JsPaginate.buildPage(document.getElementById('tokhai-hanghoa-pager'), pages, function (data) {
            self.bindGrid(data);
        });
    },
    isVaild: function () {
        if (this.List === null || (this.List !== null && this.List.length === 0)) {
            app.Alert(NSWLang["common_msg_chuanhapthongtin"] + NSWLang["most_02_tokhai_popup_thongtintokhai"]);
            return false;
        }
        return true;
    },
}
