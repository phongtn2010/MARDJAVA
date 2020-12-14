/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var GiayChungNhanHangHoa = function () { };
GiayChungNhanHangHoa.prototype = {
    ministryCode: 'most',
    code: '01',
    pagination1: {
        currentPage: 0,
        pageSize: 10
    },
    pagination2: {
        currentPage: 0,
        pageSize: 10
    },
    data: {
        list1: [], //Hang hoa co giay chung nhan chua duoc chon
        list2: [] //Hang hoa co giay chung nhan duoc chon
    },
    fiIdDinhkem: 0,
    lstHangHoa: [],
    templates: ['gcn-hh', 'gcn-hh-item', 'gcn-hh-item2'],
    init: function (obj) {
        this.loadTemplates();
        //Lay hang hoa tu danh sach hang hoa
        this.lstHangHoa = window.detailDocument.hangHoa.List;
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
    addPopup: function (id) {
        var self = this;
        self.fiIdDinhkem = id;
        //Gan lai danh sach hang hoa hien tai
        self.lstHangHoa = window.detailDocument.hangHoa.List;
        
        //Reset lai danh sach cua giay chung nhan
        if(id !== self.fiIdDinhkem)
            self.resetData();        
        
        var callback = function (html) {
            var cb = function (_popup) {                
                //Lay hang hoa da thuoc giay chung nhan nay
                self.data.list2 = self.lstHangHoa.getArray('fiIdDinhkem', self.fiIdDinhkem);                
                //Lay hang hoa co giay chung nhan nhung chua thuoc vao data2
                self.data.list1 = self.lstHangHoa.getArrayAndNotExitsInOther('fiCoGcn', 1, 'fiIdDinhkem', self.data.list2);                
                self.bindData();                
            };

            var popup = app.popup({
                title: NSWLang["most_01_hanghoa_thongtinhanghoa"],
                html: html,
                width: 800,
                buttons: [
                    {
                        name: NSWLang["common_button_luu"],
                        class: 'btn blue',
                        icon: 'fa-save',
                        action: function () {
                            $('#badge-' + self.fiIdDinhkem).text(self.data.list2.length);
                            if(self.fiIdDinhkem !== '0')
                                self.updateHangHoaList(self.fiIdDinhkem);
                            app.popupRemove(popup.selector);
                        }
                    }
                ]
            }, cb);
        };

        app.complieTemplate({
            ministryCode: self.ministryCode,
            code: self.code,
            templateName: self.templates[0]
        }, function (html) {
            callback(html);
        });
    },
    bindData: function(){
        this.buildPager('#gcn-hh-container1', 'gcn-hh-pager1', 1, this.pagination1, this.data.list1);
        this.buildPager('#gcn-hh-container2', 'gcn-hh-pager2', 2, this.pagination2, this.data.list2);
    },
    buildPager: function (container, pagerId, tmpl, pagination, store) {
        var self = this;
        var pages = JsPaginate.paginate(pagination.pageSize, store);

        if (pages.length > 0) {
            self.bindGrid(container, tmpl, pages[pagination.currentPage].items);
        } else {
            self.bindGrid(container, tmpl, []);
        }

        JsPaginate.buildPage(document.getElementById(pagerId), pages, function (data) {
            self.bindGrid(container, tmpl, data);
        });
    },
    bindGrid: function (container, tmpl, data) {
        var self = this;

        var cb = function (html) {
            $(container).html(html);
            self.bindEventsGrid(container);
        };

        app.complieTemplate({
            ministryCode: self.ministryCode,
            code: self.code,
            templateName: self.templates[tmpl],
            data: data,
            container: container
        }, cb);

    },
    bindEventsGrid: function (container) {
        var self = this;
        var con = $(container);

        con.find('.fa-arrow-down').off('click').on('click', function (e) {
            e.preventDefault();
            var me = $(this);
            var id = me.attr('item');
            var i = self.data.list1.Search('fiIdHh', id);
            if (i >= 0) {
                self.data.list1[i]['fiIdDinhkem'] = self.fiIdDinhkem;
                self.data.list2.push(self.data.list1[i]);                
                self.data.list1.splice(i, 1); 
                self.bindData();
            }
            return false;
        });

        con.find('.fa-remove').off('click').on('click', function (e) {
            e.preventDefault();
            var me = $(this);
            var id = me.attr('item');
            var i = self.data.list2.Search('fiIdHh', id);

            if (i >= 0) {
                var pop = app.popup({
                    title: NSWLang["common_msg_thong_bao"],
                    html: '<i class="fa fa-3x fa-warning"></i> ' + NSWLang["most_common_msg_xoadanhmuchanghoa"],
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
                                
                                self.data.list2[i]['fiIdDinhkem'] = null;
                                var hhId = self.data.list2[i].fiIdHh;
                                var idx = window.detailDocument.hangHoa.List.Search('fiIdHh', hhId);
                                if(idx >= 0){                
                                    window.detailDocument.hangHoa.List[idx]['fiIdDinhkem'] = null;
                                    console.log(hhId, window.detailDocument.hangHoa.List[idx]);
                                }
                                
                                self.data.list1.push(self.data.list2[i]);
                                self.data.list2.splice(i, 1);
                                
                                self.bindData();
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
    resetData: function () {
        this.data.list1 = [];
        this.data.list2 = [];
        $('#badge-0').text('0');
        this.fiIdDinhkem = null;        
    },
    updateHangHoaList: function(fiIdDinhKem){        
        var len = this.data.list2.length;               
        var idx = 0;
        for(var i = 0; i < len; i++){
            idx = window.detailDocument.hangHoa.List.Search('fiIdHh', this.data.list2[i]['fiIdHh']);
            
            if(idx >= 0){                
                window.detailDocument.hangHoa.List[idx]['fiIdDinhkem'] = fiIdDinhKem;
            }
            idx = -1;
        }
        //Reset 
        this.resetData();
    },
    removeHangHoa: function(fiIdGcn){
        var len = window.detailDocument.hangHoa.List.length;        
        var idx = 0;
        for(var i = 0; i < len; i++){
            idx = window.detailDocument.hangHoa.List.Search('fiIdDinhkem', fiIdGcn);
            if(idx >= 0){                
                window.detailDocument.hangHoa.List[idx]['fiIdDinhkem'] = null;
            }
            idx = -1;
        }
    }
};

