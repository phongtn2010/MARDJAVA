function Mard25ViewHangHoaVM (options) {
    var self=this;
    self.fiHSCode = ko.observable(null);
    self.fiHSStatus = ko.observable(null);
    self.errorMsg  = ko.observable('');
    self.mard25HangHoaItems  = ko.observableArray((options && options.hasOwnProperty('mard25HangHoaItems')) ? options.mard25HangHoaItems :[]);
    self.lstToChucDanhGia  = ko.observableArray((options && options.hasOwnProperty('lstToChucDanhGia')) ? options.lstToChucDanhGia :[]);
    self.lstKetQuaPhanTich  = ko.observableArray((options && options.hasOwnProperty('lstKetQuaPhanTich')) ? options.lstKetQuaPhanTich :[]);

    self.fiNSWFileCode = ko.observable(null);
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

    self.fiNameTCCD = ko.observable(null);
    self.guiKetQuaVM= new GuiKetQuaVM();

    self.hangHoaSelected = ko.observable(null);
    self.backBtn = function(){
        window.location.href=app.appContext+"/mard/25/home";
    }
    self.removeFile = function(data,index){
        self.lstKetQuaPhanTich.splice(index,1);
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
                    var item={
                        fiTenFile:fiFileName,
                        fiFileLink:d.data.urlFile,
                        fiFileId:d.data.itemId
                    };
                    self.lstKetQuaPhanTich.push(item);
                }else{
                    self.errorMsg('Có lỗi tải file lên');
                }
            },
            error: function (e) {
                ufVMSelf.errorMsg('Có lỗi tải file lên'+e);
            }
        });
    }
    self.xemKQDGSPH = function(data,type,index){
        self.fiProName(index.fiProName);
        $("#modal_view").show();
    }
    self.fileKQChange = function(data, e){
        var files = e.target.files;
        console.log(files);
        app.uploadFile({
            file: files[0],
            mcode: 'mard',
            pcode: '25',
            url: '/mard/25/upload',
            success: function (d) {
                if(d.success){
                    self.fiFileGCNLink(d.data.urlFile);
                    self.fiFileGCNId(d.data.itemId);
                    self.fiFileGCNName(files[0].name);
                }else{
                    self.errorMsg('Có lỗi tải file lên');
                }
                $('#loading08').hide();
            },
            error: function (e) {
                self.errorMsg('Có lỗi tải file lên'+e);
                $('#loading08').hide();

            }
        });
    }
    self.guiSuaHangHoa = function(data,type,index){
        self.fiProName(index.fiProName);
        self.hangHoaSelected(index);
        self.fiNSWFileCode(self.fiHS().fiNSWFileCode);
        $("#modal_guiSua").show();
    }
    self.guiKiemDinhHangHoa =function(){
        if(!self.validateForm()){
            return;
        }
        var item={

        }
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
    self.thoatOnClick = function(index){
        self.clearForm();
        $("#modal_view").hide();
        $("#modal_guiSua").hide();
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
            })
        ).done(function (data) {
            $('#loading10').hide();
            init(options);
        })
    })
})
function GuiKetQuaVM(){

}