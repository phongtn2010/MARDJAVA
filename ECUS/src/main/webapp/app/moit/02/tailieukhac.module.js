/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var TaiLieuKhacController = function () { };
TaiLieuKhacController.prototype = {
    ministryCode: 'most',
    code: '02',
    pagination: {
        isReady: false,
        currentPage: 1,
        pageSize: 1
    },
    fileType: 0,
    templateName: null,
    containerId: null,
    pagerId: null,
    list: [],
    currentFile: null,
    init: function (obj) {
        var op = $.extend(true, {}, obj);
        this.list = [];
        this.containerId = '#{0}'.format(op.containerId);
        //this.pagerId = '#{0}'.format(op.pagerId);        
        this.templateName = op.templateName;
        this.fileType = op.fileType;
        if (obj.hasOwnProperty('data')) {
            this.list = op.data;
            if (this.list === null)
                this.list = [];
        }

        this.list.forEach(function (item) {
            item.IsView = obj.IsView;
        });

        this.loadTemplates();
        this.registerEvents();

        this.bindGrid();
    },
     setData: function (obj) {
        var op = $.extend(true, {}, obj);
        if (obj.hasOwnProperty('data')) {
            this.list = op.data;
            if (this.list === null)
                this.list = [];
        }        
        this.bindGrid();
    },
    loadTemplates: function () {
        if (this.templateName === null)
            return;
        app.getTemplate({
            ministryCode: this.ministryCode,
            code: this.code,
            templateName: this.templateName
        }, null);
    },
    registerEvents: function () {
        var self = this;

        $('#tailieu-file-form').find('.tooltips').tooltip();
        $('#tailieu-file-form').find('#tailieu-ip').attr('accept',Util.extensions.join(', '));
        $("#btnFileTaiLieuThemMoi").on('click', function (e) {
            e.stopPropagation();
            e.preventDefault();
            if(self.list != null && self.list.length > 0){
                return;
            }
            var isOk = app.isFormVaild('tailieu-file-form');
            if (!isOk)
                return;

            var formObj = $('#tailieu-file-form');
            var fileInfo = app.form2Object('#tailieu-file-form');
            var d = fileInfo.fiNgayCap.trim().toValidDate();
            var now = new Date().toDayFirstString().toValidDate();

            var fieldName = formObj.find('#txtNgayTaiLieu').attr('field');
            if (Util.compareDate(d, now) === 1) {
                app.Alert(NSWLang[fieldName] + ' <b>' + NSWLang['common_msg_khonglonhon'] + '</b> ' + NSWLang['common_msg_ngayhientai']);
                return false;
            }

            fileInfo.fiIdDinhkem = 1 - (self.list.length + 1);
            fileInfo.fiMaLoai = self.fileType;
            fileInfo.fiTenLoai = fileInfo.fiMaLoai == 5 ? NSWLang["most_02_filetypename_talieukhac"] : NSWLang["most_02_filetypename_thuyetminh"];
//            fileInfo.fiMaLoaiTaiLieu = self.fileType;
            if (Util.validateFieExtensionByDom('tailieu-ip')) {
                var file = $('#tailieu-ip')[0].files[0];

                fileInfo.fiFileSize = file.size;

                var cb = function (d) {
                    var data = d.data;
                    if (d.success) {
                        if (data.filePath != null) {
                            fileInfo.fiTenTep = file.name;
                            fileInfo.fiMostId = data.filePath;
                            fileInfo.fiDuongDan = data.filePath;
                            self.list.push(fileInfo);
                            self.bindGrid();
                            self.clearForm();
                        } else {
                            app.Alert('Upload không thành công, vui lòng thử lại lần nữa!');
                        }
                    } else {
                        app.toast({
                            title: NSWLang["common_msg_thong_bao"],
                            message: data.message,
                            function: 'success'
                        });
                    }
                };

                app.uploadFile({
                    file: file,
                    mcode: self.ministryCode,
                    pcode: self.code,
                    success: function (d) {
                        cb(d);
                    },
                    error: function (e) {
                        console.log(e);
                    }
                });
            }

            return false;
        });

        $('#hopdong-tmpl').find('.date-picker').datepicker({rtl: false, orientation: "left", autoclose: true});

        //document.getElementById('tailieu-ip').addEventListener('change', self.uploadFile, false);
    },
    bindGrid: function () {
        var self = this;
        if (self.list != null && self.list.length > 0) {
            $('#btnFileTaiLieuThemMoi').parents('tfoot').hide();
        } else {
            $('#btnFileTaiLieuThemMoi').parents('tfoot').show();
        }
        var cb = function (html) {
            $(self.containerId).html(html);
            self.bindEventsGrid();
            $(self.containerId).find('.tooltips').tooltip();
        };
        app.complieTemplate({
            ministryCode: self.ministryCode,
            code: self.code,
            templateName: self.templateName,
            data: self.list
        }, cb);
    },
    bindEventsGrid: function () {
        var self = this;
        var con = $(self.containerId);
        con.find('.fa-remove').off('click').on('click', function (e) {
            e.preventDefault();
            var me = $(this);
            var id = me.attr('item');
            var i = self.list.Search('fiIdDinhkem', id);
            var totalSize = parseInt($('#fiTotalFileSize').attr('value'));
            var docCode = me.attr('code');
            if (i > -1) {
                var pop = app.popup({
                    title: NSWLang["common_msg_thong_bao"],
                    html: '<i class="fa fa-3x fa-warning"></i> ' + NSWLang["most_02_talieukhac_msg_xoa"] + ' <b>' + docCode + '</b>',
                    width: 400,
                    buttons: [
                        {
                            name: NSWLang["common_button_toi_chac_chan"],
                            class: 'btn',
                            icon: 'fa-check',
                            action: function () {
                                var msg = '';
                                var fun = 'success';

                                msg = NSWLang["common_msg_cap_nhat_du_lieu_thanh_cong"];
                                app.popupRemove(pop.selector);
                                var fileInfo = self.list[i];

                                self.list.splice(i, 1);
                                totalSize = totalSize - fileInfo.fiFileSize;
                                $('#fiTotalFileSize').attr('value', totalSize);
                                self.bindGrid();
                                app.toast({
                                    title: NSWLang["common_msg_thong_bao"],
                                    message: msg,
                                    function: fun
                                });
                            }
                        }
                    ]
                });
            }
            return false;
        });
    },
    clearForm: function () {
        $('#txtLoaiTaiLieu').val('').focus();
        $('#txtNgayTaiLieu').val('');
        $('#tailieu-tmpl').find('.fileinput-filename').text('');
        document.getElementById("tailieu-ip").value = "";
    },
    isVaild: function () {
        if (this.list == null || (this.list != null && this.list.length == 0)) {
            alert(NSWLang["common_msg_chuanhapthongtin"] + NSWLang["most_02_talieukhac"]);
            return false;
        }
        return true;
    }
};


