function PopupViewGP() {
    var self = this;
    // ket qua xu ly

    self.show = function(item) {
        var url ='/mard/api/17/findGP/'+ item.fiIdHoSo();
        app.makePost({
            url: url,
            data: JSON.stringify({}),
            error: function (d) {
                d.TotalMoneyGpUSD = 0;
                d.TotalMoneyGpEUR = 0;
                d.isKhangSinh = false;
                d.mucDichNotSdKd = ["3", "4", "5", "6", "7", "8"];
                d.mucDichSdKd = ["1", "2", "10"];
                if(d.hoSo.fiPurposes != null && d.hoSo.fiPurposes != undefined) {
                    d.mucDich = d.hoSo.fiPurposes.substring(0, d.hoSo.fiPurposes.length - 1);
                }
                if(d.hoSo.fiDeniedReason != null && d.hoSo.fiDeniedReason != undefined){
                d.DeniedReason = d.hoSo.fiDeniedReason.replace(/&emsp;/g,' ').replace(/<br\s*\/?>/g,"\n");//.replace(/<br\s*\/?>/g,"\n");//replace(/^\s*[\r\n]/gm,'').
                }
                for(var i = 0; i < d.thuocs.length; i++ ){
                if (d.thuocs[i].fiProductType == 8){d.isKhangSinh = true;}
                if(d.thuocs[i].fiMoneyUnitCode == 'EUR' )
                {
                    d.TotalMoneyGpEUR += d.thuocs[i].fiTotal;
                }
                if(d.thuocs[i].fiMoneyUnitCode == 'USD')
                {
                    d.TotalMoneyGpUSD += d.thuocs[i].fiTotal;
                }
                }

                var callback = function (html) {
                    var pop = app.popup({
                        title: '',
                        html: html,
                        width: 1200,
                        buttons: [
                            {
                                name: NSWLang["common_button_dong"],
                                class: 'btn',
                                icon: 'fa-remove',
                                action: function () {
                                    app.popupRemove(pop.selector);
                                }
                            }
                        ]
                    }, function () {
                        var popupViewHoSo = new PopupViewHoSo(d);
                        ko.applyBindings(popupViewHoSo, document.getElementById("form"));
                    });
                };

                app.complieTemplate({
                    ministryCode: "mard",
                    code: "17",
                    templateName: "xemgiayphep",
                    data: d

                }, callback);
            }
        });

    }

}

function PopupViewHoSo(d) {
    var self = this;

    self.formData = d;
    var idHoSo = d.hoSo.fiIdHoSo;
    console.log(d);
    self.capitalizeFirstLetter = function(text){
        text = text.trim();
        return text.charAt(0).toUpperCase() + text.slice(1);
    }
    self.includes = function (array, elment) {
        if(array.indexOf(elment) !== -1){
            return true;
        }
        else {
            return false;
        }

    }
    self.downloadFileUrl = app.appContext  + "/mard/api/17/xuatGiayPhep/" + idHoSo;

    self.xuatGiayPhep  = function () {
        var url = "/mard/api/17/xuatGiayPhep";
        app.makePost( {
            url: url,
            type: 'POST',
            data: JSON.stringify({}),
            success: function (d) {
                console.log(d);
            },
            error: function (e) {
                console.log(e);
            }


        })

    }
}
