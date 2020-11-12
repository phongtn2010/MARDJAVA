function ProductVM(data, validator) {
    var productVMSelf = this;
    productVMSelf.fiDienGiai = ko.observable((data && data.hasOwnProperty('fiDienGiai')) ? data.fiDienGiai : null);
    productVMSelf.fiHamLuong = ko.observable((data && data.hasOwnProperty('fiHamLuong')) ? data.fiHamLuong : null);
    productVMSelf.fiKhoiLuong = ko.observable((data && data.hasOwnProperty('fiKhoiLuong')) ? data.fiKhoiLuong : null);
    productVMSelf.fiDonViTinh = ko.observable((data && data.hasOwnProperty('fiDonViTinh')) ? data.fiDonViTinh : null);
    productVMSelf.fiGiaTriUocTinh = ko.observable((data && data.hasOwnProperty('fiGiaTriUocTinh')) ? data.fiGiaTriUocTinh : null);
    productVMSelf.errorMsg = ko.observable('');
    productVMSelf.addProduct = function () {
        console.log("abc");
        // if (!productVMSelf.validate()) return;
        var item = {
            fiDienGiai: productVMSelf.fiDienGiai(),
            fiHamLuong: productVMSelf.fiHamLuong(),
            fiKhoiLuong: productVMSelf.fiKhoiLuong(),
            fiDonViTinh: productVMSelf.fiDonViTinh(),
            fiGiaTriUocTinh: productVMSelf.fiGiaTriUocTinh(),
        }
        console.log(item);
        // productVMSelf.fiProductList.push(item);
        // productVMSelf.clearForm();
        // if ($('#modal_addAnimal').hasClass('in')) {
        //     $('#modal_addAnimal').modal('hide')
        // }
        // ;
        // if ($('#modal_addAnimalProduct').hasClass('in')) {
        //     $('#modal_addAnimalProduct').modal('hide')
        // }
    }
}
