function ThongTinChungViewModel(parent) {
	var self = this;
	self.tbdHoSo15 = convertObjectToKnockout(parent.formData.hoSo, new TbdHoSo15());
	self.isValid = function(isGuiHoSo) {
		if (self.tbdHoSo15.valid.errors().length > 0) {
			showError(self.tbdHoSo15, null, true);
			self.tbdHoSo15.valid.errors.showAllMessages();
			return false;
		}
		return true;
	}
	
	self.convertData = function () {
        return convertKnockoutToObject(self.tbdHoSo15, createObject(self.tbdHoSo15));
    }
}