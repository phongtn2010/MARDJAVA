function uploadTo(files, completed, error) {

    var thoiGian = '';
    var d = new Date();
    thoiGian += d.getDate();
    thoiGian +=  "/" + formatNumber(d.getMonth() + 1, 2);
    thoiGian += "/" + d.getFullYear();
    thoiGian += " " + formatNumber(d.getHours(), 2) + ":" + formatNumber(d.getMinutes(), 2);
    var formData = new FormData();

    for (var k = 0; k < files.length; k++) {
        if (isDevTest) {
            console.log(files[k]);
        }

        formData.append('file[]', files[k]);
    }

    formData.append('thoiGian', thoiGian);
    formData.append('token', md5(thoiGian + "nqanhVnpt@123"));

    if (isDevTest) {
        console.log(uploadUsername + "@" + uploadPassword);
        console.log(urlUpload);
        console.log(urlDownload);
        console.log(formData.get("thoiGian"));
        console.log(thoiGian + "nqanhVnpt@123");
        console.log(formData.get("token"));
        console.log(formData.get("file[]"));
    }


    $.ajax({
        url : urlUpload,
        type : 'POST',
        data : formData,
        processData: false,  // tell jQuery not to process the data
        contentType: false,  // tell jQuery not to set contentType
        success : function(data) {
            if (isDevTest) {
                console.log(data);
            }

            if (data.message != 0) {
                if (error) error();
                showToast(data.message, false);
            } else {
                if (completed) {
                    completed(data);
                }
            }

        },
        error: function (e) {
            if (isDevTest) {
                console.log("UPLOAD ERROR:");
                console.log(e);
            }
            if (error) {
                error();
            }
        }
    });
}

function formatNumber(value, size) {
    var s = value + "";
    var frist = '';
    while (s.length < size) {
        frist += "0";
        s += "0";
    }
    return frist + value;
}
