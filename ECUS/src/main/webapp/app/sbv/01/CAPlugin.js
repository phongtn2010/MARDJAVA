/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
var CAPlugin = {
    token: "",
    cert: "",
    initPlugin: function () {
        var url = "http://localhost:8888/GetToken";
        this.token = sd.connector.get(url);
        if (this.token == null || this.token == "") {
            var rs = confirm("Chưa chạy plugin hoặc chưa cài đặt plugin tại máy người dùng, bạn có muốn tải plugin về không");
            if (rs) {
                if (navigator.userAgent.indexOf("WOW64") != -1 ||
                        navigator.userAgent.indexOf("Win64") != -1) {
                    window.open('share/js/ca/setup.exe');
                } else {
                    window.open('share/js/ca/setup_32bit.exe');
                }
            }
            return false;
        } else {
            return true;
        }
    },
    getCert: function () {
        var url = "http://localhost:8888/GetCert";
        var param = {token: this.token};
        this.cert = sd.connector.get(url, param);
        return this.cert;
    },
    signHash: function (base64Hash, serialNumber) {
        var url = "http://localhost:8888/SignHash";
        var param = {token: this.token, data: base64Hash, serialNumber: serialNumber};
        this.cert = sd.connector.get(url, param);
        return this.cert;
    },
    signXml: function (xml, serialNumber) {
        var url = "http://localhost:8888/SignXml";
        var param = {token: this.token, data: xml, serialNumber: serialNumber};
        this.cert = sd.connector.get(url, param);
        return this.cert;
    },
    encrypt: function (data) {
        var url = "http://localhost:8888/Encrypt";
        var param = {token: this.token, data: data};
        this.cert = sd.connector.get(url, param);
        return this.cert;

    },
    decrypt: function (data) {
        var url = "http://localhost:8888/Decrypt";
        var param = {token: this.token, data: data};
        this.cert = sd.connector.get(url, param);
        return this.cert;
    }
};












/**
 * 
 * @param {type} base64Hash
 * @param {type} certSerial
 * @returns {@exp;@call;plugin@call;signHash}
 */



