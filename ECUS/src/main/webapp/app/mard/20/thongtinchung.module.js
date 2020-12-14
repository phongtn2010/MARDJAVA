function ThongTinChungViewModel(parent) {
	var self = this;
	self.tbdHoSo20 = convertObjectToKnockout(parent.formData.hoSo, new TbdHoSo20());
	self.isValid = function(isGuiHoSo) {
		if (self.tbdHoSo20.valid.errors().length > 0) {
			showError(self.tbdHoSo20);
			self.tbdHoSo20.valid.errors.showAllMessages();
			return false;
		}
		return true;
	}

	self.convertData = function () {
        return convertKnockoutToObject(self.tbdHoSo20, createObject(self.tbdHoSo20));
    }
}
