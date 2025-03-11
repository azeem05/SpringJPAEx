# Spring Boot application demo using JPA

$ This repo demonstrates on how to use JPA for backend connectivity and access/update the data from the Controller

1. Add the data

   URL: {{base_url}}/jpaex/addData

   Input:
   
    {
   
       "firstName": "fname",

       "lastName" : "Test"
   
    }
2. Get all the data
    
    URL: {{base_url}}/jpaex/listAll

3. Get the data using the Id
   
    URL: {{base_url}}/jpaex/find/<<id>>