/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function GCNController() {};

GCNController.prototype = {
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
    gcnHanghoaPopup: null,
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
        this.gcnHanghoaPopup = new GiayChungNhanHangHoa();
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
        var tmplContainer = $('#gcn-tmpl');
        $('#gcn-file-form').find('.tooltips').tooltip();

        $("#btnThemMoiGCN").on('click', function (e) {
            e.stopPropagation();
            e.preventDefault();
            var isOk = app.isFormVaild('gcn-file-form');
            if (!isOk)
                return;

            var fileInfo = app.form2Object('#gcn-file-form');
            var formObj = $('#gcn-file-form');
            var d = fileInfo.fiNgayCap.trim().toValidDate();
            var now = new Date().toDayFirstString().toValidDate();

            var fieldName = formObj.find('#txtNgayGCN').attr('field');
            if (Util.compareDate(d, now) === 1) {
                app.Alert(NSWLang[fieldName] + ' <b>' + NSWLang['common_msg_khonglonhon'] + '</b> ' + NSWLang['common_msg_ngayhientai']);
                return false;
            }
            
            var file = $('#gcn-ip')[0].files[0];
                fileInfo.fiFileSize = file.size;
                fileInfo.fiTenTep = file.name;
            fileInfo.fiIdDinhkem = 1 - (self.list.length + 2);
            fileInfo.fiTenLoai = $('#fiTenLoai').attr('value');

            fileInfo.fiMaLoaiTaiLieu = self.fileType;
            fileInfo.fiTenLoaiTaiLieu = NSWLang["most_01_filetypename_giaychungnhan"];

            if (Util.validateAttachByDom('gcn-ip')) {
                
                var cb = function (d) {
                    var data = d.data;
                    if (d.success) {
						if(data.filePath != null) {
							self.gcnHanghoaPopup.updateHangHoaList(fileInfo.fiIdDinhkem);
												   
							fileInfo.fiGuiId = data.filePath;
							self.list.push(fileInfo);
							
							self.bindGrid();
							self.clearForm();
							
							self.gcnHanghoaPopup.resetData();
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
                        //console.log(e);
                    }
                });
            }

            return false;
        });

        tmplContainer.find('.date-picker').datepicker({rtl: false, orientation: "left", autoclose: true});
        var cbfiMaLoaiTaiLieuGCN = $('#fiMaLoaiTaiLieuGCN');
        cbfiMaLoaiTaiLieuGCN.change(function () {
            $('#fiTenLoai').attr('value', $(this).find("option:selected").text());
        });

        tmplContainer.find('.select2').select2({width: 150});
        //document.getElementById('gcn-ip').addEventListener('change', self.uploadFile, false);

        $("#btnAddHangHoa").on('click', function (e) {
            e.stopPropagation();
            e.preventDefault();
            var me = $(this);
            var data = me.attr('data');
            self.gcnHanghoaPopup.addPopup(data);
            return false;
        });
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
            var docCode = me.attr('code');
            if (i > -1) {
                var pop = app.popup({
                    title: NSWLang["common_msg_thong_bao"],
                    html: '<i class="fa fa-3x fa-warning"></i> ' + NSWLang["most_common_msg_xoagiaychungnhan"] + ' <b>' + docCode + '</b>',
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
                                self.gcnHanghoaPopup.removeHangHoa(id);
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

        con.find(".btn-badge-hh").off('click').on('click', function (e) {
            e.stopPropagation();
            e.preventDefault();
            var me = $(this);
            var data = me.attr('data');
            self.gcnHanghoaPopup.addPopup(data);
            return false;
        });
    },
    clearForm: function () {
        $('#txtSoGCN').val('').focus();
        $('#txtNgayGCN').val('');
        $('#txtDonViCapGCN').val('');
        $('#fiMaLoaiTaiLieuGCN').val('-1');
        $('#gcn-file-form').find('.fileinput-filename').text('');
        $('#select2-fiMaLoaiTaiLieuGCN-container').text('');
    },
    isVaild: function () {
        if (this.list === null || (this.list !== null && this.list.length === 0)) {
            alert(NSWLang["common_msg_chuanhapthongtin"] + NSWLang["most_01_gcn"]);
            return false;
        }
        return true;
    }
};


