function SendHoSoView() {
    var self = this;
    self.show = function (item) {
        var docCode = item.fiDocumentName();
        var pop = app.popup({
            title: NSWLang["mard.20.send.confirm"],
            html: '<i class="fa fa-3x fa-warning"></i> ' + NSWLang["mard.20.send.confirm"] + ' <b>' + docCode + '</b>',
            width: 400,
            buttons: [
                {
                    name: NSWLang["common_button_toi_chac_chan"],
                    class: 'btn',
                    icon: 'fa-check',
                    action: function () {
                        coKySo = false;
                        if (coKySo) {
                            self.send(post);
                        } else {
                            var post = {
                                fiReason: null,
                                fiXml: null,
                                fiIdHoSo: item.fiIdHoSo(),
                                fiAction: action
                            }
                            self.send(pop, post);
                        }
                    }
                }
            ]
        });
    }

    ///verify chu ky so ----------------------------------------------
    self.verifySignature = function (signature, doc) {

        var data = {
            'signatureXml': signature,
            'messageXml': doc.sign.fiXml,
            'msgFunc': doc.sign.fiFunc,
            'msgType': doc.sign.fiMsgType,
            'documentCode': doc.data.fiMaHoso,
            'ministryCode': 'MARD',
            'proceduceCode': 'BNNPTNT0600007'
        };
        app.makePost({
            url: '/mard/api/20/verify',
            data: JSON.stringify(data),
            success: function (d) {
                app.makePost({
                    url: '/mard/api/20/send',
                    timeout: 5 * 60 * 1000,
                    data: JSON.stringify(doc.data),
                    success: function (d) {
                        app.Alert('Gửi hồ sơ thành công');

                    },
                    error: function (e) {
                        app.Alert('Gửi hồ sơ không thành công');
                    }
                });
            },
            error: function (e) {
                if(e.hasOwnProperty('message')) {
                    app.Alert(e.message);
                } else {
                    app.Alert('Ký số không thành công, vui lòng thử lại.');
                }
            }
        });
    };
    /////////////////

   self.send = function (popup, data) {
        app.popupRemove(popup.selector);
        app.makePost({
            url: '/mard/api/20/send',
            timeout: 5 * 60 * 1000,
            success: function (d) {
            	 if (isDevTest) {
                     console.log(d);
                 }
                self.thongBao(d.message, true);
            },
            data: ko.toJSON(data),
            error: function (e) {
                if (isDevTest) {
                    console.log("Gui ho so. Ban tin tra ve");
                    console.log(e);
                }

                if (!e.message) e.message = NSWLang["mard.20.send.timeout"];
                self.thongBao(e.message, false);
            }
        });
    }

    self.thongBao = function (message, success) {
        var cls = 'class="alert alert-success toast-success" style="color: #fff;"';
        var icon = 'fa fa-check';
        if (!success) {
            cls = 'class="alert alert-danger" style="color: #000;background: red;"';
            icon = 'fa fa-send-o';
        }
        var pop = app.popup({
            title: NSWLang["common_msg_thong_bao"],
            html: '<div ' + cls + ' ><i class="' + icon + '" aria-hidden="true"></i> ' + NSWLang["common_msg_thong_bao"] + ' <b>' + message + '</b></div>',
            width: 400,
            buttons: [
                {
                    name: NSWLang["common_button_dong"],
                    class: 'btn',
                    icon: 'fa-remove',
                    action: function () {
                        app.popupRemove(pop.selector);
                        if (!isDevTest) {
                            location.reload();
                        }

                    }
                }
            ]
        }, function () {
            $('button[class="close"]').click(function () {
                app.popupRemove(pop.selector);
                if (!isDevTest) {
                    location.reload();
                }
            });
        });
        if (!isDevTest || (isDevTest && success == true)) {
            setTimeout(function () {
                location.href = app.appContext + '/mard/20/home';
            }, 1000);
        } else if (!success) {
            setTimeout(function () {
                location.href = app.appContext + '/mard/20/edit/' + idHoSo;
            }, 1000);
        }

    }

}
