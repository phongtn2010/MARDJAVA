function ThongTinChungViewModel(parent) {
	var self = this;
	self.tbdHoSo19 = convertObjectToKnockout(parent.formData.hoSo, new TbdHoSo19());
	self.isValid = function(isGuiHoSo) {
		if (self.tbdHoSo19.valid.errors().length > 0) {
			showError(self.tbdHoSo19);
			self.tbdHoSo19.valid.errors.showAllMessages();
			return false;
		}
		return true;
	}
	
	self.convertData = function () {
        return convertKnockoutToObject(self.tbdHoSo19, createObject(self.tbdHoSo19));
    }
}
