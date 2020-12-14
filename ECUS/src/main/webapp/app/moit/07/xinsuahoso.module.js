function XinSuaHoSoViewModel(hoSo) {
	var self = this;
	self.xinSuaHoSoModel = new XinSuaHoSoModel();
	self.xinSuaHoSoModel.lyDoSua(hoSo.lyDoSua);
	self.xemHoSo = ko.observable(xemHoSo);
	self.isYeuCauSua = ko.observable(isYeuCauSua);
	self.xinSuaHoSoModel.valid.errors.showAllMessages(false);
	self.isValid = function(isGuiHoSo) {
		if (self.isYeuCauSua && isGuiHoSo) {
			if (self.xinSuaHoSoModel.lyDoSua() == null || self.xinSuaHoSoModel.lyDoSua().trim() == '') {
				self.xinSuaHoSoModel.lyDoSua('');
				cssError('xinSuaHoSoModel_LyDoSua');
				self.xinSuaHoSoModel.valid.errors.showAllMessages();
				return false;
			} else {
				cssSuccess('xinSuaHoSoModel_LyDoSua');
			}
		}
		
		return true;
	}
}