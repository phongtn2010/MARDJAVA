/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var IndexController = function () { };
IndexController.prototype = {
    ministryCode: 'moh',
    code: 'typea',
    templates: ['history', 'list'],
    pagination: {
        isReady: false,
        currentPage: 1,
        pageSize: 10
    },
    container: null,
    formSearch: null,
    pager: null,
    init: function (obj) {
        var op = $.extend(true, {}, obj);
        this.loadTemplates();
        this.registerEvents();
        this.bindEventsGrid();
        this.container = '#' + op.container;
        this.formSearch = '#' + op.form;
        this.pager = '#' + op.pager;
        $(".select2").select2({placeholder: '', width: null});
        $('.date-picker').datepicker({rtl: false, orientation: "left", autoclose: true, todayHighlight: true});
        this.search();
    },
    registerEvents: function () {
        var self = this;
        $("#searchHoSo").on('click', function (e) {
            e.preventDefault();
            self.pagination.currentPage = 1;
            self.pagination.isReady = false;
            self.search();
            return false;
        });
        $("#btnAddNew").on('click', function (e) {
            e.preventDefault();
            document.location = app.appContext + '/moh/06/hoso';
            return false;
        });

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
    bindEventsGrid: function () {
        var self = this;
        $('.fa-remove').off('click').on('click', function () {
            var me = $(this);
            var id = me.attr('doc');
            var postData = {
                fiIdHoso: id
            };
            var pop = app.popup({
                title: NSWLang["common_button_thong_bao"],
                html: '<b>' + NSWLang["common_msg_xoa_ho_so"] + '</b>',
                width: 400,
                height: 100,
                buttons: [
                    {
                        name: NSWLang["common_button_toi_chac_chan"],
                        class: 'btn',
                        icon: 'fa-check',
                        action: function () {
                            app.makePost({
                                url: '/moh/01/delete',
                                data: JSON.stringify(postData),
                                success: function (d) {
                                    var msg = '';
                                    var fun = 'success';
                                    if (d.success) {
                                        msg = NSWLang["common_msg_xoathanhcong"];
                                        app.popupRemove(pop.selector);
                                        self.search();
                                    } else {
                                        msg = data.message;
                                        fun = 'error';
                                    }
                                    self.announce(msg, fun);
                                    app.popupRemove(pop.selector);
                                },
                                error: function (e) {
                                    //console.log(e);
                                    app.popupRemove(pop.selector);
                                }
                            });
                        }
                    }
                ]
            });
        });
        $('.fa-history, .lsXuly').off('click').on('click', function () {
            var me = $(this);
            var loaiLs = "tacdong";
            if (me.attr("class") === "lsXuly") {
                loaiLs = "xuly";
            }
            var id = me.attr('doc');
            var code = me.attr('code');
            var mst = me.parents("tr").attr("data-mst");
            var tendn = me.parents("tr").attr("data-tendn");

            self.view({id: id, code: code, mst: mst, tendn: tendn, loai: loaiLs}, '/moh/01/history/', NSWLang["common_history_lichsuxuly"], 800, 0);
            return false;
        });
        $(".fa-pencil").off().on("click", function () {
            var me = $(this);
            document.location = app.appContext + '/moh/06/hoso/' + me.attr('doc');
        });
        $(".view").off().on('click', function (e) {
            var me = $(this);
            e.preventDefault();
            document.location = app.appContext + '/moh/06/view/' + me.attr('doc') + "/";
            return false;
        });
        $('.fa-book').off('click').on('click', function () {
            var me = $(this);
            document.location = app.appContext + '/moh/06/phieutiepnhan/' + me.attr('doc') + "/";
        });
        $(".fa-send").off('click').on('click', function () {
            var idHoso = $(this).attr('doc');
            var me = $(this);
            app.makePost({
                url: '/moh/01/gethoso/' + idHoso,
                success: function (d) {
                    if (d.success) {
                        var hoso = d.data;
                        if (self.validateHoso(hoso)) {
                            self.send(hoso);
                        }
                    } else {
                        onFail(d);
                    }
                },
                error: function (e) {
                    onFail(e);
                }
            });
            var onFail = function (d) {
                var message = NSWLang["common_msg_he_thong_chua_san_sang"]
                if (d.message != null) {
                    message = d.message;
                }
                self.announce(message, 'error');
            }
        });
    },
    search: function () {
        var self = this;
        var cb = function (data) {
            self.setupPager(data);
            self.bindEventsGrid();
        };
        if (app.isReady) {
            var post_data = self.initSearchForm();
            app.bindData({
                ministryCode: self.ministryCode,
                code: self.code,
                templateName: self.templates[1],
                container: self.container,
                url: '/moh/01/search',
                data: post_data
            }, cb);
        } else {
            self.announce(NSWLang["common_msg_he_thong_chua_san_sang"], 'error');
        }
    },
    initSearchForm: function () {
        var self = this;
        var obj = app.form2Object(self.formSearch);
        obj.pageSize = self.pagination.pageSize;
        obj.currentPage = self.pagination.currentPage - 1;
        return JSON.stringify(obj);
    },
    setupPager: function (data) {
        var self = this;
        if (!self.pagination.isReady || self.pagination.total !== data.total) {
            self.pagination.total = data.total;
            self.pagination.isReady = true;

            $('#lbTotalRecords').text(data.total);

            $(self.pager).pagination('destroy');
            $(self.pager).pagination({
                items: self.pagination.total,
                itemsOnPage: self.pagination.pageSize,
                cssStyle: 'light-theme',
                edges: 2,
                displayedPages: 5,
                prevText: '<',
                nextText: '>',
                onPageClick: function (pageNumber, event) {
                    self.pagination.currentPage = pageNumber;
                    self.search();
                }
            });
        }
    },
    view: function (postData, url, title, width, tmplIndex) {
        var self = this;
        var callback = function (html) {
            var popup = app.popup({
                title: "<span style='text-transform: uppercase'" > +title + "</span>",
                html: html,
                width: width,
                height: 500,
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
        app.makePost({
            url: url + postData.id,
            success: function (d) {
                app.complieTemplate({
                    ministryCode: self.ministryCode,
                    code: self.code,
                    templateName: self.templates[0],
                    data: {
                        data: d.data,
                        mahoso: postData.code,
                        mst: postData.mst,
                        tendn: postData.tendn
                    }
                }, callback);
            }
        });
    },

    send: function (hoso) {
        var self = this;
        var afterSigning = function (xml) {
            action = '/moh/01/sendwithsignature';
            var id = hoso.fiIdHoso;
            app.makePost({
                url: action,
                data: JSON.stringify({fiIdHoso: id, signedXml: xml}),
                success: function (d) {
                    if (d.success) {
                        self.announce(NSWLang["common_msg_sendsuccess"], 'success');
                        self.search();
                    } else {
                        onFail(d);
                    }
                },
                error: function (e) {
                    onFail(e);
                }
            });
        };

        var onFail = function (d) {
            var message = NSWLang["common_msg_he_thong_chua_san_sang"]
            if (d.message != null) {
                message = d.message;
            }
            self.announce(message, 'error');
        }

        var sendStr = hoso.fiIdHoso + "-" + app.requireSigning;
        app.makePost({
            url: "/moh/01/sendOne",
            data: JSON.stringify(sendStr),
            success: function (d) {
                if (app.requireSigning) {
                    var xmlContent = d.xmlData;
                    CASigner.sign(xmlContent, '', afterSigning);
                } else {
                    self.announce(NSWLang["common_msg_sendsuccess"], 'success');
                    self.search();
                }
            },
            error: function (d) {
                onFail(d);
            }
        });
    },

    announce: function (message, funct) {
        app.toast({
            title: NSWLang["common_msg_thong_bao"],
            message: message,
            function: funct
        });
    },

    validateHoso: function (hoso) {
        var isValid = true;
        var taptin = hoso.taptinList;
        var isValidHoso = hoso.listOfTbdthanhtoan != null && hoso.listOfTbdthanhtoan.length > 0;
        if (!isValidHoso) {
            app.AlertWithBtn(NSWLang['moh_06_xac_nhan_nop_phi'] + ' ' + NSWLang["common_msg_chua_nhap"]);
            return isValidHoso;
        }

        var loai = [];
        for (i = 0; i < taptin.length; i++) {
            loai.push(taptin[i].fiLoai);
        }
        loai.sort(function (a, b) {
            return a - b
        });

        for (i = 1; i < 9; i++) {
            if (loai.indexOf(i.toString()) < 0) {
                isValidHoso = false;
                break;
            }
        }
        if (taptin !== null && (taptin.length < 8 || !isValidHoso)) {
            app.AlertWithBtn(NSWLang['tep_dinh_kem'] + ' ' + NSWLang["moh_06_tepdinhkem_thongbao_thieu"]);
            return false;
        }
        return isValid;
    }
};