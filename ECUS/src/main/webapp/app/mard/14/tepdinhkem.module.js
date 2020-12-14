function ThongTinTepDinhKemViewModel(parent) {
	var self = this;
	self.xemHoSo = ko.observable(parent.xemHoSo());
	self.accepFiles = ['jpg', 'pdf', 'tif', 'JPG', 'PDF', 'TIF'];

	self.danhMucTeps = ko.observableArray([]);
	self.selectedTep = ko.observable(documentType);

	self.teps = ko.observableArray();
	parent.formData.danhMucTepDinhKems.forEach(function(item, index){
		self.danhMucTeps.push(item);
		self.teps.push(ko.observableArray([]));
	});

    self.totalFileSize = ko.observable(0);
	self.layDanhSachTepTinTheoHS = function(){
		 parent.formData.danhMucTepDinhKems.forEach(function(t, tIndex){
     		 $(parent.formData.tepDinhKems).each(function(index, loopItem){
     			 if (t.fiFileTypeCode == loopItem.fiFileTypeCode) {
                     var tepTin = convertObjectToKnockout(loopItem, new TepTinModel());
                     tepTin.xemHoSo(self.xemHoSo());
                     tepTin.link(app.appContext +  '/mard/api/14/download/' + loopItem.fiId);
                     self.teps()[tIndex].push(tepTin);
                     self.totalFileSize(self.totalFileSize() + tepTin.fiSize());
     			 }
    		 });
     	});
	}

	self.layDanhSachTepTinTheoHS();

	self.uploadFileChangeEvent = function(loaiTep, position, elemet, event) {
		var files = event.target.files;
		for (var i = 0, file; file = files[i]; i++) {
			var ext = file.name.substr(file.name.lastIndexOf('.') + 1);
			if ($.inArray(ext, self.accepFiles) === -1) {
				$('#fileUpload' + position).val('');
				app.Alert( NSWLang["mard.14.uploadInfo"]);
				return false;
			}
		}
		var totalMB = 1024 * 1024 * 5;// 5MB

	   	$(files).each(function(index, item){
	   		self.totalFileSize(self.totalFileSize() + item.size);
	   	});
	   	 if (self.totalFileSize() > totalMB) {
	   	  	$(files).each(function(index, item){
		   		self.totalFileSize(self.totalFileSize() - item.size);
		   	});
	   	  	$('#fileUpload' + position).val('');
	   	  	app.Alert( NSWLang["mard.14.uploadSize"]);
	   		 return false;
	   	 }
		 var findId = idHoSo;
			for (var k = 0; k < files.length; k++) {
				var param = {};
				param.mcode = "mard";
				param.pcode = "14";
				param.file = files[k];
		        app.uploadFile({
		          url: '/mard/api/14/upload/' + findId + '/' + loaiTep,
		          data: param,
		          success: function (d) {
		            if (d.success) {
		            	 var tepTin = convertObjectToKnockout(d.data, new TepTinModel());
			                if (idHoSo > 0) {
			                	  tepTin.link(app.appContext +  '/mard/api/14/download/' + d.data.fiId);
			                } else {
			                	tepTin.link(app.appContext +  '/mard/api/14/getfile/' + param.mcode + '/' + param.pcode + '/' + d.data.fiFileCode);
			                }

			                self.teps()[position].push(tepTin);
		            }
		             $('#fileUpload' + position).val('');
		          },
		          error: function (e) {
		          	 $('#fileUpload' + position).val('');
		          	toastr.error(NSWLang["common_msg_thong_bao"], e.message);
		          }
		      });

		}

	}

    self.callConfirm = function(affter) {
        var pop = app.popup({
            title: NSWLang["common_msg_thong_bao"],
            html: '<i class="fa fa-3x fa-warning"></i> ' + NSWLang["common_msg_xoa_ho_so"],
            width: 400,
            buttons: [
                {
                    name: NSWLang["common_button_toi_chac_chan"],
                    class: 'btn',
                    icon: 'fa-check',
                    action: function () {
                        app.popupRemove(pop.selector);
                        if (affter) {
                            affter();
                        }
                    }
                }
            ]
        });
    }

	self.xoaTepTin = function(position) {
        self.callConfirm(function () {
            var idHS = idHoSo;
            if (idHS > 0) {
                $(self.teps()[position]()).each(function(index, loopItem){
                    $.getJSON(app.appContext + '/mard/14/tbdDinhKem14/delete/' + loopItem.fiId(), function (d) {
                        self.teps()[position].remove(loopItem);
                        self.totalFileSize(self.totalFileSize() - d.fiSize);
                        self.teps()[position].remove(loopItem);
                    });

                });
            } else {
                $(self.teps()[position]()).each(function(index, loopItem){
                    self.totalFileSize(self.totalFileSize() - loopItem.fiSize());
                    self.teps()[position].remove(loopItem);
                });
            }
        })

	}


	self.xoaMotFile = function(item, position) {

        self.callConfirm(function () {
            var idHS = idHoSo;
            if (idHS > 0) {
                $.getJSON(app.appContext + '/mard/14/tbdDinhKem14/delete/' + item.fiId(), function (d) {
                    self.teps()[position].remove(item);
                    self.totalFileSize(self.totalFileSize() - d.fiSize);
                });
            } else {
                self.totalFileSize(self.totalFileSize() - item.fiSize());
                self.teps()[position].remove(item);
            }
        })


	}

	self.isValid = function(isGuiHoSo) {
		if (isGuiHoSo) {
			var check = false;
   			for (var i = 0; i < parent.formData.danhMucTepDinhKems.length; i++) {
   			 var item = parent.formData.danhMucTepDinhKems[i];
   				if (item.fiFileGroup == self.selectedTep()) {
       				if (self.teps()[i]().length > 0) {
       					check = true;
       				}
   				}
   			}
   			if (check == false) {
                app.Alert( NSWLang["mard.14.tepDinhKem.notValid"]);
   				return false;
			}
   		 }
		return true;
	}


	self.convertData = function() {
		var data = [];
		parent.formData.danhMucTepDinhKems.forEach(function(item, index){
			 if (item.fiFileGroup  == self.selectedTep()) {
				 $(self.teps()[index]()).each(function(tIndex, t){
					 data.push(convertKnockoutToObject(t, createObject(t)));
					});
			 }
	     });
		return data;
	}
}
