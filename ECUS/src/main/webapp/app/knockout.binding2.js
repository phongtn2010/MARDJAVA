/* 
 * @author HaLV Antsoft
 */

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
    return "ngày " + (this.getDate() > 9 ? this.getDate() : "0" + this.getDate())
            + " tháng "
            + ((this.getMonth() + 1) > 9 ? (this.getMonth() + 1) : "0" + (this.getMonth() + 1))
            + " năm "
            + this.getFullYear();
};
ko.bindingHandlers.selectedText2 = {
    init: function (element, valueAccessor) {
        var value = valueAccessor();
        $(element).change(function () {
            var $option = $("option:selected", this);
            if ($option && $option.val()) {
                value($option.text());
            }
        });
        var $selected = $(element).find(":selected");
        if ($selected.val()) {
            value($selected.text());
        }
    }
};