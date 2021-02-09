# Docu-Mentor

Docu-Mentor is a REST API written in Java with Spring. It is designed to provide utilities to enhance and increase the value of Postman documentation. Currently it has one main function, which is to evaluate a provided Postman Collection and use the JSON request and response bodies to build model requests in the collection. These requests will provide and example response of the object along with a description that can be used to link to the requests the model is used in, describe the model properties, and link to any related models that the model uses. 

This project can be packaged into a WAR file through the maven package goal, and deployed as needed. 

This project was written for the Postman 2021 Hackathon, and as such the code is not 100% documented or formatted as well as it could be. Please be patient as this will be enhanced over time.
