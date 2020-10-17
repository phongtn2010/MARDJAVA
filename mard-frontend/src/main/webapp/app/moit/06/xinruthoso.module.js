function HuyHoSoView() {
	var self = this;
	self.show = function(item, success) {
		var callback = function (html) {
            var pop = app.popup({
                title: NSWLang["moit_06_popup_huyhs"] + ' - ' + item.maHoSo(),
                html: html,
                width: 960,
                buttons: [
                	  {
                          name: NSWLang["common_button_gui"],
                          class: 'btn',
                          icon: 'fa fa-paper-plane',
                          action: function () {
                        	  
                        	  var isOk = app.isFormVaild('form-sin-rut-ho-so-popup');

                              if (!isOk)
                                  return;

                              var data = app.form2Object('#form-sin-rut-ho-so-popup');
                              app.makePost({
					            url: '/moit/api/06/huyHS/' + item.idHoSo(),
					            data: JSON.stringify(data),
					            success: function (d) {
					            	
					                var fun = 'success';
					                if (d.success) {
					                    app.popupRemove(pop.selector);
                                        app.toast({
    					                    title: NSWLang["common_msg_thong_bao"],
    					                    message: NSWLang["moit_06_action_status_huy_ho_so_success"],
    					                    function: fun
    					                });
                                        success();
                                        self.thongBao(NSWLang["moit_06_action_status_huy_ho_so_success"], true)
					                } 
					              
					            },
					            error: function (e) {
					                toastr.error(NSWLang["moit_06_action_status_huy_ho_so_success"], NSWLang["common_msg_thong_bao"]);
					                app.popupRemove(pop.selector);
					                self.thongBao(NSWLang["moit_06_action_status_huy_ho_so_error"], false)
					            }
					        });
                         	
                          }
                      },
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
		 
		 app.complieTemplate({
	            ministryCode: "moit",
	            code: "06",
	            templateName: "xin_rut_ho_so",
	            data: []
	        }, callback);
	}
	
	self.thongBao = function( message, success) {
		var cls = 'class="alert alert-success toast-success" style="color: #fff;"';
		var icon = 'fa fa-check';
		if (!success) {
			cls = 'class="alert alert-danger" style="color: #000;background: red;"';
			icon = 'fa fa-send-o';
		}
		  var pop = app.popup({
                title: NSWLang["common_msg_thong_bao"],
                html: '<div '+ cls +' ><i class="'+ icon +'" aria-hidden="true"></i> ' + NSWLang["common_msg_thong_bao"] + ' <b>'+ message +'</b></div>',
                width: 400,
                buttons: [
                    {
                        name: NSWLang["common_button_dong"],
                        class: 'btn',
                        icon: 'fa-remove',
                        action: function () {
                        	app.popupRemove(pop.selector);
                        	if (success) {
                    			location.reload();
                        	}
                        }
                    }
                ]
            }, function(){
            	$('button[class="close"]').click(function(){
            		app.popupRemove(pop.selector);
            		if (success) {
            			location.reload();
                	}
            	});
            });
	}
	
}