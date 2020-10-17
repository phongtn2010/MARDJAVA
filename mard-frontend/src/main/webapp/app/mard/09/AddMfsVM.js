// frmAddMfs

var AddMfsVM = function(mfs, onAddMfs) {
    var self = this;
    self.errorMsg = ko.observable(null);
    self.listMfs = ko.observableArray(mfs);
    self.fiFactoryAddress = ko.observable(null).trimmed();

    self.addMfs = function () {
        var data = mfs[$("#frmCongTySanXuatCheBien").prop('selectedIndex') - 1];
        if (data != null ){
            onAddMfs(data);
            self.errorMsg(null);
            self.fiFactoryAddress(null);
            $("#frmCongTySanXuatCheBien").prop('selectedIndex', 0);
            $("#modal_addMfs").modal('toggle');
        } else {
            self.errorMsg("Vui lòng chọn nhà máy sản xuất chế biến");
        }

    };

    self.onClose = function() {
        self.errorMsg(null);
        self.fiFactoryAddress(null);
        $("#frmCongTySanXuatCheBien").prop('selectedIndex', 0);
    };

    self.onChooseMfs = function () {
        if ($("#frmCongTySanXuatCheBien").prop('selectedIndex')) {
            var data = mfs[$("#frmCongTySanXuatCheBien").prop('selectedIndex') - 1];
            self.fiFactoryAddress(data.fiFactoryAddress);
        }
    };
};

var AddMfsVM20a = function(mfs, onAddMfs) {
    var self = this;
    self.errorMsg = ko.observable(null);
    self.listMfs = ko.observableArray(mfs);
    self.fiFactoryAddress = ko.observable(null).trimmed();

    self.addMfs = function () {
        var data = mfs[$("#frmCongTySanXuatCheBien20a").prop('selectedIndex') - 1];
        if (data != null ){
            onAddMfs(data);
            self.errorMsg(null);
            self.fiFactoryAddress(null);
            $("#frmCongTySanXuatCheBien20a").prop('selectedIndex', 0);
            $("#modal_addMfs20a").modal('toggle');
        } else {
            self.errorMsg("Vui lòng chọn nhà máy sản xuất chế biến");
        }

    };

    self.onClose = function() {
        self.errorMsg(null);
        self.fiFactoryAddress(null);
        $("#frmCongTySanXuatCheBien").prop('selectedIndex', 0);
    };

    self.onChooseMfs = function () {
        if ($("#frmCongTySanXuatCheBien20a").prop('selectedIndex')) {
            var data = mfs[$("#frmCongTySanXuatCheBien20a").prop('selectedIndex') - 1];
            self.fiFactoryAddress(data.fiFactoryAddress);
        }
    };
};
