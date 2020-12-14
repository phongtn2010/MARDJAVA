function ThongTinChungViewModel(parent) {
	var self = this;
	self.tbdHoSo18 = convertObjectToKnockout(parent.formData.hoSo, new TbdHoSo18());
	self.isValid = function(isGuiHoSo) {
		if (self.tbdHoSo18.valid.errors().length > 0) {
			showError(self.tbdHoSo18);
			self.tbdHoSo18.valid.errors.showAllMessages();
			return false;
		}
		return true;
	}
	
	self.convertData = function () {
        return convertKnockoutToObject(self.tbdHoSo18, createObject(self.tbdHoSo18));
    }
}
