/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var IndexController = function () { };
IndexController.prototype = {
    ministryCode: 'most',
    code: '02',
    templates: ['history', 'list', 'cancel', 'delay', 'thongbaokiemtra', 'thongbao-chitiet'],
    pagination: {
        isReady: false,
        currentPage: 1,
        pageSize: 10
    },
    tempPagination: {
        currentPage: 0,
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
            document.location = app.appContext + '/most/02/hoso/0';
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
                                url: '/most/02/delete',
                                data: JSON.stringify(postData),
                                success: function (d) {
                                    var msg = '';
                                    var fun = 'success';
                                    if (d.success) {
                                        msg = NSWLang["common_msg_xoathanhcong"];
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
                                    app.popupRemove(pop.selector);
                                },
                                error: function (e) {
                                    var msg = !!e.message ? e.message : NSWLang["common_msg_he_thong_chua_san_sang"];
                                    app.toast({
                                        title: NSWLang["common_msg_thong_bao"],
                                        message: msg,
                                        function: 'error'
                                    });
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
            
            var id = me.attr('doc');
            var code = me.attr('code');
            var mst = me.parents("tr").attr("data-mst");
            var tendn = me.parents("tr").attr("data-tendn");

            self.view({fiIdHoso: id, pageSize: self.tempPagination.pageSize,
                currentPage: self.tempPagination.currentPage, }, code, '/most/02/history', NSWLang["common_history_lichsuxuly"], 1000, 0);
            return false;
        });
        $(".fa-pencil").off().on("click", function () {
            var me = $(this);
            document.location = app.appContext + '/most/02/hoso/' + me.attr('doc');
        });
        $(".view").off().on('click', function (e) {
            var me = $(this);
            e.preventDefault();
            document.location = app.appContext + '/most/02/view/' + me.attr('doc') + "/";
            return false;
        });
        $('.cancel').off('click').on('click', function () {
            var me = $(this);
            var id = me.attr('doc');
            var code = me.attr('code');
            var trangthai = me.attr('trangthai');
            var callback;
            if (trangthai != 0) {
                callback = function (html) {
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
                                    var isOk = app.isFormVaild('cancelForm02');
                                    if (!isOk)
                                        return;

                                    var data = app.form2Object('#' + 'cancelForm02');
                                    data.fiIdHoso = id;
                                    data.fiMaHoSo = code;

                                    if (app.requireSigning) {
                                        data.fiGetMessage = true;
                                    }
                                    sendRequest(pop, data);
                                    
                                }
                            }
                        ]
                    });
                };
            } else {
                callback = function () {
                    var html = NSWLang["most_02_confirm_huy"];
                    var pop = app.popup({
                        title: NSWLang["common_msg_yeu_cau_huy_ho_so"] + ' ' + code,
                        html: html,
                        width: 400,
                        height: 100,
                        buttons: [
                            {
                                name: NSWLang["common_button_toi_chac_chan"],
                                class: 'btn',
                                icon: 'fa-check',
                                action: function () {
                                    var data = {};
                                    data.fiIdHoso = id;
                                    data.fiMaHoSo = code;
                                    data.fiContent="";
                                    if (app.requireSigning) {
                                        data.fiGetMessage = true;
                                    }
                                    sendRequest(pop, data);
                                }
                            },
                            {
                                name: NSWLang["common_button_huy"],
                                class: 'btn',
                                icon: 'fa-close',
                                action: function () {
                                    app.popupRemove(pop.selector);
                                }
                            }
                        ]
                    }
                    )
                };
            }
             var afterSigning = function (xml) {
                //console.log("after signing =>", xml);
                action = '/most/02/cancel';
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
            var sendRequest = function (pop, data) {
                app.makePost({
                    url: '/most/02/cancel',
                    data: JSON.stringify(data),
                    success: function (d) {
                        var msg = '';
                        if (d.success) {
                            if (app.requireSigning) {
                                var xmlContent = d.data;
                                //console.log("before signing =>", xmlContent);
//                                CASigner.sign(xmlContent, '', afterSigning);
                            } else {
                                msg = NSWLang["common_msg_cap_nhat_du_lieu_thanh_cong"];
                                onSuccess(pop, msg);
                            }
                        } else {
                            msg = d.message;
                            onSuccess(pop, msg);
                        }
                    },
                    error: function (d) {
                        app.popupRemove(pop.selector);
                        onFail(d);
                    }
                });
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
            ;
            app.complieTemplate({
                ministryCode: self.ministryCode,
                code: self.code,
                templateName: self.templates[2]
            }, callback);
            return false;
        });

        $('.delay').off('click').on('click', function (e) {
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
                                var isOk = app.isFormVaild('delayForm02');
                                if (!isOk)
                                    return;

                                var data = app.form2Object('#' + 'delayForm02');
                                data.fiIdHoso = id;
                                data.fiMaHoSo = code;
                                data.fiIdCqxl = deptCode;

                                var time = data.fiTime.toString().toValidDate();
                                var timeToDelay = new Date(time);
                                if (timeToDelay.compareWithNow() < 0) {
                                    alert(NSWLang["common_msg_thoi_han_moi_nhap_sai"]);
                                    return;
                                }

                                if (app.requireSigning) {
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
                                    //console.log("after signing =>", xml);
                                    action = '/most/02/delay';
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
                                    url: '/most/02/delay',
                                    data: JSON.stringify(data),
                                    success: function (d) {
                                        var msg = '';
                                        if (d.success) {
                                            if (app.requireSigning) {
                                                var xmlContent = d.xmlData;
                                                //console.log("before signing =>", data);
//                                                CASigner.sign(xmlContent, '', afterSigning);
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
                url: '/most/02/getcurrentdelay',
                data: JSON.stringify(data),
                success: function (d) {
                    app.complieTemplate({
                        ministryCode: self.ministryCode,
                        code: self.code,
                        templateName: self.templates[3],
                        data: [d.data]
                    }, callback);
                }
            });

            return false;
        });
        $('.fa-search').off('click').on('click', function () {
            var fiIdHoso = $(this).attr('doc');
            app.makePost({
                url: '/most/02/getTbkt/',
                data: JSON.stringify({fiIdHoso: fiIdHoso}),
                success: function (d) {
                    app.complieTemplate({
                        ministryCode: self.ministryCode,
                        code: self.code,
                        templateName: self.templates[4],
                        data: d.data
                    }, callback);
                }
            });
            var callback = function (html) {
                var popup = app.popup({
                    title: NSWLang["most_02_thongbaokiemtra"],
                    html: html,
                    width: 600,
                    height: 200,
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
        })
        $('.fa-book').off('click').on('click', function (e) {
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
            }, '/most/02/kqkt', NSWLang["most_01_gcn_popup"], 900, 5);

            return false;
        })
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
    search: function () {
        var self = this;
        var cb = function (data) {
            self.setupPager(data);
            self.bindEventsGrid();
        };
        if (app.isReady) {
            var post_data = self.initSearchForm();
            //console.log(post_data);
            app.bindData({
                ministryCode: self.ministryCode,
                code: self.code,
                templateName: self.templates[1],
                container: self.container,
                url: '/most/02/search',
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
    view: function (postData, code, url, title, width, tmplIndex) {
        var self = this;
        var callback = function (html) {
            var popup = app.popup({
                title: title,
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
            url: url,
            data: JSON.stringify(postData),
            success: function (d) {
                app.complieTemplate({
                    ministryCode: self.ministryCode,
                    code: self.code,
                    templateName: self.templates[0],
                    data: {
                        data: d.data,
                        mahoso: code,
                    }
                }, callback);
            }
        });

    }
};