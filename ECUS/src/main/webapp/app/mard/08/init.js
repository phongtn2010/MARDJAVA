var CSRF_TOKEN_NAME = $('#csrfHeader').val();
var CSRF_TOKEN_VALUE = $('#csrfToken').val();

ko.validation.rules.pattern.message = 'Invalid.';
ko.validation.init({
    registerExtenders: true,
    messagesOnModified: true,
    insertMessages: true,
    parseInputAttributes: true,
    messageTemplate: null
}, true);

/*trimed value binder for knockout*/
ko.bindingHandlers.trimedValue = {
    init: function (element, valueAccessor, allBindingsAccessor) {
        $(element).on("change", function () {
            var observable = valueAccessor();
            var trimedValue = $.trim($(this).val());
            observable($(this).val());
            observable(trimedValue);
        });
    },
    update: function (element, valueAccessor) {
        var value = ko.utils.unwrapObservable(valueAccessor());
        var trimedValue = $.trim(value);
        $(element).val(trimedValue);
    }
};

ko.validation.rules['minLength'] = {
    validator: function (val, params) {
        return val.length >= params.length;
    },
    message: ''
};

// ko.validation.registerExtenders();

ko.validation.makeBindingHandlerValidatable("trimedValue");
ko.validation.makeBindingHandlerValidatable("datepicker");

moment.locale('vi');
ko.bindingHandlers.formattedTime = {
    update: function(element, valueAccessor) {
        var date = new Date(ko.unwrap(valueAccessor()));
        $(element).text("ngày " + date.getDate() + " tháng " + (date.getMonth()+1) + " năm " + date.getFullYear());
    }
};
ko.bindingHandlers.datetime = {
    update: function(element, valueAccessor) {
        var date = new Date(ko.unwrap(valueAccessor()));
        $(element).text(moment(date).format('DD/MM/YYYY HH:mm'));
    }
};
