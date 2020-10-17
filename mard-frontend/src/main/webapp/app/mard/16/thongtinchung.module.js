function ThongTinChungViewModel(parent) {
	var self = this;
	self.tbdHoSo16 = convertObjectToKnockout(parent.formData.hoSo, new TbdHoSo16());
	self.isValid = function(isGuiHoSo) {
		if (self.tbdHoSo16.valid.errors().length > 0) {
			showError(self.tbdHoSo16);
			self.tbdHoSo16.valid.errors.showAllMessages();
			return false;
		}
		return true;
	}
	
	self.convertData = function () {
        return convertKnockoutToObject(self.tbdHoSo16, createObject(self.tbdHoSo16));
    }
}