function dateToTime(ddMMyyyy) {
    if (ddMMyyyy == undefined || ddMMyyyy == null || ddMMyyyy == '') return 0;
    var d = ddMMyyyy.toString().split("/");
    return new Date(d[2] + "-" + d[1] + "-" + d[0]).getTime();
}

function test(pattern, value) {
    var res = pattern.test(value);
    return res;
}
ko.validation.rules['dateVI'] = {
    validator: function (val, otherVal) {
        if (otherVal == true) {
            if (val) {
                var check = test(/^((0[1-9]|[12][0-9]|3[01])\/(0[1-9]|1[012])\/(19|2[0-9])[0-9]{2})$/m, val);
                if (check == false) return false;
                var s = val.split("\/");
                var month = parseInt(s[1]);
                var soCuoi = parseInt(s[2].substring(2,4));
                var year = parseInt(s[2]);
                if (month === 2) {
                    if (soCuoi % 4 === 0 || (soCuoi === 0 && year % 100 === 0)) {
                        return test(/^((29\/02\/2000|2400|2800|(19|2[0-9](0[48]|[2468][048]|[13579][26]))))$/m, val);
                    } else {
                        return test(/^((0[1-9]|1[0-9]|2[0-8])\/02\/((19|2[0-9])[0-9]{2}))$/m, val);
                    }
                }
                var thang30Ngay = [4, 6, 9, 11];
                if (thang30Ngay.includes(month)) {
                    return test(/^((0[1-9]|[12][0-9]|30)\/(0[469]|11)\/((19|2[0-9])[0-9]{2}))$/m, val);
                }
                var thang31Ngay = [1, 3, 5, 7, 8, 10, 12];
                if (thang31Ngay.includes(month)) {
                    return test(/^((0[1-9]|[12][0-9]|3[01])\/(0[13578]|10|12)\/((19|2[0-9])[0-9]{2}))$/m, val);
                }
            }
        }
        return true;
    },
    message: 'Sai định dạng ngày/tháng/năm (dd/mm/yyyy) hoặc năm bắt đầu từ 1900-2999 hoặc ngày nhập không đúng theo lịch.'
};


ko.validation.rules['notEqual'] = {
    validator: function (val, otherVal) {
        if (val) {
            return val != otherVal;
        }
        return false;
    },
    message: ''
};
ko.validation.rules['greaterThan'] = {
    validator: function (val, otherVal) {
        if (val) {
            return dateToTime(val) > dateToTime(otherVal);
        }
        return true;
    },
    message: 'Giá trị nhập phải lớn hơn {0}.'
};
ko.validation.rules['greaterThanOrEqual'] = {
    validator: function (val, otherVal) {
        if (val) {
            return dateToTime(val) >= dateToTime(otherVal);
        }
        return true;
    },
    message: 'Giá trị nhập phải lớn hơn hoặc bằng {0}.'
};

function showError(item, rowIndex, isDebug) {
    for (var key in item) {
        if (isDebug) {
            if (item[key] != undefined && item[key] != null) {
                console.log(key + " is valid: " + item[key].isValid());
            }
        }
        if (item[key] != undefined && item[key] != null && key != 'valid') {
            if (item[key].isValid() == false) {
                var eleId = "#" + key;
                if (rowIndex != undefined && rowIndex != null) eleId += rowIndex;
                if($(eleId).length) {
                    $(eleId).focus();
                    return;
                }
            }
        }
    }
}

ko.validation.registerExtenders();

function isKeyControl(keyCode) {
    var reuslt = $.inArray(keyCode, [37, 39, 46, 47, 8, 116]);
    if (reuslt !== -1) return true;
    return false;
}

ko.bindingHandlers.dateInput = {
    init: function (element, valueAccessor, allBindingsAccessor, viewModel) {
        var allBindings = allBindingsAccessor();
        $(element).keydown(function (e) {
            var value = e.target.value;
            var keyCode = e.which || e.keyCode;
            var keys = [ 48, 49, 50, 51, 52, 53, 54, 55, 56, 57];

            if (isKeyControl(keyCode) === true) return true;
            if (!value) {
                if (keyCode > 51) return false;
            }
            if (value.length === 1) {
                var oneChar = value.charCodeAt();
                if (oneChar > 51) return false;
                if (oneChar === 51 && keyCode > 49) return false;
            }
            if (value.length === 2 || value.length === 5) {
                if (keyCode != 191) return false;
                return true;
            }
            if (value.length === 3) {
                if (keyCode > 49) return false;
            }
            if (value.length === 4) {
                var oneChar = value.substring(3).charCodeAt();
                if (oneChar > 49) return false;
                if (oneChar === 49 && keyCode > 50) return false;
            }
            if (value.length === 6) {
                if (keyCode === 49 || keyCode === 50) return true;
                return false;
            }
            if (value.length === 7) {
                var oneChar = value.substring(6).charCodeAt();
                console.log(value.substring(6));
                if ((oneChar === 49 && keyCode === 57) || oneChar === 50) return true;
                return false;
            }
            if (value.length >= 10) {
                if (isKeyControl(keyCode) === true) return true;
                return false;
            }
            if ($.inArray(keyCode, keys) === -1) return false;
            if (allBindings.dateInput) {
                allBindings.dateInput.call(viewModel, viewModel, e.target, element);
            }
            return true;
        });
    }
}

ko.bindingHandlers.numberFormatInput = {
    init: function (element, valueAccessor, allBindingsAccessor, viewModel) {
        var allBindings = allBindingsAccessor();
        $(element).keydown(function (e) {
            var value = e.target.value;
            var keyCode = e.which || e.keyCode;
            var keys = [ 48, 49, 50, 51, 52, 53, 54, 55, 56, 57];
            if (isKeyControl(keyCode) === true) return true;

            if ($.inArray(keyCode, keys) === -1) return false;
            if (allBindings.numberFormatInput) {
                allBindings.numberFormatInput.call(viewModel, viewModel, e.target, element);
            }
            return true;
        });
    }
}

ko.bindingHandlers.textFormatInput = {
    init: function (element, valueAccessor, allBindingsAccessor, viewModel) {
        var allBindings = allBindingsAccessor();
        var ctrlDown = false,
            ctrlKey = 17,
            cmdKey = 91,
            vKey = 86,
            cKey = 67;
        $(element).keydown(function (e) {
            var value = e.target.value;
            var keyCode = e.which || e.keyCode;
            if (e.keyCode == ctrlKey || e.keyCode == cmdKey) ctrlDown = true;
            if (ctrlDown && (e.keyCode == vKey || e.keyCode == cKey)) return false;
            if (isKeyControl(keyCode) === true) return true;
            if ((keyCode >= 97 && keyCode <= 122) || (keyCode >= 65 && keyCode <= 90) || keyCode === 188 || keyCode == 32 || keyCode === 190) {
                if (allBindings.textFormatInput) {
                    allBindings.textFormatInput.call(viewModel, viewModel, e.target, element);
                }
                return true;
            };
            return false;
        });

        $(element).keyup(function (e) {
            if (e.keyCode == ctrlKey || e.keyCode == cmdKey) ctrlDown = false;
        });
    }
}

function CustomPagination(arrayData, itemOfPage) {
    var self = this;

    self.data = ko.observableArray(arrayData);

    self.pageData = ko.observableArray([]);

    self.pageChilds = ko.observableArray([]);

    self.itemOfPage = ko.observable(itemOfPage);

    self.currentPage = ko.observable(1);

    self.totalPage = ko.observable(0);

    self.isLastPage = ko.observable(false);
    self.isFirstPage = ko.observable(false);

    self.firstPage = function(val) {
        self.isFirstPage(val);
        self.isLastPage(false);
    }
    self.lastPage = function(val) {
        self.isLastPage(false);
        self.isLastPage(val);
    }
    self.getPageNumber = function () {
        var end = Math.trunc(self.data().length / self.itemOfPage());
        if (self.data().length % self.itemOfPage() !== 0) end ++;
        self.totalPage(end);
        self.pageChilds.removeAll();
        for (i = 1; i <= end; i++) self.pageChilds.push(i);
    }

    self.goToPage = function (page) {
        self.currentPage(page);
        self.pageData.removeAll();
        self.data.slice((page -1) * self.itemOfPage() , page * self.itemOfPage()).forEach(function (value, index) {
            self.pageData.push(value);
        })
    }

    self.loadPage = function (d) {
        self.data.removeAll();
        d.forEach(function (value, index) {
            self.data.push(value);
        })
        self.getPageNumber();
        if (self.isLastPage()) {
            self.currentPage(self.totalPage());

        } else if (self.isFirstPage()) {
            self.currentPage(self.totalPage() < self.currentPage() ? self.currentPage() - 1 : self.currentPage());
        }
        self.pageData.removeAll();
        self.data.slice((self.currentPage() - 1) * self.itemOfPage(), self.currentPage() * self.itemOfPage()).forEach(function (value, index) {
            self.pageData.push(value);
        })

        $(".select5").select2({
            placeholder: '',
            width: '100%'
        });
    }
}