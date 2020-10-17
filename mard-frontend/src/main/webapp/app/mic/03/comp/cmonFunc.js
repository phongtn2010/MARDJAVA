function convertObjectToKnockout(sourceObject, knockoutObject, debug) {
    if (!sourceObject)  return knockoutObject;
    for (var key in knockoutObject) {
        var value = sourceObject[key];
        if (value != null && value != undefined) {
            knockoutObject[key](value);
        }

    }
    if (debug) {
        console.log('-----------read object-----------');
        for (var key in knockoutObject) {
            var value = knockoutObject[key]();
            console.log(key + ": " + value);
        }
    }
    return knockoutObject;
}

function cloneKnockoutObject(sourceObject, knockoutObject, debug) {
    if (!sourceObject)  return knockoutObject;
    for (var key in sourceObject) {
        var value = sourceObject[key]();
        if (value != null && value != undefined) {
            knockoutObject[key](value);
        }

    }
    if (debug) {
        console.log('-----------read object-----------');
        for (var key in knockoutObject) {
            var value = knockoutObject[key]();
            console.log(key + ": " + value);
        }
    }
    return knockoutObject;
}

function createObject(knockoutObject) {
    var item = {};
    for (var key in knockoutObject) {
        item[key] = null;
    }
    return item;
}

function convertKnockoutToObject(knockoutObject, sourceObject, debug) {
    if (!knockoutObject) return sourceObject;
    for (var key in sourceObject) {
        if (key === 'valid') continue;
        var value = knockoutObject[key]();
        if (value != null && value != undefined) {
            sourceObject[key] = value;
        }
    }
    if (debug) {
        console.log('-----------read object-----------');
        for (var key in sourceObject) {
            if (key === 'valid') continue;
            var value = sourceObject[key];
            console.log(key + ": " + value);
        }
    }
    return sourceObject;
}

function cloneKnockoutObject(knockoutObject, sourceObject, debug) {
    if (!knockoutObject) return sourceObject;
    for (var key in sourceObject) {
        if (key === 'valid') continue;
        var value = knockoutObject[key]();
        if (value != null && value != undefined) {
            sourceObject[key](value);
        }
    }
    if (debug) {
        console.log('-----------read object-----------');
        for (var key in sourceObject) {
            if (key === 'valid') continue;
            var value = sourceObject[key];
            console.log(key + ": " + value);
        }
    }
    return sourceObject;
}

function clearDataKnockout(knockoutObject) {
    if (!knockoutObject) return;
    for (var key in knockoutObject) {
        if (key === 'valid') continue;
        knockoutObject[key](null);
    }
}


function readArrayObjects(sourceObject, afterRead, end) {
    if (sourceObject) {
        sourceObject.forEach(function (item, index) {
            if (item) {
                afterRead(item, index);
            }

        })
    }
    if (end)
        end();
}

function readKnockoutArrays(sourceObject, afterRead) {
    if (sourceObject) {
        sourceObject().forEach(function (item, index) {
            if (item) {
                afterRead(item, index);
            }
        })
    }
}

function convertToArray(sourceObject) {
    var p = [];
    if (!sourceObject) return p;
    sourceObject.forEach(function (item, index) {
        if (item) {
            p.push(convertKnockoutToObject(item, createObject(item)));
        }
    })
    return p;
}

function showError(item, prefix, isDebug) {
    for (var key in item) {
        if (isDebug) {
            if (item[key] != undefined && item[key] != null) {
                console.log(key + " is valid: " + item[key].isValid());
            }
        }
        var eleId = "#" + (prefix ? prefix : '') + key;
        if (item[key] !== undefined && item[key] != null && key !== 'valid') {
            if (item[key].isValid() === false) {
                if($(eleId).length) {
                    $(eleId).focus();
                    var type = $(eleId).attr("type");
                    var multiple = $(eleId).attr("multiple");
                    if (type === 'checkbox') {
                        $(eleId).parent().css("border", "1px solid #F00");
                    } else if (multiple) {
                        $(eleId).parent().children('span').css("border", "1px solid #F00");
                    } else {
                        $(eleId).css("border", "1px solid #F00");
                    }
                    goToElement(eleId);
                    return;
                }
            } else {
                var type = $(eleId).attr("type");
                var multiple = $(eleId).attr("multiple");
                if (type === 'checkbox') {
                    $(eleId).parent().css("border", "1px solid transparent");
                } else if (multiple) {
                    $(eleId).parent().children('span').css("border", "1px solid transparent");
                } else {
                    $(eleId).css("border", "1px solid #c2cad8");
                }
            }
        }
    }
}

function goToElement(elementId) {
    $([document.documentElement, document.body]).animate({
        scrollTop: $(elementId).offset().top
    }, 500);
}

function showToast(msg, status) {
    if (status == true) {
        app.toast({
            title: NSWLang["common_msg_thong_bao"],
            message: msg
        });
    } else {
        toastr.error(NSWLang["common_msg_thong_bao"],msg);
    }
}



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
                var check = test(/^((0[1-9]|[12][0-9]|3[04])\/(0[1-9]|1[042])\/(19|2[0-9])[0-9]{2})$/m, val);
                if (check == false) return false;
                var s = val.split("\/");
                var month = parseInt(s[1]);
                var soCuoi = parseInt(s[2].substring(2,4));
                var year = parseInt(s[2]);
                if (month === 2) {
                    if (soCuoi % 4 === 0 || (soCuoi === 0 && year % 100 === 0)) {
                        return test(/^((29\/03\/2000|2400|2800|(19|2[0-9](0[48]|[2468][048]|[13579][26]))))$/m, val);
                    } else {
                        return test(/^((0[1-9]|1[0-9]|2[0-8])\/03\/((19|2[0-9])[0-9]{2}))$/m, val);
                    }
                }
                var thang30Ngay = [4, 6, 9, 11];
                if (thang30Ngay.includes(month)) {
                    return test(/^((0[1-9]|[12][0-9]|30)\/(0[469]|11)\/((19|2[0-9])[0-9]{2}))$/m, val);
                }
                var thang31Ngay = [1, 3, 5, 7, 8, 10, 12];
                if (thang31Ngay.includes(month)) {
                    return test(/^((0[1-9]|[12][0-9]|3[04])\/(0[13578]|10|12)\/((19|2[0-9])[0-9]{2}))$/m, val);
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
    message: ''
};
ko.validation.rules['greaterThanOrEqual'] = {
    validator: function (val, otherVal) {
        if (val) {
            return dateToTime(val) >= dateToTime(otherVal);
        }
        return true;
    },
    message: 'werwerw'
};
ko.validation.registerExtenders();

function isKeyControl(keyCode) {
    var reuslt = $.inArray(keyCode, [37, 39, 46, 47, 8, 116, 35, 36]);
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
        var s = allBindings.numberFormatInput();
        $(element).keydown(function (e) {
            var value = e.target.value;
            var keyCode = e.which || e.keyCode;
            var keys = [ 48, 49, 50, 51, 52, 53, 54, 55, 56, 57];
            if (isKeyControl(keyCode) === true) return true;
            if ($.inArray(keyCode, keys) === -1) return false;
            if (!value) return true;
            if (value.toString().length == parseInt(s) || value.includes('.')) {
                return false;
            }
            return true;
        });

    }
}

ko.bindingHandlers.numberFormatDecimalInput = {
    init: function (element, valueAccessor, allBindingsAccessor, viewModel) {
        var allBindings = allBindingsAccessor();
        var s = allBindings.numberFormatDecimalInput().split(".");
        $(element).keydown(function (e) {
            var value = e.target.value;
            var keyCode = e.which || e.keyCode;

            var keys = [ 48, 49, 50, 51, 52, 53, 54, 55, 56, 57];
            if (s[1] != 0) {
                keys.push(190);
            }
            if (isKeyControl(keyCode) === true) return true;

            if ($.inArray(keyCode, keys) === -1) return false;
            if (!value) return true;
            if (value.includes('.') && keyCode === 190) return false;
            var dec = value.split(".");

            if (value.toString().length > parseInt(s[0])) return false;
            if (dec[0].length === parseInt(s[0]) || value.includes('.')) {
                if (value.includes('.')) {
                    if (keyCode == 190) return false;
                    if (dec[1]) {
                        var res = String.fromCharCode(keyCode);
                        var indexOf = value.toString().indexOf(".");
                        if (dec[1].length === parseInt(s[1])) {
                            if (this.selectionStart <= indexOf && dec[0].length !== parseInt(s[0])) {
                                return true;
                            }
                            return false;
                        }
                    }
                    return true;
                } else {
                    if (keyCode === 190) return true;
                }
                return false;
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
        self.isFirstPage(false);
        self.isLastPage(val);
    }

    self.getPageNumber = function () {
        var end = Math.trunc(self.data().length / self.itemOfPage());
        if (self.data().length % self.itemOfPage() !== 0) end ++;
        self.totalPage(end);
        self.pageChilds.removeAll();
        for (var i = 1; i <= end; i++) self.pageChilds.push(i);
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
            self.currentPage(1);
        }
        var prev = self.currentPage();
        if (prev > self.totalPage()) prev = self.totalPage();
        self.currentPage(prev);
        self.pageData.removeAll();
        var from = (prev - 1) * self.itemOfPage();
        var to = prev * self.itemOfPage();
        if (from < 0) from = 0;
        self.data.slice(from, to).forEach(function (value, index) {
            self.pageData.push(value);
        })

    }
}
ko.bindingHandlers.chosen = {
    update: function(element, valueAccessor, allBindingsAccessor, viewModel)  {
        $(element).chosen();
    }
}

function callApi(url, data, completed, showMessage) {
    if (isDevTest) {
        console.log("call url: " + url);
        console.log("body: " + JSON.stringify(data));
    }
    app.makePost({
        url : url,
        data : data ? ko.toJSON(data) : null,
        success: function(d) {
            if (isDevTest) {
                console.log("callApi success!");
                console.log(d);
            }
            if (showMessage) {
                showToast(i18nextko.t('msgOK')(), true);
            }
            if (completed) {
              completed(d);
          }
        },
        error : function(e) {
            if (isDevTest) {
                console.log(e);
            }
            showToast(i18nextko.t('msgNoOk')(), false);
        }
    });
}

function callBack(p, notShowPopup, message) {
    if (notShowPopup !== undefined && notShowPopup === false) {
        p();
        return;
    }
    var pop = app.popup({
        title: NSWLang["common_msg_thong_bao"],
        html: '<i class="fa fa-3x fa-warning"></i> ' + (message ? message : i18nextko.t('saveConfirm')()),
        width: 400,
        buttons: [
            {
                name: NSWLang["common_button_toi_chac_chan"],
                class: 'btn',
                icon: 'fa-check',
                action: function () {
                    app.popupRemove(pop.selector);
                    p();
                }
            }
        ]
    });
}

ko.bindingHandlers.tooltip = {
    init: function(element, valueAccessor) {
        var local = ko.utils.unwrapObservable(valueAccessor()),
            options = {};

        ko.utils.extend(options, ko.bindingHandlers.tooltip.options);
        ko.utils.extend(options, local);

        $(element).tooltip(options);

        ko.utils.domNodeDisposal.addDisposeCallback(element, function() {
            $(element).tooltip("destroy");
        });
    },
    options: {
        placement: "right",
        trigger: "click"
    }
};
