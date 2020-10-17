/**
 * @returns
 */
/**
 * @returns
 */
$(document).ready(function() {
function ViewModel() {

	var self = this;
	
	self.showActionError = ko.observable(false);
    self.showActionSuccess = ko.observable(false);
    self.errorMessage = ko.observable('');
	
	self.contextPath = ko.observable($('#contextPath').val());
	
	 $(".select2").select2({placeholder: '',  width: '100%'});
	  
     $('.date-picker').datepicker({rtl: false, orientation: "left", autoclose: true});


    self.xemChiTietHoSo = function (item) {
        location.href = app.appContext + '/mard/15/view/' + item.fiIdHoSo();
    }

	self.xinSua = function(item) {
		location.href = app.appContext + '/mard/15/ycs/'+item.fiIdHoSo();
	}

    self.themMoiHoSo = function() {
        location.href = app.appContext + '/mard/15/edit';
    }


    self.chinhSuaHoSo = function(item) {
        location.href= app.appContext + '/mard/15/edit/' + item.fiIdHoSo();
    }
   
	// danh sach ho so
	var loadHoSo = new LoadHoSoView(this);
	
	// xoa ho so
	self.xoaHoSo = function(item) {
		var xoaHoSoView = new XoaHoSoView();
		xoaHoSoView.show(item, function(){
               setTimeout(function(){
             	  location.reload();
               }, 1000);
 		});
	}
	
	self.xemHoSo = function(item) {
		var viewPopup= new PopupView();
		viewPopup.show(item);
	}
    self.xinSuaGiayPhep = function(item) {
       var view = new XinSuaGiayPhepViewModel();
       view.show(item, function () {
           setTimeout(function () {
               location.reload();
           }, 1000);
       });
    }
	// ket qua xu ly
	self.xemLichSu = function(item) {
		var history = new HistoryView();
		history.show(item);
	}

    //xem giay xac nhan
    self.xemGiayXacNhanClick = function(item) {
        var gxn = new PopupViewGP();
        gxn.show(item);
    }
    //yeu cau rut ho so
    self.huyHoSo = function(item) {
        var view = new HuyHoSoView();
        view.show(item, function () {
            setTimeout(function () {
                location.reload();
            }, 1000);
        });
    }

    self.toDate = function(dateStr) {
		var splits = dateStr.split("/");
		var day = splits[0];
		var month = splits[1];
		var year = splits[2];
	    return new Date(year, month - 1, day);
	}
	
}
    ko.validation.locale(locale);
var vm = new ViewModel();
ko.applyBindings(vm);
});
