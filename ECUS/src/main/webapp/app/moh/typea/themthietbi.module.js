/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

addEquipController = function () {};
addEquipController.prototype = {
    ministryCode: 'moh',
    code: 'typea',
    list: [],
    templates: ['listBaohanh'],
    baohanh: [],
    baohanhClone: [],
    dialog: null,
    uploadInfor: null,
    init: function (obj) {
        var op = $.extend(true, {}, obj);
        this.registerEvents();
        this.dialog = op.data.dialog;

        $(".select2").select2({placeholder: '', width: null, selectOnClose: true});
        $('.date-picker').datepicker({rtl: false, orientation: "left", autoclose: true});
        this.list = op.data.data != null ? [op.data.data] : [];
        var self = this;
        if (obj.data.baoHanh != null) {
            var bh = [];
            obj.data.baoHanh.forEach(function (item) {
                bh.push(item);
                self.createClone(item, false);
            });
            this.baohanh = bh;
        } else {
            this.baohanh = [];
        }
        
    },
    registerEvents: function () {
        var self = this;
       
        $('.chon-phuluc').on('change', function (e) {
            var isDonle = ($("#fiPhannhom").val() == "0" || $("#fiPhannhom").val() == "-1");
            var isNhieucssx = ($("#fiNhieucssx").val() == 1);
            if (!isDonle) {
                $("#fiNhieucssx").select2('enable', false);
                $("#fiNhieucssx").attr("disable", true);
            } else {
                $("#fiNhieucssx").select2('enable');
                $("#fiNhieucssx").attr("disable", false);
                $("#fiNhieucssx").removeAttr("disable");
            }
            if (!isDonle || isNhieucssx) {
                var input = $(".phuluc");
                input.attr("readonly", "true");
                $(".phuluc").not(".chon-phuluc").val(NSWLang["moh_06_themthietbi_theophuluc"]);
                $("#fiMaqgsx").val(-1);        
                $("#fiMaqgsx").change();
                $("#fiMaqgsx").select2('enable', false);
                $("#fiMaqgsx").attr("disable", true);
                $(".condition").show();
            } else {
                var input = $(".phuluc");
                $(input).not(".chon-phuluc").val("");
                input.removeAttr("readonly");
                $("#fiMaqgsx").select2('enable');
                $("#fiMaqgsx").attr("disable", false);
                $(".condition").hide();
            }
        });
        $('#fiNhomtb').on('change', function (e) {
            var nhomtb = $("#fiNhomtb").val();
            if (nhomtb == 0) {
                $("#baohanhlist").hide();
            } else {
                $("#baohanhlist").show();
            }
        });
        $("#addEquip").off().on("click", function (e) {
            if (self.isValidThietBi()) {
                var thietbi = app.form2Object("#form-draftTB");
                thietbi.fiNhieucssx = $("#fiNhieucssx").val();
                thietbi.fiQuocgiacsh = $("#fiMaqgsch :selected").html();
                thietbi.fiQgsx = $("#fiMaqgsx :selected").html();
                if(thietbi.fiPhannhom !== "0"){
                    thietbi.fiNhieucssx = -1;
                }
                if(thietbi.fiNhieucssx !== "0" || thietbi.fiPhannhom !== "0"){//neu phan nhom != don le, c� nhieu co so sx
                    thietbi.fiLoai = NSWLang["moh_06_themthietbi_theophuluc"];
                    thietbi.fiQuycach = NSWLang["moh_06_themthietbi_theophuluc"];
                    thietbi.fiHangsx = NSWLang["moh_06_themthietbi_theophuluc"];
                    thietbi.fiDiachisx = NSWLang["moh_06_themthietbi_theophuluc"];
                    thietbi.fiQgsx = NSWLang["moh_06_themthietbi_theophuluc"];
                    thietbi.fiMaqgsx = '-1';
                }
                thietbi.phuluc = self.uploadInfor;
                self.list.push(thietbi);
                if(thietbi.fiPhannhom = 0 && thietbi.fiNhomtb ==0 ){
                    self.baohanh = [];
                    self.baohanhClone = [];
                }         
                $(".vanban #list-container").append("<tr id='tb1'></tr>");
                $(".vanban #list-container #tb1").append("<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>")
                var newTB = $(".vanban #list-container #tb1").find("td");
                var phannhomString = $("#fiPhannhom option[value='" + thietbi.fiPhannhom + "']");
                newTB.eq(0).html("1");
                newTB.eq(1).html(thietbi.fiTen);
                newTB.eq(2).html(phannhomString);
                newTB.eq(3).html(thietbi.fiLoai);
                newTB.eq(4).html(thietbi.fiHangsx);
                newTB.eq(5).html(thietbi.fiDiachisx);
                newTB.eq(6).html(thietbi.fiTieuchuan);
                newTB.eq(7).html("<a><i class='fa fa-remove fa-lg " + $(".vanban #list-container tr").length + "'></i></a>");
                $(".modal-header button").click();
                //console.log(thietbi);
            }
        });
        $("#save").off().on("click", function (e) {
            e.preventDefault();
            e.stopPropagation();
            var newBaohanh = self.saveBaoHanh();
            newBaohanh.fiBaohanhId=0;
            if(newBaohanh != null && newBaohanh !=undefined){
                if(!!$("#bhForm").attr("dat")){
                    self.baohanh[$("#bhForm").attr("dat")] = newBaohanh;
                    $("#bhForm").removeAttr("dat");
                }else{
                    self.baohanh.push(newBaohanh);
                }
            }
             $("#bhForm input").removeAttr("readonly");
            self.bindGrid();
        });
        $("#cancelWarr").off().on('click', function (e) {
            e.preventDefault();
            e.stopPropagation();
            $("#bhForm input").val("");
        });
        $("#huyTB").off('click').on('click', function (e) {
            e.preventDefault();
            e.stopPropagation();
            self.baohanh = [];
            self.uploadInfor = null;
            $("#fileIdLabelframe2").html("");
            $(".modal-header .close").click();
        });
        $("#buttonPL").off('click').on('click', function () {//upload ph? l?c
            var loaiTapTin = "12";
            var tenTapTin = NSWLang["moh_typea_phu_luc"];
            var frameId = "frame2";
            var upload = {frameId: frameId, maTaiLieu: loaiTapTin, tenTaiLieu: tenTapTin};
            app.makePost({
                url: "/moh/01/key",
                data: JSON.stringify(upload),
                success: function (data) {
                },
                error: function (data) {
                    if (data != null && data.length > 0) {
                        value = data;
                        var url = self.dialog;
                        $("#frame1").attr("src", url + encodeURIComponent(value) + "?t=" + (new Date()).getTime());
                        $("#dialog").dialog({modal: true, width: 640, height: 300, dialogClass: 'plDiaglog'});
                    }
                }
            });
            self.uploadInfor = upload;
        });
    },
    isValidThietBi: function () {
        if (!$('#fiTentrangtb').val()) {
            app.AlertWithBtn(NSWLang['moh_typea_tenthietbi'] + ' ' + NSWLang["common_msg_chua_nhap"]);
            $('#fiTentrangtb').focus();
            return false;
        }
        if (!$('#fiChusohuu').val()) {
            app.AlertWithBtn(NSWLang['moh_typea_chusohuu'] + ' ' + NSWLang["common_msg_chua_nhap"]);
            $('#fiChusohuu').focus();
            return false;
        }
        if (!$('#fiDiachicsh').val()) {
            app.AlertWithBtn(NSWLang['moh_typea_dc_chu_so_huu'] + ' ' + NSWLang["common_msg_chua_nhap"]);
            $('#fiDiachicsh').focus();
            return false;
        }
        if ($('#fiMaqgsch').val() == "-1") {
            app.AlertWithBtn(NSWLang['moh_typea_qg_chu_so_huu'] + ' ' + NSWLang["common_msg_chua_nhap"]);
            $('#fiMaqgsch').focus();
            return false;
        }
        if (!$('#fiTieuchuan').val()) {
            app.WithBtn(NSWLang['moh_typea_thietbi_tieuchuanapdung'] + ' ' + NSWLang["common_msg_chua_nhap"]);
            $('#fiTieuchuan').focus();
            return false;
        }
        if ($('#fiPhannhom').val() == "-1") {
            app.AlertWithBtn(NSWLang['moh_typea_phan_nhom'] + ' ' + NSWLang["common_msg_chua_nhap"]);
            $('#fiPhannhom').focus();
            return false;
        }   
        if ($('#fiNhomtb').val() == "-1") {
            app.AlertWithBtn(NSWLang['moh_typea_nhomtb'] + ' ' + NSWLang["common_msg_chua_nhap"]);
            $('#fiNhomtb').focus();
            return false;
        }
        if ($("#fiPhannhom").val() == "0" && $("#fiNhieucssx").val() == "0") {
             if ($('#fiNhieucssx').val() == "-1") {
                app.AlertWithBtn(NSWLang['moh_typea_nhieu_cssx'] + ' ' + NSWLang["common_msg_chua_nhap"]);
                $('#fiNhieucssx').focus();
                return false;
            }
            if ($('#fiLoaihang').val() != null && $('#fiLoaihang').val().length==0) {
                app.AlertWithBtn(NSWLang['moh_typea_thietbi_ma_san_pham'] + ' ' + NSWLang["common_msg_chua_nhap"]);
                $('#fiLoaihang').focus();
                return false;
            }
           
            if (!$('#fiTen').val()) {
                app.AlertWithBtn(NSWLang['moh_typea_tenthietbi'] + ' ' + NSWLang["common_msg_chua_nhap"]);
                $('#fiTen').focus();
                return false;
            }
            
            if (!$('#fiHangsx').val()) {
                app.AlertWithBtn(NSWLang['moh_typea_hangsx'] + ' ' + NSWLang["common_msg_chua_nhap"]);
                $('#fiHangsx').focus();
                return false;
            }
            
            if (!$('#fiDiachisx').val()) {
                app.AlertWithBtn(NSWLang['moh_typea_dia_chi_sx'] + ' ' + NSWLang["common_msg_chua_nhap"]);
                $('#fiDiachisx').focus();
                return false;
            }
            
            if ($('#fiMaqgsx').val() == "-1" || !!!$('#fiMaqgsx').val()) {
                app.AlertWithBtn(NSWLang['moh_typea_nuoc_sx'] + ' ' + NSWLang["common_msg_chua_nhap"]);
                $('#fiMaqgsx').focus();
                return false;
            }
            } else {
                if (this.uploadInfor == null) {
                    app.AlertWithBtn(NSWLang['moh_typea_phu_luc'] + ' ' + NSWLang["common_msg_chua_nhap"]);
                    return false;
                }
            }
        
        //ckeck if bao hanh is compulsory
        if ($('#fiNhomtb').val() != "0") {
            if (this.baohanh.length == 0) {
                app.AlertWithBtn(NSWLang['moh_typea_co_so_bao_hanh'] + ' ' + NSWLang["common_msg_chua_nhap"]);
                $('#fiTencoso').focus();
                return false;
            }
        }
        return true;
    },
    isValidBaoHanh: function () {        
        return  app.isFormVaild('form-bh');
    },
    changeDropdown: function () {
        var formContainer = $('#form-draftTB');
        var fiMaqgsch = formContainer.find("#fiMaqgsch");
        var phanNhom = formContainer.find("#fiPhannhom");
        var nhomtb = formContainer.find("#fiNhomtb");
        var nhieucssc = formContainer.find("#fiNhieucssx");
        var QgSx = formContainer.find("#fiMaqgsx");

        fiMaqgsch.val(fiMaqgsch.attr('data')).select2({placeholder: '', width: '100%', selectOnClose: true});
        phanNhom.val(phanNhom.attr('data')).select2({placeholder: '', width: '100%', selectOnClose: true});
        nhomtb.val(nhomtb.attr('data')).select2({placeholder: '', width: '100%', selectOnClose: true});
        nhieucssc.val(nhieucssc.attr('data')).select2({placeholder: '', width: '100%', selectOnClose: true});
        QgSx.val(QgSx.attr('data')).select2({placeholder: '', width: '100%', selectOnClose: true});

        fiMaqgsch.change(function () {
            $('#fiMaqgsch').attr('value', $(this).find("option:selected").text());
        });
        phanNhom.change(function () {
            $('#fiPhannhom').attr('value', $(this).find("option:selected").text());
        });
        nhomtb.change(function () {
            $('#fiNhomtb').attr('value', $(this).find("option:selected").text());
        });
        nhieucssc.change(function () {
            $('#fiNhieucssx').attr('value', $(this).find("option:selected").text());
        });
        QgSx.change(function () {
            $('#fiMaqgsx').attr('value', $(this).find("option:selected").text());
        });
    },
    bindGridEvent: function () {
        var self = this;
        $('.listWarranty .fa-close').off('click').on('click', function () {
            var index = $(this).parents('tr').attr('id');
            var me = $(this);
            var pop = app.popup({
                title: NSWLang["common_button_thong_bao"],
                html: '<b>' + NSWLang["common_msg_xoa_ho_so"] + '</b>',
                width: 400,
                height: 100,
                buttons: [
                    {
                        name: NSWLang["common_button_toi_chac_chan"],
                        class: 'btn',
                        icon: 'fa-check',
                        action: function () {
                            me.parents("tr").remove();
                            self.baohanh.splice((index), 1);
                            self.baohanhClone.splice((index), 1);                            
                            app.popupRemove(pop.selector);
                            self.bindGrid();
                        }
                    }
                ]
            });
        });
        $(".fa-pencil").off("click").on("click", function(e){
            e.preventDefault();
            e.stopPropagation();
            var index = parseInt($(this).parents("tr").attr('id'));
            $(this).parents("tr").remove();
            $("#fiMstCsbh").val(self.baohanh[index].fiMstCsbh);
            $("#fiTencoso").val(self.baohanh[index].fiTencoso);
            $("#fiDiachics").val(self.baohanh[index].fiDiachics);
            $("#fiDienthoai").val(self.baohanh[index].fiDienthoai);
            $("#fiDidong").val(self.baohanh[index].fiDidong);
            $("#bhForm").attr("dat",index);
            $("#fiDidong").focus();
        });
        $('#fiMstCsbh').off('focusout').on('focusout', function () {
            var data = $(this).val();
            if (!!data) {
                app.makePost({
                    url: "/moh/01/findbaohanh",
                    data: JSON.stringify({mst: data}),
                    success: function (d) {
                        if (d.data != null && d.data.length > 0) {
                            self.view(d.data);
                        }
                    }
                });
            }
        });
    },
    saveBaoHanh: function () {
        var self = this;
        if (self.isValidBaoHanh()) {
            var baohanh = app.form2Object("#form-bh");
            self.createClone(baohanh, true);
        }
        return baohanh;
    },
    bindGrid: function(){
        $('.listWarranty').html("");
        for(var i = 0; i < this.baohanhClone.length; i++){
            var row = $(document.createElement("tr"));
            row.attr('id',i);
            row.append("<td>" +(i+1)+ "</td>");
            row.append("<td>" + this.baohanhClone[i].fiMstCsbh + "</td>");
            row.append("<td>" + this.baohanhClone[i].fiTencoso + "</td>");
            row.append("<td>" + this.baohanhClone[i].fiDiachics + "</td>");
            row.append("<td>" + this.baohanhClone[i].fiDienthoai + "</td>");
            row.append("<td>" + this.baohanhClone[i].fiDidong + "</td>");
            var actions = "<td><a><i class='fa fa-pencil fa-lg'></i></a>&nbsp;&nbsp;<a><i class='fa fa-close fa-lg'></i></a></td>"
            if(!this.baohanhClone[i].canEdit){
                actions = "<td><a><i class='fa fa-close fa-lg'></i></a></td>"
            }
            row.append(actions);
            $(".listWarranty").append(row);
        }  
        $("#bhForm input").val("");
        this.bindGridEvent();
    },
    isVaild: function () {
        if (this.list === null || (this.list !== null && this.list.length === 0)) {
            app.AlertWithBtn(NSWLang["common_msg_chuanhapthongtin"] + NSWLang["moh_typea_trangthietbi"]);
            return false;
        }
        return true;
    },
    view: function (data) {
        var self = this;
        app.complieTemplate({
            ministryCode: self.ministryCode,
            code: self.code,
            templateName: self.templates[0],
            data: data
        }, callback);
        function callback(html) {
            var pop = app.popup({
                title: NSWLang["common_button_thong_bao"],
                html: html,
                width: 800,
                height: 400,
                buttons: [
                    {
                        name: NSWLang["moh_typea_cosobaohanh_chon"],
                        class: 'btn',
                        icon: 'fa-check',
                        action: function () {
                            onload();
                            app.popupRemove(pop.selector);
                        }
                    },
                    {
                        name: NSWLang["moh_typea_cosobaohanh_nhaptay"],
                        class: 'btn',
                        icon: 'fa-close',
                        action: function () {
                            app.popupRemove(pop.selector);
                        }
                    }
                ]
            });
        }
        var onload = function () {
            var input = $("#load-baohanh").find('input:checked');
            var i = 1;
            $(input).each(function (index, value) {
                i++;
                var obj = {};
                var cells = $("#load-baohanh #" + $(value).val()).find("td");
                $(cells).each(function (key, val) {
                    if (!!$(val).attr('class')) {
                        obj[$(val).attr('class')] = $(val).html().trim();
                    }
                });
                self.baohanh.push(obj);
                self.createClone(obj, false);
            });
            self.bindGrid();
        }
    },
    createClone: function (item, canEdit) {
        var clone = $.extend(true, {}, item);
        clone.canEdit = canEdit;
        this.baohanhClone.push(clone);
    }
};
