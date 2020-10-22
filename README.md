# Postman Utilities

This repository is a collection of [Postman](https://www.postman.com/) utilities. These are designed with the goal of simplifying the creation of robust and well documented Postman collections. The following utilities are available as a part of this repository, each of their respective folders should contain detailed information about how and when to use them:

- [newman-example-generator][newman-example-generator]: Written in Node.JS, this utility takes advantage of Postman's [Newman Package](https://www.npmjs.com/package/newman) to run a collection and save the responses of all the requests as example responses.
- [postman-model][postman-model]: This directory contains libraries implementations of the [Postman collection schema](https://schema.getpostman.com/collection/json/v2.1.0/draft-07/collection.json) in different languages. This allows the Postman collection schema to be built up programmatically. 

[newman-example-generator]: ./newman-example-generator
[postman-model]: ./postman-model
