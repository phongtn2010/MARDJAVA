function  numberToText(value) {
    var text = '';
    var soTy = 1000000000;
    var soTrieu = 1000000;
    var soNghin = 1000;
    if (value > 999999) {
        //hang ty
        var nTy = parseInt(value / soTy);
        if (nTy > 0) {
            text += docNghin(nTy) + 'tỷ, ';
        }

        var nTrieu = parseInt((value % soTy) / soTrieu);
        if (nTrieu > 0) {
            text += docNghin(nTrieu) + 'triệu, ';
        }


        var nNghin = parseInt(((value % soTy) % soTrieu) / soNghin);

        if (nNghin < 100 && nNghin > 0) {
            text += 'không trăm ';
        }
        if (nNghin < 10 && nNghin) {
            text += 'linh ';
        }
        if (nNghin > 0) {
            text += docNghin(nNghin) + 'nghìn, ';
        }


        var nTram = parseInt(((value % soTy) % soTrieu) % soNghin);
        if (nTram < 100 && nTram > 0) {
            text += 'không trăm ';
        }
        if (nTram > 0) {
            text += docNghin(nTram);
        }

    } else {
        text = docNghin(value);
    }
    text = text.trim();
    if (text.endsWith(',')) {
        text = text.substring(0, text.length - 1);
    }
    return text;
}


function docNghin(number) {
    var soNghin = 1000;
    var soTram = 100;
    var soChuc = 10;
    var text = '';
    var nNghin = parseInt(number / soNghin);
    if (nNghin > 0) {

        var duNghin = nNghin % 10;
        if (nNghin > 100)  duNghin = nNghin % 100;
        if (duNghin > 0) {
            var soChan = nNghin - duNghin;
            if (soChan > 0) {
                text += getNumberName(soChan);
            }
            if (duNghin > 10) {
                var du = parseInt(duNghin % 10);
                text += getNumberName(duNghin - du);
                if (du > 0)
                    text += getNumberName(du);
                text += 'nghìn, ';
            } else {
                text +=  getNumberName(duNghin) + 'nghìn, ';
            }

        } else {
            text += getNumberName(nNghin) + 'nghìn, ';
        }
    }
    var nTram = parseInt((number % soNghin) / soTram);
    if (nTram > 0) {
        text += getNumberName(nTram) + 'trăm ';
    } else if (nNghin > 0) {
        text += getNumberName(nTram) + 'trăm '
    }
    var nChuc = parseInt(((number % soNghin) % soTram) / soChuc);
    var nDonVi = parseInt((((number % soNghin) % soTram) % soChuc));
    if (nChuc > 0) {
        if (nChuc == 1) {
            text += getNumberName(10);
        } else {
            text += getNumberName(nChuc) + 'mươi ';
        }
    } else if (nDonVi > 0 && number > 10) {
        text += getNumberName(-1);
    }

    if (nDonVi > 0) text += getNumberName(nDonVi);
    return text;
}

function getNumberName(number) {
    if (number == 1) return 'một ';
    if (number == 2) return 'hai ';
    if (number == 3) return 'ba ';
    if (number == 4) return 'bốn ';
    if (number == 5) return 'năm ';
    if (number == 6) return 'sáu ';
    if (number == 7) return 'bảy ';
    if (number == 8) return 'tám ';
    if (number == 9) return 'chín ';
    if (number == 10) return 'mười ';
    if (number == 20) return 'hai mươi ';
    if (number == 30) return 'ba mươi ';
    if (number == 40) return 'bốn mươi ';
    if (number == 50) return 'năm mươi ';
    if (number == 60) return 'sáu mươi ';
    if (number == 70) return 'bảy mươi ';
    if (number == 80) return 'tám mươi ';
    if (number == 90) return 'chín mươi ';
    if (number == 100) return 'một trăm ';
    if (number == 200) return 'hai trăm ';
    if (number == 300) return 'ba trăm ';
    if (number == 400) return 'bốn trăm ';
    if (number == 500) return 'năm trăm ';
    if (number == 600) return 'sáu trăm ';
    if (number == 700) return 'bảy trăm ';
    if (number == 800) return 'tám trăm ';
    if (number == 900) return 'chín trăm ';
    if (number == -2) return 'mươi ';
    if (number == -1) return 'linh ';
    if (number == 0) return 'không ';
    return "không ";
}