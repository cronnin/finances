/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function _post(objForm) {
    $.ajax({
        type: "POST",
        url: objForm.attr('action'),
        data: objForm.serialize()
    }).done(function (msg) {
        alert("Data Saved: " + msg);
    }).fail(function( jqXHR, textStatus ) {
        alert( "Request failed: " + textStatus );
    });
}