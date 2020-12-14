/************************************************
* This is an example localization page. All of these
* messages are the default messages for ko.validation
*
* Currently ko.validation does multiple parameter replacement
* on your message (indicated by the {0}, {1}, etc.).
*
* The parameters that you provide in your validation extender
* are what are passed to your message to do the {0}, {1} etc. replacements.
*
* eg: myProperty.extend({ minLength: 5 });
* ... will provide a message of "Please enter at least 5 characters"
* when validated
*
* eg: myProperty.extend({ between: [1, 5] });
* ... will provide a message of "Please enter between 1 and 5 characters"
* when validated
*
* This message replacement obviously only works with primitives
* such as numbers and strings. We do not stringify complex objects
* or anything like that currently.
*/
(function(factory) {
	// Module systems magic dance.
	/*global require,ko.validation,define,module*/
	if (typeof require === 'function' && typeof exports === 'object' && typeof module === 'object') {
		// CommonJS or Node
        module.exports = factory(require('./.'));
	} else if (typeof define === 'function' && define['amd']) {
		// AMD anonymous module
		define(['knockout.validation'], factory);
	} else {
		// <script> tag: use the global `ko.validation` object
		factory(ko.validation);
	}
}(function(kv) {
	if (!kv || typeof kv.defineLocale !== 'function') {
		throw new Error('Knockout-Validation is required, please ensure it is loaded before this localization file');
	}
	return kv.defineLocale('vi', {
		required: 'Đây là trường bắt buộc phải nhập.',
		min: 'Giá trị nhỏ nhất tổi thiểu là {0}.',
		max: 'Giá trị lớn nhất là {0}.',
		minLength: 'Chiều dài nhập tối thiểu là {0} kí tự.',
		maxLength: 'Chiều dài nhập tối đa là {0} kí tự.',
		pattern: 'Nhập chưa đúng định dạng.',
		step: 'Giá trị tăng lên {0}.',
		email: 'Email nhập chưa đúng định dạng.',
		date: 'Ngày chưa đúng định dạng.',
		dateISO: 'Nhập đúng định dạng ngày tháng.',
		number: 'Nhập kiểu số.',
		digit: 'Nhập số lớn hơn >= 0.',
		phoneUS: 'Please specify a valid phone number.',
		equal: 'Giá trị phải giống.',
		notEqual: 'Chọn khác giá trị mặc định.',
		unique: 'Giá trị này đã tồn tại.',
        greaterThan: 'Giá trị nhập phải lớn hơn {0}.',
        greaterThanOrEqual: 'Giá trị nhập phải lớn hơn hoặc bằng {0}.',
        dateVI: 'Sai định dạng ngày/tháng/năm (dd/mm/yyyy) hoặc năm bắt đầu từ 1900-2999 hoặc ngày nhập không đúng theo lịch.'
	});
}));
