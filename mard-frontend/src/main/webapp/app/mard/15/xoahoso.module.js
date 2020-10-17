function XoaHoSoView() {
	var self = this;
	self.show = function(item, success) {
		 var docCode = item.fiDocumentName();
	        
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
	                                url:'/mard/15/tbdHoSo15/delete/'+item.fiIdHoSo(),
	                                data: JSON.stringify(postData),
	                                success: function (d) {
	                                },
	                                error: function (e) {
	                                    if (e.readyState) {
	                                    	toastr.error(NSWLang["mard.15.msg.xoaHoSoNo"], NSWLang["common_msg_thong_bao"]);
	                                    } else {
	                                    	app.toast({
		                                        title: NSWLang["common_msg_thong_bao"],
		                                        message: NSWLang["mard.15.msg.xoaHoSoOk"],
		                                    });
	                                    }
	                                    setTimeout(function(){
	                                    	location.reload();
	                                    }, 500);
	                                }
	                            });


	                        }
	                    }
	                ]
	            });
	}
	
}