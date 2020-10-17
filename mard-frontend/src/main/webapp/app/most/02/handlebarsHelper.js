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
        out = out + files[i].fiSoVb + ", " + NSWLang["common_ngay"] + ": " + Handlebars.helpers.convertToDateFromTimeStamp.apply(this, [files[i].fiNgayCap]) + "; ";
    }

    return out;
});

Handlebars.registerHelper('showDelayCommand', function (trangthai, options) {
    if (trangthai == 4) {
        return options.fn(this);
    }
});


Handlebars.registerHelper('canDelete', function (trangthai, options) {
    if (trangthai === 0) {
        return options.fn(this);
    } 
});

Handlebars.registerHelper('canCancel', function (trangthai, options) {
    if (trangthai != 7 && trangthai != 3 && trangthai != 0) {
        return options.fn(this);
    } 
});

Handlebars.registerHelper('canEdit', function (trangthai, options) {
    if (trangthai != 7 && trangthai != 3) {
        return options.fn(this);
    } 
});


Handlebars.registerHelper('showTestAnnounce', function (trangthai, options) {
    if (trangthai === 6 || trangthai == 7) {
        return options.fn(this);
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


Handlebars.registerHelper('getCommandName', function (cmd) {
    return NSWLang[cmd];
});

Handlebars.registerHelper('viewResult', function (trangthai, options) {
    if (trangthai == 7) {
        return options.fn(this);
    }
});

Handlebars.registerHelper("showResult", function (v) {
    return v==1?NSWLang["common_dat"]:NSWLang["common_khongdat"];
});

Handlebars.registerHelper('countProduct', function (fiIdDinhkem) {
    var out = '0';
    var products = window.detailDocument.hangHoa.List;
    if (products === null || (typeof (products) === 'undefined') || (products !== null && products.length === 0))
        return out;    
    var files = products.getArray('fiIdDinhkem', fiIdDinhkem);
    return files.length;
});

Handlebars.registerHelper("showToKhai", function (tk) {
    var out = "";
     if (tk === null || (typeof (tk) === 'undefined') || (tk !== null && tk.length === 0))
        return out;
     for (var i = 0, l = tk.length; i < l; i++) {
        out = out + tk[i].fiSoTk + ", " + NSWLang["common_tokhai_ngaydangky"] + ": " + Handlebars.helpers.convertToDateFromTimeStamp.apply(this, [tk[i].fiNgayDk]) + ";";
    }
    return out;
});

Handlebars.registerHelper('showPlaceHolder', function () {
    return "placeholder ='mahs'"
});

Handlebars.registerHelper('buildDownloadUrlForNewFile', function (hosoID, fileId) {
    return context + '/most/02/fileDinhKem/' + hosoID + '/' + fileId;
});

Handlebars.registerHelper('buildDownloadUrlForHistoryFile', function (hosoID, fileId) {
    return context + '/most/02/dinhkemLS/' + hosoID + '/' + fileId;
});

Handlebars.registerHelper("showViewTokhai", function (v) {
    if (v === "none")
        return "fa-search";
    else
        return 'fa-edit';
});

Handlebars.registerHelper("getfilename", function (fileName, fileCode) {
    if (!!fileName)
        return fileName;
    else
        return fileCode;
});

Handlebars.registerHelper("showLoaiDoiTuong", function (loai) {
    if (loai == 1)
        return NSWLang["most_02_hanghoa_loaidoituong_pt_do"];
    else if(loai == 2)
        return NSWLang["most_02_hanghoa_loaidoituong_hangdonggoi"];
});

Handlebars.registerHelper("toFormalDate", function (d) {
    date = new Date(d);
    var result = "Ngày "+date.getDate()+" tháng "+(date.getMonth()+1)+" năm "+date.getFullYear();
    return result;
});

Handlebars.registerHelper('buildDownloadFileUrl', function (guid) {
    return app.appContext + "/file/download/" + guid;
});