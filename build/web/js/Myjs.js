/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function(){
    $("#login").click(function(){
        
        $("#row2").hide();
        $("#row1").show();
    });
     $("#register").click(function(){
        $("#row1").hide();
        $("#row2").show();
    });
    $("#hotel").click(function(){
        $("#courseAdd").slideDown();
        $("#hotelRoom").slideUp();
        $("#book").slideUp();
         $("#reservation").hide();
    });
     $("#rooms").click(function(){
         $("#courseAdd").slideUp();
        $("#hotelRoom").slideDown(); 
         $("#book").slideUp();
          $("#reservation").hide();
    });
     $("#booking").click(function(){
         $("#courseAdd").hide();
           $("#book").slideDown();
         $("#hotelRoom").hide();  
          $("#reservation").hide();
    });
    $("#reservations").click(function(){
          $("#courseAdd").hide();
           $("#book").hide();
         $("#hotelRoom").hide();  
         $("#reservation").slideDown();
    })
});