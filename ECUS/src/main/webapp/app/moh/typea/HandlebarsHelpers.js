
/**
 * ki?m tra tr?ng th�i h? s?, h? s? ?� c� phi?u ti�p nh?n ch?a
 * @param {type} param1
 * @param {type} param2
 */
Handlebars.registerHelper('checkViewPhieuTiepNhan', function (v1, options) {
    if (v1 == "4") {
        return options.fn(this);
    }
});

/**
 * ki?m tra xem thao t�c g?i h? s? ???c ph�o th?c hi?n hay kh�ng
 */
Handlebars.registerHelper('checkIfCanSend', function (v1,options) {
    if (v1 == "0" || v1 == "2") {
        return options.fn(this);
    }
});

/**
 * ki?m tra xem thao t�c x�a ???c ph�p th?c hi?n hay kh�ng
 */
Handlebars.registerHelper('checkIfCanDelete', function (v1, options) {
    if (v1 == "0") {
        return options.fn(this);
    }
});

/**
 * ki?m tra xem thao t�c ch�nh s?a ???c ph�p th?c hi?n hay kh�ng
 */
Handlebars.registerHelper('checkIfCanEdit', function (v1, options) {
    if (v1 == "0" || v1 == "2") {
        return options.fn(this);
    }
});
/**
 * ham hien thi ten phan nhom them ma phan nhom
 */
Handlebars.registerHelper('tenPhanNhom', function (v1) {
    if (v1 == "1") {
        return NSWLang["moh_typea_phannhom_donle"];
    }
    else if (v1 == "2") {
        return NSWLang["moh_typea_phannhom_vitro"];
    }
     else if (v1 == "3") {
        return NSWLang["moh_typea_phannhom_ivd"];
    }
     else if (v1 == "4") {
        return NSWLang["moh_typea_phannhom_cumttbytkhac"];
    }
     else if (v1 == "5") {
        return NSWLang["moh_typea_phannhom_hethongttbyt"];
    }
    else {
        return NSWLang["moh_typea_phannhom_hottbyt"];
    }
});


/**
 * format s? 
 */
Handlebars.registerHelper('formatNumber', function (n) {
   return n.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
});