/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


ko.bindingHandlers.chosen =
{
    init: function (element)
    {
        $(element).addClass('chzn-select');
        $(element).chosen({allow_single_deselect: true});
    }
};