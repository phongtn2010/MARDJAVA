function HistoryView() {
	var self = this;
	// ket qua xu ly
	
	self.show = function(item) {
		var url =  '/moit/api/06/layDsLichSuHS/' + item.maHoSo() + '/1';
		
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
                            title: NSWLang["moit_06_lichsh_table_00"] + ' - ' + item.maHoSo(),
                            html: html,
                            width: 1200,
                            buttons: [
                                {
                                    name: NSWLang["common_button_dong"],
                                    class: 'btn',
                                    icon: 'fa-remove',
                                    action: function () {
                                   	 app.popupRemove(pop.selector);
                                    }
                                }
                            ]
                        });
                    };
                    var history = {
                    	items: d.data,
                    	pagination: d.total > 10
                    }
	           		 app.complieTemplate({
	           	            ministryCode: "moit",
	           	            code: "06",
	           	            templateName: "lich_su_tac_dong",
	           	            data: history
	           	        }, callback);
	           		 
	           		$('#' +'lich-su-pagination').pagination({
	                    items: total,
	                    itemsOnPage: 10,
	                    cssStyle: 'light-theme',
	                    edges: 2,
	                    displayedPages: 5,
	                    prevText: NSWLang['monre_01_pagination_trang_truoc'],
	                    nextText: NSWLang['monre_01_pagination_trang_sau'],
	                    onPageClick: function (pageNumber, event) {
	                		var url = '/moit/api/06/layDsLichSuHS/' + item.idHoSo() + '/' +pageNumber;
	                    	 app.bindData({
	                             ministryCode: 'moit',
	                             code: '06',
	                             templateName: "lich_su_tac_dong_item",
	                             container: '#historyContainer',
	                             url: url,
	                             data: JSON.stringify({})
	                         }, function (d) {
//	                             console.log(d);
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
                console.log(e);
                toastr.error(e.message, NSWLang["common_msg_thong_bao"]);
            }
        });
	
	}
}