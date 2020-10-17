/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
Handlebars.registerHelper('showAttachments', function (items, type) {
    var out = '';
    if (items === null || (typeof (items) === 'undefined') || (items !== null && items.length === 0))
        return out;
    var files = items.getArray('fiMaLoai', type);

    for (var i = 0, l = files.length; i < l; i++) {
        if(files[i].fiSoVb != null) {
            out = out + files[i].fiSoVb + ", "
        }
        if(files[i].fiNgayCap != null) {
            out = out + NSWLang["common_ngay"] + ": " + Handlebars.helpers.convertToDateFromTimeStamp.apply(this, [files[i].fiNgayCap]) + ";";
        }
    }

    return out;
});

Handlebars.registerHelper('showDelayCommand', function (v1, type, arr, options) {
    if (type === 1) {
        var a = JSON.parse(arr);
        if (a.indexOf(v1) >= 0) {
            return options.fn(this);
        }
    }
    return options.inverse(this);
});

Handlebars.registerHelper('showDepartment', function (type, cqxl1, cqxl2) {
    if (type === 1) {
        return cqxl1;
    } else {
        return cqxl2;
    }
});

Handlebars.registerHelper('giayChungNhan', function (items, type) {
    var out = "..., " + NSWLang["most_01_thongbao_do"] + "..." + NSWLang["most_01_thongbao_capngay"] + "...";
    if (items === null || (typeof (items) === 'undefined') || (items !== null && items.length === 0))
        return out;

    var files = items.getArray('fiMaLoai', type);

    if (files === null || (typeof (files) === 'undefined') || (files !== null && files.length === 0)) {
        out = '';
        return out;
    }

    out = '';
    for (var i = 0, l = files.length; i < l; i++) {
        out = files[i].fiSoVb + ", " + NSWLang["most_01_thongbao_do"] + " " + files[i].fiDvCap + ", " + NSWLang["most_01_thongbao_capngay"] + " " + Handlebars.helpers.convertToDateFromTimeStamp.apply(this, [files[i].fiNgayCap]) + ";";
    }

    return out;
});

Handlebars.registerHelper('chungThuGiamDinh', function (items, type) {
    var out = "..., " + NSWLang["most_01_thongbao_do"] + "..." + NSWLang["most_01_thongbao_capngay"] + "...";
    if (items === null || (typeof (items) === 'undefined') || (items !== null && items.length === 0))
        return out;

    var files = items.getArray('fiMaLoai', type);

    if (files === null || (typeof (files) === 'undefined') || (files !== null && files.length === 0)) {
        out = '';
        return out;
    }
    out = '';
    for (var i = 0, l = files.length; i < l; i++) {
        out = files[i].fiSoVb + ", " + NSWLang["most_01_thongbao_do"] + " " + files[i].fiDvCap + ", " + NSWLang["most_01_thongbao_capngay"] + " " + Handlebars.helpers.convertToDateFromTimeStamp.apply(this, [files[i].fiNgayCap]) + ";";
    }

    return out;
});

Handlebars.registerHelper('getResultFromCqxl', function (fiSoGCN, fiNgayCap, fiDvCap) {
    var out = "..., " + NSWLang["most_01_thongbao_do"] + "..." + NSWLang["most_01_thongbao_capngay"] + "...";
    if (typeof (fiSoGCN) === 'undefined' || typeof (fiNgayCap) === 'undefined' || typeof (fiDvCap) === 'undefined')
        return '';
    
    out = (fiSoGCN ? fiSoGCN : '...') + ", "
            + NSWLang["most_01_thongbao_do"] + " " + (fiDvCap ? fiDvCap : '..') + ", "
            + NSWLang["most_01_thongbao_capngay"]
            + " " + (fiNgayCap ? Handlebars.helpers.convertToDateFromTimeStamp.apply(this, [fiNgayCap]) : '...') + ";";
    return out;
});

Handlebars.registerHelper('getCommandName', function (cmd) {
    return NSWLang[cmd];
});

Handlebars.registerHelper('buildDownloadUrlForNewFile', function (minister, propcode, guid) {
    return context + '/downloadnew/' + minister + '/' + propcode + '/' + guid;
});

Handlebars.registerHelper('buildDownloadFileUrl', function (guid) {
    return app.appContext + "/file/download/" + guid;
});

Handlebars.registerHelper('viewPaper', function (status, type, arr, options) {
    var a = JSON.parse(arr);
    if (type === 2) {
        if (a.indexOf(status) >= 0) {
            return options.fn(this);
        }
    }
    return options.inverse(this);
});

Handlebars.registerHelper('viewResult', function (status, type, arr, options) {
    var a = JSON.parse(arr);
    if (type === 1) {
        if (a.indexOf(status) >= 0) {
            return options.fn(this);
        }
    }
    return options.inverse(this);
});

Handlebars.registerHelper("showStatus", function (v) {
    if (v === 1)
        return 'Phù hợp';
    else if (v === 2)
        return 'Không phù hợp';
    else if (v === 3)
        return NSWLang["common_ngoaidanhmuc"];
    else
        return '';
});

Handlebars.registerHelper("showResult", function (v) {
    return NSWLang['most_01_tb_status_status' + v];
});

Handlebars.registerHelper('countProduct', function (fiIdDinhkem) {
    var out = '0';
    var products = window.detailDocument.hangHoa.List;
    if (products === null || (typeof (products) === 'undefined') || (products !== null && products.length === 0))
        return out;
    var files = products.getArray('fiIdDinhkem', fiIdDinhkem);
    return files.length;
});

Handlebars.registerHelper('showEditCommand', function (v1, type, arr, options) {
    if (type === 1) {//CQKT
        var a = JSON.parse(arr);
        if (a.indexOf(v1) >= 0) {
            return options.fn(this);
        }
    }
    return options.inverse(this);
});

Handlebars.registerHelper('showRequestEditCommand', function (status, type, arr, options) {
    var a = JSON.parse(arr);
    if (type === 1) {//CQKT        
        if (status !== 2) {
            if (a.indexOf(status) >= 0) {
                return options.fn(this);
            }
        } else {
            return options.inverse(this);
        }
    } else {
        if (a.indexOf(status) >= 0) {
            return options.fn(this);
        }
    }    
});



