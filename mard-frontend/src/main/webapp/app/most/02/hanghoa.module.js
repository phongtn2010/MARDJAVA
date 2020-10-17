var HangHoaController = function () {};
HangHoaController.prototype = {
    ministryCode: 'most',
    code: '02',
    templates: ['hanghoa-danhsach'],
    pagination: {
        isReady: false,
        currentPage: 0,
        pageSize: 10
    },
    container: null,
    List: [],
    IsView: null,
    init: function (obj) {
        var op = $.extend(true, {}, obj);
        this.loadTemplates();
        if (obj.hasOwnProperty('hangHoa')) {
            if (op.hangHoa != null) {
                for (i = 0; i < op.hangHoa.length; i++) {
                    delete op.hangHoa[i].errors;
                }
            }
            this.List = op.hangHoa;
            if (this.List == null)
                this.List = [];
        }
        this.IsView = op.IsView;
        this.container = "#" + op.container;
        this.loadTemplates();
        this.registerEvents();

        this.buildPager();
    },
    setData: function (obj) {
        var op = $.extend(true, {}, obj);
        if (!op.hasOwnProperty('hangHoa')) {
            this.List = [];
            this.Pages = [];

        } else {
            this.List = op['hangHoa'] != null ? op['hangHoa'] : [];
        }
        this.buildPager();
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
        $("#btnThemMoiHangHoa").on('click', function (e) {
            e.preventDefault();
            self.addPopup(null);
            return false;
        });
    },
    bindGrid: function (data) {
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
            data: list,
            container: self.container
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
            var i = self.List.Search('fiIdHh', id);
            var docCode = me.attr('code');
            if (i >= 0) {
                var pop = app.popup({
                    title: NSWLang["common_msg_thong_bao"],
                    html: '<i class="fa fa-3x fa-warning"></i> ' + NSWLang["most_common_msg_xoahanghoa"] + ' <b>' + docCode + '</b>',
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
                                self.buildPager();

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
    },
    addPopup: function (id) {
        var self = this;
        var callback = function (html) {
            
            var cb = function (_popup) {// reset dropdown
                    
                $(_popup.find('.hanghoa-form')[0]).attr('id', 'hanghoa-form-popup');
                var cbfiMaCuakhau = _popup.find('#fiMaCuakhau'),
                        cbfiMaQg = _popup.find('#fiMaQg'),
                        cbfiMaDv = _popup.find('#fiMaDv'),
                        cbfiMaLoaiHh = _popup.find('#fiMaLoaiHh');

                cbfiMaCuakhau.val(cbfiMaCuakhau.attr('data'));
//                $('#fiMaLoaiHh').change();

                cbfiMaLoaiHh.change( function(){                    
                    if(cbfiMaLoaiHh.val() == '-1'){
                       _popup.find(".ptdo").attr('style','display:none');
                       _popup.find(".donggoi").attr('style','display:none');
                    }
                    else if(cbfiMaLoaiHh.val() == '1'){ // loai doi tuong phuong tien do
                         _popup.find("option[value='"+_popup.find("#fiTenHh2").attr("data")+"']").attr('selected','selected');
                         $(_popup.find("#fiTenHh2")).change()
                        _popup.find(".donggoi").attr('require',false);
                        _popup.find(".ptdo").attr('require',true);
                        _popup.find(".donggoi").attr('style','display:none');
                        _popup.find(".ptdo").attr('style','display:block');
                        _popup.find("#fiMaHh").val($("#fiMaHh").attr("data"));
                    }
                    else if(cbfiMaLoaiHh.val() == '2'){// loai doi tuong hang dong goi
                         _popup.find(".donggoi").attr('require',true);
                        _popup.find(".ptdo").attr('require',false);
                        _popup.find(".ptdo").attr('style','display:none');
                        _popup.find(".donggoi").attr('style','display:block');
                    }
                });
                cbfiMaLoaiHh.val(cbfiMaLoaiHh.attr('data'));
                cbfiMaLoaiHh.change();
                cbfiMaQg.val(cbfiMaQg.attr('data'));
                cbfiMaQg.change(function () {
                    _popup.find('#fiTenQg').attr('value', $(this).find("option:selected").text());
                });

                cbfiMaDv.val(cbfiMaDv.attr('data'));
                cbfiMaDv.change(function () {
                    _popup.find('#fiTenDv').attr('value', $(this).find("option:selected").text());
                });

                _popup.find('.select2').select2({width: 435});
            };
            
            var popup = app.popup({
                title: "Thêm mới đối tượng",
                html: html,
                width: 800,
                buttons: [
                    {
                        name: NSWLang["common_button_luu"],
                        class: 'btn blue',
                        icon: 'fa-save',
                        action: function () {
                            var isOk = app.isFormVaild('hanghoa-form-popup');
                            if (!isOk)
                                return;

                            var data = app.form2Object('#hanghoa-form-popup');
                            
                            if(data.fiMaLoaiHh == 1){ //phuong tien do
                                data.fiTenHh = data.fiTenHh2;
                                data.fiTenLoaiHh = NSWLang["most_02_hanghoa_loaidoituong_pt_do"];
                            }
                            else if(data.fiMaLoaiHh == 2){ // hang dong goi san
                                data.fiTenHh = data.fiTenHh1;
                                data.fiTenLoaiHh =NSWLang["most_02_hanghoa_loaidoituong_hangdonggoi"];
                            }
                            delete data.fiTenHh2;
                            delete data.fiTenHh1;
                            data.fiIdHh = id;
                            data.fiTenDv = popup.find('#fiTenDv').attr('value');
                            data.fiTenQg = popup.find('#fiTenQg').attr('value');
                            data.fiTenCuakhau = popup.find('#fiMaCuakhau').find("option:selected").text();
                            
                            var fromDate = data.fiNkTu.trim().toValidDate();
                            var toDate = data.fiNkDen.trim().toValidDate();
                            if (Util.compareDate(fromDate, toDate) === 1) {
                                app.Alert(NSWLang['most_02_hanghoa_ngaybatdaunk'] + ' <b>' + NSWLang['common_msg_khonglonhon'] + '</b> ' + NSWLang['most_02_hanghoa_ngayketthucnk']);
                                return false;
                            }
                            if (id === null) {
                                data.fiIdHh = 1 - (self.List.length + 1);
                                self.List.push(data);
                                
                            } else {
                                var i = self.List.Search('fiIdHh', id);
                                if (i > -1) {
                                    self.List[i] = data;
                                }
                            }
                            self.buildPager();                            
                            app.toast({
                                title: NSWLang["common_msg_thong_bao"],
                                message: NSWLang["common_msg_cap_nhat_du_lieu_thanh_cong"],
                                function: 'success'
                            });

                            app.popupRemove(popup.selector);
                        }
                    }
                ]
            }, cb);
        };

        if (id == null) {
            app.complieHtml({
                container: '#hanghoa-tmpl',
                data: {}
            }, callback);
        } else {
            var i = self.List.Search('fiIdHh', id);
            if (i > -1) {
                var op = {};
                op.data = self.List[i];
                op.container = '#hanghoa-tmpl';
                app.complieHtml(op, callback);
                
            }
        }
        $('.date-picker').datepicker({rtl: false, orientation: "left", autoclose: true});
    },
    buildPager: function () {
        var self = this;
        var pages = JsPaginate.paginate(self.pagination.pageSize, self.List);

        if (pages.length > 0) {
            self.bindGrid(pages[self.pagination.currentPage].items);
        } else {
            self.bindGrid([]);
        }
        JsPaginate.buildPage(document.getElementById('hanghoa-pager'), pages, function (data) {
            self.bindGrid(data);
        });
    },
    isVaild: function () {
        if (this.List === null || (this.List !== null && this.List.length === 0)) {
            app.Alert(NSWLang["common_msg_chuanhapthongtin"] + NSWLang["most_01_hanghoa_thongtinhanghoa"]);
            return false;
        }
        return true;
    },
    validateData : function(){
        var isValid = true;
        var lst = this.List;
        var l = lst.length;
        for(var i = 0; i < l; i++){
            if(!lst[i].fiTenHh || !lst[i].fiKlSl || !lst[i].fiMaDv || !lst[i].fiNhanHh || !lst[i].fiKyhieu
                    || !lst[i].fiThongsoKt || !lst[i].fiMaQg || !lst[i].fiMaCuakhau || !lst[i].fiNkTu || !lst[i].fiNkDen){
                isValid = false;
                return false;
            }
        }
        return isValid;
    },
    addProductFromToKhai: function (obj) {
        var self = this;        
        if (self.List.Search('fiMaHs', obj.fiMaHs) < 0) {
            obj.fiIdHh = 1 - (self.List.length + 1);
            self.List.push(obj);
        }
    }
};

