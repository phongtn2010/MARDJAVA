function PopupView() {
	var self = this;
	// ket qua xu ly
	
	self.show = function(item) {
		var url = '/mard/api/17/edit/' + item.fiIdHoSo();
		app.makePost({
			url: url,
			data: JSON.stringify({}),
			error: function (d) {
		  	    d.TotalMoneyUSD = 0;
		  	    d.TotalMoneyEUR = 0;
				for (var i = 0; i < d.thuocs.length; i++) {
					if(d.thuocs[i].fiMoneyUnitCode == 'EUR')
					{d.TotalMoneyEUR += d.thuocs[i].fiTotal}
					if(d.thuocs[i].fiMoneyUnitCode == 'USD')
					{d.TotalMoneyUSD += d.thuocs[i].fiTotal}

					for (var j = 0; j < d.danhMucThuocs.length; j++) {
						if (d.thuocs[i].fiProductType == d.danhMucThuocs[j].fiCode) {
							d.thuocs[i].fiProductType = d.danhMucThuocs[j].fiName;
						}
					}
				}
				if (d.hoSo.fiPurposes != undefined && d.hoSo.fiPurposes != null) {
					d.purpose1 = false;
					d.purpose2 = false;
					d.purpose3 = false;
					d.purpose4 = false;
					d.purpose5 = false;
					d.purpose6 = false;
					d.purpose7 = false;
					d.purpose8 = false;
					d.purpose9 = false;
					if (d.hoSo.fiPurposes != null) {
						var purpose = d.hoSo.fiPurposes.split(';');
						for (var i = 0; i < purpose.length; i++) {
							if (purpose[i] == 1) {
								d.purpose1 = true;

							} else if (purpose[i] == 2) {
								d.purpose2 = true;
							} else if (purpose[i] == 3) {
								d.purpose3 = true;
							} else if (purpose[i] == 4) {
								d.purpose4 = true;
							} else if (purpose[i] == 5) {
								d.purpose5 = true;
							} else if (purpose[i] == 6) {
								d.purpose6 = true;
							} else if (purpose[i] == 7) {
								d.purpose7 = true;
							} else if (purpose[i] == 8) {
								d.purpose8 = true;
							} else {
								d.purpose9 = true;
							}
						}
					}
				}
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
					code: "17",
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

	self.capitalizeFirstLetter = function(text){
		text = text.trim();
		return text.charAt(0).toUpperCase() + text.slice(1);
	}


}
