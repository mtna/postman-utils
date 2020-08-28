# Newman Example Generator

## Overview

The usefullness of a Postman collection can be greatly increased by adding saved example responses with each request. When publishing the collection, users will be able to reference the saved request to see the data structure they will be dealing with when they use that request. 

When creating small collections it is simple enough to accomplish this through the Postman UI, saving a response after a request is run. However, this can be tedious and time consuming on any collection with more than a few requests. If a collection has been built up over time without saving responses, imported from another source without saved responses, or is being created programmatically it would be convenient to have some way to expedite the process. 

This is the goal of the newman-example-generator. It will take a Postman collection JSON file, run all the requests, and save the responses to the appropriate request. The example generator uses the request ID to line up the response with the appropriate request. 

## Usage

Currently this utility can be pulled an run locally, after review and sorting out any bugs that may be present it will be added to NPM. 

To use the generator:

- clone this the newman-example-generator
- Install newman in your local newman-example-generator directory, `npm install newman` 
- Run the generator on your Postman collection JSON file, `node example-generatory.js <mycollection>.json`
- This will generate the file `<mycollection>-examples.json`
- The generated file can be used to publish the collection for the first time or to update an already published collection through the Postman API. 
