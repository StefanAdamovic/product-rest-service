Product REST Service
The service is accessible at http://localhost:8888/api.predic8.de. The RESTful endpoints under this base URL are as follows:

Endpoints
Create Product

Method: POST
Path: /shop/v2/products
Summary: Create a new product
Status: 201 Created
Get All Products

Method: GET
Path: /shop/v2/products
Summary: Retrieve all products
Status: 200 OK
Get Product by ID

Method: GET
Path: /shop/v2/products/{id}
Summary: Retrieve a product by its ID
Status: 200 OK
Update Product by ID

Method: PUT
Path: /shop/v2/products/{id}
Summary: Update a product by its ID
Status: 200 OK
Delete Product by ID

Method: DELETE
Path: /shop/v2/products/{id}
Summary: Delete a product by its ID
Status: 200 OK
Swagger Integration
Swagger UI is available at http://localhost:8888/api.predic8.de/swagger-ui.html, providing interactive API documentation.

Technology Stack
Spring Boot: Framework for creating stand-alone, production-grade Spring-based applications.
MySQL: Relational database used for storing product data.
Spring Data JPA: Provides repository support for the Java Persistence API (JPA).
Spring Boot Starter Validation: Starter for using Java Bean Validation with Spring Boot.
Spring Boot Starter Web: Starter for building web, including RESTful, applications using Spring MVC.
Lombok: Library to reduce boilerplate code in Java.
Spring Boot Test Starter: Starter for testing Spring Boot applications with libraries including JUnit, Hamcrest, and Mockito.
Springdoc OpenAPI Starter: Starter for generating OpenAPI 3 documentation automatically from Spring Boot applications.
Tomcat Embed Jasper: Embeddable Apache Tomcat JSP engine.
Jakarta Servlet JSP JSTL: Standard JSP Tag Library API specification.
Spring Boot Docker Compose: Plugin for building Docker images and running Docker Compose from a Spring Boot application.
Liquibase Core: Database schema evolution library for Java.
