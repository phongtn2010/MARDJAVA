function ThongTinTepDinhKemViewModel(hoSo, thongTinChungModel) {
	var self = this;
	self.accepFiles = ['jpg', 'pdf', 'tif', 'JPG', 'PDF', 'TIF'];
	
	self.xemHoSo = ko.observable(xemHoSo);
	self.danhMucTeps = ko.observableArray([]);
    self.danhMucTepDuocChon = ko.observableArray([]);
	self.selectedTep = ko.observable(thongTinChungModel.loaiGiayPhep() == 2 ? 'XNK_TC_MA_TUY_GIAHAN' : 'XNK_TC_MA_TUY');
	
	self.teps = ko.observableArray();
	self.groupFileSelected = ko.observableArray([]);
	self.groupFileSelected.push(ko.observableArray([]));
    self.groupFileSelected.push(ko.observableArray([]));
    self.groupFileIndexSelected = ko.observable(thongTinChungModel.loaiGiayPhep() == 2 ? 1 : 0);

    hoSo.danhMucTepDinhKems.forEach(function(item, index){
        if (item.loaiTep == self.selectedTep()) {
            self.danhMucTepDuocChon.push(item);
        }
        if (item.loaiTep == 'XNK_TC_MA_TUY') {
            self.groupFileSelected()[0].push(ko.observableArray([]));
		} else {
            self.groupFileSelected()[1].push(ko.observableArray([]));
		}
	});
	self.layDanhSachTepTinTheoHS = function(){
		var ds = [];
        hoSo.danhMucTepDinhKems.forEach(function(t, tIndex){
            if (t.loaiTep == self.selectedTep()) {
				ds.push(t);
            }
        });
		 ds.forEach(function(t, tIndex){
     		 $(hoSo.tepDinhKems).each(function(index, loopItem){
     			 if (t.maLoaiTep == loopItem.maLoaiTep) {
     				 var tepTin = new TepTinModel();
                     tepTin.idTepTin(loopItem.idTepTin);
                     tepTin.idHoSo(loopItem.idHoSo);
                     tepTin.guID(loopItem.guID);
                     tepTin.duongDanFile(loopItem.duongDanFile);
                     tepTin.tenTepDinhKem(loopItem.tenTepDinhKem);
                     tepTin.maLoaiTep(loopItem.maLoaiTep);
                     tepTin.link(app.appContext +  '/moit/api/07/download/' + loopItem.idTepTin);
                     self.groupFileSelected()[self.groupFileIndexSelected()]()[tIndex].push(tepTin);
     			 }
    			
    		 });
     	});
	}
    thongTinChungModel.loaiGiayPhep.subscribe(function () {
        if (thongTinChungModel.loaiGiayPhep() == -1) return;
		if (thongTinChungModel.loaiGiayPhep() == 2) {
            self.selectedTep('XNK_TC_MA_TUY_GIAHAN');
            self.groupFileIndexSelected(1);
		} else {
            self.selectedTep('XNK_TC_MA_TUY');
            self.groupFileIndexSelected(0);
		}
        // self.groupFileSelected().forEach(function (group, groupIndex) {
        //
        //     self.groupFileSelected()[groupIndex]().forEach(function (groupDetail, groupDetailIndex) {
        //         groupDetail.removeAll();
        //         console.log("groupIdex = " + groupIndex + " > " + groupDetailIndex );
        //     })
        // })
		self.danhMucTepDuocChon.removeAll();

        hoSo.danhMucTepDinhKems.forEach(function (item) {
			if (item.loaiTep == self.selectedTep()) {
				self.danhMucTepDuocChon.push(item);
			}
        });
        app.makePost({
            url:'/moit/api/07/xoaTepDKByIdHoSo/' + idHoSo,
            data: JSON.stringify({}),
            success: function (d) {
            },
            error: function (e) {
            }
        });
        self.totalFileSize(0);
    })
	self.layDanhSachTepTinTheoHS();
	
	self.totalFileSize = ko.observable(hoSo.totalFileSize);
	self.uploadFileChangeEvent = function(loaiTep, position, elemet, event) {
		var files = event.target.files;
		for (var i = 0, file; file = files[i]; i++) {
			var ext = file.name.substr(file.name.lastIndexOf('.') + 1);
			if ($.inArray(ext, self.accepFiles) === -1) {
				$('#fileUpload' + position).val('');
				app.Alert(NSWLang["moit_06_form_teptin_error_3"]);
				return false;
			}
		}
		var totalMB = 1024 * 1024 * 4;// 3MB
		
	   	$(files).each(function(index, item){
	   		self.totalFileSize(self.totalFileSize() + item.size);
	   	});
	   	 if (self.totalFileSize() > totalMB) {
	   		cssError('fileUpload' + position);
	   	  	$(files).each(function(index, item){
		   		self.totalFileSize(self.totalFileSize() - item.size);
		   	});
	   	  	$('#fileUpload' + position).val('');
	   		 app.Alert(NSWLang["moit_06_totalSizeUploadError"] + ' 4MB!');
	   		 return false;
	   	 }
	   	 var groupIndex = 0;
        if (thongTinChungModel.loaiGiayPhep() == 2) {
            groupIndex = 1;
        }
		 var findId = idHoSo;
			for (var k = 0; k < files.length; k++) {
				var param = {};
				param.mcode = "moit";
				param.pcode = "07";
				param.file = files[k];
		        app.uploadFile({
		          url: '/moit/api/07/upload/' + findId + '/' + loaiTep,
		          data: param,
		          success: function (d) {
		            if (d.success) {
		            	 var tepTin = new TepTinModel();
			                tepTin.idTepTin(d.data.idTepTin);
			                tepTin.idHoSo(findId);
			                tepTin.guID(d.data.guID);
			                tepTin.duongDanFile(d.data.duongDanFile);
			                tepTin.tenTepDinhKem(d.data.tenTepDinhKem);
			                tepTin.maLoaiTep(d.data.maLoaiTep);
			                tepTin.loaiTep(d.data.loaiTep);
			                tepTin.size(d.data.size);
			                if (idHoSo > 0) {
			                	  tepTin.link(app.appContext +  '/moit/api/07/download/' + d.data.idTepTin);
			                } else {
			                	tepTin.link(app.appContext +  '/moit/api/07/getfile/moit/07/' + d.data.guID + '.' + d.data.loaiTep);
			                }
			                self.groupFileSelected()[groupIndex]()[position].push(tepTin);
                            // self.groupFileSelected().forEach(function (group, groupIndex) {
								// console.log("groupIdex = " + groupIndex);
                            //     self.groupFileSelected()[groupIndex]().forEach(function (groupDetail, groupDetailIndex) {
                            //         console.log("groupDetailIndex = " + groupDetailIndex + " : " + groupDetail().length);
                            //     })
                            // })
		            }
		             $('#fileUpload' + position).val('');
		          },
		          error: function (e) {
		          	 $('#fileUpload' + position).val('');
		          	toastr.error(NSWLang["common_msg_thong_bao"], e.message);
		          }
		      });
	        
	        cssSuccess('fileUpload' + position);
		}

	}
	
	
	

	self.delete = function(item, groupPosition) {
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
                        var arr = [];
                        if (item) {
                        	arr.push(item);
						} else {
                            $(self.groupFileSelected()[self.groupFileIndexSelected()]()[groupPosition]()).each(function(index, loopItem){
                                arr.push(loopItem);
                            });
						}
                        $(arr).each(function(index, loopItem){
                           if (idHoSo > 0) {
                               var url = '/moit/api/07/xoaTepDK/' + loopItem.idTepTin();
                               app.makePost({
                                   url: url,
                                   data: JSON.stringify({}),
                                   success: function (d) {
                                       var msg = d.message;
                                       var fun = 'success';
                                       if (d.success) {
                                           self.groupFileSelected()[self.groupFileIndexSelected()]()[groupPosition].remove(loopItem);
                                           self.totalFileSize(self.totalFileSize() - d.data.size);
                                       } else {
                                           toastr.error(NSWLang["common_msg_thong_bao"], d.message);
                                       }
                                   },
                                   error: function (e) {
                                       app.popupRemove(pop.selector);
                                       toastr.error(NSWLang["common_msg_thong_bao"], e.message);
                                   }
                               });
						   } else {
                               self.groupFileSelected()[self.groupFileIndexSelected()]()[groupPosition].remove(loopItem);
                               self.totalFileSize(self.totalFileSize() - loopItem.size());
						   }

                        });
                    }
                }
            ]
        });
	}
	

	 cssError = function(id) {
	 		var ele = $('#' + id);
	 		ele.focus();
	 		ele.css('border', '1px solid #f00');
	 		var p = $('span[aria-labelledby="select2-'+ id+'-container"]');
	 		p.css('border', '1px solid #f00');
	 	}
	  cssSuccess = function(id) {
	 		var ele = $('#' + id);
	 		ele.removeAttr('style');
	 		var p = $('span[aria-labelledby="select2-'+ id+'-container"]');
	 		p.removeAttr('style');
	 	}
	
	self.isValid = function(isGuiHoSo) {
        var check = true;
		if (isGuiHoSo) {
            self.groupFileSelected()[self.groupFileIndexSelected()]().forEach(function (groupDetail, groupDetailIndex) {
                // console.log("groupDetailIndex = " + groupDetailIndex + " : " + groupDetail().length + " > " + self.danhMucTepDuocChon()[groupDetailIndex].required);
                if ( self.danhMucTepDuocChon()[groupDetailIndex].required) {
                    if (groupDetail().length == 0) {
                        check = false;
                        return false;
                    }
                }
            })
   		 }
   		 if (!check) {
             app.Alert( NSWLang["moit_06_form_teptin_error_message"]);
		 }
		return check;
	}
	
	
	self.getTepDinhKems = function() {
		var data = [];
        self.groupFileSelected()[self.groupFileIndexSelected()]().forEach(function (groupDetail, groupDetailIndex) {
            // console.log("groupDetailIndex = " + groupDetailIndex + " : " + groupDetail().length + " > " + self.danhMucTepDuocChon()[groupDetailIndex].required);
            $(groupDetail()).each(function(tIndex, t){
                data.push({
                    idTepTin : t.idTepTin(),
                    idHoSo : t.idHoSo(),
                    guID : t.guID(),
                    duongDanFile : t.duongDanFile(),
                    tenTepDinhKem : t.tenTepDinhKem(),
                    maLoaiTep : t.maLoaiTep()
                });
            });
        })

		return data;
	}
}
