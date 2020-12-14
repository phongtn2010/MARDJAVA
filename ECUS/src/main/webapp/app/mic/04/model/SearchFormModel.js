function SearchFormModel() {

    var self = this;
    self.fiDocumentType = ko.observable(null);
    self.fiDocumentName = ko.observable(null);
    self.fiTaxCode = ko.observable(taxCode);
    self.fiStatus = ko.observable(null);
    self.fiFromCreateDate = ko.observable(null).extend({dateVI: true, maxLength: 12});
    self.fiToCreateDate = ko.observable(null).extend({dateVI: true, maxLength: 12, greaterThanOrEqual: self.fiFromCreateDate});
    self.fiDispatchNo = ko.observable(null);
    self.fiFromSignConfirmDate = ko.observable(null).extend({dateVI: true, maxLength: 12});
    self.fiToSignConfirmDate = ko.observable(null).extend({dateVI: true, maxLength: 12, greaterThanOrEqual: self.fiFromSignConfirmDate});
    self.valid = ko.validatedObservable(this);

}
