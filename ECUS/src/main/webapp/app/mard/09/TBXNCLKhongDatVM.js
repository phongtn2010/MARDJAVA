function TBXNCLKhongDatVM() {
    var self = this;

    self.fiAttachmentList = ko.observableArray([])
    self.fiCreatorName = ko.observable(null);
    self.fiDepartment = ko.observable(null);
    self.fiGoodsList = ko.observableArray([]);
    self.fiQualityResult = ko.observable(null);
    self.fiReason = ko.observable(null);
    self.fiRequestDate = ko.observable(null);
    self.fiDescription = ko.observable(null);

    var hs = null;

    self.showThongbao = function (hoso) {
        $("#loading10").show();
        hs = hoso;
        app.makeGet({
            url: '/mard/09/giayphep/view' + '?type=' + 'tbxncl' + '&code=' + hoso.fiHSCode(),
            success: function (res) {
                if (res.success) {

                    $("#modal_xemTBXNCLKhongDat").modal('toggle');
                    $("#loading10").hide();
                    self.fiAttachmentList(res.data[0].fiAttachmentList);
                    self.fiCreatorName(res.data[0].fiCreaterName);
                    self.fiDepartment(res.data[0].fiDepartment);
                    self.fiGoodsList(res.data[0].fiGoodsList);
                    self.fiQualityResult(res.data[0].fiQualityResult);
                    self.fiReason(res.data[0].fiReason);
                    self.fiRequestDate(new Date(res.data[0].fiRequestDate));
                    self.fiDescription(res.data[0].fiDescription);
                }
            },
            error: function (e) {
                $("#loading10").hide();
            }
        });
    };


    self.bPhanHoiKetQua = function () {
        var html = [
            $('#phanhoi-xncl-template').html()
        ].join('');
        self.pop = app.popup({
            title: 'Phản hồi thông báo XNCL không đạt',
            html: html,
            width: 650,
            buttons: [
                {
                    name: 'Gửi',
                    class: 'btn',
                    icon: 'fa-check',
                    action: function () {
                        var val = $('#fiNoiDungPhanHoiXNCL').val();
                        if (!val || val == "") {
                            alert('Phải nhập: Nội dung xin chỉnh sửa giấy Chứng nhận');
                            return;
                        }
                        var data = {
                            fiNSWFileCode: hs.fiHSCode(),
                            fiDeescription: val
                        };

                        app.makePost({
                            url: '/mard/09/phanhoixncl',
                            data: JSON.stringify(data),
                            success: function (res) {
                                app.Alert('Gửi phản hồi thành công');
                                location.reload();
                                app.popupRemove(self.pop.selector);
                            }, error: function (res) {
                                app.Alert('Gửi phản hồi thất bại');
                            }
                        })
                    }
                },{
                    name: 'Huỷ',
                    class: 'btn',
                    icon: 'fa-close',
                    action: function () {
                        app.popupRemove(self.pop.selector);
                    }
                }
            ]
        });
    };

    return self;
}