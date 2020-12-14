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

ko.validation.rules['minArrayLength'] = {
    validator: function (obj, params) {
        return obj.length >= params.minLength;
    },
    message: "Phải chọn ít nhất {0} {1}"
};


ko.validation.registerExtenders();

