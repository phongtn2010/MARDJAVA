var Hoso01VM = function (hoso01) {
    var self = this;
    ko.mapping.fromJS(hoso01, {}, self);

    return self;
};

var GP13A = function (gp, fiHSStatus) {
    var self = this;
    ko.mapping.fromJS(gp, {}, self);
    self.hideEdit = ko.observable([11, 15, 13].includes(fiHSStatus));
    self.hideCancel = ko.observable([11, 15, 13].includes(fiHSStatus));
    self.fiLinkDownContent = ko.observable("/mard/01/dinhkem/download/" + gp.fiAttachmentID);
    self.fiLinkDownGCN = ko.observable("/mard/01/gcn/download/13a/" + gp.fiNSWFileCode);
    return self;
};

var GP13B = function (gp, fiHSStatus) {
    var self = this;
    ko.mapping.fromJS(gp, {}, self);
    self.hideEdit = ko.observable([11, 15, 13].includes(fiHSStatus));
    self.hideCancel = ko.observable([11, 15, 13].includes(fiHSStatus));
    self.fiLinkFile = ko.observable("/mard/01/gcn/download/13b/" + gp.fiNSWFileCode);
    self.fiLinkDownContent = ko.observable("/mard/01/dinhkem/download/" + gp.fiAttachmentID);
    return self;
};

var GPChina = function (gp, fiHSStatus) {
    var self = this;
    ko.mapping.fromJS(gp, {}, self);
    self.hideEdit = ko.observable([11, 15, 13].includes(fiHSStatus));
    self.hideCancel = ko.observable([11, 15, 13].includes(fiHSStatus));
    self.fiLinkFile = ko.observable("/mard/01/gcn/download/cn/" + gp.fiNSWFileCode);
    return self;
};

var GPHongKongGa = function (gp, fiHSStatus) {
    var self = this;
    ko.mapping.fromJS(gp, {}, self);
    self.hideEdit = ko.observable([11, 15, 13].includes(fiHSStatus));
    self.hideCancel = ko.observable([11, 15, 13].includes(fiHSStatus));
    self.fiLinkFile = ko.observable("/mard/01/gcn/download/hkc/" + gp.fiNSWFileCode);
    return self;
};

var GPHongKongLon = function (gp, fiHSStatus) {
    var self = this;
    ko.mapping.fromJS(gp, {}, self);
    self.hideEdit = ko.observable([11, 15, 13].includes(fiHSStatus));
    self.hideCancel = ko.observable([11, 15, 13].includes(fiHSStatus));
    self.fiLinkFile = ko.observable("/mard/01/gcn/download/hkp/" + gp.fiNSWFileCode);
    return self;
};

var GPMalay = function (gp, fiHSStatus) {
    var self = this;
    ko.mapping.fromJS(gp, {}, self);
    self.hideEdit = ko.observable([11, 15, 13].includes(fiHSStatus));
    self.hideCancel = ko.observable([11, 15, 13].includes(fiHSStatus));
    self.fiLinkFile = ko.observable("/mard/01/gcn/download/m/" + gp.fiNSWFileCode);
    return self;
};