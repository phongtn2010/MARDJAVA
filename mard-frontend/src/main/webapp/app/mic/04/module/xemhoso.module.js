function HoSoViewModel() {
  var self = this;
  // ket qua xu ly

  self.show = function(item) {
    callApi('/mic/api/04/edit/' + item.fiIdHoSo(), null, function (d) {
      var callback = function (html) {
        var pop = app.popup({
          title: '',
          html: html,
          width: 1200,
          buttons: [
            {
              name: NSWLang["common_button_dong"],
              class: 'btn',
              icon: 'fa-remove',
              action: function () {
                app.popupRemove(pop.selector);
              }
            }
          ]
        }, function () {
          var p = new HoSoPopupViewModel(d.data);
          ko.applyBindings(p, document.getElementById("popupView"));
        });
      };

      app.complieTemplate({
        ministryCode: complieTemplateMinistryCode,
        code: complieTemplateCode,
        templateName: "xemthongtinhoso",
        data: d
      }, callback);
    })

  }
}

function HoSoPopupViewModel(data) {

  data.hoSo.fiCreateDate = moment(data.hoSo.fiCreateDate).utc().format('DD/MM/YYYY');
  var self = this;
  self.formData = data;

  self.tongSoBan = function (arr) {
    var sum = 0;
    arr.forEach(function (value) {
      sum += value.fiSoBan;
    });
    return sum;
  }
  self.titles = ko.observableArray([]);
  self.dataTable = ko.observableArray([]);
  self.totalElements = ko.observable(0);
  self.currentPage = ko.observable(1);
  self.pageSize = ko.observable(10);

  self.titles.push({key: '', value: i18nextko.t('TbdThietBi03.fiId')});
  self.titles.push({key: 'fiMaISBN', value: i18nextko.t('TbdThietBi03.fiMaISBN')});
  self.titles.push({key: 'fiTenGoc', value: i18nextko.t('TbdThietBi03.fiTenGoc')});
  self.titles.push({key: 'fiTenTiengViet', value: i18nextko.t('TbdThietBi03.fiTenTiengViet')});
  self.titles.push({key: 'fiTenTacGia', value: i18nextko.t('TbdThietBi03.fiTenTacGia')});
  self.titles.push({key: 'fiTenNhaCC', value: i18nextko.t('TbdThietBi03.fiTenNhaCC')});
  self.titles.push({key: 'fiTheLoai', value: i18nextko.t('TbdThietBi03.fiTheLoai')});
  self.titles.push({key: 'fiSoBan', value: i18nextko.t('TbdThietBi03.fiSoBan'), align: 'right'});
  self.titles.push({key: 'fiTomTat', value: i18nextko.t('TbdThietBi03.fiTomTat')});
  self.titles.push({key: 'fiSoLuongDia', value: i18nextko.t('TbdThietBi03.fiSoLuongDia'), align: 'right'});
  self.titles.push({key: 'fiSoLuongBang', value: i18nextko.t('TbdThietBi03.fiSoLuongBang') , align: 'right'});
  self.titles.push({key: 'fiSoLuongCatset', value: i18nextko.t('TbdThietBi03.fiSoLuongCatset'), align: 'right'});

  self.pageClick = function (page) {

  }

  self.loadTbdThietBi03 = function() {
    self.totalElements(0);
    self.dataTable.removeAll();

    if (data.hoSo.tbdNguoiThamDinh04DTOS) {
      data.hoSo.tbdNguoiThamDinh04DTOS.forEach(function (value, index) {
        self.dataTable.push(value);
      });
      self.totalElements(data.hoSo.tbdNguoiThamDinh04DTOS.length);
    }

  }

  self.loadTbdThietBi03();
}

