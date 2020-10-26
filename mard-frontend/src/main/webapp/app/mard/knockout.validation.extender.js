/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


ko.validation.rules['validationYear'] = {
    validator: function (val) {
        var d = new Date();
        var n = d.getFullYear();
        return val <= n;
    },
    message: 'Thông tin năm phải nhỏ hơn hoặc bằng năm hiện tại.'
};


ko.validation.rules['validationPhoneNumber'] = {
    validator: function (phoneNumber) {
        if (typeof (phoneNumber) !== 'string') { return false; }
        phoneNumber = phoneNumber.replace(/\s+/g, "");
        return validate && phoneNumber.length > 9 && phoneNumber.match(/^(1-?)?(\([2-9]\d{2}\)|[2-9]\d{2})-?[2-9]\d{2}-?\d{4}$/);
    },
    message: 'Please specify a valid phone number.'
};

ko.validation.registerExtenders();
