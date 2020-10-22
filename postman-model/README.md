# Postman Model

This directory is designed to house various implementations of the [Postman collection schema](https://schema.getpostman.com/collection/json/v2.1.0/draft-07/collection.json). Each implementation should be a subdirectory named with the language the implementation is written in. 

## Implementations

- The Java implementation was written by Andrew DeCarlo (andrew.decarlo@mtna.us) of [MTNA](https://mtna.us/) and uses the [jsonschema2pojo](https://github.com/joelittlejohn/jsonschema2pojo) maven plugin to generate the POJO's from the Postman Collection Schema. Where the schema specifies that a property can be `oneOf` a complete object or a string, handwritten interfaces are used to overcome this obstacle. An empty interface is defined with two implementations, the full object and the string. Custom (de)serializers are then used to read and write these objects with Jackson. All of the (de)serializers are registered in the `PostmanModule` which can be used manually with and `ObjectMapper` or through the use of `ObjectMapper.findAndRegisterModules()`.