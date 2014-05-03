// like import statements for node
// using express js here
var express = require('express')
  , app = express()
  , server = app.listen(80)
  , io = require('socket.io').listen(server)
  , fs = require('fs')

var footData = [];

app.get('/sendFootData', function(req, res) {
  res.writeHead(200);
  var data = {
    "val1":  req.query.val1,
    "val2":  req.query.val2,
    "val3":  req.query.val3,
    "val4":  req.query.val4,
    "val5":  req.query.val5,
    "val6":  req.query.val6,
    "val7":  req.query.val7
  };
  footData.push(data);

  io.sockets.emit('update', data);
  res.end("OK");
});

app.get('/stats', function(req, res) {
  res.writeHead(200);
  res.end(JSON.stringify(footData));
});


io.sockets.on('connection', function (socket) {
});