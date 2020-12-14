function ThongTinChungViewModel(parent) {
	var self = this;
	self.tbdHoSo14 = convertObjectToKnockout(parent.formData.hoSo, new TbdHoSo14());
	self.isValid = function(isGuiHoSo) {
		if (self.tbdHoSo14.valid.errors().length > 0) {
			showError(self.tbdHoSo14);
			self.tbdHoSo14.valid.errors.showAllMessages();
			return false;
		}
		return true;
	}
	
	self.convertData = function () {
        return convertKnockoutToObject(self.tbdHoSo14, createObject(self.tbdHoSo14));
    }
}