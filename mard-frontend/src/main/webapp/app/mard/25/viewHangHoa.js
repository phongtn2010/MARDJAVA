function Mard25ViewHangHoaVM (options) {
    var self=this;
    self.fiMaCqkt = ko.observable(null);
    self.fiHSCode = ko.observable(null);
    self.fiTrangThaiHangHoa = ko.observable(null);
    self.errorMsg  = ko.observable('');
    self.lstFilePT  = ko.observableArray();
    self.lstFileGCN  = ko.observableArray();
	self.lstCountry  = ko.observableArray((options && options.hasOwnProperty('lstCountry')) ? options.lstCountry :[]);
	self.sortBy = ko.observable("fiCreatedDate");
    self.order = ko.observable("desc");
    self.mard25HangHoaItems  = ko.observableArray((options && options.hasOwnProperty('mard25HangHoaItems')) ? options.mard25HangHoaItems :[]);
    self.lstProfileStatus  = ko.observableArray((options && options.hasOwnProperty('lstProfileStatus')) ? options.lstProfileStatus :[]);
    self.lstTrangThaiHangHoa =ko.observableArray([]);
    if(self.lstProfileStatus().length>0){
        ko.utils.arrayForEach(self.lstProfileStatus(),function (statusEntity) {
            if(statusEntity.fiCatType>=26){
                self.lstTrangThaiHangHoa.push(statusEntity);
            }
        });
    }
    self.lstToChucDanhGia  = ko.observableArray((options && options.hasOwnProperty('lstToChucDanhGia')) ? options.lstToChucDanhGia :[]);
    self.lstKetQuaPhanTich  = ko.observableArray((options && options.hasOwnProperty('lstKetQuaPhanTich')) ? options.lstKetQuaPhanTich :[]);
    self.lstNhom  = ko.observableArray((options && options.hasOwnProperty('lstNhom')) ? options.lstNhom :[]);
    var MAX_PAGE_SIZE = 10;
    self.size = ko.observable(MAX_PAGE_SIZE);
    self.fiNSWFileCode = ko.observable(null);
    self.fiHSType = ko.observable(null);
    self.fiHSTypeName = ko.observable((options && options.hasOwnProperty('fiHSTypeName')) ? options.fiHSTypeName : null);
    self.fiProName = ko.observable(null);
    self.fiLoaiDanhGia = ko.observable(null);
    self.fiToChucDanhGia = ko.observable(null);
    self.fiSoGCNHopQuy = ko.observable('');
    self.fiNgayCap = ko.observable(null);

    self.fiFileGCN = ko.observable(null);
    self.fiFileGCNId = ko.observable(null);
    self.fiFileGCNName = ko.observable(null);
    self.fiFileGCNLink = ko.observable(null);
    self.fiFileKQ = ko.observable(null);
    self.fiHS = ko.observable((options && options.hasOwnProperty('fiHS')) ? options.fiHS : null);
    self.isEditable = ko.observable(true);
    self.fiNameTCCD = ko.observable(null);

    self.getProfileStatus = function (statuscode) {
        var lstProfileStatus = self.lstProfileStatus();
        var pos = lstProfileStatus.find(function (e) {
            return e.fiCatType == Number(statuscode);
        })
        if (pos)
            return pos.fiCatTypeName;
        else return statuscode;
    }
    self.changeHoSoType =function(hsType){
        // if(hsType!=4){
        //     $("#model-congvan").hide();
        // }else {
        //     $("#model-congvan").show();
        // }
        // console.log(ttcVMSelf.fiHSType());
    }
    self.currentPage = ko.observable(1);
    self.pagination = ko.observable(new PagingVM({
        pageSize: MAX_PAGE_SIZE,
        totalCount: 0,
        currentPage: 1
    }));
    self.pagination().currentPage.subscribe(function (newCurrentPage) {
        self.currentPage(newCurrentPage);
        self.searchProduct(newCurrentPage);
    })
    self.searchProduct = function () {
        self.getHangHoa(1);
    }
    self.getHangHoa = function (page) {
        var filter = {
            fiProName: self.fiProName(),
            fiTrangThaiHangHoa: self.fiTrangThaiHangHoa(),
            fiIdHS: idHoSo,
            page: page,
            size: self.size(),
            sortBy: self.sortBy(),
            order: self.order()
        }
        $.ajax({
            async: true,
            type: 'POST',
            cache: false,
            crossDomain: true,
            url: app.appContext + "/mard/25/hanghoa/timkiem",
            data: JSON.stringify(filter),
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            beforeSend: function (xhr) {
                xhr.setRequestHeader(CSRF_TOKEN_NAME, CSRF_TOKEN_VALUE);
                $('#loading08').show();
            },
            success: function (res) {
                if (res.success) {
                    var list = res.data ? res.data.data : [];
                    self.mard25HangHoaItems(list);
                    self.pagination().update({
                        totalCount: res.data.total,
                        pageSize: MAX_PAGE_SIZE,
                        currentPage: page
                    })
                }
            },
            error: function (err) {
            },
            complete: function (jqXHR, textStatus) {
                $('#loading08').hide();
                window.stateChanging = false;
            }
        });
    }
    self.hangHoaSelected = ko.observable(null);
    self.backBtn = function(){
        window.location.href=app.appContext+"/mard/25/home";
    }
    self.removeFile = function(data,index){
        self.lstKetQuaPhanTich.splice(index,1);
    }
    self.fiHSType(self.fiHS().fiHSType);

    self.getTenNhom = function (idNhom) {
        var pos = self.lstNhom().find(function (e) {
            return e.fiidcat == Number(idNhom);
        })
        if (pos)
            return pos.fiCatTypeName;
        else
            return idNhom;
    }
    self.addFileKQ = function(){
        var file=$("#fiFileKQ")[0].files[0];
        var fiFileName=self.fiFileKQ().replace(/^.*[\\\/]/, '');
        app.uploadFile({
            file: file,
            mcode: 'mard',
            pcode: '25',
            url: '/mard/25/upload',
            success: function (d) {
                if(d.success){
                    console.log(d);
                    var item={
                        fiFileName:fiFileName,
                        fiFileLink:d.data.urlFile,
                        fiFileId:d.data.itemId,
                        fiIDHangHoa:self.hangHoaSelected().fiIdProduct,
                        fiLoaiFile:'1',
                        fiTenLoai:'Phiếu kết quả phân tích',
                        fiTenFile:fiFileName
                    };
                    self.lstKetQuaPhanTich.push(item);
                    self.fiFileKQ(null);
                    self.errorMsg(null);
                }else{
                    self.errorMsg('Có lỗi tải file lên');
                    self.fiFileKQ(null);
                    console.log(d);
                }
            },
            error: function (e) {
                self.fiFileKQ(null);
                console.log(e);
                self.errorMsg('Có lỗi tải file lên'+e);
            }
        });
    }
    self.xemKQDGSPH = function(data,type,index){
        self.getFileGCN(index.fiIdProduct,function (res) {
            self.lstFileGCN(res.data);
            self.fiMaCqkt(self.lstFileGCN.fiMaCqkt);
            self.fiLoaiDanhGia(self.lstFileGCN.fiLoaiDanhgia);
        });
        self.getFileKQPT(index.fiIdProduct,function (res) {
            self.lstFilePT(res.data);
        });
        self.fiProName(index.fiProName);
        $("#modal_view").show();
    }
    self.downloadFile =function(data,type,index){
        if(index.fiLinkGcn){
            window.open(index.fiLinkGcn);
        }else{
            window.open(index.fiFileLink);
        }

    }
    self.thongBaoKQVM = ko.observable(new ThongBaoKQVM());
    self.xemThongBao = function(data,type,index){
        self.thongBaoKQVM().update(index);
        $("#mard25KQKT").show();
    }

    self.lichsuXuly = ko.observable(new HistoryPopupView());
    self.showLSHH = function (item) {
        self.lichsuXuly().getLSHH(item.fiIdProduct);
        return false;
    }
    self.fileKQChange = function(data, e){
        var files = e.target.files;
        app.uploadFile({
            file: files[0],
            mcode: 'mard',
            pcode: '25',
            url: '/mard/25/upload',
            success: function (d) {
                if(d.success){
                    console.log(d);
                    self.fiFileGCNLink(d.data.urlFile);
                    self.fiFileGCNId(d.data.itemId);
                    self.fiFileGCNName(files[0].name);
                    self.errorMsg(null);
                }else{
                    self.errorMsg('Có lỗi tải file lên: '+d.message);
                }
                $('#loading08').hide();
                // self.fiFileGCN(null);

            },
            error: function (e) {
                self.errorMsg('Có lỗi tải file lên: '+e);
                $('#loading08').hide();
                self.fiFileGCN(null);
            }
        });
    }
    self.guiSuaHangHoa = function(data,type,index){
        self.fiProName(index.fiProName);
        self.hangHoaSelected(index);
        self.fiNSWFileCode(self.fiHS().fiNSWFileCode);
        self.clearForm();
        $("#modal_guiSua").modal("show");
    }

    self.guiKiemDinhHangHoa =function(){
        // if(!self.validateForm()){
        //     return;
        // }
        var jsonData=self.getBodyGuiKQ();
        self.pop = app.popup({
            title: 'Thông báo',
            html: '<b>Bạn chắc chắn muốn gửi?</b>',
            width: 450,
            buttons: [
                {
                    name: NSWLang["common_button_toi_chac_chan"],
                    class: 'btn',
                    icon: 'fa-save',
                    action: function () {
                        app.popupRemove(self.pop.selector);
                        app.makePost({
                            url: '/mard/25/hoso/guikqxl',
                            data: jsonData,
                            contentType: "application/json; charset=utf-8",
                            success: function (d) {
                                if (d && d.success) {
                                    app.Alert('Gửi yêu cầu thành công');
                                    self.searchProduct();
                                    $('#modal_guiSua').modal('hide');
                                } else {
                                    app.Alert(d.message);
                                }
                            },
                            error: function (e) {
                                app.Alert('Không gửi được yêu cầu');
                            }
                        });
                    }
                },
                {
                    name: 'Huỷ',
                    class: 'btn',
                    icon: 'fa-close',
                    action: function () {
                        app.popupRemove(self.pop.selector);
                    }
                }
            ]
        });
    }
    self.getBodyGuiKQ = function(){
        var item = {
            fiNSWFileCode:self.fiNSWFileCode(),
            fiDVXLCode:self.fiToChucDanhGia(),
            fiDVXLName:self.fiNameTCCD(),
            fiProId:self.hangHoaSelected().fiIdProduct,
            fiProName:self.fiProName(),
            fiLoaiKQDG:self.fiLoaiDanhGia(),
            fiSoGCN:self.fiSoGCNHopQuy(),
            fiNgayDG:self.fiNgayCap(),
            fiIDFileGCN:self.fiFileGCNId(),
            fiLinkGCN:self.fiFileGCNLink(),
            fiNameGCN:self.fiFileGCNName(),
            fiListHangHoaFile:self.lstKetQuaPhanTich()
        }
        return JSON.stringify(item);
    }
    self.validateForm =function(){
        if(self.fiHS().fiHSType=='3'||self.fiHS().fiHSType==3){
            if(self.fiSoGCNHopQuy()==''||self.fiSoGCNHopQuy()==null){
                app.Alert("Chưa điền số GCN hợp quy (đối với hàng 2C)");
                return false;
            }
            if(self.fiNgayCap()=='undefine'||self.fiNgayCap()==null){
                app.Alert("Chưa điền ngày cấp GCN hợp quy (đối với hàng 2C)");
                return false;
            }
            if(self.lstKetQuaPhanTich().length==0){
                app.Alert("Chưa đính kèm phiếu kết quả phân tích (đối với hàng 2C)");
                return false;
            }
        }
        if(self.fiFileGCN()==null){
            app.Alert("Chưa có file GCN hợp quy");
            return false;
        }
        return true;
    }
    self.thoatOnClick = function(){
        self.clearForm();
        $("#modal_view").hide();
        $("#modal_guiSua").modal("hide");
    }
    self.clearForm =function () {
        self.fiLoaiDanhGia(null);
        self.fiToChucDanhGia(null);
        self.fiSoGCNHopQuy('');
        self.fiNgayCap(new Date());
        self.fiFileGCN(null);
        self.fiFileKQ(null);
        self.lstKetQuaPhanTich([]);
    }
    self.getTrangThaiHangHoa = function (statuscode) {
        var lstProfileStatus = self.lstProfileStatus();
        var pos = lstProfileStatus.find(function (e) {
            return e.fiCatType == Number(statuscode);
        })
        if (pos)
            return pos.fiCatTypeName;
        else return statuscode;
    }
    self.getFileGCN =function (idHangHoa,callback) {
        app.makeGet({
            url: '/mard/25/filegcn/'+idHangHoa,
            success: function (d) {
                if (d.success) {
                    callback(d);
                }
            }
        });
    }
    self.getFileKQPT =function (idHangHoa,callback) {
        app.makeGet({
            url: '/mard/25/filekqpt/'+idHangHoa,
            success: function (d) {
                if (d.success) {
                    callback(d);
                }
            }
        });
    }
    self.permissionViewSendFunction= function (item) {
        if(self.fiHSType()==3){
            if(item.fiTrangThaiHangHoa==28 ||
                item.fiTrangThaiHangHoa==33 || item.fiTrangThaiHangHoa==38){
                return true;
            }else{
                return false;
            }
        }else{
            if (item.fiTrangThaiHangHoa==26 ||
                item.fiTrangThaiHangHoa==33 || item.fiTrangThaiHangHoa==38){
                return true;
            }else{
                return false;
            }
        }
    }
    self.permissionViewWordFunction= function (item) {
        if(self.fiHSType()==3){
            if(item.fiTrangThaiHangHoa==44){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
}

function getThongTinHangHoa(callback) {
    $('#loading08').show();
    $.ajax({
        async: true,
        type: 'GET',
        cache: false,
        crossDomain: true,
        url: app.appContext + '/mard/25/hanghoa/find/' + idHoSo,
        beforeSend: function (xhr) {
            xhr.setRequestHeader(CSRF_TOKEN_NAME, CSRF_TOKEN_VALUE);
        },
        success: function (res) {
            callback(res);
            $('#loading08').hide();
        },
        error: function (x, t, m) {
            $('#loading08').hide();
        },
    })
}
function init(options) {
    var mard25ViewHangHoaVM = new Mard25ViewHangHoaVM(options);
    options["fiTrangThaiHangHoa"]="0";
    ko.applyBindings(mard25ViewHangHoaVM, document.getElementById('mardHangHoa25'));
}
$(document).ready(function () {
    var options = {};
    getThongTinHangHoa(function (data) {
        options["mard25HangHoaItems"]=data.data;
        $('#loading10').show();
        $.when(
            app.sendGetRequest("/mard/25/danhmuc/dvxl/1", function (res) {
                options['lstToChucDanhGia'] = res.data;
            }),
            app.sendGetRequest( '/mard/25/hoso/find'  + "?idHoSo=" + idHoSo, function (res) {
                options["fiHS"] = res.data;
            }),
            // Get profile status
            app.sendGetRequest("/mard/25/danhmuc/getby-catno/1", function (res) {
                options['lstNhom'] = res.data;
            }),
            //danh muc trang thai
            app.sendGetRequest("/mard/25/danhmuc/getby-catno/25", function (res) {
                options['lstProfileStatus'] = res.data;
            }),
            app.sendGetRequest("/mard/25/danhmuc/quocgia", function (res) {
                options['lstCountry'] = res.data;
            })
        ).done(function (data) {
            $('#loading10').hide();

            init(options);
        })
    })
})

function ThongBaoKQVM() {
    var thongBaoVMSefl = this;
    thongBaoVMSefl.listHangHoa = ko.observableArray([]);
    thongBaoVMSefl.thoiGianNhap = ko.observable(null);
    thongBaoVMSefl.hopDong=ko.observable(null);
    thongBaoVMSefl.hoaDon=ko.observable(null);
    thongBaoVMSefl.giayDKXN=ko.observable(null);
    thongBaoVMSefl.tenCongTyNK=ko.observable(null);
    thongBaoVMSefl.diaChiCongTyNK=ko.observable(null);
    thongBaoVMSefl.tieuChuanApDung=ko.observable(null);
    thongBaoVMSefl.quyChuanKT=ko.observable(null);
    thongBaoVMSefl.giayCN=ko.observable(null);
    thongBaoVMSefl.ngayKy=ko.observable(null);
    thongBaoVMSefl.soGDK=ko.observable(null);
    thongBaoVMSefl.lstHD=ko.observableArray([]);
    thongBaoVMSefl.lstHoaDon=ko.observableArray([]);
    thongBaoVMSefl.update=function(index){
        thongBaoVMSefl.listHangHoa(index);
        thongBaoVMSefl.thoiGianNhap("Từ ngày: "+  new Date(self.fiHS().fiPurchFromDate).toShortDateString() + " tới ngày " + new Date(self.fiHS().fiPurchToDate).toShortDateString());
        thongBaoVMSefl.tenCongTyNK(self.fiHS().fiImporterName);
        thongBaoVMSefl.diaChiCongTyNK(self.fiHS().fiImporterAddress);
        thongBaoVMSefl.quyChuanKT(index.fiProQuyChuan);
        thongBaoVMSefl.tieuChuanApDung(index.fiProSoHieu);
        thongBaoVMSefl.giayCN(index.fiSoGCN);
        thongBaoVMSefl.ngayKy(index.ngayKy==null?null:new Date(index.ngayKy).toDateString());
        thongBaoVMSefl.soGDK(self.fiHS().fiSoXacNhanDon);

        if(self.fiHS().fiAttachmentList.length>0) {
            thongBaoVMSefl.lstHD=ko.computed(function () {
                return ko.utils.arrayFilter(item.fiAttachmentList, function (re) {
                    return re.fiFileTypeID == '1';
                });
            });
            thongBaoVMSefl.lstHoaDon=ko.computed(function () {
                return ko.utils.arrayFilter(item.fiAttachmentList, function (re) {
                    return re.fiFileTypeID == '2';
                });
            });
        }
    }
    thongBaoVMSefl.closeThongBao = function(data,type,index){
        $("#mard25KQKT").modal("hide");
    }
}