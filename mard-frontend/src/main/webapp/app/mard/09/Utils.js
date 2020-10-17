

function convertDDMMYYYYToDate(dateString) {
    var dateParts = dateString.split("/");
    return new Date(+dateParts[2], dateParts[1] - 1, +dateParts[0]);
}