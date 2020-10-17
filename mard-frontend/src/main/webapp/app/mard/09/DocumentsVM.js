var DocumentsVM = function (currentDocuments, documentTypes) {
    var self = this;

    self.lstDocuments = ko.observableArray([]);

    if (currentDocuments && currentDocuments.length > 0) {
        currentDocuments.forEach(function (item) {
            self.lstDocuments.push(new Document(item, documentTypes))
        })
    }

    self.onRemove = function(index) {
        self.lstDocuments.splice(index, 1)
    };

    self.onAdd = function () {
        self.lstDocuments.push(new Document(null, documentTypes))
    };

    self.isValid = function() {
        var valid = self.lstDocuments().length > 0;
        self.lstDocuments().forEach(function (item) {
            valid = valid && item.isValid()
        });
        return valid;
    };

    self.toJSON = function () {
        var rs = [];
        self.lstDocuments().forEach(function (item) {
            rs.push(item.toJSON());
        });
        return rs
    }
};

var Document = function (data, documentTypes) {
    var document = this;

    document.documentTypes = ko.observableArray(documentTypes);
    var typesMap = {};

    documentTypes.forEach(function (item) {
        typesMap[item.id.toString()] = item.name;
    });

    document.typeId = ko.observable(data ? data.fiTypeDoc : null).trimmed().extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });
    document.typeName = ko.observable(data ? typesMap[data.fiTypeDoc.toString()] : null).trimmed().extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},

    });
    document.number = ko.observable(data ? data.fiNumber : null).trimmed().extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true},
    });
    document.date = ko.observable(data ? new Date(data.fiDate) : null).trimmed().extend({
        required: {message: NSWLang["common_msg_formvaild_required"], params: true}
    });

    document.toJSON = function () {
        return {
            fiTypeDoc: document.typeId(),
            fiNumber: document.number(),
            fiDate: document.date()
        }
    };

    document.isValid = function () {
        return document.typeId.isValid() && document.number.isValid() && document.date.isValid()
    };

    return document;
};

