function XoaHoSoView() {
	var self = this;
	self.show = function(item, success) {
		 var docCode = item.maHoSo();
	        
	        var postData = {
	             
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
	                                url: '/moit/api/06/deleteHoSo/' + item.idHoSo(),
	                                data: JSON.stringify(postData),
	                                success: function (d) {
	                                    var msg = '';
	                                    var fun = 'success';
	                                    if (d.success) {
	                                        msg = NSWLang["common_msg_cap_nhat_du_lieu_thanh_cong"];
	                                        app.popupRemove(pop.selector);
	                                        success();
	                                    	
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
	                                    toastr.error(e.message, NSWLang["common_msg_thong_bao"]);
	                                }
	                            });
	                        }
	                    }
	                ]
	            });
	}
	
}