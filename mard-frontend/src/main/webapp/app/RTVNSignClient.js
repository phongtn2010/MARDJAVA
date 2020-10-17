/*
 * API gọi đến tool ký để thực hiện ký điện tử
 * Tác giả: Công ty cổ phần phần mềm Revotech giữ mọi quyền (revotech.vn)
 * 
 * Phiên bản: 1.0
 * Ngày cập nhập: 03/12/2018 (dd/MM/yyyy)
 * 
 * Ví dụ: 
 * Để gọi hàm kiểm tra service ký có hoạt động:
 * RTVNSignClient.ping(function(data){console.log(data);}, function(){alert('F');});
 * 
 * Để gọi hàm ký dữ liệu sử dụng định dạng base64
 * RTVNSignClient.create64("xml", "PGNvbXBhbnk+cmV2b3RlY2g8L2NvbXBhbnk+", function(data){console.log(data);}, function(){alert('F');});
 */
var rtvnUrl = "http://localhost:12001/sign";
var rtvnPing = rtvnUrl + "/Ping";
var rtvnSign = rtvnUrl + "/Create";
var rtvn64Sign = rtvnUrl + "/Create64";
var RTVNSignClient = {

    // Khởi tạo đối tượng request
    getRequest: function () {
        var requestReq;
        try {
            requestReq = new XMLHttpRequest();
        } catch (ex) {
            requestReq = new window.ActiveXObject("Microsoft.request");
        }
        return requestReq;
    },

    // Kiểm tra service có hoạt động hay không
    // onsuccess : callback nếu gọi thành công
    // onerror : callback nếu gọi không thành công
    ping: function (/* fn */ onsuccess, /* fn */ onerror) {
        var request = this.getRequest();
        request.open("GET", rtvnPing);
        request.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
        request.onreadystatechange = function () {
            if (request.readyState === 4) {
                if (request.status === 200) {
                    if (onsuccess) {
                        var response = request.responseText;
                        onsuccess(response);
                    }
                } else {
                    if (onerror) {
                        onerror();
                    }
                }
            }
        }
        request.send(JSON.stringify({}));
    },

    // Ký số truyền vào url
    // @param onsuccess : callback nếu gọi thành công
    // @param onerror : callback nếu gọi không thành công
    // @param extension : loại ký số muốn áp dụng, nhận các giá trị: xml, pdf
    // @param fileUrl : đường dẫn tải tệp để ký số
    // @param uploadUrl : đường dẫn để upload tệp sau khi service đã ký số
    create : function (/*string*/ extension, /* string */ fileUrl,  /* string */uploadUrl, /* fn */ onsuccess, /* fn */ onerror) {
        var request = this.getRequest();
        request.open("POST", rtvnSign);
        request.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
        request.onreadystatechange = function () {
            if (request.readyState === 4) {
                if (request.status === 200) {
                    if (onsuccess) {
                        var response = request.responseText ? JSON.parse(request.responseText) : null;
                        onsuccess(response);
                    }
                } else {
                    if (onerror) {
                        onerror();
                    }
                }
            }
        }
        request.send(JSON.stringify({ "extension": extension, "fileUrl": fileUrl, "uploadUrl": uploadUrl }));
    },

    // Ký số truyền vào url
    // @param onsuccess : callback nếu gọi thành công
    // @param onerror : callback nếu gọi không thành công
    // @param extension : loại ký số muốn áp dụng, nhận các giá trị: xml, pdf
    // @param fileData : nội dung cần ký số (đã mã hóa base64)
    create64: function (/*string*/ extension, /* string */ fileData, /* fn */ onsuccess, /* fn */ onerror) {
        var request = this.getRequest();
        request.open("POST", rtvn64Sign);
        request.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
        request.onreadystatechange = function () {
            if (request.readyState === 4) {
                if (request.status === 200) {
                    if (onsuccess) {
                        var response = request.responseText ? JSON.parse(request.responseText) : null;
                        onsuccess(response);
                    }
                } else {
                    if (onerror) {
                        onerror();
                    }
                }
            }
        }
        request.send(JSON.stringify({ "extension": extension, "fileData": fileData}));
    }
}