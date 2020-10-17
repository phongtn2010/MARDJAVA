function ChooseLicenseTT8VM(options, callback) {
    var self = this;


    var hoso = (options !== null && options.hasOwnProperty('hoso')) ? options.hoso : null;

    self.fiIsPicked = ko.observable(false);

    self.fiNgayCap = ko.observable(null);

    if (hoso != null) {
        self.fiIsPicked(true);
        self.fiNgayCap(new Date(options.mapKdnk[hoso.fiAccQuarantineDoc].fiSignConfirmDate));
    }


    self.lstKdnk = ko.observableArray(options.lstKdnk ? options.lstKdnk : []);

    self.isDisable = ko.observable(hoso ? true : false);

    self.optionsCaption = ko.observable(hoso ? hoso.fiAccQuarantineDoc : "Chọn...");

    self.fiMaKdnk = ko.observable(hoso ? hoso.fiAccQuarantineDoc : null).extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });

    self.onPickKdnk = function (obj, event){
        if ($("#fiMaKdnk").prop('selectedIndex')) {
            callback(options.lstKdnk[$("#fiMaKdnk").prop('selectedIndex') - 1]);
            self.fiIsPicked(true);
            self.fiNgayCap(new Date(options.lstKdnk[$("#fiMaKdnk").prop('selectedIndex') - 1].fiSignConfirmDate))
        }
    };

}