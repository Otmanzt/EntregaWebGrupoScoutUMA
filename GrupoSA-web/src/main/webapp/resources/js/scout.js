/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function enlaceActivo() {
    url = $(location).attr('pathname');
    indice = url.lastIndexOf("/");
    cadena = url.substring(indice + 1, url.length - 6);
    $("#" + cadena).toggleClass("active");
}

function lateralActivo() {
    url = $(location).attr('pathname');
    indice = url.lastIndexOf("/");
    cadena = url.substring(indice + 1, url.length - 6);
    
    $("#lateral" + cadena).toggleClass("active");
}
function editarComentarioEvt(){
        $( ".btn_editarCom" ).click(function(evt) {
          evt.preventDefault();
          cadena = $(this).attr("id");
          cadena = cadena.substr(9,cadena.length);
          $( "#idComentario"+cadena ).addClass("d-none");
          $("#formEditCom"+cadena+"\\:guardarComentario"+cadena).removeClass("d-none");
          $("#formEditCom"+cadena+"\\:idComentarioTexto"+cadena).removeClass("d-none");
        });
}

$(document).ready(function () {
    // Handler for .ready() called.
    enlaceActivo();
    lateralActivo();
    editarComentarioEvt();

});
