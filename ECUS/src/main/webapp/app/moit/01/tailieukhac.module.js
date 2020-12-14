/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var TLKController = function () { };
TLKController.prototype = {
    ministryCode: 'most',
    code: '01',
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
            if (this.list == null)
                this.list = [];
        }

        this.list.forEach(function (item) {
            item.IsView = obj.IsView;
        });

        this.loadTemplates();
        this.registerEvents();

        this.bindGrid();
    },
    loadTemplates: function () {
        if (this.templateName == null)
            return;
        app.getTemplate({
            ministryCode: this.ministryCode,
            code: this.code,
            templateName: this.templateName
        }, null);
    },
    registerEvents: function () {
        var self = this;
        var tmplContainer = $('#tlk-tmpl');

        $('#tlk-file-form').find('.tooltips').tooltip();

        $("#btnThemMoiTLK").on('click', function (e) {
            e.stopPropagation();
            e.preventDefault();
            var isOk = app.isFormVaild('tlk-file-form');
            if (!isOk)
                return;

            var fileInfo = app.form2Object('#tlk-file-form');
            var formObj = $('#tlk-file-form');
            var d = fileInfo.fiNgayCap.trim().toValidDate();
            var now = new Date().toDayFirstString().toValidDate();

            var fieldName = formObj.find('#txtNgayTLK').attr('field');
            if (Util.compareDate(d, now) === 1) {
                app.Alert(NSWLang[fieldName] + ' <b>' + NSWLang['common_msg_khonglonhon'] + '</b> ' + NSWLang['common_msg_ngayhientai']);
                return false;
            }

            fileInfo.fiIdDinhkem = 1 - (self.list.length + 1);
            fileInfo.fiTenLoai = $('#fiTenLoai').attr('value');

            fileInfo.fiMaLoaiTaiLieu = self.fileType;
            fileInfo.fiTenLoaiTaiLieu = NSWLang["most_01_filetypename_tailieukhac"];

            if (Util.validateAttachByDom('tailieukhac-ip')) {
                var file = $('#tailieukhac-ip')[0].files[0];
                fileInfo.fiFileSize = file.size;
                var cb = function (d) {
                    var data = d.data;
                    if (d.success) {
                        fileInfo.fiTenTep = file.name;
                        fileInfo.fiGuiId = data.fileCode;
                        fileInfo.fiDuongDan = data.filePath;
                        self.list.push(fileInfo);

                        self.bindGrid();
                        self.clearForm();
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
                    success: function (d) { cb(d); },
                    error: function (e) { console.log(e); }
                });
            }

            return false;
        });

        tmplContainer.find('.date-picker').datepicker({rtl: false, orientation: "left", autoclose: true});
        var cbfiMaLoaiTaiLieu = $('#fiMaLoai');
        cbfiMaLoaiTaiLieu.change(function () {
            $('#fiTenLoai').attr('value', $(this).find("option:selected").text());
        });

        tmplContainer.find('.select2').select2({width: 425});
        //document.getElementById('gcn-ip').addEventListener('change', self.uploadFile, false);
    },
    bindGrid: function () {
        var self = this;
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
            if (i > -1) {
                var fileInfo = self.list[i];
                self.list.splice(i, 1);
                totalSize = totalSize - fileInfo.fiFileSize;
                $('#fiTotalFileSize').attr('value', totalSize);                
                self.bindGrid();
            }
            return false;
        });
    },
    clearForm: function () {
        $('#txtNgayTLK').val('');
        $('#fiMaLoaiTaiLieuTLK').val('-1');
        $('#tlk-tmpl').find('.fileinput-filename').text('');
    },
    isVaild: function () {
        if (this.list == null || (this.list != null && this.list.length == 0)) {
            alert(NSWLang["common_msg_chuanhapthongtin"] + NSWLang["most_01_tailieukhac"]);
            return false;
        }
        return true;
    }
};



