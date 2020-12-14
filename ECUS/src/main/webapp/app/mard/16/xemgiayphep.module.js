function PopupViewGP() {
	var self = this;
	// ket qua xu ly
	
	self.show = function(item) {
		var url ='/mard/api/16/findGP/'+item.fiIdHoSo();
		app.makePost({
            url: url,
            data: JSON.stringify({}),            
            error: function (d) {                       	          	
                var callback = function (html) {
                    var pop = app.popup({
                        title: '',
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
                    }, function () {
                        var popupViewHoSo = new PopupViewHoSo(d);
                        ko.applyBindings(popupViewHoSo, document.getElementById("form"));
                    });
                };            
              
           		 app.complieTemplate({
           	            ministryCode: "mard",
           	            code: "16",
           	            templateName: "xemgiayphep",
           	            data: d
           	        }, callback);
           		
            }
        });
	
	}
}

function PopupViewHoSo(d) {
    var self = this;
    self.formData = d;
}