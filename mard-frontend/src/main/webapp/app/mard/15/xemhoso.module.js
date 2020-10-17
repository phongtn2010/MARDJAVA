function PopupView() {
	var self = this;
	self.show = function(item) {
		var url ='/mard/api/15/edit/'+item.fiIdHoSo();
		app.makePost({
            url: url,
            data: JSON.stringify({}),
            error: function (d) {
                self.formData = d;
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
                        var teps = [];
                        readArrayObjects(d.tepDinhKems, function (loopItem) {
                            loopItem.fiLink = app.appContext +  '/mard/api/15/download/' + loopItem.fiId;
                            teps.push(loopItem);
                        })
                        d.tepDinhKems = teps;
                        var popupViewHoSo = new PopupViewHoSo(d);
                        ko.applyBindings(popupViewHoSo, document.getElementById("form"));
                    });
                };

           		 app.complieTemplate({
           	            ministryCode: "mard",
           	            code: "15",
           	            templateName: "xemthongtinhoso",
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