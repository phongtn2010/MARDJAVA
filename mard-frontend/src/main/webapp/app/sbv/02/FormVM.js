function ProductVM(data, validator) {
    var productVMSelf = this;
    productVMSelf.fiDienGiai = ko.observable((data && data.hasOwnProperty('fiDienGiai')) ? data.fiDienGiai : null);
    productVMSelf.fiHamLuong = ko.observable((data && data.hasOwnProperty('fiHamLuong')) ? data.fiHamLuong : null);
    productVMSelf.fiKhoiLuong = ko.observable((data && data.hasOwnProperty('fiKhoiLuong')) ? data.fiKhoiLuong : null);
    productVMSelf.fiDonViTinh = ko.observable((data && data.hasOwnProperty('fiDonViTinh')) ? data.fiDonViTinh : null);
    productVMSelf.fiGiaTriUocTinh = ko.observable((data && data.hasOwnProperty('fiGiaTriUocTinh')) ? data.fiGiaTriUocTinh : null);
    productVMSelf.errorMsg = ko.observable('');
    productVMSelf.lstDVT  = ko.observableArray((data && data.hasOwnProperty('lstDVT')) ? data.lstDVT :[]);
    productVMSelf.lstTienTe  = ko.observableArray((data && data.hasOwnProperty('lstTienTe')) ? data.lstTienTe :[]);
    productVMSelf.lstVang  = ko.observableArray((data && data.hasOwnProperty('lstVang')) ? data.lstVang :[]);
    productVMSelf.selectedIndex = ko.observable(null);
    productVMSelf.fiProductList = ko.observableArray([])
        .extend({
            validation: {
                validator: function (val, params) {
                    return val.length >= params;
                },
                message: NSWLang["mard.06.tokhai.thong_tin_hang_hoa"] + " " + NSWLang["common_msg_formvalid_isrequired"],
                params: 1
            }
        })
    productVMSelf.addProduct = function () {
        // if (!productVMSelf.validate()) return;
        var item = {
            fiDienGiai: productVMSelf.fiDienGiai(),
            fiHamLuong: productVMSelf.fiHamLuong(),
            fiKhoiLuong: productVMSelf.fiKhoiLuong(),
            fiDonViTinh: productVMSelf.fiDonViTinh(),
            fiGiaTriUocTinh: productVMSelf.fiGiaTriUocTinh()
        }

        productVMSelf.fiProductList.push(item);
        productVMSelf.clearForm();
        if ($('#modal_addProduct').hasClass('in')) {
            $('#modal_addProduct').modal('hide')
        }
        if ($('#modal_addProduct').hasClass('in')) {
            $('#modal_addProduct').modal('hide')
        }
    }

    productVMSelf.openUpdateProduct = function (data, index, type) {
        ko.mapping.fromJS(data, {}, productVMSelf);
        productVMSelf.selectedIndex(index);
        if (type == '1' || type == 1) {
            $('#modal_editProduct1').modal('show');
        } else {
            $('#modal_editProduct1').modal('show');
        }
    }

    productVMSelf.updateProduct = function () {
        // if (!productVMSelf.validate()) return;
        var item = {
            fiDienGiai: productVMSelf.fiDienGiai(),
            fiHamLuong: productVMSelf.fiHamLuong(),
            fiKhoiLuong: productVMSelf.fiKhoiLuong(),
            fiDonViTinh: productVMSelf.fiDonViTinh(),
            fiGiaTriUocTinh: productVMSelf.fiGiaTriUocTinh()
        }
        var index = productVMSelf.selectedIndex();
        productVMSelf.fiProductList.splice(index, 1);
        productVMSelf.fiProductList.splice(index, 0, item);
        productVMSelf.clearForm();
        if ($('#modal_editProduct1').hasClass('in')) {
            $('#modal_editProduct1').modal('hide')
        }
        ;
        if ($('#modal_editProduct1').hasClass('in')) {
            $('#modal_editProduct1').modal('hide')
        }
        ;
    }

    productVMSelf.removeProduct = function (index) {
        productVMSelf.fiProductList.splice(index, 1);
    }

    productVMSelf.clearForm = function () {
        productVMSelf.errorMsg('');
        productVMSelf.fiDienGiai(null);
        productVMSelf.fiHamLuong(null);
        productVMSelf.fiKhoiLuong(null);
        productVMSelf.fiGiaTriUocTinh(null);
        productVMSelf.fiDonViTinh(null);
    }
}
