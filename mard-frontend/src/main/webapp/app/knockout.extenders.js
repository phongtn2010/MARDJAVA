/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
ko.extenders.vndate = function (target) {
    return ko.computed({
        read: function () {
            var value = target();
            var d = new Date(value());
            var year = d.getFullYear();
            var month = ("0" + (d.getMonth() + 1)).substr(-2);
            var day = ("0" + d.getDate()).substr(-2);

            var hour = ("0" + d.getHours()).substr(-2);
            var minutes = ("0" + d.getMinutes()).substr(-2);
            var seconds = ("0" + d.getSeconds()).substr(-2);
            return  day + "/" + month + "/" + year + ' ' + hour + ':' + minutes + ':' + seconds;
        },
        write: target
    });
};

ko.extenders.vnDateShort = function (target) {
    return ko.computed({
        read: function () {
            var value = target();
            var d = new Date(value());
            var year = d.getFullYear();
            var month = ("0" + (d.getMonth() + 1)).substr(-2);
            var day = ("0" + d.getDate()).substr(-2);

            return  day + "/" + month + "/" + year;
        },
        write: target
    });
};

ko.extenders.vnDateWithText = function (target) {
    return ko.computed({
        read: function () {
            debugger;
            var value = target();
            var d = new Date(value);
            console.log(value);
            var year = d.getFullYear();
            var month = ("0" + (d.getMonth() + 1)).substr(-2);
            var day = ("0" + d.getDate()).substr(-2);

            return  'Ngày ' + day + ' tháng ' + month + ' nam ' + year;
        },
        write: target
    });
};

ko.observableArray.fn.firstIndexOf = function (predicate, predicateOwner) {
    for (var i = 0, j = this().length; i < j; i++) {
        if (predicate.call(predicateOwner, this()[i])) {
            return i;
        }
    }
    return -1;
};

ko.bindingHandlers.vnDateShort =
        {
            update: function (element, valueAccessor, allBindingsAccessor)
            {
                return ko.bindingHandlers.text.update(element, function ()
                {
                    var value = ko.utils.unwrapObservable(valueAccessor());
                    if (value == null)
                    {
                        return null;
                    }
//            console.log("value -> ", value);
                    //if (typeof value === "string")
                    //{
                    value = new Date(value);
                    //}
                    return value.toShortDateString();
                }, allBindingsAccessor, null, null);
            }
        };
Date.prototype.toShortDateString = function ()
{
    return (this.getDate() > 9 ? this.getDate() : "0" + this.getDate())
            + "/"
            + ((this.getMonth() + 1) > 9 ? (this.getMonth() + 1) : "0" + (this.getMonth() + 1))
            + "/"
            + this.getFullYear();
};

ko.bindingHandlers.vnDateText =
        {
            update: function (element, valueAccessor, allBindingsAccessor)
            {
                return ko.bindingHandlers.text.update(element, function ()
                {
                    var value = ko.utils.unwrapObservable(valueAccessor());
                    if (value == null)
                    {
                        return null;
                    }
//            console.log("value -> ", value);
                    //if (typeof value === "string")
                    //{
                    value = new Date(value);
                    //}
                    return value.toDateString();
                }, allBindingsAccessor, null, null);
            }
        };
Date.prototype.toDateString = function ()
{
    return (this.getDate() > 9 ? "ngày "+ this.getDate() :"ngày "+ "0"+ this.getDate())
            + " tháng "
            + ((this.getMonth() + 1) > 9 ? (this.getMonth() + 1) : "0" + (this.getMonth() + 1))
            + " nam "
            + this.getFullYear();
};

