/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var ListController = function () { };
ListController.prototype = {
    ministryCode: 'most',
    code: '01',
    templates: ['list', 'cancel', 'delay', 'thongbao-chitiet', 'gcn-chitiet', 'history', 'lichsutacdong', 'request-edit', 'history-item'],
    pagination: {
        isReady: false,
        currentPage: 1,
        pageSize: 10,
        total: 0
    },
    container: null,
    formSearch: null,
    pager: null,
    tempPagination: {
        currentPage: 0,
        pageSize: 10
    },
    init: function (obj) {
        var op = $.extend(true, {}, obj);
        this.loadTemplates();
        this.registerEvents();
        this.container = '#' + op.container;
        this.formSearch = '#' + op.form;
        this.pager = '#' + op.pager;
        $(".select2").select2({placeholder: '', width: null});
        $('.date-picker').datepicker({rtl: false, orientation: "left", autoclose: true});
        this.search();
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
        $("#searchHoSo").on('click', function (e) {
            e.preventDefault();
            self.pagination.currentPage = 1;
            self.pagination.isReady = false;

            var isVaild = self.compareDatetime('ngayTaoTuNgay', 'ngayTaoDenNgay')
            if (!isVaild)
                return false;

            isVaild = self.compareDatetime('ngayGuiTuNgay', 'ngayGuiDenNgay')
            if (!isVaild)
                return false;

            self.search();
            return false;
        });
        $("#btnAddNew").on('click', function (e) {
            e.preventDefault();
            document.location = app.appContext + '/most/01/edit/0';
            return false;
        });
    },
    initSearchForm: function () {
        var self = this;
        var obj = app.form2Object(self.formSearch);
        obj.pageSize = self.pagination.pageSize;
        obj.currentPage = self.pagination.currentPage - 1;
        return JSON.stringify(obj);
    },
    search: function () {
        var self = this;
        var cb = function (data) {
            self.setupPager(data);
            self.bindEventsGrid();
            $('.tooltips').tooltip();
        };
        if (app.isReady) {
            var post_data = self.initSearchForm();
            app.bindData({
                ministryCode: self.ministryCode,
                code: self.code,
                templateName: self.templates[0],
                container: self.container,
                url: '/most/01/search',
                data: post_data
            }, cb);
        } else {
            app.toast({
                title: NSWLang["common_msg_thong_bao"],
                message: NSWLang["common_msg_he_thong_chua_san_sang"],
                function: 'error'
            });
        }
    },
    bindEventsGrid: function () {
        var self = this;
        var con = $(self.container);

        con.find('.fa-history').off('click').on('click', function (e) {
            e.preventDefault();
            var me = $(this);
            var id = me.attr('doc');
            var code = me.attr('code');
            var deptCode = me.attr('dept');
            self.tempPagination.currentPage = 0;

            self.viewHistory({
                fiCode: code,
                fiIdHoso: id,
                fiIdCqxl: deptCode,
                pageSize: self.tempPagination.pageSize,
                currentPage: self.tempPagination.currentPage,
                pager: 'history-pager'
            }, '/most/01/history', NSWLang["common_history_lichsuxuly"], 900, 5);

            return false;
        });

        con.find('.edit').off('click').on('click', function (e) {
            e.preventDefault();
            var me = $(this);
            document.location = app.appContext + '/most/01/edit/' + me.attr('doc');
            return false;
        });

        con.find('.request-delay').off('click').on('click', function (e) {
            e.preventDefault();
            var me = $(this);
            var id = me.attr('doc');
            var code = me.attr('code');
            var deptCode = me.attr('dept');

            var callback = function (html) {
                var pop = app.popup({
                    title: NSWLang["common_msg_xin_gia_han_ho_so"] + ' ' + code,
                    html: html,
                    width: 650,
                    buttons: [
                        {
                            name: NSWLang["common_button_gui"],
                            class: 'btn',
                            icon: 'fa-check',
                            action: function () {
                                var isOk = app.isFormVaild('delayForm01');
                                if (!isOk)
                                    return;

                                var data = app.form2Object('#' + 'delayForm01');
                                data.fiIdHoso = id;
                                data.fiMaHoSo = code;
                                data.fiIdCqxl = deptCode;

                                var time = data.fiTime.toString().toValidDate();
                                var timeToDelay = new Date(time);
                                if (timeToDelay.compareWithNow() < 0) {
                                    alert(NSWLang["common_msg_thoi_han_moi_nhap_sai"]);
                                    return;
                                }

                                if (CASigner.requireCA) {
                                    data.fiGetMessage = true;
                                }

                                var onSuccess = function (_popup, msg) {
                                    app.Alert(msg);
                                    app.popupRemove(_popup.selector);
                                    self.search();
                                };

                                var onFail = function (d) {
                                    if (d !== null) {
                                        if (typeof (d.data) !== 'undefined' && Array.isArray(d.data)) {
                                            app.Alert(Util.getErrorMsg(d.data[0]));
                                        } else {
                                            app.Alert(d.message);
                                        }
                                    } else {
                                        app.Alert(NSWLang["common_msg_he_thong_chua_san_sang"]);
                                    }
                                };

                                var afterSigning = function (xml) {
                                    console.log("after signing =>", xml);
                                    action = '/most/01/delay';
                                    data.fiSignedXml = xml;
                                    data.fiGetMessage = false;

                                    app.makePost({
                                        url: action,
                                        data: JSON.stringify(data),
                                        success: function (d) {
                                            if (d.success) {
                                                msg = NSWLang["common_msg_cap_nhat_du_lieu_thanh_cong"];
                                                onSuccess(pop, msg);
                                            } else {
                                                onFail();
                                            }
                                        },
                                        error: function (e) {
                                            onFail();
                                        }
                                    });
                                };

                                app.makePost({
                                    url: '/most/01/delay',
                                    data: JSON.stringify(data),
                                    success: function (d) {
                                        var msg = '';
                                        if (d.success) {
                                            if (CASigner.requireCA) {
                                                var xmlContent = d.xmlData;
                                                console.log("before signing =>", data);
                                                CASigner.sign(xmlContent, '', afterSigning);
                                            } else {
                                                msg = NSWLang["common_msg_cap_nhat_du_lieu_thanh_cong"];
                                                onSuccess(pop, msg);
                                            }
                                        } else {
                                            msg = d.message;
                                            onSuccess(pop, msg);
                                        }
                                    }
                                });
                            }
                        }
                    ]
                });
                pop.find('.date-picker').datepicker({rtl: false, orientation: "left", autoclose: true});
            };
            var data = {};
            data.fiIdHoso = id;
            data.fiMaHoSo = code;
            data.fiIdCqxl = deptCode;
            app.makePost({
                url: '/most/01/getcurrentdelay',
                data: JSON.stringify(data),
                success: function (d) {
                    app.complieTemplate({
                        ministryCode: self.ministryCode,
                        code: self.code,
                        templateName: self.templates[2],
                        data: [d.data]
                    }, callback);
                }
            });

            return false;
        });
        con.find('.request-edit').off('click').on('click', function (e) {
            e.preventDefault();
            var me = $(this);
            var id = me.attr('doc');
            var code = me.attr('code');
            var deptCode = me.attr('dept');

            var callback = function (html) {
                var pop = app.popup({
                    title: NSWLang["common_msg_xin_sua_ho_so"] + ' ' + code,
                    html: html,
                    width: 600,
                    height: 250,
                    buttons: [
                        {
                            name: NSWLang["common_button_gui"],
                            class: 'btn',
                            icon: 'fa-check',
                            action: function () {
                                var isOk = app.isFormVaild('editForm01');
                                if (!isOk)
                                    return;

                                var data = app.form2Object('#' + 'editForm01');
                                data.fiIdHoso = id;
                                data.fiMaHoSo = code;
                                data.fiIdCqxl = deptCode;

                                if (CASigner.requireCA) {
                                    data.fiGetMessage = true;
                                }

                                var onSuccess = function (_popup, msg) {
                                    app.Alert(msg);
                                    app.popupRemove(_popup.selector);
                                    self.search();
                                };

                                var onFail = function (d) {
                                    if (d !== null) {
                                        if (typeof (d.data) !== 'undefined' && Array.isArray(d.data)) {
                                            app.Alert(Util.getErrorMsg(d.data[0]));
                                        } else {
                                            app.Alert(d.message);
                                        }
                                    } else {
                                        app.Alert(NSWLang["common_msg_he_thong_chua_san_sang"]);
                                    }
                                };

                                var afterSigning = function (xml) {
                                    console.log("after signing =>", xml);
                                    action = '/most/01/redit';
                                    data.fiSignedXml = xml;
                                    data.fiGetMessage = false;

                                    app.makePost({
                                        url: action,
                                        data: JSON.stringify(data),
                                        success: function (d) {
                                            if (d.success) {
                                                msg = NSWLang["common_msg_cap_nhat_du_lieu_thanh_cong"];
                                                onSuccess(pop, msg);
                                            } else {
                                                onFail();
                                            }
                                        },
                                        error: function (e) {
                                            onFail();
                                        }
                                    });
                                };

                                app.makePost({
                                    url: '/most/01/redit',
                                    data: JSON.stringify(data),
                                    success: function (d) {
                                        var msg = '';
                                        if (d.success) {
                                            if (CASigner.requireCA) {
                                                var xmlContent = d.data;
                                                console.log("before signing =>", xmlContent);
                                                CASigner.sign(xmlContent, '', afterSigning);
                                            } else {
                                                msg = NSWLang["common_msg_cap_nhat_du_lieu_thanh_cong"];
                                                onSuccess(pop, msg);
                                            }
                                        } else {
                                            msg = d.message;
                                            onSuccess(pop, msg);
                                        }
                                    }
                                });
                            }
                        }
                    ]
                });
                pop.find('.date-picker').datepicker({rtl: false, orientation: "left", autoclose: true});
            };
            app.complieTemplate({
                ministryCode: self.ministryCode,
                code: self.code,
                templateName: self.templates[7]
            }, callback);
            return false;
        });
        con.find('.request-cancel').off('click').on('click', function (e) {
            e.preventDefault();
            var me = $(this);
            var id = me.attr('doc');
            var code = me.attr('code');
            var deptCode = me.attr('dept');

            var callback = function (html) {
                var pop = app.popup({
                    title: NSWLang["common_msg_yeu_cau_huy_ho_so"] + ' ' + code,
                    html: html,
                    width: 600,
                    height: 200,
                    buttons: [
                        {
                            name: NSWLang["common_button_gui"],
                            class: 'btn',
                            icon: 'fa-check',
                            action: function () {
                                var isOk = app.isFormVaild('cancelForm01');
                                if (!isOk)
                                    return;

                                var data = app.form2Object('#' + 'cancelForm01');
                                data.fiIdHoso = id;
                                data.fiMaHoSo = code;
                                data.fiIdCqxl = deptCode;

                                if (CASigner.requireCA) {
                                    data.fiGetMessage = true;
                                }

                                var onSuccess = function (_popup, msg) {
                                    app.Alert(msg);
                                    app.popupRemove(_popup.selector);
                                    self.search();
                                };

                                var onFail = function (d) {
                                    if (d !== null) {
                                        if (typeof (d.data) !== 'undefined' && Array.isArray(d.data)) {
                                            app.Alert(Util.getErrorMsg(d.data[0]));
                                        } else {
                                            app.Alert(d.message);
                                        }
                                    } else {
                                        app.Alert(NSWLang["common_msg_he_thong_chua_san_sang"]);
                                    }
                                };

                                var afterSigning = function (xml) {
                                    console.log("after signing =>", xml);
                                    action = '/most/01/cancel';
                                    data.fiSignedXml = xml;
                                    data.fiGetMessage = false;

                                    app.makePost({
                                        url: action,
                                        data: JSON.stringify(data),
                                        success: function (d) {
                                            if (d.success) {
                                                msg = NSWLang["common_msg_cap_nhat_du_lieu_thanh_cong"];
                                                onSuccess(pop, msg);
                                            } else {
                                                onFail();
                                            }
                                        },
                                        error: function (e) {
                                            onFail();
                                        }
                                    });
                                };

                                app.makePost({
                                    url: '/most/01/cancel',
                                    data: JSON.stringify(data),
                                    success: function (d) {
                                        var msg = '';
                                        if (d.success) {
                                            if (CASigner.requireCA) {
                                                var xmlContent = d.data;
                                                console.log("before signing =>", xmlContent);
                                                CASigner.sign(xmlContent, '', afterSigning);
                                            } else {
                                                msg = NSWLang["common_msg_cap_nhat_du_lieu_thanh_cong"];
                                                onSuccess(pop, msg);
                                            }
                                        } else {
                                            msg = d.message;
                                            onSuccess(pop, msg);
                                        }
                                    }
                                });
                            }
                        }
                    ]
                });
            };
            app.complieTemplate({
                ministryCode: self.ministryCode,
                code: self.code,
                templateName: self.templates[1]
            }, callback);
            return false;
        });
        con.find('.fa-search').off('click').on('click', function (e) {
            e.preventDefault();
            var me = $(this);
            var id = me.attr('doc');
            var code = me.attr('code');
            var deptCode = me.attr('dept');
            self.tempPagination.currentPage = 0;

            self.viewGCN({
                fiCode: code,
                fiIdHoso: id,
                fiIdCqxl: deptCode,
                pageSize: self.tempPagination.pageSize,
                currentPage: self.tempPagination.currentPage,
                pager: 'history-pager'
            }, '/most/01/gcn', NSWLang["most_01_gcn_popup"], 900, 4);

            return false;
        });
        con.find('.fa-search-plus').off('click').on('click', function (e) {
            e.preventDefault();
            var me = $(this);
            var id = me.attr('doc');
            var code = me.attr('code');
            var deptCode = me.attr('dept');
            self.tempPagination.currentPage = 0;

            self.viewResult({
                fiCode: code,
                fiIdHoso: id,
                fiIdCqxl: deptCode,
                pageSize: self.tempPagination.pageSize,
                currentPage: self.tempPagination.currentPage,
                pager: 'history-pager'
            }, '/most/01/kqkt', NSWLang["most_01_thongbao_tb"], 900, 3);

            return false;
        });
        con.find('.fa-remove').off('click').on('click', function (e) {
            e.preventDefault();
            var me = $(this);
            var id = me.attr('doc');
            var dept = me.attr('dept');
            var docCode = me.attr('code');
            var postData = {
                fiIdHoso: id,
                fiIdCqxl: dept
            };

            var pop = app.popup({
                title: NSWLang["common_msg_thong_bao"],
                html: '<i class="fa fa-3x fa-warning"></i> ' + NSWLang["common_msg_xoa_ho_so"] + ' <b>'+ docCode +'</b>',
                width: 400,
                buttons: [
                    {
                        name: NSWLang["common_button_toi_chac_chan"],
                        class: 'btn',
                        icon: 'fa-check',
                        action: function () {
                            app.makePost({
                                url: '/most/01/delete',
                                data: JSON.stringify(postData),
                                success: function (d) {
                                    var msg = '';
                                    var fun = 'success';
                                    if (d.success) {
                                        msg = NSWLang["common_msg_cap_nhat_du_lieu_thanh_cong"];
                                        app.popupRemove(pop.selector);
                                        self.search();
                                    } else {
                                        msg = data.message;
                                        fun = 'error';
                                    }
                                    app.toast({
                                        title: NSWLang["common_msg_thong_bao"],
                                        message: msg,
                                        function: fun
                                    });
                                },
                                error: function (e) {
                                    console.log(e);
                                }
                            });
                        }
                    }
                ]
            });
            return false;
        });
    },
    viewHistory: function (postData, url, title, width, tmplIndex) {
        var self = this;
        var cb = function (html) {
            var popup = app.popup({
                title: title,
                html: html,
                width: width,
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
            url: url,
            data: JSON.stringify(postData),
            success: function (d) {
                app.complieTemplate({
                    ministryCode: self.ministryCode,
                    code: self.code,
                    templateName: self.templates[tmplIndex],
                    data: d.data
                }, function (html) {
                    if (cb !== null)
                        cb(html);

                    if (typeof (postData.pager) !== 'undefined' && postData.pager !== null) {
                        self.setupTempPager(postData.pager, d, function () {
                            postData.currentPage = self.tempPagination.currentPage - 1;
                            self.searchHistory(postData, url, 8, '#history-container');
                        });
                    }

                    $('#history-nswcode').text(postData.fiCode);
                });
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
    searchHistory: function (postData, url, tmplIndex, containerId) {
        var self = this;

        app.bindData({
            ministryCode: self.ministryCode,
            code: self.code,
            templateName: self.templates[tmplIndex],
            container: containerId,
            url: url,
            data: JSON.stringify(postData)
        }, function (d) {
            console.log(d);
        });
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
    setupTempPager: function (pager, data, cb) {
        var self = this;

        $('#' + pager).pagination({
            items: data.total,
            itemsOnPage: self.tempPagination.pageSize,
            cssStyle: 'light-theme',
            edges: 2,
            displayedPages: 5,
            prevText: '<',
            nextText: '>',
            onPageClick: function (pageNumber, event) {
                self.tempPagination.currentPage = pageNumber;
                cb();
                return false;
            }
        });
    },
    viewGCN: function (postData, url, title, width, tmplIndex) {
        var self = this;
        var cb = function (html) {
            var popup = app.popup({
                title: title,
                html: html,
                width: width,
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
            url: url,
            data: JSON.stringify(postData),
            success: function (d) {
                if (d.success) {
                    d.data.context = app.appContext;
                    app.complieTemplate({
                        ministryCode: self.ministryCode,
                        code: self.code,
                        templateName: self.templates[tmplIndex],
                        data: d.data
                    }, function (html) {
                        if (cb !== null)
                            cb(html);

                        if (typeof postData.pager !== 'undefined' && postData.pager !== null) {
                            self.setupTempPager(postData.pager, d, function () {
                                postData.currentPage = self.tempPagination.currentPage - 1;
                                self.searchHistory(postData, url, 8, '#history-container');
                            });
                        }

                        $('#history-nswcode').text(postData.fiCode);
                    });
                } else {

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
    viewResult: function (postData, url, title, width, tmplIndex) {
        var self = this;
        var cb = function (html) {
            var popup = app.popup({
                title: title,
                html: html,
                width: width,
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
            url: url,
            data: JSON.stringify(postData),
            success: function (d) {
                if (d.success) {
                    d.data.context = app.appContext;
                    app.complieTemplate({
                        ministryCode: self.ministryCode,
                        code: self.code,
                        templateName: self.templates[tmplIndex],
                        data: d.data
                    }, function (html) {
                        if (cb !== null)
                            cb(html);

                        if (typeof postData.pager !== 'undefined' && postData.pager !== null) {
                            self.setupTempPager(postData.pager, d, function () {
                                postData.currentPage = self.tempPagination.currentPage - 1;
                                self.searchHistory(postData, url, 8, '#history-container');
                            });
                        }

                        $('#history-nswcode').text(postData.fiCode);
                    });
                }
            },
            error: function (e) { }
        });
    },
    compareDatetime: function (t1, t2) {

        var e1 = $('#' + t1),
                e2 = $('#' + t2);

        var valE1 = e1.val().toString().trim(),
                valE2 = e2.val().toString().trim();
        var d1 = Util.isDate(valE1),
                d2 = Util.isDate(valE2);
        var fieldName1 = e1.attr('field');
        var fieldName2 = e2.attr('field');

        if (valE1 !== '') {
            if (!d1) {
                app.Alert(NSWLang[fieldName1]);
                return false;
            }
        }

        if (valE2 !== '') {
            if (!d2) {
                app.Alert(NSWLang[fieldName2]);
                return false;
            }
        }

        if (d1 && d2) {
            if (Util.getDate(valE1).getTime() - Util.getDate(valE2).getTime() > 0) {
                app.Alert(NSWLang[fieldName2] + ' <b>' + NSWLang['common_msg_khongnhohon'] + '</b> ' + NSWLang[fieldName1]);
                return false;
            }
        }

        return true;
    }
};

$(document).ready(function () {
    $.fn.select2.defaults.set("theme", "bootstrap");

    var controller = new ListController();
    controller.init({
        container: 'list-container',
        form: 'searchForm01',
        pager: 'list-pager'
    });
});
