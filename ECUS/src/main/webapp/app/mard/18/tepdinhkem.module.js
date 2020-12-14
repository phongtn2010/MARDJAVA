var token;

const tokenUrl = "https://mcupload.mard.gov.vn/UploadFile/FileAttachments/GetToken";
function getToken() {
	var settings = {
		"url" : tokenUrl,
		"method" : "GET",
		"timeout" : 0,
	};

	$.ajax(settings).done(function(response) {

		token = response.data;
		
	});
}

setInterval(getToken, 300000);
function ThongTinTepDinhKemViewModel(parent) {
	getToken();
	var self = this;
    self.addTep = function (tep){
	var self = this;
        self.teps.push(tep);
    };

    self.removeTep = function (tep){
    	var self = this;
              self.teps.remove(tep);
    };
	self.uploadNew = function getdata(k, fileTypeCode){
		var fd = new FormData();
		var files = $('#fileUpload')[0].files[k];

		
		fd.append('token',token);
		fd.append('documentType',"BNNPTNT0600007");
		fd.append('fileCode',fileTypeCode);
		fd.append('fileName',files.name);
		fd.append('file', files);

		$.ajax({
			url : 'https://mcupload.mard.gov.vn/UploadFile/FileAttachments/Upload',
			type : 'post',
			data : fd,
			contentType : false,
			processData : false,
			success : function(response) {
				if (response.status == "Successful" ) {
                    var tepTin1;
					
					tepTin1 = convertObjectToKnockout(response.data, new TepTinModel());
					//tepTin1.fiId(response.data.ItemId);
          			tepTin1.fiSize(files.size);
					tepTin1.link(response.data.UrlFile);
					tepTin1.fiFileName(files.name);
					tepTin1.fiFileTypeCode(1);
					tepTin1.fiFileGroup(documentType);
					tepTin1.fiPath(response.data.UrlFile);
					
          			self.addTep(tepTin1);
					$('#fileUpload').val('');

				} else {
					app.Alert('File upload không thành công vui lòng thử lại');
					$('#fileUpload').val('');
					getToken();
				}
			},
		});
	}

	self.xemHoSo = ko.observable(parent.xemHoSo());
	self.accepFiles = ['jpg', 'pdf', 'tif', 'JPG', 'PDF', 'TIF'];

	//self.danhMucTeps = ko.observableArray([]);
	self.selectedTep = ko.observable(documentType);

	self.teps = ko.observableArray();
	/*parent.formData.danhMucTepDinhKems.forEach(function(item, index){
		self.danhMucTeps.push(item);
		self.teps.push(ko.observableArray([]));
	});*/

	self.totalFileSize = ko.observable(0);
	self.layDanhSachTepTinTheoHS = function(){
		parent.formData.danhMucTepDinhKems.forEach(function(t){
			$(parent.formData.tepDinhKems).each(function(index, loopItem){
				if (t.fiFileTypeCode == loopItem.fiFileTypeCode) {
					//var tepTin = convertObjectToKnockout(loopItem, new TepTinModel());
					

					tepTin1 = convertObjectToKnockout(loopItem, new TepTinModel());
					tepTin1.xemHoSo(self.xemHoSo());
					
					tepTin1.link("https://mcupload.mard.gov.vn/sites/0600009/Lists/DataAttachment/Attachments/" + loopItem.fiId + "/" + loopItem.fiFileName);
					self.teps().push(tepTin1);
					
					//self.totalFileSize(self.totalFileSize() + tepTin.fiSize());
				}
			});
		});
	}

	self.layDanhSachTepTinTheoHS();

	self.uploadFileChangeEvent = function( elemet, event) {
		getToken();
		var files = event.target.files;
		for (var i = 0, file; file = files[i]; i++) {
			if (/#|%|&|\*|:|<|>|\?|\/|\{|\}/.test(file.name)) {
				app.Alert( 'Tên tệp không được chứa ký tự đặc biệt sau: ~ " # % & * : < > ? / \ { | }');
				$('#fileUpload').val('');
				return false;
			}
			var ext = file.name.substr(file.name.lastIndexOf('.') + 1);
			if ($.inArray(ext, self.accepFiles) === -1) {
				$('#fileUpload').val('');
				app.Alert( NSWLang["mard.18.uploadInfo"]);
				return false;
			}
		}
		var totalMB = 1024 * 1024 * 50;// 50MB

		$(files).each(function(index, item){
			self.totalFileSize(self.totalFileSize() + item.size);
		});
		if (self.totalFileSize() > totalMB) {
			$(files).each(function(index, item){
				self.totalFileSize(self.totalFileSize() - item.size);
			});
			$('#fileUpload').val('');
			app.Alert( NSWLang["mard.18.uploadSize"]);
			return false;
		}
		var findId = idHoSo;
		for (var k = 0; k < files.length; k++) {
			self.uploadNew( k, 1);

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

 self.xoaTepTin = function() {
        self.callConfirm(function () {
            
            if(self.teps().length > 0 ){
                $(self.teps()).each(function(index, loopItem){
                    if(loopItem.fiId() != undefined && loopItem.fiId() !== null){
                        $.getJSON(app.appContext + '/mard/18/tbdDinhKem18/delete/' + loopItem.fiId(), function (d) {
							self.teps().remove(loopItem);
                            self.totalFileSize(self.totalFileSize() - d.fiSize);
                        });
                    }
                    else{
                        
                        self.totalFileSize(self.totalFileSize() - loopItem.fiSize);
                        self.removeTep(loopItem);
                    }
                });
            }

        })


	}


  self.xoaMotFile = function(item1, position) {

        self.callConfirm(function () {
            var idHS = idHoSo;

            if(item1.fiId() != null && item1.fiId() >0){ // ??? Code này không hiểu trên vẫn có mà

                $.getJSON(app.appContext + '/mard/18/tbdDinhKem18/delete/' + item1.fiId(), function (d) {

                });
            }
            self.totalFileSize(self.totalFileSize() - item1.fiFileByte());
            self.removeTep(item1);


        })


	}

	self.isValid = function(isGuiHoSo) {
		if (isGuiHoSo) {
			var check = false;
			for (var i = 0; i < parent.formData.danhMucTepDinhKems.length; i++) {
				var item = parent.formData.danhMucTepDinhKems[i];
				if (item.fiFileGroup == self.selectedTep()) {
					if (self.teps().length > 0) {
						check = true;
					}
				}
			}
			if (check == false) {
				app.Alert( NSWLang["mard.18.tepDinhKem.notValid"]);
				return false;
			}
		}
		return true;
	}


	self.convertData = function() {
		var data = [];
				$(self.teps()).each(function(tIndex, t){
					data.push(convertKnockoutToObject(t, createObject(t)));
				});
		return data;
	}
}
