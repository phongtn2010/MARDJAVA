/**
 * @returns
 */
/**
 * @returns
 */
$(document).ready(function () {

    function ViewModel() {

        var self = this;

        self.contextPath = ko.observable($('#contextPath').val());
        self.totalData = ko.observable(0);
        self.pagingVM = new PagingVM({pageSize: 15, totalCount: 0});
        $('.date-picker').datepicker({rtl: false, orientation: "left", autoclose: true});

        self.showActionError = ko.observable(false);
        self.showActionSuccess = ko.observable(false);
        self.errorMessage = ko.observable('');

        self.danhsachgiayphep = ko.observableArray();

        
        self.listItem = ko.observableArray();
        
        self.selectItem = function (data) {
        	data.isSelected(true);
            //self.selectedItem(data);
            if(self.hasItem(data)){
            	self.listItem.remove(data.fiSoGiayphep());
            	//data.isSelected(false);
        	}
            else{
            	self.listItem.push(data.fiSoGiayphep());
            	//data.isSelected(false);
            }
            return true;
        };
        self.hasItem = function(data){
        	if(self.listItem.indexOf(data.fiSoGiayphep()) > -1){
        		return true;
        	}else{
        		return false;
        	}
        	
        }
        self.danhSachLichSu = ko.observableArray();
        self.xemLichSu = function (item) {
            var url = '/mt/23/history/giayphep/' + item.fiSoGiayphep()+'/1';
            self.danhSachLichSu.removeAll();
            app.makePost({
                url: url,
                data: JSON.stringify({}),
                success: function (d) {
                    var msg = '';
                    var fun = 'success';
                    if (d.success) {
                        msg = d.message;
                        var total = 0;
                        if (d.data != null && d.data.length > 0) {
                            total = d.total;
                        }
                        var callback = function (html) {
                            var pop = app.popup({
                                title:  NSWLang["sbv_01_lichsgp_table_00"]  + ' - ' + item.fiSoGiayphep(),
                                html: html,
                                width: 960,
                                buttons: [
                                    {
                                        name: NSWLang["common_button_dong"],
                                        class: 'btn red',
                                        icon: 'fa-remove',
                                        action: function () {
                                            app.popupRemove(pop.selector);
                                        }
                                    }
                                ]
                            });
                        };


                        app.complieTemplate({
                            ministryCode: "mt",
                            code: "p23",
                            templateName: "lich_su_gp",
                            data: d.data
                        }, callback);

                        $('#' + 'lich-su-pagination').pagination({
                            items: total,
                            itemsOnPage: 10,
                            cssStyle: 'light-theme',
                            edges: 2,
                            displayedPages: 5,
                            prevText: NSWLang['monre_01_pagination_trang_truoc'],
                            nextText: NSWLang['monre_01_pagination_trang_sau'],
                            onPageClick: function (pageNumber, event) {
                                var url = '/mt/23/history/giayphep/' + item.fiSoGiayphep() + '/' + pageNumber;
                                app.bindData({
                                    ministryCode: 'mt',
                                    code: 'p23',
                                    templateName: "lich_su_item_gp",
                                    container: '#historyContainer',
                                    url: url,
                                    data: JSON.stringify({})
                                }, function (d) {
                                });

                                return false;
                            }
                        });

                    } else {
                        msg = d.message;
                        fun = 'error';
                    }
                    app.toast({
                        title: NSWLang["common_msg_thong_bao"],
                        message: msg,
                        function: fun
                    });
                },
                error: function (e) {
                    
                    toastr.error(e.message, NSWLang["common_msg_thong_bao"]);
                }
            });
        }
//      =====
        var Page = function(){
          this.currentPage = ko.observable(0);
            this.pageSize = ko.observable(10);
        }
        self.page = new Page();
        self.pagingVM = new PagingVM({pageSize: 10, totalCount: 0, currentPage : 1});
        var id_hoso ;
        self.getGiayPhep = function (id) {
          id_hoso = id;
          self.danhsachgiayphep.removeAll();
          self.page.currentPage(self.pagingVM.currentPage());
            app.makePost({
                url: '/mt/23/call_service',
                data: JSON.stringify({
                    URL_BACKEND: "/mt/23/giayphep/license_detail/" + id,
                    URL_GET_TOTAL:"/mt/23/giayphep/license_detail/getTotal/" + id ,
                    METHOD: "POST",
                    REQUEST: app.convertFormObservableJson(self.page)
                }),
                success: function (d) {
                    $('#loading_c4e6a343-dd41-b5c5-1ef9-75eeebba032d').hide();
                    var msg = '';
                    var fun = 'success';
                    if (d.success) {
                        self.pagingVM.totalCount(d.total);
                        self.totalData(d.total);
                        for (const item of d.data) {
                          var loai = "";
                          if(item.fiLoaiphuongtien == 1){
                            loai = 'Xe khách';
                          }else if(item.fiLoaiphuongtien == 2){
                            loai = 'Xe tải';
                          } else{
                            loai = 'Xe khác';
                          }
                          var gp = app.convertObjectToObservable(item, new Tbdgiayphep());
                          gp.fiLoaiphuongtien(loai);
                            self.danhsachgiayphep.push(gp);
                        }
                    } else {
                        msg = d.message;
                        fun = 'error';
                    }
                    app.toast({
                        title: NSWLang["common_msg_thong_bao"],
                        message: msg,
                        function: fun
                    });
                },
                error: function (e) {
                    $('#loading_c4e6a343-dd41-b5c5-1ef9-75eeebba032d').hide();
                    
                    toastr.error(e.message, NSWLang["common_msg_thong_bao"]);
                    self.showActionSuccess(false);
                    self.showActionError(true);
                    self.errorMessage(e.message);
                    $('html,body').scrollTop(0);
                }
            });
        }
        self.goToPage = function (page) {
            if (page >= self.pagingVM.firstPage && page <= self.pagingVM.lastPage()) {
                self.pagingVM.setCurrentPage(page);
                self.getGiayPhep(id_hoso);
            }

        };

        self.goToFirst = function () {
            self.pagingVM.setCurrentPage(self.pagingVM.firstPage);
            self.getGiayPhep(id_hoso);
        };

        self.goToPrevious = function () {
            var previous = self.pagingVM.previousPage();
            if (previous != null) {
                self.pagingVM.setCurrentPage(previous);
                self.getGiayPhep(id_hoso);
            }

        };

        self.goToNext = function () {
            var next = self.pagingVM.nextPage();
            if (next != null) {
                self.pagingVM.setCurrentPage(next);
                self.getGiayPhep(id_hoso);
            }

        };

        self.goToLast = function () {
            self.pagingVM.setCurrentPage(self.pagingVM.lastPage());
            self.getGiayPhep(id_hoso);
        };
        
//        ======

        if (giayPhepId) {
            self.getGiayPhep(giayPhepId);
        }

        self.xemChiTietGiayPhep = function (item) {
            var callback = function (html) {
                var pop = app.popup({
                    title: 'Xem chi tiết giấy phép - ' + item.fiSoGiayphep(),
                    html: html,
                    width: 960,
                    buttons: [
                        {
                            name: NSWLang["common_button_dong"],
                            class: 'btn red',
                            icon: 'fa-remove',
                            action: function () {
                                app.popupRemove(pop.selector);
                            }
                        }
                    ]
                });
            };
            app.complieTemplate({
                ministryCode: "mt",
                code: "p23",
                templateName: "license_detail",
                data: item
            }, callback);
        }

        self.suaGiayPhep = function () {
        	if(self.listItem().length == 0){
        		app.AlertWithBtn('Bạn phải chọn ít nhất 1 giấy phép');
        		return;
        	}else{
        		var callback = function (html) {
                    var pop = app.popupWithLabel({
                    	//+ ' - Số giấy phép' + self.selectedItem().fiSoGiayphep()
                        title: "Đề nghị sửa giấy phép" ,
                        label: "Lý do sửa giấy phép",
                        html: html,
                        width: 960,
                        buttons: [
                            {
                                name: NSWLang["common_button_gui"],
                                class: 'btn blue',
                                icon: 'fa fa-paper-plane',
                                action: function () {
                                    var isOk = app.isFormVaild('form-ly-do-popup');
                                    if (!isOk)
                                        return;

                                    var data = app.form2Value('#form-ly-do-popup');
                                    var popConfirm = app.popup({
                                        title: NSWLang["common_msg_thong_bao"],
                                        //+ self.selectedItem().fiSoGiayphep() +
                                        html: '<i class="fa fa-3x fa-warning"></i> ' + 'Bạn có chắc chắn muốn yêu cầu sửa giấy phép ' + ' <b>' + '</b>',
                                        width: 400,
                                        buttons: [
                                            {
                                                name: NSWLang["common_button_toi_chac_chan"],
                                                class: 'btn',
                                                icon: 'fa-check',
                                                action: function () {
                                                    app.makePost({
                                                        url: '/mt/23/ycsuagiayphep',
                                                        data: JSON.stringify({
                                                            dsGiayphep: self.listItem(),
                                                            fiLydo: data,
                                                            fiIdHoso: giayPhepId,
                                                            fiLoaihoso: procedureId
                                                        }),
                                                        success: function (d) {

                                                            var fun = 'success';
                                                            if (d.success) {
                                                            	;
                                                                app.popupRemove(popConfirm.selector);
                                                                app.popupRemove(pop.selector);
                                                                self.showActionSuccess(true);
                                                                self.showActionError(false);
                                                                app.toast({
                                                                    title: NSWLang["common_msg_thong_bao"],
                                                                    message: "Yêu cầu sửa giấy phép thành công",
                                                                    function: fun
                                                                });
                                                                location.href = location.href;
                                                            } else {
                                                                self.showActionSuccess(false);
                                                                self.showActionError(true);
                                                            }


                                                        },
                                                        error: function (e) {
                                                            
                                                            toastr.error(e.message, NSWLang["common_msg_thong_bao"]);
                                                            app.popupRemove(popConfirm.selector);
                                                            self.showActionSuccess(false);
                                                            self.showActionError(true);
                                                        }
                                                    });
                                                }
                                            }
                                        ]
                                    });

                                }
                            },
                            {
                                name: NSWLang["common_button_dong"],
                                class: 'btn red',
                                icon: 'fa-remove',
                                action: function () {
                                    app.popupRemove(pop.selector);
                                }
                            }
                        ]
                    });
                };

                app.complieTemplate({
                    ministryCode: "mt",
                    code: "p23",
                    templateName: "ly_do",
                    data: []
                }, callback);
        	}
            
        }

        self.traGiayPhep = function() {
        	if(self.listItem().length == 0){
        		 app.AlertWithBtn('Bạn phải chọn ít nhất 1 giấy phép');
        		return;
        	}else{
	            var callback = function (html) {
	                var pop = app.popupWithLabel({
	                    title: "Đề nghị trả giấy phép" ,
	                    label: "Lý do trả giấy phép",
	                    html: html,
	                    width: 960,
	                    buttons: [
	                        {
	                            name: NSWLang["common_button_gui"],
	                            class: 'btn blue',
	                            icon: 'fa fa-paper-plane',
	                            action: function () {
	
	                                var isOk = app.isFormVaild('form-ly-do-popup');
	
	                                if (!isOk)
	                                    return;
	
	                                var data = app.form2Value('#form-ly-do-popup');
	                                var popConfirm = app.popup({
	                                    title: NSWLang["common_msg_thong_bao"],
	                                    html: '<i class="fa fa-3x fa-warning"></i> ' + 'Bạn có chắc chắn muốn yêu cầu trả giấy phép ' + ' <b>'+ '</b>',
	                                    width: 400,
	                                    buttons: [
	                                        {
	                                            name: NSWLang["common_button_toi_chac_chan"],
	                                            class: 'btn',
	                                            icon: 'fa-check',
	                                            action: function () {
	                                                app.makePost({
	                                                    url: '/mt/23/yctragiayphep',
	                                                    data: JSON.stringify({
	                                                    	dsGiayphep: self.listItem(),
                                                            fiLydo: data,
                                                            fiIdHoso: giayPhepId,
                                                            fiLoaihoso: procedureId
	                                                    }),
	                                                    success: function (d) {
	
	                                                        var fun = 'success';
	                                                        if (d.success) {
	                                                            app.popupRemove(popConfirm.selector);
	                                                            app.popupRemove(pop.selector);
	                                                            self.showActionSuccess(true);
	                                                            self.showActionError(false);
	                                                            app.toast({
	                                                                title: NSWLang["common_msg_thong_bao"],
	                                                                message: "Yêu cầu trả giấy phép thành công",
	                                                                function: fun
	                                                            });
	                                                            location.href = location.href;
	                                                        } else {
	                                                            self.showActionSuccess(false);
	                                                            self.showActionError(true);
	                                                        }
	
	
	                                                    },
	                                                    error: function (e) {
	                                                        
	                                                        toastr.error(e.message, NSWLang["common_msg_thong_bao"]);
	                                                        app.popupRemove(popConfirm.selector);
	                                                        self.showActionSuccess(false);
	                                                        self.showActionError(true);
	                                                    }
	                                                });
	                                            }
	                                        }
	                                    ]
	                                });
	                            }
	                        },
	                        {
	                            name: NSWLang["common_button_dong"],
	                            class: 'btn red',
	                            icon: 'fa-remove',
	                            action: function () {
	                                app.popupRemove(pop.selector);
	                            }
	                        }
	                    ]
	                });
	            };
	
	            app.complieTemplate({
	                ministryCode: "mt",
	                code: "p23",
	                templateName: "ly_do",
	                data: []
	            }, callback);
	        }
        }
        self.danhSachTrangThai = ko.observableArray(0);
        app.makePost({
            url: '/mt/23/call_service',
            data: JSON.stringify({
                URL_BACKEND: "/mt/danhmuc/trangthai/search",
                METHOD: "POST",
                REQUEST: {}
            }),
            success: function (d) {
                $('#loading_c4e6a343-dd41-b5c5-1ef9-75eeebba032d').hide();
                var msg = '';
                var fun = 'success';
                if (d.success) {
                    var tatca = {};
                    tatca["fiTenTrangthai"] = ko.observable("--- Tất cả ----");
                    tatca["fiTrangthaiId"] = ko.observable(null);
                    self.danhSachTrangThai.push(tatca);
                    for (const item of d.data) {
                        var itemBind = {};
                        self.danhSachTrangThai.push(app.convertObjectToObservable(item, itemBind));
                    }
                } else {
                    msg = data.message;
                    fun = 'error';
                }
            },
            error: function (e) {
                $('#loading_c4e6a343-dd41-b5c5-1ef9-75eeebba032d').hide();
                
                toastr.error(e.message, NSWLang["common_msg_thong_bao"]);
                self.showActionSuccess(false);
                self.showActionError(true);
                self.errorMessage(e.message);
                $('html,body').scrollTop(0);
            }
        });
        self.getTenTrangthai = function (idTrangthai) {
            var match = ko.utils.arrayFirst(self.danhSachTrangThai(), function (item) {
                return item.fiTrangthaiId() == idTrangthai;
            });
            if (match) {
                return match.fiTenTrangthai();
            }
            return '';
        }
        self.dong = function () {
        	if(type==1){
        		location.href = app.appContext + '/mt/23/home/'+  procedureId;
        	}else{
        		location.href = app.appContext + '/mt/qlhs/home';
        	}
            
        }
    }

    var vm = new ViewModel();
    ko.applyBindings(vm);
});
