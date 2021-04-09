# Icommerce
The project creates a very simple online shopping application to sell the products. The application is designed based on 
Model-View-Controller(MVC) architectural pattern. Clients access and manipulate product, order information in a data repository which is stored
on the server. At the front-end side, the client application is split into model and view components where model corresponds to the
bussiness logic: searching and ordering products and a web page representing the list of products and orders. At the back-end, 
the application server contains the server side model and data repository which contains database for products and orders.
The front-end and back-end communicate with each other via REST APIs.    

## Techonologies
Project is created with:
* Back-end: Java Spring Boot with JPA and H2 database at persistence layer.  
* Front-end: Angular Version 11.2.5 and NodeJS version 14.16.0    

## Code structures and design diagrams
* Back-end package diagram is located at resources/solution/package_diagram.png.  
![alt text](./resources/solution/package_diagram.png?raw=true)
* Front-end class diagram is located at resources/solution/front_end.png.  
![alt text](./resources/solution/front_end.png?raw=true)
* Database Entity Relationship Diagram is located at resources/db/icommerce.png.  
![alt text](./resources/db/icommerce.png?raw=true)
 
## Installation 
1. Back-end application: you can use your favorite IDE (IntelliJ/Eclipse) to run application IcommerceApplication.
Or, you can use Maven to build and run the application from project home directory.  
    `mvn install`  
    `mvn spring-boot:run`
      
2. Front-end application: First, you need to install the latest version of npm, Angular and Node.js. Then, go to front-end 
home directory and run application with following commands:   
    `cd front-end`  
    `npm update`  
    `npm start`   
    Then you can access the web page at http://localhost:4200/  

## API Verification
Please execute the following CURL commands to verify APIs
* Products  
`curl -v http://localhost:8080/api/products`  
* Orders  
`curl -v http://localhost:8080/api/orders`
