function ThongTinChungViewModel(parent) {
	var self = this;
	self.tbdHoSo17 = convertObjectToKnockout(parent.formData.hoSo, new TbdHoSo17());
	self.isValid = function(isGuiHoSo) {
		if (self.tbdHoSo17.valid.errors().length > 0) {
			showError(self.tbdHoSo17);
			self.tbdHoSo17.valid.errors.showAllMessages();
			return false;
		}
		return true;
	}
	
	self.convertData = function () {
        return convertKnockoutToObject(self.tbdHoSo17, createObject(self.tbdHoSo17));
    }
}
