//setInterval (pt, 1000);
//
//function pt(){
//var trurl ="/minutes";
//console.log("hello world");
//$.getJSON(trurl, function(result){
//       $("#demo").val("Hello world!");
//});
//}




$("#start-btn").click(
function() {
var url ="/start";
  alert( "Handler for .start() called." );
  $.getJSON(url);
});

$("#stop-btn").click(
function() {
var url ="/stop";
  alert( "Handler for .stop() called." );
  $.getJSON(url);
  $("#stop-btn").attr('disabled','disabled');
});


$("#start-btn").click(changeText);


function changeText(){
setInterval(innerfunc,1000);
function innerfunc(){
var trurl ="/minutes";
  $.get(trurl, function(data, status){
  if(data)$("#demo").text(data);
  });
}
}

