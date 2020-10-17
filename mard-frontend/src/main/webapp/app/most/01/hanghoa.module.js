/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var NHH_DO_CHOI_TRE_EM = 3, //2
        NHH_XANG_DIEZEN = 1, //1
        NHH_THEP_COT_BETONG = 5, //2
        NHH_THEP = 8, //2
        NHH_MU_BAO_HIEM = 2, //2
        NHH_KHI_DAU_MO = 6, //1
        NHH_KHAC = 7, //1
        NHH_CAC_THIET_BI_DT = 4;//2

var HangHoaController = function () { };
HangHoaController.prototype = {
    ministryCode: 'most',
    code: '01',
    templates: ['hanghoa-danhsach', 'nhomhanghoa'],
    pagination: {
        isReady: false,
        currentPage: 0,
        pageSize: 10
    },
    container: null,
    pager: null,
    List: [],
    init: function (obj) {
        var op = $.extend(true, {}, obj);
        this.container = '#{0}'.format(op.container);
        if (obj.hasOwnProperty('pager')) {
            this.pager = '#{0}'.format(op.pager);
        }

        if (!obj.hasOwnProperty('hangHoa1')) {
            this.List = [];
            this.Pages = [];

        } else {
            this.List = obj['hangHoa1'] != null ? obj['hangHoa1'] : [];
        }

        //Set IsView cua tat ca cac item co trong danh sach 
        this.List.forEach(function (item) {
            item.IsView = obj.IsView;
        });
        //Load tat ca cac template va cache vao client
        this.loadTemplates();
        this.registerEvents();
        //Phan trang
        this.buildPager();
    },
    setData: function (obj) {
        var op = $.extend(true, {}, obj);
        if (!op.hasOwnProperty('hangHoa1')) {
            this.List = [];
            this.Pages = [];

        } else {
            this.List = op['hangHoa1'] != null ? op['hangHoa1'] : [];
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
                app.makePost({
                    url: '/most/01/checksession',
                    data: JSON.stringify({}),
                    success: function (d) {
                        e.preventDefault();
                        self.addPopup(null);
                        return false;
                    },
                    error: function (e) {
                        app.popup({
                            title: 'Thông báo',
                            html: '<i class="fa fa-3x fa-warning"></i> <b> Đã hết phiên đăng nhập, vui lòng đăng nhập lại </b>',
                            width: 850,
                            buttons: [
                                {
                                    name: 'Quay lại trang đăng nhập',
                                    class: 'btn',
                                    icon: 'fa-check',
                                    action: function () {
                                        location.href = app.appContext + "/login";
                                    }
                                }
                            ]
                        });
                        window.setTimeout(function(){
                            window.location.href = app.appContext + "/login";
                        }, 5000);
                    }
                });

        });
    },
    bindGrid: function (data) {
        var self = this;
        var cb = function (html) {
            $(self.container).html(html);
            self.bindEventsGrid();
            $(self.container).find('.tooltips').tooltip();
        };

        app.complieTemplate({
            ministryCode: self.ministryCode,
            code: self.code,
            templateName: self.templates[0],
            data: data,
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
    isVaild: function () {
        if (this.List === null || (this.List !== null && this.List.length === 0)) {
            app.Alert(NSWLang["common_msg_chuanhapthongtin"] + NSWLang["most_01_hanghoa_thongtinhanghoa"]);
            return false;
        }
        var countItem = this.List.length;
        for (var i = 0; i < countItem; i++) {
            if (this.isProductVaild(this.List[i]) === false) {
                app.Alert(this.List[i].fiTenHh + ': ' + NSWLang['common_msg_loinhaplieu']);
                return false;
            }
        }
        return true;
    },
    isProductVaild: function (obj) {

        if (obj === null || (obj !== null && !obj.hasOwnProperty('fiKyhieu')))
            return false;
        if (obj.fiManhom === '' || obj.fiManhom === null ||
                obj.fiTenHh === '' || obj.fiTenHh === null ||
                obj.fiMaHs === '' || obj.fiMaHs === null ||
                obj.fiNhanHh === '' || obj.fiNhanHh === null ||
                obj.fiThongsoKt === '' || obj.fiThongsoKt === null ||
                obj.fiMaQg === '' || obj.fiMaQg === null ||
                obj.fiKlSl === '' || obj.fiKlSl === null ||
                obj.fiMaDv === '' || obj.fiMaDv === null ||
                obj.fiKyhieu === '' || obj.fiKyhieu === null) {

            return false;
        }
        return true;
    },
    isFullLicense: function () {
        var isOK = true;

        for (var i = 0, len = this.List.length; i < len; i++) {
            if (this.List[i].fiCoGcn === 0) {
                isOK = false;
                break;
            }
        }
        return isOK;
    },
    isNoLisence: function () {
        var isOK = true;

        for (var i = 0, len = this.List.length; i < len; i++) {
            if (this.List[i].fiCoGcn === 0 && (this.List[i].fiIdDinhkem === null || this.List[i].fiIdDinhkem === '')) {
                isOK = false;
                break;
            }
        }
        return isOK;
    },
    hasLisenceButNoAttach: function () {
        var nameOfProduct = null;

        for (var i = 0, len = this.List.length; i < len; i++) {
            if (this.List[i].fiCoGcn === 1 && (this.List[i].fiIdDinhkem === null || this.List[i].fiIdDinhkem === '')) {
                nameOfProduct = this.List[i].fiTenHh;
                break;
            }
        }
        return nameOfProduct;
    },
    checkProductLisence: function () {
        if (this.List === null || (this.List !== null && this.List.length === 0)) {
            return false;
        }

        for (var i = 0, len = this.List.length; i < len; i++) {
            if (this.List[i].fiCoGcn === 1) {
                return true;
            }
        }

        return false;
    },
    addPopup: function (id) {
        var self = this;
        var callback = function (html) {

            var cb = function (_popup) {
                $(_popup.find('.hanghoa-form')[0]).attr('id', 'hanghoa-form-popup');
                var cbfiMaNhomHh = _popup.find('#fiManhom'),
                        cbfiMaQg = _popup.find('#fiMaQg'),
                        cbfiMaDv = _popup.find('#fiMaDv'),
                        cbfiMaMk = _popup.find('#fiMaMk');

                //Fill du lieu vao drop nhom hang hoa theo loai ho so
                self.buildNhomHangHoaDdl(cbfiMaNhomHh);

                var txtOther = _popup.find('#fiNhomHhOther');
                //cbfiMaNhomHh.val(cbfiMaNhomHh.attr('data'));
                cbfiMaNhomHh.change(function () {
                    _popup.find('#fiNhomHh').attr('value', $(this).find("option:selected").text());

                    if ($(this).val() === '7') {
                        txtOther.show();
                        txtOther.focus();
                    } else {
                        txtOther.hide();
                    }
                });

                if (cbfiMaNhomHh.attr('data') === '7') {
                    txtOther.show();
                }

                cbfiMaQg.val(cbfiMaQg.attr('data'));
                cbfiMaQg.change(function () {
                    _popup.find('#fiTenQg').attr('value', $(this).find("option:selected").text());
                });

                cbfiMaDv.val(cbfiMaDv.attr('data'));
                cbfiMaDv.change(function () {
                    _popup.find('#fiTenDv').attr('value', $(this).find("option:selected").text());
                });

                cbfiMaMk.val(cbfiMaMk.attr('data'));
                cbfiMaMk.change(function () {
                    _popup.find('#fiLoaiMk').attr('value', $(this).find("option:selected").text());
                });

                _popup.find('.select2').select2({width: 435});

                var cbfiCoGcn = _popup.find('#fiCoGcn');
                if (cbfiCoGcn.attr('data') === '1') {
                    cbfiCoGcn.prop("checked", true);
                }
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
                            app.makePost({
                                url: '/most/01/checksession',
                                data: JSON.stringify({}),
                                success: function (d) {

                                    var isOk = app.isFormVaild('hanghoa-form-popup');

                                    if (!isOk)
                                        return;

                                    var data = app.form2Object('#hanghoa-form-popup');

                                    data.fiIdHh = id;

                                    data.fiLoaiMk = popup.find('#fiLoaiMk').attr('value');
                                    data.fiTenDv = popup.find('#fiMaDv').find("option:selected").text();//popup.find('#fiTenDv').attr('value');
                                    data.fiTenQg = popup.find('#fiTenQg').attr('value');
                                    data.fiNhomHh = popup.find('#fiNhomHh').attr('value');

                                    var txtOther = popup.find('#fiNhomHhOther');
                                    if (data.fiManhom === '7') {
                                        data.fiNhomHh = txtOther.val();
                                    } else {
                                        txtOther.hide();
                                    }
                                    if (data.fiManhom === '7' && (data.fiNhomHh == '' || data.fiNhomHh == null)) {
                                        txtOther.show();
                                        app.Alert(NSWLang['common_msg_chua_nhap'] + ' ' + NSWLang['most_01_hanghoa_nhomhanghoa']);
                                        txtOther.addClass('input-invaild');
                                        txtOther.focus();
                                        return;
                                    }

                                    if (data.fiMaMk === "-1") {
                                        data.fiLoaiMk = null;
                                    }
                                    if (data.fiCoGcn === 'on')
                                        data.fiCoGcn = 1;
                                    else
                                        data.fiCoGcn = 0;

                                    if (data.fiCoGcn === 0) {
                                        var idDk = data.fiIdDinhkem;
                                        var bag = $('#badge-' + idDk);
                                        var noProducts = bag.text();
                                        if (noProducts !== '0') {
                                            bag.text(noProducts - 1);
                                        }
                                        data.fiIdDinhkem = null;
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
                                },
                                error: function (e) {
                                    app.popup({
                                        title: 'Thông báo',
                                        html: '<i class="fa fa-3x fa-warning"></i> <b> Đã hết phiên đăng nhập, vui lòng đăng nhập lại </b>',
                                        width: 850,
                                        buttons: [
                                            {
                                                name: 'Quay lại trang đăng nhập',
                                                class: 'btn',
                                                icon: 'fa-check',
                                                action: function () {
                                                    location.href = app.appContext + "/login";
                                                }
                                            }
                                        ]
                                    });
                                    window.setTimeout(function(){
                                        window.location.href = app.appContext + "/login";
                                    }, 5000);
                                }
                            });
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
    addProductFromToKhai: function (obj) {
        var self = this;
        ////console.log(self.List.Search('fiMaql', obj.fiMaql), obj);
        if (self.List.Search('fiMaql', obj.fiMaql) < 0) {
            obj.fiIdHh = 1 - (self.List.length + 1);
            self.List.push(obj);
        }
    },
    buildNhomHangHoaDdl: function (ddl) {
        var self = this;
        var ddlDocumenttype = $('#fiDocumenttype');
        var docType = parseInt(ddlDocumenttype.val());

        var cb = function (html) {
            var dataId = ddl.attr('data');
            ddl.html(html);
            if (parseInt(dataId) > 0) {
                ddl.val(dataId);
            }
        };

        var data = window.detailDocument.lstNhomHangHoa.getArray('fiDocumenttype', docType);

        app.complieTemplate({
            ministryCode: self.ministryCode,
            code: self.code,
            templateName: self.templates[1],
            data: data
        }, cb);
    },
    isValidHangHoaWithDocumentType: function (docType) {
        var isOK = true;
        		
        if (docType == 2) {
            for (var i = 0, len = this.List.length; i < len; i++) {
                if ([NHH_DO_CHOI_TRE_EM, NHH_THEP_COT_BETONG, NHH_THEP, NHH_MU_BAO_HIEM, NHH_CAC_THIET_BI_DT].indexOf(parseInt(this.List[i].fiManhom)) < 0) {
                    isOK = false;
                    break;
                }
            }
        } else {
            for (var i = 0, len = this.List.length; i < len; i++) {
                if ([NHH_KHAC, NHH_KHI_DAU_MO, NHH_XANG_DIEZEN].indexOf(parseInt(this.List[i].fiManhom)) < 0) {
                    isOK = false;
                    break;
                }
            }
        }
        return isOK;
    }
};
