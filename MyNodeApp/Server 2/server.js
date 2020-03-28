var express = require('express');
var app = express();
var fs = require("fs");

var bodyParser = require('body-parser')
app.use(bodyParser.json()); 
app.use(bodyParser.urlencoded({
    extended: true
}));


// A promo message to user 
var message = "Black Friday! Get 50% cachback on saving your first spot.";

app.get('/messages', function (req, res) {
    res.end(JSON.stringify(message));
})

// Home Page 
app.get('/', (req, res) => res.send('Welcome! You are all set to go!'))

// Configure server 
var server = app.listen(8000, '192.168.43.222', function (req, res) {

    var host = server.address().address
    var port = server.address().port

    console.log(`Server running at http://${host}:${port}/`);
})

