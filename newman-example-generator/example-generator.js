//npm install newman
const newman = require("newman"),
  fs = require("fs");

var args = process.argv.slice(2);
var responses = {};

newman
  .run(
    {
      collection: args[0],
    },
    function (err, run) {
      var collection = run.collection;
      var items = getItems(collection.items.members);
      items.forEach((element) => {
        if (element.id in responses) {
          console.log(`Adding response for [${element.id}]`);
          var response = responses[element.id];
          element.responses.members = [response];
        }
      });

      var fileName = args[0].substring(0, args[0].lastIndexOf('.'));
      fileName += "-examples.json";

      fs.writeFile(
        fileName,
        JSON.stringify(collection),
        function (error) {
          if (error) {
            console.error(error);
          }
        }
      );
    }
  )
  .on("request", function (error, data) {
    if (error) {
      console.error(error);
    } else {
      console.log(`Running request [${data.item.name}]`)
      var originalRequest = {};
      originalRequest["method"] = data.request.method;
      (originalRequest["header"] = []),
        (originalRequest["url"] = data.item.request.url);

      var response = {};
      response["originalRequest"] = originalRequest;
      response["name"] = data.item.name;
      response["status"] = data.response.status;
      response["code"] = data.response.code;
      response["_postman_previewlanguage"] = "json";
      response["header"] = [];
      response["cookie"] = [];
      response["body"] = data.response.stream.toString();

      responses[data.item.id] = response;
    }
  });

function getItems(items) {
  var finalItems = [];

  items.forEach((element) => {
    if (element.items !== undefined) {
      getItems(element.items.members).forEach((subElement) => {
        finalItems.push(subElement);
      });
    } else {
      finalItems.push(element);
    }
  });

  return finalItems;
}
