/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* global app, RAW_HS_STATUS */

var TAO_MOI = 0;
var CHO_TIEP_NHAN = 1;
var DA_TIEP_NHAN = 2;
var YC_BO_SUNG = 3;
var DA_RUT_HOSO = 4;
var DA_BO_SUNG_HOSO = 5;
var YC_SUA_GIAYPHEP = 6;
var DONG_Y_YC_SUA_GP = 7;
var TU_CHOI_CAP_GIAYPHEP = 8;
var DUOC_CAP_GIAYPHEP = 9;
var DA_CAP_LAI_GIAYPHEP = 10;
var DA_THU_HOI = 11;
var TU_CHOI_YC_SUA_GP = 12;
var YC_RUT_HOSO = 13;
var DONG_Y_YC_RUT = 14;
var TU_CHOI_YC_RUT = 15;
var YC_SUA_HOSO = 16;
var DONG_Y_YC_SUA = 17;
var TU_CHOI_YC_SUA = 18;
var DA_DUYET = 19;
var THONG_BAO_PHI = 20;
var DA_THANH_TOAN = 21;
var YC_BS_PHI = 22;
var XACNHAN_THANHTOAN_PHI = 23;

function ConfirmMessageVM(fiMsg, fiMaHoso) {
    var self = this;
    self.fiMsg = ko.observable(fiMsg);
    self.fiMaHoso = ko.observable(fiMaHoso);
}

ko.observableArray.fn.firstIndexOf = function (predicate, predicateOwner) {
    for (var i = 0, j = this().length; i < j; i++) {
        if (predicate.call(predicateOwner, this()[i])) {
            return i;
        }
    }
    return -1;
};

var mapTbdlichsu01 = function (dataFromServer, p) {
    return ko.utils.arrayMap(dataFromServer, function (item, index) {
        return new Tbdlichsu01(index + 1 + p, item);
    });
};
var Tbdlichsu01 = function (STT, item) {
    var self = this;
    this.STT = ko.observable(STT);
    if (item != null) {
        ko.mapping.fromJS(item, {}, self);
    }

    self.fiNgaytao = ko.observable(item.fiNgaytao ? new Date(item.fiNgaytao).toDayFirstWithTime() : null);
};

var mapCategory = function (dataFromServer, idName, textName) {
    if (idName && textName) {
        return ko.utils.arrayMap(dataFromServer, function (item) {
            return new Category(item[idName], item[textName]);
        });
    } else {
        return ko.utils.arrayMap(dataFromServer, function (item) {
            return new Category(item.id, item.name);
        });
    }
};
var Category = function (id, name) {
    this.id = id;
    this.name = name;
};

var mapTbdhoso01 = function (d, p) {
    return ko.utils.arrayMap(d, function (item, index) {
        return new Tbdhoso01((index + 1) + p, item);
    });
};
function Tbdhoso01(STT, item) {
    var self = this;

    if (item) {
        ko.mapping.fromJS(item, {}, self);
    }
    self.fiTenTrangthai = ko.computed(function () {
        if (!RAW_HS_STATUS || RAW_HS_STATUS.length <= 0) {
            return self.fiTrangthai();
        } else {
            for (var i = 0; i < RAW_HS_STATUS.length; i++) {
                if (RAW_HS_STATUS[i]["id"] == self.fiTrangthai()) {
                    return RAW_HS_STATUS[i]["name"] ? RAW_HS_STATUS[i]["name"] : self.fiTrangthai();
                }
            }
        }
    }, self);

    if ([DUOC_CAP_GIAYPHEP, DA_CAP_LAI_GIAYPHEP].indexOf(self.fiTrangthai()) < 0) {
        self.fiNgaycapGp(null);
    }

    self.STT = ko.observable(STT);
    self.bXemLichSu = ko.dependentObservable(function () {
        return true;
    }, self);
    self.bSuaHoSo = ko.dependentObservable(function () {
        //return true;
        return [TAO_MOI, CHO_TIEP_NHAN, YC_BO_SUNG].indexOf(self.fiTrangthai()) >= 0;
    }, self);
    self.bXinSuaHoSo = ko.dependentObservable(function () {
        //return true;
        return [DA_TIEP_NHAN, DONG_Y_YC_SUA, TU_CHOI_YC_SUA, DA_BO_SUNG_HOSO, DA_DUYET].indexOf(self.fiTrangthai()) >= 0;
    }, self);
    self.bXinRutHoSo = ko.dependentObservable(function () {
        //return true;
        return [DONG_Y_YC_SUA_GP, TU_CHOI_CAP_GIAYPHEP, DUOC_CAP_GIAYPHEP
                    , DA_CAP_LAI_GIAYPHEP, TU_CHOI_YC_SUA_GP, DONG_Y_YC_RUT, DA_RUT_HOSO
                    , YC_RUT_HOSO, YC_SUA_HOSO, TAO_MOI, DA_THU_HOI, YC_SUA_GIAYPHEP].indexOf(self.fiTrangthai()) <= 0;

    }, self);
    self.bThongTinPhi = ko.dependentObservable(function () {
        return [THONG_BAO_PHI, YC_BS_PHI].indexOf(self.fiTrangthai()) >= 0;
    }, self);
    self.bXoaHoSo = ko.dependentObservable(function () {
        //return true;
        return [TAO_MOI].indexOf(self.fiTrangthai()) >= 0;
    }, self);
    self.bXemThongBao = ko.dependentObservable(function () {
        //return true;
        return [DUOC_CAP_GIAYPHEP, DA_CAP_LAI_GIAYPHEP, TU_CHOI_YC_SUA_GP, YC_SUA_GIAYPHEP, DA_THU_HOI].indexOf(self.fiTrangthai()) >= 0;
    }, self);


    self.fiNgayguiText = ko.observable(item.fiNgaygui ? new Date(item.fiNgaygui).toDayFirstWithTime() : null);
}

function TbdhsHanghoa01(data, i) {
    var self = this;
    self.STT = ko.observable(i);
    self.fiIdHh = ko.observable(data ? data.fiId : null);
    self.fiIdNhh = ko.observable(data ? data.fiIdNhh : null);
    self.fiTenhanghoa = ko.observable(data ? data.fiTenhanghoa : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 500 ký tự', params: 500}
    });
    self.fiMahs = ko.observable(data ? data.fiMahs : null);
    self.fiChungloai = ko.observable(data ? data.fiChungloai : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 500 ký tự', params: 500}
    });
    self.fiSoluong = ko.observable(data ? data.fiSoluong : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        pattern: {message: 'Không nhập trước dấu chấm quá 13 chữ số, sau dấu phẩy 2 chữ số , số âm và chữ', params: /^([0-9]{1,13}(\.[1-9]{1,3})?)$/}
    });
    self.fiTenDvt = ko.observable(data ? data.fiTenDvt : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 50 ký tự', params: 50}
    });
    self.fiKichthuoc = ko.observable(data ? data.fiKichthuoc : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });

    var hanghoaVG = [self.fiTenhanghoa, self.fiChungloai, self.fiSoluong, self.fiTenDvt, self.fiKichthuoc];
    self.hanghoaError = ko.validation.group(hanghoaVG, {deep: true, live: true, observable: true});

    self.fiNgaygui = ko.observable(data ? data.fiNgaygui : null);
    self.fiHoatdong = ko.observable(data ? data.fiHoatdong : null);
    self.fiNguoitao = ko.observable(data ? data.fiNguoitao : null);
    self.fiNgaytao = ko.observable(data ? data.fiNgaytao : null);
    self.fiNgCapnhat = ko.observable(data ? data.fiNgCapnhat : null);




}
var mapTbdhsHanghoa01 = function (d) {
    return ko.utils.arrayMap(d, function (item, index) {
        item.fiStt = index + 1;
        return new TbdhsHanghoa01(item, index + 1);
    });
};

function TbdhsNhomHanghoa01(data, i) {
    var self = this;
    self.STT = ko.observable(i);
    self.fiIdNhh = ko.observable(data ? data.fiIdNhh : null);
    self.fiIdHoso = ko.observable(data ? data.fiIdHoso : null);
    self.fiMaHoso = ko.observable(data ? data.fiMaHoso : null);
    self.fiTenNhh = ko.observable(data ? data.fiTenNhh : "Nhóm " + i).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiNguoiDaidien = ko.observable(data ? data.fiNguoiDaidien : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 100 ký tự', params: 100}
    });
    self.fiTenAnh = ko.observable(data ? data.fiTenAnh : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 100 ký tự', params: 100}
    });
    self.fiNoidungAnh = ko.observable(data ? data.fiNoidungAnh : null);
    self.fiHochieu = ko.observable(data ? data.fiHochieu : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 50 ký tự', params: 50}
    });
    self.fiNgaycapHochieu = ko.observable(data ? new Date(data.fiNgaycapHochieu) : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
    });
    self.fiLydo = ko.observable(data ? data.fiLydo : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 500 ký tự', params: 500}
    });
    self.fiHinhthuc = ko.observable(data ? data.fiHinhthuc : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 1 ký tự', params: 1}
    });
    self.fiThoigianvaoTungay = ko.observable(data ? new Date(data.fiThoigianvaoTungay) : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    self.fiThoigianvaoDenngay = ko.observable(data ? new Date(data.fiThoigianvaoDenngay) : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    if (data.fiThoigianraTungay != null) {
        self.fiThoigianraTungay = ko.observable(data ? new Date(data.fiThoigianraTungay) : null);
    } else {
        self.fiThoigianraTungay = ko.observable(data ? data.fiThoigianraTungay : null);
    }
    if (data.fiThoigianraDenngay != null) {
        self.fiThoigianraDenngay = ko.observable(data ? new Date(data.fiThoigianraDenngay) : null);
    } else {
        self.fiThoigianraDenngay = ko.observable(data ? data.fiThoigianraDenngay : null);
    }
    self.fiCuakhauVao = ko.observable(data ? data.fiCuakhauVao : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });
    self.fiCuakhauRa = ko.observable(data ? data.fiCuakhauRa : null);
    self.fiPtVanchuyen = ko.observable(data ? data.fiPtVanchuyen : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
        maxLength: {message: 'Tối đa 250 ký tự', params: 250}
    });

    var nhomHHVG = [self.fiTenNhh, self.fiNguoiDaidien, self.fiTenAnh, self.fiNoidungAnh, self.fiHochieu,
        self.fiNgaycapHochieu, self.fiLydo, self.fiHinhthuc, self.fiThoigianvaoTungay, self.fiThoigianvaoDenngay,
        self.fiCuakhauVao, self.fiCuakhauRa, self.fiPtVanchuyen];
    self.nhomHHErrors = ko.validation.group(nhomHHVG, {deep: true, live: true, observable: true});

    self.fiGuiid = ko.observable(data ? data.fiGuiid : null);
    self.fiDuongDan = ko.observable(data ? data.fiDuongDan : null);
    self.fiNgaygui = ko.observable(data ? data.fiNgaygui : null);
    self.fiHoatdong = ko.observable(data ? data.fiHoatdong : null);
    self.fiNguoitao = ko.observable(data ? data.fiNguoitao : null);
    self.fiNgaytao = ko.observable(data ? data.fiNgaytao : null);
    self.fiNgCapnhat = ko.observable(data ? data.fiNgCapnhat : null);
    self.lstHanghoa01s = ko.observableArray(mapTbdhsHanghoa01(data.hasOwnProperty('lstHanghoa01s') ? data.lstHanghoa01s : []));
    self.lstHinhthuc = ko.observableArray(mapCategory(HINHTHUC ? HINHTHUC : [], "id", "name"));

    self.changeHTItem = function(){
        if(self.fiHinhthuc()===2){
            $("#tgratungay_lbl_").show();
            $("#tgradenngay_lbl_").show();
        }else{
            $("#tgratungay_lbl_").hide();
            $("#tgradenngay_lbl_").hide();
            self.fiThoigianraTungay(null);
            self.fiThoigianraDenngay(null);
        }
    }
    
    //tamdt
    self.validTimeInOut = function (item) {
        debugger;
        
        //dinhpv
        if (item.fiThoigianvaoTungay() != null) {
            $("#fiNgaycapHochieu_lbl_" + item.STT()).hide();
        } else {
            $("#fiNgaycapHochieu_lbl_" + item.STT()).show();
        }
        
        //time in
        if (item.fiThoigianvaoTungay() != null) {
            $("#fiThoigianvaoTungay_lbl_" + item.STT()).hide();
        } else {
            $("#fiThoigianvaoTungay_lbl_" + item.STT()).show();
        }

        if (item.fiThoigianvaoDenngay() != null) {
            $("#fiThoigianvaoDenngay_lbl_" + item.STT()).hide();
        } else {
            $("#fiThoigianvaoDenngay_lbl_" + item.STT()).show();
        }

        //time out
        if (item.fiHinhthuc()===2){
            if (item.fiThoigianraTungay() != null) {
                $("#fiThoigianraTungay_lbl_" + item.STT()).hide();
            } else {
                $("#fiThoigianraTungay_lbl_" + item.STT()).show();
            }

            if (item.fiThoigianraDenngay() != null) {
                $("#fiThoigianraDenngay_lbl_" + item.STT()).hide();
            } else {
                $("#fiThoigianraDenngay_lbl_" + item.STT()).show();
            }
        }

    }

    //XU LY SU KIEN BUTTON

    /**
     * 
     *Xóa hàng hóa
     * 
     */
    self.removeHangHoaOnClick = function (item) {

        if (item) {
            var pop = app.popup({
                title: 'Thông báo',
                html: '<b>Bạn chắc chắn muốn xoá dữ liệu của hàng hoá này?</b>',
                width: 450,
                buttons: [
                    {
                        name: NSWLang["common_button_toi_chac_chan"],
                        class: 'btn',
                        icon: 'fa-save',
                        action: function () {
                            self.lstHanghoa01s.remove(function (o) {
                                return o.fiIdHh() == item.fiIdHh();
                            });
                            for (var i = 0; i < self.lstHanghoa01s().length; i++) {
                                self.lstHanghoa01s()[i].STT(i + 1);
                            }
                            app.popupRemove(pop.selector);
                        }
                    },
                    {
                        name: 'Huỷ',
                        class: 'btn',
                        icon: 'fa-close',
                        action: function () {
                            app.popupRemove(pop.selector);
                        }
                    }
                ]
            });
        }
    };

    //BUTTON END
    // xu lý dowload ảnh đại diện
    /**
     * check upload 
     */
    self.canUpload = ko.computed(function () {
        return (self.fiTenAnh() == null);
    }, this);

    self.canDelete = ko.computed(function () {
        return (self.fiTenAnh() !== null && self.fiTenAnh() !== undefined);
    }, this);
    self.deleteImg = function () {
        return self.fiTenAnh(null);
    };
    /**
     * check Download
     */
    self.canDownload = ko.computed(function () {
        return self.fiTenAnh() != null;
    }, this);
    /**
     * url download anh
     */
    self.downloadUrl = ko.computed(function () {
        if (self.fiTenAnh()) {
            return app.appContext + '/bca/01/file/' + self.fiDuongDan() + '/' + self.fiGuiid();
        }
        return null;
    }, this);
    /**
     * upload anh
     */
    self.doUpload = function (item, e) {

        var files = e.target.files;
        if (!files || files.length <= 0) {
            return;
        }

        var fd = new FormData();
        fd.append("file", files[0]);
        //Check validate file
        if (!Util.uploadFileNameValidate(files[0].name)) {
            $('#loading10').hide();
            //no remove this line
            e.target.value = '';
            return;
        }

        //check name utf8
        if (Util.hasUnicode(files[0].name)) {
            $('#loading10').hide();
            //no remove this line
            e.target.value = '';
            return;
        }

        if (!Util.validateFieExtensionWithoutDom(files)) {
            $('#loading10').hide();
            //no remove this line
            e.target.value = '';
            return;
        }

        if (!Util.validateAttachByFile(files[0])) {
            $('#loading10').hide();
            //no remove this line
            e.target.value = '';
            return;
        }

        var cb = function (d) {
            var data = d.data;
            if (d.success) {
                item.fiGuiid(data.fileCode);
                item.fiTenAnh(data.fileName);
                item.fiDuongDan(data.filePath);
                item.fiIdNhh(self.fiIdNhh());
                
                $("#file_lbl_"+item.STT()).hide();
                
            } else {
                $("#file_lbl_"+item.STT()).show();
                app.toast({
                    title: NSWLang["common_msg_thong_bao"],
                    message: data.message,
                    function: 'success'
                });
            }
        };

        app.uploadFile({
            file: files[0],
            mcode: 'bca',
            pcode: '01',
            url: '/bca/01/upload',
            success: function (d) {

                e.target.value = '';
                cb(d);
            },
            error: function (e) {

            }
        });
    };
    // xu lý dowload ảnh đại diện END
}


var mapTbdhsNhomHanghoa01 = function (d) {
    return ko.utils.arrayMap(d, function (item, index) {
        item.fiStt = index + 1;
        return new TbdhsNhomHanghoa01(item, index + 1);
    });
}

var mapTbdgiayphep01 = function (d) {
    return ko.utils.arrayMap(d, function (item, index) {
        return new Tbdgiayphep01(index + 1, item);
    });
};
var Tbdgiayphep01 = function (STT, item) {
    var self = this;
    this.STT = ko.observable(STT);
    if (item) {

        ko.mapping.fromJS(item, {}, self);
    }

    self.fiTrangthai = ko.observable(item.fiTrangthai);
    self.fiNgayCPText = ko.observable(item.fiNgayky ? new Date(item.fiNgayky).toDayFirstWithTime() : null);
    self.isChecked = ko.observable(false);
    self.isDisable = ko.dependentObservable(function () {
        // return True
        return [YC_SUA_GIAYPHEP].indexOf(self.fiTrangthai()) >= 0;

    }, self)

};