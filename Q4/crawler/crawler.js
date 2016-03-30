var request = require('request');
var cheerio = require('cheerio');
var URL = require('url-parse');

var pagina = "http://www.submarino.com.br/";
console.log("Visitando a página " + pagina);
request(pagina, function(error, response, body) {
   if(error) {
     console.log("Erro: " + error);
   }
   console.log("Status: " + response.statusCode);
   if(response.statusCode === 200) {

     var $ = cheerio.load(body);
     console.log("Título da página:  " + $('title').text()+"teste");
     //console.log($('.product-price-integer').text());
     //console.log("Títula da página:  " + $('div class='+'price-area').text());
   }
});

function procurarPalavra($, word) {
  var bodyText = $('html > body').text();
  if(bodyText.toLowerCase().indexOf(word.toLowerCase()) !== -1) {
    return true;
  }
  return false;
}
