function XoaHoSoView() {
	var self = this;
	self.show = function(item, success) {
		callBack(function () {
            callApi(pathAPI + "/xoaHoSo/" + item.fiIdHoSo(), null, function (d) {
                setTimeout(function () {
                    location.reload();
                }, 1000);
            })
        })
	}
	
}