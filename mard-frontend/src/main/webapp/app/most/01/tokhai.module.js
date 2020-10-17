/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var ToKhaiController = function () { };
ToKhaiController.prototype = {
    ministryCode: 'most',
    code: '01',
    templates: ['tokhai-danhsach', 'tokhai-chitiet', 'tokhai-hanghoa'],
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

        if (!obj.hasOwnProperty('toKhaiHQ')) {
            this.List = [];
        } else {
            this.List = obj['toKhaiHQ'] !== null ? obj['toKhaiHQ'] : [];
        }

        this.List.forEach(function (item) {
            item.IsView = obj.IsView;
        });

        this.loadTemplates();
        this.registerEvents();
        this.bindGrid();
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
            app.makePost({
                url: '/most/01/checksession',
                data: JSON.stringify({}),
                success: function (d) {
                    e.preventDefault();
                    self.addPopup(-1);
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
    bindGrid: function () {
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
            data: self.List
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
    isVaild: function () {
        if (this.List === null || (this.List !== null && this.List.length === 0)) {
            app.Alert(NSWLang["common_msg_chuanhapthongtin"] + NSWLang["most_01_tokhai_popup_thongtintokhai"]);
            return false;
        }
        return true;
    },
    view: function (id) {
        var self = this;

        var callback = function (html) {
            var popup = app.popup({
                title: NSWLang["most_01_tokhai_popup_thongtintokhai"],
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
        var ngayCapHd =new Date(self.List[0].fiNgayCapHd);
        var ngayCapHd =new Date(self.List[0].fiNgayCapHd);
        self.List[0].fiNgayCapHd=new Date(self.List[0].fiNgayCapHd);
        self.List[0].fiNgayDk=new Date(self.List[0].fiNgayDk);
        console.log(self.List[0].fiNgayCapHd);
        app.complieTemplate({
            ministryCode: self.ministryCode,
            code: self.code,
            templateName: self.templates[1],
            data: self.List[i]
        }, callback);
    },
    addPopup: function (id) {
        var self = this;
        var namDk;
        var callback = function (html) {
            var tokhaiData = null;

            var popup = app.popup({
                title: NSWLang["most_01_tokhai_popup_thongtintokhai"],
                html: html,
                width: 850,
                buttons: [
                    {
                        name: NSWLang["common_button_luu"],
                        class: 'btn',
                        icon: 'fa-check',
                        action: function () {
                            app.makePost({
                                url: '/most/01/checksession',
                                data: JSON.stringify({}),
                                success: function (d) {
                                    var data = null;
                                    var formData = app.form2Object('#tokhai-form-popup');

                                    if (tokhaiData !== null) {
                                        data = tokhaiData;

                                        if (id <= 0) {
                                            if (self.List.Search('fiSoTk', formData.fiSoTk) > -1
                                                && self.List.Search('fiMaHq', formData.fiMaHq) > -1) {
                                                //app.Alert(NSWLang['common_msg_datontaitokhai']);
                                                //return;
                                            } else {
                                                data.fiIdTk = 1 - (self.List.length - 1);
                                                self.List.push(data);
                                            }
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
                                            window.detailDocument.hangHoa.addProductFromToKhai({
                                                'fiTenHh': me.attr('fiTenHh'),
                                                'fiMaDv': me.attr('fiTenDv'),
                                                'fiKlSl': me.attr('fiKlSl'),
                                                'fiMaHs': me.attr('fiMaHs'),
                                                'fiMaql': me.attr('fiMaql'),
                                                'fiSoTk': formData.fiSoTk
                                            });
                                            //refresh lish
                                            window.detailDocument.hangHoa.buildPager();
                                        });
                                        //Nếu vượt quá 255 thì ko cho lưu
                                        var checkTenHangHoa;
                                        var tenHang;
                                        $('.table_tokhai_hanghoa tr').each(function () {
                                            var hangHoa = this.cells[3].innerHTML;
                                            if (hangHoa.length >= 255) {
                                                checkTenHangHoa = true;
                                                tenHang = hangHoa;
                                                return;
                                            } else {
                                                checkTenHangHoa = false;
                                            }
                                        });

                                        if (checkTenHangHoa) {
                                            app.Alert(NSWLang['most_01_hanghoa_kiemtra_dodai_tenhang'] + ": " + tenHang);
                                        } else {
                                            app.popupRemove(popup.selector);
                                        }
                                    } else {
                                        app.Alert(NSWLang["common_msg_khonglayduocthongtintokhai"]);
                                    }

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
            });

            var searchFun = function (namdk) {
                var isOk = app.isFormVaild('tokhai-form-popup');
                if (!isOk){
                    return;
                }
                    
                isOk = self.checkNamToKhai(namdk);
                if (!isOk){
                   return;
                }
                    
                var data = app.form2Object('#tokhai-form-popup');
                data.fiIdTk = id;

                //Lay thong tin to khai
                self.getDetailDeclaration(data, function (d) {
                    var result = d.data;

                    data.toKhaiHQD1 = [];

                    data.fiSoluong = result.fiSoluong;
                    data.fiTong = result.fiTong;
                    data.fiDtNnk = result.fiDtNnk;

                    data.fiSoHoadon = result.fiSoHoadon;
                    data.fiNgayCapHd = new Date(result.fiNgayCapHd).toDayFirstString();
                    var d = new Date(result.fiNgayDk);
                    data.fiNgayDk = d.toDayFirstString();

                    data.fiNguoiNk = result.fiNguoiNk;
                    data.fiDiachiNnk = result.fiDiachiNnk;
                    data.dienthoaiDvNK = result.dienthoaiDvNK;
                    data.fiNuocNk = result.fiNuocNk;

                    data.fiNguoiXk = result.fiNguoiXk;
                    data.fiDiachiNxk = result.fiDiachiNxk;
                    data.fiNuocXk = result.fiNuocXk;

                    //Thong tin hang hoa
                    var product = null;
                    if (result.lstHanghoa !== null) {
                        for (var i = 0, j = result.lstHanghoa.length; i < j; i++) {
                            product = result.lstHanghoa[i];
                            data.toKhaiHQD1.push({
                                fiMaHs: product.fiMaHs,
                                fiTenHh: product.fiTenHh,
                                fiKlSl: product.fiKlSl,
                                fiTenDv: product.fiTenDv,
                                fiIdTk: result.fiIdTk,
                                fiMaql: product.fiMaQl
                            });
                        }
                    }

                    if (id <= 0) {
                        data.fiIdTk = 1 - (self.List.length - 1);
                    }
                    popup.find('#lbTKSo').text(data.fiSoTk);
                    popup.find('#lbTKMaHq').text(data.fiMaHq);
                    popup.find('#lbTKNgayDK').text(data.fiNgayDk);
                    //Luu tam lai de lat day vao danh sach to khai neu nguoi dung nhan button luu
                    tokhaiData = data;
                    //Bind data                    
                    self.buildPager(data.toKhaiHQD1);
                });
            };

            $(popup.find('.tokhai-form')[0]).attr('id', 'tokhai-form-popup');
            $(popup.find('.tokhai-hanghoa-pager')[0]).attr('id', 'tokhai-hanghoa-pager');
            $(popup.find('.tokhai-hanghoa-container')[0]).attr('id', 'tokhai-hanghoa-container');

            popup.find('#btnToKhaiSearch').off('click').on('click', function (e) {
                var namDangKy = popup.find('#fiNamdk').val();
                searchFun(namDangKy);
                return false;
            });

            popup.find('#cbAllProducts').off('click').on('click', function (e) {
                var me = $(this);
                //e.preventDefault();

                var status = me.attr("data");
                if (status === "0") {
                    status = true;
                    me.attr("data", "1");
                } else {
                    status = false;
                    me.attr("data", "0");
                }
                $('#tokhai-hanghoa-container input').each(function () {
                    $(this).prop("checked", status);
                });
                //return false;
            });

            popup.find('#fiDVHQ').off('change').on('change', function (e) {
                var _self = $(this);
                popup.find('#fiMaHq').val(_self.val());
                return;
            });

           // Fake data
            if (id <= 0) {//Them moi to khai


            } else { //Chinh sua thong tin to khai
                var i = self.List.Search('fiIdTk', id);
                if (i > -1) {
                    popup.find('#fiNamdk').val(namDk);
                    popup.find('#btnToKhaiSearch').click();
                }
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
                op.data = self.List[i];
                var date = new Date(op.data.fiNgayDk);
                op.data.fiNamdk=date.getFullYear();
                namDk=date.getFullYear();
                op.container = '#tokhai-tmpl';
                console.log(op);
                app.complieHtml(op, callback);
            }
        }
    },
    checkNamToKhai: function (namdk) {
        var check = true;
        if (isNaN(namdk) || namdk.length >= 5 || namdk.length < 4) {
            check =false;
            app.Alert(NSWLang["most_01_tokhai_invalid_year"]);
        } 
        return check;
    }
    ,
    getDetailDeclaration: function (obj, cb) {
        var data = {};
        data.mst = '';
        data.sotk = obj.fiSoTk;
        data.mahq = obj.fiMaHq;
        data.namdk = obj.fiNamdk;
        app.makePost({
            url: '/most/01/tokhai',
            data: JSON.stringify(data),
            success: function (d) {
                console.log(d);
                if (d.success && d.data.fiSoTk !== null) {
                    cb(d);
                } else {
                    app.Alert(NSWLang["common_msg_khonglayduocthongtintokhai"]);
                }
            },
            error: function (e) {
                console.log(e);
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
            data.toKhaiHQD1 = [];

            data.fiSoHoadon = result.sohd;
            data.fiNguoiNk = result.tendvdt;
            data.fiNuocXk = result.nuocxk;
            data.fiSoHoadon = result.sohd;
            data.fiNgayCapHd = new Date(result.ngayphathanhhd).toDayFirstString();
            data.fiSoluong = result.soluongkien;
            data.fiTong = result.tongtrongluong;
            data.fiNuocNk = result.nuocnk;

            var product = null;
            if (result.lstHanghoa !== null) {
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
            }

            var i = self.List.Search('fiIdTk', id);
            if (i > -1) {
                self.List[i] = data;
            }
        });
    },
    buildPager: function (obj) {
        var self = this;
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
};
